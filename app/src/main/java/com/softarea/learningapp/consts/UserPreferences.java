package com.softarea.learningapp.consts;

import android.content.Context;
import android.content.SharedPreferences;

import com.softarea.learningapp.model.User;

public class UserPreferences {
  public static final String PREFERENCES_NAME = "MyPrefs" ;
  public static final String USER_ID = "idKey";
  public static final String USER_NAME = "nameKey";
  public static final String USER_IMAGE = "imageKey";
  public static final String USER_TOKEN = "tokenKey";

  public static final String ERROR_NOT_FOUND_STRING = "Nie znaleziono";
  public static final int ERROR_NOT_FOUND_INT = 0;

  public static void setPreferences(Context context, User user) {
    SharedPreferences sharedpreferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);;
    SharedPreferences.Editor editor = sharedpreferences.edit();

    editor.putInt(USER_ID, user.getId());
    editor.putString(USER_NAME, user.getFullName());
    editor.putInt(USER_IMAGE, user.getImage());
    editor.putString(USER_TOKEN, user.getToken());

    editor.apply();
  }

  public static SharedPreferences getInstance(Context context) {
    SharedPreferences sharedpreferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);;
    return sharedpreferences;
  }
}
