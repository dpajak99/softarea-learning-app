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
import com.softarea.learningapp.R;
import com.softarea.learningapp.activities.MainActivity;
import com.softarea.learningapp.adapters.NotesAdapter;
import com.softarea.learningapp.dao.NotesDAO;
import com.softarea.learningapp.sqlite.DBManager;

public class NotesFragment extends Fragment {
  View root;
  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    root = inflater.inflate(R.layout.fragment_notes, container, false);

    initStartSettings();

    RecyclerView notesList = root.findViewById(R.id.list_notes);
    notesList.setLayoutManager(new GridLayoutManager(requireContext(), 2));

   // NotesAdapter notesAdapter = new NotesAdapter(NotesDAO.getData());
    DBManager dbManager = new DBManager(requireContext());
    NotesAdapter notesAdapter = new NotesAdapter(NotesDAO.getNotes(requireContext()));
    notesList.setHasFixedSize(true);
    notesList.setAdapter(notesAdapter);

    return root;
  }

  private void initStartSettings() {
    MainActivity.setExpandAndCollapseEnabled( false);
    AppBarLayout appBarLayout = MainActivity.appBarLayout;
    appBarLayout.setExpanded(false, false);
    appBarLayout.setBackgroundResource(R.color.backgroundColor);
  }
}
