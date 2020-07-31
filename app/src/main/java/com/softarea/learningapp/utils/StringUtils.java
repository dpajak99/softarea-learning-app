package com.softarea.learningapp.utils;


public class StringUtils {
  public static String join(String... values) {
    StringBuilder sb = new StringBuilder("");
    for (int i = 0; i < values.length; i++) {
      sb.append(values[i]);
    }
    return sb.toString();
  }
}
