# DashMottu Web API

API RESTful para o sistema **DashMottu**: mapeamento inteligente de pátios e gestão de motos.  
Desenvolvida com **Java** e **Spring Boot**.

## 📋 Equipe

- Felipe Seiki Hashiguti — RM98985  
- Lucas Corradini Silveira — RM555118  
- Matheus Gregorio Mota — RM557254  

## 🛠 Tecnologias utilizadas

- Java 17+  
- Spring Boot  
- Spring Data JPA
- Spring Security
- Lomobok
- Banco de dados Oracle
- Thymleaf
- Maven  

## 🔧 Configuração

1. Clone este repositório:

   ```bash
   git clone https://github.com/MatheusGmota/dashmottu-web-api.git
   cd dashmottu-web-api
1. No arquivo `src/main/resources/application.properties`, configure os parâmetros do banco Oracle:
   ```
   spring.datasource.url=${ORCL_URL}
   spring.datasource.username=${ORCL_USERNAME}
   spring.datasource.password=${ORCL_PASSWORD}
   spring.jpa.hibernate.ddl-auto=update    # ou conforme sua estratégia

   ```
2. (Opcional) Ajustes adicionais como porta, perfil (dev/prod), logs, etc.

## 🚀 Executando o projeto

### Opção 1 — Rodando pelo IDE (classe Main)

Execute a classe `DashmottuApplication` no seu ambiente de desenvolvimento (IDE de sua preferência).

### Opção 2 — Pela linha de comando

```
mvn clean package
java -jar target/dashmottu-0.0.1-SNAPSHOT.jar
```

Por padrão, a aplicação será iniciada na porta 8080 ([http://localhost:8080](http://localhost:8080 "‌")), a menos que configurado de outra forma.

## 📌 Endpoints

### Pátio

MétodoEndpointDescrição
GET`/patio`  -  Lista todos os pátios cadastrados  
GET`/patio/{id}`  -  Busca um pátio por ID  
POST`/patio`  -  Cria novo pátio (informe `imagemPlantaUrl` e objeto `endereco`)  
POST`/patio/{id}/motos?id={motoId}`  -  Associa uma moto existente ao pátio  
PUT`/patio/{id}`  -  Atualiza dados do pátio  
DELETE`/patio/{id}`  -  Remove um pátio do sistema

### Moto

MétodoEndpointDescrição  
GET`/moto`  -  Lista todas as motos cadastradas  
POST`/moto`  -  Cria nova moto (informe `codTag`, `modelo`, `placa`, `status`)  
PUT`/moto/{id}` -  Atualiza dados da moto  
PUT`/moto?codTag={codTag}`  -  Atualiza a localização de uma moto (passa `posicaoX`, `posicaoY` no corpo)  
DELETE`/moto/{id}`  -  Remove uma moto do sistema  


## 🧪 Testes / Uso via Postman

1. Importe a _collection_ no Postman (ex: com nome “DashMottu API”).  
2. Configure a variável `{{dashmottu}}` para apontar para a URL base da API (ex: `http://localhost:8080/api` ou `http://localhost:8080`).  
3. Teste na ordem recomendada:  
   1. Criar um pátio (POST `/patio`)  
   2. Criar uma moto (POST `/moto`)  
   3. Associar moto ao pátio (POST `/patio/{id}/motos?id={motoId}`)  
   4. Atualizar coordenadas da moto (PUT `/moto?codTag=…`)  
   5. Listar pátios e motos (GET `/patio`, GET `/moto`)  
   6. Outras operações: atualizar, deletar, etc.  

## 🧭 Fluxo recomendado

1. Criar pátio
2. Criar moto
3. Associar moto → pátio
4. Atualizar localização da moto
5. Verificar via listagens que tudo foi persistido corretamente

## 🗂 Estrutura do repositório

```
.
├── src
│   ├── main
│   │   ├── java/… — código-fonte
│   │   └── resources
│   │       └── application.properties
├── Dockerfile
├── pom.xml
└── README.md
```
