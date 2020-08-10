package com.softarea.learningapp.model;

import java.io.Serializable;

public class User implements Serializable {
  private int id;
  private String fullName;
  private String position;
  private int image;

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

  public int getImage() {
    return image;
  }

  public User(int id, String fullName, String position, int image) {
    this.id = id;
    this.fullName = fullName;
    this.position = position;
    this.image = image;
  }
}
