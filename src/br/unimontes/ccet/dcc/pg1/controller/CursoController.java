package br.unimontes.ccet.dcc.pg1.controller;

import br.unimontes.ccet.dcc.pg1.model.service.CursoService;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Curso;
import br.unimontes.ccet.dcc.pg1.model.dao.exception.DAOException;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

/**
 * Controller para operações de Curso.
 * Usa CursoService para manter consistência arquitetural com AlunoController.
 */
public class CursoController {

    private CursoService service;

    public CursoController() {
        try {
            service = new CursoService();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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

    public boolean salvar(Curso curso) {
        try {
            if (service == null)
                return false;
            return service.salvarCurso(curso);
        } catch (DAOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluir(int id) {
        try {
            if (service == null)
                return false;
            return service.excluir(id);
        } catch (DAOException e) {
            e.printStackTrace();
            return false;
        }
    }

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
}
