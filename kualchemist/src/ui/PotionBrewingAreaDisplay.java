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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;

public class PotionBrewingAreaDisplay extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel potionSalePanel;
	private JLabel lblNewLabel;

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
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{0, 0};
        gbl_contentPane.rowHeights = new int[]{0, 0, 0};
        gbl_contentPane.columnWeights = new double[]{0.7, 0.3};
        gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);
        
        JPanel experimentPanel = new JPanel();
        GridBagConstraints gbc_experimentPanel = new GridBagConstraints();
        gbc_experimentPanel.insets = new Insets(0, 0, 5, 5);
        gbc_experimentPanel.fill = GridBagConstraints.BOTH;
        gbc_experimentPanel.gridx = 0;
        gbc_experimentPanel.gridy = 0;
        contentPane.add(experimentPanel, gbc_experimentPanel);
        
        JPanel potionSalePanel = new JPanel();
        potionSalePanel.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
        GridBagConstraints gbc_potionSalePanel = new GridBagConstraints();
        gbc_potionSalePanel.insets = new Insets(0, 0, 5, 0);
        gbc_potionSalePanel.fill = GridBagConstraints.BOTH;
        gbc_potionSalePanel.gridx = 1;
        gbc_potionSalePanel.gridy = 0;
        contentPane.add(potionSalePanel, gbc_potionSalePanel);
        potionSalePanel.setLayout(new GridLayout(1, 0, 0, 0));
          

	}
	
    
    public void initialize() {
		
		setVisible(true);
	}
}
