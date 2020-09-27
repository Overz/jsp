package util;

import com.example.jsp.util.Crypto;
import com.example.jsp.util.RandomData;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@Ignore()
public class TestUtil extends Assert {

	@Test()
	@Ignore()
	public void testEmail() {
		System.out.println("Email: " + RandomData.generateEmail(null));
	}

	@Test()
	@Ignore()
	public void testCpf() {
		System.out.println("Cpf: " + RandomData.generateCpf());
	}

	@Test()
	@Ignore()
	public void testTelefone() {
		System.out.println("Telefone: " + RandomData.generatePhone(8));
	}

	@Test()
	@Ignore()
	public void testNome() {
		String res = RandomData.generateName(30);
		System.out.println("Nome: " + res);
	}

	@Test()
	@Ignore()
	public void testSenha64() {
		String res = Crypto.toBase64("batatinha@123", null);
		System.out.println("Senha Base64: " + res);
		assertNotSame("batatinha@123", res);
	}

	@Test()
	@Ignore()
	public void testSha() {
		String res = Crypto.toSha("batatinha@123");
		System.out.println("SHA: " + res);
		assertNotSame("batatinha@123", res);
	}

	@Test()
	@Ignore()
	public void testHex() {
		String res = Crypto.toHex("batatinha@123");
		System.out.println("Hexa: " + res);
		assertNotSame("batatinha@123", res);
	}

	@Test()
	@Ignore()
	public void testCriptoString() {
		String res = Crypto.cryptoPassword("batatinha@123");
		System.out.println("Criptografia: " + res);
		assertNotSame("batatinha@123", res);
	}

	@Test()
	@Ignore()
	public void testDecripto64() {
		String res = Crypto.fromBase64(Crypto.toBase64("batatinha@123", null));
		System.out.println("Base 64 Decripted: " + res);
		assertEquals("batatinha@123", res);
	}

	@Test()
	@Ignore()
	public void testDecryptHex() {
		String res = Crypto.fromHex(Crypto.toHex("batatinha"));
		System.out.println("Hex decrypted: " + res);
		assertNotSame(res, "batatinha");
	}
}
