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
import com.softarea.learningapp.MainActivity;
import com.softarea.learningapp.R;
import com.softarea.learningapp.adapters.CalendarListAdapter;
import com.softarea.learningapp.adapters.StatisticsElementAdapter;
import com.softarea.learningapp.adapters.TutorialShortcutAdapter;
import com.softarea.learningapp.model.CalendarEvent;
import com.softarea.learningapp.model.StatisticsElement;
import com.softarea.learningapp.model.TutorialShortcut;
import com.softarea.learningapp.model.User;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_home, container, false);
    MainActivity.setExpandAndCollapseEnabled(true);
    List<TutorialShortcut> tutorialShortcuts = new ArrayList<>();
    tutorialShortcuts.add(new TutorialShortcut( "Podstawowe komponenty Android", 36, 5));
    tutorialShortcuts.add(new TutorialShortcut( "Czym jest widok w aplikacji Android", 5, 0));
    tutorialShortcuts.add(new TutorialShortcut( "Czysty kod a profesjonalizm", 17, 5));
    tutorialShortcuts.add(new TutorialShortcut( "Wprowadzanie danych - Android", 34, 34));

    User author = new User( "Łukasz", "Usarz", "SOFTAREA - SEO", R.drawable.demo_profile);

    List<CalendarEvent> calendarEvents = new ArrayList<>();
    calendarEvents.add(new CalendarEvent(31, 7, 2020, "14:00", "14:30", "Podsumowanie pierwszego miesiąca praktyk", author ));
    calendarEvents.add(new CalendarEvent(4, 8, 2020, "11:00", "11:20", "Poznaj obuwie - checkpoint meeting", author ));
    calendarEvents.add(new CalendarEvent(11, 8, 2020, "11:00", "11:20", "Poznaj obuwie - checkpoint meeting", author ));

    List<StatisticsElement> statisticsElements = new ArrayList<>();
    statisticsElements.add(new StatisticsElement(36, R.drawable.ic_github, "- commity na githubie"));
    statisticsElements.add(new StatisticsElement(7, R.drawable.ic_softarea_logo_short, "- dodanych tutoriali"));
    statisticsElements.add(new StatisticsElement(13, R.drawable.ic_notepad, "- stworzonych notatek"));
    statisticsElements.add(new StatisticsElement(27, R.drawable.ic_todo_list, "- zrealizowanych zadań"));
    statisticsElements.add(new StatisticsElement(2, R.drawable.ic_idea, "- zapisanych pomysłów na projekt"));



    RecyclerView calendarEventsList = root.findViewById(R.id.list_calendar);
    CalendarListAdapter calendarListAdapter = new CalendarListAdapter( calendarEvents );
    calendarEventsList.setHasFixedSize(true);
    calendarEventsList.setLayoutManager(new LinearLayoutManager(getActivity()));
    calendarEventsList.setAdapter(calendarListAdapter);


    RecyclerView tutorialsShortcutList = (RecyclerView) root.findViewById(R.id.list_tutorial);
    TutorialShortcutAdapter tutorialShortcutAdapter = new TutorialShortcutAdapter( tutorialShortcuts );
    tutorialsShortcutList.setHasFixedSize(true);
    tutorialsShortcutList.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
    tutorialsShortcutList.setAdapter(tutorialShortcutAdapter);

    RecyclerView statisticsElementList = root.findViewById(R.id.list_statistic);
    StatisticsElementAdapter statisticsElementAdapter = new StatisticsElementAdapter( statisticsElements );
    statisticsElementList.setHasFixedSize(true);
    statisticsElementList.setLayoutManager(new LinearLayoutManager(getActivity()));
    statisticsElementList.setAdapter(statisticsElementAdapter);


    AppBarLayout appBarLayout = MainActivity.appBarLayout;
    appBarLayout.setExpanded(true, false);
    appBarLayout.setBackground(getResources().getDrawable(R.color.below_toolbar));

    return root;
  }
}
