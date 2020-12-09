package com.mm.base.security;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.UUID;

public class CodecUtil {

	/**
	 * 创建随机数
	 */
	public static String createRandomNum(int count) {
		return RandomStringUtils.randomNumeric(count);
	}

	/**
	 * 获取 UUID（32位）
	 */
	public static String createUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
	}

}
