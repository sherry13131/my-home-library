package com.mylibrary.createhelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mylibrary.databasehelper.DeleteHelper;
import com.mylibrary.databasehelper.InserterHelper;
import com.mylibrary.databasehelper.SelectHelper;
import com.mylibrary.object.Album;
import com.mylibrary.object.Movie;
import com.mylibrary.object.MovieCrew;
import com.mylibrary.object.MusicTrack;

public class TransactionHelper {

  /* --- Data->insert->book --- */
  public static boolean insertBookTransaction(String isbn, String title, String pub, int pages, int year, int edition,
      String bookabs, List<String> authors, String[] keywords, Connection con) {
    try {
      con.setAutoCommit(false);
      // insert book
      InserterHelper.insertBook(isbn, title, pub, pages, year, edition, bookabs, con);
      // insert authors
      InserterHelper.insertBookAuthor(isbn, authors, con);
      // insert keywords
      InserterHelper.insertKeyword(isbn, keywords, con);
      con.commit();
      return true;
    } catch (SQLException e) {
      try {
        con.rollback();
        System.out.println("Something wrong when inserting data");
        System.out.println("Rolling back data...");
        e.printStackTrace();
      } catch (SQLException e1) {
        e1.printStackTrace();
      }
    } finally {
      try {
        con.setAutoCommit(true);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return false;
  }

  /* --- Data->insert->music --- */
  public static boolean insertMusicTransaction(String albumName, int year, String producer,
      List<MusicTrack> musicTracks, Connection con) {
    int pplID = -1;
    try {
      con.setAutoCommit(false);
      for (MusicTrack mt : musicTracks) {

        for (String s : mt.getSingers()) {
          pplID = SelectHelper.getPeopleID(s, con);
          if (pplID == -1) {
            // author not exist
            // add new author
            pplID = InserterHelper.insertNewPeople(s, con);
            if (pplID == -1) {
              break;
            }
          }
        }

        for (String s : mt.getCasts()) {
          pplID = SelectHelper.getPeopleID(s, con);
          if (pplID == -1) {
            // author not exist
            // add new author
            pplID = InserterHelper.insertNewPeople(s, con);
            if (pplID == -1) {
              break;
            }
          }
        }

        pplID = SelectHelper.getPeopleID(producer, con);
        if (pplID == -1) {
          // producer not exist
          // add new producer
          pplID = InserterHelper.insertNewPeople(producer, con);
          if (pplID == -1) {
            System.out
                .println("The producer name " + producer + " is not in a correct format. will not add to database.");
          }
        }

        // update the hashmap to storing the id of musicpeoples
        Map<String, Integer> musicpeopleid = new HashMap<String, Integer>();
        musicpeopleid = mt.getCastIDHashMap(con);

        // insert only if that piece of soundtrack is not in db
        // insert into Music table
        InserterHelper.insertAlbum(albumName, year, mt.getMusicName(), mt.getLanguage(), mt.getType(), producer, con);
        // insert into MusicSinger
        // only add at most 2 singers for each song
        for (int sid : mt.getSingerIDHashMap(con).values()) {
          // add the people is exist in peopleInvolved
          InserterHelper.insertMusicSinger(albumName, year, mt.getMusicName(), sid, con);
        }
        // insert into PeopleInvolvedMusic
        // check the role for each people

        Map<String, Integer> temprole = new HashMap<String, Integer>();
        // for each people, serach their roles in music
        for (int ppl : musicpeopleid.values()) {
          // check if this people is inserted already
          if (!SelectHelper.checkMusicCastExist(albumName, year, mt.getMusicName(), ppl, con)) {
            for (String role : musicpeopleid.keySet()) {
              if (musicpeopleid.get(role).equals(ppl)) {
                temprole.put(role, ppl);
              }
            }
            // insert
            int sw = 0, c = 0, a = 0;
            if (temprole.containsKey("songWriter")) {
              sw = 1;
            }
            if (temprole.containsKey("composer")) {
              c = 1;
            }
            if (temprole.containsKey("arranger")) {
              a = 1;
            }
            // insert
            InserterHelper.insertMusicPeopleInvolved(albumName, year, mt.getMusicName(), ppl, sw, c, a, con);
            // reset the hashmap
            temprole.clear();
            sw = 0;
            c = 0;
            a = 0;
          }
        }
      }
      con.commit();
      return true;
    } catch (SQLException e) {
      System.out.println("something wrong when inserting.");
      System.out.println("Rolling back here...");
      e.printStackTrace();
      try {
        con.rollback();
      } catch (SQLException e1) {
        e1.printStackTrace();
      }
    } finally {
      try {
        con.setAutoCommit(true);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return false;
  }

  /* --- Data->update-> add one musictrack --- */
  public static void insertOneMusicTrack(String musicName, Album album, MusicTrack mt, Connection con) {
    try {
      con.setAutoCommit(false);
      int id = -1;
      // insert music track
      InserterHelper.insertAlbum(album.getAlbumName(), album.getYear(), musicName, mt.getLanguage(), mt.getType(), album.getProducer(), con);
      // insert singers
      id = SelectHelper.getPeopleID(mt.getSinger1(), con);
      if (id < 0) {
        id = InserterHelper.insertNewPeople(mt.getSinger1(), con);
        if (id < 0) {
          throw new SQLException();
        }
      }
      InserterHelper.insertMusicSinger(album.getAlbumName(), album.getYear(), musicName, id, con);
      if (mt.getSinger2() != null) {
        id = SelectHelper.getPeopleID(mt.getSinger2(), con);
        if (id < 0) {
          id = InserterHelper.insertNewPeople(mt.getSinger2(), con);
          if (id < 0) {
            throw new SQLException();
          }
        }
        InserterHelper.insertMusicSinger(album.getAlbumName(), album.getYear(), musicName, id, con);
      }

      // insert crews
      // InserterHelper.insertMusicPeopleInvolved(albumName, year, musicName, ppl, sw,
      // c, a);

      Map<String, Integer> musicpeopleid = new HashMap<String, Integer>();
      musicpeopleid = mt.getCastIDHashMap(con);

      // insert into PeopleInvolvedMusic
      // check the role for each people

      Map<String, Integer> temprole = new HashMap<String, Integer>();
      // for each people, serach their roles in music
      for (int ppl : musicpeopleid.values()) {
        // check if this people is inserted already
        if (!SelectHelper.checkMusicCastExist(album.getAlbumName(), album.getYear(), mt.getMusicName(), ppl, con)) {
          for (String role : musicpeopleid.keySet()) {
            if (musicpeopleid.get(role).equals(ppl)) {
              temprole.put(role, ppl);
            }
          }
          // insert
          int sw = 0, c = 0, a = 0;
          if (temprole.containsKey("songWriter")) {
            sw = 1;
          }
          if (temprole.containsKey("composer")) {
            c = 1;
          }
          if (temprole.containsKey("arranger")) {
            a = 1;
          }
          // insert
          InserterHelper.insertMusicPeopleInvolved(album.getAlbumName(), album.getYear(), mt.getMusicName(), ppl, sw, c, a, con);
          // reset the hashmap
          temprole.clear();
          sw = 0;
          c = 0;
          a = 0;
        }
      }

    } catch (SQLException e) {
      try {
        con.rollback();
      } catch (SQLException e1) {
        e1.printStackTrace();
      }
      System.out.println("rollback ...");
      e.printStackTrace();
    } finally {
      try {
        con.setAutoCommit(true);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

  }

  public static boolean insertOneCrewMember(Movie mv, MovieCrew mc, Connection con) {
    int id = -1;
    try {
      con.setAutoCommit(false);
      // check if the people involved exist, insert if not
      id = SelectHelper.getPeopleID(mc.getCrewName(), con);
      if (id < 0) {
        id = InserterHelper.insertNewPeople(mc.getCrewName(), con);
        if (id < 0) {
          throw new SQLException();
        }
      }
      // insert crew into crewMember
      InserterHelper.insertCrewMember(mv.getMovieName(), mv.getYear(), mc, con);
      // insert award
      InserterHelper.insertAward(mv.getMovieName(), mv.getYear(), mc, con);
      con.commit();
      return true;
    } catch (SQLException e) {
      try {
        con.rollback();
        System.out.println("all crew roles should have at least one valid input");
        System.out.println("Rolling back data...");
      } catch (SQLException e1) {
        e1.printStackTrace();
      }
      e.printStackTrace();
    } finally {
      try {
        con.setAutoCommit(true);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return false;
  }

  /* --- Data->insert->Movie --- */
  public static boolean insertMovieTransaction(String movieName, int movieYear, Map<String, List<MovieCrew>> crews, Connection con) {
    try {
      con.setAutoCommit(false);
      // check if the people involved exist, insert if not
      for (List<MovieCrew> list : crews.values()) {
        for (MovieCrew crew : list) {
          if (SelectHelper.getPeopleID(crew.getCrewName(), con) < 0) {
            InserterHelper.insertNewPeople(crew, con);
          }
        }
      }
      // insert movie
      InserterHelper.insertMovie(movieName, movieYear, con);
      // insert crew into crewMember
      InserterHelper.insertCrewMember(movieName, movieYear, crews, con);
      // insert award
      InserterHelper.insertAward(movieName, movieYear, crews, con);
      con.commit();
      return true;
    } catch (SQLException e) {
      try {
        con.rollback();
        System.out.println("all crew roles should have at least one valid input");
        System.out.println("Rolling back data...");
      } catch (SQLException e1) {
        e1.printStackTrace();
      }
      e.printStackTrace();
    } finally {
      try {
        con.setAutoCommit(true);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return false;
  }

  /* --- Data->remove->book --- */
  public static void deleteBookTransaction(String bookTitle, Connection con) {
    try {
      con.setAutoCommit(false);
      String isbn = SelectHelper.getBookIsbn(bookTitle, con);
      DeleteHelper.removeBookKeyword(isbn, con);
      DeleteHelper.removeBookAuthor(isbn, con);
      DeleteHelper.removeBook(isbn, con);
      con.commit();
    } catch (SQLException e) {
      System.out.println("something wrong");
      System.out.println("rolling back now ...");
      try {
        con.rollback();
      } catch (SQLException e1) {
        e1.printStackTrace();
      }
    } finally {
      try {
        con.setAutoCommit(true);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  /* --- Data->remove->album/music --- */ /* --- Data->update->album/music --- */
  public static void deleteMusicTransaction(String albumName, String musicName, Connection con) {
    try {
      con.setAutoCommit(false);
      DeleteHelper.removeMusicSingers(albumName, musicName, null);
      DeleteHelper.removeMusicPeopleInvolved(albumName, musicName, con);
      DeleteHelper.removeMusic(albumName, musicName, con);
      con.commit();
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("something wrong");
      System.out.println("rolling back now ...");
      try {
        con.rollback();
      } catch (SQLException e1) {
        e1.printStackTrace();
      }
    } finally {
      try {
        con.setAutoCommit(true);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  /* --- Data->remove->album --- */
  public static void deleteAlbumTransaction(String albumName, Connection con) {
    try {
      con.setAutoCommit(false);
      // search all music in that album
      ResultSet rs = SelectHelper.getAlbumMusics(albumName, con);
      String musicName = "";
      while (rs.next()) {
        musicName = rs.getString("MusicName");
        DeleteHelper.removeMusicSingers(albumName, musicName, con);
        DeleteHelper.removeMusicPeopleInvolved(albumName, musicName, con);
        DeleteHelper.removeMusic(albumName, musicName, con);
      }
      con.commit();
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("something wrong");
      System.out.println("rolling back now ...");
      try {
        con.rollback();
      } catch (SQLException e1) {
        e1.printStackTrace();
      }
    } finally {
      try {
        con.setAutoCommit(true);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  /* --- Data->remove->movie --- */
  public static void deleteMovieTransaction(String movieName, Connection con) {
    try {
      con.setAutoCommit(false);
      DeleteHelper.removeMovieAward(movieName, con);
      DeleteHelper.removeMovieCrew(movieName, con);
      DeleteHelper.removeMovie(movieName, con);
      con.commit();
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("something wrong");
      System.out.println("rolling back now ...");
      try {
        con.rollback();
      } catch (SQLException e1) {
        e1.printStackTrace();
      }
    } finally {
      try {
        con.setAutoCommit(true);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}
