package com.softarea.learningapp.dao;

import android.content.Context;

import com.softarea.learningapp.model.Note;
import com.softarea.learningapp.sqlite.DBManager;

import java.util.List;

public class NotesDAO {
  public static void createNote(Context context, Note note ) {
    DBManager dbHelper = new DBManager(context);
    dbHelper.addNote(note);
  }

  public static List<Note> getNotes(Context context) {
    DBManager dbHelper = new DBManager(context);
    return dbHelper.getNotes();
  }

  public static int getLastId(Context context) {
    DBManager dbHelper = new DBManager(context);
    return dbHelper.getLastId();
  }
}
