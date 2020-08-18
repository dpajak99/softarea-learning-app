package com.softarea.learningapp.dao;

import com.softarea.learningapp.model.TutorialShortcut;

import java.util.ArrayList;
import java.util.List;

public class TutorialShortcutDAO {
  public static List<TutorialShortcut> getData() {
    List<TutorialShortcut> tutorialShortcuts = new ArrayList<>();
//    tutorialShortcuts.add(new TutorialShortcut( "Podstawowe komponenty Android", 36, 5));
//    tutorialShortcuts.add(new TutorialShortcut( "Czym jest widok w aplikacji Android", 5, 0));
//    tutorialShortcuts.add(new TutorialShortcut( "Czysty kod a profesjonalizm", 17, 5));
//    tutorialShortcuts.add(new TutorialShortcut( "Wprowadzanie danych - Android", 34, 34));

    tutorialShortcuts.add(new TutorialShortcut( "Basic Android components", 36, 5));
    tutorialShortcuts.add(new TutorialShortcut( "What is a view in an Android application", 5, 0));
    tutorialShortcuts.add(new TutorialShortcut( "Clean code = professionalism", 17, 5));
    tutorialShortcuts.add(new TutorialShortcut( "Data Input - Android", 34, 34));

    return tutorialShortcuts;
  }
}
