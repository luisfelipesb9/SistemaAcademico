package br.unimontes.ccet.dcc.pg1.controller;

/**
 * Classe padronizada para retorno de operações do Controller.
 * Permite que a View decida como exibir mensagens de sucesso/erro.
 */
public class Response {

    private boolean sucesso;
    private String mensagem;
    private Object dados;

    public Response(boolean sucesso, String mensagem) {
        this.sucesso = sucesso;
        this.mensagem = mensagem;
        this.dados = null;
    }

    public Response(boolean sucesso, String mensagem, Object dados) {
        this.sucesso = sucesso;
        this.mensagem = mensagem;
        this.dados = dados;
    }

    public static Response sucesso(String mensagem) {
        return new Response(true, mensagem);
    }

    public static Response sucesso(String mensagem, Object dados) {
        return new Response(true, mensagem, dados);
    }

    public static Response erro(String mensagem) {
        return new Response(false, mensagem);
    }

    public boolean isSucesso() {
        return sucesso;
    }

    public String getMensagem() {
        return mensagem;
    }

    public Object getDados() {
        return dados;
    }

    @SuppressWarnings("unchecked")
    public <T> T getDadosAs(Class<T> tipo) {
        return (T) dados;
    }
}
