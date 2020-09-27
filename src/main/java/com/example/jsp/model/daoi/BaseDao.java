package com.example.jsp.model.daoi;

import java.util.List;

public interface BaseDao<T> {

	/**
	 * Método para consultar tudo o que há no db;
	 *
	 * @return ArrayList<?>
	 */
	<T> T consultarTodos() throws Exception;

	/**
	 * @param values Array String
	 * @param <T>    Valor Indefinido
	 * @return Retorno Indefinido
	 */
	<T> T consultar(String... values) throws Exception;

	/**
	 * Consulta algo especifico através de um id;
	 *
	 * @param id: Long
	 * @return object
	 */
	T consultarPorId(Long id) throws Exception;

	/**
	 * Método para cadastrar;
	 *
	 * @param newObject: Object
	 * @return newObject
	 */
	T cadastrar(T newObject, String... values) throws Exception;

	/**
	 * Método para altera/atualizar;
	 *
	 * @param object: Object
	 * @return boolean
	 */
	boolean alterar(T object) throws Exception;

	/**
	 * Método para excluir;
	 *
	 * @param id: Long
	 * @return boolean
	 */
	boolean excluirPorID(Long id) throws Exception;
}
