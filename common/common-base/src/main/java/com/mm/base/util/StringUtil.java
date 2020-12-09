package com.mm.base.util;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author mory.lee
 */
public class StringUtil {

	/**
	 * 判断字符串是否存在（忽略大小写）
	 * @param str
	 * @param args
	 * @return
	 */
	public static final boolean inStringIgnoreCase(String str, String... args) {
		for (String s: args) {
			if (StringUtils.containsIgnoreCase(str, s)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * 正则全部替换
	 * @param str
	 * @param reg
	 * @param replace
	 */
	public static final String replaceAll(String str, String reg, String replace) {
		Pattern pattern = Pattern.compile(reg);
		return replaceAll(str, pattern, replace);
	}

	/**
	 * 正则全部替换
	 * @param str
	 * @param pattern
	 * @param replace
	 */
	public static final String replaceAll(String str, Pattern pattern, String replace) {
		Matcher matcher = pattern.matcher(str);
		return matcher.replaceAll(replace);
	}

}
