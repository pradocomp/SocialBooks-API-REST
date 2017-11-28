package com.librarysocial.socialbooks.client.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Author {

	private Long id;
	
	private String name;
	
	@JsonFormat (pattern = "dd/mm/yyyy")
	private Date dateBirthday;
	
	private String nationality;
	
	private List<Book> books;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getDateBirthday() {
		return dateBirthday;
	}
	
	public void setDateBirthday(Date dateBirthday) {
		this.dateBirthday = dateBirthday;
	}
	
	public String getNationality() {
		return nationality;
	}
	
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	public List<Book> getBooks() {
		return books;
	}
	
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
}
