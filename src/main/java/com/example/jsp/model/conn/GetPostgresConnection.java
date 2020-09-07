package com.example.jsp.model.conn;

public class GetPostgresConnection {

	public static final int CODIGO_RETORNO_ERRO_EXCLUSAO = 0;
	public static final int CODIGO_RETORNO_SUCESSO = 1;
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String BANCO = "docker";
	private static final String CONEXAO = "jdbc:mysql://localhost:3306/" + BANCO
	                                      + "?useTimezone=true&serverTimezone=America/Sao_Paulo&zeroDateTimeBehavior=convertToNull";
	private static final String USUARIO = "cris";
	private static final String SENHA = "30752287";
}
