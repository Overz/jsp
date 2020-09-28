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