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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import domain.Game;
import domain.Game.Controller;
import domain.Player;
import domain.Game.Controller;
import domain.ingredients.Ingredient;
import domain.ingredients.IngredientStorage;
import domain.potion.Potion;
import domain.potion.PotionController;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Menu;

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
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Graphics;

public class PotionBrewingAreaDisplay extends JFrame implements Display {

	private static final long serialVersionUID = 1L;
	PotionController controller = PotionController.getInstance();
	private JPanel contentPane;
	private JPanel experimentPanel;
	private JPanel potionSalePanel;
	private boolean requestAccepted = false;
	private boolean requestDeclined = false;
	private ImageIcon coinIcon;
	private static String testMethod ;
	private Ingredient[] ingredients; 	
	private JList<JPanel> ingredientList;
	private JScrollPane scrollPane_ingredients;
	private final static int IMAGE_WIDTH = 140;
	private static final int IMAGE_HEIGHT = 140;
	private static Ingredient[] chosenIngredients;
	Ingredient ingredientChoice1;
	Ingredient ingredientChoice2;
	private static int guaranteeLevel; //3: Positive, 2: Positive/Neutral 1: No guarantee 
	int coinsEarned = 0; //Shows the coins earned from the potion sale
	

	//Singleton implementation
    private static PotionBrewingAreaDisplay instance;
	
    public static PotionBrewingAreaDisplay getInstance() {
        if (instance == null) {
            instance = new PotionBrewingAreaDisplay();
        }
        return instance;
    }
	
    
	
	/**
	 * Create the frame.
	 */
	public PotionBrewingAreaDisplay() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1440, 800);
		setResizable(false);        
        contentPane = new JPanel();
        
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
        //experimentPanel.setBackground(new Color(237, 238, 238));
        // Make the panel transparent
        experimentPanel.setOpaque(false);
        contentPane.add(experimentPanel);
        experimentPanel.setLayout(null);
        
        JPanel ingredientPanel = new JPanel();
        ingredientPanel.setBounds(0, 74, 854, 139);
        experimentPanel.add(ingredientPanel);
        
        //Scroll pane to hold ingredients
        scrollPane_ingredients = new JScrollPane();
        scrollPane_ingredients.setFont(new Font("Cochin", Font.PLAIN, 13));
        scrollPane_ingredients.setBounds(0, 0, 871, 140);
        scrollPane_ingredients.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane_ingredients.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
       
		ingredientPanel.setLayout(null);
        ingredientPanel.add(scrollPane_ingredients);
        
		//JList ingredientList = new JList<>(ingredientListModel);
        ingredientList = new JList<>();
        ingredientList.setFont(new Font("Cochin", Font.PLAIN, 12));
		JPanel[] ingredientCardPanelsArray = PlayerIngredientList.createIngredientArray(Game.getGame().getCurrPlayer());
		
		//This model allows multiple selecting in a scroll pane
		ingredientList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		
		scrollPane_ingredients.setRowHeaderView(ingredientList);
		ingredientList.setCellRenderer(new ImageListCellRenderer());
		ingredientList.setListData(ingredientCardPanelsArray);
		ingredientList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
	
		//ingredientList.setFixedCellHeight(scrollPane_ingredients.getHeight());
		//ingredientList.setFixedCellHeight(200);
		//ingredientList.setFixedCellWidth(150);
		ingredientList.setVisibleRowCount(1); // Set the visible row count to 1 for horizontal layout

        
		JLabel lblIngredients = new JLabel("INGREDIENTS");
        lblIngredients.setBounds(0, 0, 842, 82);
        experimentPanel.add(lblIngredients);
        lblIngredients.setFont(new Font("Cochin", Font.PLAIN, 45));
        lblIngredients.setHorizontalAlignment(SwingConstants.CENTER);
		
		// TEST PANEL
		
        JPanel testPanel = new JPanel();
        testPanel.setBounds(0, 272, 871, 167);
        // Transparent
        testPanel.setOpaque(false); 
        experimentPanel.add(testPanel);
        testPanel.setLayout(new GridLayout(0, 1, 0, 0));
        
        JLabel lblTestOn = new JLabel("TEST ON");
        lblTestOn.setFont(new Font("Cochin", Font.PLAIN, 45));
        lblTestOn.setHorizontalAlignment(SwingConstants.CENTER);
        testPanel.add(lblTestOn);
        
        JButton btnTestOnPlayer = new JButton("Player");
        btnTestOnPlayer.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		testMethod = "Player";
        		PotionController.getInstance().setTestMethod(testMethod);
        		System.out.println(testMethod);
        	}
        });
        btnTestOnPlayer.setFont(new Font("Cochin", Font.PLAIN, 20));
        testPanel.add(btnTestOnPlayer);
        
        JButton btnTestOnStudent = new JButton("Student");
        btnTestOnStudent.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		testMethod = "Student";
        		PotionController.getInstance().setTestMethod(testMethod);
        		System.out.println(testMethod);
        	}
        });
        btnTestOnStudent.setFont(new Font("Cochin", Font.PLAIN, 20));
        testPanel.add(btnTestOnStudent);
        
        
        // MAKE POTION PANEL
        JPanel makePotionPanel = new JPanel();
        makePotionPanel.setOpaque(false);
        makePotionPanel.setBounds(0, 500, 871, 195);
        experimentPanel.add(makePotionPanel);
        makePotionPanel.setLayout(new GridLayout(0, 1, 0, 0));
        
        JLabel makePotionIcon = new JLabel();
        makePotionIcon.setHorizontalAlignment(SwingConstants.CENTER);
        //makePotionIcon.setBounds(43, 95, 420, 406);
        ImageIcon witchCauldron = new ImageIcon("src/images/witchCauldron.jpg");
        Image witchCauldronImage = witchCauldron.getImage().getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, IMAGE_HEIGHT); // size picture disabling cutting it
        witchCauldron = new ImageIcon(witchCauldronImage);
        makePotionIcon.setIcon(witchCauldron);
        makePotionPanel.add(makePotionIcon);
        
     
        ///////////////////////////////////////////////// 
        
        
        //Panel for potion sale
        potionSalePanel = new JPanel();
        potionSalePanel.setBounds(878, 6, 556, 860);
        //potionSalePanel.setBackground(new Color(237, 238, 238));
        // Make the panel transparent
        potionSalePanel.setOpaque(false);
        contentPane.add(potionSalePanel);
        potionSalePanel.setLayout(null);
        
        //Panel for showing Adventurer's request
        JPanel requestPanel = new JPanel();
        requestPanel.setBackground(new Color(171, 124, 67));
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
        ImageIcon requestedPotionIcon = new ImageIcon("src/images/bottle-icons/bottles.png");
        requestedPotion.setIcon(new ImageIcon(requestedPotionIcon.getImage().getScaledInstance(380, 335, 0)));
        requestPanel.add(requestedPotion);
        
        //Coin photograph for placeholder of information of payed gold amount
        JLabel goldPayment = new JLabel();
        goldPayment.setBackground(new Color(222, 184, 135));
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
        		        
                String[] guaranteeLevels = {"1", "2", "3"};
                String guaranteeLevelStr = (String)JOptionPane.showInputDialog(null,"Choose guarantee level:","Guarantee Level",
                		JOptionPane.QUESTION_MESSAGE,null,guaranteeLevels,guaranteeLevels[0]);
                
                if (guaranteeLevelStr != null) {
	                guaranteeLevel = Integer.valueOf(guaranteeLevelStr);
	                PotionController.getInstance().setGuaranteeLevel(guaranteeLevel);
	                
	        		JOptionPane.showMessageDialog(contentPane,
	        			    "Make potion for Adventurer's request!");  
                }
        		
        		PotionController.getInstance().setSellRequestAccepted(true);
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
      			requestDeclined = true;
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
          			
          		if (Game.getGame().getCurrPlayer().getTurnNumber() == 0) {
          			JOptionPane.showMessageDialog(null, "No turns left! Please end your turn." );
          		}
          		
          		else {
	          		potionIcon.setVisible(false);
	                acceptButton.setVisible(true);
	                declineButton.setVisible(true);
	                requestedPotion.setVisible(true);
	          		Game.getGame().selectController(Controller.SELL_POTION);
	                
          		}
           	}
          });
          
          sellPotionButton.setFont(new Font("Cochin", Font.PLAIN, 30));
            
          //MAKE POTION BUTTON
          JButton btnMakePotion = new JButton("MAKE POTION");
          //btnMakePotion.setBounds(0, 0, 871, 195);
          btnMakePotion.addActionListener(new ActionListener() {
          	public void actionPerformed(ActionEvent e) {
          		
          		// make potion 
          		chosenIngredients = PlayerIngredientList.getChosenIngredients(ingredientList);
          		PotionController.getInstance().setChosenIngredients(chosenIngredients);
          		
          		// end turn
          		if(Game.getGame().getCurrPlayer().getTurnNumber() == 0) {
          			JOptionPane.showMessageDialog(contentPane,
            			    "End Turn, please");   
          		} // ingredient number is not valid
          		else if (chosenIngredients == null || chosenIngredients.length != 2) {
          			JOptionPane.showMessageDialog(contentPane,
            			    "Choose 2 ingredients for making potion!");   
          		}// same ingredients
          		else if (chosenIngredients[0].equals(chosenIngredients[1])) {
          			JOptionPane.showMessageDialog(contentPane,
            			    "Choose different Ingredient, please");   
          		}// not selected option
          		else if (testMethod == null && !(requestAccepted)) {
          			JOptionPane.showMessageDialog(contentPane,
            			    "Choose test method for making potion!");   
          		} else {
          			//Game.setController(Game.Controller.MAKE_EXPERIMENT);
          			Game.getGame().selectController(Controller.MAKE_EXPERIMENT);
          			Potion potion = Game.getGame().getCurrPlayer().getPotions().get(Game.getGame().getCurrPlayer().getPotions().size() - 1);
          			updateIngredient(Game.getGame().getCurrPlayer());

          			/////////// Message Dialog Result Token
          	        // Create a panel with a label for text and an image
          	        JPanel panel = new JPanel(new BorderLayout());
          	        JLabel textLabel = new JLabel("Potion Recipe: " + potion.getRecipe()[0].getName() + " + "+ potion.getRecipe()[1].getName() + " = ", JLabel.CENTER);
          	                 
          	        ImageIcon imageIcon = new ImageIcon(potion.getAlchemyMarker().getIcon()); // Get the path of alchemyMarker
          	        JLabel imageLabel = new JLabel(imageIcon);
          	        panel.add(textLabel, BorderLayout.NORTH);
          	        panel.add(imageLabel, BorderLayout.CENTER);
          	        //
          	        // Show the option pane with the custom panel
          	        
          	        JOptionPane.showMessageDialog(null, panel, "Custom Image Dialog", JOptionPane.INFORMATION_MESSAGE);
          	    
          		}
          		
          		
          		//Action handler for Adventurer's Potion Reuqest
          		if (requestAccepted) {
          			goldPayment.setIcon(null);
          			coinsEarned = controller.getEarnedGoldAmount();
          			goldPayment.setText(String.format("Adventurer payed %d golds to Player!", coinsEarned));

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
          //ImageIcon icon = new ImageIcon("src/images/witchCauldron.jpg");
          //Image img = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
          //icon = new ImageIcon(img);
          makePotionPanel.add(btnMakePotion);

	}
	
    
    public JScrollPane getScrollPane_ingredients() {
		return scrollPane_ingredients;
	}
	public void setScrollPane_ingredients(JScrollPane scrollPane_ingredients) {
		this.scrollPane_ingredients = scrollPane_ingredients;
	}

	public JList<JPanel> getIngredientList() {
		return ingredientList;
	}
	public void setIngredientList(JList<JPanel> ingredientList) {
		this.ingredientList = ingredientList;
	}


	public void initialize() {
		
		setVisible(true);
	}
    
    public void openDialog() {
        // Create a small dialog
        JDialog dialog = new JDialog(this, "In Game Menu", true);
        dialog.setSize(1250, 500);

        // Panel for the buttons in the dialog
        JPanel buttonPanel = new JPanel(new FlowLayout());
        
        String labelText = Display.labelText;
        
        // Buttons in the dialog
        JButton helpButton = new JButton("Help");
        JButton pauseButton = new JButton("Pause");
        JButton exitButton = new JButton("Exit");
        
        
         
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
	public void showResumePausePage() {
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
	
	public int getGuaranteeLevel() {
		return guaranteeLevel;
	}

	public static String getTestMethod() {
		return testMethod;
	}
	
	public Ingredient[] getIngredients() {
		return ingredients;
	}

	public static Ingredient[] getChosenIngredients() {
		//return PlayerIngredientList.getChosenIngredients(ingredientList);
		return chosenIngredients;
    }

	public static void setTestMethod(String testMethod) {
		PotionBrewingAreaDisplay.testMethod = testMethod;
	}

	
	/**
	 * Initialize UI, player cards are updated every time this is called (every button click)
	 * @param player
	 */
	public void updateIngredient(Player player) {

		/*
		if (player.getIngredientCards() == null || player.getIngredientCards().isEmpty()) {
			System.out.println("Player Ingredient Cards null");
			return;			
		}*/
	

		JPanel[] ingredientCardPanelsArray = PlayerIngredientList.createIngredientArray(player);
		ingredientList.setListData(ingredientCardPanelsArray);
		 
		ingredientList.setLayoutOrientation(JList.VERTICAL_WRAP);
		ingredientList.setFixedCellHeight(IMAGE_HEIGHT+50);
		ingredientList.setFixedCellWidth(IMAGE_WIDTH);
		
		int boxWidth = 900; //ingredientScrollPane.getViewport().getSize().width;
		int numberOfImagesInRow = boxWidth/IMAGE_WIDTH;
		ingredientList.setVisibleRowCount((player.getIngredientCards().size()+numberOfImagesInRow-1)/numberOfImagesInRow);
		ingredientList.setSelectedIndex(0);
		scrollPane_ingredients.setViewportView(ingredientList);
		
	}
}
