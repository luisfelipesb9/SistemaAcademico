package br.unimontes.ccet.dcc.pg1.view;

import br.unimontes.ccet.dcc.pg1.controller.LancarNotasController;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Matricula;
import javax.swing.JOptionPane;

public class TelaLancarNotas extends javax.swing.JDialog {

    private Matricula matricula;
    private boolean salvo = false;

    public TelaLancarNotas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
    }

    public void setMatricula(Matricula m, String nomeAluno, String nomeDisciplina) {
        this.matricula = m;
        lblAluno.setText(nomeAluno);
        lblDisciplina.setText(nomeDisciplina);
        tfNota.setText(String.valueOf(m.getNota()));
        tfFrequencia.setText(String.valueOf(m.getFrequencia()));
    }

    public boolean isSalvo() {
        return salvo;
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblAluno = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblDisciplina = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfNota = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfFrequencia = new javax.swing.JTextField();
        jbSalvar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lançamento de Notas");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Lançar Notas e Frequência");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Aluno:");

        lblAluno.setText("Nome do Aluno");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Disciplina:");

        lblDisciplina.setText("Nome da Disciplina");

        jLabel6.setText("Nota (0-100):");

        jLabel7.setText("Frequência (%):");

        jbSalvar.setText("Salvar");
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
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
                                        .addComponent(jLabel1)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel2))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblAluno)
                                                        .addComponent(lblDisciplina)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel7)
                                                        .addComponent(jLabel6))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(tfNota, javax.swing.GroupLayout.DEFAULT_SIZE, 100,
                                                                Short.MAX_VALUE)
                                                        .addComponent(tfFrequencia)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jbSalvar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jbCancelar)))
                                .addContainerGap(134, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(lblAluno))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(lblDisciplina))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(tfNota, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(tfFrequencia, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38,
                                        Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jbSalvar)
                                        .addComponent(jbCancelar))
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

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            double nota = Double.parseDouble(tfNota.getText().replace(",", "."));
            int frequencia = Integer.parseInt(tfFrequencia.getText());

            matricula.setNota(nota);
            matricula.setFrequencia(frequencia);

            LancarNotasController controller = new LancarNotasController();
            if (controller.salvar(matricula)) {
                salvo = true;
                JOptionPane.showMessageDialog(this, "Notas lançadas com sucesso!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao lançar notas.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Digite valores numéricos válidos.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
    }

    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JLabel lblAluno;
    private javax.swing.JLabel lblDisciplina;
    private javax.swing.JTextField tfFrequencia;
    private javax.swing.JTextField tfNota;
}
