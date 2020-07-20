package com.amarpal.vix.digital.example.values;

public enum QualityCategory {

  RED(1),
  AMBER(2),
  GREEN(3);

  private int id;

  private QualityCategory(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

}
