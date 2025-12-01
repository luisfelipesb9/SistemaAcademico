DROP DATABASE IF EXISTS sistema_academico;
CREATE DATABASE sistema_academico;
USE sistema_academico;

-- Table: Cursos
CREATE TABLE cursos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    creditos INT NOT NULL -- Agora representa Horas
) ENGINE=InnoDB;

-- Table: Professores (Vinculados a um curso)
CREATE TABLE professores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    titulacao VARCHAR(50),
    id_curso INT NOT NULL,
    FOREIGN KEY (id_curso) REFERENCES cursos(id)
) ENGINE=InnoDB;

-- Table: Alunos
CREATE TABLE alunos (
    id INT PRIMARY KEY, -- Número de Matrícula (RA) - Formato 1000xxxxx
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    ano_nascimento INT NOT NULL,
    id_curso INT NOT NULL,
    FOREIGN KEY (id_curso) REFERENCES cursos(id)
) ENGINE=InnoDB;

-- Table: Matriculas (Aluno -> Curso)
CREATE TABLE matriculas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_aluno INT NOT NULL,
    id_curso INT NOT NULL,
    data_matricula DATE DEFAULT CURRENT_DATE,
    FOREIGN KEY (id_aluno) REFERENCES alunos(id) ON DELETE CASCADE,
    FOREIGN KEY (id_curso) REFERENCES cursos(id)
) ENGINE=InnoDB;

-- ==========================================
-- INSERÇÃO DE DADOS (DATA SEEDING)
-- ==========================================

-- 1. Inserir Cursos
INSERT INTO cursos (nome, creditos) VALUES
('Sistemas de Informação', 3000),
('Engenharia Civil', 3600),
('Direito', 3700),
('Medicina', 7200),
('Engenharia de Software', 3200),
('Arquitetura e Urbanismo', 3600),
('Psicologia', 4000),
('Administração', 3000),
('Ciência da Computação', 3200),
('Odontologia', 4500);

-- 2. Inserir Professores (Vinculados a Cursos)
INSERT INTO professores (nome, titulacao, id_curso) VALUES
('Dr. João Silva', 'Doutorado', 2), -- Civil
('Msc. Pedro Santos', 'Mestrado', 1), -- SI
('Dra. Maria Oliveira', 'Doutorado', 3), -- Direito
('Dr. Roberto Campos', 'Doutorado', 4), -- Medicina
('Msc. Ana Pereira', 'Mestrado', 5), -- Eng Software
('Esp. Lucas Costa', 'Especialista', 8), -- Adm
('Dra. Fernanda Lima', 'Doutorado', 7), -- Psicologia
('Msc. Bruno Souza', 'Mestrado', 6), -- Arq
('Dr. Carlos Mendes', 'Doutorado', 10), -- Odonto
('Msc. Juliana Rocha', 'Mestrado', 9); -- CC

-- 3. Inserir Alunos (IDs 1000xxxxx)
INSERT INTO alunos (id, nome, cpf, ano_nascimento, id_curso) VALUES
(100012345, 'Carlos Souza', '111.111.111-11', 2000, 1),
(100054321, 'Fernanda Lima', '222.222.222-22', 2001, 1),
(100098765, 'Roberto Alves', '333.333.333-33', 1999, 2),
(100011111, 'Julia Martins', '444.444.444-44', 2002, 4),
(100022222, 'Lucas Pereira', '555.555.555-55', 2003, 5),
(100033333, 'Ana Costa', '666.666.666-66', 2000, 3),
(100044444, 'Bruno Rocha', '777.777.777-77', 2001, 8),
(100055555, 'Carla Dias', '888.888.888-88', 2002, 7),
(100066666, 'Daniel Gomes', '999.999.999-99', 1998, 2),
(100077777, 'Elena Silva', '101.101.101-01', 2004, 1),
(100088888, 'Fabio Junior', '121.212.121-21', 1999, 5),
(100099999, 'Gabriela Nunes', '131.313.313-31', 2003, 4),
(100010101, 'Hugo Santos', '141.414.414-41', 2000, 6),
(100020202, 'Isabela Moraes', '151.515.515-51', 2001, 9),
(100030303, 'Jorge Amado', '161.616.616-61', 2002, 3),
(100040404, 'Kelly Key', '171.717.717-71', 2003, 8),
(100050505, 'Luan Santana', '181.818.818-81', 2000, 7),
(100060606, 'Maria Gadú', '191.919.919-91', 1999, 6),
(100070707, 'Neymar Jr', '202.020.202-02', 2004, 10),
(100080808, 'Oscar Niemeyer', '212.121.212-12', 1998, 6);

-- 4. Inserir Matrículas (Aluno -> Curso)
INSERT INTO matriculas (id_aluno, id_curso) VALUES
(100012345, 1),
(100054321, 1),
(100098765, 2),
(100011111, 4),
(100022222, 5),
(100033333, 3),
(100044444, 8),
(100055555, 7),
(100066666, 2),
(100077777, 1),
(100088888, 5),
(100099999, 4),
(100010101, 6),
(100020202, 9),
(100030303, 3),
(100040404, 8),
(100050505, 7),
(100060606, 6),
(100070707, 10),
(100080808, 6);
