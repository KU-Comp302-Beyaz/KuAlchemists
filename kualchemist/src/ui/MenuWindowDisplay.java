package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import ui.MenuWindowDisplay.ImageListCellRenderer;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JScrollBar;

public class MenuWindowDisplay extends JFrame {

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

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuWindowDisplay frame = new MenuWindowDisplay();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuWindowDisplay() {
		setBounds(0, 0, 971, 720);
		getContentPane().setLayout(null);
		JPanel playerPanel1 = new JPanel();
		playerPanel1.setBounds(0, 0, 971, 720);
		playerPanel1.setLayout(null);
		
		JLabel gameTitle = new JLabel("KU ALCHEMISTS");
		gameTitle.setFont(new Font("Cochin", Font.PLAIN, 50));
		gameTitle.setBounds(241, 22, 439, 64);
		playerPanel1.add(gameTitle);
		getContentPane().add(playerPanel1);
		
		JTextField usernameText = new JTextField();
		usernameText.setBounds(313, 151, 257, 32);
		playerPanel1.add(usernameText);
		usernameText.setColumns(10);
		
		JLabel playerUsername = new JLabel("PLAYER 1 USERNAME:");
		playerUsername.setFont(new Font("Cochin", Font.PLAIN, 20));
		playerUsername.setBounds(322, 115, 315, 32);
		playerPanel1.add(playerUsername);
		
		JLabel playerUsername2 = new JLabel("PLAYER 2 USERNAME:");
		playerUsername2.setFont(new Font("Cochin", Font.PLAIN, 20));
		playerUsername2.setBounds(322, 115, 315, 32);
		playerPanel1.add(playerUsername2);
		
		playerUsername2.setVisible(false);
		
		JButton loginButton = new JButton("LOGIN");
		JButton loginButton2 = new JButton("LOGIN");
		loginButton2.setVisible(false);
		
		loginButton.setBounds(370, 517, 117, 29);
		loginButton2.setBounds(370, 517, 117, 29);

		playerPanel1.add(loginButton);
		playerPanel1.add(loginButton2);
		
		JLabel[] avatarIcons = new JLabel[6];
		JPanel[] avatarPanels = new JPanel[6];
		for (int i = 0; i < 6; i++) {
			avatarIcons[i] = new JLabel("", new ImageIcon("Images/avatar-icons/avatar"+(i+1)+".png"), JLabel.CENTER);
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
		avatarScrollPane.setBounds(360,215,150,280);
		avatarScrollPane.setViewportView(avatarList);
		playerPanel1.add(avatarScrollPane);

		
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameText.getText();
				System.out.println("Username 1" + username);
				usernameText.setText("");
				
				int chosenAvatarIndex = avatarList.getSelectedIndex();
				System.out.println("Avatar 1 is number " + chosenAvatarIndex);

				//Player player1 = new Player(username1, token1)
				//game.players.add(player1)
				
				//Disabling player1 panel and enabling player2 panel
				
				playerUsername.setVisible(false);
				playerUsername2.setVisible(true);
				
				loginButton.setVisible(false);
				loginButton2.setVisible(true);
				
			}
		});
		
		loginButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username2 = usernameText.getText();
				System.out.println("Username 2" + username2);

				int chosenAvatarIndex = avatarList.getSelectedIndex();
				System.out.println("Avatar 2 is number " + chosenAvatarIndex);
				
				//Player player2 = new Player(username2, token2)
				//game.players.add(player2)
				
				setVisible(false);
				BoardWindow board = new BoardWindow();
				board.initialize();
				
			}
		});
		

	}
}