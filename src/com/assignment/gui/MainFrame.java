package com.assignment.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
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
import javax.swing.table.DefaultTableModel;
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
import java.awt.GridBagConstraints;
import java.awt.Insets;

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
	private JTextField producersTx;
	private JTextField scriptWritersTx;
	private JTextField directorsTx;
	private JTextField movieYearTx;
	private JTextField movieNameTx;
	private JTextField upAlbumSearch;
	private JTextField upMusicYearSearch;
	private JTextField upMusicNameSearch;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField singersTx;
	private JTextField composersTx;
	private JTextField editorsTx;
	private JTextField costumeDesignersTx;
	private JTextField castsTx;
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
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;

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
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hl", "root", "");
		initialize(con);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Connection con) {
		frame = new JFrame();
		frame.setBounds(100, 100, 1150, 1039);
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
            boolean success = TransactionHelper.insertMusicTransaction(albumName, musicName, lang, producer, musicpeoples, year, singers, type);
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
              .addGroup(gl_insertAlbum.createParallelGroup(Alignment.TRAILING)
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
                  .addPreferredGap(ComponentPlacement.RELATED, 555, GroupLayout.PREFERRED_SIZE)
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
            .addComponent(button_1))
          .addContainerGap(348, Short.MAX_VALUE))
    );
    
		diskTypeTx = new ButtonGroup();
		diskTypeTx.add(audioCDtype);
		diskTypeTx.add(vinylType);
		insertAlbum.setLayout(gl_insertAlbum);
		
		JPanel insertMovie = new JPanel();
		frame.getContentPane().add(insertMovie, "insertMovie");
		
		JLabel lblReleaseYear = new JLabel("Release year:");
		
		JLabel lblMovieName_1 = new JLabel("Director (1 to 3):");
		
		JLabel lblReleaseYear_1 = new JLabel("Script Writer (1 to 3):");
		
		JLabel lblCrewName = new JLabel("Producer (1 to 3):");
		
		JLabel lblRole = new JLabel("Composer (1 to 3):");
		
		JLabel lblMovieName = new JLabel("Movie name:");
		
		producersTx = new JTextField();
		producersTx.setColumns(10);
		
		scriptWritersTx = new JTextField();
		scriptWritersTx.setColumns(10);
		
		directorsTx = new JTextField();
		directorsTx.setColumns(10);
		
		movieYearTx = new JTextField();
		movieYearTx.setColumns(10);
		
		movieNameTx = new JTextField();
		movieNameTx.setColumns(10);
		
		JButton button_4 = new JButton("Submit");
		button_4.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
        int movieYear = checkHelper.checkIfNumerical(movieYearTx);
		    // validate input field
		    if (movieNameTx.getText().equals("") || movieYearTx.getText().equals("") || directorsTx.getText().equals("") || scriptWritersTx.getText().equals("") ||
		        producersTx.getText().equals("") || composersTx.getText().equals("") || editorsTx.getText().equals("") || costumeDesignersTx.getText().equals("") ||
		        castsTx.getText().equals("")) {
		      System.out.println("Please enter all fields");
		    } else if (movieYear < 0) {
		      System.out.println("Please enter a valid year");
		    } else {
		      // get inputs
		      // get crews name and roles
//		      JTextField[] insertMovieCrewFields = {directorsTx, scriptWritersTx, producersTx, composersTx, editorsTx, costumeDesignersTx};
		      Map<JTextField, String> MovieCrewJFields = new HashMap<JTextField, String>();
		      MovieCrewJFields.put(directorsTx, "director");
		      MovieCrewJFields.put(scriptWritersTx, "script writer");
		      MovieCrewJFields.put(producersTx, "producer");
		      MovieCrewJFields.put(composersTx, "composer");
		      MovieCrewJFields.put(editorsTx, "editor");
		      MovieCrewJFields.put(costumeDesignersTx, "costume designer");
		      MovieCrewJFields.put(castsTx, "cast");
		      
		      int counter = 0;
		      String[] tempCrewName = null;
		      List<String> theirRoles = new ArrayList<String>();
		      Map<String, List<String>> allCrewNameRole = new HashMap<String, List<String>>();  // key: crewname, value:array of roleName
		      // --- for each role
		      for (JTextField crewTx: MovieCrewJFields.keySet()) {		        
		        // split by ','
		        tempCrewName = crewTx.getText().toLowerCase().split("\\s*,\\s*");
		        
		        // try to put in a hashmap with name as key and role[] as value
		        // the pair with the same key will replace the previous value ... wrong... fixing now
		        // create a hash map for each person with an empty list
		        for (String name : tempCrewName) {
		          // if the name not exist in the hash map, insert it into the hashmap
		          if (allCrewNameRole.get(name) == null) {
		            allCrewNameRole.put(name, new ArrayList<String>());
		          }
		          // add their corresponding roles for each person
		          if (MovieCrewJFields.get(crewTx).equals("cast")) {
                if (counter < 10) {
//                  allCrewNameRole.put(name, MovieCrewJFields.get(crewTx));
                  allCrewNameRole.get(name).add(MovieCrewJFields.get(crewTx));
                  counter++;
                }
              } else {
                if (counter < 3) {
                  allCrewNameRole.get(name).add(MovieCrewJFields.get(crewTx));
                  counter++;
                }
              }
		        }
            counter = 0;
          }
		      
		      // get casts name
//		      tempCrewName = castsTx.getText().split("\\s*,\\s*");
//		      List<String> castNameList = new LinkedList<String>(Arrays.asList(tempCrewName));
		      
		      
		      // check if the crews and cast exist in peopleInvolved table
		      // crew
		      int pplID;
		      List<String> removalKey = new ArrayList<String>();
		      for (String crewName : allCrewNameRole.keySet()) {
            pplID = SelectHelper.getPeopleID(crewName);
            if (pplID == -1) {
              // author not exist
              System.out.println("movie crew not exist " + crewName);
              // add new crew
              try {
                pplID = InserterHelper.insertNewPeople(crewName);
              } catch (SQLException ex) {
                ex.printStackTrace();
              }
              if (pplID == -1) {
                System.out.println("The movie crew name "+ crewName +" is not in a correct format. did not add to database.");
                // remove from hashmap - prevent from inserting into other tables
                removalKey.add(crewName);
              }
            }
          }
//		      List<Integer> removalCast = new ArrayList<Integer>();
//		      // cast
//		      for (int i = 0 ; i < castNameList.size() && i < 10; i ++) {
//            pplID = SelectHelper.getPeopleID(castNameList.get(i));
//            if (pplID == -1) {
//              // author not exist
//              System.out.println("movie crew not exist " + tempCrewName[i]);
//              // add new crew
//              try {
//                pplID = InserterHelper.insertNewPeople(castNameList.get(i));
//              } catch (SQLException ex) {
//                ex.printStackTrace();
//              }
//              if (pplID == -1) {
//                System.out.println("The movie cast name "+ castNameList.get(i) +" is not in a correct format. did not add to database.");
//                // add index to array for removal later - prevent from inserting into other tables
//                removalCast.add(i);
//              }
//            }
//          }
		      if (removalKey.size() > 0) {
		        for (String k : removalKey) {
		          allCrewNameRole.remove(k);
		        }
		      }
//		      // remove cast that name format is wrong
//		      if (castNameList.size() > 10) {
//		        for (int i = castNameList.size(); i>10; i--) {
//		          castNameList.remove(i);
//		        }
//		      }
//		      if (removalCast.size() > 0) {
//		        System.out.println(removalCast.get(0));
//  		      for (int i=removalCast.size()-1 ; i>=0 ;i--) {
//  		        castNameList.remove(i);
//  		      }
//		      }
		      
		      // get movie name
		      String movieName = movieNameTx.getText();
		      
//		      for (String name: allCrewNameRole.keySet()) {
//		        System.out.println(name + " " + allCrewNameRole.get(name) + " " + SelectHelper.getRoleID(allCrewNameRole.get(name)));
//		      }
		      
		      
		      // check if it's a number
		      if (movieYear >= 0) {
  		      // check if movie exist
  		      if (!SelectHelper.checkMovieExist(movieName, movieYear)) {
  		          boolean success = TransactionHelper.insertMovieTransaction(movieName, movieYear, allCrewNameRole);
  		          if (success) {
  		            JOptionPane.showMessageDialog(null, "Movie inserted.", "Insert movie - success", JOptionPane.INFORMATION_MESSAGE);
  		          } else {
  		            JOptionPane.showMessageDialog(null, "Movie insertion fail due to unexpected error", "Insert movie - error", JOptionPane.ERROR_MESSAGE);
  		          }
//  		        // insert movie if not exist
//  		        InserterHelper.insertMovie(movieName, movieYear);
//  		        System.out.println("movie inserted");
//  		        // insert award
////  		        InserterHelper.insertMovie(movieName, movieYear, allCrewNameRole, castNameList);
//  		        InserterHelper.insertAward(movieName, movieYear, allCrewNameRole);
//  		        System.out.println("award inserted - default all no award");
//  		        // insert crew into crewMember
//  		        InserterHelper.insertCrewMember(movieName, movieYear, allCrewNameRole);
//  		        System.out.println("crewMember inserted");
  		      } else {
  		        System.out.println("movie already exist");
  		        JOptionPane.showMessageDialog(null, "This music track of that album already existed", "Insert music - already existed", JOptionPane.ERROR_MESSAGE);
  		        // clear textfields
  		        clearInsertMovie();
  		      }
		      }
		    }
		  }
		});
		
		JButton button_5 = new JButton("Cancel");
		button_5.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        clearInsertMovie();
      }
    });
		
		String[] movieCastRoles = {"director", "script writer", "cast", "producer",
		    "composer", "editor", "costume designer"};
		
		JComboBox movieRolesTx = new JComboBox(movieCastRoles);
		
		JLabel lblGender = new JLabel("Editor (1 to 3):");
		
		JLabel lblGotAward = new JLabel("Costume designer (1 to 3):");
		
		ButtonGroup castGenderGroup = new ButtonGroup();
		
		ButtonGroup castRewardGroup = new ButtonGroup();
		
		JLabel lblCrewsAndCasts = new JLabel("Crews and casts");
		
		composersTx = new JTextField();
		composersTx.setColumns(10);
		
		editorsTx = new JTextField();
		editorsTx.setColumns(10);
		
		JLabel lblCast = new JLabel("Cast (1 to 10):");
		
		costumeDesignersTx = new JTextField();
		costumeDesignersTx.setColumns(10);
		
		castsTx = new JTextField();
		castsTx.setColumns(10);
		GroupLayout gl_insertMovie = new GroupLayout(insertMovie);
		gl_insertMovie.setHorizontalGroup(
		  gl_insertMovie.createParallelGroup(Alignment.LEADING)
		    .addGroup(gl_insertMovie.createSequentialGroup()
		      .addGap(44)
		      .addGroup(gl_insertMovie.createParallelGroup(Alignment.TRAILING)
		        .addGroup(gl_insertMovie.createSequentialGroup()
		          .addComponent(button_4, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
		          .addContainerGap(1006, Short.MAX_VALUE))
		        .addGroup(gl_insertMovie.createSequentialGroup()
		          .addGroup(gl_insertMovie.createParallelGroup(Alignment.LEADING)
		            .addGroup(gl_insertMovie.createSequentialGroup()
		              .addGroup(gl_insertMovie.createParallelGroup(Alignment.LEADING)
		                .addComponent(lblCrewsAndCasts)
		                .addGroup(gl_insertMovie.createSequentialGroup()
		                  .addGroup(gl_insertMovie.createParallelGroup(Alignment.LEADING)
		                    .addComponent(lblMovieName)
		                    .addComponent(lblMovieName_1)
		                    .addComponent(lblReleaseYear_1)
		                    .addComponent(lblCrewName)
		                    .addComponent(lblRole)
		                    .addComponent(lblGender))
		                  .addPreferredGap(ComponentPlacement.RELATED, 199, Short.MAX_VALUE)
		                  .addGroup(gl_insertMovie.createParallelGroup(Alignment.LEADING, false)
		                    .addComponent(scriptWritersTx, Alignment.TRAILING)
		                    .addComponent(directorsTx, Alignment.TRAILING)
		                    .addComponent(composersTx, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
		                    .addComponent(producersTx, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
		                    .addComponent(editorsTx, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
		                    .addComponent(movieNameTx))
		                  .addPreferredGap(ComponentPlacement.UNRELATED)
		                  .addComponent(lblReleaseYear)
		                  .addGap(18)
		                  .addComponent(movieYearTx, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)))
		              .addPreferredGap(ComponentPlacement.RELATED))
		            .addGroup(gl_insertMovie.createSequentialGroup()
		              .addGroup(gl_insertMovie.createParallelGroup(Alignment.LEADING)
		                .addGroup(gl_insertMovie.createSequentialGroup()
		                  .addComponent(lblGotAward)
		                  .addGap(37)
		                  .addComponent(costumeDesignersTx, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE))
		                .addGroup(gl_insertMovie.createSequentialGroup()
		                  .addComponent(lblCast)
		                  .addGap(46)
		                  .addGroup(gl_insertMovie.createParallelGroup(Alignment.LEADING)
		                    .addComponent(button_5, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
		                    .addComponent(castsTx, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))))
		              .addPreferredGap(ComponentPlacement.RELATED)))
		          .addPreferredGap(ComponentPlacement.RELATED)
		          .addComponent(movieRolesTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		          .addGap(127))))
		);
		gl_insertMovie.setVerticalGroup(
		  gl_insertMovie.createParallelGroup(Alignment.LEADING)
		    .addGroup(gl_insertMovie.createSequentialGroup()
		      .addGap(22)
		      .addGroup(gl_insertMovie.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_insertMovie.createSequentialGroup()
		          .addGap(72)
		          .addComponent(directorsTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		          .addGap(18)
		          .addGroup(gl_insertMovie.createParallelGroup(Alignment.BASELINE)
		            .addComponent(scriptWritersTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		            .addComponent(lblReleaseYear_1))
		          .addGap(18)
		          .addGroup(gl_insertMovie.createParallelGroup(Alignment.BASELINE)
		            .addComponent(producersTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		            .addComponent(lblCrewName))
		          .addGap(18)
		          .addGroup(gl_insertMovie.createParallelGroup(Alignment.BASELINE)
		            .addComponent(composersTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		            .addComponent(lblRole))
		          .addGap(18)
		          .addGroup(gl_insertMovie.createParallelGroup(Alignment.BASELINE)
		            .addComponent(editorsTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		            .addComponent(lblGender)))
		        .addGroup(gl_insertMovie.createSequentialGroup()
		          .addGroup(gl_insertMovie.createParallelGroup(Alignment.BASELINE)
		            .addComponent(lblMovieName)
		            .addComponent(lblReleaseYear)
		            .addComponent(movieYearTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		            .addComponent(movieNameTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		          .addGroup(gl_insertMovie.createParallelGroup(Alignment.LEADING, false)
		            .addGroup(gl_insertMovie.createSequentialGroup()
		              .addGap(18)
		              .addComponent(lblCrewsAndCasts)
		              .addGap(21)
		              .addComponent(lblMovieName_1)
		              .addGap(179)
		              .addGroup(gl_insertMovie.createParallelGroup(Alignment.BASELINE)
		                .addComponent(lblGotAward)
		                .addComponent(costumeDesignersTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		              .addGap(18)
		              .addGroup(gl_insertMovie.createParallelGroup(Alignment.BASELINE)
		                .addComponent(lblCast)
		                .addComponent(castsTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		              .addGap(60)
		              .addGroup(gl_insertMovie.createParallelGroup(Alignment.BASELINE)
		                .addComponent(button_4)
		                .addComponent(button_5)))
		            .addGroup(gl_insertMovie.createSequentialGroup()
		              .addPreferredGap(ComponentPlacement.UNRELATED, 263, Short.MAX_VALUE)
		              .addComponent(movieRolesTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		              .addGap(240)))))
		      .addGap(32))
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
		
		JPanel updateAlbum2 = new JPanel();
		frame.getContentPane().add(updateAlbum2, "updateAlbum2");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label_28 = new JLabel("Album name:");
		
		JLabel label_29 = new JLabel("Producer:");
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		
		JLabel label_30 = new JLabel("Year:");
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		GroupLayout gl_updateAlbum2 = new GroupLayout(updateAlbum2);
		gl_updateAlbum2.setHorizontalGroup(
		  gl_updateAlbum2.createParallelGroup(Alignment.TRAILING)
		    .addGroup(gl_updateAlbum2.createSequentialGroup()
		      .addGroup(gl_updateAlbum2.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_updateAlbum2.createSequentialGroup()
		          .addGap(79)
		          .addGroup(gl_updateAlbum2.createParallelGroup(Alignment.LEADING)
		            .addGroup(gl_updateAlbum2.createSequentialGroup()
		              .addComponent(label_28)
		              .addGap(18)
		              .addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)
		              .addGap(135)
		              .addComponent(label_30)
		              .addGap(12)
		              .addComponent(textField_8, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE))
		            .addGroup(gl_updateAlbum2.createSequentialGroup()
		              .addComponent(label_29)
		              .addGap(39)
		              .addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE))))
		        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 1087, GroupLayout.PREFERRED_SIZE))
		      .addContainerGap(45, Short.MAX_VALUE))
		);
		gl_updateAlbum2.setVerticalGroup(
		  gl_updateAlbum2.createParallelGroup(Alignment.LEADING)
		    .addGroup(gl_updateAlbum2.createSequentialGroup()
		      .addGap(60)
		      .addGroup(gl_updateAlbum2.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_updateAlbum2.createSequentialGroup()
		          .addGap(3)
		          .addComponent(label_28))
		        .addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		        .addGroup(gl_updateAlbum2.createSequentialGroup()
		          .addGap(6)
		          .addComponent(label_30))
		        .addGroup(gl_updateAlbum2.createSequentialGroup()
		          .addGap(3)
		          .addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		      .addGap(10)
		      .addGroup(gl_updateAlbum2.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_updateAlbum2.createSequentialGroup()
		          .addGap(6)
		          .addComponent(label_29))
		        .addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
		      .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 832, GroupLayout.PREFERRED_SIZE))
		);
		
		JPanel panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{72, 73, 75, 61, 73, 71, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{53, 22, 22, 25, 22, 22, 22, 22, 25, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel label_3 = new JLabel("Music name:");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.WEST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 1;
		gbc_label_3.gridy = 1;
		panel_1.add(label_3, gbc_label_3);
		
		textField = new JTextField();
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.anchor = GridBagConstraints.NORTH;
		gbc_textField.gridwidth = 4;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		panel_1.add(textField, gbc_textField);
		
		JLabel label_22 = new JLabel("Music name:");
		GridBagConstraints gbc_label_22 = new GridBagConstraints();
		gbc_label_22.anchor = GridBagConstraints.WEST;
		gbc_label_22.insets = new Insets(0, 0, 5, 5);
		gbc_label_22.gridx = 10;
		gbc_label_22.gridy = 1;
		panel_1.add(label_22, gbc_label_22);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridwidth = 5;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 11;
		gbc_textField_1.gridy = 1;
		panel_1.add(textField_1, gbc_textField_1);
		
		JLabel label_23 = new JLabel("language:");
		GridBagConstraints gbc_label_23 = new GridBagConstraints();
		gbc_label_23.anchor = GridBagConstraints.SOUTHWEST;
		gbc_label_23.insets = new Insets(0, 0, 5, 5);
		gbc_label_23.gridx = 1;
		gbc_label_23.gridy = 2;
		panel_1.add(label_23, gbc_label_23);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.anchor = GridBagConstraints.NORTH;
		gbc_textField_2.gridwidth = 4;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 2;
		panel_1.add(textField_2, gbc_textField_2);
		
		JLabel label_24 = new JLabel("language:");
		GridBagConstraints gbc_label_24 = new GridBagConstraints();
		gbc_label_24.anchor = GridBagConstraints.WEST;
		gbc_label_24.insets = new Insets(0, 0, 5, 5);
		gbc_label_24.gridx = 10;
		gbc_label_24.gridy = 2;
		panel_1.add(label_24, gbc_label_24);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridwidth = 5;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.gridx = 11;
		gbc_textField_3.gridy = 2;
		panel_1.add(textField_3, gbc_textField_3);
		
		JLabel label_25 = new JLabel("Disk type:");
		GridBagConstraints gbc_label_25 = new GridBagConstraints();
		gbc_label_25.anchor = GridBagConstraints.WEST;
		gbc_label_25.insets = new Insets(0, 0, 5, 5);
		gbc_label_25.gridx = 1;
		gbc_label_25.gridy = 3;
		panel_1.add(label_25, gbc_label_25);
		
		JRadioButton radioButton = new JRadioButton("audioCD");
		radioButton.setSelected(true);
		GridBagConstraints gbc_radioButton = new GridBagConstraints();
		gbc_radioButton.anchor = GridBagConstraints.NORTHWEST;
		gbc_radioButton.insets = new Insets(0, 0, 5, 5);
		gbc_radioButton.gridx = 2;
		gbc_radioButton.gridy = 3;
		panel_1.add(radioButton, gbc_radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("vinyl");
		GridBagConstraints gbc_radioButton_1 = new GridBagConstraints();
		gbc_radioButton_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_radioButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_radioButton_1.gridx = 4;
		gbc_radioButton_1.gridy = 3;
		panel_1.add(radioButton_1, gbc_radioButton_1);
		
		JLabel label_26 = new JLabel("Disk type:");
		GridBagConstraints gbc_label_26 = new GridBagConstraints();
		gbc_label_26.anchor = GridBagConstraints.WEST;
		gbc_label_26.insets = new Insets(0, 0, 5, 5);
		gbc_label_26.gridx = 10;
		gbc_label_26.gridy = 3;
		panel_1.add(label_26, gbc_label_26);
		
		JRadioButton radioButton_2 = new JRadioButton("audioCD");
		radioButton_2.setSelected(true);
		GridBagConstraints gbc_radioButton_2 = new GridBagConstraints();
		gbc_radioButton_2.anchor = GridBagConstraints.WEST;
		gbc_radioButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_radioButton_2.gridx = 11;
		gbc_radioButton_2.gridy = 3;
		panel_1.add(radioButton_2, gbc_radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("vinyl");
		GridBagConstraints gbc_radioButton_3 = new GridBagConstraints();
		gbc_radioButton_3.anchor = GridBagConstraints.WEST;
		gbc_radioButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_radioButton_3.gridx = 14;
		gbc_radioButton_3.gridy = 3;
		panel_1.add(radioButton_3, gbc_radioButton_3);
		
		JLabel label_27 = new JLabel("Song writer:");
		GridBagConstraints gbc_label_27 = new GridBagConstraints();
		gbc_label_27.anchor = GridBagConstraints.WEST;
		gbc_label_27.insets = new Insets(0, 0, 5, 5);
		gbc_label_27.gridx = 1;
		gbc_label_27.gridy = 4;
		panel_1.add(label_27, gbc_label_27);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.anchor = GridBagConstraints.NORTH;
		gbc_textField_4.gridwidth = 4;
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.gridx = 2;
		gbc_textField_4.gridy = 4;
		panel_1.add(textField_4, gbc_textField_4);
		
		JLabel label_31 = new JLabel("Song writer:");
		GridBagConstraints gbc_label_31 = new GridBagConstraints();
		gbc_label_31.anchor = GridBagConstraints.WEST;
		gbc_label_31.insets = new Insets(0, 0, 5, 5);
		gbc_label_31.gridx = 10;
		gbc_label_31.gridy = 4;
		panel_1.add(label_31, gbc_label_31);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridwidth = 5;
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.gridx = 11;
		gbc_textField_5.gridy = 4;
		panel_1.add(textField_5, gbc_textField_5);
		
		JLabel label_32 = new JLabel("Composer:");
		GridBagConstraints gbc_label_32 = new GridBagConstraints();
		gbc_label_32.anchor = GridBagConstraints.WEST;
		gbc_label_32.insets = new Insets(0, 0, 5, 5);
		gbc_label_32.gridx = 1;
		gbc_label_32.gridy = 5;
		panel_1.add(label_32, gbc_label_32);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		GridBagConstraints gbc_textField_9 = new GridBagConstraints();
		gbc_textField_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_9.anchor = GridBagConstraints.NORTH;
		gbc_textField_9.gridwidth = 4;
		gbc_textField_9.insets = new Insets(0, 0, 5, 5);
		gbc_textField_9.gridx = 2;
		gbc_textField_9.gridy = 5;
		panel_1.add(textField_9, gbc_textField_9);
		
		JLabel label_33 = new JLabel("Composer:");
		GridBagConstraints gbc_label_33 = new GridBagConstraints();
		gbc_label_33.anchor = GridBagConstraints.WEST;
		gbc_label_33.insets = new Insets(0, 0, 5, 5);
		gbc_label_33.gridx = 10;
		gbc_label_33.gridy = 5;
		panel_1.add(label_33, gbc_label_33);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		GridBagConstraints gbc_textField_10 = new GridBagConstraints();
		gbc_textField_10.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_10.gridwidth = 5;
		gbc_textField_10.insets = new Insets(0, 0, 5, 5);
		gbc_textField_10.gridx = 11;
		gbc_textField_10.gridy = 5;
		panel_1.add(textField_10, gbc_textField_10);
		
		JLabel label_34 = new JLabel("Arranger:");
		GridBagConstraints gbc_label_34 = new GridBagConstraints();
		gbc_label_34.anchor = GridBagConstraints.WEST;
		gbc_label_34.insets = new Insets(0, 0, 5, 5);
		gbc_label_34.gridx = 1;
		gbc_label_34.gridy = 6;
		panel_1.add(label_34, gbc_label_34);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		GridBagConstraints gbc_textField_11 = new GridBagConstraints();
		gbc_textField_11.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_11.anchor = GridBagConstraints.NORTH;
		gbc_textField_11.gridwidth = 4;
		gbc_textField_11.insets = new Insets(0, 0, 5, 5);
		gbc_textField_11.gridx = 2;
		gbc_textField_11.gridy = 6;
		panel_1.add(textField_11, gbc_textField_11);
		
		JLabel label_35 = new JLabel("Arranger:");
		GridBagConstraints gbc_label_35 = new GridBagConstraints();
		gbc_label_35.anchor = GridBagConstraints.WEST;
		gbc_label_35.insets = new Insets(0, 0, 5, 5);
		gbc_label_35.gridx = 10;
		gbc_label_35.gridy = 6;
		panel_1.add(label_35, gbc_label_35);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		GridBagConstraints gbc_textField_12 = new GridBagConstraints();
		gbc_textField_12.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_12.gridwidth = 5;
		gbc_textField_12.insets = new Insets(0, 0, 5, 5);
		gbc_textField_12.gridx = 11;
		gbc_textField_12.gridy = 6;
		panel_1.add(textField_12, gbc_textField_12);
		
		JLabel label_36 = new JLabel("Singers:");
		GridBagConstraints gbc_label_36 = new GridBagConstraints();
		gbc_label_36.anchor = GridBagConstraints.WEST;
		gbc_label_36.insets = new Insets(0, 0, 5, 5);
		gbc_label_36.gridx = 1;
		gbc_label_36.gridy = 7;
		panel_1.add(label_36, gbc_label_36);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		GridBagConstraints gbc_textField_13 = new GridBagConstraints();
		gbc_textField_13.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_13.anchor = GridBagConstraints.NORTH;
		gbc_textField_13.gridwidth = 4;
		gbc_textField_13.insets = new Insets(0, 0, 5, 5);
		gbc_textField_13.gridx = 2;
		gbc_textField_13.gridy = 7;
		panel_1.add(textField_13, gbc_textField_13);
		
		JLabel label_37 = new JLabel("Singers:");
		GridBagConstraints gbc_label_37 = new GridBagConstraints();
		gbc_label_37.anchor = GridBagConstraints.WEST;
		gbc_label_37.insets = new Insets(0, 0, 5, 5);
		gbc_label_37.gridx = 10;
		gbc_label_37.gridy = 7;
		panel_1.add(label_37, gbc_label_37);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		GridBagConstraints gbc_textField_14 = new GridBagConstraints();
		gbc_textField_14.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_14.gridwidth = 5;
		gbc_textField_14.insets = new Insets(0, 0, 5, 5);
		gbc_textField_14.gridx = 11;
		gbc_textField_14.gridy = 7;
		panel_1.add(textField_14, gbc_textField_14);
		
		JButton button = new JButton("Update");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.anchor = GridBagConstraints.NORTHWEST;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 4;
		gbc_button.gridy = 8;
		panel_1.add(button, gbc_button);
		
		JButton button_6 = new JButton("Cancel");
		GridBagConstraints gbc_button_6 = new GridBagConstraints();
		gbc_button_6.anchor = GridBagConstraints.NORTHWEST;
		gbc_button_6.insets = new Insets(0, 0, 5, 5);
		gbc_button_6.gridx = 5;
		gbc_button_6.gridy = 8;
		panel_1.add(button_6, gbc_button_6);
		
		JButton button_7 = new JButton("Update");
		GridBagConstraints gbc_button_7 = new GridBagConstraints();
		gbc_button_7.insets = new Insets(0, 0, 5, 5);
		gbc_button_7.gridx = 14;
		gbc_button_7.gridy = 8;
		panel_1.add(button_7, gbc_button_7);
		
		JButton button_8 = new JButton("Cancel");
		GridBagConstraints gbc_button_8 = new GridBagConstraints();
		gbc_button_8.anchor = GridBagConstraints.EAST;
		gbc_button_8.insets = new Insets(0, 0, 5, 5);
		gbc_button_8.gridx = 15;
		gbc_button_8.gridy = 8;
		panel_1.add(button_8, gbc_button_8);
		updateAlbum2.setLayout(gl_updateAlbum2);
		
		
		
		
		
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
        	  c.show(frame.getContentPane(), "insertAlbum");
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
	
	private void clearInsertMovie() {
	  movieNameTx.setText("");
	  movieYearTx.setText("");
	  directorsTx.setText("");
	  scriptWritersTx.setText("");
	  producersTx.setText("");
	  composersTx.setText("");
	  editorsTx.setText("");
	  costumeDesignersTx.setText("");
	  castsTx.setText("");
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
	   
	  public static boolean insertMusicTransaction(String albumName, String musicName, String lang, String producer,
       Map<String, String> musicpeoples, int year, List<String> singers, diskType type) {
       int pplID = -1;
       try {
         con.setAutoCommit(false);
         
         for (String s : singers) {
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
         
         for (String s : musicpeoples.values()) {
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
         musicpeopleid.put("songWriter", SelectHelper.getPeopleID(musicpeoples.get("songWriter")));
         musicpeopleid.put("composer", SelectHelper.getPeopleID(musicpeoples.get("composer")));
         musicpeopleid.put("arranger", SelectHelper.getPeopleID(musicpeoples.get("arranger")));
         
           System.out.println("here");
           // insert only if that piece of soundtrack is not in db
           // insert into Music table
           InserterHelper.insertAlbum(albumName, year, musicName, lang, type, producer);
           // insert into MusicSinger
           // only add at most 2 singers for each song
           for (int i=0; i<singers.size() ;i++) {
             // add the people is exist in peopleInvolved
             id = SelectHelper.getPeopleID(singers.get(i));
             InserterHelper.insertMusicSinger(albumName, year, musicName, id);
             System.out.println("inserted music singer");
           }
           // insert into PeopleInvolvedMusic
           // check the role for each people
  
           Map<String, Integer> temprole = new HashMap<String, Integer>();
           // for each people, serach their roles in music
           for (int ppl : musicpeopleid.values()) {
             // check if this people is inserted already
             if (!SelectHelper.checkMusicCastExist(albumName, year, musicName, ppl)) {
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
               InserterHelper.insertMusicPeopleInvolved(albumName, year, musicName, ppl, sw, c, a);
               System.out.println("inserted music people involved " + ppl);
               // reset the hashmap
               temprole.clear();
               sw = 0; c = 0; a= 0;
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
}
