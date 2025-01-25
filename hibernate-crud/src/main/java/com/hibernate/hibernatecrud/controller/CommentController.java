package com.hibernate.hibernatecrud.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.hibernate.hibernatecrud.model.Comment;
import com.hibernate.hibernatecrud.service.CommentService;
@RestController
public class CommentController {
@Autowired
private CommentService service;
@PostMapping("/addcomment")
public Comment addComment(@RequestBody Comment comment) {
return service.saveComment(comment);
}
@GetMapping("/allcomments")
public List<Comment> getAllComments(){
return service.getComments();
}
@GetMapping("/comment/{id}")
public Comment getCommentById(@PathVariable long id) {
return service.getCommentById(id);
}
@PutMapping("/update")
public Comment updateComment(@RequestBody Comment comment) {
return service.updateComment(comment);
}
@DeleteMapping("/delete/{id}")
public String deleteComment(@PathVariable long id) {
return service.deleteComment(id);
}
}