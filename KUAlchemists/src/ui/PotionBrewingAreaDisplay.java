package ui;

import java.awt.EventQueue;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListModel;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JToolBar;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListCellRenderer;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class PotionBrewingAreaDisplay extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JPanel experimentPanel;
	JPanel potionSalePanel;
	private boolean requestAccepted = false;
	ImageIcon coinIcon;
	
	//Singleton implementation
    private static PotionBrewingAreaDisplay instance;
	
    public static PotionBrewingAreaDisplay getPotionBrewingAreaDisplay() {
        if (instance == null) {
            instance = new PotionBrewingAreaDisplay();
        }
        return instance;
    }
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
	public PotionBrewingAreaDisplay() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1440, 800);
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH); // automatically extends frame to desktop size (full size)
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

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
	
      
        
        //Panel to make and test experiments 
        experimentPanel = new JPanel();
        experimentPanel.setBounds(6, 6, 860, 860);
        experimentPanel.setBackground(new Color(237, 238, 238));
        contentPane.add(experimentPanel);
        experimentPanel.setLayout(null);
        
        JPanel ingredientPanel = new JPanel();
        ingredientPanel.setBounds(0, 74, 854, 139);
        experimentPanel.add(ingredientPanel);
        
        
        JScrollPane scrollPane_ingredients = new JScrollPane();
        scrollPane_ingredients.setBounds(0, 0, 871, 140);
        scrollPane_ingredients.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane_ingredients.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        
        
        /**
		 * Taking the ingredients images from the Images/images-icons/ folder 
		 */
		DefaultListModel<JPanel> ingredientListModel = new DefaultListModel<>();

		JLabel[] ingredientsIcons = new JLabel[12];
		JPanel[] ingredientPanels = new JPanel[12];
		for (int i = 0; i < 12; i++) {
			ImageIcon imageIcon = new ImageIcon("src/images/images-icons/ingredient"+(i+1)+".jpg");
			Image image = imageIcon.getImage();
			Image scaledImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			imageIcon = new ImageIcon(scaledImage);
			
			ingredientsIcons[i] = new JLabel("", imageIcon, JLabel.CENTER);
			ingredientPanels[i] = new JPanel();
		    ingredientListModel.addElement(ingredientPanels[i]);
			//avatarPanels[i].setMaximumSize();
			//avatarPanels[i].setLayout(new BoxLayout(avatarPanels[i], BoxLayout.X_AXIS));
			//avatarPanels[i].setPreferredSize(new Dimension(avatarPanels[i].getPreferredSize().width, scrollPane_ingredients.getHeight()));
		       
			ingredientPanels[i].add(ingredientsIcons[i]);
		}
		ingredientPanel.setLayout(null);
        ingredientPanel.add(scrollPane_ingredients);
        
		JList ingredientList = new JList<>(ingredientListModel);
		
		//This model allows multiple selecting in a scroll pane
        ListSelectionModel selectionModel = ingredientList.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        ingredientList.setSelectionModel(selectionModel);
        
		scrollPane_ingredients.setViewportView(ingredientList);
		ingredientList.setCellRenderer(new ImageListCellRenderer());
		ingredientList.setListData(ingredientPanels);
		ingredientList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		//ingredientList.setFixedCellHeight(scrollPane_ingredients.getHeight());
		//ingredientList.setFixedCellHeight(200);
		//ingredientList.setFixedCellWidth(150);
		ingredientList.setVisibleRowCount(1); // Set the visible row count to 1 for horizontal layout
		ingredientList.setSelectedIndex(0);
        
        
        
        JPanel testPanel = new JPanel();
        testPanel.setBounds(0, 272, 871, 167);
        experimentPanel.add(testPanel);
        testPanel.setLayout(new GridLayout(0, 1, 0, 0));
        
        JLabel lblTestOn = new JLabel("TEST ON");
        lblTestOn.setFont(new Font("Cochin", Font.PLAIN, 45));
        lblTestOn.setHorizontalAlignment(SwingConstants.CENTER);
        testPanel.add(lblTestOn);
        JButton btnTestOnPlayer = new JButton("Player");
        btnTestOnPlayer.setFont(new Font("Cochin", Font.PLAIN, 20));
        testPanel.add(btnTestOnPlayer);
        
        JButton btnTestOnStudent = new JButton("Student");
        btnTestOnStudent.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnTestOnStudent.setFont(new Font("Cochin", Font.PLAIN, 20));
        testPanel.add(btnTestOnStudent);
        
        JPanel makePotionPanel = new JPanel();
        makePotionPanel.setBounds(0, 500, 871, 195);
        experimentPanel.add(makePotionPanel);
        makePotionPanel.setLayout(new BorderLayout(0, 0));
       
        JLabel lblIngredients = new JLabel("INGREDIENTS");
        lblIngredients.setBounds(0, 0, 842, 82);
        experimentPanel.add(lblIngredients);
        lblIngredients.setFont(new Font("Cochin", Font.PLAIN, 45));
        lblIngredients.setHorizontalAlignment(SwingConstants.CENTER);
        
     
        //////////////////////////////// 
        
        
        //Panel for potion sale
        potionSalePanel = new JPanel();
        potionSalePanel.setBounds(878, 6, 556, 860);
        potionSalePanel.setBackground(new Color(237, 238, 238));
        contentPane.add(potionSalePanel);
        potionSalePanel.setLayout(null);
        
        //Panel for showing Adventurer's request
        JPanel requestPanel = new JPanel();
        requestPanel.setBackground(new Color(214, 244, 215));
        requestPanel.setForeground(new Color(204, 204, 255));
        requestPanel.setBounds(47, 22, 488, 675);
        potionSalePanel.add(requestPanel);
        requestPanel.setLayout(null);
        
        //Title of the Adventurer's panel
        JLabel adventurerRequestTitle = new JLabel("ADVENTURER'S REQUEST");
        adventurerRequestTitle.setBounds(24, 21, 439, 42);
        adventurerRequestTitle.setFont(new Font("Cochin", Font.PLAIN, 32));
        requestPanel.add(adventurerRequestTitle);
        
        //Adding placeholder photograph for Adventurer's Request
        JLabel potionIcon = new JLabel();
        potionIcon.setBounds(43, 95, 420, 406);
        ImageIcon elixirBottle = new ImageIcon("src/images/potions/elixir-bottle-1.png");
        Image elixirImage = elixirBottle.getImage().getScaledInstance(420, 406, 0);
        elixirBottle = new ImageIcon(elixirImage);
        potionIcon.setIcon(elixirBottle);
        requestPanel.add(potionIcon);
        
        //Requested potion after clicking "SELL POTION" button
        JLabel requestedPotion = new JLabel();
        requestedPotion.setBounds(61, 75, 380, 335);
        ImageIcon requestedPotionIcon = new ImageIcon("src/images/potions/potion-1.png");
        Image requestedPotionImage = requestedPotionIcon.getImage().getScaledInstance(380, 335, 0);
        requestedPotionIcon = new ImageIcon(requestedPotionImage);
        requestedPotion.setIcon(requestedPotionIcon);
        requestPanel.add(requestedPotion);
        requestedPotion.setVisible(false);
        
        //Coin photograph for placeholder of information of payed gold amount
        JLabel goldPayment = new JLabel();
        goldPayment.setBackground(new Color(203, 217, 192));
        goldPayment.setOpaque(true);
        goldPayment.setBounds(43, 522, 420, 48);
        coinIcon = new ImageIcon("src/images/coin.png");
        Image coinImage = coinIcon.getImage().getScaledInstance(50, 48, 0);
        coinIcon = new ImageIcon(coinImage);
        goldPayment.setIcon(coinIcon);
        goldPayment.setHorizontalAlignment(SwingConstants.CENTER);
        requestPanel.add(goldPayment);
             
        
        //Button for accepting Adventurer's request
        JButton acceptButton = new JButton("ACCEPT");
        acceptButton.setBounds(61, 435, 380, 31);
        
        //Event handler of the accept button
        acceptButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		String guaranteeLevel = JOptionPane.showInputDialog("Enter your guarantee level (1: Positive 2: Positive or Neutral 3: No Guarantee)");
        		
        		JOptionPane.showMessageDialog(contentPane,
        			    "Make potion for Adventurer's request!");   
        		
        		requestAccepted = true;
        	}
        });
        acceptButton.setFont(new Font("Cochin", Font.PLAIN, 20));
        
        requestPanel.add(acceptButton);
        
        //Button for declining Adventurer's request
        JButton declineButton = new JButton("DECLINE");
        declineButton.setBounds(61, 470, 380, 31);
        
        //Event handler of the DeclineButton
        declineButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	
          		potionIcon.setVisible(true);
                acceptButton.setVisible(false);
                declineButton.setVisible(false);
                requestedPotion.setVisible(false);
      			goldPayment.setText(null);
      			goldPayment.setIcon(coinIcon);


        		JOptionPane.showMessageDialog(contentPane,
        			    "Adventurer's request is declined. Player's turn count remains the same!",
        			    "Potion Request Decline",
        			    JOptionPane.WARNING_MESSAGE);

        		
        	}
        });
        declineButton.setFont(new Font("Cochin", Font.PLAIN, 20));
        
        requestPanel.add(declineButton);
        
          
          JButton sellPotionButton = new JButton("SELL A POTION");
          sellPotionButton.setBounds(43, 593, 420, 43);
          requestPanel.add(sellPotionButton);
          
          //Event handler for Sell Potion button
          sellPotionButton.addActionListener(new ActionListener() {
          	public void actionPerformed(ActionEvent e) {
          		potionIcon.setVisible(false);
                acceptButton.setVisible(true);
                declineButton.setVisible(true);
                requestedPotion.setVisible(true);
          	}
          });
          
          sellPotionButton.setFont(new Font("Cochin", Font.PLAIN, 30));
            
          //MAKE POTION BUTTON
          JButton btnMakePotion = new JButton("MAKE POTION");
          btnMakePotion.addActionListener(new ActionListener() {
          	public void actionPerformed(ActionEvent e) {
          		
          		//Action handler for Adventurer's Potion Reuqest
          		if (requestAccepted) {
          			goldPayment.setIcon(null);
          			goldPayment.setText("Adventurer payed 2 golds to Player!");
          			goldPayment.setIcon(coinIcon);
          			
              		potionIcon.setVisible(true);
                    acceptButton.setVisible(false);
                    declineButton.setVisible(false);
                    requestedPotion.setVisible(false);
          		
          		}
          		
          		
          	}
          });
          btnMakePotion.setFont(new Font("Cochin", Font.PLAIN, 20));
          //ImageIcon icon = createImageIcon("path/to/your/image.jpg"); // Replace with the actual path to your image
          ImageIcon icon = new ImageIcon("src/images/witchCauldron.jpg");
          Image img = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
          icon = new ImageIcon(img);
          
          btnMakePotion.setIcon(icon);
          // Use BoxLayout to arrange the components vertically
          btnMakePotion.setLayout(new BoxLayout(btnMakePotion, BoxLayout.Y_AXIS));
          
          makePotionPanel.add(btnMakePotion, BorderLayout.CENTER);
          

	}
	
    
    public void initialize() {
		
		setVisible(true);
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
    

	//method for menu bar
	protected void showResumePausePage() {
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
}
