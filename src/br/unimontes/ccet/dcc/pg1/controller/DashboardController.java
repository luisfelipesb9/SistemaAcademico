package br.unimontes.ccet.dcc.pg1.controller;

import br.unimontes.ccet.dcc.pg1.view.interfaces.IDashboardController;
import java.util.HashMap;
import java.util.Map;

public class DashboardController implements IDashboardController {

    @Override
    public Map<String, Integer> getDadosDashboard() {
        Map<String, Integer> dados = new HashMap<>();

        AlunoController alunoController = new AlunoController();
        CursoController cursoController = new CursoController();
        MatriculaController matriculaController = new MatriculaController();

        dados.put("alunos", alunoController.count());
        dados.put("cursos", cursoController.count());
        dados.put("matriculas", matriculaController.count());

        return dados;
    }

    /**
     * Retorna dados completos para o dashboard, incluindo valores do progress bar.
     * Move a lógica de cálculo que antes estava na View.
     */
    @Override
    public Map<String, Object> getDadosCompletoDashboard() {
        Map<String, Object> dados = new HashMap<>();

        AlunoController alunoController = new AlunoController();
        CursoController cursoController = new CursoController();
        MatriculaController matriculaController = new MatriculaController();

        int totalAlunos = alunoController.count();
        int totalCursos = cursoController.count();
        int totalMatriculas = matriculaController.count();

        // Valores para labels
        dados.put("totalAlunos", totalAlunos);
        dados.put("totalCursos", totalCursos);
        dados.put("totalMatriculas", totalMatriculas);

        // Valores calculados para progress bars (lógica movida da View)
        dados.put("pbAlunos", Math.min(totalAlunos * 10, 100));
        dados.put("pbCursos", Math.min(totalCursos * 2, 100));
        dados.put("pbMatriculas", Math.min(totalMatriculas * 5, 100));

        return dados;
    }
}
