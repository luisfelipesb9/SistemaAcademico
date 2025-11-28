package br.unimontes.ccet.dcc.pg1.view;

import br.unimontes.ccet.dcc.pg1.controller.BoletimController;
import java.awt.Component;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class TelaBoletim extends javax.swing.JFrame {

    private int idAluno;
    private String nomeAluno;

    public TelaBoletim(String idStr, String nome) {
        this.idAluno = Integer.parseInt(idStr);
        this.nomeAluno = nome;
        initComponents();
        setLocationRelativeTo(null);
        lblAluno.setText("Boletim de: " + nomeAluno);
        carregarBoletim();
    }

    private void carregarBoletim() {
        try {
            BoletimController controller = new BoletimController();
            List<Object[]> dados = controller.buscarBoletim(idAluno);

            DefaultTableModel model = (DefaultTableModel) tableBoletim.getModel();
            model.setNumRows(0);

            for (Object[] row : dados) {
                model.addRow(row);
            }

            // Configurar renderizador da barra de progresso para a coluna de Frequência
            // (índice 2)
            tableBoletim.getColumnModel().getColumn(2).setCellRenderer(new ProgressRenderer());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar boletim: " + e.getMessage());
        }
    }

    // Renderizador customizado para JProgressBar na tabela
    class ProgressRenderer extends DefaultTableCellRenderer {
        private final JProgressBar b = new JProgressBar(0, 100);

        public ProgressRenderer() {
            super();
            b.setStringPainted(true); // Mostrar o valor numérico
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            if (value instanceof Integer) {
                int valor = (int) value;
                b.setValue(valor);
                b.setString(valor + "%");

                // Muda a cor dependendo da frequência
                if (valor < 75) {
                    b.setForeground(java.awt.Color.RED);
                } else {
                    b.setForeground(new java.awt.Color(0, 150, 0)); // Verde escuro
                }
                return b;
            }
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblAluno = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBoletim = new javax.swing.JTable();
        jbFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Boletim Escolar");

        lblAluno.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblAluno.setText("Boletim de: Aluno");

        tableBoletim.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "Disciplina", "Nota", "Frequência", "Situação"
                }) {
            boolean[] canEdit = new boolean[] {
                    false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tableBoletim.setRowHeight(25); // Altura maior para caber a barra
        jScrollPane1.setViewportView(tableBoletim);

        jbFechar.setText("Fechar");
        jbFechar.addActionListener(new java.awt.event.ActionListener() {
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
                                                .addComponent(lblAluno)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                jPanel1Layout.createSequentialGroup()
                                                        .addGap(0, 0, Short.MAX_VALUE)
                                                        .addComponent(jbFechar)))
                                .addContainerGap()));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblAluno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbFechar)
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

    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbFechar;
    private javax.swing.JLabel lblAluno;
    private javax.swing.JTable tableBoletim;
}
