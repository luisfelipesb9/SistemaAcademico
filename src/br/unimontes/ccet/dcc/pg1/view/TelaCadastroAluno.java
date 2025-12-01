package br.unimontes.ccet.dcc.pg1.view;

import br.unimontes.ccet.dcc.pg1.controller.AlunoController;
import br.unimontes.ccet.dcc.pg1.controller.CursoController;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Aluno;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Curso;
import java.util.List;
import javax.swing.JOptionPane;

public class TelaCadastroAluno extends javax.swing.JFrame {

        private AlunoController alunoController;
        private CursoController cursoController;
        private int idAluno = 0;

        public TelaCadastroAluno() {
                alunoController = new AlunoController();
                cursoController = new CursoController();
                initComponents();
                setLocationRelativeTo(null);
                carregarCursos();
        }

        private void carregarCursos() {
                try {
                        List<Curso> cursos = cursoController.listarTodos();
                        cbCurso.removeAllItems();
                        for (Curso c : cursos) {
                                cbCurso.addItem(c);
                        }
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Erro ao carregar cursos: " + e.getMessage());
                }
        }

        public void setAluno(Aluno aluno) {
                this.idAluno = aluno.getId();
                tfNome.setText(aluno.getNome());
                tfCpf.setText(aluno.getCpf());
                tfCpf.setEditable(false);
                tfAnoNascimento.setText(String.valueOf(aluno.getAnoNascimento()));

                for (int i = 0; i < cbCurso.getItemCount(); i++) {
                        Curso c = cbCurso.getItemAt(i);
                        if (c.getId() == aluno.getIdCurso()) {
                                cbCurso.setSelectedIndex(i);
                                break;
                        }
                }

                jbCadastrar.setText("Salvar Alterações");
        }

        private void initComponents() {

                panelPG11 = new br.unimontes.ccet.dcc.pg1.view.panels.PanelPG1();
                jlNome = new javax.swing.JLabel();
                jlCpf = new javax.swing.JLabel();
                jlAnoNascimento = new javax.swing.JLabel();
                jlCurso = new javax.swing.JLabel();
                tfNome = new br.unimontes.ccet.dcc.pg1.view.components.TextFieldPG1();
                tfCpf = new br.unimontes.ccet.dcc.pg1.view.components.TextFieldPG1();
                tfAnoNascimento = new br.unimontes.ccet.dcc.pg1.view.components.TextFieldPG1();
                cbCurso = new javax.swing.JComboBox<>();
                jbCadastrar = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                setTitle("Cadastro Aluno");
                setResizable(false);

                jlNome.setText("Nome");
                jlCpf.setText("CPF");
                jlAnoNascimento.setText("Ano de Nascimento");
                jlCurso.setText("Curso");

                jbCadastrar.setText("Cadastrar");
                jbCadastrar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jbCadastrarActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout panelPG11Layout = new javax.swing.GroupLayout(panelPG11);
                panelPG11.setLayout(panelPG11Layout);
                panelPG11Layout.setHorizontalGroup(
                                panelPG11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(panelPG11Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(panelPG11Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(panelPG11Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(panelPG11Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jlNome)
                                                                                                                .addComponent(jlCpf)
                                                                                                                .addComponent(jlAnoNascimento)
                                                                                                                .addComponent(jlCurso))
                                                                                                .addGap(18, 18, 18)
                                                                                                .addGroup(panelPG11Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(tfNome,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                273,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(tfCpf,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(tfAnoNascimento,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(cbCurso,
                                                                                                                                0,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)))
                                                                                .addGroup(panelPG11Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jbCadastrar)
                                                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                                .addContainerGap()));
                panelPG11Layout.setVerticalGroup(
                                panelPG11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(panelPG11Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(panelPG11Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jlNome)
                                                                                .addComponent(tfNome,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(panelPG11Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jlCpf)
                                                                                .addComponent(tfCpf,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(panelPG11Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jlAnoNascimento)
                                                                                .addComponent(tfAnoNascimento,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(panelPG11Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jlCurso)
                                                                                .addComponent(cbCurso,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jbCadastrar)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(panelPG11, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(panelPG11, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

                pack();
        }

        private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
                try {
                        String nome = tfNome.getText();
                        if (nome.matches(".*\\d.*")) {
                                JOptionPane.showMessageDialog(this, "O nome não pode conter números.");
                                return;
                        }
                        String cpf = tfCpf.getText();
                        int ano = Integer.parseInt(tfAnoNascimento.getText());
                        Curso curso = (Curso) cbCurso.getSelectedItem();

                        if (curso == null) {
                                JOptionPane.showMessageDialog(this, "Selecione um curso.");
                                return;
                        }

                        Aluno aluno;
                        if (idAluno > 0) {
                                aluno = new Aluno(idAluno, cpf, nome, ano, curso.getId());
                        } else {
                                aluno = new Aluno(cpf, nome, ano, curso.getId());
                        }

                        if (alunoController.salvar(aluno)) {
                                String msg = (idAluno > 0) ? "Aluno editado com sucesso!" : "Aluno salvo com sucesso!";
                                JOptionPane.showMessageDialog(this, msg);
                                dispose();
                        } else {
                                JOptionPane.showMessageDialog(this, "Erro ao salvar aluno.");
                        }
                } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Ano de nascimento inválido.");
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
                }
        }

        private javax.swing.JButton jbCadastrar;
        private javax.swing.JLabel jlAnoNascimento;
        private javax.swing.JLabel jlCpf;
        private javax.swing.JLabel jlNome;
        private javax.swing.JLabel jlCurso;
        private br.unimontes.ccet.dcc.pg1.view.panels.PanelPG1 panelPG11;
        private br.unimontes.ccet.dcc.pg1.view.components.TextFieldPG1 tfAnoNascimento;
        private br.unimontes.ccet.dcc.pg1.view.components.TextFieldPG1 tfCpf;
        private br.unimontes.ccet.dcc.pg1.view.components.TextFieldPG1 tfNome;
        private javax.swing.JComboBox<Curso> cbCurso;
}
