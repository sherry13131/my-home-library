package com.mylibrary.createframe;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

import com.mylibrary.databasehelper.SelectHelper;
import com.mylibrary.object.MovieCrew;

public class CreateFrameMovieCrew {

  /**
   * for inserting a new movie crew, click through the add crew button
   * 
   * @param crews
   * @param update (true if from update page, false if from insert page)
   */
  public CreateFrameMovieCrew(Map<String, List<MovieCrew>> crews, boolean update) {
    JFrame frame = new JFrame("Add movie crews");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Exception e) {
      e.printStackTrace();
    }
    JPanel AddMovieCrewPanel = new JPanel();
    AddMovieCrewPanel.setOpaque(true);

    JLabel label_3 = new JLabel("Crews and casts");

    insCastNameTx = new JTextField();
    insCastNameTx.setColumns(10);

    JList insRoleTx = new JList(movieCastRoles);
    insRoleTx.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    insRoleTx.setSelectedIndex(0);

    JLabel lblName = new JLabel("Name:");

    JLabel lblRole = new JLabel("Role:");

    JLabel lblGender = new JLabel("Gender:");

    JRadioButton rdbtnMale = new JRadioButton("male");
    rdbtnMale.setSelected(true);
    rdbtnMale.setActionCommand("male");

    JRadioButton rdbtnFemale = new JRadioButton("female");
    rdbtnFemale.setActionCommand("female");

    ButtonGroup castGenderGroup = new ButtonGroup();
    castGenderGroup.add(rdbtnMale);
    castGenderGroup.add(rdbtnFemale);

    JLabel lblGotAward = new JLabel("got award:");
    JCheckBox chckbxTickIfYes = new JCheckBox("Tick if yes");

    JButton button = new JButton("Submit");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        // validate all input fields
        String name = insCastNameTx.getText();
        boolean male = false; // 0 - female, 1 - male
        boolean award = false; // 0 - no award, 1 - has award
        boolean valid = true;
        String role = "director";
        if (insCastNameTx.getText().equals("")) {
          JOptionPane.showMessageDialog(null, "fill in the name of the cast", "Insert movie cast - missing name",
              JOptionPane.ERROR_MESSAGE);
        } else if (!checkHelper.checkNameFormat(name)) {
          JOptionPane.showMessageDialog(null, "Please fill in the name in correct format",
              "Insert movie cast - wrong name format", JOptionPane.ERROR_MESSAGE);
        } else {
          // get all the inputs
          role = insRoleTx.getSelectedValue().toString();
          if (castGenderGroup.getSelection().getActionCommand().equalsIgnoreCase("male")) {
            male = true;
          }
          if (chckbxTickIfYes.isSelected()) {
            award = true;
          }

          // check if the name is already in the current list with same role

          // check if there are still space for entering this people

          if (update) {
            for (List<MovieCrew> list : tempcrew.values()) {
              for (MovieCrew c : list) {
                if (c.compareName(name)) {
                  JOptionPane.showMessageDialog(null, "You have entered a duplicated crew",
                      "Insert movie crew - duplicated crew", JOptionPane.ERROR_MESSAGE);
                  valid = false;
                }
              }
            }
            for (String crewRole : tempcrew.keySet()) {
              if (crewRole.equalsIgnoreCase("cast")) {
                // check if there are already 10 people
                if (tempcrew.get(crewRole).size() >= 10 && role.equalsIgnoreCase(crewRole)) {
                  valid = false;
                  JOptionPane.showMessageDialog(null, "You have already entered 10 Casts",
                      "Insert movie crew - too many cast entered", JOptionPane.ERROR_MESSAGE);
                  break;
                }
              } else {
                // check if there are already 3 people
                if (tempcrew.get(crewRole).size() >= 3 && role.equalsIgnoreCase(crewRole)) {
                  valid = false;
                  JOptionPane.showMessageDialog(null, "You have already entered 3 " + crewRole,
                      "Insert movie crew - too many crews entered", JOptionPane.ERROR_MESSAGE);
                  break;
                }
              }
            }
          } else {
            for (List<MovieCrew> list : crews.values()) {
              for (MovieCrew c : list) {
                if (c.compareName(name)) {
                  JOptionPane.showMessageDialog(null, "You have entered a duplicated crew",
                      "Insert movie crew - duplicated crew", JOptionPane.ERROR_MESSAGE);
                  valid = false;
                }
              }
            }
            for (String crewRole : crews.keySet()) {
              if (crewRole.equalsIgnoreCase("cast")) {
                // check if there are already 10 people
                if (crews.get(crewRole).size() >= 10 && role.equalsIgnoreCase(crewRole)) {
                  valid = false;
                  JOptionPane.showMessageDialog(null, "You have already entered 10 Casts",
                      "Insert movie crew - too many cast entered", JOptionPane.ERROR_MESSAGE);
                  break;
                }
              } else {
                // check if there are already 3 people
                if (crews.get(crewRole).size() >= 3 && role.equalsIgnoreCase(crewRole)) {
                  valid = false;
                  JOptionPane.showMessageDialog(null, "You have already entered 3 " + crewRole,
                      "Insert movie crew - too many crews entered", JOptionPane.ERROR_MESSAGE);
                  break;
                }
              }
            }
          }

          if (valid) {
            // make a new MovieCrew object
            MovieCrew mc = new MovieCrew(name, male, award, SelectHelper.getRoleID(role));
            if (update) {
              // insert new music track
              // may have to think how to insert them when finally submit button is click on
              // the main page
              if (role.equalsIgnoreCase("cast")) {
                model2.addElement(name + "---" + role);
              } else {
                model.addElement(name + "---" + role);
              }
              tempcrew.get(role).add(mc);
              JOptionPane.showMessageDialog(null, "submitted", "Update movie crew - added a new crew",
                  JOptionPane.INFORMATION_MESSAGE);
            } else {
              crews.get(role).add(mc);
              JOptionPane.showMessageDialog(null, "submitted", "Insert movie crew - submitted",
                  JOptionPane.INFORMATION_MESSAGE);
            }
          }
        }
      }
    });

    JButton button_4 = new JButton("Cancel");
    button_4.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        // clear fields
        insCastNameTx.setText("");
        chckbxTickIfYes.setSelected(false);
      }
    });

    GroupLayout gl_AddMovieCrewPanel = new GroupLayout(AddMovieCrewPanel);
    gl_AddMovieCrewPanel.setHorizontalGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_AddMovieCrewPanel.createSequentialGroup().addGap(54)
            .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.LEADING).addComponent(lblRole)
                .addComponent(lblName).addComponent(lblGender)
                .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.TRAILING, false)
                    .addComponent(lblGotAward, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE)
                    .addComponent(label_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)))
            .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_AddMovieCrewPanel.createSequentialGroup().addComponent(rdbtnMale).addGap(18)
                    .addComponent(rdbtnFemale))
                .addComponent(insCastNameTx, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
                .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.TRAILING)
                    .addGroup(gl_AddMovieCrewPanel.createSequentialGroup()
                        .addComponent(button, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE).addGap(48)
                        .addComponent(button_4, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                    .addComponent(insRoleTx, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE))
                .addGroup(gl_AddMovieCrewPanel.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(chckbxTickIfYes)))
            .addContainerGap(734, Short.MAX_VALUE)));
    gl_AddMovieCrewPanel.setVerticalGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_AddMovieCrewPanel.createSequentialGroup().addGap(64).addComponent(label_3).addGap(16)
            .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblName).addComponent(
                insCastNameTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGap(18)
            .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblRole)
                .addComponent(insRoleTx, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE))
            .addGap(18)
            .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblGender)
                .addComponent(rdbtnMale).addComponent(rdbtnFemale))
            .addGap(22)
            .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblGotAward)
                .addComponent(chckbxTickIfYes))
            .addGap(18).addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.LEADING).addComponent(button)
                .addComponent(button_4))
            .addContainerGap(469, Short.MAX_VALUE)));
    AddMovieCrewPanel.setLayout(gl_AddMovieCrewPanel);

    frame.getContentPane().add(BorderLayout.CENTER, AddMovieCrewPanel);
    frame.pack();
    frame.setLocationByPlatform(true);
    frame.setVisible(true);
    frame.setResizable(false);
  }

  public CreateFrameMovieCrew(MovieCrew mc) {
    JFrame frame = new JFrame("Add movie crews");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Exception e) {
      e.printStackTrace();
    }
    JPanel AddMovieCrewPanel = new JPanel();
    AddMovieCrewPanel.setOpaque(true);

    JLabel label_3 = new JLabel("Crews and casts");

    insCastNameTx = new JTextField();
    insCastNameTx.setColumns(10);

    JList insRoleTx = new JList(movieCastRoles);
    insRoleTx.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    insRoleTx.setSelectedIndex(0);

    JLabel lblName = new JLabel("Name:");

    JLabel lblRole = new JLabel("Role:");

    JLabel lblGender = new JLabel("Gender:");

    JRadioButton rdbtnMale = new JRadioButton("male");
    rdbtnMale.setSelected(true);
    rdbtnMale.setActionCommand("male");

    JRadioButton rdbtnFemale = new JRadioButton("female");
    rdbtnFemale.setActionCommand("female");

    ButtonGroup castGenderGroup = new ButtonGroup();
    castGenderGroup.add(rdbtnMale);
    castGenderGroup.add(rdbtnFemale);

    ButtonModel model_male = rdbtnMale.getModel();
    ButtonModel model_female = rdbtnFemale.getModel();

    JLabel lblGotAward = new JLabel("got award:");
    JCheckBox chckbxTickIfYes = new JCheckBox("Tick if yes");

    // set values in all text fields
    insCastNameTx.setText(mc.getCrewName());
    if (mc.getGender() == true) {
      castGenderGroup.setSelected(model_male, true);
    } else {
      castGenderGroup.setSelected(model_female, true);
    }
    String oldRole = mc.getRoleName();
    insRoleTx.setSelectedValue(oldRole, true);
    if (mc.getAward()) {
      chckbxTickIfYes.setSelected(true);
    }

    JButton button = new JButton("Update");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        // validate all input fields
        String name = insCastNameTx.getText();
        boolean male = false; // 0 - female, 1 - male
        boolean award = false; // 0 - no award, 1 - has award
        boolean valid = true;
        String role = "director";
        if (insCastNameTx.getText().equals("")) {
          JOptionPane.showMessageDialog(null, "fill in the name of the cast", "Insert movie cast - missing name",
              JOptionPane.ERROR_MESSAGE);
        } else if (!checkHelper.checkNameFormat(name)) {
          JOptionPane.showMessageDialog(null, "Please fill in the name in correct format",
              "Insert movie cast - wrong name format", JOptionPane.ERROR_MESSAGE);
        } else {
          // get all the inputs
          role = insRoleTx.getSelectedValue().toString();
          if (castGenderGroup.getSelection().getActionCommand().equalsIgnoreCase("male")) {
            male = true;
          }
          if (chckbxTickIfYes.isSelected()) {
            award = true;
          }

          // check if the name is already in the current list with same role
          /// ... unique name so skip?

          // check if there are still space for entering this people
          if (!mc.compareName(name)) {
            for (List<MovieCrew> list : tempcrew.values()) {
              for (MovieCrew c : list) {
                if (c.compareName(name)) {
                  JOptionPane.showMessageDialog(null, "You have entered a duplicated crew",
                      "Insert movie crew - duplicated crew", JOptionPane.ERROR_MESSAGE);
                  valid = false;
                }
              }
            }
          }
          if (!oldRole.equalsIgnoreCase(role)) {
            if (tempcrew.get(oldRole).size() <= 1) {
              valid = false;
              JOptionPane.showMessageDialog(null, "You need at least 1 people for that role",
                  "Insert movie crew - too few cast entered", JOptionPane.ERROR_MESSAGE);
            }
            if (role.equalsIgnoreCase("cast")) {
              if (tempcrew.get(role).size() >= 10) {
                valid = false;
                JOptionPane.showMessageDialog(null, "You have already entered 10 Casts",
                    "Insert movie crew - too many cast entered", JOptionPane.ERROR_MESSAGE);
              }
            } else {
              if (tempcrew.get(role).size() >= 3) {
                valid = false;
                JOptionPane.showMessageDialog(null, "You have already entered 3 Casts",
                    "Insert movie crew - too many cast entered", JOptionPane.ERROR_MESSAGE);
              }
            }
          }

          if (valid) {
            // make a new MovieCrew object
            MovieCrew newmc = new MovieCrew(name, male, award, SelectHelper.getRoleID(role));
            tempcrew.get(oldRole).remove(mc);
            tempcrew.get(role).add(newmc);
            if (oldRole.equalsIgnoreCase("cast")) {
              model2.removeElement(mc.getCrewName() + "---" + oldRole);
            } else {
              model.removeElement(mc.getCrewName() + "---" + oldRole);
            }
            if (role.equalsIgnoreCase("cast")) {
              model2.addElement(newmc.getCrewName() + "---" + role);
            } else {
              model.addElement(newmc.getCrewName() + "---" + role);
            }
            JOptionPane.showMessageDialog(null, "submitted", "Insert movie crew - submitted",
                JOptionPane.INFORMATION_MESSAGE);
          }
        }
      }
    });

    JButton button_4 = new JButton("Cancel");
    button_4.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        // clear fields
        insCastNameTx.setText("");
        chckbxTickIfYes.setSelected(false);
      }
    });

    GroupLayout gl_AddMovieCrewPanel = new GroupLayout(AddMovieCrewPanel);
    gl_AddMovieCrewPanel.setHorizontalGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_AddMovieCrewPanel.createSequentialGroup().addGap(54)
            .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.LEADING).addComponent(lblRole)
                .addComponent(lblName).addComponent(lblGender)
                .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.TRAILING, false)
                    .addComponent(lblGotAward, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE)
                    .addComponent(label_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)))
            .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_AddMovieCrewPanel.createSequentialGroup().addComponent(rdbtnMale).addGap(18)
                    .addComponent(rdbtnFemale))
                .addComponent(insCastNameTx, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
                .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.TRAILING)
                    .addGroup(gl_AddMovieCrewPanel.createSequentialGroup()
                        .addComponent(button, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE).addGap(48)
                        .addComponent(button_4, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                    .addComponent(insRoleTx, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE))
                .addGroup(gl_AddMovieCrewPanel.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(chckbxTickIfYes)))
            .addContainerGap(734, Short.MAX_VALUE)));
    gl_AddMovieCrewPanel.setVerticalGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_AddMovieCrewPanel.createSequentialGroup().addGap(64).addComponent(label_3).addGap(16)
            .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblName).addComponent(
                insCastNameTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGap(18)
            .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblRole)
                .addComponent(insRoleTx, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE))
            .addGap(18)
            .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblGender)
                .addComponent(rdbtnMale).addComponent(rdbtnFemale))
            .addGap(22)
            .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblGotAward)
                .addComponent(chckbxTickIfYes))
            .addGap(18).addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.LEADING).addComponent(button)
                .addComponent(button_4))
            .addContainerGap(469, Short.MAX_VALUE)));
    AddMovieCrewPanel.setLayout(gl_AddMovieCrewPanel);

    frame.getContentPane().add(BorderLayout.CENTER, AddMovieCrewPanel);
    frame.pack();
    frame.setLocationByPlatform(true);
    frame.setVisible(true);
    frame.setResizable(false);
  }
}

