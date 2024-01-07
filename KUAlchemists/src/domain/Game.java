package domain;

import java.util.ArrayDeque;
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
import domain.theorydeduction.TheoryController;
import ui.EndGameDisplay;
import ui.IngredientStorageDisplay;
import ui.LogInWindow;
import ui.PotionBrewingAreaDisplay;

public class Game {

	//fields
	private Controller controller = null;
	private Player currPlayer;
	private int numberOfPlayers;
	private int gameRound;
	
	private ArrayDeque<Player> players = new ArrayDeque<>();
	
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
	
	/* The abstraction function for the Game class is:
	// AF(game) = [] if game == null,
	// 			[game.numberOfPlayers,game.players] if game != null
	// 			where:
	//   			- numberOfPlayers is the total number of players in the game.
	//   			- players is a queue representing the order of players in the game.
	// 			additional details:
	//   			-players' order in the queue represents the order of turns.
	*/
	
	
	/**
	 * Representation Invariant:
	 * 		gameSingleton != null &&
	 * 		currPlayer != null && 
	 * 		2 <= numberOfPlayers <= 4 &&
	 * 		0 < gameRound <= 3 &&
	 * 		players != null && 0 < players.size() <= 5 &&
	 *  	players in players arrayDeque cannot be null
	 */
	
	public boolean repOk() {
		   
		if (gameSingleton == null) {
			return false;
		}

        if (currPlayer == null || !players.contains(currPlayer)) {
            return false;
        }

        if (numberOfPlayers < 2 || numberOfPlayers > 4) {
            return false;
        }

        if (gameRound < 0 || gameRound > 3) {
            return false;
        }

        for (Player player : players) {
            if (player == null) {
                return false;
            }
        }
        
        if (players == null) {
        	return false;
        }
        
        if (players.size() < 0 || players.size() > 5) {
        	return false;
        }
        	

        return true;
    }
	

	/**
	 * Initializes players for OFFLINE mode using numberOfPlayers.
	 * Gives players 2 ingredient cards from ingredients deck.
	 * Gives players 10 gold.
	 * @param loginWindow
	 * @param players
	 * @param numberOfPlayers
	 */
	
	
	public void initializePlayers(int numberOfPlayers) {
		
		//REQUIRES: Number of players is not null
		//MODIFIES: Game.players, scorePoint, currPlayer, IngredientCards, goldBalance is updated
		//EFFECTS:  scorePoint of the endRoundControl player is assigned to minimum integer value. Add players to Game.players. Two ingredients is added to Player's Ingredients. 
		//			Set gold balance to 10. Set current player to the first player.
		
		String username;
		
		int chosenAvatarIndex;
		Player endRoundControl = new Player("End Round Control",0);
		endRoundControl.setScorePoints(Integer.MIN_VALUE);
		players.offer(endRoundControl);
		
		int j = 0;
		for (int i = 0; i < numberOfPlayers; i++) {
			username = LogInWindow.getFirstUsername();
			chosenAvatarIndex = LogInWindow.getFirstAvatarIndex();
			Player p = new Player(username,chosenAvatarIndex);
			
			p.getIngredientCards().add(IngredientStorage.getInstance().getIngredientCards().get(j++));
			p.getIngredientCards().add(IngredientStorage.getInstance().getIngredientCards().get(j++));
			p.setGoldBalance(10);
			players.offer(p);
		}
		
		currPlayer = players.peek();
	}
	
	public void endTurn() {		
		
		//REQUIRES: Players is not null. Players' usernames are not null.
		//MODIFIES: currPlayer and players are modified.
		//EFFECTS: If player username equals "End Round Control", update gameRound
		//		   and currPlayer is updated to the first element of the players queue	
	

		Player oldPlayer = players.poll(); 
		players.offer(oldPlayer);
		
		if (oldPlayer.getUsername().equals("End Round Control")) {
			nextRound();
			currPlayer = players.poll();
			players.offer(currPlayer);
			
		}
		else {
			currPlayer = players.peek();
		}			
	}
	
	public void nextRound() {
		
		//MODIFIES: gameRound is modified
		//EFFECTS: gameRound is incremented by 1
		//		   if the gameRound exceeds three, endGame(players) function is called
		
		this.gameRound++;
		if (gameRound > 3) {
			endGame(players);
		}
	}
	
	public String endGame(ArrayDeque<Player> players) {
		
		//REQUIRES: players is not null
		//EFFECTS: Players' score is calculated, and the player with highest score is returned
		
		
		Player winner = players.peek();
		for (int i = 0; i < players.size(); i++) {
			Player p = players.poll();
			if (!p.getUsername().equals("End Round Control")) {
				players.offer(p);
				p.getScorePoints();
				if (p.getScorePoints() > winner.getScorePoints()) {
				//get max player points
				winner = p; //for now
				}
			}
		}
		
		EndGameDisplay.getInstance().displayWinner(winner);
		return winner.getUsername();
	}
	/**
	 * Initializes board
	 */
	public void initializeBoard() {
		
		//MODIFIES: PublicationTrack and IngredientStorageDisplay fields are modified
		//EFFECTS: Alchemicals and Ingredients are added to the PublicationTrack.
		//		   PublicationCards are created with random ingredients.
		//		   Constructs images in IngredientStorageDisplay
		
		IngredientStorageDisplay.getInstance().constructAllImagesDeck(IngredientController.getInstance().giveAllCardsToIngredientStorageDisplay());
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
			Ingredient[] ing = PotionBrewingAreaDisplay.getInstance().getChosenIngredients();
			PotionController.getInstance().initializeMakeExperiment(ing,currPlayer);
			//PlayerIngredientList.initialize(currPlayer);
			PotionBrewingAreaDisplay.getInstance().updateIngredient(currPlayer);
		case SELL_POTION:
			PotionController.getInstance().initializePotionSale();	
		case PUBLISH_THEORY:
			TheoryController.getInstance().setCurrPlayer(currPlayer);
		default:
			break;
		}
	}


	//getters and setters
	public  void setController(Controller gameController) {
		this.controller = gameController;
	}

	public Controller getController() {
		return controller;
	}

	// To get it in Other Classes
	public Player getCurrPlayer() {
		return currPlayer;
	}

	public void setCurrPlayer(Player currPlayer) {
		this.currPlayer = currPlayer;
	}

	public ArrayDeque<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayDeque<Player> players) {
		this.players = players;
	}
	
	public  int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public  void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}
	
	public int getGameRound() {
		return gameRound;
	}

	public void setGameRound(int gameRound) {
		this.gameRound = gameRound;		
	}
	
	
}
