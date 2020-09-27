package util;

import com.example.jsp.util.Crypto;
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
		System.out.println("Telefone: " + RandomData.generatePhone(8));
	}

	@Test()
	public void testNome() {
		System.out.println("Nome: " + RandomData.generateName(30));
	}

	@Test()
	public void testSenha64() {
		String res = Crypto.toBase64("batatinha@123", null);
		System.out.println("Senha Base64: " + res);
		assertNotSame("batatinha@123", res);
	}

	@Test()
	public void testSha() {
		String res = Crypto.toSha("batatinha@123");
		System.out.println("SHA: " + res);
		assertNotSame("batatinha@123", res);
	}

	@Test()
	public void testHex() {
		String res = Crypto.toHex("batatinha@123");
		System.out.println("Hexa: " + res);
		assertNotSame("batatinha@123", res);
	}

	@Test()
	public void testCriptoString() {
		String res = Crypto.cryptoPassword("batatinha@123");
		System.out.println("Criptografia: " + res);
		assertNotSame("batatinha@123", res);
	}

	@Test()
	public void testDecripto64() {
		String res = Crypto.fromBase64(Crypto.toBase64("batatinha@123", null));
		System.out.println("Base 64 Decripted: " + res);
		assertEquals("batatinha@123", res);
	}

	@Test()
	public void testDecryptHex() {
		String res = Crypto.fromHex(Crypto.toHex("batatinha"));
		System.out.println("Hex decrypted: " + res);
		assertNotSame(res, "batatinha");
	}
}
