package com.librarysocial.socialbooks.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.librarysocial.socialbooks.client.BooksClient;
import com.librarysocial.socialbooks.client.domain.Book;

public class Application {

	public static void main(String[] args) throws ParseException {

		BooksClient client = new BooksClient("http://localhost:8080", "guilherme", "roots");
		
		// Printing the book
		System.out.println("Print the books saves: ");
		List<Book> books = client.list();
		for(Book book : books) {
			System.out.println("Book: " + book.getName());
		}
		
		// Saving the book
		System.out.println("-- Saving another book --");
		Book book = new Book();
		book.setName("TESTE - How to build API");
		book.setPublisher("Editora Brasil");
		SimpleDateFormat publication = new SimpleDateFormat("dd/mm/yyyy");
		book.setPublication(publication.parse("01/06/2017"));
		book.setSummary("This book is about developing SOAP services.");
		
		String localization = client.save(book);
		System.out.println("Book: " + book.getName());
		System.out.println("URI of the book saved:" + localization);
		
		// Finding the book
		Book BookFound = client.find(localization);
		
		System.out.println("Livro encontrado: " + BookFound.getName());
	}

}
