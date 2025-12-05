package br.unimontes.ccet.dcc.pg1.view.interfaces;

import br.unimontes.ccet.dcc.pg1.controller.Response;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Curso;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Professor;
import java.util.List;

/**
 * Interface que define o contrato para operações de Curso.
 * Controllers devem implementar esta interface.
 */
public interface ICursoController {

    List<Curso> listarTodos();

    Curso buscarPorId(int id);

    Response salvar(Curso curso);

    Response excluir(int id);

    int count();

    /**
     * Lista cursos formatados para tabela, incluindo coordenador.
     */
    List<Object[]> listarCursosParaTabela(String termoPesquisa);

    /**
     * Busca coordenador de um curso.
     */
    Professor buscarCoordenadorPorCurso(int idCurso);

    /**
     * Salva ou atualiza coordenador.
     */
    Response salvarCoordenador(Professor professor);

    /**
     * Valida dados do curso antes de salvar.
     */
    Response validarCurso(String nome, String creditos);
}
