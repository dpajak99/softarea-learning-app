package com.softarea.learningapp.dao;

import com.softarea.learningapp.R;
import com.softarea.learningapp.model.StatisticsElement;

import java.util.ArrayList;
import java.util.List;

public class StatisticsElementDAO {
  public static List<StatisticsElement> getData() {
    List<StatisticsElement> statisticsElements = new ArrayList<>();
    statisticsElements.add(new StatisticsElement(36, R.drawable.ic_github, "- commity na githubie"));
    statisticsElements.add(new StatisticsElement(7, R.drawable.ic_softarea_logo_short, "- dodanych tutoriali"));
    statisticsElements.add(new StatisticsElement(13, R.drawable.ic_notepad, "- stworzonych notatek"));
    statisticsElements.add(new StatisticsElement(27, R.drawable.ic_todo_list, "- zrealizowanych zadań"));
    statisticsElements.add(new StatisticsElement(2, R.drawable.ic_idea, "- zapisanych pomysłów na projekt"));

    return statisticsElements;
  }
}
