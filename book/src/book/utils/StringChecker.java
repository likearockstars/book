package book.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import book.model.exception.CpfError;

public class StringChecker {
	
	
	public static boolean CpfValidator(String prompt) {
		
		// regular expression to check the person's email
		String rgx = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$";
		Pattern pattern = Pattern.compile(rgx);
		Matcher matcher = pattern.matcher(prompt);
		return matcher.matches();
	}
	
	public static boolean nameValidator(String prompt) {
		

		// Name with 2 to 50 characters (letters and spaces)
		String rgx = "^[A-Za-zÀ-ÖØ-öø-ÿ\\s]{2,50}$";
		Pattern pattern = Pattern.compile(rgx);
		Matcher matcher = pattern.matcher(prompt);
		return matcher.matches();
	}
	
	public static boolean emailValidator(String prompt) {
		
		String rgx = " String regex = \"^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\\\.[A-Za-z]{2,}$\";";
		Pattern pattern = Pattern.compile(rgx);
		Matcher matcher = pattern.matcher(prompt);
		return matcher.matches();
	}
	
	public static boolean phoneValidator(String prompt) {
		
		 // "(XX) XXXX-XXXX" ou "(XX) XXXXX-XXXX"
		 String rgx = "^\\(\\d{2}\\)\\s?\\d{4,5}-\\d{4}$"; 
		 Pattern pattern = Pattern.compile(rgx);
		 Matcher matcher = pattern.matcher(prompt);
		 return matcher.matches();
	}
	
	public static boolean nationalityValidator(String prompt) {
		
		String rgx = "[a-zA-Z]";
		Pattern pattern = Pattern.compile(rgx);
		Matcher matcher = pattern.matcher(prompt);
		return matcher.matches();
	}
	
	public static boolean digitValidation(String prompt) throws CpfError {

		
		// Get first digit validator
		String stringFirstDigitValidator = prompt.substring(12,13);
		Integer numberFirstDigitValidator = stringFirstDigitValidator.charAt(0) - '0';
		
		// Get second digit validator
		String stringSecondDigitValidator = prompt.substring(13,14); 
		Integer numberSecondDigitValidator = stringSecondDigitValidator.charAt(0) - '0';
		
	
		
		String nineDigits = prompt.substring(0, 11);
		
		List<Integer> integerDigits = new ArrayList<>();
		
		
		for(int i = 0; i < nineDigits.length(); i++) {
			
			
			char currentChar = nineDigits.charAt(i);
			
			if(currentChar != '.' && currentChar != '-') {
				
				
				Integer digit = currentChar - '0';
				
				integerDigits.add(digit);
			}
			
		}
		
		
		Integer firstCheckDigit = getCheckDigit(integerDigits, 10);
		
		integerDigits.add(firstCheckDigit);
			
		Integer secondCheckDigit = getCheckDigit(integerDigits, 11);
		
		integerDigits.add(secondCheckDigit);
		
		if(numberFirstDigitValidator.equals(firstCheckDigit) && numberSecondDigitValidator.equals(secondCheckDigit)) {
			return true;
		}else {
			
			throw new CpfError("Enter a CPF with valid verification digits");
		}
		
		
	}
	
	public static int getCheckDigit(List<Integer> cpf, int weigth) {
		
		int sum = 0;
		
		for(Integer digit : cpf) {
			
			
			sum += digit * weigth;
			weigth--;
		}
		
		
		int rest = sum % 11;
		return (rest < 2) ? 0 : 11 - rest;
	}
	
	
	
	

}
