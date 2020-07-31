package com.softarea.learningapp.model;

public class User {
  private String firstName;
  private String surname;
  private String position;

  public User(String firstName, String surname, String position) {
    this.firstName = firstName;
    this.surname = surname;
    this.position = position;
  }

  @Override
  public String toString() {
    return "User{" +
      "firstName='" + firstName + '\'' +
      ", surname='" + surname + '\'' +
      ", position='" + position + '\'' +
      '}';
  }

  public String getFirstName() {
    return firstName;
  }

  public String getSurname() {
    return surname;
  }

  public String getPosition() {
    return position;
  }
}
