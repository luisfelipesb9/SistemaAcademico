package br.unimontes.ccet.dcc.pg1.model.dao.entity;

import br.unimontes.ccet.dcc.pg1.model.dao.exception.DAOException;
import br.unimontes.ccet.dcc.pg1.model.dao.service.Utils;

public class Aluno {
    private String cpf;
    private String nome;
    private Integer anoNascimento;

    public Aluno(String cpf, String nome, int anoNascimento) throws DAOException {
        this.cpf = Utils.validaCPF(cpf);
        if (this.cpf == null)
            throw new DAOException("CPF inválido");
        this.nome = Utils.validaNome(nome);
        if (this.nome == null)
            throw new DAOException("Nome inválido");
        this.anoNascimento = Utils.validaAnoNascimento(anoNascimento);
        if (this.anoNascimento == null)
            throw new DAOException("Ano de nascimento inválido (deve ter 4 dígitos e ser válido)");
    }

    @Override
    public String toString() {
        return nome;
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

}
