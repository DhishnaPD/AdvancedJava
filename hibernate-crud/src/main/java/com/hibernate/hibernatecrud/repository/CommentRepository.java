package com.hibernate.hibernatecrud.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hibernate.hibernatecrud.model.Comment;
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
