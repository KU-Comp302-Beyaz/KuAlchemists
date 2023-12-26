package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;


public class PublicationTrackDisplay extends JFrame implements Display {
	
	private static PublicationTrackDisplay isDisplay = new PublicationTrackDisplay(); // Singleton 
	private ArrayList<JPanel> publicationBoardPanels = new ArrayList<>();
	private ArrayList<JPanel> theoryPanels = new ArrayList<>();
	
	private static final int IMAGE_WIDTH = 200, IMAGE_HEIGHT = 200;
	
	
	
	private PublicationTrackDisplay() {
		
		setResizable(false);
		setTitle("KuAlchemists");
		setBounds(0, 0, 1440, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("Publication Track");
		titleLabel.setFont(new Font("Cochin", Font.PLAIN, 30));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(632, 74, 250, 50);
		getContentPane().add(titleLabel);
		
		JLabel trackInfoLabel = new JLabel("Publication Cards");
		trackInfoLabel.setFont(new Font("Cochin", Font.PLAIN, 25));
		trackInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		trackInfoLabel.setBounds(252, 169, 250, 50);
		getContentPane().add(trackInfoLabel);
		
		JLabel theoryInfoPanel = new JLabel("Published Theories");
		theoryInfoPanel.setFont(new Font("Cochin", Font.PLAIN, 25));
		theoryInfoPanel.setHorizontalAlignment(SwingConstants.CENTER);
		theoryInfoPanel.setBounds(1044, 169, 250, 50);
		getContentPane().add(theoryInfoPanel);
		
		JScrollPane publicationScrollPane = new JScrollPane();
		publicationScrollPane.setBounds(50, 221, 560, 480);
		getContentPane().add(publicationScrollPane);
		
		JList publicationList = new JList();
		publicationList.setLayoutOrientation(JList.VERTICAL);
		publicationList.setCellRenderer(new ImageListCellRenderer());
		getPublishListItems();
		publicationList.setListData(publicationBoardPanels.toArray());
		publicationList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		publicationList.setFixedCellHeight(IMAGE_HEIGHT+50);
		publicationList.setFixedCellWidth(IMAGE_WIDTH);
		publicationScrollPane.setViewportView(publicationList);
		
		JScrollPane theoryScrollPane = new JScrollPane();
		theoryScrollPane.setBounds(855, 221, 560, 480);
		getContentPane().add(theoryScrollPane);
		
		JList theoryList = new JList();
		theoryList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		theoryList.setCellRenderer(new ImageListCellRenderer());
		getTheoryListItems();
		theoryList.setListData(theoryPanels.toArray());
		theoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		theoryList.setFixedCellHeight(IMAGE_HEIGHT+38);
		theoryList.setFixedCellWidth(IMAGE_WIDTH);
		theoryList.setVisibleRowCount(2);
		theoryScrollPane.setViewportView(theoryList);
		
		JButton debunkButton = new JButton("Debunk A Theory");
		debunkButton.setFont(new Font("Cochin", Font.PLAIN, 20));
		debunkButton.setBounds(1058, 719, 250, 64);
		getContentPane().add(debunkButton);
		
		JButton claimRewardButton = new JButton("Claim Publication Card");
		claimRewardButton.setFont(new Font("Cochin", Font.PLAIN, 20));
		claimRewardButton.setBounds(252, 719, 250, 64);
		getContentPane().add(claimRewardButton);
		
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
        backToBoardButton.addActionListener(e -> {
        	
        	BoardWindow board = BoardWindow.getBoardWindow();
			board.initialize();
			setVisible(false);
			
        });
        menuBar.add(backToBoardButton);
	}
	
	
	
	public static PublicationTrackDisplay getIsDisplay() {
		return isDisplay;
	}





	public void initialize() {
		setVisible(true);
	}
	
	// will be called by PublicationTrack and will have parameters. It is implemented here just to show how it will work.

	
	private void getPublishListItems() {
		
		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JLabel label = new JLabel();
		JLabel label2 = new JLabel();
		JLabel label3 = new JLabel();
		JLabel label4 = new JLabel("Reputation Point Reward: 3");
		JLabel labela = new JLabel("Gold Reward: 4");
		
		JLabel label5 = new JLabel();
		JLabel label6 = new JLabel();
		JLabel label7 = new JLabel();
		JLabel label8 = new JLabel("Reputation Point Reward: 2");
		JLabel labelb = new JLabel("Gold Reward: 3");

		
		JLabel label9 = new JLabel();
		JLabel label10 = new JLabel();
		JLabel label11 = new JLabel();
		JLabel label12 = new JLabel("Reputation Point Reward: 1");
		JLabel labelc = new JLabel("Gold Reward: 5");

		
		label.setIcon(new ImageIcon(new ImageIcon("src/images/images-icons/ingredient8.jpg").getImage().getScaledInstance(IMAGE_WIDTH/3, IMAGE_HEIGHT/3, Image.SCALE_SMOOTH)));
		label2.setIcon(new ImageIcon(new ImageIcon("src/images/images-icons/ingredient10.jpg").getImage().getScaledInstance(IMAGE_WIDTH/3, IMAGE_HEIGHT/3, Image.SCALE_SMOOTH)));
		label3.setIcon(new ImageIcon(new ImageIcon("src/images/images-icons/ingredient11.jpg").getImage().getScaledInstance(IMAGE_WIDTH/3, IMAGE_HEIGHT/3, Image.SCALE_SMOOTH)));

		
		label5.setIcon(new ImageIcon(new ImageIcon("src/images/images-icons/ingredient1.jpg").getImage().getScaledInstance(IMAGE_WIDTH/3, IMAGE_HEIGHT/3, Image.SCALE_SMOOTH)));
		label6.setIcon(new ImageIcon(new ImageIcon("src/images/images-icons/ingredient2.jpg").getImage().getScaledInstance(IMAGE_WIDTH/3, IMAGE_HEIGHT/3, Image.SCALE_SMOOTH)));
		label7.setIcon(new ImageIcon(new ImageIcon("src/images/images-icons/ingredient3.jpg").getImage().getScaledInstance(IMAGE_WIDTH/3, IMAGE_HEIGHT/3, Image.SCALE_SMOOTH)));

		
		label9.setIcon(new ImageIcon(new ImageIcon("src/images/images-icons/ingredient5.jpg").getImage().getScaledInstance(IMAGE_WIDTH/3, IMAGE_HEIGHT/3, Image.SCALE_SMOOTH)));
		label10.setIcon(new ImageIcon(new ImageIcon("src/images/images-icons/ingredient6.jpg").getImage().getScaledInstance(IMAGE_WIDTH/3, IMAGE_HEIGHT/3, Image.SCALE_SMOOTH)));
		label11.setIcon(new ImageIcon(new ImageIcon("src/images/images-icons/ingredient7.jpg").getImage().getScaledInstance(IMAGE_WIDTH/3, IMAGE_HEIGHT/3, Image.SCALE_SMOOTH)));

		panel.add(label);
		panel.add(label2);
		panel.add(label3);
		panel.add(label4);
		panel.add(labela);

		
		panel2.add(label5);
		panel2.add(label6);
		panel2.add(label7);
		panel2.add(label8);
		panel2.add(labelb);

		
		panel3.add(label9);
		panel3.add(label10);
		panel3.add(label11);
		panel3.add(label12);
		panel3.add(labelc);

		

		this.publicationBoardPanels.add(panel);
		this.publicationBoardPanels.add(panel2);
		this.publicationBoardPanels.add(panel3);

		
		

	}
		
		
	// will be called by PublicationTrack and will have parameters. It is implemented here just to show how it will work.
	
	private void getTheoryListItems() {
		
		JPanel panel = new JPanel();
		JLabel label = new JLabel();
		JLabel label2 = new JLabel();
		JLabel label3 = new JLabel("Publisher: <player1 username>");
		
		label.setIcon(new ImageIcon(new ImageIcon("src/images/images-icons/ingredient8.jpg").getImage().getScaledInstance(IMAGE_WIDTH/2, IMAGE_HEIGHT/2, Image.SCALE_SMOOTH)));
		label2.setIcon(new ImageIcon(new ImageIcon("src/images/alchemical-icons/alchemical1.png").getImage().getScaledInstance(IMAGE_WIDTH/2, IMAGE_HEIGHT/2, Image.SCALE_SMOOTH)));
		
		panel.add(label);
		panel.add(label2);
		panel.add(label3);
		
		JPanel panel2 = new JPanel();
		JLabel label4 = new JLabel();
		JLabel label5 = new JLabel();
		JLabel label6 = new JLabel("Publisher: <player2 username>");
		
		label4.setIcon(new ImageIcon(new ImageIcon("src/images/images-icons/ingredient9.jpg").getImage().getScaledInstance(IMAGE_WIDTH/2, IMAGE_HEIGHT/2, Image.SCALE_SMOOTH)));
		label5.setIcon(new ImageIcon(new ImageIcon("src/images/alchemical-icons/alchemical2.png").getImage().getScaledInstance(IMAGE_WIDTH/2, IMAGE_HEIGHT/2, Image.SCALE_SMOOTH)));
		
		panel2.add(label4);
		panel2.add(label5);
		panel2.add(label6);
		
		
		this.theoryPanels.add(panel);
		this.theoryPanels.add(panel2);
		
		
		
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