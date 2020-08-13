package com.softarea.learningapp.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "USERS")
public class User implements Serializable {
  @PrimaryKey
  private int id;
  @ColumnInfo(name = "fullname")
  private String fullName;
  @ColumnInfo(name = "position")
  private String position;
  @ColumnInfo(name = "image")
  private int image;
  @ColumnInfo(name = "email")
  private String email;
  @ColumnInfo(name = "password")
  private String password;
  @ColumnInfo(name = "token")
  private String token;

  @Override
  public String toString() {
    return "User{" +
      "id=" + id +
      ", fullName='" + fullName + '\'' +
      ", position='" + position + '\'' +
      ", image=" + image +
      '}';
  }

  public int getId() {
    return id;
  }

  public String getFullName() {
    return fullName;
  }

  public String getPosition() {
    return position;
  }

  public User(int id, String fullName, String position, int image, String email, String password, String token) {
    this.id = id;
    this.fullName = fullName;
    this.position = position;
    this.image = image;
    this.email = email;
    this.password = password;
    this.token = token;
  }
  @Ignore
  public User(int id, String fullName, String position, int image) {
    this.id = id;
    this.fullName = fullName;
    this.position = position;
    this.image = image;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public String getToken() {
    return token;
  }

  public int getImage() {
    return image;
  }


}
