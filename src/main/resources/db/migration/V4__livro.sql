CREATE TABLE IF NOT EXISTS livro
(
    id        INT          NOT NULL AUTO_INCREMENT,
    nome      VARCHAR(255) NOT NULL,
    autor     VARCHAR(100) NOT NULL,
    editora   VARCHAR(255) NOT NULL,
    anoEdicao INT          NOT NULL,
    descricao VARCHAR(255),

    CONSTRAINT pk_livro PRIMARY KEY (id)

) ENGINE = InnoDB;