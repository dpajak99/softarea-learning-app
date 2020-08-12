package com.softarea.learningapp.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "softareaschool.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE NOTES" +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
          "       title VARCHAR, " +
          "       content VARCHAR, " +
          "       date DATETIME, " +
          "       author VARCHAR)");

        db.execSQL("CREATE TABLE USERS" +
          "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
          "       fullname VARCHAR, " +
          "       position VARCHAR, " +
          "       email VARCHAR, " +
          "       password VARCHAR, " +
          "       image INTEGER, " +
          "       token VARCHAR)");

        db.execSQL("CREATE TABLE TOKEN" +
          "       (token VARCHAR," +
          "id INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
