package com.mylibrary.objects;

import java.sql.Connection;

import com.assignment.gui.MainFrame;
import com.mylibrary.dbhelper.SelectHelper;

public class MovieCrew {
  Connection con = MainFrame.con;
  private String name;
  private boolean gender, award;
  int roleid;

  public MovieCrew(String name, boolean gender, boolean award, int roleid) {
    this.name = name;
    this.gender = gender;
    this.award = award;
    this.roleid = roleid;
  }

  public MovieCrew get() {
    return this;
  }

  public String getCrewName() {
    return this.name;
  }

  public boolean getGender() {
    return this.gender;
  }

  public boolean getAward() {
    return this.award;
  }

  public int getRoleID() {
    return this.roleid;
  }

  public String getRoleName() {
    return SelectHelper.getMovieRoleName(this.roleid, con).toLowerCase();
  }

  public int getPeopleID() {
    return SelectHelper.getPeopleID(this.name, con);
  }

  @Override
  public String toString() {
    return this.name + ' ' + this.roleid;
  }

  public boolean compareName(String name) {
    if (this.name.equalsIgnoreCase(name)) {
      return true;
    }
    return false;
  }

  public boolean compareGender(boolean gender) {
    if (this.gender && !gender) {
      return false;
    }
    return true;
  }

  public boolean compareAward(boolean award) {
    if (this.award && !award) {
      return false;
    }
    return true;
  }

  public boolean compareCrew(MovieCrew newCrew) {
    boolean same = true;
    same = same && this.compareAward(newCrew.getAward());
    same = same && this.compareGender(newCrew.getGender());
    same = same && this.compareName(newCrew.getCrewName());
    return same;
  }

}
