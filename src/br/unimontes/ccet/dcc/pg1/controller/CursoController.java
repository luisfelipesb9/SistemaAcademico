package br.unimontes.ccet.dcc.pg1.controller;

import br.unimontes.ccet.dcc.pg1.model.dao.CursoDao;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Curso;
import br.unimontes.ccet.dcc.pg1.model.dao.exception.DAOException;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class CursoController {

    private CursoDao dao;

    public CursoController() {
        try {
            dao = new CursoDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Curso> listarTodos() {
        try {
            if (dao == null)
                return new ArrayList<>();
            return dao.findAll();
        } catch (DAOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Curso buscarPorId(int id) {
        try {
            if (dao == null)
                return null;
            Curso c = new Curso(id, "Dummy", 0);
            return dao.findOne(c);
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean salvar(Curso curso) {
        try {
            if (dao == null)
                return false;
            if (curso.getId() > 0 && buscarPorId(curso.getId()) != null) {
                return dao.update(curso) > 0;
            } else {
                return dao.save(curso) > 0;
            }
        } catch (DAOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluir(int id) {
        try {
            if (dao == null)
                return false;
            Curso c = new Curso(id, "Dummy", 0);
            return dao.delete(c) > 0;
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
