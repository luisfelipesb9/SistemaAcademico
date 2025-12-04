package br.unimontes.ccet.dcc.pg1.model.service;

import br.unimontes.ccet.dcc.pg1.model.dao.CursoDao;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Curso;
import br.unimontes.ccet.dcc.pg1.model.dao.exception.DAOException;
import java.sql.SQLException;
import java.util.List;

public class CursoService {

    private CursoDao cursoDao;

    public CursoService() throws SQLException {
        this.cursoDao = new CursoDao();
    }

    public boolean salvarCurso(Curso curso) throws DAOException {
        if (curso.getId() > 0) {
            return cursoDao.update(curso) > 0;
        } else {
            return cursoDao.save(curso) > 0;
        }
    }

    public List<Curso> listarTodos() throws DAOException {
        return cursoDao.findAll();
    }

    public Curso buscarPorId(int id) throws DAOException {
        Curso c = new Curso(id, "Dummy", 0);
        return cursoDao.findOne(c);
    }

    public boolean excluir(int id) throws DAOException {
        Curso c = new Curso(id, "Dummy", 0);
        return cursoDao.delete(c) > 0;
    }

    public int count() throws SQLException {
        return cursoDao.count();
    }
}
