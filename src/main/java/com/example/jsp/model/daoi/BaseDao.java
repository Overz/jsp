package com.example.jsp.model.daoi;

import java.util.List;

public interface BaseDao<T> {

	/**
	 * Método para consultar tudo o que há no db;
	 *
	 * @return ArrayList<?>
	 */
	List<T> consultarTodos();

	/**
	 * @param values Array String
	 * @param <T>    Valor Indefinido
	 * @return Retorno Indefinido
	 */
	<T> T consultar(String... values);

	/**
	 * Consulta algo especifico através de um id;
	 *
	 * @param id: Long
	 * @return object
	 */
	T consultarPorId(Long id);

	/**
	 * Método para cadastrar;
	 *
	 * @param newObject: Object
	 * @return newObject
	 */
	T cadastrar(T newObject, String... values);

	/**
	 * Método para altera/atualizar;
	 *
	 * @param object: Object
	 * @return boolean
	 */
	boolean alterar(T object);

	/**
	 * Método para excluir;
	 *
	 * @param id: Long
	 * @return boolean
	 */
	boolean excluirPorID(Long id);
}
