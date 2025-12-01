package br.unimontes.ccet.dcc.pg1.controller;

import br.unimontes.ccet.dcc.pg1.model.dao.AlunoDao;
import br.unimontes.ccet.dcc.pg1.model.dao.MatriculaDao;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Aluno;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Matricula;
import br.unimontes.ccet.dcc.pg1.model.dao.exception.DAOException;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class AlunoController {

    private AlunoDao dao;

    public AlunoController() {
        try {
            dao = new AlunoDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Aluno> listarTodos() {
        try {
            if (dao == null)
                return new ArrayList<>();
            return dao.findAll();
        } catch (DAOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Aluno buscarPorId(int id) {
        try {
            if (dao == null)
                return null;
            Aluno a = new Aluno(id, "000.000.000-00", "Dummy", 2000, 0);
            return dao.findOne(a);
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean salvar(Aluno aluno) {
        try {
            if (dao == null)
                return false;

            if (aluno.getId() > 0 && buscarPorId(aluno.getId()) != null) {
                return dao.update(aluno) > 0;
            } else {
                boolean salvo = dao.save(aluno) > 0;
                if (salvo) {
                    try {
                        MatriculaDao mDao = new MatriculaDao();
                        Matricula m = new Matricula(aluno.getId(), aluno.getIdCurso());
                        mDao.save(m);
                    } catch (SQLException | DAOException e) {
                        System.err.println("Erro ao criar matrícula automática: " + e.getMessage());
                    }
                }
                return salvo;
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
            Aluno a = new Aluno(id, "000.000.000-00", "Dummy", 2000, 0);
            return dao.delete(a) > 0;
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
