package book.model.entities;
import book.model.exception.CpfException;
import book.utils.NumberChecker;
import book.utils.StringChecker;

public class Person {
	
	private Integer numberId;
	private  String cpf;
	private String firstName;
	private String lastName;
	private String email;

	
	public Person() {
	}
	
	
	public Person(Integer numberId, String firstName, String lastName, String email) throws CpfException {
		
		
		this.setNumberId(numberId);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEmail(email);
	}
	
	public Person(Integer numberId,String cpf, String firstName, String lastName, String email) throws CpfException {
		
		
		this.setNumberId(numberId);
		this.setCpf(cpf);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEmail(email);
	}
	
	public void setNumberId(Integer numberId) {
		
		NumberChecker.checkNumberInteger(numberId);
		this.numberId = numberId;
	
	}
	
	
	public Integer getNumberId() {
		
		return this.numberId;
	}
	
	public void setCpf(String cpf) throws CpfException
	{
		
		if( !(StringChecker.CpfValidator(cpf)) ){ 
			throw new CpfException("Enter a valid CPF!");
		}
		
		this.cpf = cpf;
	}
	
	public String getCpf() {
		
		return this.cpf;
	}
	
	public void setFirstName(String firstName) {
		
		
		if( !(StringChecker.nameValidator(firstName)) ) {
			
			throw new IllegalArgumentException("Enter a valid first name!");
		}
		
		this.firstName = firstName;
	
	}
	
	public String getFirstName() {
		
		return this.firstName;
	}
	
	public void setLastName(String lastName) {
		
		
		if( !(StringChecker.nameValidator(lastName)) ) {
			
			throw new IllegalArgumentException("Enter a valid last name!");
		}
		
		this.lastName = lastName;
	}
	
	public String getLastName() {
		
		return this.lastName;
	}
	
	public void setEmail(String email) {
		
		if( !(StringChecker.emailValidator(email)) ) {
			
			throw new IllegalArgumentException("Enter a valid email!");
		}
		
		this.email = email;
	}
	
	public String getEmail() {
		
		return this.email;
	}

	@Override
	public String toString() {
		return "Person [getCpf()=" + getCpf() + ", getFirstName()=" + getFirstName() + ", getLastName()="
				+ getLastName() + ", getEmail()=" + getEmail() + "]";
	}

	

	
}
