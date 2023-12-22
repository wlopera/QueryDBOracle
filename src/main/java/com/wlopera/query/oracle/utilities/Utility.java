package com.wlopera.query.oracle.utilities;

import com.google.gson.JsonParser;

public class Utility {
	public static boolean isJson(String value) {
		try {
			JsonParser.parseString(value);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
