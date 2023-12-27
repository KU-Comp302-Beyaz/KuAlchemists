package domain;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

import domain.artifact.ArtifactController;
import domain.artifact.ElixirOfInsight;
import domain.artifact.TheRiver;
import domain.ingredients.Alchemical;
import domain.ingredients.Ingredient;
import domain.ingredients.IngredientController;
import domain.ingredients.IngredientStorage;
import domain.potion.PotionController;
import domain.publication.PublicationCard;
import domain.publication.PublicationTrack;
import domain.theorydeduction.AlchemyMarker;
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
		SELL_POTION,
		PUBLISH_THEORY
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
		initializePublicationTrack();
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
	
	public static void initializePublicationTrack() {
		
		Random rand = new Random();
		PublicationTrack pt = PublicationTrack.getInstance();
		Alchemical a1 = new Alchemical(new AlchemyMarker("+","red","S"), new AlchemyMarker("-","green","L"), new AlchemyMarker("-","blue","S"), "src/images/alchemical-icons/alchemical1.png");
		Alchemical a2 = new Alchemical(new AlchemyMarker("-","red","S"), new AlchemyMarker("+","green","L"), new AlchemyMarker("+","blue","S"), "src/images/alchemical-icons/alchemical2.png");
		Alchemical a3 = new Alchemical(new AlchemyMarker("-","red","L"), new AlchemyMarker("-","green","S"), new AlchemyMarker("+","blue","S"), "src/images/alchemical-icons/alchemical3.png");
		Alchemical a4 = new Alchemical(new AlchemyMarker("+","red","S"), new AlchemyMarker("-","green","S"), new AlchemyMarker("+","blue","L"), "src/images/alchemical-icons/alchemical4.png");
		Alchemical a5 = new Alchemical(new AlchemyMarker("-","red","S"), new AlchemyMarker("+","green","S"), new AlchemyMarker("-","blue","L"), "src/images/alchemical-icons/alchemical5.png");
		Alchemical a6 = new Alchemical(new AlchemyMarker("+","red","L"), new AlchemyMarker("+","green","S"), new AlchemyMarker("-","blue","S"), "src/images/alchemical-icons/alchemical6.png");
		Alchemical a7 = new Alchemical(new AlchemyMarker("-","red","L"), new AlchemyMarker("-","green","L"), new AlchemyMarker("-","blue","L"), "src/images/alchemical-icons/alchemical7.png");
		Alchemical a8 = new Alchemical(new AlchemyMarker("+","red","L"), new AlchemyMarker("+","green","L"), new AlchemyMarker("+","blue","L"), "src/images/alchemical-icons/alchemical8.png");
		
		pt.getAvailableAlchemicals().add(a1);
		pt.getAvailableAlchemicals().add(a2);
		pt.getAvailableAlchemicals().add(a3);
		pt.getAvailableAlchemicals().add(a4);
		pt.getAvailableAlchemicals().add(a5);
		pt.getAvailableAlchemicals().add(a6);
		pt.getAvailableAlchemicals().add(a7);
		pt.getAvailableAlchemicals().add(a8);
		
		
		
		for (int i=0; i<8;i++) {
			pt.getAvailableIngredients().add(IngredientStorage.getAllingredientcardsarray()[i]);
		}
		
		for (int j=0; j<5; j++) {
			ArrayList<Ingredient> requiredIngredients = new ArrayList<>();
			while (requiredIngredients.size() < 3) {
				Ingredient randIngredient = IngredientStorage.getAllingredientcardsarray()[rand.nextInt(8)];
				if (!requiredIngredients.contains(randIngredient)) {
					requiredIngredients.add(randIngredient);
				}
			}
			PublicationCard card = new PublicationCard(requiredIngredients,rand.nextInt(5)+1,rand.nextInt(5)+1);
			pt.getPublicationCards().add(card);
		}
		
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
