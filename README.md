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
│   │   │   ├── controller/       # Endpoints REST
│   │   │   ├── service/          # Regras de negócio
│   │   │   ├── repository/       # Acesso ao MongoDB
│   │   │   └── model/            # Entidades / documentos
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── pom.xml
└── mvnw
```

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
│   │   │   ├── controller/       # REST endpoints
│   │   │   ├── service/          # Business logic
│   │   │   ├── repository/       # MongoDB access
│   │   │   └── model/            # Entities / documents
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── pom.xml
└── mvnw
```

## 🧪 Tests

```bash
./mvnw test
```

## 📄 License

This project is licensed under the MIT License. See the `LICENSE` file for details.

## 👤 Author

**Pedro Rios** — [@rios-pedro](https://github.com/rios-pedro)
