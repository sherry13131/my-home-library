package com.mylibrary.object;

import java.util.HashMap;
import java.util.Map;

public class Album {
  private String albumName, producer;
  private int year;
  private Map<String, MusicTrack> tracks = new HashMap<String, MusicTrack>();

  public Album(String albumName, String producer, int year, Map<String, MusicTrack> tracks) {
    this.albumName = albumName;
    this.producer = producer;
    this.year = year;
    this.tracks = tracks;
  }

  public String toString() {
    return (this.albumName + " " + String.valueOf(this.year));
  }

  public String getAlbumName() {
    return this.albumName;
  }

  public int getYear() {
    return this.year;
  }

  public boolean compareAlbumName(String newAlbum) {
    if (this.albumName.equalsIgnoreCase(newAlbum)) {
      return true;
    }
    return false;
  }

  public boolean compareProducer(String newProducer) {
    if (this.getProducer().equalsIgnoreCase(newProducer)) {
      return true;
    }
    return false;
  }

  public boolean compareYear(int year) {
    if (this.year == year) {
      return true;
    }
    return false;
  }

  public boolean compareTracks(Map<String, MusicTrack> newTracks) {
    boolean same = true;
    for (String trackName : tracks.keySet()) {
      if (newTracks.get(trackName) != null) {
        // compare the music tracks
        same = this.tracks.get(trackName).compareTwoMusicTracks(newTracks.get(trackName));
        if (!same) {
          break;
        }
      }
    }
    return same;
  }

  /**
   * @return the producer
   */
  public String getProducer() {
    return this.producer;
  }

}
