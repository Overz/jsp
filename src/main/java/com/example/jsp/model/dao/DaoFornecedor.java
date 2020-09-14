package com.example.jsp.model.dao;

import com.example.jsp.model.conn.GetMySqlConnection;
import com.example.jsp.model.daoi.DaoiFornecedor;
import com.example.jsp.model.vo.VoFornecedor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoFornecedor implements DaoiFornecedor {
	private String qry;
	private VoFornecedor f;
	private List<VoFornecedor> list;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	private VoFornecedor criarResultset(ResultSet rs) {
		try {
			f = new VoFornecedor();
			f.setId(rs.getLong("id"));
			f.setNome(rs.getString("nome"));
			f.setEmail(rs.getString("email"));
			f.setDescricao(rs.getString("descricao"));
			f.setDtCadastro(rs.getDate("dtcadastro"));

			return f;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			GetMySqlConnection.closeResultSet(rs);
		}
		return null;
	}


	@Override
	public List<VoFornecedor> consultarTodos() {
		try {
			String qry = "select * from fornecedor";
			list = new ArrayList<>();
			conn = GetMySqlConnection.openConnection();
			ps = GetMySqlConnection.getPreparedStatement(conn, qry, PreparedStatement.RETURN_GENERATED_KEYS);

			rs = ps.executeQuery();
			while (rs.next()) {
				f = criarResultset(rs);
				list.add(f);
			}

			return list;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public <T> T consultar(String... values) {
		return null;
	}

	@Override
	public VoFornecedor consultarPorId(Long id) {
		try {
			String qry = "select * from fornecedor where id=?";

			conn = GetMySqlConnection.openConnection();
			ps = GetMySqlConnection.getPreparedStatement(conn, qry, PreparedStatement.RETURN_GENERATED_KEYS);

			ps.setLong(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				f = criarResultset(rs);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			GetMySqlConnection.closeConnection(conn, ps, rs);
		}
		return null;
	}

	@Override
	public VoFornecedor cadastrar(VoFornecedor newObject, String... values) {
		try {
			qry = "insert into fornecedor (nome, email, descricao, dtCadastro) values (?,?,?,?)";

			conn = GetMySqlConnection.openConnection();
			ps = GetMySqlConnection.getPreparedStatement(conn, qry, PreparedStatement.RETURN_GENERATED_KEYS);

			ps.setString(1, newObject.getNome());
			ps.setString(2, newObject.getEmail());
			ps.setString(3, newObject.getDescricao());
			ps.setDate(4, new Date(newObject.getDtCadastro().getTime()));

			ps.execute();
			rs = ps.getGeneratedKeys();

			if (rs.next()) {
				Long id = rs.getLong(1);
				newObject.setId(id);
			}
			return newObject;
		} catch (SQLException e) {
			System.out.println(e.getClass().getSimpleName());
			System.out.println(e);
		} finally {
			GetMySqlConnection.closeConnection(conn, ps, rs);
		}
		return null;
	}

	@Override
	public boolean alterar(VoFornecedor object) {
		try {
			qry = "update fornecedor set nome=?, email=?, descricao=?, dtCadastro=? where id=?";

			conn = GetMySqlConnection.openConnection();
			ps = GetMySqlConnection.getPreparedStatement(conn, qry, PreparedStatement.RETURN_GENERATED_KEYS);

			ps.setString(1, object.getNome());
			ps.setString(2, object.getEmail());
			ps.setString(3, object.getDescricao());
			ps.setDate(4, new Date(object.getDtCadastro().getTime()));
			ps.setLong(5, object.getId());

			boolean res = ps.execute();
			rs = ps.getGeneratedKeys();

			if (rs.next()) {
				Long id = rs.getLong(1);
				object.setId(id);
			}
			return res;
		} catch (SQLException e) {
			System.out.println(e.getClass().getSimpleName());
			System.out.println(e);
		} finally {
			GetMySqlConnection.closeConnection(conn, ps, rs);
		}
		return false;
	}

	@Override
	public boolean excluirPorID(Long id) {
		String qry = "delete from fornecedor where id=?";

		conn = GetMySqlConnection.openConnection();
		ps = GetMySqlConnection.getPreparedStatement(conn, qry, PreparedStatement.RETURN_GENERATED_KEYS);

		try {
			ps.setLong(1, id);

			if (ps.executeUpdate() == GetMySqlConnection.CODIGO_RETORNO_SUCESSO) {
				return true;
			}
		} catch (SQLException e) {
			String method = "excluir(int id)";
			System.out.println("\n" + "Class: " + getClass().getSimpleName() + "\n" + "Method: " + method + "\n"
			                   + "Msg: " + e.getMessage() + "\n" + "Cause: " + e.getCause());
		} finally {
			GetMySqlConnection.closeConnection(conn, ps, rs);
		}
		return false;
	}
}
