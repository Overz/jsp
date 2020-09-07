package com.example.jsp.model.conn;

import java.sql.*;

public class GetMySqlConnection {

	public static final int CODIGO_RETORNO_ERRO_EXCLUSAO = 0;
	public static final int CODIGO_RETORNO_SUCESSO = 1;
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String BANCO = "jsp";
	private static final String CONEXAO = "jdbc:mysql://localhost:3306/" + BANCO
	                                      + "?useTimezone=true&serverTimezone=America/Sao_Paulo&zeroDateTimeBehavior=convertToNull";
	private static final String USUARIO = "cris";
	private static final String SENHA = "30752287";

	/**
	 * Estabelece a conexão JBDC considerando as configurações da classe Banco.
	 *
	 * @return Connection um objeto de conexão JDBC.
	 * @throws ClassNotFoundException caso o nome completo de DRIVER_MYSQL esteja
	 *                                incorreto ou o driver JDBC do banco
	 *                                selecionado não foi adicionado ao projeto (via
	 *                                .jar ou dependência no pom.xml).
	 * @throws SQLException           caso a URL_CONEXAO, USUARIO e/ou SENHA estejam
	 *                                incorretos.
	 */
	public static Connection openConnection() {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(CONEXAO, USUARIO, SENHA);
		} catch (ClassNotFoundException e) {
			System.out.println("Classe do Driver não foi encontrada. Causa: " + e.getMessage());
			return null;
		} catch (SQLException e) {
			System.out.println("Erro ao obter a Connection. Causa: " + e.getMessage());
			System.out.println(e);
			System.out.println("Código: " + e.getErrorCode());
			System.out.println("Status SQL: " + e.getSQLState());
			System.out.println("Next Exception: " + e.getNextException());
			return null;
		}
	}

	public static void closeConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("Problema no fechamento da conexão. Causa: " + e.getMessage());
		}
	}

	/**
	 * Solicita um objeto Statement para uma conexão. Este objeto serve para
	 * executar as operações SQL.
	 * <p>
	 * Este método deve ser sempre chamado nos DAOs após a criação da expressão SQL,
	 * geralmente com os métodos execute(sql), executeUpdate(sql) ou
	 * executeQuery(sql), onde "sql" é do tipo String.
	 *
	 * @param conn uma conexão anteriormente criada.
	 * @return stmt um objeto do tipo Statement
	 * @throws SQLException
	 */
	public static Statement getStatement(Connection conn) {
		try {
			return conn.createStatement();
		} catch (SQLException e) {
			System.out.println("Erro ao obter o Statement. Causa: " + e.getMessage());
			return null;
		}
	}

	/**
	 * Fecha um objeto Statement anteriormente criado.
	 * <p>
	 * Este método deve ser sempre chamado nos DAOs após a execução da expressão
	 * SQL.
	 *
	 * @param stmt um objeto do tipo Statement
	 * @throws SQLException
	 */
	public static void closeStatement(Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			System.out.println("Problema no fechamento do Statement. Causa: " + e.getMessage());
		}
	}

	/**
	 * Solicita um objeto PreparedStatement para uma conexão. Este objeto serve para
	 * executar as operações SQL.
	 *
	 * @param conn uma conexão anteriormente criada.
	 * @return stmt um objeto do tipo PreparedStatement
	 * @throws SQLException
	 */
	public static PreparedStatement getPreparedStatement(Connection conn) {
		try {
//			PreparedStatement stmt = null;
			return null;
		} catch (Exception e) {
			System.out.println("Erro ao obter o PreparedStatement. Causa: " + e.getMessage());
			return null;
		}
	}

	/**
	 * Solicita um objeto PreparedStatement para uma conexão. Este objeto serve para
	 * executar as operações SQL.
	 *
	 * @param conn uma conexão anteriormente criada.
	 * @return stmt um objeto do tipo PreparedStatement
	 * @throws SQLException
	 */
	public static PreparedStatement getPreparedStatement(Connection conn, String sql) {
		try {
			return conn.prepareStatement(sql);
		} catch (Exception e) {
			System.out.println("Erro ao obter o PreparedStatement.");
			return null;
		}
	}

	public static PreparedStatement getPreparedStatement(Connection conn, String sql, int tipoRetorno) {
		try {
			return conn.prepareStatement(sql, tipoRetorno);
		} catch (Exception e) {
			System.out.println("Erro ao obter o PreparedStatement.");
			return null;
		}
	}

	/**
	 * Fecha um objeto PreparedStatement anteriormente criado.
	 * <p>
	 * Este método deve ser sempre chamado nos DAOs após a execução da expressão
	 * SQL.
	 *
	 * @param stmt um objeto do tipo PreparedStatement
	 * @throws SQLException
	 */
	public static void closePreparedStatement(Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			System.out.println("Problema no fechamento do PreparedStatement. Causa: " + e.getMessage());
		}
	}

	/**
	 * Fecha um objeto ResultSet anteriormente criado.
	 * <p>
	 * Este método deve ser sempre chamado nos DAOs após a consulta de todos os
	 * resultados e conversão para objetos.
	 *
	 * @param result um objeto do tipo ResultSet
	 * @throws SQLException
	 */
	public static void closeResultSet(ResultSet result) {
		try {
			if (result != null) {
				result.close();
			}
		} catch (SQLException e) {
			System.out.println("Problema no fechamento do ResultSet. Causa: " + e.getMessage());
		}
	}

	public static void closeConnection(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if (conn != null) {
				conn.close();
				System.out.println("Connection Closed!");
			}
			if (ps != null) {
				ps.close();
				System.out.println("PreparedStatement Closed!");
			}
			if (rs != null) {
				rs.close();
				System.out.println("ResulSet Closed!");
			}
		} catch (Exception e) {
			System.out.println("Erro no fechamento de toda a conexão");
			System.out.println(e.getMessage());
		}
	}
}
