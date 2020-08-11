package com.softarea.learningapp.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.appbar.AppBarLayout;
import com.softarea.learningapp.R;
import com.softarea.learningapp.activities.MainActivity;
import com.softarea.learningapp.dao.NotesDAO;
import com.softarea.learningapp.model.Note;
import com.softarea.learningapp.model.User;

import java.util.Date;

import static com.softarea.learningapp.activities.MainActivity.navController;

public class CreateNoteFragment extends Fragment {
  View root;
  EditText title;
  EditText content;
  User author;

  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    root = inflater.inflate(R.layout.fragment_create_note, container, false);
    initStartSettings();

    author = new User(0, "Dominik Pająk", "SOFTAREA - Junior Android Developer", R.drawable.demo_profile);
    title = root.findViewById(R.id.note_create_title);
    content = root.findViewById(R.id.note_create_content);
    Button buttonCreateNote = root.findViewById(R.id.button_create_note);

    buttonCreateNote.setOnClickListener(v -> createNote());
    return root;
  }

  private void createNote() {
    if (checkInputs()) {
      Note note = new Note(0, String.valueOf(title.getText()), String.valueOf(content.getText()), author, new Date());
      NotesDAO.createNote(requireContext(), note);
      note.setId(NotesDAO.getLastId(requireContext()));
      Log.i("TEST", String.valueOf(note.getId()));

      clearInputs();

      Bundle bundle = new Bundle();
      bundle.putSerializable("note", note);
      navController.navigate(R.id.navigation_show_note, bundle);
      Toast.makeText(requireContext(), R.string.add_note_successful, Toast.LENGTH_LONG).show();
    }
  }

  private void clearInputs() {
    title.setText("");
    content.setText("");
  }

  private boolean checkInputs() {
    if(String.valueOf(title.getText()).length() < 2 ) {
      Toast.makeText(requireContext(), R.string.add_note_error_short_title, Toast.LENGTH_LONG).show();
      return false;
    }

    if(String.valueOf(content.getText()).length() < 2 ) {
      //TODO: Check the note for SQL Injection and wrong HTML Tags
      Toast.makeText(requireContext(), R.string.add_note_error_short_content, Toast.LENGTH_LONG).show();
      return false;
    }

    return true;
  }

  private void initStartSettings() {
    MainActivity.setExpandAndCollapseEnabled(false);
    this.setHasOptionsMenu(true);

    AppBarLayout appBarLayout = MainActivity.appBarLayout;
    appBarLayout.setExpanded(false, false);

    appBarLayout.setBackgroundResource(R.color.backgroundColor);
  }
}
