package com.softarea.learningapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.appbar.AppBarLayout;
import com.softarea.learningapp.MainActivity;
import com.softarea.learningapp.R;

public class NotificationsFragment extends Fragment {

  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_notifications, container, false);
    final TextView textView = root.findViewById(R.id.text_notifications);

    AppBarLayout appBarLayout = MainActivity.appBarLayout;
    appBarLayout.setExpanded(false, true);
    appBarLayout.setBackground(getResources().getDrawable(R.color.backgroundColor));
    return root;
  }
}
