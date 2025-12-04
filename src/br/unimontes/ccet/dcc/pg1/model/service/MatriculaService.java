package br.unimontes.ccet.dcc.pg1.model.service;

import br.unimontes.ccet.dcc.pg1.model.dao.MatriculaDao;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Matricula;
import br.unimontes.ccet.dcc.pg1.model.dao.exception.DAOException;
import java.sql.SQLException;
import java.util.List;

public class MatriculaService {

    private MatriculaDao matriculaDao;

    public MatriculaService() throws SQLException {
        this.matriculaDao = new MatriculaDao();
    }

    public boolean salvarMatricula(Matricula matricula) throws DAOException {
        if (matricula.getId() > 0) {
            return matriculaDao.update(matricula) > 0;
        } else {
            return matriculaDao.save(matricula) > 0;
        }
    }

    public List<Matricula> listarTodos() throws DAOException {
        return matriculaDao.findAll();
    }

    public Matricula buscarPorId(int id) throws DAOException {
        Matricula m = new Matricula(id, 0, 0);
        return matriculaDao.findOne(m);
    }

    public boolean excluir(int idAluno) throws DAOException {
        Matricula m = new Matricula(0, idAluno, 0);
        return matriculaDao.delete(m) > 0;
    }

    public int count() throws SQLException {
        return matriculaDao.count();
    }
}
