package domain;

import javax.swing.ImageIcon;

import domain.artifact.ArtifactController;
import domain.artifact.ElixirOfInsight;
import domain.artifact.TheRiver;
import domain.ingredients.Ingredient;
import domain.ingredients.IngredientController;
import domain.ingredients.IngredientStorage;
import domain.potion.PotionController;
import ui.BoardWindow;
import ui.IngredientStorageDisplay;
import ui.LogInWindow;
import ui.PlayerIngredientList;
import ui.PotionBrewingAreaDisplay;

public class Game {

	//fields
	private static Controller controller = null;
	private static Player currPlayer;
	
	private static Player[] players = new Player[4];
	
	//Controller as enum
	public enum Controller {
		FORAGE_FOR_INGREDIENT,
		TRANSMUTE_INGREDIENT,
		BUY_THE_RIVER,
		BUY_EOI,
		MAKE_EXPERIMENT,
		SELL_POTION
	};
	
	//Singleton implementation
	private static Game gameSingleton = new Game();
	
	private Game() {}
	
	public static Game getGame() {
		return gameSingleton;
	}
	
	//Main function
	public static void main(String[] args) {
		
		//Displaying the Login Window:
		LogInWindow loginWindow = LogInWindow.getInstance(); 
		loginWindow.displayLogInWindow();
		
		int numberOfPlayers = loginWindow.getNumberOfPlayers();

		numberOfPlayers = 2; //for now erase later
		
		initializePlayers(loginWindow,players,numberOfPlayers);
		initializeBoard();

	}
	
	/**
	 * Initializes players for OFFLINE mode using numberOfPlayers.
	 * Gives players 2 ingredient cards from ingredients deck.
	 * Gives players 10 gold.
	 * @param loginWindow
	 * @param players
	 * @param numberOfPlayers
	 */
	public static void initializePlayers(LogInWindow loginWindow, Player[] players, int numberOfPlayers) {
		String username;
		int chosenAvatarIndex;
		int j = 0;
		for (int i = 0; i < numberOfPlayers; i++) {
			username = loginWindow.getFirstUsername();
			chosenAvatarIndex = loginWindow.getFirstAvatarIndex();
			players[i] = new Player(username,chosenAvatarIndex);
			
			players[i].getIngredientCards().add(IngredientStorage.getInstance().getIngredientCards().get(j++));
			players[i].getIngredientCards().add(IngredientStorage.getInstance().getIngredientCards().get(j++));
			
			players[i].setGoldBalance(10);
		}
		currPlayer = players[0];
	}
	
	/**
	 * Initializes board
	 */
	public static void initializeBoard() {
		IngredientStorageDisplay.getInstance().constructAllImagesDeck(IngredientController.getInstance().giveAllCardsToIngredientStorageDisplay());
	}
	
	/**
	 * Selects which controller to use and function
	 * @param controller
	 */
	public void selectController(Controller controller) {
		switch (controller) {
		case FORAGE_FOR_INGREDIENT:
			Ingredient newIngredient = IngredientController.getInstance().addIngredientToPlayer(currPlayer);
			ImageIcon newIngredientCardImageIcon = IngredientStorageDisplay.getInstance().getImage(newIngredient);
			IngredientStorageDisplay.getInstance().displayCard(newIngredient, newIngredientCardImageIcon);
			IngredientStorageDisplay.getInstance().initialize(currPlayer);
			break;
		case TRANSMUTE_INGREDIENT:
			Ingredient chosenIngredient = IngredientStorageDisplay.getInstance().getChosenIngredient();
			IngredientController.getInstance().transmuteIngredient(currPlayer, chosenIngredient);
			IngredientStorageDisplay.getInstance().displayText("<html>Ingredient transmuted.<br/>One gold added to Player.</html>");
			IngredientStorageDisplay.getInstance().initialize(currPlayer);
			break;
		case BUY_THE_RIVER:
			ArtifactController.getArtifactController().buyArtifact(new TheRiver() , currPlayer);
			break;
		case BUY_EOI:
			ArtifactController.getArtifactController().buyArtifact(new ElixirOfInsight() , currPlayer);
			break;
		case MAKE_EXPERIMENT:
			Ingredient[] ing = PotionBrewingAreaDisplay.getPotionBrewingAreaDisplay().getChosenIngredients();
			PotionController.getInstance().initializeMakeExperiment(ing,currPlayer);
			//PlayerIngredientList.initialize(currPlayer);
			PotionBrewingAreaDisplay.getPotionBrewingAreaDisplay().updateIngredient(currPlayer);
		case SELL_POTION:
			PotionController.getInstance().initializePotionSale();			
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
		Game.currPlayer = currPlayer;
	}

	public static Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		Game.players = players;
	}

	
	


	
}
