package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import domain.Game;
import domain.Player;
import ui.ImageListCellRenderer; //necessary

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;


public class LogInWindow extends JFrame {

	//fields
	private JTextField textField;
	private String username1;
	private String username2;
	private int selectedToken1;
	private int selectedToken2;
	private int numberOfPlayers;
	private boolean loginCompleted = false;
	
	//Singleton implementation
	private static LogInWindow loginWindowSingleton = new LogInWindow();
	
	public static LogInWindow getInstance() {
		return loginWindowSingleton;
	}

	/**
	 * Create the frame.
	 */
	private LogInWindow() {
		setResizable(false);
		//get screen height and width
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int screenHeight = dimension.height;
        int screenWidth = dimension.width;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); // automatically extends frame to desktop size (full size)
        setResizable(false);
        
        
        getContentPane().setLayout(null);
		JPanel playerPanel1 = new JPanel();
		
		// Add background image
        try {
            BufferedImage backgroundImage1 = ImageIO.read(new File("src/images/board.png"));
            playerPanel1 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(backgroundImage1, 0, 0, getWidth(), getHeight(), this);
                }
            };
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		
		playerPanel1.setBounds(0, 0, 1440, 900);
		playerPanel1.setLayout(null);
		
		
		//Game title
		JLabel gameTitle = new JLabel("KU ALCHEMISTS");
		gameTitle.setFont(new Font("Cochin", Font.PLAIN, 50));
		gameTitle.setBounds((screenWidth-440)/2, 22, 440, 64);
        getContentPane().add(gameTitle);
        
		//Mode selection panel 
		JPanel modeSelectionPanel = new JPanel();
		modeSelectionPanel.setBounds(0, 0, 1440, 900);
		modeSelectionPanel.setLayout(null);
		modeSelectionPanel.setVisible(true);
		getContentPane().add(modeSelectionPanel);
		
		JLabel modeText = new JLabel("SELECT YOUR MODE");
		modeText.setForeground(new Color(153, 145, 255));
		modeText.setFont(new Font("Cochin", Font.PLAIN, 36));
		modeText.setBounds(560, 225, 400, 64);
		modeSelectionPanel.add(modeText);
		

        //Player 1 panel
        JPanel playerPanel1 = new JPanel();
		playerPanel1.setBounds(0, 0, 1440, 900);
		playerPanel1.setLayout(null);
		playerPanel1.setVisible(false);
		
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
		loginButton.setFont(new Font("Cochin", Font.PLAIN, 13));
		JButton loginButton2 = new JButton("LOGIN");
		loginButton2.setFont(new Font("Cochin", Font.PLAIN, 13));
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
		avatarList.setFixedCellHeight(140);
		avatarList.setFixedCellWidth(128);
		avatarList.setVisibleRowCount(2);
		avatarList.setSelectedIndex(0);
		
		JScrollPane avatarScrollPane = new JScrollPane();
		avatarScrollPane.setBounds((screenWidth-390)/2,215,390,290); 
		avatarScrollPane.setViewportView(avatarList);
		playerPanel1.add(avatarScrollPane);

		
		//Online Button
		JButton onlineButton = new JButton("ONLINE");
		onlineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		onlineButton.setFont(new Font("Cochin", Font.PLAIN, 48));
		onlineButton.setBounds(632, 379, 278, 81);
		modeSelectionPanel.add(onlineButton);
		
		//Offline Button
		JButton offlineButton = new JButton("OFFLINE");
		offlineButton.setFont(new Font("Cochin", Font.PLAIN, 48));
		offlineButton.setBounds(632, 513, 278, 81);
		modeSelectionPanel.add(offlineButton);
		offlineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			playerPanel1.setVisible(true);
			gameTitle.setVisible(true);
			modeSelectionPanel.setVisible(false);
			offlineButton.setVisible(false);
			onlineButton.setVisible(false);
			
			}
		});		
		

		
		/**
		 * Player 1 Login
		 */
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (usernameText.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Name field cannot be empty.","Error",JOptionPane.WARNING_MESSAGE);
				}
				else {
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
			}
		});
		
		/**
		 * Player 2 Login
		 */
		loginButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (usernameText.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Name field cannot be empty.","Error",JOptionPane.WARNING_MESSAGE);
				}
				else if (usernameText.getText().equals(username1)) {
					JOptionPane.showMessageDialog(null, "Username is already taken!","Error",JOptionPane.WARNING_MESSAGE);
				}
				else {
					username2 = usernameText.getText();
					selectedToken2 = avatarList.getSelectedIndex();				
					loginCompleted = true;
					
					BoardWindow board = BoardWindow.getBoardWindow();
					board.initialize();
					dispose();
				}
			}
		});		
	}
	
	//Displays the frame
	public void displayLogInWindow() {
		setVisible(true);
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

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}
	}
