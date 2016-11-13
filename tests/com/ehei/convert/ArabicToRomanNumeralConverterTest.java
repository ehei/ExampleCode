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
	public void convert_throwsIllegalArgumentException_ifNoValueGivenToConvert() throws Exception {
		
		try {
			_converter.convert();
			fail();
		}
		catch (IllegalArgumentException exception) {
			
			assertThat(exception.getMessage()).isEqualTo("The value '0' is outside the valid range for Roman Numerals (0 < X < 4000)");
		}
	}
	
	@Test
	public void convert_givenValueLessThanZero_throwsIllegalArgumentException() throws Exception {
		
		try {
			_converter.convert(-1);
			fail();
		}
		catch (IllegalArgumentException exception) {
			
			assertThat(exception.getMessage()).isEqualTo("The value '-1' is outside the valid range for Roman Numerals (0 < X < 4000)");
		}
	}
	
	@Test
	public void convert_givenValueEqualToZero_throwsIllegalArgumentException() throws Exception {
		
		try {
			_converter.convert(0);
			fail();
		}
		catch (IllegalArgumentException exception) {
			
			assertThat(exception.getMessage()).isEqualTo("The value '0' is outside the valid range for Roman Numerals (0 < X < 4000)");
		}
	}

	@Test
	public void convert_givenAValueOfEleven_shouldConsumeUntilReachingZero_andAddXIToOutput() throws Exception {
		
		assertThat(_converter.convert(11)).isEqualTo("XI");
	}

	@Test
	public void convert_givenAValueOfThree_shouldConsumeUntilReachingZero_andAddIIIToOutput() throws Exception {
		
		assertThat(_converter.convert(3)).isEqualTo("III");
	}
	
	@Test
	public void convert_givenLargeValue_shouldWork() throws Exception {
		
		assertThat(_converter.convert(1066)).isEqualTo("MLXVI");
		assertThat(_converter.convert(1989)).isEqualTo("MCMLXXXIX");
	}
	
	@Test
	public void convert_withValue_givenLargeValues_shouldWork() throws Exception {
		
		_converter.setValue(1989);

		assertThat(_converter.convert()).isEqualTo("MCMLXXXIX");
	}
	
	@Test
	public void value_withValueSet_shouldReturnConvertedValue() throws Exception {
		
		_converter.setNumeral("I");
		
		assertThat(_converter.value()).isEqualTo(1);
	}
	
	@Test
	public void value_withValueSet_shouldReturnConvertedValue_Fourteen() throws Exception {
		
		_converter.setNumeral("XIV");
		
		assertThat(_converter.value()).isEqualTo(14);
	}
	
	@Test
	public void value_withThreeAndTwenty_shouldReturnConvertedValue() throws Exception {
		
		assertThat(_converter.value("XXIII")).isEqualTo(23);
	}

	@Test
	public void value_withNothingSetToConvert_shouldReturnZero() throws Exception {
		
		assertThat(_converter.value()).isEqualTo(0);
	}
	
	@Test
	public void value_withUnhandledCharacters_shouldThrowException() throws Exception {
		
		try {
			_converter.value("QWERTY");
			fail();
		}
		catch (NumberFormatException exception) {
			
			assertThat(exception.getMessage()).isEqualTo("The string 'QWERTY' is not a valid Roman Numeral");
		}
	}
	
	@Test
	public void convert_withValueGreaterThan4000_shouldThrowException() throws Exception {
		
		try {
			_converter.convert(4001);
			fail();
		}
		catch (IllegalArgumentException exception) {
			
			assertThat(exception.getMessage()).isEqualTo("The value '4001' is outside the valid range for Roman Numerals (0 < X < 4000)");
		}
	}

	@Test
	public void value_withBigValue_shouldStillWork() throws Exception {
		
		assertThat(_converter.value("MCMLXXXIX")).isEqualTo(1989);
	}
}
