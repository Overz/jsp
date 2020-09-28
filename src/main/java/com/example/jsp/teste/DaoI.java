package com.example.jsp.teste;

public interface DaoI<T> {

	<T> T cadastrar();

	<T> T listar();
}
