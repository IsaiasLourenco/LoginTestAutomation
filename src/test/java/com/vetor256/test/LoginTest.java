package com.vetor256.test;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.vetor256.page.LoginPO;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class LoginTest extends BaseTest {

    private LoginPO loginPage;

    @BeforeEach
    public void prepararTestes() {
        loginPage = new LoginPO(driver);
    }

    private void validarMensagemCamposObrigatorios() {

        String mensagem = loginPage.getMensagem();

        assertEquals(
                "Informe e-mail e senha, os campos não podem ser brancos.",
                mensagem);
    }

    private void validarMensagemCredenciaisInvalidas() {

        String mensagem = loginPage.getMensagem();

        assertEquals(
                "E-mail ou senha inválidos",
                mensagem);
    }

    @Test
    public void teste001_LoginComCredenciaisInexistentes() {

        loginPage.inputEmail.clear();
        loginPage.inputSenha.clear();

        loginPage.buttonEntrar.click();

        validarMensagemCamposObrigatorios();
    }

    @Test
    public void teste002_LoginComSenhaInexistente() {

        loginPage.inputEmail.clear();
        loginPage.inputSenha.clear();

        loginPage.inputEmail.sendKeys("teste");

        loginPage.buttonEntrar.click();

        validarMensagemCamposObrigatorios();
    }

    @Test
    public void teste003_LoginComEmailInexistente() {

        loginPage.inputEmail.clear();
        loginPage.inputSenha.clear();

        loginPage.inputSenha.sendKeys("123");

        loginPage.buttonEntrar.click();

        validarMensagemCamposObrigatorios();
    }

    @Test
    public void teste004_LoginComCredenciaisInvalidas() {

        loginPage.inputEmail.clear();
        loginPage.inputSenha.clear();

        loginPage.inputEmail.sendKeys("teste");
        loginPage.inputSenha.sendKeys("123");

        loginPage.buttonEntrar.click();

        validarMensagemCredenciaisInvalidas();
    }

    @Test
    public void teste005_LoginComSenhaInvalida() {

        loginPage.inputEmail.clear();
        loginPage.inputSenha.clear();

        loginPage.inputEmail.sendKeys("admin@admin.com");
        loginPage.inputSenha.sendKeys("123");

        loginPage.buttonEntrar.click();

        validarMensagemCredenciaisInvalidas();
    }

    @Test
    public void teste006_LoginComEmailSenhaInvalido() {

        loginPage.inputEmail.clear();
        loginPage.inputSenha.clear();

        loginPage.inputEmail.sendKeys("teste");
        loginPage.inputSenha.sendKeys("admin@123");

        loginPage.buttonEntrar.click();

        validarMensagemCredenciaisInvalidas();
    }

    @Test
    public void teste007_LoginComCredenciaisValidas() {

        loginPage.inputEmail.clear();
        loginPage.inputSenha.clear();

        loginPage.inputEmail.sendKeys("admin@admin.com");
        loginPage.inputSenha.sendKeys("admin@123");

        loginPage.buttonEntrar.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(
                ExpectedConditions.urlToBe(
                        "http://localhost/ProdContr/produtos.html?teste=123"));

        assertEquals(
                "http://localhost/ProdContr/produtos.html?teste=123",
                driver.getCurrentUrl());
    }
}
