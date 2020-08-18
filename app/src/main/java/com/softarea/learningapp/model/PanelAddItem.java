package com.softarea.learningapp.model;

public class PanelAddItem {
  private String name;
  private int href;

  public PanelAddItem(String name, int href) {
    this.name = name;
    this.href = href;
  }

  public String getName() {
    return name;
  }

  public int getHref() {
    return href;
  }
}
