DROP DATABASE IF EXISTS jsp;
CREATE SCHEMA IF NOT EXISTS jsp DEFAULT CHARACTER SET utf8;
USE jsp;

CREATE TABLE fornecedor
(
    id         INT          NOT NULL AUTO_INCREMENT,
    nome       VARCHAR(255) NOT NULL,
    email      VARCHAR(255) NOT NULL,
    descricao  VARCHAR(255),
    dtCadastro DATE         NOT NULL,

    CONSTRAINT pk_fornecedor PRIMARY KEY (id)
) Engine = InnoDB;

CREATE INDEX ix_pk_fornecedor ON fornecedor (id);