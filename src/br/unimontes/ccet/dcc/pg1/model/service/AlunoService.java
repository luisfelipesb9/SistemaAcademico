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
            return alunoDao.update(aluno) > 0;
        } else {
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
