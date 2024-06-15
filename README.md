# Projeto de Microserviços com Spring Boot, H2Database e RabbitMQ

![Badge em Desenvolvimento](https://img.shields.io/badge/Status-Em%20Desenvolvimento-green)

## Índice

- [Descrição do Projeto](#descrição-do-projeto)
- [Funcionalidades](#funcionalidades)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Pré-requisitos](#pré-requisitos)
- [Instalação](#instalação)
- [Configuração](#configuração)
- [Execução](#execução)
- [Endpoints](#endpoints)
- [Contribuição](#contribuição)
- [Licença](#licença)
- [Contato](#contato)

## Descrição do Projeto

Este projeto demonstra a implementação de dois microserviços utilizando Spring Boot. Os microserviços "users" e "email" interagem entre si através do RabbitMQ para realizar autenticação de usuários e envio de emails de registro. Os dados de usuários são persistidos em um banco de dados H2, enquanto a comunicação entre microserviços é facilitada pelo RabbitMQ.

## Funcionalidades

- **Autenticação e Registro de Usuários:**
  - Persistência dos dados de usuários no H2Database.
  - Comunicação assíncrona com o microserviço de email para envio de notificações de registro.

- **Envio de Email:**
  - Consome mensagens da fila `default.email` para envio de emails via SMTP do Google.

## Tecnologias Utilizadas

- **Backend:**
  - [Spring Boot](https://spring.io/projects/spring-boot)
  - [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
  - [Spring AMQP](https://spring.io/projects/spring-amqp)
  
- **Banco de Dados:**
  - [H2Database](https://www.h2database.com/)

- **Mensageria:**
  - [RabbitMQ](https://www.rabbitmq.com/)

- **Email:**
  - [Google SMTP](https://support.google.com/mail/answer/7126229?hl=pt-BR)

## Pré-requisitos

- Java 11+
- Maven 3.6+
- RabbitMQ
- Conta Google para SMTP

## Instalação

1. Clone o repositório:
    ```bash
    git clone https://github.com/seu-usuario/seu-repositorio.git
    cd seu-repositorio
    ```

2. Compile os projetos:
    ```bash
    mvn clean install
    ```

## Configuração

### Configurar o RabbitMQ

1. Inicie o servidor RabbitMQ:
    ```bash
    rabbitmq-server
    ```

2. Acesse o RabbitMQ Management Console em [http://localhost:15672](http://localhost:15672).

### Configurar o SMTP do Google

1. Adicione as seguintes propriedades no `application.properties` do microserviço "email":
    ```properties
    spring.mail.host=smtp.gmail.com
    spring.mail.port=587
    spring.mail.username=seu-email@gmail.com
    spring.mail.password=sua-senha
    spring.mail.properties.mail.smtp.auth=true
    spring.mail.properties.mail.smtp.starttls.enable=true
    ```

## Execução

1. Inicie o microserviço "users":
    ```bash
    cd users-service
    mvn spring-boot:run
    ```

2. Inicie o microserviço "email":
    ```bash
    cd email-service
    mvn spring-boot:run
    ```

## Endpoints

### Users Service

- **Registrar Usuário**
  - `POST /api/users/register`
  - Request Body:
    ```json
    {
      "name": "string",
      "email": "string"
    }
    ```

### Email Service

- **Enviar Email (Consumido automaticamente)**
  - Fila: `default.email`

## Contribuição

1. Faça um fork do projeto.
2. Crie uma nova branch com as suas alterações: `git checkout -b minha-feature`
3. Commit suas alterações: `git commit -m 'Adicionando minha feature'`
4. Faça push para a branch: `git push origin minha-feature`
5. Envie um Pull Request.

## Licença

Este projeto está licenciado sob a licença MIT - veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## Contato

- **Nome:** Seu Nome
- **Email:** seu-email@gmail.com
- **LinkedIn:** [Seu LinkedIn](https://www.linkedin.com/in/seu-usuario)

---

Feito com ♥ por [Seu Nome](https://github.com/seu-usuario)
