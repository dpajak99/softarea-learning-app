package com.softarea.learningapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.appbar.AppBarLayout;
import com.softarea.learningapp.R;
import com.softarea.learningapp.activities.MainActivity;
import com.softarea.learningapp.model.Note;
import com.softarea.learningapp.model.User;
import com.softarea.learningapp.sqlite.DBManager;

import java.util.Date;

public class CreateNoteFragment extends Fragment {
  View root;
  EditText title;
  EditText content;
  User author;
  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    root = inflater.inflate(R.layout.fragment_create_note, container, false);
    initStartSettings();

    author = new User("Dominik", "Pająk", "SOFTAREA - Junior Android Developer", R.drawable.demo_profile);
    title = root.findViewById(R.id.note_create_title);
    content  = root.findViewById(R.id.note_create_content);
    Button buttonCreateNote = root.findViewById(R.id.button_create_note);

    buttonCreateNote.setOnClickListener(v -> createNote());
    return root;
  }

  private void createNote() {
    DBManager dbHelper = new DBManager(requireContext());
    dbHelper.addNote(new Note(String.valueOf(title.getText()), String.valueOf(content.getText()), author, new Date()));
  }

  private void initStartSettings() {
    MainActivity.setExpandAndCollapseEnabled( false);
    this.setHasOptionsMenu(true);

    AppBarLayout appBarLayout = MainActivity.appBarLayout;
    appBarLayout.setExpanded(false, false);

    appBarLayout.setBackgroundResource(R.color.backgroundColor);
  }
}
