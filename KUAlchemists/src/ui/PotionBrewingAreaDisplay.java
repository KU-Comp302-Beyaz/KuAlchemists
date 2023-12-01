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
		setBounds(0, 0, 1440, 900);
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH); // automatically extends frame to desktop size (full size)
        
        //Gridbag layout of content pane
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        
        //Panel to make and test experiments 
        experimentPanel = new JPanel();
        experimentPanel.setBounds(0, 0, 871, 1080);
        experimentPanel.setBackground(SystemColor.scrollbar);
        contentPane.add(experimentPanel);
        experimentPanel.setLayout(null);
        
        //Panel for potion sale
        potionSalePanel = new JPanel();
        potionSalePanel.setBounds(881, 0, 553, 866);
        potionSalePanel.setBackground(SystemColor.textHighlight);
        contentPane.add(potionSalePanel);
        potionSalePanel.setLayout(null);
        
        //Panel for showing Adventurer's request
        JPanel requestPanel = new JPanel();
        requestPanel.setBounds(50, 63, 484, 596);
        potionSalePanel.add(requestPanel);
        requestPanel.setLayout(null);
        
        //Title of the Adventurer's panel
        JLabel adventurerRequestTitle = new JLabel("ADVENTURER'S REQUEST");
        adventurerRequestTitle.setBounds(81, 6, 325, 42);
        adventurerRequestTitle.setFont(new Font("Cochin", Font.PLAIN, 24));
        requestPanel.add(adventurerRequestTitle);
                
        JLabel potionIcon = new JLabel("", new ImageIcon("images/potions/elixir-bottle-1.png"), JLabel.CENTER);
        potionIcon.setBounds(81, 60, 325, 372);
        requestPanel.add(potionIcon);
        
        //Button for accepting Adventurer's request
        JButton acceptButton = new JButton("ACCEPT");
        acceptButton.setBounds(81, 473, 325, 31);
        
        //Event handler of the accept button
        acceptButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		//sell process başlayacak
        		
        	}
        });
        acceptButton.setFont(new Font("Cochin", Font.PLAIN, 20));
        
        requestPanel.add(acceptButton);
        
        //Button for declining Adventurer's request
        JButton declineButton = new JButton("DECLINE");
        declineButton.setBounds(81, 516, 325, 31);
        
        //Event handler of the DeclineButton
        declineButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//okay mesajı, turn number remains the same 
        		//bir daha sell potionı seçemez
        		
        		
        	}
        });
        declineButton.setFont(new Font("Cochin", Font.PLAIN, 20));
        
        requestPanel.add(declineButton);
      
        
        JButton sellPotionButton = new JButton("SELL A POTION");
        sellPotionButton.setBounds(90, 671, 420, 43);
        potionSalePanel.add(sellPotionButton);
        
        //Event handler for Sell Potion button
        sellPotionButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		potionIcon.setVisible(true);
                acceptButton.setVisible(true);
                declineButton.setVisible(true);
        	}
        });
        
        sellPotionButton.setFont(new Font("Cochin", Font.PLAIN, 30));
 
	}
	
    
    public void initialize() {
		
		setVisible(true);
	}
}
