package dao;

import com.example.jsp.model.conn.GetConnection;
import com.example.jsp.model.dao.DaoFornecedor;
import com.example.jsp.model.vo.VoFornecedor;
import com.example.jsp.util.RandomData;
import java.sql.Connection;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestFornecedor extends Assert implements BaseTEST {

	private VoFornecedor f;

	public TestFornecedor() {
	}

	@Test()
	@Before()
	@Override()
	public void testCadastrar() throws Exception {
		System.out.println("Cadastrar");
		f = new VoFornecedor(null, "joaozinho", "a@a.com", RandomData.generatePhone(8), "sei la", new Date());
		f = new DaoFornecedor().cadastrar(f);
		assertNotNull(f);
	}

	@Test()
	@Override()
	public void testAlterar() throws Exception {
		System.out.println("Alterar");
		f.setEmail("Fornecedor@email.com");
		assertTrue(new DaoFornecedor().alterar(f));
		assertNotEquals(f.getEmail(), "a@a.com");
	}

	@Test()
	@Override()
	public void testConsultar() throws Exception {
		System.out.println("Consultar");
		assertNotNull(new DaoFornecedor().consultar("A"));
	}

	@Test()
	@Override()
	public void testConsultarPorID() throws Exception {
		System.out.println("ConsultarPorID");
		assertNotNull(new DaoFornecedor().consultarPorId(f.getId()));
	}

	@Test()
	@Override()
	public void testExcluir() throws Exception {
		System.out.println("Excluir");
		assertTrue(new DaoFornecedor().excluirPorID(f.getId()));
	}

	@Test()
	@Override()
	@After()
	public void truncate() throws Exception {
		System.out.println("Truncate");
		Connection conn = null;
		try {
			conn = GetConnection.abrirConexao();
			assert conn != null;
			conn.prepareStatement("truncate fornecedor").execute();
			System.gc();
		} catch (Exception e) {
			System.out.println(e.getClass().getSimpleName());
			System.out.println(e.getMessage());
		} finally {
			GetConnection.fecharConexao(conn, null, null);
		}
	}

}
