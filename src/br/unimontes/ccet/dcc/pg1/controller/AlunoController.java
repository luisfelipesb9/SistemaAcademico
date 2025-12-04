package br.unimontes.ccet.dcc.pg1.controller;

import br.unimontes.ccet.dcc.pg1.model.service.AlunoService;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Aluno;
import br.unimontes.ccet.dcc.pg1.model.dao.exception.DAOException;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class AlunoController {

    private AlunoService service;

    public AlunoController() {
        try {
            service = new AlunoService();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Aluno> listarTodos() {
        try {
            if (service == null)
                return new ArrayList<>();
            return service.listarTodos();
        } catch (DAOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Aluno buscarPorId(int id) {
        try {
            if (service == null)
                return null;
            return service.buscarPorId(id);
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean salvar(Aluno aluno) {
        try {
            if (service == null)
                return false;
            return service.salvarAluno(aluno);
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
