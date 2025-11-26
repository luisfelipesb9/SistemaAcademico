DROP DATABASE IF EXISTS sistema_academico;
CREATE DATABASE sistema_academico;
USE sistema_academico;

-- Table: Alunos
CREATE TABLE alunos (
    cpf VARCHAR(14) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    ano_nascimento INT NOT NULL
) ENGINE=InnoDB;

-- Table: Cursos
CREATE TABLE cursos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    creditos INT NOT NULL
) ENGINE=InnoDB;

-- Table: Professores
CREATE TABLE professores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    titulacao VARCHAR(50)
) ENGINE=InnoDB;

-- Table: Disciplinas
CREATE TABLE disciplinas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    carga_horaria INT NOT NULL,
    id_curso INT,
    FOREIGN KEY (id_curso) REFERENCES cursos(id)
) ENGINE=InnoDB;

-- Table: Turmas
CREATE TABLE turmas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_disciplina INT NOT NULL,
    id_professor INT NOT NULL,
    ano INT NOT NULL,
    semestre INT NOT NULL,
    FOREIGN KEY (id_disciplina) REFERENCES disciplinas(id),
    FOREIGN KEY (id_professor) REFERENCES professores(id)
) ENGINE=InnoDB;

-- Table: Matriculas
CREATE TABLE matriculas (
    id INT PRIMARY KEY,
    cpf_aluno VARCHAR(14) NOT NULL,
    id_turma INT NOT NULL,
    nota DECIMAL(5,2),
    frequencia INT,
    FOREIGN KEY (cpf_aluno) REFERENCES alunos(cpf),
    FOREIGN KEY (id_turma) REFERENCES turmas(id)
) ENGINE=InnoDB;

-- ==========================================
-- INSERÇÃO DE DADOS (DATA SEEDING)
-- ==========================================

-- 1. Inserir Cursos (Unimontes)
INSERT INTO cursos (nome, creditos) VALUES
('Administração', 200),
('Agronomia', 220),
('Artes Visuais', 180),
('Ciências Biológicas Bacharelado', 200),
('Ciências Biológicas Licenciatura', 190),
('Ciências Contábeis', 200),
('Ciências da Religião', 180),
('Ciências Econômicas', 200),
('Ciências Sociais', 190),
('Cinema e Audiovisual', 180),
('Direito', 240),
('Educação Física Bacharelado', 180),
('Educação Física Licenciatura', 180),
('Enfermagem', 240),
('Engenharia Civil', 250),
('Engenharia de Sistemas', 240),
('Engenharia Elétrica e Eletrônica', 250),
('Engenharia Florestal', 230),
('Farmácia', 220),
('Filosofia', 180),
('Física Licenciatura', 190),
('Geografia Bacharelado', 190),
('Geografia Licenciatura', 190),
('História', 190),
('Inteligência Artificial', 200),
('Letras Espanhol', 180),
('Letras Inglês', 180),
('Letras Português', 180),
('Matemática', 190),
('Medicina', 300),
('Medicina Veterinária', 250),
('Música', 180),
('Odontologia', 240),
('Pedagogia', 180),
('Psicologia', 220),
('Serviço Social', 180),
('Sistemas de Informação', 200),
('Teatro', 180),
('Tecnologia em Gestão do Agronegócio', 160),
('Tecnologia em Gestão Pública', 160),
('Zootecnia', 220);

-- 2. Inserir Professores Genéricos
INSERT INTO professores (nome, titulacao) VALUES
('Dr. João Silva', 'Doutorado'),
('Dra. Maria Oliveira', 'Doutorado'),
('Msc. Pedro Santos', 'Mestrado'),
('Dr. Ana Costa', 'Doutorado'),
('Msc. Lucas Pereira', 'Mestrado'),
('Dr. Roberto Almeida', 'Doutorado'),
('Dra. Fernanda Lima', 'Doutorado'),
('Msc. Juliana Martins', 'Mestrado'),
('Dr. Carlos Souza', 'Doutorado'),
('Msc. Paulo Rocha', 'Mestrado');

-- 3. Inserir Alunos Genéricos
INSERT INTO alunos (cpf, nome, ano_nascimento) VALUES
('111.111.111-11', 'Carlos Souza', 2000),
('222.222.222-22', 'Fernanda Lima', 2001),
('333.333.333-33', 'Roberto Alves', 1999),
('444.444.444-44', 'Julia Martins', 2002),
('555.555.555-55', 'Marcos Paulo', 2000),
('666.666.666-66', 'Ana Clara', 2001),
('777.777.777-77', 'Pedro Henrique', 1998),
('888.888.888-88', 'Mariana Costa', 2003),
('999.999.999-99', 'Lucas Gabriel', 2000),
('000.000.000-00', 'Beatriz Silva', 2002);

-- 4. Inserir Disciplinas (Vinculadas a alguns cursos)
-- IDs dos cursos podem variar se a lista acima mudar, mas como é sequencial:
-- 15: Eng Civil, 16: Eng Sistemas, 30: Medicina, 11: Direito, 1: Adm
INSERT INTO disciplinas (nome, carga_horaria, id_curso) VALUES
('Cálculo I', 60, 15),
('Algoritmos e Estrutura de Dados', 60, 16),
('Anatomia Humana', 90, 30),
('Direito Constitucional', 60, 11),
('Teoria Geral da Administração', 60, 1),
('Física I', 60, 15),
('Banco de Dados', 60, 36), -- Sistemas de Informação
('História da Arte', 45, 3), -- Artes Visuais
('Genética', 60, 4), -- Bio Bacharelado
('Programação Orientada a Objetos', 60, 16);

-- 5. Inserir Turmas
INSERT INTO turmas (id_disciplina, id_professor, ano, semestre) VALUES
(1, 1, 2024, 1), -- Cálculo I com Dr. João
```sql
DROP DATABASE IF EXISTS sistema_academico;
CREATE DATABASE sistema_academico;
USE sistema_academico;

-- Table: Alunos
CREATE TABLE alunos (
    cpf VARCHAR(14) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    ano_nascimento INT NOT NULL
) ENGINE=InnoDB;

-- Table: Cursos
CREATE TABLE cursos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    creditos INT NOT NULL
) ENGINE=InnoDB;

-- Table: Professores
CREATE TABLE professores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    titulacao VARCHAR(50)
) ENGINE=InnoDB;

-- Table: Disciplinas
CREATE TABLE disciplinas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    carga_horaria INT NOT NULL,
    id_curso INT,
    FOREIGN KEY (id_curso) REFERENCES cursos(id)
) ENGINE=InnoDB;

-- Table: Turmas
CREATE TABLE turmas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_disciplina INT NOT NULL,
    id_professor INT NOT NULL,
    ano INT NOT NULL,
    semestre INT NOT NULL,
    FOREIGN KEY (id_disciplina) REFERENCES disciplinas(id),
    FOREIGN KEY (id_professor) REFERENCES professores(id)
) ENGINE=InnoDB;

-- Table: Matriculas
CREATE TABLE matriculas (
    id INT PRIMARY KEY,
    cpf_aluno VARCHAR(14) NOT NULL,
    id_turma INT NOT NULL,
    nota DECIMAL(5,2),
    frequencia INT,
    FOREIGN KEY (cpf_aluno) REFERENCES alunos(cpf),
    FOREIGN KEY (id_turma) REFERENCES turmas(id)
) ENGINE=InnoDB;

-- ==========================================
-- INSERÇÃO DE DADOS (DATA SEEDING)
-- ==========================================

-- 1. Inserir Cursos (Unimontes)
INSERT INTO cursos (nome, creditos) VALUES
('Administração', 200),
('Agronomia', 220),
('Artes Visuais', 180),
('Ciências Biológicas Bacharelado', 200),
('Ciências Biológicas Licenciatura', 190),
('Ciências Contábeis', 200),
('Ciências da Religião', 180),
('Ciências Econômicas', 200),
('Ciências Sociais', 190),
('Cinema e Audiovisual', 180),
('Direito', 240),
('Educação Física Bacharelado', 180),
('Educação Física Licenciatura', 180),
('Enfermagem', 240),
('Engenharia Civil', 250),
('Engenharia de Sistemas', 240),
('Engenharia Elétrica e Eletrônica', 250),
('Engenharia Florestal', 230),
('Farmácia', 220),
('Filosofia', 180),
('Física Licenciatura', 190),
('Geografia Bacharelado', 190),
('Geografia Licenciatura', 190),
('História', 190),
('Inteligência Artificial', 200),
('Letras Espanhol', 180),
('Letras Inglês', 180),
('Letras Português', 180),
('Matemática', 190),
('Medicina', 300),
('Medicina Veterinária', 250),
('Música', 180),
('Odontologia', 240),
('Pedagogia', 180),
('Psicologia', 220),
('Serviço Social', 180),
('Sistemas de Informação', 200),
('Teatro', 180),
('Tecnologia em Gestão do Agronegócio', 160),
('Tecnologia em Gestão Pública', 160),
('Zootecnia', 220);

-- 2. Inserir Professores Genéricos
INSERT INTO professores (nome, titulacao) VALUES
('Dr. João Silva', 'Doutorado'),
('Dra. Maria Oliveira', 'Doutorado'),
('Msc. Pedro Santos', 'Mestrado'),
('Dr. Ana Costa', 'Doutorado'),
('Msc. Lucas Pereira', 'Mestrado'),
('Dr. Roberto Almeida', 'Doutorado'),
('Dra. Fernanda Lima', 'Doutorado'),
('Msc. Juliana Martins', 'Mestrado'),
('Dr. Carlos Souza', 'Doutorado'),
('Msc. Paulo Rocha', 'Mestrado');

-- 3. Inserir Alunos Genéricos
INSERT INTO alunos (cpf, nome, ano_nascimento) VALUES
('111.111.111-11', 'Carlos Souza', 2000),
('222.222.222-22', 'Fernanda Lima', 2001),
('333.333.333-33', 'Roberto Alves', 1999),
('444.444.444-44', 'Julia Martins', 2002),
('555.555.555-55', 'Marcos Paulo', 2000),
('666.666.666-66', 'Ana Clara', 2001),
('777.777.777-77', 'Pedro Henrique', 1998),
('888.888.888-88', 'Mariana Costa', 2003),
('999.999.999-99', 'Lucas Gabriel', 2000),
('000.000.000-00', 'Beatriz Silva', 2002);

-- 4. Inserir Disciplinas (Vinculadas a alguns cursos)
-- IDs dos cursos podem variar se a lista acima mudar, mas como é sequencial:
-- 15: Eng Civil, 16: Eng Sistemas, 30: Medicina, 11: Direito, 1: Adm
INSERT INTO disciplinas (nome, carga_horaria, id_curso) VALUES
('Cálculo I', 60, 15),
('Algoritmos e Estrutura de Dados', 60, 16),
('Anatomia Humana', 90, 30),
('Direito Constitucional', 60, 11),
('Teoria Geral da Administração', 60, 1),
('Física I', 60, 15),
('Banco de Dados', 60, 36), -- Sistemas de Informação
('História da Arte', 45, 3), -- Artes Visuais
('Genética', 60, 4), -- Bio Bacharelado
('Programação Orientada a Objetos', 60, 16);

-- 5. Inserir Turmas
INSERT INTO turmas (id_disciplina, id_professor, ano, semestre) VALUES
(1, 1, 2024, 1), -- Cálculo I com Dr. João
(2, 3, 2024, 1), -- Algoritmos com Msc. Pedro
(3, 2, 2024, 1), -- Anatomia com Dra. Maria
(7, 5, 2024, 1), -- BD com Msc. Lucas
(10, 3, 2024, 1); -- POO com Msc. Pedro

-- 6. Inserir Matrículas
INSERT INTO matriculas (id, cpf_aluno, id_turma, nota, frequencia) VALUES
(100000001, '111.111.111-11', 2, 85.5, 90), -- Carlos em Algoritmos
(100000002, '222.222.222-22', 2, 90.0, 100), -- Fernanda em Algoritmos
(100000003, '333.333.333-33', 1, 70.0, 85), -- Roberto em Cálculo
(100000004, '444.444.444-44', 3, 95.0, 100), -- Julia em Anatomia
(100000005, '555.555.555-55', 4, 80.0, 90), -- Marcos em BD
(100000006, '999.999.999-99', 5, 100.0, 100); -- Lucas em POO
```