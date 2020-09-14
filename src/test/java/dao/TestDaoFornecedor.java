package dao;

import com.example.jsp.model.dao.DaoFornecedor;
import com.example.jsp.model.vo.VoFornecedor;
import java.util.Date;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class TestDaoFornecedor extends Assert {

	private VoFornecedor f;
	private DaoFornecedor daoF;

	public TestDaoFornecedor() {
	}

	@Test
	@Ignore
	public void runAll() {
		this.testCadastrar();
		this.testAlterar();
	}

	@Test()
	@Ignore("Utilizado somente para cadastrar uma vez")
	public void testCadastrar() {
		System.out.println("Cadastrar");
		f = new VoFornecedor(null, "joaozinho", "a@a.com", "sei la", new Date());
		daoF = new DaoFornecedor();
		f = daoF.cadastrar(f);;
		assertNotNull(f);
	}

	@Test()
//	@Ignore("Método não implementado")
	public void testAlterar() {
		System.out.println("Alterar");
		daoF = new DaoFornecedor();
		f = new VoFornecedor(null, "joaozinho", "a@a.com", "sei la", new Date());
		VoFornecedor novo = daoF.cadastrar(f);;
		assertNotSame(novo, f);

		novo.setEmail("Fornecedor@email.com");
		assertTrue(daoF.alterar(novo));
	}
}
