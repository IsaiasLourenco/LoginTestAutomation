package com.vetor256.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Classe base para a criação das novas PageObjects
 * Todas as pages devem ser herdadas dessa página
 */
public abstract class BasePO {

    /**
     * Construtor base para criação da fábrica de elemenbtos (Page Factory)
     * @param driver Driver da págoina atual
     */
    protected WebDriver driver;

    public BasePO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
