package com.microservices.countries.enums;

public enum Continent {
  ASIA("Asia"),
  EUROPE("Europe"),
  NORTH_AMERICA("North America"),
  AFRICA("Africa"),
  OCEANIA("Oceania"),
  AMERICA("Antarctica"),
  SOUTH_AMERICA("South America");

  private String displayName;

  Continent(String displayName) {
    this.displayName = displayName;
  }

  public String displayName() { return displayName; }

  // Optionally and/or additionally, toString.
  @Override public String toString() { return displayName; }
}
