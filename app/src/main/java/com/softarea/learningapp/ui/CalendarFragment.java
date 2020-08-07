package com.softarea.learningapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.appbar.AppBarLayout;
import com.softarea.learningapp.activities.MainActivity;
import com.softarea.learningapp.R;

public class CalendarFragment extends Fragment {
  View root;
  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    root = inflater.inflate(R.layout.fragment_calendar, container, false);
    initStartSettings();

    return root;
  }

  private void initStartSettings() {
    MainActivity.setExpandAndCollapseEnabled( false);
    AppBarLayout appBarLayout = MainActivity.appBarLayout;
    appBarLayout.setExpanded(false, false);
    appBarLayout.setBackgroundResource(R.color.backgroundColor);
  }
}
