package com.softarea.learningapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.softarea.learningapp.dao.NotesDAO;
import com.softarea.learningapp.dao.TokenDAO;
import com.softarea.learningapp.dao.UserDAO;
import com.softarea.learningapp.model.Note;
import com.softarea.learningapp.model.Token;
import com.softarea.learningapp.model.User;

@Database(entities = {Token.class, Note.class, User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
  public abstract NotesDAO notesDAO();
  public abstract UserDAO userDAO();
  public abstract TokenDAO tokenDAO();
}
