package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import domain.Game;
import domain.Player;
import domain.ingredients.Ingredient;
import domain.potion.Potion;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BoardWindow extends JFrame {
	
	private static final int IMAGE_WIDTH = 128;

	private static final int IMAGE_HEIGHT = 128;

	private static BoardWindow boardWindow;

    private JPanel contentPane;
    private JPanel contentPane_1;
    private JPanel boardDisplay_1;
    private JLabel lblCurrentPlayer;
    private JTabbedPane tabbedPane;

    private JPanel[] playerDashboards = new JPanel[4];
    private JTextArea[] playerInfoTextAreas = new JTextArea[4];
    private JList<JPanel>[] playerPotionsJLists = new JList[4];
    private JScrollPane[] playerPotionsScrollPanes = new JScrollPane[4];
    private JPanel[][] playerPotionsJPanelsArray = new JPanel[4][20];

	public static void setBoardWindow(BoardWindow boardWindow) {
		BoardWindow.boardWindow = boardWindow;
	}
	
	/**
	 * Singleton implementation
	 * @return unique instance
	 */
	public static synchronized BoardWindow getBoardWindow() {
		if (boardWindow == null)
			boardWindow = new BoardWindow();
		return boardWindow;
	}
	
    
	/**
	 * Initialize UI, player history is updated every time this is called (every button click)
	 * @param player
	 */
	public void rewriteHistory(Player player) {

	    JTextArea textArea = new JTextArea("no history");
	    

	    int index = 0;

	    // find Dashboard index
	    for (int i = 0; i < Game.getGame().getNumberOfPlayers(); i++) {
	        Player p = Game.getGame().getPlayers()[i];
	        if (p.equals(player)) {
	            index = i;
	        }
	    }

	    // update history
	    if (player.getHistory() != null) {
	        textArea = new JTextArea(player.getHistory());
	    }

	    textArea.setEditable(false);

	    // Wrap the JTextArea in a JScrollPane for scrolling
	    JScrollPane scrollPane = new JScrollPane(textArea);
	    scrollPane.setBounds(10, 450, 650, 100);
	    scrollPane.setAutoscrolls(true);

	    // Remove the existing JScrollPane and add the updated one
	    Component[] components = playerDashboards[index].getComponents();
	    for (Component component : components) {
	    	if (component instanceof JScrollPane && component.getBounds().equals(scrollPane.getBounds())) {
	            playerDashboards[index].remove(component);
	            break;
	        }
	    }
	    playerDashboards[index].add(scrollPane);

	    // Repaint the component to reflect the changes
	    playerDashboards[index].revalidate();
	    playerDashboards[index].repaint();
	}



    /**
     * Create the frame.
     */
    private BoardWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1440, 800);
 
        contentPane = new JPanel();
        
     // Add background image
        try {
            BufferedImage backgroundImage1 = ImageIO.read(new File("src/images/board.png"));
            contentPane_1 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(backgroundImage1, 0, 0, getWidth(), getHeight(), this);
                }
            };
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane_1);
        contentPane_1.setLayout(null);
        
        
        JButton ingredientStorageButton = new JButton("Ingredient Storage");
        ingredientStorageButton.setBounds(140, 70, 344, 70);
        contentPane_1.add(ingredientStorageButton);
        ingredientStorageButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				IngredientStorageDisplay isDisplay = IngredientStorageDisplay.getInstance();
				setVisible(false);
				isDisplay.initialize(Game.getGame().getCurrPlayer());
				isDisplay.setVisible(true);
				
			}
		});
        
        JButton artifactStorageButton = new JButton("Artifact Storage");
        artifactStorageButton.setBounds(140, 470, 344, 70);
        contentPane_1.add(artifactStorageButton);
  		artifactStorageButton.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent e) {
				ArtifactDeckDisplay isDisplay = ArtifactDeckDisplay.getArtifactDeckDisplay();
				setVisible(false);
				isDisplay.initialize(Game.getGame().getCurrPlayer());
				isDisplay.setVisible(true);
			}
		});
        
        JButton potionBrewingAreaButton = new JButton("Potion Brewing Area");
        potionBrewingAreaButton.setBounds(140, 170, 344, 70);
        contentPane_1.add(potionBrewingAreaButton);
  		potionBrewingAreaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PotionBrewingAreaDisplay pbdDisplay = new PotionBrewingAreaDisplay();
				pbdDisplay.initialize();
				dispose(); //closes BoardWindow
			}
		});
        
        JButton publicationTrackButton = new JButton("Publication Track");
        publicationTrackButton.setBounds(140, 370, 344, 70);
        contentPane_1.add(publicationTrackButton);
  		publicationTrackButton.addActionListener(e -> {
  			PublicationTrackDisplay ptDisplay = PublicationTrackDisplay.getInstance();
  			setVisible(false);
  			ptDisplay.initialize();
  			
  		});
  		
        
        JButton deductionBoardButton = new JButton("Deduction Board");
        deductionBoardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeductionBoardDisplay dbDisplay = DeductionBoardDisplay.getIsDisplay();
				setVisible(false);
				dbDisplay.initialize();
				dispose(); //closes BoardWindow
			}
		});
        deductionBoardButton.setBounds(140, 270, 344, 70);
        contentPane_1.add(deductionBoardButton);        
        
        
        JButton endTurnButton = new JButton("End Turn");
        endTurnButton.setBounds(190, 636, 244, 60);
        contentPane_1.add(endTurnButton);
  		endTurnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				if (Game.getGame().getGameRound() <= 3) {
					Game.getGame().endTurn();
				}
				else {
					setVisible(false);
					EndGameDisplay.getInstance().displayWinner();
				}
				lblCurrentPlayer.setText("Current Player: " + Game.getGame().getCurrPlayer().getUsername());
			}
		});
  		
  		lblCurrentPlayer = new JLabel("Current Player: " + Game.getGame().getCurrPlayer().getUsername());
	    lblCurrentPlayer.setFont(new Font("Cochin", Font.PLAIN, 20));
	    lblCurrentPlayer.setBounds(190, 567, 400, 46);
	    contentPane_1.add(lblCurrentPlayer);

        //Player Dashboard TabbedPane
        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(600, 70, 760, 626);
        contentPane_1.add(tabbedPane);
        
        for (int i = 0; i < Game.getGame().getNumberOfPlayers(); i++) {
        	
        	// player info
        	Player player = Game.getGame().getPlayers()[i];
        	playerDashboards[i] = new JPanel();
        	tabbedPane.addTab(player.getUsername(), playerDashboards[i]);
        	
        	playerDashboards[i].setLayout(null);
        	JLabel avatarImageLabel = new JLabel(new ImageIcon(player.getProfilePhoto()), JLabel.CENTER);
        	avatarImageLabel.setBounds(6, 6, 128, 128);
        	playerDashboards[i].add(avatarImageLabel);

        	playerInfoTextAreas[i] = new JTextArea("");
        	playerInfoTextAreas[i].setEditable(false);
        	playerInfoTextAreas[i].setBounds(0, 0, 200, 150);
        	
        	JScrollPane playerInfoScrollPane = new JScrollPane(playerInfoTextAreas[i]);
        	playerInfoScrollPane.setFont(new Font("Cochin", Font.PLAIN, 13));
        	playerInfoScrollPane.setBounds(160, 6, 200, 150);
        	playerInfoScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        	playerInfoScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        	playerDashboards[i].add(playerInfoScrollPane);

        	//player potions
			playerPotionsScrollPanes[i] = new JScrollPane();
			playerPotionsScrollPanes[i].setBounds(10, 180, 650, 140);
			playerPotionsScrollPanes[i].setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			playerPotionsScrollPanes[i].setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

			playerPotionsJLists[i] = new JList<JPanel>();
			playerPotionsJLists[i].setCellRenderer(new ImageListCellRenderer());  
			playerPotionsJLists[i].setSelectionModel(new NoSelectionModel());
			
			playerPotionsScrollPanes[i].setViewportView(playerPotionsJLists[i]);
			playerDashboards[i].add(playerPotionsScrollPanes[i]);
        	
        	//player history
        	rewriteHistory(player);	
		}
        
        initializeDashboard();

   
        // Menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("Menu");
        menuBar.add(fileMenu);

        JMenuItem openDialogMenuItem = new JMenuItem("Open Menu");
        fileMenu.add(openDialogMenuItem);

        // Add ActionListener to open the dialog when the menu item is clicked
        openDialogMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openDialog();
            }
        });
        }
    
    
	public void updatePlayerPotionsList(Player player, int i) {
		playerPotionsJPanelsArray[i] = createPlayerPotionsJPanelArray(player);
		playerPotionsJLists[i].setListData(playerPotionsJPanelsArray[i]);
		playerPotionsJLists[i].setLayoutOrientation(JList.VERTICAL_WRAP);
		playerPotionsJLists[i].setFixedCellHeight(IMAGE_HEIGHT+50);
		playerPotionsJLists[i].setFixedCellWidth(IMAGE_WIDTH);
		playerPotionsJLists[i].setVisibleRowCount(1);
		playerPotionsJLists[i].setSelectedIndex(0);
		playerPotionsScrollPanes[i].setViewportView(playerPotionsJLists[i]);
	}
	
	/**
	 * Creates the array of player potions
	 * @param player
	 * @return 
	 * @return Jpanel array of player potions to be put into JList
	 */

  public JPanel[] createPlayerPotionsJPanelArray(Player player) {
		JLabel label;
		JPanel panel;
		ArrayList<JPanel> playerPotionJPanels = new ArrayList<JPanel>(0);
		
		for (Potion potion : player.getPotions()) {
			ImageIcon potionImage = new ImageIcon(new ImageIcon(potion.getAlchemyMarker().getIcon()).getImage()
					.getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_SMOOTH));
			
			label = new JLabel(potionImage, JLabel.LEFT);
			label.setHorizontalTextPosition(JLabel.CENTER);
			label.setVerticalTextPosition(JLabel.BOTTOM);
			
			panel = new JPanel();
			panel.add(label);
			playerPotionJPanels.add(panel);
		}
		
		System.out.println("size of potions is " + playerPotionJPanels.size());

		return playerPotionJPanels.toArray(new JPanel[playerPotionJPanels.size()]);
	}

    
	private void initializeDashboard() {
        for (int i = 0; i < Game.getGame().getNumberOfPlayers(); i++) {
        	Player player = Game.getGame().getPlayers()[i];
        	playerInfoTextAreas[i].setText(player.getPlayerInfo());
        	updatePlayerPotionsList(player,i);
        	
		}
	}

	

        
    private void openDialog() {
        // Create a small dialog
        JDialog dialog = new JDialog(this, "In Game Menu", true);
        dialog.setSize(1250, 500);

        // Panel for the buttons in the dialog
        JPanel buttonPanel = new JPanel(new FlowLayout());
        

        // Buttons in the dialog
        JButton helpButton = new JButton("Help");
        JButton pauseButton = new JButton("Pause");
        JButton exitButton = new JButton("Exit");
      
        
        // JLabel için HTML formatında metin
        String labelText = "<html><h1> Welcome to KU Alchemists: The Academic Concoction Help</h1><br><br>"
                + "<h2> Game Overview:</h2>"
                + " KU Alchemists is an engaging board game that thrusts players into the captivating world of potion-making and deduction.<br> Inspired by the acclaimed \"Alchemists\" game[1], KU Alchemists challenges players to become ambitious alchemists, unravel the secrets of magical ingredients, and craft powerful potions.<br> Success in this game requires a blend of wit, strategy, and intuition.<br>"
        		+ "<br><h2> Game Phases:</h2>"
        		+ " The game unfolds in the prestigious Alchemical University, where each player takes on the role of a dedicated alchemist striving for recognition and influence.<br> By conducting experiments, publishing theories, and navigating the complexities of alchemy, players earn reputation points and ascend the ranks of the Alchemical community.<br>"
        		+ "<br><h2> Game Rounds:</h2>"
        		+ "<br><h3> First Round:</h3>"
        		+ " There are four allowed actions for the first round:<br> Forage for Ingredient, Transmute Ingredient, Make Experiments and Buy Artifacts"
        		+ "<br><h4> Forage for Ingredient:</h4>"
        		+ " When it is your turn to forage for an ingredient, you may draw 1 random ingredient from the top of the deck."
        		+ "<br><h4> Transmute Ingredient:</h4>"
        		+ " When you play this action, discard 1 ingredient and take 1 gold piece from the bank.<br> Whenever you discard ingredients, no one else gets to see what you discarded. <h5>Hint:</h5> This is a quick way to get the gold piece you really need ... or an inefficient way to get the two gold pieces you really, really need.<br> Skilled alchemists, however, will make most of their money by earning grants and selling potions to adventurers."
        		+ "<br><h4> Buy Artifacts:</h4>"
        		+ " When you buy an artifact, take one of the cards in the artifact deck and pay 3 golds.<br> Keep your artifacts on the table in front of you where everyone can see them.<br> Artifacts have effects that last the entire game.<br> If an effect does not specify that it is limited to once per round, then you can use it every time it applies.<br> Other artifacts have an immediate effect that can be used only once. Using this effect is part of your Buy Artifact action."
        		+ "<br><h4> Make Experiments:</h4>" 
        		+ " You can make experiments where you mix two ingredients and see what happens. You can test your potion on a student or yourself.<br> The procedure for mixing a potion is the same whether you are Testing on a Student or Drinking the Potion yourself:"
        		+ "  - Choose 2 of your ingredient cards to mix.<br>"
        		+ "  - Choose whether you want to test it on a student or yourself.<br>"
        		+ "  - Click a button to mix the selected ingredients. <br>"
        		+ "  - See the results of your experiment. <br>"
        		+ "  - Put the corresponding result token in your results triangle. <br>"
        		+ "  - Show the result to the other players.<br> Yes, they will learn which potion you <br>"
        		+ "        		made, but they will not know which ingredients you used.<br> Put the corresponding result token on your player board, to remind the other players that you have made that potion <br>"
        		+ "  - Discard the ingredients you used.<br>"
        		+ " When you mix two ingredients, you may get positive, negative or a neutral potion.<br> If you get a negative potion and test it on a student, you will lose 1 gold. <br> However, if the potion is negative and you test it on yourself, you get sick. <br> If your sickness level increases to 3, e.g., you get sick 3 times, you lose all of your golds to have surgery and get well.<br> If you have a healing potion (a positive potion), you can use it to decrease your sickness level by 1. <br>"
        		+ "<br><h3> Second Round:</h3>"
        		+ " In the second round, two more actions are allowed in addition to the actions in the first round: Sell a Potion and Publish a Theory."
        		+ "<br><h4> Sell a Potion:</h4>" 
        		+ " You can sell the potion that you get to an adventurer (the system) if you want. You can ask for 1 to 3 golds to sell your potion. <br> If you guarantee that it is a positive potion, the adventurer is willing to pay you 3 gold pieces. <br> If you say that it is either positive or a neutral potion, he pays you 2 gold pieces.<br> He pays you only 1 gold piece in case you do not guarantee that it is not a negative potion."
        		+ "<br><h4> Publish a Theory:</h4>" 
        		+ " You can publish a theory about an ingredient when you know it's alchemical. <br> Or when you think you know. Or when you’re sure no one else knows, either.<br> It’s up to you to decide whether to take a risk and publish early or to wait until you are certain. To publish a theory:<br>"
        		+ "  - Pick up one of the alchemy markers and place it on one of the books on the theory board. <br> This is your public statement about the true identity of the ingredient depicted in that book.<br>"
        		+ "  - Now pay your publisher! You give 1 gold piece to the bank.<br>"
        		+ "  - Once you have published your theory, gain 1 point of reputation.<br>"
        		+ "  - You can publish a theory only about an ingredient that does not currently have an alchemy marker on it. <br>"
        		+ " You can use only a marker that is not currently assigned to any ingredient. The reason for this is simple: Each alchemy marker corresponds to exactly 1 ingredient. <br> Each ingredient corresponds to exactly 1 alchemical. So any other theory involving that alchemical or ingredient would contradict the published theory.<br> You can try to tell the publisher that the other theory is wrong, but the publisher will not believe you. <br>"
        		+ " That other theory is published; yours is not. Clearly, the published theory is the more credible one. <br> You can unmask their incompetence next round. See Debunk Theory on the next round. <br>"
        		+ "<br><h3> Final Round:</h3>"
        		+ " In the final round, you can Debunk or Endorse a Theory in addition to the actions allowed in the first two rounds. "
        		+ "<br><h4> Debunk a Theory:</h4>" 
        		+ " If you think a published theory is wrong and prove that, you gain 2 points of reputation. <br>" 
        		+ " Of course, anyone with a seal on that theory is at risk of losing reputation. <br>"
        		+ " To debunk a theory, you just need to show that one of the aspects is wrong. <br>"
        		+ " Tap the ingredient of the theory you are trying to debunk. Tap the aspect you are hoping to prove wrong. <br>"
        		+ " The system will show everyone the sign of that aspect of that ingredient. <br>"
        		+ " Compare it with the alchemical token on that theory. <br>"
        		+ " If the sign on the screen matches the sign of that aspect on the token, you have failed to debunk the theory. <br>"
        		+ " (That doesn't mean it's correct. It just means you have failed to prove it is incorrect.) <br>"
        		+ " You lose 1 point of reputation for wasting your colleagues' time.<br>"
        		+ " If the sign on the screen is the opposite of the sign of that aspect on the token, you have debunked the theory. <br>"
        		+ " In either case, everyone now knows the sign of that aspect for that ingredient. <br>"
        		+ " They can mark that information in their deduction grid.<br>"
        		+ " When using this action, you are not allowed to choose an ingredient that doesn't have a published theory.<br>"
        		+ "<br><h3> Final Scoring:</h3>"
        		+ " Each reputation point a player has at the end of the game becomes 10 score points in the final score.<br>"
        		+ " If a player has any artifact cards left in his/her hand, he/she exchanges each artifact card for 2 gold pieces. <br>"
        		+ " Score one-third of a score point for each gold piece. <br> Meaning that, buy 1 score point for every 3 gold pieces, and keep any leftover gold pieces as a tiebreaker <br>"
        		+ " The winner of the game is the player with the most score points. Break ties using leftover gold pieces.<br> If players are still tied, they remain tied. Well done! <br>"
        		+ "<br><h2> Game Components:</h2>"
        		+ "<h3> Board:</h3> Represents the laboratory setting where players conduct experiments.<br>"
        		+ "<h3> Player Tokens:</h3> Unique avatars tracking player position, resources, and scores.<br>"
        		+ "<h3> Ingredients:</h3> Various types with unique attributes, stored in the Ingredient Storage area.<br>"
        		+ "<h3> Potions:</h3> Primary objective cards with unique recipes and point values.<br>"
        		+ "<h3> Publication Cards:</h3> Represent theories or publications with specific requirements.<br>"
        		+ "<h3> Artifact Cards:</h3> Special cards providing unique abilities or effects lasting the entire game.<br>"
        		+ "<h3> Alchemy Markers:</h3> Used to track players' hypotheses about ingredient properties.<br>"
        		+ "<h3> Deduction Board:</h3> Dedicated area for forming and testing theories about ingredient properties.<br>"
        		+ "<br><h2> Screens:<h2>"
        		+ "<h3> Main Game Screen:</h3> Displays the entire game board and comprehensive information about each player's resources, scores, and progress.<br>"
        		+ "<h3> Player Dashboard:</h3> Showcases the current player's avatar, available resources, and interactive buttons for actions.<br>"
        		+ "<h3> Ingredient Storage:</h3> Visual representation of the Ingredient Storage area on the board.<br>"
        		+ " Allows players to interact with this area to collect ingredients as needed for potion-making.<br>"
        		+ "<h3> Potion Brewing Area:</h3> Visual representation of the Potion Brewing Area on the board.<br>"
        		+ " Allows players to interact with this area to combine ingredients and brew potions following the game rules. <br>"
        		+ "<h3> Publication Area:</h3> Displays available Publication Cards and outlines their specific requirements.<br>"
        		+ " Facilitates players in submitting theories and claiming points upon fulfilling the card requirements.<br>"
        		+ "<h3> Deduction Board:</h3> Visual representations with interactive functionalities.<br> Such as placing alchemy markers to create and test theories about ingredient properties.<br>"
        		+ "<h3> Game Log:</h3> Logs actions taken during the game for reference.<br>"
        		+ "<h3> End Game Screen:</h3> Appears at the conclusion of the game, displaying final scores and announcing the winner.<br>"
        		+ " Offers an option for players to initiate a new game, ensuring a smooth transition to the next round of gameplay.<br>"
        		+ "<br><h2> Game Play:<h2>"
        		+ "<h3> Game Setup:</h3> Two-player game with three rounds. Players login with a unique username and select an avatar. Rounds include specific allowed actions.<br>"
        		+ "<h3> Actions:</h3> Forage for Ingredient, Transmute Ingredient, Make Experiments, Buy Artifacts, Sell a Potion, Publish a Theory, Debunk or Endorse a Theory.<br>"
        		+ "<h3> Scoring:</h3> Reputation points, artifact card conversion, and gold piece conversion contribute to final scores.<br>"
        		+ "<br><h2> Game Features:</h2>"
        		+ "<h3> Pause/Resume:</h3> Players can pause the game and resume later.<br>"
        		+ "<h3> Help Screen:</h3> Provides information about game objects, features, and how to play.<br>"
        		+ "<h3> Login Screen:</h3> Appears before the game starts, allowing players to enter a unique username and select an avatar.<br>"
        		+ "<h3> Game Over Screen:</h3> Appears at the end of the game, displaying final scores and announcing the winner."
                + "</html>";
        
        JLabel lblHelp = new JLabel(labelText);

        // Add ActionListener to the "Exit" button to close the dialog
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(dialog, "Game Paused");
                 showResumePausePage();
                    //  Hide the "Pause Game" button and show the "Resume Game" button
                    pauseButton.setVisible(false);
                    //resumeButton.setVisible(true);
                    dialog.dispose();
                
            }
        });

        // Add buttons to the panel
        buttonPanel.add(helpButton);
        buttonPanel.add(pauseButton);
        buttonPanel.add(exitButton);
        
        // Panel for Help
        JScrollPane helpPanel = new JScrollPane(lblHelp);
        // Sadece dikey kaydırma çubuğunu göster
        helpPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        // Yatay kaydırma çubuğunu gizle
        helpPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        //helpPanel.setVisible(false);  // Başlangıçta gizle

        // Add the panel to the dialog
        dialog.getContentPane().add(buttonPanel,BorderLayout.NORTH);
        dialog.getContentPane().add(helpPanel,BorderLayout.CENTER);
        

        
        // Add ActionListener to the helpButton to change the visibility of Help panel
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	//  Change the visibility of Help label
            	helpPanel.setVisible(! helpPanel.isVisible());
            	
            }
        });

        // Set the dialog location relative to the main frame
        dialog.setLocationRelativeTo(this);

        // Make the dialog visible
        dialog.setVisible(true);
    }
    
    
    private void showResumePausePage() {    
        
        JDialog dialog = new JDialog(this, "In Game Menu", true);
        dialog.setSize(300, 150);

        // Panel for the buttons in the dialog
        JPanel buttonPanel = new JPanel(new FlowLayout());

        // Buttons in the dialog
        JButton resumeButton = new JButton("Resume Game");
        
        resumeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(dialog, "Game Resumed");
               // Hide the "Resume Game" button and show the "Pause Game" button
                resumeButton.setVisible(false);
              // pauseButton.setVisible(true);
                                        
                dialog.dispose();

            }
        });
        
        // Add buttons to the panel
        buttonPanel.add(resumeButton);

        // Add the panel to the dialog
        dialog.getContentPane().add(buttonPanel);

        // Set the dialog location relative to the main frame
        dialog.setLocationRelativeTo(this);

        // Make the dialog visible
        dialog.setVisible(true);
  
    }
    
    public void initialize() {
    	initializeDashboard();
		setVisible(true);
	}
    
	public JPanel[] getPlayerDashboards() {
		return playerDashboards;
	}
	public void setPlayerDashboards(JPanel[] playerDashboards) {
		this.playerDashboards = playerDashboards;
	}	

}
   