package com.example.jsp.model.daoi;

import com.example.jsp.model.vo.VoFornecedor;

public interface DaoiFornecedor extends BaseDao<VoFornecedor> {

	@Override
	<T> T consultarTodos() throws Exception;

	@Override
	<T> T consultar(String... values) throws Exception;

	@Override
	VoFornecedor consultarPorId(Long id) throws Exception;

	@Override
	VoFornecedor cadastrar(VoFornecedor newObject, String... values) throws Exception;

	@Override
	boolean alterar(VoFornecedor object) throws Exception;

	@Override
	boolean excluirPorID(Long id) throws Exception;
}
