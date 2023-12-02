package ui;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
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
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;

import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import ui.LogInWindow.ImageListCellRenderer;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.SpringLayout;
import java.awt.CardLayout;

public class PotionBrewingAreaDisplay extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	private JPanel potionSalePanel;
	private JLabel lblNewLabel;

	
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
		setBounds(300, 300, 1550, 900);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); // automatically extends frame to desktop size (full size)

        //Gridbag layout of content pane
        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPanel);
        GridBagLayout gbl_contentPanel = new GridBagLayout();
        gbl_contentPanel.columnWidths = new int[]{0, 0};
        gbl_contentPanel.rowHeights = new int[]{0};
        gbl_contentPanel.columnWeights = new double[]{0.75, 0.25}; //Experiment panel: 0.75 of the main frame, PotionSale panel: 0.25 of the main frame
        gbl_contentPanel.rowWeights = new double[]{1.0};
        contentPanel.setLayout(gbl_contentPanel);
        
        
        //Panel to make and test experiments 
        JPanel experimentPanel = new JPanel();
        experimentPanel.setBackground(Color.LIGHT_GRAY);
        GridBagConstraints gbc_experimentPanel = new GridBagConstraints();
        gbc_experimentPanel.insets = new Insets(0, 0, 5, 5);
        gbc_experimentPanel.fill = GridBagConstraints.BOTH;
        gbc_experimentPanel.gridwidth = 3;
        gbc_experimentPanel.gridx = 0;
        gbc_experimentPanel.gridy = 0;
        contentPanel.add(experimentPanel, gbc_experimentPanel);
        GridBagLayout gbl_experimentPanel = new GridBagLayout();
        gbl_experimentPanel.columnWidths = new int[]{0, 0};
        gbl_experimentPanel.rowHeights = new int[]{0, 0, 0, 0};
        gbl_experimentPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_experimentPanel.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
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
        
        
        
        /**
		 * Taking the avatar images from the /Images/avatar-icons folder 
		 */
		JLabel[] avatarIcons = new JLabel[6];
		JPanel[] avatarPanels = new JPanel[6];
		for (int i = 0; i < 6; i++) {
			avatarIcons[i] = new JLabel("", new ImageIcon("Images/avatar-icons/avatar"+(i+1)+".png"), JLabel.CENTER);
			avatarPanels[i] = new JPanel();
			avatarPanels[i].add(avatarIcons[i]);
		}
						
		JList ingredientList = new JList();
		ingredientList.setCellRenderer(new ImageListCellRenderer());
		ingredientList.setListData(avatarPanels);
		ingredientList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		ingredientList.setBounds(165,215,128,280);
		ingredientList.setFixedCellHeight(140);
		ingredientList.setFixedCellWidth(128);	
		ingredientList.setSelectedIndex(0);
		
        JScrollPane scrollPane_ingredients = new JScrollPane();
        scrollPane_ingredients.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane_ingredients.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
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
        makePotionPanel.add(btnMakePotion, BorderLayout.CENTER);
        
        
      

    
        
        
        //////////////////////////////////////////
        
        //Panel for potion sale
        JPanel potionSalePanel = new JPanel();
        potionSalePanel.setBackground(Color.WHITE);
        
        //Gridbag constraints of potionsale panel
        GridBagConstraints gbc_potionSalePanel = new GridBagConstraints();
        gbc_potionSalePanel.insets = new Insets(0, 0, 5, 0);
        gbc_potionSalePanel.fill = GridBagConstraints.BOTH;
        gbc_potionSalePanel.gridx = 3;
        gbc_potionSalePanel.gridy = 0;
        contentPanel.add(potionSalePanel, gbc_potionSalePanel);
        
        
        //Gridbag layout of the potion sale
        GridBagLayout gbl_potionSalePanel = new GridBagLayout();
        gbl_potionSalePanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
        gbl_potionSalePanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
        gbl_potionSalePanel.columnWeights = new double[]{0.2, 0.2, 0.2, 0.2, 0.2, 0.2, 0.2};
        gbl_potionSalePanel.rowWeights = new double[]{0.2, 0.2, 0.2, 0.2, 0.2, 0.2, 0.2};
        potionSalePanel.setLayout(gbl_potionSalePanel);
        
        //Panel for showing Adventurer's request
        JPanel requestPanel = new JPanel();
        GridBagConstraints gbc_requestPanel = new GridBagConstraints();
        gbc_requestPanel.gridheight = 4;
        gbc_requestPanel.insets = new Insets(0, 0, 5, 0);
        gbc_requestPanel.fill = GridBagConstraints.HORIZONTAL;
        gbc_requestPanel.gridx = 1;
        gbc_requestPanel.gridy = 1;
        potionSalePanel.add(requestPanel, gbc_requestPanel);
        
        //Gridbag layout of Adventurer's request panel
        GridBagLayout gbl_adventurerPanel = new GridBagLayout();
        gbl_adventurerPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
        gbl_adventurerPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
        gbl_adventurerPanel.columnWeights = new double[]{0.2, 0.2, 0.2, 0.2, 0.2, 0.2, 0.2};
        gbl_adventurerPanel.rowWeights = new double[]{0.2, 0.2, 0.2, 0.2, 0.2, 0.2, 0.2, Double.MIN_VALUE};
        requestPanel.setLayout(gbl_adventurerPanel);     
                
        //Title of the Adventurer's panel
        JLabel adventurerRequestTitle = new JLabel("ADVENTURER'S REQUEST");
        adventurerRequestTitle.setFont(new Font("Cochin", Font.PLAIN, 36));
        GridBagConstraints gbc_adventurerRequestTitle = new GridBagConstraints();
        gbc_adventurerRequestTitle.gridwidth = 2;
        gbc_adventurerRequestTitle.insets = new Insets(0, 0, 5, 5);
        gbc_adventurerRequestTitle.gridx = 1;
        gbc_adventurerRequestTitle.gridy = 1;
        requestPanel.add(adventurerRequestTitle, gbc_adventurerRequestTitle);

        //Button for accepting Adventurer's request
        JButton acceptButton = new JButton("ACCEPT");
        acceptButton.setFont(new Font("Cochin", Font.PLAIN, 20));
        GridBagConstraints gbc_acceptButton = new GridBagConstraints();
        gbc_acceptButton.gridwidth = 3;
        gbc_acceptButton.insets = new Insets(0, 0, 5, 5);
        gbc_acceptButton.gridx = 3;
        gbc_acceptButton.gridy = 10;
        gbc_acceptButton.fill = GridBagConstraints.HORIZONTAL;
        
        requestPanel.add(acceptButton, gbc_acceptButton);
        
        //Button for declining Adventurer's request
        JButton declineButton = new JButton("DECLINE");
        declineButton.setFont(new Font("Cochin", Font.PLAIN, 20));
        GridBagConstraints gbc_declineButton = new GridBagConstraints();
        gbc_declineButton.insets = new Insets(0, 0, 0, 5);
        gbc_declineButton.gridwidth = 3;
        gbc_declineButton.gridx = 3;
        gbc_declineButton.gridy = 11;
        gbc_declineButton.fill = GridBagConstraints.HORIZONTAL;
        
        requestPanel.add(declineButton, gbc_declineButton);
 
	}
	
    
    public void initialize() {
		
		setVisible(true);
	}
}
