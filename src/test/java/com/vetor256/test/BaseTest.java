package com.vetor256.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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
}
