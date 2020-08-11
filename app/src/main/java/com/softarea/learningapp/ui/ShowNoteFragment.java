package com.softarea.learningapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.google.android.material.appbar.AppBarLayout;
import com.softarea.learningapp.R;
import com.softarea.learningapp.activities.MainActivity;
import com.softarea.learningapp.components.ImageViewRounded;
import com.softarea.learningapp.dao.NotesDAO;
import com.softarea.learningapp.model.Note;
import com.softarea.learningapp.utils.DateUtils;
import com.softarea.learningapp.utils.StringUtils;

import static com.softarea.learningapp.activities.MainActivity.navController;

public class ShowNoteFragment extends Fragment {
  View root;
  Note note;
  Bundle bundle;

  ImageViewRounded noteAuthorImage;
  TextView noteAuthorName;
  TextView noteTitle;
  TextView noteContent;
  TextView noteDate;
  LinearLayout deleteNote;

  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    root = inflater.inflate(R.layout.fragment_show_note, container, false);
    initStartSettings();
    initViews();

    noteAuthorImage.setImageResource(note.getAuthor().getImage());
    noteAuthorName.setText(note.getAuthor().getFullName());
    noteTitle.setText(note.getTitle());
    noteContent.setText(note.getContent());
    noteDate.setText(StringUtils.join(requireContext().getString(R.string.created_at_date), " ", DateUtils.parseDate(note.getCreatedAt()), " ", requireContext().getString(R.string.created_at_time), " ", DateUtils.parseTime(note.getCreatedAt())));

    deleteNote.setOnClickListener(view -> {
      new AlertDialog.Builder(requireContext())
        .setTitle(R.string.app_name)
        .setMessage(R.string.note_delete_confirm)
        .setPositiveButton(R.string.yes, (dialog, which) -> {
          if(NotesDAO.deleteNote(requireContext(), note.getId())) {
            navController.navigate(R.id.navigation_notes);
            Toast.makeText(requireContext(), R.string.note_delete_successful, Toast.LENGTH_LONG).show();
          } else {
            Toast.makeText(requireContext(), R.string.note_delete_error, Toast.LENGTH_LONG).show();
          }
        })
        .setNegativeButton(R.string.no, null)
        .setIcon(R.drawable.ic_delete)
        .show();
    });

    return root;
  }

  private void initViews() {
    noteAuthorImage = root.findViewById(R.id.note_author_image);
    noteAuthorName = root.findViewById(R.id.note_author_name);
    noteTitle = root.findViewById(R.id.note_title);
    noteContent = root.findViewById(R.id.note_content);
    deleteNote = root.findViewById(R.id.delete_note);
    noteDate = root.findViewById(R.id.note_date);
    bundle = this.getArguments();
    assert bundle != null;
    note = (Note) bundle.getSerializable("note");
  }

  private void initStartSettings() {
    MainActivity.setExpandAndCollapseEnabled( false);
    AppBarLayout appBarLayout = MainActivity.appBarLayout;
    appBarLayout.setExpanded(false, false);
    appBarLayout.setBackgroundResource(R.color.backgroundColor);
  }
}
