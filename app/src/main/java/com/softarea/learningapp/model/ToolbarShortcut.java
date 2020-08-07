package com.softarea.learningapp.model;

public class ToolbarShortcut {
  private String title;
  private int image;
  private int href;

  @Override
  public String toString() {
    return "ToolbarShortcut{" +
      "title='" + title + '\'' +
      ", image=" + image +
      ", href=" + href +
      '}';
  }

  public ToolbarShortcut(String title, int image, int href) {
    this.title = title;
    this.image = image;
    this.href = href;
  }

  public String getTitle() {
    return title;
  }

  public int getImage() {
    return image;
  }

  public int getHref() {
    return href;
  }
}
