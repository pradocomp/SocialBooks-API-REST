package com.librarysocial.socialbooks.resources;

import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.librarysocial.socialbooks.domain.Book;
import com.librarysocial.socialbooks.domain.Comment;
import com.librarysocial.socialbooks.services.BookService;

@RestController
@RequestMapping(value = "/books")
public class BooksResources {

	@Autowired
	private BookService bookService;

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Book>> list() {
		return ResponseEntity.status(HttpStatus.OK).body(bookService.list());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@Valid @RequestBody Book book) {
		book = bookService.save(book);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(book.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable("id") Long id) {
		Book book = bookService.find(id);
		CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);
		return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(book);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		bookService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Book book, @PathVariable("id") Long id) {
		book.setId(id);
		bookService.update(book);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}/comments", method = RequestMethod.POST)
	public ResponseEntity<Void> addComment(@PathVariable("id") Long bookId, @RequestBody Comment comment) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		comment.setUser(auth.getName());
		
		bookService.saveComment(bookId, comment);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}/comments", method = RequestMethod.GET)
	public ResponseEntity<List<Comment>> listComments (@PathVariable("id") Long bookId) {
		List<Comment> comments = bookService.listComment(bookId);
		
		return ResponseEntity.status(HttpStatus.OK).body(comments);
	}

}
