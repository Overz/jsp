package com.example.jsp.model.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Teste {

	private static Connection c;

	public static void createAndUpdate(ArrayList<String> create, ArrayList<String> insert) {
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite::memory");
			c.setAutoCommit(false);

			Statement st = c.createStatement();

			for (String qry : create) {
				int res = st.executeUpdate(qry);
				System.out.println(res);
			}

			for (String in : insert) {
				st.executeUpdate(in);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static ResultSet select(String query) {
		try {
			Statement st = c.createStatement();
			return st.executeQuery(query);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
