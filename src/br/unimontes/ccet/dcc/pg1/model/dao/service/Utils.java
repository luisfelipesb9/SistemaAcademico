package br.unimontes.ccet.dcc.pg1.model.dao.service;

import java.time.LocalDate;

public class Utils {
    public static String validaCPF(String cpf) {
        if (cpf == null || cpf.isBlank())
            return null;

        String numCpf = cpf.replaceAll("[^0-9]", "");

        // Apenas verifica se tem 11 dígitos (permite CPFs de teste)
        if (numCpf.length() != 11)
            return null;

        return cpf;
    }

    public static String validaNome(String nome) {
        if (nome == null || nome.isBlank())
            return null;
        if (nome.length() >= 255)
            return null;
        return nome;
    }

    public static Integer validaAnoNascimento(int ano) {

        if (String.valueOf(ano).length() != 4)
            return null;

        int currentYear = LocalDate.now().getYear();
        if (ano < 1900 || ano > currentYear)
            return null;
        return ano;
    }

}
