package com.librarysocial.socialbooks.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.librarysocial.socialbooks.domain.Author;
import com.librarysocial.socialbooks.repository.AuthorsRepository;
import com.librarysocial.socialbooks.services.exceptions.AuthorExistingExceptions;
import com.librarysocial.socialbooks.services.exceptions.AuthorNotFoundExceptions;

@Service
public class AuthorsService {
	
	@Autowired
	private AuthorsRepository authorsRepository;
	
	public List<Author> list() {
		return authorsRepository.findAll();
	}
	
	public Author save(Author author) {
		if (author.getId() != null) {
			Author a = authorsRepository.findOne(author.getId());
			if (a != null) {
				throw new AuthorExistingExceptions("O Autor já existe");
			}
		}
		return authorsRepository.save(author);
	}
	
	public Author find(Long id) {
		Author author = authorsRepository.findOne(id);
		if (author == null) {
			throw new AuthorNotFoundExceptions("Author is not found.");
		}
		return author;
	}

}
