package ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domain.Game;
import domain.Player;
import domain.Game.Controller;
import domain.ingredients.Ingredient;
import domain.ingredients.IngredientStorage;
import domain.potion.Potion;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EndGameDisplay extends JFrame{
	
	//Singleton implementation
		private static EndGameDisplay egDisplay;
		
		public static synchronized EndGameDisplay getInstance() {
			if (egDisplay == null)
				egDisplay = new EndGameDisplay(null);// change null
			return egDisplay;
		}
		
		private EndGameDisplay(Player[] players) {
		       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(0, 0, 1440, 800);
		        this.setExtendedState(JFrame.MAXIMIZED_BOTH); // automatically extends frame to desktop size (full size)
		        
		        JPanel contentPane = new JPanel();
		        
		        // Add background image
		        try {
		            BufferedImage backgroundImage1 = ImageIO.read(new File("src/images/board.png"));
		            contentPane = new JPanel() {
		                @Override
		                protected void paintComponent(Graphics g) {
		                    super.paintComponent(g);
		                    g.drawImage(backgroundImage1, 0, 0, getWidth(), getHeight(), this);
		                }
		            };
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		        
		        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		        setContentPane(contentPane);
		        contentPane.setLayout(null);
		        
		        
		        
		        
		        JLabel lblNewLabel = new JLabel("GAME OVER");
		        lblNewLabel.setBounds(291, 85, 225, 41);
		        lblNewLabel.setFont(new Font("Cochin", Font.BOLD, 35));
		        getContentPane().add(lblNewLabel);
		        contentPane.setLayout(null);
		        
		        JLabel lblNewLabel_1 = new JLabel("Winner: " + "");
		        lblNewLabel_1.setBounds(6, 23, 74, 23);
		        lblNewLabel_1.setFont(new Font("Cochin", Font.PLAIN, 20));
		        contentPane.add(lblNewLabel_1);
		        
		        JLabel lblNewLabel_2 = new JLabel("Winner Score: ");
		        lblNewLabel_2.setBounds(88, 11, 127, 23);
		        lblNewLabel_2.setFont(new Font("Cochin", Font.PLAIN, 20));
		        contentPane.add(lblNewLabel_2);
		        
		        JLabel lblPlayers = new JLabel("PLAYERS");
		        lblPlayers.setBounds(220, 5, 143, 36);
		        lblPlayers.setFont(new Font("Cochin", Font.BOLD, 30));
		        contentPane.add(lblPlayers);
		        
		        // PLAYER 1
		        JLabel lblPlayer_1 = new JLabel("Player 1");
		        lblPlayer_1.setBounds(368, 11, 69, 23);
		        lblPlayer_1.setFont(new Font("Cochin", Font.PLAIN, 20));
		        contentPane.add(lblPlayer_1);
		        
		        JLabel lblPlayerUserName_1 = new JLabel("Username: " + players[0].getUsername());
		        lblPlayer_1.setFont(new Font("Cochin", Font.PLAIN, 20));
		        contentPane.add(lblPlayer_1);
		        
		        ImageIcon image_Player1 = new ImageIcon(players[0].getProfilePhoto());
		        JLabel lblPlayerProfilePhoto_1 = new JLabel(image_Player1);
		        lblPlayerProfilePhoto_1.setBounds(442, 23, -1, -1);
		        contentPane.add(lblPlayerProfilePhoto_1);
		        
		        JLabel lblScore_1 = new JLabel("Final Score: " + players[0].getScorePoints());
		        lblScore_1.setBounds(67, 46, 116, 23);
		        lblScore_1.setFont(new Font("Cochin", Font.PLAIN, 20));
		        contentPane.add(lblScore_1);
		        
		        // PLAYER 2
		        JLabel lblPlayer_2 = new JLabel("Player 2");
		        lblPlayer_2.setBounds(188, 46, 69, 23);
		        lblPlayer_2.setFont(new Font("Cochin", Font.PLAIN, 20));
		        contentPane.add(lblPlayer_2);
		        
		        JLabel lblPlayerUserName_2 = new JLabel("Username: " + players[1].getUsername());
		        lblPlayer_1.setFont(new Font("Cochin", Font.PLAIN, 20));
		        contentPane.add(lblPlayer_2);
		        
		        ImageIcon image_Player2 = new ImageIcon(players[1].getProfilePhoto());
		        JLabel lblPlayerProfilePhoto_2 = new JLabel(image_Player2);
		        lblPlayerProfilePhoto_2.setBounds(262, 58, -1, -1);
		        contentPane.add(lblPlayerProfilePhoto_2); 
		        
		        JLabel lblScore_2 = new JLabel("Final Score: " + players[1].getScorePoints());
		        lblScore_2.setBounds(266, 46, 116, 23);
		        lblScore_2.setFont(new Font("Cochin", Font.PLAIN, 20));
		        contentPane.add(lblScore_2);
		        
		        if(players.length > 2) {
		        	
		        	// PLAYER 3
			        JLabel lblPlayer_3 = new JLabel("Player 3");
			        lblPlayer_3.setFont(new Font("Cochin", Font.PLAIN, 20));
			        contentPane.add(lblPlayer_3);
			        
			        JLabel lblPlayerUserName_3 = new JLabel("Username: " + players[2].getUsername());
			        lblPlayer_3.setFont(new Font("Cochin", Font.PLAIN, 20));
			        contentPane.add(lblPlayer_3);
			        
			        ImageIcon image_Player3 = new ImageIcon(players[0].getProfilePhoto());
			        JLabel lblPlayerProfilePhoto_3 = new JLabel(image_Player3);
			        contentPane.add(lblPlayerProfilePhoto_3); 
			        
			        JLabel lblScore_3 = new JLabel("Final Score: " + players[2].getScorePoints());
			        lblScore_3.setBounds(1241, 459, 254, 25);
			        lblScore_3.setFont(new Font("Cochin", Font.PLAIN, 20));
			        contentPane.add(lblScore_3);
		        	
		        }
		        
		        if(players.length > 3) {
		        	
		        	// PLAYER 4
			        JLabel lblPlayer_4 = new JLabel("Player 4");
			        lblPlayer_4.setFont(new Font("Cochin", Font.PLAIN, 20));
			        contentPane.add(lblPlayer_4);
			        
			        JLabel lblPlayerUserName_4 = new JLabel("Username: " + players[3].getUsername());
			        lblPlayer_4.setFont(new Font("Cochin", Font.PLAIN, 20));
			        contentPane.add(lblPlayer_4);
			        
			        ImageIcon image_Player4 = new ImageIcon(players[3].getProfilePhoto());
			        JLabel lblPlayerProfilePhoto_4 = new JLabel(image_Player4);
			        contentPane.add(lblPlayerProfilePhoto_4); 
			        
			        JLabel lblScore_4 = new JLabel("Final Score: " + players[3].getScorePoints());
			        lblScore_4.setBounds(1241, 459, 254, 25);
			        lblScore_4.setFont(new Font("Cochin", Font.PLAIN, 20));
			        contentPane.add(lblScore_4);
		        	
		        }
		        
		        // For displaying user Ingredient with alchemyMarker pair
		        JButton btnShowResult = new JButton("Show Results");
		        btnShowResult.setBounds(89, 75, 127, 29);
		                
		        //Event handler Show Result Button
		        btnShowResult.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		

	          			/////////// Message Dialog Result Token
	          			JFrame frame = new JFrame("ResultToken Dialog");
	          	        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	          	        // Create a panel with a label for text and an image
	          	        JPanel panel = new JPanel(new BorderLayout());
	          	        
	          	        
	          	        Ingredient[] ingredients = IngredientStorage.getAllingredientcardsarray();
	          	        for(Ingredient i: ingredients) {
	          	        	
	          	        	JLabel textLabel = new JLabel("Ingredient - Alchemical pair: " + i.getName() + " - " + i.getAlchemical().getName() , JLabel.CENTER);
	  	          	      
		          	        ImageIcon ingredientImage = new ImageIcon(i.getPhoto()); 
		          	        JLabel ingredientImageLabel = new JLabel(ingredientImage);
		          	        ImageIcon alchemicalImage = new ImageIcon(i.getAlchemical().getAlchemicalPhoto()); 
		          	        JLabel alchemicalImageLabel = new JLabel(ingredientImage);
		          	        panel.add(textLabel, BorderLayout.LINE_START);
		          	        panel.add(ingredientImageLabel, BorderLayout.CENTER);
		          	        panel.add(alchemicalImageLabel, BorderLayout.LINE_END);
		          	        
	          	        }

	          	        // Show the option pane 
	          	        JOptionPane.showMessageDialog(frame, panel, "", JOptionPane.INFORMATION_MESSAGE);

	          	        // Optional: Set frame size and make it visible
	          	        frame.setSize(300, 200);
	          	        frame.setLocationRelativeTo(null); // Center on screen
	          	        frame.setVisible(true);
		        	}
		        });
		        contentPane.add(btnShowResult);
		        
		        
		        JButton btnNewGame = new JButton("New Game");
		        btnNewGame.setBounds(221, 74, 139, 31);
		        //Event handler of the accept button
		        btnNewGame.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		//game = new Game();
		        	}
		        });
		        btnNewGame.setFont(new Font("Cochin", Font.PLAIN, 20));
		        contentPane.add(btnNewGame);

		}
		
		public void displayWinner() {
			
			setVisible(true);
			
		}
}
