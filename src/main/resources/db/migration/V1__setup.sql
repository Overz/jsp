
CREATE TABLE IF NOT EXISTS fornecedor
(
    id         INT          NOT NULL AUTO_INCREMENT,
    nome       VARCHAR(255) NOT NULL,
    email      VARCHAR(255) NOT NULL,
    descricao  VARCHAR(255),
    dtCadastro DATE         NOT NULL,

    CONSTRAINT pk_fornecedor PRIMARY KEY (id)

) Engine = InnoDB;

CREATE TABLE IF NOT EXISTS produto
(
    id        INT          NOT NULL AUTO_INCREMENT,
    nome      TEXT NOT NULL,
    preco     DOUBLE       NOT NULL,
    estoque   INT          NOT NULL,
    codigo    INT          NOT NULL,
    descricao TEXT,

    CONSTRAINT pk_produto PRIMARY KEY (id)

) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS telefone
(

    id        INT          NOT NULL AUTO_INCREMENT,
    numero    VARCHAR(45)  NOT NULL,
    ddd       VARCHAR(3)   NOT NULL,
    operadora VARCHAR(45)  NOT NULL,
    contato   VARCHAR(255) NOT NULL,

    CONSTRAINT pk_telefone PRIMARY KEY (id)

) ENGINE = InnoDB;