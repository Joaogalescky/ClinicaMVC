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
    idProfissional INT AUTO_INCREMENT PRIMARY KEY,
    idPessoa INT,
    especialidade VARCHAR(50) NOT NULL,
    horarioAtend TIME,
    FOREIGN KEY (idPessoa) REFERENCES Pessoa(idPessoa)
);

CREATE TABLE Paciente (
    idPaciente INT AUTO_INCREMENT PRIMARY KEY,
    idPessoa INT,
    FOREIGN KEY (idPessoa) REFERENCES Pessoa(idPessoa)
);

CREATE TABLE Funcionario (
    idFuncionario INT AUTO_INCREMENT PRIMARY KEY,
    idPessoa INT,
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

CREATE TABLE Usuario (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL
);

INSERT INTO Usuario (username, password) VALUES ('admin', 'admin123');