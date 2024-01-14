package ui;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.ScrollPane;

import domain.Game;
import domain.Game.Controller;
import domain.Player;
import domain.ingredients.Ingredient;
import domain.ingredients.IngredientController;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListSelectionModel;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Component;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.SwingConstants;

public class IngredientStorageDisplay extends JFrame implements Display {

	//fields
	private final int IMAGE_WIDTH = 140, IMAGE_HEIGHT = 140;
	private final int SCREEN_WIDTH = 1440, SCREEN_HEIGHT = 800;
	
	private JLabel ingredientDisplayLabel;
	private JButton forageForIngredientButton;
	private JButton transmuteIngredientButton;
	
	private JList<JPanel> ingredientList;
	private JScrollPane ingredientScrollPane;

	private JList<JPanel> allIngredientsList;
	private JScrollPane allIngredientsScrollPane;
	private JPanel[] allIngredientJListPanels;
	private Ingredient[] allIngredientCards;
	
	private HashMap<JLabel, Ingredient> playerIngredientJListLabels = new HashMap<JLabel, Ingredient>();
	private ArrayList<JPanel> playerIngredientJListPanels = new ArrayList<JPanel>();
	
	//Singleton implementation
	private static IngredientStorageDisplay isDisplay = new IngredientStorageDisplay();
	
	public static IngredientStorageDisplay getInstance() {
		return isDisplay;
	}
	
	private IngredientStorageDisplay() {

		//Creates the JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        setResizable(false);
        
		getContentPane().setName("ingredientPane");
		
		JPanel ingredientFramePanel = new JPanel();
		
		// Add background image
        try {
            BufferedImage backgroundImage1 = ImageIO.read(new File("src/images/board.png"));
            ingredientFramePanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(backgroundImage1, 0, 0, getWidth(), getHeight(), this);
                }
            };
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		
		getContentPane().add(ingredientFramePanel, BorderLayout.CENTER);
		ingredientFramePanel.setLayout(new BoxLayout(ingredientFramePanel, BoxLayout.X_AXIS));
		
		//ingredientDeckPanel
		JPanel ingredientDeckPanel = new JPanel();
		// Transparent
		ingredientDeckPanel.setOpaque(false); 
		ingredientFramePanel.add(ingredientDeckPanel);
		ingredientDeckPanel.setLayout(new BoxLayout(ingredientDeckPanel, BoxLayout.Y_AXIS));
		ingredientDeckPanel.add(Box.createRigidArea(new Dimension(1000, 50)));
		
		JLabel ingredientDeckLabel = new JLabel("Ingredient Deck");
		ingredientDeckLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		ingredientDeckLabel.setFont(new Font("Cochin", Font.PLAIN, 32));
		ingredientDeckPanel.add(ingredientDeckLabel);
		
		//---
		JPanel allIngredientsScrollPanePanel = new JPanel();
		allIngredientsScrollPanePanel.setOpaque(false);
		ingredientDeckPanel.add(allIngredientsScrollPanePanel);
		allIngredientsScrollPanePanel.setLayout(new BoxLayout(allIngredientsScrollPanePanel, BoxLayout.X_AXIS));
		allIngredientsScrollPanePanel.add(Box.createRigidArea(new Dimension(100, 50)));
		
		//all ingredients scroll pane
		allIngredientsScrollPane = new JScrollPane();
		allIngredientsScrollPanePanel.add(allIngredientsScrollPane);

		//allIngredientsList in to be put in the scroll pane
		allIngredientsList = new JList<JPanel>();
		allIngredientsList.setCellRenderer(new ImageListCellRenderer());  
		allIngredientsList.setSelectionModel(new NoSelectionModel());
		
        // add ingredientList to allIngredientsScrollPane
		allIngredientsScrollPane.setViewportView(allIngredientsList);
		allIngredientsScrollPanePanel.add(Box.createRigidArea(new Dimension(30, 50)));
		ingredientDeckPanel.add(Box.createRigidArea(new Dimension(100, 20)));

		//---
		JPanel ingredientDeckScrollPanePanel = new JPanel();
		ingredientDeckScrollPanePanel.setOpaque(false);
		ingredientDeckPanel.add(ingredientDeckScrollPanePanel);
		ingredientDeckScrollPanePanel.setLayout(new BoxLayout(ingredientDeckScrollPanePanel, BoxLayout.X_AXIS));
		ingredientDeckScrollPanePanel.add(Box.createRigidArea(new Dimension(100, 50)));
		
		//player ingredients deck scroll pane
		ingredientScrollPane = new JScrollPane();
		ingredientDeckScrollPanePanel.add(ingredientScrollPane);

		//ingredientList in to be put in the Scroll pane
		ingredientList = new JList<JPanel>();
		ingredientList.setCellRenderer(new ImageListCellRenderer());
		ingredientList.setSelectedIndex(0);    
		ingredientList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		
        // add ingredientList to scrollPane_ingredients
        ingredientScrollPane.setViewportView(ingredientList);
		ingredientDeckScrollPanePanel.add(Box.createRigidArea(new Dimension(30, 50)));
		ingredientDeckPanel.add(Box.createRigidArea(new Dimension(100, 100)));
		
		//buttonsPanel
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBackground(new Color(171, 124, 67));
		ingredientFramePanel.add(buttonsPanel);
		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
		
		JLabel ingredientInstructionLabel = new JLabel("<html>Click Forage for Ingredient or<br/>Choose Ingredient to Transmute.<br/> <br/> </html>", SwingConstants.CENTER);
		ingredientInstructionLabel.setFont(new Font("Cochin", Font.PLAIN, 20));
		ingredientInstructionLabel.setAlignmentX(0.5f);
		buttonsPanel.add(ingredientInstructionLabel);
		
		ingredientDisplayLabel = new JLabel(" ",JLabel.CENTER);
		ingredientDisplayLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		ingredientDisplayLabel.setFont(new Font("Cochin", Font.PLAIN, 20));
		buttonsPanel.add(ingredientDisplayLabel);
		buttonsPanel.add(Box.createRigidArea(new Dimension(100,100)));
		
		//button for forage for ingredient
		forageForIngredientButton = new JButton("Forage for Ingredient");
		forageForIngredientButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		forageForIngredientButton.setFont(new Font("Cochin", Font.PLAIN, 20));
		forageForIngredientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Game.getGame().getCurrPlayer().getTurnNumber() > 0) {
					Game.getGame().selectController(Controller.FORAGE_FOR_INGREDIENT);
					Player currPlayer = Game.getGame().getCurrPlayer();
					Ingredient newIngredient = currPlayer.getIngredientCards().get(currPlayer.getIngredientCards().size()-1);
					displayCard(newIngredient, getImage(newIngredient));
					initialize(currPlayer);
				}
				else {
					displayText("<html>No turns left.<br/>Please end turn.</html>");
				}
			}
		});
		buttonsPanel.add(forageForIngredientButton);
		buttonsPanel.add(Box.createRigidArea(new Dimension(100,20)));
		
		//button for transmute ingredient
		transmuteIngredientButton = new JButton("Transmute Ingredient");
		transmuteIngredientButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		transmuteIngredientButton.setFont(new Font("Cochin", Font.PLAIN, 20));
		transmuteIngredientButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (Game.getGame().getCurrPlayer().getIngredientCards().isEmpty()) {
					displayText("<html>No ingredients left.<br/>Please choose another action.</html>");
				}
				else if(Game.getGame().getCurrPlayer().getTurnNumber() > 0) {
					IngredientController.getInstance().setChosenIngredient(getChosenIngredient());
					Game.getGame().selectController(Controller.TRANSMUTE_INGREDIENT);
					displayText("<html>Ingredient transmuted.<br/>One gold added to Player.</html>");
					initialize(Game.getGame().getCurrPlayer());
				}
				else {
					displayText("<html>No turns left.<br/>Please end turn.</html>");
				}
			}
		});
		buttonsPanel.add(transmuteIngredientButton);
		buttonsPanel.add(Box.createRigidArea(new Dimension(400, 50)));
		ingredientFramePanel.add(Box.createRigidArea(new Dimension(50, 10)));

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
        
        constructAllImagesDeck(IngredientController.getInstance().giveAllCardsToIngredientStorageDisplay());
	}
	
	
	/**
	 * Needed for all ingredient cards panel, so they cannot be selected
	 */
	private static class NoSelectionModel extends DefaultListSelectionModel {
	   @Override
	   public void setAnchorSelectionIndex(final int anchorIndex) {}

	   @Override
	   public void setLeadAnchorNotificationEnabled(final boolean flag) {}

	   @Override
	   public void setLeadSelectionIndex(final int leadIndex) {}

	   @Override
	   public void setSelectionInterval(final int index0, final int index1) { }
	}
	
	/**
	 * Called at the beginning of the game to get all ingredient cards from ingredient storage 
	 * and create the all ingredients deck
	 * @param ingredientCards
	 */
	public void constructAllImagesDeck(Ingredient[] ingredientCards) {
		setAllIngredientCards(ingredientCards);
		allIngredientJListPanels = createAllIngredientsArray();
		allIngredientsList.setListData(allIngredientJListPanels);
		
		allIngredientsList.setLayoutOrientation(JList.VERTICAL_WRAP);
		allIngredientsList.setFixedCellHeight(IMAGE_HEIGHT+50);
		allIngredientsList.setFixedCellWidth(IMAGE_WIDTH);
		allIngredientsList.setVisibleRowCount(1);
		
		allIngredientsScrollPane.setViewportView(allIngredientsList);	
	}

	
	/**
	 * Initialize UI, player cards are updated every time this is called (every button click)
	 * @param player
	 */
	public void initialize(Player player) {

		if (player.getIngredientCards() == null) {
			return;			
		}
		if (getAllIngredientJListPanels() == null) {
			constructAllImagesDeck(getAllIngredientCards());
		}

		JPanel[] ingredientCardPanelsArray = this.createIngredientArray(player);
		ingredientList.setListData(ingredientCardPanelsArray);
		ingredientList.setLayoutOrientation(JList.VERTICAL_WRAP);
		ingredientList.setFixedCellHeight(IMAGE_HEIGHT+50);
		ingredientList.setFixedCellWidth(IMAGE_WIDTH);
		
		int boxWidth = 900; //ingredientScrollPane.getViewport().getSize().width;
		int numberOfImagesInRow = boxWidth/IMAGE_WIDTH;
		ingredientList.setVisibleRowCount((player.getIngredientCards().size()+numberOfImagesInRow-1)/numberOfImagesInRow);
		ingredientList.setSelectedIndex(0);
		ingredientScrollPane.setViewportView(ingredientList);
	}
	
	/**
	 * Creates the array of player ingredient cards
	 * @param player
	 * @return Jpanel array of player ingredients to be put into JList
	 */

  public JPanel[] createIngredientArray(Player player) {
		JLabel label;
		JPanel panel;
		setIngredientCardPanels(new ArrayList<JPanel>(0));
		
		for (Ingredient ingredient : player.getIngredientCards()) {
			label = new JLabel(ingredient.getName(), getImage(ingredient), JLabel.LEFT);
			label.setHorizontalTextPosition(JLabel.CENTER);
			label.setVerticalTextPosition(JLabel.BOTTOM);
			
			panel = new JPanel();
			panel.add(label);
			
			getIngredientCardLabels().put(label, ingredient);
			getIngredientCardPanels().add(panel);
		}

		JPanel[] ingredientCardPanelsArray = getIngredientCardPanels().toArray(new JPanel[getIngredientCardPanels().size()]);
		return ingredientCardPanelsArray;
	}
	
	/**
	 * Creates an array of all the ingredient cards
	 * @return Jpanel array of all ingredients to be put into JList
	 */
	public JPanel[] createAllIngredientsArray() {
		JLabel label;
		JPanel panel;
		JPanel[] allIngredientJListPanels = new JPanel[getAllIngredientCards().length];
		for (int ingredient = 0; ingredient < getAllIngredientCards().length; ingredient++) {
			label = new JLabel(getAllIngredientCards()[ingredient].getName(), getImage(getAllIngredientCards()[ingredient]), JLabel.LEFT);
			label.setHorizontalTextPosition(JLabel.CENTER);
			label.setVerticalTextPosition(JLabel.BOTTOM);

			panel = new JPanel();
			panel.add(label);
			allIngredientJListPanels[ingredient] = panel;
		}
		return allIngredientJListPanels;
	}

	/**
	 * Gets image from the images folder in src and scales it to the wanted pixels
	 * @param ingredient to access image path
	 * @return imageicon of the ingredient
	 */
	public ImageIcon getImage(Ingredient ingredient) {
		return new ImageIcon(new ImageIcon(ingredient.getPhoto()).getImage()
					.getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_SMOOTH));
	}
	
	/**
	 * Gets the selected index by player from JList
	 * @return chosen Ingredient
	 */
	public Ingredient getChosenIngredient() {
		JLabel label = (JLabel) ingredientList.getSelectedValue().getComponent(0);
		return getIngredientCardLabels().get(label);
	}
	
	/**
	 * Displays given text
	 * @param text
	 */
	public void displayText(String text) {
		ingredientDisplayLabel.setText(text);
		ingredientDisplayLabel.setIcon(null);
		ingredientDisplayLabel.setHorizontalTextPosition(JLabel.CENTER);
		ingredientDisplayLabel.setVerticalTextPosition(JLabel.BOTTOM);
	}
	
	/**
	 * Displays given ingredient card
	 * @param ingredient
	 * @param ingredientCardImage
	 */
	public void displayCard(Ingredient ingredient, ImageIcon ingredientCardImage) {
		ingredientDisplayLabel.setText(ingredient.getName());
		ingredientDisplayLabel.setIcon(ingredientCardImage);
		ingredientDisplayLabel.setHorizontalTextPosition(JLabel.CENTER);
		ingredientDisplayLabel.setVerticalTextPosition(JLabel.BOTTOM);
	}
	
	//method for menu bar
	public void openDialog() {
		// Create a small dialog
        JDialog dialog = new JDialog(this, "In Game Menu", true);
        dialog.setSize(300, 150);

        // Panel for the buttons in the dialog
        JPanel buttonPanel = new JPanel(new FlowLayout());

        // Buttons in the dialog
        JButton helpButton = new JButton("Help");
        JButton pauseButton = new JButton("Pause");
        JButton exitButton = new JButton("Exit");

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

        // Add the panel to the dialog
        dialog.getContentPane().add(buttonPanel);

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
	


	//getter and setters
	public HashMap<JLabel, Ingredient> getIngredientCardLabels() {
		return playerIngredientJListLabels;
	}

	public void setIngredientCardLabels(HashMap<JLabel, Ingredient> ingredientCardLabels) {
		this.playerIngredientJListLabels = ingredientCardLabels;
	}

	public ArrayList<JPanel> getIngredientCardPanels() {
		return playerIngredientJListPanels;
	}

	public void setIngredientCardPanels(ArrayList<JPanel> ingredientCardPanels) {
		this.playerIngredientJListPanels = ingredientCardPanels;
	}

	public JPanel[] getAllIngredientJListPanels() {
		return allIngredientJListPanels;
	}

	public void setAllIngredientJListPanels(JPanel[] allIngredientJListPanels) {
		this.allIngredientJListPanels = allIngredientJListPanels;
	}

	public Ingredient[] getAllIngredientCards() {
		return allIngredientCards;
	}

	public void setAllIngredientCards(Ingredient[] allIngredientCards) {
		this.allIngredientCards = allIngredientCards;
	}
	


	
	

}
