package com.softarea.learningapp.model;

import android.database.Cursor;

import com.softarea.learningapp.R;

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

  public Note(Cursor cursor) {
    this.title = cursor.getString(cursor.getColumnIndexOrThrow("title"));
    this.content = cursor.getString(cursor.getColumnIndexOrThrow("content"));
    this.author = new User("Dominik", "Pająk", "SOFTAREA - Junior Android Developer", R.drawable.demo_profile);
    this.createdAt = new Date();
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
