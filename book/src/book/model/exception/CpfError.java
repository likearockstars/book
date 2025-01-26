package book.model.exception;

public class CpfError extends Exception {
	
	private static final long serialVersionUID = 256347037757722154L;

	public CpfError(String error) {
		
		super(error);
	}
}
