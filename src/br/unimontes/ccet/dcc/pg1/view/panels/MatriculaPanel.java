package br.unimontes.ccet.dcc.pg1.view.panels;

import br.unimontes.ccet.dcc.pg1.controller.MatriculaController;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Matricula;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MatriculaPanel extends javax.swing.JPanel {

    private MatriculaController matriculaController;
    private br.unimontes.ccet.dcc.pg1.controller.AlunoController alunoController;

    public MatriculaPanel() {
        matriculaController = new MatriculaController();
        alunoController = new br.unimontes.ccet.dcc.pg1.controller.AlunoController();
        initComponents();
        listarMatriculas();
    }

    private void listarMatriculas() {
        try {
            List<Matricula> matriculas = matriculaController.listarTodas();
            DefaultTableModel model = (DefaultTableModel) tableMatriculas.getModel();
            model.setNumRows(0);

            br.unimontes.ccet.dcc.pg1.controller.CursoController cursoController = new br.unimontes.ccet.dcc.pg1.controller.CursoController();

            for (Matricula m : matriculas) {
                String nomeAluno = "N/A";
                String nomeCurso = "N/A";
                try {
                    br.unimontes.ccet.dcc.pg1.model.dao.entity.Aluno a = alunoController.buscarPorId(m.getIdAluno());
                    if (a != null) {
                        nomeAluno = a.getNome();
                        br.unimontes.ccet.dcc.pg1.model.dao.entity.Curso c = cursoController
                                .buscarPorId(m.getIdCurso());
                        if (c != null) {
                            nomeCurso = c.getNome();
                        }
                    }
                } catch (Exception ex) {
                    // Ignora erro
                }

                model.addRow(new Object[] {
                        m.getIdAluno(),
                        nomeAluno,
                        nomeCurso
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao listar matrículas: " + e.getMessage());
        }
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMatriculas = new javax.swing.JTable();
        jbNovaMatricula = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbAtualizar = new javax.swing.JButton();
        jbVoltar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel1.setText("Gerenciar Matrículas");

        tableMatriculas.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {},
                new String[] { "Matrícula", "Nome do Aluno", "Curso" }) {
            boolean[] canEdit = new boolean[] { false, false, false };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tableMatriculas.setAutoCreateRowSorter(true);
        jScrollPane1.setViewportView(tableMatriculas);

        jbNovaMatricula.setText("Nova Matrícula");
        jbNovaMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovaMatriculaActionPerformed(evt);
            }
        });

        jbExcluir.setText("Excluir Selecionada");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jbAtualizar.setText("Atualizar");
        jbAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAtualizarActionPerformed(evt);
            }
        });

        jbEditar = new javax.swing.JButton();
        jbEditar.setText("Editar");
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jbVoltar.setText("Voltar");
        jbVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                java.awt.Window w = javax.swing.SwingUtilities.getWindowAncestor(MatriculaPanel.this);
                if (w != null)
                    w.dispose();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 588,
                                                Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jbNovaMatricula)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jbExcluir)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jbEditar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jbAtualizar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jbVoltar)))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jbNovaMatricula)
                                        .addComponent(jbExcluir)
                                        .addComponent(jbEditar)
                                        .addComponent(jbAtualizar)
                                        .addComponent(jbVoltar))
                                .addContainerGap()));
    }

    private void jbNovaMatriculaActionPerformed(java.awt.event.ActionEvent evt) {
        br.unimontes.ccet.dcc.pg1.view.TelaCadastroAluno tela = new br.unimontes.ccet.dcc.pg1.view.TelaCadastroAluno();
        tela.setVisible(true);
        tela.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        tela.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                listarMatriculas();
            }
        });
    }

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        int row = tableMatriculas.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma matrícula para excluir.");
            return;
        }

        int id = (int) tableMatriculas.getValueAt(row, 0);
        int confirm = JOptionPane.showConfirmDialog(this,
                "Tem certeza que deseja excluir a matrícula ID " + id + "?",
                "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            // The controller expects an object with the ID set.
            // Since we changed DAO to delete by id_aluno, we need to make sure we pass an
            // object with id_aluno set.
            // However, the controller's delete method takes an int 'id' and sets it to 'id'
            // of the entity.
            // We need to update the controller or the way we call it.
            // Actually, let's update the Controller to be clear or just rely on the DAO
            // change.
            // In DAO delete(Matricula m), we now use m.getIdAluno().
            // So we need to create a Matricula object with idAluno set.

            // But wait, the controller 'excluir(int id)' does: m.setId(id); return
            // dao.delete(m);
            // And DAO.delete uses m.getIdAluno() now (per my previous edit plan).
            // So m.setId(id) sets the internal ID, but m.getIdAluno() will be 0!
            // I need to update the Controller to set idAluno, OR update DAO to use getId()
            // if I want to treat the input as ID.

            // CORRECT FIX: The table shows 'Matrícula' (id_aluno) in column 0.
            // So 'id' variable here IS 'id_aluno'.
            // I should update the Controller to handle this.
            if (matriculaController.excluirPorAluno(id)) {
                listarMatriculas();
                JOptionPane.showMessageDialog(this, "Matrícula excluída com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao excluir matrícula.");
            }
        }
    }

    private void jbAtualizarActionPerformed(java.awt.event.ActionEvent evt) {
        listarMatriculas();
    }

    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAtualizar;

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {
        int row = tableMatriculas.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma matrícula para editar.");
            return;
        }

        int idAluno = (int) tableMatriculas.getValueAt(row, 0);
        br.unimontes.ccet.dcc.pg1.model.dao.entity.Aluno aluno = alunoController.buscarPorId(idAluno);

        if (aluno != null) {
            br.unimontes.ccet.dcc.pg1.view.TelaCadastroAluno tela = new br.unimontes.ccet.dcc.pg1.view.TelaCadastroAluno();
            tela.setAluno(aluno);
            tela.setVisible(true);
            tela.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
            tela.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                    listarMatriculas();
                }
            });
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao buscar dados do aluno.");
        }
    }

    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbNovaMatricula;
    private javax.swing.JButton jbVoltar;
    private javax.swing.JTable tableMatriculas;
}
