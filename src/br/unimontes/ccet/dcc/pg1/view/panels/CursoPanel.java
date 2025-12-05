package br.unimontes.ccet.dcc.pg1.view.panels;

import br.unimontes.ccet.dcc.pg1.controller.CursoController;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Curso;
import br.unimontes.ccet.dcc.pg1.view.TelaCadastroCurso;
import br.unimontes.ccet.dcc.pg1.view.components.PlaceholderTextField;
import br.unimontes.ccet.dcc.pg1.view.components.ZebraTableRenderer;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CursoPanel extends javax.swing.JPanel {

    private CursoController cursoController;

    public CursoPanel() {
        cursoController = new CursoController();
        initComponents();
        listarCursos();
    }

    private void listarCursos() {
        listarCursos(null);
    }

    /**
     * Atualiza a tabela com dados do controller.
     * Panel apenas exibe dados - toda lógica de busca e filtro está no Controller.
     */
    private void listarCursos(String termoPesquisa) {
        try {
            // Controller retorna dados já formatados e filtrados (incluindo coordenador)
            List<Object[]> dados = cursoController.listarCursosParaTabela(termoPesquisa);

            DefaultTableModel model = (DefaultTableModel) tableCursos.getModel();
            model.setNumRows(0);

            for (Object[] row : dados) {
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao listar cursos: " + e.getMessage());
        }
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfPesquisa = new PlaceholderTextField("Pesquisar curso, ID ou coordenador...");
        jbPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCursos = new javax.swing.JTable();
        jbCadastrar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbAtualizar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbVoltar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel1.setText("Gerenciar Cursos");

        jbPesquisar.setText("🔍 Pesquisar");
        jbPesquisar.setToolTipText("Pesquisar cursos por nome, ID ou coordenador");
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

        tableCursos.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {},
                new String[] { "ID", "Nome", "Horas", "Coordenador" }) {
            boolean[] canEdit = new boolean[] { false, false, false, false };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tableCursos.setAutoCreateRowSorter(true);
        tableCursos.setDefaultRenderer(Object.class, new ZebraTableRenderer());
        // Double-click para editar
        tableCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    jbEditarActionPerformed(null);
                }
            }
        });
        jScrollPane1.setViewportView(tableCursos);

        jbCadastrar.setText("➕ Cadastrar Novo Curso");
        jbCadastrar.setToolTipText("Cadastrar um novo curso no sistema");
        jbCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarActionPerformed(evt);
            }
        });

        jbExcluir.setText("🗑️ Excluir Selecionado");
        jbExcluir.setToolTipText("Excluir curso selecionado (somente se não houver alunos)");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jbEditar.setText("✏️ Editar Curso");
        jbEditar.setToolTipText("Editar dados do curso selecionado");
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jbAtualizar.setText("📋 Listar Todos");
        jbAtualizar.setToolTipText("Recarregar lista de cursos");
        jbAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAtualizarActionPerformed(evt);
            }
        });

        jbVoltar.setText("← Voltar");
        jbVoltar.setToolTipText("Voltar para a tela anterior");
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
                                                .addComponent(tfPesquisa)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jbPesquisar))
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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jbPesquisar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jbCadastrar)
                                        .addComponent(jbEditar)
                                        .addComponent(jbExcluir)
                                        .addComponent(jbAtualizar)
                                        .addComponent(jbVoltar))
                                .addContainerGap()));
    }

    private void jbPesquisarActionPerformed(java.awt.event.ActionEvent evt) {
        listarCursos(tfPesquisa.getRealText());
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
                "Deseja excluir o curso " + nome + "?",
                "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            // Controller retorna Response - View decide como exibir
            br.unimontes.ccet.dcc.pg1.controller.Response resultado = cursoController.excluir(id);
            JOptionPane.showMessageDialog(this, resultado.getMensagem());

            if (resultado.isSucesso()) {
                listarCursos();
            }
        }
    }

    private void jbAtualizarActionPerformed(java.awt.event.ActionEvent evt) {
        tfPesquisa.clear();
        listarCursos();
    }

    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAtualizar;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbPesquisar;
    private javax.swing.JButton jbVoltar;
    private javax.swing.JTable tableCursos;
    private PlaceholderTextField tfPesquisa;
}
