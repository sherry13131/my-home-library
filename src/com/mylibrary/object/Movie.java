package com.mylibrary.object;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Movie {
  private String name;
  private int year;
  private Map<String, List<MovieCrew>> crews = new HashMap<String, List<MovieCrew>>();

  public Movie(String name, int year, Map<String, List<MovieCrew>> crews) {
    this.name = name;
    this.year = year;
    this.crews = crews;
  }

  public String getMovieName() {
    return this.name;
  }

  public int getYear() {
    return this.year;
  }

  public Map<String, List<MovieCrew>> getCrewsMap() {
    return this.crews;
  }

  public List<MovieCrew> getCrewList(String crewRole) {
    return crews.get(crewRole);
  }

  public boolean compareMovie(String name) {
    if (this.getMovieName().equalsIgnoreCase(name)) {
      return true;
    }
    return false;
  }

  public boolean compareYear(int year) {
    if (this.getYear() == year) {
      return true;
    }
    return false;
  }
}

