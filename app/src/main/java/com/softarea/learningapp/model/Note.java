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
  private String date;
  @ColumnInfo(name = "time")
  private String time;

  public Note(String title, String content, int author, String date, String time) {
    this.title = title;
    this.content = content;
    this.author = author;
    this.date = date;
    this.time = time;
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

  public String getDate() {
    return date;
  }

  public String getTime() {
    return time;
  }


}
