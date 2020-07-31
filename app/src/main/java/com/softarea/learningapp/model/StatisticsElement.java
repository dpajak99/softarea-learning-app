package com.softarea.learningapp.model;

public class StatisticsElement {
  private int amount;
  private int icon;
  private String name;

  @Override
  public String toString() {
    return "StatisticsElement{" +
      "amount=" + amount +
      ", icon='" + icon + '\'' +
      ", name='" + name + '\'' +
      '}';
  }

  public int getAmount() {
    return amount;
  }

  public int getIcon() {
    return icon;
  }

  public String getName() {
    return name;
  }

  public StatisticsElement(int amount, int icon, String name) {
    this.amount = amount;
    this.icon = icon;
    this.name = name;
  }
}
