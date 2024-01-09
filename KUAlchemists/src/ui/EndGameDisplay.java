package ui;

import javax.swing.JFrame;

import domain.Player;
import domain.ingredients.IngredientController;

public class EndGameDisplay extends JFrame{
	
	//Singleton implementation
		private static EndGameDisplay egDisplay;
		
		public static synchronized EndGameDisplay getInstance() {
			if (egDisplay == null)
				egDisplay = new EndGameDisplay();
			return egDisplay;
		}
		
		private EndGameDisplay() {}
		
		public void displayWinner(Player player) {}
	
	
	
	

}
