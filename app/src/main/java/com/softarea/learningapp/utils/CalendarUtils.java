package com.softarea.learningapp.utils;

public class CalendarUtils {
  public static String transformDay(int day) {
    if( day < 10 ) {
      return StringUtils.join( "0", String.valueOf(day) );
    } else {
      return String.valueOf(day);
    }
  }
  public static String transformMonth(int month) {
    String[] months = {"styczeń", "luty", "marzec", "kwiecień", "maj", "czerwiec", "lipiec", "sierpień", "wrzesień", "październik", "listopad", "grudzień"};
    return  months[month - 1];
  }
}
