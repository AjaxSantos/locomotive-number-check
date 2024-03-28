package com.deviceinsight.exercise.locomotive;

import com.deviceinsight.exercise.util.NumberUtils;

import java.util.List;

public class LocomotiveNumberCheck {
	private static final String NUMBER_PATTERN = "[0-9]{7}-[0-9]";

	/**
	 * Returns {@code true} if the given locomotive number is valid.
	 *
	 * @param number the whole locomotive number (e.g. "1014005-1")
	 * @return whether the number is valid or not
	 */
	public static boolean isValid(String number) {
		if(number == null || number.isEmpty() || number.isBlank())
			return false;

		if (!hasNumberPattern(number))
			return false;

		List<Integer> numbers = GetNumbers(number);
		if(numbers == null || numbers.isEmpty())
			return false;
		String expectedDigit = getCheckDigit(numbers);
		String actualDigit = getCheckDigit(number);
		return actualDigit.equals(expectedDigit);
	}

	private static boolean hasNumberPattern(String number) {
		return number.matches(NUMBER_PATTERN);
	}

	private static List<Integer> GetNumbers(String number) {
		String locomotiveNumber = number.substring(0, 7);
		return NumberUtils.toIntegerList(locomotiveNumber);
	}

	private static String getCheckDigit(List<Integer> numbers) {
		int calculationNumber = getCalculationNumber(numbers);
		int digitSum = NumberUtils.sumOfDigits(calculationNumber);
		String checkDigit;
		if(digitSum % 10 == 0)
		{
			checkDigit = "0";
		}
		else
		{
			int helper = digitSum + (10 - digitSum % 10);
			checkDigit = String.valueOf(helper - digitSum);
		}
		return checkDigit;
	}

	private static int getCalculationNumber(List<Integer> numbers) {
		List<Integer> calculationList =  numbers.stream().toList();
		StringBuilder calculationResult = new StringBuilder();
		for (int i = 0; i < calculationList.size(); i++)
		{
			int factor = 2 - i % 2;
			int digit = calculationList.get(i) * factor;
			calculationResult.append(digit);
		}
		return Integer.parseInt(calculationResult.toString());
	}

	private static String getCheckDigit(String number) {
		return number.substring(8);
	}

}
