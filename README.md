# ativ_pontuada_equipe
Atividade Pontuada Final, será realizada em equipe de 5 integrantes.

---

# 👩‍💻👨‍💻 Integrantes da Equipe:
* **Bruno Rosa da Silva** - TechLeader - Dev. BackEnd

* **Geovane Ferreira** - Dev. BackEnd

* **Camila Viana** - Dev. FrontEnd 

* **Guilherme Silva de Souza** - Dev. FrontEnd

* **Michell Silva Santos** Dev. BackEnd

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

---




