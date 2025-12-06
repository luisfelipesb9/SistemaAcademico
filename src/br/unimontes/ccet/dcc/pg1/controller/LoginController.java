package br.unimontes.ccet.dcc.pg1.controller;

/**
 * Controller para operações de Login.
 * Centraliza a lógica de autenticação, removendo-a da View.
 */
public class LoginController {

    // Credenciais (em produção, usar banco de dados e criptografia)
    private static final String USUARIO_ADMIN = "admin";
    private static final String SENHA_ADMIN = "123";

    /**
     * Valida as credenciais do usuário.
     * 
     * @param usuario Nome de usuário
     * @param senha   Senha do usuário
     * @return Response com sucesso ou erro
     */
    public Response autenticar(String usuario, String senha) {
        if (usuario == null || usuario.trim().isEmpty()) {
            return Response.erro("Informe o usuário.");
        }

        if (senha == null || senha.isEmpty()) {
            return Response.erro("Informe a senha.");
        }

        if (usuario.equals(USUARIO_ADMIN) && senha.equals(SENHA_ADMIN)) {
            return Response.sucesso("Login realizado com sucesso!");
        } else {
            return Response.erro("Usuário ou senha inválidos!");
        }
    }
}
