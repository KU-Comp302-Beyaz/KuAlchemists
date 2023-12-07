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
import java.util.ArrayList;
import java.util.HashMap;
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

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListSelectionModel;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Component;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.SwingConstants;

public class IngredientStorageDisplay extends JFrame {

	//fields
	private final int IMAGE_WIDTH = 200, IMAGE_HEIGHT = 200, NUMBER_OF_IMAGES = 12, IMAGE_INTERVAL_START = 1;
	private final int SCREEN_WIDTH = 1440, SCREEN_HEIGHT = 800;
	
	private JLabel ingredientDisplayLabel;
	private JButton forageForIngredientButton;
	private JButton transmuteIngredientButton;
	private JList<JPanel> ingredientList;
	private JScrollPane ingredientScrollPane;
	
	private HashMap<Integer,ImageIcon> allIngredientCardImageIcons = new HashMap<Integer,ImageIcon>();
	JPanel[] allIngredientJListPanels = new JPanel[NUMBER_OF_IMAGES];
	private ArrayList<JLabel> playerIngredientJListLabels = new ArrayList<JLabel>();
	private ArrayList<JPanel> playerIngredientJListPanels = new ArrayList<JPanel>();
	
	//Singleton implementation
	private static IngredientStorageDisplay isDisplay = new IngredientStorageDisplay();
	
	public static IngredientStorageDisplay getInstance() {
		return isDisplay;
	}
	
	private IngredientStorageDisplay() {

		getImages(IMAGE_INTERVAL_START,NUMBER_OF_IMAGES,IMAGE_WIDTH,IMAGE_HEIGHT);
		
		//Creates the JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        setResizable(false);
        
		getContentPane().setName("ingredientPane");
		
		JPanel ingredientFramePanel = new JPanel();
		getContentPane().add(ingredientFramePanel, BorderLayout.CENTER);
		ingredientFramePanel.setLayout(new BoxLayout(ingredientFramePanel, BoxLayout.X_AXIS));
		
		//ingredientDeckPanel
		JPanel ingredientDeckPanel = new JPanel();
		ingredientFramePanel.add(ingredientDeckPanel);
		ingredientDeckPanel.setLayout(new BoxLayout(ingredientDeckPanel, BoxLayout.Y_AXIS));
		ingredientDeckPanel.add(Box.createRigidArea(new Dimension(1000, 50)));
		
		JLabel ingredientDeckLabel = new JLabel("Ingredient Deck");
		ingredientDeckLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		ingredientDeckLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		ingredientDeckPanel.add(ingredientDeckLabel);
		
		//---
//		JPanel allIngredientsScrollPanePanel = new JPanel();
//		ingredientDeckPanel.add(allIngredientsScrollPanePanel);
//		allIngredientsScrollPanePanel.setLayout(new BoxLayout(allIngredientsScrollPanePanel, BoxLayout.X_AXIS));
//		allIngredientsScrollPanePanel.add(Box.createRigidArea(new Dimension(100, 50)));
//		
//		//all ingredients scroll pane
//		JScrollPane allIngredientsScrollPane = new JScrollPane();
//		allIngredientsScrollPanePanel.add(allIngredientsScrollPane);
//
//		//allIngredientsList in to be put in the scroll pane
//		JList<JPanel> allIngredientsList = new JList<JPanel>();
//		allIngredientsList.setListData(allIngredientJListPanels);
//		allIngredientsList.setCellRenderer(new ImageListCellRenderer());  
//		allIngredientsList.setLayoutOrientation(JList.VERTICAL_WRAP);
//		allIngredientsList.setFixedCellHeight(IMAGE_HEIGHT+50);
//		allIngredientsList.setFixedCellWidth(IMAGE_WIDTH);
//		allIngredientsList.setVisibleRowCount(2);
//		allIngredientsList.setSelectionModel(new NoSelectionModel());
//		
//        // add ingredientList to allIngredientsScrollPane
//		allIngredientsScrollPane.setViewportView(allIngredientsList);
//      allIngredientsScrollPanePanel.add(Box.createRigidArea(new Dimension(30, 50)));
//		ingredientDeckPanel.add(Box.createRigidArea(new Dimension(100, 20)));

		//---
		JPanel ingredientDeckScrollPanePanel = new JPanel();
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
		ingredientFramePanel.add(buttonsPanel);
		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
		
		JLabel ingredientInstructionLabel = new JLabel("<html>Click Forage for Ingredient or<br/>Choose Ingredient to Transmute.<br/> <br/> </html>", SwingConstants.CENTER);
		ingredientInstructionLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		ingredientInstructionLabel.setAlignmentX(0.5f);
		buttonsPanel.add(ingredientInstructionLabel);
		
		ingredientDisplayLabel = new JLabel(" ",JLabel.CENTER);
		ingredientDisplayLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		ingredientDisplayLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		buttonsPanel.add(ingredientDisplayLabel);
		buttonsPanel.add(Box.createRigidArea(new Dimension(100,100)));
		
		//button for forage for ingredient
		forageForIngredientButton = new JButton("Forage for Ingredient");
		forageForIngredientButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		forageForIngredientButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		forageForIngredientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game.getGame().selectController(Controller.FORAGE_FOR_INGREDIENT);
			}
		});
		buttonsPanel.add(forageForIngredientButton);
		buttonsPanel.add(Box.createRigidArea(new Dimension(100,20)));
		
		//button for transmute ingredient
		transmuteIngredientButton = new JButton("Transmute Ingredient");
		transmuteIngredientButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		transmuteIngredientButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		transmuteIngredientButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Game.getGame().selectController(Controller.TRANSMUTE_INGREDIENT);
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
	}
	
	/**
	 * Needed for the ingredientList JList -> contains a list of JPanels with JLabels instead of Strings
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
	
//	/**
//	 * PUT THIS IN ANOTHER .JAVA FILE IN UI
//	 */
//	public class IngredientCardPanel extends JPanel {
//		
//	}
//	
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
	
	


	//initialize ui
	//THIS METHOD IS WHERE THE INGREDIENTS CARD DECK SHOULD BE UPDATED
	public void initialize(Player player) {


		if (player.getIngredientCards().entrySet() == null) {
			System.out.println("null alert");
			return;			
		}

		JPanel[] ingredientCardPanelsArray = this.createIngredientArray(player);
		ingredientList.setListData(ingredientCardPanelsArray);
		ingredientList.setLayoutOrientation(JList.VERTICAL_WRAP);
		ingredientList.setFixedCellHeight(IMAGE_HEIGHT+50);
		ingredientList.setFixedCellWidth(IMAGE_WIDTH);
		
		int boxWidth = 800; //ingredientScrollPane.getViewport().getSize().width;
		int numberOfImagesInRow = boxWidth/IMAGE_WIDTH;
		ingredientList.setVisibleRowCount((player.getIngredientCards().size()+numberOfImagesInRow-1)/numberOfImagesInRow);
		ingredientList.setSelectedIndex(0);
		ingredientScrollPane.setViewportView(ingredientList);
	}
	
	public JPanel[] createIngredientArray(Player player) {
		JLabel label;
		JPanel panel;
		Ingredient ingredient;
		
		//iterate over all of player's cards
		// RIGHT NOW WE DO NOT CREATE NEW ARRAY LIST AT THE BEGINNING OF THE FUNCTION
		// SO EVERY TIME ALL THE CARDS ARE ADDED AGAIN TO CREATE MULTIPLES FOR EVERY BUTTON PRESS
		// NEEDS TO BE FIXED, ONLY THE CARD WITH THE DIFFERENCES SHOULD BE ADDED OR REMOVED FROM ARRAY
		setIngredientCardLabels(new ArrayList<JLabel>(0));
		setIngredientCardPanels(new ArrayList<JPanel>(0));
		
		for (Entry<Integer, Ingredient> entry : player.getIngredientCards().entrySet()) {
			ingredient = entry.getValue();
			String labelName = String.format("%2d", ingredient.getIdentifier()) + ": " + ingredient.getName();
			label = new JLabel(labelName, getAllIngredientCardImageIcons().get(ingredient.getIdentifier()), JLabel.LEFT);
			label.setHorizontalTextPosition(JLabel.CENTER);
			label.setVerticalTextPosition(JLabel.BOTTOM);
			
			panel = new JPanel();
			panel.add(label);
			
			getIngredientCardLabels().add(label);
			getIngredientCardPanels().add(panel);
		}

		JPanel[] ingredientCardPanelsArray = getIngredientCardPanels().toArray(new JPanel[getIngredientCardPanels().size()]);
		return ingredientCardPanelsArray;
	}
	
	public JPanel[] createAllIngredientsArray(Ingredient[] ingredientCards) {
		JLabel label;
		JPanel panel;
		for (int ingredientIdentifier = IMAGE_INTERVAL_START; ingredientIdentifier < ingredientCards.length+IMAGE_INTERVAL_START; ingredientIdentifier++) {
			String labelName = String.format("%2d", ingredientCards[ingredientIdentifier].getIdentifier()) + ": " + ingredientCards[ingredientIdentifier].getName();
			label = new JLabel(labelName, getAllIngredientCardImageIcons().get(ingredientIdentifier), JLabel.LEFT);
			label.setHorizontalTextPosition(JLabel.CENTER);
			label.setVerticalTextPosition(JLabel.BOTTOM);

			panel = new JPanel();
			panel.add(label);
			allIngredientJListPanels[ingredientIdentifier] = panel;
		}
		return allIngredientJListPanels;
	}

	public int getChosenIngredient() {
		JLabel label = (JLabel) ingredientList.getSelectedValue().getComponent(0);
//		return label.getText()
		return Integer.parseInt(label.getText().substring(0, 2).trim());
//		return ingredientList.getSelectedIndex();
	}
	
	public void displayText(String text) {
		ingredientDisplayLabel.setText(text);
		ingredientDisplayLabel.setIcon(null);
		ingredientDisplayLabel.setHorizontalTextPosition(JLabel.CENTER);
		ingredientDisplayLabel.setVerticalTextPosition(JLabel.BOTTOM);
	}
	
	public void displayCard(Ingredient ingredient, ImageIcon ingredientCardImage) {
		ingredientDisplayLabel.setText(ingredient.getName());
		ingredientDisplayLabel.setIcon(ingredientCardImage);
		ingredientDisplayLabel.setHorizontalTextPosition(JLabel.CENTER);
		ingredientDisplayLabel.setVerticalTextPosition(JLabel.BOTTOM);
	}
	
	//method for menu bar
	protected void openDialog() {
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
	
	/**
	 * Gets images from the images folder in src and scales them to the wanted pixels
	 * @param intervalBegin -> first image is ingredient(intervalBegin).jpg
	 * @param numberOfImages -> last image is ingredient(intervalBegin+numberOfImages).jpg
	 * @param imageWidth
	 * @param imageHeight
	 */
	public void getImages(int intervalBegin, int numberOfImages, int imageWidth, int imageHeight) {
		for (int i = intervalBegin; i < intervalBegin+numberOfImages; i++) {
			getAllIngredientCardImageIcons().put(i, new ImageIcon(
					new ImageIcon("src/images/images-icons/ingredient"+i+".jpg").getImage()
					.getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH)));
		}
	}

	//getter and setters
	public ArrayList<JLabel> getIngredientCardLabels() {
		return playerIngredientJListLabels;
	}

	public void setIngredientCardLabels(ArrayList<JLabel> ingredientCardLabels) {
		this.playerIngredientJListLabels = ingredientCardLabels;
	}

	public ArrayList<JPanel> getIngredientCardPanels() {
		return playerIngredientJListPanels;
	}

	public void setIngredientCardPanels(ArrayList<JPanel> ingredientCardPanels) {
		this.playerIngredientJListPanels = ingredientCardPanels;
	}

	public HashMap<Integer, ImageIcon> getAllIngredientCardImageIcons() {
		return allIngredientCardImageIcons;
	}

	public void setAllIngredientCardImageIcons(HashMap<Integer, ImageIcon> allIngredientCardImageIcons) {
		this.allIngredientCardImageIcons = allIngredientCardImageIcons;
	}


	
	

}
