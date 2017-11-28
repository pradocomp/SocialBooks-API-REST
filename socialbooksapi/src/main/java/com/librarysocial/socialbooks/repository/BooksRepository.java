package com.librarysocial.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.librarysocial.socialbooks.domain.Book;

public interface BooksRepository extends JpaRepository<Book, Long> {

}
