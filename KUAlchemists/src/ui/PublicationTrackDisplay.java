package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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


import domain.Display;
import domain.publication.PublicationTrack;
import domain.theorydeduction.Theory;

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
		getContentPane().add(debunkButton);
		
		
		claimRewardButton.setFont(new Font("Cochin", Font.PLAIN, 20));
		claimRewardButton.setBounds(200, 719, 250, 64);
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
		publicationBoardPanels.clear();
		getPublishListItems();
		publicationList.setListData(publicationBoardPanels.toArray());
		setVisible(true);
	}
	
	
	
	private void getPublishListItems() {
		
		for(int i=0; i<pt.getPublicationCards().size(); i++) {
			JPanel p = new JPanel();
			JLabel l1 = new JLabel();
			JLabel l2 = new JLabel();
			JLabel l3 = new JLabel();
			JLabel l4 = new JLabel("Reputation Point Reward: "+pt.getPublicationCards().get(i).getReputationReward());
			JLabel l5 = new JLabel("Gold Reward: "+pt.getPublicationCards().get(i).getGoldReward());
			l1.setIcon(new ImageIcon(new ImageIcon(pt.getPublicationCards().get(i).getRequiredTheories().get(0).getPhoto()).getImage().getScaledInstance(IMAGE_WIDTH/3, IMAGE_HEIGHT/3, Image.SCALE_SMOOTH)));
			l2.setIcon(new ImageIcon(new ImageIcon(pt.getPublicationCards().get(i).getRequiredTheories().get(1).getPhoto()).getImage().getScaledInstance(IMAGE_WIDTH/3, IMAGE_HEIGHT/3, Image.SCALE_SMOOTH)));
			l3.setIcon(new ImageIcon(new ImageIcon(pt.getPublicationCards().get(i).getRequiredTheories().get(2).getPhoto()).getImage().getScaledInstance(IMAGE_WIDTH/3, IMAGE_HEIGHT/3, Image.SCALE_SMOOTH)));
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