package com.ehei.convert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {

	// Very basic input/output to exercise the converter
	public static void main(String[] args) throws Exception {

		boolean exit = false;

		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(inputStreamReader);
        ArabicToRomanNumeralConverter converter = new ArabicToRomanNumeralConverter();
        
        try
        {
			do {
			
				System.out.println("1. Enter numeric to convert to Roman numeral");
				System.out.println("2. Enter Roman numeral to convert to numeric");
				System.out.println("3. Exit");
	
		        String input = buffer.readLine();
				
		        switch (input)
		        {
			        case "3":
			        	exit = true;
			        	break;
			        case "2":
			        	convertRomanNumeral(buffer, converter);
			        	break;
			        case "1":
			        	convertNumeric(buffer, converter);
			        	break;
			        default:
			        	break;
		        }
				
			} while (!exit);
			
			System.out.println("See you next time!");
        }
        finally
        {
			buffer.close();
			inputStreamReader.close();
        }
	}

	private static void convertNumeric(BufferedReader buffer, ArabicToRomanNumeralConverter converter) throws IOException {
		System.out.println("Enter numeric:");
		try{
			String input = buffer.readLine();
			int number = Integer.parseUnsignedInt(input);
			converter.setValue(number);
			System.out.println(converter.convert());
		}
		catch (Exception exception){
			exception.printStackTrace();
		}
	}

	private static void convertRomanNumeral(BufferedReader buffer, ArabicToRomanNumeralConverter converter) throws IOException {
		System.out.println("Enter Roman numeral:");

		try
		{
			String numeralToConvert = buffer.readLine();
			converter.setNumeral(numeralToConvert);
			System.out.println(converter.value());
		}
		catch (Exception exception){
			exception.printStackTrace();
		}
	}

}
