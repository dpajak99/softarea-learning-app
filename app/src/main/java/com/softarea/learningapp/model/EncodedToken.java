package com.softarea.learningapp.model;

public class EncodedToken {
  private int day;
  private int month;
  private int year;
  private int id;

  public EncodedToken() {

  }

  public void setDay(int day) {
    this.day = day;
  }

  public void setMonth(int month) {
    this.month = month;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "EncodedToken{" +
      "day=" + day +
      ", month=" + month +
      ", year=" + year +
      ", id=" + id +
      '}';
  }

  public int getDay() {
    return day;
  }

  public int getMonth() {
    return month;
  }

  public int getYear() {
    return year;
  }

  public int getId() {
    return id;
  }
}
