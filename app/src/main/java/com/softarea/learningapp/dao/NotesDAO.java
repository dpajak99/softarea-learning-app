package com.softarea.learningapp.dao;

import android.content.Context;

import com.softarea.learningapp.model.Note;
import com.softarea.learningapp.sqlite.DBManager;

import java.util.List;

public class NotesDAO {
  public static void createNote(Context context, Note note) {
    DBManager dbManager = new DBManager(context);
    dbManager.addNote(note);
    note.setId(NotesDAO.getLastId(context));
  }

  public static List<Note> getNotes(Context context) {
    DBManager dbManager = new DBManager(context);
    return dbManager.getNotes();
  }

  public static int getLastId(Context context) {
    DBManager dbManager = new DBManager(context);
    return dbManager.getLastId();
  }

  public static boolean deleteNote(Context context, int id ) {
    DBManager bdbManager = new DBManager(context);
    return bdbManager.deleteNote(id);
  }
}
