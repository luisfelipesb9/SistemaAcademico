package br.unimontes.ccet.dcc.pg1.controller;

import br.unimontes.ccet.dcc.pg1.model.service.MatriculaService;
import br.unimontes.ccet.dcc.pg1.model.service.AlunoService;
import br.unimontes.ccet.dcc.pg1.model.service.CursoService;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Aluno;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Curso;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Matricula;
import br.unimontes.ccet.dcc.pg1.model.dao.exception.DAOException;
import br.unimontes.ccet.dcc.pg1.view.interfaces.IMatriculaController;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

/**
 * Controller para operações de Matrícula.
 * Usa Services para lógica de negócio (não acessa DAOs diretamente).
 * Implementa IMatriculaController para garantir contrato com as Views.
 */
public class MatriculaController implements IMatriculaController {

    private MatriculaService matriculaService;
    private AlunoService alunoService;
    private CursoService cursoService;

    public MatriculaController() {
        try {
            matriculaService = new MatriculaService();
            alunoService = new AlunoService();
            cursoService = new CursoService();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Matricula> listarTodas() {
        try {
            if (matriculaService == null)
                return new ArrayList<>();
            return matriculaService.listarTodos();
        } catch (DAOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public Matricula buscarPorId(int id) {
        try {
            if (matriculaService == null)
                return null;
            return matriculaService.buscarPorId(id);
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean salvar(Matricula matricula) {
        try {
            if (matriculaService == null)
                return false;
            return matriculaService.salvarMatricula(matricula);
        } catch (DAOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Response excluir(int id) {
        return excluirPorAluno(id);
    }

    /**
     * Exclui a matrícula e o aluno associado.
     * Regra de negócio: aluno só existe com matrícula ativa.
     */
    @Override
    public Response excluirPorAluno(int idAluno) {
        try {
            if (matriculaService == null || alunoService == null)
                return Response.erro("Serviço não disponível.");

            // Primeiro exclui a matrícula via service
            boolean matriculaExcluida = matriculaService.excluir(idAluno);

            // Depois exclui o aluno
            if (matriculaExcluida) {
                alunoService.excluir(idAluno);
                return Response.sucesso("Matrícula e aluno excluídos com sucesso!");
            } else {
                return Response.erro("Erro ao excluir matrícula.");
            }
        } catch (DAOException e) {
            return Response.erro("Erro: " + e.getMessage());
        }
    }

    @Override
    public int count() {
        try {
            if (matriculaService == null)
                return 0;
            return matriculaService.count();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * Lista todas as matrículas com dados formatados para a tabela.
     * Usa Services para buscar dados (não acessa DAOs).
     */
    @Override
    public List<Object[]> listarMatriculasParaTabela(String termoPesquisa) {
        List<Object[]> resultado = new ArrayList<>();
        try {
            if (matriculaService == null)
                return resultado;

            List<Matricula> matriculas = matriculaService.listarTodos();

            for (Matricula m : matriculas) {
                String nomeAluno = "N/A";
                String nomeCurso = "N/A";
                try {
                    Aluno a = alunoService.buscarPorId(m.getIdAluno());
                    if (a != null) {
                        nomeAluno = a.getNome();
                        Curso c = cursoService.buscarPorId(m.getIdCurso());
                        if (c != null) {
                            nomeCurso = c.getNome();
                        }
                    }
                } catch (Exception ex) {
                    // Ignora erro
                }

                // Filtro de pesquisa
                if (termoPesquisa != null && !termoPesquisa.isBlank()) {
                    String termo = termoPesquisa.toLowerCase();
                    boolean matches = nomeAluno.toLowerCase().contains(termo) ||
                            String.valueOf(m.getIdAluno()).contains(termo) ||
                            nomeCurso.toLowerCase().contains(termo);
                    if (!matches) {
                        continue;
                    }
                }

                resultado.add(new Object[] { m.getIdAluno(), nomeAluno, nomeCurso });
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return resultado;
    }
}
