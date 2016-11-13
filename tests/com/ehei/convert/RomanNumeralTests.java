package com.ehei.convert;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class RomanNumeralTests {


	@Test
	public void value() {

		assertThat(RomanNumeral.M.getNumericValue()).isEqualTo(1000);
		assertThat(RomanNumeral.CM.getNumericValue()).isEqualTo(900);
		assertThat(RomanNumeral.D.getNumericValue()).isEqualTo(500);
		assertThat(RomanNumeral.CD.getNumericValue()).isEqualTo(400);
		assertThat(RomanNumeral.C.getNumericValue()).isEqualTo(100);
		assertThat(RomanNumeral.XC.getNumericValue()).isEqualTo(90);
		assertThat(RomanNumeral.L.getNumericValue()).isEqualTo(50);
		assertThat(RomanNumeral.XL.getNumericValue()).isEqualTo(40);
		assertThat(RomanNumeral.X.getNumericValue()).isEqualTo(10);
		assertThat(RomanNumeral.IX.getNumericValue()).isEqualTo(9);
		assertThat(RomanNumeral.V.getNumericValue()).isEqualTo(5);
		assertThat(RomanNumeral.IV.getNumericValue()).isEqualTo(4);
		assertThat(RomanNumeral.I.getNumericValue()).isEqualTo(1);
	}
	
	@Test
	public void symbol() throws Exception {
		
		assertThat(RomanNumeral.M.getSymbolicValue()).isEqualTo("M");
		assertThat(RomanNumeral.CM.getSymbolicValue()).isEqualTo("CM");
		assertThat(RomanNumeral.D.getSymbolicValue()).isEqualTo("D");
		assertThat(RomanNumeral.CD.getSymbolicValue()).isEqualTo("CD");
		assertThat(RomanNumeral.C.getSymbolicValue()).isEqualTo("C");
		assertThat(RomanNumeral.XC.getSymbolicValue()).isEqualTo("XC");
		assertThat(RomanNumeral.L.getSymbolicValue()).isEqualTo("L");
		assertThat(RomanNumeral.XL.getSymbolicValue()).isEqualTo("XL");
		assertThat(RomanNumeral.X.getSymbolicValue()).isEqualTo("X");
		assertThat(RomanNumeral.IX.getSymbolicValue()).isEqualTo("IX");
		assertThat(RomanNumeral.V.getSymbolicValue()).isEqualTo("V");
		assertThat(RomanNumeral.IV.getSymbolicValue()).isEqualTo("IV");
		assertThat(RomanNumeral.I.getSymbolicValue()).isEqualTo("I");
	}

	@Test
	public void maxRepeat() throws Exception {
		
		assertThat(RomanNumeral.M.getMaxRepeat()).isEqualTo(3);
		assertThat(RomanNumeral.CM.getMaxRepeat()).isEqualTo(1);
		assertThat(RomanNumeral.D.getMaxRepeat()).isEqualTo(1);
		assertThat(RomanNumeral.CD.getMaxRepeat()).isEqualTo(1);
		assertThat(RomanNumeral.C.getMaxRepeat()).isEqualTo(3);
		assertThat(RomanNumeral.XC.getMaxRepeat()).isEqualTo(1);
		assertThat(RomanNumeral.L.getMaxRepeat()).isEqualTo(1);
		assertThat(RomanNumeral.XL.getMaxRepeat()).isEqualTo(1);
		assertThat(RomanNumeral.X.getMaxRepeat()).isEqualTo(3);
		assertThat(RomanNumeral.IX.getMaxRepeat()).isEqualTo(1);
		assertThat(RomanNumeral.V.getMaxRepeat()).isEqualTo(1);
		assertThat(RomanNumeral.IV.getMaxRepeat()).isEqualTo(1);
		assertThat(RomanNumeral.I.getMaxRepeat()).isEqualTo(3);
	}
}
