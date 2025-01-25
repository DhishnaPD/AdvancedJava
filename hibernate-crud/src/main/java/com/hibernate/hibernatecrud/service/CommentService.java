package com.hibernate.hibernatecrud.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hibernate.hibernatecrud.model.Comment;
import com.hibernate.hibernatecrud.repository.CommentRepository;
@Service
public class CommentService {
@Autowired
private CommentRepository commentRepository;
public Comment saveComment(Comment comment) {
return commentRepository.save(comment);
}
public List<Comment> getComments(){
return commentRepository.findAll();
}
public Comment getCommentById(Long id) {
return commentRepository.findById(id).orElse(null);
}
public String deleteComment(long id) {
commentRepository.deleteById(id);
return "comment deleted : "+id;
}
public Comment updateComment(Comment comment) {
Comment existingComment = 
commentRepository.findById(comment.getId()).orElse(null);
existingComment.setName(comment.getName());
existingComment.setCommentText(comment.getCommentText());
return commentRepository.save(existingComment);
}
}