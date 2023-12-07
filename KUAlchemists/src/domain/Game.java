package domain;

import javax.swing.ImageIcon;

import domain.artifact.ArtifactController;
import domain.artifact.ElixirOfInsight;
import domain.artifact.TheRiver;
import domain.ingredients.Ingredient;
import domain.ingredients.IngredientController;
import domain.ingredients.IngredientStorage;
import ui.BoardWindow;
import ui.IngredientStorageDisplay;
import ui.LogInWindow;

public class Game {
	
	//WE SHOULD USE THE STATE PATTERN IN HEAD FIRST DESIGN PATTERNS CHAPTER 10
	//states like: LOGIN_WINDOW, PLAYER1S_TURN, PLAYER2S_TURN, PLAYER1_WON, PLAYER2_WON, GAME_PAUSED etc.

	//fields
	public static Controller controller = null;
	public static Player player1;
	public static Player player2;
	
	//WE COULD ADD A currentPlayer TO USE FOR THE FUNCTIONS IN THE selectController()
	public static Player currPlayer;
	
	//Controller as enum
	public enum Controller {
		FORAGE_FOR_INGREDIENT,
		TRANSMUTE_INGREDIENT,
		BUY_THE_RIVER,
		BUY_EOI
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
		
		//just for now, will be implemented later
		currPlayer = player1;
		player1.getIngredientCards().put(IngredientStorage.getIngredientStorage().getIngredientCards().get(0).getIdentifier(),IngredientStorage.getIngredientStorage().getIngredientCards().get(0));
		player1.getIngredientCards().put(IngredientStorage.getIngredientStorage().getIngredientCards().get(1).getIdentifier(),IngredientStorage.getIngredientStorage().getIngredientCards().get(1));
		

	}
	
	/**
	 * Selects which controller to use and function
	 * @param controller
	 */
	public void selectController(Controller controller) {
		switch (controller) {
		case FORAGE_FOR_INGREDIENT:
			Ingredient newIngredient = IngredientController.getIngredientController().addIngredientToPlayer(currPlayer);
			ImageIcon newIngredientCardImageIcon = IngredientStorageDisplay.getIngredientStorageDisplay().getAllIngredientCardImageIcons().get(newIngredient.getIdentifier());
			IngredientStorageDisplay.getIngredientStorageDisplay().displayCard(newIngredient, newIngredientCardImageIcon);
			IngredientStorageDisplay.getIngredientStorageDisplay().initialize(currPlayer);
			break;
		case TRANSMUTE_INGREDIENT:
			int chosenIngredientIdentifier = IngredientStorageDisplay.getIngredientStorageDisplay().getChosenIngredient();
			IngredientController.getIngredientController().transmuteIngredient(currPlayer, chosenIngredientIdentifier);
			IngredientStorageDisplay.getIngredientStorageDisplay().displayText("<html>Ingredient transmuted.<br/>One gold added to Player.</html>");
			IngredientStorageDisplay.getIngredientStorageDisplay().initialize(currPlayer);
			break;
		case BUY_THE_RIVER:
			ArtifactController.getArtifactController().buyArtifact(new TheRiver() , currPlayer);
			break;
		case BUY_EOI:
			ArtifactController.getArtifactController().buyArtifact(new ElixirOfInsight() , currPlayer);
			
			
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

	// To get it in Other Classes
	public static Player getCurrPlayer() {
		return currPlayer;
	}

	public void setCurrPlayer(Player currPlayer) {
		this.currPlayer = currPlayer;
	}


	
}
