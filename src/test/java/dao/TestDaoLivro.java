package dao;

import com.example.jsp.model.conn.GetConnection;
import com.example.jsp.model.dao.DaoLivro;
import com.example.jsp.model.vo.VoLivro;
import java.sql.Connection;
import java.time.LocalDate;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestDaoLivro extends Assert implements BaseTEST {

	private VoLivro t;

	@Test
	@Before
	@Override
	public void testCadastrar() throws Exception {
		System.out.println(getClass().getSimpleName() + " Cadastrar");
		t = new VoLivro("Teste A", "Joaozinho", "Records", LocalDate.now().getYear(), null);
		t = new DaoLivro().cadastrar(t);
		assertNotNull(t);
	}

	@Test
	@Override
	public void testAlterar() throws Exception {
		System.out.println(getClass().getSimpleName() + " Alterar");
		t.setDescricao("asdasdas");
		assertTrue(new DaoLivro().alterar(t));
		assertNotEquals(t.getDescricao(), null);
	}

	@Test
	@Override
	public void testConsultar() throws Exception {
		System.out.println(getClass().getSimpleName() + " Consultar");
		assertNotNull(new DaoLivro().consultar("A"));
	}

	@Test
	@Override
	public void testConsultarPorID() throws Exception {
		System.out.println(getClass().getSimpleName() + " ConsultarPorID");
		assertNotNull(new DaoLivro().consultarPorId(t.getId()));
	}

	@Test
	@Override
	public void testExcluir() throws Exception {
		System.out.println(getClass().getSimpleName() + " Excluir");
		assertTrue(new DaoLivro().excluirPorID(t.getId()));
	}

	@Test
	@After
	@Override
	public void truncate() throws Exception {
		System.out.println(getClass().getSimpleName() + " Truncate");
		Connection conn = null;
		try {
			conn = GetConnection.abrirConexao();
			assert conn != null;
			conn.prepareStatement("truncate livro").execute();
		} catch (Exception e) {
			System.out.println(e.getClass().getSimpleName());
			System.out.println(e.getMessage());
		} finally {
			GetConnection.fecharConexao(conn, null, null);
		}
	}
}
