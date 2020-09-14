package com.example.jsp.util;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.Random;
import org.apache.commons.codec.binary.Hex;

/**
 * @author Christian Lima
 * <p>
 * Classe Útil para auxiliar na geração de valores.
 */
public class RandomData {

	private static final int MINIMUM = 15;
	private static final int MEDIUM = 30;
	private static final int MAXIMUM = 55;
	private static final String REGEX = "\\D";

	/**
	 * Método Util para gerar characteres aleatórios.
	 * Obs: Método gera automaticamente valores abaixo de 10 caso o parametro Int não seja informado.
	 *
	 * @param value String - Valor a ser substituido pelo autogerado.
	 * @param i     Integer - Length a ser substituido pelo padrão atual(10).
	 * @return String com caracteres aleatórios.
	 */
	private static String generateChars(String value, Integer i) {

		if (value == null || value.isEmpty()) {
			value = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		}

		if (i == null || i <= 0) {
			i = MINIMUM;
		}

		StringBuilder builder = new StringBuilder();
		Random random = new Random();
		while (builder.length() < i) { // length of the random string.
			int j = (int) (random.nextFloat() * value.length());
			builder.append(value.charAt(j));
		}
		return builder.toString();
	}

	/**
	 * Gera nome FAKE, simulando espaços entre os caracteres.
	 *
	 * @param i Integer - Length a ser substituido pelo padrão atual(10).
	 * @return String com caracteres aleatórios.
	 */
	public static String generateName(Integer i) {
		StringBuilder res = new StringBuilder();
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		if (i == null || i <= 10) {
			i = MEDIUM;
		}
		for (int j = 0; j < 2; j++) {
			res.append(generateChars(chars, i / 3));
			res.append(' ');
		}
		return res.toString();
	}

	/**
	 * Gera um FAKE email padrão @email.com
	 *
	 * @param i Integer - Length a ser substituido pelo padrão atual(10).
	 * @return String com padrão AlgumaCoisa@email.com
	 */
	public static String generateEmail(Integer i) {
		return generateChars(null, i).concat("@email.com").toUpperCase();
	}

	/**
	 * Gera um FAKE Cpf, de 11 posições.
	 *
	 * @return String CPF sem formatação
	 */
	public static String generateCpf() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 11; i++) {
			Integer n = (int) (Math.random() * 10);
			builder.append(n);
		}
		return builder.toString();
	}

	/**
	 * Gera um número FAKE de telefone, com padrão (48)9.
	 *
	 * @return String número de telefone
	 */
	public static String generatePhone(String number) {
		return "(48)9".concat(generateChars(number.replaceAll(REGEX, ""), number.length()));
	}

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
}