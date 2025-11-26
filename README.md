# Sistema Acadêmico - PG1

## 1. Visão Geral do Projeto
Este projeto consiste em um **Sistema de Gerenciamento Acadêmico** desenvolvido como requisito da disciplina de Programação 1. O objetivo é fornecer uma aplicação desktop para o controle de alunos, professores, cursos, disciplinas, turmas e matrículas de uma instituição de ensino.

O sistema foi construído com foco na **integridade dos dados**, **usabilidade** e **boas práticas de engenharia de software**, utilizando padrões de projeto consagrados.

---

## 2. Tecnologias Utilizadas
*   **Linguagem de Programação:** Java (JDK 17+)
*   **Interface Gráfica (GUI):** Java Swing
*   **Banco de Dados:** MariaDB / MySQL
*   **Conectividade:** JDBC (Java Database Connectivity)
*   **IDE Recomendada:** VS Code, NetBeans ou IntelliJ IDEA

---

## 3. Arquitetura do Sistema
O projeto segue rigorosamente o padrão de arquitetura **MVC (Model-View-Controller)** combinado com o padrão **DAO (Data Access Object)** para persistência de dados.

### 3.1. Estrutura de Pacotes
A organização do código reflete a arquitetura escolhida:

*   `br.unimontes.ccet.dcc.pg1.view`: **Camada de Visão**. Contém as telas (JFrames) e componentes visuais. É responsável apenas pela interação com o usuário.
    *   Ex: `TelaPrincipal.java`, `TelaGerenciarAlunos.java`.
*   `br.unimontes.ccet.dcc.pg1.controller`: **Camada de Controle**. Intermedia a comunicação entre a View e o Model, contendo regras de negócio específicas.
    *   Ex: `CadastrarAlunoController.java`.
*   `br.unimontes.ccet.dcc.pg1.model.dao`: **Camada de Dados (DAO)**. Responsável por executar os comandos SQL (INSERT, UPDATE, DELETE, SELECT) no banco de dados.
    *   Ex: `AlunoDao.java`, `CursoDao.java`.
*   `br.unimontes.ccet.dcc.pg1.model.dao.entity`: **Entidades (Model)**. Classes POJO (Plain Old Java Objects) que representam as tabelas do banco.
    *   Ex: `Aluno.java`, `Curso.java`.
*   `br.unimontes.ccet.dcc.pg1.model.dao.service`: **Serviços Utilitários**. Classes auxiliares para validações e lógica compartilhada.
    *   Ex: `Utils.java` (Validação de CPF e Datas).

### 3.2. Padrão Singleton
A classe `DB.java` implementa o padrão **Singleton** para garantir que apenas uma instância de conexão com o banco de dados seja criada durante a execução, otimizando recursos.

---

## 4. Banco de Dados
O sistema utiliza um banco relacional com as seguintes tabelas principais:

1.  **Alunos**: Armazena CPF (chave primária), nome e ano de nascimento.
2.  **Cursos**: Armazena os cursos de graduação.
3.  **Professores**: Armazena os docentes e suas titulações.
4.  **Disciplinas**: Matérias vinculadas a um curso.
5.  **Turmas**: Oferta de uma disciplina em um ano/semestre específico, ministrada por um professor.
6.  **Matrículas**: Tabela associativa que liga um Aluno a uma Turma, registrando nota e frequência.

*O script completo de criação e povoamento inicial do banco encontra-se no arquivo `database_schema.sql`.*

---

## 5. Funcionalidades Principais

### ✅ Gerenciamento de Alunos
*   Cadastro completo com validação de **CPF** (algoritmo oficial) e **Ano de Nascimento** (4 dígitos).
*   Listagem, edição e exclusão de alunos.
*   Proteção contra exclusão de alunos que possuem matrículas ativas (Integridade Referencial).

### ✅ Gerenciamento de Cursos e Disciplinas
*   Cadastro de cursos com carga horária.
*   Vinculação de disciplinas aos seus respectivos cursos.

### ✅ Gestão de Matrículas
*   Matrícula de alunos em turmas ofertadas.
*   Registro de notas e frequência.
*   Geração automática de IDs de matrícula.

### ✅ Dashboard
*   Tela principal com indicadores em tempo real:
    *   Total de Alunos
    *   Cursos Ativos
    *   Total de Matrículas

---

## 6. Guia de Instalação e Execução

Para rodar o projeto em sua máquina, siga os passos abaixo:

### Passo 1: Configurar o Banco de Dados
1.  Certifique-se de ter o **MariaDB** ou **MySQL** instalado.
2.  Abra seu cliente SQL (DBeaver, Workbench, HeidiSQL).
3.  Execute o script `database_schema.sql` contido na raiz do projeto.
    *   *Isso criará o banco `sistema_academico` e inserirá dados de teste.*

### Passo 2: Configurar a Conexão
1.  Abra o arquivo `src/br/unimontes/ccet/dcc/pg1/model/dao/DB.java`.
2.  Verifique as credenciais de conexão:
    ```java
    private String url = "jdbc:mariadb://localhost/sistema_academico";
    // Usuário padrão: "root", Senha padrão: "" (vazia)
    ```
3.  Se seu banco tiver senha, altere a linha:
    ```java
    db = DriverManager.getConnection(url, "root", "SUA_SENHA_AQUI");
    ```

### Passo 3: Executar a Aplicação
1.  Compile o projeto na sua IDE de preferência.
2.  Execute a classe principal: `br.unimontes.ccet.dcc.pg1.view.TelaLogin` (ou `TelaPrincipal` se o login estiver desabilitado para testes).

---

## 7. Considerações Finais
Este sistema atende a todos os requisitos propostos, demonstrando uma aplicação robusta de conceitos de Orientação a Objetos, persistência de dados e interface gráfica. O código está limpo, organizado e documentado, pronto para manutenção e expansão futura.

**Desenvolvido por:** Luis
**Disciplina:** Programação 1
