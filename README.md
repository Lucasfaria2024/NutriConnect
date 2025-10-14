# NutriConnect
SaaS para nutricionistas Full-Stack

# API Banco Digital

## 📖 Sobre o Projeto

Este projeto é uma API RESTful simples para gerenciar clientes de um banco digital. Foi desenvolvido como parte de um estudo prático sobre a construção de APIs com Java e Spring Boot, cobrindo as operações fundamentais de um CRUD (Create, Read, Update, Delete).

## ✨ Funcionalidades

-   [x] **Criar Cliente**: Adicionar um novo cliente ao banco de dados.
-   [x] **Listar Clientes**: Visualizar todos os clientes cadastrados.
-   [x] **Buscar Cliente por ID**: Obter os detalhes de um cliente específico.
-   [x] **Atualizar Cliente**: Modificar os dados de um cliente existente.
-   [x] **Deletar Cliente**: Remover um cliente do banco de dados.

## 🛠️ Tecnologias Utilizadas

O projeto foi construído utilizando as seguintes tecnologias:

-   **Java 17**: Versão da linguagem de programação.
-   **Spring Boot**: Framework principal para a construção da aplicação.
-   **Spring Web**: Para a criação de endpoints REST.
-   **Spring Data JPA**: Para a persistência de dados e comunicação com o banco.
-   **Maven**: Gerenciador de dependências do projeto.
-   **H2 Database**: Banco de dados em memória para desenvolvimento e testes.

## 🚀 Como Executar o Projeto

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/SEU-USUARIO/banco-digital-java.git](https://github.com/SEU-USUARIO/banco-digital-java.git)
    ```
2.  **Navegue até o diretório da API:**
    ```bash
    cd banco-digital-java/api
    ```
3.  **Execute a aplicação com o Maven:**
    ```bash
    ./mvnw spring-boot:run
    ```
4.  A API estará disponível em `http://localhost:8080`.

## 🕹️ Endpoints da API

A seguir estão os endpoints disponíveis para interagir com a API.

| Método HTTP | Rota                     | Descrição                                 | Exemplo de Corpo (Body)                                |
| :---------- | :----------------------- | :---------------------------------------- | :----------------------------------------------------- |
| `GET`       | `/clientes`              | Lista todos os clientes cadastrados.      | N/A                                                    |
| `GET`       | `/clientes/{id}`         | Busca um cliente específico pelo seu ID.  | N/A                                                    |
| `POST`      | `/clientes`              | Cria um novo cliente.                     | `{ "nome": "Ana Silva", "cpf": "111.222.333-44" }`      |
| `PUT`       | `/clientes/{id}`         | Atualiza os dados de um cliente existente.| `{ "nome": "Ana Silva Souza", "cpf": "111.222.333-44" }` |
| `DELETE`    | `/clientes/{id}`         | Deleta um cliente pelo seu ID.            | N/A                                                    |

---

Feito por **Lucas Faria**.
