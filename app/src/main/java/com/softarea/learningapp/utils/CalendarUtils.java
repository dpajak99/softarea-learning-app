package com.softarea.learningapp.utils;

public class CalendarUtils {
  public static String transformMonth(int month) {
    String[] months = {"styczeń", "luty", "marzec", "kwiecień", "maj", "czerwiec", "lipiec", "sierpień", "wrzesień", "październik", "listopad", "grudzień"};
    return  months[month - 1];
  }
}
