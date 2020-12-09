package com.mm.base.security;

import com.mm.base.exception.CoderException;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class DigestCoderUtil {

	private static final String SHA1 = "SHA-1";
	private static final String MD5 = "MD5";

	public static final String CHARSET = "UTF-8";

	private static SecureRandom random = new SecureRandom();

	/**
	 * 生成随机的Byte[]作为盐值
	 *
	 * @param numBatys 盐值的大小
	 * @return
	 */
	public static byte[] generateSalt(int numBatys) {
		byte[] bytes = new byte[numBatys];
		random.nextBytes(bytes);
		return bytes;
	}

	/**
	 * 对输入字符串进行md5散列，基于MD5算法的单向加密
	 */
	public static String md5(String strSrc) {
		try {
			return CommonCoderUtil.encodeHex(md5(strSrc.getBytes(CHARSET)));
		} catch (UnsupportedEncodingException ex) {
			return null;
		}
	}

	public static byte[] md5(byte[] input) {
		return digest(input, MD5, null, 1);
	}

	public static byte[] md5(byte[] input, int iterations) {
		return digest(input, MD5, null, iterations);
	}
/**
 * 对输入字符串进行sha1散列.
 */
	/**
	 * 将字符串 SHA 加密
	 */
	public static String sha1(String str) {
		try {
			return CommonCoderUtil.encodeHex(sha1(str.getBytes(CHARSET)));
		} catch (UnsupportedEncodingException ex) {
			return null;
		}
	}

	public static byte[] sha1(byte[] input) {
		return digest(input, SHA1, null, 1);
	}

	public static byte[] sha1(byte[] input, byte[] salt) {
		return digest(input, SHA1, salt, 1);
	}

	public static byte[] sha1(byte[] input, byte[] salt, int iterations) {
		return digest(input, SHA1, salt, iterations);
	}

	/**
	 * 对字符串进行散列，支持MD5/SHA-1算法
	 *
	 * @param input      需要散列的数据
	 * @param algorithm  算法MD5/SHA-1
	 * @param salt       盐值
	 * @param iterations 迭代次数
	 * @return
	 */
	private static byte[] digest(byte[] input, String algorithm, byte[] salt, int iterations) {
		try {
			MessageDigest digest = MessageDigest.getInstance(algorithm);
			if (salt != null) {
				digest.update(salt);
			}
			byte[] result = digest.digest(input);
			for (int i = 1; i < iterations; i++) {
				digest.reset();
				result = digest.digest(result);
			}
			return result;
		} catch (NoSuchAlgorithmException e) {
			throw new CoderException();
		}
	}

	/**
	 * 对文件进行md5散列.
	 */
	public static byte[] md5(InputStream input) throws IOException {
		return digest(input, MD5);
	}

	/**
	 * 对文件进行sha1散列.
	 */
	public static byte[] sha1(InputStream input) throws IOException {
		return digest(input, SHA1);
	}

	private static byte[] digest(InputStream input, String algorithm) throws IOException {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
			int bufferLength = 8 * 1024;
			byte[] buffer = new byte[bufferLength];
			int read = input.read(buffer, 0, bufferLength);

			while (read > -1) {
				messageDigest.update(buffer, 0, read);
				read = input.read(buffer, 0, bufferLength);
			}

			return messageDigest.digest();
		} catch (GeneralSecurityException e) {
			throw new CoderException(e);
		}
	}

	public static String len16(String str) {
		String baseMd5 = md5(str);
		if (baseMd5 != null) {
			baseMd5 = baseMd5.substring(8, 24);
		}
		return baseMd5;
	}

}
