package com.deviceinsight.exercise.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class NumberUtilsTest {

	@ParameterizedTest
	@NullAndEmptySource
	void toIntegerListShouldReturnEmptyForNullString(String digits) {
		assertThat(NumberUtils.toIntegerList(digits)).isEmpty();
	}

	@Test
	void toIntegerListShouldReturnExpectedIntValues() {
		assertThat(NumberUtils.toIntegerList("01")).containsExactly(0, 1);
	}

	@ParameterizedTest
	@ValueSource(strings = {" ", "-10", "10.0", "10,0", "10-1"})
	void toIntegerListShouldThrowExceptionForNonNumericValues(String digits) {
		assertThrows(IllegalArgumentException.class, () -> NumberUtils.toIntegerList(digits));
	}

	@Test
	void sumOfDigitsShouldThrowAnExceptionForNegativeValue() {
		assertThrows(IllegalArgumentException.class, () -> NumberUtils.sumOfDigits(-1));
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 9})
	void sumOfDigitsShouldReturnInputParamForSingleDigit(int number) {
		assertThat(NumberUtils.sumOfDigits(number)).isEqualTo(number);
	}

	@Test
	void sumOfDigitsShouldReturnDigitSumOf() {
		assertThat(NumberUtils.sumOfDigits(10)).isEqualTo(1);
		assertThat(NumberUtils.sumOfDigits(19)).isEqualTo(10);
		assertThat(NumberUtils.sumOfDigits(1234)).isEqualTo(10);
	}

}
