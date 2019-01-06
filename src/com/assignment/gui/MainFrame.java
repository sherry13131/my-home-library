package com.assignment.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.mylibrary.buildhelper.ReportHelper;
import com.mylibrary.dbhelper.DeleteHelper;
import com.mylibrary.dbhelper.InserterHelper;
import com.mylibrary.dbhelper.SelectHelper;
import com.mylibrary.dbhelper.UpdateHelper;
import com.mylibrary.helper.checkHelper;
import com.mylibrary.objects.Album;
import com.mylibrary.objects.Book;
import com.mylibrary.objects.Movie;
import com.mylibrary.objects.MovieCrew;
import com.mylibrary.objects.MusicTrack;
import com.mylibrary.type.DiskType;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.UIManager;

import java.awt.Toolkit;
import javax.swing.JTextArea;

import javax.swing.ListSelectionModel;

public class MainFrame {

  public static Connection con;

  private JFrame frame;
  private JTextField insertbooktitle, insertbookisbn, insertbookpub, insertpages, insertpubyear, insertedition;
  private JTextField insertabstract, insertkeyword, insertauthor1, insertauthor2, insertauthor3, insertauthor4, insertauthor5;
  private JTextField movieYearTx, movieNameTx, upBookYearTx, upEditionTx, upAbstractTx, upKeywordsTx;
  private JTextField upAuthorTx1, upAuthorTx2, upAuthorTx3, upAuthorTx4, upAuthorTx5;
  private JTextField upBookTitleTx, upISBN, upPublisherTx, upPagesTx;
  private JTextField searchNameTx, searchYearTx;
  private JCheckBox chckbxBook, chckbxAlbum, chckbxMovie;
  private JTextField insYearTx, insSingerTx1, insSingerTx2, insMusicTx, insLangTx, insSongWriterTx, insComposerTx;
  private JTextField insArrangerTx, textField_17, insProducerTx, insAlbumTx, insCastNameTx;
  private List<MusicTrack> musicTracks;
  private JTextArea textAreaMusicTrack, textArea, textArea_1;
  private JTextField textField, upAlbumTx, upProducerTx, upYearTx, upMovieNameTx, upMovieYearTx;
  private String[] movieCastRoles = { "director", "script writer", "cast", "producer", "composer", "editor",
      "costume designer" };
  private Book oldBook;
  private Album oldAlbum;
  private Movie oldMovie;
  private Map<String, MusicTrack> tracks = new HashMap<String, MusicTrack>();
  private Map<String, List<MovieCrew>> crews = new HashMap<String, List<MovieCrew>>();
  private Map<String, List<MovieCrew>> tempcrew = new HashMap<String, List<MovieCrew>>();
  private DefaultListModel<String> model = new DefaultListModel();
  private DefaultListModel<String> model2 = new DefaultListModel();

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          MainFrame window = new MainFrame();
          window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   * 
   * @throws SQLException
   * @throws ClassNotFoundException
   */
  public MainFrame() throws SQLException, ClassNotFoundException {

    Class.forName("com.mysql.jdbc.Driver");
    String username = "root";
    String password = "";
    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hl", username, password);
    initialize(con);
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize(Connection con) {
    frame = new JFrame();
    frame.setBounds(100, 100, 885, 702);
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
//    frame.setBounds(100, 100, 1070, 669);
    frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.getContentPane().setLayout(new CardLayout(0, 0));

    JPanel panel = new JPanel();
    frame.getContentPane().add(panel, "mainPage");

    JLabel lblWelcomeToMy = new JLabel("Welcome to my library");
    panel.add(lblWelcomeToMy);

    JPanel insertBook = new JPanel();
    frame.getContentPane().add(insertBook, "insertBook");

    JLabel lblBookTitle = new JLabel("Book title* :");

    insertbooktitle = new JTextField();
    insertbooktitle.setColumns(10);

    JLabel lblBookIsbn = new JLabel("Book ISBN* :");

    insertbookisbn = new JTextField();
    insertbookisbn.setColumns(10);

    JLabel lblNewLabel = new JLabel("Publisher* :");

    JLabel lblNumberofPages = new JLabel("Numberof pages* :");

    JLabel lblYearOfPublication = new JLabel("Year of publication* :");

    JLabel lblEditionNumber = new JLabel("Edition number:");

    JLabel lblAbstract = new JLabel("Abstract:");

    JLabel lblKeywords = new JLabel("Keywords:");

    JLabel lblAuthors = new JLabel("Authors* :");

    insertbookpub = new JTextField();
    insertbookpub.setColumns(10);

    insertpages = new JTextField();
    insertpages.setColumns(10);

    insertpubyear = new JTextField();
    insertpubyear.setColumns(10);

    insertedition = new JTextField();
    insertedition.setColumns(10);

    insertabstract = new JTextField();
    insertabstract.setColumns(10);

    insertkeyword = new JTextField();
    insertkeyword.setColumns(10);

    insertauthor2 = new JTextField();
    insertauthor2.setColumns(10);

    insertauthor1 = new JTextField();
    insertauthor1.setColumns(10);

    insertauthor4 = new JTextField();
    insertauthor4.setColumns(10);

    insertauthor3 = new JTextField();
    insertauthor3.setColumns(10);

    insertauthor5 = new JTextField();
    insertauthor5.setColumns(10);

    JButton btnCancelbook = new JButton("Cancel");
    btnCancelbook.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        clearInsertbook();
      }
    });

    JButton btnSubmitbookinsert = new JButton("Submit");
    btnSubmitbookinsert.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        String title = null, isbn = null, pub = null, author1 = null, bookabs = null;
        int edition = -1;
        String[] keywords = null;
        // validate entry
        if (insertbooktitle.getText().equals("") || insertbookisbn.getText().equals("")
            || insertbookpub.getText().equals("") || insertpages.getText().equals("")
            || insertpubyear.getText().equals("") || insertauthor1.getText().equals("")
            || insertbookisbn.getText().length() != 13 || insertabstract.getText().length() > 5000) {
          // show error - mandatory fields
          JOptionPane.showMessageDialog(null, "fill in all mandatory fields and in correct format",
              "Insert book - wrong format", JOptionPane.ERROR_MESSAGE);
        } else {
          // get input
          title = insertbooktitle.getText();
          isbn = insertbookisbn.getText();
          pub = insertbookpub.getText();
          int pages = checkHelper.checkIfNumerical(insertpages);
          int year = checkHelper.checkIfNumerical(insertpubyear);
          author1 = insertauthor1.getText();

          // check if isbn exist already
          boolean bookExist = SelectHelper.bookexist(isbn, con);

          if (pages <= 0 || year <= 0) {
            // show error - wrong range
            JOptionPane.showMessageDialog(null, "Please fill in with correct range",
                "Insert book - wrong format on range", JOptionPane.ERROR_MESSAGE);
          } else if (bookExist) {
            // error - book isbn duplicated
            JOptionPane.showMessageDialog(null, "This book has already exist in the database",
                "Insert book - book existed", JOptionPane.ERROR_MESSAGE);
          } else {

            // get optional field
            if (!insertedition.getText().equals("")) {
              edition = checkHelper.checkIfNumerical(insertedition);
              if (edition < 0) {
                JOptionPane.showMessageDialog(null, "Since edition in wrong format, default set it as no edition info",
                    "Insert book - wrong format on range", JOptionPane.ERROR_MESSAGE);
                edition = -1;
              }
            }
            if (!insertabstract.getText().equals("")) {
              bookabs = insertabstract.getText();
            }
            if (!insertkeyword.getText().equals("")) {
              if (insertkeyword.getText().contains(",")) {
                keywords = insertkeyword.getText().split("\\s*,\\s*");
              } else {
                keywords = (insertkeyword.getText() + ",").split(",");
              }
            }

            List<String> authors = new ArrayList<String>();
            authors.add(author1);
            if (!insertauthor2.getText().equals("")) {
              authors.add(insertauthor2.getText());
            }
            if (!insertauthor3.getText().equals("")) {
              authors.add(insertauthor3.getText());
            }
            if (!insertauthor4.getText().equals("")) {
              authors.add(insertauthor4.getText());
            }
            if (!insertauthor5.getText().equals("")) {
              authors.add(insertauthor5.getText());
            }

            // insert book
            boolean success = TransactionHelper.insertBookTransaction(isbn, title, pub, pages, year, edition, bookabs,
                authors, keywords);

            if (success) {
              JOptionPane.showMessageDialog(null, "Book inserted.", "Insert book - success",
                  JOptionPane.INFORMATION_MESSAGE);
            } else {
              JOptionPane.showMessageDialog(null, "Book insertion fail due to unexpected error", "Insert book - error",
                  JOptionPane.ERROR_MESSAGE);
            }
            // clear all fields if successfully insert all data
            clearInsertbook();

          }
        }
      }
    });

    JLabel lblEachBookCan = new JLabel(
        "Each book can store at most 5 authors and at least one author, and, at most 20 keywords.");

    JLabel lblNameOfPeople_1 = new JLabel(
        "Name of people who involved should be in the format of 'first_name family_name' or 'first_name middle_name family_name'");

    JLabel lblIfTheNames = new JLabel("If the names are in the wrong format, it will not be stored in the database.");

    JLabel lblPleaseInsertAll_1 = new JLabel("Please insert all the mandatory fields. ISBN is a 13 digits string.");
    GroupLayout gl_insertBook = new GroupLayout(insertBook);
    gl_insertBook
        .setHorizontalGroup(
            gl_insertBook.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_insertBook.createSequentialGroup()
                    .addGroup(gl_insertBook
                        .createParallelGroup(
                            Alignment.LEADING)
                        .addGroup(gl_insertBook.createSequentialGroup().addGap(22).addGroup(
                            gl_insertBook.createParallelGroup(Alignment.LEADING)
                                .addComponent(lblNameOfPeople_1, GroupLayout.PREFERRED_SIZE, 809,
                                    GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPleaseInsertAll_1, GroupLayout.PREFERRED_SIZE, 672,
                                    GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblIfTheNames, GroupLayout.PREFERRED_SIZE, 469,
                                    GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblEachBookCan, GroupLayout.PREFERRED_SIZE, 597,
                                    GroupLayout.PREFERRED_SIZE)))
                        .addGroup(gl_insertBook.createSequentialGroup().addGap(184).addGroup(gl_insertBook
                            .createParallelGroup(Alignment.LEADING).addGroup(
                                gl_insertBook.createSequentialGroup().addComponent(lblNumberofPages).addGap(
                                    18).addComponent(insertpages, GroupLayout.PREFERRED_SIZE, 298,
                                        GroupLayout.PREFERRED_SIZE))
                            .addGroup(gl_insertBook.createSequentialGroup()
                                .addGroup(
                                    gl_insertBook.createParallelGroup(Alignment.LEADING).addComponent(lblBookTitle)
                                        .addComponent(lblBookIsbn).addComponent(lblNewLabel))
                                .addGap(53)
                                .addGroup(gl_insertBook
                                    .createParallelGroup(Alignment.LEADING, false).addComponent(insertbookpub)
                                    .addComponent(
                                        insertbookisbn)
                                    .addComponent(insertbooktitle, GroupLayout.PREFERRED_SIZE, 298,
                                        GroupLayout.PREFERRED_SIZE)))
                            .addGroup(gl_insertBook.createSequentialGroup()
                                .addGroup(gl_insertBook.createParallelGroup(Alignment.LEADING)
                                    .addComponent(lblYearOfPublication).addComponent(lblEditionNumber)
                                    .addComponent(lblAbstract).addComponent(lblKeywords).addComponent(lblAuthors))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_insertBook.createParallelGroup(Alignment.LEADING)
                                    .addComponent(insertkeyword, GroupLayout.PREFERRED_SIZE, 298,
                                        GroupLayout.PREFERRED_SIZE)
                                    .addComponent(insertedition, GroupLayout.PREFERRED_SIZE, 298,
                                        GroupLayout.PREFERRED_SIZE)
                                    .addComponent(insertpubyear, GroupLayout.PREFERRED_SIZE, 298,
                                        GroupLayout.PREFERRED_SIZE)
                                    .addComponent(insertabstract, GroupLayout.PREFERRED_SIZE, 298,
                                        GroupLayout.PREFERRED_SIZE)
                                    .addGroup(gl_insertBook.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(gl_insertBook.createSequentialGroup()
                                            .addComponent(insertauthor1, GroupLayout.PREFERRED_SIZE, 138,
                                                GroupLayout.PREFERRED_SIZE)
                                            .addGap(23).addComponent(insertauthor2, GroupLayout.PREFERRED_SIZE, 138,
                                                GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_insertBook.createSequentialGroup()
                                            .addComponent(insertauthor3, GroupLayout.PREFERRED_SIZE, 138,
                                                GroupLayout.PREFERRED_SIZE)
                                            .addGap(23).addComponent(insertauthor4, GroupLayout.PREFERRED_SIZE, 138,
                                                GroupLayout.PREFERRED_SIZE))
                                        .addComponent(insertauthor5, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 138,
                                            GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_insertBook.createSequentialGroup()
                                            .addComponent(btnSubmitbookinsert, GroupLayout.PREFERRED_SIZE, 82,
                                                GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(ComponentPlacement.RELATED)
                                            .addComponent(btnCancelbook))))))))
                    .addContainerGap(36, Short.MAX_VALUE)));
    gl_insertBook.setVerticalGroup(gl_insertBook.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_insertBook.createSequentialGroup().addContainerGap().addComponent(lblPleaseInsertAll_1).addGap(11)
            .addComponent(lblEachBookCan).addGap(13).addComponent(lblNameOfPeople_1).addGap(13)
            .addComponent(lblIfTheNames).addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
            .addGroup(gl_insertBook.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_insertBook.createSequentialGroup().addGap(3).addComponent(lblBookTitle)).addComponent(
                    insertbooktitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGap(18)
            .addGroup(gl_insertBook.createParallelGroup(Alignment.BASELINE)
                .addComponent(insertbookisbn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                    GroupLayout.PREFERRED_SIZE)
                .addComponent(lblBookIsbn))
            .addGap(18)
            .addGroup(gl_insertBook.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel).addComponent(
                insertbookpub, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGap(18)
            .addGroup(gl_insertBook.createParallelGroup(Alignment.BASELINE).addComponent(lblNumberofPages).addComponent(
                insertpages, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGap(18)
            .addGroup(
                gl_insertBook.createParallelGroup(Alignment.BASELINE).addComponent(lblYearOfPublication).addComponent(
                    insertpubyear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGap(18)
            .addGroup(gl_insertBook.createParallelGroup(Alignment.BASELINE).addComponent(lblEditionNumber).addComponent(
                insertedition, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGap(18)
            .addGroup(gl_insertBook.createParallelGroup(Alignment.BASELINE).addComponent(lblAbstract).addComponent(
                insertabstract, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGap(18)
            .addGroup(gl_insertBook.createParallelGroup(Alignment.BASELINE).addComponent(lblKeywords).addComponent(
                insertkeyword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGap(18)
            .addGroup(gl_insertBook.createParallelGroup(Alignment.LEADING).addComponent(lblAuthors)
                .addComponent(insertauthor1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                    GroupLayout.PREFERRED_SIZE)
                .addComponent(insertauthor2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                    GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(ComponentPlacement.RELATED)
            .addGroup(gl_insertBook.createParallelGroup(Alignment.LEADING)
                .addComponent(insertauthor3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                    GroupLayout.PREFERRED_SIZE)
                .addComponent(insertauthor4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                    GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(ComponentPlacement.RELATED)
            .addComponent(insertauthor5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(ComponentPlacement.UNRELATED).addGroup(gl_insertBook
                .createParallelGroup(Alignment.BASELINE).addComponent(btnSubmitbookinsert).addComponent(btnCancelbook))
            .addGap(38)));
    insertBook.setLayout(gl_insertBook);

    JPanel insertAlbum2 = new JPanel();
    frame.getContentPane().add(insertAlbum2, "insertAlbum2");

    JButton button_2 = new JButton("Add a music track");
    button_2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        CreateFrameMusicTrack createFrame = new CreateFrameMusicTrack(musicTracks, false);
      }
    });

    JLabel label = new JLabel("Please insert all the fields.");

    JLabel label_1 = new JLabel("Year:");

    JLabel label_43 = new JLabel("Album name:");

    insYearTx = new JTextField();
    insYearTx.setColumns(10);

    JLabel label_44 = new JLabel(
        "Name of people who involved should be in the format of 'first_name family_name' or 'first_name middle_name family_name'");

    JLabel lblYouShouldInsert = new JLabel("You should insert at least one music track for an album.");

    JLabel label_38 = new JLabel("Producer:");

    textField_17 = new JTextField();
    textField_17.setColumns(10);

    JLabel lblMusicTracks = new JLabel("Music Tracks:");

    JScrollPane scrollPane_1 = new JScrollPane();

    textAreaMusicTrack = new JTextArea();
    scrollPane_1.setViewportView(textAreaMusicTrack);

    JButton btnTry = new JButton("Refresh list");
    btnTry.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // set music track name on main panel
        String str = "";
        for (MusicTrack mt : musicTracks) {
          str += mt.toString();
        }
        textAreaMusicTrack.setText(str);
      }
    });

    JButton btnSubmit = new JButton("Submit");
    btnSubmit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String albumName = null, producer = null;
        int year = -1;

        // check all fields are filled in or not
        if (insAlbumTx.getText().equals("") || insYearTx.getText().equals("") || insProducerTx.getText().equals("")) {
          // show error - mandatory fields
          JOptionPane.showMessageDialog(null, "fill in all mandatory fields and in correct format",
              "Insert music - wrong format", JOptionPane.ERROR_MESSAGE);
        } else if (checkHelper.checkIfNumerical(insYearTx) <= 0) {
          JOptionPane.showMessageDialog(null, "fill in the year in correct range", "Insert music - wrong range",
              JOptionPane.ERROR_MESSAGE);
        } else if (musicTracks.isEmpty()) {
          JOptionPane.showMessageDialog(null, "You should have at least one music track",
              "Insert music - no music track", JOptionPane.ERROR_MESSAGE);
        } else {
          // get the string values
          albumName = insAlbumTx.getText();
          year = Integer.parseInt(insYearTx.getText());
          producer = insProducerTx.getText();
          if (!checkHelper.checkNameFormat(producer)) {
            JOptionPane.showMessageDialog(null, "fill in the producer name in correct format",
                "Insert music - wrong name format", JOptionPane.ERROR_MESSAGE);
          } else {

            // check if the music album exist in Music, insert if not
            if (!checkHelper.albumExist(albumName, con)) {
              // insert music
              boolean success = TransactionHelper.insertMusicTransaction(albumName, year, producer, musicTracks);
              if (success) {
                JOptionPane.showMessageDialog(null, "Music inserted.", "Insert music - success",
                    JOptionPane.INFORMATION_MESSAGE);
                // clear the text fields
                clearInsertMusic();
                musicTracks.clear();
              } else {
                JOptionPane.showMessageDialog(null, "Music insertion fail due to unexpected error",
                    "Insert music - error", JOptionPane.ERROR_MESSAGE);
              }
            } else {
              JOptionPane.showMessageDialog(null, "This music track of that album already existed",
                  "Insert music - already existed", JOptionPane.ERROR_MESSAGE);
            }
          }
        }
      }
    });

    JLabel lblProducer_1 = new JLabel("Producer:");

    insProducerTx = new JTextField();
    insProducerTx.setColumns(10);

    insAlbumTx = new JTextField();
    insAlbumTx.setColumns(10);

    JButton btnCancel_2 = new JButton("Cancel");
    btnCancel_2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        clearInsertMusic();
      }
    });
    GroupLayout gl_insertAlbum2 = new GroupLayout(insertAlbum2);
    gl_insertAlbum2.setHorizontalGroup(gl_insertAlbum2.createParallelGroup(Alignment.TRAILING)
        .addGroup(gl_insertAlbum2.createSequentialGroup()
            .addGroup(gl_insertAlbum2.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_insertAlbum2.createSequentialGroup().addGap(52).addComponent(label))
                .addGroup(gl_insertAlbum2.createSequentialGroup().addGap(52)
                    .addGroup(gl_insertAlbum2.createParallelGroup(Alignment.LEADING).addComponent(label_44)
                        .addComponent(lblYouShouldInsert)))
                .addGroup(gl_insertAlbum2.createSequentialGroup().addGap(289).addComponent(label_38).addGap(39)
                    .addComponent(textField_17, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)))
            .addGap(155))
        .addGroup(Alignment.LEADING,
            gl_insertAlbum2.createSequentialGroup().addGap(195)
                .addGroup(gl_insertAlbum2.createParallelGroup(Alignment.TRAILING, false)
                    .addGroup(gl_insertAlbum2.createSequentialGroup().addComponent(lblMusicTracks).addGap(314))
                    .addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 397, GroupLayout.PREFERRED_SIZE)
                    .addGroup(gl_insertAlbum2.createSequentialGroup().addComponent(button_2)
                        .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTry))
                    .addGroup(gl_insertAlbum2.createSequentialGroup()
                        .addGroup(gl_insertAlbum2.createParallelGroup(Alignment.LEADING, false)
                            .addComponent(label_43, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label_1).addComponent(lblProducer_1))
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addGroup(gl_insertAlbum2.createParallelGroup(Alignment.LEADING)
                            .addComponent(insAlbumTx, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
                            .addGroup(gl_insertAlbum2.createParallelGroup(Alignment.LEADING)
                                .addComponent(insProducerTx, GroupLayout.PREFERRED_SIZE, 308,
                                    GroupLayout.PREFERRED_SIZE)
                                .addComponent(insYearTx, GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE))))
                    .addGroup(gl_insertAlbum2.createSequentialGroup().addComponent(btnCancel_2).addGap(18)
                        .addComponent(btnSubmit)))
                .addContainerGap(328, Short.MAX_VALUE)));
    gl_insertAlbum2.setVerticalGroup(gl_insertAlbum2.createParallelGroup(Alignment.LEADING).addGroup(gl_insertAlbum2
        .createSequentialGroup().addGap(38).addComponent(label).addGap(11).addComponent(lblYouShouldInsert)
        .addPreferredGap(ComponentPlacement.UNRELATED).addComponent(label_44).addGap(47)
        .addGroup(gl_insertAlbum2.createParallelGroup(Alignment.BASELINE).addComponent(label_43)
            .addComponent(insAlbumTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(ComponentPlacement.UNRELATED)
        .addGroup(gl_insertAlbum2.createParallelGroup(Alignment.BASELINE).addComponent(label_1).addComponent(insYearTx,
            GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(ComponentPlacement.UNRELATED)
        .addGroup(gl_insertAlbum2.createParallelGroup(Alignment.BASELINE).addComponent(lblProducer_1).addComponent(
            insProducerTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        .addGap(30).addComponent(lblMusicTracks).addGap(18)
        .addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE).addGap(35)
        .addGroup(gl_insertAlbum2.createParallelGroup(Alignment.BASELINE).addComponent(button_2).addComponent(btnTry))
        .addGap(84)
        .addGroup(
            gl_insertAlbum2.createParallelGroup(Alignment.BASELINE).addComponent(btnSubmit).addComponent(btnCancel_2))
        .addGap(55)
        .addGroup(gl_insertAlbum2.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_insertAlbum2.createSequentialGroup().addGap(376).addComponent(label_38))
            .addGroup(gl_insertAlbum2.createSequentialGroup().addGap(373).addComponent(textField_17,
                GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

    insertAlbum2.setLayout(gl_insertAlbum2);

    JPanel insertMovie = new JPanel();
    frame.getContentPane().add(insertMovie, "insertMovie");

    JLabel lblReleaseYear = new JLabel("Release year:");

    JLabel lblMovieName = new JLabel("Movie name:");

    movieYearTx = new JTextField();
    movieYearTx.setColumns(10);

    movieNameTx = new JTextField();
    movieNameTx.setColumns(10);

    JLabel lblCrewAndCast = new JLabel("Crew:");

    textArea = new JTextArea();

    JLabel lblCast = new JLabel("Cast:");

    textArea_1 = new JTextArea();

    JButton btnAddNewCrew = new JButton("Add new crew or cast");
    btnAddNewCrew.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        CreateFrameMovieCrew createFrameMovieCrew = new CreateFrameMovieCrew(crews, false);
      }
    });

    JButton btnCancel_1 = new JButton("Cancel");
    btnCancel_1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        // clear fields
        clearInsertMovies();
      }
    });

    JButton btnSubmit_1 = new JButton("Submit");
    btnSubmit_1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        String movieName = null;
        int year = checkHelper.checkIfNumerical(movieYearTx);
        // validate input fields
        if (movieNameTx.getText().equals("") || movieYearTx.getText().equals("")
            || checkHelper.checkIfEmptyCrew(crews)) {
          JOptionPane.showMessageDialog(null, "Please fill in all the fields with at least one people in each role",
              "Insert movie - incomplete input", JOptionPane.ERROR_MESSAGE);
        } else if (year < 0) {
          JOptionPane.showMessageDialog(null, "Year in wrong range", "Insert movie - wrong range",
              JOptionPane.ERROR_MESSAGE);
        } else {
          // get all the input
          movieName = movieNameTx.getText();

          // check if movie exist
          if (!checkHelper.movieExist(movieName, con)) {
            // inserting start
            TransactionHelper.insertMovieTransaction(movieName, year, crews);
            JOptionPane.showMessageDialog(null, "Movie inserted", "Insert movie - movie inserted",
                JOptionPane.INFORMATION_MESSAGE);
            // clear fields
            clearInsertMovies();
          } else {
            JOptionPane.showMessageDialog(null, "Movie already exist", "Insert movie - movie existed",
                JOptionPane.ERROR_MESSAGE);
          }
        }
      }
    });

    JButton btnRefreshList_1 = new JButton("Refresh list");
    btnRefreshList_1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        String str = "";
        for (MovieCrew cast : crews.get("cast")) {
          str += cast.getCrewName() + "\n";
        }
        textArea_1.setText(str);
        str = "";
        for (String role : crews.keySet()) {
          if (!role.equalsIgnoreCase("cast")) {
            for (MovieCrew crew : crews.get(role)) {
              str += crew.getCrewName() + "\n";
            }
          }
        }
        textArea.setText(str);
      }
    });

    JLabel lblPleaseFillIn = new JLabel("Please fill in all the madatory fields.");

    JLabel lblThereShouldBe = new JLabel(
        "There should be at least one people for each role. At most 10 for cast, at most 3 otherwise.");
    GroupLayout gl_insertMovie = new GroupLayout(insertMovie);
    gl_insertMovie.setHorizontalGroup(gl_insertMovie.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_insertMovie.createSequentialGroup()
            .addGroup(gl_insertMovie.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_insertMovie.createSequentialGroup().addGap(45)
                    .addGroup(gl_insertMovie.createParallelGroup(Alignment.LEADING).addComponent(lblThereShouldBe)
                        .addComponent(lblPleaseFillIn)))
                .addGroup(gl_insertMovie.createSequentialGroup().addGap(176)
                    .addGroup(gl_insertMovie.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_insertMovie.createSequentialGroup()
                            .addGroup(gl_insertMovie.createParallelGroup(Alignment.LEADING)
                                .addComponent(textArea, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCrewAndCast).addComponent(btnRefreshList_1))
                            .addGap(93)
                            .addGroup(gl_insertMovie.createParallelGroup(Alignment.LEADING)
                                .addComponent(lblCast, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                .addGroup(gl_insertMovie.createParallelGroup(Alignment.TRAILING)
                                    .addGroup(gl_insertMovie.createSequentialGroup().addComponent(btnSubmit_1)
                                        .addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnCancel_1))
                                    .addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, 206,
                                        GroupLayout.PREFERRED_SIZE))))
                        .addGroup(gl_insertMovie.createSequentialGroup()
                            .addGroup(gl_insertMovie.createParallelGroup(Alignment.LEADING).addComponent(lblReleaseYear)
                                .addComponent(lblMovieName))
                            .addGap(18)
                            .addGroup(gl_insertMovie.createParallelGroup(Alignment.LEADING, false)
                                .addComponent(movieNameTx).addComponent(movieYearTx, GroupLayout.PREFERRED_SIZE, 169,
                                    GroupLayout.PREFERRED_SIZE)))
                        .addComponent(btnAddNewCrew))))
            .addContainerGap(103, Short.MAX_VALUE)));
    gl_insertMovie.setVerticalGroup(gl_insertMovie.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_insertMovie.createSequentialGroup().addGap(31).addComponent(lblPleaseFillIn).addGap(18)
            .addComponent(lblThereShouldBe).addGap(18)
            .addGroup(gl_insertMovie.createParallelGroup(Alignment.TRAILING)
                .addGroup(gl_insertMovie.createSequentialGroup().addComponent(lblCast).addGap(18)
                    .addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
                .addGroup(gl_insertMovie.createSequentialGroup()
                    .addGroup(gl_insertMovie
                        .createParallelGroup(Alignment.BASELINE).addComponent(lblMovieName).addComponent(movieNameTx,
                            GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(27)
                    .addGroup(gl_insertMovie.createParallelGroup(Alignment.BASELINE).addComponent(lblReleaseYear)
                        .addComponent(movieYearTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                            GroupLayout.PREFERRED_SIZE))
                    .addGap(34).addComponent(lblCrewAndCast).addGap(18)
                    .addComponent(textArea, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)))
            .addGap(48).addComponent(btnAddNewCrew).addGap(42)
            .addGroup(gl_insertMovie.createParallelGroup(Alignment.BASELINE).addComponent(btnCancel_1)
                .addComponent(btnSubmit_1).addComponent(btnRefreshList_1))
            .addContainerGap(59, Short.MAX_VALUE)));
    insertMovie.setLayout(gl_insertMovie);

    JPanel updateBook = new JPanel();
    frame.getContentPane().add(updateBook, "updateBook");

    JLabel lblNewLabel_2 = new JLabel("Book title:");

    JLabel label_6 = new JLabel("Book ISBN:");

    JLabel lblPublisher = new JLabel("Publisher:");

    JLabel lblNumberOfPages = new JLabel("Number of pages:");

    JLabel label_7 = new JLabel("Year of publication:");

    upBookYearTx = new JTextField();
    upBookYearTx.setColumns(10);

    JLabel label_8 = new JLabel("Edition number:");

    upEditionTx = new JTextField();
    upEditionTx.setColumns(10);

    JLabel label_9 = new JLabel("Abstract:");

    upAbstractTx = new JTextField();
    upAbstractTx.setColumns(10);

    JLabel label_10 = new JLabel("Keywords:");

    upKeywordsTx = new JTextField();
    upKeywordsTx.setColumns(10);

    JLabel label_11 = new JLabel("Authors:");

    upAuthorTx1 = new JTextField();
    upAuthorTx1.setColumns(10);

    upAuthorTx3 = new JTextField();
    upAuthorTx3.setColumns(10);

    upAuthorTx5 = new JTextField();
    upAuthorTx5.setColumns(10);

    upAuthorTx4 = new JTextField();
    upAuthorTx4.setColumns(10);

    upAuthorTx2 = new JTextField();
    upAuthorTx2.setColumns(10);

    upBookTitleTx = new JTextField();
    upBookTitleTx.setColumns(10);

    upISBN = new JTextField();
    upISBN.setColumns(10);

    upPublisherTx = new JTextField();
    upPublisherTx.setColumns(10);

    upPagesTx = new JTextField();
    upPagesTx.setColumns(10);

    JButton btnNewButton_3 = new JButton("Update");
    btnNewButton_3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        // get validate input, put it as a book object
        String isbn = upISBN.getText();
        String newTitle = upBookTitleTx.getText();
        String newPublisher = upPublisherTx.getText();
        int newPage = checkHelper.checkIfNumerical(upPagesTx);
        int newEdition = checkHelper.checkIfNumerical(upEditionTx);
        String newAbstract = upAbstractTx.getText();
        int newYear = checkHelper.checkIfNumerical(upBookYearTx);
        String newAllKeywords = upKeywordsTx.getText();

        boolean success = true;

        List<String> newAuthors = new ArrayList<String>();
        List<String> newKeywordsArr = new ArrayList<String>();
        String[] newKeywords = {};

        if (!newAllKeywords.equals("")) {
          if (newAllKeywords.contains(",")) {
            newKeywords = newAllKeywords.split("\\s*,\\s*");
          } else {
            newKeywords = (newAllKeywords + ",").split(",");
          }
        }
        for (String k : newKeywords) {
          newKeywordsArr.add(k);
        }

        if (!upAuthorTx1.getText().equals("")) {
          success = (success && checkHelper.checkNameFormat(upAuthorTx1.getText()));
          newAuthors.add(upAuthorTx1.getText());
        }
        if (!upAuthorTx2.getText().equals("")) {
          success = (success && checkHelper.checkNameFormat(upAuthorTx2.getText()));
          success = (success && !checkHelper.duplicateAuthor(upAuthorTx2.getText(), newAuthors));
          newAuthors.add(upAuthorTx2.getText());
        }
        if (!upAuthorTx3.getText().equals("")) {
          success = (success && checkHelper.checkNameFormat(upAuthorTx3.getText()));
          success = (success && !checkHelper.duplicateAuthor(upAuthorTx3.getText(), newAuthors));
          newAuthors.add(upAuthorTx3.getText());
        }
        if (!upAuthorTx4.getText().equals("")) {
          success = (success && checkHelper.checkNameFormat(upAuthorTx4.getText()));
          success = (success && !checkHelper.duplicateAuthor(upAuthorTx4.getText(), newAuthors));
          newAuthors.add(upAuthorTx4.getText());
        }
        if (!upAuthorTx5.getText().equals("")) {
          success = (success && checkHelper.checkNameFormat(upAuthorTx5.getText()));
          success = (success && !checkHelper.duplicateAuthor(upAuthorTx5.getText(), newAuthors));
          newAuthors.add(upAuthorTx5.getText());
        }
        if (!success) {
          JOptionPane.showMessageDialog(null, "Wrong name format or duplicate author name entered", "fail update book",
              JOptionPane.ERROR_MESSAGE);
        }
        if (newEdition < 0 && !upEditionTx.getText().equals("")) {
          success = false;
          JOptionPane.showMessageDialog(null, "Wrong format for edition", "fail update book",
              JOptionPane.ERROR_MESSAGE);
        }
        // check if all the mandatory fields are filled in
        // if mandatory field is empty, do nothing
        // if isbn changed, pop up said cannot changed
//        if (!upISBN.getText().equals("")) {
//          if (!oldBook.isbn.equalsIgnoreCase(newIsbn)) {
//            JOptionPane.showMessageDialog(null, "Cannot change book ISBN", "fail update book",
//                JOptionPane.ERROR_MESSAGE);
//            success = false;
//          }
//        }

        if (upAuthorTx1.getText().equals("") && upAuthorTx2.getText().equals("") && upAuthorTx3.getText().equals("")
            && upAuthorTx4.getText().equals("") && upAuthorTx5.getText().equals("")) {
          JOptionPane.showMessageDialog(null, "Should have at least one author", "fail update book",
              JOptionPane.ERROR_MESSAGE);
          success = false;
        }

        /* --- Data->update->book --- */
        if (success) {
          try {
            con.setAutoCommit(false);
            if (!newTitle.equals("") && !oldBook.compareTitle(newTitle)) {
              // update title
              UpdateHelper.updateBookString(newTitle, isbn, "title", con);
            }
            if (!newPublisher.equals("") && !oldBook.comparePublisher(newPublisher)) {
              // update publisher
              UpdateHelper.updateBookString(newPublisher, isbn, "publisher", con);
            }
            if (!upPagesTx.getText().equals("") && !oldBook.comparePages(newPage)) {
              // update page with check
              if (newPage >= 0) {
                UpdateHelper.updateBookInt(newPage, isbn, "Numberofpages", con);
              }
            }
            if (upEditionTx.getText().equals("")) {
              // remove edition
              UpdateHelper.updateBookInt(-1, isbn, "editionnumber", con);
            } else if (!upEditionTx.getText().equals("") && !oldBook.compareEdition(newEdition)) {
              // update edition with check
              if (newEdition >= 0) {
                UpdateHelper.updateBookInt(newEdition, isbn, "editionnumber", con);
              }
            }
            if (!oldBook.compareAbstract(newAbstract)) {
              // update abstract
              UpdateHelper.updateBookString(newAbstract, isbn, "abstract", con);
            }
            if (!upBookYearTx.getText().equals("") && !oldBook.compareYear(newYear)) {
              // update year with check
              if (newYear > 0) {
                UpdateHelper.updateBookInt(newYear, isbn, "yearofpublication", con);
              }
            }
            List<String> delAuthor = new ArrayList<String>();
            List<String> insertAuthor = new ArrayList<String>(newAuthors);
            // check author list
            if (!oldBook.compareAuthor(newAuthors)) {
              if (newAuthors.size() == 0) {
                // do nothing, remain old data
                JOptionPane.showMessageDialog(null, "Must have at least one author", "updated failed",
                    JOptionPane.ERROR_MESSAGE);
                success = false;
              } else {
                // get the list for update
                for (String authorName : newAuthors) {
                  if (!oldBook.getAuthors().contains(authorName)) {
                    // old book don't have this new name, should be added
                    
                  } else {
                    // old book contain this name, no need to insert
                    insertAuthor.remove(authorName);
                  }
                }
                for (String authorName : oldBook.getAuthors()) {
                  if (!newAuthors.contains(authorName)) {
                    // newauthors doesn't have this name from oldbook, should be deleted
                    delAuthor.add(authorName);
                  }
                }
              }
              // do update for authors
              if (delAuthor.size() > 0) {
                // delete author
                DeleteHelper.deleteBookAuthors(isbn, delAuthor, con);
              }
              if (insertAuthor.size() > 0) {
                InserterHelper.insertBookAuthor(isbn, insertAuthor, con);
              }
            }

            List<String> delkey = new ArrayList<String>();
            List<String> insertkey = new ArrayList<String>(newKeywordsArr);
            // check keyword list
            // do update for keywords
            if (delkey.size() > 0) {
              DeleteHelper.deleteBookKeywords(isbn, delkey, con);
            }
            if (upKeywordsTx.getText().equals("")) {
              DeleteHelper.removeBookKeyword(isbn, con);
            }
            if (insertkey.size() > 0) {
              DeleteHelper.removeBookKeyword(isbn, con);
              InserterHelper.insertBookKeyword(isbn, insertkey, con);
            }

            con.commit();
            if (success) {
              JOptionPane.showMessageDialog(null, "Successfully updated", "Successfully updated",
                  JOptionPane.INFORMATION_MESSAGE);
            }
            CardLayout c = (CardLayout) (frame.getContentPane().getLayout());
            c.show(frame.getContentPane(), "mainPage");
          } catch (SQLException e) {
            try {
              System.out.println("rollback");
              con.rollback();
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
        }

      }
    });

    JLabel lblChangeTheValues = new JLabel("Change the values and click update to update the information of this book");
    lblChangeTheValues.setFont(new Font("Tahoma", Font.PLAIN, 16));

    JButton btnCancel_3 = new JButton("Cancel");
    btnCancel_3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        CardLayout c = (CardLayout) (frame.getContentPane().getLayout());
        c.show(frame.getContentPane(), "mainPage");
      }
    });
    GroupLayout gl_updateBook = new GroupLayout(updateBook);
    gl_updateBook
        .setHorizontalGroup(gl_updateBook.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_updateBook.createSequentialGroup()
                .addGroup(gl_updateBook.createParallelGroup(Alignment.LEADING)
                    .addGroup(
                        gl_updateBook.createSequentialGroup().addGap(31).addComponent(lblChangeTheValues))
                    .addGroup(gl_updateBook.createSequentialGroup().addGap(131).addGroup(gl_updateBook
                        .createParallelGroup(Alignment.LEADING).addGroup(gl_updateBook
                            .createSequentialGroup().addGroup(gl_updateBook.createParallelGroup(Alignment.LEADING)
                                .addComponent(lblNewLabel_2).addComponent(label_6, GroupLayout.PREFERRED_SIZE, 63,
                                    GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPublisher))
                            .addGap(53)
                            .addGroup(gl_updateBook
                                .createParallelGroup(Alignment.LEADING)
                                .addComponent(upPublisherTx, GroupLayout.PREFERRED_SIZE, 298,
                                    GroupLayout.PREFERRED_SIZE)
                                .addComponent(upISBN, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)
                                .addComponent(upBookTitleTx, GroupLayout.PREFERRED_SIZE, 298,
                                    GroupLayout.PREFERRED_SIZE)))
                        .addGroup(gl_updateBook.createSequentialGroup().addGroup(gl_updateBook
                            .createParallelGroup(Alignment.LEADING)
                            .addGroup(gl_updateBook.createSequentialGroup()
                                .addComponent(label_8, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                .addGap(25)
                                .addComponent(upEditionTx, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE))
                            .addGroup(gl_updateBook.createSequentialGroup()
                                .addComponent(label_9, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                .addGap(64).addComponent(upAbstractTx, GroupLayout.PREFERRED_SIZE, 298,
                                    GroupLayout.PREFERRED_SIZE))
                            .addGroup(gl_updateBook.createSequentialGroup()
                                .addComponent(label_10, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addGap(56).addComponent(upKeywordsTx, GroupLayout.PREFERRED_SIZE, 298,
                                    GroupLayout.PREFERRED_SIZE))
                            .addGroup(gl_updateBook.createSequentialGroup()
                                .addComponent(label_11, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                .addGap(67)
                                .addComponent(upAuthorTx1, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                                .addGap(23)
                                .addComponent(upAuthorTx2, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
                            .addGroup(gl_updateBook.createSequentialGroup().addGap(116).addComponent(upAuthorTx5,
                                GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
                            .addGroup(gl_updateBook.createSequentialGroup()
                                .addComponent(label_7, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                                .addGap(5).addComponent(upBookYearTx, GroupLayout.PREFERRED_SIZE, 298,
                                    GroupLayout.PREFERRED_SIZE))
                            .addGroup(gl_updateBook.createParallelGroup(Alignment.LEADING)
                                .addGroup(Alignment.TRAILING,
                                    gl_updateBook.createSequentialGroup().addComponent(btnNewButton_3).addGap(18)
                                        .addComponent(btnCancel_3))
                                .addGroup(gl_updateBook.createSequentialGroup().addGap(116)
                                    .addComponent(upAuthorTx3, GroupLayout.PREFERRED_SIZE, 138,
                                        GroupLayout.PREFERRED_SIZE)
                                    .addGap(23).addComponent(upAuthorTx4, GroupLayout.PREFERRED_SIZE, 138,
                                        GroupLayout.PREFERRED_SIZE)))
                            .addGroup(gl_updateBook.createSequentialGroup().addComponent(lblNumberOfPages)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(upPagesTx, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)))
                            .addGap(13)))))
                .addContainerGap(295, Short.MAX_VALUE)));
    gl_updateBook.setVerticalGroup(gl_updateBook.createParallelGroup(Alignment.LEADING).addGroup(gl_updateBook
        .createSequentialGroup().addContainerGap().addComponent(lblChangeTheValues).addGap(34)
        .addGroup(gl_updateBook.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_updateBook.createSequentialGroup().addComponent(lblNewLabel_2).addGap(18)
                .addGroup(gl_updateBook.createParallelGroup(Alignment.BASELINE).addComponent(label_6).addComponent(
                    upISBN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18)
                .addGroup(gl_updateBook.createParallelGroup(Alignment.BASELINE).addComponent(lblPublisher).addComponent(
                    upPublisherTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
            .addComponent(upBookTitleTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(ComponentPlacement.UNRELATED)
        .addGroup(gl_updateBook.createParallelGroup(Alignment.BASELINE).addComponent(lblNumberOfPages)
            .addComponent(upPagesTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        .addGap(18)
        .addGroup(gl_updateBook.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_updateBook.createSequentialGroup().addGap(3).addComponent(label_7)).addComponent(upBookYearTx,
                GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        .addGap(18)
        .addGroup(gl_updateBook.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_updateBook.createSequentialGroup().addGap(3).addComponent(label_8)).addComponent(upEditionTx,
                GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        .addGap(18)
        .addGroup(gl_updateBook.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_updateBook.createSequentialGroup().addGap(3).addComponent(label_9)).addComponent(upAbstractTx,
                GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        .addGap(18)
        .addGroup(gl_updateBook.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_updateBook.createSequentialGroup().addGap(3).addComponent(label_10)).addComponent(upKeywordsTx,
                GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        .addGap(18)
        .addGroup(
            gl_updateBook.createParallelGroup(Alignment.LEADING).addComponent(label_11)
                .addComponent(upAuthorTx1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                    GroupLayout.PREFERRED_SIZE)
                .addComponent(upAuthorTx2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                    GroupLayout.PREFERRED_SIZE))
        .addGap(7)
        .addGroup(
            gl_updateBook.createParallelGroup(Alignment.LEADING)
                .addComponent(upAuthorTx3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                    GroupLayout.PREFERRED_SIZE)
                .addComponent(upAuthorTx4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                    GroupLayout.PREFERRED_SIZE))
        .addGap(7)
        .addComponent(upAuthorTx5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        .addGap(40).addGroup(gl_updateBook.createParallelGroup(Alignment.BASELINE).addComponent(btnCancel_3)
            .addComponent(btnNewButton_3))
        .addContainerGap(108, Short.MAX_VALUE)));
    updateBook.setLayout(gl_updateBook);

    musicTracks = new ArrayList<MusicTrack>();

    String[] movieCastRoles = { "director", "script writer", "cast", "producer", "composer", "editor",
        "costume designer" };

    ButtonGroup castGenderGroup = new ButtonGroup();

    JPanel updateAlbum = new JPanel();
    frame.getContentPane().add(updateAlbum, "updateAlbum");

    JLabel lblUpdateByChanging = new JLabel(
        "Update by changing the data in the fields. Double click the music track to change the info of music.");

    JLabel label_23 = new JLabel(
        "Name of people who involved should be in the format of 'first_name family_name' or 'first_name middle_name family_name'");

    JLabel lblThereShouldBe_1 = new JLabel("There should be at least one music track for an album.");

    JLabel label_25 = new JLabel("Producer:");

    textField = new JTextField();
    textField.setColumns(10);

    JLabel label_26 = new JLabel("Music Tracks:");

    JButton upAddBtn = new JButton("Add a music track");
    upAddBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        CreateFrameMusicTrack createFrame = new CreateFrameMusicTrack(musicTracks, true);
      }
    });

    JLabel label_27 = new JLabel("Album name:");

    JLabel label_28 = new JLabel("Year:");

    JLabel label_29 = new JLabel("Producer:");

    upAlbumTx = new JTextField();
    upAlbumTx.setColumns(10);

    upProducerTx = new JTextField();
    upProducerTx.setColumns(10);

    upYearTx = new JTextField();
    upYearTx.setColumns(10);

    JButton button_6 = new JButton("Cancel");

    JButton button_7 = new JButton("Update");
    button_7.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String albumName = null, producer = null;
        int year = -1;

        // check all fields are filled in or not
        if (upAlbumTx.getText().equals("") || upYearTx.getText().equals("") || upProducerTx.getText().equals("")) {
          // show error - mandatory fields
          JOptionPane.showMessageDialog(null, "fill in all mandatory fields and in correct format",
              "Update music - wrong format", JOptionPane.ERROR_MESSAGE);
        } else if (checkHelper.checkIfNumerical(upYearTx) <= 0) {
          JOptionPane.showMessageDialog(null, "fill in the year in correct range", "Update music - wrong range",
              JOptionPane.ERROR_MESSAGE);
        } else if (tracks.isEmpty()) {
          JOptionPane.showMessageDialog(null, "You should have at least one music track",
              "Update music - no music track", JOptionPane.ERROR_MESSAGE);
        } else {
          // get the string values
          albumName = upAlbumTx.getText();
          year = Integer.parseInt(upYearTx.getText());
          producer = upProducerTx.getText();
          if (!checkHelper.checkNameFormat(producer)) {
            JOptionPane.showMessageDialog(null, "fill in the producer name in correct format",
                "Update music - wrong name format", JOptionPane.ERROR_MESSAGE);
          } else {
            String newName = albumName, newProducer = producer;
            int newYear = year;
            boolean changedn = false, changedy = false, changedp = false;
            String oldAlbumName = oldAlbum.getAlbumName();
            int oldYear = oldAlbum.getYear();
            // check if the album name the same
            if (!oldAlbum.compareAlbumName(albumName)) {
              // check if the music album exist in Music
              if (!checkHelper.albumExist(albumName, con)) {
                // update the album name for all music tracks
                changedn = true;
              } else {
                JOptionPane.showMessageDialog(null, "This album name already existed",
                    "Update album name - already existed", JOptionPane.ERROR_MESSAGE);
              }
            }
            // check if the year the same
            if (!oldAlbum.compareYear(year)) {
              changedy = true;
            }
            // check if the producer the same
            if (!oldAlbum.compareProducer(producer)) {
              changedp = true;
              // update
            }

            /* --- Data->update->album --- */
            // update album transaction --------------
            try {
              con.setAutoCommit(false);
              // if there are music tracks are added/deleted, do that
              if (changedp) {
                // only update the producer in table music
                UpdateHelper.updateMusicProducer(albumName, producer, con);
              }
              if (changedn && changedy) { // if album name and year is changed
                for (MusicTrack t : tracks.values()) {
                  InserterHelper.insertAlbum(newName, newYear, t.getMusicName(), t.getLanguage(), t.getType(), newProducer, con);
                  UpdateHelper.updateAlbumNameSinger(oldAlbumName, oldYear, newName, newYear, t.getMusicName(), con);
                  UpdateHelper.updateAlbumNameCrew(oldAlbumName, oldYear, newName, newYear, t.getMusicName(), con);
                  DeleteHelper.removeMusic(oldAlbumName, t.getMusicName(), con);
                }
              } else if (changedn) { // if album name is changed
                for (MusicTrack t : tracks.values()) {
                  InserterHelper.insertAlbum(newName, newYear, t.getMusicName(), t.getLanguage(), t.getType(), newProducer, con);
                  UpdateHelper.updateAlbumNameSinger(oldAlbumName, oldYear, newName, newYear, t.getMusicName(), con);
                  UpdateHelper.updateAlbumNameCrew(oldAlbumName, oldYear, newName, newYear, t.getMusicName(), con);
                  DeleteHelper.removeMusic(oldAlbumName, t.getMusicName(), con);
                }
              } else if (changedy) { // if album year is changed
                for (MusicTrack t : tracks.values()) {
                  InserterHelper.insertAlbum(newName, newYear, t.getMusicName(), t.getLanguage(), t.getType(), newProducer, con);
                  UpdateHelper.updateAlbumNameSinger(oldAlbumName, oldYear, newName, newYear, t.getMusicName(), con);
                  UpdateHelper.updateAlbumNameCrew(oldAlbumName, oldYear, newName, newYear, t.getMusicName(), con);
                  DeleteHelper.removeMusicByYear(oldAlbumName, oldYear, t.getMusicName(), con);
                }
              }
              con.commit();
              JOptionPane.showMessageDialog(null, "Album has been updated", "Update album successfully",
                  JOptionPane.INFORMATION_MESSAGE);
              CardLayout c = (CardLayout) (frame.getContentPane().getLayout());
              c.show(frame.getContentPane(), "mainPage");
            } catch (SQLException e1) {
              try {
                con.rollback();
              } catch (SQLException e2) {
                e2.printStackTrace();
              }
              System.out.println("rollback");
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

    JList upTrackList = new JList();
    upTrackList.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent evt) {
        JList list = (JList) evt.getSource();
        if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2) {
          // Double-click detected
          int index = list.locationToIndex(evt.getPoint());
          String musicName = model.getElementAt(index);
          MusicTrack mt = tracks.get(musicName);
          CreateFrameMusicTrack createFrame = new CreateFrameMusicTrack(mt);
        }
        if (evt.getButton() == MouseEvent.BUTTON3 && evt.getClickCount() == 2) {
          int dialogButton = JOptionPane.YES_NO_OPTION;
          int dialogResult = JOptionPane.showConfirmDialog(null, "Would You Like to delete this music track?",
              "Comfirm", dialogButton);
          if (dialogResult == JOptionPane.YES_OPTION) {
            // get the music track, delete it
            int index = list.locationToIndex(evt.getPoint());
            String musicName = model.getElementAt(index);
            MusicTrack mt = tracks.get(musicName);
            try {
              con.setAutoCommit(false);
              DeleteHelper.removeOneMusicTrack(oldAlbum, mt, con);
            } catch (SQLException e) {
              try {
                con.rollback();
              } catch (SQLException e1) {
                e1.printStackTrace();
              }
              System.out.println("rollback");
              e.printStackTrace();
            } finally {
              try {
                con.setAutoCommit(true);
              } catch (SQLException e) {
                e.printStackTrace();
              }
            }
            // update the tracks and album music tracks list
            tracks.remove(mt.getMusicName());
            model.removeElement(mt.getMusicName());
            JOptionPane.showMessageDialog(null, "Music track has been removed", "Remove successfully",
                JOptionPane.INFORMATION_MESSAGE);
          }
        }
      }
    });

    JLabel lblDoubleRightClick = new JLabel("Double right click the music track can removed from this album.");
    GroupLayout gl_updateAlbum = new GroupLayout(updateAlbum);
    gl_updateAlbum
        .setHorizontalGroup(gl_updateAlbum.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_updateAlbum.createSequentialGroup()
                .addGroup(gl_updateAlbum.createParallelGroup(Alignment.LEADING)
                    .addGroup(gl_updateAlbum.createSequentialGroup().addGap(52).addComponent(lblUpdateByChanging))
                    .addGroup(gl_updateAlbum.createSequentialGroup().addGap(52)
                        .addGroup(gl_updateAlbum.createParallelGroup(Alignment.LEADING).addComponent(label_23)
                            .addComponent(lblThereShouldBe_1).addComponent(lblDoubleRightClick)))
                    .addGroup(gl_updateAlbum
                        .createSequentialGroup().addGap(289).addComponent(label_25).addGap(39)
                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE))
                    .addGroup(gl_updateAlbum.createSequentialGroup().addGap(195)
                        .addGroup(gl_updateAlbum.createParallelGroup(Alignment.LEADING).addComponent(upAddBtn)
                            .addGroup(gl_updateAlbum
                                .createSequentialGroup().addComponent(button_6).addGap(18).addComponent(button_7))
                            .addComponent(label_26)
                            .addGroup(gl_updateAlbum.createParallelGroup(Alignment.LEADING, false)
                                .addComponent(upTrackList, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                    Short.MAX_VALUE)
                                .addGroup(gl_updateAlbum.createSequentialGroup()
                                    .addGroup(gl_updateAlbum.createParallelGroup(Alignment.LEADING, false)
                                        .addComponent(label_27, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                            Short.MAX_VALUE)
                                        .addComponent(label_28).addComponent(label_29))
                                    .addPreferredGap(ComponentPlacement.UNRELATED)
                                    .addGroup(gl_updateAlbum.createParallelGroup(Alignment.LEADING, false)
                                        .addComponent(upProducerTx).addComponent(upYearTx).addComponent(upAlbumTx,
                                            GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(102, Short.MAX_VALUE)));
    gl_updateAlbum.setVerticalGroup(gl_updateAlbum.createParallelGroup(Alignment.LEADING).addGroup(gl_updateAlbum
        .createSequentialGroup().addGap(38).addComponent(lblUpdateByChanging).addGap(11)
        .addComponent(lblThereShouldBe_1).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(label_23)
        .addGap(13).addComponent(lblDoubleRightClick).addGap(18)
        .addGroup(gl_updateAlbum.createParallelGroup(Alignment.BASELINE).addComponent(label_27).addComponent(upAlbumTx,
            GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(ComponentPlacement.UNRELATED)
        .addGroup(gl_updateAlbum.createParallelGroup(Alignment.BASELINE).addComponent(label_28).addComponent(upYearTx,
            GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(ComponentPlacement.UNRELATED)
        .addGroup(gl_updateAlbum.createParallelGroup(Alignment.BASELINE).addComponent(label_29).addComponent(
            upProducerTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        .addGap(30).addComponent(label_26).addGap(18)
        .addComponent(upTrackList, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE).addGap(27)
        .addComponent(upAddBtn).addGap(84)
        .addGroup(gl_updateAlbum.createParallelGroup(Alignment.BASELINE).addComponent(button_7).addComponent(button_6))
        .addGap(55)
        .addGroup(gl_updateAlbum.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_updateAlbum.createSequentialGroup().addGap(376).addComponent(label_25))
            .addGroup(gl_updateAlbum.createSequentialGroup().addGap(373).addComponent(textField,
                GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
    updateAlbum.setLayout(gl_updateAlbum);

    JPanel updateMovie = new JPanel();
    frame.getContentPane().add(updateMovie, "updateMovie");

    JLabel label_12 = new JLabel(
        "There should be at least one people for each role. At most 10 for cast, at most 3 otherwise.");

    JLabel label_13 = new JLabel("Please fill in all the madatory fields.");

    JLabel label_14 = new JLabel("Crew:");

    JLabel label_15 = new JLabel("Cast:");

    JButton button_5 = new JButton("Update");
    button_5.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        // check all the fields are filled in correctly
        String movieName = null;
        int year = checkHelper.checkIfNumerical(upMovieYearTx);
        // validate input fields
        if (upMovieNameTx.getText().equals("") || upMovieYearTx.getText().equals("")
            || checkHelper.checkIfEmptyCrew(crews)) {
          JOptionPane.showMessageDialog(null, "Please fill in all the fields with at least one people in each role",
              "Insert movie - incomplete input", JOptionPane.ERROR_MESSAGE);
        } else if (year < 0) {
          JOptionPane.showMessageDialog(null, "Year in wrong range", "Insert movie - wrong range",
              JOptionPane.ERROR_MESSAGE);
        } else {
          // get all the input
          movieName = upMovieNameTx.getText();
          boolean changedn = false, changedy = false, valid = true;

          /* --- Data->update->movie --- */
          // delete all the movieCrew, insert all the crew in tempcrew
          try {
            con.setAutoCommit(false);
            // delete movie crew and award
            DeleteHelper.removeMovieCrew(oldMovie.getMovieName(), con);
            DeleteHelper.removeMovieAward(oldMovie.getMovieName(), con);
            // if movie name / year is changed
            if (!oldMovie.compareMovie(movieName)) {
              changedn = true;
            }
            if (!oldMovie.compareYear(year)) {
              changedy = true;
            }
            // check if movie name already exist if changed
            if (changedy && !changedn) {
              // just update the year
              UpdateHelper.updateMovieInfo(oldMovie.getMovieName(), movieName, year, con);
            } else if (changedn) {
              if (!checkHelper.movieExist(movieName, con)) {
                UpdateHelper.updateMovieInfo(oldMovie.getMovieName(), movieName, year, con);
              } else {
                valid = false;
                JOptionPane.showMessageDialog(null, "Movie already exist", "Update movie - movie exist",
                    JOptionPane.ERROR_MESSAGE);
              }
            }

            if (valid) {
              InserterHelper.insertCrewMember(movieName, year, tempcrew, con);
              InserterHelper.insertAward(movieName, year, tempcrew, con);
            }

            con.commit();
            JOptionPane.showMessageDialog(null, "Movie updated", "Update movie successfully",
                JOptionPane.INFORMATION_MESSAGE);
          } catch (SQLException e) {
            try {
              con.rollback();
            } catch (SQLException e1) {
              e1.printStackTrace();
            }
            System.out.println("rollback");
            e.printStackTrace();
          } finally {
            try {
              con.setAutoCommit(true);
            } catch (SQLException e) {
              e.printStackTrace();
            }
          }

          CardLayout c = (CardLayout) (frame.getContentPane().getLayout());
          c.show(frame.getContentPane(), "mainPage");

        }
      }
    });

    JButton button_8 = new JButton("Cancel");
    button_8.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        CardLayout c = (CardLayout) (frame.getContentPane().getLayout());
        c.show(frame.getContentPane(), "mainPage");
      }
    });

    JLabel label_16 = new JLabel("Release year:");

    JLabel label_17 = new JLabel("Movie name:");

    upMovieNameTx = new JTextField();
    upMovieNameTx.setColumns(10);

    upMovieYearTx = new JTextField();
    upMovieYearTx.setColumns(10);

    JButton button_10 = new JButton("Add new crew or cast");
    button_10.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        CreateFrameMovieCrew createFrameMovieCrew = new CreateFrameMovieCrew(crews, true);
      }
    });

    JScrollPane scrollPane = new JScrollPane();

    JScrollPane scrollPane_2 = new JScrollPane();
    GroupLayout gl_updateMovie = new GroupLayout(updateMovie);
    gl_updateMovie.setHorizontalGroup(gl_updateMovie.createParallelGroup(Alignment.LEADING).addGroup(gl_updateMovie
        .createSequentialGroup().addGap(68)
        .addGroup(gl_updateMovie.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_updateMovie.createSequentialGroup()
                .addComponent(button_10, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE).addContainerGap())
            .addGroup(gl_updateMovie.createSequentialGroup().addGroup(gl_updateMovie
                .createParallelGroup(Alignment.LEADING)
                .addGroup(gl_updateMovie.createParallelGroup(Alignment.LEADING, false)
                    .addGroup(
                        gl_updateMovie.createSequentialGroup()
                            .addComponent(label_16, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                            .addGap(18).addComponent(upMovieYearTx))
                    .addGroup(gl_updateMovie.createSequentialGroup()
                        .addComponent(label_17, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE).addGap(23)
                        .addComponent(upMovieNameTx, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)))
                .addComponent(label_13, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
                .addComponent(label_12, GroupLayout.PREFERRED_SIZE, 526, GroupLayout.PREFERRED_SIZE)
                .addGroup(gl_updateMovie.createSequentialGroup()
                    .addGroup(gl_updateMovie.createParallelGroup(Alignment.LEADING)
                        .addComponent(label_14, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                    .addGroup(gl_updateMovie.createParallelGroup(Alignment.LEADING)
                        .addComponent(label_15, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addGroup(gl_updateMovie.createParallelGroup(Alignment.TRAILING)
                            .addGroup(gl_updateMovie.createSequentialGroup()
                                .addComponent(button_5, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(button_8, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
                            .addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(ComponentPlacement.RELATED)))
                .addContainerGap(110, GroupLayout.PREFERRED_SIZE)))));
    gl_updateMovie.setVerticalGroup(gl_updateMovie.createParallelGroup(Alignment.LEADING).addGroup(gl_updateMovie
        .createSequentialGroup().addGap(40).addComponent(label_13).addGap(18).addComponent(label_12).addGap(18)
        .addGroup(gl_updateMovie.createParallelGroup(Alignment.TRAILING).addGroup(gl_updateMovie.createSequentialGroup()
            .addGroup(gl_updateMovie.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_updateMovie.createSequentialGroup().addGap(3).addComponent(label_17)).addComponent(
                    upMovieNameTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGroup(gl_updateMovie.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_updateMovie.createSequentialGroup().addGap(30).addComponent(label_16))
                .addGroup(gl_updateMovie.createSequentialGroup().addGap(27).addComponent(upMovieYearTx,
                    GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
            .addGap(34).addComponent(label_14).addGap(18)
            .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE).addGap(18)
            .addComponent(button_10).addGap(68).addGroup(
                gl_updateMovie.createParallelGroup(Alignment.BASELINE).addComponent(button_8).addComponent(button_5)))
            .addGroup(gl_updateMovie.createSequentialGroup().addComponent(label_15).addGap(18)
                .addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE).addGap(136)))
        .addContainerGap(50, Short.MAX_VALUE)));

    JList upCastList = new JList();
    upCastList.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent evt) {
        JList list = (JList) evt.getSource();
        if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2) {
          // Double-click detected
          int index = list.locationToIndex(evt.getPoint());
          MovieCrew mc = null;
          String[] modelString = model2.getElementAt(index).split("---");
          String crewName = modelString[0];
          for (MovieCrew m : tempcrew.get("cast")) {
            if (m.compareName(crewName)) {
              mc = m;
              break;
            }
          }
          CreateFrameMovieCrew createFrame = new CreateFrameMovieCrew(mc);
        }
        if (evt.getButton() == MouseEvent.BUTTON3 && evt.getClickCount() == 2) {
          int dialogButton = JOptionPane.YES_NO_OPTION;
          int dialogResult = JOptionPane.showConfirmDialog(null, "Would You Like to delete this movie crew?", "Comfirm",
              dialogButton);
          if (dialogResult == JOptionPane.YES_OPTION) {
            // get the movie crew, delete it
            int index = list.locationToIndex(evt.getPoint());
            String movieCrew = model2.getElementAt(index);
            String[] temp = movieCrew.split("---");
            String crewname = temp[0];
            String crewrole = temp[1];

            if (tempcrew.get("cast").size() > 1) {
              for (MovieCrew mc : tempcrew.get("cast")) {
                if (mc.getCrewName().equalsIgnoreCase(crewname)) {
                  // remove from tempcrew list
                  tempcrew.get("cast").remove(mc);
                  model2.removeElement(mc.getCrewName() + "---cast");
                  JOptionPane.showMessageDialog(null, "Movie cast has been removed", "Remove successfully",
                      JOptionPane.INFORMATION_MESSAGE);
                  break;
                }
              }
            } else {
              JOptionPane.showMessageDialog(null, "You should have at least one cast for each movie", "Remove fail",
                  JOptionPane.ERROR_MESSAGE);
            }
          }
        }
      }
    });

    scrollPane_2.setViewportView(upCastList);

    JList upCrewList = new JList();
    upCrewList.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent evt) {
        JList list = (JList) evt.getSource();
        if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2) {
          // Double-click detected
          int index = list.locationToIndex(evt.getPoint());
          MovieCrew mc = null;
          String[] modelString = model.getElementAt(index).split("---");
          String crewName = modelString[0];
          for (List<MovieCrew> crewlist : tempcrew.values()) {
            for (MovieCrew m : crewlist)
              if (m.compareName(crewName)) {
                mc = m;
                break;
              }
          }
          CreateFrameMovieCrew createFrame = new CreateFrameMovieCrew(mc);
        }
        if (evt.getButton() == MouseEvent.BUTTON3 && evt.getClickCount() == 2) {
          int dialogButton = JOptionPane.YES_NO_OPTION;
          int dialogResult = JOptionPane.showConfirmDialog(null, "Would You Like to delete this crew?", "Comfirm",
              dialogButton);
          if (dialogResult == JOptionPane.YES_OPTION) {
            // get the movie crew, delete it from the tempcrew list
            int index = list.locationToIndex(evt.getPoint());
            String movieCrew = model.getElementAt(index);
            String[] temp = movieCrew.split("---");
            String crewname = temp[0];
            String crewrole = temp[1];

            if (tempcrew.get(crewrole).size() > 1) {
              for (MovieCrew mc : tempcrew.get(crewrole)) {
                if (mc.getCrewName().equalsIgnoreCase(crewname)) {
                  // remove from tempcrew list
                  tempcrew.get(crewrole).remove(mc);
                  model.removeElement(mc.getCrewName() + "---" + crewrole);
                  JOptionPane.showMessageDialog(null, "Movie cast has been removed", "Remove successfully",
                      JOptionPane.INFORMATION_MESSAGE);
                  break;
                }
              }
            } else {
              JOptionPane.showMessageDialog(null, "You should have at least one cast for each movie", "Remove fail",
                  JOptionPane.ERROR_MESSAGE);
            }

          }
        }
      }
    });

    scrollPane.setViewportView(upCrewList);
    updateMovie.setLayout(gl_updateMovie);

    JPanel view = new JPanel();
    frame.getContentPane().add(view, "viewPanel");

    JLabel lblProductName = new JLabel("Product name:");

    searchNameTx = new JTextField();
    searchNameTx.setColumns(10);

    JLabel lblReleaseYear_3 = new JLabel("Release year:");

    searchYearTx = new JTextField();
    searchYearTx.setColumns(10);

    chckbxBook = new JCheckBox("Book");

    chckbxAlbum = new JCheckBox("Album");

    chckbxMovie = new JCheckBox("Movie");

    JButton btnNewButton_4 = new JButton("Search");
    btnNewButton_4.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // validate input fields
        String name = searchNameTx.getText();
        if (name.equals("") || checkHelper.checkIfNumerical(searchYearTx) < 0) {
          JOptionPane.showMessageDialog(null, "please enter valid information", "View - wrong infomation",
              JOptionPane.ERROR_MESSAGE);
        } else {
          int year = Integer.parseInt(searchYearTx.getText());
          ResultSet rs = null;
          try {
            // get selected types
            Map<String, Boolean> types = new HashMap<String, Boolean>();
            if (chckbxBook.isSelected()) {
              types.put("book", true);
            } else {
              types.put("book", false);
            }
            if (chckbxAlbum.isSelected()) {
              types.put("album", true);
            } else {
              types.put("album", false);
            }
            if (chckbxMovie.isSelected()) {
              types.put("movie", true);
            } else {
              types.put("movie", false);
            }
            // build result set
            rs = SelectHelper.createView(name, year, types, con);
            if (rs != null) {
              JTable table = new JTable(buildTableModel(rs));
              // show views
              JOptionPane.showMessageDialog(null, new JScrollPane(table), "Data Table Preview",
                  JOptionPane.INFORMATION_MESSAGE);
            } else {
              JOptionPane.showMessageDialog(null, "Please select at least one type (book, album, movie)",
                  "No selected data", JOptionPane.ERROR_MESSAGE);
            }
          } catch (SQLException e1) {

            e1.printStackTrace();
          }
        }
      }
    });

    JButton btnCancel = new JButton("Cancel");
    btnCancel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        clearViewFields();
      }
    });
    GroupLayout gl_view = new GroupLayout(view);
    gl_view.setHorizontalGroup(gl_view.createParallelGroup(Alignment.LEADING).addGroup(gl_view.createSequentialGroup()
        .addGap(75)
        .addGroup(gl_view.createParallelGroup(Alignment.LEADING).addComponent(lblProductName)
            .addComponent(lblReleaseYear_3).addComponent(chckbxBook))
        .addGap(43)
        .addGroup(gl_view.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_view.createSequentialGroup()
                .addComponent(searchYearTx, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE).addGap(58)
                .addComponent(btnNewButton_4).addGap(33).addComponent(btnCancel))
            .addGroup(gl_view.createSequentialGroup().addComponent(chckbxAlbum).addGap(59).addComponent(chckbxMovie))
            .addComponent(searchNameTx, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE))
        .addContainerGap(63, Short.MAX_VALUE)));
    gl_view.setVerticalGroup(gl_view.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_view.createSequentialGroup().addGap(44)
            .addGroup(gl_view.createParallelGroup(Alignment.BASELINE).addComponent(chckbxBook).addComponent(chckbxAlbum)
                .addComponent(chckbxMovie))
            .addGap(34)
            .addGroup(gl_view.createParallelGroup(Alignment.LEADING)
                .addComponent(searchNameTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                    GroupLayout.PREFERRED_SIZE)
                .addComponent(lblProductName))
            .addGap(22)
            .addGroup(gl_view.createParallelGroup(Alignment.BASELINE).addComponent(lblReleaseYear_3)
                .addComponent(searchYearTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                    GroupLayout.PREFERRED_SIZE)
                .addComponent(btnNewButton_4).addComponent(btnCancel))
            .addContainerGap(444, Short.MAX_VALUE)));
    view.setLayout(gl_view);

    JPanel AddMusicTrackPanel = new JPanel();
    frame.getContentPane().add(AddMusicTrackPanel, "AddMusicTrackPanel");

    JButton button_3 = new JButton("Submit");
    button_3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      }
    });

    JButton button_9 = new JButton("Cancel");

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

    JRadioButton radioButton_vinyl = new JRadioButton("vinyl");

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
                    .addGroup(
                        gl_AddMusicTrackPanel.createSequentialGroup()
                            .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.TRAILING, false)
                                .addComponent(label_47, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                    Short.MAX_VALUE)
                                .addComponent(label_48))
                            .addGap(39)
                            .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.TRAILING)
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
            .addContainerGap(325, Short.MAX_VALUE)));
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
                    .addContainerGap(224, Short.MAX_VALUE)));
    AddMusicTrackPanel.setLayout(gl_AddMusicTrackPanel);

    JPanel AddMovieCrewPanel = new JPanel();
    AddMovieCrewPanel.setOpaque(true);
    frame.getContentPane().add(AddMovieCrewPanel, "AddMovieCrewPanel");

    JButton button = new JButton("Submit");

    JLabel label_3 = new JLabel("Crews and casts");

    insCastNameTx = new JTextField();
    insCastNameTx.setColumns(10);

    JLabel lblGotAward = new JLabel("got award:");
    JCheckBox chckbxTickIfYes = new JCheckBox("Tick if yes");

    JButton button_4 = new JButton("Cancel");

    JLabel lblName = new JLabel("Name:");

    JLabel lblRole = new JLabel("Role:");

    JLabel lblGender = new JLabel("Gender:");

    JRadioButton rdbtnMale = new JRadioButton("male");
    JRadioButton rdbtnFemale = new JRadioButton("female");
    castGenderGroup.add(rdbtnMale);
    castGenderGroup.add(rdbtnFemale);

    JList insRoleTx = new JList(movieCastRoles);
    insRoleTx.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

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
            .addGroup(gl_AddMovieCrewPanel
                .createParallelGroup(Alignment.BASELINE).addComponent(lblGotAward).addComponent(chckbxTickIfYes))
            .addGap(18)
            .addGroup(
                gl_AddMovieCrewPanel.createParallelGroup(Alignment.LEADING).addComponent(button).addComponent(button_4))
            .addContainerGap(469, Short.MAX_VALUE)));
    AddMovieCrewPanel.setLayout(gl_AddMovieCrewPanel);

    JMenuBar menuBar = new JMenuBar();
    frame.setJMenuBar(menuBar);

    JMenu mnData = new JMenu("Data");
    menuBar.add(mnData);

    JMenu mnInsert = new JMenu("Insert");
    mnData.add(mnInsert);

    JMenuItem mntmBook = new JMenuItem("Book");
    mntmBook.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        // go to insert book page
        CardLayout c = (CardLayout) (frame.getContentPane().getLayout());
        c.show(frame.getContentPane(), "insertBook");
      }
    });
    mnInsert.add(mntmBook);

    JMenuItem mntmAlbum = new JMenuItem("Album");
    mntmAlbum.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        // go to insert book page
        CardLayout c = (CardLayout) (frame.getContentPane().getLayout());
        c.show(frame.getContentPane(), "insertAlbum2");
        // clear the musicTrack list
        musicTracks.clear();
      }
    });
    mnInsert.add(mntmAlbum);

    JMenuItem mntmMovie = new JMenuItem("Movie");
    mntmMovie.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        crews.clear();
        for (String role : movieCastRoles) {
          crews.put(role, new ArrayList<MovieCrew>());
        }
        // go to insert book page
        CardLayout c = (CardLayout) (frame.getContentPane().getLayout());
        c.show(frame.getContentPane(), "insertMovie");
      }
    });
    mnInsert.add(mntmMovie);

    JMenuItem menuUpdate = new JMenuItem("Update");
    menuUpdate.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // init global values
        tempcrew.clear();
        model.clear();
        model2.clear();
        crews.clear();
        for (String role : movieCastRoles) {
          crews.put(role, new ArrayList<MovieCrew>());
          tempcrew.put(role, new ArrayList<MovieCrew>());
        }

        String name = JOptionPane.showInputDialog(null, "What do you want to update?", "Update dialog",
            JOptionPane.QUESTION_MESSAGE);
        // validate input field
        if (name == "") {
          JOptionPane.showMessageDialog(null, "You have to input a name", "Update dialog - need name",
              JOptionPane.ERROR_MESSAGE);
        } else {
          // search the product and redirect them to corresponding panel
          if (checkHelper.bookExist(name, con)) {
            CardLayout c = (CardLayout) (frame.getContentPane().getLayout());
            c.show(frame.getContentPane(), "updateBook");
            clearUpdateBook();
            // get data set
            ResultSet bookResult = null, bookKeyword = null, bookAuthors = null;
            String keywords = "";
            List<String> oldAuthors = new ArrayList<String>();
            List<String> oldKeywords = new ArrayList<String>();
            String isbn = SelectHelper.getBookIsbn(name, con);
            bookResult = SelectHelper.getBookInfo(isbn, con);
            bookKeyword = SelectHelper.getBookKeyword(isbn, con);
            bookAuthors = SelectHelper.getBookAuthorName(isbn, con);
            // show data textfield
            try {
              upBookTitleTx.setText(bookResult.getString("Title"));
              upISBN.setText(bookResult.getString("ISBN"));
              upISBN.setEditable(false);
              upPublisherTx.setText(bookResult.getString("Publisher"));
              upPagesTx.setText(String.valueOf(bookResult.getInt("NumberOfPages")));
              upBookYearTx.setText(String.valueOf(bookResult.getInt("YearOfPublication")));
              if (!(bookResult.getObject("EditionNumber") == null)) {
                upEditionTx.setText(String.valueOf(bookResult.getInt("EditionNumber")));
              }
              upAbstractTx.setText(bookResult.getString("Abstract"));
              upKeywordsTx.setText(keywords);
              try {
                if (bookKeyword != null) {
                  keywords = bookKeyword.getString("Tag");
                  oldKeywords.add(bookKeyword.getString("Tag"));
                  while (bookKeyword.next()) {
                    oldKeywords.add(bookKeyword.getString("Tag"));
                    keywords += "," + bookKeyword.getString("Tag");
                  }
                  upKeywordsTx.setText(keywords);
                }
              } catch (SQLException e1) {
                // do nothing...
              }

              upAuthorTx1.setText(bookAuthors.getString("FullName"));
              oldAuthors.add(bookAuthors.getString("FullName"));
              if (bookAuthors.next()) {
                upAuthorTx2.setText(bookAuthors.getString("FullName"));
                oldAuthors.add(bookAuthors.getString("FullName"));
              }
              if (bookAuthors.next()) {
                upAuthorTx3.setText(bookAuthors.getString("FullName"));
                oldAuthors.add(bookAuthors.getString("FullName"));
              }
              if (bookAuthors.next()) {
                upAuthorTx4.setText(bookAuthors.getString("FullName"));
                oldAuthors.add(bookAuthors.getString("FullName"));
              }
              if (bookAuthors.next()) {
                upAuthorTx5.setText(bookAuthors.getString("FullName"));
                oldAuthors.add(bookAuthors.getString("FullName"));
              }

              // set book object
              oldBook = new Book(bookResult.getString("Title"), bookResult.getString("ISBN"),
                  bookResult.getString("Publisher"), bookResult.getString("Abstract"),
                  bookResult.getInt("YearOfPublication"), bookResult.getInt("NumberOfPages"),
                  bookResult.getInt("EditionNumber"), oldAuthors, oldKeywords);
            } catch (SQLException e1) {
              e1.printStackTrace();
            }
          } else if (checkHelper.albumExist(name, con)) {
            CardLayout c = (CardLayout) (frame.getContentPane().getLayout());
            c.show(frame.getContentPane(), "updateAlbum");
            clearUpdateAlbum();// clear the album object
            // get data set
            ResultSet albumResult = null, tracksResult = null;
            String albumName = null, producer = null;
            int year = -1;
            albumResult = SelectHelper.getAlbumInfo(name, con);
            albumName = name;

            String musicName = null, language = null;
            List<String> singers = new ArrayList<String>();
            Map<String, String> trackCrews = new HashMap<String, String>();
            try {
              year = albumResult.getInt("year");
              producer = SelectHelper.getPeopleName(albumResult.getInt("producer_id"), con);

              // get track objects
              tracksResult = SelectHelper.getAlbumMusics(name, con);
              while (tracksResult.next()) {
                // get musicname
                musicName = tracksResult.getString("MusicName");
                // get language
                language = tracksResult.getString("language");
                // get DiskType
                boolean tempbool = tracksResult.getBoolean("DiskType");
                DiskType type1 = checkHelper.checkDiskType(tracksResult.getBoolean("DiskType"));
                // get singers name
                singers = SelectHelper.getSingersList(albumName, musicName, con);
                // get crews name
                trackCrews = SelectHelper.getTrackCrewName(name, tracksResult.getString("MusicName"), con);
                // make a new MusicTrack object
                MusicTrack mt = new MusicTrack(musicName, language,
                    ((type1 == DiskType.AUDIOCD) ? DiskType.AUDIOCD : DiskType.VINYL), singers.get(0),
                    ((singers.size() == 2) ? singers.get(1) : null), trackCrews.get("songwriter"),
                    trackCrews.get("composer"), trackCrews.get("arranger"));
                // add it to an arraylist for showing in the JList
                tracks.put(musicName, mt);
              }

              // set textfield values
              upAlbumTx.setText(albumName);
              upYearTx.setText(String.valueOf(year));
              upProducerTx.setText(producer);
              for (String trackName : tracks.keySet()) {
                model.addElement(trackName);
              }
              upTrackList.setModel(model);

              // make an album object
              oldAlbum = new Album(albumName, producer, year, tracks);
            } catch (SQLException e1) {
              e1.printStackTrace();
            }

          } else if (checkHelper.movieExist(name, con)) {
            CardLayout c = (CardLayout) (frame.getContentPane().getLayout());
            c.show(frame.getContentPane(), "updateMovie");
//            clearUpdateMovie();
            // get data set
            ResultSet movieResult = null, crewIdsResult = null, crewResult = null;
            String movieName = null;
            int year = -1;
//            Map<String, MusicTrack> tracks = new HashMap<String, MusicTrack>();
            movieResult = SelectHelper.getMovieInfo(name, con);
            crewIdsResult = SelectHelper.getMovieCrewIds(name, con);
            movieName = name;

            String role = null;
            MovieCrew mc = null;
            String crewname = null;
            Boolean gender = false, award = false;
            int roleid = -1, pid = -1;
            try {
              year = movieResult.getInt("year");
              // get crew objects
              while (crewIdsResult.next()) {
                // get the pid and roleid and the crewInfo
                pid = crewIdsResult.getInt("id");
                roleid = crewIdsResult.getInt("role_id");
                crewResult = SelectHelper.getMovieCrewInfo(name, pid, con);
                // get the crew actual info
                crewname = SelectHelper.getPeopleName(pid, con);
                gender = crewResult.getBoolean("gender");
                award = crewResult.getBoolean("award");
                mc = new MovieCrew(crewname, gender, award, roleid);
                // add moviecrew object to corresponding list of the role
                role = SelectHelper.getMovieRoleName(roleid, con).toLowerCase();
                crews.get(role).add(mc);
                tempcrew.get(role).add(mc);
              }

              // set textfield values
              upMovieNameTx.setText(movieName);
              upMovieYearTx.setText(String.valueOf(year));
              for (String r : crews.keySet()) {
                for (MovieCrew m : crews.get(r)) {
                  if (r.equals("cast")) {
                    model2.addElement(m.getCrewName() + "---" + r);
                  } else {
                    model.addElement(m.getCrewName() + "---" + r);
                  }
                }
              }
              upCrewList.setModel(model);
              upCastList.setModel(model2);

              // create a new movie object
              oldMovie = new Movie(movieName, year, crews);

            } catch (SQLException e1) {
              e1.printStackTrace();
            }
          } else {
            JOptionPane.showMessageDialog(null, "Product not found", "Product not found",
                JOptionPane.INFORMATION_MESSAGE);
          }
        }
      }
    });
    mnData.add(menuUpdate);

    JMenuItem mntmDelete = new JMenuItem("Remove");
    mntmDelete.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String name = JOptionPane.showInputDialog(null, "What do you want to remove?", "Remove dialog",
            JOptionPane.QUESTION_MESSAGE);
        // validate input field
        if (name == "") {
          JOptionPane.showMessageDialog(null, "You have to input a name", "Remove dialog - need name",
              JOptionPane.ERROR_MESSAGE);
        } else {
          // search the name in each category, if found, delete it
          if (checkHelper.bookExist(name, con)) {
            TransactionHelper.deleteBookTransaction(name);
            JOptionPane.showMessageDialog(null, "Successfully deleted this book", "Remove successfully",
                JOptionPane.INFORMATION_MESSAGE);
          } else if (checkHelper.albumExist(name, con)) {
            TransactionHelper.deleteAlbumTransaction(name);
            JOptionPane.showMessageDialog(null, "Successfully deleted all music tracks in this album",
                "Remove successfully", JOptionPane.INFORMATION_MESSAGE);
          } else if (checkHelper.movieExist(name, con)) {
            TransactionHelper.deleteMovieTransaction(name);
            JOptionPane.showMessageDialog(null, "Successfully deleted this movie", "Remove successfully",
                JOptionPane.INFORMATION_MESSAGE);
          } else {
            JOptionPane.showMessageDialog(null, "Product not found", "Product not found",
                JOptionPane.INFORMATION_MESSAGE);
          }
        }
      }
    });
    mnData.add(mntmDelete);

    JMenu mnView = new JMenu("View");
    menuBar.add(mnView);

    JMenuItem mntmView = new JMenuItem("view");
    mntmView.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        // go to insert book page
        CardLayout c = (CardLayout) (frame.getContentPane().getLayout());
        c.show(frame.getContentPane(), "viewPanel");
      }
    });
    mnView.add(mntmView);

    JMenu mnReport = new JMenu("Report");
    menuBar.add(mnReport);

    JMenuItem mntmRAuthors = new JMenuItem("R1 - Author's publication");
    mntmRAuthors.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        String name = JOptionPane.showInputDialog(null, "Which author are you searching for?", "R1 - Get author's name",
            JOptionPane.QUESTION_MESSAGE);
        if (name.equals("")) {
          JOptionPane.showMessageDialog(null, "Please enter a name", "No name is inserted", JOptionPane.ERROR_MESSAGE);
        } else {
          ResultSet rs = null;
          rs = ReportHelper.createR1Report(name, con);
          try {
            if (rs != null) {
              JTable table;
              table = new JTable(buildTableModel(rs));
              // show views
              JOptionPane.showMessageDialog(null, new JScrollPane(table), "Data Table Preview",
                  JOptionPane.INFORMATION_MESSAGE);
            } else {
              JOptionPane.showMessageDialog(null, "Please enter correct information", "something wrong",
                  JOptionPane.ERROR_MESSAGE);
            }
          } catch (SQLException e) {
            e.printStackTrace();
          }
        }
      }
    });
    mnReport.add(mntmRAuthors);

    JMenuItem mntmRPublication = new JMenuItem("R2 - Publication in one year");
    mntmRPublication.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String str = JOptionPane.showInputDialog(null, "Which year are you searching for?", "R2 - Get publication year",
            JOptionPane.QUESTION_MESSAGE);
        int year = checkHelper.checkIfNumerical(str);
        if (year < 0) {
          JOptionPane.showMessageDialog(null, "Please enter a positive number", "No number is inserted",
              JOptionPane.ERROR_MESSAGE);
        }
        if (str.equals("") || year < 0) {
          JOptionPane.showMessageDialog(null, "Please enter a positive number", "Need positive number",
              JOptionPane.ERROR_MESSAGE);
        } else {
          ResultSet rs = null;
          rs = ReportHelper.createR2Report(year, con);
          try {
            if (rs != null) {
              JTable table;
              table = new JTable(buildTableModel(rs));
              // show views
              JOptionPane.showMessageDialog(null, new JScrollPane(table), "Data Table Preview",
                  JOptionPane.INFORMATION_MESSAGE);
            } else {
              JOptionPane.showMessageDialog(null, "Please enter correct information", "something wrong",
                  JOptionPane.ERROR_MESSAGE);
            }
          } catch (SQLException e1) {
            e1.printStackTrace();
          }
        }
      }
    });
    mnReport.add(mntmRPublication);

    JMenuItem mntmRBooks = new JMenuItem("R3 - Books with similar topic");
    mntmRBooks.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String keyword = JOptionPane.showInputDialog(null, "What keyword are you searching for?", "R3 - Get a keyword",
            JOptionPane.QUESTION_MESSAGE);
        if (keyword.equals("")) {
          JOptionPane.showMessageDialog(null, "Please enter a string", "No string is inserted",
              JOptionPane.ERROR_MESSAGE);
        } else {
          ResultSet rs = null;
          rs = ReportHelper.createR3Report(keyword, con);
          try {
            if (rs != null) {
              JTable table;
              table = new JTable(buildTableModel(rs));
              // show views
              JOptionPane.showMessageDialog(null, new JScrollPane(table), "Data Table Preview",
                  JOptionPane.INFORMATION_MESSAGE);
            } else {
              JOptionPane.showMessageDialog(null, "Please enter correct information", "something wrong",
                  JOptionPane.ERROR_MESSAGE);
            }
          } catch (SQLException e1) {
            e1.printStackTrace();
          }
        }
      }
    });
    mnReport.add(mntmRBooks);

    JMenuItem mntmRFrequent = new JMenuItem("R4 - Frequent publishers");
    mntmRFrequent.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        ResultSet rs = null;
        rs = ReportHelper.createR4Report(con);
        try {
          if (rs != null) {
            JTable table;
            table = new JTable(buildTableModel(rs));
            // show views
            JOptionPane.showMessageDialog(null, new JScrollPane(table), "Data Table Preview",
                JOptionPane.INFORMATION_MESSAGE);
          }
        } catch (SQLException e1) {
          e1.printStackTrace();
        }

      }
    });
    mnReport.add(mntmRFrequent);

    JMenuItem mntmRMost = new JMenuItem("R5 - Most popular subjects");
    mntmRMost.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        ResultSet rs = null;
        rs = ReportHelper.createR5Report(con);
        try {
          if (rs != null) {
            JTable table;
            table = new JTable(buildTableModel(rs));
            // show views
            JOptionPane.showMessageDialog(null, new JScrollPane(table), "Data Table Preview",
                JOptionPane.INFORMATION_MESSAGE);
          }
        } catch (SQLException e1) {
          e1.printStackTrace();
        }

      }
    });
    mnReport.add(mntmRMost);

    JMenuItem mntmRMulti = new JMenuItem("R6 - Multi skills movie crew");
    mntmRMulti.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        ResultSet rs = null;
        rs = ReportHelper.createR6Report(con);
        try {
          if (rs != null) {
            JTable table;
            table = new JTable(buildTableModel(rs));
            // show views
            JOptionPane.showMessageDialog(null, new JScrollPane(table), "Data Table Preview",
                JOptionPane.INFORMATION_MESSAGE);
          }
        } catch (SQLException e1) {
          e1.printStackTrace();
        }
      }
    });
    mnReport.add(mntmRMulti);

    JMenuItem mntmRAward = new JMenuItem("R7 - Award winning movies");
    mntmRAward.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        ResultSet rs = null;
        rs = ReportHelper.createR7Report(con);
        try {
          if (rs != null) {
            JTable table;
            table = new JTable(buildTableModel(rs));
            // show views
            JOptionPane.showMessageDialog(null, new JScrollPane(table), "Data Table Preview",
                JOptionPane.INFORMATION_MESSAGE);
          }
        } catch (SQLException e1) {
          e1.printStackTrace();
        }
      }
    });
    mnReport.add(mntmRAward);

    JMenuItem mntmRMusic = new JMenuItem("R8 - Music with similar name");
    mntmRMusic.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        ResultSet rs = null;
        rs = ReportHelper.createR8Report(con);
        try {
          if (rs != null) {
            JTable table;
            table = new JTable(buildTableModel(rs));
            // show views
            JOptionPane.showMessageDialog(null, new JScrollPane(table), "Data Table Preview",
                JOptionPane.INFORMATION_MESSAGE);
          }
        } catch (SQLException e1) {
          e1.printStackTrace();
        }
      }
    });
    mnReport.add(mntmRMusic);

    JMenuItem mntmRMulti_1 = new JMenuItem("R9 - Multi skills music crew");
    mntmRMulti_1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        ResultSet rs = null;
        rs = ReportHelper.createR9Report(con);
        try {
          if (rs != null) {
            JTable table;
            table = new JTable(buildTableModel(rs));
            // show views
            JOptionPane.showMessageDialog(null, new JScrollPane(table), "Data Table Preview",
                JOptionPane.INFORMATION_MESSAGE);
          }
        } catch (SQLException e1) {
          e1.printStackTrace();
        }
      }
    });
    mnReport.add(mntmRMulti_1);

    JMenuItem mntmRSimilar = new JMenuItem("R10 - Similar Names");
    mntmRSimilar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        ResultSet rs = null;
        rs = ReportHelper.createR10Report(con);
        try {
          if (rs != null) {
            JTable table;
            table = new JTable(buildTableModel(rs));
            // show views
            JOptionPane.showMessageDialog(null, new JScrollPane(table), "Data Table Preview",
                JOptionPane.INFORMATION_MESSAGE);
          }
        } catch (SQLException e1) {
          e1.printStackTrace();
        }
      }
    });
    mnReport.add(mntmRSimilar);

  }

  // functions for insert book
  // ----------------------------------------------------------------------

  private void clearInsertbook() {
    insertbooktitle.setText("");
    insertbookisbn.setText("");
    insertbookpub.setText("");
    insertpages.setText("");
    insertpubyear.setText("");
    insertedition.setText("");
    insertabstract.setText("");
    insertkeyword.setText("");
    insertauthor2.setText("");
    insertauthor1.setText("");
    insertauthor4.setText("");
    insertauthor3.setText("");
    insertauthor5.setText("");
  }

  private void clearUpdateBook() {
    upBookTitleTx.setText("");
    upISBN.setText("");
    upPublisherTx.setText("");
    upPagesTx.setText("");
    upBookYearTx.setText("");
    upEditionTx.setText("");
    upAbstractTx.setText("");
    upKeywordsTx.setText("");
    upAuthorTx1.setText("");
    upAuthorTx2.setText("");
    upAuthorTx3.setText("");
    upAuthorTx4.setText("");
    upAuthorTx5.setText("");
  }

  private void clearUpdateAlbum() {
    upAlbumTx.setText("");
    upYearTx.setText("");
    upProducerTx.setText("");
    model.clear();
    tracks.clear();
  }

  private void clearInsertMusic() {
    insAlbumTx.setText("");
    insYearTx.setText("");
    insProducerTx.setText("");
    textAreaMusicTrack.setText("");
    musicTracks.clear();
  }

  private void clearInsertMovies() {
    textArea.setText("");
    textArea_1.setText("");
    movieNameTx.setText("");
    movieYearTx.setText("");
    // reset the list
    crews.clear();
    for (String role : movieCastRoles) {
      crews.put(role, new ArrayList<MovieCrew>());
    }
  }

  private void clearViewFields() {
    searchNameTx.setText("");
    searchYearTx.setText("");
    chckbxBook.setSelected(false);
    chckbxAlbum.setSelected(false);
    chckbxMovie.setSelected(false);
  }

  public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {

    ResultSetMetaData metaData = rs.getMetaData();

    // names of columns
    Vector<String> columnNames = new Vector<String>();
    int columnCount = metaData.getColumnCount();
    for (int column = 1; column <= columnCount; column++) {
      columnNames.add(metaData.getColumnName(column));
    }

    // data of the table
    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
    while (rs.next()) {
      Vector<Object> vector = new Vector<Object>();
      for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
        vector.add(rs.getObject(columnIndex));
      }
      data.add(vector);
    }

    return new DefaultTableModel(data, columnNames);
  }

  public static class TransactionHelper {

    /* --- Data->insert->book --- */
    public static boolean insertBookTransaction(String isbn, String title, String pub, int pages, int year, int edition,
        String bookabs, List<String> authors, String[] keywords) {
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
        List<MusicTrack> musicTracks) {
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
          musicpeopleid = mt.getCastIDHashMap();

          // insert only if that piece of soundtrack is not in db
          // insert into Music table
          InserterHelper.insertAlbum(albumName, year, mt.getMusicName(), mt.getLanguage(), mt.getType(), producer, con);
          // insert into MusicSinger
          // only add at most 2 singers for each song
          for (int sid : mt.getSingerIDHashMap().values()) {
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
    public static void insertOneMusicTrack(String musicName, Album album, MusicTrack mt) {
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
        musicpeopleid = mt.getCastIDHashMap();

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

    public static boolean insertOneCrewMember(Movie mv, MovieCrew mc) {
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
        InserterHelper.insertCrewMember(mv.getName(), mv.getYear(), mc, con);
        // insert award
        InserterHelper.insertAward(mv.getName(), mv.getYear(), mc, con);
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
    public static boolean insertMovieTransaction(String movieName, int movieYear, Map<String, List<MovieCrew>> crews) {
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
    public static void deleteBookTransaction(String bookTitle) {
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
    public static void deleteMusicTransaction(String albumName, String musicName) {
      try {
        con.setAutoCommit(false);
        DeleteHelper.removeMusicSingers(albumName, musicName, con);
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
    public static void deleteAlbumTransaction(String albumName) {
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
    public static void deleteMovieTransaction(String movieName) {
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
              MovieCrew mc = new MovieCrew(name, male, award, SelectHelper.getRoleID(role, con));
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
              MovieCrew newmc = new MovieCrew(name, male, award, SelectHelper.getRoleID(role, con));
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

  public class CreateFrameMusicTrack {

    private JTextField insSingerTx2;
    private JTextField insMusicTx;
    private JTextField insLangTx;
    private JTextField insSongWriterTx;
    private JTextField insComposerTx;
    private JTextField insArrangerTx;
    private JTextField insSingerTx1;
    private ButtonGroup DiskTypeTx;

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

            // get DiskType
            boolean typeBool = false;
            if (DiskTypeTx.getSelection().getActionCommand().equalsIgnoreCase("vinyl")) {
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
              MusicTrack mt = new MusicTrack(musicName, lang, ((typeBool) ? DiskType.VINYL : DiskType.AUDIOCD), singer1,
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
      DiskTypeTx = new ButtonGroup();
      DiskTypeTx.add(radioButton_cd);
      DiskTypeTx.add(radioButton_vinyl);

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
          DiskType type = DiskType.AUDIOCD;
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

            // get DiskType

            for (Enumeration<AbstractButton> buttons = DiskTypeTx.getElements(); buttons.hasMoreElements();) {
              AbstractButton button = buttons.nextElement();
              if (button.isSelected()) {
                if (button.getText().equalsIgnoreCase("vinyl")) {
                  type = DiskType.VINYL;
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
                  UpdateHelper.updateAllMusicName(oldMusicName, musicName, lang, type, oldAlbum, con);
                  oldmt.setMusicName(musicName);
                  model.addElement(musicName);
                  model.removeElement(oldMusicName);
                  tracks.put(musicName, oldmt);
                  tracks.remove(oldMusicName);
                }

                // check what fields are different and change values in object
                if (!oldmt.compareLanguage(lang)) {
                  // update lang
                  UpdateHelper.updateMusicTrackString(lang, musicName, "language", con);
                  oldmt.setLanguage(lang);
                }

                if (!oldmt.compareArranger(arranger)) {
                  // update arranger
                  // check old arranger
                  if (checkHelper.checkNumRoleMusic(oldAlbum.getAlbumName(), musicName, oldmt.getArranger(), null) == 1) {
                    // delete
                    DeleteHelper.removeMusicPeopleInvolved(oldAlbum.getAlbumName(), musicName, oldmt.getArranger(), con);
                  } else {
                    // set off
                    UpdateHelper.updateMusicTrackCrewOff(oldmt.getArranger(), musicName, oldAlbum.getAlbumName(),
                        "isarranger", con);
                  }
                  // check new aranger
                  if (checkHelper.checkMusicCrewExist(oldAlbum.getAlbumName(), musicName, arranger, null)) {
                    // set on
                    UpdateHelper.updateMusicTrackCrewOn(arranger, musicName, oldAlbum.getAlbumName(), "isarranger", con);
                  } else {
                    // add musicCrew and set on
                    InserterHelper.insertMusicPeopleInvolved(oldAlbum.getAlbumName(), oldAlbum.getYear(), musicName, arranger, 0,
                        0, 1, con);
                  }
                  oldmt.setArranger(arranger);
//                      UpdateHelper.updateMusicTrackCrew(arranger, musicName, oldAlbum.getAlbumName(), "isarranger");
                }
                if (!oldmt.compareComposer(composer)) {

                  // update composer
                  // check old composer
                  if (checkHelper.checkNumRoleMusic(oldAlbum.getAlbumName(), musicName, oldmt.getComposer(), null) == 1) {
                    // delete
                    DeleteHelper.removeMusicPeopleInvolved(oldAlbum.getAlbumName(), musicName, oldmt.getComposer(), con);
                  } else {
                    // set off
                    UpdateHelper.updateMusicTrackCrewOff(oldmt.getComposer(), musicName, oldAlbum.getAlbumName(),
                        "iscomposer", con);
                  }
                  // check new composer
                  if (checkHelper.checkMusicCrewExist(oldAlbum.getAlbumName(), musicName, composer, null)) {
                    // set on
                    UpdateHelper.updateMusicTrackCrewOn(composer, musicName, oldAlbum.getAlbumName(), "iscomposer", con);
                  } else {
                    // add musicCrew and set on
                    InserterHelper.insertMusicPeopleInvolved(oldAlbum.getAlbumName(), oldAlbum.getYear(), musicName, composer, 0,
                        1, 0, con);
                  }
                  oldmt.setComposer(composer);
//                      UpdateHelper.updateMusicTrackCrew(composer, musicName, oldAlbum.getAlbumName(), "iscomposer");
                }
                if (!oldmt.compareSongWriter(songWriter)) {

                  // update songWriter
                  // check old songWriter
                  if (checkHelper.checkNumRoleMusic(oldAlbum.getAlbumName(), musicName, oldmt.getSongWriter(), null) == 1) {
                    // delete
                    DeleteHelper.removeMusicPeopleInvolved(oldAlbum.getAlbumName(), musicName, oldmt.getSongWriter(), con);
                  } else {
                    // set off
                    UpdateHelper.updateMusicTrackCrewOff(oldmt.getSongWriter(), musicName, oldAlbum.getAlbumName(),
                        "issongwriter", con);
                  }
                  // check new songWriter
                  if (checkHelper.checkMusicCrewExist(oldAlbum.getAlbumName(), musicName, songWriter, null)) {
                    // set on
                    UpdateHelper.updateMusicTrackCrewOn(songWriter, musicName, oldAlbum.getAlbumName(), "issongwriter", con);
                  } else {
                    // add musicCrew and set on
                    InserterHelper.insertMusicPeopleInvolved(oldAlbum.getAlbumName(), oldAlbum.getYear(), musicName, songWriter,
                        1, 0, 0, con);
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
                    DeleteHelper.removeMusicSinger(oldAlbum.getAlbumName(), musicName, s, con);
                  }
                  for (String s : singerSet) {
                    if ((!s.equalsIgnoreCase(oldmt.getSinger1())) && (!s.equalsIgnoreCase(oldmt.getSinger2()))) {
                      // insert new s
                      InserterHelper.insertMusicSinger(oldAlbum.getAlbumName(), oldAlbum.getYear(), musicName, s, con);
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

      DiskTypeTx = new ButtonGroup();
      DiskTypeTx.add(radioButton_cd);
      DiskTypeTx.add(radioButton_vinyl);

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
      if (oldmt.getTypeString().equalsIgnoreCase(DiskType.AUDIOCD.getString())) {
        DiskTypeTx.setSelected(model_cd, true);
      } else {
        DiskTypeTx.setSelected(model_vinyl, true);
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
}
