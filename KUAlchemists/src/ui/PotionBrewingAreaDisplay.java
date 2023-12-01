package ui;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JDesktopPane;
import javax.swing.JToolBar;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class PotionBrewingAreaDisplay extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JPanel experimentPanel;
	JPanel potionSalePanel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PotionBrewingAreaDisplay frame = new PotionBrewingAreaDisplay();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PotionBrewingAreaDisplay() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); // automatically extends frame to desktop size (full size)
        setResizable(false);
        
        //Gridbag layout of content pane
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{659, 0};
        gbl_contentPane.rowHeights = new int[]{0};
        gbl_contentPane.columnWeights = new double[]{0.7, 0.3}; //Experiment panel: 0.70 of the main frame, PotionSale panel: 0.30 of the main frame
        gbl_contentPane.rowWeights = new double[]{1.0};
        contentPane.setLayout(gbl_contentPane);
        
        
        //Panel to make and test experiments 
        experimentPanel = new JPanel();
        experimentPanel.setBackground(SystemColor.scrollbar);
        GridBagConstraints gbc_experimentPanel = new GridBagConstraints();
        gbc_experimentPanel.weightx = 0.7;
        gbc_experimentPanel.insets = new Insets(0, 0, 5, 5);
        gbc_experimentPanel.fill = GridBagConstraints.BOTH;
        gbc_experimentPanel.gridx = 0;
        gbc_experimentPanel.gridy = 0;
        contentPane.add(experimentPanel, gbc_experimentPanel);
        
        //Panel for potion sale
        potionSalePanel = new JPanel();
        potionSalePanel.setBackground(SystemColor.textHighlight);
        
        //Gridbag constraints of potionsale panel
        GridBagConstraints gbc_potionSalePanel = new GridBagConstraints();
        gbc_potionSalePanel.weightx = 0.3;
        gbc_potionSalePanel.insets = new Insets(0, 0, 5, 0);
        gbc_potionSalePanel.fill = GridBagConstraints.BOTH;
        gbc_potionSalePanel.gridx = 1;
        gbc_potionSalePanel.gridy = 0;
        contentPane.add(potionSalePanel, gbc_potionSalePanel);
        
        
        //Gridbag layout of the potion sale
        GridBagLayout gbl_potionSalePanel = new GridBagLayout();
        gbl_potionSalePanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_potionSalePanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_potionSalePanel.columnWeights = new double[]{0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
        gbl_potionSalePanel.rowWeights = new double[]{0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.0, 0.1};
        potionSalePanel.setLayout(gbl_potionSalePanel);
        
        //Panel for showing Adventurer's request
        JPanel requestPanel = new JPanel();
        GridBagConstraints gbc_requestPanel = new GridBagConstraints();
        gbc_requestPanel.gridwidth = 3;
        gbc_requestPanel.gridheight = 5;
        gbc_requestPanel.insets = new Insets(0, 0, 5, 5);
        gbc_requestPanel.fill = GridBagConstraints.BOTH;
        gbc_requestPanel.gridx = 3;
        gbc_requestPanel.gridy = 2;
        potionSalePanel.add(requestPanel, gbc_requestPanel);
        
        //Gridbag layout of Adventurer's request panel
        GridBagLayout gbl_adventurerPanel = new GridBagLayout();
        gbl_adventurerPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_adventurerPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_adventurerPanel.columnWeights = new double[]{0.1, 0.1, 0.1, 0.1, 0.1, 0.0, 0.1, 0.1, 0.1, 0.1, 0.1};
        gbl_adventurerPanel.rowWeights = new double[]{0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
        requestPanel.setLayout(gbl_adventurerPanel);     
        
        //Title of the Adventurer's panel
        JLabel adventurerRequestTitle = new JLabel("ADVENTURER'S REQUEST");
        adventurerRequestTitle.setFont(new Font("Cochin", Font.PLAIN, 36));
        GridBagConstraints gbc_adventurerRequestTitle = new GridBagConstraints();
        gbc_adventurerRequestTitle.gridwidth = 3;
        gbc_adventurerRequestTitle.insets = new Insets(0, 0, 5, 5);
        gbc_adventurerRequestTitle.gridx = 4;
        gbc_adventurerRequestTitle.gridy = 2;
        requestPanel.add(adventurerRequestTitle, gbc_adventurerRequestTitle);
                
        JLabel potionIcon = new JLabel("", new ImageIcon("Images/potions/potion-icon.png"), JLabel.CENTER);
        //potionIcon.setVisible(false);
        GridBagConstraints gbc_potionIcon = new GridBagConstraints();
        gbc_potionIcon.gridheight = 5;
        gbc_potionIcon.gridwidth = 3;
        gbc_potionIcon.insets = new Insets(0, 0, 5, 5);
        gbc_potionIcon.gridx = 4;
        gbc_potionIcon.gridy = 3;
        requestPanel.add(potionIcon, gbc_potionIcon);
        
        //Button for accepting Adventurer's request
        JButton acceptButton = new JButton("ACCEPT");
        
        //Event handler of the accept button
        acceptButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		//sell process başlayacak
        		
        	}
        });
        acceptButton.setFont(new Font("Cochin", Font.PLAIN, 20));
        //acceptButton.setVisible(false);
        GridBagConstraints gbc_acceptButton = new GridBagConstraints();
        gbc_acceptButton.gridwidth = 4;
        gbc_acceptButton.insets = new Insets(0, 0, 5, 5);
        gbc_acceptButton.gridx = 4;
        gbc_acceptButton.gridy = 10;
        gbc_acceptButton.fill = GridBagConstraints.HORIZONTAL;
        
        requestPanel.add(acceptButton, gbc_acceptButton);
        
        //Button for declining Adventurer's request
        JButton declineButton = new JButton("DECLINE");
        
        //Event handler of the DeclineButton
        declineButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//okay mesajı, turn number remains the same 
        		//bir daha sell potionı seçemez
        		
        		
        	}
        });
        declineButton.setFont(new Font("Cochin", Font.PLAIN, 20));
        //declineButton.setVisible(false);
        GridBagConstraints gbc_declineButton = new GridBagConstraints();
        gbc_declineButton.insets = new Insets(0, 0, 0, 5);
        gbc_declineButton.gridwidth = 4;
        gbc_declineButton.gridx = 4;
        gbc_declineButton.gridy = 11;
        gbc_declineButton.fill = GridBagConstraints.HORIZONTAL;
        
        requestPanel.add(declineButton, gbc_declineButton);
        
        JButton sellPotionButton = new JButton("SELL A POTION");
        
        //Event handler for Sell Potion button
        sellPotionButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		potionIcon.setVisible(true);
                acceptButton.setVisible(true);
                declineButton.setVisible(true);
        	}
        });
        
        sellPotionButton.setFont(new Font("Cochin", Font.PLAIN, 30));
        GridBagConstraints gbc_sellPotionButton = new GridBagConstraints();
        gbc_sellPotionButton.gridwidth = 3;
        gbc_sellPotionButton.insets = new Insets(0, 0, 5, 5);
        gbc_sellPotionButton.gridx = 3;
        gbc_sellPotionButton.gridy = 9;
        gbc_sellPotionButton.fill = GridBagConstraints.HORIZONTAL;
        potionSalePanel.add(sellPotionButton, gbc_sellPotionButton);
 
	}
	
    
    public void initialize() {
		
		setVisible(true);
	}
}
