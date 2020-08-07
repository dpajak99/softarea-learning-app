package com.softarea.learningapp.utils;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
  public static String parseDate( Date date ) {
    @SuppressLint("SimpleDateFormat")
    SimpleDateFormat template = new SimpleDateFormat("yyyy-MM-dd");
    return  template.format(date);
  }

  public static String parseTime( Date date ) {
    @SuppressLint("SimpleDateFormat")
    SimpleDateFormat template = new SimpleDateFormat("HH:mm");
    return  template.format(date);
  }
}
