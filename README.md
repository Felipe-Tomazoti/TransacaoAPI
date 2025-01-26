# DesafioTransações

### Sobre o Projeto
Este projeto foi inspirado em um desafio do banco Itaú, onde o sistema deve simular **transações bancárias** e **análise** de estatísticas. Além disso, os dados devem ser armazenados em memória, ou seja, não utilizar banco de dados. O sistema foi desenvolvido com **SpringBoot 3** e conta com diversos conceitos, como:

---

- **Testes E2E**
- **Testes de Carga**
- **Documentação personalizada com Swagger**
- **Exceções personalizadas**
- **Docker**
- **Logs**
- **Rota para checar a saúde da API**

---

### Como Rodar o Projeto com Docker?
Siga os passos abaixo:

---

### Instalação
<a href="https://www.docker.com/">Docker</a> - Instale o Docker

---

### 1. Clone o Repositório:
   ```bash
   git clone https://github.com/Felipe-Tomazoti/TransacaoAPI.git
   cd desafio-itau
  ```
### 2. Execute o comando:
  ```bash
   mvn clean install
  ```
### 3. Depois de gerado o arquivo .jar, certifique-se de que o Docker está rodando.
### 4. **Suba o container:**
   ```bash
   docker-compose up --build
  ```
![image](https://github.com/Felipe-Tomazoti/TransacaoAPI/blob/main/src/main/java/br/com/FelipeTomazoti/desafioItau/img/imgDocker.jpg)

---

### Documentação com Swagger:

- #### Acesse: http://localhost:8080/swagger-ui/index.html
  ![image](https://github.com/Felipe-Tomazoti/TransacaoAPI/blob/main/src/main/java/br/com/FelipeTomazoti/desafioItau/img/imgSwagger.jpg)

---

### Como rodar os testes E2E?

### Com a aplicação parada, execute o comando:
  ```bash
   mvn test
  ```

---

### Para rodar o teste de carga, execute:
   ```bash
   mvn gatling:test
  ```
#### Depois de executado o comando, irá surgir um arquivo chamado "index.html" na pasta target/gatling/transacaosavessimulation/
![image](https://github.com/Felipe-Tomazoti/TransacaoAPI/blob/main/src/main/java/br/com/FelipeTomazoti/desafioItau/img/imgGatling.jpg)

---

### Como checar a saúde da API?
- #### Acesse: http://localhost:8080/actuator/health
![image](https://github.com/Felipe-Tomazoti/TransacaoAPI/blob/main/src/main/java/br/com/FelipeTomazoti/desafioItau/img/imgHealth.jpg)

---

### Muito obrigado pela sua atenção e tenha um ótimo dia!

---

# TransactionsChallenge

### About the Project
This project was inspired by a challenge from Itaú Bank, where the system must simulate **bank transactions** and **statistics analysis**. Additionally, the data must be stored in memory, meaning no database should be used. The system was developed with **SpringBoot 3** and includes several concepts such as:

---

- **E2E Tests**
- **Load Tests**
- **Custom Documentation with Swagger**
- **Custom Exceptions**
- **Docker**
- **Logs**
- **Route to Check API Health**

---

### How to Run the Project with Docker?
Follow the steps below:

---

### Installation
<a href="https://www.docker.com/">Docker</a> - Install Docker

---

### 1. Clone the Repository:
   ```bash
   git clone https://github.com/Felipe-Tomazoti/TransacaoAPI.git
   cd desafio-itau
  ```
### 2. Execute the command:
  ```bash
   mvn clean install
  ```
### 3. After the .jar file is generated, ensure Docker is running.
### 4. **Start the container:**
   ```bash
   docker-compose up --build
  ```
![image](https://github.com/Felipe-Tomazoti/TransacaoAPI/blob/main/src/main/java/br/com/FelipeTomazoti/desafioItau/img/imgDocker.jpg)

---

### Documentation with Swagger:

- #### Access: http://localhost:8080/swagger-ui/index.html
  ![image](https://github.com/Felipe-Tomazoti/TransacaoAPI/blob/main/src/main/java/br/com/FelipeTomazoti/desafioItau/img/imgSwagger.jpg)

---

### How to Run E2E Tests?

### With the application stopped, execute the command:
  ```bash
   mvn test
  ```

---

### To Run the Load Test, Execute:
   ```bash
   mvn gatling:test
  ```
#### After executing the command, a file named "index.html" will appear in the folder target/gatling/transacaosavessimulation/
![image](https://github.com/Felipe-Tomazoti/TransacaoAPI/blob/main/src/main/java/br/com/FelipeTomazoti/desafioItau/img/imgGatling.jpg)

---

### How to Check the API Health?
- #### Access: http://localhost:8080/actuator/health
![image](https://github.com/Felipe-Tomazoti/TransacaoAPI/blob/main/src/main/java/br/com/FelipeTomazoti/desafioItau/img/imgHealth.jpg)

---

### Thank you very much for your attention and have a great day!


