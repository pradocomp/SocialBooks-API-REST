package com.librarysocial.socialbooks.services.exceptions;

public class AuthorExistingExceptions extends RuntimeException {

	private static final long serialVersionUID = 5669468311093717100L;

	public AuthorExistingExceptions(String message) {
		super(message);
	}

	public AuthorExistingExceptions(String message, Throwable target) {
		super(message, target);
	}
	
}
