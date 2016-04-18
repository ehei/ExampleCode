package com.ehei.convert;

public class ArabicToRomanNumeralConverter {

	private int valueToConvert;
	private int workingValue;
	private StringBuilder output = new StringBuilder();

	public void setValue(int valueToConvert) {
		
		this.valueToConvert = valueToConvert;
		this.workingValue = valueToConvert;
		
		this.output.setLength(0);
	}

	public boolean consume() {

		if (this.workingValue > 0) {
			
			if (this.workingValue >= 10) {
				
				this.workingValue -= 10;
				this.output.append("X");
			}
			else if (this.workingValue  >= 5) {
				
				this.workingValue -= 5;
				this.output.append("V");
			}
			else if (this.workingValue  >= 1) {
				
				this.workingValue -= 1;
				this.output.append("I");
			}
			
			return true;
		}
		return false;
	}

	public boolean hasValue() {

		return this.valueToConvert > 0;
	}

	public String getOutput() {
		
		return this.output.toString();
	}

	public String convert() {
		
		while (this.consume()) {
			
		}
		
		return this.output.toString();
	}

}
