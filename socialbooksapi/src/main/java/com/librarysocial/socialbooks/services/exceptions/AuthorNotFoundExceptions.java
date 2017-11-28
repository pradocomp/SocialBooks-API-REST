package com.librarysocial.socialbooks.services.exceptions;

public class AuthorNotFoundExceptions extends RuntimeException {

	private static final long serialVersionUID = 5669468311093717100L;

	public AuthorNotFoundExceptions(String message) {
		super(message);
	}

	public AuthorNotFoundExceptions(String message, Throwable target) {
		super(message, target);
	}
	
}
