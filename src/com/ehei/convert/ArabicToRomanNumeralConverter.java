package com.ehei.convert;

import java.util.TreeMap;

public class ArabicToRomanNumeralConverter {

	private static final TreeMap<Integer, RomanNumeral> map = new TreeMap<Integer, RomanNumeral>();
	private int numberToConvert;
	
	static {
		
		for (RomanNumeral numeral : RomanNumeral.values()) {
			map.put(numeral.getNumericValue(), numeral);
		}
	}
	
	public String convert() {
		
		return this.convert(this.numberToConvert);
	}

	public String convert(int value) {
		
		if (value <= 0)
			return "";
		
		int lowestValue =  map.floorKey(value);
		
        if ( value == lowestValue ) {
        	
            return map.get(value).toString();
        }
        
        return map.get(lowestValue).toString() + convert(value - lowestValue).toString();
	}

	public void setValue(int number) {
		
		this.numberToConvert = number;
	}

}
