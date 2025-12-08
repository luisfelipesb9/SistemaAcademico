package br.unimontes.ccet.dcc.pg1.view.interfaces;

import br.unimontes.ccet.dcc.pg1.controller.Response;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Matricula;
import java.util.List;

/**
 * Interface que define o contrato para operações de Matrícula.
 * Controllers devem implementar esta interface.
 */
public interface IMatriculaController {

    List<Matricula> listarTodas();

    Matricula buscarPorId(int id);

    boolean salvar(Matricula matricula);

    Response excluir(int id);

    Response excluirPorAluno(int idAluno);

    int count();

    /**
     * Lista matrículas formatadas para exibição em tabela.
     */
    List<Object[]> listarMatriculasParaTabela(String termoPesquisa);
}
