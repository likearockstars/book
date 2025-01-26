package book.model.entities;

import java.time.LocalDate;

import book.model.exception.CpfError;
import book.utils.StringChecker;

public abstract class Person {
	
	private  String cpf;
	private String firstName;
	private String lastName;
	private String email;
	private LocalDate birthDate;
	private String nationalty;
	private String phone;
	
	public Person() {
	}
	
	public Person(String cpf, String firstName, String lastName, String email, LocalDate birthDate, String nationality,String phone) throws CpfError {
		
		this.setCpf(cpf);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEmail(email);
		this.setBirthDate(birthDate);
		this.setNationality(nationality);
		this.setPhone(phone);
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
	
	public void setBirthDate(LocalDate birthDate) {
		
		this.birthDate = birthDate;
	}
	
	public LocalDate getBirthDate() {
		
		return this.birthDate;
	}
	
	public void setNationality(String nationality) {
		
		if(StringChecker.nationalityValidator(nationality)) {
			
			this.nationalty = nationality;
		}else {
			throw new IllegalArgumentException("Enter a nationality valid!");
		}
	}
	
	public String getNationality() {
		
		return this.nationalty;
	}
	
	public void setPhone(String phone) {
		
		
		if(StringChecker.phoneValidator(phone)) {
			this.phone = phone;
		}else {
			throw new IllegalArgumentException("invalid telepone format!");
		}
	}
	
	public String getPhone() {
		
		return this.phone;
	}

	@Override
	public String toString() {
		return "Person [getCpf()=" + getCpf() + ", getFirstName()=" + getFirstName() + ", getLastName()="
				+ getLastName() + ", getEmail()=" + getEmail() + ", getBirthDate()=" + getBirthDate()
				+ ", getNationality()=" + getNationality() + ", getPhone()=" + getPhone() + "]";
	}
	
	
}
