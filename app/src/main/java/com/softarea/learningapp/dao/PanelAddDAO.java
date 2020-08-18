package com.softarea.learningapp.dao;

import com.softarea.learningapp.R;
import com.softarea.learningapp.model.PanelAddItem;

import java.util.ArrayList;
import java.util.List;

public class PanelAddDAO {
  public static List<PanelAddItem> getData() {
    List<PanelAddItem> panelAddItems = new ArrayList<>();
    panelAddItems.add(new PanelAddItem("Dodaj notatkę", R.id.navigation_create_note));
    panelAddItems.add(new PanelAddItem("Dodaj zadanie", 0));
    panelAddItems.add(new PanelAddItem("Dodaj wydarzenie", 0));
    panelAddItems.add(new PanelAddItem("Dodaj tutorial", 0));
    panelAddItems.add(new PanelAddItem("Dodaj pomysł na aplikację", 0));

    return panelAddItems;
  }
}
