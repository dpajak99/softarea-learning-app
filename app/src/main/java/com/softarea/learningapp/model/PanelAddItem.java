package com.softarea.learningapp.model;

public class PanelAddItem {
  private String name;
  private String href;

  public PanelAddItem(String name, String href) {
    this.name = name;
    this.href = href;
  }

  public String getName() {
    return name;
  }

  public String getHref() {
    return href;
  }
}
