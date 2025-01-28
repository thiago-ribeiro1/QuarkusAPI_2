# 🚀 API com Quarkus e H2 Console  

Este projeto é uma API desenvolvida em **Quarkus 3.17.8**, utilizando **Java 17**, **Banco de Dados H2** e **Hibernate ORM**. Como o Quarkus não suporta mais o **H2 Console nativamente**, implementei uma solução personalizada para acessá-lo manualmente.  

---

## 📌 **Tecnologias Utilizadas**
- [Quarkus 3.17.8](https://quarkus.io/)
- [Java 17](https://adoptium.net/)
- [H2 Database](https://www.h2database.com/)
- [Hibernate ORM](https://hibernate.org/orm/)
- [Maven](https://maven.apache.org/)

---

## 🔧 **Configuração e Instalação**

### **1️⃣ Pré-requisitos**
Antes de rodar o projeto, você precisará ter instalado:
- **Java JDK 17** ([Baixar](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html))
- **Maven** ([Baixar](https://maven.apache.org/download.cgi))
- **Quarkus CLI** (opcional, para facilitar comandos)

---

### **2️⃣ Clonar o repositório**
```sh
git clone https://github.com/thiago-ribeiro1/QuarkusAPI_2.git
cd QuarkusAPI_2
```

---

### **3️⃣ Instalar dependências**
```sh
mvn clean install
```

---

### **4️⃣ Rodar a aplicação**
```sh
mvn quarkus:dev
```

A API estará rodando em **http://localhost:8080** 🚀

---

## 🗄️ **Configuração do Banco de Dados H2**
O projeto utiliza um banco **H2 em memória** (`mem:pessoa`). Para garantir que ele seja criado corretamente, configuramos o `application.properties`:

```properties
# Configuração do Banco de Dados H2
quarkus.datasource.db-kind=h2
quarkus.datasource.jdbc.url=jdbc:h2:mem:pessoa;DB_CLOSE_DELAY=-1;INIT=CREATE SCHEMA IF NOT EXISTS PESSOA
quarkus.datasource.username=sa
quarkus.datasource.password=sa

# Configuração do Hibernate ORM
quarkus.hibernate-orm.database.generation=drop-and-create


```

Isso garante que o **banco não seja perdido** durante a execução.

---

## 🔍 **Acessar o H2 Console**
Como o **Quarkus 3.17.8 não suporta mais o H2 Console nativamente**, criei um **endpoint customizado** para iniciar o console do H2:

📌 **Acesse o console do H2:**  
👉 [`http://localhost:8082`](http://localhost:8082)  

📌 **JDBC URL para conexão:**  
```
jdbc:h2:mem:pessoa
```
📌 **Usuário:** `sa`  
📌 **Senha:** `sa`  

---

## 🔧 **Endpoints Disponíveis**
A API expõe os seguintes endpoints:

### 🔹 **/pessoas**
- `POST /pessoas` → Cadastra uma nova pessoa  
- `GET /pessoas` → Retorna todas as pessoas  
- `GET /pessoas/older-than-25` → Retorna pessoas com mais de 25 anos  
- `GET /pessoas/{nome}` → Retorna pessoa pelo nome  

---
