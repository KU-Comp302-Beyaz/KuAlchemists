package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuWindowDisplay extends JFrame {

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
		setBounds(0, 0, 971, 440);
		getContentPane().setLayout(null);
		JPanel playerPanel1 = new JPanel();
		playerPanel1.setBounds(0, 0, 971, 412);
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
		
		loginButton.setBounds(381, 284, 117, 29);
		loginButton2.setBounds(381, 284, 117, 29);

		playerPanel1.add(loginButton);
		playerPanel1.add(loginButton2);

		
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameText.getText();
				System.out.println("Username 1" + username);
				usernameText.setText("");
				//token alınacak
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

				//token alınacak
				//Player player2 = new Player(username2, token2)
				//game.players.add(player2)
				
				setVisible(false);
				BoardWindow board = new BoardWindow();
				board.initialize();
				
			}
		});
		

	}
}
