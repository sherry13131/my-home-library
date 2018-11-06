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
//		mntmBook.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//
//	            // go to insert book page
//	        	  CardLayout c = (CardLayout)(frame.getContentPane().getLayout());
//	        	  c.show(frame.getContentPane(), "insertBook");
//			}
//		});
		mnInsert.add(mntmBook);
		
		JMenuItem mntmAlbum = new JMenuItem("Album");
		mnInsert.add(mntmAlbum);
		
		JMenuItem mntmMovie = new JMenuItem("Movie");
		mnInsert.add(mntmMovie);
		
		JMenu mnUpdate = new JMenu("Update");
		menuBar.add(mnUpdate);
		
		JMenuItem menuItem = new JMenuItem("Book");
		mnUpdate.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("Album");
		mnUpdate.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("Movie");
		mnUpdate.add(menuItem_2);
		
		JMenu mnDelete = new JMenu("Delete");
		menuBar.add(mnDelete);
		
		JMenuItem menuItem_3 = new JMenuItem("Book");
		mnDelete.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("Album");
		mnDelete.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("Movie");
		mnDelete.add(menuItem_5);
		
		

	}
}
