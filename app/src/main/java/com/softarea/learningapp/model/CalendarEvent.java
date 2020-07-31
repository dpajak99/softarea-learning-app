package com.softarea.learningapp.model;

public class CalendarEvent {
  private int day;
  private int month;
  private int year;
  private String eventStartTime;
  private String eventEndTime;
  private String title;
  private User author;

  public CalendarEvent(int day, int month, int year, String eventStartTime, String eventEndTime, String title, User author) {
    this.day = day;
    this.month = month;
    this.year = year;
    this.eventStartTime = eventStartTime;
    this.eventEndTime = eventEndTime;
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

  public String getEventStartTime() {
    return eventStartTime;
  }

  public String getEventEndTime() {
    return eventEndTime;
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
      ", eventStartTime='" + eventStartTime + '\'' +
      ", eventEndTime='" + eventEndTime + '\'' +
      ", title='" + title + '\'' +
      ", author=" + author +
      '}';
  }
}
