# 🛒 Sistema de Cadastro de Produtos em Java

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![POO](https://img.shields.io/badge/Paradigma-POO-blue?style=for-the-badge)
![Interfaces](https://img.shields.io/badge/Interfaces-OOP-green?style=for-the-badge)
![Swing](https://img.shields.io/badge/Java-Swing-orange?style=for-the-badge)

---

## 📌 Sobre o projeto
Este é um exemplo de **Cadastro de Produtos em Java**, implementado com:
- **Programação Orientada a Objetos (POO)**  
- Uso de **Interfaces** para abstração de serviços  
- Biblioteca gráfica **Swing** para criação da interface  

O sistema permite **cadastrar produtos** (nome, preço e quantidade) e **listar os produtos já cadastrados**.  

---

## 🏗️ Estrutura do Projeto
```bash
src/
├── Produto.java # Classe de modelo
├── ProdutoService.java # Interface (contrato)
├── ProdutoServiceImpl.java # Implementação do serviço
└── TelaCadastroProduto.java # Tela gráfica em Swing
```

---

## 📖 Explicação do Código

### 🔹 `Produto.java`
Representa o modelo de dados, com atributos **nome**, **preço** e **quantidade**.

```java
public class Produto {
    private String nome;
    private double preco;
    private int quantidade;
    // getters, construtor e toString()
}
```
### 🔹 `ProdutoService.java`

Define o contrato para manipulação de produtos.
Assim, qualquer implementação (ex: banco de dados, memória) pode ser usada.

```java
public interface ProdutoService {
    void salvarProduto(Produto produto);
    List<Produto> listarProdutos();
}
```
### 🔹 `ProdutoServiceImpl.java`

Implementa o serviço definido pela interface, salvando os produtos em memória (lista).
```java
public class ProdutoServiceImpl implements ProdutoService {
    private List<Produto> produtos = new ArrayList<>();
    public void salvarProduto(Produto produto) { ... }
    public List<Produto> listarProdutos() { ... }
}
```
### 🔹 `TelaCadastroProduto.java`

Interface gráfica criada com Swing.
Permite cadastrar produtos e listar os já existentes.
```java
ProdutoService produtoService = new ProdutoServiceImpl();
TelaCadastroProduto tela = new TelaCadastroProduto(produtoService);
tela.setVisible(true);
```

---

▶️ `Como executar`

1. Compile os arquivos:
```java
javac *.java
```
2. Rode o programa:
```java
java TelaCadastroProduto
```
3. Preencha os campos Nome, Preço, Quantidade e clique em Salvar.

4. Use o botão Listar Produtos para visualizar todos os cadastrados.

# 

## 🎯 Conceitos aplicados

Interfaces: abstraem a lógica do serviço de produto, facilitando a manutenção e expansão.

POO: separação em classes claras (Modelo, Serviço, Tela).

Swing: construção de interface gráfica em Java.

## 🚀 Possíveis melhorias

Persistir os produtos em banco de dados (MySQL ou PostgreSQL).

Implementar edição e exclusão de produtos.

Criar um padrão MVC para separar melhor as camadas.

#

![Dev Hudson Amorim](https://img.shields.io/badge/Dev-Hudson%20Amorim-black?style=for-the-badge&logo=github)



   
