package com.mylibrary.createframe;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.assignment.gui.diskType;
import com.mylibrary.createhelper.TransactionHelper;
import com.mylibrary.createhelper.checkHelper;
import com.mylibrary.databasehelper.DeleteHelper;
import com.mylibrary.databasehelper.InserterHelper;
import com.mylibrary.databasehelper.UpdateHelper;
import com.mylibrary.object.MusicTrack;

public class CreateFrameMusicTrack {

    private JTextField insSingerTx2;
    private JTextField insMusicTx;
    private JTextField insLangTx;
    private JTextField insSongWriterTx;
    private JTextField insComposerTx;
    private JTextField insArrangerTx;
    private JTextField insSingerTx1;
    private ButtonGroup diskTypeTx;

    private ButtonModel model_cd;
    private ButtonModel model_vinyl;

    /**
     * for inserting a new music track, click throught the add music track button
     * 
     * @param musicTracks
     * @param update      (true if from update page, false if from insert page)
     */
    public CreateFrameMusicTrack(List<MusicTrack> musicTracks, boolean update) {
      JFrame frame = new JFrame("Test");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      } catch (Exception e) {
        e.printStackTrace();
      }
      JPanel AddMusicTrackPanel = new JPanel();
      AddMusicTrackPanel.setOpaque(true);

      JButton button_3 = new JButton("Submit");
      button_3.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          String musicName = null, lang = null, arranger = null, composer = null, songWriter = null, singer1 = null,
              singer2 = null;
          boolean valid = true;

          // check all fields are filled in or not
          if (insMusicTx.getText().equals("") || insLangTx.getText().equals("") || insArrangerTx.getText().equals("")
              || insComposerTx.getText().equals("") || insSongWriterTx.getText().equals("")
              || insSingerTx1.getText().equals("")) {
            // show error - mandatory fields
            JOptionPane.showMessageDialog(null, "fill in all mandatory fields and in correct format",
                "Insert music - wrong format", JOptionPane.ERROR_MESSAGE);
          } else {
            // get the string values
            musicName = insMusicTx.getText();
            lang = insLangTx.getText();
            arranger = insArrangerTx.getText();
            composer = insComposerTx.getText();
            songWriter = insSongWriterTx.getText();
            singer1 = insSingerTx1.getText();
            if (!insSingerTx2.getText().equals("")) {
              singer2 = insSingerTx2.getText();
              valid = (checkHelper.checkNameFormat(singer1) && checkHelper.checkNameFormat(singer2));
              if (singer2.equals(singer1)) {
                valid = false;
              }
            } else {
              valid = checkHelper.checkNameFormat(singer1);
            }

            // musicpeoples: key - roleTitle, value - peopleName
            Map<String, String> musicpeoples = new HashMap<String, String>();
            musicpeoples.put("songWriter", songWriter);
            musicpeoples.put("composer", composer);
            musicpeoples.put("arranger", arranger);

            // check if the names are valid name
            for (String name : musicpeoples.values()) {
              if (!checkHelper.checkNameFormat(name)) {
                valid = false;
                break;
              }
            }

            // get diskType
            boolean typeBool = false;
            if (diskTypeTx.getSelection().getActionCommand().equalsIgnoreCase("vinyl")) {
              typeBool = true;
            }
            if (update) {
              // check if this music name appears in the model
              if (model.contains(musicName)) {
                JOptionPane.showMessageDialog(null, "Music track name already entered",
                    "Insert music - duplicated music name", JOptionPane.ERROR_MESSAGE);
                valid = false;
              }
            } else {
              // check if the music track name already exist in the list
              for (MusicTrack mutrack : musicTracks) {
                String mName = mutrack.getMusicName();
                if (mName.equalsIgnoreCase(musicName)) {
                  JOptionPane.showMessageDialog(null, "Music track name already entered",
                      "Insert music - duplicated music name", JOptionPane.ERROR_MESSAGE);
                  valid = false;
                  break;
                }
              }
            }

            if (valid) {
              // store as music track
              MusicTrack mt = new MusicTrack(musicName, lang, ((typeBool) ? diskType.VINYL : diskType.AUDIOCD), singer1,
                  singer2, songWriter, composer, arranger);
              if (update) {
                // insert new music track
                TransactionHelper.insertOneMusicTrack(musicName, oldAlbum, mt);
                model.addElement(musicName);
                tracks.put(musicName, mt);
              } else {
                musicTracks.add(mt);
              }
              JOptionPane.showMessageDialog(null, "submitted", "Insert music - submitted",
                  JOptionPane.INFORMATION_MESSAGE);
              clearInsertMusicTrack();
            }
          }

        }
      });

      JButton button_9 = new JButton("Cancel");
      button_9.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          clearInsertMusicTrack();
        }
      });

      JLabel label_2 = new JLabel("Singer 2:");

      insSingerTx2 = new JTextField();
      insSingerTx2.setColumns(10);

      JLabel label_4 = new JLabel("Music name:");

      insMusicTx = new JTextField();
      insMusicTx.setColumns(10);

      JLabel label_5 = new JLabel("language:");

      insLangTx = new JTextField();
      insLangTx.setColumns(10);

      JLabel label_39 = new JLabel("Disk type:");

      JRadioButton radioButton_cd = new JRadioButton("audioCD");
      radioButton_cd.setSelected(true);
      radioButton_cd.setActionCommand("audioCD");

      JRadioButton radioButton_vinyl = new JRadioButton("vinyl");
      radioButton_vinyl.setActionCommand("vinyl");

      model_cd = radioButton_cd.getModel();
      model_vinyl = radioButton_vinyl.getModel();
      diskTypeTx = new ButtonGroup();
      diskTypeTx.add(radioButton_cd);
      diskTypeTx.add(radioButton_vinyl);

      JLabel label_41 = new JLabel("Song writer:");

      insSongWriterTx = new JTextField();
      insSongWriterTx.setColumns(10);

      JLabel label_42 = new JLabel("Composer:");

      insComposerTx = new JTextField();
      insComposerTx.setColumns(10);

      JLabel label_47 = new JLabel("Singer 1:");

      JLabel label_48 = new JLabel("Arranger:");

      insArrangerTx = new JTextField();
      insArrangerTx.setColumns(10);

      insSingerTx1 = new JTextField();
      insSingerTx1.setColumns(10);
      GroupLayout gl_AddMusicTrackPanel = new GroupLayout(AddMusicTrackPanel);
      gl_AddMusicTrackPanel.setHorizontalGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING)
          .addGroup(gl_AddMusicTrackPanel.createSequentialGroup().addGap(149).addGroup(gl_AddMusicTrackPanel
              .createParallelGroup(Alignment.LEADING, false).addGroup(gl_AddMusicTrackPanel
                  .createParallelGroup(Alignment.TRAILING).addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
                      .addComponent(button_3, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE).addGap(18)
                      .addComponent(button_9, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
                  .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING, false)
                      .addGroup(gl_AddMusicTrackPanel.createSequentialGroup().addComponent(label_2)
                          .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                          .addComponent(insSingerTx2, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE))
                      .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
                          .addComponent(label_41, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE).addGap(23)
                          .addComponent(insSongWriterTx, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE))
                      .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
                          .addComponent(label_42, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE).addGap(32)
                          .addComponent(insComposerTx, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE))
                      .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
                          .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.TRAILING, false)
                              .addComponent(label_47, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                  Short.MAX_VALUE)
                              .addComponent(label_48))
                          .addGap(39).addGroup(
                              gl_AddMusicTrackPanel.createParallelGroup(Alignment.TRAILING)
                                  .addComponent(insArrangerTx, GroupLayout.PREFERRED_SIZE, 298,
                                      GroupLayout.PREFERRED_SIZE)
                                  .addComponent(insSingerTx1, GroupLayout.PREFERRED_SIZE, 298,
                                      GroupLayout.PREFERRED_SIZE)))))
              .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
                  .addComponent(label_4, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE).addGap(22)
                  .addComponent(insMusicTx))
              .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
                  .addComponent(label_5, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE).addGap(38)
                  .addComponent(insLangTx, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE))
              .addGroup(gl_AddMusicTrackPanel.createSequentialGroup().addComponent(label_39).addGap(39)
                  .addComponent(radioButton_cd, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE).addGap(64)
                  .addComponent(radioButton_vinyl, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)))
              .addContainerGap(566, Short.MAX_VALUE)));
      gl_AddMusicTrackPanel
          .setVerticalGroup(
              gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING)
                  .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
                      .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING)
                          .addGroup(gl_AddMusicTrackPanel.createSequentialGroup().addGap(60).addComponent(label_4))
                          .addGroup(gl_AddMusicTrackPanel.createSequentialGroup().addGap(57).addComponent(insMusicTx,
                              GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                      .addGap(18)
                      .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING)
                          .addGroup(gl_AddMusicTrackPanel.createSequentialGroup().addGap(6).addComponent(label_5))
                          .addComponent(insLangTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                              GroupLayout.PREFERRED_SIZE))
                      .addGap(18)
                      .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING)
                          .addGroup(gl_AddMusicTrackPanel.createSequentialGroup().addGap(4).addComponent(label_39))
                          .addComponent(radioButton_cd).addComponent(radioButton_vinyl))
                      .addGap(18)
                      .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING)
                          .addGroup(gl_AddMusicTrackPanel.createSequentialGroup().addGap(3).addComponent(label_41))
                          .addComponent(insSongWriterTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                              GroupLayout.PREFERRED_SIZE))
                      .addGap(18)
                      .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING)
                          .addGroup(gl_AddMusicTrackPanel.createSequentialGroup().addGap(3).addComponent(label_42))
                          .addComponent(insComposerTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                              GroupLayout.PREFERRED_SIZE))
                      .addGap(18)
                      .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING)
                          .addGroup(gl_AddMusicTrackPanel.createSequentialGroup().addGap(3).addComponent(label_48))
                          .addComponent(insArrangerTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                              GroupLayout.PREFERRED_SIZE))
                      .addGap(18)
                      .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING)
                          .addComponent(insSingerTx1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                              GroupLayout.PREFERRED_SIZE)
                          .addGroup(gl_AddMusicTrackPanel.createSequentialGroup().addGap(3).addComponent(label_47)))
                      .addGap(18)
                      .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.BASELINE).addComponent(label_2)
                          .addComponent(insSingerTx2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                              GroupLayout.PREFERRED_SIZE))
                      .addGap(18).addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.BASELINE)
                          .addComponent(button_3).addComponent(button_9))
                      .addContainerGap(366, Short.MAX_VALUE)));
      AddMusicTrackPanel.setLayout(gl_AddMusicTrackPanel);

      frame.getContentPane().add(BorderLayout.CENTER, AddMusicTrackPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
      frame.setResizable(false);

    }

    /**
     * for update a musictrack (clicked through the JList)
     * 
     * @param oldmt
     */
    public CreateFrameMusicTrack(MusicTrack oldmt) {
      JFrame frame = new JFrame("Test");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      } catch (Exception e) {
        e.printStackTrace();
      }
      JPanel AddMusicTrackPanel = new JPanel();
      AddMusicTrackPanel.setOpaque(true);

      JButton button_3 = new JButton("Update");
      button_3.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          String musicName = null, lang = null, arranger = null, composer = null, songWriter = null, singer1 = null,
              singer2 = null;
          diskType type = diskType.AUDIOCD;
          Set<String> singerSet = new HashSet<String>();
          boolean valid = true;

          // check all fields are filled in or not
          if (insMusicTx.getText().equals("") || insLangTx.getText().equals("") || insArrangerTx.getText().equals("")
              || insComposerTx.getText().equals("") || insSongWriterTx.getText().equals("")
              || insSingerTx1.getText().equals("")) {
            // show error - mandatory fields
            JOptionPane.showMessageDialog(null, "fill in all mandatory fields and in correct format",
                "Insert music - wrong format", JOptionPane.ERROR_MESSAGE);
          } else {
            // get the string values
            musicName = insMusicTx.getText();
            lang = insLangTx.getText();
            arranger = insArrangerTx.getText();
            composer = insComposerTx.getText();
            songWriter = insSongWriterTx.getText();
            singer1 = insSingerTx1.getText();
            singerSet.add(singer1);
            if (!insSingerTx2.getText().equals("")) {
              singer2 = insSingerTx2.getText();
              singerSet.add(singer2);
              valid = (checkHelper.checkNameFormat(singer1) && checkHelper.checkNameFormat(singer2));
              if (singer2.equals(singer1)) {
                valid = false;
                singer2 = null;
              }
            } else {
              valid = checkHelper.checkNameFormat(singer1);
            }

            // musicpeoples: key - roleTitle, value - peopleName
            Map<String, String> musicpeoples = new HashMap<String, String>();
            musicpeoples.put("songWriter", songWriter);
            musicpeoples.put("composer", composer);
            musicpeoples.put("arranger", arranger);

            // check if the names are valid name
            for (String name : musicpeoples.values()) {
              if (!checkHelper.checkNameFormat(name)) {
                valid = false;
                break;
              }
            }

            // get diskType

            for (Enumeration<AbstractButton> buttons = diskTypeTx.getElements(); buttons.hasMoreElements();) {
              AbstractButton button = buttons.nextElement();
              if (button.isSelected()) {
                if (button.getText().equalsIgnoreCase("vinyl")) {
                  type = diskType.VINYL;
                }
              }
            }
            
            /* --- Data->update->album->music track --- */
            // if valid
            if (valid) {
              try {
                con.setAutoCommit(false);

                if (!oldmt.compareMusicName(musicName)) {
                  String oldMusicName = oldmt.getMusicName();
                  UpdateHelper.updateAllMusicName(oldMusicName, musicName, lang, type, oldAlbum);
                  oldmt.setMusicName(musicName);
                  model.addElement(musicName);
                  model.removeElement(oldMusicName);
                  tracks.put(musicName, oldmt);
                  tracks.remove(oldMusicName);
                }

                // check what fields are different and change values in object
                if (!oldmt.compareLanguage(lang)) {
                  // update lang
                  UpdateHelper.updateMusicTrackString(lang, musicName, "language");
                  oldmt.setLanguage(lang);
                }

                if (!oldmt.compareArranger(arranger)) {
                  // update arranger
                  // check old arranger
                  if (checkHelper.checkNumRoleMusic(oldAlbum.albumName, musicName, oldmt.getArranger()) == 1) {
                    // delete
                    DeleteHelper.removeMusicPeopleInvolved(oldAlbum.albumName, musicName, oldmt.getArranger());
                  } else {
                    // set off
                    UpdateHelper.updateMusicTrackCrewOff(oldmt.getArranger(), musicName, oldAlbum.albumName,
                        "isarranger");
                  }
                  // check new aranger
                  if (checkHelper.checkMusicCrewExist(oldAlbum.albumName, musicName, arranger)) {
                    // set on
                    UpdateHelper.updateMusicTrackCrewOn(arranger, musicName, oldAlbum.albumName, "isarranger");
                  } else {
                    // add musicCrew and set on
                    InserterHelper.insertMusicPeopleInvolved(oldAlbum.albumName, oldAlbum.year, musicName, arranger, 0,
                        0, 1);
                  }
                  oldmt.setArranger(arranger);
//                      UpdateHelper.updateMusicTrackCrew(arranger, musicName, oldAlbum.getAlbumName(), "isarranger");
                }
                if (!oldmt.compareComposer(composer)) {

                  // update composer
                  // check old composer
                  if (checkHelper.checkNumRoleMusic(oldAlbum.albumName, musicName, oldmt.getComposer()) == 1) {
                    // delete
                    DeleteHelper.removeMusicPeopleInvolved(oldAlbum.albumName, musicName, oldmt.getComposer());
                  } else {
                    // set off
                    UpdateHelper.updateMusicTrackCrewOff(oldmt.getComposer(), musicName, oldAlbum.albumName,
                        "iscomposer");
                  }
                  // check new composer
                  if (checkHelper.checkMusicCrewExist(oldAlbum.albumName, musicName, composer)) {
                    // set on
                    UpdateHelper.updateMusicTrackCrewOn(composer, musicName, oldAlbum.albumName, "iscomposer");
                  } else {
                    // add musicCrew and set on
                    InserterHelper.insertMusicPeopleInvolved(oldAlbum.albumName, oldAlbum.year, musicName, composer, 0,
                        1, 0);
                  }
                  oldmt.setComposer(composer);
//                      UpdateHelper.updateMusicTrackCrew(composer, musicName, oldAlbum.getAlbumName(), "iscomposer");
                }
                if (!oldmt.compareSongWriter(songWriter)) {

                  // update songWriter
                  // check old songWriter
                  if (checkHelper.checkNumRoleMusic(oldAlbum.albumName, musicName, oldmt.getSongWriter()) == 1) {
                    // delete
                    DeleteHelper.removeMusicPeopleInvolved(oldAlbum.albumName, musicName, oldmt.getSongWriter());
                  } else {
                    // set off
                    UpdateHelper.updateMusicTrackCrewOff(oldmt.getSongWriter(), musicName, oldAlbum.albumName,
                        "issongwriter");
                  }
                  // check new songWriter
                  if (checkHelper.checkMusicCrewExist(oldAlbum.albumName, musicName, songWriter)) {
                    // set on
                    UpdateHelper.updateMusicTrackCrewOn(songWriter, musicName, oldAlbum.albumName, "issongwriter");
                  } else {
                    // add musicCrew and set on
                    InserterHelper.insertMusicPeopleInvolved(oldAlbum.albumName, oldAlbum.year, musicName, songWriter,
                        1, 0, 0);
                  }
                  oldmt.setSongWriter(songWriter);
//                      UpdateHelper.updateMusicTrackCrew(songWriter, musicName, oldAlbum.getAlbumName(), "issongwriter");
                }

                if (!oldmt.compareSingers(singerSet)) {
                  List<String> dels = new ArrayList<String>();
                  // UpdateHelper.updateMusicTrackString(singerSet, String musicName, "singers");
                  if (!singerSet.contains(oldmt.getSinger1())) {
                    // remove old s1
                    dels.add(oldmt.getSinger1());
                  }
                  if (oldmt.getSinger2() != null && !singerSet.contains(oldmt.getSinger2())) {
                    // remove old s2
                    dels.add(oldmt.getSinger2());
                  }
                  for (String s : dels) {
                    DeleteHelper.removeMusicSinger(oldAlbum.albumName, musicName, s);
                  }
                  for (String s : singerSet) {
                    if ((!s.equalsIgnoreCase(oldmt.getSinger1())) && (!s.equalsIgnoreCase(oldmt.getSinger2()))) {
                      // insert new s
                      InserterHelper.insertMusicSinger(oldAlbum.albumName, oldAlbum.year, musicName, s);
                    }
                  }
                  oldmt.setSingers(singer1, singer2);
                }

                JOptionPane.showMessageDialog(null, "Successfully update all this music tracks information.",
                    "Update successfully", JOptionPane.INFORMATION_MESSAGE);
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
              } catch (SQLException e1) {
                try {
                  con.rollback();
                } catch (SQLException e2) {
                  e2.printStackTrace();
                }
                System.out.println("rollback here");
                e1.printStackTrace();
              } finally {
                try {
                  con.setAutoCommit(true);
                } catch (SQLException e1) {
                  e1.printStackTrace();
                }
              }
            }

          }

        }
      });

      JButton button_9 = new JButton("Cancel");
      button_9.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }
      });

      JLabel label_2 = new JLabel("Singer 2:");

      insSingerTx2 = new JTextField();
      insSingerTx2.setColumns(10);

      JLabel label_4 = new JLabel("Music name:");

      insMusicTx = new JTextField();
      insMusicTx.setColumns(10);

      JLabel label_5 = new JLabel("language:");

      insLangTx = new JTextField();
      insLangTx.setColumns(10);

      JLabel label_39 = new JLabel("Disk type:");

      JRadioButton radioButton_cd = new JRadioButton("audioCD");
      radioButton_cd.setSelected(true);
      radioButton_cd.setActionCommand("audioCD");

      JRadioButton radioButton_vinyl = new JRadioButton("vinyl");
      radioButton_vinyl.setActionCommand("vinyl");

      diskTypeTx = new ButtonGroup();
      diskTypeTx.add(radioButton_cd);
      diskTypeTx.add(radioButton_vinyl);

      model_cd = radioButton_cd.getModel();
      model_vinyl = radioButton_vinyl.getModel();

      JLabel label_41 = new JLabel("Song writer:");

      insSongWriterTx = new JTextField();
      insSongWriterTx.setColumns(10);

      JLabel label_42 = new JLabel("Composer:");

      insComposerTx = new JTextField();
      insComposerTx.setColumns(10);

      JLabel label_47 = new JLabel("Singer 1:");

      JLabel label_48 = new JLabel("Arranger:");

      insArrangerTx = new JTextField();
      insArrangerTx.setColumns(10);

      insSingerTx1 = new JTextField();
      insSingerTx1.setColumns(10);

      // set text fields
      insMusicTx.setText(oldmt.getMusicName());
      insLangTx.setText(oldmt.getLanguage());
      if (oldmt.getTypeString().equalsIgnoreCase(diskType.AUDIOCD.getString())) {
        diskTypeTx.setSelected(model_cd, true);
      } else {
        diskTypeTx.setSelected(model_vinyl, true);
      }
      insSongWriterTx.setText(oldmt.getSongWriter());
      insComposerTx.setText(oldmt.getComposer());
      insArrangerTx.setText(oldmt.getArranger());
      insSingerTx1.setText(oldmt.getSingers().get(0));
      if (oldmt.getSingers().size() == 2) {
        insSingerTx2.setText(oldmt.getSingers().get(1));
      }

      GroupLayout gl_AddMusicTrackPanel = new GroupLayout(AddMusicTrackPanel);
      gl_AddMusicTrackPanel.setHorizontalGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING)
          .addGroup(gl_AddMusicTrackPanel.createSequentialGroup().addGap(149).addGroup(gl_AddMusicTrackPanel
              .createParallelGroup(Alignment.LEADING, false).addGroup(gl_AddMusicTrackPanel
                  .createParallelGroup(Alignment.TRAILING).addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
                      .addComponent(button_3, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE).addGap(18)
                      .addComponent(button_9, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
                  .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING, false)
                      .addGroup(gl_AddMusicTrackPanel.createSequentialGroup().addComponent(label_2)
                          .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                          .addComponent(insSingerTx2, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE))
                      .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
                          .addComponent(label_41, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE).addGap(23)
                          .addComponent(insSongWriterTx, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE))
                      .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
                          .addComponent(label_42, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE).addGap(32)
                          .addComponent(insComposerTx, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE))
                      .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
                          .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.TRAILING, false)
                              .addComponent(label_47, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                  Short.MAX_VALUE)
                              .addComponent(label_48))
                          .addGap(39).addGroup(
                              gl_AddMusicTrackPanel.createParallelGroup(Alignment.TRAILING)
                                  .addComponent(insArrangerTx, GroupLayout.PREFERRED_SIZE, 298,
                                      GroupLayout.PREFERRED_SIZE)
                                  .addComponent(insSingerTx1, GroupLayout.PREFERRED_SIZE, 298,
                                      GroupLayout.PREFERRED_SIZE)))))
              .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
                  .addComponent(label_4, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE).addGap(22)
                  .addComponent(insMusicTx))
              .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
                  .addComponent(label_5, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE).addGap(38)
                  .addComponent(insLangTx, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE))
              .addGroup(gl_AddMusicTrackPanel.createSequentialGroup().addComponent(label_39).addGap(39)
                  .addComponent(radioButton_cd, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE).addGap(64)
                  .addComponent(radioButton_vinyl, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)))
              .addContainerGap(566, Short.MAX_VALUE)));
      gl_AddMusicTrackPanel
          .setVerticalGroup(
              gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING)
                  .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
                      .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING)
                          .addGroup(gl_AddMusicTrackPanel.createSequentialGroup().addGap(60).addComponent(label_4))
                          .addGroup(gl_AddMusicTrackPanel.createSequentialGroup().addGap(57).addComponent(insMusicTx,
                              GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                      .addGap(18)
                      .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING)
                          .addGroup(gl_AddMusicTrackPanel.createSequentialGroup().addGap(6).addComponent(label_5))
                          .addComponent(insLangTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                              GroupLayout.PREFERRED_SIZE))
                      .addGap(18)
                      .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING)
                          .addGroup(gl_AddMusicTrackPanel.createSequentialGroup().addGap(4).addComponent(label_39))
                          .addComponent(radioButton_cd).addComponent(radioButton_vinyl))
                      .addGap(18)
                      .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING)
                          .addGroup(gl_AddMusicTrackPanel.createSequentialGroup().addGap(3).addComponent(label_41))
                          .addComponent(insSongWriterTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                              GroupLayout.PREFERRED_SIZE))
                      .addGap(18)
                      .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING)
                          .addGroup(gl_AddMusicTrackPanel.createSequentialGroup().addGap(3).addComponent(label_42))
                          .addComponent(insComposerTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                              GroupLayout.PREFERRED_SIZE))
                      .addGap(18)
                      .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING)
                          .addGroup(gl_AddMusicTrackPanel.createSequentialGroup().addGap(3).addComponent(label_48))
                          .addComponent(insArrangerTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                              GroupLayout.PREFERRED_SIZE))
                      .addGap(18)
                      .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING)
                          .addComponent(insSingerTx1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                              GroupLayout.PREFERRED_SIZE)
                          .addGroup(gl_AddMusicTrackPanel.createSequentialGroup().addGap(3).addComponent(label_47)))
                      .addGap(18)
                      .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.BASELINE).addComponent(label_2)
                          .addComponent(insSingerTx2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                              GroupLayout.PREFERRED_SIZE))
                      .addGap(18).addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.BASELINE)
                          .addComponent(button_3).addComponent(button_9))
                      .addContainerGap(366, Short.MAX_VALUE)));
      AddMusicTrackPanel.setLayout(gl_AddMusicTrackPanel);

      frame.getContentPane().add(BorderLayout.CENTER, AddMusicTrackPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
      frame.setResizable(false);

    }

    private void clearInsertMusicTrack() {
      insSingerTx1.setText("");
      insSingerTx2.setText("");
      insComposerTx.setText("");
      insArrangerTx.setText("");
      insMusicTx.setText("");
      insLangTx.setText("");
      insSongWriterTx.setText("");
    }

  }
