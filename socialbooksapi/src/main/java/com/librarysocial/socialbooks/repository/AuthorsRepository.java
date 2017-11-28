package com.librarysocial.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.librarysocial.socialbooks.domain.Author;

public interface AuthorsRepository extends JpaRepository<Author, Long> {

}
