package com.softarea.learningapp.model;

import java.util.Date;

public class Note {
  private String title;
  private String content;
  private User author;
  private Date created_at;

  public Note(String title, String content, User author, Date created_at ) {
    this.title = title;
    this.content = content;
    this.author = author;
    this.created_at = created_at;
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

  public Date getCreated_at() {
    return created_at;
  }


}
