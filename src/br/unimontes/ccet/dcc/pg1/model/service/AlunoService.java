package br.unimontes.ccet.dcc.pg1.model.service;

import br.unimontes.ccet.dcc.pg1.model.dao.AlunoDao;
import br.unimontes.ccet.dcc.pg1.model.dao.MatriculaDao;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Aluno;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Matricula;
import br.unimontes.ccet.dcc.pg1.model.dao.exception.DAOException;
import java.sql.SQLException;

public class AlunoService {

    private AlunoDao alunoDao;
    private MatriculaDao matriculaDao;

    public AlunoService() throws SQLException {
        this.alunoDao = new AlunoDao();
        this.matriculaDao = new MatriculaDao();
    }

    public boolean salvarAluno(Aluno aluno) throws DAOException {
        if (aluno.getId() > 0) {
            // Edição: atualiza aluno E a matrícula (caso o curso tenha mudado)
            boolean alunoAtualizado = alunoDao.update(aluno) > 0;
            if (alunoAtualizado) {
                try {
                    // Atualiza a matrícula com o novo curso
                    Matricula m = new Matricula();
                    m.setIdAluno(aluno.getId());
                    m.setIdCurso(aluno.getIdCurso());
                    // Buscar a matrícula existente e atualizar
                    java.util.List<Matricula> matriculas = matriculaDao.findAll();
                    for (Matricula mat : matriculas) {
                        if (mat.getIdAluno() == aluno.getId()) {
                            mat.setIdCurso(aluno.getIdCurso());
                            matriculaDao.update(mat);
                            break;
                        }
                    }
                } catch (DAOException e) {
                    System.err.println("Erro ao atualizar matrícula: " + e.getMessage());
                }
            }
            return alunoAtualizado;
        } else {
            // Novo cadastro: salva aluno e cria matrícula
            boolean salvo = alunoDao.save(aluno) > 0;
            if (salvo) {
                try {
                    Matricula m = new Matricula(aluno.getId(), aluno.getIdCurso());
                    matriculaDao.save(m);
                } catch (DAOException e) {
                    System.err.println("Erro ao criar matrícula automática: " + e.getMessage());
                }
            }
            return salvo;
        }
    }

    public java.util.List<Aluno> listarTodos() throws DAOException {
        return alunoDao.findAll();
    }

    public Aluno buscarPorId(int id) throws DAOException {
        Aluno a = new Aluno(id, "000.000.000-00", "Dummy", 2000, 0);
        return alunoDao.findOne(a);
    }

    public boolean excluir(int id) throws DAOException {
        Aluno a = new Aluno(id, "000.000.000-00", "Dummy", 2000, 0);
        return alunoDao.delete(a) > 0;
    }

    public int count() throws SQLException {
        return alunoDao.count();
    }
}
