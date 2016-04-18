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
	public void convert_shouldReturnEmptyString_ifNoValueGivenToConvert() throws Exception {
		
		assertThat(_converter.convert()).isEmpty();
	}
	
	@Test
	public void convert_givenValueLessThanZero_shouldReturnEmptyString() throws Exception {
		
		assertThat(_converter.convert(-1)).isEmpty();
	}
	
	@Test
	public void convert_givenValueEqualToZero_shouldReturnEmptyString() throws Exception {
		
		assertThat(_converter.convert(0)).isEmpty();
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
}
