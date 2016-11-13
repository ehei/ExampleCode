package com.ehei.convert;

import java.util.OptionalDouble;

public enum RomanNumeral {

	M(1000,3),
    CM(900,1),
    D(500,1),
    CD(400,1),
    C(100,3),
    XC(90,1),
    L(50,1),
    XL(40,1),
    X(10,3),
    IX(9,1),
    V(5,1),
    IV(4,1),
    I(1,3);
	
	private int numericValue;
	private int maxRepeat;
	
	private RomanNumeral(int value, int maxRepeat) {
		
		this.numericValue = value;
		this.maxRepeat = maxRepeat;
	}

	public int getNumericValue() {
		
		return numericValue;
	}

	public String getSymbolicValue() {
		
		return this.name();
	}

	public int getMaxRepeat() {
		
		return this.maxRepeat;
	}
	
}
