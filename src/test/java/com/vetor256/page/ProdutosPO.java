package com.vetor256.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProdutosPO extends BasePO {

    public ProdutosPO(WebDriver driver) {
        super(driver);
    }

    // Tela principal
    @FindBy(css = "nav .navbar-brand")
    public WebElement logo;

    @FindBy(linkText = "Voltar")
    public WebElement linkVoltar;

    @FindBy(id = "btn-adicionar")
    public WebElement buttonCriar;

    // Modal de cadastro
    @FindBy(id = "codigo")
    public WebElement inputCodigo;

    @FindBy(id = "nome")
    public WebElement inputNome;

    @FindBy(id = "quantidade")
    public WebElement inputQuantidade;

    @FindBy(id = "valor")
    public WebElement inputValor;

    @FindBy(id = "data")
    public WebElement inputData;

    @FindBy(id = "btn-salvar")
    public WebElement buttonSalvar;

    @FindBy(id = "btn-sair")
    public WebElement buttonSair;

    @FindBy(id="btn-fechar-alert")
    public WebElement buttonFecharAlerta;

    @FindBy(id="mensagem")
    public WebElement spanMensagem;

    @FindBy(css="table thead th")
    public List<WebElement> titulosTabela;

    @FindBy(id="cadastro-produto")
    public WebElement modalCadastro;

    public void abrirModal() {
        buttonCriar.click();
    }

    public void fecharModal() {
        buttonSair.click();
    }

    public void salvarProduto() {
        buttonSalvar.click();
    }

    public void preencherProduto(
        String codigo,
        String nome,
        String quantidade,
        String valor,
        String data
    ) {

    }
}
