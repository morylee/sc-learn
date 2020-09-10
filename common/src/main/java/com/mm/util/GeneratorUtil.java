package com.mm.util;

import java.util.UUID;

public final class GeneratorUtil {

	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}

}
