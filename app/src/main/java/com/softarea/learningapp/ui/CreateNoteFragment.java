package com.softarea.learningapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.softarea.learningapp.R;
import com.softarea.learningapp.model.Note;
import com.softarea.learningapp.model.User;
import com.softarea.learningapp.utils.BundleUtils;
import com.softarea.learningapp.utils.DatabaseUtils;
import com.softarea.learningapp.utils.ValidationUtils;

import java.util.Date;


public class CreateNoteFragment extends Fragment {
  EditText title;
  EditText content;

  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_create_note, container, false);
    this.setHasOptionsMenu(true);

    title = root.findViewById(R.id.note_create_title);
    content = root.findViewById(R.id.note_create_content);
    Button buttonCreateNote = root.findViewById(R.id.button_create_note);

    buttonCreateNote.setOnClickListener(v -> createNote());
    return root;
  }

  private void createNote() {
    if (checkInputs()) {
      User author = new User(0, "Dominik Pająk", "SOFTAREA - Junior Android Developer", R.drawable.demo_profile);
      Note note = new Note(title.getText().toString(), content.getText().toString(), 0, new Date().toString());

      DatabaseUtils.getDatabase(getContext()).notesDAO().insert(note);

      title.setText("");
      content.setText("");

      Toast.makeText(requireContext(), R.string.add_note_successful, Toast.LENGTH_LONG).show();

      NavController navController = Navigation.findNavController(getActivity(), R.id.fragment_main);
      navController.navigate(R.id.navigation_show_note, BundleUtils.createSerializableBundle("note", note));
    }
  }

  private boolean checkInputs() {
    // TODO: Check the note for SQL Injection and wrong HTML Tags
    return ValidationUtils.validateMinLength(requireContext(), title, 2, R.string.add_note_error_short_title)
      && ValidationUtils.validateMinLength(requireContext(), content, 2, R.string.add_note_error_short_content);
  }
}
