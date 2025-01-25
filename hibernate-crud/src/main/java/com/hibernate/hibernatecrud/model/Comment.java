package com.hibernate.hibernatecrud.model;
import java.time.Instant;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "comments")
public class Comment {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
@Column(nullable = false)
private String name;
@Column(nullable = false)
private String commentText;
@CreationTimestamp
private Instant createdOn;
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
public String getCommentText() {
return commentText;
}
public void setCommentText(String commentText) {
this.commentText = commentText;
}
public Instant getCreatedOn() {
return createdOn;
}
public void setCreatedOn(Instant createdOn) {
this.createdOn = createdOn;
}
}
