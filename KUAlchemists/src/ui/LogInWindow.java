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
	private static JTextField textField;
	private static String[] usernames;
	private static int[] selectedTokens;
	private static boolean loginCompleted;
	
	private int numberOfPlayers;
	
	private JPanel playerPanel1;
	private JLabel playerUsername;

	BufferedImage backgroundImage1;
	
	/**
	 * Create the frame.
	 */
	public LogInWindow() {
		usernames = new String[4];
		selectedTokens = new int[4];
		loginCompleted = false;
		
		
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
		playerPanel1 = new JPanel();
		
		// Add background image
        try {
            backgroundImage1 = ImageIO.read(new File("src/images/board.png"));
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
		playerPanel1.setVisible(false);
		
		//Game title
		JLabel gameTitle = new JLabel("KU ALCHEMISTS");
		gameTitle.setFont(new Font("Cochin", Font.PLAIN, 50));
		gameTitle.setBounds((screenWidth-440)/2, 22, 440, 64);
		getContentPane().add(gameTitle);
		
		//Mode selection
		JPanel modeSelectionPanel = new JPanel();
        modeSelectionPanel.setBounds(0, 0, 1440, 900);
        modeSelectionPanel.setLayout(null);
        modeSelectionPanel.setVisible(true);
        getContentPane().add(modeSelectionPanel);
     
        
        JLabel modeText = new JLabel("SELECT YOUR MODE");
        modeText.setFont(new Font("Cochin", Font.PLAIN, 36));
        modeText.setBounds((screenWidth-400)/2, 225, 400, 64);
        modeSelectionPanel.add(modeText);
        modeSelectionPanel.add(gameTitle);
     
        
        //Login time
		JLabel gameTitle2 = new JLabel("KU ALCHEMISTS");
		gameTitle2.setFont(new Font("Cochin", Font.PLAIN, 50));
		gameTitle2.setBounds((screenWidth-440)/2, 22, 440, 64);
		playerPanel1.add(gameTitle2);
		getContentPane().add(playerPanel1);
  
		//Taking input for username
		JTextField usernameText = new JTextField();
		usernameText.setBounds((screenWidth-260)/2, 151, 260, 32);
		playerPanel1.add(usernameText);
		usernameText.setColumns(10);
		
		//Player Username title
		playerUsername = new JLabel("PLAYER 1 USERNAME:");
		playerUsername.setAlignmentX(Component.CENTER_ALIGNMENT);
		playerUsername.setFont(new Font("Cochin", Font.PLAIN, 20));
		playerUsername.setBounds((screenWidth-235)/2, 115, 235, 32);
		playerPanel1.add(playerUsername);
		
		
		//Login Buttons for Player 1 login and Player 2 login
		JButton loginButton = new JButton("LOGIN");
		loginButton.setFont(new Font("Cochin", Font.PLAIN, 13));
		loginButton.setBounds((screenWidth-120)/2, 517, 120, 29);
		
		JButton loginButton2 = new JButton("LOGIN");
		loginButton2.setFont(new Font("Cochin", Font.PLAIN, 13));
		loginButton2.setVisible(false);
		loginButton2.setBounds((screenWidth-120)/2, 517, 120, 29);

		JButton loginButton3 = new JButton("LOGIN");
		loginButton3.setFont(new Font("Cochin", Font.PLAIN, 13));
		loginButton3.setVisible(false);
		loginButton3.setBounds((screenWidth-120)/2, 517, 120, 29);

		JButton loginButtonLast = new JButton("LOGIN");
		loginButtonLast.setFont(new Font("Cochin", Font.PLAIN, 13));
		loginButtonLast.setVisible(false);
		loginButtonLast.setBounds((screenWidth-120)/2, 517, 120, 29);
		
		playerPanel1.add(loginButton);
		playerPanel1.add(loginButton2);
		playerPanel1.add(loginButton3);
		playerPanel1.add(loginButtonLast);
		
		
		
		
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
                	
                	//TO BE IMPLEMENTED FOR NETWORK
                }
        });
        
        onlineButton.setFont(new Font("Cochin", Font.PLAIN, 48));
        onlineButton.setBounds((screenWidth-278)/2, 379, 278, 81);
        modeSelectionPanel.add(onlineButton);
        
        //Offline Button
        JButton offlineButton = new JButton("OFFLINE");
        offlineButton.setFont(new Font("Cochin", Font.PLAIN, 48));
        offlineButton.setBounds((screenWidth-278)/2, 513, 278, 81);
        modeSelectionPanel.add(offlineButton);
        offlineButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] numOfPlayers = {"2", "3", "4"};
                String ans = (String)JOptionPane.showInputDialog(null,"Choose number of players:","Player Number",
                		JOptionPane.QUESTION_MESSAGE,null,numOfPlayers,numOfPlayers[0]);
                if (ans != null) {
                 	setNumberOfPlayers(Integer.valueOf(ans));
                    playerPanel1.setVisible(true);
                    gameTitle.setVisible(true);
                    modeSelectionPanel.setVisible(false);
                    offlineButton.setVisible(false);
                    onlineButton.setVisible(false);	
                }
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
					usernames[0] = usernameText.getText();
					usernameText.setText("");
					playerUsername.setText("PLAYER 2 USERNAME:");
					
					//Avatar index of Player1
					selectedTokens[0] = avatarList.getSelectedIndex();

					loginButton.setVisible(false);
					
					if(numberOfPlayers == 2) {
						loginButtonLast.setVisible(true);
					}
					else {
						loginButton2.setVisible(true);
					}
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
				else if (usernameText.getText().equals(usernames[0])) {
					JOptionPane.showMessageDialog(null, "Username is already taken!","Error",JOptionPane.WARNING_MESSAGE);
				}
				else {
					//Username of Player2
					usernames[1] = usernameText.getText();
					usernameText.setText("");
					playerUsername.setText("PLAYER 3 USERNAME:");
					
					//Avatar index of Player2
					selectedTokens[1] = avatarList.getSelectedIndex();

					loginButton2.setVisible(false);
					
					if(numberOfPlayers == 3) {
						loginButtonLast.setVisible(true);
					}
					else {
						loginButton3.setVisible(true);
					}
				}					
			}
		});
		
		/**
		 * Player 3 Login
		 */
		loginButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				if (usernameText.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Name field cannot be empty.","Error",JOptionPane.WARNING_MESSAGE);
				}
				else if (usernameText.getText().equals(usernames[0]) || usernameText.getText().equals(usernames[1])) {
					JOptionPane.showMessageDialog(null, "Username is already taken!","Error",JOptionPane.WARNING_MESSAGE);
				}
				else {
					//Username of Player3
					usernames[2] = usernameText.getText();
					usernameText.setText("");
					playerUsername.setText("PLAYER 4 USERNAME:");
					
					//Avatar index of Player3
					selectedTokens[2] = avatarList.getSelectedIndex();

					loginButton3.setVisible(false);
					loginButtonLast.setVisible(true);
				}					
			}
		});
		
		
		/**
		 * Player Last Login
		 */
		loginButtonLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (usernameText.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Name field cannot be empty.","Error",JOptionPane.WARNING_MESSAGE);
				}
				else {
					switch (numberOfPlayers) {
					case 2: 
						if (usernameText.getText().equals(usernames[0]))
							JOptionPane.showMessageDialog(null, "Username is already taken!","Error",JOptionPane.WARNING_MESSAGE);
						break;
					case 3: 
						if (usernameText.getText().equals(usernames[0]) || usernameText.getText().equals(usernames[1]))
							JOptionPane.showMessageDialog(null, "Username is already taken!","Error",JOptionPane.WARNING_MESSAGE);
						break;
					case 4: 
						if (usernameText.getText().equals(usernames[0]) || usernameText.getText().equals(usernames[1]) || usernameText.getText().equals(usernames[2]))
							JOptionPane.showMessageDialog(null, "Username is already taken!","Error",JOptionPane.WARNING_MESSAGE);
						break;
					}
					
					//Username of Player Last
					usernames[numberOfPlayers-1] = usernameText.getText();
					
					//Avatar index of Player Last
					selectedTokens[numberOfPlayers-1] = avatarList.getSelectedIndex();		
					loginCompleted = true;
					
					

	        		Game game = Game.getGame();
	        		game.initializePlayers(Game.getGame().getPlayers(), getNumberOfPlayers());
	        		game.initializeBoard();
					BoardWindow board = BoardWindow.getBoardWindow();
					board.initialize();
					dispose();
					
				}
			}

		});
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		LogInWindow loginWindow = new LogInWindow();


	}
	
	
	public static String[] getUsernames() {
		return usernames;
	}

	public static void setUsernames(String[] usernames) {
		LogInWindow.usernames = usernames;
	}

	public static int[] getSelectedTokens() {
		return selectedTokens;
	}

	public static void setSelectedTokens(int[] selectedTokens) {
		LogInWindow.selectedTokens = selectedTokens;
	}

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}


	
}
