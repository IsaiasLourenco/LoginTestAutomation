package com.vetor256.test;
import com.vetor256.utils.constantes;

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
            constantes.MSG_CAMPOS_OBRIGATORIOS,
                mensagem);
    }

    private void validarMensagemCredenciaisInvalidas() {

        String mensagem = loginPage.getMensagem();

        assertEquals(
            constantes.MSG_CREDENCIAIS_INVALIDAS,
            mensagem);
    }

    @Test
    public void tc001_LoginComCredenciaisInexistentes() {

        loginPage.efetuarLogin("", "");

        validarMensagemCamposObrigatorios();
    }

    @Test
    public void tc002_LoginComSenhaInexistente() {

        loginPage.efetuarLogin("teste", "");

        validarMensagemCamposObrigatorios();
    }

    @Test
    public void tc003_LoginComEmailInexistente() {

        loginPage.efetuarLogin("", "123");

        validarMensagemCamposObrigatorios();
    }

    @Test
    public void tc004_LoginComCredenciaisInvalidas() {

        loginPage.efetuarLogin("teste", "123");

        validarMensagemCredenciaisInvalidas();
    }

    @Test
    public void tc005_LoginComSenhaInvalida() {

        loginPage.efetuarLogin(constantes.EMAIL_VALIDO, "123");

        validarMensagemCredenciaisInvalidas();
    }

    @Test
    public void tc006_LoginComEmailSenhaInvalido() {

        loginPage.efetuarLogin("teste", constantes.SENHA_VALIDA);
        validarMensagemCredenciaisInvalidas();
    }

    @Test
    public void tc007_LoginComCredenciaisValidas() {

        loginPage.efetuarLogin(constantes.EMAIL_VALIDO, constantes.SENHA_VALIDA);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));


        wait.until(ExpectedConditions.urlToBe(constantes.URL_PRODUTOS));

        assertEquals(constantes.URL_PRODUTOS, driver.getCurrentUrl());
    }
}
