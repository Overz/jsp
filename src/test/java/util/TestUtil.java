package util;

import com.example.jsp.util.RandomData;
import org.junit.Assert;
import org.junit.Test;

public class TestUtil extends Assert {

	@Test()
	public void testEmail() {
		System.out.println("Email: " + RandomData.generateEmail(null));
	}

	@Test()
	public void testCpf() {
		System.out.println("Cpf: " + RandomData.generateCpf());
	}

	@Test()
	public void testTelefone() {
		System.out.println("Telefone: " + RandomData.generatePhone());
	}

	@Test()
	public void testNome() {
		String res = RandomData.generateName(30);
		System.out.println("Nome: " + res);
	}

	@Test()
	public void testSenha64() {
		String res = RandomData.generatePassword("batatinha@123", null);
		System.out.println("Senha Base64: " + res);
		assertNotSame("batatinha@123", res);
	}

	@Test()
	public void testSha512() {
		String res = RandomData.generateShaPass("batatinha@123");
		System.out.println("Hash: " + res);
		assertNotSame("batatinha@123", res);
	}

	@Test()
	public void testHex() {
		String res = RandomData.stringHexa("batatinha@123");
		System.out.println("Hexa: " + res);
		assertNotSame("batatinha@123", res);
	}

	@Test()
	public void testCriptoString() {
		String res = RandomData.criptoPassword("batatinha@123");
		System.out.println("Criptografia: " + res);
		assertNotSame("batatinha@123", res);
	}
}
