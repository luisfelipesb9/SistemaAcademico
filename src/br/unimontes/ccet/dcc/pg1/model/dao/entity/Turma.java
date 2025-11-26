package br.unimontes.ccet.dcc.pg1.model.dao.entity;

public class Turma {
    private int id;
    private int idDisciplina;
    private int idProfessor;
    private int ano;
    private int semestre;

    public Turma(int id, int idDisciplina, int idProfessor, int ano, int semestre) {
        this.id = id;
        this.idDisciplina = idDisciplina;
        this.idProfessor = idProfessor;
        this.ano = ano;
        this.semestre = semestre;
    }

    public Turma(int idDisciplina, int idProfessor, int ano, int semestre) {
        this.idDisciplina = idDisciplina;
        this.idProfessor = idProfessor;
        this.ano = ano;
        this.semestre = semestre;
    }

    public Turma() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
}
