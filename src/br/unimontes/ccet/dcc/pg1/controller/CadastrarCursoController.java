package br.unimontes.ccet.dcc.pg1.controller;

import br.unimontes.ccet.dcc.pg1.model.dao.CursoDao;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Curso;
import br.unimontes.ccet.dcc.pg1.model.dao.exception.DAOException;
import br.unimontes.ccet.dcc.pg1.view.interfaces.PanelInterface;
import br.unimontes.ccet.dcc.pg1.view.interfaces.TextFieldInterface;
import java.sql.SQLException;
import java.util.HashMap;

public class CadastrarCursoController {
    public boolean executa(PanelInterface view) throws SQLException, DAOException {
        HashMap<String, java.awt.Component> comp = view.getMapComponents();

        TextFieldInterface tfnome = (TextFieldInterface) comp.get("tfNome");
        TextFieldInterface tfcreditos = (TextFieldInterface) comp.get("tfCreditos");

        Curso c = new Curso(
                tfnome.getText(),
                Integer.parseInt(tfcreditos.getText()));

        CursoDao cDao = new CursoDao();
        int resultado = cDao.save(c);

        if (resultado > 0)
            return true;
        return false;
    }
}
