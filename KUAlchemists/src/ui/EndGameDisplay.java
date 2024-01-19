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
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.Image;
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
				egDisplay = new EndGameDisplay(Game.getGame().getPlayers());// change null
			return egDisplay;
		}
		
		public void initialize() {
			setVisible(true);
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
		        
		        Player winner = Game.getGame().getWinner(players);
		        
		        
		        JLabel lblNewLabel = new JLabel("GAME OVER");
		        lblNewLabel.setBounds(384, 96, 225, 41);
		        lblNewLabel.setFont(new Font("Cochin", Font.BOLD, 35));
		        getContentPane().add(lblNewLabel);
		        contentPane.setLayout(null);
		        
		        JLabel lblNewLabel_1 = new JLabel("Winner: " + winner.getUsername());
		        lblNewLabel_1.setBounds(89, 176, 250, 23);
		        lblNewLabel_1.setFont(new Font("Cochin", Font.PLAIN, 20));
		        contentPane.add(lblNewLabel_1);
		        
		        JLabel lblNewLabel_2 = new JLabel("Winner Score: " + winner.getScorePoints());
		        lblNewLabel_2.setBounds(427, 176, 250, 23);
		        lblNewLabel_2.setFont(new Font("Cochin", Font.PLAIN, 20));
		        contentPane.add(lblNewLabel_2);
		        
		        JLabel lblPlayers = new JLabel("PLAYERS");
		        lblPlayers.setBounds(411, 250, 143, 36);
		        lblPlayers.setFont(new Font("Cochin", Font.BOLD, 30));
		        contentPane.add(lblPlayers);
		        
		        // PLAYER 1
		        JLabel lblPlayer_1 = new JLabel("Player 1");
		        lblPlayer_1.setBounds(100, 300, 69, 23);
		        lblPlayer_1.setFont(new Font("Cochin", Font.PLAIN, 20));
		        contentPane.add(lblPlayer_1);
		        
		        JLabel lblPlayerUserName_1 = new JLabel("Username: " + players[0].getUsername());
		        lblPlayerUserName_1.setFont(new Font("Cochin", Font.PLAIN, 20));
		        lblPlayerUserName_1.setLocation(250, 350);
		        lblPlayerUserName_1.setSize(187, 25);
		        lblPlayer_1.setFont(new Font("Cochin", Font.PLAIN, 20));
		        contentPane.add(lblPlayerUserName_1);
		        
		        ImageIcon image_Player1 = new ImageIcon(players[0].getProfilePhoto());
		        Image scaledImage1 = image_Player1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		        ImageIcon scaledIcon1 = new ImageIcon(scaledImage1);
		        JLabel lblPlayerProfilePhoto_1 = new JLabel(scaledIcon1);
		        lblPlayerProfilePhoto_1.setBounds(100, 350, 100, 100);
		        contentPane.add(lblPlayerProfilePhoto_1);
		        
		        JLabel lblScore_1 = new JLabel("Final Score: " + players[0].getScorePoints());
		        lblScore_1.setBounds(500, 350, 187, 23);
		        lblScore_1.setFont(new Font("Cochin", Font.PLAIN, 20));
		        contentPane.add(lblScore_1);
		        
		        
		        // PLAYER 2
		        JLabel lblPlayer_2 = new JLabel("Player 2");
		        lblPlayer_2.setBounds(100, 475, 69, 23);
		        lblPlayer_2.setFont(new Font("Cochin", Font.PLAIN, 20));
		        contentPane.add(lblPlayer_2);
		        
		        JLabel lblPlayerUserName_2 = new JLabel("Username: " + players[1].getUsername());
		        lblPlayerUserName_2.setFont(new Font("Cochin", Font.PLAIN, 20));
		        lblPlayerUserName_2.setLocation(250, 525);
		        lblPlayerUserName_2.setSize(187, 25);
		        lblPlayer_1.setFont(new Font("Cochin", Font.PLAIN, 20));
		        contentPane.add(lblPlayerUserName_2);		      
		        
		        ImageIcon image_Player2 = new ImageIcon(players[1].getProfilePhoto());
		        Image scaledImage2 = image_Player2.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		        ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);
		        JLabel lblPlayerProfilePhoto_2 = new JLabel(scaledIcon2);
		        lblPlayerProfilePhoto_2.setBounds(100, 525, 100, 100);
		        contentPane.add(lblPlayerProfilePhoto_2); 
		        
		        JLabel lblScore_2 = new JLabel("Final Score: " + players[1].getScorePoints());
		        lblScore_2.setBounds(500, 525, 187, 23);
		        lblScore_2.setFont(new Font("Cochin", Font.PLAIN, 20));
		        contentPane.add(lblScore_2);
		        
		        if(players[2] != null) {
		        	
		        	// PLAYER 3		        	
		        	
			        JLabel lblPlayer_3 = new JLabel("Player 3");
			        lblPlayer_3.setBounds(783, 300, 69, 23);
			        lblPlayer_3.setFont(new Font("Cochin", Font.PLAIN, 20));
			        contentPane.add(lblPlayer_3);
			        
			        JLabel lblPlayerUserName_3 = new JLabel("Username: " + players[2].getUsername());
			        lblPlayerUserName_3.setFont(new Font("Cochin", Font.PLAIN, 20));
			        lblPlayerUserName_3.setLocation(947, 336);
			        lblPlayerUserName_3.setSize(150, 25);
			        lblPlayer_3.setFont(new Font("Cochin", Font.PLAIN, 20));
			        contentPane.add(lblPlayerUserName_3);
			        
			        ImageIcon image_Player3 = new ImageIcon(players[2].getProfilePhoto());
			        Image scaledImage3 = image_Player3.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			        ImageIcon scaledIcon3 = new ImageIcon(scaledImage3);
			        JLabel lblPlayerProfilePhoto_3 = new JLabel(scaledIcon3);
			        lblPlayerProfilePhoto_3.setBounds(783, 350, 100, 100);
			        contentPane.add(lblPlayerProfilePhoto_3); 
			        
			        JLabel lblScore_3 = new JLabel("Final Score: " + players[2].getScorePoints());
			        lblScore_3.setBounds(1161, 334, 254, 25);
			        lblScore_3.setFont(new Font("Cochin", Font.PLAIN, 20));
			        contentPane.add(lblScore_3);
		        	
		        }
		        
		        if(players[3] != null) {
		        	
		        	// PLAYER 4
			        JLabel lblPlayer_4 = new JLabel("Player 4");
			        lblPlayer_4.setBounds(783, 475, 69, 23);
			        lblPlayer_4.setFont(new Font("Cochin", Font.PLAIN, 20));
			        contentPane.add(lblPlayer_4);
			        
			        JLabel lblPlayerUserName_4 = new JLabel("Username: " + players[3].getUsername());
			        lblPlayerUserName_4.setFont(new Font("Cochin", Font.PLAIN, 20));
			        lblPlayerUserName_4.setLocation(947, 527);
			        lblPlayerUserName_4.setSize(150, 25);
			        lblPlayer_4.setFont(new Font("Cochin", Font.PLAIN, 20));
			        contentPane.add(lblPlayerUserName_4);
			        
			        ImageIcon image_Player4 = new ImageIcon(players[3].getProfilePhoto());
			        Image scaledImage4 = image_Player4.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			        ImageIcon scaledIcon4 = new ImageIcon(scaledImage4);
			        JLabel lblPlayerProfilePhoto_4 = new JLabel(scaledIcon4);
			        lblPlayerProfilePhoto_4.setBounds(783, 525, 100, 100);
			        contentPane.add(lblPlayerProfilePhoto_4); 
			        
			        JLabel lblScore_4 = new JLabel("Final Score: " + players[3].getScorePoints());
			        lblScore_4.setBounds(1161, 525, 254, 25);
			        lblScore_4.setFont(new Font("Cochin", Font.PLAIN, 20));
			        contentPane.add(lblScore_4);
		        	
		        }
		        
		        // For displaying user Ingredient with alchemyMarker pair
		        JButton btnShowResult = new JButton("Show Results");
		        btnShowResult.setFont(new Font("Cochin", Font.PLAIN, 20));
		        btnShowResult.setBounds(500, 700, 150, 50);
		              
		        
		      //Event handler Show Result Button
		        btnShowResult.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		

		      			/////////// Message Dialog Result Token
//		      			JFrame frame = new JFrame("ResultToken Dialog");
		      	        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		      	        // Create a panel with a label for text and an image
		      	        JPanel panel = new JPanel();
		      	        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		      	        
		      	        Ingredient[] ingredients = IngredientStorage.getInstance().getAllingredientcardsarray();
		      	        for(Ingredient i: ingredients) {
		      	        	
		      	        	// Create a new panel for each pair (text, ingredientImage, alchemicalImage)
		      	            JPanel pairPanel = new JPanel();
		      	            pairPanel.setLayout(new BoxLayout(pairPanel, BoxLayout.X_AXIS));
		      	        	
		      	        	JLabel textLabel = new JLabel("Ingredient - Alchemical pair \n" + i.getName() + " & " + i.getAlchemical().getName() , JLabel.CENTER);
		      	            //JLabel textLabel = new JLabel("<html><b>Ingredient - Alchemical pair:</b>" + i.getName() + " & " + i.getAlchemical().getName() + "</html>", JLabel.CENTER);

		      	            
		          	        ImageIcon ingredientImage = new ImageIcon(i.getPhoto()); 
		          	        JLabel ingredientImageLabel = new JLabel(new ImageIcon(ingredientImage.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT)));
		          	        
		          	        ImageIcon alchemicalImage = new ImageIcon(i.getAlchemical().getAlchemicalPhoto()); 
		          	        JLabel alchemicalImageLabel = new JLabel(new ImageIcon(alchemicalImage.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT)));
		          	        
		          	        panel.add(textLabel);
		          	        pairPanel.add(ingredientImageLabel);
		          	        pairPanel.add(alchemicalImageLabel);
		          	        panel.add(pairPanel);
		          	        
		      	        }

		      	        // Show the option pane 
		      	        JOptionPane.showMessageDialog(null, panel, "", JOptionPane.INFORMATION_MESSAGE);

		      	        // Optional: Set frame size and make it visible
//		      	        frame.setSize(300, 200);
//		      	        frame.setLocationRelativeTo(null); // Center on screen
//		      	        frame.setVisible(true);
		        	}
		        });
		           
		        contentPane.add(btnShowResult);
		        
		        
//		        JButton btnNewGame = new JButton("New Game");
//		        btnNewGame.setBounds(700, 700, 150, 50);
//		        //Event handler of the accept button
//		        btnNewGame.addActionListener(new ActionListener() {
//		        	public void actionPerformed(ActionEvent e) {
//		        		//game = new Game();
//		        	}
//		        });
//		        btnNewGame.setFont(new Font("Cochin", Font.PLAIN, 20));
//		        contentPane.add(btnNewGame);

		}
		
		public void displayWinner() {
			
			setVisible(true);
			
		}
}
