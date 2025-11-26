package br.unimontes.ccet.dcc.pg1.view;

import br.unimontes.ccet.dcc.pg1.model.dao.AlunoDao;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Aluno;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaGerenciarAlunos extends javax.swing.JFrame {

    public TelaGerenciarAlunos() {
        initComponents();
        setLocationRelativeTo(null);
        listarAlunos();
    }

    private void listarAlunos() {
        listarAlunos(null);
    }

    private void listarAlunos(String nomePesquisa) {
        try {
            AlunoDao alunoDao = new AlunoDao();
            List<Aluno> alunos = alunoDao.findAll();
            DefaultTableModel model = (DefaultTableModel) tableAlunos.getModel();
            model.setNumRows(0);

            for (Aluno a : alunos) {
                if (nomePesquisa != null && !nomePesquisa.isBlank()) {
                    String termo = nomePesquisa.toLowerCase();
                    boolean matches = a.getNome().toLowerCase().contains(termo) ||
                            a.getCpf().contains(termo) ||
                            String.valueOf(a.getAnoNascimento()).contains(termo);
                    if (!matches) {
                        continue;
                    }
                }
                model.addRow(new Object[] {
                        a.getCpf(),
                        a.getNome(),
                        a.getAnoNascimento()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao listar alunos: " + e.getMessage());
        }
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfPesquisa = new javax.swing.JTextField();
        jbPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAlunos = new javax.swing.JTable();
        jbListar = new javax.swing.JButton();
        jbCadastrar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciar Alunos");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel1.setText("Gerenciar Alunos");

        jbPesquisar.setText("Pesquisar");
        jbPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesquisarActionPerformed(evt);
            }
        });

        tableAlunos.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "CPF", "Nome", "Ano Nascimento"
                }) {
            boolean[] canEdit = new boolean[] {
                    false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableAlunos);

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
        listarAlunos(tfPesquisa.getText());
    }

    private void jbListarActionPerformed(java.awt.event.ActionEvent evt) {
        listarAlunos();
    }

    private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
        TelaCadastroAluno tela = new TelaCadastroAluno();
        tela.setVisible(true);
        tela.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        tela.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                listarAlunos();
            }
        });
    }

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {
        int row = tableAlunos.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um aluno para editar.");
            return;
        }

        try {
            String cpf = (String) tableAlunos.getValueAt(row, 0);
            AlunoDao dao = new AlunoDao();
            Aluno a = new Aluno(cpf, "Dummy Name", 2000);
            a = dao.findOne(a);

            if (a != null) {
                TelaCadastroAluno tela = new TelaCadastroAluno();
                tela.setAluno(a);
                tela.setVisible(true);
                tela.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
                tela.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                        listarAlunos();
                    }
                });
            } else {
                JOptionPane.showMessageDialog(this, "Aluno não encontrado.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar aluno para edição: " + e.getMessage());
        }
    }

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        int row = tableAlunos.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um aluno para excluir.");
            return;
        }

        String cpf = (String) tableAlunos.getValueAt(row, 0);
        int confirm = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir o aluno com CPF " + cpf + "?",
                "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                AlunoDao dao = new AlunoDao();
                Aluno a = new Aluno(cpf, "Dummy", 2000);
                dao.delete(a);
                listarAlunos();
                JOptionPane.showMessageDialog(this, "Aluno excluído com sucesso!");
            } catch (Exception e) {
                if (e.getMessage().contains("constraint") || e.getMessage().contains("foreign key")) {
                    JOptionPane.showMessageDialog(this,
                            "Não é possível excluir este aluno pois ele possui matrículas.\nExclua as matrículas primeiro.");
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao excluir aluno: " + e.getMessage());
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
    private javax.swing.JTable tableAlunos;
    private javax.swing.JTextField tfPesquisa;
}
