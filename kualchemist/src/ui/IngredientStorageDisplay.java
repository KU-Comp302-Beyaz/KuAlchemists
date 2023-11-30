package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;

public class IngredientStorageDisplay extends JFrame {
	
	private static IngredientStorageDisplay isDisplay = new IngredientStorageDisplay();
	
	private JPanel ingredientStoragePanel;
	
	private IngredientStorageDisplay() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 1550, 900);
		getContentPane().setName("heyy");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("jhegfjagdfjkahkdkjvcbaksc");
		lblNewLabel.setBounds(6, 6, 170, 16);
		panel.add(lblNewLabel);
		
		setVisible(true);
		
	}
	
	public static IngredientStorageDisplay getIngredientStorageDisplay() {
		return isDisplay;
	}
	
	public void initialize() {
		setVisible(true);
	}
	
	public void openDisplay() {
		
	}
	
	public void displayText() {
		
	}
	
	public void displayCard() {
		
	}

}
