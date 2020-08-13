package com.softarea.learningapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.softarea.learningapp.dao.NotesDAO;
import com.softarea.learningapp.model.Note;

@Database(entities = {Note.class}, version = 3)
public abstract class AppDatabase extends RoomDatabase {
  public abstract NotesDAO notesDAO();
}
