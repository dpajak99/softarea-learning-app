package com.softarea.learningapp.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "TOKEN")
public class Token {
  @PrimaryKey
  private int id;
  @ColumnInfo(name = "token")
  private String token;

  public int getId() {
    return id;
  }

  public String getToken() {
    return token;
  }

  public Token(int id, String token) {
    this.id = id;
    this.token = token;
  }
}
