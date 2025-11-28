package br.unimontes.ccet.dcc.pg1.model.dao.entity;

import br.unimontes.ccet.dcc.pg1.model.dao.service.Utils;

public class Curso {
    private int id;
    private String nome;
    private int creditos;

    public Curso(int id, String nome, int creditos) {
        this.id = id;
        this.nome = Utils.validaNome(nome);
        this.creditos = creditos;
    }

    public Curso(String nome, int creditos) {
        this.id = 0;
        this.nome = Utils.validaNome(nome);
        this.creditos = creditos;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return nome;
    }
}
