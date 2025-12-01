package br.unimontes.ccet.dcc.pg1.view;

import br.unimontes.ccet.dcc.pg1.view.panels.CursoPanel;
import javax.swing.JFrame;

public class TelaGerenciarCursos extends JFrame {

    public TelaGerenciarCursos() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciar Cursos");

        CursoPanel panel = new CursoPanel();
        this.setContentPane(panel);
        this.pack();
    }
}
