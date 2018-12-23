package com.mylibrary.dbhelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.assignment.gui.MainFrame.MovieCrew;
import com.assignment.gui.MainFrame.diskType;

public class InserterHelper {

  /* --- Data->insert->book --- */
  public static void insertBook(String isbn, String title, String pub, int pages, int year, int edition,
      String bookabs, Connection con) throws SQLException {
    String sql = "insert into Book values (?,?,?,?,?,?,?);";
    PreparedStatement preparedStatement;
    // insert book
    preparedStatement = con.prepareStatement(sql);
    preparedStatement.setString(1, isbn);
    preparedStatement.setString(2, title);
    preparedStatement.setString(3, pub);
    preparedStatement.setInt(4, pages);
    preparedStatement.setInt(5, year);
    if (edition == -1) {
      preparedStatement.setNull(6, java.sql.Types.NULL);
    } else {
      preparedStatement.setInt(6, edition);
    }
    preparedStatement.setString(7, bookabs);
    preparedStatement.executeUpdate();
  }

  /* --- Data->insert->book --- */
  public static void insertOneBookAuthor(String isbn, String author, Connection con) throws SQLException {
    String sql = "insert into Bookauthor values (?,?);";
    PreparedStatement preparedStatement;
    int pplID = -1;
    pplID = SelectHelper.getPeopleID(author, con);
    if (pplID == -1) {
      // add new author
      pplID = InserterHelper.insertNewPeople(author, con);
    }
    // insert author after found/added
    preparedStatement = con.prepareStatement(sql);
    preparedStatement.setString(1, isbn);
    preparedStatement.setInt(2, pplID);
    preparedStatement.executeUpdate();
  }

  /* --- Data->insert->book --- */
  public static void insertBookAuthor(String isbn, List<String> authors, Connection con) throws SQLException {
    String sql = "insert into Bookauthor values (?,?);";
    int count = 0;
    PreparedStatement preparedStatement;
    int pplID = -1;
    for (String author : authors) {
      pplID = SelectHelper.getPeopleID(author, con);
      if (pplID == -1) {
        // add new author
        pplID = InserterHelper.insertNewPeople(author, con);
        if (pplID == -1) {
          continue;
        }
      }
      // insert author after found/added
      preparedStatement = con.prepareStatement(sql);
      preparedStatement.setString(1, isbn);
      preparedStatement.setInt(2, pplID);
      preparedStatement.executeUpdate();
      count++;
    }
    if (count <= 0) {
      throw new SQLException();
    }
  }

  /* --- Data->insert->book --- */
  public static void insertBookAuthor(String isbn, Set<String> authors, Connection con) throws SQLException {
    String sql = "insert into Bookauthor values (?,?);";
    int count = 0;
    PreparedStatement preparedStatement;
    int pplID = -1;
    for (String author : authors) {
      pplID = SelectHelper.getPeopleID(author, con);
      if (pplID == -1) {
        // add new author
        pplID = InserterHelper.insertNewPeople(author, con);
        if (pplID == -1) {
          continue;
        }
      }
      // insert author after found/added
      preparedStatement = con.prepareStatement(sql);
      preparedStatement.setString(1, isbn);
      preparedStatement.setInt(2, pplID);
      preparedStatement.executeUpdate();
      count++;
    }
    if (count <= 0) {
      throw new SQLException();
    }
  }

  /* --- Data->insert->book --- */
  public static void insertBookKeyword(String isbn, int keyID, Connection con) throws SQLException {
    String sql = "insert into BookKeyword values (?,?);";
    PreparedStatement preparedStatement;
    preparedStatement = con.prepareStatement(sql);
    preparedStatement.setString(1, isbn);
    preparedStatement.setInt(2, keyID);
    preparedStatement.executeUpdate();
  }

  /* --- Data->insert->book --- */
  public static void insertBookKeyword(String isbn, List<String> keywords, Connection con) throws SQLException {
    String sql = "insert into BookKeyword values (?,?);";
    List<String> newKeywords = new ArrayList<String>();
    int id = -1;
    String[] stringArray = {};
    PreparedStatement preparedStatement;
    preparedStatement = con.prepareStatement(sql);
    preparedStatement.setString(1, isbn);
    for (String key : keywords) {
      id = SelectHelper.getKeywordID(key, con);
      if (id < 0) {
        newKeywords.add(key);
      }
    }
    stringArray = newKeywords.toArray(new String[newKeywords.size()]);

    // insert all the new keywords to keyword table
    InserterHelper.insertKeyword(isbn, stringArray, con);
    // insert all the keywords to bookkeyword table
    for (String key : keywords) {
      id = SelectHelper.getKeywordID(key, con);
      preparedStatement.setInt(2, id);
      preparedStatement.executeUpdate();
    }

  }

  /* --- Data->insert->book --- */
  public static void insertKeyword(String isbn, String[] keywords, Connection con) throws SQLException {
    int keyID = -1;
    String sql = "insert into Keyword (tag) values (?);";
    PreparedStatement preparedStatement;
    if (keywords != null) {
      for (String keyword : keywords) {
        // nextKeyID = SelectHelper.getNextKeywordID();
        keyID = SelectHelper.getKeywordID(keyword, con);
        if (keyID < 0) {
          preparedStatement = con.prepareStatement(sql);
          // preparedStatement.setInt(1, nextKeyID);
          preparedStatement.setString(1, keyword);
          preparedStatement.executeUpdate();
          // keyID = nextKeyID;
          keyID = SelectHelper.getKeywordID(keyword, con);
        }
        // insertBookKeyword(isbn, keyID);
      }
    }
  }

  /* --- Data->insert->peopleinvolved --- */
  public static int insertNewPeople(String fullname, Connection con) throws SQLException {
    // int nextID = SelectHelper.getNextPeopleID();
    String first = null, mid = null, last = null;
    String[] name = fullname.split(" ");
    // if (nextID > 0) {
    if (name.length == 2) {
      first = name[0];
      last = name[1];
    } else if (name.length >= 3) {
      first = name[0];
      mid = name[1];
      last = name[2];
    }
    if (name.length >= 2) {
      // insert new author
      String sql = "insert into PeopleInvolved (firstname, middlename, familyname, gender) values (?,?,?,?);";
      try {
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, first);
        preparedStatement.setString(2, mid);
        preparedStatement.setString(3, last);
        preparedStatement.setString(4, null);
        preparedStatement.executeUpdate();
        return SelectHelper.getPeopleID(fullname, con);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    // }
    return -1;
  }

  /* --- Data->insert->movie --- */
  public static int insertNewPeople(MovieCrew crew, Connection con) throws SQLException {
    // int nextID = SelectHelper.getNextPeopleID();
    String first = null, mid = null, last = null, fullname = null;
    String[] name = crew.getCrewName().split(" ");

    if (name.length == 2) {
      first = name[0];
      last = name[1];
      fullname = first + " " + last;
    } else if (name.length >= 3) {
      first = name[0];
      mid = name[1];
      last = name[2];
      fullname = first + " " + mid + " " + last;
    }
    if (name.length >= 2) {
      // insert new author
      String sql = "insert into PeopleInvolved (firstname, middlename, familyname, gender) values (?,?,?,?);";
      try {
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(sql);
        // preparedStatement.setInt(1, nextID);
        preparedStatement.setString(1, first);
        preparedStatement.setString(2, mid);
        preparedStatement.setString(3, last);
        preparedStatement.setBoolean(4, crew.getGender());
        preparedStatement.executeUpdate();
        return SelectHelper.getPeopleID(fullname, con);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return -1;
  }

  /* --- Data->insert->album --- */
  public static void insertAlbum(String albumName, int year, String musicName, String language, diskType diskType,
      String producer, Connection con) throws SQLException {
    int producerID = SelectHelper.getPeopleID(producer, con);
    String sql = "insert into Music values (?,?,?,?,?,?);";
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setString(1, albumName);
    ps.setInt(2, year);
    ps.setString(3, musicName);
    ps.setString(4, language);
    ps.setInt(5, diskType.getEnumValue());
    ps.setInt(6, producerID);
    ps.executeUpdate();
  }

  /* --- Data->insert->album --- */
  public static void insertMusicSinger(String albumName, int year, String musicName, int id, Connection con) throws SQLException {
    String sql = "insert into MusicSinger values (?,?,?,?);";
    PreparedStatement ps;
    ps = con.prepareStatement(sql);
    ps.setString(1, albumName);
    ps.setInt(2, year);
    ps.setString(3, musicName);
    ps.setInt(4, id);
    ps.executeUpdate();
  }

  /* --- Data->insert->album --- */
  public static void insertMusicSinger(String albumName, int year, String musicName, String sname, Connection con)
      throws SQLException {
    String sql = "insert into MusicSinger values (?,?,?,?);";
    int id = SelectHelper.getPeopleID(sname, con);
    if (id < 0) {
      id = InserterHelper.insertNewPeople(sname, con);
    }
    PreparedStatement ps;
    ps = con.prepareStatement(sql);
    ps.setString(1, albumName);
    ps.setInt(2, year);
    ps.setString(3, musicName);
    ps.setInt(4, id);
    ps.executeUpdate();
  }

  /* --- Data->insert->album --- */
  public static void insertMusicPeopleInvolved(String albumName, int year, String musicName, int ppl, int sw, int c,
      int a, Connection con) throws SQLException {
    String sql = "insert into PeopleInvolvedMusic values (?,?,?,?,?,?,?);";
    PreparedStatement ps;
    ps = con.prepareStatement(sql);
    ps.setString(1, albumName);
    ps.setInt(2, year);
    ps.setString(3, musicName);
    ps.setInt(4, ppl);
    ps.setInt(5, sw);
    ps.setInt(6, c);
    ps.setInt(7, a);
    ps.executeUpdate();
  }

  /* --- Data->insert->album --- */
  public static void insertMusicPeopleInvolved(String albumName, int year, String musicName, String name, int sw,
      int c, int a, Connection con) throws SQLException {
    String sql = "insert into PeopleInvolvedMusic values (?,?,?,?,?,?,?);";
    int id = SelectHelper.getPeopleID(name, con);
    if (id < 0) {
      id = InserterHelper.insertNewPeople(name, con);
      if (id < 0) {
        throw new SQLException();
      }
    }
    PreparedStatement ps;
    ps = con.prepareStatement(sql);
    ps.setString(1, albumName);
    ps.setInt(2, year);
    ps.setString(3, musicName);
    ps.setInt(4, id);
    ps.setInt(5, sw);
    ps.setInt(6, c);
    ps.setInt(7, a);
    ps.executeUpdate();
  }

  /* --- Data->insert->movie --- */
  public static void insertMovie(String movieName, int movieYear, Connection con) throws SQLException {
    String sql = "insert into Movie values (?,?);";
    PreparedStatement ps;
    ps = con.prepareStatement(sql);
    ps.setString(1, movieName);
    ps.setInt(2, movieYear);
    ps.executeUpdate();
  }

  /* --- Data->insert->movie --- */
  public static void insertAward(String movieName, int movieYear, Map<String, List<MovieCrew>> crews, Connection con)
      throws SQLException {
    String sql = "insert ignore into award values (?,?,?,?);";
    PreparedStatement ps;
    ps = con.prepareStatement(sql);
    ps.setString(2, movieName);
    ps.setInt(3, movieYear);
    for (List<MovieCrew> list : crews.values()) {
      for (MovieCrew crew : list) {
        ps.setInt(1, crew.getPeopleID());
        ps.setBoolean(4, crew.getAward());
        ps.executeUpdate();
      }
    }
  }

  /* --- Data->insert->movie --- */
  public static void insertAward(String movieName, int movieYear, MovieCrew mc, Connection con) throws SQLException {
    String sql = "insert ignore into award values (?,?,?,?);";
    PreparedStatement ps;
    ps = con.prepareStatement(sql);
    ps.setString(2, movieName);
    ps.setInt(3, movieYear);
    ps.setInt(1, mc.getPeopleID());
    ps.setBoolean(4, mc.getAward());
    ps.executeUpdate();
  }

  /* --- Data->insert->movie --- */
  public static void insertCrewMember(String movieName, int movieYear, Map<String, List<MovieCrew>> crews, Connection con)
      throws SQLException {
    String sql = "insert into CrewMember values (?,?,?,?);";
    PreparedStatement ps;
    int id = -1;
    ps = con.prepareStatement(sql);
    ps.setString(2, movieName);
    ps.setInt(3, movieYear);
    for (List<MovieCrew> list : crews.values()) {
      for (MovieCrew crew : list) {
        // get peopleID for people
        id = crew.getPeopleID();
        if (id < 0) {
          id = InserterHelper.insertNewPeople(crew, con);
          if (id < 0) {
            throw new SQLException();
          }
        }
        ps.setInt(1, id);
        // for each role the person has
        ps.setInt(4, crew.getRoleID());
        ps.executeUpdate();
      }
    }
  }

  /* --- Data->insert->movie --- */
  public static void insertCrewMember(String movieName, int movieYear, MovieCrew mc, Connection con) throws SQLException {
    String sql = "insert into CrewMember values (?,?,?,?);";
    PreparedStatement ps;
    ps = con.prepareStatement(sql);
    // get peopleID for people
    ps.setInt(1, mc.getPeopleID());
    ps.setString(2, movieName);
    ps.setInt(3, movieYear);
    ps.setInt(4, mc.getRoleID());
    ps.executeUpdate();
  }

}
