package com.librarysocial.socialbooks.services;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.librarysocial.socialbooks.domain.Book;
import com.librarysocial.socialbooks.domain.Comment;
import com.librarysocial.socialbooks.repository.BooksRepository;
import com.librarysocial.socialbooks.repository.CommentsRepository;
import com.librarysocial.socialbooks.services.exceptions.BooksExceptions;

@Service
public class BookService {

	@Autowired
	private BooksRepository booksRepository;
	@Autowired
	private CommentsRepository commentsRepository;
	
	/**
	 * List the books
	 * @return
	 */
	public List<Book> list() {
		return booksRepository.findAll();
	}
	
	/**
	 * Find the book
	 * @param id
	 * @return
	 */
	public Book find(Long id) {
		Book book = booksRepository.findOne(id);
		if (book == null) {
			throw new BooksExceptions("The book not found!");
		}
		return book;
	}
	
	/**
	 * Save the book
	 * @param book
	 */
	public Book save(Book book) {
		book.setId(null);
		return booksRepository.save(book);
	}
	
	/**
	 * Delete the book
	 * @param id
	 */
	public void delete(Long id) {
		try {
			booksRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new BooksExceptions("The book not found!");
		}
	}
	
	/**
	 * update the book
	 * @param book
	 */
	public void update(Book book) {
		checkExistence(book);
		booksRepository.save(book);
	}
	
	/**
	 * Check the existence of book
	 * @param id
	 */
	private void checkExistence(Book book) {
		find(book.getId());
	}
	
	/**
	 * Save the comment in the book
	 * @param id
	 * @param comment
	 * @return
	 */
	public Comment saveComment(Long id, Comment comment) {
		Book book = find(id);
		comment.setBook(book);
		comment.setData(new Date());
		
		return commentsRepository.save(comment);
	}
	
	/**
	 * List all the comments
	 * @param bookId
	 * @return
	 */
	public List<Comment> listComment(Long bookId) {
		Book book = find(bookId);
		return book.getComment();
	}
}
