package com.example.jsp.model.conn;

import java.sql.*;

public class InMemoryDb {

//	https://www.sqlitetutorial.net/sqlite-java/sqlite-jdbc-driver/

	private static final String DRIVER = "org.sqlite.JDBC";
	private static final String BANCO = "jdbc:sqlite::memory:";

	public static Connection openConnection() {
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(BANCO);
			return conn;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro ao obter a Connection. Causa: " + e.getMessage());
			System.out.println("Código: " + e.getErrorCode());
			System.out.println("Status SQL: " + e.getSQLState());
			System.out.println("Next Exception: " + e.getNextException());
		} catch (ClassNotFoundException e1) {
			System.out.println("Erro ao encontrar a Classe. Causa: " + e1.getMessage());
			System.out.println("Classe: " + e1.getClass());
			System.out.println("Exception: " + e1.getException());
			System.out.println("Next Message: " + e1.getLocalizedMessage());
		}
		return null;
	}

	public static void closeConnection(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if (conn != null) {
				conn.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			System.out.println("Problema no fechamento da conexão. Causa: " + e.getMessage());
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
}
