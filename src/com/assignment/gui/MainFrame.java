package com.assignment.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.Component;
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
import javax.swing.ButtonModel;
import javax.swing.DefaultListModel;
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
import java.awt.Toolkit;
import java.awt.FlowLayout;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

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
	private JTextField movieYearTx;
	private JTextField movieNameTx;
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
//	private JList<String> upTrackList = new JList<String>();
	private Map<String, MusicTrack> tracks = new HashMap<String, MusicTrack>();
	private JTextField searchNameTx;
	private JTextField searchYearTx;
	private JCheckBox chckbxBook;
  private JCheckBox chckbxAlbum;
  private JCheckBox chckbxMovie;
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
	private JTextField insCastNameTx;
	private JTextArea textAreaMusicTrack;
	private JTextArea textArea;
  private JTextArea textArea_1;
	private Map<String, List<MovieCrew>> crews = new HashMap<String, List<MovieCrew>>();
	private String[] movieCastRoles = {"director", "script writer", "cast", "producer",
      "composer", "editor", "costume designer"};
	private Book oldBook;
	private Album oldAlbum;
	private Movie oldMovie;
  private Map<String, List<MovieCrew>> tempcrew = new HashMap<String, List<MovieCrew>>();
	private DefaultListModel<String> model = new DefaultListModel();
	private DefaultListModel<String> model2 = new DefaultListModel();
	private JTextField textField;
	private JTextField upAlbumTx;
	private JTextField upProducerTx;
	private JTextField upYearTx;
	private JTextField upMovieNameTx;
	private JTextField upMovieYearTx;
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
		frame.setBounds(100, 100, 885, 702);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
//    frame.setBounds(100, 100, 1070, 669);
    frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
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
		
		JLabel lblEachBookCan = new JLabel("Each book can store at most 5 authors and at least one author, and, at most 20 keywords.");
		
		JLabel lblNameOfPeople_1 = new JLabel("Name of people who involved should be in the format of 'first_name family_name' or 'first_name middle_name family_name'");
		
		JLabel lblIfTheNames = new JLabel("If the names are in the wrong format, it will not be stored in the database.");
		
		JLabel lblPleaseInsertAll_1 = new JLabel("Please insert all the mandatory fields. ISBN is a 13 digits string.");
		GroupLayout gl_insertBook = new GroupLayout(insertBook);
		gl_insertBook.setHorizontalGroup(
		  gl_insertBook.createParallelGroup(Alignment.LEADING)
		    .addGroup(gl_insertBook.createSequentialGroup()
		      .addGroup(gl_insertBook.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_insertBook.createSequentialGroup()
		          .addGap(22)
		          .addGroup(gl_insertBook.createParallelGroup(Alignment.LEADING)
		            .addComponent(lblNameOfPeople_1, GroupLayout.PREFERRED_SIZE, 809, GroupLayout.PREFERRED_SIZE)
		            .addComponent(lblPleaseInsertAll_1, GroupLayout.PREFERRED_SIZE, 672, GroupLayout.PREFERRED_SIZE)
		            .addComponent(lblIfTheNames, GroupLayout.PREFERRED_SIZE, 469, GroupLayout.PREFERRED_SIZE)
		            .addComponent(lblEachBookCan, GroupLayout.PREFERRED_SIZE, 597, GroupLayout.PREFERRED_SIZE)))
		        .addGroup(gl_insertBook.createSequentialGroup()
		          .addGap(184)
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
		      .addContainerGap(36, Short.MAX_VALUE))
		);
		gl_insertBook.setVerticalGroup(
		  gl_insertBook.createParallelGroup(Alignment.LEADING)
		    .addGroup(gl_insertBook.createSequentialGroup()
		      .addContainerGap()
		      .addComponent(lblPleaseInsertAll_1)
		      .addGap(11)
		      .addComponent(lblEachBookCan)
		      .addGap(13)
		      .addComponent(lblNameOfPeople_1)
		      .addGap(13)
		      .addComponent(lblIfTheNames)
		      .addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
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
		      .addGap(38))
		);
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
		
		JLabel label_44 = new JLabel("Name of people who involved should be in the format of 'first_name family_name' or 'first_name middle_name family_name'");
		
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
          JOptionPane.showMessageDialog(null, "fill in all mandatory fields and in correct format", "Insert music - wrong format", JOptionPane.ERROR_MESSAGE);
        } else if (checkHelper.checkIfNumerical(insYearTx) <= 0) {
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
                // clear the text fields
                clearInsertMusic();
                musicTracks.clear();
              } else {
                JOptionPane.showMessageDialog(null, "Music insertion fail due to unexpected error", "Insert music - error", JOptionPane.ERROR_MESSAGE);
              }
            } else {
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
		
		JButton btnCancel_2 = new JButton("Cancel");
		btnCancel_2.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent arg0) {
		    clearInsertMusic();
		  }
		});
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
		            .addComponent(lblYouShouldInsert)))
		        .addGroup(gl_insertAlbum2.createSequentialGroup()
		          .addGap(289)
		          .addComponent(label_38)
		          .addGap(39)
		          .addComponent(textField_17, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)))
		      .addGap(155))
		    .addGroup(Alignment.LEADING, gl_insertAlbum2.createSequentialGroup()
		      .addGap(195)
		      .addGroup(gl_insertAlbum2.createParallelGroup(Alignment.TRAILING, false)
		        .addGroup(gl_insertAlbum2.createSequentialGroup()
		          .addComponent(lblMusicTracks)
		          .addGap(314))
		        .addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 397, GroupLayout.PREFERRED_SIZE)
		        .addGroup(gl_insertAlbum2.createSequentialGroup()
		          .addComponent(button_2)
		          .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		          .addComponent(btnTry))
		        .addGroup(gl_insertAlbum2.createSequentialGroup()
		          .addGroup(gl_insertAlbum2.createParallelGroup(Alignment.LEADING, false)
		            .addComponent(label_43, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		            .addComponent(label_1)
		            .addComponent(lblProducer_1))
		          .addPreferredGap(ComponentPlacement.UNRELATED)
		          .addGroup(gl_insertAlbum2.createParallelGroup(Alignment.LEADING)
		            .addComponent(insAlbumTx, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
		            .addGroup(gl_insertAlbum2.createParallelGroup(Alignment.LEADING)
		              .addComponent(insProducerTx, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
		              .addComponent(insYearTx, GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE))))
		        .addGroup(gl_insertAlbum2.createSequentialGroup()
		          .addComponent(btnCancel_2)
		          .addGap(18)
		          .addComponent(btnSubmit)))
		      .addContainerGap(328, Short.MAX_VALUE))
		);
		gl_insertAlbum2.setVerticalGroup(
		  gl_insertAlbum2.createParallelGroup(Alignment.LEADING)
		    .addGroup(gl_insertAlbum2.createSequentialGroup()
		      .addGap(38)
		      .addComponent(label)
		      .addGap(11)
		      .addComponent(lblYouShouldInsert)
		      .addPreferredGap(ComponentPlacement.UNRELATED)
		      .addComponent(label_44)
		      .addGap(47)
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
		      .addGap(84)
		      .addGroup(gl_insertAlbum2.createParallelGroup(Alignment.BASELINE)
		        .addComponent(btnSubmit)
		        .addComponent(btnCancel_2))
		      .addGap(55)
		      .addGroup(gl_insertAlbum2.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_insertAlbum2.createSequentialGroup()
		          .addGap(376)
		          .addComponent(label_38))
		        .addGroup(gl_insertAlbum2.createSequentialGroup()
		          .addGap(373)
		          .addComponent(textField_17, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		      .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
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
//		    CardLayout c = (CardLayout)(frame.getContentPane().getLayout());
//        c.show(frame.getContentPane(), "AddMovieCrewPanel2");
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
        if (movieNameTx.getText().equals("") || movieYearTx.getText().equals("") || checkHelper.checkIfEmptyCrew(crews)) {
          JOptionPane.showMessageDialog(null, "Please fill in all the fields with at least one people in each role", "Insert movie - incomplete input", JOptionPane.ERROR_MESSAGE);
        } else if (year < 0) {
          JOptionPane.showMessageDialog(null, "Year in wrong range", "Insert movie - wrong range", JOptionPane.ERROR_MESSAGE);
        } else {
          // get all the input
          movieName = movieNameTx.getText();
          
          // check if movie exist
          if (!checkHelper.movieExist(movieName)) {
            // inserting start
            TransactionHelper.insertMovieTransaction(movieName, year, crews);
            JOptionPane.showMessageDialog(null, "Movie inserted", "Insert movie - movie inserted", JOptionPane.INFORMATION_MESSAGE);
          } else {
            JOptionPane.showMessageDialog(null, "Movie already exist", "Insert movie - movie existed", JOptionPane.ERROR_MESSAGE);
          }
        }
      }
    });
		
		JButton btnRefreshList_1 = new JButton("Refresh list");
		btnRefreshList_1.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent arg0) {
		    String str = "";
		    for (MovieCrew cast:crews.get("cast")) {
		      str += cast.getCrewName() + "\n";
		    }
		    textArea_1.setText(str);
		    str = "";
		    for (String role: crews.keySet()) {
		      if (!role.equalsIgnoreCase("cast")) {
		        for (MovieCrew crew: crews.get(role)) {
		          str += crew.getCrewName() + "\n"; 
		        }
		      }
		    }
		    textArea.setText(str);
		  }
		});
		
		JLabel lblPleaseFillIn = new JLabel("Please fill in all the madatory fields.");
		
		JLabel lblThereShouldBe = new JLabel("There should be at least one people for each role. At most 10 for cast, at most 3 otherwise.");
		GroupLayout gl_insertMovie = new GroupLayout(insertMovie);
		gl_insertMovie.setHorizontalGroup(
		  gl_insertMovie.createParallelGroup(Alignment.LEADING)
		    .addGroup(gl_insertMovie.createSequentialGroup()
		      .addGroup(gl_insertMovie.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_insertMovie.createSequentialGroup()
		          .addGap(45)
		          .addGroup(gl_insertMovie.createParallelGroup(Alignment.LEADING)
		            .addComponent(lblThereShouldBe)
		            .addComponent(lblPleaseFillIn)))
		        .addGroup(gl_insertMovie.createSequentialGroup()
		          .addGap(176)
		          .addGroup(gl_insertMovie.createParallelGroup(Alignment.LEADING)
		            .addGroup(gl_insertMovie.createSequentialGroup()
		              .addGroup(gl_insertMovie.createParallelGroup(Alignment.LEADING)
		                .addComponent(textArea, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
		                .addComponent(lblCrewAndCast)
		                .addComponent(btnRefreshList_1))
		              .addGap(93)
		              .addGroup(gl_insertMovie.createParallelGroup(Alignment.LEADING)
		                .addComponent(lblCast, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
		                .addGroup(gl_insertMovie.createParallelGroup(Alignment.TRAILING)
		                  .addGroup(gl_insertMovie.createSequentialGroup()
		                    .addComponent(btnSubmit_1)
		                    .addPreferredGap(ComponentPlacement.UNRELATED)
		                    .addComponent(btnCancel_1))
		                  .addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE))))
		            .addGroup(gl_insertMovie.createSequentialGroup()
		              .addGroup(gl_insertMovie.createParallelGroup(Alignment.LEADING)
		                .addComponent(lblReleaseYear)
		                .addComponent(lblMovieName))
		              .addGap(18)
		              .addGroup(gl_insertMovie.createParallelGroup(Alignment.LEADING, false)
		                .addComponent(movieNameTx)
		                .addComponent(movieYearTx, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)))
		            .addComponent(btnAddNewCrew))))
		      .addContainerGap(103, Short.MAX_VALUE))
		);
		gl_insertMovie.setVerticalGroup(
		  gl_insertMovie.createParallelGroup(Alignment.LEADING)
		    .addGroup(gl_insertMovie.createSequentialGroup()
		      .addGap(31)
		      .addComponent(lblPleaseFillIn)
		      .addGap(18)
		      .addComponent(lblThereShouldBe)
		      .addGap(18)
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
		        .addComponent(btnSubmit_1)
		        .addComponent(btnRefreshList_1))
		      .addContainerGap(59, Short.MAX_VALUE))
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
		    // get validate input, put it as a book object
		    String newIsbn = upISBN.getText();
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
		    Set<String> newAuthorsSet = new HashSet<String>();
		    
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
		      JOptionPane.showMessageDialog(null, "Wrong name format or duplicate author name entered", "fail update book", JOptionPane.ERROR_MESSAGE);
		    }
		    if (newEdition < 0 && !upEditionTx.getText().equals("")) {
		      success = false;
		      JOptionPane.showMessageDialog(null, "Wrong format for edition", "fail update book", JOptionPane.ERROR_MESSAGE);
	      }
		    // check if all the mandatory fields are filled in
		    // if mandatory field is empty, do nothing
		    // if isbn changed, pop up said cannot changed
		    if (!upISBN.getText().equals("")) {
		      if (!oldBook.isbn.equalsIgnoreCase(newIsbn)) {
		        JOptionPane.showMessageDialog(null, "Cannot change book ISBN", "fail update book", JOptionPane.ERROR_MESSAGE);
		        success = false;
		      }
		    }
		    
		    if(upAuthorTx1.getText().equals("")&&upAuthorTx2.getText().equals("")&&upAuthorTx3.getText().equals("")&&
		        upAuthorTx4.getText().equals("")&&upAuthorTx5.getText().equals("")) {
		      JOptionPane.showMessageDialog(null, "Should have at least one author", "fail update book", JOptionPane.ERROR_MESSAGE);
          success = false;
		    }

		    if (success) {
          try {
    		    con.setAutoCommit(false);
    		    if (!newTitle.equals("") && !oldBook.compareTitle(newTitle)) {
    		      // update title
    		      UpdateHelper.updateBookString(newTitle, oldBook.isbn, "title");
    		    }
    		    if (!newPublisher.equals("") && !oldBook.comparePublisher(newPublisher)) {
    		      // update publisher
    		      UpdateHelper.updateBookString(newPublisher, oldBook.isbn, "publisher");
    		    }
    		    if (!upPagesTx.getText().equals("") && !oldBook.comparePages(newPage)) {
    		      // update page with check
    		      if (newPage >= 0) {
    		        UpdateHelper.updateBookInt(newPage, oldBook.isbn, "Numberofpages");
    		      }
    		    }
    		    if (upEditionTx.getText().equals("")) {
    		      // remove edition
    		      UpdateHelper.updateBookInt(-1, oldBook.isbn, "editionnumber");
    		    } else if (!upEditionTx.getText().equals("") && !oldBook.compareEdition(newEdition)) {
    		      // update edition with check
    		      if (newEdition >= 0) {
    		        UpdateHelper.updateBookInt(newEdition, oldBook.isbn, "editionnumber");
    		      }
    		    }
    		    if (!oldBook.compareAbstract(newAbstract)) {
    		      //update abstract
    		      UpdateHelper.updateBookString(newAbstract, oldBook.isbn, "abstract");
    		    }
    		    if (!upBookYearTx.getText().equals("") && !oldBook.compareYear(newYear)) {
    		      // update year with check
    		      if (newYear > 0) {
    		        UpdateHelper.updateBookInt(newYear, oldBook.isbn, "yearofpublication");
    		      }
    		    }
    		    List<String> delAuthor = new ArrayList<String>();
    		    List<String> insertAuthor = new ArrayList<String>(newAuthors);
    		    
  //  		     check author list
    		    if (!oldBook.compareAuthor(newAuthors)) {
    		      if (newAuthors.size() == 0) {
    		        // do nothing, remain old data
    		        JOptionPane.showMessageDialog(null, "Must have at least one author", "updated failed", JOptionPane.ERROR_MESSAGE);
    		        success = false;
    		      } else {
    		        // get the list for update
    		        for (String authorName : oldBook.authors) {
    		          if (!newAuthors.contains(authorName)) {
    		            delAuthor.add(authorName);
    		          } else {
    		            insertAuthor.remove(authorName);
    		          }
    		        }
    		      }
    		    }
    		    // do update for authors
    		    if (delAuthor.size() > 0) {
    		      // delete author
    		      DeleteHelper.deleteBookAuthors(oldBook.isbn, delAuthor);
    		    }
    		    if (insertAuthor.size() > 0) {
    		      InserterHelper.insertBookAuthor(oldBook.isbn, insertAuthor);
    		    }
    		    
    		    List<String> delkey = new ArrayList<String>();
            List<String> insertkey = new ArrayList<String>(newKeywordsArr);
    		    // check keyword list
    		    // do update for keywords
    		    if (delkey.size() > 0) {
    		      DeleteHelper.deleteBookKeywords(oldBook.isbn, delkey);
    		    }
    		    if (upKeywordsTx.getText().equals("")) {
    		      DeleteHelper.removeBookKeyword(oldBook.isbn);
    		    }
    		    if (insertkey.size() > 0) {
    		      DeleteHelper.removeBookKeyword(oldBook.isbn);
    		      InserterHelper.insertBookKeyword(oldBook.isbn, insertkey);
    		    }
    		    
    		    
    		    con.commit();
    		    if (success) {
    		      JOptionPane.showMessageDialog(null, "Successfully updated", "Successfully updated", JOptionPane.INFORMATION_MESSAGE);
    		    }
    		    CardLayout c = (CardLayout)(frame.getContentPane().getLayout());
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
		    CardLayout c = (CardLayout)(frame.getContentPane().getLayout());
        c.show(frame.getContentPane(), "mainPage");
		  }
		});
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
		            .addGroup(gl_updateBook.createSequentialGroup()
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
		                  .addComponent(upAuthorTx5, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
		                .addGroup(gl_updateBook.createSequentialGroup()
		                  .addComponent(label_7, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
		                  .addGap(5)
		                  .addComponent(upBookYearTx, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE))
		                .addGroup(gl_updateBook.createParallelGroup(Alignment.LEADING)
		                  .addGroup(Alignment.TRAILING, gl_updateBook.createSequentialGroup()
		                    .addComponent(btnNewButton_3)
		                    .addGap(18)
		                    .addComponent(btnCancel_3))
		                  .addGroup(gl_updateBook.createSequentialGroup()
		                    .addGap(116)
		                    .addComponent(upAuthorTx3, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
		                    .addGap(23)
		                    .addComponent(upAuthorTx4, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)))
		                .addGroup(gl_updateBook.createSequentialGroup()
		                  .addComponent(lblNumberOfPages)
		                  .addPreferredGap(ComponentPlacement.UNRELATED)
		                  .addComponent(upPagesTx, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)))
		              .addGap(13)))))
		      .addContainerGap(295, Short.MAX_VALUE))
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
		            .addComponent(upPublisherTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		        .addComponent(upBookTitleTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addPreferredGap(ComponentPlacement.UNRELATED)
		      .addGroup(gl_updateBook.createParallelGroup(Alignment.BASELINE)
		        .addComponent(lblNumberOfPages)
		        .addComponent(upPagesTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		      .addGap(18)
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
		      .addGap(40)
		      .addGroup(gl_updateBook.createParallelGroup(Alignment.BASELINE)
		        .addComponent(btnCancel_3)
		        .addComponent(btnNewButton_3))
		      .addContainerGap(108, Short.MAX_VALUE))
		);
		updateBook.setLayout(gl_updateBook);
		
		musicTracks = new ArrayList<MusicTrack>();
    
    String[] movieCastRoles = {"director", "script writer", "cast", "producer",
        "composer", "editor", "costume designer"};
    
    ButtonGroup castGenderGroup = new ButtonGroup();
    
    JPanel updateAlbum = new JPanel();
    frame.getContentPane().add(updateAlbum, "updateAlbum");
    
    JLabel lblUpdateByChanging = new JLabel("Update by changing the data in the fields. Double click the music track to change the info of music.");
    
    JLabel label_23 = new JLabel("Name of people who involved should be in the format of 'first_name family_name' or 'first_name middle_name family_name'");
    
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
          JOptionPane.showMessageDialog(null, "fill in all mandatory fields and in correct format", "Update music - wrong format", JOptionPane.ERROR_MESSAGE);
        } else if (checkHelper.checkIfNumerical(upYearTx) <= 0) {
          JOptionPane.showMessageDialog(null, "fill in the year in correct range", "Update music - wrong range", JOptionPane.ERROR_MESSAGE);
        } else if (tracks.isEmpty()) {
          JOptionPane.showMessageDialog(null, "You should have at least one music track", "Update music - no music track", JOptionPane.ERROR_MESSAGE);
        } else {
          // get the string values
          albumName = upAlbumTx.getText();
          year = Integer.parseInt(upYearTx.getText());
          producer = upProducerTx.getText();
          if (!checkHelper.checkNameFormat(producer)) {
            JOptionPane.showMessageDialog(null, "fill in the producer name in correct format", "Update music - wrong name format", JOptionPane.ERROR_MESSAGE);
          } else {
            String newName = albumName, newProducer = producer;
            int newYear = year;
            boolean changedn = false, changedy = false, changedp = false;
            String oldAlbumName = oldAlbum.getAlbumName();
            int oldYear = oldAlbum.getYear();
            // check if the album name the same
            if (!oldAlbum.compareAlbumName(albumName)) {
              // check if the music album exist in Music
              if (!checkHelper.albumExist(albumName)) {
                // update the album name for all music tracks
                changedn = true;
              } else {
                JOptionPane.showMessageDialog(null, "This album name already existed", "Update album name - already existed", JOptionPane.ERROR_MESSAGE);
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

            // update album transaction --------------
            try {
              con.setAutoCommit(false);
              // if there are music tracks are added/deleted, do that
              if (changedp) {
                // only update the producer in table music
                UpdateHelper.updateMusicProducer(albumName, producer);
              }
              if (changedn && changedy) { // if album name and year is changed
                // update all the music track for this album
                // insert music tracks with new album data
                for (MusicTrack t : tracks.values()) {
                  InserterHelper.insertAlbum(newName, newYear, t.musicName, t.language, t.type, newProducer);
                  // update all the album name in 2 other tables
                  UpdateHelper.updateAlbumNameSinger(oldAlbumName, oldYear, newName, newYear, t.musicName);
                  UpdateHelper.updateAlbumNameCrew(oldAlbumName, oldYear, newName, newYear, t.musicName);
                  // remove all the music track for old album
                  DeleteHelper.removeMusic(oldAlbumName, t.musicName);
                }
              } else if (changedn) { // if album name is changed
                // update all the music track for this album
                // insert music tracks with new album data
                for (MusicTrack t : tracks.values()) {
                  InserterHelper.insertAlbum(newName, newYear, t.musicName, t.language, t.type, newProducer);
                  // update all the album name in 2 other tables
                  UpdateHelper.updateAlbumNameSinger(oldAlbumName, oldYear, newName, newYear, t.musicName);
                  UpdateHelper.updateAlbumNameCrew(oldAlbumName, oldYear, newName, newYear, t.musicName);
                  // remove all the music track for old album
                  DeleteHelper.removeMusic(oldAlbumName, t.musicName);
                }
              } else if (changedy){ // if album year is changed
                for (MusicTrack t : tracks.values()) {
                  InserterHelper.insertAlbum(newName, newYear, t.musicName, t.language, t.type, newProducer);
                  // update all the album name in 2 other tables
                  UpdateHelper.updateAlbumNameSinger(oldAlbumName, oldYear, newName, newYear, t.musicName);
                  UpdateHelper.updateAlbumNameCrew(oldAlbumName, oldYear, newName, newYear, t.musicName);
                  // remove all the music track for old album
                  DeleteHelper.removeMusicByYear(oldAlbumName, oldYear, t.musicName);
                }
              }
              JOptionPane.showMessageDialog(null, "Album has been updated", "Update album successfully", JOptionPane.INFORMATION_MESSAGE);
              CardLayout c = (CardLayout)(frame.getContentPane().getLayout());
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
        JList list = (JList)evt.getSource();
        if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2) {
            // Double-click detected
          int index = list.locationToIndex(evt.getPoint());
          String musicName = model.getElementAt(index);
          MusicTrack mt = tracks.get(musicName);
          CreateFrameMusicTrack createFrame = new CreateFrameMusicTrack(mt);
        }
        if(evt.getButton() == MouseEvent.BUTTON3 && evt.getClickCount() == 2) {
          int dialogButton = JOptionPane.YES_NO_OPTION;
          int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to delete this music track?","Comfirm",dialogButton);
          if(dialogResult == JOptionPane.YES_OPTION){
            // get the music track, delete it
            int index = list.locationToIndex(evt.getPoint());
            String musicName = model.getElementAt(index);
            MusicTrack mt = tracks.get(musicName);
            try {
              con.setAutoCommit(false);
              DeleteHelper.removeOneMusicTrack(oldAlbum, mt);
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
            JOptionPane.showMessageDialog(null, "Music track has been removed", "Remove successfully", JOptionPane.INFORMATION_MESSAGE);
          }
        }
      }
    });
    
    JLabel lblDoubleRightClick = new JLabel("Double right click the music track can removed from this album.");
    GroupLayout gl_updateAlbum = new GroupLayout(updateAlbum);
    gl_updateAlbum.setHorizontalGroup(
      gl_updateAlbum.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_updateAlbum.createSequentialGroup()
          .addGroup(gl_updateAlbum.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_updateAlbum.createSequentialGroup()
              .addGap(52)
              .addComponent(lblUpdateByChanging))
            .addGroup(gl_updateAlbum.createSequentialGroup()
              .addGap(52)
              .addGroup(gl_updateAlbum.createParallelGroup(Alignment.LEADING)
                .addComponent(label_23)
                .addComponent(lblThereShouldBe_1)
                .addComponent(lblDoubleRightClick)))
            .addGroup(gl_updateAlbum.createSequentialGroup()
              .addGap(289)
              .addComponent(label_25)
              .addGap(39)
              .addComponent(textField, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE))
            .addGroup(gl_updateAlbum.createSequentialGroup()
              .addGap(195)
              .addGroup(gl_updateAlbum.createParallelGroup(Alignment.LEADING)
                .addComponent(upAddBtn)
                .addGroup(gl_updateAlbum.createSequentialGroup()
                  .addComponent(button_6)
                  .addGap(18)
                  .addComponent(button_7))
                .addComponent(label_26)
                .addGroup(gl_updateAlbum.createParallelGroup(Alignment.LEADING, false)
                  .addComponent(upTrackList, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addGroup(gl_updateAlbum.createSequentialGroup()
                    .addGroup(gl_updateAlbum.createParallelGroup(Alignment.LEADING, false)
                      .addComponent(label_27, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                      .addComponent(label_28)
                      .addComponent(label_29))
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addGroup(gl_updateAlbum.createParallelGroup(Alignment.LEADING, false)
                      .addComponent(upProducerTx)
                      .addComponent(upYearTx)
                      .addComponent(upAlbumTx, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)))))))
          .addContainerGap(102, Short.MAX_VALUE))
    );
    gl_updateAlbum.setVerticalGroup(
      gl_updateAlbum.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_updateAlbum.createSequentialGroup()
          .addGap(38)
          .addComponent(lblUpdateByChanging)
          .addGap(11)
          .addComponent(lblThereShouldBe_1)
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addComponent(label_23)
          .addGap(13)
          .addComponent(lblDoubleRightClick)
          .addGap(18)
          .addGroup(gl_updateAlbum.createParallelGroup(Alignment.BASELINE)
            .addComponent(label_27)
            .addComponent(upAlbumTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addGroup(gl_updateAlbum.createParallelGroup(Alignment.BASELINE)
            .addComponent(label_28)
            .addComponent(upYearTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addGroup(gl_updateAlbum.createParallelGroup(Alignment.BASELINE)
            .addComponent(label_29)
            .addComponent(upProducerTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(30)
          .addComponent(label_26)
          .addGap(18)
          .addComponent(upTrackList, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
          .addGap(27)
          .addComponent(upAddBtn)
          .addGap(84)
          .addGroup(gl_updateAlbum.createParallelGroup(Alignment.BASELINE)
            .addComponent(button_7)
            .addComponent(button_6))
          .addGap(55)
          .addGroup(gl_updateAlbum.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_updateAlbum.createSequentialGroup()
              .addGap(376)
              .addComponent(label_25))
            .addGroup(gl_updateAlbum.createSequentialGroup()
              .addGap(373)
              .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
          .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    updateAlbum.setLayout(gl_updateAlbum);
    
    JPanel updateMovie = new JPanel();
    frame.getContentPane().add(updateMovie, "updateMovie");
    
    JLabel label_12 = new JLabel("There should be at least one people for each role. At most 10 for cast, at most 3 otherwise.");
    
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
        if (upMovieNameTx.getText().equals("") || upMovieYearTx.getText().equals("") || checkHelper.checkIfEmptyCrew(crews)) {
          JOptionPane.showMessageDialog(null, "Please fill in all the fields with at least one people in each role", "Insert movie - incomplete input", JOptionPane.ERROR_MESSAGE);
        } else if (year < 0) {
          JOptionPane.showMessageDialog(null, "Year in wrong range", "Insert movie - wrong range", JOptionPane.ERROR_MESSAGE);
        } else {
          // get all the input
          movieName = upMovieNameTx.getText();
          boolean changedn = false, changedy = false, valid = true;
          // delete all the movieCrew, insert all the crew in tempcrew
          try {
            con.setAutoCommit(false);
            // delete movie crew and award
            DeleteHelper.removeMovieCrew(oldMovie.getMovieName());
            DeleteHelper.removeMovieAward(oldMovie.getMovieName());
            // if movie name / year is changed
            if (!oldMovie.compareMovie(movieName)) {
              changedn = true;
            } if (!oldMovie.compareYear(year)) {
              changedy = true;
            }
            // check if movie name already exist if changed
            if (changedy && !changedn) {
              // just update the year
              UpdateHelper.updateMovieInfo(oldMovie.getMovieName(), movieName, year);
            } else if (changedn) {
              if (!checkHelper.movieExist(movieName)) {
                UpdateHelper.updateMovieInfo(oldMovie.getMovieName(), movieName, year);
              } else {
                valid = false;
                JOptionPane.showMessageDialog(null, "Movie already exist", "Update movie - movie exist", JOptionPane.ERROR_MESSAGE);
              }
            }
            
            if (valid) {
              InserterHelper.insertCrewMember(movieName, year, tempcrew);
              InserterHelper.insertAward(movieName, year, tempcrew);
            }
            
            con.commit();
            JOptionPane.showMessageDialog(null, "Movie updated", "Update movie successfully", JOptionPane.INFORMATION_MESSAGE);
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
          
          CardLayout c = (CardLayout)(frame.getContentPane().getLayout());
          c.show(frame.getContentPane(), "mainPage");
        
        }
      }
    });
    
    JButton button_8 = new JButton("Cancel");
    button_8.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        CardLayout c = (CardLayout)(frame.getContentPane().getLayout());
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
    gl_updateMovie.setHorizontalGroup(
      gl_updateMovie.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_updateMovie.createSequentialGroup()
          .addGap(68)
          .addGroup(gl_updateMovie.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_updateMovie.createSequentialGroup()
              .addComponent(button_10, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
              .addContainerGap())
            .addGroup(gl_updateMovie.createSequentialGroup()
              .addGroup(gl_updateMovie.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_updateMovie.createParallelGroup(Alignment.LEADING, false)
                  .addGroup(gl_updateMovie.createSequentialGroup()
                    .addComponent(label_16, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(upMovieYearTx))
                  .addGroup(gl_updateMovie.createSequentialGroup()
                    .addComponent(label_17, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                    .addGap(23)
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
              .addContainerGap(110, GroupLayout.PREFERRED_SIZE))))
    );
    gl_updateMovie.setVerticalGroup(
      gl_updateMovie.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_updateMovie.createSequentialGroup()
          .addGap(40)
          .addComponent(label_13)
          .addGap(18)
          .addComponent(label_12)
          .addGap(18)
          .addGroup(gl_updateMovie.createParallelGroup(Alignment.TRAILING)
            .addGroup(gl_updateMovie.createSequentialGroup()
              .addGroup(gl_updateMovie.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_updateMovie.createSequentialGroup()
                  .addGap(3)
                  .addComponent(label_17))
                .addComponent(upMovieNameTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
              .addGroup(gl_updateMovie.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_updateMovie.createSequentialGroup()
                  .addGap(30)
                  .addComponent(label_16))
                .addGroup(gl_updateMovie.createSequentialGroup()
                  .addGap(27)
                  .addComponent(upMovieYearTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
              .addGap(34)
              .addComponent(label_14)
              .addGap(18)
              .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
              .addGap(18)
              .addComponent(button_10)
              .addGap(68)
              .addGroup(gl_updateMovie.createParallelGroup(Alignment.BASELINE)
                .addComponent(button_8)
                .addComponent(button_5)))
            .addGroup(gl_updateMovie.createSequentialGroup()
              .addComponent(label_15)
              .addGap(18)
              .addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
              .addGap(136)))
          .addContainerGap(50, Short.MAX_VALUE))
    );
    
    JList upCastList = new JList();
    upCastList.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent evt) {
          JList list = (JList)evt.getSource();
          if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2) {
            // Double-click detected
            int index = list.locationToIndex(evt.getPoint());
            MovieCrew mc = null;
            String[] modelString = model2.getElementAt(index).split("---");
            String crewName = modelString[0];
            for (MovieCrew m: tempcrew.get("cast")) {
              if (m.compareName(crewName)) {
                 mc = m;
                 break;
              }
            }
            CreateFrameMovieCrew createFrame = new CreateFrameMovieCrew(mc);
          }
          if(evt.getButton() == MouseEvent.BUTTON3 && evt.getClickCount() == 2) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to delete this movie crew?","Comfirm",dialogButton);
            if(dialogResult == JOptionPane.YES_OPTION){
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
                    JOptionPane.showMessageDialog(null, "Movie cast has been removed", "Remove successfully", JOptionPane.INFORMATION_MESSAGE);
                    break;
                  }
                }
              } else {
                JOptionPane.showMessageDialog(null, "You should have at least one cast for each movie", "Remove fail", JOptionPane.ERROR_MESSAGE);
              }
              
//              try {
//                con.setAutoCommit(false);
//                DeleteHelper.removeOneMusicTrack(oldAlbum, mt);
//              } catch (SQLException e) {
//                try {
//                  con.rollback();
//                } catch (SQLException e1) {
//                  e1.printStackTrace();
//                }
//                System.out.println("rollback");
//                e.printStackTrace();
//              } finally {
//                try {
//                  con.setAutoCommit(true);
//                } catch (SQLException e) {
//                  e.printStackTrace();
//                }
//              }
              // update the tracks and album music tracks list
              
            }
          }
      }
    });
    
    scrollPane_2.setViewportView(upCastList);
    
    JList upCrewList = new JList();
    upCrewList.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent evt) {
          JList list = (JList)evt.getSource();
          if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2) {
            // Double-click detected
            int index = list.locationToIndex(evt.getPoint());
            MovieCrew mc = null;
            String[] modelString = model.getElementAt(index).split("---");
            String crewName = modelString[0];
            for (List<MovieCrew> crewlist: tempcrew.values()) {
              for (MovieCrew m: crewlist)
              if (m.compareName(crewName)) {
                 mc = m;
                 break;
              }
            }
            CreateFrameMovieCrew createFrame = new CreateFrameMovieCrew(mc);
          }
          if(evt.getButton() == MouseEvent.BUTTON3 && evt.getClickCount() == 2) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to delete this crew?","Comfirm",dialogButton);
            if(dialogResult == JOptionPane.YES_OPTION){
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
                    JOptionPane.showMessageDialog(null, "Movie cast has been removed", "Remove successfully", JOptionPane.INFORMATION_MESSAGE);
                    break;
                  }
                }
              } else {
                JOptionPane.showMessageDialog(null, "You should have at least one cast for each movie", "Remove fail", JOptionPane.ERROR_MESSAGE);
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
              JOptionPane.showMessageDialog(null, "please enter valid information", "View - wrong infomation", JOptionPane.ERROR_MESSAGE);
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
        btnCancel.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            clearViewFields();
          }
        });
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
		gl_AddMusicTrackPanel.setHorizontalGroup(
		  gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING)
		    .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
		      .addGap(149)
		      .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING, false)
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
		          .addComponent(insMusicTx))
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
		      .addContainerGap(325, Short.MAX_VALUE))
		);
		gl_AddMusicTrackPanel.setVerticalGroup(
		  gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING)
		    .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
		      .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
		          .addGap(60)
		          .addComponent(label_4))
		        .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
		          .addGap(57)
		          .addComponent(insMusicTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
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
		      .addContainerGap(224, Short.MAX_VALUE))
		);
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
          .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_AddMovieCrewPanel.createSequentialGroup()
              .addComponent(rdbtnMale)
              .addGap(18)
              .addComponent(rdbtnFemale))
            .addComponent(insCastNameTx, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
            .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.TRAILING)
              .addGroup(gl_AddMovieCrewPanel.createSequentialGroup()
                .addComponent(button, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
                .addGap(48)
                .addComponent(button_4, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
              .addComponent(insRoleTx, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE))
            .addGroup(gl_AddMovieCrewPanel.createSequentialGroup()
              .addPreferredGap(ComponentPlacement.RELATED)
              .addComponent(chckbxTickIfYes)))
          .addContainerGap(734, Short.MAX_VALUE))
    );
    gl_AddMovieCrewPanel.setVerticalGroup(
      gl_AddMovieCrewPanel.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_AddMovieCrewPanel.createSequentialGroup()
          .addGap(64)
          .addComponent(label_3)
          .addGap(16)
          .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblName)
            .addComponent(insCastNameTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(18)
          .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblRole)
            .addComponent(insRoleTx, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE))
          .addGap(18)
          .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblGender)
            .addComponent(rdbtnMale)
            .addComponent(rdbtnFemale))
          .addGap(22)
          .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblGotAward)
            .addComponent(chckbxTickIfYes))
          .addGap(18)
          .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.LEADING)
            .addComponent(button)
            .addComponent(button_4))
          .addContainerGap(469, Short.MAX_VALUE))
    );
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
        	  // clear the musicTrack list
        	  musicTracks.clear();
          }
        });
		mnInsert.add(mntmAlbum);
		
		JMenuItem mntmMovie = new JMenuItem("Movie");
		mntmMovie.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {
          crews.clear();
      	  for (String role: movieCastRoles) {
            crews.put(role, new ArrayList<MovieCrew>());
          }
      	  // go to insert book page
          CardLayout c = (CardLayout)(frame.getContentPane().getLayout());
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
        for (String role: movieCastRoles) {
          crews.put(role, new ArrayList<MovieCrew>());
          tempcrew.put(role, new ArrayList<MovieCrew>());
        }
        
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
            List<String> oldAuthors = new ArrayList<String>();
            List<String> oldKeywords = new ArrayList<String>();
            String isbn = SelectHelper.getBookIsbn(name);
            bookResult = SelectHelper.getBookInfo(isbn);
//            try {
//              System.out.println(bookResult.getObject("EditionNumber") + " hi");
//              System.out.println(bookResult.getObject("EditionNumber") == null);
//            } catch (SQLException e2) {
//              // TODO Auto-generated catch block
//              e2.printStackTrace();
//            }
            bookKeyword = SelectHelper.getBookKeyword(isbn);
            bookAuthors = SelectHelper.getBookAuthorName(isbn);
            // show data textfield
            try {
              upBookTitleTx.setText(bookResult.getString("Title"));
              upISBN.setText(bookResult.getString("ISBN"));
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
              oldBook = new Book(bookResult.getString("Title"), bookResult.getString("ISBN"), bookResult.getString("Publisher"),
                  bookResult.getString("Abstract"), bookResult.getInt("YearOfPublication"), bookResult.getInt("NumberOfPages"),
                  bookResult.getInt("EditionNumber"), oldAuthors, oldKeywords);
            } catch (SQLException e1) {
              e1.printStackTrace();
            }
          } else if(checkHelper.albumExist(name)) {
            CardLayout c = (CardLayout)(frame.getContentPane().getLayout());
            c.show(frame.getContentPane(), "updateAlbum"); 
            clearUpdateAlbum();// clear the album object
            // get data set
            ResultSet albumResult = null, tracksResult = null;
            String albumName = null, producer = null;
            int year = -1;
//            Map<String, MusicTrack> tracks = new HashMap<String, MusicTrack>();
            albumResult = SelectHelper.getAlbumInfo(name);
            albumName = name;
            
            String musicName = null, language = null;
//            diskType type1;
            List<String> singers = new ArrayList<String>();
            Map<String, String> trackCrews = new HashMap<String, String>();
            try {
              year = albumResult.getInt("year");
              producer = SelectHelper.getPeopleName(albumResult.getInt("producer_id"));
              
              // get track objects
              tracksResult = SelectHelper.getAlbumMusics(name);
              while(tracksResult.next()) {
                // get musicname
                musicName = tracksResult.getString("MusicName");
                // get language
                language = tracksResult.getString("language");
                // get disktype
                boolean tempbool = tracksResult.getBoolean("diskType");
                diskType type1 = checkHelper.checkDiskType(tracksResult.getBoolean("diskType"));
                // get singers name
                singers = SelectHelper.getSingersList(albumName, musicName);
                // get crews name
                trackCrews = SelectHelper.getTrackCrewName(name, tracksResult.getString("MusicName"));
                diskType temptype = type1;
                // make a new MusicTrack object
                MusicTrack mt = new MusicTrack(musicName, language, ((type1 == diskType.AUDIOCD) ? diskType.AUDIOCD:diskType.VINYL), singers.get(0), ((singers.size() == 2) ? singers.get(1) : null),
                    trackCrews.get("songwriter"), trackCrews.get("composer"), trackCrews.get("arranger"));
                // add it to an arraylist for showing in the JList
                tracks.put(musicName, mt);
              }
              
              // set textfield values
              upAlbumTx.setText(albumName);
              upYearTx.setText(String.valueOf(year));
              upProducerTx.setText(producer);
              for (String trackName: tracks.keySet()) {
                model.addElement(trackName);
              }
              upTrackList.setModel(model);
              
              // make an album object
              oldAlbum = new Album(albumName, producer, year, tracks);
            } catch (SQLException e1) {
              e1.printStackTrace();
            }
            
                        
          } else if (checkHelper.movieExist(name)) {
            CardLayout c = (CardLayout)(frame.getContentPane().getLayout());
            c.show(frame.getContentPane(), "updateMovie");
//            clearUpdateMovie();
            // get data set
            ResultSet movieResult = null, crewIdsResult = null, crewResult = null;
            String movieName = null;
            int year = -1;
//            Map<String, MusicTrack> tracks = new HashMap<String, MusicTrack>();
            movieResult = SelectHelper.getMovieInfo(name);
            crewIdsResult = SelectHelper.getMovieCrewIds(name);
            movieName = name;
            
            String role = null;
            MovieCrew mc = null;
            String crewname = null;
            Boolean gender = false, award = false;
            int roleid = -1, pid = -1;
            try {
              year = movieResult.getInt("year");
              // get crew objects
              while(crewIdsResult.next()) {
                // get the pid and roleid and the crewInfo
                pid = crewIdsResult.getInt("id");
                roleid = crewIdsResult.getInt("role_id");
                crewResult = SelectHelper.getMovieCrewInfo(name, pid);
                // get the crew actual info
                crewname = SelectHelper.getPeopleName(pid);
                gender = crewResult.getBoolean("gender");
                award = crewResult.getBoolean("award");
                mc = new MovieCrew(crewname, gender, award, roleid);
                // add moviecrew object to corresponding list of the role
                role = SelectHelper.getMovieRoleName(roleid).toLowerCase();
                crews.get(role).add(mc);
                tempcrew.get(role).add(mc);
              }
              
              // set textfield values
              upMovieNameTx.setText(movieName);
              upMovieYearTx.setText(String.valueOf(year));
              for (String r: crews.keySet()) {
                for (MovieCrew m: crews.get(r)) {
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
		mntmRFrequent.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        ResultSet rs = null;
        rs = ReportHelper.createR4Report();
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
		mntmRAward.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        ResultSet rs = null;
        rs = ReportHelper.createR7Report();
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
    for (String role: movieCastRoles) {
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
    public static List<diskType> getIteration() {
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
	
	public enum MovieRole {
    DIRECTOR {

      @Override
      public String getString() {
        return "director";
      }

      @Override
      public MovieRole getEnum() {
        return DIRECTOR;
      }

      @Override
      public int getRoleId() {
        return SelectHelper.getRoleID("director");
      }
      
    }, SCRIPTWRITER {

      @Override
      public String getString() {
        return "script writer";
      }

      @Override
      public MovieRole getEnum() {
        return SCRIPTWRITER;
      }

      @Override
      public int getRoleId() {
        return SelectHelper.getRoleID("script writer");
      }
      
    }, CAST {

      @Override
      public String getString() {
        return "cast";
      }

      @Override
      public MovieRole getEnum() {
        return CAST;
      }

      @Override
      public int getRoleId() {
        return SelectHelper.getRoleID("cast");
      }
      
    }, PRODUCER {

      @Override
      public String getString() {
        return "producer";
      }

      @Override
      public MovieRole getEnum() {
        return PRODUCER;
      }

      @Override
      public int getRoleId() {
        return SelectHelper.getRoleID("producer");
      }
      
    }, COMPOSER {

      @Override
      public String getString() {
        return "composer";
      }

      @Override
      public MovieRole getEnum() {
        return COMPOSER;
      }

      @Override
      public int getRoleId() {
        return SelectHelper.getRoleID("composer");
      }
      
    }, EDITOR {

      @Override
      public String getString() {
        return "editor";
      }

      @Override
      public MovieRole getEnum() {
        return EDITOR;
      }

      @Override
      public int getRoleId() {
        return SelectHelper.getRoleID("editor");
      }
      
    }, COSTUMEDESIGNER {

      @Override
      public String getString() {
        return "costume designer";
      }

      @Override
      public MovieRole getEnum() {
        return COSTUMEDESIGNER;
      }

      @Override
      public int getRoleId() {
        return SelectHelper.getRoleID("costume designer");
      }
      
    };
    
    public abstract String getString();
    public abstract MovieRole getEnum();
    public abstract int getRoleId();
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
	  
	  public static void insertOneBookAuthor(String isbn, String author) throws SQLException {
	    String sql = "insert into Bookauthor values (?,?);";
      int count = 0;
      PreparedStatement preparedStatement;
      int pplID = -1;
      pplID = SelectHelper.getPeopleID(author);
      if (pplID == -1) {
        // add new author
        pplID = InserterHelper.insertNewPeople(author);
      }
        // insert author after found/added
        preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, isbn);
        preparedStatement.setInt(2, pplID);
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
          // add new author
          pplID = InserterHelper.insertNewPeople(author);
          if (pplID == -1) {
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
        throw new SQLException();
      }
	  }
	  
	  public static void insertBookAuthor(String isbn, Set<String> authors) throws SQLException {
      String sql = "insert into Bookauthor values (?,?);";
      int count = 0;
      PreparedStatement preparedStatement;
      int pplID = -1;
      for (String author : authors) {
        pplID = SelectHelper.getPeopleID(author);
        if (pplID == -1) {
          // add new author
          pplID = InserterHelper.insertNewPeople(author);
          if (pplID == -1) {
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
	  
	  public static void insertBookKeyword(String isbn, List<String> keywords) throws SQLException {
      String sql = "insert into BookKeyword values (?,?);";
      List<String> newKeywords = new ArrayList<String>();
      int id = -1;
      String[] stringArray = {};
      PreparedStatement preparedStatement;
      preparedStatement = con.prepareStatement(sql);
      preparedStatement.setString(1, isbn);
      for (String key : keywords) {
        id = SelectHelper.getKeywordID(key);
        if (id < 0) {
          newKeywords.add(key);
        }
      }
      stringArray = newKeywords.toArray(new String[newKeywords.size()]);

      // insert all the new keywords to keyword table
      InserterHelper.insertKeyword(isbn, stringArray);
      // insert all the keywords to bookkeyword table
      for (String key: keywords) {
        id = SelectHelper.getKeywordID(key);
        preparedStatement.setInt(2,id);
        preparedStatement.executeUpdate();        
      }
      
      
//      if (stringArray.length > 0) {
//        InserterHelper.insertKeyword(isbn, stringArray);
//      }
//      for (String key : keywords) {
//        id = SelectHelper.getKeywordID(key);
//        preparedStatement.setInt(2, id);
//        preparedStatement.executeUpdate(); 
//      }
      
    }
	  
	  public static void insertKeyword(String isbn, String[] keywords) throws SQLException {
	    int keyID = -1;
	    String sql = "insert into Keyword (tag) values (?);";
	    PreparedStatement preparedStatement;
	    if (keywords != null) {
        for (String keyword : keywords) {
//          nextKeyID = SelectHelper.getNextKeywordID();
          keyID = SelectHelper.getKeywordID(keyword);
          if (keyID < 0){
            preparedStatement = con.prepareStatement(sql);
//            preparedStatement.setInt(1, nextKeyID);
            preparedStatement.setString(1, keyword);
            preparedStatement.executeUpdate();
//            keyID = nextKeyID;
            keyID = SelectHelper.getKeywordID(keyword);
          }
//          insertBookKeyword(isbn, keyID);
        }
	    }
	  }
	  
	  public static int insertNewPeople(String fullname) throws SQLException {
//	    int nextID = SelectHelper.getNextPeopleID();
	    String first=null, mid=null, last = null;
	    String[] name = fullname.split(" ");
//	    if (nextID > 0) {
	      if (name.length == 2) {
	        first = name[0];
	        last = name[1];
	      } else if (name.length >= 3) {
	        first = name[0];
	        mid = name[1];
	        last = name[2];
	      }
	      if (name.length >= 2) {
	        // insert new author
	        String sql = "insert into PeopleInvolved (firstname, middlename, familyname, gender) values (?,?,?,?);";
	        try {
	          PreparedStatement preparedStatement;
	          preparedStatement = con.prepareStatement(sql);
	          preparedStatement.setString(1, first);
	          preparedStatement.setString(2, mid);
	          preparedStatement.setString(3, last);
	          preparedStatement.setString(4, null);
	          preparedStatement.executeUpdate();
	          return SelectHelper.getPeopleID(fullname);
	        } catch (SQLException e) {
	          e.printStackTrace();
	        }
	      }
//	    }
	    return -1;
	  }
	  
	  public static int insertNewPeople(MovieCrew crew) throws SQLException {
//      int nextID = SelectHelper.getNextPeopleID();
      String first=null, mid=null, last = null, fullname = null;
      String[] name = crew.getCrewName().split(" ");
    
      if (name.length == 2) {
        first = name[0];
        last = name[1];
        fullname = first + " " + last;
      } else if (name.length >= 3) {
        first = name[0];
        mid = name[1];
        last = name[2];
        fullname = first + " " + mid + " " + last;
      }
      if (name.length >= 2) {
        // insert new author
        String sql = "insert into PeopleInvolved (firstname, middlename, familyname, gender) values (?,?,?,?);";
        try {
          PreparedStatement preparedStatement;
          preparedStatement = con.prepareStatement(sql);
//            preparedStatement.setInt(1, nextID);
          preparedStatement.setString(1, first);
          preparedStatement.setString(2, mid);
          preparedStatement.setString(3, last);
          preparedStatement.setBoolean(4, crew.getGender());
          preparedStatement.executeUpdate();
          return SelectHelper.getPeopleID(fullname);
        } catch (SQLException e) {
          e.printStackTrace();
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
	   
	   public static void insertMusicSinger(String albumName, int year, String musicName, String sname) throws SQLException {
	     String sql = "insert into MusicSinger values (?,?,?,?);";
	     int id = SelectHelper.getPeopleID(sname);
	     if (id < 0) {
	       id = InserterHelper.insertNewPeople(sname);
	     }
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
	   
	   public static void insertMusicPeopleInvolved(String albumName, int year, String musicName, String name, int sw, int c, int a) throws SQLException {
       String sql = "insert into PeopleInvolvedMusic values (?,?,?,?,?,?,?);";
       int id = SelectHelper.getPeopleID(name);
       if (id < 0) {
         id = InserterHelper.insertNewPeople(name);
         if (id < 0) {
           throw new SQLException();
         }
       }
       PreparedStatement ps;
        ps = con.prepareStatement(sql);
        ps.setString(1, albumName);
        ps.setInt(2, year);
        ps.setString(3, musicName);
        ps.setInt(4, id);
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
	   public static void insertAward(String movieName, int movieYear, Map<String, List<MovieCrew>> crews) throws SQLException {
	     String sql = "insert ignore into award values (?,?,?,?);";
	     PreparedStatement ps;
       ps = con.prepareStatement(sql);
       ps.setString(2, movieName);
       ps.setInt(3, movieYear);
       for (List<MovieCrew> list : crews.values()) {
         for (MovieCrew crew: list) {
           ps.setInt(1, crew.getPeopleID());
           ps.setBoolean(4, crew.getAward());
           ps.executeUpdate();
         }
       }
	   }
	   
	   public static void insertAward(String movieName, int movieYear, MovieCrew mc) throws SQLException {
       String sql = "insert ignore into award values (?,?,?,?);";
       PreparedStatement ps;
       ps = con.prepareStatement(sql);
       ps.setString(2, movieName);
       ps.setInt(3, movieYear);
       ps.setInt(1, mc.getPeopleID());
       ps.setBoolean(4, mc.getAward());
       ps.executeUpdate();
     }
	   
	  public static void insertCrewMember(String movieName, int movieYear, Map<String, List<MovieCrew>> crews) throws SQLException {
	    String sql = "insert into CrewMember values (?,?,?,?);";  
	    PreparedStatement ps;
	    int id = -1;
      ps = con.prepareStatement(sql);
      ps.setString(2, movieName);
      ps.setInt(3, movieYear);
      for (List<MovieCrew> list : crews.values()) {
        for (MovieCrew crew: list) {
          // get peopleID for people
          id = crew.getPeopleID();
          if (id < 0) {
            id = InserterHelper.insertNewPeople(crew);
            if (id < 0) {
              throw new SQLException();
            }
          }
          ps.setInt(1, id);
          // for each role the person has 
          ps.setInt(4, crew.getRoleID());
          ps.executeUpdate();
        }
      }
	  }
	  
	  public static void insertCrewMember(String movieName, int movieYear, MovieCrew mc) throws SQLException {
      String sql = "insert into CrewMember values (?,?,?,?);";  
      PreparedStatement ps;
      ps = con.prepareStatement(sql);
      // get peopleID for people
      ps.setInt(1, mc.getPeopleID());
      ps.setString(2, movieName);
      ps.setInt(3, movieYear); 
      ps.setInt(4, mc.getRoleID());
      ps.executeUpdate();
    }
	  
	}
	
	public static class checkHelper {
	  
	  public static boolean checkIfEmptyCrew(Map<String, List<MovieCrew>> crews) {
	    for (List<MovieCrew> list : crews.values()) {
	      if (list.isEmpty()) {
	        return true;
	      }
	    }
	    return false;
	  }
	  public static boolean duplicateAuthor(String name, List<String> newAuthors) {
	    for (String a: newAuthors) {
        if (a.equalsIgnoreCase(name)) {
          return true;
        }
	    }
      return false;
    }
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
	   
	   public static diskType checkDiskType(Boolean type) {
	     // 0-> CD, 1 -> vinyl
	     if (type) {
	       return diskType.VINYL;
	     } else {
	       return diskType.AUDIOCD;
	     }
	   }
	   
	   public static int checkNumRoleMusic(String albumName, String musicName, String name) {
	     int id = SelectHelper.getPeopleID(name);
	     int num = SelectHelper.getNumRoleMusic(albumName, musicName, name);
	     return num;
	   }
	   
	   public static boolean checkMusicCrewExist(String albumName, String musicName, String name) {
	     int id = SelectHelper.getPeopleID(name);
	     if (id < 0) {
	       return false;
	     }
	     boolean exist = SelectHelper.checkMusicCastExist(albumName, musicName, name);
	     return exist;
	   }
	}
	
	public static class DeleteHelper {
	  
	  public static void deleteOneBookAuthor(String isbn, String author) throws SQLException {
	    int id = -1;
      String sql = "delete from BookAuthor where isbn = ? and author_id = ?;";
      PreparedStatement preparedStatement;
      preparedStatement = con.prepareStatement(sql);
      preparedStatement.setString(1, isbn);
      id = SelectHelper.getPeopleID(author);
      if (id > 0) {
        preparedStatement.setInt(2, id);
        preparedStatement.executeUpdate();
      }
	  }
	  public static void deleteBookAuthors(String isbn, List<String> authors) throws SQLException {
	    int id = -1;
	    String sql = "delete from BookAuthor where isbn = ? and author_id = ?;";
	    PreparedStatement preparedStatement;
      preparedStatement = con.prepareStatement(sql);
      preparedStatement.setString(1, isbn);
	    for (String author : authors) {
	      id = SelectHelper.getPeopleID(author);
	      if (id > 0) {
	        preparedStatement.setInt(2, id);
	        preparedStatement.executeUpdate();
	      }
	    }
	  }
	  
	  public static void deleteBookKeywords(String isbn, List<String> keywords) throws SQLException {
	    int id = -1;
      String sql = "delete from BookKeyword where isbn = ? and keyword_id = ?;";
      PreparedStatement preparedStatement;
      preparedStatement = con.prepareStatement(sql);
      preparedStatement.setString(1, isbn);
      for (String key : keywords) {
        id = SelectHelper.getKeywordID(key);
        if (id > 0) {
          preparedStatement.setInt(2, id);
          preparedStatement.executeUpdate();
        }
      }
	  }
	  
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
	    
	    public static void removeMusicByYear(String albumName, int oldYear, String musicName) throws SQLException {
	      String sql = "delete from Music where AlbumName = ? and MusicName = ? and year = ?;";
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, albumName);
        preparedStatement.setString(2, musicName);
        preparedStatement.setInt(3, oldYear);
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
	    
	    public static void removeMusicSinger(String albumName, String musicName, String singer) throws SQLException {
	      String sql = "delete from musicsinger where albumname = ? and musicname = ? and peopleinvolved_id = ?;";
	      PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, albumName);
        preparedStatement.setString(2, musicName);
        preparedStatement.setInt(3, SelectHelper.getPeopleID(singer));
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
	    
	    public static void removeMusicPeopleInvolved(String albumName, String musicName, String name) throws SQLException {
        String sql = "delete from PeopleInvolvedMusic where AlbumName = ? and MusicName = ? and peopleinvolved_id = ?;";
        int id = SelectHelper.getPeopleID(name);
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, albumName);
        preparedStatement.setString(2, musicName);
        preparedStatement.setInt(3, id);
        preparedStatement.executeUpdate();
      }
	    
	    public static void removeOneMusicTrack(Album album, MusicTrack mt) throws SQLException {
	      DeleteHelper.removeMusicSingers(album.albumName, mt.musicName);
	      DeleteHelper.removeMusicPeopleInvolved(album.albumName, mt.musicName);
	      DeleteHelper.removeMusic(album.albumName, mt.musicName);
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
		 
	public static class UpdateHelper {
	  
	  public static void updateBookString(String data, String isbn, String type) throws SQLException {
	    String sql = "Update Book set " + type + " = ? where isbn = ?;";
	    PreparedStatement ps;
      ps = con.prepareStatement(sql);
      ps.setString(1, data);
      ps.setString(2, isbn);
      ps.executeUpdate();
	  }
	  
	  public static void updateMovieInfo(String oldName, String newName, int year) throws SQLException {
      String sql = "Update movie set moviename = ?, year = ? where moviename = ?;";
      PreparedStatement ps;
      ps = con.prepareStatement(sql);
      ps.setString(1, newName);
      ps.setInt(2, year);
      ps.setString(3, oldName);
      ps.executeUpdate();
    }

    public static void updateBookInt(int data, String isbn, String type) throws SQLException {
	    String sql = "Update Book set " + type + " = ? where isbn = ?;";
      PreparedStatement ps;
      ps = con.prepareStatement(sql);
      if (data == -1) {
        ps.setNull(1, java.sql.Types.NULL);
      } else {
        ps.setInt(1, data);
      }
      ps.setString(2, isbn);
      ps.executeUpdate();
	  }
	  
	  public static void updateBookAuthor(String oldauthor, String author, String isbn) throws SQLException {
	    String sql = "Update bookauthor set author_id = ? where isbn = ? and author_id = ?;";
	    int oldid = -1, newid = -1;
      PreparedStatement ps;
      
      ps = con.prepareStatement(sql);
      ps.setInt(1, newid);
      ps.setString(2, isbn);
      ps.setInt(3, oldid);
      ps.executeUpdate();
    
	  }
	  
	  public static void updateMusicTrackString(String newdata, String musicName, String category) throws SQLException {
	    // use for musicname and language
	    String sql = "Update music set " + " " + category + " = ? where musicName = ?;";
	    PreparedStatement ps;
      
      ps = con.prepareStatement(sql);
      ps.setString(1, newdata);
      ps.setString(2, musicName);
      ps.executeUpdate();
	  }
	  
	  // use when music people already in that music track
	  public static void updateMusicTrackCrewOn(String newdata, String musicName, String albumName, String role) throws SQLException {
	    String sql = "Update peopleinvolvedmusic set " + role + " = 1 where peopleinvolved_id = ? and albumname = ? and musicname = ?;";
	    PreparedStatement ps;
      int id = SelectHelper.getPeopleID(newdata);
      ps = con.prepareStatement(sql);
      ps.setInt(1, id);
      ps.setString(2, albumName);
      ps.setString(3, musicName);
      ps.executeUpdate();
	  }
	  
	  public static void updateMusicTrackCrewOff(String newdata, String musicName, String albumName, String role) throws SQLException {
      String sql = "Update peopleinvolvedmusic set " + role + " = 0 where peopleinvolved_id = ? and albumname = ? and musicname = ?;";
      PreparedStatement ps;
      int id = SelectHelper.getPeopleID(newdata);
      ps = con.prepareStatement(sql);
      ps.setInt(1, id);
      ps.setString(2, albumName);
      ps.setString(3, musicName);
      ps.executeUpdate();
    }
	  
	  public static void updateAllMusicName(String oldMusicName, String musicName, String lang, diskType t, Album album) throws SQLException {
      String albumName = album.albumName;
	    // insert the new music track
	    InserterHelper.insertAlbum(albumName, album.year, musicName, lang, t, album.producer);
	    // update other
      UpdateHelper.updateMusicNameSinger(oldMusicName, musicName, albumName);
      UpdateHelper.updateMusicNamePeople(oldMusicName, musicName, albumName);
      // delete the old music track
      DeleteHelper.removeMusic(albumName, oldMusicName);
	  }
	  
	  public static void updateMusicNameSinger(String oldMusicName, String musicName, String albumName) throws SQLException {
	    String sql = "update musicsinger set musicName = ? where albumName = ? and musicName = ?;";
	    PreparedStatement ps;
      ps = con.prepareStatement(sql);
      ps.setString(1, musicName);
      ps.setString(2, albumName);
      ps.setString(3, oldMusicName);
      ps.executeUpdate();
	  }
	  
	  public static void updateMusicNamePeople(String oldMusicName, String musicName, String albumName) throws SQLException {
      String sql = "update peopleinvolvedmusic set musicName = ? where albumName = ? and musicName = ?;";
      PreparedStatement ps;
      ps = con.prepareStatement(sql);
      ps.setString(1, musicName);
      ps.setString(2, albumName);
      ps.setString(3, oldMusicName);
      ps.executeUpdate();
    }
	  
	  public static void updateMusicProducer(String albumName, String producer) throws SQLException {
	    String sql = "update music set producer_id = ? where albumName = ?";
	    int id = SelectHelper.getPeopleID(producer);
	    if (id < 0) {
	      id = InserterHelper.insertNewPeople(producer);
	      if (id < 0) {
	        throw new SQLException();
	      }
	    }
	    PreparedStatement ps;
      ps = con.prepareStatement(sql);
      ps.setInt(1, id);
      ps.setString(2, albumName);
      ps.executeUpdate();
	  }
	  
	  public static void updateAlbumNameSinger(String oldAlbumName, int oldYear, String newName, int newYear, String musicName) throws SQLException {
	    String sql = "update musicsinger set albumname = ?, year = ? where albumname = ? and year = ? and musicname = ?";
	    PreparedStatement ps;
      ps = con.prepareStatement(sql);
      ps.setString(1, newName);
      ps.setInt(2, newYear);
      ps.setString(3, oldAlbumName);
      ps.setInt(4, oldYear);
      ps.setString(5, musicName);
      ps.executeUpdate();
	  }
	  
	  public static void updateAlbumNameCrew(String oldAlbumName, int oldYear, String newName, int newYear, String musicName) throws SQLException {
	    String sql = "update peopleinvolvedmusic set albumname = ?, year = ? where albumname = ? and year = ? and musicname = ?";
      PreparedStatement ps;
      ps = con.prepareStatement(sql);
      ps.setString(1, newName);
      ps.setInt(2, newYear);
      ps.setString(3, oldAlbumName);
      ps.setInt(4, oldYear);
      ps.setString(5, musicName);
      ps.executeUpdate();
	  }
	}

	public static class SelectHelper {
	  
	  public static String getPeopleName(int id) {
	    String sql = "SELECT CASE WHEN ISNULL(MiddleName) " + 
	        "THEN concat(firstName, ' ', familyname) "+ 
	        "ELSE concat(firstName, ' ',middlename, ' ', familyname) " + 
	        "END FullName " + 
	        "FROM peopleinvolved where id = ?;";
	    ResultSet rs = null;
	    PreparedStatement ps;
	    String name = null;
	    try {
        ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        rs.next();
        name = rs.getString("FullName");
      } catch (SQLException e) {
        e.printStackTrace();
      }
	    return name;   
	    
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

    private static ResultSet getPeopleGenderHelper(int id) {
      String sql = "select gender from peopleinvolved where id = ?;";
      ResultSet rs = null;
      PreparedStatement ps;
      try {
        ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return rs;
    }

    public static Boolean getPeopleGender(int id) {
      ResultSet rs = getPeopleGenderHelper(id);
      try {
        if (rs != null) {
          rs.next();
          return rs.getBoolean("gender");
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return null;
    }

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

    public static ResultSet getAlbumInfo(String albumName) {
	    String sql = "Select albumName, year, producer_id from music where albumName = ? group by albumName;";
	    ResultSet rs = null;
	    PreparedStatement ps;
	    try {
	      ps = con.prepareStatement(sql);
	      ps.setString(1, albumName);
	      rs = ps.executeQuery();
	      rs.next();
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
      return rs;
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
	  
	  public static ResultSet getAlbumMusics(String albumName) {
      String sql = "Select MusicName, language, disktype from music where AlbumName=?;";
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
    
    public static ResultSet getTrackCrewsRs(String albumName, String musicName) {
      String sql = "(select peopleinvolved_id, 'songwriter' role_ from peopleinvolvedmusic " + 
          "where issongwriter = 1 and albumName = ? and musicName = ?) " + 
          "union " + 
          "(select peopleinvolved_id, 'composer' role_ from peopleinvolvedmusic " + 
          "where iscomposer = 1 and albumName = ? and musicName = ?)" + 
          "union " + 
          "(select peopleinvolved_id,'arranger' role_ from peopleinvolvedmusic " + 
          "where isarranger = 1 and albumName = ? and musicName = ?);";
      ResultSet rs = null;
      PreparedStatement ps;
      try {
        ps = con.prepareStatement(sql);
        for (int i = 1; i <= 6; i = i+2) {
          ps.setString(i, albumName);
          ps.setString(i+1, musicName);
        }
        rs = ps.executeQuery();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return rs;
    }
    
    public static Map<String, String> getTrackCrewName(String albumName, String musicName) {
      ResultSet rs = SelectHelper.getTrackCrewsRs(albumName, musicName);
      Map<String, String> crews = new HashMap<String, String>(); // key: role ; value: people name
      try {
        while (rs.next()) {
          crews.put(rs.getString("role_"), SelectHelper.getPeopleName(rs.getInt("peopleinvolved_id")));
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return crews;
    }
    
    public static int getNumRoleMusic(String albumName, String musicName, String name) {
      String sql = "select (isarranger + issongwriter + iscomposer ) as num from peopleinvolvedmusic where"
          + " albumName = ? and musicname = ? and peopleinvolved_id = ?;";
      ResultSet rs = null;
      int num = -1;
      PreparedStatement ps;
      try {
        ps = con.prepareStatement(sql);
        ps.setString(1, albumName);
        ps.setString(2, musicName);
        ps.setInt(3, SelectHelper.getPeopleID(name));
        rs = ps.executeQuery();
        rs.next();
        num = rs.getInt("num");
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return num;
    }
    
    public static ResultSet getSingersRs(String albumName, String musicName) {
      String sql = "select * from musicsinger where albumName = ? and musicName = ?;";
      ResultSet rs = null;
      Set<String> singers = new HashSet<String>();
      PreparedStatement ps;
      try {
        ps = con.prepareStatement(sql);
        ps.setString(1, albumName);
        ps.setString(2, musicName);
        rs = ps.executeQuery();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return rs;
    }
    
    public static Set<String> getSingersName(String albumName, String musicName) {
      ResultSet rs = null;
      rs = SelectHelper.getSingersRs(albumName, musicName);
      String name = null;
      Set<String> singers = new HashSet<String>();
      try {
        while (rs.next()) {
          name = SelectHelper.getPeopleName(rs.getInt("peopleinvolved_id"));
          singers.add(name);
        }
      } catch (SQLException e) {
        e.printStackTrace();
      } 
      return singers;
    }
    
    public static List<String> getSingersList(String albumName, String musicName) {
      ResultSet rs = null;
      rs = SelectHelper.getSingersRs(albumName, musicName);
      String name = null;
      List<String> singers = new ArrayList<String>();
      try {
        while (rs.next()) {
          name = SelectHelper.getPeopleName(rs.getInt("peopleinvolved_id"));
          singers.add(name);
        }
      } catch (SQLException e) {
        e.printStackTrace();
      } 
      return singers;
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

    public static ResultSet getMovieInfo(String movieName) {
	    String sql = "select moviename, year from movie where movieName = ?;";
	    ResultSet rs = null;
	    PreparedStatement ps;
	    try {
        ps = con.prepareStatement(sql);
        ps.setString(1, movieName);
        rs = ps.executeQuery();
        rs.next();
      } catch (SQLException e) {
        e.printStackTrace();
      }
	    return rs;
	  }
	  
    /**
     * get all crews in that movie (pid and roleid)
     * @param movieName
     * @return rs
     */
	  public static ResultSet getMovieCrewIds(String movieName) {
	    String sql = "select peopleinvolved_id id, role_id from crewmember where moviename = ?;";
	    ResultSet rs = null;
      PreparedStatement ps;
      try {
        ps = con.prepareStatement(sql);
        ps.setString(1, movieName);
        rs = ps.executeQuery();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return rs;
	  }
	  
	  /**
	   * get one movie crew info (id, gender and award)
	   * @param movieName
	   * @param id
	   * @return rs
	   */
	  public static ResultSet getMovieCrewInfo(String movieName, int id) {
	    String sql = "select a.peopleinvolved_id, a.award, p.gender from peopleinvolved p, award a where "
	        + "p.id = a.peopleinvolved_id and a.moviename = ? and p.id = ?;";
	    ResultSet rs = null;
      PreparedStatement ps;
      try {
        ps = con.prepareStatement(sql);
        ps.setString(1, movieName);
        ps.setInt(2, id);
        rs = ps.executeQuery();
        rs.next();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return rs;
	  }
	  
	  public static String getMovieRoleName(int roleid) {
	    String sql = "select description from role where id = ?;";
	    String role = null;
	    ResultSet rs = null;
      PreparedStatement ps;
      try {
        ps = con.prepareStatement(sql);
        ps.setInt(1, roleid);
        rs = ps.executeQuery();
        rs.next();
        role = rs.getString("description");
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return role;
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

    public static boolean checkMusicCastExist(String albumName, String musicName, String name) {
       String sql = "Select count(*) from PeopleInvolvedMusic " + 
           "group by AlbumName, MusicName, PeopleInvolved_ID " + 
           "having AlbumName = ? and MusicName = ? and PeopleInvolved_ID = ?;";
       ResultSet rs = null;
       int found = -1, id = -1;
       PreparedStatement ps;
       id = SelectHelper.getPeopleID(name);
       try {
         ps = con.prepareStatement(sql);
         ps.setString(1, albumName);
         ps.setString(2, musicName);
         ps.setInt(3, id);
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
	      exist = checkHelper.checkIfTableExist(viewname);
	      if (!exist) {
	        switch (viewNames.get(viewname)) {
	          case "a":
	            success = CreateViewHelper.createViewForViewPartAuthor();
	          case "s":
              success = CreateViewHelper.createViewForViewPartSinger();
	          case "c":
              success = CreateViewHelper.createViewForViewPartCrew();
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
        // insert authors
        InserterHelper.insertBookAuthor(isbn, authors);
        // insert keywords
        InserterHelper.insertKeyword(isbn, keywords);
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
	  
	  public static boolean insertMusicTransaction(String albumName, int year, String producer, List<MusicTrack> musicTracks) {
       int pplID = -1;
       try {
         con.setAutoCommit(false);
         for (MusicTrack mt: musicTracks) {
           
           for (String s : mt.getSingers()) {
             pplID = SelectHelper.getPeopleID(s);
             if (pplID == -1) {
               // author not exist
               // add new author
               pplID = InserterHelper.insertNewPeople(s);
               if (pplID == -1) {
                 break;
               }
             }
           }
           
           for (String s : mt.getCasts()) {
             pplID = SelectHelper.getPeopleID(s);
             if (pplID == -1) {
               // author not exist
               // add new author
               pplID = InserterHelper.insertNewPeople(s);
               if (pplID == -1) {
                 break;
               }
             }
           }
           
           pplID = SelectHelper.getPeopleID(producer);
           if (pplID == -1) {
             // producer not exist
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
           
             // insert only if that piece of soundtrack is not in db
             // insert into Music table
             InserterHelper.insertAlbum(albumName, year, mt.getMusicName(), mt.getLanguage(), mt.getType(), producer);
             // insert into MusicSinger
             // only add at most 2 singers for each song
             for (int sid : mt.getSingerIDHashMap().values()) {
               // add the people is exist in peopleInvolved
               InserterHelper.insertMusicSinger(albumName, year, mt.getMusicName(), sid);
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
	  	  
	  public static void insertOneMusicTrack(String musicName, Album album, MusicTrack mt) {
         try {
          con.setAutoCommit(false);
    	     int id = -1;
    	     // insert music track
    	     InserterHelper.insertAlbum(album.albumName, album.year, musicName, mt.language, mt.type, album.producer);
    	     // insert singers
    	     id = SelectHelper.getPeopleID(mt.singer1);
    	     if (id < 0) {
    	       id = InserterHelper.insertNewPeople(mt.singer1);
    	       if (id < 0) {
    	         throw new SQLException();
    	       }
    	     }
    	     InserterHelper.insertMusicSinger(album.albumName, album.year, musicName, id);
    	     if (mt.singer2 != null) {
    	       id = SelectHelper.getPeopleID(mt.singer2);
    	       if (id < 0) {
    	         id = InserterHelper.insertNewPeople(mt.singer2);
    	         if (id < 0) {
    	           throw new SQLException();
    	         }
    	       }
    	       InserterHelper.insertMusicSinger(album.albumName, album.year, musicName, id);
    	     }
    	     
    	     // insert crews
    //	     InserterHelper.insertMusicPeopleInvolved(albumName, year, musicName, ppl, sw, c, a);
    	     
    	     
    	     Map<String, Integer> musicpeopleid = new HashMap<String, Integer>();
           musicpeopleid = mt.getCastIDHashMap();
           
           // insert into PeopleInvolvedMusic
             // check the role for each people
    
             Map<String, Integer> temprole = new HashMap<String, Integer>();
             // for each people, serach their roles in music
             for (int ppl : musicpeopleid.values()) {
               // check if this people is inserted already
               if (!SelectHelper.checkMusicCastExist(album.albumName, album.year, mt.getMusicName(), ppl)) {
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
                 InserterHelper.insertMusicPeopleInvolved(album.albumName, album.year, mt.getMusicName(), ppl, sw, c, a);
                 // reset the hashmap
                 temprole.clear();
                 sw = 0; c = 0; a= 0;
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
        id = SelectHelper.getPeopleID(mc.getCrewName()); 
        if (id < 0) {
          id = InserterHelper.insertNewPeople(mc.getCrewName());
          if (id < 0) {
            throw new SQLException();
          }
        }
        // insert crew into crewMember
        InserterHelper.insertCrewMember(mv.name, mv.year, mc);
        // insert award
        InserterHelper.insertAward(mv.name, mv.year, mc);
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
	  
    public static boolean insertMovieTransaction(String movieName, int movieYear, Map<String, List<MovieCrew>> crews) {
      try {
        con.setAutoCommit(false);
        // check if the people involved exist, insert if not
        for (List<MovieCrew> list: crews.values()) {
          for (MovieCrew crew: list) {
            if (SelectHelper.getPeopleID(crew.getCrewName()) < 0) {
              InserterHelper.insertNewPeople(crew);
            }
          }
        }
        // insert movie
        InserterHelper.insertMovie(movieName, movieYear);
        // insert crew into crewMember
        InserterHelper.insertCrewMember(movieName, movieYear, crews);
        // insert award
        InserterHelper.insertAward(movieName, movieYear, crews);
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
	  
	  public static ResultSet createR4Report() {
	 // create a view if not exist yet
      boolean exist1 = checkHelper.checkIfTableExist("bookAuthorWritten");
      boolean exist2 = checkHelper.checkIfTableExist("authorPubConsecutiveYear");
      boolean success1 = true, success2 = true;
      ResultSet rs = null;
      if(!exist1) {
        success1 = CreateViewHelper.createViewForR4BookAuthor();
      }
      if (!exist2) {
        success2 = CreateViewHelper.createViewForR4PubConsecutive();
      }
      // execute query if view exist
      if (success1 && success2) {
        String sql = "select b.isbn, b.title, CASE WHEN ISNULL(p.MiddleName)  " + 
            "THEN concat(p.firstName, ' ', p.familyname) " + 
            "ELSE concat(p.firstName, ' ',p.middlename, ' ', p.familyname) " + 
            "END author_name, b.yearofpublication " + 
            "from authorPubConsecutiveYear c, book b, bookauthor ba, peopleinvolved p " + 
            "where b.isbn = ba.isbn and p.id = ba.author_id and c.author_id = ba.author_id " + 
            "order by p.familyname, b.yearofpublication;";
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
	  
	  public static ResultSet createR5Report() {
	    // create a view if not exist yet
	    boolean exist = checkHelper.checkIfTableExist("keywordFrequency");
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
      boolean exist = checkHelper.checkIfTableExist("multiSkillsMovieCrew");
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
	  
	  public static ResultSet createR7Report() {
	    // create a view if not exist yet
	    boolean exist = checkHelper.checkIfTableExist("movieWithAward"), exist2 = checkHelper.checkIfTableExist("movieCrew");;
	    boolean success = true, success2 = true;
	    ResultSet rs = null;
	    if (!exist) {
	      success = CreateViewHelper.createViewForR7MovieAward();
	    }
	    if (!exist2) {
	      success = CreateViewHelper.createViewForR7MovieCrew();
	    }
	    // execute query if view exist
	    if (success && success2) {
	      String sql = "select cm.moviename, mc.director_name, mwa.numAward " + 
	          "from movieWithAward mwa, crewmember cm, movieCrew mc " + 
	          "where mwa.moviename = cm.moviename and mc.peopleInvolved_id = cm.peopleinvolved_id " + 
	          "and mc.description = 'director' " + 
	          "group by mc.director_name, moviename " + 
	          "order by mc.familyname;";
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
      boolean exist = checkHelper.checkIfTableExist("musicNameDupNum");
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
      boolean exist = checkHelper.checkIfTableExist("peopleOnlyNotArrangerMusic");
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
      boolean exist = checkHelper.checkIfTableExist("lnameofbook");
      boolean success = true;
      Map<String, String> viewNames = new HashMap<String, String>();
      //{"lnameofbook","lnameofmusicsinger","lnameofmusiccrews","lnameofmusicallpeople","lnameofmovie","distinctFamilyname"};
      viewNames.put("lnameofbook", "b");
      viewNames.put("lnameofmusicsinger", "mus");
      viewNames.put("lnameofmusiccrews", "muc");
      viewNames.put("lnameofmusicallpeople", "mup");
      viewNames.put("lnameofmovie", "mv");
      viewNames.put("distinctFamilyname", "d");
      ResultSet rs = null;
      for (String viewname : viewNames.keySet()) {
        exist = checkHelper.checkIfTableExist(viewname);
        if (!exist) {
          switch (viewNames.get(viewname)) {
            case "b":
              success = CreateViewHelper.createViewForR10Book();
            case "mus":
              success = CreateViewHelper.createViewForR10MusicSinger();
              success = CreateViewHelper.createViewForR10MusicCrews();
              success = CreateViewHelper.createViewForR10MusicAllPeople();
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
            "from distinctFamilyname d, lnameofmusicallpeople s, peopleinvolved p " + 
            "where s.id = p.id and d.familyname = p.familyname and s.issinger = 1 " + 
            "group by d.familyname " + 
            "union " + 
            "select d.familyname, 'arranger' role " + 
            "from distinctFamilyname d, lnameofmusicallpeople s, peopleinvolved p " + 
            "where s.id = p.id and d.familyname = p.familyname and s.isarranger = 1 " + 
            "group by d.familyname " + 
            "union " + 
            "select d.familyname, 'composer' role " + 
            "from distinctFamilyname d, lnameofmusicallpeople s, peopleinvolved p " + 
            "where s.id = p.id and d.familyname = p.familyname and s.iscomposer = 1 " + 
            "group by d.familyname " + 
            "union " + 
            "select d.familyname, 'song writer' role " + 
            "from distinctFamilyname d, lnameofmusicallpeople s, peopleinvolved p " + 
            "where s.id = p.id and d.familyname = p.familyname and s.issongwriter = 1 " + 
            "group by d.familyname " + 
            "union " + 
            "select d.familyname, r.description role " + 
            "from distinctFamilyname d, crewmember c, peopleinvolved p, role r " + 
            "where c.peopleinvolved_id = p.id and d.familyname = p.familyname and r.id = c.role_id " + 
            "group by d.familyname) result " + 
            "order by familyname;";
        PreparedStatement ps;
        try {
          ps = con.prepareStatement(sql);
          rs = ps.executeQuery(sql);
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
	    PreparedStatement ps;
      try {
        ps = con.prepareStatement(sql);
        ps.executeUpdate(sql);
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
      PreparedStatement ps;
      try {
        ps = con.prepareStatement(sql);
        ps.executeUpdate(sql);
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
      PreparedStatement ps;
      try {
        ps = con.prepareStatement(sql);
        ps.executeUpdate(sql);
        return true;
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return false;
    }
	  
	  public static boolean createViewForR4BookAuthor() {
	    String sql = "create view bookAuthorWritten as " + 
	        "select b2.isbn, b2.title, b2.YearOfPublication year, ba.author_id " + 
	        "from book b2, bookauthor ba " + 
	        "where b2.isbn = ba.isbn " + 
	        "order by yearofpublication;";
	    PreparedStatement ps;
      try {
        ps = con.prepareStatement(sql);
        ps.executeUpdate(sql);
        return true;
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return false;
	  }
	  
	  public static boolean createViewForR4PubConsecutive() {
	    String sql = "create view authorPubConsecutiveYear as " + 
	        "select distinct a.author_id " + 
	        "from bookAuthorWritten a, bookAuthorWritten b " + 
	        "where a.author_id = b.author_id and a.year = b.year-1 " + 
	        "order by a.year, b.year;";
	    PreparedStatement ps;
      try {
        ps = con.prepareStatement(sql);
        ps.executeUpdate(sql);
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
	    PreparedStatement ps;
      try {
        ps = con.prepareStatement(sql);
        ps.executeUpdate(sql);
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
      PreparedStatement ps;
      try {
        ps = con.prepareStatement(sql);
        ps.executeUpdate(sql);
        return true;
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return false;
    }
	  
	  public static boolean createViewForR7MovieAward() {
	    String sql = "create view movieWithAward as " + 
	        "select moviename, sum(award) numAward " + 
	        "from award " + 
	        "group by moviename " + 
	        "having numAward > 0;";
	    PreparedStatement ps;
      try {
        ps = con.prepareStatement(sql);
        ps.executeUpdate(sql);
        return true;
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return false;
	  }
	  
	  public static boolean createViewForR7MovieCrew() {
	    String sql = "create view movieCrew as " + 
	        "select cm.PeopleInvolved_ID, r.description, CASE WHEN ISNULL(p.MiddleName)  " + 
	        "THEN concat(p.firstName, ' ', p.familyname) " + 
	        "ELSE concat(p.firstName, ' ',p.middlename, ' ', p.familyname) " + 
	        "END 'Director_name', p.familyname " + 
	        "from crewmember cm, role r, peopleinvolved p " + 
	        "where cm.Role_ID = r.id and cm.peopleinvolved_id = p.id;";
	    PreparedStatement ps;
      try {
        ps = con.prepareStatement(sql);
        ps.executeUpdate(sql);
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
      PreparedStatement ps;
      try {
        ps = con.prepareStatement(sql);
        ps.executeUpdate(sql);
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
      PreparedStatement ps;
      try {
        ps = con.prepareStatement(sql);
        ps.executeUpdate(sql);
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
	    PreparedStatement ps;
      try {
        ps = con.prepareStatement(sql);
        ps.executeUpdate(sql);
        return true;
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return false;
	  }
	  
	  public static boolean createViewForR10MusicSinger() {
      String sql = "create view lnameofmusicsinger as " + 
          "select p.id, p.familyname, 1 'IsSinger' " + 
          "from peopleinvolved p, musicsinger m " + 
          "where p.id = m.peopleinvolved_id;";
      PreparedStatement ps;
      try {
        ps = con.prepareStatement(sql);
        ps.executeUpdate(sql);
        return true;
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return false;
    }
    
    public static boolean createViewForR10MusicCrews() {
      String sql = "create view lnameofmusiccrews as " + 
          "select p.id, p.familyname, pm.IsArranger, pm.IsComposer, pm.IsSongwriter " + 
          "from peopleinvolved p, peopleinvolvedmusic pm " + 
          "where p.id = pm.peopleinvolved_id;";
      PreparedStatement ps;
      try {
        ps = con.prepareStatement(sql);
        ps.executeUpdate(sql);
        return true;
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return false;
    }

    public static boolean createViewForR10MusicAllPeople() {
      String sql = "create view lnameofmusicallpeople as " + 
          "select distinct p.id, p.familyname, p.IsSinger, pm.IsArranger, pm.IsComposer, pm.IsSongWriter " + 
          "from lnameofmusicsinger p " + 
          "left outer join lnameofmusiccrews pm " + 
          "on p.id = pm.id;";
      PreparedStatement ps;
      try {
        ps = con.prepareStatement(sql);
        ps.executeUpdate(sql);
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
      PreparedStatement ps;
      try {
        ps = con.prepareStatement(sql);
        ps.executeUpdate(sql);
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
          "where (p.familyname in (select familyname from lnameofbook) and p.familyname in (select familyname from lnameofmusicallpeople)) " + 
          "or (p.familyname in (select familyname from lnameofbook) and p.familyname in (select familyname from lnameofmovie)) " + 
          "or (p.familyname in (select familyname from lnameofmusicallpeople) and p.familyname in (select familyname from lnameofmovie));";
      PreparedStatement ps;
      try {
        ps = con.prepareStatement(sql);
        ps.executeUpdate(sql);
        return true;
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return false;
    }
	}
	
	
	
	public static class Book {
	  private String title, isbn, publisher, bookAbstract;
	  private int year, pages, edition;
	  private List<String> authors, keywords;
	  public Book(String title, String isbn, String publisher, String bookAbstract, int year, int pages,
	  int edition, List<String> authors, List<String> keywords) {
	    this.title = title;
	    this.isbn = isbn;
	    this.publisher = publisher;
	    this.bookAbstract = bookAbstract;
	    this.year = year;
	    this.pages = pages;
	    this.edition = edition;
	    this.authors = authors;
	    this.keywords = keywords;
	  }
	  
	  public String getAbstract() {
	    return this.bookAbstract;
	  }
	  
	  public boolean compareTitle(String newTitle) {
	    if (title.equalsIgnoreCase(newTitle)) {
	      return true;
	    }
	    return false;
	  }
	  
	  public boolean compareIsbn(String newIsbn) {
	    if (isbn.equalsIgnoreCase(newIsbn)) {
	      return true;
	    }
	    return false;
	  }
	  
	  public boolean comparePublisher(String newPub) {
	    if (publisher.equalsIgnoreCase(newPub)) {
	      return true;
	    }
	    return false;
	  }
	  
	  public boolean compareAbstract(String newAbstract) {
	    if ((bookAbstract == null && newAbstract != "") || (!bookAbstract.equalsIgnoreCase(newAbstract))) {
	      return false;
	    }
	    return true;
	  }
	  
	  public boolean compareYear(int newYear) {
	    if(year == newYear) {
	      return true;
	    }
	    return false;
	  }
	  
	  public boolean comparePages(int newPages) {
	    if(pages == newPages) {
	      return true;
	    }
	    return false;
	  }
	  
	  public boolean compareEdition(int newEdition) {
	    if(edition == newEdition) {
	      return true;
	    }
	    return false;
	  }
	  
	  public boolean compareAuthor(List<String> newAuthors) {
	    // if author not in newAuthors, delete author
	    // if new author not in authors, insert author
	    for (String author: authors) {
	      if (!authors.contains(newAuthors)) {
	        return false;
	      }
	    }
	    return true;
	  }
	  
	  public boolean compareKeywords(List<String> newKeywords) {
	    // if keyword not in newKeywords, delete keyword
	    // if new keyword not in keywords, insert keyword
	    for (String keyword: keywords) {
//	      if (!keywords.contains(newKeywords)) {
//	        return false;
//	      }
	      if (!keywords.containsAll(newKeywords)) {
	        return false;
	      }
	    }
      return true;
	  }
	  
	  @Override
	  public String toString() {
	    return this.title + " " +this.isbn + " " + this.year + " " + this.edition + " " + this.pages + " " + this.publisher + " " + this.authors.get(1) + " " + this.keywords.get(2); 
	  }
	}
	
	public static class Album {
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
	    if(this.albumName.equalsIgnoreCase(newAlbum)) {
	      return true;
	    }
	    return false;
	  }
	  
	  public boolean compareProducer(String newProducer) {
	    if(this.producer.equalsIgnoreCase(newProducer)) {
	      return true;
	    }
	    return false;
	  }
	  
	  public boolean compareYear(int year) {
	    if(this.year == year) {
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
	}
	public static class MusicTrack {
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
	  
	  public void setArranger (String arr) {
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
	    singers.add(this.singer1);
	    if (singer2 != null) {
	      singers.add(this.singer2);
	    }
	    return singers;
	  }
	  
	  public Set<String> getSingersSet() {
      Set<String> singers = new HashSet<String>();
      singers.add(this.singer1);
      if (singer2 != null) {
        singers.add(this.singer2);
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
	    singerSet.add(this.singer1);
	    if (this.singer2 != null) {
	      singerSet.add(this.singer2);  
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
	}
	
	public static class Movie {
	  private String name;
	  private int year;
	  private Map<String, List<MovieCrew>> crews = new HashMap<String, List<MovieCrew>>();
	  public Movie(String name, int year, Map<String, List<MovieCrew>> crews) {
	    this.name = name;
	    this.year = year;
	    this.crews = crews;
	  }
	  
	  public String getMovieName() {
	    return this.name;
	  }
	  
	  public int getYear() {
	    return this.year;
	  }
	  
	  public Map<String, List<MovieCrew>> getCrewsMap() {
	    return this.crews;
	  }
	  
	  public List<MovieCrew> getCrewList(String crewRole) {
	    return crews.get(crewRole);
	  }
	  
	  public boolean compareMovie(String name) {
	    if (this.getMovieName().equalsIgnoreCase(name)) {
	      return true;
	    }
	    return false;
	  }
	  
	  public boolean compareYear(int year) {
	    if (this.getYear() == year) {
	      return true;
	    }
	    return false;
	  }
	  
//	  public boolean compareCrewList(String crewRole, List<MovieCrew> crewlist) {
//	    List<MovieCrew> thisList = this.getCrewList(crewRole);
//	    MovieCrew curr = null;
//	    boolean same = true;
//	    for (MovieCrew crew : crewlist) {
//	      if (crewlist.contains(crew)) {
//	        
////	        same = crew.compareAward(crew.)? 
//	      } else {
//	        same = false;
//	        break;
//	      }
//	    }
//	  }
	  
//	  publi 
	}

  public static class MovieCrew {
    private String name;
    private boolean gender, award;
    int roleid;
    public MovieCrew(String name, boolean gender, boolean award, int roleid) {
      this.name = name;
      this.gender = gender;
      this.award = award;
      this.roleid = roleid;
    }
    
    public MovieCrew get() {
      return this;
    }
    
    public String getCrewName() {
      return this.name;
    }
    
    public boolean getGender() {
      return this.gender;
    }
    
    public boolean getAward() {
      return this.award;
    }
    
    public int getRoleID() {
      return this.roleid;
    }
    
    public String getRoleName() {
      return SelectHelper.getMovieRoleName(this.roleid).toLowerCase();
    }
    
    public int getPeopleID() {
      return SelectHelper.getPeopleID(this.name);
    }
    
    @Override
    public String toString() {
      return this.name + ' ' + this.roleid;
    }
    
    public boolean compareName(String name) {
      if (this.name.equalsIgnoreCase(name)) {
        return true;
      }
      return false;
    }
    
    public boolean compareGender(boolean gender) {
      if (this.gender && !gender) {
        return false;
      }
      return true;
    }
    
    public boolean compareAward(boolean award) {
      if (this.award && !award) {
        return false;
      }
      return true;
    }
    
    public boolean compareCrew(MovieCrew newCrew) {
      boolean same = true;
      same = same && this.compareAward(newCrew.getAward());
      same = same && this.compareGender(newCrew.getGender());
      same = same && this.compareName(newCrew.getCrewName());
      return same;
    }
    
  }
	
	
	public class CreateFrameMovieCrew {
	  
	   /**
	    * for inserting a new movie crew, click through the add crew button 
	    * @param crews
	    * @param update (true if from update page, false if from insert page)
	    */
	   public CreateFrameMovieCrew(Map<String, List<MovieCrew>> crews, boolean update)
     {
       JFrame frame = new JFrame("Add movie crews");
	     frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       try 
       {
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
             JOptionPane.showMessageDialog(null, "fill in the name of the cast", "Insert movie cast - missing name", JOptionPane.ERROR_MESSAGE);
           } else if (!checkHelper.checkNameFormat(name)) {
             JOptionPane.showMessageDialog(null, "Please fill in the name in correct format", "Insert movie cast - wrong name format", JOptionPane.ERROR_MESSAGE);
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
             ///... unique name so skip?

             // check if there are still space for entering this people

             if (update) {
               // check if this music name appears in the model
//               if (model.contains(name + " " + role) || model2.contains(name + " " + role)) {
//                 JOptionPane.showMessageDialog(null, "You have entered a duplicated crew-role", "Insert movie crew - duplicated crew-role", JOptionPane.ERROR_MESSAGE);
//                 valid = false;
//               }
               for (List<MovieCrew> list: tempcrew.values()) {
                 for (MovieCrew c: list) {
                   if (c.compareName(name)) {
                     JOptionPane.showMessageDialog(null, "You have entered a duplicated crew", "Insert movie crew - duplicated crew", JOptionPane.ERROR_MESSAGE);
                     valid = false;
                   }
                 }
               }
               for (String crewRole: tempcrew.keySet()) {
                 if (crewRole.equalsIgnoreCase("cast")) {
                   // check if there are already 10 people
                   if (tempcrew.get(crewRole).size() >= 10 && role.equalsIgnoreCase(crewRole)) {
                     valid = false;
                     JOptionPane.showMessageDialog(null, "You have already entered 10 Casts", "Insert movie crew - too many cast entered", JOptionPane.ERROR_MESSAGE);
                     break;
                   }
                 } else {
                   // check if there are already 3 people
                   if (tempcrew.get(crewRole).size() >= 3 && role.equalsIgnoreCase(crewRole)) {
                     valid = false;
                     JOptionPane.showMessageDialog(null, "You have already entered 3 " + crewRole, "Insert movie crew - too many crews entered", JOptionPane.ERROR_MESSAGE);
                     break;
                   }
                 }
               }
             } else {
               for (List<MovieCrew> list: crews.values()) {
                 for (MovieCrew c: list) {
                   if (c.compareName(name)) {
                     JOptionPane.showMessageDialog(null, "You have entered a duplicated crew", "Insert movie crew - duplicated crew", JOptionPane.ERROR_MESSAGE);
                     valid = false;
                   }
                 }
               }
               for (String crewRole: crews.keySet()) {
                 if (crewRole.equalsIgnoreCase("cast")) {
                   // check if there are already 10 people
                   if (crews.get(crewRole).size() >= 10 && role.equalsIgnoreCase(crewRole)) {
                     valid = false;
                     JOptionPane.showMessageDialog(null, "You have already entered 10 Casts", "Insert movie crew - too many cast entered", JOptionPane.ERROR_MESSAGE);
                     break;
                   }
                 } else {
                   // check if there are already 3 people
                   if (crews.get(crewRole).size() >= 3 && role.equalsIgnoreCase(crewRole)) {
                     valid = false;
                     JOptionPane.showMessageDialog(null, "You have already entered 3 " + crewRole, "Insert movie crew - too many crews entered", JOptionPane.ERROR_MESSAGE);
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
                 // may have to think how to insert them when finally submit button is click on the main page
//                 TODO:TransactionHelper.insertOneCrewMember(oldMovie, mc); // insert those in tempcrew at the main menu
                 if (role.equalsIgnoreCase("cast")) {
                   model2.addElement(name + "---" + role);
                 } else {
                   model.addElement(name + "---" + role);
                 }
                 tempcrew.get(role).add(mc);
                 JOptionPane.showMessageDialog(null, "submitted", "Update movie crew - added a new crew", JOptionPane.INFORMATION_MESSAGE);
               } else {
                 crews.get(role).add(mc);
                 JOptionPane.showMessageDialog(null, "submitted", "Insert movie crew - submitted", JOptionPane.INFORMATION_MESSAGE);
               }
               
               // TODO: clear fields
               
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
             .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.LEADING)
               .addGroup(gl_AddMovieCrewPanel.createSequentialGroup()
                 .addComponent(rdbtnMale)
                 .addGap(18)
                 .addComponent(rdbtnFemale))
               .addComponent(insCastNameTx, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
               .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.TRAILING)
                 .addGroup(gl_AddMovieCrewPanel.createSequentialGroup()
                   .addComponent(button, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
                   .addGap(48)
                   .addComponent(button_4, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                 .addComponent(insRoleTx, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE))
               .addGroup(gl_AddMovieCrewPanel.createSequentialGroup()
                 .addPreferredGap(ComponentPlacement.RELATED)
                 .addComponent(chckbxTickIfYes)))
             .addContainerGap(734, Short.MAX_VALUE))
       );
       gl_AddMovieCrewPanel.setVerticalGroup(
         gl_AddMovieCrewPanel.createParallelGroup(Alignment.LEADING)
           .addGroup(gl_AddMovieCrewPanel.createSequentialGroup()
             .addGap(64)
             .addComponent(label_3)
             .addGap(16)
             .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.BASELINE)
               .addComponent(lblName)
               .addComponent(insCastNameTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
             .addGap(18)
             .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.BASELINE)
               .addComponent(lblRole)
               .addComponent(insRoleTx, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE))
             .addGap(18)
             .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.BASELINE)
               .addComponent(lblGender)
               .addComponent(rdbtnMale)
               .addComponent(rdbtnFemale))
             .addGap(22)
             .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.BASELINE)
               .addComponent(lblGotAward)
               .addComponent(chckbxTickIfYes))
             .addGap(18)
             .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.LEADING)
               .addComponent(button)
               .addComponent(button_4))
             .addContainerGap(469, Short.MAX_VALUE))
       );
       AddMovieCrewPanel.setLayout(gl_AddMovieCrewPanel);
	     
	     frame.getContentPane().add(BorderLayout.CENTER, AddMovieCrewPanel);
       frame.pack();
       frame.setLocationByPlatform(true);
       frame.setVisible(true);
       frame.setResizable(false);
     }
	   
	   public CreateFrameMovieCrew(MovieCrew mc)
     {
       JFrame frame = new JFrame("Add movie crews");
       frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       try 
       {
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
             JOptionPane.showMessageDialog(null, "fill in the name of the cast", "Insert movie cast - missing name", JOptionPane.ERROR_MESSAGE);
           } else if (!checkHelper.checkNameFormat(name)) {
             JOptionPane.showMessageDialog(null, "Please fill in the name in correct format", "Insert movie cast - wrong name format", JOptionPane.ERROR_MESSAGE);
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
             ///... unique name so skip?

             // check if there are still space for entering this people

//             if (update) {
               // check if this music name appears in the model
//               if (model.contains(name + " " + role) || model2.contains(name + " " + role)) {
//                 JOptionPane.showMessageDialog(null, "You have entered a duplicated crew-role", "Insert movie crew - duplicated crew-role", JOptionPane.ERROR_MESSAGE);
//                 valid = false;
//               }
             if (!mc.compareName(name)) {
               for (List<MovieCrew> list: tempcrew.values()) {
                 for (MovieCrew c: list) {
                   if (c.compareName(name)) {
                     JOptionPane.showMessageDialog(null, "You have entered a duplicated crew", "Insert movie crew - duplicated crew", JOptionPane.ERROR_MESSAGE);
                     valid = false;
                   }
                 }
               }
             }
               if (!oldRole.equalsIgnoreCase(role)) {
                 if (tempcrew.get(oldRole).size() <= 1) {
                   valid = false;
                   JOptionPane.showMessageDialog(null, "You need at least 1 people for that role", "Insert movie crew - too few cast entered", JOptionPane.ERROR_MESSAGE);
                 }
                 if (role.equalsIgnoreCase("cast")) {
                   if (tempcrew.get(role).size() >= 10) {
                     valid = false;
                     JOptionPane.showMessageDialog(null, "You have already entered 10 Casts", "Insert movie crew - too many cast entered", JOptionPane.ERROR_MESSAGE);
                   }
                 } else {
                   if (tempcrew.get(role).size() >= 3) {
                     valid = false;
                     JOptionPane.showMessageDialog(null, "You have already entered 3 Casts", "Insert movie crew - too many cast entered", JOptionPane.ERROR_MESSAGE);
                   }
                 }
               }
//                 for (String crewRole: tempcrew.keySet()) {
//                   if (crewRole.equalsIgnoreCase("cast")) {
//                     // check if there are already 10 people
//                     if (tempcrew.get(crewRole).size() >= 10 && crewRole.equalsIgnoreCase(role)) {
//                       valid = false;
//                       JOptionPane.showMessageDialog(null, "You have already entered 10 Casts", "Insert movie crew - too many cast entered", JOptionPane.ERROR_MESSAGE);
//                       break;
//                     }
//                     if (tempcrew.get(crewRole).size() <= 1 && crewRole.equalsIgnoreCase(oldRole)) {
//                       valid = false;
//                       JOptionPane.showMessageDialog(null, "You need at least 1 Casts", "Insert movie crew - too few cast entered", JOptionPane.ERROR_MESSAGE);
//                       break;
//                     }
//                   } else {
//                     // check if there are already 3 people
//                     if (crews.get(crewRole).size() >= 3 && role.equalsIgnoreCase(crewRole)) {
//                       valid = false;
//                       JOptionPane.showMessageDialog(null, "You have already entered 3 " + crewRole, "Insert movie crew - too many crews entered", JOptionPane.ERROR_MESSAGE);
//                       break;
//                     }
//                   }
//                 }
                 
//                 } else {
//                   // check if there are already 3 people
//                   if (tempcrew.get(crewRole).size() >= 3 && role.equalsIgnoreCase(crewRole)) {
//                     valid = false;
//                     JOptionPane.showMessageDialog(null, "You have already entered 3 " + crewRole, "Insert movie crew - too many crews entered", JOptionPane.ERROR_MESSAGE);
//                     break;
//                   }
//                 }
//               }
//             } else {
//               for (List<MovieCrew> list: crews.values()) {
//                 for (MovieCrew c: list) {
//                   if (c.compareName(name)) {
//                     JOptionPane.showMessageDialog(null, "You have entered a duplicated crew", "Insert movie crew - duplicated crew", JOptionPane.ERROR_MESSAGE);
//                     valid = false;
//                   }
//                 }
//               }
//               for (String crewRole: crews.keySet()) {
//                 if (crewRole.equalsIgnoreCase("cast")) {
//                   // check if there are already 10 people
//                   if (crews.get(crewRole).size() >= 10 && role.equalsIgnoreCase(crewRole)) {
//                     valid = false;
//                     JOptionPane.showMessageDialog(null, "You have already entered 10 Casts", "Insert movie crew - too many cast entered", JOptionPane.ERROR_MESSAGE);
//                     break;
//                   }
//                 } else {
//                   // check if there are already 3 people
//                   if (crews.get(crewRole).size() >= 3 && role.equalsIgnoreCase(crewRole)) {
//                     valid = false;
//                     JOptionPane.showMessageDialog(null, "You have already entered 3 " + crewRole, "Insert movie crew - too many crews entered", JOptionPane.ERROR_MESSAGE);
//                     break;
//                   }
//                 }
//               }
//             }
             
             
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
//               if (update) {
//                 // insert new music track
//                 // may have to think how to insert them when finally submit button is click on the main page
////                 TODO:TransactionHelper.insertOneCrewMember(oldMovie, mc); // insert those in tempcrew at the main menu
//                 if (role.equalsIgnoreCase("cast")) {
//                   model2.addElement(name + " " + role);
//                 } else {
//                   model.addElement(name + " " + role);
//                 }
//                 tempcrew.get(role).add(mc);
//               } else {
//                 crews.get(role).add(mc);
//               }
               JOptionPane.showMessageDialog(null, "submitted", "Insert movie crew - submitted", JOptionPane.INFORMATION_MESSAGE);
//               // TODO: clear fields
               
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
             .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.LEADING)
               .addGroup(gl_AddMovieCrewPanel.createSequentialGroup()
                 .addComponent(rdbtnMale)
                 .addGap(18)
                 .addComponent(rdbtnFemale))
               .addComponent(insCastNameTx, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
               .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.TRAILING)
                 .addGroup(gl_AddMovieCrewPanel.createSequentialGroup()
                   .addComponent(button, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
                   .addGap(48)
                   .addComponent(button_4, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                 .addComponent(insRoleTx, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE))
               .addGroup(gl_AddMovieCrewPanel.createSequentialGroup()
                 .addPreferredGap(ComponentPlacement.RELATED)
                 .addComponent(chckbxTickIfYes)))
             .addContainerGap(734, Short.MAX_VALUE))
       );
       gl_AddMovieCrewPanel.setVerticalGroup(
         gl_AddMovieCrewPanel.createParallelGroup(Alignment.LEADING)
           .addGroup(gl_AddMovieCrewPanel.createSequentialGroup()
             .addGap(64)
             .addComponent(label_3)
             .addGap(16)
             .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.BASELINE)
               .addComponent(lblName)
               .addComponent(insCastNameTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
             .addGap(18)
             .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.BASELINE)
               .addComponent(lblRole)
               .addComponent(insRoleTx, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE))
             .addGap(18)
             .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.BASELINE)
               .addComponent(lblGender)
               .addComponent(rdbtnMale)
               .addComponent(rdbtnFemale))
             .addGap(22)
             .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.BASELINE)
               .addComponent(lblGotAward)
               .addComponent(chckbxTickIfYes))
             .addGap(18)
             .addGroup(gl_AddMovieCrewPanel.createParallelGroup(Alignment.LEADING)
               .addComponent(button)
               .addComponent(button_4))
             .addContainerGap(469, Short.MAX_VALUE))
       );
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
        private ButtonGroup diskTypeTx;

        private ButtonModel model_cd;
        private ButtonModel model_vinyl;
        
      /**
       * for inserting a new music track, click throught the add music track button
       * @param musicTracks
       * @param update (true if from update page, false if from insert page)
       */
      public CreateFrameMusicTrack(List<MusicTrack> musicTracks, boolean update)
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
              diskType type;
              boolean valid = true;
              
              // check all fields are filled in or not
              if (insMusicTx.getText().equals("")|| insLangTx.getText().equals("") ||
                  insArrangerTx.getText().equals("") || insComposerTx.getText().equals("") || insSongWriterTx.getText().equals("") ||
                  insSingerTx1.getText().equals("")) {
                // show error - mandatory fields
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
                boolean typeBool = false;
//                for (Enumeration<AbstractButton> buttons = diskTypeTx.getElements(); buttons.hasMoreElements();) {
//                  AbstractButton button = buttons.nextElement();
//                  if (button.isSelected()) {
//                    typeString = diskTypeTx.getSelection().getActionCommand();
//                  }
                if (diskTypeTx.getSelection().getActionCommand().equalsIgnoreCase("vinyl")) {
                  typeBool = true;
                }
//                }
//                for (diskType d : type.getIteration()) {
//                  if (d.getString().equalsIgnoreCase(typeString)) {
//                    type = d.getEnum();
//                  }
//                }
//                type = checkHelper.checkDiskType(typeString);
                
                if (update) {
                  // check if this music name appears in the model
                  if (model.contains(musicName)) {
                    JOptionPane.showMessageDialog(null, "Music track name already entered", "Insert music - duplicated music name", JOptionPane.ERROR_MESSAGE);
                    valid = false;
                  }
                } else {
               // check if the music track name already exist in the list
                  for (MusicTrack mutrack: musicTracks) {
                    String mName = mutrack.getMusicName();
                    if (mName.equalsIgnoreCase(musicName)) {
                      JOptionPane.showMessageDialog(null, "Music track name already entered", "Insert music - duplicated music name", JOptionPane.ERROR_MESSAGE);
                      valid = false;
                      break;
                    }
                  }
                }
                
                if (valid) {
                  // store as music track
                  MusicTrack mt = new MusicTrack(musicName, lang, ((typeBool) ? diskType.VINYL : diskType.AUDIOCD), singer1, singer2, songWriter, composer, arranger);
                  if (update) {
                    // insert new music track
                    TransactionHelper.insertOneMusicTrack(musicName, oldAlbum, mt);
                    model.addElement(musicName);
                    tracks.put(musicName, mt);
                  } else {
                    musicTracks.add(mt);
                  }
                  JOptionPane.showMessageDialog(null, "submitted", "Insert music - submitted", JOptionPane.INFORMATION_MESSAGE);
                  // TODO: clear fields
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
          
          
          JLabel label_40 = new JLabel("Producer:");
          
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
                .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING, false)
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
                    .addComponent(insMusicTx))
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
            gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING)
              .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
                .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING)
                  .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
                    .addGap(60)
                    .addComponent(label_4))
                  .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
                    .addGap(57)
                    .addComponent(insMusicTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
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
          
        frame.getContentPane().add(BorderLayout.CENTER, AddMusicTrackPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.setResizable(false);
        
      }

      
      /**
       * for update a musictrack (clicked through the JList)
       * @param oldmt
       */
      public CreateFrameMusicTrack(MusicTrack oldmt)
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
          
          JButton button_3 = new JButton("Update");
          button_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              String musicName = null, lang = null, arranger = null, composer = null, songWriter = null, singer1 = null, singer2 = null;
              diskType type = diskType.AUDIOCD;
              Set<String> singerSet = new HashSet<String>();
              boolean valid = true;
              
              // check all fields are filled in or not
              if (insMusicTx.getText().equals("")|| insLangTx.getText().equals("") ||
                  insArrangerTx.getText().equals("") || insComposerTx.getText().equals("") || insSongWriterTx.getText().equals("") ||
                  insSingerTx1.getText().equals("")) {
                // show error - mandatory fields
                JOptionPane.showMessageDialog(null, "fill in all mandatory fields and in correct format", "Insert music - wrong format", JOptionPane.ERROR_MESSAGE);
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
                
                for (Enumeration<AbstractButton> buttons = diskTypeTx.getElements(); buttons.hasMoreElements();) {
                  AbstractButton button = buttons.nextElement();
                  if (button.isSelected()) {
                    if (button.getText().equalsIgnoreCase("vinyl")) {
                      type = diskType.VINYL;
                    }
                  }
                }
//                for (diskType d : type.getIteration()) {
//                  if (d.getString().equalsIgnoreCase(typeString)) {
//                    type = d.getEnum();
//                  }
//                }
//                type = checkHelper.checkDiskType(typeString);
                
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
                        UpdateHelper.updateMusicTrackCrewOff(oldmt.getArranger(), musicName, oldAlbum.albumName, "isarranger");
                      }
                      // check new aranger
                      if (checkHelper.checkMusicCrewExist(oldAlbum.albumName, musicName, arranger)) {
                        // set on
                        UpdateHelper.updateMusicTrackCrewOn(arranger, musicName, oldAlbum.albumName, "isarranger");
                      } else {
                        // add musicCrew and set on
                        InserterHelper.insertMusicPeopleInvolved(oldAlbum.albumName, oldAlbum.year, musicName, arranger, 0, 0, 1);
                      }
                      oldmt.setArranger(arranger);
//                      UpdateHelper.updateMusicTrackCrew(arranger, musicName, oldAlbum.getAlbumName(), "isarranger");
                    }
                    if(!oldmt.compareComposer(composer)) {
                      
                      // update composer
                      // check old composer
                      if (checkHelper.checkNumRoleMusic(oldAlbum.albumName, musicName, oldmt.getComposer()) == 1) {
                        // delete
                        DeleteHelper.removeMusicPeopleInvolved(oldAlbum.albumName, musicName, oldmt.getComposer());
                      } else {
                        // set off
                        UpdateHelper.updateMusicTrackCrewOff(oldmt.getComposer(), musicName, oldAlbum.albumName, "iscomposer");
                      }
                      // check new composer
                      if (checkHelper.checkMusicCrewExist(oldAlbum.albumName, musicName, composer)) {
                        // set on
                        UpdateHelper.updateMusicTrackCrewOn(composer, musicName, oldAlbum.albumName, "iscomposer");
                      } else {
                        // add musicCrew and set on
                        InserterHelper.insertMusicPeopleInvolved(oldAlbum.albumName, oldAlbum.year, musicName, composer, 0, 1, 0);
                      }
                      oldmt.setComposer(composer);
//                      UpdateHelper.updateMusicTrackCrew(composer, musicName, oldAlbum.getAlbumName(), "iscomposer");
                    }
                    if(!oldmt.compareSongWriter(songWriter)) {
                      
                      // update songWriter
                      // check old songWriter
                      if (checkHelper.checkNumRoleMusic(oldAlbum.albumName, musicName, oldmt.getSongWriter()) == 1) {
                        // delete
                        DeleteHelper.removeMusicPeopleInvolved(oldAlbum.albumName, musicName, oldmt.getSongWriter());
                      } else {
                        // set off
                        UpdateHelper.updateMusicTrackCrewOff(oldmt.getSongWriter(), musicName, oldAlbum.albumName, "issongwriter");
                      }
                      // check new songWriter
                      if (checkHelper.checkMusicCrewExist(oldAlbum.albumName, musicName, songWriter)) {
                        // set on
                        UpdateHelper.updateMusicTrackCrewOn(songWriter, musicName, oldAlbum.albumName, "issongwriter");
                      } else {
                        // add musicCrew and set on
                        InserterHelper.insertMusicPeopleInvolved(oldAlbum.albumName, oldAlbum.year, musicName, songWriter, 1, 0, 0);
                      }
                      oldmt.setSongWriter(songWriter);
//                      UpdateHelper.updateMusicTrackCrew(songWriter, musicName, oldAlbum.getAlbumName(), "issongwriter");
                    }
                    
                    if(!oldmt.compareSingers(singerSet)) {
                      List<String> dels = new ArrayList<String>();
                      List<String> ins = new ArrayList<String>();
    //                  UpdateHelper.updateMusicTrackString(singerSet, String musicName, "singers");
                      if (!singerSet.contains(oldmt.singer1)) {
                        // remove old s1
                        dels.add(oldmt.singer1);
                      }
                      if (oldmt.singer2 != null && !singerSet.contains(oldmt.singer2)) {
                        // remove old s2
                        dels.add(oldmt.singer2); 
                      }
                      for (String s: dels) {
                        DeleteHelper.removeMusicSinger(oldAlbum.albumName, musicName, s);
                      }
                      for (String s: singerSet) {
                        if ((!s.equalsIgnoreCase(oldmt.singer1)) && (!s.equalsIgnoreCase(oldmt.singer2))) {
                          // insert new s
                          InserterHelper.insertMusicSinger(oldAlbum.albumName, oldAlbum.year, musicName, s);
                        }
                      }
                      oldmt.setSingers(singer1, singer2);
                    }
                    
                    JOptionPane.showMessageDialog(null, "Successfully update all this music tracks information.", "Update successfully", JOptionPane.INFORMATION_MESSAGE);
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
          
          JLabel label_40 = new JLabel("Producer:");
          
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
          gl_AddMusicTrackPanel.setHorizontalGroup(
            gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING)
              .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
                .addGap(149)
                .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING, false)
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
                    .addComponent(insMusicTx))
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
            gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING)
              .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
                .addGroup(gl_AddMusicTrackPanel.createParallelGroup(Alignment.LEADING)
                  .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
                    .addGap(60)
                    .addComponent(label_4))
                  .addGroup(gl_AddMusicTrackPanel.createSequentialGroup()
                    .addGap(57)
                    .addComponent(insMusicTx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
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
