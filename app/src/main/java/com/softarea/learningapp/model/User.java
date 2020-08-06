package com.softarea.learningapp.model;

public class User {
  private String firstName;
  private String surname;
  private String position;
  private int image;

  public User(String firstName, String surname, String position, int image) {
    this.firstName = firstName;
    this.surname = surname;
    this.position = position;
    this.image = image;
  }

  @Override
  public String toString() {
    return "User{" +
      "firstName='" + firstName + '\'' +
      ", surname='" + surname + '\'' +
      ", position='" + position + '\'' +
      ", image=" + image +
      '}';
  }

  public String getFirstName() {
    return firstName;
  }

  public String getSurname() {
    return surname;
  }

  public String getFullName() {
    return firstName + " " + surname;
  }

  public String getPosition() {
    return position;
  }

  public int getImage() {
    return image;
  }
}
