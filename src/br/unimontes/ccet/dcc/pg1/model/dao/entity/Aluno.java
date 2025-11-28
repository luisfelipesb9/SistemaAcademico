package br.unimontes.ccet.dcc.pg1.model.dao.entity;

import br.unimontes.ccet.dcc.pg1.model.dao.exception.DAOException;
import br.unimontes.ccet.dcc.pg1.model.dao.service.Utils;

public class Aluno {
    // Force recompile
    private int id; // Matrícula (RA)
    private String cpf;
    private String nome;
    private Integer anoNascimento;
    private int idCurso;

    public Aluno(int id, String cpf, String nome, int anoNascimento, int idCurso) throws DAOException {
        this.id = id;
        this.cpf = Utils.validaCPF(cpf);
        if (this.cpf == null)
            throw new DAOException("CPF inválido");
        this.nome = Utils.validaNome(nome);
        if (this.nome == null)
            throw new DAOException("Nome inválido");
        this.anoNascimento = Utils.validaAnoNascimento(anoNascimento);
        if (this.anoNascimento == null)
            throw new DAOException("Ano de nascimento inválido (deve ter 4 dígitos e ser válido)");
        this.idCurso = idCurso;
    }

    // Construtor sem ID (para novos cadastros antes de salvar)
    public Aluno(String cpf, String nome, int anoNascimento, int idCurso) throws DAOException {
        this(0, cpf, nome, anoNascimento, idCurso);
    }

    @Override
    public String toString() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public Integer getAnoNascimento() {
        return anoNascimento;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }
}
