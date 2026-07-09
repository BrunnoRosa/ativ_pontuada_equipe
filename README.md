# Ativ_pontuada_equipe
Atividade Pontuada Final, será realizada em equipe de 5 integrantes.

---

# 👩‍💻👨‍💻 Integrantes da Equipe:
* **Bruno Rosa da Silva** - TechLeader - Dev. BackEnd

* **Geovane Ferreira** - Dev. BackEnd

* **Camila Viana** - Dev. FrontEnd 

* **Guilherme Silva de Souza** - Dev. FrontEnd

* **Michell Silva Santos** - Dev. BackEnd

---

# 🛠️ Projeto AOE - Sistema de Gestão Operacional e Manutenção

![Status do Projeto](https://img.shields.io/badge/Status-Em_Desenvolvimento-yellow)
![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green)
![React](https://img.shields.io/badge/React-18-blue)

## 📌 Sobre o Projeto

O **AOE** é uma plataforma corporativa desenvolvida para otimizar o acompanhamento, abertura e gestão de **Ordens de Serviço de Manutenção** e **Relatórios de Incidentes** em ativos industriais e operacionais (como turbinas de compressão, brocas de perfuração e geradores).

O objetivo do sistema é garantir que falhas operacionais sejam registradas rapidamente, categorizadas por nível de criticidade e processadas pela equipe responsável de forma eficiente e sem atritos de comunicação.

---

## 🛠️ Tecnologias Utilizadas

### **Back-End**
* **Linguagem:** Java 21
* **Framework:** Spring Boot 3
* **Segurança:** Spring Security (com suporte a CORS habilitado)
* **Persistência de Dados:** Spring Data JPA / Hibernate
* **Validação:** Jakarta Bean Validation (`@Valid`, `@NotBlank`, `@NotNull`)
* **Gerenciador de Dependências:** Maven (com Maven Wrapper `mvnw` incluso)

### **Front-End**
* **Biblioteca Principal:** React.js
* **Comunicação HTTP:** Axios
* **Roteamento:** React Router DOM
* **Formulários e Validação:** React Hook Form e Yup
* **Notificações:** React Toastify
* **Estilização:** CSS3 nativo com suporte a modo escuro/claro (*Dark Mode*)

---

## 📁 Estrutura do Repositório

```text
ativ_pontuada_equipe/
├── ProjetoFinalBackEnd/        # Aplicação Spring Boot (API REST)
│   ├── .mvn/                   # Configuração local do Maven Wrapper
│   ├── src/                    # Código-fonte Java (Controller, Service, DTO, Model,Repository,Config,Exception)
│   ├── mvnw / mvnw.cmd         # Executáveis do Maven Wrapper
│   └── pom.xml                 # Gerenciamento de dependências Java
│
└── ProjetoFinalFrontEnd/       # Aplicação Web em React
    ├── src/
    │   ├── components/         # Componentes visuais
    │   ├── pages/              # Telas da aplicação (ex: SolicitacaoManutencao)
    │   └── services/           # Configuração do Axios e chamadas de API
    └── package.json            # Dependências do Node.js
                                #
```
---
## Como Subir o Sistema

### 💻 Rodando o Back-end:

🛠️ Tecnologias Utilizadas

Java 17 / Spring Boot 3.x
Spring Data JPA / Spring Web
Docker e H2 (Ambiente de Banco de Dados)
ReactJS / Vite
Axios
[CSS Modules / Tailwind CSS]
🚀 Como Executar o Projeto

Clonar e preparar o ambiente: Clone o repositório: git clone https://github.com/BrunnoRosa/ativ_pontuada.equipe.git Entre na pasta do projeto: cd ativ_tech_nexus

Executar o Back-end & Banco de Dados: Inicie o banco de dados no Docker: docker-compose up -d Entre na pasta do back-end: cd backend Instale as dependências e compile: ./mvnw clean install Inicie a API Spring Boot: ./mvnw spring-boot:run

Executar o Front-end: Abra um novo terminal e entre na pasta do front-end: cd frontend Instale as dependências: npm install Instale as dependências: npm install react-router-dom Instale as dependências: npm install axios react-toastify Inicie o servidor de desenvolvimento: npm run dev

### 💻 Rodando o Front-end:

### Pré-requisitos
Antes de começar, certifique-se de ter o [Node.js](https://nodejs.org/) instalado na sua máquina.

### Passo a passo

1. Pelo terminal, navegue até a pasta do front-end do projeto:
```bash
   cd front-projeto-AOE
```

2. Instale todas as dependências do projeto:
```bash
    npm i react-router-dom axios react-toastify yup react-hook-form @hookform/resolvers
    npm i
```

3. Inicie o servidor de desenvolvimento:
```bash
    npm run dev
```

4. Inicie o servidor de desenvolvimento:


    Abra o seu navegador e acesse http://localhost:5174





