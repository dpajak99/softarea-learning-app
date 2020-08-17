package com.softarea.learningapp.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.softarea.learningapp.model.Note;

import java.util.List;

@Dao
public interface NotesDAO {
  @Query("SELECT * FROM NOTES")
  List<Note> getAll();

  @Insert
  void insert(Note note);

  @Delete
  void delete(Note note);
}
