package br.unimontes.ccet.dcc.pg1.view;

import br.unimontes.ccet.dcc.pg1.controller.DashboardController;
import java.util.Map;
import javax.swing.JOptionPane;

public class TelaDashboard extends javax.swing.JFrame {

        private DashboardController controller;

        public TelaDashboard() {
                controller = new DashboardController();
                initComponents();
                setLocationRelativeTo(null);
                atualizarDados();
        }

        /**
         * Atualiza os componentes visuais com dados do controller.
         * View apenas exibe dados - toda lógica está no Controller.
         */
        private void atualizarDados() {
                try {
                        Map<String, Object> dados = controller.getDadosCompletoDashboard();

                        // Atualizar labels (apenas exibição)
                        lblValorAlunos.setText(String.valueOf(dados.get("totalAlunos")));
                        lblValorCursos.setText(String.valueOf(dados.get("totalCursos")));
                        lblValorMatriculas.setText(String.valueOf(dados.get("totalMatriculas")));

                        // Atualizar progress bars (valores já calculados pelo controller)
                        pbAlunos.setValue((int) dados.get("pbAlunos"));
                        pbCursos.setValue((int) dados.get("pbCursos"));
                        pbMatriculas.setValue((int) dados.get("pbMatriculas"));

                } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, "Erro ao carregar dados do dashboard: " + ex.getMessage());
                }
        }

        private void initComponents() {

                jPanelHeader = new javax.swing.JPanel();
                jLabelTitulo = new javax.swing.JLabel();
                jPanelContainer = new javax.swing.JPanel();
                panelAlunos = new javax.swing.JPanel();
                jLabelAlunos = new javax.swing.JLabel();
                lblValorAlunos = new javax.swing.JLabel();
                pbAlunos = new javax.swing.JProgressBar();
                panelCursos = new javax.swing.JPanel();
                jLabelCursos = new javax.swing.JLabel();
                lblValorCursos = new javax.swing.JLabel();
                pbCursos = new javax.swing.JProgressBar();
                panelMatriculas = new javax.swing.JPanel();
                jLabelMatriculas = new javax.swing.JLabel();
                lblValorMatriculas = new javax.swing.JLabel();
                pbMatriculas = new javax.swing.JProgressBar();
                jbAtualizar = new javax.swing.JButton();
                jbFechar = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                setTitle("Dashboard - RenêLabs");

                jPanelHeader.setBackground(new java.awt.Color(0, 102, 204));

                jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24));
                jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
                jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabelTitulo.setText("Dashboard Acadêmico");

                javax.swing.GroupLayout jPanelHeaderLayout = new javax.swing.GroupLayout(jPanelHeader);
                jPanelHeader.setLayout(jPanelHeaderLayout);
                jPanelHeaderLayout.setHorizontalGroup(
                                jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanelHeaderLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jLabelTitulo,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addContainerGap()));
                jPanelHeaderLayout.setVerticalGroup(
                                jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanelHeaderLayout.createSequentialGroup()
                                                                .addGap(20, 20, 20)
                                                                .addComponent(jLabelTitulo)
                                                                .addContainerGap(20, Short.MAX_VALUE)));

                panelAlunos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
                panelAlunos.setBackground(new java.awt.Color(240, 248, 255));

                jLabelAlunos.setFont(new java.awt.Font("Segoe UI", 1, 18));
                jLabelAlunos.setForeground(new java.awt.Color(0, 51, 102));
                jLabelAlunos.setText("Total de Alunos");

                lblValorAlunos.setFont(new java.awt.Font("Segoe UI", 1, 36));
                lblValorAlunos.setForeground(new java.awt.Color(0, 102, 204));
                lblValorAlunos.setText("0");

                pbAlunos.setForeground(new java.awt.Color(0, 102, 204));

                javax.swing.GroupLayout panelAlunosLayout = new javax.swing.GroupLayout(panelAlunos);
                panelAlunos.setLayout(panelAlunosLayout);
                panelAlunosLayout.setHorizontalGroup(
                                panelAlunosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(panelAlunosLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(panelAlunosLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(pbAlunos,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addGroup(panelAlunosLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(panelAlunosLayout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jLabelAlunos)
                                                                                                                .addComponent(lblValorAlunos))
                                                                                                .addGap(0, 108, Short.MAX_VALUE)))
                                                                .addContainerGap()));
                panelAlunosLayout.setVerticalGroup(
                                panelAlunosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(panelAlunosLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jLabelAlunos)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(lblValorAlunos)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                28,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(pbAlunos,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                10,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap()));

                panelCursos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
                panelCursos.setBackground(new java.awt.Color(240, 255, 240));

                jLabelCursos.setFont(new java.awt.Font("Segoe UI", 1, 18));
                jLabelCursos.setForeground(new java.awt.Color(0, 102, 51));
                jLabelCursos.setText("Cursos Ativos");

                lblValorCursos.setFont(new java.awt.Font("Segoe UI", 1, 36));
                lblValorCursos.setForeground(new java.awt.Color(0, 153, 51));
                lblValorCursos.setText("0");

                pbCursos.setForeground(new java.awt.Color(0, 153, 51));

                javax.swing.GroupLayout panelCursosLayout = new javax.swing.GroupLayout(panelCursos);
                panelCursos.setLayout(panelCursosLayout);
                panelCursosLayout.setHorizontalGroup(
                                panelCursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(panelCursosLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(panelCursosLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(pbCursos,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addGroup(panelCursosLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(panelCursosLayout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jLabelCursos)
                                                                                                                .addComponent(lblValorCursos))
                                                                                                .addGap(0, 122, Short.MAX_VALUE)))
                                                                .addContainerGap()));
                panelCursosLayout.setVerticalGroup(
                                panelCursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(panelCursosLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jLabelCursos)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(lblValorCursos)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(pbCursos,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                10,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap()));

                panelMatriculas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
                panelMatriculas.setBackground(new java.awt.Color(255, 245, 240));

                jLabelMatriculas.setFont(new java.awt.Font("Segoe UI", 1, 18));
                jLabelMatriculas.setForeground(new java.awt.Color(153, 51, 0));
                jLabelMatriculas.setText("Total Matrículas");

                lblValorMatriculas.setFont(new java.awt.Font("Segoe UI", 1, 36));
                lblValorMatriculas.setForeground(new java.awt.Color(204, 51, 0));
                lblValorMatriculas.setText("0");

                pbMatriculas.setForeground(new java.awt.Color(204, 51, 0));

                javax.swing.GroupLayout panelMatriculasLayout = new javax.swing.GroupLayout(panelMatriculas);
                panelMatriculas.setLayout(panelMatriculasLayout);
                panelMatriculasLayout.setHorizontalGroup(
                                panelMatriculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(panelMatriculasLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(panelMatriculasLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(pbMatriculas,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addGroup(panelMatriculasLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(panelMatriculasLayout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jLabelMatriculas)
                                                                                                                .addComponent(lblValorMatriculas))
                                                                                                .addGap(0, 105, Short.MAX_VALUE)))
                                                                .addContainerGap()));
                panelMatriculasLayout.setVerticalGroup(
                                panelMatriculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(panelMatriculasLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jLabelMatriculas)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(lblValorMatriculas)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(pbMatriculas,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                10,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap()));

                jbAtualizar.setFont(new java.awt.Font("Segoe UI", 0, 14));
                jbAtualizar.setText("Atualizar Dados");
                jbAtualizar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                atualizarDados();
                        }
                });

                jbFechar.setFont(new java.awt.Font("Segoe UI", 0, 14));
                jbFechar.setText("Fechar");
                jbFechar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                dispose();
                        }
                });

                javax.swing.GroupLayout jPanelContainerLayout = new javax.swing.GroupLayout(jPanelContainer);
                jPanelContainer.setLayout(jPanelContainerLayout);
                jPanelContainerLayout.setHorizontalGroup(
                                jPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanelContainerLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanelContainerLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanelContainerLayout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(panelAlunos,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(panelCursos,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(panelMatriculas,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                jPanelContainerLayout
                                                                                                                .createSequentialGroup()
                                                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                                                .addComponent(jbAtualizar)
                                                                                                                .addGap(18, 18, 18)
                                                                                                                .addComponent(jbFechar)))
                                                                .addContainerGap()));
                jPanelContainerLayout.setVerticalGroup(
                                jPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanelContainerLayout.createSequentialGroup()
                                                                .addGap(20, 20, 20)
                                                                .addGroup(jPanelContainerLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                false)
                                                                                .addComponent(panelAlunos,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(panelCursos,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(panelMatriculas,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                30,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(jPanelContainerLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jbAtualizar)
                                                                                .addComponent(jbFechar))
                                                                .addContainerGap()));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanelHeader, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jPanelContainer, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jPanelHeader,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jPanelContainer,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                pack();
        }

        private javax.swing.JLabel jLabelAlunos;
        private javax.swing.JLabel jLabelCursos;
        private javax.swing.JLabel jLabelMatriculas;
        private javax.swing.JLabel jLabelTitulo;
        private javax.swing.JPanel jPanelContainer;
        private javax.swing.JPanel jPanelHeader;
        private javax.swing.JButton jbAtualizar;
        private javax.swing.JButton jbFechar;
        private javax.swing.JLabel lblValorAlunos;
        private javax.swing.JLabel lblValorCursos;
        private javax.swing.JLabel lblValorMatriculas;
        private javax.swing.JPanel panelAlunos;
        private javax.swing.JPanel panelCursos;
        private javax.swing.JPanel panelMatriculas;
        private javax.swing.JProgressBar pbAlunos;
        private javax.swing.JProgressBar pbCursos;
        private javax.swing.JProgressBar pbMatriculas;
}
