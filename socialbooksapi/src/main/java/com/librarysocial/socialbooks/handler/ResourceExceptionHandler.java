package com.librarysocial.socialbooks.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.librarysocial.socialbooks.domain.DetailsError;
import com.librarysocial.socialbooks.services.exceptions.AuthorExistingExceptions;
import com.librarysocial.socialbooks.services.exceptions.AuthorNotFoundExceptions;
import com.librarysocial.socialbooks.services.exceptions.BooksExceptions;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(BooksExceptions.class)
	public ResponseEntity<DetailsError> HandleBookNotFoundException(BooksExceptions e, HttpServletRequest request) {

		DetailsError error = new DetailsError();
		error.setStatus(404L);
		error.setTitle("The book is not found!");
		error.setMessageDeveloper("http://error.socialbooks.com/404");
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(AuthorExistingExceptions.class)
	public ResponseEntity<DetailsError> HandleAuthorExistingException(AuthorExistingExceptions e,
			HttpServletRequest request) {

		DetailsError error = new DetailsError();
		error.setStatus(409L);
		error.setTitle("The author is existing");
		error.setMessageDeveloper("http://error.socialbooks.com/409");
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}

	@ExceptionHandler(AuthorNotFoundExceptions.class)
	public ResponseEntity<DetailsError> HandleAuthorNotFoundException(AuthorNotFoundExceptions e,
			HttpServletRequest request) {

		DetailsError error = new DetailsError();
		error.setStatus(404L);
		error.setTitle("Author is not found");
		error.setMessageDeveloper("http://error.socialbooks.com/404");
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<DetailsError> HandleDataIntegrityViolationException(DataIntegrityViolationException e,
			HttpServletRequest request) {

		DetailsError error = new DetailsError();
		error.setStatus(400L);
		error.setTitle("Request invalid");
		error.setMessageDeveloper("http://error.socialbooks.com/400");
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}
