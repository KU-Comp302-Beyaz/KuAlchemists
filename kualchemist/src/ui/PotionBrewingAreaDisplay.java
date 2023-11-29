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

public class PotionBrewingAreaDisplay extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel experimentPanel;
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
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); // automatically extends frame to desktop size (full size)
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

        //Make Experiment Panel
        experimentPanel = new JPanel();
        experimentPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        experimentPanel.setBackground(SystemColor.activeCaption);
        experimentPanel.setPreferredSize(new Dimension ((int) (this.getWidth() * 0.7), this.getHeight()));
        contentPane.add(experimentPanel);

        //Potion Sale Panel
        potionSalePanel = new JPanel();
        potionSalePanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        potionSalePanel.setPreferredSize(new Dimension ((int) (this.getWidth() * 0.3), this.getHeight()));
        potionSalePanel.setBackground(SystemColor.textHighlight);
        contentPane.add(potionSalePanel);
        

	}
	
    
    public void initialize() {
		
		setVisible(true);
	}
}
