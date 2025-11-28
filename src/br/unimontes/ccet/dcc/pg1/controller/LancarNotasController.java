package br.unimontes.ccet.dcc.pg1.controller;

import br.unimontes.ccet.dcc.pg1.model.dao.MatriculaDao;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Matricula;
import br.unimontes.ccet.dcc.pg1.model.dao.exception.DAOException;
import java.sql.SQLException;

public class LancarNotasController {

    public boolean salvar(Matricula matricula) throws SQLException, DAOException {
        // Validações básicas
        if (matricula.getNota() < 0 || matricula.getNota() > 100) {
            throw new DAOException("A nota deve estar entre 0 e 100.");
        }
        if (matricula.getFrequencia() < 0 || matricula.getFrequencia() > 100) {
            throw new DAOException("A frequência deve estar entre 0 e 100.");
        }

        MatriculaDao dao = new MatriculaDao();
        int linhas = dao.update(matricula);
        return linhas > 0;
    }
}
