CREATE TABLE IF NOT EXISTS fornecedor
(
    id         INT          NOT NULL AUTO_INCREMENT,
    nome       VARCHAR(255) NOT NULL,
    email      VARCHAR(255) NOT NULL,
    telefone   VARCHAR(100) NOT NULL,
    descricao  VARCHAR(255),
    dtCadastro DATE         NOT NULL,

    CONSTRAINT pk_fornecedor PRIMARY KEY (id)

) Engine = InnoDB;