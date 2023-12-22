package com.wlopera.query.oracle.utilities;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class StringEncrypt {

	private static final String ALGORITHM = "AES";
	private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";

	public static String encrypt(String value, String secretKey, String iv) {
		try {
			if (secretKey.length() != 16) {
				throw new IllegalArgumentException("La longitud de la clave debe ser de 16 bytes (128 bits)");
			}

			Cipher cipher = Cipher.getInstance(TRANSFORMATION);
			SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(), ALGORITHM);
			IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());
			cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);

			byte[] encryptedBytes = cipher.doFinal(value.getBytes());
			byte[] ivBytes = cipher.getIV();

			byte[] result = new byte[ivBytes.length + encryptedBytes.length];
			System.arraycopy(ivBytes, 0, result, 0, ivBytes.length);
			System.arraycopy(encryptedBytes, 0, result, ivBytes.length, encryptedBytes.length);

			return Base64.getEncoder().encodeToString(result);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String decrypt(String encryptedValue, String secretKey, String iv) {
		try {
			if (secretKey.length() != 16) {
				throw new IllegalArgumentException("La longitud de la clave debe ser de 16 bytes (128 bits)");
			}

			byte[] encryptedBytes = Base64.getDecoder().decode(encryptedValue);
			IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());
			SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(), ALGORITHM);

			Cipher cipher = Cipher.getInstance(TRANSFORMATION);
			cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);

			int ivSize = cipher.getBlockSize();
			byte[] ivBytes = new byte[ivSize];
			byte[] encryptedData = new byte[encryptedBytes.length - ivSize];

			System.arraycopy(encryptedBytes, 0, ivBytes, 0, ivSize);
			System.arraycopy(encryptedBytes, ivSize, encryptedData, 0, encryptedData.length);

			byte[] decryptedBytes = cipher.doFinal(encryptedData);
			return new String(decryptedBytes);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
		// Ejemplo de uso
		String secretKey = "1234567890123456"; // Clave de 16 bytes (128 bits)
		String iv = "0123456789ABCDEF";
		String originalText = "william";

		// Encriptar
		String encryptedText = encrypt(originalText, secretKey, iv);
		System.out.println("Texto cifrado: " + encryptedText);

		// Desencriptar
		String decryptedText = decrypt(encryptedText, secretKey, iv);
		System.out.println("Texto descifrado: " + decryptedText);
	}
}
