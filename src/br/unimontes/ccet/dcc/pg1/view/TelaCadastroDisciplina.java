package br.unimontes.ccet.dcc.pg1.view;

import br.unimontes.ccet.dcc.pg1.model.dao.DisciplinaDao;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Disciplina;
import javax.swing.JOptionPane;

public class TelaCadastroDisciplina extends javax.swing.JDialog {

        private int idCurso;
        private Disciplina disciplina;

        public TelaCadastroDisciplina(java.awt.Frame parent, boolean modal, int idCurso, String nomeCurso) {
                super(parent, modal);
                this.idCurso = idCurso;
                initComponents();
                lblTitulo.setText("Nova Disciplina para: " + nomeCurso);
                setLocationRelativeTo(parent);
        }

        public void setDisciplina(Disciplina d) {
                this.disciplina = d;
                tfNome.setText(d.getNome());
                tfCargaHoraria.setText(String.valueOf(d.getCargaHoraria()));
                lblTitulo.setText("Editar Disciplina");
        }

        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                lblTitulo = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                tfNome = new javax.swing.JTextField();
                jLabel3 = new javax.swing.JLabel();
                tfCargaHoraria = new javax.swing.JTextField();
                jbSalvar = new javax.swing.JButton();
                jbCancelar = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                setTitle("Cadastrar Disciplina");

                lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                lblTitulo.setText("Nova Disciplina");

                jLabel2.setText("Nome da Disciplina:");

                jLabel3.setText("Carga Horária:");

                jbSalvar.setText("Salvar");
                jbSalvar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jbSalvarActionPerformed(evt);
                        }
                });

                jbCancelar.setText("Cancelar");
                jbCancelar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                dispose();
                        }
                });

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(tfNome)
                                                                                .addComponent(tfCargaHoraria)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(lblTitulo)
                                                                                                                .addComponent(jLabel2)
                                                                                                                .addComponent(jLabel3))
                                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                jPanel1Layout.createSequentialGroup()
                                                                                                                .addGap(0, 198, Short.MAX_VALUE)
                                                                                                                .addComponent(jbSalvar)
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(jbCancelar)))
                                                                .addContainerGap()));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(lblTitulo)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jLabel2)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(tfNome,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabel3)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(tfCargaHoraria,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jbSalvar)
                                                                                .addComponent(jbCancelar))
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

                pack();
        }

        private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {
                try {
                        String nome = tfNome.getText();
                        String cargaHorariaStr = tfCargaHoraria.getText();

                        if (nome.isBlank() || cargaHorariaStr.isBlank()) {
                                JOptionPane.showMessageDialog(this, "Preencha todos os campos.");
                                return;
                        }

                        int cargaHoraria = Integer.parseInt(cargaHorariaStr);
                        DisciplinaDao dao = new DisciplinaDao();

                        if (disciplina == null) {
                                Disciplina d = new Disciplina(nome, cargaHoraria, idCurso);
                                dao.save(d);
                                JOptionPane.showMessageDialog(this, "Disciplina cadastrada com sucesso!");
                        } else {
                                disciplina.setNome(nome);
                                disciplina.setCargaHoraria(cargaHoraria);
                                dao.update(disciplina);
                                JOptionPane.showMessageDialog(this, "Disciplina editada com sucesso!");
                        }
                        dispose();

                } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Carga horária deve ser um número.");
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Erro ao salvar disciplina: " + e.getMessage());
                }
        }

        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JButton jbCancelar;
        private javax.swing.JButton jbSalvar;
        private javax.swing.JLabel lblTitulo;
        private javax.swing.JTextField tfCargaHoraria;
        private javax.swing.JTextField tfNome;
}
