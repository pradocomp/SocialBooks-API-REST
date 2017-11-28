package com.librarysocial.socialbooks.client;

import java.net.URI;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.librarysocial.socialbooks.client.domain.Book;

public class BooksClient {
	
	private RestTemplate restTemplate;
	
	private String URI_BASE;
	
	private String URN_BASE = "/livros";
	
	private String credencial;
	
	// Constructor
	public BooksClient (String url, String user, String password) {
		restTemplate = new RestTemplate();
		
		URI_BASE = url.concat(URN_BASE);
		
		String credencialAux = user + ":" + password;
		
		credencial = "Basic " + Base64.getEncoder().encodeToString(credencialAux.getBytes());
	}
	
	// List a Books available
	public List<Book> list () {
		RequestEntity<Void> request= RequestEntity
				.get(URI.create(URI_BASE))
				.header("Authorization", credencial).build();
		ResponseEntity<Book[]> response = restTemplate.exchange(request, Book[].class);
		return Arrays.asList(response.getBody());
	}
	
	// Save the book
	public String save (Book book) {
		RequestEntity<Book> request= RequestEntity
				.post(URI.create(URI_BASE))
				.header("Authorization", credencial).body(book);
		
		ResponseEntity<Void> response = restTemplate.exchange(request, Void.class);
		
		return response.getHeaders().getLocation().toString();
		
	}
	
	// Find a Book
	public Book find (String uri) {
		RequestEntity<Void> request= RequestEntity
				.get(URI.create(uri))
				.header("Authorization", credencial)
				.build();
		
		ResponseEntity<Book> response = restTemplate.exchange(request, Book.class);
		
		return response.getBody();
		
	}
	
}
