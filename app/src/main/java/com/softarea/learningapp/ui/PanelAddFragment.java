package com.softarea.learningapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.appbar.AppBarLayout;
import com.softarea.learningapp.MainActivity;
import com.softarea.learningapp.R;

public class PanelAddFragment extends Fragment {

  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    AppBarLayout appBarLayout = MainActivity.appBarLayout;
    appBarLayout.setExpanded(false, false);
    appBarLayout.setBackground(getResources().getDrawable(R.color.backgroundColor));

    View root = inflater.inflate(R.layout.fragment_create_note, container, false);



    return root;
  }
}
