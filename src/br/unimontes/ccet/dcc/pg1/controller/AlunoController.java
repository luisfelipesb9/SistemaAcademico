package br.unimontes.ccet.dcc.pg1.controller;

import br.unimontes.ccet.dcc.pg1.model.service.AlunoService;
import br.unimontes.ccet.dcc.pg1.model.service.CursoService;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Aluno;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Curso;
import br.unimontes.ccet.dcc.pg1.model.dao.exception.DAOException;
import br.unimontes.ccet.dcc.pg1.view.interfaces.IAlunoController;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

/**
 * Controller para operações de Aluno.
 * Implementa IAlunoController para garantir contrato com as Views.
 */
public class AlunoController implements IAlunoController {

    private AlunoService alunoService;
    private CursoService cursoService;

    public AlunoController() {
        try {
            alunoService = new AlunoService();
            cursoService = new CursoService();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Aluno> listarTodos() {
        try {
            if (alunoService == null)
                return new ArrayList<>();
            return alunoService.listarTodos();
        } catch (DAOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public Aluno buscarPorId(int id) {
        try {
            if (alunoService == null)
                return null;
            return alunoService.buscarPorId(id);
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Response salvar(Aluno aluno) {
        try {
            if (alunoService == null)
                return Response.erro("Serviço não disponível.");

            boolean sucesso = alunoService.salvarAluno(aluno);
            if (sucesso) {
                String msg = aluno.getId() > 0 ? "Aluno editado com sucesso!" : "Aluno salvo com sucesso!";
                return Response.sucesso(msg);
            } else {
                return Response.erro("Erro ao salvar aluno.");
            }
        } catch (DAOException e) {
            return Response.erro("Erro: " + e.getMessage());
        }
    }

    @Override
    public Response excluir(int id) {
        try {
            if (alunoService == null)
                return Response.erro("Serviço não disponível.");

            boolean sucesso = alunoService.excluir(id);
            if (sucesso) {
                return Response.sucesso("Aluno excluído com sucesso!");
            } else {
                return Response.erro("Erro ao excluir aluno. Verifique se existem matrículas associadas.");
            }
        } catch (DAOException e) {
            return Response.erro("Erro: " + e.getMessage());
        }
    }

    @Override
    public int count() {
        try {
            if (alunoService == null)
                return 0;
            return alunoService.count();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Object[]> listarAlunosParaTabela(String termoPesquisa) {
        List<Object[]> resultado = new ArrayList<>();
        try {
            if (alunoService == null || cursoService == null)
                return resultado;

            List<Aluno> alunos = alunoService.listarTodos();
            List<Curso> cursos = cursoService.listarTodos();

            for (Aluno a : alunos) {
                if (termoPesquisa != null && !termoPesquisa.isBlank()) {
                    String termo = termoPesquisa.toLowerCase();
                    boolean matches = a.getNome().toLowerCase().contains(termo) ||
                            String.valueOf(a.getId()).contains(termo);
                    if (!matches) {
                        continue;
                    }
                }

                String nomeCurso = "N/A";
                for (Curso c : cursos) {
                    if (c.getId() == a.getIdCurso()) {
                        nomeCurso = c.getNome();
                        break;
                    }
                }

                resultado.add(new Object[] { a.getId(), a.getNome(), nomeCurso });
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public List<Curso> listarCursosParaCombo() {
        try {
            if (cursoService == null)
                return new ArrayList<>();
            return cursoService.listarTodos();
        } catch (DAOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public int getIndiceCursoParaAluno(Aluno aluno, List<Curso> cursos) {
        for (int i = 0; i < cursos.size(); i++) {
            if (cursos.get(i).getId() == aluno.getIdCurso()) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Valida dados do aluno antes de salvar.
     * Validações movidas da View para o Controller.
     */
    @Override
    public Response validarAluno(String nome, String cpf, String anoNascimento, Curso curso) {
        // Validar nome
        if (nome == null || nome.trim().isEmpty()) {
            return Response.erro("O nome é obrigatório.");
        }
        if (nome.matches(".*\\d.*")) {
            return Response.erro("O nome não pode conter números.");
        }

        // Validar CPF
        if (cpf == null || cpf.trim().isEmpty()) {
            return Response.erro("O CPF é obrigatório.");
        }

        // Validar ano de nascimento
        try {
            int ano = Integer.parseInt(anoNascimento);
            if (ano < 1900 || ano > 2024) {
                return Response.erro("Ano de nascimento inválido.");
            }
        } catch (NumberFormatException e) {
            return Response.erro("Ano de nascimento deve ser um número válido.");
        }

        // Validar curso
        if (curso == null) {
            return Response.erro("Selecione um curso.");
        }

        return Response.sucesso("Dados válidos.");
    }

    /**
     * Cria e salva um aluno.
     * View envia dados brutos, Controller cria a entidade e salva.
     * Move a criação de entidade da View para o Controller.
     */
    public Response criarESalvarAluno(String nome, String cpf, String anoNascimento, int cursoId, int idEdicao) {
        try {
            int ano = Integer.parseInt(anoNascimento);
            Aluno aluno;
            boolean isEdicao = idEdicao > 0;

            if (isEdicao) {
                aluno = new Aluno(idEdicao, cpf, nome, ano, cursoId);
            } else {
                aluno = new Aluno(cpf, nome, ano, cursoId);
            }

            if (alunoService == null)
                return Response.erro("Serviço não disponível.");

            boolean sucesso = alunoService.salvarAluno(aluno);
            if (sucesso) {
                String msg = isEdicao ? "Aluno editado com sucesso!" : "Aluno cadastrado com sucesso!";
                return Response.sucesso(msg);
            } else {
                return Response.erro("Erro ao salvar aluno.");
            }
        } catch (DAOException e) {
            return Response.erro("Erro: " + e.getMessage());
        }
    }
}
