package br.unimontes.ccet.dcc.pg1.view.panels;

import br.unimontes.ccet.dcc.pg1.controller.MatriculaController;
import br.unimontes.ccet.dcc.pg1.controller.AlunoController;
import br.unimontes.ccet.dcc.pg1.view.components.PlaceholderTextField;
import br.unimontes.ccet.dcc.pg1.view.components.ZebraTableRenderer;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MatriculaPanel extends javax.swing.JPanel {

    private MatriculaController matriculaController;
    private AlunoController alunoController;

    public MatriculaPanel() {
        matriculaController = new MatriculaController();
        alunoController = new AlunoController();
        initComponents();
        listarMatriculas();
    }

    private void listarMatriculas() {
        listarMatriculas(null);
    }

    /**
     * Atualiza a tabela com dados do controller.
     * Panel apenas exibe dados - toda lógica de busca e filtro está no Controller.
     */
    private void listarMatriculas(String termoPesquisa) {
        try {
            // Controller retorna dados já formatados e filtrados
            List<Object[]> dados = matriculaController.listarMatriculasParaTabela(termoPesquisa);

            DefaultTableModel model = (DefaultTableModel) tableMatriculas.getModel();
            model.setNumRows(0);

            for (Object[] row : dados) {
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao listar matrículas: " + e.getMessage());
        }
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfPesquisa = new PlaceholderTextField("Pesquisar por nome, matrícula ou curso...");
        jbPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMatriculas = new javax.swing.JTable();
        jbNovaMatricula = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbAtualizar = new javax.swing.JButton();
        jbVoltar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel1.setText("Gerenciar Matrículas");

        jbPesquisar.setText("🔍 Pesquisar");
        jbPesquisar.setToolTipText("Pesquisar matrículas");
        jbPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesquisarActionPerformed(evt);
            }
        });
        // Enter para pesquisar
        tfPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    jbPesquisarActionPerformed(null);
                }
            }
        });

        tableMatriculas.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {},
                new String[] { "Matrícula", "Nome do Aluno", "Curso" }) {
            boolean[] canEdit = new boolean[] { false, false, false };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tableMatriculas.setAutoCreateRowSorter(true);
        tableMatriculas.setDefaultRenderer(Object.class, new ZebraTableRenderer());
        // Double-click para editar
        tableMatriculas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    jbEditarActionPerformed(null);
                }
            }
        });
        jScrollPane1.setViewportView(tableMatriculas);

        jbNovaMatricula.setText("➕ Nova Matrícula");
        jbNovaMatricula.setToolTipText("Cadastrar um novo aluno com matrícula");
        jbNovaMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovaMatriculaActionPerformed(evt);
            }
        });

        jbExcluir.setText("🗑️ Excluir Selecionada");
        jbExcluir.setToolTipText("Excluir matrícula (remove também o aluno)");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jbAtualizar.setText("📋 Listar Todos");
        jbAtualizar.setToolTipText("Recarregar lista de matrículas");
        jbAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAtualizarActionPerformed(evt);
            }
        });

        jbEditar = new javax.swing.JButton();
        jbEditar.setText("✏️ Editar");
        jbEditar.setToolTipText("Editar dados do aluno selecionado");
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jbVoltar.setText("← Voltar");
        jbVoltar.setToolTipText("Voltar para a tela anterior");
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
                                                .addComponent(tfPesquisa)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jbPesquisar))
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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jbPesquisar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jbNovaMatricula)
                                        .addComponent(jbExcluir)
                                        .addComponent(jbEditar)
                                        .addComponent(jbAtualizar)
                                        .addComponent(jbVoltar))
                                .addContainerGap()));
    }

    private void jbPesquisarActionPerformed(java.awt.event.ActionEvent evt) {
        listarMatriculas(tfPesquisa.getRealText());
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

        int idAluno = (int) tableMatriculas.getValueAt(row, 0);
        String nomeAluno = (String) tableMatriculas.getValueAt(row, 1);

        int confirm = JOptionPane.showConfirmDialog(this,
                "Deseja excluir a matrícula do aluno " + nomeAluno
                        + "?\n\nATENÇÃO: O aluno também será removido do sistema!",
                "Confirmar Exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (confirm == JOptionPane.YES_OPTION) {
            if (matriculaController.excluirPorAluno(idAluno)) {
                listarMatriculas();
                JOptionPane.showMessageDialog(this, "Matrícula e aluno excluídos com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao excluir matrícula.");
            }
        }
    }

    private void jbAtualizarActionPerformed(java.awt.event.ActionEvent evt) {
        tfPesquisa.clear();
        listarMatriculas();
    }

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

    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAtualizar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbNovaMatricula;
    private javax.swing.JButton jbPesquisar;
    private javax.swing.JButton jbVoltar;
    private javax.swing.JTable tableMatriculas;
    private PlaceholderTextField tfPesquisa;
}
