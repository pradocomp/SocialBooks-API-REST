package com.librarysocial.socialbooks.domain;


import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Book {

	@JsonInclude(Include.NON_NULL)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "The name is required.")
	private String name;
	
	@JsonInclude(Include.NON_NULL)
	@ManyToOne
	@JoinColumn(name = "AUTHOR_ID")
	private Author author;
	
	@JsonInclude(Include.NON_NULL)
	@JsonFormat (pattern = "yyyy-mm-dd")
	@NotNull(message = "The publication is required.")
	private Date publication;
	
	@JsonInclude(Include.NON_NULL)
	private String publisher;
	
	@JsonInclude(Include.NON_NULL)
	@NotNull(message = "The summary is required.")
	@Size(max = 1500, message = "Summary can not exceed 1500 characters.")
	private String summary;
	
	@JsonInclude(Include.NON_EMPTY)
	@OneToMany(mappedBy = "book")
	private List<Comment> comment;
	
	// Constructors
	public Book() {}
	
	public Book (String name) {
		this.name = name;
	}

	// Methods
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

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Date getPublication() {
		return publication;
	}

	public void setPublication(Date publication) {
		this.publication = publication;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}
	
}
