package com.librarysocial.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.librarysocial.socialbooks.domain.Comment;

public interface CommentsRepository extends JpaRepository<Comment, Long> {

}
