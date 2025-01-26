# DesafioTransações

### Sobre o Projeto
Este projeto foi inspirado em um desafio do banco Itau, onde o sistema deve simular **transações bancárias** e **análise** de estátisticas, além disso os dados devem ser armazenados
em memória, ou seja, não utilizar banco de dados. O Sistema foi desenvolvido com **SpringBoot 3** e conta com diversos conceitos, como:

---

- **Tests E2E**
- **Tests de Carga**
- **Documentação personalizada com Swagger**
- **Exceptions personalizadas**
- **Docker**
- **Logs**
- **Rota para checkar saúde da API**

---

### Como Rodar o Projeto com Docker?
Na branch `main`, você pode rodar o projeto utilizando **Docker**. Siga os passos abaixo:

---

### Instalação
<a href="https://www.docker.com/">Docker</a> - Instale o docker

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

- ### Acesse: http://localhost:8080/swagger-ui/index.html
  #
  ![image](https://github.com/Felipe-Tomazoti/TransacaoAPI/blob/main/src/main/java/br/com/FelipeTomazoti/desafioItau/img/imgSwagger.jpg)

