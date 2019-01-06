package com.mylibrary.helper;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.assignment.gui.MainFrame.diskType;
import com.mylibrary.dbhelper.SelectHelper;
import com.mylibrary.objects.MovieCrew;

public class checkHelper {

  public static boolean checkIfEmptyCrew(Map<String, List<MovieCrew>> crews) {
    for (List<MovieCrew> list : crews.values()) {
      if (list.isEmpty()) {
        return true;
      }
    }
    return false;
  }

  public static boolean duplicateAuthor(String name, List<String> newAuthors) {
    for (String a : newAuthors) {
      if (a.equalsIgnoreCase(name)) {
        return true;
      }
    }
    return false;
  }

  public static boolean checkNameFormat(String name) {
    String[] temp = name.split(" ");
    if ((temp.length < 2) || (temp.length > 3)) {
      JOptionPane.showMessageDialog(null, "Some of the names are in wrong format.",
          "Insert music - wrong name format", JOptionPane.ERROR_MESSAGE);
      return false;
    }
    return true;
  }

  public static boolean bookExist(String bookTitle, Connection con) {
    if (SelectHelper.getBookCount(bookTitle, con) > 0) {
      return true;
    }
    return false;
  }

  public static boolean albumExist(String albumName, Connection con) {
    if (SelectHelper.getAlbumMusicsCount(albumName, con) > 0) {
      return true;
    }
    return false;
  }

  public static boolean movieExist(String movieName, Connection con) {
    if (SelectHelper.getMovieCount(movieName, con) > 0) {
      return true;
    }
    return false;
  }

  public static boolean checkIsbnFormat(String isbn) {
    String pattern = "^\\d{13}$";
    Pattern r = Pattern.compile(pattern);
    Matcher m = r.matcher(isbn);
    if (m.find()) {
      return true;
    }
    return false;
  }

  public static boolean musicExist(String albumName, int year, String musicName, Connection con) {
    ResultSet rs = SelectHelper.getAlbums(con);
    try {
      while (rs.next()) {
        if (rs.getString("AlbumName").equalsIgnoreCase(albumName)) {
          if (rs.getInt("Year") == year) {
            if (rs.getString("MusicName").equalsIgnoreCase(musicName)) {
              return true;
            }
          }
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  public static boolean musicExistNoYear(String albumName, String musicName, Connection con) {
    ResultSet rs = SelectHelper.getAlbums(con);
    try {
      while (rs.next()) {
        if (rs.getString("AlbumName").equalsIgnoreCase(albumName)) {
          if (rs.getString("MusicName").equalsIgnoreCase(musicName)) {
            return true;
          }
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  public static int checkIfNumerical(JTextField text) {
    int result = -1;
    try {
      result = Integer.parseInt(text.getText());
    } catch (NumberFormatException nfe) {
      // Not a number
      result = -1;
    }
    return result;
  }

  public static int checkIfNumerical(String str) {
    int result = -1;
    try {
      result = Integer.parseInt(str);
    } catch (NumberFormatException nfe) {
      // Not a number
      result = -1;
    }
    return result;
  }

  public static boolean checkIfTableExist(String tableName, Connection con) {
    DatabaseMetaData meta;
    try {
      meta = con.getMetaData();
      ResultSet res = meta.getTables(null, null, null, new String[] { "TABLE", "VIEW" });
      while (res.next()) {
        if (res.getString("TABLE_NAME").equalsIgnoreCase(tableName)) {
          return true;
        }
      }
      res.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  public static diskType checkDiskType(Boolean type) {
    // 0-> CD, 1 -> vinyl
    if (type) {
      return diskType.VINYL;
    } else {
      return diskType.AUDIOCD;
    }
  }

  public static int checkNumRoleMusic(String albumName, String musicName, String name, Connection con) {
    int num = SelectHelper.getNumRoleMusic(albumName, musicName, name, con);
    return num;
  }

  public static boolean checkMusicCrewExist(String albumName, String musicName, String name, Connection con) {
    int id = SelectHelper.getPeopleID(name, con);
    if (id < 0) {
      return false;
    }
    boolean exist = SelectHelper.checkMusicCastExist(albumName, musicName, name, con);
    return exist;
  }
}
