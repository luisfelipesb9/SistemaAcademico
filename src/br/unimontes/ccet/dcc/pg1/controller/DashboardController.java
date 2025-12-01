package br.unimontes.ccet.dcc.pg1.controller;

import java.util.HashMap;
import java.util.Map;

public class DashboardController {

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
}
