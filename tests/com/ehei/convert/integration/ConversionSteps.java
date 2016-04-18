package com.ehei.convert.integration;
import org.jbehave.core.annotations.*;

import com.ehei.convert.ArabicToRomanNumeralConverter;

import static org.assertj.core.api.Assertions.*;

public class ConversionSteps{
	
	private ArabicToRomanNumeralConverter converter;
	
	@When("I enter a $number")
	public void whenIEnterAnumber(@Named("number") int number){
		
		this.converter.setValue(number);
	}
	@Then("the Roman Numeral representation $numeral is returned")
	public void thenTheRomanNumeralRepresentationnumeralIsReturned(@Named("numeral") String numeral){
		 
		assertThat(this.converter.convert()).isEqualTo(numeral);
	}
	@Given("I have started the converter")
	public void givenIHaveStartedTheConverter(){
		
		this.converter = new ArabicToRomanNumeralConverter();
	}
}