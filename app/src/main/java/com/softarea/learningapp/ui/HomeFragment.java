package com.softarea.learningapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;
import com.softarea.learningapp.R;
import com.softarea.learningapp.activities.MainActivity;
import com.softarea.learningapp.adapters.CalendarListAdapter;
import com.softarea.learningapp.adapters.StatisticsElementAdapter;
import com.softarea.learningapp.adapters.TutorialShortcutAdapter;
import com.softarea.learningapp.dao.EventsDAO;
import com.softarea.learningapp.dao.StatisticsElementDAO;
import com.softarea.learningapp.dao.TutorialShortcutDAO;

public class HomeFragment extends Fragment {
  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_home, container, false);

    RecyclerView calendarEventsList = root.findViewById(R.id.list_calendar);
    CalendarListAdapter calendarListAdapter = new CalendarListAdapter(EventsDAO.getData());
    calendarEventsList.setHasFixedSize(true);
    calendarEventsList.setLayoutManager(new LinearLayoutManager(getActivity()));
    calendarEventsList.setAdapter(calendarListAdapter);


    RecyclerView tutorialsShortcutList = root.findViewById(R.id.list_tutorial);
    TutorialShortcutAdapter tutorialShortcutAdapter = new TutorialShortcutAdapter(TutorialShortcutDAO.getData());
    tutorialsShortcutList.setHasFixedSize(true);
    tutorialsShortcutList.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
    tutorialsShortcutList.setAdapter(tutorialShortcutAdapter);

    RecyclerView statisticsElementList = root.findViewById(R.id.list_statistic);
    StatisticsElementAdapter statisticsElementAdapter = new StatisticsElementAdapter(StatisticsElementDAO.getData(requireContext()));
    statisticsElementList.setHasFixedSize(true);
    statisticsElementList.setLayoutManager(new LinearLayoutManager(getActivity()));
    statisticsElementList.setAdapter(statisticsElementAdapter);

    return root;
  }
}
