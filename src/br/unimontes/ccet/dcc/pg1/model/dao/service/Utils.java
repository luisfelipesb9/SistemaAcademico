package br.unimontes.ccet.dcc.pg1.model.dao.service;

public class Utils {
    public static String validaCPF(String cpf) {
        if (cpf == null || cpf.isBlank())
            return null;

        String numCpf = cpf.replaceAll("[^0-9]", "");

        if (numCpf.length() != 11)
            return null;

        // if (numCpf.matches("(\\d)\\1{10}"))
        // return null;

        // try {

        // int soma1 = 0;
        // for (int i = 0; i < 9; i++) {
        // int num = Character.getNumericValue(numCpf.charAt(i));
        // soma1 += num * (10 - i);
        // }

        // int resto1 = (soma1 * 10) % 11;
        // if (resto1 == 10)
        // resto1 = 0;

        // if (resto1 != Character.getNumericValue(numCpf.charAt(9)))
        // return null;

        // int soma2 = 0;
        // for (int i = 0; i < 10; i++) {
        // int num = Character.getNumericValue(numCpf.charAt(i));
        // soma2 += num * (11 - i);
        // }

        // int resto2 = (soma2 * 10) % 11;
        // if (resto2 == 10)
        // resto2 = 0;

        // if (resto2 != Character.getNumericValue(numCpf.charAt(10)))
        // return null;

        return cpf;
        // } catch (Exception e) {
        // return null;
        // }
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

        if (ano < 1900 || ano > 2026)
            return null;
        return ano;
    }

}
