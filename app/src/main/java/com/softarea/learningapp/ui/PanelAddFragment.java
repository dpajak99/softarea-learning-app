package com.softarea.learningapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.softarea.learningapp.R;
import com.softarea.learningapp.adapters.PanelAddAdapter;
import com.softarea.learningapp.dao.PanelAddDAO;

public class PanelAddFragment extends Fragment {
  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_panel_add, container, false);


    RecyclerView panelAddList = root.findViewById(R.id.list_panel_add);
    PanelAddAdapter panelAddAdapter = new PanelAddAdapter(PanelAddDAO.getData(getContext()));
    panelAddList.setHasFixedSize(true);
    panelAddList.setLayoutManager(new LinearLayoutManager(getActivity()));
    panelAddList.setAdapter(panelAddAdapter);

    return root;
  }
}
