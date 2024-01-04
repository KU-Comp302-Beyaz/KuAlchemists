package ui;

import javax.swing.JFrame;

import domain.Player;

public class EndGameDisplay extends JFrame {
	
	//Singleton implementation
	private static EndGameDisplay egDisplay = new EndGameDisplay();
	
	public static EndGameDisplay getInstance() {
		return egDisplay;
	}
	
	private EndGameDisplay() {}
	
	public void displayWinner(Player player) {}

}
