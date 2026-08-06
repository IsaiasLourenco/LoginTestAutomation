package com.vetor256.utils;

public class constantes {

    private constantes() {
        // impede instanciação
    }

    // Credenciais
    public static final String EMAIL_VALIDO = "admin@admin.com";
    public static final String SENHA_VALIDA = "admin@123";

    // URLs
    public static final String URL_LOGIN ="http://localhost/ProdContr/index.html";

    public static final String URL_PRODUTOS ="http://localhost/ProdContr/produtos.html?teste=123";

    // Mensagens
    public static final String MSG_CAMPOS_OBRIGATORIOS = "Informe e-mail e senha, os campos não podem ser brancos.";

    public static final String MSG_CREDENCIAIS_INVALIDAS = "E-mail ou senha inválidos";

    public static final String MSG_CAMPOS_MODAL_OBRIGATORIOS = "Todos os campos são obrigatórios para o cadastro!";
}
