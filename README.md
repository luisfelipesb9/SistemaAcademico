# Sistema Acadêmico - PG1

## 1. Visão Geral do Projeto
Este projeto consiste em um **Sistema de Gerenciamento Acadêmico** desenvolvido como requisito da disciplina de Programação 1. O objetivo é fornecer uma aplicação desktop para o controle de alunos, cursos, coordenadores e matrículas de uma instituição de ensino.

O sistema foi construído com foco na **integridade dos dados**, **usabilidade** e **boas práticas de engenharia de software**, utilizando padrões de projeto consagrados.

---

## 2. Tecnologias Utilizadas
*   **Linguagem de Programação:** Java (JDK 16+)
*   **Interface Gráfica (GUI):** Java Swing
*   **Banco de Dados:** MariaDB / MySQL
*   **Conectividade:** JDBC (Java Database Connectivity)
*   **IDE Recomendada:** VS Code

---

## 3. Arquitetura do Sistema
O projeto segue rigorosamente o padrão de arquitetura **MVC (Model-View-Controller)** combinado com o padrão **DAO (Data Access Object)** para persistência de dados.

### 3.1. Estrutura de Pacotes
```
src/br/unimontes/ccet/dcc/pg1/
├── controller/          ← Intermediário View-Service
├── model/
│   ├── service/         ← Regras de Negócio
│   └── dao/             ← Acesso a Dados
│       └── entity/      ← Entidades (POJOs)
└── view/
    ├── panels/          ← Painéis reutilizáveis
    └── components/      ← Componentes customizados (Placeholder, ZebraTable)
```

### 3.2. Fluxo de Dados
```
View → Controller → Service → DAO → Database
```

### 3.3. Padrão Singleton
A classe `DB.java` implementa o padrão **Singleton** para garantir uma única instância de conexão.

---

## 4. Banco de Dados
O sistema utiliza um banco relacional com as seguintes tabelas:

| Tabela | Descrição |
|--------|-----------|
| **cursos** | Cursos com ID sequencial (manual) e carga horária |
| **professores** | Coordenadores vinculados a cursos |
| **alunos** | Alunos com matrícula formato `1000XXXXX` |
| **matriculas** | Tabela associativa Aluno → Curso (CASCADE DELETE) |

*O script completo encontra-se em `database_schema.sql`.*

---

## 5. Funcionalidades Principais

### ✅ Gerenciamento de Alunos
*   Cadastro com validação de **CPF** (11 dígitos) e **Ano de Nascimento** (4 dígitos)
*   Matrícula gerada automaticamente no formato `1000XXXXX`
*   Pesquisa por nome ou matrícula com placeholder
*   Listagem, edição e exclusão

### ✅ Gerenciamento de Cursos
*   Cadastro com carga horária e vinculação de **Coordenador**
*   Pesquisa por nome, ID ou coordenador
*   IDs sequenciais (reutiliza IDs excluídos)
*   Proteção: não exclui curso com alunos vinculados

### ✅ Gestão de Matrículas
*   Matrícula automática ao cadastrar aluno
*   Pesquisa por nome, matrícula ou curso
*   Exclusão de matrícula remove o aluno (regra de negócio)

### ✅ Dashboard
*   Indicadores em tempo real: Total de Alunos, Cursos Ativos, Matrículas

### ✅ Melhorias Visuais
*   **Zebra Striping:** Linhas alternadas nas tabelas
*   **Tooltips:** Dicas em todos os botões
*   **Ícones Unicode:** 🔍 ➕ ✏️ 🗑️ 📋 ← 🔐
*   **Placeholders:** Campos com texto de dica

---

## 6. Componentes Customizados

| Componente | Descrição |
|------------|-----------|
| `PlaceholderTextField` | Campo de texto com placeholder |
| `PlaceholderPasswordField` | Campo de senha com placeholder visível |
| `ZebraTableRenderer` | Renderizador de linhas alternadas |

---

## 7. Guia de Instalação e Execução

### Passo 1: Configurar o Banco de Dados
```sql
SOURCE database_schema.sql;
```

### Passo 2: Configurar a Conexão (`src/db.properties`)
```properties
db.url=jdbc:mariadb://localhost/sistema_academico
db.user=root
db.password=
```

### Passo 3: Executar
**Via script:** `run_app.bat`  
**Via IDE:** Execute `br.unimontes.ccet.dcc.pg1.view.TelaLogin`

**Acesso:** Usuário `admin`, senha `123`

---

## 8. Considerações Finais
Sistema desenvolvido seguindo padrões MVC/DAO, com validações no Model, regras de negócio no Service e componentes visuais reutilizáveis.

**Desenvolvido por:** Luis  
**Disciplina:** Programação 1  
**Universidade:** UNIMONTES