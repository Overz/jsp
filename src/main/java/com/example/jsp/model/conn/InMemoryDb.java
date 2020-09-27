package com.example.jsp.model.conn;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;

//	https://www.sqlitetutorial.net/sqlite-java/sqlite-jdbc-driver/
//	https://www.tutorialspoint.com/sqlite/sqlite_java.htm
//	https://www.programcreek.com/java-api-examples/?api=org.sqlite.SQLiteConfig
public class InMemoryDb {

	private static final String DRIVER = "org.sqlite.JDBC";
	private static final String BANCO = "jdbc:sqlite::memory:";

	public static Connection openConnection() {
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(BANCO);
			conn.setAutoCommit(false);
			System.out.println("Connection: " + !conn.isClosed());
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

	public static void restoreFile(Connection conn, String path) {
		try {
			if (path == null || path.isEmpty()) throw new FileNotFoundException("Arquivo's não encontrado em: " + path);

			if (conn == null) conn = openConnection();

			Statement st = conn.createStatement();
			File file = new File(path);
			File[] files = file.listFiles();
			for (File f : files) {
				int i = st.executeUpdate("restore from " + f.getPath());
				if (i > 0) System.out.println("File restored!\nFile: " + f.getName());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void closeConnection(Connection conn, Statement ps, ResultSet rs) {
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

	public static Statement getStatment(Connection conn, String sql) {
		try {
			return conn.createStatement();
		} catch (Exception e) {
			System.out.println("Erro ao obter o PreparedStatement.");
			return null;
		}
	}

	public static void createTable(Connection conn, ArrayList<String> querys) {
		try {
			if (conn == null) conn = openConnection();

			Statement st = conn.createStatement();
			for (String qry : querys) {
				boolean res = st.execute(qry);
				System.out.println("Created: " + res);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}

	public static void insertTable(Connection conn, ArrayList<String> inserts) {
		try {
			if (conn == null) conn = openConnection();
			Statement st = conn.createStatement();

			for (String insert : inserts) {
				int i = st.executeUpdate(insert);
				if (i > 0) System.out.println("Updated!\n" + insert);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}

	public static ResultSet selectTable(Connection conn, String query) {
		try {
			if (conn == null) conn = openConnection();

			return conn.createStatement().executeQuery(query);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
