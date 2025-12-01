package br.unimontes.ccet.dcc.pg1.controller;

import br.unimontes.ccet.dcc.pg1.model.dao.MatriculaDao;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Matricula;
import br.unimontes.ccet.dcc.pg1.model.dao.exception.DAOException;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class MatriculaController {

    private MatriculaDao dao;

    public MatriculaController() {
        try {
            dao = new MatriculaDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Matricula> listarTodas() {
        try {
            if (dao == null)
                return new ArrayList<>();
            return dao.findAll();
        } catch (DAOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Matricula buscarPorId(int id) {
        try {
            if (dao == null)
                return null;
            Matricula m = new Matricula();
            m.setId(id);
            return dao.findOne(m);
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean salvar(Matricula matricula) {
        try {
            if (dao == null)
                return false;
            if (matricula.getId() > 0 && buscarPorId(matricula.getId()) != null) {
                return dao.update(matricula) > 0;
            } else {
                return dao.save(matricula) > 0;
            }
        } catch (DAOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluir(int id) {
        // Legacy method, kept for compatibility but might be incorrect if id is treated
        // as internal ID
        return excluirPorAluno(id);
    }

    public boolean excluirPorAluno(int idAluno) {
        try {
            if (dao == null)
                return false;
            Matricula m = new Matricula();
            m.setIdAluno(idAluno);
            return dao.delete(m) > 0;
        } catch (DAOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int count() {
        try {
            if (dao == null)
                return 0;
            return dao.count();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
