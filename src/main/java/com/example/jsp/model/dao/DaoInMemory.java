package com.example.jsp.model.dao;


import com.example.jsp.model.conn.InMemoryDb;
import com.example.jsp.model.daoi.BaseDao;
import com.example.jsp.model.vo.VoFornecedor;
import java.sql.*;
import java.util.List;

public class DaoInMemory implements BaseDao<VoFornecedor> {
	private String qry;
	private VoFornecedor f;
	private List<VoFornecedor> list;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	@Override
	public List<VoFornecedor> consultarTodos() {
		return null;
	}

	@Override
	public <T> T consultar(String... values) {
		return null;
	}

	@Override
	public VoFornecedor consultarPorId(Long id) {
		return null;
	}

	@Override
	public VoFornecedor cadastrar(VoFornecedor newObject, String... values) {
		try {
			qry = "insert into fornecedor (nome, email, descricao, dtCadastro) values (?,?,?,?)";
			this.f = newObject;

			conn = InMemoryDb.openConnection();
			ps = conn.prepareStatement(qry, PreparedStatement.RETURN_GENERATED_KEYS);

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
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public boolean alterar(VoFornecedor object) {
		return false;
	}

	@Override
	public boolean excluirPorID(Long id) {
		return false;
	}
}
