package br.unimontes.ccet.dcc.pg1.view;

import br.unimontes.ccet.dcc.pg1.view.panels.MatriculaPanel;
import javax.swing.JFrame;

public class TelaGerenciarMatriculas extends JFrame {

    public TelaGerenciarMatriculas() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciar Matrículas");

        MatriculaPanel panel = new MatriculaPanel();
        this.setContentPane(panel);
        this.pack();
    }
}
