package br.unimontes.ccet.dcc.pg1.view;

import br.unimontes.ccet.dcc.pg1.controller.CursoController;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Curso;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Professor;
import javax.swing.JOptionPane;

public class TelaCadastroCurso extends javax.swing.JFrame {

        private CursoController cursoController;
        private Curso cursoEdicao;
        private Professor coordenadorEdicao;

        public TelaCadastroCurso() {
                cursoController = new CursoController();
                initComponents();
                setLocationRelativeTo(null);
        }

        /**
         * Preenche o formulário com dados do curso para edição.
         * Controller busca o coordenador - View apenas exibe.
         */
        public void setCurso(Curso curso) {
                this.cursoEdicao = curso;
                tfNome.setText(curso.getNome());
                tfCreditos.setText(String.valueOf(curso.getCreditos()));
                jbCadastrar.setText("Salvar Alterações");

                // Controller busca o coordenador
                coordenadorEdicao = cursoController.buscarCoordenadorPorCurso(curso.getId());
                if (coordenadorEdicao != null) {
                        tfCoordenador.setText(coordenadorEdicao.getNome());
                        cbTitulacao.setSelectedItem(coordenadorEdicao.getTitulacao());
                }
        }

        private void initComponents() {

                panelPG11 = new br.unimontes.ccet.dcc.pg1.view.panels.PanelPG1();
                jlNome = new javax.swing.JLabel();
                jlCreditos = new javax.swing.JLabel();
                jlCoordenador = new javax.swing.JLabel();
                jlTitulacao = new javax.swing.JLabel();
                tfNome = new br.unimontes.ccet.dcc.pg1.view.components.TextFieldPG1();
                tfCreditos = new br.unimontes.ccet.dcc.pg1.view.components.TextFieldPG1();
                tfCoordenador = new br.unimontes.ccet.dcc.pg1.view.components.TextFieldPG1();
                cbTitulacao = new javax.swing.JComboBox<>();
                jbCadastrar = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                setTitle("Cadastro Curso");
                setResizable(false);

                jlNome.setText("Nome do Curso");
                jlCreditos.setText("Horas");
                jlCoordenador.setText("Coordenador");
                jlTitulacao.setText("Titulação");

                // Opções de titulação
                cbTitulacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
                                "Doutorado", "Mestrado", "Especialista", "Graduado"
                }));

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
                                                                                                                .addComponent(jlCreditos)
                                                                                                                .addComponent(jlCoordenador)
                                                                                                                .addComponent(jlTitulacao))
                                                                                                .addGap(18, 18, 18)
                                                                                                .addGroup(panelPG11Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(tfNome,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                273,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(tfCreditos,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(tfCoordenador,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(cbTitulacao,
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
                                                                                .addComponent(jlCreditos)
                                                                                .addComponent(tfCreditos,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(panelPG11Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jlCoordenador)
                                                                                .addComponent(tfCoordenador,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(panelPG11Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jlTitulacao)
                                                                                .addComponent(cbTitulacao,
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
         * Processa cadastro/edição de curso.
         * View apenas exibe mensagens - validações e lógica estão no Controller.
         */
        private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
                String nome = tfNome.getText();
                String creditos = tfCreditos.getText();
                String nomeCoordenador = tfCoordenador.getText().trim();
                String titulacao = (String) cbTitulacao.getSelectedItem();

                // Controller faz a validação
                br.unimontes.ccet.dcc.pg1.controller.Response validacao = cursoController.validarCurso(nome, creditos);

                if (!validacao.isSucesso()) {
                        JOptionPane.showMessageDialog(this, validacao.getMensagem());
                        return;
                }

                int creditosInt = Integer.parseInt(creditos);
                Curso curso;
                if (cursoEdicao != null) {
                        curso = new Curso(cursoEdicao.getId(), nome, creditosInt);
                } else {
                        curso = new Curso(nome, creditosInt);
                }

                // Controller retorna Response
                br.unimontes.ccet.dcc.pg1.controller.Response resultado = cursoController.salvar(curso);

                if (resultado.isSucesso()) {
                        // Pegar o curso salvo do Response para ter o ID correto
                        Curso cursoSalvo = resultado.getDadosAs(Curso.class);

                        // Salvar coordenador se informado
                        if (!nomeCoordenador.isEmpty()) {
                                Professor p;
                                if (coordenadorEdicao != null) {
                                        p = new Professor(coordenadorEdicao.getId(), nomeCoordenador, titulacao,
                                                        cursoSalvo != null ? cursoSalvo.getId() : curso.getId());
                                } else {
                                        p = new Professor(0, nomeCoordenador, titulacao,
                                                        cursoSalvo != null ? cursoSalvo.getId() : curso.getId());
                                }
                                cursoController.salvarCoordenador(p);
                        }

                        JOptionPane.showMessageDialog(this, resultado.getMensagem());
                        dispose();
                } else {
                        JOptionPane.showMessageDialog(this, resultado.getMensagem());
                }
        }

        private javax.swing.JButton jbCadastrar;
        private javax.swing.JLabel jlCreditos;
        private javax.swing.JLabel jlNome;
        private javax.swing.JLabel jlCoordenador;
        private javax.swing.JLabel jlTitulacao;
        private br.unimontes.ccet.dcc.pg1.view.panels.PanelPG1 panelPG11;
        private br.unimontes.ccet.dcc.pg1.view.components.TextFieldPG1 tfCreditos;
        private br.unimontes.ccet.dcc.pg1.view.components.TextFieldPG1 tfNome;
        private br.unimontes.ccet.dcc.pg1.view.components.TextFieldPG1 tfCoordenador;
        private javax.swing.JComboBox<String> cbTitulacao;
}
