package book.model.entities;

import book.model.exception.CpfError;
import book.utils.StringChecker;

public abstract class Person {
	
	private  String cpf;
	private String firstName;
	private String lastName;
	private String email;

	
	public Person() {
	}
	
	public Person(String cpf, String firstName, String lastName, String email) throws CpfError {
		
		this.setCpf(cpf);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEmail(email);
	}
	
	public void setCpf(String cpf) throws CpfError
	{
		
		if(StringChecker.CpfValidator(cpf) && StringChecker.digitValidation(cpf)) {
			
			this.cpf = cpf;
		}else {
			throw new IllegalArgumentException("Enter an invalid CPF!");
		}
	}
	
	public String getCpf() {
		
		return this.cpf;
	}
	
	public void setFirstName(String firstName) {
		
		
		if(StringChecker.nameValidator(firstName)) {
			
			this.firstName = firstName;
		}else {
			throw new IllegalArgumentException("Enter a valid first name!");
		}
		
	
	}
	
	public String getFirstName() {
		
		return this.firstName;
	}
	
	public void setLastName(String lastName) {
		
		
		if(StringChecker.nameValidator(lastName)) {
			
			this.lastName = lastName;
		}else {
			throw new IllegalArgumentException("Enter a valid last name!");
		}
	}
	
	public String getLastName() {
		
		return this.lastName;
	}
	
	public void setEmail(String email) {
		
		if(StringChecker.emailValidator(email)) {
			
			this.email = email;
		}else {
			
			throw new IllegalArgumentException("Enter a valid email!");
		}
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
