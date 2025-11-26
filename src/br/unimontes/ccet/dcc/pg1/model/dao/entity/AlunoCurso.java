package br.unimontes.ccet.dcc.pg1.model.dao.entity;

import br.unimontes.ccet.dcc.pg1.model.dao.service.Utils;

public class AlunoCurso {
    private String cpfAluno;
    private int idCurso;
    private int creditosCursados;

    public AlunoCurso(String cpfAluno, int idCurso, int creditosCursados) {
        this.cpfAluno = Utils.validaCPF(cpfAluno);
        this.idCurso = idCurso;
        this.creditosCursados = creditosCursados;
    }

    public String getCpfAluno() {
        return cpfAluno;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public int getCreditosCursados() {
        return creditosCursados;
    }
}
