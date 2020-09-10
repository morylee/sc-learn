package com.mm.security;

public class PwdUtil {

	/**
	 * Shiro 算法
	 **/
	public static final String HASH_ALGORITHM = "SHA-1";
	/**
	 * 盐值的大小
	 **/
	public static final int SALT_SIZE = 8;
	/**
	 * 迭代的次数
	 **/
	public static final int HASH_INTERATIONS = 1024;

	/**
	 * 生成密码，生成随机数的16为盐值并且经过1024次 SHA-1 Hash
	 *
	 * @param plainPassword
	 * @return
	 */
	public static String entryptPassword(String plainPassword) {
		String plain = CommonCoderUtil.unescapeHtml(plainPassword);
		byte[] salt = DigestCoderUtil.generateSalt(SALT_SIZE);
		byte[] hashPassword = DigestCoderUtil.sha1(plain.getBytes(), salt, HASH_INTERATIONS);
		return CommonCoderUtil.encodeHex(salt) + CommonCoderUtil.encodeHex(hashPassword);
	}

	/**
	 * @param planinPassword 明文密码
	 * @param password       加密的密码
	 * @return 验证结果
	 */
	public static boolean validatePassword(String planinPassword, String password) {
		String plain = CommonCoderUtil.unescapeHtml(planinPassword);
		byte[] salt = CommonCoderUtil.decodeHex(password.substring(0, 16));
		byte[] hashPassword = DigestCoderUtil.sha1(plain.getBytes(), salt, HASH_INTERATIONS);
		return password.equals(CommonCoderUtil.encodeHex(salt) + CommonCoderUtil.encodeHex(hashPassword));
	}

}
