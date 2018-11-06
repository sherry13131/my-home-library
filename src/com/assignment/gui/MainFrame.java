package com.assignment.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class MainFrame {

	private JFrame frame;
	private JTextField insertbooktitle;
	private JTextField insertbookisbn;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_11;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_10;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
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
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 823, 623);
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
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		JButton btnCancel = new JButton("Cancel");
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JLabel lblAuthors = new JLabel("Authors:");
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		GroupLayout gl_insertBook = new GroupLayout(insertBook);
		gl_insertBook.setHorizontalGroup(
			gl_insertBook.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_insertBook.createSequentialGroup()
					.addGap(173)
					.addGroup(gl_insertBook.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_insertBook.createSequentialGroup()
							.addComponent(lblNumberofPages)
							.addGap(18)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_insertBook.createSequentialGroup()
							.addGroup(gl_insertBook.createParallelGroup(Alignment.LEADING)
								.addComponent(lblBookTitle)
								.addComponent(lblBookIsbn)
								.addComponent(lblNewLabel))
							.addGap(53)
							.addGroup(gl_insertBook.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField)
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
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_insertBook.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_insertBook.createSequentialGroup()
										.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
										.addGap(23)
										.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_insertBook.createSequentialGroup()
										.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
										.addGap(23)
										.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
									.addComponent(textField_11, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_insertBook.createSequentialGroup()
										.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnCancel))))))
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
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_insertBook.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumberofPages)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_insertBook.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYearOfPublication)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_insertBook.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEditionNumber)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_insertBook.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAbstract)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_insertBook.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKeywords)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_insertBook.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAuthors)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_insertBook.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_insertBook.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSubmit)
						.addComponent(btnCancel))
					.addContainerGap(99, Short.MAX_VALUE))
		);
		insertBook.setLayout(gl_insertBook);
		
		JPanel insertAlbum = new JPanel();
		frame.getContentPane().add(insertAlbum, "insertAlbum");
		
		JButton button = new JButton("Submit");
		
		JButton button_1 = new JButton("Cancel");
		
		JLabel lblLanguage = new JLabel("language:");
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		
		JLabel lblAlbumName = new JLabel("Album name:");
		
		JLabel lblYear = new JLabel("Year:");
		
		JLabel lblMusicName = new JLabel("Music name:");
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		
		JLabel lblDiskType = new JLabel("Disk type:");
		
		JLabel lblProducer = new JLabel("Producer:");
		
		JLabel lblSongWriter = new JLabel("Song writer:");
		
		JLabel lblComposer = new JLabel("Composer:");
		
		JLabel lblArranger = new JLabel("Arranger:");
		
		textField_20 = new JTextField();
		textField_20.setColumns(10);
		
		textField_21 = new JTextField();
		textField_21.setColumns(10);
		
		textField_22 = new JTextField();
		textField_22.setColumns(10);
		
		textField_23 = new JTextField();
		textField_23.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		GroupLayout gl_insertAlbum = new GroupLayout(insertAlbum);
		gl_insertAlbum.setHorizontalGroup(
			gl_insertAlbum.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_insertAlbum.createSequentialGroup()
					.addGap(173)
					.addGroup(gl_insertAlbum.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_insertAlbum.createSequentialGroup()
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_1))
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
										.addComponent(lblArranger))
									.addGap(22))
								.addGroup(gl_insertAlbum.createSequentialGroup()
									.addComponent(lblAlbumName)
									.addGap(18)))
							.addGroup(gl_insertAlbum.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField_19, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
								.addComponent(textField_20, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
								.addComponent(textField_21, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
								.addComponent(textField_22, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
								.addComponent(textField_23, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
								.addComponent(textField_16, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
								.addComponent(textField_10, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
								.addComponent(textField_18)
								.addComponent(textField_17))))
					.addContainerGap(239, Short.MAX_VALUE))
		);
		gl_insertAlbum.setVerticalGroup(
			gl_insertAlbum.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_insertAlbum.createSequentialGroup()
					.addContainerGap(21, Short.MAX_VALUE)
					.addGroup(gl_insertAlbum.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_insertAlbum.createSequentialGroup()
							.addGroup(gl_insertAlbum.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_19, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAlbumName))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_insertAlbum.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_18, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblYear))
							.addGap(18)
							.addGroup(gl_insertAlbum.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_17, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMusicName))
							.addGap(18)
							.addComponent(textField_16, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblLanguage))
					.addGap(18)
					.addGroup(gl_insertAlbum.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_22, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDiskType))
					.addGap(18)
					.addGroup(gl_insertAlbum.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_21, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblProducer))
					.addGap(18)
					.addGroup(gl_insertAlbum.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_23, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSongWriter))
					.addGap(18)
					.addGroup(gl_insertAlbum.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_20, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblComposer))
					.addGap(18)
					.addGroup(gl_insertAlbum.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblArranger))
					.addGap(56)
					.addGroup(gl_insertAlbum.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(111))
		);
		insertAlbum.setLayout(gl_insertAlbum);
		
		JPanel insertMovie = new JPanel();
		frame.getContentPane().add(insertMovie, "insertMovie");
		
		JButton button_2 = new JButton("Submit");
		
		JButton button_3 = new JButton("Cancel");
		
		JLabel lblReleaseYear = new JLabel("Release year:");
		
		JLabel lblMovieName_1 = new JLabel("Movie name:");
		
		JLabel lblReleaseYear_1 = new JLabel("Release year:");
		
		JLabel lblCrewName = new JLabel("Crew name:");
		
		JLabel lblRole = new JLabel("Role:");
		
		JLabel lblMovieName = new JLabel("Movie name:");
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		
		textField_24 = new JTextField();
		textField_24.setColumns(10);
		
		textField_25 = new JTextField();
		textField_25.setColumns(10);
		
		textField_26 = new JTextField();
		textField_26.setColumns(10);
		
		textField_27 = new JTextField();
		textField_27.setColumns(10);
		
		JButton button_4 = new JButton("Submit");
		
		JButton button_5 = new JButton("Cancel");
		GroupLayout gl_insertMovie = new GroupLayout(insertMovie);
		gl_insertMovie.setHorizontalGroup(
			gl_insertMovie.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_insertMovie.createSequentialGroup()
					.addGap(199)
					.addGroup(gl_insertMovie.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_insertMovie.createSequentialGroup()
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_insertMovie.createSequentialGroup()
							.addGroup(gl_insertMovie.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_insertMovie.createSequentialGroup()
									.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_insertMovie.createSequentialGroup()
									.addGroup(gl_insertMovie.createParallelGroup(Alignment.LEADING)
										.addComponent(lblMovieName)
										.addComponent(lblReleaseYear)
										.addComponent(lblMovieName_1)
										.addComponent(lblReleaseYear_1)
										.addComponent(lblCrewName)
										.addComponent(lblRole))
									.addGroup(gl_insertMovie.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_insertMovie.createSequentialGroup()
											.addGap(22)
											.addGroup(gl_insertMovie.createParallelGroup(Alignment.LEADING, false)
												.addComponent(textField_26)
												.addComponent(textField_27, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)))
										.addGroup(gl_insertMovie.createSequentialGroup()
											.addGap(18)
											.addGroup(gl_insertMovie.createParallelGroup(Alignment.LEADING)
												.addComponent(textField_24, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
												.addComponent(textField_14, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
												.addComponent(textField_25, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
												.addComponent(textField_13, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))))))
							.addGap(9)))
					.addGap(198))
		);
		gl_insertMovie.setVerticalGroup(
			gl_insertMovie.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_insertMovie.createSequentialGroup()
					.addGap(69)
					.addGroup(gl_insertMovie.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_27, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMovieName))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_insertMovie.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_26, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblReleaseYear))
					.addGap(18)
					.addGroup(gl_insertMovie.createParallelGroup(Alignment.LEADING)
						.addComponent(button_4)
						.addComponent(button_5))
					.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
					.addGroup(gl_insertMovie.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_25, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMovieName_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_insertMovie.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblReleaseYear_1)
						.addComponent(textField_24, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(23)
					.addGroup(gl_insertMovie.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCrewName)
						.addComponent(textField_14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_insertMovie.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRole)
						.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_insertMovie.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_3)
						.addComponent(button_2))
					.addGap(147))
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
		
		JMenu mnInsert = new JMenu("Insert");
		menuBar.add(mnInsert);
		
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
		menuBar.add(mnUpdate);
		
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
		menuBar.add(mnDelete);
		
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
		
		

	}
}
