package com.vetor256.test;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vetor256.page.LoginPO;
import com.vetor256.utils.constantes;

public class BaseTest {

    protected static WebDriver driver;

    private static final String URL_BASE = "http://localhost/ProdContr/";

    @BeforeEach
    public void iniciar() {

        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Chrome151\\chrome-win64\\chrome.exe");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get(URL_BASE);
    }

    @AfterEach
    public void finalizar() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        if (driver != null) {
            driver.quit();
        }
    }

    protected void efetuarLogin() {

        LoginPO loginPage = new LoginPO(driver);

        loginPage.efetuarLogin(
               constantes.EMAIL_VALIDO,
                constantes.SENHA_VALIDA);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(
                ExpectedConditions.urlToBe(constantes.URL_PRODUTOS));
    }
}
