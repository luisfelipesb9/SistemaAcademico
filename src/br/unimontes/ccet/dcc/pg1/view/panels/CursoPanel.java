package br.unimontes.ccet.dcc.pg1.view.panels;

import br.unimontes.ccet.dcc.pg1.controller.CursoController;
import br.unimontes.ccet.dcc.pg1.model.dao.ProfessorDao;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Curso;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Professor;
import br.unimontes.ccet.dcc.pg1.view.TelaCadastroCurso;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CursoPanel extends javax.swing.JPanel {

    private CursoController cursoController;
    private ProfessorDao professorDao;

    public CursoPanel() {
        cursoController = new CursoController();
        try {
            professorDao = new ProfessorDao();
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
        listarCursos();
    }

    private void listarCursos() {
        try {
            List<Curso> cursos = cursoController.listarTodos();
            DefaultTableModel model = (DefaultTableModel) tableCursos.getModel();
            model.setNumRows(0);

            for (Curso c : cursos) {
                // Busca o coordenador do curso
                String nomeCoordenador = "Não definido";
                if (professorDao != null) {
                    try {
                        Professor coord = professorDao.buscarCoordenadorPorCurso(c.getId());
                        if (coord != null) {
                            nomeCoordenador = coord.getNomeFormatado();
                        }
                    } catch (Exception ex) {
                        // Ignora erro ao buscar coordenador
                    }
                }

                model.addRow(new Object[] {
                        c.getId(),
                        c.getNome(),
                        c.getCreditos(),
                        nomeCoordenador
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao listar cursos: " + e.getMessage());
        }
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCursos = new javax.swing.JTable();
        jbCadastrar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbAtualizar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbVoltar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel1.setText("Gerenciar Cursos");

        tableCursos.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {},
                new String[] { "ID", "Nome", "Horas", "Coordenador" }) {
            boolean[] canEdit = new boolean[] { false, false, false, false };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tableCursos.setAutoCreateRowSorter(true);
        jScrollPane1.setViewportView(tableCursos);

        jbCadastrar.setText("Cadastrar Novo Curso");
        jbCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarActionPerformed(evt);
            }
        });

        jbExcluir.setText("Excluir Selecionado");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jbEditar.setText("Editar Curso");
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jbAtualizar.setText("Atualizar Lista");
        jbAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAtualizarActionPerformed(evt);
            }
        });

        jbVoltar.setText("Voltar");
        jbVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                java.awt.Window w = javax.swing.SwingUtilities.getWindowAncestor(CursoPanel.this);
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
                                                .addComponent(jbCadastrar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jbEditar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jbExcluir)
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
                                        .addComponent(jbCadastrar)
                                        .addComponent(jbEditar)
                                        .addComponent(jbExcluir)
                                        .addComponent(jbAtualizar)
                                        .addComponent(jbVoltar))
                                .addContainerGap()));
    }

    private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
        TelaCadastroCurso tela = new TelaCadastroCurso();
        tela.setVisible(true);
        tela.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        tela.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                listarCursos();
            }
        });
    }

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {
        int row = tableCursos.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um curso para editar.");
            return;
        }

        try {
            int id = (int) tableCursos.getValueAt(row, 0);
            String nome = (String) tableCursos.getValueAt(row, 1);
            int creditos = (int) tableCursos.getValueAt(row, 2);

            Curso curso = new Curso(id, nome, creditos);

            TelaCadastroCurso tela = new TelaCadastroCurso();
            tela.setCurso(curso);
            tela.setVisible(true);
            tela.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
            tela.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                    listarCursos();
                }
            });
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar curso para edição: " + e.getMessage());
        }
    }

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        int row = tableCursos.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um curso para excluir.");
            return;
        }

        int id = (int) tableCursos.getValueAt(row, 0);
        String nome = (String) tableCursos.getValueAt(row, 1);

        int confirm = JOptionPane.showConfirmDialog(this,
                "Devo excluir o curso " + nome + "?",
                "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            if (cursoController.excluir(id)) {
                listarCursos();
                JOptionPane.showMessageDialog(this, "Curso excluído com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao excluir curso. Verifique se existem alunos vinculados.");
            }
        }
    }

    private void jbAtualizarActionPerformed(java.awt.event.ActionEvent evt) {
        listarCursos();
    }

    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAtualizar;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbVoltar;
    private javax.swing.JTable tableCursos;
}
