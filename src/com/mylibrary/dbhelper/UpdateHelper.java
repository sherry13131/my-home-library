package com.mylibrary.dbhelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.assignment.gui.MainFrame.Album;
import com.assignment.gui.MainFrame.diskType;

public class UpdateHelper {

  /* --- Data->update->book --- */
  public static void updateBookString(String data, String isbn, String type, Connection con) throws SQLException {
    String sql = "Update Book set " + type + " = ? where isbn = ?;";
    PreparedStatement ps;
    ps = con.prepareStatement(sql);
    ps.setString(1, data);
    ps.setString(2, isbn);
    ps.executeUpdate();
  }
  
  /* --- Data->update->movie --- */
  public static void updateMovieInfo(String oldName, String newName, int year, Connection con) throws SQLException {
    String sql = "Update movie set moviename = ?, year = ? where moviename = ?;";
    PreparedStatement ps;
    ps = con.prepareStatement(sql);
    ps.setString(1, newName);
    ps.setInt(2, year);
    ps.setString(3, oldName);
    ps.executeUpdate();
  }

  /* --- Data->update->book --- */
  public static void updateBookInt(int data, String isbn, String type, Connection con) throws SQLException {
    String sql = "Update Book set " + type + " = ? where isbn = ?;";
    PreparedStatement ps;
    ps = con.prepareStatement(sql);
    if (data == -1) {
      ps.setNull(1, java.sql.Types.NULL);
    } else {
      ps.setInt(1, data);
    }
    ps.setString(2, isbn);
    ps.executeUpdate();
  }

  /* --- Data->update->book --- */
  public static void updateBookAuthor(String oldauthor, String author, String isbn, Connection con) throws SQLException {
    String sql = "Update bookauthor set author_id = ? where isbn = ? and author_id = ?;";
    int oldid = -1, newid = -1;
    PreparedStatement ps;

    ps = con.prepareStatement(sql);
    ps.setInt(1, newid);
    ps.setString(2, isbn);
    ps.setInt(3, oldid);
    ps.executeUpdate();

  }

  /* --- Data->update->album --- */
  public static void updateMusicTrackString(String newdata, String musicName, String category, Connection con) throws SQLException {
    // use for musicname and language
    String sql = "Update music set " + " " + category + " = ? where musicName = ?;";
    PreparedStatement ps;

    ps = con.prepareStatement(sql);
    ps.setString(1, newdata);
    ps.setString(2, musicName);
    ps.executeUpdate();
  }

  /* --- Data->update->album --- */
  // use when music people already in that music track
  public static void updateMusicTrackCrewOn(String newdata, String musicName, String albumName, String role, Connection con)
      throws SQLException {
    String sql = "Update peopleinvolvedmusic set " + role
        + " = 1 where peopleinvolved_id = ? and albumname = ? and musicname = ?;";
    PreparedStatement ps;
    int id = SelectHelper.getPeopleID(newdata, con);
    ps = con.prepareStatement(sql);
    ps.setInt(1, id);
    ps.setString(2, albumName);
    ps.setString(3, musicName);
    ps.executeUpdate();
  }

  /* --- Data->update->album --- */
  public static void updateMusicTrackCrewOff(String newdata, String musicName, String albumName, String role, Connection con)
      throws SQLException {
    String sql = "Update peopleinvolvedmusic set " + role
        + " = 0 where peopleinvolved_id = ? and albumname = ? and musicname = ?;";
    PreparedStatement ps;
    int id = SelectHelper.getPeopleID(newdata, con);
    ps = con.prepareStatement(sql);
    ps.setInt(1, id);
    ps.setString(2, albumName);
    ps.setString(3, musicName);
    ps.executeUpdate();
  }

  /* --- Data->update->album --- */
  public static void updateAllMusicName(String oldMusicName, String musicName, String lang, diskType t, Album album, Connection con)
      throws SQLException {
    String albumName = album.getAlbumName();
    // insert the new music track
    InserterHelper.insertAlbum(albumName, album.getYear(), musicName, lang, t, album.getProducer(), con);
    // update other
    UpdateHelper.updateMusicNameSinger(oldMusicName, musicName, albumName, con);
    UpdateHelper.updateMusicNamePeople(oldMusicName, musicName, albumName, con);
    // delete the old music track
    DeleteHelper.removeMusic(albumName, oldMusicName, con);
  }

  /* --- Data->update->album --- */
  public static void updateMusicNameSinger(String oldMusicName, String musicName, String albumName, Connection con)
      throws SQLException {
    String sql = "update musicsinger set musicName = ? where albumName = ? and musicName = ?;";
    PreparedStatement ps;
    ps = con.prepareStatement(sql);
    ps.setString(1, musicName);
    ps.setString(2, albumName);
    ps.setString(3, oldMusicName);
    ps.executeUpdate();
  }

  /* --- Data->update->album --- */
  public static void updateMusicNamePeople(String oldMusicName, String musicName, String albumName, Connection con)
      throws SQLException {
    String sql = "update peopleinvolvedmusic set musicName = ? where albumName = ? and musicName = ?;";
    PreparedStatement ps;
    ps = con.prepareStatement(sql);
    ps.setString(1, musicName);
    ps.setString(2, albumName);
    ps.setString(3, oldMusicName);
    ps.executeUpdate();
  }

  /* --- Data->update->album --- */
  public static void updateMusicProducer(String albumName, String producer, Connection con) throws SQLException {
    String sql = "update music set producer_id = ? where albumName = ?";
    int id = SelectHelper.getPeopleID(producer, con);
    if (id < 0) {
      id = InserterHelper.insertNewPeople(producer, con);
      if (id < 0) {
        throw new SQLException();
      }
    }
    PreparedStatement ps;
    ps = con.prepareStatement(sql);
    ps.setInt(1, id);
    ps.setString(2, albumName);
    ps.executeUpdate();
  }

  /* --- Data->update->album --- */
  public static void updateAlbumNameSinger(String oldAlbumName, int oldYear, String newName, int newYear,
      String musicName, Connection con) throws SQLException {
    String sql = "update musicsinger set albumname = ?, year = ? where albumname = ? and year = ? and musicname = ?";
    PreparedStatement ps;
    ps = con.prepareStatement(sql);
    ps.setString(1, newName);
    ps.setInt(2, newYear);
    ps.setString(3, oldAlbumName);
    ps.setInt(4, oldYear);
    ps.setString(5, musicName);
    ps.executeUpdate();
  }

  /* --- Data->update->album --- */
  public static void updateAlbumNameCrew(String oldAlbumName, int oldYear, String newName, int newYear,
      String musicName, Connection con) throws SQLException {
    String sql = "update peopleinvolvedmusic set albumname = ?, year = ? where albumname = ? and year = ? and musicname = ?";
    PreparedStatement ps;
    ps = con.prepareStatement(sql);
    ps.setString(1, newName);
    ps.setInt(2, newYear);
    ps.setString(3, oldAlbumName);
    ps.setInt(4, oldYear);
    ps.setString(5, musicName);
    ps.executeUpdate();
  }
}
