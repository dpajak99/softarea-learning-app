package com.softarea.learningapp.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.softarea.learningapp.R;
import com.softarea.learningapp.model.Note;
import com.softarea.learningapp.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DBManager {
  private DBHelper helper;
  private SQLiteDatabase db;

  public DBManager(Context context) {
    helper = new DBHelper(context);
    db = helper.getWritableDatabase();
  }

  public void addNote(Note note) {
    db.beginTransaction();
    try {
      db.execSQL("INSERT INTO NOTES VALUES(?,?,?, ?, ?)",
        new Object[]{null, note.getTitle(), note.getContent(),
          note.getCreatedAt(), note.getAuthor().getFullName()});
      db.setTransactionSuccessful();
      Log.i("TEST", "Inserted: " + note.toString());
    } finally {
      db.endTransaction();
    }
  }

  public List<Note> getNotes() {
    ArrayList<Note> list = new ArrayList<>();
      Cursor c = db.rawQuery("SELECT * FROM NOTES ORDER BY id DESC", null);
    while (c.moveToNext()) {
      Note note = new Note(
        c.getInt(c.getColumnIndex("id")),
        c.getString(c.getColumnIndex("title")),
        c.getString(c.getColumnIndex("content")),
        new User("Dominik", "Pająk", "SOFTAREA - Junior Android Developer", R.drawable.demo_profile),
        new Date(c.getString(c.getColumnIndex("date"))));

      Log.i("TEST", "NOTE: " + note.toString());
      list.add(note);
    }
    c.close();
    return list;
  }

  public int getLastId() {
    int result = 0;
    Cursor c = db.rawQuery("SELECT id FROM NOTES ORDER BY id DESC Limit 1", null);
    while (c.moveToNext()) {
      result = c.getInt(c.getColumnIndex("id"));
      Log.i("TEST", String.valueOf(result));
    }
    c.close();
    return result;
  }


  public void closeDB() {
    db.close();
  }
}
