package com.mylibrary.createhelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public class ReportHelper {

  /* --- report 1: Authors’ Publications --- */
  public static ResultSet createR1Report(String fullname, Connection con) {
    String[] name = fullname.split(" ");
    ResultSet rs = null;
    String sql = "select b.ISBN, b.Title, b.YearOfPublication " + "from Book b, bookauthor ba, peopleinvolved p "
        + "where b.ISBN = ba.ISBN and ba.author_id = p.id and concat(p.firstname,' ',p.familyname) = ? "
        + "order by ISBN;";
    if (name.length >= 3) {
      sql = "select b.ISBN, b.Title, b.YearOfPublication " + "from Book b, bookauthor ba, peopleinvolved p "
          + "where b.ISBN = ba.ISBN and ba.author_id = p.id and concat(p.firstname,' ',p.middlename,' ',p.familyname) = ? "
          + "order by ISBN;";
    }
    try {
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, fullname);
      rs = ps.executeQuery();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return rs;
  }

  /* --- report 2: Publications in one Year --- */
  public static ResultSet createR2Report(int year, Connection con) {
    String sql = "select b.ISBN, b.title, b.YearOfPublication, p.familyname, upper(SUBSTRING(p.firstname,1,1)) initials "
        + "from book b, bookauthor ba, peopleinvolved p "
        + "where b.isbn = ba.isbn and ba.author_id = p.id and yearOfPublication = ? " + "order by b.title;";
    ResultSet rs = null;
    try {
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, year);
      rs = ps.executeQuery();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return rs;
  }

  /* --- report 3: Books with Similar Topic --- */
  public static ResultSet createR3Report(String keyword, Connection con) {
    String sql = "select isbn, title, yearofpublication " + "from " + "(select b.isbn, b.title, b.yearofpublication "
        + "from book b " + "inner join bookkeyword bk " + "on b.isbn = bk.isbn " + "inner join keyword k "
        + "on k.id = bk.keyword_id " + "where k.tag like ?  " + "union " + "select ISBN, title, yearOfPublication  "
        + "from book  " + "where abstract like ? or title like ?) a " + "order by isbn;";
    ResultSet rs = null;
    try {
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, "%" + keyword + "%");
      ps.setString(2, "%" + keyword + "%");
      ps.setString(3, "%" + keyword + "%");
      rs = ps.executeQuery();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return rs;
  }

  /* --- report 4: Frequent Publishers --- */
  public static ResultSet createR4Report(Connection con) {
    // create a view if not exist yet
    boolean exist1 = checkHelper.checkIfTableExist("bookAuthorWritten", con);
    boolean exist2 = checkHelper.checkIfTableExist("authorPubConsecutiveYear", con);
    boolean success1 = true, success2 = true;
    ResultSet rs = null;
    if (!exist1) {
      success1 = CreateViewHelper.createViewForR4BookAuthor(con);
    }
    if (!exist2) {
      success2 = CreateViewHelper.createViewForR4PubConsecutive(con);
    }
    // execute query if view exist
    if (success1 && success2) {
      String sql = "select b.isbn, b.title, CASE WHEN ISNULL(p.MiddleName)  "
          + "THEN concat(p.firstName, ' ', p.familyname) "
          + "ELSE concat(p.firstName, ' ',p.middlename, ' ', p.familyname) " + "END author_name, b.yearofpublication "
          + "from authorPubConsecutiveYear c, book b, bookauthor ba, peopleinvolved p "
          + "where b.isbn = ba.isbn and p.id = ba.author_id and c.author_id = ba.author_id "
          + "order by p.familyname, b.yearofpublication;";
      PreparedStatement ps;
      try {
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery(sql);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return rs;
  }

  /* --- report 5: Most Popular Subjects --- */
  public static ResultSet createR5Report(Connection con) {
    // create a view if not exist yet
    boolean exist = checkHelper.checkIfTableExist("keywordFrequency", con);
    boolean success = true;
    ResultSet rs = null;
    if (!exist) {
      success = CreateViewHelper.createViewForR5(con);
    }
    // execute query if view exist
    if (success) {
      String sql = "select k.tag, kf.frequency " + "from bookkeyword bk, keyword k, keywordFrequency kf "
          + "where bk.keyword_id = k.id and kf.tag = k.tag and kf.frequency in (select max(frequency) from keywordFrequency) "
          + "group by k.tag " + "order by k.tag;";
      PreparedStatement ps;
      try {
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery(sql);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return rs;
  }

  /* --- report 6: Multi Skills Movie Crew --- */
  public static ResultSet createR6Report(Connection con) {
    // create a view if not exist yet
    boolean exist = checkHelper.checkIfTableExist("multiSkillsMovieCrew", con);
    boolean success = true;
    ResultSet rs = null;
    if (!exist) {
      success = CreateViewHelper.createViewForR6(con);
    }
    // execute query if view exist
    if (success) {
      String sql = "select t.familyname, r.description, mc.moviename "
          + "from multiSkillsMovieCrew t, role r, crewmember mc "
          + "where t.peopleinvolved_id = mc.peopleinvolved_id and r.id = mc.role_id "
          + "order by t.familyname;";
      PreparedStatement ps;
      try {
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery(sql);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return rs;
  }

  /* --- report 7: Award Winning Movies--- */
  public static ResultSet createR7Report(Connection con) {
    // create a view if not exist yet
    boolean exist = checkHelper.checkIfTableExist("movieWithAward", con),
        exist2 = checkHelper.checkIfTableExist("movieCrew", con);
    ;
    boolean success = true, success2 = true;
    ResultSet rs = null;
    if (!exist) {
      success = CreateViewHelper.createViewForR7MovieAward(con);
    }
    if (!exist2) {
      success = CreateViewHelper.createViewForR7MovieCrew(con);
    }
    // execute query if view exist
    if (success && success2) {
      String sql = "select cm.moviename, mc.director_name, mwa.numAward "
          + "from movieWithAward mwa, crewmember cm, movieCrew mc "
          + "where mwa.moviename = cm.moviename and mc.peopleInvolved_id = cm.peopleinvolved_id "
          + "and mc.description = 'director' " + "group by mc.director_name, moviename " + "order by mc.familyname;";
      PreparedStatement ps;
      try {
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery(sql);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return rs;
  }

  /* --- report 8: Music with Similar Name --- */
  public static ResultSet createR8Report(Connection con) {
    // create a view if not exist yet
    boolean exist = checkHelper.checkIfTableExist("musicNameDupNum", con);
    boolean success = true;
    ResultSet rs = null;
    if (!exist) {
      success = CreateViewHelper.createViewForR8(con);
    }
    // execute query if view exist
    if (success) {
      String sql = "select ms.albumname, ms.musicname, ms.year, CASE WHEN ISNULL(p.MiddleName) "
          + "THEN concat(p.firstName, ' ', p.familyname) "
          + "ELSE concat(p.firstName, ' ',p.middlename, ' ', p.familyname) " + "END 'Singer name' "
          + "from musicsinger ms, musicNameDupNum d, peopleinvolved p "
          + "where ms.musicname = d.musicname and ms.peopleinvolved_id = p.id " + "order by ms.musicname, ms.year;";
      PreparedStatement ps;
      try {
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery(sql);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return rs;
  }

  /* --- report 9: Multi Skills Music Crew --- */
  public static ResultSet createR9Report(Connection con) {
    // create a view if not exist yet
    boolean exist = checkHelper.checkIfTableExist("peopleOnlyNotArrangerMusic", con);
    boolean success = true;
    ResultSet rs = null;
    if (!exist) {
      success = CreateViewHelper.createViewForR9(con);
    }
    // execute query if view exist
    if (success) {
      String sql = "select p.familyname, upper(SUBSTRING(p.firstname,1,1)) 'First_name_initials', pa.musicname, pa.albumname, pa.year "
          + "from peopleinvolved p, peopleOnlyNotArrangerMusic pa " + "where p.id = pa.peopleinvolved_id "
          + "order by pa.year, pa.musicname desc;";
      PreparedStatement ps;
      try {
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery(sql);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return rs;
  }

  /* --- report 10: Similar Names --- */
  public static ResultSet createR10Report(Connection con) {
    // create a view if not exist yet
    boolean exist = checkHelper.checkIfTableExist("lnameofbook", con);
    boolean success = true;
    Map<String, String> viewNames = new HashMap<String, String>();
    // {"lnameofbook","lnameofmusicproducer","lnameofmusicsinger","lnameofmusiccrews","lnameofmusicSingerProd",
    // "lnameofmusicallpeople","lnameofmovie","distinctFamilyname"};
    viewNames.put("lnameofbook", "b");
    viewNames.put("lnameofmusicproducer", "mupd");
    viewNames.put("lnameofmusicsinger", "mus");
    viewNames.put("lnameofmusicsingerprod", "muspd");
    viewNames.put("lnameofmusiccrews", "muc");
    viewNames.put("lnameofmusicallpeople", "mup");
    viewNames.put("lnameofmovie", "mv");
    viewNames.put("distinctFamilyname", "d");
    ResultSet rs = null;
    for (String viewname : viewNames.keySet()) {
      exist = checkHelper.checkIfTableExist(viewname, con);
      if (!exist) {
        switch (viewNames.get(viewname)) {
        case "b":
          success = CreateViewHelper.createViewForR10Book(con);
        case "mus":
          success = CreateViewHelper.createViewForR10MusicProducer(con);
          success = CreateViewHelper.createViewForR10MusicSinger(con);
          success = CreateViewHelper.createViewForR10MusicSingerProd(con);
          success = CreateViewHelper.createViewForR10MusicCrews(con);
          success = CreateViewHelper.createViewForR10MusicAllPeople(con);
        case "mv":
          success = CreateViewHelper.createViewForR10Movie(con);
        case "d":
          success = CreateViewHelper.createViewForR10DistinctLname(con);
        }
        if (!success) {
          break;
        }
      }
    }
    // execute query if view exist
    if (success) {
      String sql = "select familyname, role " + "from " + "(select d.familyname, 'author' role "
          + "from distinctFamilyname d, bookauthor b, peopleinvolved p "
          + "where b.author_id = p.id and d.familyname = p.familyname " + "group by d.familyname " + "union "
          + "select d.familyname, 'producer' role "
          + "from distinctFamilyname d, lnameofmusicallpeople s, peopleinvolved p "
          + "where s.id = p.id and d.familyname = p.familyname and s.isproducer = 1 " + "group by d.familyname "
          + "union " + "select d.familyname, 'singer' role "
          + "from distinctFamilyname d, lnameofmusicallpeople s, peopleinvolved p "
          + "where s.id = p.id and d.familyname = p.familyname and s.issinger = 1 " + "group by d.familyname "
          + "union " + "select d.familyname, 'arranger' role "
          + "from distinctFamilyname d, lnameofmusicallpeople s, peopleinvolved p "
          + "where s.id = p.id and d.familyname = p.familyname and s.isarranger = 1 " + "group by d.familyname "
          + "union " + "select d.familyname, 'composer' role "
          + "from distinctFamilyname d, lnameofmusicallpeople s, peopleinvolved p "
          + "where s.id = p.id and d.familyname = p.familyname and s.iscomposer = 1 " + "group by d.familyname "
          + "union " + "select d.familyname, 'song writer' role "
          + "from distinctFamilyname d, lnameofmusicallpeople s, peopleinvolved p "
          + "where s.id = p.id and d.familyname = p.familyname and s.issongwriter = 1 " + "group by d.familyname "
          + "union " + "select d.familyname, r.description role "
          + "from distinctFamilyname d, crewmember c, peopleinvolved p, role r "
          + "where c.peopleinvolved_id = p.id and d.familyname = p.familyname and r.id = c.role_id "
          + "group by d.familyname) result " + "order by familyname;";
      PreparedStatement ps;
      try {
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery(sql);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    } else {
      JOptionPane.showMessageDialog(null, "Something wrong when creating views", "create view - unexpected error",
          JOptionPane.ERROR_MESSAGE);
    }
    return rs;
  }
}
