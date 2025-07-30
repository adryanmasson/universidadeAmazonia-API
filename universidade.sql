-- Criação do banco de dados
CREATE DATABASE IF NOT EXISTS universidade;
USE universidade;

-- Tabela curso
CREATE TABLE curso (
    id_curso INT AUTO_INCREMENT PRIMARY KEY,
    nivel VARCHAR(50) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    ano INT NOT NULL
);

-- Inserindo dados na tabela curso
INSERT INTO curso (nivel, nome, ano) VALUES 
('Graduação', 'Ciência da Computação', 2025),
('Pós-Graduação', 'Mestrado em Engenharia de Software', 2025);

-- Tabela usuario (aluno ou professor) com senha
CREATE TABLE usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    tipo ENUM('aluno', 'professor') NOT NULL,      -- Tipo do usuário
    identificador VARCHAR(20) NOT NULL UNIQUE,     -- RA ou RP (único entre todos)
    nome VARCHAR(100) NOT NULL,
    senha VARCHAR(255) NOT NULL                    -- Senha com hash
);

-- Inserindo dados na tabela usuario (com senha hashada)
INSERT INTO usuario (tipo, identificador, nome, senha) VALUES 
('aluno', 'RA123456', 'João Silva', '$2a$10$M9t/D1gYaF7sYPfSTBjmW.yu4aPTvh8jj.fRAh19bD59rq.IQW3Yi'),  -- Exemplo de senha hashada
('aluno', 'RA789101', 'Maria Oliveira', '$2a$10$M9t/D1gYaF7sYPfSTBjmW.yu4aPTvh8jj.fRAh19bD59rq.IQW3Yi'),  -- Exemplo de senha hashada
('professor', 'RP111213', 'Carlos Souza', '$2a$10$M9t/D1gYaF7sYPfSTBjmW.yu4aPTvh8jj.fRAh19bD59rq.IQW3Yi'), -- Exemplo de senha hashada
('professor', 'RP141516', 'Ana Pereira', '$2a$10$WBWiuhtF1a1ODEKmfn9BRePTYnTLyyWRWby0y/e63jTfL1vdaoqF6'); -- Exemplo de senha hashada

-- Tabela materia
CREATE TABLE materia (
    id_materia INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

-- Inserindo dados na tabela materia
INSERT INTO materia (nome) VALUES
('Matemática Discreta'),
('Algoritmos e Estruturas de Dados'),
('Banco de Dados'),
('Sistemas Operacionais');

-- Tabela materia_curso (relacionamento entre matérias e cursos)
CREATE TABLE materia_curso (
    id_mc INT AUTO_INCREMENT PRIMARY KEY,
    id_materia INT NOT NULL,
    id_curso INT NOT NULL,
    FOREIGN KEY (id_materia) REFERENCES materia(id_materia),
    FOREIGN KEY (id_curso) REFERENCES curso(id_curso)
);

-- Inserindo dados na tabela materia_curso
INSERT INTO materia_curso (id_materia, id_curso) VALUES
(1, 1), -- Matemática Discreta no curso Ciência da Computação
(2, 1), -- Algoritmos e Estruturas de Dados no curso Ciência da Computação
(3, 1), -- Banco de Dados no curso Ciência da Computação
(4, 2); -- Sistemas Operacionais no curso Mestrado em Engenharia de Software

-- Tabela materia_aluno (com id único agora)
CREATE TABLE materia_aluno (
    id_materia_aluno INT AUTO_INCREMENT PRIMARY KEY,
    id_aluno INT NOT NULL,
    id_materia INT NOT NULL,
    np1 DECIMAL(5,2),
    np2 DECIMAL(5,2),
    rep DECIMAL(5,2),
    exame DECIMAL(5,2),
    FOREIGN KEY (id_aluno) REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_materia) REFERENCES materia(id_materia)
);

-- Inserindo dados na tabela materia_aluno
INSERT INTO materia_aluno (id_aluno, id_materia, np1, np2, rep, exame) VALUES
(1, 1, 7.5, 8.0, NULL, NULL), -- João Silva em Matemática Discreta
(1, 2, 6.0, 7.5, NULL, NULL), -- João Silva em Algoritmos
(2, 1, 9.0, 9.5, NULL, NULL), -- Maria Oliveira em Matemática Discreta
(2, 3, 7.0, 8.5, NULL, NULL); -- Maria Oliveira em Banco de Dados

-- Tabela materia_professor (relacionamento entre professores e matérias)
CREATE TABLE materia_professor (
    id_professor INT NOT NULL,
    id_materia INT NOT NULL,
    PRIMARY KEY (id_professor, id_materia),
    FOREIGN KEY (id_professor) REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_materia) REFERENCES materia(id_materia)
);

-- Inserindo dados na tabela materia_professor
INSERT INTO materia_professor (id_professor, id_materia) VALUES
(3, 1), -- Carlos Souza em Matemática Discreta
(3, 2), -- Carlos Souza em Algoritmos e Estruturas de Dados
(4, 3); -- Ana Pereira em Banco de Dados
