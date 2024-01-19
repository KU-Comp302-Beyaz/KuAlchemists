package ui;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import domain.Game;
import domain.Game.Controller;
import domain.Player;
import domain.ingredients.Alchemical;
import domain.ingredients.Ingredient;
import domain.ingredients.IngredientStorage;
import domain.publication.PublicationTrack;
import domain.theorydeduction.DeductionBoard;
import domain.theorydeduction.TheoryController;
import java.awt.Font;
import javax.swing.SwingConstants;


public class DeductionBoardDisplay extends JFrame{
	
	
	//Singleton
	private static DeductionBoardDisplay isDisplay = new DeductionBoardDisplay();

	
    public static DeductionBoardDisplay getIsDisplay() {
		return isDisplay;
	}
    
    
    private List<Player> players;
    private int currentPlayerIndex;
    private DeductionBoard currentPlayerDeductionBoard;

	public DeductionBoardDisplay() {
		
		//getContentPane().setBackground(new Color(255, 255, 255));
        getContentPane().setLayout(null);
        JLabel backgroundLabel = new JLabel(new ImageIcon("src/images/board.png"));
        backgroundLabel.setBounds(0, 0, 1440, 800);
        getContentPane().add(backgroundLabel);
        
        
    	setTitle("KuAlchemists");
    	setBounds(0, 0, 1440, 800);
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
    	
  /*
    	JPanel deductionTrianglePanel = new JPanel();
    	deductionTrianglePanel.setBackground(new Color(183, 254, 218));
    	deductionTrianglePanel.setBounds(98, 43, 1089, 272);
    	getContentPane().add(deductionTrianglePanel);
    	deductionTrianglePanel.setLayout(null);
    	*/
        JPanel deductionTrianglePanel = new JPanel();
       //deductionTrianglePanel.setBackground(new Color(183, 254, 218));
        deductionTrianglePanel.setOpaque(false); // make it transparent
        deductionTrianglePanel.setBounds(98, 43, 1089, 272);
        
        ImageIcon triangleImage = new ImageIcon("src/images/deduction_board.png");

        // Create a JLabel to hold the background image
        JLabel triangleLabel = new JLabel(triangleImage);
        triangleLabel.setBounds(0, 0, triangleImage.getIconWidth(), triangleImage.getIconHeight());

        deductionTrianglePanel.add(triangleLabel);
        
        backgroundLabel.add(deductionTrianglePanel);
        deductionTrianglePanel.setLayout(null);

    	
    	
       	JButton b1 = new JButton("");
    	b1.setBounds(92, 237, 60, 29);
    	deductionTrianglePanel.add(b1);
    	/*
    	b1.addActionListener(new ActionListener() {
    		@Override 
    		public void actionPerformed(ActionEvent arg0) {
    			 JFrame newFrame = new JFrame("Select");
    			 newFrame.setSize(400, 300);
    		        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    		         JLabel label = new JLabel("Select one!");
    		         newFrame.add(label);
    		         newFrame.setVisible(true);
    		}
    	});
    	*/


        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b1);
            }
        });
        
    	JButton b2 = new JButton("");
    	b2.setBounds(211, 237, 60, 29);
    	deductionTrianglePanel.add(b2);
    	
    	b2.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b2);
            }
        });
    	
    	
    	JButton b3 = new JButton("");
    	b3.setBounds(336, 237, 60, 29);
    	deductionTrianglePanel.add(b3);
    	
    	b3.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b3);
            }
        });
    	
    	JButton b4 = new JButton("");
    	b4.setBounds(455, 237, 60, 29);
    	deductionTrianglePanel.add(b4);
    	
    	b4.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b4);
            }
        });
    	
    	JButton b5 = new JButton("");
    	b5.setBounds(576, 237, 60, 29);
    	deductionTrianglePanel.add(b5);
    	
    	b5.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b5);
            }
        });
    	
    	JButton b6 = new JButton("");
    	b6.setBounds(698, 237, 60, 29);
    	deductionTrianglePanel.add(b6);
    	
    	b6.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b6);
            }
        });
    	
    	JButton b7 = new JButton("");
    	b7.setBounds(156, 207, 60, 29);
    	deductionTrianglePanel.add(b7);
    	
    	b7.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b7);
            }
        });
    	
    	
    	JButton b8 = new JButton("");
    	b8.setBounds(276, 207, 60, 29);
    	deductionTrianglePanel.add(b8);
    	
    	b8.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b8);
            }
        });
    	
    	JButton b9 = new JButton("");
    	b9.setBounds(466, 178, 60, 29);
    	deductionTrianglePanel.add(b9);
    	
    	b9.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b9);
            }
        });
    	
    	JButton b10 = new JButton("");
    	b10.setBounds(399, 207, 60, 29);
    	deductionTrianglePanel.add(b10);
    	
    	b10.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b10);
            }
        });
    	
    	JButton b11 = new JButton("");
    	b11.setBounds(516, 212, 60, 29);
    	deductionTrianglePanel.add(b11);
    	b11.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b11);
            }
        });
    	
    	JButton b12 = new JButton("");
    	b12.setBounds(817, 237, 60, 29);
    	deductionTrianglePanel.add(b12);
    	b12.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b12);
            }
        });
    	
    	JButton b13 = new JButton("");
    	b13.setBounds(346, 110, 60, 29);
    	deductionTrianglePanel.add(b13);
    	b13.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b13);
            }
        });
    	
    	JButton b14 = new JButton("");
    	b14.setBounds(221, 178, 60, 29);
    	deductionTrianglePanel.add(b14);
    	b14.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b14);
            }
        });
    	
    	JButton b15 = new JButton("");
    	b15.setBounds(276, 146, 60, 29);
    	deductionTrianglePanel.add(b15);
    	b15.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b15);
            }
        });
    	
    	JButton b16 = new JButton("");
    	b16.setBounds(336, 178, 60, 29);
    	deductionTrianglePanel.add(b16);
    	b16.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b16);
            }
        });
    	
    	JButton b17 = new JButton("");
    	b17.setBounds(409, 146, 60, 29);
    	deductionTrianglePanel.add(b17);
    	b17.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b17);
            }
        });
    	
    	JButton b18 = new JButton("");
    	b18.setBounds(409, 69, 60, 29);
    	deductionTrianglePanel.add(b18);
    	b18.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b1);
            }
        });
    	
    	JButton b19 = new JButton("");
    	b19.setBounds(527, 146, 60, 29);
    	deductionTrianglePanel.add(b19);
    	b19.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b19);
            }
        });
    	
    	JButton b20 = new JButton("");
    	b20.setBounds(586, 178, 60, 29);
    	deductionTrianglePanel.add(b20);
    	b20.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b20);
            }
        });
    	
    	JButton b21 = new JButton("");
    	b21.setBounds(638, 207, 60, 29);
    	deductionTrianglePanel.add(b21);
    	b21.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b21);
            }
        });
    	
    	JButton b22 = new JButton("");
    	b22.setBounds(531, 69, 60, 29);
    	deductionTrianglePanel.add(b22);
    	b22.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b22);
            }
        });
    	
    	JButton b23 = new JButton("");
    	b23.setBounds(466, 110, 60, 29);
    	deductionTrianglePanel.add(b23);
    	b23.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b23);
            }
        });
    	
    	JButton b24 = new JButton("");
    	b24.setBounds(643, 146, 60, 29);
    	deductionTrianglePanel.add(b24);
    	b24.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b24);
            }
        });
    	
    	JButton b25 = new JButton("");
    	b25.setBounds(758, 207, 60, 29);
    	deductionTrianglePanel.add(b25);
    	b25.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b25);
            }
        });
    	
    	JButton b26 = new JButton("");
    	b26.setBounds(471, 28, 60, 29);
    	deductionTrianglePanel.add(b26);
    	b26.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b26);
            }
        });
    	
    	JButton b27 = new JButton("");
    	b27.setBounds(698, 178, 60, 29);
    	deductionTrianglePanel.add(b27);
    	b27.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b27);
            }
        });
    	
    	JButton b28 = new JButton("");
    	b28.setBounds(591, 110, 60, 29);
    	deductionTrianglePanel.add(b28);
    	b28.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b28);
            }
        });
    	

  
    	/*	  		
    	JPanel deductionGridPanel = new JPanel();
    	deductionGridPanel.setBounds(98, 314, 1089, 428);
    	getContentPane().add(deductionGridPanel);
    	deductionGridPanel.setBackground(new Color(221, 160, 221));
    	deductionGridPanel.setLayout(new GridLayout(9, 9, 0, 0)); 
    	*/
    	JPanel deductionGridPanel = new JPanel();
    	deductionGridPanel.setBackground(new Color(104, 71, 40));
        deductionGridPanel.setBounds(98, 314, 1089, 428);
        backgroundLabel.add(deductionGridPanel);
        //deductionGridPanel.setBackground(new Color(221, 160, 221));
        deductionGridPanel.setOpaque(false); // make it transparent
        deductionGridPanel.setLayout(new GridLayout(9, 9, 0, 0));
        
        
 	
    	JButton publishButton = new JButton("Publish a Theory");
    	publishButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			if (PublicationTrack.getInstance().getAvailableAlchemicals().isEmpty()) {
    				JOptionPane.showMessageDialog(DeductionBoardDisplay.getIsDisplay(), "There are no Alchemy Markers left to publish theory!","No Alchemy Markers Left",JOptionPane.ERROR_MESSAGE);
    			}
    			else {
    				showIngredientSelectionDialog();
    			}
    		}
    	});
        /*
      	publishButton.setFont(new Font("Cochin", Font.PLAIN, 20));
    	publishButton.setBounds(1243, 322, 165, 88);
    	getContentPane().add(publishButton); */
    	
        publishButton.setFont(new Font("Cochin", Font.PLAIN, 20));
        publishButton.setBounds(1243, 322, 165, 88);
        backgroundLabel.add(publishButton);
       
        JButton nextPlayerButton = new JButton("Next Player");
        nextPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
  
                // Explicitly validate and repaint the content pane
                getContentPane().revalidate();
                getContentPane().repaint();
                initializeGUIComponents();
            	initializeGUIComponents();
            }
        });
        nextPlayerButton.setFont(new Font("Cochin", Font.PLAIN, 20));
        nextPlayerButton.setBounds(1243, 430, 165, 50);
        backgroundLabel.add(nextPlayerButton);
        
    	JLabel titleLabel = new JLabel("Deduction Board");
    	titleLabel.setFont(new Font("Cochin", Font.PLAIN, 30));
    	titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
    	titleLabel.setBounds(584, 6, 266, 25);
    	//getContentPane().add(titleLabel);
        backgroundLabel.add(titleLabel);


    	// Add labels for Y axis (1, 2, 3, ...)
  		for (int i = 0; i < 8; i++) {
  		    JLabel label = new JLabel();
  		    label.setIcon(new ImageIcon(new ImageIcon("src/images/images-icons/ingredient"+(i+1)+".jpg").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
  		    label.setHorizontalAlignment(JLabel.CENTER);
  		    deductionGridPanel.add(label);
  		}
  		
  		
  		for (int i = 0; i < 64; i++) {
  		    // Add labels for X axis (1, 2, 3, ...)
  			int xAxisLabel = i / 8 + 1;
  			if (i % 8 == 0) {
  		        
  		        JLabel label = new JLabel();
  		        deductionGridPanel.add(label);
  		    }
  		    JPanel p = new JPanel();
  		    JLabel l = new JLabel();
  		    l.setIcon(new ImageIcon(new ImageIcon("src/images/alchemical-icons/"+ Alchemical.getAlchemicalphotos()[xAxisLabel-1]+".png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
  		    JButton b = new JButton();
  		    b.setPreferredSize(new Dimension(40 ,40));
  		    b.addActionListener(e -> {
  		    	
  		    	JButton currButton = (JButton) e.getSource();
		            
		            
		            if (currButton.getIcon() == null) {
		            	currButton.setIcon(createScaledImageIcon("src/images/X.png", 40, 40));
		            }
		            else {
		            	currButton.setIcon(null);
		            }
  		    	
  		    });
  		    p.add(l);
  		    p.add(b);
  		    deductionGridPanel.add(p);
	  		    
    	}
  		//-- Menu bar
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
            
            
            
            //back to Board button
        JButton backToBoardButton = new JButton("Back to Board");
        menuBar.add(backToBoardButton);
            
        backToBoardButton.addActionListener(new ActionListener() {
    			
    			@Override
    		public void actionPerformed(ActionEvent e) {
    			BoardWindow board = BoardWindow.getBoardWindow();
    			board.initialize();
    			setVisible(false);
    		}
    	});

}
    	
    private ImageIcon createScaledImageIcon(String path, int width, int height) {
    	ImageIcon icon = new ImageIcon(path);
    	Image image = icon.getImage();
    	Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    	return new ImageIcon(scaledImage);
    }
    	
	//method for menu bar
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
    
    
    
   
    private static void showPhotoSelectionDialog(JButton targetButton) {
        JFrame photoSelectionFrame = new JFrame("Select alchemy marker");

        
        String[] photoPaths = {
        		
        		"src/images/alchemyMarker-icons/blue+.png",
        		"src/images/alchemyMarker-icons/green+.png",
        		"src/images/alchemyMarker-icons/red+.png",
        		"src/images/alchemyMarker-icons/nullnull.png",
        		"src/images/alchemyMarker-icons/blue-.png",
                "src/images/alchemyMarker-icons/green-.png",
                "src/images/alchemyMarker-icons/red-.png"
    
                
        };
        
       
        
        JPanel photoPanel = new JPanel(new GridLayout(2, 4));

        for (String path : photoPaths) {
            ImageIcon icon = new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
            JButton photoButton = new JButton(icon);

            photoButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Set selected photo as the icon of button (b1 b2 ...)
                    targetButton.setIcon(icon);
                    // Close alchemy marker selection frame
                    photoSelectionFrame.dispose();
                }
            });

            photoPanel.add(photoButton);
        }
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(e -> {
        	targetButton.setIcon(null);
        	photoSelectionFrame.dispose();
        });
        photoPanel.add(clearButton);
        JScrollPane scrollPane = new JScrollPane(photoPanel);

        photoSelectionFrame.getContentPane().add(scrollPane);
        photoSelectionFrame.setSize(400, 200);
        photoSelectionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        photoSelectionFrame.setVisible(true);
    }
    
    private void showIngredientSelectionDialog() {
    	
    	JFrame photoSelectionFrame = new JFrame("Select an Ingredient to Publish a Theory");
    	
    	ArrayList<String> photoPaths = new ArrayList<>();
    	for (Ingredient i : PublicationTrack.getInstance().getAvailableIngredients()) {
    		photoPaths.add(i.getPhoto());
    	}
    	ArrayList<JPanel> ingredientPhotos = new ArrayList<>();
    	for (String s : photoPaths) {
    		JPanel p = new JPanel();
    		JLabel l = new JLabel();
    		ImageIcon i = new ImageIcon(new ImageIcon(s).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH),s);
    		l.setIcon(i);
    		p.add(l);
    		ingredientPhotos.add(p);
    	}
    	
    	
    	photoSelectionFrame.setBounds(100, 100, 800, 600);
    	photoSelectionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	photoSelectionFrame.getContentPane().setLayout(null);
    	photoSelectionFrame.setResizable(false);
		
		
		JScrollPane ingredientScrollPane = new JScrollPane();
		ingredientScrollPane.setBounds(6, 54, 788, 400);
		photoSelectionFrame.getContentPane().add(ingredientScrollPane);
		
		JLabel titleLabel = new JLabel("Please Select an Ingredient");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(241, 16, 325, 16);
		photoSelectionFrame.getContentPane().add(titleLabel);
		
		JList theoryList = new JList();
		theoryList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		theoryList.setCellRenderer(new ImageListCellRenderer());
		
		theoryList.setListData(ingredientPhotos.toArray());
		theoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		theoryList.setFixedCellHeight(200);
		theoryList.setFixedCellWidth(150);
		theoryList.setVisibleRowCount(2);
		ingredientScrollPane.setViewportView(theoryList);
		
		JButton selectButton = new JButton("Select ");
		selectButton.setBounds(341, 466, 117, 29);
		selectButton.addActionListener(e -> {
			
			if (theoryList.getSelectedValue() == null) {
				JOptionPane.showMessageDialog(photoSelectionFrame, "Please select an ingredient to publish theory!","Select Ingredient",JOptionPane.ERROR_MESSAGE);
			}
			else {
				JLabel selectedPanel = (JLabel) ((JPanel) theoryList.getSelectedValue()).getComponent(0);
				ImageIcon photo = (ImageIcon) selectedPanel.getIcon();
				Ingredient ing = findIngredientFromPhoto(photo.getDescription());
				photoSelectionFrame.dispose();
				showAlchemicalSelectionDialog(ing);
			}
		});
		photoSelectionFrame.getContentPane().add(selectButton);
		photoSelectionFrame.setVisible(true);
		
    }
    
    private void showAlchemicalSelectionDialog(Ingredient ing) {
    	
    	JFrame photoSelectionFrame = new JFrame("Select an Alchemical to Publish a Theory");
    	
    	ArrayList<String> photoPaths = new ArrayList<>();
    	for (Alchemical a : PublicationTrack.getInstance().getAvailableAlchemicals()) {
    		photoPaths.add(a.getAlchemicalPhoto());
    	}
    	ArrayList<JPanel> alchemicalPhotos = new ArrayList<>();
    	for (String s : photoPaths) {
    		JPanel p = new JPanel();
    		JLabel l = new JLabel();
    		ImageIcon i = new ImageIcon(new ImageIcon(s).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH),s);
    		l.setIcon(i);
    		p.add(l);
    		alchemicalPhotos.add(p);
    	}
    	

    	photoSelectionFrame.setBounds(100, 100, 800, 600);
    	photoSelectionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	photoSelectionFrame.getContentPane().setLayout(null);
    	photoSelectionFrame.setResizable(false);
		
		
		JScrollPane alchemicalScrollPane = new JScrollPane();
		alchemicalScrollPane.setBounds(6, 54, 788, 400);
		photoSelectionFrame.getContentPane().add(alchemicalScrollPane);
		
		JLabel titleLabel = new JLabel("Please Select an Alchemical");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(241, 16, 325, 16);
		photoSelectionFrame.getContentPane().add(titleLabel);
		
		JList alchemicalList = new JList();
		alchemicalList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		alchemicalList.setCellRenderer(new ImageListCellRenderer());
		
		alchemicalList.setListData(alchemicalPhotos.toArray());
		alchemicalList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		alchemicalList.setFixedCellHeight(200);
		alchemicalList.setFixedCellWidth(150);
		alchemicalList.setVisibleRowCount(2);
		alchemicalScrollPane.setViewportView(alchemicalList);
		
		JButton selectButton = new JButton("Select ");
		selectButton.setBounds(341, 466, 117, 29);
		selectButton.addActionListener(e -> {
			
			if (alchemicalList.getSelectedValue()==null) {
				JOptionPane.showMessageDialog(photoSelectionFrame, "Please select an alchemical to publish theory!","Select Alchemical",JOptionPane.ERROR_MESSAGE);
			}
			else {
				JLabel selectedPanel = (JLabel) ((JPanel) alchemicalList.getSelectedValue()).getComponent(0);
				ImageIcon photo = (ImageIcon) selectedPanel.getIcon();
				Alchemical alc = findAlchemicalFromPhoto(photo.getDescription());
				Game.getGame().selectController(Controller.PUBLISH_THEORY);
				TheoryController.getInstance().initPublishTheory(alc, ing);
				photoSelectionFrame.dispose();
				JOptionPane.showMessageDialog(null, Game.getGame().getCurrPlayer().getUsername()+" Succesfully Published a Theory!","Theory Publication Successful!",JOptionPane.PLAIN_MESSAGE);
			}
		});
		photoSelectionFrame.getContentPane().add(selectButton);
		photoSelectionFrame.setVisible(true);
    	
    }
    
    private Ingredient findIngredientFromPhoto(String path) {
    	
    	for (Ingredient i : IngredientStorage.getInstance().getAllingredientcardsarray()) {
    		if (i.getPhoto().equals(path)) {
    			return i;
    		}
    	}
    	return null;
    }
    
    private Alchemical findAlchemicalFromPhoto(String path) {
    	
    	for (Alchemical a : PublicationTrack.getInstance().getAvailableAlchemicals()) {
    		if (a.getAlchemicalPhoto().equals(path))
    			return a;
    	}
    	return null;
    	
    }
    
    
    private void setCurrentPlayerDeductionBoard() {
        // Create a new Deduction Board for the current player
        Player currentPlayer = players.get(currentPlayerIndex);
        currentPlayerDeductionBoard = new DeductionBoard(currentPlayer);

        initializeGUIComponents();
    }

    private void initializeGUIComponents() {
        // Clear the existing components
        getContentPane().removeAll();
        
		//getContentPane().setBackground(new Color(255, 255, 255));
        getContentPane().setLayout(null);
        JLabel backgroundLabel2 = new JLabel(new ImageIcon("src/images/board.png"));
        backgroundLabel2.setBounds(0, 0, 1440, 800);
        getContentPane().add(backgroundLabel2);
        
        
    	setTitle("KuAlchemists");
    	setBounds(0, 0, 1440, 800);
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
  
 
        JPanel deductionTrianglePanel2 = new JPanel();
       //deductionTrianglePanel.setBackground(new Color(183, 254, 218));
        deductionTrianglePanel2.setOpaque(false); // make it transparent
        deductionTrianglePanel2.setBounds(98, 43, 1089, 272);
        
        ImageIcon triangleImage = new ImageIcon("src/images/deduction_board.png");

        // Create a JLabel to hold the background image
        JLabel triangleLabel = new JLabel(triangleImage);
        triangleLabel.setBounds(0, 0, triangleImage.getIconWidth(), triangleImage.getIconHeight());

        deductionTrianglePanel2.add(triangleLabel);
        
        backgroundLabel2.add(deductionTrianglePanel2);
        deductionTrianglePanel2.setLayout(null);

    	
    	
       	JButton b1 = new JButton("");
    	b1.setBounds(92, 237, 60, 29);
    	deductionTrianglePanel2.add(b1);
 


        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b1);
            }
        });
        
    	JButton b2 = new JButton("");
    	b2.setBounds(211, 237, 60, 29);
    	deductionTrianglePanel2.add(b2);
    	
    	b2.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b2);
            }
        });
    	
    	
    	JButton b3 = new JButton("");
    	b3.setBounds(336, 237, 60, 29);
    	deductionTrianglePanel2.add(b3);
    	
    	b3.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b3);
            }
        });
    	
    	JButton b4 = new JButton("");
    	b4.setBounds(455, 237, 60, 29);
    	deductionTrianglePanel2.add(b4);
    	
    	b4.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b4);
            }
        });
    	
    	JButton b5 = new JButton("");
    	b5.setBounds(576, 237, 60, 29);
    	deductionTrianglePanel2.add(b5);
    	
    	b5.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b5);
            }
        });
    	
    	JButton b6 = new JButton("");
    	b6.setBounds(698, 237, 60, 29);
    	deductionTrianglePanel2.add(b6);
    	
    	b6.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b6);
            }
        });
    	
    	JButton b7 = new JButton("");
    	b7.setBounds(156, 207, 60, 29);
    	deductionTrianglePanel2.add(b7);
    	
    	b7.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b7);
            }
        });
    	
    	
    	JButton b8 = new JButton("");
    	b8.setBounds(276, 207, 60, 29);
    	deductionTrianglePanel2.add(b8);
    	
    	b8.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b8);
            }
        });
    	
    	JButton b9 = new JButton("");
    	b9.setBounds(466, 178, 60, 29);
    	deductionTrianglePanel2.add(b9);
    	
    	b9.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b9);
            }
        });
    	
    	JButton b10 = new JButton("");
    	b10.setBounds(399, 207, 60, 29);
    	deductionTrianglePanel2.add(b10);
    	
    	b10.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b10);
            }
        });
    	
    	JButton b11 = new JButton("");
    	b11.setBounds(516, 212, 60, 29);
    	deductionTrianglePanel2.add(b11);
    	b11.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b11);
            }
        });
    	
    	JButton b12 = new JButton("");
    	b12.setBounds(817, 237, 60, 29);
    	deductionTrianglePanel2.add(b12);
    	b12.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b12);
            }
        });
    	
    	JButton b13 = new JButton("");
    	b13.setBounds(346, 110, 60, 29);
    	deductionTrianglePanel2.add(b13);
    	b13.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b13);
            }
        });
    	
    	JButton b14 = new JButton("");
    	b14.setBounds(221, 178, 60, 29);
    	deductionTrianglePanel2.add(b14);
    	b14.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b14);
            }
        });
    	
    	JButton b15 = new JButton("");
    	b15.setBounds(276, 146, 60, 29);
    	deductionTrianglePanel2.add(b15);
    	b15.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b15);
            }
        });
    	
    	JButton b16 = new JButton("");
    	b16.setBounds(336, 178, 60, 29);
    	deductionTrianglePanel2.add(b16);
    	b16.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b16);
            }
        });
    	
    	JButton b17 = new JButton("");
    	b17.setBounds(409, 146, 60, 29);
    	deductionTrianglePanel2.add(b17);
    	b17.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b17);
            }
        });
    	
    	JButton b18 = new JButton("");
    	b18.setBounds(409, 69, 60, 29);
    	deductionTrianglePanel2.add(b18);
    	b18.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b1);
            }
        });
    	
    	JButton b19 = new JButton("");
    	b19.setBounds(527, 146, 60, 29);
    	deductionTrianglePanel2.add(b19);
    	b19.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b19);
            }
        });
    	
    	JButton b20 = new JButton("");
    	b20.setBounds(586, 178, 60, 29);
    	deductionTrianglePanel2.add(b20);
    	b20.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b20);
            }
        });
    	
    	JButton b21 = new JButton("");
    	b21.setBounds(638, 207, 60, 29);
    	deductionTrianglePanel2.add(b21);
    	b21.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b21);
            }
        });
    	
    	JButton b22 = new JButton("");
    	b22.setBounds(531, 69, 60, 29);
    	deductionTrianglePanel2.add(b22);
    	b22.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b22);
            }
        });
    	
    	JButton b23 = new JButton("");
    	b23.setBounds(466, 110, 60, 29);
    	deductionTrianglePanel2.add(b23);
    	b23.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b23);
            }
        });
    	
    	JButton b24 = new JButton("");
    	b24.setBounds(643, 146, 60, 29);
    	deductionTrianglePanel2.add(b24);
    	b24.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b24);
            }
        });
    	
    	JButton b25 = new JButton("");
    	b25.setBounds(758, 207, 60, 29);
    	deductionTrianglePanel2.add(b25);
    	b25.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b25);
            }
        });
    	
    	JButton b26 = new JButton("");
    	b26.setBounds(471, 28, 60, 29);
    	deductionTrianglePanel2.add(b26);
    	b26.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b26);
            }
        });
    	
    	JButton b27 = new JButton("");
    	b27.setBounds(698, 178, 60, 29);
    	deductionTrianglePanel2.add(b27);
    	b27.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b27);
            }
        });
    	
    	JButton b28 = new JButton("");
    	b28.setBounds(591, 110, 60, 29);
    	deductionTrianglePanel2.add(b28);
    	b28.addActionListener(new ActionListener() {
    		@Override 
            public void actionPerformed(ActionEvent arg0) {
                showPhotoSelectionDialog(b28);
            }
        });
    	

  

    	JPanel deductionGridPanel = new JPanel();
        deductionGridPanel.setBounds(98, 314, 1089, 428);
        backgroundLabel2.add(deductionGridPanel);
        //deductionGridPanel.setBackground(new Color(221, 160, 221));
        deductionGridPanel.setOpaque(false); // make it transparent
        deductionGridPanel.setLayout(new GridLayout(9, 9, 0, 0));
        
        
 	
    	JButton publishButton = new JButton("Publish a Theory");
    	publishButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) { 
    			showIngredientSelectionDialog();
    		}
    	});

        publishButton.setFont(new Font("Cochin", Font.PLAIN, 20));
        publishButton.setBounds(1243, 322, 165, 88);
        backgroundLabel2.add(publishButton);
       
        JButton nextPlayerButton = new JButton("Next Player");
        nextPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
      
                getContentPane().revalidate();
                getContentPane().repaint();
                initializeGUIComponents();
            	initializeGUIComponents();
            }
        });
        nextPlayerButton.setFont(new Font("Cochin", Font.PLAIN, 20));
        nextPlayerButton.setBounds(1243, 430, 165, 50);
        backgroundLabel2.add(nextPlayerButton);
        
        
    	JLabel titleLabel = new JLabel("Deduction Board");
    	titleLabel.setFont(new Font("Cochin", Font.PLAIN, 30));
    	titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
    	titleLabel.setBounds(584, 6, 266, 25);
    	//getContentPane().add(titleLabel);
        backgroundLabel2.add(titleLabel);


    	// Add labels for Y axis (1, 2, 3, ...)
  		for (int i = 0; i < 8; i++) {
  		    JLabel label2 = new JLabel();
  		    label2.setIcon(new ImageIcon(new ImageIcon("src/images/images-icons/ingredient"+(i+1)+".jpg").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
  		    label2.setHorizontalAlignment(JLabel.CENTER);
  		    deductionGridPanel.add(label2);
  		}
  		
  		
  		for (int i = 0; i < 64; i++) {
  		    // Add labels for X axis (1, 2, 3, ...)
  			int xAxisLabel = i / 8 + 1;
  			if (i % 8 == 0) {
  		        
  		        JLabel label = new JLabel();
  		        deductionGridPanel.add(label);
  		    }
  		    JPanel p2 = new JPanel();
  		    JLabel l2 = new JLabel();
  		    l2.setIcon(new ImageIcon(new ImageIcon("src/images/alchemical-icons/alchemical"+(xAxisLabel)+".png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
  		    JButton b = new JButton();
  		    b.setPreferredSize(new Dimension(40 ,40));
  		    b.addActionListener(e -> {
  		    	
  		    	JButton currButton = (JButton) e.getSource();
		            
		            
		            if (currButton.getIcon() == null) {
		            	currButton.setIcon(createScaledImageIcon("src/images/X.png", 40, 40));
		            }
		            else {
		            	currButton.setIcon(null);
		            }
  		    	
  		    });
  		    p2.add(l2);
  		    p2.add(b);
  		    deductionGridPanel.add(p2);
	  		    
    	}
  	
 


    }
    public void initialize() {
		setVisible(true);
	}
}
