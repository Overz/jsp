package dao;

import com.example.jsp.model.conn.GetConnection;
import com.example.jsp.model.dao.DaoTelefone;
import com.example.jsp.model.vo.VoTelefone;
import com.example.jsp.util.RandomData;
import java.sql.Connection;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestDaoTelefone extends Assert implements BaseTEST {

	private VoTelefone t;

	@Test
	@Before
	@Override
	public void testCadastrar() throws Exception {
		System.out.println("Cadastrar");
		t = new VoTelefone(RandomData.generatePhone(5), "48", "TIM", "Joaozinho");
		t = new DaoTelefone().cadastrar(t);
		assertNotNull(t);
	}

	@Test
	@Override
	public void testAlterar() throws Exception {
		System.out.println("Alterar");
		t.setOperadora("VIVO");
		assertTrue(new DaoTelefone().alterar(t));
		assertNotEquals(t.getOperadora(), "TIM");
	}

	@Test
	@Override
	public void testConsultar() throws Exception {
		System.out.println("Consultar");
		assertNotNull(new DaoTelefone().consultar("VIVO"));
	}

	@Test
	@Override
	public void testConsultarPorID() throws Exception {
		System.out.println("ConsultarPorId");
		assertNotNull(new DaoTelefone().consultarPorId(t.getId()));
	}

	@Test
	@Override
	public void testExcluir() throws Exception {
		System.out.println("Excluir");
		assertTrue(new DaoTelefone().excluirPorID(t.getId()));
	}

	@Test
	@After
	@Override
	public void truncate() throws Exception {
		Connection conn = null;
		try {
			conn = GetConnection.abrirConexao();
			conn.prepareStatement("truncate telefone").execute();
		} catch (Exception e) {
			System.out.println(e.getClass().getSimpleName());
			System.out.println(e.getMessage());
		} finally {
			GetConnection.fecharConexao(conn, null, null);
		}
	}
}
