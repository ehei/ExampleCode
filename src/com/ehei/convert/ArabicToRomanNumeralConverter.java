package com.ehei.convert;

import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;

public class ArabicToRomanNumeralConverter {

	private static final TreeMap<Integer, RomanNumeral> map = new TreeMap<Integer, RomanNumeral>();
	private int numberToConvert;
	private String numeralToConvert;
	
	static {
		
		for (RomanNumeral numeral : RomanNumeral.values()) {
			map.put(numeral.getNumericValue(), numeral);
		}
	}
	
	public String convert() {
		
		return this.convert(this.numberToConvert);
	}

	public String convert(int value) {
		
		if (value < 1 || value > 3999)
			throw new IllegalArgumentException(
					String.format("The value '%d' is outside the valid range for Roman Numerals (0 < X < 4000)", value));
		
		int lowestValue =  map.floorKey(value);
		
        if ( value == lowestValue ) {
        	
            return map.get(value).toString();
        }
        
        return map.get(lowestValue).toString() + convert(value - lowestValue).toString();
	}

	public void setValue(int number) {
		
		this.numberToConvert = number;
	}

	public void setNumeral(String numeral) {
		
		this.numeralToConvert = numeral;
	}

	public int value() {
		
		if (StringUtils.isEmpty(this.numeralToConvert))
			return 0;
		
		return this.value(this.numeralToConvert);
	}

	public int value(String numeralToConvert) {
		if (StringUtils.isEmpty(numeralToConvert))
			return 0;
		
		int number = 0;
        int offset = 0;
        for (RomanNumeral digit : RomanNumeral.values()) {
            int value = digit.getNumericValue();
            int maxRepeat = digit.getMaxRepeat();
            String symbol = digit.getSymbolicValue();

            for (int index = 0; index < maxRepeat && numeralToConvert.startsWith(symbol, offset); index++) {
                number += value;
                offset += symbol.length();
            }
        }
        
        if (offset != numeralToConvert.length()) {
            throw new NumberFormatException(String.format(
                    "The string '%s' is not a valid Roman Numeral",
                    numeralToConvert ));
        }
        
        return number;
	}

}
