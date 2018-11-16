package com.assignment.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.JTextField;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

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
	private JTextField textField_12;
	private JTextField textField_15;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField textField_34;
	private JTextField textField_35;
	private JTextField textField_36;
	private JTextField textField_37;
	private JTextField singersTx;
	private JTextField composersTx;
	private JTextField editorsTx;
	private JTextField costumeDesignersTx;
	private JTextField castsTx;

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
		frame.setBounds(100, 100, 815, 624);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, "mainPage");
		
		JLabel lblWelcomeToMy = new JLabel("Welcome to my library");
		panel.add(lblWelcomeToMy);
		
		JPanel insertBook = new JPanel();
		frame.getContentPane().add(insertBook, "insertBook");
		
				JLabel lblBookTitle = new JLabel("Book title:");
		
		insertbooktitle = new JTextField();
		insertbooktitle.setColumns(10);
		
		JLabel lblBookIsbn = new JLabel("Book ISBN:");
		
		insertbookisbn = new JTextField();
		insertbookisbn.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Publisher:");
		
		JLabel lblNumberofPages = new JLabel("Numberof pages:");
		
		JLabel lblYearOfPublication = new JLabel("Year of publication:");
		
		JLabel lblEditionNumber = new JLabel("Edition number:");
		
		JLabel lblAbstract = new JLabel("Abstract:");
		
		JLabel lblKeywords = new JLabel("Keywords:");
		
		JLabel lblAuthors = new JLabel("Authors:");
		
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
						insertbookisbn.getText().length() != 13) {
					// show error - mandatory fields
					System.out.println("fill in all mandatory fields and in correct format");
				} else {
					// get input
					title = insertbooktitle.getText();
					isbn = insertbookisbn.getText();
					pub = insertbookpub.getText();
					int pages = Integer.parseInt(insertpages.getText());
					int year = Integer.parseInt(insertpubyear.getText());
					author1 = insertauthor1.getText();
					
					// check if isbn exist already
					boolean bookExist = bookexist(isbn);
					
					if (pages <= 0 || year <= 0) {
						// show error - wrong range
						System.out.println("range wrong");	
					} else if (bookExist) {
						// error - book isbn duplicated
						System.out.println("ISBN already exist in the database");
					} else {
						
						// get optional field
						if (!insertedition.getText().equals("")) {
							edition = Integer.parseInt(insertedition.getText());
							if (edition < 0) {
								// show error - wrong range
							}
						}
						if (!insertabstract.getText().equals("")) {
							bookabs = insertabstract.getText();
						}
						if (!insertkeyword.getText().equals("")) {
							keywords = insertkeyword.getText().split("\\s*,\\s*");
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
						
						
						// if pass validation
						String sql = "insert into Book values (?,?,?,?,?,?,?);";
						PreparedStatement preparedStatement;
						try {
							// insert book
							preparedStatement = con.prepareStatement(sql);
							preparedStatement.setString(1, isbn);
							preparedStatement.setString(2, title);
							preparedStatement.setString(3, pub);
							preparedStatement.setInt(4, pages);
							preparedStatement.setInt(5, year);
							if (edition == -1) {
								preparedStatement.setInt(6, java.sql.Types.INTEGER);
							} else {
								preparedStatement.setInt(6, edition);
							}
							preparedStatement.setString(7, bookabs);
							preparedStatement.executeUpdate();
							
							// insert authors
							sql = "insert into Bookauthor values (?,?);";
							int pplID = -1;
							for (String author : authors) {
								pplID = getPeopleID(author);
								if (pplID == -1) {
									// author not exist
									System.out.println("author not exist");
									// add new author
									pplID = insertNewPeople(author);
									if (pplID == -1) {
										System.out.println("The author name "+author+" is not in a correct format. will not add to database.");
										// revert - remove book
//										removeBook(isbn);
										break;
									}
								}
								// insert author after found/added
								preparedStatement = con.prepareStatement(sql);
								preparedStatement.setString(1, isbn);
								preparedStatement.setInt(2, pplID);
								preparedStatement.executeUpdate();
								
							}
							
							// insert keywords
							// find if keyword exist in db
							// if not add keyword
							int keyID = -1, nextKeyID = -1;
							for (String keyword : keywords) {
								nextKeyID = getNextKeywordID();
								keyID = getKeywordID(keyword);
								if (nextKeyID == -1) {
									// sth wrong on getting next keyword id
									System.out.println("sth wrong - keyword");
								} else if (keyID < 0){
									sql = "insert into Keyword values (?,?);";
									preparedStatement = con.prepareStatement(sql);
									preparedStatement.setInt(1, nextKeyID);
									preparedStatement.setString(2, keyword);
									preparedStatement.executeUpdate();
									keyID = nextKeyID;
								}
								// if found keyword (or added new keyword), add into bookkeyword
								sql = "insert into BookKeyword values (?,?);";
								preparedStatement = con.prepareStatement(sql);
								preparedStatement.setString(1, isbn);
								preparedStatement.setInt(2, keyID);
								preparedStatement.executeUpdate();								
							}

							// clear all fields if successfully insert all data
							clearInsertbook();
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							System.out.println("sth wrong");
							e.printStackTrace();
						}
					}
				}
			}
		});
		GroupLayout gl_insertBook = new GroupLayout(insertBook);
		gl_insertBook.setHorizontalGroup(
			gl_insertBook.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_insertBook.createSequentialGroup()
					.addGap(173)
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
										.addComponent(btnCancelbook))))))
					.addContainerGap(217, Short.MAX_VALUE))
		);
		gl_insertBook.setVerticalGroup(
			gl_insertBook.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_insertBook.createSequentialGroup()
					.addContainerGap()
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
					.addContainerGap(99, Short.MAX_VALUE))
		);
		insertBook.setLayout(gl_insertBook);
		
		JPanel insertAlbum = new JPanel();
		frame.getContentPane().add(insertAlbum, "insertAlbum");
		
		JButton submitBtn = new JButton("Submit");
		submitBtn.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent arg0) {
		    String albumName = null, musicName = null, lang = null, producer = null, arranger = null, composer = null, songWriter = null;
		    String[] singers = null; // at most 2 singer for each song
		    int year = -1;
		    diskType type = diskType.AUDIOCD;
		    
		    // check all fields are filled in or not
		    if (albumNameTx.getText().equals("")|| musicNameTx.getText().equals("") || langTx.getText().equals("") || producerTx.getText().equals("") ||
		        arrangerTx.getText().equals("") || ComposerTx.getText().equals("") || songWriterTx.getText().equals("") ||
		        yearTx.getText().equals("") || singersTx.getText().equals("")) {
		      // show error - mandatory fields
          System.out.println("fill in all mandatory fields and in correct format");
		    } else if (Integer.parseInt(yearTx.getText()) <= 0) {
		      System.out.println("fill in the year in correct format (year > 0)");
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
		      
		      Map<String, String> musicpeoples = new HashMap<String,String>();
		      musicpeoples.put("songWriter", songWriter);
		      musicpeoples.put("composer", composer);
		      musicpeoples.put("arranger", arranger);
		      
		      // split singers by ','
          singers = singersTx.getText().split("\\s*,\\s*");
          
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

          
          int pplID = -1;
          for (String s : singers) {
            pplID = getPeopleID(s);
            if (pplID == -1) {
              // author not exist
              System.out.println("singer not exist");
              // add new author
              try {
                pplID = insertNewPeople(s);
              } catch (SQLException e) {
                e.printStackTrace();
              }
              if (pplID == -1) {
                System.out.println("The author name "+ s +" is not in a correct format. will not add to database.");
                // revert - remove 
                break;
              }
            }
          }
          
          for (String s : musicpeoples.values()) {
            pplID = getPeopleID(s);
            if (pplID == -1) {
              // author not exist
              System.out.println("music cast not exist");
              // add new author
              try {
                pplID = insertNewPeople(s);
              } catch (SQLException e) {
                e.printStackTrace();
              }
              if (pplID == -1) {
                System.out.println("The music cast name "+ s +" is not in a correct format. will not add to database.");
                // revert - remove 
                break;
              }
            }
          }
          
          pplID = getPeopleID(producer);
          if (pplID == -1) {
            // producer not exist
            System.out.println("producer not exist");
            // add new producer
            try {
              pplID = insertNewPeople(producer);
            } catch (SQLException e) {
              e.printStackTrace();
            }
            if (pplID == -1) {
              System.out.println("The producer name "+ producer +" is not in a correct format. will not add to database.");
              // revert - remove 
            }
          }
          
          int id = -1;
          
          // update the hashmap to storing the id of musicpeoples
          Map<String, Integer> musicpeopleid = new HashMap<String, Integer>();
          musicpeopleid.put("songWriter", getPeopleID(songWriter));
          musicpeopleid.put("composer", getPeopleID(composer));
          musicpeopleid.put("arranger", getPeopleID(arranger));
          
          boolean success = true;
          // check if the music album exist in Music, insert if not
          if (!musicExist(albumName, year, musicName, producer)) {
              System.out.println("here");
              // insert only if that piece of soundtrack is not in db
              // insert into Music table
              success = insertAlbum(albumName, year, musicName, lang, type, producer);
              // insert into MusicSinger
              // only add at most 2 singers for each song
              for (int i=0; i<singers.length ;i++) {
                // add the people is exist in peopleInvolved
                id = getPeopleID(singers[i]);
                insertMusicSinger(albumName, year, musicName, id);
                System.out.println("inserted music");
              }
              // insert into PeopleInvolvedMusic
              // check the role for each people
  
              Map<String, Integer> temprole = new HashMap<String, Integer>();
              // for each people, serach their roles in music
              for (int ppl : musicpeopleid.values()) {
                // check if this people is inserted already
                if (!checkMusicCastExist(albumName, year, musicName, ppl)) {
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
                  insertMusicPeopleInvolved(albumName, year, musicName, ppl, sw, c, a);
                  System.out.println("inserted music people involved");
                  // reset the hashmap
                  temprole.clear();
                  sw = 0; c = 0; a= 0;
                }
              }
            } else {
              System.out.println("music track of that album already existed.");
            }
		    }
		  }
		});
		
		JButton button_1 = new JButton("Cancel");
		button_1.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent arg0) {
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
    GroupLayout gl_insertAlbum = new GroupLayout(insertAlbum);
    
		diskTypeTx = new ButtonGroup();
		diskTypeTx.add(audioCDtype);
		diskTypeTx.add(vinylType);
		
		gl_insertAlbum.setHorizontalGroup(
		  gl_insertAlbum.createParallelGroup(Alignment.TRAILING)
		    .addGroup(gl_insertAlbum.createSequentialGroup()
		      .addGap(173)
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
		          .addComponent(musicNameTx))
		        .addComponent(singersTx, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)
		        .addGroup(gl_insertAlbum.createSequentialGroup()
		          .addComponent(audioCDtype)
		          .addGap(64)
		          .addComponent(vinylType)))
		      .addContainerGap(239, Short.MAX_VALUE))
		    .addGroup(gl_insertAlbum.createSequentialGroup()
		      .addContainerGap(401, Short.MAX_VALUE)
		      .addComponent(submitBtn, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
		      .addGap(18)
		      .addComponent(button_1)
		      .addGap(233))
		);
		gl_insertAlbum.setVerticalGroup(
		  gl_insertAlbum.createParallelGroup(Alignment.LEADING)
		    .addGroup(gl_insertAlbum.createSequentialGroup()
		      .addContainerGap(15, Short.MAX_VALUE)
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
		      .addGap(81))
		);
		insertAlbum.setLayout(gl_insertAlbum);
		
		JPanel insertMovie = new JPanel();
		frame.getContentPane().add(insertMovie, "insertMovie");
		
		JButton button_2 = new JButton("Submit");
		
		JButton button_3 = new JButton("Cancel");
		
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
		
	  JTextField[] insertMovieFields = {movieNameTx, movieYearTx};
	  
		
		JButton button_4 = new JButton("Submit");
		button_4.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
        int movieYear = checkIfNumerical(movieYearTx);
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
		      
		      int counter = 0;
		      String[] tempCrewName = null;
		      Map<String, String> allCrewNameRole = new HashMap<String, String>();  // key: name, value:role
		      for (JTextField crewTx: MovieCrewJFields.keySet()) {		        
		        // split by ','
		        tempCrewName = crewTx.getText().split("\\s*,\\s*");
		        // try to put in a hashmap with name as key and role as value
		        // the pair with the same key will replace the previous value
		        for (String name : tempCrewName) {
		          if (counter < 3) {
		            allCrewNameRole.put(name, MovieCrewJFields.get(crewTx));
		            counter++;
		          }
		        }
		        counter = 0;
		      }
		      // get casts name
		      tempCrewName = castsTx.getText().split("\\s*,\\s*");
		      List<String> castNameArrayList = new LinkedList<String>(Arrays.asList(tempCrewName));
		      
		      
		      // check if the crews and cast exist in peopleInvolved table
		      // crew
		      int pplID;
		      List<String> removalKey = new ArrayList<String>();
		      for (String crewName : allCrewNameRole.keySet()) {
            pplID = getPeopleID(crewName);
            if (pplID == -1) {
              // author not exist
              System.out.println("movie crew not exist " + crewName);
              // add new crew
              try {
                pplID = insertNewPeople(crewName);
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
		      List<Integer> removalCast = new ArrayList<Integer>();
		      // cast
		      for (int i = 0 ; i < castNameArrayList.size() && i < 10; i ++) {
            pplID = getPeopleID(castNameArrayList.get(i));
            if (pplID == -1) {
              // author not exist
              System.out.println("movie crew not exist " + tempCrewName[i]);
              // add new crew
              try {
                pplID = insertNewPeople(castNameArrayList.get(i));
              } catch (SQLException ex) {
                ex.printStackTrace();
              }
              if (pplID == -1) {
                System.out.println("The movie cast name "+ castNameArrayList.get(i) +" is not in a correct format. did not add to database.");
                // add index to array for removal later - prevent from inserting into other tables
                removalCast.add(i);
              }
            }
          }
		      if (removalKey.size() > 0) {
		        for (String k : removalKey) {
		          allCrewNameRole.remove(k);
		        }
		      }
		      // remove cast that name format is wrong
		      if (castNameArrayList.size() > 10) {
		        for (int i = castNameArrayList.size(); i>10; i--) {
		          castNameArrayList.remove(i);
		        }
		      }
		      if (removalCast.size() > 0) {
		        System.out.println(removalCast.get(0));
  		      for (int i=removalCast.size()-1 ; i>=0 ;i--) {
  		        castNameArrayList.remove(i);
  		      }
		      }
		      
		      // get movie name
		      String movieName = movieNameTx.getText();
		      
		      
		      
		      
		      // check if it's a number
		      if (movieYear >= 0) {
  		      // check if movie exist
  		      if (!checkMovieExist(movieName, movieYear)) {
  		        // insert movie if not exist
  		        insertMovie(movieName, movieYear);
  		        System.out.println("movie inserted");
  		        // insert award
  		        
  		        // insert crewMember
  		        
  		        
  		      } else {
  		        System.out.println("movie already exist");
  		        // clear textfields
  		        clearFields(insertMovieFields);
  		      }
		      }
		    }
		  }
		});
		
		JButton button_5 = new JButton("Cancel");
		button_5.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        movieNameTx.setText("");
        movieYearTx.setText("");
      }
    });
		
		String[] movieCastRoles = {"director", "script writer", "cast", "producer",
		    "composer", "editor", "costume designer"};
		
		JComboBox movieRolesTx = new JComboBox(movieCastRoles);
		
		JLabel lblGender = new JLabel("Editor (1 to 3):");
		
		JRadioButton rdbtnMale = new JRadioButton("male");
		rdbtnMale.setSelected(true);
		
		JRadioButton rdbtnFemale = new JRadioButton("female");
		
		JLabel lblGotAward = new JLabel("Costume designer (1 to 3):");
		
		JRadioButton rdbtnYes = new JRadioButton("Yes");
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		
		ButtonGroup castGenderGroup = new ButtonGroup();
		castGenderGroup.add(rdbtnMale);
		castGenderGroup.add(rdbtnFemale);
		
		ButtonGroup castRewardGroup = new ButtonGroup();
		castRewardGroup.add(rdbtnNo);
		castRewardGroup.add(rdbtnYes);
		
		rdbtnNo.setSelected(true);
		
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
		      .addGroup(gl_insertMovie.createParallelGroup(Alignment.LEADING)
		        .addGroup(Alignment.TRAILING, gl_insertMovie.createSequentialGroup()
		          .addGroup(gl_insertMovie.createParallelGroup(Alignment.LEADING)
		            .addGroup(gl_insertMovie.createSequentialGroup()
		              .addComponent(button_4, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
		              .addPreferredGap(ComponentPlacement.RELATED, 397, Short.MAX_VALUE)
		              .addComponent(rdbtnNo)
		              .addGap(144))
		            .addGroup(gl_insertMovie.createSequentialGroup()
		              .addGap(110)
		              .addComponent(button_5, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
		              .addPreferredGap(ComponentPlacement.RELATED)))
		          .addGap(182))
		        .addGroup(gl_insertMovie.createSequentialGroup()
		          .addComponent(lblCast)
		          .addGap(41)
		          .addComponent(castsTx, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
		          .addContainerGap())
		        .addGroup(gl_insertMovie.createSequentialGroup()
		          .addComponent(lblGotAward)
		          .addGap(37)
		          .addComponent(costumeDesignersTx, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
		          .addContainerGap())
		        .addGroup(gl_insertMovie.createSequentialGroup()
		          .addGroup(gl_insertMovie.createParallelGroup(Alignment.TRAILING)
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
		                  .addPreferredGap(ComponentPlacement.RELATED, 5, Short.MAX_VALUE)
		                  .addGroup(gl_insertMovie.createParallelGroup(Alignment.TRAILING, false)
		                    .addGroup(gl_insertMovie.createSequentialGroup()
		                      .addPreferredGap(ComponentPlacement.RELATED)
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
		                      .addComponent(movieYearTx, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
		                    .addGroup(gl_insertMovie.createSequentialGroup()
		                      .addComponent(button_2, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
		                      .addGap(64)
		                      .addGroup(gl_insertMovie.createParallelGroup(Alignment.LEADING)
		                        .addComponent(rdbtnFemale)
		                        .addComponent(rdbtnMale))
		                      .addGap(39)))))
		              .addPreferredGap(ComponentPlacement.RELATED))
		            .addGroup(gl_insertMovie.createSequentialGroup()
		              .addComponent(rdbtnYes)
		              .addGap(74)))
		          .addGroup(gl_insertMovie.createParallelGroup(Alignment.LEADING)
		            .addComponent(button_3, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
		            .addGroup(gl_insertMovie.createSequentialGroup()
		              .addPreferredGap(ComponentPlacement.RELATED)
		              .addComponent(movieRolesTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
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
		              .addComponent(button_4)
		              .addGap(19)
		              .addComponent(button_5)
		              .addGap(30)
		              .addComponent(button_2))
		            .addGroup(gl_insertMovie.createSequentialGroup()
		              .addPreferredGap(ComponentPlacement.UNRELATED)
		              .addGroup(gl_insertMovie.createParallelGroup(Alignment.TRAILING)
		                .addGroup(gl_insertMovie.createSequentialGroup()
		                  .addComponent(rdbtnMale)
		                  .addPreferredGap(ComponentPlacement.RELATED, 258, Short.MAX_VALUE)
		                  .addComponent(rdbtnFemale))
		                .addGroup(gl_insertMovie.createSequentialGroup()
		                  .addComponent(rdbtnNo)
		                  .addGap(13)
		                  .addComponent(movieRolesTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		                  .addGap(70)))
		              .addGroup(gl_insertMovie.createParallelGroup(Alignment.LEADING)
		                .addGroup(gl_insertMovie.createSequentialGroup()
		                  .addGap(19)
		                  .addComponent(button_3))
		                .addGroup(gl_insertMovie.createSequentialGroup()
		                  .addGap(28)
		                  .addComponent(rdbtnYes)))
		              .addGap(126)))))
		      .addGap(32))
		);
		insertMovie.setLayout(gl_insertMovie);
		
		JPanel updateBook = new JPanel();
		frame.getContentPane().add(updateBook, "updateBook");
		
		JLabel lblNewLabel_1 = new JLabel("Book ISBN:");
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		
		JButton btnNewButton = new JButton("Search Book");
		GroupLayout gl_updateBook = new GroupLayout(updateBook);
		gl_updateBook.setHorizontalGroup(
			gl_updateBook.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_updateBook.createSequentialGroup()
					.addGroup(gl_updateBook.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_updateBook.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton))
						.addGroup(Alignment.LEADING, gl_updateBook.createSequentialGroup()
							.addGap(107)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, 425, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(198, Short.MAX_VALUE))
		);
		gl_updateBook.setVerticalGroup(
			gl_updateBook.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_updateBook.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_updateBook.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnNewButton)
					.addContainerGap(453, Short.MAX_VALUE))
		);
		updateBook.setLayout(gl_updateBook);
		
		JPanel updateAlbum = new JPanel();
		frame.getContentPane().add(updateAlbum, "updateAlbum");
		
		JButton btnSearchMusic = new JButton("Search Music");
		
		JLabel lblAlbumName_1 = new JLabel("Album name:");
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		
		JLabel lblYear_1 = new JLabel("Year:");
		
		JLabel lblMusicName_1 = new JLabel("Music name:");
		
		textField_28 = new JTextField();
		textField_28.setColumns(10);
		
		textField_29 = new JTextField();
		textField_29.setColumns(10);
		GroupLayout gl_updateAlbum = new GroupLayout(updateAlbum);
		gl_updateAlbum.setHorizontalGroup(
			gl_updateAlbum.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_updateAlbum.createSequentialGroup()
					.addGap(107)
					.addGroup(gl_updateAlbum.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnSearchMusic)
						.addGroup(gl_updateAlbum.createSequentialGroup()
							.addGroup(gl_updateAlbum.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMusicName_1)
								.addComponent(lblAlbumName_1)
								.addComponent(lblYear_1))
							.addGap(18)
							.addGroup(gl_updateAlbum.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_15, GroupLayout.PREFERRED_SIZE, 425, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_28, GroupLayout.PREFERRED_SIZE, 425, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_29, GroupLayout.PREFERRED_SIZE, 425, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(178, Short.MAX_VALUE))
		);
		gl_updateAlbum.setVerticalGroup(
			gl_updateAlbum.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_updateAlbum.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_updateAlbum.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAlbumName_1)
						.addComponent(textField_15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_updateAlbum.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYear_1)
						.addComponent(textField_28, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_updateAlbum.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMusicName_1)
						.addComponent(textField_29, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnSearchMusic)
					.addContainerGap(373, Short.MAX_VALUE))
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
		GroupLayout gl_updateMovie = new GroupLayout(updateMovie);
		gl_updateMovie.setHorizontalGroup(
			gl_updateMovie.createParallelGroup(Alignment.LEADING)
				.addGap(0, 805, Short.MAX_VALUE)
				.addGroup(gl_updateMovie.createSequentialGroup()
					.addGap(107)
					.addGroup(gl_updateMovie.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnSearchMovie)
						.addGroup(gl_updateMovie.createSequentialGroup()
							.addGroup(gl_updateMovie.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMovieName_2)
								.addComponent(lblReleaseYear_2))
							.addGap(18)
							.addGroup(gl_updateMovie.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_30, GroupLayout.PREFERRED_SIZE, 425, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_31, GroupLayout.PREFERRED_SIZE, 425, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(178, Short.MAX_VALUE))
		);
		gl_updateMovie.setVerticalGroup(
			gl_updateMovie.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_updateMovie.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_updateMovie.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMovieName_2)
						.addComponent(textField_30, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_updateMovie.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblReleaseYear_2)
						.addComponent(textField_31, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnSearchMovie)
					.addContainerGap(413, Short.MAX_VALUE))
		);
		updateMovie.setLayout(gl_updateMovie);
		
		JPanel deleteBook = new JPanel();
		frame.getContentPane().add(deleteBook, "deleteBook");
		
		JButton btnDeleteBook = new JButton("Delete Book");
		
		JLabel label = new JLabel("Book ISBN:");
		
		textField_32 = new JTextField();
		textField_32.setColumns(10);
		GroupLayout gl_deleteBook = new GroupLayout(deleteBook);
		gl_deleteBook.setHorizontalGroup(
			gl_deleteBook.createParallelGroup(Alignment.LEADING)
				.addGap(0, 805, Short.MAX_VALUE)
				.addGroup(gl_deleteBook.createSequentialGroup()
					.addGap(107)
					.addGroup(gl_deleteBook.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnDeleteBook)
						.addGroup(gl_deleteBook.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_32, GroupLayout.PREFERRED_SIZE, 425, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(198, Short.MAX_VALUE))
		);
		gl_deleteBook.setVerticalGroup(
			gl_deleteBook.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_deleteBook.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_deleteBook.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textField_32, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnDeleteBook)
					.addContainerGap(453, Short.MAX_VALUE))
		);
		deleteBook.setLayout(gl_deleteBook);
		
		JPanel deleteAlbum = new JPanel();
		frame.getContentPane().add(deleteAlbum, "deleteAlbum");
		
		JButton btnDeleteMusic = new JButton("Delete Music");
		btnDeleteMusic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel label_1 = new JLabel("Music name:");
		
		JLabel label_2 = new JLabel("Album name:");
		
		JLabel label_3 = new JLabel("Year:");
		
		textField_33 = new JTextField();
		textField_33.setColumns(10);
		
		textField_34 = new JTextField();
		textField_34.setColumns(10);
		
		textField_35 = new JTextField();
		textField_35.setColumns(10);
		GroupLayout gl_deleteAlbum = new GroupLayout(deleteAlbum);
		gl_deleteAlbum.setHorizontalGroup(
			gl_deleteAlbum.createParallelGroup(Alignment.LEADING)
				.addGap(0, 805, Short.MAX_VALUE)
				.addGroup(gl_deleteAlbum.createSequentialGroup()
					.addGap(107)
					.addGroup(gl_deleteAlbum.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnDeleteMusic)
						.addGroup(gl_deleteAlbum.createSequentialGroup()
							.addGroup(gl_deleteAlbum.createParallelGroup(Alignment.LEADING)
								.addComponent(label_1)
								.addComponent(label_2)
								.addComponent(label_3))
							.addGap(18)
							.addGroup(gl_deleteAlbum.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_33, GroupLayout.PREFERRED_SIZE, 425, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_34, GroupLayout.PREFERRED_SIZE, 425, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_35, GroupLayout.PREFERRED_SIZE, 425, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(178, Short.MAX_VALUE))
		);
		gl_deleteAlbum.setVerticalGroup(
			gl_deleteAlbum.createParallelGroup(Alignment.LEADING)
				.addGap(0, 550, Short.MAX_VALUE)
				.addGroup(gl_deleteAlbum.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_deleteAlbum.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(textField_33, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_deleteAlbum.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(textField_34, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_deleteAlbum.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(textField_35, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnDeleteMusic)
					.addContainerGap(373, Short.MAX_VALUE))
		);
		deleteAlbum.setLayout(gl_deleteAlbum);
		
		JPanel deleteMovie = new JPanel();
		frame.getContentPane().add(deleteMovie, "deleteMovie");
		
		JButton btnDeleteMovie = new JButton("Delete Movie");
		btnDeleteMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel label_4 = new JLabel("Movie name:");
		
		JLabel label_5 = new JLabel("Release year:");
		
		textField_36 = new JTextField();
		textField_36.setColumns(10);
		
		textField_37 = new JTextField();
		textField_37.setColumns(10);
		GroupLayout gl_deleteMovie = new GroupLayout(deleteMovie);
		gl_deleteMovie.setHorizontalGroup(
			gl_deleteMovie.createParallelGroup(Alignment.LEADING)
				.addGap(0, 805, Short.MAX_VALUE)
				.addGroup(gl_deleteMovie.createSequentialGroup()
					.addGap(107)
					.addGroup(gl_deleteMovie.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnDeleteMovie)
						.addGroup(gl_deleteMovie.createSequentialGroup()
							.addGroup(gl_deleteMovie.createParallelGroup(Alignment.LEADING)
								.addComponent(label_4)
								.addComponent(label_5))
							.addGap(18)
							.addGroup(gl_deleteMovie.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_36, GroupLayout.PREFERRED_SIZE, 425, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_37, GroupLayout.PREFERRED_SIZE, 425, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(176, Short.MAX_VALUE))
		);
		gl_deleteMovie.setVerticalGroup(
			gl_deleteMovie.createParallelGroup(Alignment.LEADING)
				.addGap(0, 550, Short.MAX_VALUE)
				.addGroup(gl_deleteMovie.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_deleteMovie.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(textField_36, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_deleteMovie.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5)
						.addComponent(textField_37, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnDeleteMovie)
					.addContainerGap(413, Short.MAX_VALUE))
		);
		deleteMovie.setLayout(gl_deleteMovie);
		
		
		
		
		
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
		
		JMenu mnUpdate = new JMenu("Update");
		mnData.add(mnUpdate);
		
		JMenuItem menuItem = new JMenuItem("Book");
		menuItem.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent event) {
	        	// go to insert book page
	        	  CardLayout c = (CardLayout)(frame.getContentPane().getLayout());
	        	  c.show(frame.getContentPane(), "updateBook");
	          }
	        });
		mnUpdate.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("Album");
		menuItem_1.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent event) {
	        	// go to insert book page
	        	  CardLayout c = (CardLayout)(frame.getContentPane().getLayout());
	        	  c.show(frame.getContentPane(), "updateAlbum");
	          }
	        });
		mnUpdate.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("Movie");
		menuItem_2.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent event) {
	        	// go to insert book page
	        	  CardLayout c = (CardLayout)(frame.getContentPane().getLayout());
	        	  c.show(frame.getContentPane(), "updateMovie");
	          }
	        });
		mnUpdate.add(menuItem_2);
		
		JMenu mnDelete = new JMenu("Delete");
		mnData.add(mnDelete);
		
		JMenuItem menuItem_3 = new JMenuItem("Book");
		menuItem_3.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent event) {
	        	// go to insert book page
	        	  CardLayout c = (CardLayout)(frame.getContentPane().getLayout());
	        	  c.show(frame.getContentPane(), "deleteBook");
	          }
	        });
		mnDelete.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("Album");
		menuItem_4.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent event) {
	        	// go to insert book page
	        	  CardLayout c = (CardLayout)(frame.getContentPane().getLayout());
	        	  c.show(frame.getContentPane(), "deleteAlbum");
	          }
	        });
		mnDelete.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("Movie");
		menuItem_5.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent event) {
	        	// go to insert book page
	        	  CardLayout c = (CardLayout)(frame.getContentPane().getLayout());
	        	  c.show(frame.getContentPane(), "deleteMovie");
	          }
	        });
		mnDelete.add(menuItem_5);
		
		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);
		
		JMenuItem mntmView = new JMenuItem("view");
		mnView.add(mntmView);
		
		JMenu mnReport = new JMenu("Report");
		menuBar.add(mnReport);
		
		

	}
	
	
	// functions for insert book ----------------------------------------------------------------------
	
	public static int getPeopleID(String name) {
		String sql = "Select ID from PeopleInvolved where concat(FirstName,' ',FamilyName) = ?;";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, name);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				return (rs.getInt("ID"));
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		return -1;
	}
	
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
	
	private int getNextKeywordID() {
		String sql = "Select count(*) from keyword;";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("count(*)");
				return id + 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	private int getKeywordID(String keyword) {
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
	
	private int getNextPeopleID() {
		String sql = "Select count(*) from PeopleInvolved;";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("count(*)");
				return id + 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	private int insertNewPeople(String fullname) throws SQLException {
		int nextID = getNextPeopleID();
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
	
	private boolean bookexist(String isbn) {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	private void removeBook(String isbn) throws SQLException {
		String sql = "delete from book where isbn = ?;";
		PreparedStatement preparedStatement;
		preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, isbn);
		preparedStatement.executeUpdate();
	}
	
	// ---------------------------------------------------------------------------------
	
	// functions for inserting album ---------------------------------------------------------------
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
	 
	 public static boolean musicExist(String albumName, int year, String musicName, String producer) {
	   ResultSet rs = getAlbums();
     try {
       while(rs.next()) {
        if (rs.getString("AlbumName").equalsIgnoreCase(albumName)) {
           if (rs.getInt("Year") == year) {
             if (rs.getString("MusicName").equalsIgnoreCase(musicName)) {
               if (rs.getInt("Producer_ID") == getPeopleID(producer)) {
                 // exist in music album
                 return true;
               }
             }
           }
         }
       }
     } catch (SQLException e) {
       e.printStackTrace();
     }
     return false;
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
	 
	 public static boolean insertAlbum(String albumName, int year, String musicName, String language, diskType diskType, String producer) {
	   int producerID = getPeopleID(producer);
	   String sql = "insert into Music values (?,?,?,?,?,?);";
     try {
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1, albumName);
       ps.setInt(2, year);
       ps.setString(3, musicName);
       ps.setString(4, language);
       ps.setInt(5, diskType.getEnumValue());
       ps.setInt(6, producerID);
       ps.executeUpdate();
  	   return true;
     } catch (SQLException e){
       e.printStackTrace();
     }
     return false;
	 }
	 
	 public static boolean insertMusicSinger(String albumName, int year, String musicName, int id) {
	   String sql = "insert into MusicSinger values (?,?,?,?);";
     PreparedStatement ps;
    try {
      ps = con.prepareStatement(sql);
      ps.setString(1, albumName);
      ps.setInt(2, year);
      ps.setString(3, musicName);
      ps.setInt(4, id);
      ps.executeUpdate();
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
	 }
	 
	 public static boolean insertMusicPeopleInvolved(String albumName, int year, String musicName, int ppl, int sw, int c, int a) {
	   String sql = "insert into PeopleInvolvedMusic values (?,?,?,?,?,?,?);";
	   PreparedStatement ps;
    try {
      ps = con.prepareStatement(sql);
      ps.setString(1, albumName);
      ps.setInt(2, year);
      ps.setString(3, musicName);
      ps.setInt(4, ppl);
      ps.setInt(5, sw);
      ps.setInt(6, c);
      ps.setInt(7, a);
      ps.executeUpdate();
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
	 }
	 
   //--------------------------------------------------------------------------------------------------------------------------------
	 // ---------------------------------------------insert movie functions ---------------------------------------------------------
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
	 
	 public static boolean insertMovie(String movieName, int movieYear) {
	   String sql = "insert into Movie values (?,?);";
	   PreparedStatement ps;
	   try {
       ps = con.prepareStatement(sql);
       ps.setString(1, movieName);
       ps.setInt(2, movieYear);
       ps.executeUpdate();
       return true;
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
	 
	 public static void clearFields(JTextField[] list) {
	   for (int i = 0; i < list.length ; i++) {
	     list[i].setText("");
	   }
	 }
}
