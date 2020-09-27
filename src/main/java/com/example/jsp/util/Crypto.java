package com.example.jsp.util;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Hex;

import static com.example.jsp.util.RandomData.generateChars;

public class Crypto {

	/**
	 * Retorna uma senha criptografada em Base64
	 * - https://stackabuse.com/encoding-and-decoding-base64-strings-in-java/
	 *
	 * @param password String - Senha a ser criptografada com a lib Codec
	 * @param i:       Integer - Length a ser substituido pelo padrão atual(10).
	 * @return String encoded por Base64
	 */
	public static String toBase64(String password, Integer i) {
		Base64.Encoder encoder = Base64.getEncoder();
		return password != null && !password.isEmpty() ? encoder.encodeToString(password.getBytes()) : encoder.encodeToString(generateChars(password, i).getBytes());
	}

	/**
	 * Cria uma pass criptografada com SHA-512
	 *
	 * @param pass String - String informada a para criptografia
	 * @return String Sha-512
	 */
	public static String toSha(String pass) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] bytes = md.digest(pass.getBytes(StandardCharsets.UTF_8));
			return new BigInteger(1, bytes).toString(16);
		} catch (Exception e) {
			System.out.println("Erro ao tentar criar a pass Hash");
			System.out.println(e.getMessage());
		}
		return null;
	}

	/**
	 * Transforma a string em hexadecimal
	 *
	 * @param pass String - A strig informada
	 * @return String - Hexadecimal String
	 */
	public static String toHex(String pass) {
		return Hex.encodeHexString(pass.getBytes());
	}

	/**
	 * Cria uma pass criptografada com Hexadecimal + SHA-256
	 *
	 * @param pass String - A string informada
	 * @return String criptografada
	 */
	public static String cryptoPassword(String pass) {
		return toSha(toHex(pass));
	}

	public static String cipher(String message) {
		try {
			String encryptionKeyString = "thisisa128bitkey";
			String originalMessage = "This is a secret message";
			byte[] encryptionKeyBytes = encryptionKeyString.getBytes();

			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			SecretKey secretKey = new SecretKeySpec(encryptionKeyBytes, "AES");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);

			byte[] encryptedMessageBytes = cipher.doFinal(message.getBytes());

			cipher.init(Cipher.DECRYPT_MODE, secretKey);

			byte[] decryptedMessageBytes = cipher.doFinal(encryptedMessageBytes);
//			assertThat(originalMessage).isEqualTo(new String(decryptedMessageBytes));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public static String decipher(String pass) {
		try {

			return "";
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public static String fromBase64(String pass) {
		return new String(Base64.getDecoder().decode(pass));
	}

	public static String fromHex(String pass) {
		try {
			return new String(Hex.decodeHex(pass), StandardCharsets.UTF_8);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public static boolean compareHash(String passHashed, String hashedPass) {
		return passHashed.equalsIgnoreCase(hashedPass);
	}
}
