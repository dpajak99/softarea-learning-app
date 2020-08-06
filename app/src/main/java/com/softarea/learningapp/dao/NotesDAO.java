package com.softarea.learningapp.dao;

import com.softarea.learningapp.R;
import com.softarea.learningapp.model.Note;
import com.softarea.learningapp.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NotesDAO {
  public static List<Note> getData() {
    List<Note> notes = new ArrayList<>();
    User author = new User("Dominik", "Pająk", "SOFTAREA - Junior Android Developer", R.drawable.demo_profile);
    notes.add(new Note("Test1 title", "Test1 content", author, new Date()));
    notes.add(new Note("Test2 title", "Test2 content", author, new Date()));
    notes.add(new Note("Test3 title", "Test3 content", author, new Date()));
    notes.add(new Note("Test4 title", "Test4 content", author, new Date()));
    notes.add(new Note("Test5 title", "Test5 content", author, new Date()));
    notes.add(new Note("Test6 title", "Test6 content", author, new Date()));

    return notes;
  }
}
