DROP TABLE IF EXISTS tb_protocolos;

CREATE TABLE tb_protocolos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(250) NOT NULL,
    email VARCHAR(60) NOT NULL,
    documento_id INT NOT NULL
);

INSERT INTO tb_protocolos (nome, email, documento_id) values
('Joao', 'joao@localhost.com', 88),
('Maria', 'maria@localhost.com', 66),
('Ze', 'ze@localhost.com', 34);