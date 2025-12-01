package br.unimontes.ccet.dcc.pg1.view;

import br.unimontes.ccet.dcc.pg1.model.dao.DisciplinaDao;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Disciplina;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaVisualizarDisciplinas extends javax.swing.JDialog {

        private int idCurso;

        public TelaVisualizarDisciplinas(java.awt.Frame parent, boolean modal, int idCurso, String nomeCurso) {
                super(parent, modal);
                this.idCurso = idCurso;
                initComponents();
                tableDisciplinas.setAutoCreateRowSorter(true);
                lblTitulo.setText("Disciplinas do Curso: " + nomeCurso);
                listarDisciplinas();
                setLocationRelativeTo(parent);
        }

        private void listarDisciplinas() {
                try {
                        DisciplinaDao dao = new DisciplinaDao();
                        List<Disciplina> disciplinas = dao.findByCurso(idCurso);
                        DefaultTableModel model = (DefaultTableModel) tableDisciplinas.getModel();
                        model.setNumRows(0);

                        for (Disciplina d : disciplinas) {
                                model.addRow(new Object[] {
                                                d.getId(),
                                                d.getNome(),
                                                d.getCargaHoraria()
                                });
                        }
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Erro ao listar disciplinas: " + e.getMessage());
                }
        }

        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                lblTitulo = new javax.swing.JLabel();
                jScrollPane1 = new javax.swing.JScrollPane();
                tableDisciplinas = new javax.swing.JTable();
                jbFechar = new javax.swing.JButton();
                jbEditar = new javax.swing.JButton();
                jbExcluir = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                setTitle("Visualizar Disciplinas");

                lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                lblTitulo.setText("Disciplinas do Curso: ");

                tableDisciplinas.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {

                                },
                                new String[] {
                                                "ID", "Nome", "Carga Horária"
                                }) {
                        boolean[] canEdit = new boolean[] {
                                        false, false, false
                        };

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit[columnIndex];
                        }
                });
                jScrollPane1.setViewportView(tableDisciplinas);
                if (tableDisciplinas.getColumnModel().getColumnCount() > 0) {
                        tableDisciplinas.getColumnModel().getColumn(0).setMinWidth(50);
                        tableDisciplinas.getColumnModel().getColumn(0).setMaxWidth(50);
                        tableDisciplinas.getColumnModel().getColumn(2).setMinWidth(100);
                        tableDisciplinas.getColumnModel().getColumn(2).setMaxWidth(100);
                }

                jbFechar.setText("Fechar");
                jbFechar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                dispose();
                        }
                });

                jbEditar.setText("Editar");
                jbEditar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jbEditarActionPerformed(evt);
                        }
                });

                jbExcluir.setText("Excluir");
                jbExcluir.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jbExcluirActionPerformed(evt);
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
                                                                                .addComponent(jScrollPane1,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                488,
                                                                                                Short.MAX_VALUE)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(lblTitulo)
                                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                jPanel1Layout.createSequentialGroup()
                                                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                                                .addComponent(jbEditar)
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(jbExcluir)
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(jbFechar)))
                                                                .addContainerGap()));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(lblTitulo)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jScrollPane1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                275,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jbFechar)
                                                                                .addComponent(jbExcluir)
                                                                                .addComponent(jbEditar))
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

        private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {
                int row = tableDisciplinas.getSelectedRow();
                if (row == -1) {
                        JOptionPane.showMessageDialog(this, "Selecione uma disciplina para editar.");
                        return;
                }

                try {
                        int id = (int) tableDisciplinas.getValueAt(row, 0);
                        DisciplinaDao dao = new DisciplinaDao();
                        Disciplina d = new Disciplina("", 0, 0);
                        d.setId(id);
                        d = dao.findOne(d);

                        if (d != null) {
                                TelaCadastroDisciplina tela = new TelaCadastroDisciplina((java.awt.Frame) getParent(),
                                                true, idCurso,
                                                "");
                                tela.setDisciplina(d);
                                tela.setVisible(true);
                                listarDisciplinas();
                        }
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Erro ao carregar disciplina: " + e.getMessage());
                }
        }

        private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {
                int row = tableDisciplinas.getSelectedRow();
                if (row == -1) {
                        JOptionPane.showMessageDialog(this, "Selecione uma disciplina para excluir.");
                        return;
                }

                int id = (int) tableDisciplinas.getValueAt(row, 0);
                String nome = (String) tableDisciplinas.getValueAt(row, 1);

                int confirm = JOptionPane.showConfirmDialog(this,
                                "Tem certeza que deseja excluir a disciplina " + nome + "?",
                                "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                        try {
                                DisciplinaDao dao = new DisciplinaDao();
                                Disciplina d = new Disciplina("", 0, 0);
                                d.setId(id);
                                dao.delete(d);
                                listarDisciplinas();
                                JOptionPane.showMessageDialog(this, "Disciplina excluída com sucesso!");
                        } catch (Exception e) {
                                if (e.getMessage().contains("constraint") || e.getMessage().contains("foreign key")) {
                                        JOptionPane.showMessageDialog(this,
                                                        "Não é possível excluir esta disciplina pois existem turmas ou matrículas associadas.\nExclua as dependências primeiro.");
                                } else {
                                        JOptionPane.showMessageDialog(this,
                                                        "Erro ao excluir disciplina: " + e.getMessage());
                                }
                        }
                }
        }

        private javax.swing.JButton jbEditar;
        private javax.swing.JButton jbExcluir;
        private javax.swing.JButton jbFechar;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JLabel lblTitulo;
        private javax.swing.JTable tableDisciplinas;
}
