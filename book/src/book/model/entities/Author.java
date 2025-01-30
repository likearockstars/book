package book.model.entities;

import book.model.exception.CpfException;
import book.utils.StringChecker;

public class Author extends Person {
	
	private String pseudonmy;
	
	public Author() {
		super();
	}

	
	public Author(Integer numberId,String cpf,String firstName, String lastName,String email) throws CpfException{
		
		
		super(numberId,cpf,firstName,lastName,email);
		this.setPseudonmy(pseudonmy);
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
		return "Author [getPseudonmy()=" + getPseudonmy() + "]";
	}


	
	
	
		
}
