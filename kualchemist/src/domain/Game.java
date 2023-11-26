package domain;

import ui.BoardWindow;
import ui.MenuWindow;

public class Game {

	public static Player player1;
	public static Player player2;
	
	public static void main(String[] args) {
		
		//Displaying the Login Window:
		MenuWindow menuWindow = new MenuWindow();
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
