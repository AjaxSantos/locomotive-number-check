package com.deviceinsight.exercise.util;

import java.util.Collections;
import java.util.List;

public final class NumberUtils {

	private NumberUtils() {
		throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
	}

	/**
	 * Calculates the sum of digits of the given {@code number}.
	 * Negative numbers are not supported and will cause an {@link IllegalArgumentException}.
	 *
	 * @param number of which the digit sum is to be calculated
	 * @return the sum of digits
	 */
	public static int sumOfDigits(int number) {
		if (number < 0) {
			throw new IllegalArgumentException("The number must be 0 or a positive value");
		}
		return number < 10 ? number : number % 10 + sumOfDigits(number / 10);
	}

	/**
	 * Returns the numeric value of each digit of the given string in a list.
	 * Non-numeric characters are not supported and will cause an {@link IllegalArgumentException}.
	 *
	 * @param digitString string of digits
	 * @return digits as list of integer
	 */
	public static List<Integer> toIntegerList(String digitString) {
		if (digitString == null || digitString.isEmpty()) {
			return Collections.emptyList();
		}

		if (!digitString.matches("[0-9]+")) {
			throw new IllegalArgumentException("The digitString must only contain numeric characters");
		}

		return digitString.chars().mapToObj(Character::getNumericValue).toList();
	}

}
