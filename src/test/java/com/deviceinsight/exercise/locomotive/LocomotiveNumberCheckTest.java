package com.deviceinsight.exercise.locomotive;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class LocomotiveNumberCheckTest {

	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {" "})
	void isValidShouldReturnFalseForInvalidValue(String number) {
		assertThat(LocomotiveNumberCheck.isValid(number)).isFalse();
	}

	@ParameterizedTest
	@ValueSource(strings = {"10140-1", "10140", "1014005-99", "11014005-9"})
	void isValidShouldReturnFalseForInvalidPattern(String number) {
		assertThat(LocomotiveNumberCheck.isValid(number)).isFalse();
	}

	@Test
	void isValidShouldReturnFalseForInvalidCheckDigit() {
		assertThat(LocomotiveNumberCheck.isValid("1014005-9")).isFalse();
	}

	@Test
	void isValidShouldReturnTrueForValidNumbers() {
		assertThat(LocomotiveNumberCheck.isValid("1014005-1")).isTrue();
	}

	@Test
	void isValidShouldReturnTrueForValidNumbersWithCheckDigitZero() {
		assertThat(LocomotiveNumberCheck.isValid("0141509-0")).isTrue();
	}

}
