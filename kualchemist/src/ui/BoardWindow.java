package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardWindow extends JFrame {

    private JPanel contentPane;

    /**
     * Create the frame.
     */
    public BoardWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 1550, 900);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); // automatically extends frame to desktop size (full size)
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);

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

        // Board display panel
        JPanel boardDisplay = new JPanel(new GridBagLayout());
        contentPane.add(boardDisplay, BorderLayout.CENTER);

        // Deduction Board in the middle as a button
        JButton deductionBoardButton = new JButton("Deduction Board");
        deductionBoardButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        GridBagConstraints gbcDeductionBoard = new GridBagConstraints();
        gbcDeductionBoard.gridx = 1;
        gbcDeductionBoard.gridy = 1;
        boardDisplay.add(deductionBoardButton, gbcDeductionBoard);

        // Buttons in the corners
        JButton ingredientStorageButton = new JButton("Ingredient Storage");
  		JButton artifactStorageButton = new JButton("Artifact Storage");
  		JButton potionBrewingAreaButton = new JButton("Potion Brewing Area");
  		
  		potionBrewingAreaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				PotionBrewingAreaDisplay pbdDisplay = new PotionBrewingAreaDisplay();
				pbdDisplay.initialize();
				dispose(); //closes BoardWindow

			}
		});
	
  		
  		JButton publicationTrackButton = new JButton("Publication Track");
  		
  		
        addButton(ingredientStorageButton, boardDisplay, "Ingredient Storage", 0, 0, GridBagConstraints.NORTHWEST, 0.2);
        addButton(artifactStorageButton, boardDisplay, "Artifact Storage", 2, 0, GridBagConstraints.NORTHEAST, 0.2);
        addButton(potionBrewingAreaButton, boardDisplay, "Potion Brewing Area", 0, 2, GridBagConstraints.SOUTHWEST, 0.2);
        addButton(publicationTrackButton, boardDisplay, "Publication Track", 2, 2, GridBagConstraints.SOUTHEAST, 0.2);
        
     
    }

    private void addButton(JButton button,JPanel panel, String text, int gridx, int gridy, int anchor, double weight) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.anchor = anchor;
        gbc.weightx = weight; // Spread out horizontally
        gbc.weighty = weight; // Spread out vertically
        gbc.insets = new Insets(5, 5, 5, 5); // Adjust padding
        button.setPreferredSize(new Dimension(150, 50)); // Set preferred size
        panel.add(button, gbc);
    }

    private void openDialog() {
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
        dialog.add(buttonPanel);

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
		
		setVisible(true);
	}

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                BoardWindow frame = new BoardWindow();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}