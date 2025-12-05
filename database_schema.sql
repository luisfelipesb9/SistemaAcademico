DROP DATABASE IF EXISTS sistema_academico;
CREATE DATABASE sistema_academico;
USE sistema_academico;

CREATE TABLE cursos (
    id INT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    creditos INT NOT NULL
) ENGINE=InnoDB;

CREATE TABLE professores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    titulacao VARCHAR(50),
    id_curso INT NOT NULL,
    FOREIGN KEY (id_curso) REFERENCES cursos(id)
) ENGINE=InnoDB;

CREATE TABLE alunos (
    id INT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    ano_nascimento INT NOT NULL,
    id_curso INT NOT NULL,
    FOREIGN KEY (id_curso) REFERENCES cursos(id)
) ENGINE=InnoDB;

CREATE TABLE matriculas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_aluno INT NOT NULL,
    id_curso INT NOT NULL,
    data_matricula DATE DEFAULT CURRENT_DATE,
    FOREIGN KEY (id_aluno) REFERENCES alunos(id) ON DELETE CASCADE,
    FOREIGN KEY (id_curso) REFERENCES cursos(id)
) ENGINE=InnoDB;

INSERT INTO cursos (id, nome, creditos) VALUES
(1, 'Sistemas de Informação', 3000),
(2, 'Engenharia Civil', 3600),
(3, 'Direito', 3700),
(4, 'Medicina', 7200),
(5, 'Engenharia de Software', 3200),
(6, 'Arquitetura e Urbanismo', 3600),
(7, 'Psicologia', 4000),
(8, 'Administração', 3000),
(9, 'Ciência da Computação', 3200),
(10, 'Odontologia', 4500);

INSERT INTO professores (nome, titulacao, id_curso) VALUES
('Dr. João Silva', 'Doutorado', 2),
('Msc. Pedro Santos', 'Mestrado', 1),
('Dra. Maria Oliveira', 'Doutorado', 3),
('Dr. Roberto Campos', 'Doutorado', 4),
('Msc. Ana Pereira', 'Mestrado', 5),
('Esp. Lucas Costa', 'Especialista', 8),
('Dra. Fernanda Lima', 'Doutorado', 7),
('Msc. Bruno Souza', 'Mestrado', 6),
('Dr. Carlos Mendes', 'Doutorado', 10),
('Msc. Juliana Rocha', 'Mestrado', 9);

INSERT INTO alunos (id, nome, cpf, ano_nascimento, id_curso) VALUES
(100012345, 'Carlos Souza', '111.111.111-11', 2000, 1),
(100023456, 'Fernanda Lima', '222.222.222-22', 2001, 1),
(100034567, 'Roberto Alves', '333.333.333-33', 1999, 2),
(100045678, 'Julia Martins', '444.444.444-44', 2002, 4),
(100056789, 'Lucas Pereira', '555.555.555-55', 2003, 5),
(100067890, 'Ana Costa', '666.666.666-66', 2000, 3),
(100078901, 'Bruno Rocha', '777.777.777-77', 2001, 8),
(100089012, 'Carla Dias', '888.888.888-88', 2002, 7),
(100090123, 'Daniel Gomes', '999.999.999-99', 1998, 2),
(100001234, 'Elena Silva', '101.101.101-01', 2004, 1),
(100011111, 'Fabio Junior', '121.212.121-21', 1999, 5),
(100022222, 'Gabriela Nunes', '131.313.313-31', 2003, 4),
(100033333, 'Hugo Santos', '141.414.414-41', 2000, 6),
(100044444, 'Isabela Moraes', '151.515.515-51', 2001, 9),
(100055555, 'Jorge Amado', '161.616.616-61', 2002, 3),
(100066666, 'Kelly Key', '171.717.717-71', 2003, 8),
(100077777, 'Luan Santana', '181.818.818-81', 2000, 7),
(100088888, 'Maria Gadú', '191.919.919-91', 1999, 6),
(100099999, 'Neymar Jr', '202.020.202-02', 2004, 10),
(100010101, 'Oscar Niemeyer', '212.121.212-12', 1998, 6);

INSERT INTO matriculas (id_aluno, id_curso) VALUES
(100012345, 1),
(100023456, 1),
(100034567, 2),
(100045678, 4),
(100056789, 5),
(100067890, 3),
(100078901, 8),
(100089012, 7),
(100090123, 2),
(100001234, 1),
(100011111, 5),
(100022222, 4),
(100033333, 6),
(100044444, 9),
(100055555, 3),
(100066666, 8),
(100077777, 7),
(100088888, 6),
(100099999, 10),
(100010101, 6);