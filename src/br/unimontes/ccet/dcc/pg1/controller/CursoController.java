package br.unimontes.ccet.dcc.pg1.controller;

import br.unimontes.ccet.dcc.pg1.model.service.CursoService;
import br.unimontes.ccet.dcc.pg1.model.dao.ProfessorDao;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Curso;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Professor;
import br.unimontes.ccet.dcc.pg1.model.dao.exception.DAOException;
import br.unimontes.ccet.dcc.pg1.view.interfaces.ICursoController;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

/**
 * Controller para operações de Curso.
 * Implementa ICursoController para garantir contrato com as Views.
 * Gerencia também operações de Professor/Coordenador.
 */
public class CursoController implements ICursoController {

    private CursoService service;
    private ProfessorDao professorDao;

    public CursoController() {
        try {
            service = new CursoService();
            professorDao = new ProfessorDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Curso> listarTodos() {
        try {
            if (service == null)
                return new ArrayList<>();
            return service.listarTodos();
        } catch (DAOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public Curso buscarPorId(int id) {
        try {
            if (service == null)
                return null;
            return service.buscarPorId(id);
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Response salvar(Curso curso) {
        try {
            if (service == null)
                return Response.erro("Serviço não disponível.");

            boolean sucesso = service.salvarCurso(curso);
            if (sucesso) {
                String msg = curso.getId() > 0 ? "Curso editado com sucesso!" : "Curso cadastrado com sucesso!";
                return Response.sucesso(msg, curso);
            } else {
                return Response.erro("Erro ao salvar curso.");
            }
        } catch (DAOException e) {
            return Response.erro("Erro: " + e.getMessage());
        }
    }

    @Override
    public Response excluir(int id) {
        try {
            if (service == null)
                return Response.erro("Serviço não disponível.");

            boolean sucesso = service.excluir(id);
            if (sucesso) {
                return Response.sucesso("Curso excluído com sucesso!");
            } else {
                return Response.erro("Erro ao excluir curso. Verifique se existem alunos ou matrículas associados.");
            }
        } catch (DAOException e) {
            return Response.erro("Erro: " + e.getMessage());
        }
    }

    @Override
    public int count() {
        try {
            if (service == null)
                return 0;
            return service.count();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Object[]> listarCursosParaTabela(String termoPesquisa) {
        List<Object[]> resultado = new ArrayList<>();
        try {
            if (service == null)
                return resultado;

            List<Curso> cursos = service.listarTodos();

            for (Curso c : cursos) {
                String nomeCoordenador = "Não definido";
                if (professorDao != null) {
                    try {
                        Professor coord = professorDao.buscarCoordenadorPorCurso(c.getId());
                        if (coord != null) {
                            nomeCoordenador = coord.getNomeFormatado();
                        }
                    } catch (Exception ex) {
                        // Ignora erro ao buscar coordenador
                    }
                }

                if (termoPesquisa != null && !termoPesquisa.isBlank()) {
                    String termo = termoPesquisa.toLowerCase();
                    boolean matches = c.getNome().toLowerCase().contains(termo) ||
                            String.valueOf(c.getId()).contains(termo) ||
                            nomeCoordenador.toLowerCase().contains(termo);
                    if (!matches) {
                        continue;
                    }
                }

                resultado.add(new Object[] { c.getId(), c.getNome(), c.getCreditos(), nomeCoordenador });
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public Professor buscarCoordenadorPorCurso(int idCurso) {
        if (professorDao == null)
            return null;
        try {
            return professorDao.buscarCoordenadorPorCurso(idCurso);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Response salvarCoordenador(Professor professor) {
        if (professorDao == null)
            return Response.erro("Serviço de Professor não disponível.");
        try {
            int result;
            if (professor.getId() > 0) {
                result = professorDao.update(professor);
            } else {
                result = professorDao.save(professor);
            }

            if (result > 0) {
                return Response.sucesso("Coordenador salvo com sucesso!");
            } else {
                return Response.erro("Erro ao salvar coordenador.");
            }
        } catch (DAOException e) {
            return Response.erro("Erro: " + e.getMessage());
        }
    }

    @Override
    public Response validarCurso(String nome, String creditos) {
        if (nome == null || nome.trim().isEmpty()) {
            return Response.erro("O nome do curso é obrigatório.");
        }

        try {
            int cred = Integer.parseInt(creditos);
            if (cred <= 0) {
                return Response.erro("Os créditos devem ser maior que zero.");
            }
        } catch (NumberFormatException e) {
            return Response.erro("Créditos devem ser um número válido.");
        }

        return Response.sucesso("Dados válidos.");
    }
}
