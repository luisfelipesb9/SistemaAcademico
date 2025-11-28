package br.unimontes.ccet.dcc.pg1.model.dao.entity;

public class Matricula {
    private int id;
    private int idAluno; // Alterado de CPF para ID do Aluno
    private int idTurma;
    private double nota;
    private int frequencia;

    public Matricula() {
    }

    public Matricula(int id, int idAluno, int idTurma, double nota, int frequencia) {
        this.id = id;
        this.idAluno = idAluno;
        this.idTurma = idTurma;
        this.nota = nota;
        this.frequencia = frequencia;
    }

    public Matricula(int idAluno, int idTurma) {
        this.idAluno = idAluno;
        this.idTurma = idTurma;
        this.nota = 0.0;
        this.frequencia = 0;
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

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public int getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }
}
