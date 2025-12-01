package br.unimontes.ccet.dcc.pg1.view;

import br.unimontes.ccet.dcc.pg1.view.panels.AlunoPanel;
import javax.swing.JFrame;

public class TelaGerenciarAlunos extends JFrame {

    public TelaGerenciarAlunos() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciar Alunos");

        AlunoPanel panel = new AlunoPanel();
        this.setContentPane(panel);
        this.pack();
    }
}
