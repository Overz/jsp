package com.example.jsp.model.dao;

import com.example.jsp.model.conn.GetConnection;
import com.example.jsp.model.daoi.BaseDao;
import com.example.jsp.model.vo.VoLivro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoLivro implements BaseDao<VoLivro> {

	private String qry;
	private List<VoLivro> list;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private VoLivro l;

	private VoLivro criarResultSet(ResultSet rs) {
		try {
			l = new VoLivro();
			l.setId(rs.getInt("id"));
			l.setNome(rs.getString("nome"));
			l.setAutor(rs.getString("autor"));
			l.setEditora(rs.getString("editora"));
			l.setAnoEdicao(rs.getInt("anoEdicao"));
			l.setDescricao(rs.getString("descricao"));
			return l;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getClass().getSimpleName());
		}
		return null;
	}

	@Override
	public <T> T consultarTodos() throws Exception {
		qry = "select * from livro";
		list = new ArrayList<>();
		try {
			conn = GetConnection.abrirConexao();
			ps = GetConnection.getPreparedStatement(conn, qry, PreparedStatement.RETURN_GENERATED_KEYS);
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
		qry = "select * from livro where nome like ?";
		list = new ArrayList<>();
		try {
			conn = GetConnection.abrirConexao();
			ps = GetConnection.getPreparedStatement(conn, qry, PreparedStatement.RETURN_GENERATED_KEYS);
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
	public VoLivro consultarPorId(Long id) throws Exception {
		qry = "select * from livro where id=?";
		try {
			conn = GetConnection.abrirConexao();
			ps = GetConnection.getPreparedStatement(conn, qry, PreparedStatement.RETURN_GENERATED_KEYS);

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
	public VoLivro cadastrar(VoLivro newObject, String... values) throws Exception {
		qry = "insert into livro (nome, autor, editora, anoEdicao, descricao) values (?,?,?,?,?)";
		try {
			conn = GetConnection.abrirConexao();
			ps = GetConnection.getPreparedStatement(conn, qry, PreparedStatement.RETURN_GENERATED_KEYS);

			ps.setString(1, newObject.getNome());
			ps.setString(2, newObject.getAutor());
			ps.setString(3, newObject.getEditora());
			ps.setInt(4, newObject.getAnoEdicao());
			ps.setString(5, newObject.getDescricao());

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
	public boolean alterar(VoLivro object) throws Exception {
		qry = "update livro set nome=?, autor=?, editora=?, anoEdicao=?, descricao=? where id=?";
		try {
			conn = GetConnection.abrirConexao();
			ps = GetConnection.getPreparedStatement(conn, qry, PreparedStatement.RETURN_GENERATED_KEYS);

			ps.setString(1, object.getNome());
			ps.setString(2, object.getAutor());
			ps.setString(3, object.getEditora());
			ps.setInt(4, object.getAnoEdicao());
			ps.setString(5, object.getDescricao());
			ps.setLong(6, object.getId());

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
		qry = "delete from livro where id=?";
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
