package book.model.entities;

import java.time.LocalDate;

import book.utils.NumberChecker;
import book.utils.StringChecker;

public class Book {
	
	private String ISBN;
	private String title;
	private Integer volume;
	private Author author;
	private String publisher;
	private LocalDate publicationYear;
	private String genre;
	private Double price;
	private Integer pages;
	
	public Book() {
	}
	
	public Book(String ISBN, String title, Integer volume, Author author, String publisher, LocalDate publicationYear, String genre, Double price, Integer pages) {
		
		this.setISBN(ISBN);
		this.setTitle(title);
		this.setVolume(volume);
		this.setAuthor(author);
		this.setPublicationYear(publicationYear);
		this.setGenre(genre);
		this.setPrice(price);
		this.setPages(pages);
		
	}
	
	
	public void setISBN(String ISBN) {
		
		
		if( !(StringChecker.nameValidator(ISBN)) ) {
			
			throw new IllegalArgumentException("Enter a ISBN valid!");
		}
		
		this.ISBN = ISBN;
	}
	
	public String getISBN() {
		
		
		return this.ISBN;
	}
	
	public void setTitle(String title) {
		
		if( !(StringChecker.nameValidator(title)) ) {
			
			throw new IllegalArgumentException("Enter a title valid!");
		}
		
		this.title = title;
	}
	
	public String getTitle() {
		
		return this.title;
	}
	
	public void setVolume(Integer volume) {
		
		
		NumberChecker.checkNumberInteger(volume);
		this.volume = volume;
	}
	
	public Integer getVolume() {
		
		return this.volume;
	}

	
	public void setAuthor(Author author) {
		
		this.author = author;
	}
	
	public Author getAuthor() {
		
		return this.author;
	}
	
	public void setPublisher(String publisher) {
		
		
		if( !(StringChecker.nameValidator(publisher)) ) {
			
			throw new IllegalArgumentException("Enter a publisher valid!");
		}
	}
	
	public String getPublisher() {
		
		return this.publisher;
	}
	
	public void setPublicationYear(LocalDate publicationYear) {
		
		this.publicationYear = publicationYear;
	}
	
	public LocalDate getPublicationYear() {
		
		return this.publicationYear;
	}
	
	public void setGenre(String genre) {
		
		
		if( !(StringChecker.nameValidator(genre)) ) {
		
			throw new IllegalArgumentException("Enter a genre valid!");
		}
		
		this.genre = genre;
	}
	
	public String getGenre() {
		
		return this.genre;
	}
	
	public void setPrice(Double price) {
		
		NumberChecker.checkNumberDouble(price);
		this.price = price;
	}
	
	public Double getPrice() {
		
		return this.price;
	}
	
	public void setPages(Integer pages) {
		
		NumberChecker.checkNumberInteger(pages);
		this.pages = pages;
	}
	
	
	public Integer getPages() {
		
		return this.pages;
	}

	@Override
	public String toString() {
		return "Book [getISBN()=" + getISBN() + ", getTitle()=" + getTitle() + ", getVolume()=" + getVolume()
				+ ", getAuthor()=" + getAuthor() + ", getPublisher()=" + getPublisher() + ", getPublicationYear()="
				+ getPublicationYear() + ", getGenre()=" + getGenre() + ", getPrice()=" + getPrice() + ", getPages()="
				+ getPages() + "]";
	}
	
	
}
