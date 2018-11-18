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
	private JTextField upISBNSearch;
	private JTextField upAlbumSearch;
	private JTextField upMusicYearSearch;
	private JTextField upMusicNameSearch;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField delISBNTx;
	private JTextField delAlbumTx;
	private JTextField delAlbumTx2;
	private JTextField delMusicTx;
	private JTextField delMovieNameTx;
	private JTextField delMovieYearTx;
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
		frame.setBounds(100, 100, 856, 689);
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
					int pages = checkHelper.checkIfNumerical(insertpages);
					int year = checkHelper.checkIfNumerical(insertpubyear);
					author1 = insertauthor1.getText();
					
					// check if isbn exist already
					boolean bookExist = SelectHelper.bookexist(isbn);
					
					if (pages <= 0 || year <= 0) {
						// show error - wrong range
						System.out.println("range wrong");	
					} else if (bookExist) {
						// error - book isbn duplicated
						System.out.println("ISBN already exist in the database");
					} else {
						
						// get optional field
						if (!insertedition.getText().equals("")) {
							if (checkHelper.checkIfNumerical(editorsTx) > 0) {
								edition = Integer.parseInt(insertedition.getText());
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
						TransactionHelper.insertBookTransaction(isbn, title, pub, pages, year, edition, bookabs, authors, keywords);

						// clear all fields if successfully insert all data
						clearInsertbook();
						
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
		    String[] singersSplit = null; // at most 2 singer for each song
		    int year = -1;
		    diskType type = diskType.AUDIOCD;
		    
		    // check all fields are filled in or not
		    if (albumNameTx.getText().equals("")|| musicNameTx.getText().equals("") || langTx.getText().equals("") || producerTx.getText().equals("") ||
		        arrangerTx.getText().equals("") || ComposerTx.getText().equals("") || songWriterTx.getText().equals("") ||
		        yearTx.getText().equals("") || singersTx.getText().equals("")) {
		      // show error - mandatory fields
          System.out.println("fill in all mandatory fields and in correct format");
		    } else if (checkHelper.checkIfNumerical(yearTx) <= 0) {
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
          
          // insert music
          TransactionHelper.insertMusicTransaction(albumName, musicName, lang, producer, musicpeoples, year, singers, type);
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
		      Map<String, String> allCrewNameRole = new HashMap<String, String>();  // key: name, value:role
		      for (JTextField crewTx: MovieCrewJFields.keySet()) {		        
		        // split by ','
		        tempCrewName = crewTx.getText().toLowerCase().split("\\s*,\\s*");
		        // try to put in a hashmap with name as key and role as value
		        // the pair with the same key will replace the previous value
		        for (String name : tempCrewName) {
		          if (MovieCrewJFields.get(crewTx).equals("cast")) {
		            if (counter < 10) {
		              allCrewNameRole.put(name, MovieCrewJFields.get(crewTx));
	                counter++;
		            }
		          } else {
		            if (counter < 3) {
  		            allCrewNameRole.put(name, MovieCrewJFields.get(crewTx));
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
  		          TransactionHelper.insertMovieTransaction(movieName, movieYear, allCrewNameRole);
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
		
		JRadioButton rdbtnFemale = new JRadioButton("female");
		
		JLabel lblGotAward = new JLabel("Costume designer (1 to 3):");
		
		JRadioButton rdbtnYes = new JRadioButton("Yes");
		
		ButtonGroup castGenderGroup = new ButtonGroup();
		castGenderGroup.add(rdbtnFemale);
		
		ButtonGroup castRewardGroup = new ButtonGroup();
		castRewardGroup.add(rdbtnYes);
		
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
		          .addContainerGap(604, Short.MAX_VALUE))
		        .addGroup(gl_insertMovie.createSequentialGroup()
		          .addGroup(gl_insertMovie.createParallelGroup(Alignment.LEADING)
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
		                        .addComponent(rdbtnFemale)
		                        .addGap(39)))))
		                .addPreferredGap(ComponentPlacement.RELATED))
		              .addGroup(gl_insertMovie.createSequentialGroup()
		                .addComponent(rdbtnYes)
		                .addGap(74)))
		            .addGroup(gl_insertMovie.createSequentialGroup()
		              .addGroup(gl_insertMovie.createParallelGroup(Alignment.TRAILING)
		                .addGroup(gl_insertMovie.createSequentialGroup()
		                  .addComponent(lblGotAward)
		                  .addGap(37)
		                  .addComponent(costumeDesignersTx, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE))
		                .addGroup(Alignment.LEADING, gl_insertMovie.createSequentialGroup()
		                  .addComponent(lblCast)
		                  .addGap(46)
		                  .addGroup(gl_insertMovie.createParallelGroup(Alignment.LEADING)
		                    .addComponent(button_5, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
		                    .addComponent(castsTx, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))))
		              .addPreferredGap(ComponentPlacement.RELATED)))
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
		              .addGroup(gl_insertMovie.createParallelGroup(Alignment.BASELINE)
		                .addComponent(button_4)
		                .addComponent(button_5))
		              .addGap(74)
		              .addComponent(button_2))
		            .addGroup(gl_insertMovie.createSequentialGroup()
		              .addPreferredGap(ComponentPlacement.UNRELATED, 263, Short.MAX_VALUE)
		              .addGroup(gl_insertMovie.createParallelGroup(Alignment.TRAILING)
		                .addComponent(rdbtnFemale)
		                .addGroup(gl_insertMovie.createSequentialGroup()
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
		
		upISBNSearch = new JTextField();
		upISBNSearch.setColumns(10);
		
		JButton btnNewButton = new JButton("Search Book");
		btnNewButton.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent arg0) {
		    // clear all fields
		    clearUpdateBook();
		    // validate the field input
		    String isbn = upISBNSearch.getText();
		    if (checkHelper.checkIsbnFormat(isbn)) {
		      // check if isbn exist
		      if (SelectHelper.bookexist(isbn)) {
		        // get data set
		        ResultSet bookResult = null, bookKeyword = null, bookAuthors = null;
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
              String keywords = bookKeyword.getString("Tag");
              while (bookKeyword.next()) {
                keywords += "," + bookKeyword.getString("Tag");
              }
              upKeywordsTx.setText(keywords);
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
            } catch (SQLException e) {
              e.printStackTrace();
            }
		        
		      } else {
		        System.out.println("Book not exist");
		      }
		    } else {
		      System.out.println("ISBN wrong format");
		    }
		    
		  }
		});
		
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
		GroupLayout gl_updateBook = new GroupLayout(updateBook);
		gl_updateBook.setHorizontalGroup(
		  gl_updateBook.createParallelGroup(Alignment.LEADING)
		    .addGroup(gl_updateBook.createSequentialGroup()
		      .addGap(107)
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
		        .addGroup(gl_updateBook.createParallelGroup(Alignment.TRAILING)
		          .addComponent(btnNewButton)
		          .addGroup(gl_updateBook.createSequentialGroup()
		            .addComponent(lblNewLabel_1)
		            .addPreferredGap(ComponentPlacement.UNRELATED)
		            .addComponent(upISBNSearch, GroupLayout.PREFERRED_SIZE, 425, GroupLayout.PREFERRED_SIZE))
		          .addComponent(btnNewButton_3)))
		      .addGap(190))
		);
		gl_updateBook.setVerticalGroup(
		  gl_updateBook.createParallelGroup(Alignment.LEADING)
		    .addGroup(gl_updateBook.createSequentialGroup()
		      .addGap(32)
		      .addGroup(gl_updateBook.createParallelGroup(Alignment.BASELINE)
		        .addComponent(lblNewLabel_1)
		        .addComponent(upISBNSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addGap(18)
		      .addComponent(btnNewButton)
		      .addGap(18)
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
		      .addContainerGap(80, Short.MAX_VALUE))
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
		btnDeleteBook.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
		    String isbn = delISBNTx.getText();
		    // check isbn regex
        if (checkHelper.checkIsbnFormat(isbn)) {
          // check if book exist in db
          boolean found = SelectHelper.bookexist(isbn);
          // delete if found
          if (found) {
            TransactionHelper.deleteBookTransaction(isbn);
            System.out.println("book deleted");
          } else {
            System.out.println("No such book");  
          }
        } else {
          System.out.println("please enter ISBN with 13 digits");
        }
        delISBNTx.setText("");
		  }
		});
		
		JLabel label = new JLabel("Book ISBN:");
		
		delISBNTx = new JTextField();
		delISBNTx.setColumns(10);
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
							.addComponent(delISBNTx, GroupLayout.PREFERRED_SIZE, 425, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(198, Short.MAX_VALUE))
		);
		gl_deleteBook.setVerticalGroup(
			gl_deleteBook.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_deleteBook.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_deleteBook.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(delISBNTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
			  if (delAlbumTx.getText().equals("") || delMusicTx.getText().equals("")) {
			    System.out.println("Please enter valid information for all fields");
			  } else {
			    String albumName = delAlbumTx.getText();
			    String musicName = delMusicTx.getText();
			    // find if the music exist
			    if (checkHelper.musicExistNoYear(albumName, musicName)) {
  			    TransactionHelper.deleteMusicTransaction(albumName, musicName);
  			    System.out.println("music is deleted");
			    } else {
			      System.out.println("music not exist");
			    }
			  }
			}
		});
		
		JLabel label_1 = new JLabel("Music name:");
		
		JLabel label_2 = new JLabel("Album name:");
		
		JLabel lblAlbumName_2 = new JLabel("Album name:");
		
		delAlbumTx = new JTextField();
		delAlbumTx.setColumns(10);
		
		delAlbumTx2 = new JTextField();
		delAlbumTx2.setColumns(10);
		
		delMusicTx = new JTextField();
		delMusicTx.setColumns(10);
		
		JButton btnDeleteAlbum = new JButton("Delete Album");
		btnDeleteAlbum.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
		    // validate input
		    if (delAlbumTx2.getText().equals("")) {
		      System.out.println("Please enter the album name");
		    } else {
		      String albumName = delAlbumTx2.getText();
		      // if exist delete album
		      if (checkHelper.albumExist(albumName)) {
		        TransactionHelper.deleteAlbumTransaction(albumName);
		        System.out.println("album " + albumName+ " deleted");
		      } else {
		        System.out.println("album not exist");
		      }
		    }
		  }
		});
		GroupLayout gl_deleteAlbum = new GroupLayout(deleteAlbum);
		gl_deleteAlbum.setHorizontalGroup(
		  gl_deleteAlbum.createParallelGroup(Alignment.TRAILING)
		    .addGroup(gl_deleteAlbum.createSequentialGroup()
		      .addGap(107)
		      .addGroup(gl_deleteAlbum.createParallelGroup(Alignment.LEADING, false)
		        .addGroup(Alignment.TRAILING, gl_deleteAlbum.createSequentialGroup()
		          .addComponent(lblAlbumName_2)
		          .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		          .addComponent(delAlbumTx2, GroupLayout.PREFERRED_SIZE, 425, GroupLayout.PREFERRED_SIZE))
		        .addGroup(gl_deleteAlbum.createSequentialGroup()
		          .addComponent(label_1)
		          .addGap(18)
		          .addComponent(delMusicTx))
		        .addGroup(gl_deleteAlbum.createSequentialGroup()
		          .addComponent(label_2)
		          .addPreferredGap(ComponentPlacement.UNRELATED)
		          .addComponent(delAlbumTx, GroupLayout.PREFERRED_SIZE, 431, GroupLayout.PREFERRED_SIZE)))
		      .addContainerGap(211, Short.MAX_VALUE))
		    .addGroup(gl_deleteAlbum.createSequentialGroup()
		      .addContainerGap(575, Short.MAX_VALUE)
		      .addGroup(gl_deleteAlbum.createParallelGroup(Alignment.TRAILING)
		        .addComponent(btnDeleteAlbum, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
		        .addComponent(btnDeleteMusic))
		      .addGap(141))
		);
		gl_deleteAlbum.setVerticalGroup(
		  gl_deleteAlbum.createParallelGroup(Alignment.LEADING)
		    .addGroup(gl_deleteAlbum.createSequentialGroup()
		      .addGap(32)
		      .addGroup(gl_deleteAlbum.createParallelGroup(Alignment.BASELINE)
		        .addComponent(label_2)
		        .addComponent(delAlbumTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addGap(18)
		      .addGroup(gl_deleteAlbum.createParallelGroup(Alignment.LEADING)
		        .addComponent(label_1)
		        .addComponent(delMusicTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addGap(27)
		      .addComponent(btnDeleteMusic)
		      .addGap(38)
		      .addGroup(gl_deleteAlbum.createParallelGroup(Alignment.BASELINE)
		        .addComponent(delAlbumTx2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		        .addComponent(lblAlbumName_2))
		      .addGap(18)
		      .addComponent(btnDeleteAlbum)
		      .addContainerGap(367, Short.MAX_VALUE))
		);
		deleteAlbum.setLayout(gl_deleteAlbum);
		
		JPanel deleteMovie = new JPanel();
		frame.getContentPane().add(deleteMovie, "deleteMovie");
		
		JButton btnDeleteMovie = new JButton("Delete Movie");
		btnDeleteMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  // validate all fields
			  if (delMovieNameTx.getText().equals("") || checkHelper.checkIfNumerical(delMovieYearTx) < 0) {
			    System.out.println("Please enter valid information");
			  } else {
			    String movieName = delMovieNameTx.getText();
			    int year = Integer.parseInt(delMovieYearTx.getText());
			    // find if the movie exist
			    if (SelectHelper.checkMovieExist(movieName, year)) {
			      TransactionHelper.deleteMovieTransaction(movieName);
			      System.out.println("Movie is deleted");
			    } else {
			      System.out.println("Movie not exist");
			    }
			  }
			  
			}
		});
		
		JLabel label_4 = new JLabel("Movie name:");
		
		JLabel label_5 = new JLabel("Release year:");
		
		delMovieNameTx = new JTextField();
		delMovieNameTx.setColumns(10);
		
		delMovieYearTx = new JTextField();
		delMovieYearTx.setColumns(10);
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
								.addComponent(delMovieNameTx, GroupLayout.PREFERRED_SIZE, 425, GroupLayout.PREFERRED_SIZE)
								.addComponent(delMovieYearTx, GroupLayout.PREFERRED_SIZE, 425, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(176, Short.MAX_VALUE))
		);
		gl_deleteMovie.setVerticalGroup(
			gl_deleteMovie.createParallelGroup(Alignment.LEADING)
				.addGap(0, 550, Short.MAX_VALUE)
				.addGroup(gl_deleteMovie.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_deleteMovie.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(delMovieNameTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_deleteMovie.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5)
						.addComponent(delMovieYearTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnDeleteMovie)
					.addContainerGap(413, Short.MAX_VALUE))
		);
		deleteMovie.setLayout(gl_deleteMovie);
		
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
            c.show(frame.getContentPane(), "updateAlbum");
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
	   public static void insertAward(String movieName, int movieYear, Map<String, String> allCrewNameRole) throws SQLException {
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
	   
	  public static void insertCrewMember(String movieName, int movieYear, Map<String, String> allCrewNameRole) throws SQLException {
	    String sql = "insert into CrewMember values (?,?,?,?);";
	    Set<String> flags = new HashSet<String>();  
	    PreparedStatement ps;
      ps = con.prepareStatement(sql);
      ps.setString(2, movieName);
      ps.setInt(3, movieYear);
      for (String name : allCrewNameRole.keySet()) {
        // get peopleID for people
        ps.setInt(1, SelectHelper.getPeopleID(name));
        ps.setInt(4, SelectHelper.getRoleID(allCrewNameRole.get(name)));
        ps.executeUpdate();
        flags.add(allCrewNameRole.get(name));
	    }
      // check if all the roles have at least 1 people
      if (flags.size() != 7) {
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
        for (int i = 1; i <= count; i++) {
          ps.setString(i, "%" + name + "%");
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
	    String sql = "";
	    int count = 0;
	    for (String b: types.keySet()) {	      
	      // if it's checked
	      if (types.get(b)) {
	        // if there's sql in sql string
	        if (!sql.equals("")) {
	          sql += ") union (";
	        }
  	      if (b.equals("book")) {
  	        sql += "select b.title ProductName, b.YearOfPublication Year, 'B' Type, min(CASE WHEN ISNULL(p.MiddleName) " + 
  	            "THEN concat(p.firstName, ' ', p.familyname) " + 
  	            "ELSE concat(p.firstName, ' ',p.middlename, ' ', p.familyname) " + 
  	            "END) 'Author/singer/director' " + 
  	            "from book b, bookauthor ba, peopleInvolved p " + 
  	            "where b.isbn = ba.isbn and ba.author_id = p.id and b.title like ? " + 
  	            "group by ProductName " + 
  	            "order by p.familyname";
  	      } else if (b.equals("album")) {
  	        sql += "select mu.albumName ProductName, mu.Year Year, 'M' Type, min(CASE WHEN ISNULL(p.MiddleName) " + 
  	            "THEN concat(p.firstName, ' ', p.familyname) " + 
  	            "ELSE concat(p.firstName, ' ',p.middlename, ' ', p.familyname) " + 
  	            "END) 'Author/singer/director' " + 
  	            "from music mu, musicsinger mus, peopleinvolved p " + 
  	            "where (mu.albumName,mu.year,mu.musicName) = (mus.albumName,mus.year,mus.musicName) and mus.peopleInvolved_id = p.id and mu.albumName like ? " + 
  	            "group by ProductName " + 
  	            "order by p.familyname";
  	      } else if (b.equals("movie")) {
  	        sql += "select mv.MovieName ProductName, mv.year Year, 'F' Type, min(CASE WHEN ISNULL(p.MiddleName) " + 
  	            "THEN concat(p.firstName, ' ', p.familyname) " + 
  	            "ELSE concat(p.firstName, ' ',p.middlename, ' ', p.familyname) " + 
  	            "END) 'Author/singer/director' " + 
  	            "from movie mv, crewmember cm, peopleinvolved p, role r " + 
  	            "where (mv.MovieName, mv.year) = (cm.MovieName, cm.ReleaseYear) and cm.PeopleInvolved_id = p.id and cm.role_id = r.id and mv.MovieName like ? " + 
  	            "group by ProductName " + 
  	            "order by p.familyname";
  	      }
          count++;
	      }
        if (count == 2) {
          sql = "(" + sql;
        }
 	    }
	    // end query
	    if (count > 1) {
	      sql += ");";
	    } else {
	      sql += ";";
	    }
	    return sql;
	  }
	}
	 
	public static class TransactionHelper {
	  
	  public static void insertBookTransaction(String isbn, String title, String pub, int pages, int year, int edition,
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
	  }
	  
	  public static void insertMovieTransaction(String movieName, int movieYear, Map<String, String> allCrewNameRole) {
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
	   }	    
	   
	  public static void insertMusicTransaction(String albumName, String musicName, String lang, String producer,
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
         
         // check if the music album exist in Music, insert if not
         if (!checkHelper.musicExist(albumName, year, musicName)) {
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
                 System.out.println("inserted music people involved");
                 // reset the hashmap
                 temprole.clear();
                 sw = 0; c = 0; a= 0;
               }
             }
             con.commit();
             System.out.println("Successfully insert all data");
         } else {
           System.out.println("music track of that album already existed.");
         }

       } catch (SQLException e) {
         System.out.println("something wrong when inserting.");
         System.out.println("Rolling back here...");
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
