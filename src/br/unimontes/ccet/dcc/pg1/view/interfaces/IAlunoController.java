package br.unimontes.ccet.dcc.pg1.view.interfaces;

import br.unimontes.ccet.dcc.pg1.controller.Response;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Aluno;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Curso;
import java.util.List;

/**
 * Interface que define o contrato para operações de Aluno.
 * Controllers devem implementar esta interface.
 */
public interface IAlunoController {

    List<Aluno> listarTodos();

    Aluno buscarPorId(int id);

    Response salvar(Aluno aluno);

    Response excluir(int id);

    int count();

    /**
     * Lista alunos formatados para exibição em tabela.
     */
    List<Object[]> listarAlunosParaTabela(String termoPesquisa);

    /**
     * Lista cursos para combo de seleção.
     */
    List<Curso> listarCursosParaCombo();

    /**
     * Retorna índice do curso do aluno no combo.
     */
    int getIndiceCursoParaAluno(Aluno aluno, List<Curso> cursos);

    /**
     * Valida dados do aluno antes de salvar.
     */
    Response validarAluno(String nome, String cpf, String anoNascimento, Curso curso);
}
