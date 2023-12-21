
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

import domain.Display;
import domain.Game;
import domain.Player;
import domain.ingredients.Ingredient;
import domain.ingredients.IngredientStorage;
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
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Graphics;

public class PotionBrewingAreaDisplay extends JFrame implements Display {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel experimentPanel;
	private JPanel potionSalePanel;
	private boolean requestAccepted = false;
	private ImageIcon coinIcon;
	private Player player = Game.getCurrPlayer();
	private String testMethod = null;
	private Ingredient[] ingredients; 	



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
        
        // Add background image
        try {
            BufferedImage backgroundImage1 = ImageIO.read(new File("src/images/board.jpeg"));
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

		JLabel[] ingredientsIcons = new JLabel[8];
		JPanel[] ingredientPanels = new JPanel[8];
		

		// add players ingredients
		for (int i=0;i <8 ; i++) {
			//ImageIcon imageIcon = new ImageIcon("src/images/images-icons/ingredient"+(i+1)+".jpg");
			ImageIcon imageIcon = new ImageIcon(IngredientStorage.getAllingredientcardsarray()[i].getPhoto());
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
		
		
		
		// add players existed ingredients
		/*
		int i = 0;
		for (Ingredient ing: player.getIngredientCards().values()) {
			//ImageIcon imageIcon = new ImageIcon("src/images/images-icons/ingredient"+(i+1)+".jpg");
			ImageIcon imageIcon = new ImageIcon(ing.getPhoto());
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
			i++;
		}
		*/
		ingredientPanel.setLayout(null);
        ingredientPanel.add(scrollPane_ingredients);
        
		JList ingredientList = new JList<>(ingredientListModel);
		
		//This model allows multiple selecting in a scroll pane
		ingredientList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		 // ListSelectionListener ekleyerek seçim olaylarını dinle
		ingredientList.addListSelectionListener((ListSelectionListener) new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    // Seçilen öğelerin dizisi
                    Object[] selectedIng = ingredientList.getSelectedValues();
                    ingredients = (Ingredient[]) ingredientList.getSelectedValues();

                    // Seçilen öğeleri birleştir ve mesaj olarak göster
                    StringBuilder message = new StringBuilder("Selected Ing: ");
                    for (Object ing : selectedIng) {
                        message.append(ing).append(" ");
                    }
                    
                    System.out.println(message);
                    //JOptionPane.showMessageDialog(null, message.toString());
                }
            }
        });
        
		scrollPane_ingredients.setViewportView(ingredientList);
		ingredientList.setCellRenderer(new ImageListCellRenderer());
		ingredientList.setListData(ingredientPanels);
		ingredientList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		//ingredientList.setFixedCellHeight(scrollPane_ingredients.getHeight());
		//ingredientList.setFixedCellHeight(200);
		//ingredientList.setFixedCellWidth(150);
		ingredientList.setVisibleRowCount(1); // Set the visible row count to 1 for horizontal layout
		//ingredientList.setSelectedIndex(0);
        
        
        
        JPanel testPanel = new JPanel();
        testPanel.setBounds(0, 272, 871, 167);
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
        	}
        });
        btnTestOnPlayer.setFont(new Font("Cochin", Font.PLAIN, 20));
        testPanel.add(btnTestOnPlayer);
        
        JButton btnTestOnStudent = new JButton("Student");
        btnTestOnStudent.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		testMethod = "Student";
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
        
     
        ///////////////////////////////////////////////// 
        
        
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
        /*
        ImageIcon requestedPotionIcon = new ImageIcon("src/images/potions/potion-1.png");
        Image requestedPotionImage = requestedPotionIcon.getImage().getScaledInstance(380, 335, 0);
        requestedPotionIcon = new ImageIcon(requestedPotionImage);
        requestedPotion.setIcon(requestedPotionIcon);
        requestPanel.add(requestedPotion);
        */
        requestedPotion.setVisible(false);
        
        // Animation for illustrating random getting alchemyMarker
        Thread t = new Thread(new Runnable() {
      	  public void run() {
      		  try {
      			
      			ImageIcon icon1 = new ImageIcon("src/images/bottle-icons/blue+bottle.png");
      			ImageIcon icon2 = new ImageIcon("src/images/bottle-icons/red-bottle.png");
      			ImageIcon icon3 = new ImageIcon("src/images/bottle-icons/blue-bottle.png");
      			ImageIcon icon4 = new ImageIcon("src/images/bottle-icons/green-bottle.png");
      			ImageIcon icon5 = new ImageIcon("src/images/bottle-icons/red+bottle.png");
      			ImageIcon icon6 = new ImageIcon("src/images/bottle-icons/null_bottle.png");
      			ImageIcon icon7 = new ImageIcon("src/images/bottle-icons/green+bottle.png");
      			ImageIcon requestedPotionIcon = new ImageIcon("src/images/potions/potion-1.png");
      	        
      	        requestedPotion.setIcon(new ImageIcon(icon1.getImage().getScaledInstance(380, 335, 0)));
      	        requestPanel.add(requestedPotion);
    	        requestedPotion.setVisible(true);
    	        Thread.sleep(100);
      	        requestedPotion.setIcon(new ImageIcon(icon2.getImage().getScaledInstance(380, 335, 0)));
      	        Thread.sleep(100);
      	        requestedPotion.setIcon(new ImageIcon(icon3.getImage().getScaledInstance(380, 335, 0)));
    	        Thread.sleep(100);
    	        requestedPotion.setIcon(new ImageIcon(icon4.getImage().getScaledInstance(380, 335, 0)));
    	        Thread.sleep(100);
    	        requestedPotion.setIcon(new ImageIcon(icon5.getImage().getScaledInstance(380, 335, 0)));
    	        Thread.sleep(100);
    	        requestedPotion.setIcon(new ImageIcon(icon6.getImage().getScaledInstance(380, 335, 0)));
    	        Thread.sleep(100);
    	        requestedPotion.setIcon(new ImageIcon(icon7.getImage().getScaledInstance(380, 335, 0)));
    	        Thread.sleep(100);
    	        requestedPotion.setIcon(new ImageIcon(requestedPotionIcon.getImage().getScaledInstance(380, 335, 0)));     
      			  
      		  }
      		  catch(Exception e) {}
      	  }
        });
        
        
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
                
                //requestedPotion.setVisible(true);
                t.start();
                
                Game.setController(Game.controller.SELL_POTION);
          	}
          });
          
          sellPotionButton.setFont(new Font("Cochin", Font.PLAIN, 30));
            
          //MAKE POTION BUTTON
          JButton btnMakePotion = new JButton("MAKE POTION");
          btnMakePotion.addActionListener(new ActionListener() {
          	public void actionPerformed(ActionEvent e) {
          		
          		// make potion 
          		if ((ingredients == null) || (ingredients.length != 2)) {
          			JOptionPane.showMessageDialog(contentPane,
            			    "Choose 2 ingredients for making potion!");   
          		}else if (testMethod == null) {
          			JOptionPane.showMessageDialog(contentPane,
            			    "Choose test method for making potion!");   
          		} else {
          			//PotionController.initializeMakeExperiment();
          			Game.setController(Game.Controller.MAKE_EXPERIMENT);
          		}
          		
          		
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


	public String getTestMethod() {
		return testMethod;
	}
	
	public Ingredient[] getIngredients() {
		return ingredients;
	}
}
