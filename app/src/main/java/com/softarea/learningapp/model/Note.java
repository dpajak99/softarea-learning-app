package com.softarea.learningapp.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "NOTES")
public class Note implements Serializable {
  @PrimaryKey(autoGenerate = true)
  private int id;
  @ColumnInfo(name = "title")
  private String title;
  @ColumnInfo(name = "content")
  private String content;
  @ColumnInfo(name = "author")
  private int author;
  @ColumnInfo(name = "date")
  private String createdAt;

  public Note(String title, String content, int author, String createdAt) {
    this.title = title;
    this.content = content;
    this.author = author;
    this.createdAt = createdAt;
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

  public int getAuthor() {
    return author;
  }

  public String getCreatedAt() {
    return createdAt;
  }


}
