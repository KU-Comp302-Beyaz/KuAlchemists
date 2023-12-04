package domain;

import javax.swing.ImageIcon;

import domain.ingredients.Ingredient;
import domain.ingredients.IngredientController;
import ui.BoardWindow;
import ui.IngredientStorageDisplay;
import ui.LogInWindow;

public class Game {

	//fields
	public static Controller controller = null;
	public static Player player1;
	public static Player player2;
	
	//WE COULD ADD A currentPlayer TO USE FOR THE FUNCTIONS IN THE selectController()
	public Player currPlayer = player1;
	
	//Controller as enum
	public enum Controller {
		FORAGE_FOR_INGREDIENT,
		TRANSMUTE_INGREDIENT
	}
	
	//Singleton implementation
	private static Game gameSingleton = new Game();
	
	private Game() {}
	
	public static Game getGame() {
		return gameSingleton;
	}
	
	//MAIN function
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
	
	/**
	 * Selects which controller to use and function
	 * @param controller
	 */
	public void selectContoller(Controller controller) {
		switch (controller) {
		case FORAGE_FOR_INGREDIENT:
			ImageIcon ingredientCardImage = IngredientController.getIngredientController().addIngredientToPlayer(currPlayer);
			IngredientStorageDisplay.getIngredientStorageDisplay().displayCard(ingredientCardImage);
			break;
		case TRANSMUTE_INGREDIENT:
			IngredientController.getIngredientController().transmuteIngredient(currPlayer);
			IngredientStorageDisplay.getIngredientStorageDisplay().displayText();
			break;
		default:
			break;
		}
	}


	//getters and setters
	public static void setController(Controller gameController) {
		Game.controller = gameController;
	}

	public static Controller getController() {
		return controller;
	}

	public Player getCurrPlayer() {
		return currPlayer;
	}

	public void setCurrPlayer(Player currPlayer) {
		this.currPlayer = currPlayer;
	}


	
}
