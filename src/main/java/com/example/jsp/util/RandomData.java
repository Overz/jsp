package com.example.jsp.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Random;
import org.apache.commons.codec.binary.Base64;

/**
 * @author Christian Lima
 * <p>
 * Classe Útil para auxiliar na geração de valores.
 */
public class RandomData {

	public static final int MINIMUM = 15;
	public static final int MEDIUM = 30;
	public static final int MAXIMUM = 55;

	/**
	 * Método Util para gerar characteres aleatórios.
	 * Obs: Método gera automaticamente valores abaixo de 10 caso o parametro Int não seja informado.
	 *
	 * @param value String - Valor a ser substituido pelo autogerado.
	 * @param i Integer - Length a ser substituido pelo padrão atual(10).
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
	 * Gera uma String com caracteres aleatórios e possíveis espaços, "simulando" um nome real.
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
	 * Gera um email padrão @email.com
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
		StringBuilder iniciais = new StringBuilder();
		int numero;
		for (int i = 0; i < 11; i++) {
			numero = (int) (Math.random() * 10);
			iniciais.append(numero);
		}
		return iniciais.toString();
	}

	/**
	 * Gera um número FAKE de telefone, com padrão (48)9.
	 *
	 * @return String número de telefone
	 */
	public static String generatePhone() {
		try {
			String chars = "123456789";
			StringBuilder builder = new StringBuilder();
			Random random = new Random();
			while (builder.length() <= 8) {
				int i = (int) (random.nextFloat() * chars.length());
				builder.append(chars.charAt(i));
			}
			return "(48)9".concat(builder.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	/**
	 * Para utilizar o generatePassword, é necessário uma lib Codec da Apache
	 * - https://mvnrepository.com/artifact/commons-codec/commons-codec
	 * - http://commons.apache.org/proper/commons-codec/archives/1.9/userguide.html
	 *
	 * @param password String - Senha a ser criptografada com a lib Codec
	 * @param i:       Integer - Length a ser substituido pelo padrão atual(10).
	 * @return String encoded por Base64
	 */
	public static String generatePassword(String password, Integer i) {
		return Base64.encodeBase64String(generateChars(password, i).getBytes());
	}

	/**
	 * Cria uma pass criptografada com SHA-512
	 * <p>
	 * https://www.devmedia.com.br/como-funciona-a-criptografia-hash-em-java/31139
	 *
	 * @param pass String - String informada a para criptografia
	 * @return String Sha-512
	 */
	public static String generateShaPass(String pass) {
		try {
			MessageDigest algorithm = MessageDigest.getInstance("SHA-512");
			byte[] messageDigest = algorithm.digest(pass.getBytes(StandardCharsets.UTF_8));
			StringBuilder hexString = new StringBuilder();

			for (byte b : messageDigest) {
				// Quanto maior o número informado no "format", maior a criptografia
				// Padrão é 02
				hexString.append(String.format("%02X", 0xFF & b));
			}
			return hexString.toString();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Erro ao tentar criar a pass Hash");
		}
		return null;
	}

	/**
	 * Transforma a string em hexadecimal
	 *
	 * @param pass String - A strig informada
	 * @return String - Hexadecimal String
	 */
	public static String stringHexa(String pass) {
		StringBuilder builder = new StringBuilder();
		byte[] bytes = pass.getBytes();

		for (byte aByte : bytes) {
			int parteAlta = ((aByte >> 4) & 0xf) << 4;
			int parteBaixa = aByte & 0xf;
			if (parteAlta == 0) {
				builder.append('0');
			}
			builder.append(Integer.toHexString(parteAlta | parteBaixa));
		}
		return builder.toString();
	}

	/**
	 * Cria uma pass criptografada com Hexadecimal + SHA-256
	 *
	 * @param pass String - A string informada
	 * @return String criptografada
	 */
	public static String criptoPassword(String pass) {
		return generateShaPass(stringHexa(pass));
	}
}

//class Decripto {
//	public Decripto() {
//	};
//
//	public static String decript64(String password) {
//		return new String(Base64.decodeBase64(password.getBytes()));
//	}
//
//	public static String decriptShaPass(String pass){
//		return null;
//	}
//}