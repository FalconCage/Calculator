package com.calc.util;

/**
 * @author Divya Ramesh
 *
 */
public class CalculatorUtils {

	/**
	 * @param val
	 * @return
	 */
	public static boolean isValidString(String val) {
		if (val != null && !val.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * @param value
	 * @return
	 */
	public static String[] splitBySpace(String value) {
		String arrVal[] = value.trim().split("\\s+");
		return arrVal;
	}
}
