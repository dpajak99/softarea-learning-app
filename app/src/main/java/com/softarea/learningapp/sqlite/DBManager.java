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
  private static final String TAG = "TEST";

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
      Log.i(TAG, "Inserted: " + note.toString());
    } finally {
      db.endTransaction();
    }
  }

  public void addUser(User user, String email, String password) {
    Log.i(TAG, "addUser: start");
    db.beginTransaction();
    try {
      db.execSQL("INSERT INTO USERS VALUES(?,?,?, ?, ?, ?, ?)",
        new Object[]{null, user.getFullName(), user.getPosition(), email, password,
          user.getImage(), null});
      db.setTransactionSuccessful();
      Log.i(TAG, "addUser: added User");
      Log.i("TEST", "Inserted: " + user.toString());
    } catch (Exception e) {
      Log.i(TAG, "addUser: error");
      Log.i(TAG, e.toString());
    } finally {
      db.endTransaction();
    }
  }

  public void updateToken(String token, int id) {
    Log.i(TAG, "updateToken: tokenStart " + token);
    Log.i(TAG, "updateToken: idStart " + id);
    db.beginTransaction();
    try {
      db.execSQL("UPDATE USERS SET token = " + token + " WHERE id = " + id);
      db.setTransactionSuccessful();
    } catch (Exception e) {
      Log.i(TAG, "updateToken: error");
      Log.i(TAG, e.toString());
    } finally {
      db.endTransaction();
    }
  }

  public void updateLocalToken(String token) {
    Log.i(TAG, "updateLocalToken: tokenStart " + token);
    db.beginTransaction();
    try {
      db.execSQL("UPDATE TOKEN SET token = "+token+" WHERE id = 0");
      db.setTransactionSuccessful();
    } catch (Exception e) {
      Log.i(TAG, "updateLocalToken: error exception second " + e);
    } finally {
      db.endTransaction();
    }
  }

  public void setLocalToken(String token) {
    Log.i(TAG, "updateLocalToken: tokenStart " + token);
    db.beginTransaction();
    try {
      db.execSQL("INSERT INTO TOKEN VALUES("+token+", 0)");
      db.setTransactionSuccessful();
    } catch (Exception e) {
      Log.i(TAG, "updateLocalToken: error exception second " + e);
    } finally {
      db.endTransaction();
    }
  }

  public boolean deleteNote(int id) {
    db.beginTransaction();
    try {
      db.execSQL("DELETE FROM NOTES WHERE id=" + id);
      db.setTransactionSuccessful();
    } catch (Exception e) {
      return false;
    } finally {
      db.endTransaction();
    }
    return true;
  }

  public List<Note> getNotes() {
    ArrayList<Note> list = new ArrayList<>();
    Cursor c = db.rawQuery("SELECT * FROM NOTES ORDER BY id DESC", null);
    while (c.moveToNext()) {
      Note note = new Note(
        c.getInt(c.getColumnIndex("id")),
        c.getString(c.getColumnIndex("title")),
        c.getString(c.getColumnIndex("content")),
        new User(0, "Dominik Pająk", "SOFTAREA - Junior Android Developer", R.drawable.demo_profile),
        new Date(c.getString(c.getColumnIndex("date"))));

      Log.i("TEST", "NOTE: " + note.toString());
      list.add(note);
    }
    c.close();
    return list;
  }

  User user;

  public User getUser(String token) {

    Cursor c = db.rawQuery("SELECT * FROM USERS WHERE token = " + token, null);
    while (c.moveToNext()) {
      user = new User(
        c.getInt(c.getColumnIndex("id")),
        c.getString(c.getColumnIndex("fullname")),
        c.getString(c.getColumnIndex("position")),
        c.getInt(c.getColumnIndex("image")));

      Log.i("TEST", "USER: " + user.toString());
    }
    c.close();
    return user;
  }

  public int getUserId(String email, String password) {
    Log.i(TAG, "getUserId: start");
    int id = 0;

    try {
      Cursor c = db.rawQuery("SELECT id FROM USERS WHERE email = '" + email + "' AND password = '" + password + "'", null);

      while (c.moveToNext()) {
        id = c.getInt(c.getColumnIndex("id"));
      }
      c.close();
    } catch (Exception e) {
      Log.i(TAG, "getUserId: error");
      Log.i(TAG, e.toString());
    }
    return id;
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

  public String getLocalToken() {
    String token = "";
    Cursor c = db.rawQuery("SELECT token FROM TOKEN Limit 1", null);
    while (c.moveToNext()) {
      token = c.getString(c.getColumnIndex("token"));
      Log.i(TAG, "getLocalToken - token: " + String.valueOf(token));
    }
    c.close();
    return token;
  }


  public void closeDB() {
    db.close();
  }
}
