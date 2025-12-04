package br.unimontes.ccet.dcc.pg1.model.dao.entity;

/**
 * Entidade Professor - representa um docente vinculado a um curso.
 */
public class Professor {
    private int id;
    private String nome;
    private String titulacao;
    private int idCurso;

    public Professor(int id, String nome, String titulacao, int idCurso) {
        this.id = id;
        this.nome = nome;
        this.titulacao = titulacao;
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

    public String getTitulacao() {
        return titulacao;
    }

    public int getIdCurso() {
        return idCurso;
    }

    /**
     * Retorna nome formatado com titulação para exibição.
     * Ex: "Dr. João Silva (Doutorado)"
     */
    public String getNomeFormatado() {
        return nome + " (" + titulacao + ")";
    }

    @Override
    public String toString() {
        return nome;
    }
}
