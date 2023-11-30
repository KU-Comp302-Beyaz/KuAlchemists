package domain;

import ui.BoardWindow;
import ui.LogInWindow;

public class Game {

	private static Game gameSingleton = new Game();
	
	public static Player player1;
	public static Player player2;
	
	private Game() {}
	
	public static Game getGame() {
		return gameSingleton;
	}
	
	public static void main(String[] args) {
		
		//Displaying the Login Window:
		LogInWindow menuWindow = new LogInWindow();
		menuWindow.displayMenuWindow();
		
		//Creation of player1:
		String username1 = menuWindow.getFirstUsername();
		int chosenAvatarIndex1 = menuWindow.getFirstAvatarIndex();
		player1 = new Player(username1, chosenAvatarIndex1);

		
		//Creation of player2:
		String username2 = menuWindow.getSecondUsername();
		int chosenAvatarIndex2 = menuWindow.getSecondAvatarIndex();
		player2 = new Player(username2, chosenAvatarIndex2);

	}
	
	public void selectContoller() {
	
	}
	
}
