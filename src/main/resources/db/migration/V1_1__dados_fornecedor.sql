INSERT INTO fornecedor (nome, email, telefone, descricao, dtCadastro)
VALUES ('Teste A', 'a@a.com', '48999222534', 'asdasd', (select CURRENT_DATE));