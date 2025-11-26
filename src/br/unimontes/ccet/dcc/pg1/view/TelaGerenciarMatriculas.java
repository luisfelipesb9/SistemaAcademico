package br.unimontes.ccet.dcc.pg1.view;

import br.unimontes.ccet.dcc.pg1.model.dao.MatriculaDao;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Matricula;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaGerenciarMatriculas extends javax.swing.JFrame {

    public TelaGerenciarMatriculas() {
        initComponents();
        setLocationRelativeTo(null);
        listarMatriculas();
    }

    private void listarMatriculas() {
        listarMatriculas(null);
    }

    private void listarMatriculas(String nomePesquisa) {
        try {
            MatriculaDao dao = new MatriculaDao();
            List<Matricula> matriculas = dao.findAll();

            br.unimontes.ccet.dcc.pg1.model.dao.AlunoDao aDao = new br.unimontes.ccet.dcc.pg1.model.dao.AlunoDao();
            br.unimontes.ccet.dcc.pg1.model.dao.TurmaDao tDao = new br.unimontes.ccet.dcc.pg1.model.dao.TurmaDao();
            br.unimontes.ccet.dcc.pg1.model.dao.DisciplinaDao dDao = new br.unimontes.ccet.dcc.pg1.model.dao.DisciplinaDao();

            DefaultTableModel model = (DefaultTableModel) tableMatriculas.getModel();
            model.setNumRows(0);

            for (Matricula m : matriculas) {
                br.unimontes.ccet.dcc.pg1.model.dao.entity.Aluno a = new br.unimontes.ccet.dcc.pg1.model.dao.entity.Aluno(
                        m.getCpfAluno(), "Dummy", 2000);
                a = aDao.findOne(a);
                String nomeAluno = (a != null) ? a.getNome() : "CPF: " + m.getCpfAluno();

                br.unimontes.ccet.dcc.pg1.model.dao.entity.Turma t = new br.unimontes.ccet.dcc.pg1.model.dao.entity.Turma();
                t.setId(m.getIdTurma());
                t = tDao.findOne(t);

                String nomeDisciplina = "Turma: " + m.getIdTurma();
                if (t != null) {
                    br.unimontes.ccet.dcc.pg1.model.dao.entity.Disciplina d = new br.unimontes.ccet.dcc.pg1.model.dao.entity.Disciplina(
                            "", 0, 0);
                    d.setId(t.getIdDisciplina());
                    d = dDao.findOne(d);
                    if (d != null)
                        nomeDisciplina = d.getNome();
                }

                if (nomePesquisa != null && !nomePesquisa.isBlank()) {
                    String termo = nomePesquisa.toLowerCase();
                    boolean matches = nomeAluno.toLowerCase().contains(termo) ||
                            nomeDisciplina.toLowerCase().contains(termo) ||
                            String.valueOf(m.getId()).contains(termo);
                    if (!matches)
                        continue;
                }

                model.addRow(new Object[] {
                        m.getId(),
                        nomeAluno,
                        nomeDisciplina,
                        m.getNota(),
                        m.getFrequencia()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao listar matrículas: " + e.getMessage());
        }
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfPesquisa = new javax.swing.JTextField();
        jbPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMatriculas = new javax.swing.JTable();
        jbListar = new javax.swing.JButton();
        jbCadastrar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciar Matrículas");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel1.setText("Gerenciar Matrículas");

        jbPesquisar.setText("Pesquisar");
        jbPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesquisarActionPerformed(evt);
            }
        });

        tableMatriculas.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "Matrícula", "Aluno", "Disciplina", "Nota", "Frequência"
                }) {
            boolean[] canEdit = new boolean[] {
                    false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableMatriculas);

        jbListar.setText("Listar Todos");
        jbListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbListarActionPerformed(evt);
            }
        });

        jbCadastrar.setText("Nova Matrícula");
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
        listarMatriculas(tfPesquisa.getText());
    }

    private void jbListarActionPerformed(java.awt.event.ActionEvent evt) {
        listarMatriculas();
    }

    private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
        TelaCadastroMatricula tela = new TelaCadastroMatricula();
        tela.setVisible(true);
        tela.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        tela.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                listarMatriculas();
            }
        });
    }

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Para editar, exclua e cadastre novamente.");
    }

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        int row = tableMatriculas.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma matrícula para excluir.");
            return;
        }

        int id = (int) tableMatriculas.getValueAt(row, 0);
        int confirm = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir a matrícula ID " + id + "?",
                "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                MatriculaDao dao = new MatriculaDao();
                Matricula m = new Matricula();
                m.setId(id);
                dao.delete(m);
                listarMatriculas();
                JOptionPane.showMessageDialog(this, "Matrícula excluída com sucesso!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao excluir matrícula: " + e.getMessage());
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
    private javax.swing.JTable tableMatriculas;
    private javax.swing.JTextField tfPesquisa;
}
