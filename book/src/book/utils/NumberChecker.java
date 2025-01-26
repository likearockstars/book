package book.utils;

public class NumberChecker {
	
	public static void checkNumberDouble(Object number) {
	    if (!(number instanceof Double)) {
	        throw new IllegalArgumentException("Enter a floating point number (Double).");
	    }
	}

	public static void checkNumberInteger(Object number) {
	    if (!(number instanceof Integer)) {
	        throw new IllegalArgumentException("Enter an integer number (Integer).");
	    }
	}


}
