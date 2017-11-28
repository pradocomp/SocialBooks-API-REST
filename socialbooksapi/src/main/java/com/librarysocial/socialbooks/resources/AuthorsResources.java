package com.librarysocial.socialbooks.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.librarysocial.socialbooks.domain.Author;
import com.librarysocial.socialbooks.services.AuthorsService;

@RestController
@RequestMapping("/authors")
public class AuthorsResources {

	@Autowired
	private AuthorsService authorsService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Author>> list() {
		return ResponseEntity.status(HttpStatus.OK).body(authorsService.list());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@Valid @RequestBody Author author) {
		author = authorsService.save(author);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(author.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable("id") Long id) {
		Author author = authorsService.find(id);
		return ResponseEntity.status(HttpStatus.OK).body(author);
	}
	
}
