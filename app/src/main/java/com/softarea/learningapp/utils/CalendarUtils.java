package com.softarea.learningapp.utils;

import android.content.Context;

import com.softarea.learningapp.R;

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
}
