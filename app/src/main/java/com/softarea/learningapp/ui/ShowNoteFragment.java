package com.softarea.learningapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.appbar.AppBarLayout;
import com.softarea.learningapp.R;
import com.softarea.learningapp.activities.MainActivity;
import com.softarea.learningapp.components.ImageViewRounded;
import com.softarea.learningapp.model.Note;
import com.softarea.learningapp.utils.DateUtils;
import com.softarea.learningapp.utils.StringUtils;

public class ShowNoteFragment extends Fragment {
  View root;
  Note note;
  Bundle bundle;

  ImageViewRounded noteAuthorImage;
  TextView noteAuthorName;
  TextView noteTitle;
  TextView noteContent;
  TextView noteDate;

  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    root = inflater.inflate(R.layout.fragment_show_note, container, false);
    initStartSettings();
    initViews();

    noteAuthorImage.setImageResource(note.getAuthor().getImage());
    noteAuthorName.setText(note.getAuthor().getFullName());
    noteTitle.setText(note.getTitle());
    noteContent.setText(note.getContent());
    noteDate.setText(StringUtils.join("Utworzona dnia: " + DateUtils.parseDate(note.getCreatedAt()), " o godzinie "+ DateUtils.parseTime(note.getCreatedAt())));

    return root;
  }

  private void initViews() {
    noteAuthorImage = root.findViewById(R.id.note_author_image);
    noteAuthorName = root.findViewById(R.id.note_author_name);
    noteTitle = root.findViewById(R.id.note_title);
    noteContent = root.findViewById(R.id.note_content);
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
