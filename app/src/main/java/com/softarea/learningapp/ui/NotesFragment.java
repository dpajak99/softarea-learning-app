package com.softarea.learningapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;
import com.softarea.learningapp.MainActivity;
import com.softarea.learningapp.R;
import com.softarea.learningapp.adapters.NotesAdapter;
import com.softarea.learningapp.model.Note;
import com.softarea.learningapp.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NotesFragment extends Fragment {

  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_notes, container, false);
    MainActivity.setExpandAndCollapseEnabled(false);
    User author = new User("Dominik", "Pająk", "SOFTAREA - Junior Android Developer", R.drawable.demo_profile);
    List<Note> notes = new ArrayList<>();

    RecyclerView notesList = root.findViewById(R.id.list_notes);
    notesList.setLayoutManager(new GridLayoutManager(requireContext(), 2));

    notes.add(new Note("Test1 title", "Test1 content", author, new Date()));
    notes.add(new Note("Test2 title", "Test2 content", author, new Date()));
    notes.add(new Note("Test3 title", "Test3 content", author, new Date()));
    notes.add(new Note("Test4 title", "Test4 content", author, new Date()));
    notes.add(new Note("Test5 title", "Test5 content", author, new Date()));
    notes.add(new Note("Test6 title", "Test6 content", author, new Date()));


    NotesAdapter notesAdapter = new NotesAdapter( notes );
    notesList.setHasFixedSize(true);
    notesList.setAdapter(notesAdapter);

    AppBarLayout appBarLayout = MainActivity.appBarLayout;
    appBarLayout.setExpanded(false, false);
    appBarLayout.setBackground(getResources().getDrawable(R.color.backgroundColor));
    return root;
  }
}
