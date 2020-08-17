package com.softarea.learningapp.utils;

import android.content.Context;

import com.softarea.learningapp.R;

import java.util.Calendar;

public class CalendarUtils {
  public static String transformMonth(Context context, int month) {
    int[] months = {
      R.string.january,
      R.string.february,
      R.string.march,
      R.string.april,
      R.string.may,
      R.string.june,
      R.string.july,
      R.string.august,
      R.string.october,
      R.string.november,
      R.string.december};
    return context.getString(months[month - 1]);
  }

  public static String getCurrentDate() {
    Calendar date = Calendar.getInstance();

    return StringUtils.join(
      parseDate(date.get(Calendar.DAY_OF_MONTH)), "-",
      parseDate(date.get(Calendar.MONTH)), "-",
      date.get(Calendar.YEAR));
  }

  public static String getCurrentTime() {
    Calendar date = Calendar.getInstance();

    return StringUtils.join(
      parseDate(date.get(Calendar.HOUR_OF_DAY)), ":",
      parseDate(date.get(Calendar.MINUTE)));
  }

  private static String parseDate(int i) {
    if( i < 10 ) {
      return StringUtils.join(0, i );
    }
    return String.valueOf(i);
  }
}
