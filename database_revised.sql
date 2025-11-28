DROP DATABASE IF EXISTS sistema_academico;
CREATE DATABASE sistema_academico;
USE sistema_academico;

-- Table: Cursos (Criada antes de Alunos para a FK)
CREATE TABLE cursos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    creditos INT NOT NULL
) ENGINE=InnoDB;

-- Table: Alunos
-- Alteração: ID (Matrícula) é PK. id_curso é FK.
CREATE TABLE alunos (
    id INT PRIMARY KEY, -- Número de Matrícula (RA)
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL, -- CPF agora é apenas dado, não PK
    ano_nascimento INT NOT NULL,
    id_curso INT NOT NULL,
    FOREIGN KEY (id_curso) REFERENCES cursos(id)
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

-- Table: Matriculas_Disciplinas (Renomeada para clareza)
-- Liga o Aluno (pelo ID/RA) à Turma
CREATE TABLE matriculas_disciplinas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_aluno INT NOT NULL, -- Referencia alunos(id)
    id_turma INT NOT NULL,
    nota DECIMAL(5,2) DEFAULT 0.0,
    frequencia INT DEFAULT 0,
    FOREIGN KEY (id_aluno) REFERENCES alunos(id) ON DELETE CASCADE,
    FOREIGN KEY (id_turma) REFERENCES turmas(id)
) ENGINE=InnoDB;

-- ==========================================
-- INSERÇÃO DE DADOS (DATA SEEDING)
-- ==========================================

-- 1. Inserir Cursos
INSERT INTO cursos (nome, creditos) VALUES
('Sistemas de Informação', 200),
('Engenharia Civil', 250),
('Direito', 240),
('Medicina', 300),
('Engenharia de Software', 210),
('Administração', 180),
('Psicologia', 220),
('Arquitetura e Urbanismo', 260),
('Educação Física', 160);

-- 2. Inserir Professores
INSERT INTO professores (nome, titulacao) VALUES
('Dr. João Silva', 'Doutorado'),
('Msc. Pedro Santos', 'Mestrado'),
('Dra. Maria Oliveira', 'Doutorado'),
('Dr. Roberto Campos', 'Doutorado'),
('Msc. Ana Pereira', 'Mestrado'),
('Esp. Lucas Costa', 'Especialista'),
('Dra. Fernanda Lima', 'Doutorado'),
('Msc. Bruno Souza', 'Mestrado'),
('Dr. Carlos Mendes', 'Doutorado'),
('Msc. Juliana Rocha', 'Mestrado');

-- 3. Inserir Alunos (Com IDs/RAs gerados e vinculados a cursos)
-- IDs simulando RAs: 2024001, 2024002...
INSERT INTO alunos (id, nome, cpf, ano_nascimento, id_curso) VALUES
(2024001, 'Carlos Souza', '111.111.111-11', 2000, 1), -- SI
(2024002, 'Fernanda Lima', '222.222.222-22', 2001, 1), -- SI
(2024003, 'Roberto Alves', '333.333.333-33', 1999, 2), -- Civil
(2024004, 'Julia Martins', '444.444.444-44', 2002, 4), -- Medicina
(2024005, 'Lucas Pereira', '555.555.555-55', 2003, 5), -- Eng. Software
(2024006, 'Ana Costa', '666.666.666-66', 2000, 3), -- Direito
(2024007, 'Bruno Rocha', '777.777.777-77', 2001, 6), -- Adm
(2024008, 'Carla Dias', '888.888.888-88', 2002, 7), -- Psicologia
(2024009, 'Daniel Gomes', '999.999.999-99', 1998, 2), -- Civil
(2024010, 'Elena Silva', '101.101.101-01', 2004, 1), -- SI
(2024011, 'Fabio Junior', '121.212.121-21', 1999, 5), -- Eng. Software
(2024012, 'Gabriela Nunes', '131.313.313-31', 2003, 4), -- Medicina
(2024013, 'Hugo Santos', '141.414.414-41', 2000, 8), -- Arq
(2024014, 'Isabela Moraes', '151.515.515-51', 2001, 9), -- Ed. Física
(2024015, 'Jorge Amado', '161.616.616-61', 2002, 3), -- Direito
(2024016, 'Kelly Key', '171.717.717-71', 2003, 6), -- Adm
(2024017, 'Luan Santana', '181.818.818-81', 2000, 7), -- Psicologia
(2024018, 'Maria Gadú', '191.919.919-91', 1999, 8), -- Arq
(2024019, 'Neymar Jr', '202.020.202-02', 2004, 9), -- Ed. Física
(2024020, 'Oscar Niemeyer', '212.121.212-12', 1998, 8); -- Arq

-- 4. Inserir Disciplinas
INSERT INTO disciplinas (nome, carga_horaria, id_curso) VALUES
('Algoritmos', 60, 1),
('Banco de Dados', 60, 1),
('Cálculo I', 60, 2),
('Física I', 60, 2),
('Direito Constitucional', 90, 3),
('Direito Penal', 90, 3),
('Anatomia', 90, 4),
('Fisiologia', 90, 4),
('Engenharia de Requisitos', 60, 5),
('Testes de Software', 60, 5),
('Teoria Geral da Administração', 60, 6),
('Marketing', 60, 6),
('Psicologia Geral', 60, 7),
('Psicologia do Desenvolvimento', 60, 7),
('História da Arquitetura', 60, 8),
('Projeto Arquitetônico I', 90, 8),
('Anatomia Humana', 60, 9),
('Fisiologia do Exercício', 60, 9);

-- 5. Inserir Turmas
INSERT INTO turmas (id_disciplina, id_professor, ano, semestre) VALUES
(1, 2, 2024, 1), -- Algoritmos (Pedro)
(2, 2, 2024, 1), -- BD (Pedro)
(3, 1, 2024, 1), -- Cálculo (João)
(4, 1, 2024, 1), -- Física (João)
(5, 3, 2024, 1), -- D. Const (Maria)
(6, 3, 2024, 1), -- D. Penal (Maria)
(7, 4, 2024, 1), -- Anatomia (Roberto)
(8, 4, 2024, 1), -- Fisiologia (Roberto)
(9, 5, 2024, 1), -- Eng. Req (Ana)
(10, 5, 2024, 1), -- Testes (Ana)
(11, 6, 2024, 1), -- TGA (Lucas)
(12, 6, 2024, 1), -- Mkt (Lucas)
(13, 7, 2024, 1), -- Psic Geral (Fernanda)
(14, 7, 2024, 1), -- Psic Desenv (Fernanda)
(15, 8, 2024, 1), -- Hist Arq (Bruno)
(16, 8, 2024, 1), -- Proj Arq (Bruno)
(17, 9, 2024, 1), -- Anatomia Hum (Carlos)
(18, 9, 2024, 1); -- Fisio Ex (Carlos)

-- 6. Inserir Matrículas nas Disciplinas
INSERT INTO matriculas_disciplinas (id_aluno, id_turma, nota, frequencia) VALUES
(2024001, 1, 85.5, 90), -- Carlos em Algoritmos
(2024001, 2, 78.0, 85), -- Carlos em BD
(2024002, 1, 90.0, 100), -- Fernanda em Algoritmos
(2024002, 2, 92.5, 95), -- Fernanda em BD
(2024003, 3, 70.0, 85), -- Roberto em Cálculo
(2024003, 4, 65.0, 80), -- Roberto em Física
(2024004, 7, 95.0, 100), -- Julia em Anatomia
(2024004, 8, 98.0, 100), -- Julia em Fisiologia
(2024005, 9, 88.0, 90), -- Lucas em Eng. Req
(2024005, 10, 85.0, 92), -- Lucas em Testes
(2024006, 5, 75.0, 80), -- Ana em D. Const
(2024006, 6, 80.0, 85), -- Ana em D. Penal
(2024007, 11, 60.0, 75), -- Bruno em TGA
(2024007, 12, 70.0, 80), -- Bruno em Mkt
(2024008, 13, 90.0, 95), -- Carla em Psic Geral
(2024008, 14, 92.0, 98), -- Carla em Psic Desenv
(2024009, 3, 55.0, 70), -- Daniel em Cálculo (Reprovado nota)
(2024010, 1, 40.0, 50), -- Elena em Algoritmos (Reprovado nota e freq)
(2024011, 9, 100.0, 100), -- Fabio em Eng. Req
(2024012, 7, 85.0, 90), -- Gabriela em Anatomia
(2024013, 15, 78.0, 88), -- Hugo em Hist Arq
(2024014, 17, 82.0, 92), -- Isabela em Anatomia Hum
(2024015, 5, 68.0, 80), -- Jorge em D. Const
(2024016, 11, 72.0, 85), -- Kelly em TGA
(2024017, 13, 88.0, 90), -- Luan em Psic Geral
(2024018, 15, 95.0, 100), -- Maria em Hist Arq
(2024019, 17, 60.0, 75), -- Neymar em Anatomia Hum
(2024020, 16, 90.0, 95); -- Oscar em Proj Arq
