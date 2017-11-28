package com.librarysocial.socialbooks.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Name can not empty.")
	private String name;
	
	@JsonInclude(Include.NON_NULL)
	@JsonFormat (pattern = "dd/mm/yyyy")
	@NotNull(message = "The dateBirthday is required.")
	private Date dateBirthday;
	
	@JsonInclude(Include.NON_NULL)
	@NotNull(message = "The nationality is required.")
	private String nationality;
	
	@OneToMany(mappedBy = "author")
	@JsonIgnore
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
