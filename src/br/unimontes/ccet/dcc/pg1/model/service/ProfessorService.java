package br.unimontes.ccet.dcc.pg1.model.service;

import br.unimontes.ccet.dcc.pg1.model.dao.ProfessorDao;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Professor;
import br.unimontes.ccet.dcc.pg1.model.dao.exception.DAOException;
import java.sql.SQLException;

/**
 * Service para operações de Professor/Coordenador.
 * Centraliza regras de negócio relacionadas a professores.
 */
public class ProfessorService {

    private ProfessorDao professorDao;

    public ProfessorService() throws SQLException {
        this.professorDao = new ProfessorDao();
    }

    /**
     * Busca o coordenador de um curso específico.
     */
    public Professor buscarCoordenadorPorCurso(int idCurso) throws DAOException {
        return professorDao.buscarCoordenadorPorCurso(idCurso);
    }

    /**
     * Salva ou atualiza um professor/coordenador.
     */
    public boolean salvar(Professor professor) throws DAOException {
        if (professor.getId() > 0) {
            return professorDao.update(professor) > 0;
        } else {
            return professorDao.save(professor) > 0;
        }
    }

    /**
     * Remove o coordenador de um curso específico.
     */
    public boolean excluirPorCurso(int idCurso) throws DAOException {
        return professorDao.deleteByIdCurso(idCurso) > 0;
    }
}
