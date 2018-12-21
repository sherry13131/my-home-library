package com.mylibrary.databasehelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.mylibrary.object.Album;
import com.mylibrary.object.MusicTrack;

public class DeleteHelper {

  /* --- Data->update->book --- */
  public static void deleteOneBookAuthor(String isbn, String author, Connection con) throws SQLException {
    int id = -1;
    String sql = "delete from BookAuthor where isbn = ? and author_id = ?;";
    PreparedStatement preparedStatement;
    preparedStatement = con.prepareStatement(sql);
    preparedStatement.setString(1, isbn);
    id = SelectHelper.getPeopleID(author, con);
    if (id > 0) {
      preparedStatement.setInt(2, id);
      preparedStatement.executeUpdate();
    }
  }

  /* --- Data->delete->book --- */
  public static void deleteBookAuthors(String isbn, List<String> authors, Connection con) throws SQLException {
    int id = -1;
    String sql = "delete from BookAuthor where isbn = ? and author_id = ?;";
    PreparedStatement preparedStatement;
    preparedStatement = con.prepareStatement(sql);
    preparedStatement.setString(1, isbn);
    for (String author : authors) {
      id = SelectHelper.getPeopleID(author, con);
      if (id > 0) {
        preparedStatement.setInt(2, id);
        preparedStatement.executeUpdate();
      }
    }
  }

  /* --- Data->delete->book --- */
  public static void deleteBookKeywords(String isbn, List<String> keywords, Connection con) throws SQLException {
    int id = -1;
    String sql = "delete from BookKeyword where isbn = ? and keyword_id = ?;";
    PreparedStatement preparedStatement;
    preparedStatement = con.prepareStatement(sql);
    preparedStatement.setString(1, isbn);
    for (String key : keywords) {
      id = SelectHelper.getKeywordID(key, con);
      if (id > 0) {
        preparedStatement.setInt(2, id);
        preparedStatement.executeUpdate();
      }
    }
  }

  /* --- Data->delete->book --- */
  public static void removeBook(String isbn, Connection con) throws SQLException {
    String sql = "delete from book where isbn = ?;";
    PreparedStatement preparedStatement;
    preparedStatement = con.prepareStatement(sql);
    preparedStatement.setString(1, isbn);
    preparedStatement.executeUpdate();
  }

  /* --- Data->delete->book --- */
  public static void removeBookKeyword(String isbn, Connection con) throws SQLException {
    String sql = "delete from bookkeyword where isbn = ?;";
    PreparedStatement preparedStatement;
    preparedStatement = con.prepareStatement(sql);
    preparedStatement.setString(1, isbn);
    preparedStatement.executeUpdate();
  }

  /* --- Data->delete->book --- */
  public static void removeBookAuthor(String isbn, Connection con) throws SQLException {
    String sql = "delete from BookAuthor where isbn = ?;";
    PreparedStatement preparedStatement;
    preparedStatement = con.prepareStatement(sql);
    preparedStatement.setString(1, isbn);
    preparedStatement.executeUpdate();
  }

  /* --- Data->delete->album --- */
  public static void removeMusic(String albumName, String musicName, Connection con) throws SQLException {
    String sql = "delete from Music where AlbumName = ? and MusicName = ?;";
    PreparedStatement preparedStatement;
    preparedStatement = con.prepareStatement(sql);
    preparedStatement.setString(1, albumName);
    preparedStatement.setString(2, musicName);
    preparedStatement.executeUpdate();
  }

  /* --- Data->delete->album --- */
  public static void removeMusicByYear(String albumName, int oldYear, String musicName, Connection con) throws SQLException {
    String sql = "delete from Music where AlbumName = ? and MusicName = ? and year = ?;";
    PreparedStatement preparedStatement;
    preparedStatement = con.prepareStatement(sql);
    preparedStatement.setString(1, albumName);
    preparedStatement.setString(2, musicName);
    preparedStatement.setInt(3, oldYear);
    preparedStatement.executeUpdate();
  }

  /* --- Data->delete->album --- */
  public static void removeMusicSingers(String albumName, String musicName, Connection con) throws SQLException {
    String sql = "delete from MusicSinger where AlbumName = ? and MusicName = ?;";
    PreparedStatement preparedStatement;
    preparedStatement = con.prepareStatement(sql);
    preparedStatement.setString(1, albumName);
    preparedStatement.setString(2, musicName);
    preparedStatement.executeUpdate();
  }

  /* --- Data->delete->album --- */
  public static void removeMusicSinger(String albumName, String musicName, String singer, Connection con) throws SQLException {
    String sql = "delete from musicsinger where albumname = ? and musicname = ? and peopleinvolved_id = ?;";
    PreparedStatement preparedStatement;
    preparedStatement = con.prepareStatement(sql);
    preparedStatement.setString(1, albumName);
    preparedStatement.setString(2, musicName);
    preparedStatement.setInt(3, SelectHelper.getPeopleID(singer, con));
    preparedStatement.executeUpdate();
  }

  /* --- Data->delete->album --- */
  public static void removeMusicPeopleInvolved(String albumName, String musicName, Connection con) throws SQLException {
    String sql = "delete from PeopleInvolvedMusic where AlbumName = ? and MusicName = ?;";
    PreparedStatement preparedStatement;
    preparedStatement = con.prepareStatement(sql);
    preparedStatement.setString(1, albumName);
    preparedStatement.setString(2, musicName);
    preparedStatement.executeUpdate();
  }

  /* --- Data->delete->album --- */
  public static void removeMusicPeopleInvolved(String albumName, String musicName, String name, Connection con) throws SQLException {
    String sql = "delete from PeopleInvolvedMusic where AlbumName = ? and MusicName = ? and peopleinvolved_id = ?;";
    int id = SelectHelper.getPeopleID(name, con);
    PreparedStatement preparedStatement;
    preparedStatement = con.prepareStatement(sql);
    preparedStatement.setString(1, albumName);
    preparedStatement.setString(2, musicName);
    preparedStatement.setInt(3, id);
    preparedStatement.executeUpdate();
  }

  /* --- Data->delete->album --- */
  public static void removeOneMusicTrack(Album album, MusicTrack mt, Connection con) throws SQLException {
    DeleteHelper.removeMusicSingers(album.getAlbumName(), mt.getMusicName(), con);
    DeleteHelper.removeMusicPeopleInvolved(album.getAlbumName(), mt.getMusicName(), con);
    DeleteHelper.removeMusic(album.getAlbumName(), mt.getMusicName(), con);
  }

  /* --- Data->delete->movie --- */
  public static void removeMovie(String movieName, Connection con) throws SQLException {
    String sql = "delete from Movie where movieName = ?;";
    PreparedStatement preparedStatement;
    preparedStatement = con.prepareStatement(sql);
    preparedStatement.setString(1, movieName);
    preparedStatement.executeUpdate();
  }

  /* --- Data->delete->movie --- */
  public static void removeMovieAward(String movieName, Connection con) throws SQLException {
    String sql = "delete from Award where movieName = ?;";
    PreparedStatement preparedStatement;
    preparedStatement = con.prepareStatement(sql);
    preparedStatement.setString(1, movieName);
    preparedStatement.executeUpdate();
  }

  /* --- Data->delete->movie --- */
  public static void removeMovieCrew(String movieName, Connection con) throws SQLException {
    String sql = "delete from CrewMember where movieName = ?;";
    PreparedStatement preparedStatement;
    preparedStatement = con.prepareStatement(sql);
    preparedStatement.setString(1, movieName);
    preparedStatement.executeUpdate();
  }
}
