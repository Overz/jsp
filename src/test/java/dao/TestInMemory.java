package dao;

import com.example.jsp.model.conn.InMemoryDb;
import com.example.jsp.model.conn.Teste;
import com.example.jsp.model.dao.DaoInMemory;
import com.example.jsp.model.vo.VoFornecedor;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class TestInMemory extends Assert {

	@Test()
	@Ignore()
	public void a() {
		System.out.println("Cadastrar");
		VoFornecedor f = new VoFornecedor(null, "joaozinho", "a@a.com", "sei la", new Date());
		DaoInMemory dao = new DaoInMemory();
		f = dao.cadastrar(f);
		assertNotNull(f);
	}

	@Test()
	@Ignore()
	public void inmemory() throws SQLException {
		Connection con = InMemoryDb.openConnection();
		ArrayList<String> qry = new ArrayList<>();
		ArrayList<String> inserts = new ArrayList<>();

		qry.add("create table fornecedor ( " +
		        "id integer not null primary key autoincrement, " +
		        "nome text not null, " +
		        "email text not null, " +
		        "descricao text, " +
		        "dtcadastro text not null " +
		        ");");
		inserts.add("insert into fornecedor (nome, email, dtcadastro) " +
		            "values ('teste', 'a@a.com', '" + new Date().toString() + "');");
//		sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
//		      "VALUES (1, 'Paul', 32, 'California', 20000.00 );";
		InMemoryDb.createTable(con, qry);
		InMemoryDb.insertTable(con, inserts);
		ResultSet rs = InMemoryDb.selectTable(con, "select * from fornecedor");

		while (rs.next()) {
			int id = rs.getInt("id");
			String nome = rs.getString("nome");
			String email = rs.getString("email");
			String descricao = rs.getString("descricao");
			String dtcadastro = rs.getString("dtcadastro");
			System.out.println(id + "\n" + nome + "\n" +
			                   email + "\n" + descricao + "\n"
			                   + dtcadastro);
		}
	}

	@Test()
//	@Ignore()
	public void b() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection c = DriverManager.getConnection("jdbc:sqlite::memory");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			String sql = "create table fornecedor (" +
			             "id integer not null, " +
			             "nome text not null, " +
			             "email text not null, " +
			             "descricao text, " +
			             "dtcadastro text not null );";

			Statement stmt = c.createStatement();
			System.out.println(stmt.execute(sql));

			sql = "insert into fornecedor (id, nome, email, dtcadastro) " +
			      "values (1, 'teste', 'a@a.com', '" + new Date().toString() + "' );";
			stmt.executeUpdate(sql);

			ResultSet rs = stmt.executeQuery("SELECT * FROM fornecedor;");

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("nome");
				String age = rs.getString("email");
				String address = rs.getString("descricao");
				String salary = rs.getString("dtcadastro");

				System.out.println("ID = " + id);
				System.out.println("NAME = " + name);
				System.out.println("AGE = " + age);
				System.out.println("ADDRESS = " + address);
				System.out.println("SALwARY = " + salary);
				System.out.println();
			}
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test()
	public void c() throws SQLException {
		String sql = "CREATE TABLE COMPANY " +
		             "(ID INT PRIMARY KEY     NOT NULL," +
		             " NAME           TEXT    NOT NULL, " +
		             " AGE            INT     NOT NULL, " +
		             " ADDRESS        CHAR(50), " +
		             " SALARY         REAL)";

		ArrayList<String> create = new ArrayList<>();
		create.add(sql);

		sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
		      "VALUES (1, 'Paul', 32, 'California', 20000.00 );";
		ArrayList<String> update = new ArrayList<>();
		update.add(sql);

		Teste.createAndUpdate(create, update);
		ResultSet rs = Teste.select("select * from fornecedor");
		while (rs.next()) {
			System.out.println(rs.getInt("id"));
			System.out.println(rs.getString("nome"));
			System.out.println(rs.getString("email"));
			System.out.println(rs.getString("descricao"));
			System.out.println(rs.getString("dtcadastro"));
		}
	}
}
