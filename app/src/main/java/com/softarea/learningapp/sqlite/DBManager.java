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
  private Cursor c;

  public DBManager(Context context) {
    helper = new DBHelper(context);
    db = helper.getWritableDatabase();
  }

  public void addNote(Note note) {
    db.beginTransaction();
    try {
      db.execSQL("INSERT INTO NOTES VALUES(?,?, ?, ?)",
        new Object[]{note.getTitle(), note.getContent(),
          note.getCreatedAt(), note.getAuthor().getFullName()});
      db.setTransactionSuccessful();
      Log.i("TEST", "Inserted: " + note.toString());
    } finally {
      db.endTransaction();
    }
  }

  public List<Note> queryNote() {
    ArrayList<Note> list = new ArrayList<>();
    c = db.rawQuery("SELECT * FROM NOTES", null);
    while (c.moveToNext()) {
      Note note = new Note(
        c.getString(c.getColumnIndex("title")),
        c.getString(c.getColumnIndex("content")),
        new User("Dominik", "Pająk", "SOFTAREA - Junior Android Developer", R.drawable.demo_profile),
        new Date());

      Log.i("TEST", "NOTE: " + note.toString());
      list.add(note);
    }
    c.close();
    return list;
  }


  public void closeDB() {
    db.close();
  }
}
