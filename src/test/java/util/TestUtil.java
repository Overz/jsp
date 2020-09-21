package util;

import com.example.jsp.util.Decrypt;
import com.example.jsp.util.Encrypt;
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
		System.out.println("Telefone: " + RandomData.generatePhone("12345678"));
	}

	@Test()
	public void testNome() {
		String res = RandomData.generateName(30);
		System.out.println("Nome: " + res);
	}

	@Test()
	public void testSenha64() {
		String res = Encrypt.toBase64("batatinha@123", null);
		System.out.println("Senha Base64: " + res);
		assertNotSame("batatinha@123", res);
	}

	@Test()
	public void testSha() {
		String res = Encrypt.toSha("batatinha@123");
		System.out.println("SHA: " + res);
		assertNotSame("batatinha@123", res);
	}

	@Test()
	public void testHex() {
		String res = Encrypt.toHex("batatinha@123");
		System.out.println("Hexa: " + res);
		assertNotSame("batatinha@123", res);
	}

	@Test()
	public void testCriptoString() {
		String res = Encrypt.cryptoPassword("batatinha@123");
		System.out.println("Criptografia: " + res);
		assertNotSame("batatinha@123", res);
	}

	@Test()
	public void testDecripto64() {
		String res = Decrypt.fromBase64(Encrypt.toBase64("batatinha@123", null));
		System.out.println("Base 64 Decripted: " + res);
		assertEquals("batatinha@123", res);
	}

	@Test()
	public void testDecryptHex() {
		String res = Decrypt.fromHex(Encrypt.toHex("batatinha"));
		System.out.println("Hex decrypted: " + res);
		assertNotSame(res, "batatinha");
	}

}
