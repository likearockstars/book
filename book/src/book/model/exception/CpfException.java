package book.model.exception;

public class CpfException extends Exception {
	
	private static final long serialVersionUID = 256347037757722154L;

	public CpfException(String error) {
		
		super(error);
	}
}
