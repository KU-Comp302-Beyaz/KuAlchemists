package ui;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;


import domain.Game;
import domain.Game.Controller;
import domain.ingredients.Ingredient;

import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.awt.Component;

public class IngredientStorageDisplay extends JFrame {
	
	private static IngredientStorageDisplay isDisplay = new IngredientStorageDisplay();
	private JLabel ingredientDisplayLabel;
	private JPanel ingredientStoragePanel;
	JButton forageForIngredientButton;
	JButton transmuteIngredientButton;
	
	
	//private ActionEvent[] actionEvents = {new ActionEvent(forageForIngredientButton, ActionEvent.ACTION_PERFORMED, "FORAGE_FOR_INGREDIENT"), new ActionEvent(forageForIngredientButton, ActionEvent.ACTION_PERFORMED, "TRANSMUTE_INGREDIENT")};
	
	
	private IngredientStorageDisplay() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 1550, 900);
		getContentPane().setName("ingredientPane");
		
		JPanel ingredientFramePanel = new JPanel();
		getContentPane().add(ingredientFramePanel, BorderLayout.CENTER);
		ingredientFramePanel.setLayout(new BoxLayout(ingredientFramePanel, BoxLayout.Y_AXIS));
		
		//-- ingredientDeckPanel
		JPanel ingredientDeckPanel = new JPanel();
		ingredientFramePanel.add(ingredientDeckPanel);
		ingredientDeckPanel.setLayout(new BoxLayout(ingredientDeckPanel, BoxLayout.Y_AXIS));
		
		Component rigidArea = Box.createRigidArea(new Dimension(100, 50));
		ingredientDeckPanel.add(rigidArea);
		
		JLabel ingredientDeckLabel = new JLabel("Ingredient Deck");
		ingredientDeckLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		ingredientDeckLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		ingredientDeckPanel.add(ingredientDeckLabel);
			
		Component rigidArea_1 = Box.createRigidArea(new Dimension(100, 100));
		ingredientDeckPanel.add(rigidArea_1);
		
		ingredientDisplayLabel = new JLabel("text");
		ingredientDisplayLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		ingredientDisplayLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		ingredientDeckPanel.add(ingredientDisplayLabel);
		

		
		//-- buttonsPanel
		JPanel buttonsPanel = new JPanel();
		ingredientFramePanel.add(buttonsPanel);
		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
		
		//filler after panels
		ingredientFramePanel.add(Box.createRigidArea(new Dimension(100,100)));
		
		//button for forage for ingredient
		forageForIngredientButton = new JButton("Forage for Ingredient");
		forageForIngredientButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Game.getGame().selectContoller(Controller.FORAGE_FOR_INGREDIENT);
			}
		});
		
		forageForIngredientButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		buttonsPanel.add(forageForIngredientButton);
		
		//filler between buttons
		buttonsPanel.add(Box.createRigidArea(new Dimension(100,100)));
		
		//button for transmute ingredient
		transmuteIngredientButton = new JButton("Transmute Ingredient");
		transmuteIngredientButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Game.getGame().selectContoller(Controller.TRANSMUTE_INGREDIENT);
			}
		});
		transmuteIngredientButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		buttonsPanel.add(transmuteIngredientButton);

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
	
	public static IngredientStorageDisplay getIngredientStorageDisplay() {
		return isDisplay;
	}
	
	public void initialize() {
		ingredientDisplayLabel.setText("text");
		setVisible(true);
	}
	
	public void displayText() {
		ingredientDisplayLabel.setText("Ingredient transmuted.");
	}
	
	public void displayCard(Ingredient ingredientCard) {
		ingredientDisplayLabel.setText("chosen card here");
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

}
