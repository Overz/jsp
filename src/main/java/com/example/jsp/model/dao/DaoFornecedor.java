package com.example.jsp.model.dao;

import com.example.jsp.model.conn.GetConnection;
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
			f.setId(rs.getInt("id"));
			f.setNome(rs.getString("nome"));
			f.setEmail(rs.getString("email"));
			f.setTelefone(rs.getString("telefone"));
			f.setDescricao(rs.getString("descricao"));
			f.setDtCadastro(rs.getDate("dtcadastro"));
			return f;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public <T> T consultarTodos() throws Exception {
		try {
			String qry = "select * from fornecedor";
			list = new ArrayList<>();
			conn = GetConnection.abrirConexao();
			ps = GetConnection.getPreparedStatement(conn, qry, PreparedStatement.RETURN_GENERATED_KEYS);

			rs = ps.executeQuery();
			while (rs.next()) {
				f = criarResultset(rs);
				list.add(f);
			}

			return (T) list;
		} catch (Exception e) {
			System.out.println(e.getClass().getSimpleName());
			System.out.println(e.getMessage());
		} finally {
			GetConnection.fecharConexao(conn, ps, rs);
		}
		return null;
	}

	@Override
	public <T> T consultar(String... values) throws Exception {
		qry = "select * from fornecedor where nome like ?";
		list = new ArrayList<>();
		try {
			conn = GetConnection.abrirConexao();
			ps = conn.prepareStatement(qry, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, "%" + values[ 0 ] + "%");

			rs = ps.executeQuery();
			while (rs.next()) {
				f = criarResultset(rs);
				list.add(f);
			}
			return (T) list;
		} catch (Exception e) {
			System.out.println(e.getClass().getSimpleName());
			System.out.println(e.getMessage());
		} finally {
			GetConnection.fecharConexao(conn, ps, rs);
		}
		return null;
	}

	@Override
	public VoFornecedor consultarPorId(Long id) throws Exception {
		qry = "select * from fornecedor where id=?";
		try {
			conn = GetConnection.abrirConexao();
			ps = GetConnection.getPreparedStatement(conn, qry, PreparedStatement.RETURN_GENERATED_KEYS);

			ps.setLong(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				return criarResultset(rs);
			}
		} catch (SQLException e) {
			System.out.println(e.getClass().getSimpleName());
			System.out.println(e.getMessage());
		} finally {
			GetConnection.fecharConexao(conn, ps, rs);
		}
		return null;
	}

	@Override
	public VoFornecedor cadastrar(VoFornecedor newObject, String... values) throws Exception {
		try {
			qry = "insert into fornecedor (nome, email, telefone, descricao, dtCadastro) values (?,?,?,?,?)";

			conn = GetConnection.abrirConexao();
			ps = GetConnection.getPreparedStatement(conn, qry, PreparedStatement.RETURN_GENERATED_KEYS);

			ps.setString(1, newObject.getNome());
			ps.setString(2, newObject.getEmail());
			ps.setString(3, newObject.getTelefone());
			ps.setString(4, newObject.getDescricao());
			ps.setDate(5, new Date(newObject.getDtCadastro().getTime()));

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
			GetConnection.fecharConexao(conn, ps, rs);
		}
		return null;
	}

	@Override
	public boolean alterar(VoFornecedor object) throws Exception {
		try {
			qry = "update fornecedor set nome=?, email=?, telefone=?, descricao=?, dtCadastro=? where id=?";

			conn = GetConnection.abrirConexao();
			ps = GetConnection.getPreparedStatement(conn, qry, PreparedStatement.RETURN_GENERATED_KEYS);

			ps.setString(1, object.getNome());
			ps.setString(2, object.getEmail());
			ps.setString(3, object.getTelefone());
			ps.setString(4, object.getDescricao());
			ps.setDate(5, new Date(object.getDtCadastro().getTime()));
			ps.setLong(6, object.getId());

			return ps.executeUpdate() == GetConnection.CODIGO_RETORNO_SUCESSO;
		} catch (SQLException e) {
			System.out.println(e.getClass().getSimpleName());
			System.out.println(e.getMessage());
		} finally {
			GetConnection.fecharConexao(conn, ps, rs);
		}
		return false;
	}

	@Override
	public boolean excluirPorID(Long id) throws Exception {
		String qry = "delete from fornecedor where id=?";

		conn = GetConnection.abrirConexao();
		ps = GetConnection.getPreparedStatement(conn, qry, PreparedStatement.RETURN_GENERATED_KEYS);

		try {
			ps.setLong(1, id);

			if (ps.executeUpdate() == GetConnection.CODIGO_RETORNO_SUCESSO) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println(e.getClass().getSimpleName());
			System.out.println(e.getMessage());
		} finally {
			GetConnection.fecharConexao(conn, ps, rs);
		}
		return false;
	}
}
