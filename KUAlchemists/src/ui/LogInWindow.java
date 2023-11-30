package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import domain.Game;
import domain.Player;
import ui.LogInWindow.ImageListCellRenderer; //necessary

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.ListSelectionModel;


public class LogInWindow extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private String username1;
	private String username2;
	private int selectedToken1;
	private int selectedToken2;
	private boolean loginCompleted = false;

	
	/**
	 * Needed for the Avatar jlist - it contains jpanels with imageicons instead of a list
	 */
	public class ImageListCellRenderer implements ListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
		      Component component = (Component) value;
		      component.setForeground(Color.white);
		      component.setBackground(isSelected ? UIManager.getColor("Table.focusCellForeground") : Color.white);
		      return component;
		}

	}
	
	
	/**
	 * Create the frame.
	 */
	public LogInWindow() {
		setResizable(false);
		//get screen height and width
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int screenHeight = dimension.height;
        int screenWidth = dimension.width;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1440, 900);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); // automatically extends frame to desktop size (full size)
		getContentPane().setLayout(null);
		JPanel playerPanel1 = new JPanel();
		playerPanel1.setBounds(0, 0, 1440, 900);
		playerPanel1.setLayout(null);
		
		//Game title
		JLabel gameTitle = new JLabel("KU ALCHEMISTS");
		gameTitle.setFont(new Font("Cochin", Font.PLAIN, 50));
		gameTitle.setBounds((screenWidth-440)/2, 22, 440, 64);
		playerPanel1.add(gameTitle);
		getContentPane().add(playerPanel1);
		
		//Taking input for username1
		JTextField usernameText = new JTextField();
		usernameText.setBounds((screenWidth-260)/2, 151, 260, 32);
		playerPanel1.add(usernameText);
		usernameText.setColumns(10);
		
		//Player Username 1 title
		JLabel playerUsername = new JLabel("PLAYER 1 USERNAME:");
		playerUsername.setAlignmentX(Component.CENTER_ALIGNMENT);
		playerUsername.setFont(new Font("Cochin", Font.PLAIN, 20));
		playerUsername.setBounds((screenWidth-235)/2, 115, 235, 32);
		playerPanel1.add(playerUsername);
		
		//Player Username 2 title
		JLabel playerUsername2 = new JLabel("PLAYER 2 USERNAME:");
		playerUsername2.setFont(new Font("Cochin", Font.PLAIN, 20));
		playerUsername2.setBounds((screenWidth-235)/2, 115, 235, 32);
		playerPanel1.add(playerUsername2);
		
		playerUsername2.setVisible(false);
		
		//Login Buttons for Player 1 login and Player 2 login
		JButton loginButton = new JButton("LOGIN");
		JButton loginButton2 = new JButton("LOGIN");
		loginButton2.setVisible(false);
		
		loginButton.setBounds((screenWidth-120)/2, 517, 120, 29);
		loginButton2.setBounds((screenWidth-120)/2, 517, 120, 29);

		playerPanel1.add(loginButton);
		playerPanel1.add(loginButton2);
		
		/**
		 * Taking the avatar images from the /Images/avatar-icons folder 
		 */
		JLabel[] avatarIcons = new JLabel[6];
		JPanel[] avatarPanels = new JPanel[6];
		for (int i = 0; i < 6; i++) {
			avatarIcons[i] = new JLabel("", new ImageIcon("src/images/avatar-icons/avatar"+(i+1)+".png"), JLabel.CENTER);
			avatarPanels[i] = new JPanel();
			avatarPanels[i].add(avatarIcons[i]);
		}
						
		JList avatarList = new JList();
		avatarList.setCellRenderer(new ImageListCellRenderer());
		avatarList.setListData(avatarPanels);
		avatarList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		avatarList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		avatarList.setBounds(165,215,128,280);
		avatarList.setFixedCellHeight(140);
		avatarList.setFixedCellWidth(128);	
		avatarList.setSelectedIndex(0);
		
		JScrollPane avatarScrollPane = new JScrollPane();
		avatarScrollPane.setBounds((screenWidth-150)/2,215,150,280);
		avatarScrollPane.setViewportView(avatarList);
		playerPanel1.add(avatarScrollPane);

		/**
		 * Player 1 Login
		 */
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Username of Player1
				username1 = usernameText.getText();
				usernameText.setText("");

				//Avatar index of Player1
				selectedToken1 = avatarList.getSelectedIndex();

				
				//Disabling player1 panel and enabling player2 panel
				playerUsername.setVisible(false);
				playerUsername2.setVisible(true);
				
				loginButton.setVisible(false);
				loginButton2.setVisible(true);
				
			}
		});
		
		/**
		 * Player 2 Login
		 */
		loginButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				username2 = usernameText.getText();
				selectedToken2 = avatarList.getSelectedIndex();				
				loginCompleted = true;
				
				BoardWindow board = BoardWindow.getBoardWindow();
				board.initialize();
				dispose();
				
			}
		});
	}
	
	//Displays the frame
	public void displayMenuWindow() {
		LogInWindow frame = new LogInWindow();
		frame.setVisible(true);
	}
	
	//Returns Player 1's username
	public String getFirstUsername() {
		return username1;
	}

	//Returns Player 2's username
	public String getSecondUsername() {
		return username2;
	}
	
	//Returns Player 1's token number
	public int getFirstAvatarIndex() {
		return selectedToken1;
	}
	
	//Returns Player 2's token number
	public int getSecondAvatarIndex() {
		return selectedToken2;
	}
	
}