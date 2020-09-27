package dao;

import com.example.jsp.model.conn.GetConnection;
import com.example.jsp.model.dao.DaoProduto;
import com.example.jsp.model.vo.VoProduto;
import com.example.jsp.util.RandomData;
import java.sql.Connection;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestDaoProduto extends Assert implements BaseTEST {

	private VoProduto p;

	@Test()
	@Before()
	@Override()
	public void testCadastrar() throws Exception {
		System.out.println("Cadastrar");
		p = new VoProduto(RandomData.generateName(5), 20.0, 5, "100");
		p = new DaoProduto().cadastrar(p);
		assertNotNull(p);
	}

	@Test()
	@Override()
	public void testAlterar() throws Exception {
		System.out.println("Alterar");
		p.setDescricao("sdasdasdadsad");
		assertTrue(new DaoProduto().alterar(p));
		assertNotEquals(p.getDescricao(), null);
	}

	@Test()
	@Override()
	public void testConsultar() throws Exception {
		System.out.println("Consultar");
		assertNotNull(new DaoProduto().consultar("A", "1"));
	}

	@Test()
	@Override
	public void testConsultarPorID() throws Exception {
		System.out.println("Consultar por ID");
		assertNotNull(new DaoProduto().consultarPorId(p.getId()));
	}

	@Test()
	@Override()
	public void testExcluir() throws Exception {
		System.out.println("Excluir");
		assertTrue(new DaoProduto().excluirPorID(p.getId()));
	}

	@Test()
	@Override
	public void truncate() throws Exception {
		Connection conn = null;
		try {
			conn = GetConnection.abrirConexao();
			assert conn != null;
			conn.prepareStatement("truncate produto").execute();
		} catch (Exception e) {
			System.out.println(e.getClass().getSimpleName());
			System.out.println(e.getMessage());
		} finally {
			GetConnection.fecharConexao(conn, null, null);
		}
	}
}
