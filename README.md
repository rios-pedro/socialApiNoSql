# 📱 Social API NoSQL

<div align="center">

**[🇧🇷 Português](#-português) | [🇺🇸 English](#-english)**

</div>

---

# 🇧🇷 Português

API RESTful de rede social construída com **Java**, **Spring Boot** e **MongoDB**. O projeto utiliza banco de dados NoSQL orientado a documentos para gerenciar dados de usuários e interações sociais.

## 🛠️ Tecnologias

| Tecnologia | Versão |
|---|---|
| Java | 17 |
| Spring Boot | 4.0.5 |
| Spring Data MongoDB | — |
| Spring Web MVC | — |
| Maven | Wrapper incluído |

## 📋 Pré-requisitos

Antes de executar o projeto, certifique-se de ter instalado:

- [Java 17+](https://adoptium.net/)
- [Maven 3.8+](https://maven.apache.org/) *(ou use o wrapper `./mvnw` incluso)*
- [MongoDB](https://www.mongodb.com/try/download/community) rodando localmente na porta `27017`

## 🚀 Como executar

### 1. Clone o repositório

```bash
git clone https://github.com/rios-pedro/socialApiNoSql.git
cd socialApiNoSql
```

### 2. Configure o MongoDB

Certifique-se de que o MongoDB está em execução localmente. Por padrão, a aplicação se conecta em:

```
mongodb://localhost:27017
```

Se necessário, ajuste as configurações em `src/main/resources/application.properties`:

```properties
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=socialApiNoSql
```

### 3. Execute a aplicação

```bash
./mvnw spring-boot:run
```

Ou compile e execute o JAR:

```bash
./mvnw clean package
java -jar target/socialApiNoSql-0.0.1-SNAPSHOT.jar
```

A API estará disponível em: `http://localhost:8080`

## 📁 Estrutura do Projeto

```
socialApiNoSql/
├── src/
│   ├── main/
│   │   ├── java/pedroRios/socialApiNoSql/
│   │   │   ├── resources/        # Endpoints REST (Controllers)
│   │   │   ├── Services/         # Regras de negócio
│   │   │   ├── repositories/     # Acesso ao MongoDB
│   │   │   ├── domain/           # Entidades (User, Post)
│   │   │   └── dto/              # Data Transfer Objects
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── pom.xml
└── mvnw
```

## 🔌 Endpoints

Base URL: `http://localhost:8080`

---

### 👤 Usuários — `/users`

#### Listar todos os usuários
```http
GET /users
```
**Resposta `200 OK`:**
```json
[
  {
    "id": "64b1f2e3a1b2c3d4e5f60001",
    "name": "Pedro Rios",
    "email": "pedro@email.com"
  }
]
```

---

#### Buscar usuário por ID
```http
GET /users/{id}
```
**Resposta `200 OK`:**
```json
{
  "id": "64b1f2e3a1b2c3d4e5f60001",
  "name": "Pedro Rios",
  "email": "pedro@email.com"
}
```

---

#### Criar usuário
```http
POST /users
Content-Type: application/json
```
**Body:**
```json
{
  "name": "Pedro Rios",
  "email": "pedro@email.com"
}
```
**Resposta `201 Created`** — retorna o header `Location` com a URI do novo recurso.

---

#### Atualizar usuário
```http
PUT /users/{id}
Content-Type: application/json
```
**Body:**
```json
{
  "name": "Pedro Rios Atualizado",
  "email": "novo@email.com"
}
```
**Resposta `204 No Content`**

---

#### Deletar usuário
```http
DELETE /users/{id}
```
**Resposta `204 No Content`**

---

#### Listar posts de um usuário
```http
GET /users/{id}/posts
```
**Resposta `200 OK`:**
```json
[
  {
    "id": "64b1f2e3a1b2c3d4e5f60099",
    "date": "2024-07-15T10:30:00Z",
    "title": "Meu primeiro post",
    "body": "Conteúdo do post aqui.",
    "author": {
      "id": "64b1f2e3a1b2c3d4e5f60001",
      "name": "Pedro Rios"
    },
    "comments": []
  }
]
```

---

### 📝 Posts — `/posts`

#### Buscar post por ID
```http
GET /posts/{id}
```
**Resposta `200 OK`:**
```json
{
  "id": "64b1f2e3a1b2c3d4e5f60099",
  "date": "2024-07-15T10:30:00Z",
  "title": "Meu primeiro post",
  "body": "Conteúdo do post aqui.",
  "author": {
    "id": "64b1f2e3a1b2c3d4e5f60001",
    "name": "Pedro Rios"
  },
  "comments": [
    {
      "text": "Ótimo post!",
      "date": "2024-07-15T11:00:00Z",
      "author": {
        "id": "64b1f2e3a1b2c3d4e5f60002",
        "name": "Maria Silva"
      }
    }
  ]
}
```

---

#### Buscar posts por título
```http
GET /posts/titlesearch?text={termo}
```
**Exemplo:**
```http
GET /posts/titlesearch?text=spring
```
**Resposta `200 OK`:** lista de posts cujo título contenha o termo (case-insensitive).

---

#### Busca completa (texto + intervalo de datas)
```http
GET /posts/fullsearch?text={termo}&minDate={data}&maxDate={data}
```
**Exemplo:**
```http
GET /posts/fullsearch?text=mongodb&minDate=2024-01-01&maxDate=2024-12-31
```
Pesquisa no `title`, `body` e `comments.text` dentro do intervalo de datas.

**Resposta `200 OK`:** lista de posts correspondentes.

> **Formato de data:** `yyyy-MM-dd`
> Os parâmetros `text`, `minDate` e `maxDate` são opcionais — se omitidos, retornam todos os posts.

---

### ⚠️ Respostas de Erro

| Código | Descrição |
|---|---|
| `404 Not Found` | Recurso não encontrado (`ObjectNotFoundException`) |
| `400 Bad Request` | Requisição inválida |

---

## 🧪 Testes

```bash
./mvnw test
```

## 📄 Licença

Este projeto está sob a licença MIT. Consulte o arquivo `LICENSE` para mais detalhes.

## 👤 Autor

**Pedro Rios** — [@rios-pedro](https://github.com/rios-pedro)

---

# 🇺🇸 English

A RESTful social network API built with **Java**, **Spring Boot** and **MongoDB**. The project uses a document-oriented NoSQL database to manage user data and social interactions.

## 🛠️ Technologies

| Technology | Version |
|---|---|
| Java | 17 |
| Spring Boot | 4.0.5 |
| Spring Data MongoDB | — |
| Spring Web MVC | — |
| Maven | Wrapper included |

## 📋 Prerequisites

Before running the project, make sure you have installed:

- [Java 17+](https://adoptium.net/)
- [Maven 3.8+](https://maven.apache.org/) *(or use the included `./mvnw` wrapper)*
- [MongoDB](https://www.mongodb.com/try/download/community) running locally on port `27017`

## 🚀 How to run

### 1. Clone the repository

```bash
git clone https://github.com/rios-pedro/socialApiNoSql.git
cd socialApiNoSql
```

### 2. Configure MongoDB

Make sure MongoDB is running locally. By default, the application connects to:

```
mongodb://localhost:27017
```

If needed, adjust the settings in `src/main/resources/application.properties`:

```properties
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=socialApiNoSql
```

### 3. Run the application

```bash
./mvnw spring-boot:run
```

Or build and run the JAR:

```bash
./mvnw clean package
java -jar target/socialApiNoSql-0.0.1-SNAPSHOT.jar
```

The API will be available at: `http://localhost:8080`

## 📁 Project Structure

```
socialApiNoSql/
├── src/
│   ├── main/
│   │   ├── java/pedroRios/socialApiNoSql/
│   │   │   ├── resources/        # REST endpoints (Controllers)
│   │   │   ├── Services/         # Business logic
│   │   │   ├── repositories/     # MongoDB access
│   │   │   ├── domain/           # Entities (User, Post)
│   │   │   └── dto/              # Data Transfer Objects
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── pom.xml
└── mvnw
```

## 🔌 Endpoints

Base URL: `http://localhost:8080`

---

### 👤 Users — `/users`

#### List all users
```http
GET /users
```
**Response `200 OK`:**
```json
[
  {
    "id": "64b1f2e3a1b2c3d4e5f60001",
    "name": "Pedro Rios",
    "email": "pedro@email.com"
  }
]
```

---

#### Get user by ID
```http
GET /users/{id}
```
**Response `200 OK`:**
```json
{
  "id": "64b1f2e3a1b2c3d4e5f60001",
  "name": "Pedro Rios",
  "email": "pedro@email.com"
}
```

---

#### Create user
```http
POST /users
Content-Type: application/json
```
**Body:**
```json
{
  "name": "Pedro Rios",
  "email": "pedro@email.com"
}
```
**Response `201 Created`** — returns a `Location` header with the URI of the new resource.

---

#### Update user
```http
PUT /users/{id}
Content-Type: application/json
```
**Body:**
```json
{
  "name": "Pedro Rios Updated",
  "email": "new@email.com"
}
```
**Response `204 No Content`**

---

#### Delete user
```http
DELETE /users/{id}
```
**Response `204 No Content`**

---

#### List user's posts
```http
GET /users/{id}/posts
```
**Response `200 OK`:**
```json
[
  {
    "id": "64b1f2e3a1b2c3d4e5f60099",
    "date": "2024-07-15T10:30:00Z",
    "title": "My first post",
    "body": "Post content here.",
    "author": {
      "id": "64b1f2e3a1b2c3d4e5f60001",
      "name": "Pedro Rios"
    },
    "comments": []
  }
]
```

---

### 📝 Posts — `/posts`

#### Get post by ID
```http
GET /posts/{id}
```
**Response `200 OK`:**
```json
{
  "id": "64b1f2e3a1b2c3d4e5f60099",
  "date": "2024-07-15T10:30:00Z",
  "title": "My first post",
  "body": "Post content here.",
  "author": {
    "id": "64b1f2e3a1b2c3d4e5f60001",
    "name": "Pedro Rios"
  },
  "comments": [
    {
      "text": "Great post!",
      "date": "2024-07-15T11:00:00Z",
      "author": {
        "id": "64b1f2e3a1b2c3d4e5f60002",
        "name": "Maria Silva"
      }
    }
  ]
}
```

---

#### Search posts by title
```http
GET /posts/titlesearch?text={term}
```
**Example:**
```http
GET /posts/titlesearch?text=spring
```
**Response `200 OK`:** list of posts whose title contains the term (case-insensitive).

---

#### Full search (text + date range)
```http
GET /posts/fullsearch?text={term}&minDate={date}&maxDate={date}
```
**Example:**
```http
GET /posts/fullsearch?text=mongodb&minDate=2024-01-01&maxDate=2024-12-31
```
Searches across `title`, `body` and `comments.text` within the given date range.

**Response `200 OK`:** list of matching posts.

> **Date format:** `yyyy-MM-dd`
> The `text`, `minDate` and `maxDate` params are optional — if omitted, all posts are returned.

---

### ⚠️ Error Responses

| Code | Description |
|---|---|
| `404 Not Found` | Resource not found (`ObjectNotFoundException`) |
| `400 Bad Request` | Invalid request |

---

## 🧪 Tests

```bash
./mvnw test
```

## 📄 License

This project is licensed under the MIT License. See the `LICENSE` file for details.

## 👤 Author

**Pedro Rios** — [@rios-pedro](https://github.com/rios-pedro)
