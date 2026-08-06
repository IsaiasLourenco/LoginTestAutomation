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

    public LoginPO(WebDriver driver) {
        super(driver);
    }

    public String getMensagem() {
        return spanMensagem.getText();
    }

    public void efetuarLogin(String email, String senha) {

        inputEmail.clear();
        inputSenha.clear();

        inputEmail.sendKeys(email);
        inputSenha.sendKeys(senha);

        buttonEntrar.click();
    }
}
