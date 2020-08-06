package com.softarea.learningapp.dao;

import com.softarea.learningapp.R;
import com.softarea.learningapp.model.ToolbarShortcut;

import java.util.ArrayList;
import java.util.List;

public class ToolbarShortcutDAO {
  public static List<ToolbarShortcut> getData() {
    List<ToolbarShortcut> toolbarShortcuts = new ArrayList<>();
    toolbarShortcuts.add(new ToolbarShortcut("Dodaj notatkę", R.drawable.button_create_note, R.id.navigation_create_note));
    toolbarShortcuts.add(new ToolbarShortcut("Zobacz swoje notatki", R.drawable.button_show_notes, R.id.navigation_notes));
    toolbarShortcuts.add(new ToolbarShortcut("Zobacz listę zadań na dziś", R.drawable.button_show_tasks, R.id.navigation_create_note));

    return toolbarShortcuts;
  }
}
