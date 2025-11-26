package br.unimontes.ccet.dcc.pg1.view;

import br.unimontes.ccet.dcc.pg1.model.dao.CursoDao;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Curso;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaGerenciarCursos extends javax.swing.JFrame {

    public TelaGerenciarCursos() {
        initComponents();
        setLocationRelativeTo(null);
        tableCursos.getColumnModel().getColumn(0).setMinWidth(0);
        tableCursos.getColumnModel().getColumn(0).setMaxWidth(0);
        tableCursos.getColumnModel().getColumn(0).setWidth(0);
        listarCursos();
    }

    private void listarCursos() {
        listarCursos(null);
    }

    private void listarCursos(String nomePesquisa) {
        try {
            CursoDao cursoDao = new CursoDao();
            List<Curso> cursos = cursoDao.findAll();
            DefaultTableModel model = (DefaultTableModel) tableCursos.getModel();
            model.setNumRows(0);

            for (Curso c : cursos) {
                if (nomePesquisa != null && !nomePesquisa.isBlank()) {
                    String termo = nomePesquisa.toLowerCase();
                    boolean matches = c.getNome().toLowerCase().contains(termo) ||
                            String.valueOf(c.getId()).contains(termo) ||
                            String.valueOf(c.getCreditos()).contains(termo);
                    if (!matches) {
                        continue;
                    }
                }
                model.addRow(new Object[] {
                        c.getId(),
                        c.getNome(),
                        c.getCreditos()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao listar cursos: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfPesquisa = new javax.swing.JTextField();
        jbPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCursos = new javax.swing.JTable();
        jbListar = new javax.swing.JButton();
        jbCadastrar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciar Cursos");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel1.setText("Gerenciar Cursos");

        jbPesquisar.setText("Pesquisar");
        jbPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesquisarActionPerformed(evt);
            }
        });

        tableCursos.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "ID", "Nome", "Horas"
                }) {
            boolean[] canEdit = new boolean[] {
                    false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableCursos);

        jbListar.setText("Listar Todos");
        jbListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbListarActionPerformed(evt);
            }
        });

        jbCadastrar.setText("Cadastrar");
        jbCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarActionPerformed(evt);
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

        jbVoltar.setText("Voltar");
        jbVoltar.addActionListener(new java.awt.event.ActionListener() {
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
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 588,
                                                Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(tfPesquisa)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jbPesquisar))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jbListar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jbCadastrar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jbEditar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jbExcluir)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jbVoltar)))
                                .addContainerGap()));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jbPesquisar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jbListar)
                                        .addComponent(jbCadastrar)
                                        .addComponent(jbEditar)
                                        .addComponent(jbExcluir)
                                        .addComponent(jbVoltar))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

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

    private void jbPesquisarActionPerformed(java.awt.event.ActionEvent evt) {
        listarCursos(tfPesquisa.getText());
    }

    private void jbListarActionPerformed(java.awt.event.ActionEvent evt) {
        listarCursos();
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
            CursoDao dao = new CursoDao();
            Curso c = new Curso("Dummy", 0);
            c.setId(id);
            c = dao.findOne(c);

            if (c != null) {
                TelaCadastroCurso tela = new TelaCadastroCurso();
                tela.setCurso(c);
                tela.setVisible(true);
                tela.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
                tela.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                        listarCursos();
                    }
                });
            } else {
                JOptionPane.showMessageDialog(this, "Curso não encontrado.");
            }
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
        int confirm = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir o curso " + nome + "?",
                "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                CursoDao dao = new CursoDao();
                Curso c = new Curso(nome, 0);
                c.setId(id);
                dao.delete(c);
                listarCursos();
                JOptionPane.showMessageDialog(this, "Curso excluído com sucesso!");
            } catch (Exception e) {
                if (e.getMessage().contains("constraint") || e.getMessage().contains("foreign key")) {
                    JOptionPane.showMessageDialog(this,
                            "Não é possível excluir este curso pois existem turmas ou matrículas associadas.\nExclua as dependências primeiro.");
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao excluir curso: " + e.getMessage());
                }
            }
        }
    }

    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbVoltar;
    private javax.swing.JButton jbListar;
    private javax.swing.JButton jbPesquisar;
    private javax.swing.JTable tableCursos;
    private javax.swing.JTextField tfPesquisa;
}
