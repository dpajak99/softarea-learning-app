package com.softarea.learningapp.utils;

import android.content.Context;

import androidx.room.Room;

import com.softarea.learningapp.database.AppDatabase;

public class DatabaseUtils {
  public static int TOKEN_NOT_FOUND = 0;
  public static int TOKEN_EXIST = 1;

  public static int USER_NOT_FOUND = 0;
  public static int USER_EXIST = 1;

  public static AppDatabase getDatabase( Context context ) {
    AppDatabase db = Room.databaseBuilder(context,
      AppDatabase.class, "softareaschool.db").fallbackToDestructiveMigration().allowMainThreadQueries().build();

    return db;
  }
}
