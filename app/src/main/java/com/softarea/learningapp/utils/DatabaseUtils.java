package com.softarea.learningapp.utils;

import android.content.Context;

import androidx.room.Room;

import com.softarea.learningapp.AppDatabase;

public class DatabaseUtils {
  public static AppDatabase getDatabase( Context context ) {
    AppDatabase db = Room.databaseBuilder(context,
      AppDatabase.class, "softareaschool.db").fallbackToDestructiveMigration().allowMainThreadQueries().build();

    return db;
  }
}
