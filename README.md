# 🧠 TaskWave API

**TaskWave** é uma API RESTful desenvolvida em **Java + Spring Boot** para gestão de projetos, tarefas e rotinas diárias — com foco em produtividade pessoal e de equipes.

O projeto foi pensado como uma ferramenta escalável e segura, com arquitetura em camadas, autenticação via JWT e estrutura preparada para deploy em nuvem.

---

## 🚀 Funcionalidades

- 🔐 Autenticação com JWT
- 👥 Usuários com múltiplos projetos
- 📌 Tarefas com status, prioridade, descrição e datas
- ✅ Subtarefas (checklists por tarefa)
- 🌀 Tarefas recorrentes e alertas de vencimento
- 📊 Dashboard resumido por projeto e produtividade
- 🛡️ Controle de permissões (dono, colaborador, visualizador)
- 📃 Documentação com Swagger (OpenAPI)

---

## 🧱 Tecnologias Utilizadas

| Área              | Stack                         |
|-------------------|-------------------------------|
| Linguagem         | Java 17                       |
| Framework         | Spring Boot                   |
| Segurança         | Spring Security + JWT         |
| Banco de dados    | PostgreSQL                    |
| ORM               | JPA + Hibernate               |
| Deploy            | Docker + Render               |
| Testes            | JUnit + Mockito               |
| Documentação API  | Swagger / OpenAPI             |
| CI/CD             | GitHub Actions (em breve)     |

---

## 🔧 Como rodar localmente

```
# Clone o repositório
git clone https://github.com/seu-usuario/taskwave-api.git
cd taskwave-api

# Configure o application.yml com seus dados do PostgreSQL

# Rode com Maven ou sua IDE
 ./mvnw spring-boot:run
```
---

## 📄 Documentação da API
Acesse /swagger-ui.html após subir o projeto localmente para ver os endpoints disponíveis e fazer testes via Swagger UI.


---
## 📫 Contato
Criado por Vitor K. Richter Alves
📧 vitor.1richter@gmail.com
🔗 LinkedIn | Portfólio


