package com.mylibrary.object;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.assignment.gui.diskType;
import com.mylibrary.databasehelper.SelectHelper;

public class MusicTrack {
  private String musicName, language, singer1, singer2, songWriter, composer, arranger, typeString;
  private diskType type;

  public MusicTrack(String musicName, String language, diskType typet, String singer1, String singer2,
      String songWriter, String composer, String arranger) {
    this.musicName = musicName;
    this.language = language;
    this.type = typet;
    if (typet.getString().equalsIgnoreCase("audioCD")) {
      this.typeString = "audioCD";
    } else {
      this.typeString = "vinyl";
    }
    this.singer1 = singer1;
    this.singer2 = singer2;
    this.songWriter = songWriter;
    this.composer = composer;
    this.arranger = arranger;
  }

  public MusicTrack get() {
    return this;
  }

  public void setMusicName(String name) {
    this.musicName = name;
  }

  public void setLanguage(String lang) {
    this.language = lang;
  }

  public void setType(diskType t) {
    this.type = t;
  }

  public void setSingers(String s1, String s2) {
    this.singer1 = s1;
    this.singer2 = s2;
  }

  public void setComposer(String comp) {
    this.composer = comp;
  }

  public void setArranger(String arr) {
    this.arranger = arr;
  }

  public void setSongWriter(String sw) {
    this.songWriter = sw;
  }

  @Override
  public String toString() {
    return (this.musicName + "\n");
  }

  public String getMusicName() {
    return this.musicName;
  }

  public String getLanguage() {
    return this.language;
  }

  public diskType getType() {
    return this.type;
  }

  public String getTypeString() {
    return this.typeString;
  }

  public List<String> getSingers() {
    List<String> singers = new ArrayList<String>();
    singers.add(this.getSinger1());
    if (getSinger2() != null) {
      singers.add(this.getSinger2());
    }
    return singers;
  }

  public Set<String> getSingersSet() {
    Set<String> singers = new HashSet<String>();
    singers.add(this.getSinger1());
    if (getSinger2() != null) {
      singers.add(this.getSinger2());
    }
    return singers;
  }

  public String getSongWriter() {
    return this.songWriter;
  }

  public String getComposer() {
    return this.composer;
  }

  public String getArranger() {
    return this.arranger;
  }

  public List<String> getCasts() {
    List<String> casts = new ArrayList<String>();
    casts.add(this.songWriter);
    casts.add(this.composer);
    casts.add(this.arranger);
    return casts;
  }

  public Map<String, Integer> getSingerIDHashMap(Connection con) {
    Map<String, Integer> singerids = new HashMap<String, Integer>();
    singerids.put("singer1", SelectHelper.getPeopleID(this.getSinger1(), con));
    if (getSinger2() != null) {
      singerids.put("singer2", SelectHelper.getPeopleID(this.getSinger2(), con));
    }
    return singerids;
  }

  public Map<String, Integer> getCastIDHashMap(Connection con) {
    Map<String, Integer> musicpeopleid = new HashMap<String, Integer>();
    musicpeopleid.put("songWriter", SelectHelper.getPeopleID(this.songWriter, con));
    musicpeopleid.put("composer", SelectHelper.getPeopleID(this.composer, con));
    musicpeopleid.put("arranger", SelectHelper.getPeopleID(this.arranger, con));
    return musicpeopleid;
  }

  public boolean compareMusicName(String newMusicName) {
    if (this.musicName.equalsIgnoreCase(newMusicName)) {
      return true;
    }
    return false;
  }

  public boolean compareLanguage(String newLangeuage) {
    if (this.language.equalsIgnoreCase(newLangeuage)) {
      return true;
    }
    return false;
  }

  public boolean compareType(diskType newType) {
    if (this.type.compareTo(newType) == 0) {
      return true;
    }
    return false;
  }

  public boolean compareSingers(Set<String> singers) {
    Set<String> singerSet = new HashSet<String>();
    singerSet.add(this.getSinger1());
    if (this.getSinger2() != null) {
      singerSet.add(this.getSinger2());
    }
    return singerSet.equals(singers);
  }

  public boolean compareSongWriter(String newSongWriter) {
    if (this.songWriter.equalsIgnoreCase(newSongWriter)) {
      return true;
    }
    return false;
  }

  public boolean compareComposer(String newComposer) {
    if (this.composer.equalsIgnoreCase(newComposer)) {
      return true;
    }
    return false;
  }

  public boolean compareArranger(String newArranger) {
    if (this.arranger.equalsIgnoreCase(newArranger)) {
      return true;
    }
    return false;
  }

  public boolean compareTwoMusicTracks(MusicTrack otherTrack) {
    boolean success = true;
    success = success && this.compareMusicName(otherTrack.getMusicName());
    success = success && this.compareLanguage(otherTrack.getLanguage());
    success = success && this.compareType(otherTrack.getType());
    success = success && this.compareSingers(otherTrack.getSingersSet());
    success = success && this.compareArranger(otherTrack.getArranger());
    success = success && this.compareComposer(otherTrack.getComposer());
    success = success && this.compareSongWriter(otherTrack.getSongWriter());
    return success;
  }

  /**
   * @return the singer1
   */
  public String getSinger1() {
    return singer1;
  }

  /**
   * @return the singer2
   */
  public String getSinger2() {
    return singer2;
  }

}
