package com.ehei.convert;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArabicToRomanNumeralConverterTest {

	private ArabicToRomanNumeralConverter _converter;

	@Before
	public void setUp() throws Exception {
		
		_converter = new ArabicToRomanNumeralConverter();
	}
	
	@Test
	public void hasValue_shouldReturnFalse_ifValueWasNotSet() throws Exception {
		
		assertThat(_converter.hasValue()).isFalse();
	}
	
	@Test
	public void hasValue_shouldReturnFalse_ifValueWasSetToLessThanZero() throws Exception {
		
		_converter.setValue(-12);
		
		assertThat(_converter.hasValue()).isFalse();
	}
	
	@Test
	public void hasValue_shouldReturnFalse_ifValueWasSetToZero() throws Exception {
		
		_converter.setValue(0);
		
		assertThat(_converter.hasValue()).isFalse();
	}
	
	@Test
	public void consume_shouldReturnFalse_IfThereWasNothingToConsume() throws Exception {
		
		assertThat(_converter.consume()).isFalse();
	}

	@Test
	public void consume_givenNonZeroValue_shouldReturnTrue() throws Exception {
		
		_converter.setValue(1);
		
		assertThat(_converter.consume()).isTrue();
	}
	
	@Test
	public void getOutput_shouldReturnEmptyString_ifNothingHasBeenConverted() throws Exception {
		
		assertThat(_converter.getOutput()).isEmpty();
	}

	@Test
	public void consume_givenAValueOfOne_shouldTakeOffOneFromTheTotal_andAddIToTheOutput() {

		_converter.setValue(1);
		
		assertThat(_converter.consume()).isTrue();
		assertThat(_converter.getOutput()).isEqualTo("I");
	}

	@Test
	public void consume_givenAValueOfSix_shouldTakeOffFiveFromTheTotal_andAddVToTheOutput() {

		_converter.setValue(6);
		
		assertThat(_converter.consume()).isTrue();
		assertThat(_converter.getOutput()).isEqualTo("V");
	}

	@Test
	public void consume_givenAValueOfEleven_shouldTakeOffTenFromTheTotal_andAddXToTheOutput() {

		_converter.setValue(11);
		
		assertThat(_converter.consume()).isTrue();
		assertThat(_converter.getOutput()).isEqualTo("X");
	}

	@Test
	public void convert_givenAValueOfEleven_shouldConsumeUntilReachingZero_andAddXIToOutput() throws Exception {
		
		_converter.setValue(11);
		
		assertThat(_converter.convert()).isEqualTo("XI");
	}

	@Test
	public void convert_givenAValueOfThree_shouldConsumeUntilReachingZero_andAddIIIToOutput() throws Exception {
		
		_converter.setValue(3);
		
		assertThat(_converter.convert()).isEqualTo("III");
	}
}
