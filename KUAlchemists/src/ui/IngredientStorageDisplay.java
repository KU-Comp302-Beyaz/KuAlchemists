package ui;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
import java.util.Dictionary;
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
import ui.PotionBrewingAreaDisplay.ImageListCellRenderer;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Component;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.SwingConstants;

public class IngredientStorageDisplay extends JFrame {
	
	//cards scroll panel updated and jframe refreshed after every button click tho
	
	//fields
	private JLabel ingredientDisplayLabel;
	private JPanel ingredientStoragePanel;
	private JButton forageForIngredientButton;
	private JButton transmuteIngredientButton;
	private JList<JPanel> ingredientList;
	private JScrollPane ingredientScrollPane;
	
	private HashMap<Integer,ImageIcon> allIngredientCardImageIcons = new HashMap<Integer,ImageIcon>();
	private ArrayList<JLabel> ingredientCardLabels;
	private ArrayList<JPanel> ingredientCardPanels;
	
	private static final int IMAGE_WIDTH = 200, IMAGE_HEIGHT = 200, IMAGE_NUMBER = 12;
	
	
	//private ActionEvent[] actionEvents = {new ActionEvent(forageForIngredientButton, ActionEvent.ACTION_PERFORMED, "FORAGE_FOR_INGREDIENT"), new ActionEvent(forageForIngredientButton, ActionEvent.ACTION_PERFORMED, "TRANSMUTE_INGREDIENT")};
	
	//Multiton implementation, one for player1 and one for player2
	/*
	private final int instanceID; //1 for player1 and 2 for player2
	private static IngredientStorageDisplay[] isDisplayInstances = {new IngredientStorageDisplay(1), new IngredientStorageDisplay(2)};
	public static IngredientStorageDisplay getIngredientStorageDisplay(int id) {
		return isDisplayInstances[id];
	}
	public int getInstanceID() {
		return instanceID;
	}
	private IngredientStorageDisplay(int instanceID) { //multiton
		this.instanceID = instanceID; //multiton
	*/
	
	//Singleton implementation
	private static IngredientStorageDisplay isDisplay = new IngredientStorageDisplay(); //for singleton
	
	public static IngredientStorageDisplay getIngredientStorageDisplay() {
		return isDisplay;
	}
	
	private IngredientStorageDisplay() { //singleton
		//get ingredient images from images folder
		for (int i = 0; i < IMAGE_NUMBER; i++) {
			getAllIngredientCardImageIcons().put(i+1, new ImageIcon(new ImageIcon("src/images/images-icons/ingredient"+(i+1)+".jpg").getImage().getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_SMOOTH)));
		}
		
		/**
		 * Create the frame
		 */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1440, 800);
        setResizable(false);
        
		getContentPane().setName("ingredientPane");
		
		JPanel ingredientFramePanel = new JPanel();
		getContentPane().add(ingredientFramePanel, BorderLayout.CENTER);
		ingredientFramePanel.setLayout(new BoxLayout(ingredientFramePanel, BoxLayout.X_AXIS));
		
		//ingredientDeckPanel
		JPanel ingredientDeckPanel = new JPanel();
		ingredientFramePanel.add(ingredientDeckPanel);
		ingredientDeckPanel.setLayout(new BoxLayout(ingredientDeckPanel, BoxLayout.Y_AXIS));
		
		Component rigidArea = Box.createRigidArea(new Dimension(1000, 50));
		ingredientDeckPanel.add(rigidArea);
		
		JLabel ingredientDeckLabel = new JLabel("Ingredient Deck");
		ingredientDeckLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		ingredientDeckLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		ingredientDeckPanel.add(ingredientDeckLabel);
		
		JPanel ingredientDeckScrollPanePanel = new JPanel();
		ingredientDeckPanel.add(ingredientDeckScrollPanePanel);
		ingredientDeckScrollPanePanel.setLayout(new BoxLayout(ingredientDeckScrollPanePanel, BoxLayout.X_AXIS));
		
		Component rigidArea_2_1 = Box.createRigidArea(new Dimension(100, 50));
		ingredientDeckScrollPanePanel.add(rigidArea_2_1);
		
		//ingredients deck scroll pane
		ingredientScrollPane = new JScrollPane();
		ingredientDeckScrollPanePanel.add(ingredientScrollPane);
		
		//use createIngredientArray
//		JPanel[] ingredientCardPanelsArray = this.createIngredientArray();
      
		//ingredientList in to be put in the Scroll pane
		ingredientList = new JList();
		ingredientList.setCellRenderer(new ImageListCellRenderer());
//		ingredientList.setListData(ingredientCardPanelsArray);
//		ingredientList.setLayoutOrientation(JList.VERTICAL);
//		//ingredientList.setFixedCellHeight(scrollPane_ingredients.getHeight());
//		ingredientList.setFixedCellHeight(IMAGE_HEIGHT);
//		ingredientList.setFixedCellWidth(IMAGE_WIDTH);
//		ingredientList.setVisibleRowCount(2); //change later if necessary
		ingredientList.setSelectedIndex(0);    
		ingredientList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		
        // add ingredientList to scrollPane_ingredients
        ingredientScrollPane.setViewportView(ingredientList);
		
		Component rigidArea_2_2 = Box.createRigidArea(new Dimension(30, 50));
		ingredientDeckScrollPanePanel.add(rigidArea_2_2);

		Component rigidArea_1 = Box.createRigidArea(new Dimension(100, 100));
		ingredientDeckPanel.add(rigidArea_1);
		
		//-- buttonsPanel
		JPanel buttonsPanel = new JPanel();
		ingredientFramePanel.add(buttonsPanel);
		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
		
		//button for forage for ingredient
		forageForIngredientButton = new JButton("Forage for Ingredient");
		forageForIngredientButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		forageForIngredientButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Game.getGame().selectController(Controller.FORAGE_FOR_INGREDIENT);
			}
		});
		
		JLabel ingredientInstructionLabel = new JLabel("<html>Click Forage for Ingredient or<br/>Choose Ingredient to Transmute.<br/> <br/> </html>", SwingConstants.CENTER);
		ingredientInstructionLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		ingredientInstructionLabel.setAlignmentX(0.5f);
		buttonsPanel.add(ingredientInstructionLabel);
		
		ingredientDisplayLabel = new JLabel(" ",JLabel.CENTER);
		ingredientDisplayLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		ingredientDisplayLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		buttonsPanel.add(ingredientDisplayLabel);
		
		//filler after panels
		Component rigidArea_2 = Box.createRigidArea(new Dimension(100,100));
		buttonsPanel.add(rigidArea_2);
		
		forageForIngredientButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		buttonsPanel.add(forageForIngredientButton);
		
		//filler between buttons
		buttonsPanel.add(Box.createRigidArea(new Dimension(100,20)));
		
		//button for transmute ingredient
		transmuteIngredientButton = new JButton("Transmute Ingredient");
		transmuteIngredientButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		transmuteIngredientButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Game.getGame().selectController(Controller.TRANSMUTE_INGREDIENT);
			}
		});
		transmuteIngredientButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		buttonsPanel.add(transmuteIngredientButton);
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(400, 50));
		buttonsPanel.add(rigidArea_3);
		
		Component rigidArea_3_1 = Box.createRigidArea(new Dimension(50, 10));
		ingredientFramePanel.add(rigidArea_3_1);

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
	 * Needed for the ingredientList jlist - it contains jpanels with imageicons instead of a list
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
	
	
//	public static HashMap<Integer, ImageIcon> getAllingredientcardimageicons() {
//		return allIngredientCardImageIcons;
//	}
//	public static void createAllingredientcardimageicons() {
//		for (int i = 0; i < IMAGE_NUMBER; i++) {
//			getAllingredientcardimageicons().put(null, null)
//		}
//	}

	//initialize ui
	//THIS METHOD IS WHERE THE INGREDIENTS CARD DECK SHOULD BE UPDATED
	public void initialize(Player player) {
		if (player.getIngredientCards().entrySet() == null)
			return;
		
		JPanel[] ingredientCardPanelsArray = this.createIngredientArray(player);
		ingredientList.setListData(ingredientCardPanelsArray);
		ingredientList.setLayoutOrientation(JList.VERTICAL_WRAP);
		ingredientList.setFixedCellHeight(IMAGE_HEIGHT+50);
		ingredientList.setFixedCellWidth(IMAGE_WIDTH);
		
		int boxWidth = 1000; //ingredientScrollPane.getViewport().getSize().width;
//		ingredientList.setVisibleRowCount(((IMAGE_NUMBER*IMAGE_WIDTH)/boxWidth)+1);
		ingredientList.setVisibleRowCount(((player.getIngredientCards().size()*IMAGE_WIDTH)/boxWidth)+1);
		ingredientList.setSelectedIndex(0);
		ingredientScrollPane.setViewportView(ingredientList);
	}
	
	public JPanel[] createIngredientArray(Player player) {
		setIngredientCardLabels(new ArrayList<JLabel>());
		setIngredientCardPanels(new ArrayList<JPanel>());
		
//		for (int i = 0; i < 12; i++) {
//			getIngredientCardLabels().add(new JLabel("", getAllIngredientCardImageIcons().get(i+1), JLabel.CENTER)); // new ImageIcon(new ImageIcon("src/images/images-icons/ingredient"+(i+1)+".jpg").getImage().getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_SMOOTH)), JLabel.CENTER));	
//			getIngredientCardPanels().add(new JPanel());
//			getIngredientCardPanels().get(i).add(getIngredientCardLabels().get(i));
//		}
		JLabel label = null;
		JPanel panel = null;
	
		for (Entry<Integer, Ingredient> entry : player.getIngredientCards().entrySet()) {
			Ingredient ingredient = entry.getValue();
			String labelName = String.format("%03d", ingredient.getIdentifier()) + ": " + ingredient.getName();
			label = new JLabel(labelName, getAllIngredientCardImageIcons().get(ingredient.getIconID()), JLabel.LEFT);
			label.setHorizontalTextPosition(JLabel.CENTER);
			label.setVerticalTextPosition(JLabel.BOTTOM);
			getIngredientCardLabels().add(label);
			panel = new JPanel();
			panel.add(label);
			getIngredientCardPanels().add(panel);
		}
		
//		for (int i = 0; i < player.getIngredientCards().size(); i++) {
//			Ingredient ingredient = player.getIngredientCards().get(i);
//			String labelName = String.format("%03d", ingredient.getIdentifier()) + ": " + ingredient.getName();
//			label = new JLabel(labelName, getAllIngredientCardImageIcons().get(ingredient.getIconID()), JLabel.LEFT);
//			label.setHorizontalTextPosition(JLabel.CENTER);
//			label.setVerticalTextPosition(JLabel.BOTTOM);
//			getIngredientCardLabels().add(label);
//			getIngredientCardPanels().add(new JPanel());
//			getIngredientCardPanels().get(i).add(getIngredientCardLabels().get(i));
//		}
		
		JPanel[] ingredientCardPanelsArray = getIngredientCardPanels().toArray(new JPanel[getIngredientCardPanels().size()]);

		return ingredientCardPanelsArray;

	}

	public int getChosenIngredient() {
		JLabel label = (JLabel) ingredientList.getSelectedValue().getComponent(0);
		return Integer.parseInt(label.getText().substring(0, 3));
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

	//getter and setters
	public ArrayList<JLabel> getIngredientCardLabels() {
		return ingredientCardLabels;
	}

	public void setIngredientCardLabels(ArrayList<JLabel> ingredientCardLabels) {
		this.ingredientCardLabels = ingredientCardLabels;
	}

	public ArrayList<JPanel> getIngredientCardPanels() {
		return ingredientCardPanels;
	}

	public void setIngredientCardPanels(ArrayList<JPanel> ingredientCardPanels) {
		this.ingredientCardPanels = ingredientCardPanels;
	}

	public HashMap<Integer, ImageIcon> getAllIngredientCardImageIcons() {
		return allIngredientCardImageIcons;
	}

	public void setAllIngredientCardImageIcons(HashMap<Integer, ImageIcon> allIngredientCardImageIcons) {
		this.allIngredientCardImageIcons = allIngredientCardImageIcons;
	}


	
	

}
