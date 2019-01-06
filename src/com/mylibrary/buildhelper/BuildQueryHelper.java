package com.mylibrary.buildhelper;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import com.mylibrary.helper.checkHelper;

public class BuildQueryHelper {

  public static String bulidForView(Map<String, Boolean> types, Connection con) {
    boolean exist = true, success = true;
    String sql = "";
    Map<String, String> viewNames = new HashMap<String, String>();
    viewNames.put("authorView", "a");
    viewNames.put("SingerView", "s");
    viewNames.put("crewView", "c");
    for (String viewname : viewNames.keySet()) {
      exist = checkHelper.checkIfTableExist(viewname, con);
      if (!exist) {
        switch (viewNames.get(viewname)) {
        case "a":
          success = CreateViewHelper.createViewForViewPartAuthor(con);
        case "s":
          success = CreateViewHelper.createViewForViewPartSinger(con);
        case "c":
          success = CreateViewHelper.createViewForViewPartCrew(con);
        }
      }
    }
    /* --- View --- */
    if (success) {
      // build query
      sql = "select ProductName, Year, Type, Author_singer_director from (";
      int count = 0;
      for (String b : types.keySet()) {
        // if it's checked
        if (types.get(b)) {
          // if there's sql in sql string
          count++;
          if (count > 1) {
            sql += " union ";
          }
          if (b.equals("book")) {
            sql += "select ProductName, Year, Type, Author_singer_director " + "from authorView "
                + "where title like ? and year = ?";
          } else if (b.equals("album")) {
            sql += "select ProductName, Year, Type, Author_singer_director " + "from singerView "
                + "where albumName like ? and year = ?";
          } else if (b.equals("movie")) {
            sql += "select ProductName, Year, Type, Author_singer_director " + "from crewView "
                + "where moviename like ? and year = ?";
          }

        }
      }
      // end query
      if (count > 0) {
        sql += ") t order by Author_singer_director;";
      }
    } else {
      JOptionPane.showMessageDialog(null, "Something wrong when building query", "View - unexpected error",
          JOptionPane.ERROR_MESSAGE);
    }
    return sql;
  }
}