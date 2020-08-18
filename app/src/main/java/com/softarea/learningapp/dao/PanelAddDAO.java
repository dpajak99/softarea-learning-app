package com.softarea.learningapp.dao;

import android.content.Context;

import com.softarea.learningapp.model.PanelAddItem;

import java.util.ArrayList;
import java.util.List;

public class PanelAddDAO {
  public static List<PanelAddItem> getData(Context context) {
    List<PanelAddItem> panelAddItems = new ArrayList<>();
    panelAddItems.add(new PanelAddItem("Dodaj notatkę", ""));
    panelAddItems.add(new PanelAddItem("Dodaj zadanie", ""));
    panelAddItems.add(new PanelAddItem("Dodaj wydarzenie", ""));
    panelAddItems.add(new PanelAddItem("Dodaj tutorial", ""));
    panelAddItems.add(new PanelAddItem("Dodaj pomysł na aplikację", ""));

    return panelAddItems;
  }
}
