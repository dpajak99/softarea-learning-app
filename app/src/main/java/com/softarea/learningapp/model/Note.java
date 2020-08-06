package com.softarea.learningapp.model;

import java.io.Serializable;
import java.util.Date;

public class Note implements Serializable {
  private int id;
  private String title;
  private String content;
  private User author;
  private Date createdAt;

  public Note(int id, String title, String content, User author, Date created_at) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.author = author;
    this.createdAt = created_at;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public String getContent() {
    return content;
  }

  public User getAuthor() {
    return author;
  }

  public Date getCreatedAt() {
    return createdAt;
  }


}
