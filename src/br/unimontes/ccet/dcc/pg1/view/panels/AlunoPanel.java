package br.unimontes.ccet.dcc.pg1.view.panels;

import br.unimontes.ccet.dcc.pg1.controller.AlunoController;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Aluno;
import br.unimontes.ccet.dcc.pg1.view.TelaCadastroAluno;
import br.unimontes.ccet.dcc.pg1.view.components.PlaceholderTextField;
import br.unimontes.ccet.dcc.pg1.view.components.ZebraTableRenderer;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AlunoPanel extends javax.swing.JPanel {

    private AlunoController alunoController;

    public AlunoPanel() {
        alunoController = new AlunoController();
        initComponents();
        listarAlunos();
    }

    private void listarAlunos() {
        listarAlunos(null);
    }

    /**
     * Atualiza a tabela com dados do controller.
     * Panel apenas exibe dados - toda lógica de busca e filtro está no Controller.
     */
    private void listarAlunos(String nomePesquisa) {
        try {
            // Controller retorna dados já formatados e filtrados
            List<Object[]> dados = alunoController.listarAlunosParaTabela(nomePesquisa);

            DefaultTableModel model = (DefaultTableModel) tableAlunos.getModel();
            model.setNumRows(0);

            for (Object[] row : dados) {
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao listar alunos: " + e.getMessage());
        }
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfPesquisa = new PlaceholderTextField("Pesquisar aluno por nome ou matrícula...");
        jbPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAlunos = new javax.swing.JTable();
        jbListar = new javax.swing.JButton();
        jbCadastrar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel1.setText("Gerenciar Alunos");

        jbPesquisar.setText("🔍 Pesquisar");
        jbPesquisar.setToolTipText("Pesquisar alunos por nome ou matrícula");
        jbPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesquisarActionPerformed(evt);
            }
        });
        tfPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    jbPesquisarActionPerformed(null);
                }
            }
        });

        tableAlunos.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {},
                new String[] { "Matrícula", "Nome", "Curso" }) {
            boolean[] canEdit = new boolean[] { false, false, false };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tableAlunos.setAutoCreateRowSorter(true);
        tableAlunos.setDefaultRenderer(Object.class, new ZebraTableRenderer());
        tableAlunos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    jbEditarActionPerformed(null);
                }
            }
        });
        jScrollPane1.setViewportView(tableAlunos);

        jbListar.setText("📋 Listar Todos");
        jbListar.setToolTipText("Exibir todos os alunos cadastrados");
        jbListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbListarActionPerformed(evt);
            }
        });

        jbCadastrar.setText("➕ Cadastrar");
        jbCadastrar.setToolTipText("Cadastrar novo aluno no sistema");
        jbCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarActionPerformed(evt);
            }
        });

        jbEditar.setText("✏️ Editar");
        jbEditar.setToolTipText("Editar aluno selecionado");
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jbExcluir.setText("🗑️ Excluir");
        jbExcluir.setToolTipText("Excluir aluno selecionado");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jbVoltar = new javax.swing.JButton();
        jbVoltar.setText("← Voltar");
        jbVoltar.setToolTipText("Voltar para a tela anterior");
        jbVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                java.awt.Window w = javax.swing.SwingUtilities.getWindowAncestor(AlunoPanel.this);
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
                                                .addComponent(tfPesquisa)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jbPesquisar))
                                        .addGroup(layout.createSequentialGroup()
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
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jbPesquisar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jbListar)
                                        .addComponent(jbCadastrar)
                                        .addComponent(jbEditar)
                                        .addComponent(jbExcluir)
                                        .addComponent(jbVoltar))
                                .addContainerGap()));
    }

    private void jbPesquisarActionPerformed(java.awt.event.ActionEvent evt) {
        listarAlunos(tfPesquisa.getRealText());
    }

    private void jbListarActionPerformed(java.awt.event.ActionEvent evt) {
        tfPesquisa.clear();
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
            int id = (int) tableAlunos.getValueAt(row, 0);
            Aluno a = alunoController.buscarPorId(id);

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

        int id = (int) tableAlunos.getValueAt(row, 0);
        int confirm = JOptionPane.showConfirmDialog(this,
                "Tem certeza que deseja excluir o aluno com Matrícula " + id + "?",
                "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            // Controller retorna Response - View decide como exibir
            br.unimontes.ccet.dcc.pg1.controller.Response resultado = alunoController.excluir(id);
            JOptionPane.showMessageDialog(this, resultado.getMensagem());

            if (resultado.isSucesso()) {
                listarAlunos();
            }
        }
    }

    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbListar;
    private javax.swing.JButton jbPesquisar;
    private javax.swing.JButton jbVoltar;
    private javax.swing.JTable tableAlunos;
    private PlaceholderTextField tfPesquisa;
}
