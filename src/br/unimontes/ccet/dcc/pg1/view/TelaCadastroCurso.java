package br.unimontes.ccet.dcc.pg1.view;

import br.unimontes.ccet.dcc.pg1.controller.CadastrarCursoController;
import br.unimontes.ccet.dcc.pg1.model.dao.exception.DAOException;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class TelaCadastroCurso extends javax.swing.JFrame {

        public TelaCadastroCurso() {
                initComponents();
                setLocationRelativeTo(null);
        }

        // @SuppressWarnings("unchecked")
        private void initComponents() {

                panelPG11 = new br.unimontes.ccet.dcc.pg1.view.panels.PanelPG1();
                jlNome = new javax.swing.JLabel();
                jlCreditos = new javax.swing.JLabel();
                tfNome = new br.unimontes.ccet.dcc.pg1.view.components.TextFieldPG1();
                tfCreditos = new br.unimontes.ccet.dcc.pg1.view.components.TextFieldPG1();
                jbCadastrar = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                setTitle("Cadastro Curso");
                setResizable(false);

                jlNome.setText("Nome do Curso");

                jlCreditos.setText("Horas");

                tfNome.setName("tfNome");

                tfCreditos.setName("tfCreditos");

                jbCadastrar.setText("Cadastrar");
                jbCadastrar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jbCadastrarActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout panelPG11Layout = new javax.swing.GroupLayout(panelPG11);
                panelPG11.setLayout(panelPG11Layout);
                panelPG11Layout.setHorizontalGroup(
                                panelPG11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(panelPG11Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(panelPG11Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(panelPG11Layout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                false)
                                                                                                .addGroup(panelPG11Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(jlNome)
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(tfNome,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                273,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGroup(panelPG11Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(jlCreditos)
                                                                                                                .addGap(18, 18, 18)
                                                                                                                .addComponent(tfCreditos,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)))
                                                                                .addComponent(jbCadastrar))
                                                                .addContainerGap(20, Short.MAX_VALUE)));
                panelPG11Layout.setVerticalGroup(
                                panelPG11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(panelPG11Layout.createSequentialGroup()
                                                                .addGap(19, 19, 19)
                                                                .addGroup(panelPG11Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jlNome)
                                                                                .addComponent(tfNome,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(16, 16, 16)
                                                                .addGroup(panelPG11Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jlCreditos)
                                                                                .addComponent(tfCreditos,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(32, 32, 32)
                                                                .addComponent(jbCadastrar)
                                                                .addContainerGap(18, Short.MAX_VALUE)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(panelPG11,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addContainerGap()));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(panelPG11,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                pack();
        }

        private br.unimontes.ccet.dcc.pg1.model.dao.entity.Curso cursoEdicao;

        public void setCurso(br.unimontes.ccet.dcc.pg1.model.dao.entity.Curso curso) {
                this.cursoEdicao = curso;
                tfNome.setText(curso.getNome());
                tfCreditos.setText(String.valueOf(curso.getCreditos()));
                jbCadastrar.setText("Salvar Alterações");
        }

        private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
                try {
                        if (cursoEdicao != null) {
                                cursoEdicao.setNome(tfNome.getText());
                                br.unimontes.ccet.dcc.pg1.model.dao.entity.Curso c = new br.unimontes.ccet.dcc.pg1.model.dao.entity.Curso(
                                                tfNome.getText(),
                                                Integer.parseInt(tfCreditos.getText()));
                                c.setId(cursoEdicao.getId());

                                br.unimontes.ccet.dcc.pg1.model.dao.CursoDao dao = new br.unimontes.ccet.dcc.pg1.model.dao.CursoDao();
                                dao.update(c);
                                JOptionPane.showMessageDialog(this, "Curso atualizado com sucesso!");
                                this.dispose();
                        } else {
                                CadastrarCursoController controller = new CadastrarCursoController();
                                boolean retorno = controller.executa(panelPG11);
                                if (retorno)
                                        JOptionPane.showMessageDialog(this, "Curso cadastrado com sucesso!");
                                else
                                        JOptionPane.showMessageDialog(this, "Curso não cadastrado!");
                        }
                } catch (SQLException ex) {
                        System.getLogger(TelaCadastroCurso.class.getName()).log(System.Logger.Level.ERROR,
                                        (String) null, ex);
                } catch (DAOException ex) {
                        System.getLogger(TelaCadastroCurso.class.getName()).log(System.Logger.Level.ERROR,
                                        (String) null, ex);
                }
        }

        public static void main(String args[]) {
                try {
                        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                                        .getInstalledLookAndFeels()) {
                                if ("Nimbus".equals(info.getName())) {
                                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(TelaCadastroCurso.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(TelaCadastroCurso.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(TelaCadastroCurso.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(TelaCadastroCurso.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                }

                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new TelaCadastroCurso().setVisible(true);
                        }
                });
        }

        private javax.swing.JButton jbCadastrar;
        private javax.swing.JLabel jlCreditos;
        private javax.swing.JLabel jlNome;
        private br.unimontes.ccet.dcc.pg1.view.panels.PanelPG1 panelPG11;
        private br.unimontes.ccet.dcc.pg1.view.components.TextFieldPG1 tfCreditos;
        private br.unimontes.ccet.dcc.pg1.view.components.TextFieldPG1 tfNome;
}
