package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
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
import javax.swing.SwingConstants;

import domain.Game;
import domain.Game.Controller;
import domain.ingredients.Ingredient;
import domain.ingredients.IngredientStorage;
import domain.publication.PublicationCard;
import domain.publication.PublicationTrack;
import domain.theorydeduction.AlchemyMarker;
import domain.theorydeduction.Theory;
import domain.theorydeduction.TheoryController;


public class PublicationTrackDisplay extends JFrame implements Display {
	
	private static PublicationTrackDisplay instance; // Singleton
	private ArrayList<JPanel> publicationBoardPanels = new ArrayList<>();
	private ArrayList<JPanel> theoryPanels = new ArrayList<>();
	private PublicationTrack pt = PublicationTrack.getInstance();
	private JLabel titleLabel = new JLabel("Publication Track");
	private JLabel trackInfoLabel = new JLabel("Publication Cards");
	private JLabel theoryInfoPanel = new JLabel("Published Theories");
	private JScrollPane publicationScrollPane = new JScrollPane();
	private JList publicationList = new JList();
	private JScrollPane theoryScrollPane = new JScrollPane();
	private JList theoryList = new JList();
	private JButton debunkButton = new JButton("Debunk A Theory");
	private JButton claimRewardButton = new JButton("Claim Publication Card");
	private JMenuBar menuBar = new JMenuBar();
	private JMenu fileMenu = new JMenu("Menu");
	private JMenuItem openDialogMenuItem = new JMenuItem("Open Menu");
	private JButton backToBoardButton = new JButton("Back to Board");
	
	private static final int IMAGE_WIDTH = 200, IMAGE_HEIGHT = 200;
	
	
	
	private PublicationTrackDisplay() {
		
		setResizable(false);
		setTitle("KuAlchemists");
		setBounds(0, 0, 1440, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		
		titleLabel.setFont(new Font("Cochin", Font.PLAIN, 30));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(632, 74, 250, 50);
		getContentPane().add(titleLabel);
		
		
		trackInfoLabel.setFont(new Font("Cochin", Font.PLAIN, 25));
		trackInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		trackInfoLabel.setBounds(252, 169, 250, 50);
		getContentPane().add(trackInfoLabel);
		
		
		theoryInfoPanel.setFont(new Font("Cochin", Font.PLAIN, 25));
		theoryInfoPanel.setHorizontalAlignment(SwingConstants.CENTER);
		theoryInfoPanel.setBounds(1044, 169, 250, 50);
		getContentPane().add(theoryInfoPanel);
		
		
		publicationScrollPane.setBounds(50, 221, 560, 480);
		getContentPane().add(publicationScrollPane);
		
		
		publicationList.setLayoutOrientation(JList.VERTICAL);
		publicationList.setCellRenderer(new ImageListCellRenderer());
		publicationList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		publicationList.setFixedCellHeight(IMAGE_HEIGHT+50);
		publicationList.setFixedCellWidth(IMAGE_WIDTH);
		getPublishListItems();
		publicationList.setListData(publicationBoardPanels.toArray());
		publicationScrollPane.setViewportView(publicationList);
		
		
		theoryScrollPane.setBounds(855, 221, 560, 480);
		getContentPane().add(theoryScrollPane);
		
		
		theoryList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		theoryList.setCellRenderer(new ImageListCellRenderer());
		theoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		theoryList.setFixedCellHeight(IMAGE_HEIGHT+38);
		theoryList.setFixedCellWidth(IMAGE_WIDTH-20);
		theoryList.setVisibleRowCount(2);
		theoryScrollPane.setViewportView(theoryList);
		
		
		debunkButton.setFont(new Font("Cochin", Font.PLAIN, 20));
		debunkButton.setBounds(1058, 719, 250, 64);
		debunkButton.addActionListener(e -> {
			
			if (theoryList.getSelectedValue() == null) {
				JOptionPane.showMessageDialog(this, "Please select a theory to debunk!","Select Theory",JOptionPane.ERROR_MESSAGE);
			}
			else {
				JLabel ingredientFromTheoryLabel = (JLabel) ((JPanel) theoryList.getSelectedValue()).getComponent(0);
				ImageIcon selectedIcon = (ImageIcon) ingredientFromTheoryLabel.getIcon();
				Ingredient selectedIngredient = findIngredientFromPhoto(selectedIcon.getDescription());
				Theory selectedTheory = findTheory(selectedIngredient);
				displayAlchemyMarkerSelectionDialog(selectedTheory);
			}
			
			
		});
		getContentPane().add(debunkButton);
		
		
		claimRewardButton.setFont(new Font("Cochin", Font.PLAIN, 20));
		claimRewardButton.setBounds(200, 719, 250, 64);
		claimRewardButton.addActionListener(e -> {
			
			Game.getGame().selectController(Controller.CLAIM_CARD);
			if (publicationList.getSelectedValue()==null) {
				JOptionPane.showMessageDialog(this, "Please select a publication card to claim!","Select Publication Card",JOptionPane.ERROR_MESSAGE);

			}
			PublicationCard selectedCard = getSelectedCard();
			if (selectedCard.isClaimed())
				JOptionPane.showMessageDialog(this, "This Publication Card is already claimed.","Card Already Claimed",JOptionPane.ERROR_MESSAGE);
			else {
				boolean result = TheoryController.getInstance().initClaimCard(selectedCard);
				if (result) {
					JPanel selectedPanel = (JPanel) publicationList.getSelectedValue();
					JLabel l = new JLabel();
					l.setIcon(new ImageIcon(new ImageIcon("src/images/claimed.png").getImage().getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT/2, Image.SCALE_SMOOTH)));
					selectedPanel.add(l);
					JOptionPane.showMessageDialog(this, Game.getGame().getCurrPlayer().getUsername()+" successfully claimed the publication card! "+selectedCard.getGoldReward()+" amount(s) of gold and "+selectedCard.getReputationReward()+" amount(s) of reputation points are added to the "+Game.getGame().getCurrPlayer().getUsername(),"Card Successfully Claimed",JOptionPane.PLAIN_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(this, "You don't have required theories to claim this publication card.","Cannot Claim Card",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		getContentPane().add(claimRewardButton);
		
		
        setJMenuBar(menuBar);

 
        menuBar.add(fileMenu);
        
        
        fileMenu.add(openDialogMenuItem);
        
        // Add ActionListener to open the dialog when the menu item is clicked
        openDialogMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openDialog();
            }
        });
        
        //back to Board button
        
        backToBoardButton.addActionListener(e -> {
        	
        	BoardWindow board = BoardWindow.getBoardWindow();
			board.initialize();
			setVisible(false);
			
        });
        menuBar.add(backToBoardButton);
	}
	
	
	// Singleton implementation
	public static synchronized PublicationTrackDisplay getInstance() {
		if (instance == null)
			instance = new PublicationTrackDisplay();
		return instance;
	}

	public void initialize() {
		theoryPanels.clear();
		getTheoryListItems();
		theoryList.setListData(theoryPanels.toArray());
		setVisible(true);
	}
	
	private PublicationCard getSelectedCard() {
		
		JLabel ingredientPanel1 = (JLabel) ((JPanel) publicationList.getSelectedValue()).getComponent(0);
		JLabel ingredientPanel2 = (JLabel) ((JPanel) publicationList.getSelectedValue()).getComponent(1);
		JLabel ingredientPanel3 = (JLabel) ((JPanel) publicationList.getSelectedValue()).getComponent(2);
		
		ImageIcon photo1 = (ImageIcon) ingredientPanel1.getIcon();
		ImageIcon photo2 = (ImageIcon) ingredientPanel2.getIcon();
		ImageIcon photo3 = (ImageIcon) ingredientPanel3.getIcon();
		
		Ingredient ing1 = findIngredientFromPhoto(photo1.getDescription());
		Ingredient ing2 = findIngredientFromPhoto(photo2.getDescription());
		Ingredient ing3 = findIngredientFromPhoto(photo3.getDescription());
		
		ArrayList<Ingredient> ingredients = new ArrayList<>();
		ingredients.add(ing1);
		ingredients.add(ing2);
		ingredients.add(ing3);
		PublicationCard card = findPublicationCard(ingredients);
		return card;
		
		
	}
	
	private void displayAlchemyMarkerSelectionDialog(Theory t) {
		
		ArrayList<String> alchemyMarkerPaths = new ArrayList<>();
		
		for (AlchemyMarker alcm : t.getAlchemical().getAspects()) {
			alchemyMarkerPaths.add(alcm.getIcon());
		}
		
		ArrayList<JPanel> alchemyMarkerPhotos = new ArrayList<>();
    	for (String s : alchemyMarkerPaths) {
    		JPanel p = new JPanel();
    		JLabel l = new JLabel();
    		ImageIcon i = new ImageIcon(new ImageIcon(s).getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH),s);
    		l.setIcon(i);
    		p.add(l);
    		alchemyMarkerPhotos.add(p);
    	}
		
		JFrame photoSelectionFrame = new JFrame("Select an Alchemy Marker to Debunk a Theory");
		photoSelectionFrame.setBounds(100, 100, 800, 600);
    	photoSelectionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	photoSelectionFrame.getContentPane().setLayout(null);
    	photoSelectionFrame.setResizable(false);
		
    	JScrollPane alchemyMarkerScrollPane = new JScrollPane();
    	alchemyMarkerScrollPane.setBounds(6, 54, 788, 400);
		photoSelectionFrame.getContentPane().add(alchemyMarkerScrollPane);
		
		JLabel titleLabel = new JLabel("Please Select an Alchemy Marker");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(241, 16, 325, 16);
		photoSelectionFrame.getContentPane().add(titleLabel);
		
		JList alchemyMarkerList = new JList();
		alchemyMarkerList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		alchemyMarkerList.setCellRenderer(new ImageListCellRenderer());
		
		alchemyMarkerList.setListData(alchemyMarkerPhotos.toArray());
		alchemyMarkerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		alchemyMarkerList.setFixedCellHeight(200);
		alchemyMarkerList.setFixedCellWidth(150);
		alchemyMarkerList.setVisibleRowCount(2);
		alchemyMarkerScrollPane.setViewportView(alchemyMarkerList);
		
		JButton selectButton = new JButton("Select ");
		selectButton.setBounds(341, 466, 117, 29);
		selectButton.addActionListener(e -> {
			
			if (alchemyMarkerList.getSelectedValue()!= null) {
				JLabel selectedPanel = (JLabel) ((JPanel) alchemyMarkerList.getSelectedValue()).getComponent(0);
				ImageIcon photo = (ImageIcon) selectedPanel.getIcon();
				AlchemyMarker alm = findAlchemyMarker(photo.getDescription(),t.getAlchemical().getAspects());
				photoSelectionFrame.dispose();
				revealAlchemyMarker(t,alm);
			}
			else {
				JOptionPane.showMessageDialog(photoSelectionFrame, "Please select an alchemy marker to debunk!","Select Alchemy Marker",JOptionPane.ERROR_MESSAGE);
			}
		});
		photoSelectionFrame.getContentPane().add(selectButton);
		photoSelectionFrame.setVisible(true);
	}
	
	private void revealAlchemyMarker(Theory theory ,AlchemyMarker alm) {
		
		Game.getGame().selectController(Controller.DEBUNK_THEORY);
		Boolean result = TheoryController.getInstance().initDebunkTheory(theory, alm);
		String resultMessage;
		if (result) {
			resultMessage="<html>Player "+Game.getGame().getCurrPlayer().getUsername()+" succesfully debunked the theory!</br> 2 reputation points is added to "+Game.getGame().getCurrPlayer().getUsername()+" , and"
					+ " 2 reputation points is deducted from "+theory.getOwner().getUsername()+" .</html>";
			theoryPanels.clear();
			getTheoryListItems();
			theoryList.setListData(theoryPanels.toArray());
		}
		else
			resultMessage="<html>Player "+Game.getGame().getCurrPlayer().getUsername()+" failed to debunk the theory!</br> 1 reputation point is deducted from player "+Game.getGame().getCurrPlayer().getUsername()+" .</html>";
		
		JFrame resultFrame = new JFrame();
		resultFrame.setBounds(100, 100, 800, 600);
		resultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		resultFrame.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("Result");
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(323, 56, 146, 47);
		resultFrame.getContentPane().add(titleLabel);
		
		JPanel alchemyMarkerPanel = new JPanel();
		alchemyMarkerPanel.setBounds(196, 125, 404, 306);
		resultFrame.getContentPane().add(alchemyMarkerPanel);
		
		JLabel descriptionLabel = new JLabel(resultMessage);
		descriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		descriptionLabel.setBounds(50, 464, 698, 77);
		resultFrame.getContentPane().add(descriptionLabel);
		
		JLabel revealedAlchemyMarkerLabel = new JLabel();
		revealedAlchemyMarkerLabel.setIcon(new ImageIcon(new ImageIcon(pt.returnCorrespondingAlchemyMarker(theory, alm).getIcon()).getImage().getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_SMOOTH)));
		alchemyMarkerPanel.add(revealedAlchemyMarkerLabel);
		resultFrame.setVisible(true);
		
	}


	private AlchemyMarker findAlchemyMarker(String photo, List<AlchemyMarker> aspects) {
		
		for (AlchemyMarker alcm : aspects) {
			if(alcm.getIcon().equals(photo))
				return alcm;
		}
		return null;
		
	}


	private void getPublishListItems() {
		
		for(int i=0; i<pt.getPublicationCards().size(); i++) {
			JPanel p = new JPanel();
			JLabel l1 = new JLabel();
			JLabel l2 = new JLabel();
			JLabel l3 = new JLabel();
			JLabel l4 = new JLabel("Reputation Point Reward: "+pt.getPublicationCards().get(i).getReputationReward());
			JLabel l5 = new JLabel("Gold Reward: "+pt.getPublicationCards().get(i).getGoldReward());
			l1.setIcon(new ImageIcon(new ImageIcon(pt.getPublicationCards().get(i).getRequiredTheories().get(0).getPhoto()).getImage().getScaledInstance(IMAGE_WIDTH/3, IMAGE_HEIGHT/3, Image.SCALE_SMOOTH),pt.getPublicationCards().get(i).getRequiredTheories().get(0).getPhoto()));
			l2.setIcon(new ImageIcon(new ImageIcon(pt.getPublicationCards().get(i).getRequiredTheories().get(1).getPhoto()).getImage().getScaledInstance(IMAGE_WIDTH/3, IMAGE_HEIGHT/3, Image.SCALE_SMOOTH),pt.getPublicationCards().get(i).getRequiredTheories().get(1).getPhoto()));
			l3.setIcon(new ImageIcon(new ImageIcon(pt.getPublicationCards().get(i).getRequiredTheories().get(2).getPhoto()).getImage().getScaledInstance(IMAGE_WIDTH/3, IMAGE_HEIGHT/3, Image.SCALE_SMOOTH),pt.getPublicationCards().get(i).getRequiredTheories().get(2).getPhoto()));
			p.add(l1);
			p.add(l2);
			p.add(l3);
			p.add(l4);
			p.add(l5);
			this.publicationBoardPanels.add(p);
		}
		
	}

	private void getTheoryListItems() {
		
		for(Theory t : pt.getPublishedTheories()) {
			JPanel theoryPanel = new JPanel();
			JLabel ingredientLabel = new JLabel();
			JLabel alchemicalLabel = new JLabel();
			JLabel informationLabel = new JLabel("Publisher: "+ t.getOwner().getUsername());
			
			ImageIcon ingredientIcon = new ImageIcon(new ImageIcon(t.getIngredientType().getPhoto()).getImage().getScaledInstance(IMAGE_WIDTH/2, IMAGE_HEIGHT/2, Image.SCALE_SMOOTH),t.getIngredientType().getPhoto());
			ImageIcon alchemicalIcon = new ImageIcon(new ImageIcon(t.getAlchemical().getAlchemicalPhoto()).getImage().getScaledInstance(IMAGE_WIDTH/2, IMAGE_HEIGHT/2, Image.SCALE_SMOOTH),t.getAlchemical().getAlchemicalPhoto());
			
			ingredientLabel.setIcon(ingredientIcon);
			alchemicalLabel.setIcon(alchemicalIcon);
			
			theoryPanel.add(ingredientLabel);
			theoryPanel.add(alchemicalLabel);
			theoryPanel.add(informationLabel);
			this.theoryPanels.add(theoryPanel);
		}
	}
	
	private Ingredient findIngredientFromPhoto(String path) {
    	
    	for (Ingredient i : IngredientStorage.getAllingredientcardsarray()) {
    		if (i.getPhoto().equals(path)) {
    			return i;
    		}
    	}
    	return null;
    }
	
	private PublicationCard findPublicationCard(List<Ingredient> ingredients) {
		
		for (PublicationCard pc : pt.getPublicationCards()) {
			
			if (pc.getRequiredTheories().containsAll(ingredients))
				return pc;
		}
		return null;
		
	}
	
	private Theory findTheory(Ingredient ing) {
		for (Theory t : pt.getPublishedTheories()) {
			if (Ingredient.checkEquality(t.getIngredientType(), ing))
				return t;
		}
		return null;
	}

	public void openDialog() {
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
    
    

}