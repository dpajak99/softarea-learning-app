package com.softarea.learningapp.model;

import java.util.Date;

public class Note {
  private String title;
  private String content;
  private User author;
  private Date createdAt;

  public Note(String title, String content, User author, Date created_at) {
    this.title = title;
    this.content = content;
    this.author = author;
    this.createdAt = created_at;
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
