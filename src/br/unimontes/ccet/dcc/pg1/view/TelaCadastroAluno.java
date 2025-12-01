package br.unimontes.ccet.dcc.pg1.view;

import br.unimontes.ccet.dcc.pg1.controller.CadastrarAlunoController;
import br.unimontes.ccet.dcc.pg1.model.dao.CursoDao;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Curso;
import br.unimontes.ccet.dcc.pg1.model.dao.exception.DAOException;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class TelaCadastroAluno extends javax.swing.JFrame {

        private static final java.util.logging.Logger logger = java.util.logging.Logger
                        .getLogger(TelaCadastroAluno.class.getName());

        public TelaCadastroAluno() {
                initComponents();
                setLocationRelativeTo(null);
                carregarCursos();
        }

        private void carregarCursos() {
                try {
                        CursoDao cursoDao = new CursoDao();
                        List<Curso> cursos = cursoDao.findAll();
                        for (Curso c : cursos) {
                                cbCurso.addItem(c);
                        }
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Erro ao carregar cursos: " + e.getMessage());
                }
        }

        private int idAluno = 0;

        public void setAluno(br.unimontes.ccet.dcc.pg1.model.dao.entity.Aluno aluno) {
                this.idAluno = aluno.getId();
                tfNome.setText(aluno.getNome());
                tfCpf.setText(aluno.getCpf());
                tfCpf.setEditable(false);
                tfAnoNascimento.setText(String.valueOf(aluno.getAnoNascimento()));

                // Selecionar o curso do aluno no ComboBox
                for (int i = 0; i < cbCurso.getItemCount(); i++) {
                        Curso c = cbCurso.getItemAt(i);
                        if (c.getId() == aluno.getIdCurso()) {
                                cbCurso.setSelectedIndex(i);
                                break;
                        }
                }

                jbCadastrar.setText("Salvar Alterações");
        }

        private void initComponents() {

                panelPG11 = new br.unimontes.ccet.dcc.pg1.view.panels.PanelPG1();
                jlNome = new javax.swing.JLabel();
                jlCpf = new javax.swing.JLabel();
                jlAnoNascimento = new javax.swing.JLabel();
                jlCurso = new javax.swing.JLabel();
                tfNome = new br.unimontes.ccet.dcc.pg1.view.components.TextFieldPG1();
                tfCpf = new br.unimontes.ccet.dcc.pg1.view.components.TextFieldPG1();
                tfAnoNascimento = new br.unimontes.ccet.dcc.pg1.view.components.TextFieldPG1();
                cbCurso = new javax.swing.JComboBox<>();
                jbCadastrar = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setTitle("Cadastro Aluno");
                setResizable(false);

                jlNome.setText("Nome");

                jlCpf.setText("CPF");

                jlAnoNascimento.setText("Ano de Nascimento");

                jlCurso.setText("Curso");

                tfNome.setName("tfNome");

                tfCpf.setName("tfCpf");

                tfAnoNascimento.setName("tfAnoNascimento");

                cbCurso.setName("cbCurso");

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
                                                                                                                .addComponent(jlAnoNascimento)
                                                                                                                .addGap(18, 18, 18)
                                                                                                                .addComponent(tfAnoNascimento,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE))
                                                                                                .addGroup(panelPG11Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(jlCpf)
                                                                                                                .addGap(18, 18, 18)
                                                                                                                .addComponent(tfCpf,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE))
                                                                                                .addGroup(panelPG11Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(jlCurso)
                                                                                                                .addGap(18, 18, 18)
                                                                                                                .addComponent(cbCurso,
                                                                                                                                0,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)))
                                                                                .addComponent(jbCadastrar))
                                                                .addContainerGap(20, Short.MAX_VALUE)));
                panelPG11Layout.setVerticalGroup(
                                panelPG11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(panelPG11Layout.createSequentialGroup()
                                                                .addGap(19, 19, 19)
                                                                .addGroup(
                                                                                panelPG11Layout.createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                .addComponent(jlNome)
                                                                                                .addComponent(tfNome,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(16, 16, 16)
                                                                .addGroup(
                                                                                panelPG11Layout.createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                .addComponent(jlCpf)
                                                                                                .addComponent(tfCpf,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(
                                                                                panelPG11Layout.createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                .addComponent(jlAnoNascimento)
                                                                                                .addComponent(tfAnoNascimento,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(
                                                                                panelPG11Layout.createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                .addComponent(jlCurso)
                                                                                                .addComponent(cbCurso,
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

        private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarAlunoController controller = new CadastrarAlunoController();
                try {
                        boolean retorno = controller.executa(panelPG11, idAluno);
                        if (retorno) {
                                if (idAluno > 0)
                                        JOptionPane.showMessageDialog(this, "Aluno editado com sucesso!");
                                else
                                        JOptionPane.showMessageDialog(this, "Aluno cadastrado com sucesso!");
                        } else
                                JOptionPane.showMessageDialog(this, "Aluno não cadastrado!");
                } catch (SQLException ex) {
                        System.getLogger(TelaCadastroAluno.class.getName()).log(System.Logger.Level.ERROR,
                                        (String) null, ex);
                } catch (DAOException ex) {
                        System.getLogger(TelaCadastroAluno.class.getName()).log(System.Logger.Level.ERROR,
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
                } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
                        logger.log(java.util.logging.Level.SEVERE, null, ex);
                }

                java.awt.EventQueue.invokeLater(() -> new TelaCadastroAluno().setVisible(true));
        }

        private javax.swing.JButton jbCadastrar;
        private javax.swing.JLabel jlAnoNascimento;
        private javax.swing.JLabel jlCpf;
        private javax.swing.JLabel jlNome;
        private javax.swing.JLabel jlCurso;
        private br.unimontes.ccet.dcc.pg1.view.panels.PanelPG1 panelPG11;
        private br.unimontes.ccet.dcc.pg1.view.components.TextFieldPG1 tfAnoNascimento;
        private br.unimontes.ccet.dcc.pg1.view.components.TextFieldPG1 tfCpf;
        private br.unimontes.ccet.dcc.pg1.view.components.TextFieldPG1 tfNome;
        private javax.swing.JComboBox<Curso> cbCurso;
}
