package br.unimontes.ccet.dcc.pg1.view;

public class TelaPrincipal extends javax.swing.JFrame {

    public TelaPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        refreshDashboard();
    }

    public void refreshDashboard() {
        try {
            br.unimontes.ccet.dcc.pg1.controller.DashboardController controller = new br.unimontes.ccet.dcc.pg1.controller.DashboardController();
            java.util.Map<String, Integer> dados = controller.getDadosDashboard();

            lblTotalAlunos.setText("Total Alunos: " + dados.get("alunos"));
            lblTotalCursos.setText("Cursos Ativos: " + dados.get("cursos"));
            lblTotalMatriculas.setText("Matrículas: " + dados.get("matriculas"));

        } catch (Exception e) {
            // Silently fail or log if needed, but don't popup on every refresh if DB is
            // empty/initing
            System.err.println("Erro ao atualizar dashboard: " + e.getMessage());
        }
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelDashboard = new javax.swing.JPanel();
        lblTotalAlunos = new javax.swing.JLabel();
        lblTotalCursos = new javax.swing.JLabel();
        lblTotalMatriculas = new javax.swing.JLabel();
        jbAlunos = new javax.swing.JButton();
        jbCursos = new javax.swing.JButton();
        jbMatriculas = new javax.swing.JButton();
        jbDashboard = new javax.swing.JButton();
        jbSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Acadêmico - PG1");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sistema Acadêmico");

        jPanelDashboard.setBorder(javax.swing.BorderFactory.createTitledBorder("Dashboard"));

        lblTotalAlunos.setFont(new java.awt.Font("Segoe UI", 1, 14));
        lblTotalAlunos.setText("Total Alunos: 0");

        lblTotalCursos.setFont(new java.awt.Font("Segoe UI", 1, 14));
        lblTotalCursos.setText("Cursos Ativos: 0");

        lblTotalMatriculas.setFont(new java.awt.Font("Segoe UI", 1, 14));
        lblTotalMatriculas.setText("Matrículas: 0");

        javax.swing.GroupLayout jPanelDashboardLayout = new javax.swing.GroupLayout(jPanelDashboard);
        jPanelDashboard.setLayout(jPanelDashboardLayout);
        jPanelDashboardLayout.setHorizontalGroup(
                jPanelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelDashboardLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblTotalAlunos)
                                .addGap(18, 18, 18)
                                .addComponent(lblTotalCursos)
                                .addGap(18, 18, 18)
                                .addComponent(lblTotalMatriculas)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jPanelDashboardLayout.setVerticalGroup(
                jPanelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelDashboardLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelDashboardLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblTotalAlunos)
                                        .addComponent(lblTotalCursos)
                                        .addComponent(lblTotalMatriculas))
                                .addContainerGap(16, Short.MAX_VALUE)));

        jbAlunos.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jbAlunos.setText("Alunos");
        jbAlunos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlunosActionPerformed(evt);
            }
        });

        jbCursos.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jbCursos.setText("Cursos");
        jbCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCursosActionPerformed(evt);
            }
        });

        jbMatriculas.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jbMatriculas.setText("Matrículas");
        jbMatriculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMatriculasActionPerformed(evt);
            }
        });

        jbDashboard.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jbDashboard.setText("Dashboard");
        jbDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDashboardActionPerformed(evt);
            }
        });

        jbSair.setText("Sair");
        jbSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 388,
                                                Short.MAX_VALUE)
                                        .addComponent(jPanelDashboard, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jbAlunos, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jbCursos, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jbMatriculas, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jbDashboard, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                jPanel1Layout.createSequentialGroup()
                                                        .addGap(0, 0, Short.MAX_VALUE)
                                                        .addComponent(jbSair)))
                                .addContainerGap()));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanelDashboard, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, 45,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 45,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbMatriculas, javax.swing.GroupLayout.PREFERRED_SIZE, 45,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 45,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35,
                                        Short.MAX_VALUE)
                                .addComponent(jbSair)
                                .addContainerGap()));

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

    private void jbAlunosActionPerformed(java.awt.event.ActionEvent evt) {
        TelaGerenciarAlunos tela = new TelaGerenciarAlunos();
        tela.setVisible(true);
        tela.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                refreshDashboard();
            }
        });
    }

    private void jbCursosActionPerformed(java.awt.event.ActionEvent evt) {
        TelaGerenciarCursos tela = new TelaGerenciarCursos();
        tela.setVisible(true);
        tela.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                refreshDashboard();
            }
        });
    }

    private void jbMatriculasActionPerformed(java.awt.event.ActionEvent evt) {
        TelaGerenciarMatriculas tela = new TelaGerenciarMatriculas();
        tela.setVisible(true);
        tela.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                refreshDashboard();
            }
        });
    }

    private void jbDashboardActionPerformed(java.awt.event.ActionEvent evt) {
        TelaDashboard tela = new TelaDashboard();
        tela.setVisible(true);
    }

    private void jbSairActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.put("nimbusBase", new java.awt.Color(51, 102, 255));
                    javax.swing.UIManager.put("nimbusBlueGrey", new java.awt.Color(190, 210, 240));
                    javax.swing.UIManager.put("control", new java.awt.Color(240, 245, 255));
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelDashboard;
    private javax.swing.JButton jbAlunos;
    private javax.swing.JButton jbCursos;
    private javax.swing.JButton jbMatriculas;
    private javax.swing.JButton jbDashboard;
    private javax.swing.JButton jbSair;
    private javax.swing.JLabel lblTotalAlunos;
    private javax.swing.JLabel lblTotalCursos;
    private javax.swing.JLabel lblTotalMatriculas;
}
