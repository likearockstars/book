package book.model.entities;

import book.model.exception.CpfError;
import book.utils.NumberChecker;
import book.utils.StringChecker;

public class Author extends Person {
	
	
	private Long numberAuthor;
	private String pseudonmy;
	
	public Author() {
		super();
	}

	
	public Author(String cpf,String firstName, String lastName,String email) throws CpfError {
		
		
		super(cpf,firstName,lastName,email);
		this.setNumberAuthor(numberAuthor);
		this.setPseudonmy(pseudonmy);
	}
	
	public void setNumberAuthor(Long numberAuthor) {
		
		
		NumberChecker.checkNumberInteger(numberAuthor);
		this.numberAuthor = numberAuthor;
	}
	
	public Long getNumberAuthor() {
		
		return this.numberAuthor;
	}
	
	public void setPseudonmy(String pseudonmy) {
		
		
		if(StringChecker.nameValidator(pseudonmy)) {
			
			this.pseudonmy = pseudonmy;
		}else {
			
			throw new IllegalArgumentException("Enter a valid pseudo name");
		}
	}
	
	public String getPseudonmy() {
		
		return this.pseudonmy;
	}


	@Override
	public String toString() {
		return "Author [getNumberAuthor()=" + getNumberAuthor() + ", getPseudonmy()=" + getPseudonmy() + "]";
	}
	
	
		
}
