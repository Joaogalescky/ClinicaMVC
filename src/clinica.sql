CREATE DATABASE clinica;

USE clinica;

CREATE TABLE Pessoa (
    idPessoa INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    dataNascimento DATE NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    rg VARCHAR(20) UNIQUE NOT NULL, 
    telefone VARCHAR(15),
    email VARCHAR(100) UNIQUE,
    endereco VARCHAR(255) NOT NULL
);

CREATE TABLE Profissional (
    idProfissional INT PRIMARY KEY AUTO_INCREMENT,
    idPessoa INT,
    especialidade VARCHAR(50) NOT NULL,
    crm_estado VARCHAR(2),
    crm_numero VARCHAR(6),
    horarioAtend TIME,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL,
    FOREIGN KEY (idPessoa) REFERENCES Pessoa(idPessoa)
) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;

CREATE TABLE Paciente (
    idPaciente INT AUTO_INCREMENT PRIMARY KEY,
    idPessoa INT,
    FOREIGN KEY (idPessoa) REFERENCES Pessoa(idPessoa)
);

CREATE TABLE Funcionario (
    idFuncionario INT AUTO_INCREMENT PRIMARY KEY,
    idPessoa INT,
	username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL,
    FOREIGN KEY (idPessoa) REFERENCES Pessoa(idPessoa)
);

CREATE TABLE Agendamento (
    idAgendamento INT AUTO_INCREMENT PRIMARY KEY,
    idPaciente INT,
    idProfissional INT,
    dataHoraAgendamento DATETIME NOT NULL,   -- Data e hora agendada
    status ENUM('Agendado', 'Cancelado', 'Concluído') DEFAULT 'Agendado',  -- Status do agendamento
    FOREIGN KEY (idPaciente) REFERENCES Paciente(idPaciente),
    FOREIGN KEY (idProfissional) REFERENCES Profissional(idProfissional)
);

CREATE TABLE Atendimento (
    idAtendimento INT AUTO_INCREMENT PRIMARY KEY,
    idAgendamento INT,
    dataHoraAtendimento DATETIME NOT NULL,   -- Data e hora do atendimento real
    observacoes TEXT,                         -- Observações sobre o atendimento
    status ENUM('Realizado', 'Cancelado', 'Em Andamento') DEFAULT 'Realizado', -- Status do atendimento
    FOREIGN KEY (idAgendamento) REFERENCES Agendamento(idAgendamento)
);

INSERT INTO Pessoa (nome, dataNascimento, cpf, rg, telefone, email, endereco) VALUES ('Henrique Barbosa Gomes', '1988-04-18', '11122233344', '555666777', '45999887766', 'henriquebarbosa@email.com', 'Rua Dos Ypes, 1224');
INSERT INTO Profissional (idPessoa, especialidade, crm_estado, crm_numero, horarioAtend, username, password) VALUES (1, 'Ortopedista', 'PR', '123456', '14:00:00', 'admin', 'admin123');

INSERT INTO Pessoa (nome, dataNascimento, cpf, rg, telefone, email, endereco) VALUES ('Valeria', '1997-08-06', '44455566677', '777888999', '45988776655', 'valeria@email.com', 'Rua Das Rosas, 754');
INSERT INTO Funcionario (idPessoa, username, password) VALUES (2, 'funcionario', 'funcionario');
