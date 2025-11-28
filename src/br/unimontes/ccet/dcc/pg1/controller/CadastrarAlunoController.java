package br.unimontes.ccet.dcc.pg1.controller;

import br.unimontes.ccet.dcc.pg1.model.dao.AlunoDao;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Aluno;
import br.unimontes.ccet.dcc.pg1.model.dao.exception.DAOException;
import br.unimontes.ccet.dcc.pg1.view.interfaces.PanelInterface;
import br.unimontes.ccet.dcc.pg1.view.interfaces.TextFieldInterface;
import java.sql.SQLException;
import java.util.HashMap;

public class CadastrarAlunoController {
    public boolean executa(PanelInterface view, int idAluno) throws SQLException, DAOException {
        HashMap<String, java.awt.Component> comp = view.getMapComponents();

        TextFieldInterface tfnome = (TextFieldInterface) comp.get("tfNome");
        TextFieldInterface tfcpf = (TextFieldInterface) comp.get("tfCpf");
        TextFieldInterface tfano = (TextFieldInterface) comp.get("tfAnoNascimento");
        javax.swing.JComboBox cbCurso = (javax.swing.JComboBox) comp.get("cbCurso");

        br.unimontes.ccet.dcc.pg1.model.dao.entity.Curso cursoSelecionado = (br.unimontes.ccet.dcc.pg1.model.dao.entity.Curso) cbCurso
                .getSelectedItem();

        int idCurso = cursoSelecionado.getId();

        Aluno a = new Aluno(
                tfcpf.getText(),
                tfnome.getText(),
                Integer.parseInt(tfano.getText()),
                idCurso);

        AlunoDao aDao = new AlunoDao();
        int resultado;

        if (idAluno > 0) {
            a.setId(idAluno);
            resultado = aDao.update(a);
        } else {
            resultado = aDao.save(a);
        }

        if (resultado > 0)
            return true;
        return false;
    }
}
