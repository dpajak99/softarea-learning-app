package com.softarea.learningapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.softarea.learningapp.R;
import com.softarea.learningapp.adapters.NotesAdapter;
import com.softarea.learningapp.utils.DatabaseUtils;

public class NotesFragment extends Fragment {
  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_notes, container, false);

    RecyclerView notesList = root.findViewById(R.id.list_notes);
    notesList.setLayoutManager(new GridLayoutManager(requireContext(), 2));

    NotesAdapter notesAdapter = new NotesAdapter(getContext(), getActivity(), DatabaseUtils.getDatabase(getContext()).notesDAO().getAll());
    notesList.setHasFixedSize(true);
    notesList.setAdapter(notesAdapter);

    return root;
  }
}
