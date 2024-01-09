package ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class EndGameDisplay extends JFrame{
	
	//Singleton implementation
		private static EndGameDisplay egDisplay;
		
		public static synchronized EndGameDisplay getInstance() {
			if (egDisplay == null)
				egDisplay = new EndGameDisplay();
			return egDisplay;
		}
		
		private EndGameDisplay() {
		       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(0, 0, 1440, 800);
		        this.setExtendedState(JFrame.MAXIMIZED_BOTH); // automatically extends frame to desktop size (full size)
		        
		        JPanel contentPane = new JPanel();
		        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		        contentPane.setLayout(new BorderLayout());
		        setContentPane(contentPane);

		}
		
		public void displayWinner() {
			
			setVisible(true);
			
		}
	
	
	
	

}
