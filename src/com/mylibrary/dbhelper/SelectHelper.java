package com.mylibrary.dbhelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.assignment.gui.MainFrame.BuildQueryHelper;

public class SelectHelper {

  public static String getPeopleName(int id, Connection con) {
    String sql = "SELECT CASE WHEN ISNULL(MiddleName) " + "THEN concat(firstName, ' ', familyname) "
        + "ELSE concat(firstName, ' ',middlename, ' ', familyname) " + "END FullName "
        + "FROM peopleinvolved where id = ?;";
    ResultSet rs = null;
    PreparedStatement ps;
    String name = null;
    try {
      ps = con.prepareStatement(sql);
      ps.setInt(1, id);
      rs = ps.executeQuery();
      rs.next();
      name = rs.getString("FullName");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return name;

  }

  public static int getPeopleID(String fullname, Connection con) {
    String sql = "Select ID from PeopleInvolved where concat(FirstName,' ',FamilyName) = ?;";
    String sql2 = "Select ID from PeopleInvolved where concat(FirstName,' ', MiddleName, ' ', FamilyName) = ?;";
    String[] name = fullname.split(" ");
    PreparedStatement preparedStatement = null;
    try {
      if (name.length == 2) {
        preparedStatement = con.prepareStatement(sql);
      } else if (name.length > 2) {
        preparedStatement = con.prepareStatement(sql2);
      } else {
        return -1;
      }
      preparedStatement.setString(1, fullname);
      ResultSet rs = preparedStatement.executeQuery();
      if (rs.next()) {
        return (rs.getInt("ID"));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return -1;
  }

  public static int getNextPeopleID(Connection con) {
    String sql = "Select count(*) from PeopleInvolved;";
    try {
      PreparedStatement preparedStatement = con.prepareStatement(sql);
      ResultSet rs = preparedStatement.executeQuery();
      if (rs.next()) {
        int id = rs.getInt("count(*)");
        return id + 1;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return -1;
  }

  public static List<String> getPeopleNames(Connection con) {
    String sql = "Select concat(FirstName,' ',FamilyName) fullname from PeopleInvolved;";
    List<String> names = new ArrayList<String>();
    PreparedStatement preparedStatement;
    try {
      preparedStatement = con.prepareStatement(sql);
      ResultSet rs = preparedStatement.executeQuery();
      if (rs.next()) {
        names.add(rs.getString("fullname"));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return names;
  }

  private static ResultSet getPeopleGenderHelper(int id, Connection con) {
    String sql = "select gender from peopleinvolved where id = ?;";
    ResultSet rs = null;
    PreparedStatement ps;
    try {
      ps = con.prepareStatement(sql);
      ps.setInt(1, id);
      rs = ps.executeQuery();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return rs;
  }

  public static Boolean getPeopleGender(int id, Connection con) {
    ResultSet rs = getPeopleGenderHelper(id, con);
    try {
      if (rs != null) {
        rs.next();
        return rs.getBoolean("gender");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static String getBookIsbn(String bookTitle, Connection con) {
    String sql = "Select isbn from Book where Title = ?;";
    ResultSet rs = null;
    PreparedStatement ps;
    try {
      ps = con.prepareStatement(sql);
      ps.setString(1, bookTitle);
      rs = ps.executeQuery();
      rs.next();
      return rs.getString("ISBN");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static int getBookCount(String bookTitle, Connection con) {
    String sql = "Select count(*) from Book where Title = ?;";
    ResultSet rs = null;
    PreparedStatement ps;
    try {
      ps = con.prepareStatement(sql);
      ps.setString(1, bookTitle);
      rs = ps.executeQuery();
      rs.next();
      return rs.getInt("count(*)");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return -1;
  }

  public static ResultSet getBookInfo(String isbn, Connection con) {
    String sql = "Select * from book where ISBN = ?;";
    ResultSet rs = null;
    PreparedStatement ps;
    try {
      ps = con.prepareStatement(sql);
      ps.setString(1, isbn);
      rs = ps.executeQuery();
      rs.next();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return rs;
  }

  public static ResultSet getBookAuthorName(String isbn, Connection con) {
    String sql = "SELECT CASE WHEN ISNULL(p.MiddleName) " + "THEN concat(p.firstName, ' ', p.familyname) "
        + "ELSE concat(p.firstName, ' ',p.middlename, ' ', p.familyname) " + "END FullName "
        + "FROM peopleinvolved p, bookauthor a where p.ID = a.author_id and a.isbn = ?;";
    ResultSet rs = null;
    PreparedStatement ps;
    try {
      ps = con.prepareStatement(sql);
      ps.setString(1, isbn);
      rs = ps.executeQuery();
      rs.next();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return rs;
  }

  public static ResultSet getBookKeyword(String isbn, Connection con) {
    String sql = "select k.tag from bookkeyword bk, keyword k " + "where bk.keyword_id = k.id and bk.isbn = ?;";
    ResultSet rs = null;
    PreparedStatement ps;
    try {
      ps = con.prepareStatement(sql);
      ps.setString(1, isbn);
      rs = ps.executeQuery();
      rs.next();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return rs;
  }

  public static int getNextKeywordID(Connection con) {
    String sql = "Select count(*) from keyword;";
    try {
      PreparedStatement preparedStatement = con.prepareStatement(sql);
      ResultSet rs = preparedStatement.executeQuery();
      if (rs.next()) {
        int id = rs.getInt("count(*)");
        return id + 1;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return -1;
  }

  public static int getKeywordID(String keyword, Connection con) {
    String sql = "Select ID from keyword where Tag = ?;";
    try {
      PreparedStatement preparedStatement = con.prepareStatement(sql);
      preparedStatement.setString(1, keyword);
      ResultSet rs = preparedStatement.executeQuery();
      if (rs.next()) {
        int id = rs.getInt("ID");
        return id;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return -1;
  }

  public static boolean bookexist(String isbn, Connection con) {
    String sql = "select count(*) from Book where ISBN = ?;";
    try {
      PreparedStatement preparedStatement;
      preparedStatement = con.prepareStatement(sql);
      preparedStatement.setString(1, isbn);
      ResultSet rs = preparedStatement.executeQuery();
      if (rs.next()) {
        if (rs.getInt("count(*)") > 0) {
          return true;
        }
      }
      return false;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return true;
  }

  public static ResultSet getAlbumInfo(String albumName, Connection con) {
    String sql = "Select albumName, year, producer_id from music where albumName = ? group by albumName;";
    ResultSet rs = null;
    PreparedStatement ps;
    try {
      ps = con.prepareStatement(sql);
      ps.setString(1, albumName);
      rs = ps.executeQuery();
      rs.next();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return rs;
  }

  public static ResultSet getAlbums(Connection con) {
    String sql = "Select AlbumName, Year, MusicName, Producer_ID from Music;";
    ResultSet albumsInfo = null;
    PreparedStatement preparedStatement;
    try {
      preparedStatement = con.prepareStatement(sql);
      albumsInfo = preparedStatement.executeQuery();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return albumsInfo;

  }

  public static int getAlbumMusicsCount(String albumName, Connection con) {
    String sql = "Select count(*) from music where albumName=?;";
    ResultSet rs = null;
    PreparedStatement ps;
    int count = -1;
    try {
      ps = con.prepareStatement(sql);
      ps.setString(1, albumName);
      rs = ps.executeQuery();
      rs.next();
      count = rs.getInt("count(*)");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return count;
  }

  public static ResultSet getAlbumMusics(String albumName, Connection con) {
    String sql = "Select MusicName, language, disktype from music where AlbumName=?;";
    ResultSet rs = null;
    PreparedStatement ps;
    try {
      ps = con.prepareStatement(sql);
      ps.setString(1, albumName);
      rs = ps.executeQuery();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return rs;
  }

  public static ResultSet getTrackCrewsRs(String albumName, String musicName, Connection con) {
    String sql = "(select peopleinvolved_id, 'songwriter' role_ from peopleinvolvedmusic "
        + "where issongwriter = 1 and albumName = ? and musicName = ?) " + "union "
        + "(select peopleinvolved_id, 'composer' role_ from peopleinvolvedmusic "
        + "where iscomposer = 1 and albumName = ? and musicName = ?)" + "union "
        + "(select peopleinvolved_id,'arranger' role_ from peopleinvolvedmusic "
        + "where isarranger = 1 and albumName = ? and musicName = ?);";
    ResultSet rs = null;
    PreparedStatement ps;
    try {
      ps = con.prepareStatement(sql);
      for (int i = 1; i <= 6; i = i + 2) {
        ps.setString(i, albumName);
        ps.setString(i + 1, musicName);
      }
      rs = ps.executeQuery();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return rs;
  }

  public static Map<String, String> getTrackCrewName(String albumName, String musicName, Connection con) {
    ResultSet rs = SelectHelper.getTrackCrewsRs(albumName, musicName, con);
    Map<String, String> crews = new HashMap<String, String>(); // key: role ; value: people name
    try {
      while (rs.next()) {
        crews.put(rs.getString("role_"), SelectHelper.getPeopleName(rs.getInt("peopleinvolved_id"), con));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return crews;
  }

  public static int getNumRoleMusic(String albumName, String musicName, String name, Connection con) {
    String sql = "select (isarranger + issongwriter + iscomposer ) as num from peopleinvolvedmusic where"
        + " albumName = ? and musicname = ? and peopleinvolved_id = ?;";
    ResultSet rs = null;
    int num = -1;
    PreparedStatement ps;
    try {
      ps = con.prepareStatement(sql);
      ps.setString(1, albumName);
      ps.setString(2, musicName);
      ps.setInt(3, SelectHelper.getPeopleID(name, con));
      rs = ps.executeQuery();
      rs.next();
      num = rs.getInt("num");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return num;
  }

  public static ResultSet getSingersRs(String albumName, String musicName, Connection con) {
    String sql = "select * from musicsinger where albumName = ? and musicName = ?;";
    ResultSet rs = null;
    PreparedStatement ps;
    try {
      ps = con.prepareStatement(sql);
      ps.setString(1, albumName);
      ps.setString(2, musicName);
      rs = ps.executeQuery();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return rs;
  }

  public static Set<String> getSingersName(String albumName, String musicName, Connection con) {
    ResultSet rs = null;
    rs = SelectHelper.getSingersRs(albumName, musicName, con);
    String name = null;
    Set<String> singers = new HashSet<String>();
    try {
      while (rs.next()) {
        name = SelectHelper.getPeopleName(rs.getInt("peopleinvolved_id"), con);
        singers.add(name);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return singers;
  }

  public static List<String> getSingersList(String albumName, String musicName, Connection con) {
    ResultSet rs = null;
    rs = SelectHelper.getSingersRs(albumName, musicName, con);
    String name = null;
    List<String> singers = new ArrayList<String>();
    try {
      while (rs.next()) {
        name = SelectHelper.getPeopleName(rs.getInt("peopleinvolved_id"), con);
        singers.add(name);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return singers;
  }

  public static int getMovieCount(String movieName, Connection con) {
    String sql = "Select count(*) from Movie where MovieName = ?;";
    ResultSet rs = null;
    PreparedStatement ps;
    try {
      ps = con.prepareStatement(sql);
      ps.setString(1, movieName);
      rs = ps.executeQuery();
      rs.next();
      return rs.getInt("count(*)");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return -1;
  }

  public static ResultSet getMovieInfo(String movieName, Connection con) {
    String sql = "select moviename, year from movie where movieName = ?;";
    ResultSet rs = null;
    PreparedStatement ps;
    try {
      ps = con.prepareStatement(sql);
      ps.setString(1, movieName);
      rs = ps.executeQuery();
      rs.next();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return rs;
  }

  /**
   * get all crews in that movie (pid and roleid)
   * 
   * @param movieName
   * @return rs
   */
  public static ResultSet getMovieCrewIds(String movieName, Connection con) {
    String sql = "select peopleinvolved_id id, role_id from crewmember where moviename = ?;";
    ResultSet rs = null;
    PreparedStatement ps;
    try {
      ps = con.prepareStatement(sql);
      ps.setString(1, movieName);
      rs = ps.executeQuery();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return rs;
  }

  /**
   * get one movie crew info (id, gender and award)
   * 
   * @param movieName
   * @param id
   * @return rs
   */
  public static ResultSet getMovieCrewInfo(String movieName, int id, Connection con) {
    String sql = "select a.peopleinvolved_id, a.award, p.gender from peopleinvolved p, award a where "
        + "p.id = a.peopleinvolved_id and a.moviename = ? and p.id = ?;";
    ResultSet rs = null;
    PreparedStatement ps;
    try {
      ps = con.prepareStatement(sql);
      ps.setString(1, movieName);
      ps.setInt(2, id);
      rs = ps.executeQuery();
      rs.next();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return rs;
  }

  public static String getMovieRoleName(int roleid, Connection con) {
    String sql = "select description from role where id = ?;";
    String role = null;
    ResultSet rs = null;
    PreparedStatement ps;
    try {
      ps = con.prepareStatement(sql);
      ps.setInt(1, roleid);
      rs = ps.executeQuery();
      rs.next();
      role = rs.getString("description");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return role;
  }

  public static int getRoleID(String role, Connection con) {
    String sql = "select ID from role where Description = ?;";
    PreparedStatement ps;
    try {
      ps = con.prepareStatement(sql);
      ps.setString(1, role);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        return rs.getInt("ID");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return -1;
  }

  public static boolean checkMusicCastExist(String albumName, int year, String musicName, int ppl, Connection con) {
    String sql = "Select count(*) from PeopleInvolvedMusic "
        + "group by AlbumName, Year, MusicName, PeopleInvolved_ID "
        + "having AlbumName = ? and Year = ? and MusicName = ? and PeopleInvolved_ID = ?;";
    ResultSet rs = null;
    int found = -1;
    PreparedStatement ps;
    try {
      ps = con.prepareStatement(sql);
      ps.setString(1, albumName);
      ps.setInt(2, year);
      ps.setString(3, musicName);
      ps.setInt(4, ppl);
      rs = ps.executeQuery();
      if (rs.next()) {
        found = rs.getInt("count(*)");
      }
      if (found > 0) {
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }

  public static boolean checkMusicCastExist(String albumName, String musicName, String name, Connection con) {
    String sql = "Select count(*) from PeopleInvolvedMusic " + "group by AlbumName, MusicName, PeopleInvolved_ID "
        + "having AlbumName = ? and MusicName = ? and PeopleInvolved_ID = ?;";
    ResultSet rs = null;
    int found = -1, id = -1;
    PreparedStatement ps;
    id = SelectHelper.getPeopleID(name, con);
    try {
      ps = con.prepareStatement(sql);
      ps.setString(1, albumName);
      ps.setString(2, musicName);
      ps.setInt(3, id);
      rs = ps.executeQuery();
      if (rs.next()) {
        found = rs.getInt("count(*)");
      }
      if (found > 0) {
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }

  public static boolean checkMovieExist(String movieName, int movieYear, Connection con) {
    String sql = "select count(*) from Movie where MovieName = ? and Year = ?;";
    int found = -1;
    PreparedStatement ps;
    try {
      ps = con.prepareStatement(sql);
      ps.setString(1, movieName);
      ps.setInt(2, movieYear);
      ResultSet rs = null;
      rs = ps.executeQuery();
      if (rs.next()) {
        found = rs.getInt("count(*)");
      }
      if (found == 0) {
        return false;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return true;
  }

  public static ResultSet getResultByQuery(String name, int year, String sql, int count, Connection con) {
    PreparedStatement ps;
    ResultSet rs = null;
    try {
      ps = con.prepareStatement(sql);
      for (int i = 1; i <= count * 2; i = i + 2) {
        ps.setString(i, "%" + name + "%");
        ps.setInt(i + 1, year);
      }
      if (count > 0) {
        rs = ps.executeQuery();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return rs;
  }

  public static ResultSet createView(String name, int year, Map<String, Boolean> types, Connection con) {
    // build query
    String sql = BuildQueryHelper.bulidForView(types);
    // count how many box checked
    int count = 0;
    for (String b : types.keySet()) {
      if (types.get(b)) {
        count++;
      }
    }
    // run query
    ResultSet rs = SelectHelper.getResultByQuery(name, year, sql, count, con);
    return rs;
  }
}
