package com.softarea.learningapp.dao;

import android.content.Context;

import com.softarea.learningapp.R;
import com.softarea.learningapp.model.StatisticsElement;

import java.util.ArrayList;
import java.util.List;

public class StatisticsElementDAO {
  public static List<StatisticsElement> getData(Context context) {
    List<StatisticsElement> statisticsElements = new ArrayList<>();
    statisticsElements.add(new StatisticsElement(36, R.drawable.ic_github, context.getString(R.string.statistics_github_commits)));
    statisticsElements.add(new StatisticsElement(7, R.drawable.ic_softarea_logo_short, context.getString(R.string.statistics_tutorials_added)));
    statisticsElements.add(new StatisticsElement(13, R.drawable.ic_notepad, context.getString(R.string.statistics_notes_added)));
    statisticsElements.add(new StatisticsElement(27, R.drawable.ic_todo_list, context.getString(R.string.statistics_realised_tasks)));
    statisticsElements.add(new StatisticsElement(2, R.drawable.ic_idea, context.getString(R.string.statistics_idea_added)));

    return statisticsElements;
  }
}
