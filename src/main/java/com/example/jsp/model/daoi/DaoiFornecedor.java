package com.example.jsp.model.daoi;

import com.example.jsp.model.vo.VoFornecedor;
import java.util.List;

public interface DaoiFornecedor extends BaseDao<VoFornecedor> {

	@Override
	List<VoFornecedor> consultarTodos();

	@Override
	<T> T consultar(String... values);

	@Override
	VoFornecedor consultarPorId(Long id);

	@Override
	VoFornecedor cadastrar(VoFornecedor newObject, String... values);

	@Override
	boolean alterar(VoFornecedor object);

	@Override
	boolean excluirPorID(Long id);
}
