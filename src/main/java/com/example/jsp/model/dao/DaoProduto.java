package com.example.jsp.model.dao;

import com.example.jsp.model.conn.GetConnection;
import com.example.jsp.model.daoi.DaoiProduto;
import com.example.jsp.model.vo.VoProduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoProduto implements DaoiProduto {

	private String qry;
	private List<VoProduto> list;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private VoProduto p;

	private VoProduto criarResultSet(ResultSet rs) {
		try {
			p = new VoProduto();
			p.setId(rs.getInt("id"));
			p.setNome(rs.getString("nome"));
			p.setPreco(rs.getDouble("preco"));
			p.setEstoque(rs.getInt("estoque"));
			p.setCodigo(rs.getString("codigo"));
			p.setDescricao(rs.getString("descricao"));
			return p;
		} catch (Exception e) {
			System.out.println(e.getClass().getSimpleName());
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public <T> T consultarTodos() throws Exception {
		qry = "select * from produto";
		try {
			conn = GetConnection.abrirConexao();
			ps = GetConnection.getPreparedStatement(conn, qry, Statement.RETURN_GENERATED_KEYS);
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
		qry = "select * from produto where nome like ?";
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
	public VoProduto consultarPorId(Long id) throws Exception {
		qry = "select * from produto where id=?";
		try {
			conn = GetConnection.abrirConexao();
			ps = GetConnection.getPreparedStatement(conn, qry, Statement.RETURN_GENERATED_KEYS);

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
	public VoProduto cadastrar(VoProduto newObject, String... values) throws Exception {
		qry = "insert into produto (nome, preco, estoque, codigo) values(?, ?, ?, ?)";
		try {
			conn = GetConnection.abrirConexao();
			ps = GetConnection.getPreparedStatement(conn, qry, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, newObject.getNome());
			ps.setDouble(2, newObject.getPreco());
			ps.setInt(3, newObject.getEstoque());
			ps.setString(4, newObject.getCodigo());

			ps.executeUpdate();

			rs = ps.getGeneratedKeys();

			if (rs.next()) {
				newObject.setId(rs.getLong(1));
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
	public boolean alterar(VoProduto object) throws Exception {
		qry = "update produto set nome=?, preco=?, estoque=?, codigo=? where id=?";
		try {
			conn = GetConnection.abrirConexao();
			ps = GetConnection.getPreparedStatement(conn, qry, PreparedStatement.RETURN_GENERATED_KEYS);

			ps.setString(1, object.getNome());
			ps.setDouble(2, object.getPreco());
			ps.setInt(3, object.getEstoque());
			ps.setString(4, object.getCodigo());
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
		qry = "delete from produto where id=?";
		try {
			conn = GetConnection.abrirConexao();
			ps = GetConnection.getPreparedStatement(conn, qry, PreparedStatement.RETURN_GENERATED_KEYS);

			ps.setLong(1, id);
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
}
