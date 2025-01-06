package com.ua.token;

import org.apache.commons.lang3.RandomStringUtils;

public final class RandomToken {
	
	public static String generedeRandomString() {
		String string = RandomStringUtils.randomAlphabetic(80);
		return string;
	}
}
