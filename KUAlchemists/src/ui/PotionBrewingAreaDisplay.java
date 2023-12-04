package ui;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
import java.awt.Image;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListCellRenderer;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.BorderLayout;
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
		setBounds(0, 0, 1440, 900);
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH); // automatically extends frame to desktop size (full size)
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        
        //Panel to make and test experiments 
        experimentPanel = new JPanel();
        experimentPanel.setBounds(0, 0, 871, 1080);
        experimentPanel.setBackground(SystemColor.scrollbar);
        contentPane.add(experimentPanel);
        GridBagLayout gbl_experimentPanel = new GridBagLayout();
        gbl_experimentPanel.columnWidths = new int[]{0};
        gbl_experimentPanel.rowHeights = new int[]{0};
        gbl_experimentPanel.columnWeights = new double[]{Double.MIN_VALUE};
        gbl_experimentPanel.rowWeights = new double[]{Double.MIN_VALUE};
        experimentPanel.setLayout(gbl_experimentPanel);
        
        JPanel ingredientPanel = new JPanel();
        GridBagConstraints gbc_ingredientPanel = new GridBagConstraints();
        gbc_ingredientPanel.insets = new Insets(0, 0, 5, 0);
        gbc_ingredientPanel.fill = GridBagConstraints.BOTH;
        gbc_ingredientPanel.gridx = 0;
        gbc_ingredientPanel.gridy = 0;
        experimentPanel.add(ingredientPanel, gbc_ingredientPanel);
        ingredientPanel.setLayout(new BorderLayout(0, 0));
        
        JLabel lblIngredients = new JLabel("INGREDIENTS");
        lblIngredients.setFont(new Font("Cochin", Font.PLAIN, 20));
        lblIngredients.setHorizontalAlignment(SwingConstants.CENTER);
        ingredientPanel.add(lblIngredients, BorderLayout.NORTH);
        
        JScrollPane scrollPane_ingredients = new JScrollPane();
        scrollPane_ingredients.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane_ingredients.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        
        
        /**
		 * Taking the ingredients images from the Images/images-icons/ folder 
		 */
		JLabel[] ingredientsIcons = new JLabel[12];
		JPanel[] ingredientPanels = new JPanel[12];
		for (int i = 0; i < 12; i++) {
			ingredientsIcons[i] = new JLabel("", new ImageIcon("src/images/images-icons/ingredient"+(i+1)+".jpg"), JLabel.CENTER);
			ingredientPanels[i] = new JPanel();
			//avatarPanels[i].setMaximumSize();
			//avatarPanels[i].setLayout(new BoxLayout(avatarPanels[i], BoxLayout.X_AXIS));
			//avatarPanels[i].setPreferredSize(new Dimension(avatarPanels[i].getPreferredSize().width, scrollPane_ingredients.getHeight()));
		       
			ingredientPanels[i].add(ingredientsIcons[i]);
		}
						
		JList ingredientList = new JList();
		ingredientList.setCellRenderer(new ImageListCellRenderer());
		ingredientList.setListData(ingredientPanels);
		ingredientList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		//ingredientList.setFixedCellHeight(scrollPane_ingredients.getHeight());
		//ingredientList.setFixedCellHeight(200);
		//ingredientList.setFixedCellWidth(150);
		ingredientList.setVisibleRowCount(1); // Set the visible row count to 1 for horizontal layout
        ingredientList.setSelectedIndex(0);    
		//ingredientList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
         
        // add ingredientList to scrollPane_ingredients
        scrollPane_ingredients.setViewportView(ingredientList);
        ingredientPanel.add(scrollPane_ingredients, BorderLayout.CENTER);
        
        
        
        JPanel testPanel = new JPanel();
        GridBagConstraints gbc_testPanel = new GridBagConstraints();
        gbc_testPanel.insets = new Insets(0, 0, 5, 0);
        gbc_testPanel.fill = GridBagConstraints.BOTH;
        gbc_testPanel.gridx = 0;
        gbc_testPanel.gridy = 1;
        experimentPanel.add(testPanel, gbc_testPanel);
        testPanel.setLayout(new GridLayout(0, 1, 0, 0));
        
        JLabel lblTestOn = new JLabel("TEST ON");
        lblTestOn.setFont(new Font("Cochin", Font.PLAIN, 20));
        lblTestOn.setHorizontalAlignment(SwingConstants.CENTER);
        testPanel.add(lblTestOn);
        
        JButton btnTestOnPlayer = new JButton("Player");
        btnTestOnPlayer.setFont(new Font("Cochin", Font.PLAIN, 20));
        testPanel.add(btnTestOnPlayer);
        
        JButton btnTestOnStudent = new JButton("Student");
        btnTestOnStudent.setFont(new Font("Cochin", Font.PLAIN, 20));
        testPanel.add(btnTestOnStudent);
        
        JPanel makePotionPanel = new JPanel();
        GridBagConstraints gbc_makePotionPanel = new GridBagConstraints();
        gbc_makePotionPanel.fill = GridBagConstraints.BOTH;
        gbc_makePotionPanel.gridx = 0;
        gbc_makePotionPanel.gridy = 2;
        experimentPanel.add(makePotionPanel, gbc_makePotionPanel);
        makePotionPanel.setLayout(new BorderLayout(0, 0));
        
        JButton btnMakePotion = new JButton("MAKE POTION");
        btnMakePotion.setFont(new Font("Cochin", Font.PLAIN, 20));
        //ImageIcon icon = createImageIcon("path/to/your/image.jpg"); // Replace with the actual path to your image
        ImageIcon icon = new ImageIcon("src/images/witchCauldron.jpg");
        Image img = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);
        
        btnMakePotion.setIcon(icon);
        // Use BoxLayout to arrange the components vertically
        btnMakePotion.setLayout(new BoxLayout(btnMakePotion, BoxLayout.Y_AXIS));
        
        makePotionPanel.add(btnMakePotion, BorderLayout.CENTER);
        
     
        //////////////////////////////// 
        
        
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
                
        JLabel potionIcon = new JLabel("", new ImageIcon("imagespotions/elixir-bottle-1.png"), JLabel.CENTER);
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
