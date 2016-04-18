package com.ehei.convert;

public class ArabicToRomanNumeralConverter {

	private int valueToConvert;

	public void setValue(int valueToConvert) {
		
		this.valueToConvert = valueToConvert;	
	}

	public boolean consume() {

		return true;
	}

	public boolean hasValue() {

		return false;
	}

	public String getOutput() {
		
		return null;
	}

}
