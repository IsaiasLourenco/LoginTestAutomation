package com.vetor256.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// import com.vetor256.page.LoginPO;
import com.vetor256.page.ProdutosPO;
import com.vetor256.utils.constantes;

public class ProdutosTest extends BaseTest {

    private ProdutosPO produtosPage;

    @BeforeEach
    public void prepararTestes() {

        efetuarLogin();

        produtosPage = new ProdutosPO(driver);
    }

    @Test
    public void tc001_PermanecerNaTelaAoClicarNaLogo() {

        produtosPage.logo.click();

        assertTrue(
            driver.getCurrentUrl().startsWith(constantes.URL_PRODUTOS)
        );
    }

    @Test
    public void tc002_VoltarParaLogin() {

        produtosPage.linkVoltar.click();

        assertEquals(constantes.URL_LOGIN,
                driver.getCurrentUrl());
    }
}
