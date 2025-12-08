package br.unimontes.ccet.dcc.pg1.view.interfaces;

import java.util.Map;

/**
 * Interface que define o contrato para operações de Dashboard.
 * Controllers devem implementar esta interface.
 */
public interface IDashboardController {

    /**
     * Retorna dados básicos para o dashboard (contadores).
     */
    Map<String, Integer> getDadosDashboard();

    /**
     * Retorna dados completos para o dashboard, incluindo valores calculados.
     */
    Map<String, Object> getDadosCompletoDashboard();
}
