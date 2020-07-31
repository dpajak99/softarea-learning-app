package com.softarea.learningapp.model;

public class TutorialShortcut {
  public String title;
  public int maxTasks;
  public int currentTask;

  public TutorialShortcut(String title, int maxTasks, int currentTask) {
    this.title = title;
    this.maxTasks = maxTasks;
    this.currentTask = currentTask;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public String toString() {
    return "TutorialShortcut{" +
      "title='" + title + '\'' +
      ", maxTasks=" + maxTasks +
      ", currentTask=" + currentTask +
      '}';
  }

  public String getTitle() {
    return title;
  }

  public int getMaxTasks() {
    return maxTasks;
  }

  public int getCurrentTask() {
    return currentTask;
  }
}
