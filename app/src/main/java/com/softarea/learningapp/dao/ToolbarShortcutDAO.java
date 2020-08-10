package com.softarea.learningapp.dao;

import android.content.Context;

import com.softarea.learningapp.R;
import com.softarea.learningapp.model.ToolbarShortcut;

import java.util.ArrayList;
import java.util.List;

public class ToolbarShortcutDAO {
  public static List<ToolbarShortcut> getData(Context context) {
    List<ToolbarShortcut> toolbarShortcuts = new ArrayList<>();
    toolbarShortcuts.add(new ToolbarShortcut(context.getString(R.string.note_add), R.drawable.button_create_note, R.id.navigation_create_note));
    toolbarShortcuts.add(new ToolbarShortcut(context.getString(R.string.note_create), R.drawable.button_show_notes, R.id.navigation_notes));
    toolbarShortcuts.add(new ToolbarShortcut(context.getString(R.string.tasks_show), R.drawable.button_show_tasks, R.id.navigation_create_note));

    return toolbarShortcuts;
  }
}
