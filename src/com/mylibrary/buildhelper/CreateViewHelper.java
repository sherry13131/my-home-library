package com.mylibrary.buildhelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateViewHelper {

  /* --- View --- */
  public static boolean createViewForViewPartAuthor(Connection con) {
    String sql = "create view authorView as "
        + "select b.title ProductName, b.YearOfPublication Year, 'B' Type, min(CASE WHEN ISNULL(p.MiddleName) "
        + "THEN concat(p.firstName, ' ', p.familyname) "
        + "ELSE concat(p.firstName, ' ',p.middlename, ' ', p.familyname) " + "END) 'Author_singer_director', b.title "
        + "from book b, bookauthor ba, peopleInvolved p " + "where b.isbn = ba.isbn and ba.author_id = p.id "
        + "group by ProductName;";
    PreparedStatement ps;
    try {
      ps = con.prepareStatement(sql);
      ps.executeUpdate(sql);
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  /* --- View --- */
  public static boolean createViewForViewPartSinger(Connection con) {
    String sql = "create view SingerView as "
        + "select mu.albumName ProductName, mu.Year Year, 'M' Type, min(CASE WHEN ISNULL(p.MiddleName) "
        + "THEN concat(p.firstName, ' ', p.familyname) "
        + "ELSE concat(p.firstName, ' ',p.middlename, ' ', p.familyname) "
        + "END) 'Author_singer_director', mu.albumName " + "from music mu, musicsinger mus, peopleinvolved p "
        + "where (mu.albumName,mu.year,mu.musicName) = (mus.albumName,mus.year,mus.musicName) and mus.peopleInvolved_id = p.id "
        + "group by ProductName;";
    PreparedStatement ps;
    try {
      ps = con.prepareStatement(sql);
      ps.executeUpdate(sql);
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  /* --- View --- */
  public static boolean createViewForViewPartCrew(Connection con) {
    String sql = "create view crewView as "
        + "select mv.MovieName ProductName, mv.year Year, 'F' Type, min(CASE WHEN ISNULL(p.MiddleName) "
        + "THEN concat(p.firstName, ' ', p.familyname) "
        + "ELSE concat(p.firstName, ' ',p.middlename, ' ', p.familyname) "
        + "END) 'Author_singer_director', mv.MovieName " + "from movie mv, crewmember cm, peopleinvolved p, role r "
        + "where (mv.MovieName, mv.year) = (cm.MovieName, cm.ReleaseYear) and cm.PeopleInvolved_id = p.id and cm.role_id = r.id "
        + "group by ProductName;";
    PreparedStatement ps;
    try {
      ps = con.prepareStatement(sql);
      ps.executeUpdate(sql);
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  /* --- Report 4 - helper view --- */
  public static boolean createViewForR4BookAuthor(Connection con) {
    String sql = "create view bookAuthorWritten as "
        + "select b2.isbn, b2.title, b2.YearOfPublication year, ba.author_id " + "from book b2, bookauthor ba "
        + "where b2.isbn = ba.isbn " + "order by yearofpublication;";
    PreparedStatement ps;
    try {
      ps = con.prepareStatement(sql);
      ps.executeUpdate(sql);
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  /* --- Report 4 - helper view --- */
  public static boolean createViewForR4PubConsecutive(Connection con) {
    String sql = "create view authorPubConsecutiveYear as " + "select distinct a.author_id "
        + "from bookAuthorWritten a, bookAuthorWritten b " + "where a.author_id = b.author_id and a.year = b.year-1 "
        + "order by a.year, b.year;";
    PreparedStatement ps;
    try {
      ps = con.prepareStatement(sql);
      ps.executeUpdate(sql);
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  /* --- Report 5 - helper view --- */
  public static boolean createViewForR5(Connection con) {
    String sql = "create view keywordFrequency as "
        + "select k.tag, count(*) frequency from bookkeyword bk, keyword k " + "where bk.keyword_id = k.id "
        + "group by k.tag;";
    PreparedStatement ps;
    try {
      ps = con.prepareStatement(sql);
      ps.executeUpdate(sql);
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  /* --- Report 6 - helper view --- */
  public static boolean createViewForR6(Connection con) {
    String sql = "create view multiSkillsMovieCrew as " + "select mc.peopleinvolved_id, p.familyname "
        + "from role r, crewmember mc, peopleinvolved p " + "where r.id = mc.role_id and p.id = mc.peopleinvolved_id "
        + "group by mc.peopleinvolved_id " + "having count(distinct r.id)>1;";
    PreparedStatement ps;
    try {
      ps = con.prepareStatement(sql);
      ps.executeUpdate(sql);
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  /* --- Report 7 - helper view --- */
  public static boolean createViewForR7MovieAward(Connection con) {
    String sql = "create view movieWithAward as " + "select moviename, sum(award) numAward " + "from award "
        + "group by moviename " + "having numAward > 0;";
    PreparedStatement ps;
    try {
      ps = con.prepareStatement(sql);
      ps.executeUpdate(sql);
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  /* --- Report 7 - helper view --- */
  public static boolean createViewForR7MovieCrew(Connection con) {
    String sql = "create view movieCrew as "
        + "select cm.PeopleInvolved_ID, r.description, CASE WHEN ISNULL(p.MiddleName)  "
        + "THEN concat(p.firstName, ' ', p.familyname) "
        + "ELSE concat(p.firstName, ' ',p.middlename, ' ', p.familyname) " + "END 'Director_name', p.familyname "
        + "from crewmember cm, role r, peopleinvolved p "
        + "where cm.Role_ID = r.id and cm.peopleinvolved_id = p.id;";
    PreparedStatement ps;
    try {
      ps = con.prepareStatement(sql);
      ps.executeUpdate(sql);
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  /* --- Report 8 - helper view --- */
  public static boolean createViewForR8(Connection con) {
    String sql = "create view musicNameDupNum as " + "select musicname, count(*) numberDup " + "from music "
        + "group by musicname " + "having numberDup > 1;";
    PreparedStatement ps;
    try {
      ps = con.prepareStatement(sql);
      ps.executeUpdate(sql);
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  /* --- Report 9 - helper view --- */
  public static boolean createViewForR9(Connection con) {
    String sql = "create view peopleOnlyNotArrangerMusic as "
        + "select albumname, year, musicname, peopleinvolved_id " + "from peopleinvolvedmusic "
        + "where isSongwriter = 1 and iscomposer = 1 and isarranger = 0;";
    PreparedStatement ps;
    try {
      ps = con.prepareStatement(sql);
      ps.executeUpdate(sql);
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  /* --- Report 10 - helper views --- */
  public static boolean createViewForR10Book(Connection con) {
    String sql = "create view lnameofbook as " + "select p.familyname, count(*) "
        + "from peopleinvolved p, bookauthor b " + "where p.id = b.author_id " + "group by p.familyname;";
    PreparedStatement ps;
    try {
      ps = con.prepareStatement(sql);
      ps.executeUpdate(sql);
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  /* --- Report 10 - helper views --- */
  public static boolean createViewForR10MusicProducer(Connection con) {
    String sql = "create view lnameofmusicproducer as " + "select distinct p.id, p.familyname, 1 'IsProducer' "
        + "from peopleinvolved p, music m " + "where p.id = m.producer_id;";
    PreparedStatement ps;
    try {
      ps = con.prepareStatement(sql);
      ps.executeUpdate(sql);
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  /* --- Report 10 - helper views --- */
  public static boolean createViewForR10MusicSinger(Connection con) {
    String sql = "create view lnameofmusicsinger as " + "select p.id, p.familyname, 1 'IsSinger' "
        + "from peopleinvolved p, musicsinger m " + "where p.id = m.peopleinvolved_id;";
    PreparedStatement ps;
    try {
      ps = con.prepareStatement(sql);
      ps.executeUpdate(sql);
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  /* --- Report 10 - helper views --- */
  public static boolean createViewForR10MusicSingerProd(Connection con) {
    String sql = "create view lnameofmusicSingerProd as "
        + "select distinct p.id, p.familyname, p.IsSinger, pd.isproducer " + "from lnameofmusicsinger p "
        + "left outer join lnameofmusicproducer pd " + "on p.id = pd.id " + "union "
        + "select distinct pd.id, pd.familyname, p.IsSinger, pd.isproducer " + "from lnameofmusicproducer pd "
        + "left outer join lnameofmusicsinger p " + "on p.id = pd.id;";
    PreparedStatement ps;
    try {
      ps = con.prepareStatement(sql);
      ps.executeUpdate(sql);
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  /* --- Report 10 - helper views --- */
  public static boolean createViewForR10MusicCrews(Connection con) {
    String sql = "create view lnameofmusiccrews as "
        + "select p.id, p.familyname, pm.IsArranger, pm.IsComposer, pm.IsSongwriter "
        + "from peopleinvolved p, peopleinvolvedmusic pm " + "where p.id = pm.peopleinvolved_id;";
    PreparedStatement ps;
    try {
      ps = con.prepareStatement(sql);
      ps.executeUpdate(sql);
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  /* --- Report 10 - helper views --- */
  public static boolean createViewForR10MusicAllPeople(Connection con) {
    String sql = "create view lnameofmusicallpeople as "
        + "select distinct p.id, p.familyname, p.IsSinger, p.IsProducer, pm.IsArranger, pm.IsComposer, pm.IsSongWriter "
        + "from lnameofmusicSingerProd p " + "left outer join lnameofmusiccrews pm " + "on p.id = pm.id;";
    PreparedStatement ps;
    try {
      ps = con.prepareStatement(sql);
      ps.executeUpdate(sql);
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  /* --- Report 10 - helper views --- */
  public static boolean createViewForR10Movie(Connection con) {
    String sql = "create view lnameofmovie as " + "select p.familyname, count(*) "
        + "from peopleinvolved p, crewmember c " + "where p.id = c.peopleinvolved_id " + "group by p.familyname;";
    PreparedStatement ps;
    try {
      ps = con.prepareStatement(sql);
      ps.executeUpdate(sql);
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  /* --- Report 10 - helper views --- */
  public static boolean createViewForR10DistinctLname(Connection con) {
    String sql = "create view distinctFamilyname as " + "select distinct p.familyname " + "from peopleinvolved p "
        + "where (p.familyname in (select familyname from lnameofbook) and p.familyname in (select familyname from lnameofmusicallpeople)) "
        + "or (p.familyname in (select familyname from lnameofbook) and p.familyname in (select familyname from lnameofmovie)) "
        + "or (p.familyname in (select familyname from lnameofmusicallpeople) and p.familyname in (select familyname from lnameofmovie));";
    PreparedStatement ps;
    try {
      ps = con.prepareStatement(sql);
      ps.executeUpdate(sql);
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }
}
