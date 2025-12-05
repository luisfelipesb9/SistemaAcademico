package br.unimontes.ccet.dcc.pg1.view;

import br.unimontes.ccet.dcc.pg1.controller.AlunoController;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Aluno;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Curso;
import java.util.List;
import javax.swing.JOptionPane;

public class TelaCadastroAluno extends javax.swing.JFrame {

        private AlunoController alunoController;
        private List<Curso> cursosList;
        private int idAluno = 0;

        public TelaCadastroAluno() {
                alunoController = new AlunoController();
                initComponents();
                setLocationRelativeTo(null);
                carregarCursosNoCombo();
        }

        /**
         * Carrega os cursos no combo usando o controller.
         * View apenas popula o combo - lógica de busca está no controller.
         */
        private void carregarCursosNoCombo() {
                try {
                        cursosList = alunoController.listarCursosParaCombo();
                        cbCurso.removeAllItems();
                        for (Curso c : cursosList) {
                                cbCurso.addItem(c);
                        }
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Erro ao carregar cursos: " + e.getMessage());
                }
        }

        /**
         * Preenche o formulário com dados do aluno para edição.
         * Controller determina o índice do curso no combo.
         */
        public void setAluno(Aluno aluno) {
                this.idAluno = aluno.getId();
                tfNome.setText(aluno.getNome());
                tfCpf.setText(aluno.getCpf());
                tfCpf.setEditable(false);
                tfAnoNascimento.setText(String.valueOf(aluno.getAnoNascimento()));

                // Controller retorna o índice correto do curso
                int indiceCurso = alunoController.getIndiceCursoParaAluno(aluno, cursosList);
                if (indiceCurso >= 0) {
                        cbCurso.setSelectedIndex(indiceCurso);
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

        /**
         * Processa cadastro/edição de aluno.
         * View apenas exibe mensagens - validações e lógica estão no Controller.
         */
        private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
                String nome = tfNome.getText();
                String cpf = tfCpf.getText();
                String anoNascimento = tfAnoNascimento.getText();
                Curso curso = (Curso) cbCurso.getSelectedItem();

                // Controller faz a validação
                br.unimontes.ccet.dcc.pg1.controller.Response validacao = alunoController.validarAluno(nome, cpf,
                                anoNascimento, curso);

                if (!validacao.isSucesso()) {
                        JOptionPane.showMessageDialog(this, validacao.getMensagem());
                        return;
                }

                try {
                        // Criar aluno e salvar
                        int ano = Integer.parseInt(anoNascimento);
                        Aluno aluno;
                        if (idAluno > 0) {
                                aluno = new Aluno(idAluno, cpf, nome, ano, curso.getId());
                        } else {
                                aluno = new Aluno(cpf, nome, ano, curso.getId());
                        }

                        // Controller retorna Response - View decide como exibir
                        br.unimontes.ccet.dcc.pg1.controller.Response resultado = alunoController.salvar(aluno);
                        JOptionPane.showMessageDialog(this, resultado.getMensagem());

                        if (resultado.isSucesso()) {
                                dispose();
                        }
                } catch (br.unimontes.ccet.dcc.pg1.model.dao.exception.DAOException e) {
                        JOptionPane.showMessageDialog(this, e.getMessage());
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
