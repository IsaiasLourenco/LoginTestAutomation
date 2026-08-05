# LoginTestAutomation - Testes E2E (End-to-End)

Projeto de automação de testes E2E para o sistema **Controle de Produtos**, desenvolvido com **Java, Selenium WebDriver, JUnit 5 e Maven**.

O projeto tem como objetivo automatizar e validar o fluxo de login da aplicação, utilizando o padrão **Page Object Model (POM)** para organização e reutilização dos elementos das páginas.

## Tecnologias utilizadas

- Java 25
- Selenium WebDriver 4.35.0
- JUnit 5
- Maven
- Page Object Model (POM)
- Google Chrome / ChromeDriver

## Estrutura do projeto

```text
automatizado-selenium/
├── pom.xml
├── .gitignore
└── src/
    └── test/
        └── java/
            └── com/
                └── vetor256/
                    ├── page/
                    │   ├── BasePO.java
                    │   ├── LoginPO.java
                    │   └── ProdutosPO.java
                    │
                    └── test/
                        ├── BaseTest.java
                        └── LoginTest.java
```

## Testes automatizados

### Atualmente, o projeto possui testes para o fluxo de login:

Login com e-mail e senha vazios
Login com senha inexistente
Login com e-mail inexistente
Login com credenciais inválidas
Login com senha inválida
Login com e-mail inválido
Login com credenciais válidas

O último cenário também valida o redirecionamento para a página de controle de produtos após um login realizado com sucesso.

## Pré-requisitos
Java 25 ou superior
Maven instalado
Google Chrome
Aplicação Controle de Produtos disponível localmente

### A aplicação utilizada nos testes deve estar disponível em:

```text
http://localhost/ProdContr/
```

## Como executar os testes

### No terminal, dentro da raiz do projeto, execute:
```text
mvn clean test
```
## O Maven irá compilar o projeto, executar os testes automatizados e apresentar o resultado da execução.

### Padrão Page Object Model

O projeto utiliza o padrão Page Object Model (POM) para separar a implementação das páginas dos casos de teste.

Os elementos da interface são mapeados nas classes PO, enquanto os cenários de teste ficam nas classes de teste.

Exemplo:
```text
LoginPO.java
    ↓
LoginTest.java
```
Essa abordagem facilita a manutenção dos testes e evita a duplicação de código.

## Projeto testado

A aplicação utilizada como alvo dos testes está em um projeto separado:
```text
ControleDeProdutos
```
Este repositório contém somente os testes automatizados, mantendo separado o código da aplicação e o código de automação.

```text
Eu particularmente manteria essa versão porque ela deixa **bem clara a separação que você decidiu fazer**: o `ControleDeProdutos` é a aplicação e o `LoginTestAutomation` é o projeto de QA/automação. Isso fica bem mais profissional no GitHub do que misturar os dois.
```
