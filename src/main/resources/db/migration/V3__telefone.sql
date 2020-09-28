CREATE TABLE IF NOT EXISTS telefone
(

    id        INT          NOT NULL AUTO_INCREMENT,
    numero    VARCHAR(45)  NOT NULL,
    ddd       VARCHAR(10)   NOT NULL,
    operadora VARCHAR(45)  NOT NULL,
    contato   VARCHAR(255) NOT NULL,

    CONSTRAINT pk_telefone PRIMARY KEY (id)

) ENGINE = InnoDB;