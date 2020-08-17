package com.softarea.learningapp.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.softarea.learningapp.R;
import com.softarea.learningapp.components.ImageViewRounded;
import com.softarea.learningapp.model.Note;
import com.softarea.learningapp.model.User;
import com.softarea.learningapp.utils.DatabaseUtils;
import com.softarea.learningapp.utils.StringUtils;

public class ShowNoteFragment extends Fragment {
  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_show_note, container, false);

    ImageViewRounded authorImage = root.findViewById(R.id.note_author_image);
    TextView authorName = root.findViewById(R.id.note_author_name);
    TextView noteTitle = root.findViewById(R.id.note_title);
    TextView noteContent = root.findViewById(R.id.note_content);
    LinearLayout deleteNote = root.findViewById(R.id.delete_note);
    TextView noteDate = root.findViewById(R.id.note_date);
    Note note = (Note) this.getArguments().getSerializable("note");

    User author = DatabaseUtils.getDatabase(getContext()).userDAO().getAuthor(note.getAuthor());

    authorImage.setImageResource(author.getImage());
    authorName.setText(author.getFullName());
    Log.e("TEST", author.getFullName());
    noteTitle.setText(note.getTitle());
    noteContent.setText(note.getContent());
    noteDate.setText(StringUtils.join(
      requireContext().getString(R.string.created_at_date), " ", note.getDate(), " ",
      requireContext().getString(R.string.created_at_time), " ", note.getTime()));

    deleteNote.setOnClickListener(view -> {
      new AlertDialog.Builder(requireContext())
        .setTitle(R.string.app_name)
        .setMessage(R.string.note_delete_confirm)
        .setPositiveButton(R.string.yes, (dialog, which) -> {
          DatabaseUtils.getDatabase(getContext()).notesDAO().delete(note);

          NavController navController = Navigation.findNavController(requireActivity(), R.id.fragment_main);
          navController.navigate(R.id.navigation_notes);
          Toast.makeText(requireContext(), R.string.note_delete_successful, Toast.LENGTH_LONG).show();
        })
        .setNegativeButton(R.string.no, null)
        .setIcon(R.drawable.ic_delete)
        .show();
    });

    return root;
  }
}
