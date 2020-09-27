package com.example.jsp.model.dao;

import com.example.jsp.model.conn.GetConnection;
import com.example.jsp.model.daoi.DaoiTelefone;
import com.example.jsp.model.vo.VoTelefone;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoTelefone implements DaoiTelefone {

	private String qry;
	private List<VoTelefone> list;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private VoTelefone t;

	private VoTelefone criarResultSet(ResultSet rs) {
		try {
			t = new VoTelefone();
			t.setId(rs.getInt("id"));
			t.setNumero(rs.getString("numero"));
			t.setDdd(rs.getString("ddd"));
			t.setOperadora(rs.getString("operadora"));
			t.setContato(rs.getString("contato"));
			return t;
		} catch (Exception e) {
			System.out.println(e.getClass().getSimpleName());
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public <T> T consultarTodos() throws Exception {
		qry = "select * from telefone";
		list = new ArrayList<>();

		try {
			conn = GetConnection.abrirConexao();
			ps = conn.prepareStatement(qry, PreparedStatement.RETURN_GENERATED_KEYS);

			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(criarResultSet(rs));
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
		qry = "select * from telefone where operadora like ?";
		list = new ArrayList<>();
		try {
			conn = GetConnection.abrirConexao();
			ps = GetConnection.getPreparedStatement(conn, qry, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, "%" + values[ 0 ] + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(criarResultSet(rs));
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
	public VoTelefone consultarPorId(Long id) throws Exception {
		qry = "select * from telefone where id=?";
		list = new ArrayList<>();
		try {
			conn = GetConnection.abrirConexao();
			ps = conn.prepareStatement(qry, PreparedStatement.RETURN_GENERATED_KEYS);

			ps.setLong(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				return criarResultSet(rs);
			}
		} catch (Exception e) {
			System.out.println(e.getClass().getSimpleName());
			System.out.println(e.getMessage());
		} finally {
			GetConnection.fecharConexao(conn, ps, rs);
		}
		return null;
	}

	@Override
	public VoTelefone cadastrar(VoTelefone newObject, String... values) throws Exception {
		qry = "insert into telefone(numero, ddd, operadora, contato) values (?,?,?,?)";
		try {
			conn = GetConnection.abrirConexao();
			ps = conn.prepareStatement(qry, PreparedStatement.RETURN_GENERATED_KEYS);

			ps.setString(1, newObject.getNumero());
			ps.setString(2, newObject.getDdd());
			ps.setString(3, newObject.getOperadora());
			ps.setString(4, newObject.getContato());

			ps.executeUpdate();
			rs = ps.getGeneratedKeys();

			if (rs.next()) {
				newObject.setId(rs.getInt(1));
			}
			return newObject;
		} catch (Exception e) {
			System.out.println(e.getClass().getSimpleName());
			System.out.println(e.getMessage());
		} finally {
			GetConnection.fecharConexao(conn, ps, rs);
		}
		return null;
	}

	@Override
	public boolean alterar(VoTelefone object) throws Exception {
		qry = "update telefone set numero=?, operadora=?, ddd=?, contato=? where id=?";
		try {
			conn = GetConnection.abrirConexao();
			ps = conn.prepareStatement(qry, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, object.getNumero());
			ps.setString(2, object.getOperadora());
			ps.setString(3, object.getDdd());
			ps.setString(4, object.getContato());
			ps.setLong(5, object.getId());

			int i = ps.executeUpdate();
			return i == GetConnection.CODIGO_RETORNO_SUCESSO;
		} catch (Exception e) {
			System.out.println(e.getClass().getSimpleName());
			System.out.println(e.getMessage());
		} finally {
			GetConnection.fecharConexao(conn, ps, rs);
		}
		return false;
	}

	@Override
	public boolean excluirPorID(Long id) throws Exception {
		qry = "delete from telefone where id=?";
		try {
			conn = GetConnection.abrirConexao();
			ps = conn.prepareStatement(qry, Statement.RETURN_GENERATED_KEYS);
			ps.setLong(1, id);

			return ps.executeUpdate() == GetConnection.CODIGO_RETORNO_SUCESSO;
		} catch (Exception e) {
			System.out.println(e.getClass().getSimpleName());
			System.out.println(e.getMessage());
		} finally {
			GetConnection.fecharConexao(conn, ps, rs);
		}
		return false;
	}
}
