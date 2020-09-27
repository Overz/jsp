package dao;

import com.example.jsp.model.vo.VoFornecedor;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public interface BaseTEST {

	@Test
	@Before
	void testCadastrar() throws Exception;

	@Test
	void testAlterar() throws Exception;

	@Test
	void testConsultar() throws Exception;

	@Test
	void testConsultarPorID() throws Exception;

	@Test
	void testExcluir() throws Exception;

	@Test
	@After
	void truncate() throws Exception;
}
