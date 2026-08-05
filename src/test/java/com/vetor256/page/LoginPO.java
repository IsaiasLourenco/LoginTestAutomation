package com.vetor256.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO {

    @FindBy(id = "email")
    public WebElement inputEmail;

    @FindBy(id = "senha")
    public WebElement inputSenha;

    @FindBy(id = "btn-entrar")
    public WebElement buttonEntrar;

    @FindBy(id = "mensagem")
    public WebElement spanMensagem;

    /**
     *  Construtor padrão para criação da uma nova instânca da página de login
     * @param driver Driver da página de login
     */
    public LoginPO(WebDriver driver) {
        super(driver);
    }

    public String getMensagem() {
        return spanMensagem.getText();
    }

    public static final String MENSAGEM_CAMPOS_OBRIGATORIOS =
    "Informe e-mail e senha, os campos não podem ser brancos.";

}
