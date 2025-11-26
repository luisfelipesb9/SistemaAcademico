package br.unimontes.ccet.dcc.pg1.model.dao.entity;

public class Disciplina {
    private int id;
    private String nome;
    private int cargaHoraria;
    private int idCurso;

    public Disciplina(int id, String nome, int cargaHoraria, int idCurso) {
        this.id = id;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.idCurso = idCurso;
    }

    public Disciplina(String nome, int cargaHoraria, int idCurso) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.idCurso = idCurso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }
}
