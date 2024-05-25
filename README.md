Script para criação de tabelas

CREATE TABLE Cliente (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    nome NVARCHAR(255) NOT NULL,
    idade INT NOT NULL,
    email NVARCHAR(255) NOT NULL,
    numero_conta NVARCHAR(50) NOT NULL
);

CREATE TABLE Movimentacao (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    cliente_id BIGINT NOT NULL,
    tipo NVARCHAR(10) CHECK (tipo IN ('credito', 'debito')),  
    valor DECIMAL(10, 2) NOT NULL,  
    data_movimentacao DATETIME NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES Cliente(id) ON DELETE CASCADE
);

