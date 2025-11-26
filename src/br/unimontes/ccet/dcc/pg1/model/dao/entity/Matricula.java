package br.unimontes.ccet.dcc.pg1.model.dao.entity;

public class Matricula {
    private int id;
    private String cpfAluno;
    private int idTurma;
    private double nota;
    private int frequencia;

    public Matricula() {
    }

    public Matricula(int id, String cpfAluno, int idTurma, double nota, int frequencia) {
        this.id = id;
        this.cpfAluno = cpfAluno;
        this.idTurma = idTurma;
        this.nota = nota;
        this.frequencia = frequencia;
    }

    public Matricula(String cpfAluno, int idTurma) {
        this.cpfAluno = cpfAluno;
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

    public String getCpfAluno() {
        return cpfAluno;
    }

    public void setCpfAluno(String cpfAluno) {
        this.cpfAluno = cpfAluno;
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
