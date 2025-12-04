package br.unimontes.ccet.dcc.pg1.controller;

import br.unimontes.ccet.dcc.pg1.model.dao.AlunoDao;
import br.unimontes.ccet.dcc.pg1.model.dao.MatriculaDao;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Aluno;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Matricula;
import br.unimontes.ccet.dcc.pg1.model.dao.exception.DAOException;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class MatriculaController {

    private MatriculaDao dao;
    private AlunoDao alunoDao;

    public MatriculaController() {
        try {
            dao = new MatriculaDao();
            alunoDao = new AlunoDao();
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

    /**
     * Exclui a matrícula e o aluno associado.
     * Regra de negócio: aluno só existe com matrícula ativa.
     */
    public boolean excluirPorAluno(int idAluno) {
        try {
            if (dao == null || alunoDao == null)
                return false;

            // Primeiro exclui a matrícula
            Matricula m = new Matricula();
            m.setIdAluno(idAluno);
            boolean matriculaExcluida = dao.delete(m) > 0;

            // Depois exclui o aluno (regra: aluno só existe com matrícula ativa)
            if (matriculaExcluida) {
                Aluno a = new Aluno(idAluno, "000.000.000-00", "Dummy", 2000, 0);
                alunoDao.delete(a);
            }

            return matriculaExcluida;
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
