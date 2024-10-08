# Spring CRUD

Este projeto contém um backend com CRUD para adicionar produtos ao banco de dados PostgreSQL.

Os produtos têm o formato:
```
{
  id: Long,
  nome: String,
  preco: Double
}
```

Os endpoints disponíveis são:
```
GET /produtos - lista todos os produtos

POST /produtos - adiciona um novo produto (nome e preço necessários)

PUT /produtos/{id} - altera um produto existente (nome e preço opcionais)

DELETE /produtos/{id} - remove um produto
```

## Executando o projeto com Docker

1. Configure o arquivo `.env`:
    * `DB_URL` é o caminho para o banco de dados
    * `DB_PORT` é a porta do banco de dados (por padrão do PostgreSQL, utilize `5432`)
    * `DB_NAME` é o nome do banco de dados
    * `DB_USERNAME` é o nome do usuário do banco de dados
    * `DB_PASSWORD` é a senha do usuário do banco de dados

2. Para executar o projeto, use uma das seguintes opções:
    * Se você tem o Java 21 instalado em sua máquina:
        1. `./gradlew build --no-daemon && docker-compose -f docker-compose.dev.yml up -d`
        2. `bash run-dev.sh`
    * Caso não tenha o Java 21 instalado:
        1. `docker-compose -f docker-compose.prod.yml up -d`
        2. `bash run-prod.sh`
    * Observação: criar a build localmente e copiá-la para o container é mais rápido que criar a build dentro dele

3. A aplicação está disponível em `http://localhost:8080/`

## Executando o projeto sem Docker

1. Instale o PostgreSQL e o Java 21 em seu computador

2. No PostgreSQL, crie um banco de dados

3. Configure o arquivo `.env`:
    * `DB_URL` é o caminho para o banco de dados
    * `DB_PORT` é a porta do banco de dados (por padrão do PostgreSQL, utilize `5432`)
    * `DB_NAME` é o nome do banco de dados que você criou
    * `DB_USERNAME` é o nome do usuário do banco de dados
    * `DB_PASSWORD` é a senha do usuário do banco de dados

4. Execute `./gradlew build` no console para criar o executável do projeto

5. Execute `java -jar build/libs/crud-0.0.1-SNAPSHOT.jar` no console

6. A aplicação está disponível em `http://localhost:8080/`