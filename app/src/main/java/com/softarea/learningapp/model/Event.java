package com.softarea.learningapp.model;

public class Event {
  private int day;
  private int month;
  private int year;
  private String startTime;
  private String endTime;
  private String title;
  private User author;

  public Event(int day, int month, int year, String startTime, String endTime, String title, User author) {
    this.day = day;
    this.month = month;
    this.year = year;
    this.startTime = startTime;
    this.endTime = endTime;
    this.title = title;
    this.author = author;
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

  public String getStartTime() {
    return startTime;
  }

  public String getEndTime() {
    return endTime;
  }

  public String getTitle() {
    return title;
  }

  public User getAuthor() {
    return author;
  }

  @Override
  public String toString() {
    return "CalendarEvent{" +
      "day=" + day +
      ", month=" + month +
      ", year=" + year +
      ", eventStartTime='" + startTime + '\'' +
      ", eventEndTime='" + endTime + '\'' +
      ", title='" + title + '\'' +
      ", author=" + author +
      '}';
  }
}
