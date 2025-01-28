# 🚀 API com Quarkus e H2 Console  

Este projeto é uma API desenvolvida em **Quarkus 3.17.8**, utilizando **Java 17**, **Banco de Dados H2** e **Hibernate ORM**. Como o Quarkus não suporta mais o **H2 Console nativamente**, implementamos uma solução personalizada para acessá-lo manualmente.  

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
- **Java JDK 17** ([Baixar](https://adoptium.net/))
- **Maven** ([Baixar](https://maven.apache.org/download.cgi))
- **Quarkus CLI** (opcional, para facilitar comandos)
  ```sh
  npm install -g @quarkusio/quarkus-cli
  ```

---

### **2️⃣ Clonar o repositório**
```sh
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio
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
O projeto utiliza um banco **H2 em memória** (`mem:pessoa_db`). Para garantir que ele seja criado corretamente, configuramos o `application.properties`:

```properties
# Configuração do Banco de Dados H2
quarkus.datasource.db-kind=h2
quarkus.datasource.jdbc.url=jdbc:h2:mem:pessoa_db;DB_CLOSE_DELAY=-1;INIT=CREATE SCHEMA IF NOT EXISTS PESSOA
quarkus.datasource.username=sa
quarkus.datasource.password=sa

# Configuração do Hibernate ORM
quarkus.hibernate-orm.database.generation=drop-and-create
```

Isso garante que o **banco não seja perdido** durante a execução.

---

## 🔍 **Acessar o H2 Console**
Como o **Quarkus 3.17.8 não suporta mais o H2 Console nativamente**, criamos um **endpoint customizado** para iniciar o console do H2:

📌 **Acesse o console do H2:**  
👉 [`http://localhost:8082`](http://localhost:8082)  

📌 **JDBC URL para conexão:**  
```
jdbc:h2:mem:pessoa_db
```
📌 **Usuário:** `sa`  
📌 **Senha:** *(em branco)*  

Caso queira verificar se o console está ativo via API:
👉 [`http://localhost:8080/h2-console`](http://localhost:8080/h2-console)  

---

## 🔧 **Endpoints Disponíveis**
A API expõe os seguintes endpoints:

### 🔹 **/pessoas**
- `POST /pessoas` → Cadastra uma nova pessoa  
- `GET /pessoas` → Retorna todas as pessoas  
- `GET /pessoas/older-than-25` → Retorna pessoas com mais de 25 anos  
- `GET /pessoas/{nome}` → Retorna pessoa pelo nome  

### 🔹 **/hello**
- `GET /hello` → Teste de conexão da API  

---

## 🛠 **Estrutura do Projeto**
```bash
📂 src
 ┣ 📂 main
 ┃ ┣ 📂 java
 ┃ ┃ ┣ 📂 br.com.meuprojeto
 ┃ ┃ ┃ ┣ 📜 Application.java
 ┃ ┃ ┃ ┣ 📜 PessoaResource.java
 ┃ ┃ ┃ ┣ 📜 H2ConsoleResource.java   # Inicia o H2 Console
 ┃ ┣ 📂 resources
 ┃ ┃ ┣ 📜 application.properties    # Configuração do Banco de Dados
```

---

## 🚀 **Como Contribuir**
1. **Faça um fork** do projeto  
2. **Crie uma branch** para sua feature  
   ```sh
   git checkout -b minha-feature
   ```
3. **Commit suas alterações**  
   ```sh
   git commit -m "Adiciona nova feature"
   ```
4. **Envie para o repositório remoto**  
   ```sh
   git push origin minha-feature
   ```
5. **Crie um Pull Request!** 🎉  

---

## 📄 **Licença**
Este projeto é distribuído sob a licença **MIT**.  

---

## 📞 **Contato**
📌 **Criado por:** *Seu Nome*  
📧 *seuemail@email.com*  
🌐 *[LinkedIn](https://linkedin.com/in/seu-perfil)*  

Se tiver dúvidas ou sugestões, abra uma **issue**! 🚀🔥  
