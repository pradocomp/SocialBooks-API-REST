package com.librarysocial.socialbooks.services.exceptions;

public class BooksExceptions extends RuntimeException {

	private static final long serialVersionUID = 5669468311093717100L;

	public BooksExceptions(String message) {
		super(message);
	}

	public BooksExceptions(String message, Throwable target) {
		super(message, target);
	}
	
}
