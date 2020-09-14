package com.example.jsp.util;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import org.apache.commons.codec.binary.Hex;

public class Decrypt {

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
