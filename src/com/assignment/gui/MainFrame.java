package com.assignment.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.Component;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultCaret;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import javax.swing.SpringLayout;
import javax.swing.UIManager;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class MainFrame {


	private static Connection con;
		
	private JFrame frame;
	private JTextField insertbooktitle;
	private JTextField insertbookisbn;
	private JTextField insertbookpub;
	private JTextField insertpages;
	private JTextField insertpubyear;
	private JTextField insertedition;
	private JTextField insertabstract;
	private JTextField insertkeyword;
	private JTextField insertauthor2;
	private JTextField insertauthor1;
	private JTextField insertauthor4;
	private JTextField insertauthor3;
	private JTextField insertauthor5;
	private JTextField langTx;
	private JTextField musicNameTx;
	private JTextField yearTx;
	private JTextField albumNameTx;
	private JTextField ComposerTx;
	private JTextField producerTx;
	private JTextField songWriterTx;
	private JTextField arrangerTx;
	private ButtonGroup diskTypeTx;
	private JTextField movieYearTx;
	private JTextField movieNameTx;
	private JTextField upAlbumSearch;
	private JTextField upMusicYearSearch;
	private JTextField upMusicNameSearch;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField singersTx;
	private JTextField upBookYearTx;
	private JTextField upEditionTx;
	private JTextField upAbstractTx;
	private JTextField upKeywordsTx;
	private JTextField upAuthorTx1;
	private JTextField upAuthorTx3;
	private JTextField upAuthorTx5;
	private JTextField upAuthorTx4;
	private JTextField upAuthorTx2;
	private JTextField upBookTitleTx;
	private JTextField upISBN;
	private JTextField upPublisherTx;
	private JTextField upPagesTx;
	private JTextField upAlbumNameTx;
	private JTextField upComposerTx;
	private JTextField upMusicProducerTx;
	private JTextField upSongWriterTx;
	private JTextField upLangTx;
	private JTextField upArrangerTx;
	private JTextField upMusicYearTx;
	private JTextField upMusicNameTx;
	private JTextField upSingersTx;
	private JTextField searchNameTx;
	private JTextField searchYearTx;
	private JTextField insYearTx;
	private JTextField textField_17;
	private JTextField insSingerTx2;
	private JTextField insMusicTx;
	private JTextField insLangTx;
	private JTextField insSongWriterTx;
	private JTextField insComposerTx;
	private JTextField insArrangerTx;
	private JTextField insSingerTx1;
	private List<MusicTrack> musicTracks;
	private JTextField insProducerTx;
	private JTextField insAlbumTx;
	private JTextField textField_1;
	private HashMap<String, List<MovieCrew>> crews;

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
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public MainFrame() throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.jdbc.Driver");
		String username = "root";
		String password = "";
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hl", username, password);
		initialize(con);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Connection con) {
		frame = new JFrame();
		frame.setBounds(100, 100, 1126, 844);
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
				if (insertbooktitle.getText().equals("")||insertbookisbn.getText().equals("")||insertbookpub.getText().equals("")||
						insertpages.getText().equals("")||insertpubyear.getText().equals("") || insertauthor1.getText().equals("")||
						insertbookisbn.getText().length() != 13 || insertabstract.getText().length() > 5000) {
					// show error - mandatory fields
					JOptionPane.showMessageDialog(null, "fill in all mandatory fields and in correct format", "Insert book - wrong format", JOptionPane.ERROR_MESSAGE);
				} else {
					// get input
					title = insertbooktitle.getText();
					isbn = insertbookisbn.getText();
					pub = insertbookpub.getText();
					int pages = checkHelper.checkIfNumerical(insertpages);
					int year = checkHelper.checkIfNumerical(insertpubyear);
					author1 = insertauthor1.getText();
					
					// check if isbn exist already
					boolean bookExist = SelectHelper.bookexist(isbn);
					
					if (pages <= 0 || year <= 0) {
						// show error - wrong range
					  JOptionPane.showMessageDialog(null, "Please fill in with correct range", "Insert book - wrong format on range", JOptionPane.ERROR_MESSAGE);
					} else if (bookExist) {
						// error - book isbn duplicated
						System.out.println("ISBN already exist in the database");
						JOptionPane.showMessageDialog(null, "This book has already exist in the database", "Insert book - book existed", JOptionPane.ERROR_MESSAGE);
					} else {
						
						// get optional field
						if (!insertedition.getText().equals("")) {
						  edition = checkHelper.checkIfNumerical(insertedition);
						  if (edition < 0) {
						    JOptionPane.showMessageDialog(null, "Since edition in wrong format, default set it as no edition info", "Insert book - wrong format on range", JOptionPane.ERROR_MESSAGE);
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
						boolean success = TransactionHelper.insertBookTransaction(isbn, title, pub, pages, year, edition, bookabs, authors, keywords);

						if (success) {
						  JOptionPane.showMessageDialog(null, "Book inserted.", "Insert book - success", JOptionPane.INFORMATION_MESSAGE);
						} else {
						  JOptionPane.showMessageDialog(null, "Book insertion fail due to unexpected error", "Insert book - error", JOptionPane.ERROR_MESSAGE);
						}
						// clear all fields if successfully insert all data
						clearInsertbook();
						
					}
				}
			}
		});
		
		JLabel lblEachBookCan = new JLabel("Each book can store at most 5 authors, you can separate the names by comma ' , '.");
		
		JLabel lblNameOfPeople_1 = new JLabel("Name of people who involved should be in the format of 'first_name family_name' or 'first_name middle_name family_name'");
		
		JLabel lblIfTheNames = new JLabel("If the names are in the wrong format, it will not be stored in the database.");
		
		JLabel lblPleaseInsertAll_1 = new JLabel("Please insert all the mandatory fields. ISBN is a 13 digits string. You have to enter at least one author.");
		GroupLayout gl_insertBook = new GroupLayout(insertBook);
		gl_insertBook.setHorizontalGroup(
		  gl_insertBook.createParallelGroup(Alignment.LEADING)
		    .addGroup(gl_insertBook.createSequentialGroup()
		      .addGap(52)
		      .addGroup(gl_insertBook.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_insertBook.createParallelGroup(Alignment.LEADING)
		          .addComponent(lblEachBookCan, GroupLayout.PREFERRED_SIZE, 901, GroupLayout.PREFERRED_SIZE)
		          .addComponent(lblNameOfPeople_1, GroupLayout.PREFERRED_SIZE, 809, GroupLayout.PREFERRED_SIZE)
		          .addComponent(lblPleaseInsertAll_1, GroupLayout.PREFERRED_SIZE, 672, GroupLayout.PREFERRED_SIZE)
		          .addComponent(lblIfTheNames, GroupLayout.PREFERRED_SIZE, 469, GroupLayout.PREFERRED_SIZE))
		        .addGroup(gl_insertBook.createSequentialGroup()
		          .addGap(251)
		          .addGroup(gl_insertBook.createParallelGroup(Alignment.LEADING)
		            .addGroup(gl_insertBook.createSequentialGroup()
		              .addComponent(lblNumberofPages)
		              .addGap(18)
		              .addComponent(insertpages, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE))
		            .addGroup(gl_insertBook.createSequentialGroup()
		              .addGroup(gl_insertBook.createParallelGroup(Alignment.LEADING)
		                .addComponent(lblBookTitle)
		                .addComponent(lblBookIsbn)
		                .addComponent(lblNewLabel))
		              .addGap(53)
		              .addGroup(gl_insertBook.createParallelGroup(Alignment.LEADING, false)
		                .addComponent(insertbookpub)
		                .addComponent(insertbookisbn)
		                .addComponent(insertbooktitle, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)))
		            .addGroup(gl_insertBook.createSequentialGroup()
		              .addGroup(gl_insertBook.createParallelGroup(Alignment.LEADING)
		                .addComponent(lblYearOfPublication)
		                .addComponent(lblEditionNumber)
		                .addComponent(lblAbstract)
		                .addComponent(lblKeywords)
		                .addComponent(lblAuthors))
		              .addPreferredGap(ComponentPlacement.RELATED)
		              .addGroup(gl_insertBook.createParallelGroup(Alignment.LEADING)
		                .addComponent(insertkeyword, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)
		                .addComponent(insertedition, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)
		                .addComponent(insertpubyear, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)
		                .addComponent(insertabstract, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)
		                .addGroup(gl_insertBook.createParallelGroup(Alignment.TRAILING)
		                  .addGroup(gl_insertBook.createSequentialGroup()
		                    .addComponent(insertauthor1, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
		                    .addGap(23)
		                    .addComponent(insertauthor2, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
		                  .addGroup(gl_insertBook.createSequentialGroup()
		                    .addComponent(insertauthor3, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
		                    .addGap(23)
		                    .addComponent(insertauthor4, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
		                  .addComponent(insertauthor5, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
		                  .addGroup(gl_insertBook.createSequentialGroup()
		                    .addComponent(btnSubmitbookinsert, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
		                    .addPreferredGap(ComponentPlacement.RELATED)
		                    .addComponent(btnCancelbook))))))))
		      .addContainerGap(179, Short.MAX_VALUE))
		);
		gl_insertBook.setVerticalGroup(
		  gl_insertBook.createParallelGroup(Alignment.LEADING)
		    .addGroup(gl_insertBook.createSequentialGroup()
		      .addGap(47)
		      .addComponent(lblPleaseInsertAll_1)
		      .addGap(11)
		      .addComponent(lblEachBookCan)
		      .addGap(13)
		      .addComponent(lblNameOfPeople_1)
		      .addGap(13)
		      .addComponent(lblIfTheNames)
		      .addGap(37)
		      .addGroup(gl_insertBook.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_insertBook.createSequentialGroup()
		          .addGap(3)
		          .addComponent(lblBookTitle))
		        .addComponent(insertbooktitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addGap(18)
		      .addGroup(gl_insertBook.createParallelGroup(Alignment.BASELINE)
		        .addComponent(insertbookisbn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		        .addComponent(lblBookIsbn))
		      .addGap(18)
		      .addGroup(gl_insertBook.createParallelGroup(Alignment.BASELINE)
		        .addComponent(lblNewLabel)
		        .addComponent(insertbookpub, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addGap(18)
		      .addGroup(gl_insertBook.createParallelGroup(Alignment.BASELINE)
		        .addComponent(lblNumberofPages)
		        .addComponent(insertpages, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addGap(18)
		      .addGroup(gl_insertBook.createParallelGroup(Alignment.BASELINE)
		        .addComponent(lblYearOfPublication)
		        .addComponent(insertpubyear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addGap(18)
		      .addGroup(gl_insertBook.createParallelGroup(Alignment.BASELINE)
		        .addComponent(lblEditionNumber)
		        .addComponent(insertedition, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addGap(18)
		      .addGroup(gl_insertBook.createParallelGroup(Alignment.BASELINE)
		        .addComponent(lblAbstract)
		        .addComponent(insertabstract, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addGap(18)
		      .addGroup(gl_insertBook.createParallelGroup(Alignment.BASELINE)
		        .addComponent(lblKeywords)
		        .addComponent(insertkeyword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addGap(18)
		      .addGroup(gl_insertBook.createParallelGroup(Alignment.LEADING)
		        .addComponent(lblAuthors)
		        .addComponent(insertauthor1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		        .addComponent(insertauthor2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addPreferredGap(ComponentPlacement.RELATED)
		      .addGroup(gl_insertBook.createParallelGroup(Alignment.LEADING)
		        .addComponent(insertauthor3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		        .addComponent(insertauthor4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addPreferredGap(ComponentPlacement.RELATED)
		      .addComponent(insertauthor5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		      .addPreferredGap(ComponentPlacement.UNRELATED)
		      .addGroup(gl_insertBook.createParallelGroup(Alignment.BASELINE)
		        .addComponent(btnSubmitbookinsert)
		        .addComponent(btnCancelbook))
		      .addContainerGap(343, Short.MAX_VALUE))
		);
		insertBook.setLayout(gl_insertBook);
		
		JPanel insertAlbum = new JPanel();
		frame.getContentPane().add(insertAlbum, "insertAlbum");
		
		JButton submitBtn = new JButton("Submit");
		submitBtn.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent arg0) {
		    String albumName = null, musicName = null, lang = null, producer = null, arranger = null, composer = null, songWriter = null;
		    String[] singersSplit = null; // at most 2 singer for each song
		    int year = -1;
		    diskType type = diskType.AUDIOCD;
		    
		    // check all fields are filled in or not
		    if (albumNameTx.getText().equals("")|| musicNameTx.getText().equals("") || langTx.getText().equals("") || producerTx.getText().equals("") ||
		        arrangerTx.getText().equals("") || ComposerTx.getText().equals("") || songWriterTx.getText().equals("") ||
		        yearTx.getText().equals("") || singersTx.getText().equals("")) {
		      // show error - mandatory fields
          System.out.println("fill in all mandatory fields and in correct format");
          JOptionPane.showMessageDialog(null, "fill in all mandatory fields and in correct format", "Insert music - wrong format", JOptionPane.ERROR_MESSAGE);
		    } else if (checkHelper.checkIfNumerical(yearTx) <= 0) {
		      System.out.println("fill in the year in correct format (year > 0)");
		      JOptionPane.showMessageDialog(null, "fill in the year in correct range", "Insert music - wrong range", JOptionPane.ERROR_MESSAGE);
		    } else {
		      // get the string values
		      albumName = albumNameTx.getText();
		      musicName = musicNameTx.getText();
		      lang = langTx.getText();
		      producer = producerTx.getText();
		      arranger = arrangerTx.getText();
		      composer = ComposerTx.getText();
		      songWriter = songWriterTx.getText();
		      year = Integer.parseInt(yearTx.getText());
		      
		      // musicpeoples: key - roleTitle, value - peopleName
		      Map<String, String> musicpeoples = new HashMap<String,String>();
		      musicpeoples.put("songWriter", songWriter);
		      musicpeoples.put("composer", composer);
		      musicpeoples.put("arranger", arranger);
		      
		      // split singers by ','
          singersSplit = singersTx.getText().split("\\s*,\\s*");
          List<String> singers = new ArrayList<String>();
          if (singersSplit.length >= 2) {
            singers.add(singersSplit[0]);
            singers.add(singersSplit[1]);
          } else {
            singers.add(singersSplit[0]);
          }
          
          // get diskType
          String typeString = null;
          for (Enumeration<AbstractButton> buttons = diskTypeTx.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
              typeString = button.getText();
            }
          }
          for (diskType d : type.getIteration()) {
            if (d.getString().equalsIgnoreCase(typeString)) {
              type = d.getEnum();
            }
          }
       // check if the music album exist in Music, insert if not
          if (!checkHelper.musicExist(albumName, year, musicName)) {
            // insert music
//            boolean success = TransactionHelper.insertMusicTransaction(albumName, musicName, lang, producer, musicpeoples, year, singers, type);
            boolean success = false;
            if (success) {
              JOptionPane.showMessageDialog(null, "Music inserted.", "Insert music - success", JOptionPane.INFORMATION_MESSAGE);
            } else {
              JOptionPane.showMessageDialog(null, "Music insertion fail due to unexpected error", "Insert music - error", JOptionPane.ERROR_MESSAGE);
            }
          } else {
//            System.out.println("music track of that album already existed.");
            JOptionPane.showMessageDialog(null, "This music track of that album already existed", "Insert music - already existed", JOptionPane.ERROR_MESSAGE);
          }
		    }
		  }
		});
		
		JButton button_1 = new JButton("Cancel");
		button_1.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent arg0) {
        clearInsertAlbum();
      }
		});
      
		
		JLabel lblLanguage = new JLabel("language:");
		
		langTx = new JTextField();
		langTx.setColumns(10);
		
		JLabel lblAlbumName = new JLabel("Album name:");
		
		JLabel lblYear = new JLabel("Year:");
		
		JLabel lblMusicName = new JLabel("Music name:");
		
		musicNameTx = new JTextField();
		musicNameTx.setColumns(10);
		
		yearTx = new JTextField();
		yearTx.setColumns(10);
		
		albumNameTx = new JTextField();
		albumNameTx.setColumns(10);
		
		JLabel lblDiskType = new JLabel("Disk type:");
		
		JLabel lblProducer = new JLabel("Producer:");
		
		JLabel lblSongWriter = new JLabel("Song writer:");
		
		JLabel lblComposer = new JLabel("Composer:");
		
		JLabel lblArranger = new JLabel("Arranger:");
		
		ComposerTx = new JTextField();
		ComposerTx.setColumns(10);
		
		producerTx = new JTextField();
		producerTx.setColumns(10);
		
		songWriterTx = new JTextField();
		songWriterTx.setColumns(10);
		
		arrangerTx = new JTextField();
		arrangerTx.setColumns(10);
		
		JLabel lblSingers = new JLabel("Singers:");
		
		singersTx = new JTextField();
		singersTx.setColumns(10);

    JRadioButton audioCDtype = new JRadioButton("AudioCD");
    audioCDtype.setText("audioCD");
    audioCDtype.setSelected(true);
    
    JRadioButton vinylType = new JRadioButton("Vinyl");
    vinylType.setText("vinyl");
    
    JLabel lblPleaseInsertAll = new JLabel("Please insert all the fields.");
    
    JLabel lblProducerSongWriter = new JLabel("Producer, song writer, composer and arranger can only have one name. Each music can store at most 2 singers, you can separate the names by comma ' , '.");
    
    JLabel lblNameOfPeople = new JLabel("Name of people who involved should be in the format of 'first_name family_name' or 'first_name middle_name family_name'");
    
    JLabel lblIfTheName = new JLabel("If the names are in the wrong format, it will not be stored in the database.");
    
    JButton btnAddAMusic = new JButton("Add a music track");
    btnAddAMusic.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      }
    });
    GroupLayout gl_insertAlbum = new GroupLayout(insertAlbum);
    gl_insertAlbum.setHorizontalGroup(
      gl_insertAlbum.createParallelGroup(Alignment.TRAILING)
        .addGroup(gl_insertAlbum.createSequentialGroup()
          .addGroup(gl_insertAlbum.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_insertAlbum.createSequentialGroup()
              .addGap(52)
              .addComponent(lblPleaseInsertAll))
            .addGroup(gl_insertAlbum.createSequentialGroup()
              .addGap(279)
              .addGroup(gl_insertAlbum.createParallelGroup(Alignment.TRAILING, false)
                .addGroup(gl_insertAlbum.createSequentialGroup()
                  .addGroup(gl_insertAlbum.createParallelGroup(Alignment.TRAILING)
                    .addGroup(gl_insertAlbum.createSequentialGroup()
                      .addGroup(gl_insertAlbum.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblYear)
                        .addComponent(lblMusicName)
                        .addComponent(lblLanguage)
                        .addComponent(lblDiskType)
                        .addComponent(lblProducer)
                        .addComponent(lblSongWriter)
                        .addComponent(lblComposer)
                        .addComponent(lblArranger)
                        .addComponent(lblSingers))
                      .addGap(22))
                    .addGroup(gl_insertAlbum.createSequentialGroup()
                      .addComponent(lblAlbumName)
                      .addGap(18)))
                  .addGroup(gl_insertAlbum.createParallelGroup(Alignment.LEADING)
                    .addGroup(gl_insertAlbum.createParallelGroup(Alignment.LEADING, false)
                      .addComponent(albumNameTx, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                      .addComponent(ComposerTx, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                      .addComponent(producerTx, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                      .addComponent(songWriterTx, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                      .addComponent(langTx, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                      .addComponent(arrangerTx, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                      .addComponent(yearTx)
                      .addComponent(musicNameTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addComponent(singersTx, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)
                    .addGroup(gl_insertAlbum.createSequentialGroup()
                      .addComponent(audioCDtype)
                      .addGap(64)
                      .addComponent(vinylType))))
                .addGroup(gl_insertAlbum.createSequentialGroup()
                  .addComponent(btnAddAMusic)
                  .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(submitBtn, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
                  .addGap(18)
                  .addComponent(button_1))))
            .addGroup(gl_insertAlbum.createSequentialGroup()
              .addGap(52)
              .addGroup(gl_insertAlbum.createParallelGroup(Alignment.LEADING)
                .addComponent(lblNameOfPeople)
                .addComponent(lblProducerSongWriter)
                .addComponent(lblIfTheName))))
          .addContainerGap(179, Short.MAX_VALUE))
    );
    gl_insertAlbum.setVerticalGroup(
      gl_insertAlbum.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_insertAlbum.createSequentialGroup()
          .addGap(38)
          .addComponent(lblPleaseInsertAll)
          .addGap(11)
          .addComponent(lblProducerSongWriter)
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addComponent(lblNameOfPeople)
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addComponent(lblIfTheName)
          .addGap(22)
          .addGroup(gl_insertAlbum.createParallelGroup(Alignment.TRAILING)
            .addGroup(gl_insertAlbum.createSequentialGroup()
              .addGroup(gl_insertAlbum.createParallelGroup(Alignment.BASELINE)
                .addComponent(albumNameTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblAlbumName))
              .addPreferredGap(ComponentPlacement.UNRELATED)
              .addGroup(gl_insertAlbum.createParallelGroup(Alignment.BASELINE)
                .addComponent(yearTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblYear))
              .addGap(18)
              .addGroup(gl_insertAlbum.createParallelGroup(Alignment.BASELINE)
                .addComponent(musicNameTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblMusicName))
              .addGap(18)
              .addComponent(langTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addComponent(lblLanguage))
          .addGap(18)
          .addGroup(gl_insertAlbum.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblDiskType)
            .addComponent(audioCDtype)
            .addComponent(vinylType))
          .addGap(18)
          .addGroup(gl_insertAlbum.createParallelGroup(Alignment.BASELINE)
            .addComponent(producerTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblProducer))
          .addGap(18)
          .addGroup(gl_insertAlbum.createParallelGroup(Alignment.BASELINE)
            .addComponent(songWriterTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblSongWriter))
          .addGap(18)
          .addGroup(gl_insertAlbum.createParallelGroup(Alignment.BASELINE)
            .addComponent(ComposerTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblComposer))
          .addGap(18)
          .addGroup(gl_insertAlbum.createParallelGroup(Alignment.BASELINE)
            .addComponent(arrangerTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblArranger))
          .addGap(18)
          .addGroup(gl_insertAlbum.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblSingers)
            .addComponent(singersTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(52)
          .addGroup(gl_insertAlbum.createParallelGroup(Alignment.BASELINE)
            .addComponent(submitBtn)
            .addComponent(button_1)
            .addComponent(btnAddAMusic))
          .addContainerGap(348, Short.MAX_VALUE))
    );
    
		diskTypeTx = new ButtonGroup();
		diskTypeTx.add(audioCDtype);
		diskTypeTx.add(vinylType);
		insertAlbum.setLayout(gl_insertAlbum);
		
		JPanel insertMovie = new JPanel();
		frame.getContentPane().add(insertMovie, "insertMovie");
		
		JLabel lblReleaseYear = new JLabel("Release year:");
		
		JLabel lblMovieName = new JLabel("Movie name:");
		
		movieYearTx = new JTextField();
		movieYearTx.setColumns(10);
		
		movieNameTx = new JTextField();
		movieNameTx.setColumns(10);
		
		JLabel lblCrewAndCast = new JLabel("Crew:");
		
		JTextArea textArea = new JTextArea();
		
		JLabel lblCast = new JLabel("Cast:");
		
		JTextArea textArea_1 = new JTextArea();
		
		JButton btnAddNewCrew = new JButton("Add new crew or cast");
		btnAddNewCrew.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent arg0) {
		    CreateFrameMovieCrew createFrameMovieCrew = new CreateFrameMovieCrew(crews);
		  }
		});
		
		JButton btnCancel_1 = new JButton("Cancel");
		
		JButton btnSubmit_1 = new JButton("Submit");
		GroupLayout gl_insertMovie = new GroupLayout(insertMovie);
		gl_insertMovie.setHorizontalGroup(
		  gl_insertMovie.createParallelGroup(Alignment.LEADING)
		    .addGroup(gl_insertMovie.createSequentialGroup()
		      .addGap(259)
		      .addGroup(gl_insertMovie.createParallelGroup(Alignment.LEADING)
		        .addComponent(textArea, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
		        .addComponent(lblCrewAndCast)
		        .addGroup(gl_insertMovie.createSequentialGroup()
		          .addGroup(gl_insertMovie.createParallelGroup(Alignment.LEADING)
		            .addComponent(lblReleaseYear)
		            .addComponent(lblMovieName))
		          .addGap(18)
		          .addGroup(gl_insertMovie.createParallelGroup(Alignment.LEADING, false)
		            .addComponent(movieNameTx)
		            .addComponent(movieYearTx, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)))
		        .addComponent(btnAddNewCrew))
		      .addGap(33)
		      .addGroup(gl_insertMovie.createParallelGroup(Alignment.LEADING)
		        .addComponent(lblCast, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
		        .addGroup(gl_insertMovie.createParallelGroup(Alignment.TRAILING)
		          .addGroup(gl_insertMovie.createSequentialGroup()
		            .addComponent(btnSubmit_1)
		            .addPreferredGap(ComponentPlacement.UNRELATED)
		            .addComponent(btnCancel_1))
		          .addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)))
		      .addContainerGap(344, Short.MAX_VALUE))
		);
		gl_insertMovie.setVerticalGroup(
		  gl_insertMovie.createParallelGroup(Alignment.LEADING)
		    .addGroup(gl_insertMovie.createSequentialGroup()
		      .addGap(104)
		      .addGroup(gl_insertMovie.createParallelGroup(Alignment.TRAILING)
		        .addGroup(gl_insertMovie.createSequentialGroup()
		          .addComponent(lblCast)
		          .addGap(18)
		          .addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
		        .addGroup(gl_insertMovie.createSequentialGroup()
		          .addGroup(gl_insertMovie.createParallelGroup(Alignment.BASELINE)
		            .addComponent(lblMovieName)
		            .addComponent(movieNameTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		          .addGap(27)
		          .addGroup(gl_insertMovie.createParallelGroup(Alignment.BASELINE)
		            .addComponent(lblReleaseYear)
		            .addComponent(movieYearTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		          .addGap(34)
		          .addComponent(lblCrewAndCast)
		          .addGap(18)
		          .addComponent(textArea, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)))
		      .addGap(48)
		      .addComponent(btnAddNewCrew)
		      .addGap(42)
		      .addGroup(gl_insertMovie.createParallelGroup(Alignment.BASELINE)
		        .addComponent(btnCancel_1)
		        .addComponent(btnSubmit_1))
		      .addContainerGap(196, Short.MAX_VALUE))
		);
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
		    // get validate input
		    // check if 
		  }
		});
		
		JLabel lblChangeTheValues = new JLabel("Change the values and click update to update the information of this book");
		lblChangeTheValues.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_updateBook = new GroupLayout(updateBook);
		gl_updateBook.setHorizontalGroup(
		  gl_updateBook.createParallelGroup(Alignment.LEADING)
		    .addGroup(gl_updateBook.createSequentialGroup()
		      .addGroup(gl_updateBook.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_updateBook.createSequentialGroup()
		          .addGap(31)
		          .addComponent(lblChangeTheValues))
		        .addGroup(gl_updateBook.createSequentialGroup()
		          .addGap(131)
		          .addGroup(gl_updateBook.createParallelGroup(Alignment.LEADING)
		            .addGroup(gl_updateBook.createSequentialGroup()
		              .addGroup(gl_updateBook.createParallelGroup(Alignment.LEADING)
		                .addComponent(lblNewLabel_2)
		                .addComponent(label_6, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
		                .addComponent(lblPublisher))
		              .addGap(53)
		              .addGroup(gl_updateBook.createParallelGroup(Alignment.LEADING)
		                .addComponent(upPublisherTx, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)
		                .addComponent(upISBN, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)
		                .addComponent(upBookTitleTx, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)))
		            .addGroup(gl_updateBook.createParallelGroup(Alignment.TRAILING)
		              .addGroup(gl_updateBook.createParallelGroup(Alignment.LEADING)
		                .addGroup(gl_updateBook.createSequentialGroup()
		                  .addComponent(label_8, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
		                  .addGap(25)
		                  .addComponent(upEditionTx, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE))
		                .addGroup(gl_updateBook.createSequentialGroup()
		                  .addComponent(label_9, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
		                  .addGap(64)
		                  .addComponent(upAbstractTx, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE))
		                .addGroup(gl_updateBook.createSequentialGroup()
		                  .addComponent(label_10, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
		                  .addGap(56)
		                  .addComponent(upKeywordsTx, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE))
		                .addGroup(gl_updateBook.createSequentialGroup()
		                  .addComponent(label_11, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
		                  .addGap(67)
		                  .addComponent(upAuthorTx1, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
		                  .addGap(23)
		                  .addComponent(upAuthorTx2, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
		                .addGroup(gl_updateBook.createSequentialGroup()
		                  .addGap(116)
		                  .addComponent(upAuthorTx3, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
		                  .addGap(23)
		                  .addComponent(upAuthorTx4, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
		                .addGroup(gl_updateBook.createSequentialGroup()
		                  .addGap(116)
		                  .addComponent(upAuthorTx5, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
		                .addGroup(gl_updateBook.createSequentialGroup()
		                  .addComponent(label_7, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
		                  .addGap(5)
		                  .addComponent(upBookYearTx, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)))
		              .addGroup(gl_updateBook.createSequentialGroup()
		                .addComponent(lblNumberOfPages)
		                .addPreferredGap(ComponentPlacement.UNRELATED)
		                .addComponent(upPagesTx, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)))
		            .addGroup(gl_updateBook.createSequentialGroup()
		              .addGap(427)
		              .addComponent(btnNewButton_3)))))
		      .addContainerGap(213, Short.MAX_VALUE))
		);
		gl_updateBook.setVerticalGroup(
		  gl_updateBook.createParallelGroup(Alignment.LEADING)
		    .addGroup(gl_updateBook.createSequentialGroup()
		      .addContainerGap()
		      .addComponent(lblChangeTheValues)
		      .addGap(34)
		      .addGroup(gl_updateBook.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_updateBook.createSequentialGroup()
		          .addComponent(lblNewLabel_2)
		          .addGap(18)
		          .addGroup(gl_updateBook.createParallelGroup(Alignment.BASELINE)
		            .addComponent(label_6)
		            .addComponent(upISBN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		          .addGap(18)
		          .addGroup(gl_updateBook.createParallelGroup(Alignment.BASELINE)
		            .addComponent(lblPublisher)
		            .addComponent(upPublisherTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		          .addGap(18)
		          .addGroup(gl_updateBook.createParallelGroup(Alignment.BASELINE)
		            .addComponent(lblNumberOfPages)
		            .addComponent(upPagesTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		        .addComponent(upBookTitleTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addPreferredGap(ComponentPlacement.UNRELATED)
		      .addGroup(gl_updateBook.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_updateBook.createSequentialGroup()
		          .addGap(3)
		          .addComponent(label_7))
		        .addComponent(upBookYearTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addGap(18)
		      .addGroup(gl_updateBook.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_updateBook.createSequentialGroup()
		          .addGap(3)
		          .addComponent(label_8))
		        .addComponent(upEditionTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addGap(18)
		      .addGroup(gl_updateBook.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_updateBook.createSequentialGroup()
		          .addGap(3)
		          .addComponent(label_9))
		        .addComponent(upAbstractTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addGap(18)
		      .addGroup(gl_updateBook.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_updateBook.createSequentialGroup()
		          .addGap(3)
		          .addComponent(label_10))
		        .addComponent(upKeywordsTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addGap(18)
		      .addGroup(gl_updateBook.createParallelGroup(Alignment.LEADING)
		        .addComponent(label_11)
		        .addComponent(upAuthorTx1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		        .addComponent(upAuthorTx2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addGap(7)
		      .addGroup(gl_updateBook.createParallelGroup(Alignment.LEADING)
		        .addComponent(upAuthorTx3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		        .addComponent(upAuthorTx4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addGap(7)
		      .addComponent(upAuthorTx5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		      .addPreferredGap(ComponentPlacement.RELATED)
		      .addComponent(btnNewButton_3)
		      .addContainerGap(128, Short.MAX_VALUE))
		);
		updateBook.setLayout(gl_updateBook);
		
		JPanel updateAlbum = new JPanel();
		frame.getContentPane().add(updateAlbum, "updateAlbum");
		
		JButton btnSearchMusic = new JButton("Search Music");
		
		JLabel lblAlbumName_1 = new JLabel("Album name:");
		
		upAlbumSearch = new JTextField();
		upAlbumSearch.setColumns(10);
		
		JLabel lblYear_1 = new JLabel("Year:");
		
		JLabel lblMusicName_1 = new JLabel("Music name:");
		
		upMusicYearSearch = new JTextField();
		upMusicYearSearch.setColumns(10);
		
		upMusicNameSearch = new JTextField();
		upMusicNameSearch.setColumns(10);
		
		JLabel label_12 = new JLabel("Year:");
		
		JLabel label_13 = new JLabel("Music name:");
		
		JLabel label_14 = new JLabel("language:");
		
		JLabel label_15 = new JLabel("Disk type:");
		
		JLabel label_16 = new JLabel("Producer:");
		
		JLabel label_17 = new JLabel("Song writer:");
		
		JLabel label_18 = new JLabel("Composer:");
		
		JLabel label_19 = new JLabel("Arranger:");
		
		JLabel label_20 = new JLabel("Singers:");
		
		JLabel label_21 = new JLabel("Album name:");
		
		upAlbumNameTx = new JTextField();
		upAlbumNameTx.setColumns(10);
		
		upComposerTx = new JTextField();
		upComposerTx.setColumns(10);
		
		upMusicProducerTx = new JTextField();
		upMusicProducerTx.setColumns(10);
		
		upSongWriterTx = new JTextField();
		upSongWriterTx.setColumns(10);
		
		upLangTx = new JTextField();
		upLangTx.setColumns(10);
		
		upArrangerTx = new JTextField();
		upArrangerTx.setColumns(10);
		
		upMusicYearTx = new JTextField();
		upMusicYearTx.setColumns(10);
		
		upMusicNameTx = new JTextField();
		upMusicNameTx.setColumns(10);
		
		upSingersTx = new JTextField();
		upSingersTx.setColumns(10);
		
		JRadioButton upAudioCDBtn = new JRadioButton("audioCD");
		upAudioCDBtn.setSelected(true);
		
		JRadioButton upVinylBtn = new JRadioButton("vinyl");
		
		JButton btnNewButton_1 = new JButton("Cancel");
		
		JButton btnNewButton_2 = new JButton("Update");
		GroupLayout gl_updateAlbum = new GroupLayout(updateAlbum);
		gl_updateAlbum.setHorizontalGroup(
		  gl_updateAlbum.createParallelGroup(Alignment.LEADING)
		    .addGroup(gl_updateAlbum.createSequentialGroup()
		      .addGroup(gl_updateAlbum.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_updateAlbum.createSequentialGroup()
		          .addGap(108)
		          .addGroup(gl_updateAlbum.createParallelGroup(Alignment.TRAILING)
		            .addComponent(btnSearchMusic)
		            .addGroup(gl_updateAlbum.createSequentialGroup()
		              .addGroup(gl_updateAlbum.createParallelGroup(Alignment.LEADING)
		                .addComponent(lblMusicName_1)
		                .addComponent(lblYear_1))
		              .addGap(18)
		              .addGroup(gl_updateAlbum.createParallelGroup(Alignment.LEADING)
		                .addComponent(upMusicYearSearch, GroupLayout.PREFERRED_SIZE, 425, GroupLayout.PREFERRED_SIZE)
		                .addComponent(upMusicNameSearch, GroupLayout.PREFERRED_SIZE, 425, GroupLayout.PREFERRED_SIZE)))
		            .addGroup(gl_updateAlbum.createSequentialGroup()
		              .addComponent(lblAlbumName_1)
		              .addGap(18)
		              .addComponent(upAlbumSearch, GroupLayout.PREFERRED_SIZE, 425, GroupLayout.PREFERRED_SIZE))
		            .addGroup(gl_updateAlbum.createSequentialGroup()
		              .addComponent(btnNewButton_2)
		              .addGap(18)
		              .addComponent(btnNewButton_1))))
		        .addGroup(gl_updateAlbum.createSequentialGroup()
		          .addGap(171)
		          .addGroup(gl_updateAlbum.createParallelGroup(Alignment.LEADING)
		            .addGroup(gl_updateAlbum.createSequentialGroup()
		              .addComponent(label_21, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
		              .addGap(18)
		              .addComponent(upAlbumNameTx, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE))
		            .addGroup(gl_updateAlbum.createSequentialGroup()
		              .addComponent(label_12, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
		              .addGap(64)
		              .addComponent(upMusicYearTx, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE))
		            .addGroup(gl_updateAlbum.createSequentialGroup()
		              .addComponent(label_13, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
		              .addGap(22)
		              .addComponent(upMusicNameTx, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE))
		            .addGroup(gl_updateAlbum.createSequentialGroup()
		              .addComponent(label_14, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
		              .addGap(38)
		              .addComponent(upLangTx, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE))
		            .addGroup(gl_updateAlbum.createSequentialGroup()
		              .addComponent(label_15)
		              .addGap(39)
		              .addComponent(upAudioCDBtn, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
		              .addGap(64)
		              .addComponent(upVinylBtn, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
		            .addGroup(gl_updateAlbum.createSequentialGroup()
		              .addComponent(label_16)
		              .addGap(39)
		              .addComponent(upMusicProducerTx, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE))
		            .addGroup(gl_updateAlbum.createSequentialGroup()
		              .addComponent(label_17, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
		              .addGap(23)
		              .addComponent(upSongWriterTx, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE))
		            .addGroup(gl_updateAlbum.createSequentialGroup()
		              .addComponent(label_18, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
		              .addGap(32)
		              .addComponent(upComposerTx, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE))
		            .addGroup(gl_updateAlbum.createSequentialGroup()
		              .addComponent(label_19)
		              .addGap(39)
		              .addComponent(upArrangerTx, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE))
		            .addGroup(gl_updateAlbum.createSequentialGroup()
		              .addComponent(label_20, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
		              .addGap(47)
		              .addComponent(upSingersTx, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)))))
		      .addContainerGap(185, Short.MAX_VALUE))
		);
		gl_updateAlbum.setVerticalGroup(
		  gl_updateAlbum.createParallelGroup(Alignment.LEADING)
		    .addGroup(gl_updateAlbum.createSequentialGroup()
		      .addContainerGap()
		      .addGroup(gl_updateAlbum.createParallelGroup(Alignment.BASELINE)
		        .addComponent(lblAlbumName_1)
		        .addComponent(upAlbumSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addPreferredGap(ComponentPlacement.UNRELATED)
		      .addGroup(gl_updateAlbum.createParallelGroup(Alignment.BASELINE)
		        .addComponent(lblYear_1)
		        .addComponent(upMusicYearSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addGap(18)
		      .addGroup(gl_updateAlbum.createParallelGroup(Alignment.BASELINE)
		        .addComponent(lblMusicName_1)
		        .addComponent(upMusicNameSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addGap(18)
		      .addComponent(btnSearchMusic)
		      .addGap(18)
		      .addGroup(gl_updateAlbum.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_updateAlbum.createSequentialGroup()
		          .addGap(3)
		          .addComponent(label_21))
		        .addComponent(upAlbumNameTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addGap(13)
		      .addGroup(gl_updateAlbum.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_updateAlbum.createSequentialGroup()
		          .addGap(3)
		          .addComponent(label_12))
		        .addComponent(upMusicYearTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addGap(18)
		      .addGroup(gl_updateAlbum.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_updateAlbum.createSequentialGroup()
		          .addGap(3)
		          .addComponent(label_13))
		        .addComponent(upMusicNameTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addGap(18)
		      .addGroup(gl_updateAlbum.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_updateAlbum.createSequentialGroup()
		          .addGap(6)
		          .addComponent(label_14))
		        .addComponent(upLangTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addGap(18)
		      .addGroup(gl_updateAlbum.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_updateAlbum.createSequentialGroup()
		          .addGap(4)
		          .addComponent(label_15))
		        .addComponent(upAudioCDBtn)
		        .addComponent(upVinylBtn))
		      .addGap(18)
		      .addGroup(gl_updateAlbum.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_updateAlbum.createSequentialGroup()
		          .addGap(3)
		          .addComponent(label_16))
		        .addComponent(upMusicProducerTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addGap(18)
		      .addGroup(gl_updateAlbum.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_updateAlbum.createSequentialGroup()
		          .addGap(3)
		          .addComponent(label_17))
		        .addComponent(upSongWriterTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addGap(18)
		      .addGroup(gl_updateAlbum.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_updateAlbum.createSequentialGroup()
		          .addGap(3)
		          .addComponent(label_18))
		        .addComponent(upComposerTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addGap(18)
		      .addGroup(gl_updateAlbum.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_updateAlbum.createSequentialGroup()
		          .addGap(3)
		          .addComponent(label_19))
		        .addComponent(upArrangerTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addGap(18)
		      .addGroup(gl_updateAlbum.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_updateAlbum.createSequentialGroup()
		          .addGap(3)
		          .addComponent(label_20))
		        .addComponent(upSingersTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addPreferredGap(ComponentPlacement.UNRELATED)
		      .addGroup(gl_updateAlbum.createParallelGroup(Alignment.BASELINE)
		        .addComponent(btnNewButton_1)
		        .addComponent(btnNewButton_2))
		      .addContainerGap(27, Short.MAX_VALUE))
		);
		updateAlbum.setLayout(gl_updateAlbum);
		
		JPanel updateMovie = new JPanel();
		frame.getContentPane().add(updateMovie, "updateMovie");
		
		JButton btnSearchMovie = new JButton("Search Movie");
		
		JLabel lblMovieName_2 = new JLabel("Movie name:");
		
		textField_30 = new JTextField();
		textField_30.setColumns(10);
		
		JLabel lblReleaseYear_2 = new JLabel("Release year:");
		
		textField_31 = new JTextField();
		textField_31.setColumns(10);
		
		JLabel lblChangeTheValues_1 = new JLabel("Change the values and click update to update the information of this movie");
		lblChangeTheValues_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_updateMovie = new GroupLayout(updateMovie);
		gl_updateMovie.setHorizontalGroup(
		  gl_updateMovie.createParallelGroup(Alignment.LEADING)
		    .addGroup(gl_updateMovie.createSequentialGroup()
		      .addGroup(gl_updateMovie.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_updateMovie.createSequentialGroup()
		          .addGap(104)
		          .addGroup(gl_updateMovie.createParallelGroup(Alignment.TRAILING)
		            .addComponent(btnSearchMovie)
		            .addGroup(gl_updateMovie.createSequentialGroup()
		              .addGroup(gl_updateMovie.createParallelGroup(Alignment.LEADING)
		                .addComponent(lblMovieName_2)
		                .addComponent(lblReleaseYear_2))
		              .addGap(18)
		              .addGroup(gl_updateMovie.createParallelGroup(Alignment.LEADING)
		                .addComponent(textField_30, GroupLayout.PREFERRED_SIZE, 425, GroupLayout.PREFERRED_SIZE)
		                .addComponent(textField_31, GroupLayout.PREFERRED_SIZE, 425, GroupLayout.PREFERRED_SIZE)))))
		        .addGroup(gl_updateMovie.createSequentialGroup()
		          .addGap(26)
		          .addComponent(lblChangeTheValues_1, GroupLayout.PREFERRED_SIZE, 553, GroupLayout.PREFERRED_SIZE)))
		      .addContainerGap(212, Short.MAX_VALUE))
		);
		gl_updateMovie.setVerticalGroup(
		  gl_updateMovie.createParallelGroup(Alignment.LEADING)
		    .addGroup(gl_updateMovie.createSequentialGroup()
		      .addGap(21)
		      .addComponent(lblChangeTheValues_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
		      .addGap(31)
		      .addGroup(gl_updateMovie.createParallelGroup(Alignment.BASELINE)
		        .addComponent(lblMovieName_2)
		        .addComponent(textField_30, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addGap(18)
		      .addGroup(gl_updateMovie.createParallelGroup(Alignment.BASELINE)
		        .addComponent(lblReleaseYear_2)
		        .addComponent(textField_31, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addGap(18)
		      .addComponent(btnSearchMovie)
		      .addContainerGap(439, Short.MAX_VALUE))
		);
		updateMovie.setLayout(gl_updateMovie);
		
		JPanel view = new JPanel();
		frame.getContentPane().add(view, "viewPanel");
		
		JLabel lblProductName = new JLabel("Product name:");
		
		searchNameTx = new JTextField();
		searchNameTx.setColumns(10);
		
		JLabel lblReleaseYear_3 = new JLabel("Release year:");
		
		searchYearTx = new JTextField();
		searchYearTx.setColumns(10);		

    JCheckBox chckbxBook = new JCheckBox("Book");
    
    JCheckBox chckbxAlbum = new JCheckBox("Album");
    
    JCheckBox chckbxMovie = new JCheckBox("Movie");
		
		JButton btnNewButton_4 = new JButton("Search");
		btnNewButton_4.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
		    // validate input fields
		    String name = searchNameTx.getText();
		    if (name.equals("") || checkHelper.checkIfNumerical(searchYearTx) < 0) {
		      System.out.println("please enter valid information");
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
            rs = SelectHelper.createView(name, year, types);
            if (rs != null) {
              JTable table = new JTable(buildTableModel(rs));
              // show views
              JOptionPane.showMessageDialog(null, new JScrollPane(table), "Data Table Preview", JOptionPane.INFORMATION_MESSAGE);
            } else {
              JOptionPane.showMessageDialog(null, "Please select at least one type (book, album, movie)", "No selected data", JOptionPane.ERROR_MESSAGE);
            }
          } catch (SQLException e1) {
            
            e1.printStackTrace();
          }
		    }
		  }
		});
		
		JButton btnCancel = new JButton("Cancel");
		GroupLayout gl_view = new GroupLayout(view);
		gl_view.setHorizontalGroup(
		  gl_view.createParallelGroup(Alignment.LEADING)
		    .addGroup(gl_view.createSequentialGroup()
		      .addGap(75)
		      .addGroup(gl_view.createParallelGroup(Alignment.LEADING)
		        .addComponent(lblProductName)
		        .addComponent(lblReleaseYear_3)
		        .addComponent(chckbxBook))
		      .addGap(43)
		      .addGroup(gl_view.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_view.createSequentialGroup()
		          .addComponent(searchYearTx, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE)
		          .addGap(58)
		          .addComponent(btnNewButton_4)
		          .addGap(33)
		          .addComponent(btnCancel))
		        .addGroup(gl_view.createSequentialGroup()
		          .addComponent(chckbxAlbum)
		          .addGap(59)
		          .addComponent(chckbxMovie))
		        .addComponent(searchNameTx, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE))
		      .addContainerGap(63, Short.MAX_VALUE))
		);
		gl_view.setVerticalGroup(
		  gl_view.createParallelGroup(Alignment.LEADING)
		    .addGroup(gl_view.createSequentialGroup()
		      .addGap(44)
		      .addGroup(gl_view.createParallelGroup(Alignment.BASELINE)
		        .addComponent(chckbxBook)
		        .addComponent(chckbxAlbum)
		        .addComponent(chckbxMovie))
		      .addGap(34)
		      .addGroup(gl_view.createParallelGroup(Alignment.LEADING)
		        .addComponent(searchNameTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		        .addComponent(lblProductName))
		      .addGap(22)
		      .addGroup(gl_view.createParallelGroup(Alignment.BASELINE)
		        .addComponent(lblReleaseYear_3)
		        .addComponent(searchYearTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		        .addComponent(btnNewButton_4)
		        .addComponent(btnCancel))
		      .addContainerGap(444, Short.MAX_VALUE))
		);
		view.setLayout(gl_view);
		
		JPanel insertAlbum2 = new JPanel();
		frame.getContentPane().add(insertAlbum2, "insertAlbum2");
		
		JButton button_2 = new JButton("Add a music track");
		button_2.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
		    CreateFrame createFrame = new CreateFrame(musicTracks);
		    
		  }
		});
		
		JLabel label = new JLabel("Please insert all the fields.");
		
		JLabel label_1 = new JLabel("Year:");
		
		JLabel label_43 = new JLabel("Album name:");
		
		insYearTx = new JTextField();
		insYearTx.setColumns(10);
		
		JLabel label_44 = new JLabel("Name of people who involved should be in the format of 'first_name family_name' or 'first_name middle_name family_name'");
		
		JLabel label_45 = new JLabel("Producer, song writer, composer and arranger can only have one name. Each music can store at most 2 singers, you can separate the names by comma ' , '.");
		
		JLabel label_46 = new JLabel("If the names are in the wrong format, it will not be stored in the database.");
		
		JLabel label_38 = new JLabel("Producer:");
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		
		JLabel lblMusicTracks = new JLabel("Music Tracks:");
		
		JScrollPane scrollPane_1 = new JScrollPane();

    JTextArea textAreaMusicTrack = new JTextArea();
    scrollPane_1.setViewportView(textAreaMusicTrack);
    
		JButton btnTry = new JButton("Refresh list");
		btnTry.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
		    // set music track name on main panel
		    String str = "";
		    for(MusicTrack mt: musicTracks) {
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
          System.out.println("fill in all mandatory fields and in correct format");
          JOptionPane.showMessageDialog(null, "fill in all mandatory fields and in correct format", "Insert music - wrong format", JOptionPane.ERROR_MESSAGE);
        } else if (checkHelper.checkIfNumerical(insYearTx) <= 0) {
          System.out.println("fill in the year in correct format (year > 0)");
          JOptionPane.showMessageDialog(null, "fill in the year in correct range", "Insert music - wrong range", JOptionPane.ERROR_MESSAGE);
        } else if (musicTracks.isEmpty()) {
          JOptionPane.showMessageDialog(null, "You should have at least one music track", "Insert music - no music track", JOptionPane.ERROR_MESSAGE);
        } else {
          // get the string values
          albumName = insAlbumTx.getText();
          year = Integer.parseInt(insYearTx.getText());
          producer = insProducerTx.getText();
          if (!checkHelper.checkNameFormat(producer)) {
            JOptionPane.showMessageDialog(null, "fill in the producer name in correct format", "Insert music - wrong name format", JOptionPane.ERROR_MESSAGE);
          } else {
          
            // check if the music album exist in Music, insert if not
            if (!checkHelper.albumExist(albumName)) {
              // insert music
              boolean success = TransactionHelper.insertMusicTransaction(albumName, year, producer, musicTracks);
              if (success) {
                JOptionPane.showMessageDialog(null, "Music inserted.", "Insert music - success", JOptionPane.INFORMATION_MESSAGE);
              } else {
                JOptionPane.showMessageDialog(null, "Music insertion fail due to unexpected error", "Insert music - error", JOptionPane.ERROR_MESSAGE);
              }
            } else {
  //            System.out.println("music track of that album already existed.");
              JOptionPane.showMessageDialog(null, "This music track of that album already existed", "Insert music - already existed", JOptionPane.ERROR_MESSAGE);
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
		GroupLayout gl_insertAlbum2 = new GroupLayout(insertAlbum2);
		gl_insertAlbum2.setHorizontalGroup(
		  gl_insertAlbum2.createParallelGroup(Alignment.TRAILING)
		    .addGroup(gl_insertAlbum2.createSequentialGroup()
		      .addGroup(gl_insertAlbum2.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_insertAlbum2.createSequentialGroup()
		          .addGap(52)
		          .addComponent(label))
		        .addGroup(gl_insertAlbum2.createSequentialGroup()
		          .addGap(52)
		          .addGroup(gl_insertAlbum2.createParallelGroup(Alignment.LEADING)
		            .addComponent(label_44)
		            .addComponent(label_45)
		            .addComponent(label_46)))
		        .addGroup(gl_insertAlbum2.createSequentialGroup()
		          .addGap(289)
		          .addComponent(label_38)
		          .addGap(39)
		          .addComponent(textField_17, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE))
		        .addGroup(gl_insertAlbum2.createSequentialGroup()
		          .addGap(279)
		          .addGroup(gl_insertAlbum2.createParallelGroup(Alignment.LEADING, false)
		            .addGroup(gl_insertAlbum2.createSequentialGroup()
		              .addComponent(lblMusicTracks)
		              .addGap(314))
		            .addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 397, GroupLayout.PREFERRED_SIZE)
		            .addGroup(gl_insertAlbum2.createSequentialGroup()
		              .addComponent(button_2)
		              .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		              .addComponent(btnTry))
		            .addGroup(gl_insertAlbum2.createSequentialGroup()
		              .addGap(319)
		              .addComponent(btnSubmit))
		            .addGroup(gl_insertAlbum2.createSequentialGroup()
		              .addGroup(gl_insertAlbum2.createParallelGroup(Alignment.LEADING, false)
		                .addComponent(label_43, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		                .addComponent(label_1)
		                .addComponent(lblProducer_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		              .addPreferredGap(ComponentPlacement.UNRELATED)
		              .addGroup(gl_insertAlbum2.createParallelGroup(Alignment.LEADING)
		                .addComponent(insAlbumTx, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
		                .addGroup(gl_insertAlbum2.createParallelGroup(Alignment.LEADING)
		                  .addComponent(insProducerTx, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
		                  .addComponent(insYearTx, GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)))))))
		      .addGap(155))
		);
		gl_insertAlbum2.setVerticalGroup(
		  gl_insertAlbum2.createParallelGroup(Alignment.LEADING)
		    .addGroup(gl_insertAlbum2.createSequentialGroup()
		      .addGap(38)
		      .addComponent(label)
		      .addGap(11)
		      .addComponent(label_45)
		      .addPreferredGap(ComponentPlacement.UNRELATED)
		      .addComponent(label_44)
		      .addPreferredGap(ComponentPlacement.UNRELATED)
		      .addComponent(label_46)
		      .addGap(22)
		      .addGroup(gl_insertAlbum2.createParallelGroup(Alignment.BASELINE)
		        .addComponent(label_43)
		        .addComponent(insAlbumTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addPreferredGap(ComponentPlacement.UNRELATED)
		      .addGroup(gl_insertAlbum2.createParallelGroup(Alignment.BASELINE)
		        .addComponent(label_1)
		        .addComponent(insYearTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addPreferredGap(ComponentPlacement.UNRELATED)
		      .addGroup(gl_insertAlbum2.createParallelGroup(Alignment.BASELINE)
		        .addComponent(lblProducer_1)
		        .addComponent(insProducerTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addGap(30)
		      .addComponent(lblMusicTracks)
		      .addGap(18)
		      .addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
		      .addGap(35)
		      .addGroup(gl_insertAlbum2.createParallelGroup(Alignment.BASELINE)
		        .addComponent(button_2)
		        .addComponent(btnTry))
		      .addGap(86)
		      .addComponent(btnSubmit)
		      .addGap(49)
		      .addGroup(gl_insertAlbum2.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_insertAlbum2.createSequentialGroup()
		          .addGap(376)
		          .addComponent(label_38))
		        .addGroup(gl_insertAlbum2.createSequentialGroup()
		          .addGap(373)
		          .addComponent(textField_17, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		      .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		musicTracks = new ArrayList<MusicTrack>();
		
		insertAlbum2.setLayout(gl_insertAlbum2);
		
		JPanel AddMusicTrackPanel = new JPanel();
		frame.getContentPane().add(AddMusicTrackPanel, "AddMusicTrackPanel");
		
		JButton button_3 = new JButton("Submit");
		
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
		gl_AddMusicTrackPanel.setHorizontalGroup(
		  gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING)
		    .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
		      .addGap(149)
		      .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.TRAILING)
		          .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
		            .addComponent(button_3, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
		            .addGap(18)
		            .addComponent(button_9, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
		          .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING, false)
		            .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
		              .addComponent(label_2)
		              .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		              .addComponent(insSingerTx2, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE))
		            .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
		              .addComponent(label_41, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
		              .addGap(23)
		              .addComponent(insSongWriterTx, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE))
		            .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
		              .addComponent(label_42, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
		              .addGap(32)
		              .addComponent(insComposerTx, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE))
		            .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
		              .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.TRAILING, false)
		                .addComponent(label_47, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		                .addComponent(label_48))
		              .addGap(39)
		              .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.TRAILING)
		                .addComponent(insArrangerTx, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)
		                .addComponent(insSingerTx1, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)))))
		        .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
		          .addComponent(label_4, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
		          .addGap(22)
		          .addComponent(insMusicTx, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
		        .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
		          .addComponent(label_5, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
		          .addGap(38)
		          .addComponent(insLangTx, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE))
		        .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
		          .addComponent(label_39)
		          .addGap(39)
		          .addComponent(radioButton_cd, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
		          .addGap(64)
		          .addComponent(radioButton_vinyl, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)))
		      .addContainerGap(566, Short.MAX_VALUE))
		);
		gl_AddMusicTrackPanel.setVerticalGroup(
		  gl_AddMusicTrackPanel.createParallelGroup(Alignment.TRAILING)
		    .addGroup(Alignment.LEADING, gl_AddMusicTrackPanel.createSequentialGroup()
		      .addGap(57)
		      .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
		          .addGap(3)
		          .addComponent(label_4))
		        .addComponent(insMusicTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addGap(18)
		      .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
		          .addGap(6)
		          .addComponent(label_5))
		        .addComponent(insLangTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addGap(18)
		      .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
		          .addGap(4)
		          .addComponent(label_39))
		        .addComponent(radioButton_cd)
		        .addComponent(radioButton_vinyl))
		      .addGap(18)
		      .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
		          .addGap(3)
		          .addComponent(label_41))
		        .addComponent(insSongWriterTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addGap(18)
		      .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
		          .addGap(3)
		          .addComponent(label_42))
		        .addComponent(insComposerTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addGap(18)
		      .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
		          .addGap(3)
		          .addComponent(label_48))
		        .addComponent(insArrangerTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addGap(18)
		      .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING)
		        .addComponent(insSingerTx1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		        .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
		          .addGap(3)
		          .addComponent(label_47)))
		      .addGap(18)
		      .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.BASELINE)
		        .addComponent(label_2)
		        .addComponent(insSingerTx2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addGap(18)
		      .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.BASELINE)
		        .addComponent(button_3)
		        .addComponent(button_9))
		      .addContainerGap(366, Short.MAX_VALUE))
		);
		AddMusicTrackPanel.setLayout(gl_AddMusicTrackPanel);
		
		
		
		
		
		
		
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
        	  CardLayout c = (CardLayout)(frame.getContentPane().getLayout());
        	  c.show(frame.getContentPane(), "insertBook");
          }
        });
		mnInsert.add(mntmBook);
		
		JMenuItem mntmAlbum = new JMenuItem("Album");
		mntmAlbum.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent event) {
        	// go to insert book page
        	  CardLayout c = (CardLayout)(frame.getContentPane().getLayout());
        	  c.show(frame.getContentPane(), "insertAlbum2");
          }
        });
		mnInsert.add(mntmAlbum);
		
		JMenuItem mntmMovie = new JMenuItem("Movie");
		mntmMovie.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {
      	// go to insert book page
      	  CardLayout c = (CardLayout)(frame.getContentPane().getLayout());
      	  c.show(frame.getContentPane(), "insertMovie");
        }
      });
		mnInsert.add(mntmMovie);
		
		JMenuItem menuUpdate = new JMenuItem("Update");
		menuUpdate.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
		    String name = JOptionPane.showInputDialog(null, "What do you want to update?", "Update dialog", JOptionPane.QUESTION_MESSAGE);
        // validate input field
        if (name == "") {
          JOptionPane.showMessageDialog(null, "You have to input a name", "Update dialog - need name", JOptionPane.ERROR_MESSAGE);
        } else {
          // search the product and redirect them to corresponding panel
          if(checkHelper.bookExist(name)) {
            CardLayout c = (CardLayout)(frame.getContentPane().getLayout());
            c.show(frame.getContentPane(), "updateBook");
            clearUpdateBook();
            // get data set
            ResultSet bookResult = null, bookKeyword = null, bookAuthors = null;
            String keywords = "";
            String isbn = SelectHelper.getBookIsbn(name);
            bookResult = SelectHelper.getBookInfo(isbn);
            bookKeyword = SelectHelper.getBookKeyword(isbn);
            bookAuthors = SelectHelper.getBookAuthorName(isbn);
            // show data textfield
            try {
              upBookTitleTx.setText(bookResult.getString("Title"));
              upISBN.setText(bookResult.getString("ISBN"));
              upPublisherTx.setText(bookResult.getString("Publisher"));
              upPagesTx.setText(bookResult.getString("NumberOfPages"));
              upBookYearTx.setText(String.valueOf(bookResult.getInt("YearOfPublication")));
              upEditionTx.setText(String.valueOf(bookResult.getInt("EditionNumber")));
              upAbstractTx.setText(bookResult.getString("Abstract"));
              upKeywordsTx.setText(keywords);
              try {
                if (bookKeyword != null) {
                  keywords = bookKeyword.getString("Tag");
                  System.out.println(keywords);
                  while (bookKeyword.next()) {
                    keywords += "," + bookKeyword.getString("Tag");
                  }
                  upKeywordsTx.setText(keywords);
                }
              } catch (SQLException e1) {
                // do nothing...
              }

              upAuthorTx1.setText(bookAuthors.getString("FullName"));
              if (bookAuthors.next()) {
                upAuthorTx2.setText(bookAuthors.getString("FullName"));
              }
              if (bookAuthors.next()) {
                upAuthorTx3.setText(bookAuthors.getString("FullName"));
              }
              if (bookAuthors.next()) {
                upAuthorTx4.setText(bookAuthors.getString("FullName"));
              }
              if (bookAuthors.next()) {
                upAuthorTx5.setText(bookAuthors.getString("FullName"));
              }
            } catch (SQLException e1) {
              e1.printStackTrace();
            }
          } else if(checkHelper.albumExist(name)) {
            CardLayout c = (CardLayout)(frame.getContentPane().getLayout());
            c.show(frame.getContentPane(), "updateAlbum2"); 
          } else if (checkHelper.movieExist(name)) {
            CardLayout c = (CardLayout)(frame.getContentPane().getLayout());
            c.show(frame.getContentPane(), "updateMovie");
          } else {
            JOptionPane.showMessageDialog(null, "Product not found", "Product not found", JOptionPane.INFORMATION_MESSAGE);
          }
        }
		  }
		});
		mnData.add(menuUpdate);
		
		JMenuItem mntmDelete = new JMenuItem("Remove");
		mntmDelete.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
		    String name = JOptionPane.showInputDialog(null, "What do you want to remove?", "Remove dialog", JOptionPane.QUESTION_MESSAGE);
		    // validate input field
		    if (name == "") {
		      JOptionPane.showMessageDialog(null, "You have to input a name", "Remove dialog - need name", JOptionPane.ERROR_MESSAGE);
		    } else {
		      // search the name in each category, if found, delete it
		      if(checkHelper.bookExist(name)) {
		        TransactionHelper.deleteBookTransaction(name);
		        JOptionPane.showMessageDialog(null, "Successfully deleted this book", "Remove successfully", JOptionPane.INFORMATION_MESSAGE);
		      } else if(checkHelper.albumExist(name)) {
		        TransactionHelper.deleteAlbumTransaction(name);
		        JOptionPane.showMessageDialog(null, "Successfully deleted all music tracks in this album", "Remove successfully", JOptionPane.INFORMATION_MESSAGE);
		      } else if (checkHelper.movieExist(name)) {
		        TransactionHelper.deleteMovieTransaction(name);
		        JOptionPane.showMessageDialog(null, "Successfully deleted this movie", "Remove successfully", JOptionPane.INFORMATION_MESSAGE);
		      } else {
		        JOptionPane.showMessageDialog(null, "Product not found", "Product not found", JOptionPane.INFORMATION_MESSAGE);
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
        CardLayout c = (CardLayout)(frame.getContentPane().getLayout());
        c.show(frame.getContentPane(), "viewPanel");
      }
    });
		mnView.add(mntmView);
		
		JMenu mnReport = new JMenu("Report");
		menuBar.add(mnReport);
		
		JMenuItem mntmRAuthors = new JMenuItem("R1 - Author's publication");
		mntmRAuthors.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent arg0) {
		    String name = JOptionPane.showInputDialog(null, "Which author are you searching for?", "R1 - Get author's name", JOptionPane.QUESTION_MESSAGE);
		    if (name.equals("")) {
		      JOptionPane.showMessageDialog(null, "Please enter a name", "No name is inserted", JOptionPane.ERROR_MESSAGE);
		    } else {
  		    ResultSet rs = null;
  		    rs = ReportHelper.createR1Report(name);
  		    try {
            if (rs != null) {
              JTable table;
              table = new JTable(buildTableModel(rs));
              // show views
              JOptionPane.showMessageDialog(null, new JScrollPane(table), "Data Table Preview", JOptionPane.INFORMATION_MESSAGE);
            } else {
              JOptionPane.showMessageDialog(null, "Please enter correct information", "something wrong", JOptionPane.ERROR_MESSAGE);
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
		    String str = JOptionPane.showInputDialog(null, "Which year are you searching for?", "R2 - Get publication year", JOptionPane.QUESTION_MESSAGE);
		    int year = checkHelper.checkIfNumerical(str);
        if (year < 0) {
          JOptionPane.showMessageDialog(null, "Please enter a positive number", "No number is inserted", JOptionPane.ERROR_MESSAGE);
        }
        if (str.equals("") || year < 0) {
          JOptionPane.showMessageDialog(null, "Please enter a positive number", "Need positive number", JOptionPane.ERROR_MESSAGE);
        } else {
          ResultSet rs = null;
          rs = ReportHelper.createR2Report(year);
          try {
            if (rs != null) {
              JTable table;
              table = new JTable(buildTableModel(rs));
              // show views
              JOptionPane.showMessageDialog(null, new JScrollPane(table), "Data Table Preview", JOptionPane.INFORMATION_MESSAGE);
            } else {
              JOptionPane.showMessageDialog(null, "Please enter correct information", "something wrong", JOptionPane.ERROR_MESSAGE);
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
		    String keyword = JOptionPane.showInputDialog(null, "What keyword are you searching for?", "R3 - Get a keyword", JOptionPane.QUESTION_MESSAGE);
        if (keyword.equals("")) {
          JOptionPane.showMessageDialog(null, "Please enter a string", "No string is inserted", JOptionPane.ERROR_MESSAGE);
        } else {
          ResultSet rs = null;
          rs = ReportHelper.createR3Report(keyword);
          try {
            if (rs != null) {
              JTable table;
              table = new JTable(buildTableModel(rs));
              // show views
              JOptionPane.showMessageDialog(null, new JScrollPane(table), "Data Table Preview", JOptionPane.INFORMATION_MESSAGE);
            } else {
              JOptionPane.showMessageDialog(null, "Please enter correct information", "something wrong", JOptionPane.ERROR_MESSAGE);
            }
          } catch (SQLException e1) {
            e1.printStackTrace();
          }
        }
		  }
		});
		mnReport.add(mntmRBooks);
		
		JMenuItem mntmRFrequent = new JMenuItem("R4 - Frequent publishers");
		mnReport.add(mntmRFrequent);
		
		JMenuItem mntmRMost = new JMenuItem("R5 - Most popular subjects");
		mntmRMost.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
		    
        ResultSet rs = null;
        rs = ReportHelper.createR5Report();
        try {
          if (rs != null) {
            JTable table;
            table = new JTable(buildTableModel(rs));
            // show views
            JOptionPane.showMessageDialog(null, new JScrollPane(table), "Data Table Preview", JOptionPane.INFORMATION_MESSAGE);
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
        rs = ReportHelper.createR6Report();
        try {
          if (rs != null) {
            JTable table;
            table = new JTable(buildTableModel(rs));
            // show views
            JOptionPane.showMessageDialog(null, new JScrollPane(table), "Data Table Preview", JOptionPane.INFORMATION_MESSAGE);
          }
        } catch (SQLException e1) {
          e1.printStackTrace();
        }
		  }
		});
		mnReport.add(mntmRMulti);
		
		JMenuItem mntmRAward = new JMenuItem("R7 - Award winning movies");
		mnReport.add(mntmRAward);
		
		JMenuItem mntmRMusic = new JMenuItem("R8 - Music with similar name");
		mntmRMusic.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
		    ResultSet rs = null;
        rs = ReportHelper.createR8Report();
        try {
          if (rs != null) {
            JTable table;
            table = new JTable(buildTableModel(rs));
            // show views
            JOptionPane.showMessageDialog(null, new JScrollPane(table), "Data Table Preview", JOptionPane.INFORMATION_MESSAGE);
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
        rs = ReportHelper.createR9Report();
        try {
          if (rs != null) {
            JTable table;
            table = new JTable(buildTableModel(rs));
            // show views
            JOptionPane.showMessageDialog(null, new JScrollPane(table), "Data Table Preview", JOptionPane.INFORMATION_MESSAGE);
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
        rs = ReportHelper.createR10Report();
        try {
          if (rs != null) {
            JTable table;
            table = new JTable(buildTableModel(rs));
            // show views
            JOptionPane.showMessageDialog(null, new JScrollPane(table), "Data Table Preview", JOptionPane.INFORMATION_MESSAGE);
          }
        } catch (SQLException e1) {
          e1.printStackTrace();
        }
		  }
		});
		mnReport.add(mntmRSimilar);
		
		

	}
	
	
	// functions for insert book ----------------------------------------------------------------------
	
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
	
	private void clearInsertAlbum() {
	  langTx.setText("");
    musicNameTx.setText("");
    yearTx.setText("");
    albumNameTx.setText("");
    ComposerTx.setText("");
    producerTx.setText("");
    songWriterTx.setText("");
    arrangerTx.setText("");
    singersTx.setText("");
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
	
	
	public enum diskType {
    AUDIOCD {
      public String getString() {
        return "audioCD";
      }

      public diskType getEnum() {
        return AUDIOCD;
      }

      @Override
      public int getEnumValue() {
        return 0;
      }
    }, VINYL {
      public String getString() {
        return "vinyl";
      }

      public diskType getEnum() {
        return VINYL;
      }

      @Override
      public int getEnumValue() {
        return 1;
      }
    };
    public List<diskType> getIteration() {
      List<diskType> diskTypes = new ArrayList<diskType>();
      for (diskType t : diskType.values()) {
        diskTypes.add(t.getEnum());
      }
      return diskTypes;
    }
    public abstract String getString();
    public abstract diskType getEnum();
    public abstract int getEnumValue();
  }
	
	public static class InserterHelper {
	  
	  public static void insertBook(String isbn, String title, String pub, int pages, int year, int edition, String bookabs) throws SQLException {
	    String sql = "insert into Book values (?,?,?,?,?,?,?);";
      PreparedStatement preparedStatement;
      // insert book
      preparedStatement = con.prepareStatement(sql);
      preparedStatement.setString(1, isbn);
      preparedStatement.setString(2, title);
      preparedStatement.setString(3, pub);
      preparedStatement.setInt(4, pages);
      preparedStatement.setInt(5, year);
      if (edition == -1) {
        preparedStatement.setNull(6, java.sql.Types.NULL);
      } else {
        preparedStatement.setInt(6, edition);
      }
      preparedStatement.setString(7, bookabs);
      preparedStatement.executeUpdate();
	  }
	  
	  public static void insertBookAuthor(String isbn, List<String> authors) throws SQLException {
	    String sql = "insert into Bookauthor values (?,?);";
	    int count = 0;
      PreparedStatement preparedStatement;
      int pplID = -1;
      for (String author : authors) {
        pplID = SelectHelper.getPeopleID(author);
        if (pplID == -1) {
          // author not exist
          System.out.println("author not exist");
          // add new author
          pplID = InserterHelper.insertNewPeople(author);
          if (pplID == -1) {
            System.out.println("The author name "+author+" is not in a correct format. will not add to database.");
            continue;
          }
        }
        // insert author after found/added
        preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, isbn);
        preparedStatement.setInt(2, pplID);
        preparedStatement.executeUpdate();
        count++;
      }
      if (count <= 0) {
        System.out.println("Need to add at least one valid author");
        throw new SQLException();
      }
	  }
	  
	  public static void insertBookKeyword(String isbn, int keyID) throws SQLException {
      String sql = "insert into BookKeyword values (?,?);";
      PreparedStatement preparedStatement;
      preparedStatement = con.prepareStatement(sql);
      preparedStatement.setString(1, isbn);
      preparedStatement.setInt(2, keyID);
      preparedStatement.executeUpdate();
    }
	  
	  public static void insertKeyword(String isbn, String[] keywords) throws SQLException {
	    int keyID = -1, nextKeyID = -1;
	    String sql = "insert into Keyword values (?,?);";
	    PreparedStatement preparedStatement;
	    if (keywords != null) {
        for (String keyword : keywords) {
          nextKeyID = SelectHelper.getNextKeywordID();
          keyID = SelectHelper.getKeywordID(keyword);
          if (nextKeyID == -1) {
            // sth wrong on getting next keyword id
            System.out.println("sth wrong - keyword");
          } else if (keyID < 0){
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, nextKeyID);
            preparedStatement.setString(2, keyword);
            preparedStatement.executeUpdate();
            keyID = nextKeyID;
          }
          insertBookKeyword(isbn, keyID);
        }
	    }
	  }
	  
	  public static int insertNewPeople(String fullname) throws SQLException {
	    int nextID = SelectHelper.getNextPeopleID();
	    String first=null, mid=null, last = null;
	    String[] name = fullname.split(" ");
	    if (nextID > 0) {
	      if (name.length == 2) {
	        first = name[0];
	        last = name[1];
	      } else if (name.length >= 3) {
	        first = name[0];
	        mid = name[1];
	        last = name[2];
	      } else {
	        // sth wrong
	        System.out.println("should be first + [mid] + last name");
	      }
	      if (name.length >= 2) {
	        // insert new author
	        String sql = "insert into PeopleInvolved values (?,?,?,?,?);";
	        try {
	          PreparedStatement preparedStatement;
	          preparedStatement = con.prepareStatement(sql);
	          preparedStatement.setInt(1, nextID);
	          preparedStatement.setString(2, first);
	          preparedStatement.setString(3, mid);
	          preparedStatement.setString(4, last);
	          preparedStatement.setString(5, null);
	          preparedStatement.executeUpdate();
	          System.out.println("added new people");
	          return nextID;
	        } catch (SQLException e) {
	          e.printStackTrace();
	        }
	      }
	    }
	    return -1;
	  }
	  public static void insertAlbum(String albumName, int year, String musicName, String language, diskType diskType, String producer) throws SQLException {
	     int producerID = SelectHelper.getPeopleID(producer);
	     String sql = "insert into Music values (?,?,?,?,?,?);";
	       PreparedStatement ps = con.prepareStatement(sql);
	       ps.setString(1, albumName);
	       ps.setInt(2, year);
	       ps.setString(3, musicName);
	       ps.setString(4, language);
	       ps.setInt(5, diskType.getEnumValue());
	       ps.setInt(6, producerID);
	       ps.executeUpdate();
	   }
	   
	   public static void insertMusicSinger(String albumName, int year, String musicName, int id) throws SQLException {
	     String sql = "insert into MusicSinger values (?,?,?,?);";
	     PreparedStatement ps;
	      ps = con.prepareStatement(sql);
	      ps.setString(1, albumName);
	      ps.setInt(2, year);
	      ps.setString(3, musicName);
	      ps.setInt(4, id);
	      ps.executeUpdate();
	   }
	   
	   public static void insertMusicPeopleInvolved(String albumName, int year, String musicName, int ppl, int sw, int c, int a) throws SQLException {
	     String sql = "insert into PeopleInvolvedMusic values (?,?,?,?,?,?,?);";
	     PreparedStatement ps;
	      ps = con.prepareStatement(sql);
	      ps.setString(1, albumName);
	      ps.setInt(2, year);
	      ps.setString(3, musicName);
	      ps.setInt(4, ppl);
	      ps.setInt(5, sw);
	      ps.setInt(6, c);
	      ps.setInt(7, a);
	      ps.executeUpdate();
	   }
	   
	   public static void insertMovie(String movieName, int movieYear) throws SQLException {
	     String sql = "insert into Movie values (?,?);";
	     PreparedStatement ps;
	       ps = con.prepareStatement(sql);
	       ps.setString(1, movieName);
	       ps.setInt(2, movieYear);
	       ps.executeUpdate();	   
	   }
	   
//	   public static boolean insertAward(String movieName, int movieYear, Map<String, String> allCrewNameRole, List<String> castNameList) {
	   public static void insertAward(String movieName, int movieYear, Map<String, List<String>> allCrewNameRole) throws SQLException {
	     String sql = "insert ignore into award values (?,?,?,?);";
	     PreparedStatement ps;
       ps = con.prepareStatement(sql);
       ps.setString(2, movieName);
       ps.setInt(3, movieYear);
       ps.setInt(4, 0);
       for (String name : allCrewNameRole.keySet()) {
         // get id
         ps.setInt(1, SelectHelper.getPeopleID(name));
         ps.executeUpdate();
       }
	   }
	   
	  public static void insertCrewMember(String movieName, int movieYear, Map<String, List<String>> allCrewNameRole) throws SQLException {
	    String sql = "insert into CrewMember values (?,?,?,?);";
	    Map<String,String> flags = new HashMap<String,String>();  
	    PreparedStatement ps;
      ps = con.prepareStatement(sql);
      ps.setString(2, movieName);
      ps.setInt(3, movieYear);
      for (String name : allCrewNameRole.keySet()) {
        // get peopleID for people
        ps.setInt(1, SelectHelper.getPeopleID(name));
        // for each role the person has
        for (String role: allCrewNameRole.get(name)) {
          ps.setInt(4, SelectHelper.getRoleID(role));
          ps.executeUpdate();
          flags.put(role, name);
        }
	    }
      // check if all the roles have at least 1 people
      if (flags.size() < 7) {
        throw new SQLException();
      }
	  }
	   
	}
	
	public static class checkHelper {
	  
	  public static boolean checkNameFormat(String name) {
	    String[] temp = name.split(" ");
      if ((temp.length < 2) || (temp.length>3)) {
        JOptionPane.showMessageDialog(null, "Some of the names are in wrong format.", "Insert music - wrong name format", JOptionPane.ERROR_MESSAGE);
        return false;
      }
      return true;
	  }
	  
	  public static boolean bookExist(String bookTitle) {
	    if (SelectHelper.getBookCount(bookTitle) > 0) {
	      return true;
	    }
	    return false;
	  }
	  
	  public static boolean albumExist(String albumName) {
	    if (SelectHelper.getAlbumMusicsCount(albumName) > 0) {
	      return true;
	    }
	    return false;
	  }
	  
	  public static boolean movieExist(String movieName) {
	    if (SelectHelper.getMovieCount(movieName) > 0) {
	      return true;
	    }
	    return false;
	  }
	  
	  public static boolean checkIsbnFormat(String isbn) {
	    String pattern = "^\\d{13}$";
	    Pattern r = Pattern.compile(pattern);
	    Matcher m = r.matcher(isbn);
	    if (m.find()) {
	      return true;
	    }
	    return false;
	  }
	  
	  public static boolean musicExist(String albumName, int year, String musicName) {
	     ResultSet rs = SelectHelper.getAlbums();
	     try {
	       while(rs.next()) {
	        if (rs.getString("AlbumName").equalsIgnoreCase(albumName)) {
	           if (rs.getInt("Year") == year) {
	             if (rs.getString("MusicName").equalsIgnoreCase(musicName)) {
	                 return true;
	             }
	           }
	         }
	       }
	     } catch (SQLException e) {
	       e.printStackTrace();
	     }
	     return false;
	   }
	  
	  public static boolean musicExistNoYear(String albumName, String musicName) {
      ResultSet rs = SelectHelper.getAlbums();
      try {
        while(rs.next()) {
         if (rs.getString("AlbumName").equalsIgnoreCase(albumName)) {
            if (rs.getString("MusicName").equalsIgnoreCase(musicName)) {
              return true;
            }
          }
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return false;
    }
	   
	   public static int checkIfNumerical(JTextField text) {
	     int result = -1;
	     try {
	       result = Integer.parseInt(text.getText());
	     } catch (NumberFormatException nfe) {
	       // Not a number
	       result = -1;
	     }
	     return result;
	   }
	   
	   public static int checkIfNumerical(String str) {
	     int result = -1;
       try {
         result = Integer.parseInt(str);
       } catch (NumberFormatException nfe) {
         // Not a number
         result = -1;
       }
       return result;
	   }
	}
	
	public static class DeleteHelper {
	  
	    public static void removeBook(String isbn) throws SQLException {
  	    String sql = "delete from book where isbn = ?;";
  	    PreparedStatement preparedStatement;
  	    preparedStatement = con.prepareStatement(sql);
  	    preparedStatement.setString(1, isbn);
  	    preparedStatement.executeUpdate();
  	  }
	    
	    public static void removeBookKeyword(String isbn) throws SQLException {
	      String sql = "delete from bookkeyword where isbn = ?;";
	      PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, isbn);
        preparedStatement.executeUpdate();
	    }
	    
	    public static void removeBookAuthor(String isbn) throws SQLException {
	      String sql = "delete from BookAuthor where isbn = ?;";
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, isbn);
        preparedStatement.executeUpdate();
	    }
	    
	    public static void removeMusic(String albumName,String musicName) throws SQLException {
	      String sql = "delete from Music where AlbumName = ? and MusicName = ?;";
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, albumName);
        preparedStatement.setString(2, musicName);
        preparedStatement.executeUpdate();
	    }
	    
	    public static void removeMusicSingers(String albumName,String musicName) throws SQLException {
	      String sql = "delete from MusicSinger where AlbumName = ? and MusicName = ?;";
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, albumName);
        preparedStatement.setString(2, musicName);
        preparedStatement.executeUpdate();
	    }
	    
	    public static void removeMusicPeopleInvolved(String albumName, String musicName) throws SQLException {
	      String sql = "delete from PeopleInvolvedMusic where AlbumName = ? and MusicName = ?;";
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, albumName);
        preparedStatement.setString(2, musicName);
        preparedStatement.executeUpdate();
	    }
	  
	    public static void removeMovie(String movieName) throws SQLException {
	      String sql = "delete from Movie where movieName = ?;";
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, movieName);
        preparedStatement.executeUpdate();
	    }
	    
	    public static void removeMovieAward(String movieName) throws SQLException {
	      String sql = "delete from Award where movieName = ?;";
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, movieName);
        preparedStatement.executeUpdate();
	    }
	    
	    public static void removeMovieCrew(String movieName) throws SQLException {
	      String sql = "delete from CrewMember where movieName = ?;";
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, movieName);
        preparedStatement.executeUpdate();
	    }
	}
		 
	 
	public static class SelectHelper {
	  public static String getBookIsbn(String bookTitle) {
	    String sql = "Select isbn from Book where Title = ?;";
	    ResultSet rs = null;
      PreparedStatement ps;
      try {
        ps = con.prepareStatement(sql);
        ps.setString(1, bookTitle);
        rs = ps.executeQuery();
        rs.next();
        return rs.getString("ISBN");
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return null;
	  }
	  
	  public static int getBookCount(String bookTitle) {
	    String sql = "Select count(*) from Book where Title = ?;";
	    ResultSet rs = null;
	    PreparedStatement ps;
      try {
        ps = con.prepareStatement(sql);
        ps.setString(1, bookTitle);
        rs = ps.executeQuery();
        rs.next();
        return rs.getInt("count(*)");
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return -1;
	  }
	  
	  public static int getAlbumMusicsCount(String albumName) {
	    String sql = "Select count(*) from music where albumName=?;";
	    ResultSet rs = null;
      PreparedStatement ps;
      int count = -1;
      try {
        ps = con.prepareStatement(sql);
        ps.setString(1, albumName);
        rs = ps.executeQuery();
        rs.next();
        count = rs.getInt("count(*)");
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return count;
	  }
	  
	  public static int getMovieCount(String movieName) {
	    String sql = "Select count(*) from Movie where MovieName = ?;";
      ResultSet rs = null;
      PreparedStatement ps;
      try {
        ps = con.prepareStatement(sql);
        ps.setString(1, movieName);
        rs = ps.executeQuery();
        rs.next();
        return rs.getInt("count(*)");
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return -1;
	  }

    public static ResultSet getAlbumMusics(String albumName) {
      String sql = "Select MusicName from music where AlbumName=?;";
      ResultSet rs = null;
      PreparedStatement ps;
      try {
        ps = con.prepareStatement(sql);
        ps.setString(1, albumName);
        rs = ps.executeQuery();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return rs;
    }
    
	  public static ResultSet getBookInfo(String isbn) {
	    String sql = "Select * from book where ISBN = ?;";
      ResultSet rs = null;
	    PreparedStatement ps;
      try {
        ps = con.prepareStatement(sql);
        ps.setString(1, isbn);
        rs = ps.executeQuery();
        rs.next();
      } catch (SQLException e) {
        e.printStackTrace();
      }
	    return rs;
	  }
	  public static ResultSet getBookAuthorName(String isbn) {
	    String sql = "SELECT CASE WHEN ISNULL(p.MiddleName) " + 
	        "THEN concat(p.firstName, ' ', p.familyname) " + 
	        "ELSE concat(p.firstName, ' ',p.middlename, ' ', p.familyname) " + 
	        "END FullName " + 
	        "FROM peopleinvolved p, bookauthor a where p.ID = a.author_id and a.isbn = ?;";
	    ResultSet rs = null;
	    PreparedStatement ps;
	    try {
	      ps = con.prepareStatement(sql);
	      ps.setString(1, isbn);
	      rs = ps.executeQuery();
	      rs.next();
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return rs;
	  }
	  public static ResultSet getBookKeyword(String isbn) {
	    String sql = "select k.tag from bookkeyword bk, keyword k " + 
	        "where bk.keyword_id = k.id and bk.isbn = ?;";
	    ResultSet rs = null;
      PreparedStatement ps;
      try {
        ps = con.prepareStatement(sql);
        ps.setString(1, isbn);
        rs = ps.executeQuery();
        rs.next();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return rs;
	  }
	  
	   public static int getPeopleID(String fullname) {
	     String sql = "Select ID from PeopleInvolved where concat(FirstName,' ',FamilyName) = ?;";
	     String sql2 = "Select ID from PeopleInvolved where concat(FirstName,' ', MiddleName, ' ', FamilyName) = ?;";
       String[] name = fullname.split(" ");
	     PreparedStatement preparedStatement = null;
	     try {
	       if (name.length == 2) {
  	       preparedStatement = con.prepareStatement(sql);
	       } else if (name.length > 2) {
	         preparedStatement = con.prepareStatement(sql2);
	       } else {
	         return -1;
	       }
	       preparedStatement.setString(1, fullname);
         ResultSet rs = preparedStatement.executeQuery();
         if (rs.next()) {
           return (rs.getInt("ID"));
         }
	     } catch (Exception e){
	       e.printStackTrace();
	     }
	     return -1;
	   }
	   
	   public static int getNextKeywordID() {
	     String sql = "Select count(*) from keyword;";
	     try {
	       PreparedStatement preparedStatement = con.prepareStatement(sql);
	       ResultSet rs = preparedStatement.executeQuery();
	       if (rs.next()) {
	         int id = rs.getInt("count(*)");
	         return id + 1;
	       }
	     } catch (SQLException e) {
	       e.printStackTrace();
	     }
	     return -1;
	   }

	   public static int getKeywordID(String keyword) {
	     String sql = "Select ID from keyword where Tag = ?;";
	     try {
	       PreparedStatement preparedStatement = con.prepareStatement(sql);
	       preparedStatement.setString(1, keyword);
	       ResultSet rs = preparedStatement.executeQuery();
	       if (rs.next()) {
	         int id = rs.getInt("ID");
	         return id;
	       }
	     } catch (SQLException e) {
	       e.printStackTrace();
	     }
	     return -1;
	   }
	   
	   public static int getNextPeopleID() {
	     String sql = "Select count(*) from PeopleInvolved;";
	     try {
	       PreparedStatement preparedStatement = con.prepareStatement(sql);
	       ResultSet rs = preparedStatement.executeQuery();
	       if (rs.next()) {
	         int id = rs.getInt("count(*)");
	         return id + 1;
	       }
	     } catch (SQLException e) {
	       e.printStackTrace();
	     }
	     return -1;
	   }
	   
	   public static boolean bookexist(String isbn) {
	     String sql = "select count(*) from Book where ISBN = ?;";
	     try {
	       PreparedStatement preparedStatement;
	       preparedStatement = con.prepareStatement(sql);
	       preparedStatement.setString(1, isbn);
	       ResultSet rs = preparedStatement.executeQuery();
	       if (rs.next()) {
	         if (rs.getInt("count(*)") > 0) {
	           return true;
	         }
	       }
	       return false;
	     } catch (SQLException e) {
	       e.printStackTrace();
	     }
	     return true;
	   }
	   
	   public static List<String> getPeopleNames() {
	      String sql = "Select concat(FirstName,' ',FamilyName) fullname from PeopleInvolved;";
	      List<String> names = new ArrayList<String>();
	      PreparedStatement preparedStatement;
	      try {
	        preparedStatement = con.prepareStatement(sql);
	        ResultSet rs = preparedStatement.executeQuery();
	        if (rs.next()) {
	          names.add(rs.getString("fullname"));
	        }
	      } catch (Exception e){
	        e.printStackTrace();
	      }
	      return names;
	    }
	   
	   public static ResultSet getAlbums() {
	     String sql = "Select AlbumName, Year, MusicName, Producer_ID from Music;";
	     ResultSet albumsInfo = null;
	     PreparedStatement preparedStatement;
	     try {
	       preparedStatement = con.prepareStatement(sql);
	       albumsInfo = preparedStatement.executeQuery();
	     } catch (Exception e){
	       e.printStackTrace();
	     }
	     return albumsInfo;

	   }
	   
	   public static int getRoleID(String role) {
	     String sql = "select ID from role where Description = ?;";
	     PreparedStatement ps;
	     try {
	       ps = con.prepareStatement(sql);
	       ps.setString(1, role);
	       ResultSet rs = ps.executeQuery();
	       if (rs.next()) {
	         return rs.getInt("ID");
	       }      
	     } catch (SQLException e) {
	       e.printStackTrace();
	     }
	     return -1;
	   }
	   
	   public static boolean checkMovieExist(String movieName, int movieYear) {
       String sql = "select count(*) from Movie where MovieName = ? and Year = ?;";
       int found = -1;
       PreparedStatement ps;
       try {
         ps = con.prepareStatement(sql);
         ps.setString(1, movieName);
         ps.setInt(2, movieYear);
         ResultSet rs = null;
         rs = ps.executeQuery();
         if (rs.next()) {
           found = rs.getInt("count(*)");
         }
         if (found == 0) {
           return false;
         }
       } catch (SQLException e) {
         e.printStackTrace();
       }
       return true;
     }
   
     public static boolean checkMusicCastExist(String albumName, int year, String musicName, int ppl) {
       String sql = "Select count(*) from PeopleInvolvedMusic " + 
           "group by AlbumName, Year, MusicName, PeopleInvolved_ID " + 
           "having AlbumName = ? and Year = ? and MusicName = ? and PeopleInvolved_ID = ?;";
       ResultSet rs = null;
       int found = -1;
       PreparedStatement ps;
       try {
         ps = con.prepareStatement(sql);
         ps.setString(1, albumName);
         ps.setInt(2, year);
         ps.setString(3, musicName);
         ps.setInt(4, ppl);
         rs = ps.executeQuery();
         if (rs.next()) {
           found = rs.getInt("count(*)");
         }
         if (found > 0) {
           return true;
         }
       } catch (Exception e){
         e.printStackTrace();
       }
       return false;
     }
     
     public static ResultSet getResultByQuery(String name, int year, String sql, int count) {
       PreparedStatement ps;
       ResultSet rs = null;
       try {
        ps = con.prepareStatement(sql);
        for (int i = 1; i <= count*2; i=i+2) {
          ps.setString(i, "%" + name + "%");
          ps.setInt(i+1, year);
        }
        if (count > 0) {
          rs = ps.executeQuery();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
       return rs;
     }
     
     public static ResultSet createView(String name, int year, Map<String, Boolean> types) {
       // build query
       String sql = BuildQueryHelper.bulidForView(types);
       // count how many box checked
       int count = 0;
       for (String b : types.keySet()) {
         if (types.get(b)) {
           count++;
         }
       }
       // run query
       ResultSet rs = SelectHelper.getResultByQuery(name, year, sql, count);
       return rs;
     }
	 }
	
	public static class BuildQueryHelper {
	  
	  public static String bulidForView(Map<String, Boolean> types) {
	    boolean exist = true, success = true;
	    String sql = "";
	    Map<String, String> viewNames = new HashMap<String, String>();
	    viewNames.put("authorView", "a");
	    viewNames.put("SingerView", "s");
	    viewNames.put("crewView", "c");
	    for (String viewname : viewNames.keySet()) {
	      exist = checkIfTableExist(viewname);
	      if (!exist) {
	        switch (viewNames.get(viewname)) {
	          case "a":
	            CreateViewHelper.createViewForViewPartAuthor();
	          case "s":
              CreateViewHelper.createViewForViewPartSinger();
	          case "c":
              CreateViewHelper.createViewForViewPartCrew();
	          default:
	            success = false;
	        }
	      }
	    }
	    if (success) {
	      // build query
	      sql = "select ProductName, Year, Type, Author_singer_director from (";
	      int count = 0;
	      for (String b: types.keySet()) {        
	        // if it's checked
	        if (types.get(b)) {
	          // if there's sql in sql string
	          count ++;
	          if (count > 1) {
	            sql += " union ";
	          }
	          if (b.equals("book")) {
	            sql += "select ProductName, Year, Type, Author_singer_director " + 
	                "from authorView " + 
	                "where title like ? and year = ?";
	          } else if (b.equals("album")) {
	            sql += "select ProductName, Year, Type, Author_singer_director " + 
	                "from singerView " + 
	                "where albumName like ? and year = ?";
	          } else if (b.equals("movie")) {
	            sql += "select ProductName, Year, Type, Author_singer_director " + 
	                "from crewView " + 
	                "where moviename like ? and year = ?";
	          }
	          
	        }
	      }
	      // end query
	      if (count > 0) {
	        sql += ") t order by Author_singer_director;";
	      }
	    } else {
	      JOptionPane.showMessageDialog(null, "Something wrong when building query", "View - unexpected error", JOptionPane.ERROR_MESSAGE);
	    }
	    return sql;
	  }
	}
	 
	public static class TransactionHelper {
	  
	  public static boolean insertBookTransaction(String isbn, String title, String pub, int pages, int year, int edition,
	      String bookabs, List<String> authors, String[] keywords) {
      try {
        con.setAutoCommit(false);
        // insert book
        InserterHelper.insertBook(isbn, title, pub, pages, year, edition, bookabs);
        System.out.println("book inserted");
        // insert authors
        InserterHelper.insertBookAuthor(isbn, authors);
        System.out.println("book authors inserted");
        // insert keywords
        InserterHelper.insertKeyword(isbn, keywords);
        System.out.println("book keywords inserted");
        con.commit();
        return true;
      } catch (SQLException e) {
        try {
          con.rollback();
          System.out.println("Something wrong when inserting data");
          System.out.println("Rolling back data...");
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
	  
	  public static boolean insertMovieTransaction(String movieName, int movieYear, Map<String, List<String>> allCrewNameRole) {
      try {
	      con.setAutoCommit(false);
	       // insert movie if not exist
	      InserterHelper.insertMovie(movieName, movieYear);
	      System.out.println("movie inserted");
	      // insert crew into crewMember
	      InserterHelper.insertCrewMember(movieName, movieYear, allCrewNameRole);
	      System.out.println("crewMember inserted");
        // insert award
        InserterHelper.insertAward(movieName, movieYear, allCrewNameRole);
        System.out.println("award inserted - default all no award");
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
	   
	  public static boolean insertMusicTransaction(String albumName, int year, String producer, List<MusicTrack> musicTracks) {
       int pplID = -1;
       try {
         con.setAutoCommit(false);
         for (MusicTrack mt: musicTracks) {
           
           for (String s : mt.getSingers()) {
             pplID = SelectHelper.getPeopleID(s);
             if (pplID == -1) {
               // author not exist
               System.out.println("singer not exist");
               // add new author
               pplID = InserterHelper.insertNewPeople(s);
               if (pplID == -1) {
                 System.out.println("The author name "+ s +" is not in a correct format. will not add to database.");
                 // revert - remove 
                 break;
               }
             }
           }
           
           for (String s : mt.getCasts()) {
             pplID = SelectHelper.getPeopleID(s);
             if (pplID == -1) {
               // author not exist
               System.out.println("music cast not exist");
               // add new author
               pplID = InserterHelper.insertNewPeople(s);
               if (pplID == -1) {
                 System.out.println("The music cast name "+ s +" is not in a correct format. will not add to database.");
                 // revert - remove 
                 break;
               }
             }
           }
           
           pplID = SelectHelper.getPeopleID(producer);
           if (pplID == -1) {
             // producer not exist
             System.out.println("producer not exist");
             // add new producer
             pplID = InserterHelper.insertNewPeople(producer);
             if (pplID == -1) {
               System.out.println("The producer name "+ producer +" is not in a correct format. will not add to database.");
             }
           }
           
           int id = -1;
           
           // update the hashmap to storing the id of musicpeoples
           Map<String, Integer> musicpeopleid = new HashMap<String, Integer>();
           musicpeopleid = mt.getCastIDHashMap();
           
             System.out.println("here");
             // insert only if that piece of soundtrack is not in db
             // insert into Music table
             InserterHelper.insertAlbum(albumName, year, mt.getMusicName(), mt.getLanguage(), mt.getType(), producer);
             // insert into MusicSinger
             // only add at most 2 singers for each song
             for (int sid : mt.getSingerIDHashMap().values()) {
               // add the people is exist in peopleInvolved
               InserterHelper.insertMusicSinger(albumName, year, mt.getMusicName(), sid);
               System.out.println("inserted music singer");
             }
             // insert into PeopleInvolvedMusic
             // check the role for each people
    
             Map<String, Integer> temprole = new HashMap<String, Integer>();
             // for each people, serach their roles in music
             for (int ppl : musicpeopleid.values()) {
               // check if this people is inserted already
               if (!SelectHelper.checkMusicCastExist(albumName, year, mt.getMusicName(), ppl)) {
                 for (String role : musicpeopleid.keySet()) {
                   if (musicpeopleid.get(role).equals(ppl)) {
                     temprole.put(role, ppl);
                   }
                 }
                 // insert
                 int sw = 0, c=0, a=0;
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
                 InserterHelper.insertMusicPeopleInvolved(albumName, year, mt.getMusicName(), ppl, sw, c, a);
                 System.out.println("inserted music people involved " + ppl);
                 // reset the hashmap
                 temprole.clear();
                 sw = 0; c = 0; a= 0;
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
	  
	  public static void deleteBookTransaction(String bookTitle) {
	    try {
	      con.setAutoCommit(false);
	      String isbn = SelectHelper.getBookIsbn(bookTitle);
        DeleteHelper.removeBookKeyword(isbn);
        DeleteHelper.removeBookAuthor(isbn);
        DeleteHelper.removeBook(isbn);
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
	  
	  public static void deleteMusicTransaction(String albumName, String musicName) {
	    try {
        con.setAutoCommit(false);
        DeleteHelper.removeMusicSingers(albumName, musicName);
        DeleteHelper.removeMusicPeopleInvolved(albumName, musicName);
        DeleteHelper.removeMusic(albumName, musicName);
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
	  
	  public static void deleteAlbumTransaction(String albumName) {
	    try {
        con.setAutoCommit(false);
        // search all music in that album
        ResultSet rs = SelectHelper.getAlbumMusics(albumName);
        String musicName = "";
        while (rs.next()) {
          musicName = rs.getString("MusicName");
          DeleteHelper.removeMusicSingers(albumName, musicName);
          DeleteHelper.removeMusicPeopleInvolved(albumName, musicName);
          DeleteHelper.removeMusic(albumName, musicName);
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
	  
	  public static void deleteMovieTransaction(String movieName) {
	    try {
        con.setAutoCommit(false);
        DeleteHelper.removeMovieAward(movieName);
        DeleteHelper.removeMovieCrew(movieName);
        DeleteHelper.removeMovie(movieName);
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
	
	private static class ReportHelper {
	  public static ResultSet createR1Report(String fullname) {
	    String[] name = fullname.split(" ");
      ResultSet rs = null;
	    String sql = "select b.ISBN, b.Title, b.YearOfPublication " + 
	        "from Book b, bookauthor ba, peopleinvolved p " + 
	        "where b.ISBN = ba.ISBN and ba.author_id = p.id and concat(p.firstname,' ',p.familyname) = ? " + 
	        "order by ISBN;";
	    if (name.length >= 3) {
	      sql = "select b.ISBN, b.Title, b.YearOfPublication " + 
	          "from Book b, bookauthor ba, peopleinvolved p " + 
	          "where b.ISBN = ba.ISBN and ba.author_id = p.id and concat(p.firstname,' ',p.middlename,' ',p.familyname) = ? " + 
	          "order by ISBN;";
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
	  
	  public static ResultSet createR2Report(int year) {
	    String sql = "select b.ISBN, b.title, b.YearOfPublication, p.familyname, upper(SUBSTRING(p.firstname,1,1)) initials " + 
	        "from book b, bookauthor ba, peopleinvolved p " + 
	        "where b.isbn = ba.isbn and ba.author_id = p.id and yearOfPublication = ? " + 
	        "order by b.title;";
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
	  
	  public static ResultSet createR3Report(String keyword) {
	    String sql = "select isbn, title, yearofpublication " + 
	        "from " + 
	        "(select b.isbn, b.title, b.yearofpublication " + 
	        "from book b " + 
	        "inner join bookkeyword bk " + 
	        "on b.isbn = bk.isbn " + 
	        "inner join keyword k " + 
	        "on k.id = bk.keyword_id " + 
	        "where k.tag like ?  " + 
	        "union " + 
	        "select ISBN, title, yearOfPublication  " + 
	        "from book  " + 
	        "where abstract like ? or title like ?) a " + 
	        "order by isbn;";
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
	  
	  public static ResultSet createR5Report() {
	    // create a view if not exist yet
	    boolean exist = checkIfTableExist("keywordFrequency");
	    boolean success = true;
	    ResultSet rs = null;
	    if(!exist) {
	      success = CreateViewHelper.createViewForR5();
	    }
	    // execute query if view exist
	    if (success) {
	      String sql = "select k.tag, kf.frequency " + 
	          "from bookkeyword bk, keyword k, keywordFrequency kf " + 
	          "where bk.keyword_id = k.id and kf.tag = k.tag and kf.frequency in (select max(frequency) from keywordFrequency) " + 
	          "group by k.tag " + 
	          "order by k.tag;";
	      Statement statement;
	      try {
	        statement = con.createStatement();
	        rs = statement.executeQuery(sql);
	      } catch (SQLException e) {
	        e.printStackTrace();
	      }
	    }
      return rs;
	  }
	  
	  public static ResultSet createR6Report() {
      // create a view if not exist yet
      boolean exist = checkIfTableExist("multiSkillsMovieCrew");
      boolean success = true;
      ResultSet rs = null;
      if(!exist) {
        success = CreateViewHelper.createViewForR6();
      }
      // execute query if view exist
      if (success) {
        String sql = "select p.familyname, r.description, cm.moviename " + 
            "from peopleinvolved p " + 
            "inner join crewmember cm " + 
            "on cm.peopleinvolved_id = p.id " + 
            "inner join multiSkillsMovieCrew t " + 
            "on t.peopleinvolved_id = p.id " + 
            "inner join role r " + 
            "on r.id = cm.role_id " + 
            "where t.numroles >= (select max(numroles) from multiSkillsMovieCrew) and t.moviename = cm.moviename " + 
            "order by p.familyname;";
        Statement statement;
        try {
          statement = con.createStatement();
          rs = statement.executeQuery(sql);
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      return rs;
    }
	  
	  public static ResultSet createR8Report() {
      // create a view if not exist yet
      boolean exist = checkIfTableExist("musicNameDupNum");
      boolean success = true;
      ResultSet rs = null;
      if(!exist) {
        success = CreateViewHelper.createViewForR8();
      }
      // execute query if view exist
      if (success) {
        String sql = "select ms.albumname, ms.musicname, ms.year, CASE WHEN ISNULL(p.MiddleName) " + 
            "THEN concat(p.firstName, ' ', p.familyname) " + 
            "ELSE concat(p.firstName, ' ',p.middlename, ' ', p.familyname) " + 
            "END 'Singer name' " + 
            "from musicsinger ms, musicNameDupNum d, peopleinvolved p " + 
            "where ms.musicname = d.musicname and ms.peopleinvolved_id = p.id " + 
            "order by ms.musicname, ms.year;";
        Statement statement;
        try {
          statement = con.createStatement();
          rs = statement.executeQuery(sql);
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      return rs;
    }
	  
	  public static ResultSet createR9Report() {
      // create a view if not exist yet
      boolean exist = checkIfTableExist("peopleOnlyNotArrangerMusic");
      boolean success = true;
      ResultSet rs = null;
      if(!exist) {
        success = CreateViewHelper.createViewForR9();
      }
      // execute query if view exist
      if (success) {
        String sql = "select p.familyname, upper(SUBSTRING(p.firstname,1,1)) 'First_name_initials', pa.musicname, pa.albumname, pa.year " + 
            "from peopleinvolved p, peopleOnlyNotArrangerMusic pa " + 
            "where p.id = pa.peopleinvolved_id " + 
            "order by pa.year, pa.musicname desc;";
        Statement statement;
        try {
          statement = con.createStatement();
          rs = statement.executeQuery(sql);
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      return rs;
    }
	  
	  public static ResultSet createR10Report() {
      // create a view if not exist yet
      boolean exist = checkIfTableExist("lnameofbook");
      boolean success = true;
      Map<String, String> viewNames = new HashMap<String, String>();//{"lnameofbook","lnameofmusic","lnameofmovie","distinctFamilyname"};
      viewNames.put("lnameofbook", "b");
      viewNames.put("lnameofmusic", "mu");
      viewNames.put("lnameofmovie", "mv");
      viewNames.put("distinctFamilyname", "d");
      ResultSet rs = null;
      for (String viewname : viewNames.keySet()) {
        exist = checkIfTableExist(viewname);
        if (!exist) {
          switch (viewNames.get(viewname)) {
            case "b":
              success = CreateViewHelper.createViewForR10Book();
            case "mu":
              success = CreateViewHelper.createViewForR10Music();
            case "mv":
              success = CreateViewHelper.createViewForR10Movie();
            case "d":
              success = CreateViewHelper.createViewForR10DistinctLname();
          }
          if (!success) {
            break;
          }
        }
      }
      // execute query if view exist
      if (success) {
        String sql = "select familyname, role " + 
            "from " + 
            "(select d.familyname, 'author' role " + 
            "from distinctFamilyname d, bookauthor b, peopleinvolved p " + 
            "where b.author_id = p.id and d.familyname = p.familyname " + 
            "group by d.familyname " + 
            "union " + 
            "select d.familyname, 'singer' role " + 
            "from distinctFamilyname d, musicsinger s, peopleinvolved p " + 
            "where s.peopleinvolved_id = p.id and d.familyname = p.familyname " + 
            "group by d.familyname " + 
            "union " + 
            "select d.familyname, r.description role " + 
            "from distinctFamilyname d, crewmember c, peopleinvolved p, role r " + 
            "where c.peopleinvolved_id = p.id and d.familyname = p.familyname and r.id = c.role_id " + 
            "group by d.familyname) result " + 
            "order by familyname;";
        Statement statement;
        try {
          statement = con.createStatement();
          rs = statement.executeQuery(sql);
        } catch (SQLException e) {
          e.printStackTrace();
        }
      } else {
        JOptionPane.showMessageDialog(null, "Something wrong when creating views", "create view - unexpected error", JOptionPane.ERROR_MESSAGE);
      }
      return rs;
    }
	}
	
	public static class CreateViewHelper {
	  
	  public static boolean createViewForViewPartAuthor() {
	    String sql = "create view authorView as " + 
	        "select b.title ProductName, b.YearOfPublication Year, 'B' Type, min(CASE WHEN ISNULL(p.MiddleName) " + 
	        "THEN concat(p.firstName, ' ', p.familyname) " + 
	        "ELSE concat(p.firstName, ' ',p.middlename, ' ', p.familyname) " + 
	        "END) 'Author_singer_director', b.title " + 
	        "from book b, bookauthor ba, peopleInvolved p " + 
	        "where b.isbn = ba.isbn and ba.author_id = p.id " + 
	        "group by ProductName;";
      Statement statement;
      try {
        statement = con.createStatement();
        statement.executeUpdate(sql);
        return true;
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return false;
	  }
	  
	  public static boolean createViewForViewPartSinger() {
      String sql = "create view SingerView as " + 
          "select mu.albumName ProductName, mu.Year Year, 'M' Type, min(CASE WHEN ISNULL(p.MiddleName) " + 
          "THEN concat(p.firstName, ' ', p.familyname) " + 
          "ELSE concat(p.firstName, ' ',p.middlename, ' ', p.familyname) " + 
          "END) 'Author_singer_director', mu.albumName " + 
          "from music mu, musicsinger mus, peopleinvolved p " + 
          "where (mu.albumName,mu.year,mu.musicName) = (mus.albumName,mus.year,mus.musicName) and mus.peopleInvolved_id = p.id " + 
          "group by ProductName;";
      Statement statement;
      try {
        statement = con.createStatement();
        statement.executeUpdate(sql);
        return true;
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return false;
    }
	  
	  public static boolean createViewForViewPartCrew() {
      String sql = "create view crewView as " + 
          "select mv.MovieName ProductName, mv.year Year, 'F' Type, min(CASE WHEN ISNULL(p.MiddleName) " + 
          "THEN concat(p.firstName, ' ', p.familyname) " + 
          "ELSE concat(p.firstName, ' ',p.middlename, ' ', p.familyname) " + 
          "END) 'Author_singer_director', mv.MovieName " + 
          "from movie mv, crewmember cm, peopleinvolved p, role r " + 
          "where (mv.MovieName, mv.year) = (cm.MovieName, cm.ReleaseYear) and cm.PeopleInvolved_id = p.id and cm.role_id = r.id " + 
          "group by ProductName;";
      Statement statement;
      try {
        statement = con.createStatement();
        statement.executeUpdate(sql);
        return true;
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return false;
    }
	  
	  public static boolean createViewForR5() {
	    String sql = "create view keywordFrequency as " + 
	        "select k.tag, count(*) frequency from bookkeyword bk, keyword k " + 
	        "where bk.keyword_id = k.id " + 
	        "group by k.tag;";
	    Statement statement;
      try {
        statement = con.createStatement();
        statement.executeUpdate(sql);
        return true;
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return false;
	  }
	  
	  public static boolean createViewForR6() {
      String sql = "create view multiSkillsMovieCrew as " + 
          "select cm.peopleinvolved_id, cm.moviename, count(*) numroles " + 
          "from crewmember cm " + 
          "group by peopleinvolved_id, moviename;";
      Statement statement;
      try {
        statement = con.createStatement();
        statement.executeUpdate(sql);
        return true;
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return false;
    }
	  
	  public static boolean createViewForR8() {
      String sql = "create view musicNameDupNum as " + 
          "select musicname, count(*) numberDup " + 
          "from music " + 
          "group by musicname " + 
          "having numberDup > 1;";
      Statement statement;
      try {
        statement = con.createStatement();
        statement.executeUpdate(sql);
        return true;
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return false;
    }
	  
	  public static boolean createViewForR9() {
      String sql = "create view peopleOnlyNotArrangerMusic as " + 
          "select albumname, year, musicname, peopleinvolved_id " + 
          "from peopleinvolvedmusic " + 
          "where isSongwriter = 1 and iscomposer = 1 and isarranger = 0;";
      Statement statement;
      try {
        statement = con.createStatement();
        statement.executeUpdate(sql);
        return true;
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return false;
    }
	  
	  public static boolean createViewForR10Book() {
	    String sql = "create view lnameofbook as " + 
	        "select p.familyname, count(*) " + 
	        "from peopleinvolved p, bookauthor b " + 
	        "where p.id = b.author_id " + 
	        "group by p.familyname;";
      Statement statement;
      try {
        statement = con.createStatement();
        statement.executeUpdate(sql);
        return true;
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return false;
	  }
	  
	  public static boolean createViewForR10Music() {
      String sql = "create view lnameofmusic as " + 
          "select p.familyname, count(*) " + 
          "from peopleinvolved p, musicsinger m " + 
          "where p.id = m.peopleinvolved_id " + 
          "group by p.familyname;";
      Statement statement;
      try {
        statement = con.createStatement();
        statement.executeUpdate(sql);
        return true;
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return false;
    }
	  
	  public static boolean createViewForR10Movie() {
      String sql = "create view lnameofmovie as " + 
          "select p.familyname, count(*) " + 
          "from peopleinvolved p, crewmember c " + 
          "where p.id = c.peopleinvolved_id " + 
          "group by p.familyname;";
      Statement statement;
      try {
        statement = con.createStatement();
        statement.executeUpdate(sql);
        return true;
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return false;
    }
	  
	  public static boolean createViewForR10DistinctLname() {
      String sql = "create view distinctFamilyname as " + 
          "select distinct p.familyname " + 
          "from peopleinvolved p " + 
          "where (p.familyname in (select familyname from lnameofbook) and p.familyname in (select familyname from lnameofmusic)) " + 
          "or (p.familyname in (select familyname from lnameofbook) and p.familyname in (select familyname from lnameofmovie)) " + 
          "or (p.familyname in (select familyname from lnameofmusic) and p.familyname in (select familyname from lnameofmovie));";
      Statement statement;
      try {
        statement = con.createStatement();
        statement.executeUpdate(sql);
        return true;
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return false;
    }
	}
	
	public static boolean checkIfTableExist(String tableName) {
	  DatabaseMetaData meta;
    try {
      meta = con.getMetaData();
      ResultSet res = meta.getTables(null, null, null, 
          new String[] {"TABLE","VIEW"});
       while (res.next()) {
          if (res.getString("TABLE_NAME").equalsIgnoreCase(tableName)) {
            return true;
          }
       }
       res.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
	}
	
	public static DefaultTableModel buildTableModel(ResultSet rs)
      throws SQLException {

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
	
	public static class MusicTrack {
	  private int year;
	  private String musicName, language, singer1, singer2, songWriter, composer, arranger;
	  private diskType type;
	  public MusicTrack(String musicName, String language, diskType type, String singer1, String singer2,
	      String songWriter, String composer, String arranger) {
	    this.musicName = musicName;
	    this.language = language;
	    this.type = type;
	    this.singer1 = singer1;
	    this.singer2 = singer2;
	    this.songWriter = songWriter;
	    this.composer = composer;
	    this.arranger = arranger;
	  }
	  
	  public MusicTrack get() {
	    return this;
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
	  
	  public List<String> getSingers() {
	    List<String> singers = new ArrayList<String>();
	    singers.add(this.singer1);
	    if (singer2 != null) {
	      singers.add(this.singer2);
	    }
	    return singers;
	  }
	  
	  public List<String> getCasts() {
	    List<String> casts = new ArrayList<String>();
      casts.add(this.songWriter);
      casts.add(this.composer);
      casts.add(this.arranger);
      return casts;
	  }
	  
	  public Map<String,Integer> getSingerIDHashMap() {
	    Map<String,Integer> singerids = new HashMap<String,Integer>();
	    singerids.put("singer1", SelectHelper.getPeopleID(this.singer1));
	    if (singer2 != null) {
	      singerids.put("singer2", SelectHelper.getPeopleID(this.singer2));
	    }
	    return singerids;
	  }
	  
	  public Map<String,Integer> getCastIDHashMap() {
	    Map<String,Integer> musicpeopleid = new HashMap<String,Integer>();
	    musicpeopleid.put("songWriter", SelectHelper.getPeopleID(this.songWriter));
      musicpeopleid.put("composer", SelectHelper.getPeopleID(this.composer));
      musicpeopleid.put("arranger", SelectHelper.getPeopleID(this.arranger));
      return musicpeopleid;
	  }
	}

  public static class MovieCrew {
    private String name;
    private boolean gender, award;
    int roleid;
    public MovieCrew(String name, boolean gender, boolean award, int roleid, int year) {
      this.name = name;
      this.gender = gender;
      this.award = award;
      this.roleid = roleid;
    }
    
    public MovieCrew get() {
      return this;
    }
  }
	
	
	 public class CreateFrameMovieCrew {
	   public CreateFrameMovieCrew(HashMap<String, List<MovieCrew>> crews)
     {
	     JFrame frame = new JFrame("Test");
	     frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       try 
       {
          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
       } catch (Exception e) {
          e.printStackTrace();
       }
       JPanel AddMovieCrewPanel = new JPanel();
       AddMovieCrewPanel.setOpaque(true);
//	     frame.getContentPane().add(AddMovieCrewPanel, "AddMovieCrewPanel");
	     
	     JButton button = new JButton("Submit");
	     
	     JLabel label_3 = new JLabel("Crews and casts");
	     
	     textField_1 = new JTextField();
	     textField_1.setColumns(10);
	     
	     JButton button_4 = new JButton("Cancel");
	     button_4.addActionListener(new ActionListener() {
	       public void actionPerformed(ActionEvent arg0) {
	       }
	     });
	     
	     String[] movieCastRoles = {"director", "script writer", "cast", "producer",
	         "composer", "editor", "costume designer"};
	     
	     
	     ButtonGroup castRewardGroup = new ButtonGroup();
	     
	     JLabel lblName = new JLabel("Name:");
	     
	     JLabel lblRole = new JLabel("Role:");
	     
	     JLabel lblGender = new JLabel("Gender:");
	     
	     JRadioButton rdbtnMale = new JRadioButton("male");
	     JRadioButton rdbtnFemale = new JRadioButton("female");
	     
       ButtonGroup castGenderGroup = new ButtonGroup();
       castGenderGroup.add(rdbtnMale);
       castGenderGroup.add(rdbtnFemale);
	     
	     JLabel lblGotAward = new JLabel("got award:");
	     JCheckBox chckbxTickIfYes = new JCheckBox("Tick if yes");
	     
	     GroupLayout gl_AddMovieCrewPanel = new GroupLayout(AddMovieCrewPanel);
	     Component comboBox = null;
      gl_AddMovieCrewPanel.setHorizontalGroup(
	       gl_AddMovieCrewPanel.createParallelGroup(Alignment.LEADING)
	         .addGroup(gl_AddMovieCrewPanel.createSequentialGroup()
	           .addGap(54)
	           .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.LEADING)
	             .addComponent(lblRole)
	             .addComponent(lblName)
	             .addComponent(lblGender)
	             .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.TRAILING, false)
	               .addComponent(lblGotAward, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	               .addComponent(label_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)))
	           .addGap(36)
	           .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.LEADING)
	             .addComponent(chckbxTickIfYes)
	             .addGroup(gl_AddMovieCrewPanel.createSequentialGroup()
	               .addComponent(rdbtnMale)
	               .addGap(18)
	               .addComponent(rdbtnFemale))
	             .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.TRAILING)
	               .addGroup(gl_AddMovieCrewPanel.createSequentialGroup()
	                 .addComponent(button, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
	                 .addGap(48)
	                 .addComponent(button_4, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
	               .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)))
	           .addContainerGap(700, Short.MAX_VALUE))
	     );
	     gl_AddMovieCrewPanel.setVerticalGroup(
	       gl_AddMovieCrewPanel.createParallelGroup(Alignment.LEADING)
	         .addGroup(gl_AddMovieCrewPanel.createSequentialGroup()
	           .addGap(64)
	           .addComponent(label_3)
	           .addGap(16)
	           .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.BASELINE)
	             .addComponent(lblName)
	             .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	           .addGap(18)
	           .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.BASELINE)
	             .addComponent(lblRole))
	           .addGap(18)
	           .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.BASELINE)
	             .addComponent(lblGender)
	             .addComponent(rdbtnMale)
	             .addComponent(rdbtnFemale))
	           .addGap(18)
	           .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.BASELINE)
	             .addComponent(lblGotAward)
	             .addComponent(chckbxTickIfYes))
	           .addGap(33)
	           .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.LEADING)
	             .addComponent(button)
	             .addComponent(button_4))
	           .addContainerGap(469, Short.MAX_VALUE)
	           )
	     );
	     AddMovieCrewPanel.setLayout(gl_AddMovieCrewPanel);
	     
	     frame.getContentPane().add(BorderLayout.CENTER, AddMovieCrewPanel);
       frame.pack();
       frame.setLocationByPlatform(true);
       frame.setVisible(true);
       frame.setResizable(false);
     }
	 }
	
	public class CreateFrame {

        private JTextField insSingerTx2;
        private JTextField insMusicTx;
        private JTextField insLangTx;
        private JTextField insProducerTx;
        private JTextField insSongWriterTx;
        private JTextField insComposerTx;
        private JTextField insArrangerTx;
        private JTextField insSingerTx1;
        private ButtonGroup diskTypeTx;
        
          public CreateFrame(List<MusicTrack> musicTracks)
          {
              JFrame frame = new JFrame("Test");
              frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
              try 
              {
                 UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
              } catch (Exception e) {
                 e.printStackTrace();
              }
              JPanel AddMusicTrackPanel = new JPanel();
              AddMusicTrackPanel.setOpaque(true);
              
              JButton button_3 = new JButton("Submit");
              button_3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                  String musicName = null, lang = null, arranger = null, composer = null, songWriter = null, singer1 = null, singer2 = null;
                  diskType type = diskType.AUDIOCD;
                  boolean valid = true;
                  
                  // check all fields are filled in or not
                  if (insMusicTx.getText().equals("")|| insLangTx.getText().equals("") ||
                      insArrangerTx.getText().equals("") || insComposerTx.getText().equals("") || insSongWriterTx.getText().equals("") ||
                      insSingerTx1.getText().equals("")) {
                    // show error - mandatory fields
                    System.out.println("fill in all mandatory fields and in correct format");
                    JOptionPane.showMessageDialog(null, "fill in all mandatory fields and in correct format", "Insert music - wrong format", JOptionPane.ERROR_MESSAGE);
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
                    Map<String, String> musicpeoples = new HashMap<String,String>();
                    musicpeoples.put("songWriter", songWriter);
                    musicpeoples.put("composer", composer);
                    musicpeoples.put("arranger", arranger);
                    
                    // check if the names are valid name
                    for (String name:musicpeoples.values()) {
                      if (!checkHelper.checkNameFormat(name)) {
                        valid = false;
                        break;
                      }
                    }
                    
                    // get diskType
                    String typeString = null;
                    for (Enumeration<AbstractButton> buttons = diskTypeTx.getElements(); buttons.hasMoreElements();) {
                      AbstractButton button = buttons.nextElement();
                      if (button.isSelected()) {
                        typeString = button.getText();
                      }
                    }
                    for (diskType d : type.getIteration()) {
                      if (d.getString().equalsIgnoreCase(typeString)) {
                        type = d.getEnum();
                      }
                    }
                    
                 // check if the music track name already exist in the list
                    for (MusicTrack mutrack: musicTracks) {
                      String mName = mutrack.getMusicName();
                      if (mName.equalsIgnoreCase(musicName)) {
                        JOptionPane.showMessageDialog(null, "Music track name already entered", "Insert music - duplicated music name", JOptionPane.ERROR_MESSAGE);
                        valid = false;
                        break;
                      }
                    }
                    
                    if (valid) {
                      // store as music track
                      MusicTrack mt = new MusicTrack(musicName, lang, type, singer1, singer2, songWriter, composer, arranger);
                      musicTracks.add(mt);
                      JOptionPane.showMessageDialog(null, "submitted", "Insert music - submitted", JOptionPane.ERROR_MESSAGE);
                      
                      // TODO: clear fields
                    } else {
                      JOptionPane.showMessageDialog(null, "Some input are invalid", "Insert music - invalid name input", JOptionPane.ERROR_MESSAGE);
                    }
                  }
                }
              });
              
              JButton button_9 = new JButton("Cancel");
              // TODO: clear fields
              
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

              diskTypeTx = new ButtonGroup();
              diskTypeTx.add(radioButton_cd);
              diskTypeTx.add(radioButton_vinyl);
              
              JLabel label_40 = new JLabel("Producer:");
              
              insProducerTx = new JTextField();
              insProducerTx.setColumns(10);
              
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
              gl_AddMusicTrackPanel.setHorizontalGroup(
                gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING)
                  .addGap(0, 1098, Short.MAX_VALUE)
                  .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
                    .addGap(149)
                    .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.TRAILING)
                      .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
                        .addComponent(button_3, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
                        .addGap(18)
                        .addComponent(button_9, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
                      .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING, false)
                        .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
                          .addComponent(label_2)
                          .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                          .addComponent(insSingerTx2, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
                          .addComponent(label_4, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                          .addGap(22)
                          .addComponent(insMusicTx, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
                          .addComponent(label_5, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                          .addGap(38)
                          .addComponent(insLangTx, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
                          .addComponent(label_39)
                          .addGap(39)
                          .addComponent(radioButton_cd, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                          .addGap(64)
                          .addComponent(radioButton_vinyl, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
                          .addComponent(label_40)
                          .addGap(39)
                          .addComponent(insProducerTx, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
                          .addComponent(label_41, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                          .addGap(23)
                          .addComponent(insSongWriterTx, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
                          .addComponent(label_42, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                          .addGap(32)
                          .addComponent(insComposerTx, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
                          .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.TRAILING, false)
                            .addComponent(label_47, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label_48, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                          .addGap(39)
                          .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.TRAILING)
                            .addComponent(insArrangerTx, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)
                            .addComponent(insSingerTx1, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)))))
                    .addContainerGap(556, Short.MAX_VALUE))
              );
              gl_AddMusicTrackPanel.setVerticalGroup(
                gl_AddMusicTrackPanel.createParallelGroup(Alignment.TRAILING)
                  .addGap(0, 519, Short.MAX_VALUE)
                  .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
                    .addGap(57)
                    .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING)
                      .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
                        .addGap(3)
                        .addComponent(label_4))
                      .addComponent(insMusicTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING)
                      .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
                        .addGap(6)
                        .addComponent(label_5))
                      .addComponent(insLangTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING)
                      .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
                        .addGap(4)
                        .addComponent(label_39))
                      .addComponent(radioButton_cd)
                      .addComponent(radioButton_vinyl))
                    .addGap(18)
                    .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING)
                      .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
                        .addGap(3)
                        .addComponent(label_40))
                      .addComponent(insProducerTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING)
                      .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
                        .addGap(3)
                        .addComponent(label_41))
                      .addComponent(insSongWriterTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING)
                      .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
                        .addGap(3)
                        .addComponent(label_42))
                      .addComponent(insComposerTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING)
                      .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
                        .addGap(3)
                        .addComponent(label_48))
                      .addComponent(insArrangerTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING)
                      .addComponent(insSingerTx1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                      .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
                        .addGap(3)
                        .addComponent(label_47)))
                    .addGap(18)
                    .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.BASELINE)
                      .addComponent(label_2)
                      .addComponent(insSingerTx2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.BASELINE)
                      .addComponent(button_3)
                      .addComponent(button_9))
                    .addContainerGap(74, Short.MAX_VALUE))
              );
              AddMusicTrackPanel.setLayout(gl_AddMusicTrackPanel);
              
            frame.getContentPane().add(BorderLayout.CENTER, AddMusicTrackPanel);
            frame.pack();
            frame.setLocationByPlatform(true);
            frame.setVisible(true);
            frame.setResizable(false);
            
          }
      
  }
}
