package br.unimontes.ccet.dcc.pg1.model.dao.entity;

public class Matricula {
    private int id;
    private int idAluno;
    private int idCurso;

    public Matricula() {
    }

    public Matricula(int id, int idAluno, int idCurso) {
        this.id = id;
        this.idAluno = idAluno;
        this.idCurso = idCurso;
    }

    public Matricula(int idAluno, int idCurso) {
        this.idAluno = idAluno;
        this.idCurso = idCurso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }
}
