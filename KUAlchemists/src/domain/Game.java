package domain;

import java.util.ArrayList;
import domain.artifact.*;
import java.util.HashMap;
import java.util.Random;
import java.util.Stack;


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
import ui.LogInWindow;

public class Game {

	//fields
	private Controller controller = null;
	private Player currPlayer;
	private int currPlayerIndex;
	private int numberOfPlayers;
	private int gameRound;
	private Stack<String> actionHistory = new Stack<String>(); // add action at the end and get the latest action 
	private Stack<Player> playerTurnHistory = new Stack<Player>(); // add which user take action at the end and get the which user take latest action   
	private ArtifactFactory artifactfactory = new ArtifactFactory();
	
	private Player[] players = new Player[4];
	private String[] usernames = new String[4];
	private int[] tokens = new int[4];
	
	//Controller as enum
	public enum Controller {
		FORAGE_FOR_INGREDIENT,
		TRANSMUTE_INGREDIENT,
		BUY_THE_RIVER,
		BUY_EOI,
		MAKE_EXPERIMENT,
		SELL_POTION,
		PUBLISH_THEORY,
		CLAIM_CARD,
		DEBUNK_THEORY,
		BUY_WISDOM_IDOL,
		BUY_PRINTING_PRESS,
		BUY_MAGIC_MORTAR,
		USE_ARTIFACT
	};
	
	//Singleton implementation
	private static Game gameSingleton = new Game();
	
	private Game() {
		this.gameRound = 1;
	}
	
	public static Game getGame() {
		return gameSingleton;
	}
	
	
	
	/**
	 * Initializes players for OFFLINE mode using numberOfPlayers.
	 * Gives players 2 ingredient cards from ingredients deck.
	 * Gives players 10 gold.
	 * @param players
	 * @param numberOfPlayers
	 */
	public void initializePlayers(Player[] players) {
		String username;
		int chosenAvatarIndex;
		int j = 0;
		for (int i = 0; i < getNumberOfPlayers(); i++) {
			username = getUsernames()[i];
			chosenAvatarIndex = getTokens()[i];
			players[i] = new Player(username,chosenAvatarIndex);
			
			players[i].setProfilePhoto("src/images/avatar-icons/avatar"+(chosenAvatarIndex+1)+".png");
			
			players[i].getIngredientCards().add(IngredientStorage.getInstance().getIngredientCards().get(j++));
			players[i].getIngredientCards().add(IngredientStorage.getInstance().getIngredientCards().get(j++));
			
			players[i].setGoldBalance(10);
			
		}
		currPlayerIndex = 0;
		currPlayer = players[currPlayerIndex];	
	}
	
	public void endTurn() {
		
		currPlayerIndex++;
		if (currPlayerIndex == this.numberOfPlayers) {
			nextRound();
			currPlayerIndex = 0;
			currPlayer = players[currPlayerIndex];
			
		}
		else {
			currPlayer = players[currPlayerIndex];	
		}
		System.out.println("number of players "+numberOfPlayers);
		System.out.println("curr player index is "+currPlayerIndex);
		System.out.println("curr player is "+currPlayer);
	}
	
	public void updateHistory(String history, Player p) {
		Game.getGame().getActionHistory().add(history);
		Game.getGame().getPlayerTurnHistory().add(p);
		if(p.getHistory() == null) {
			p.setHistory("---------- New Action ----------\n" + history);
		} else {
			p.setHistory(p.getHistory() + "\n\n---------- New Action ----------\n" + history);
		}
		
	}

	
	/**
	 * Increases round number
	 * Makes all players turn number 3
	 * If game round is greater than 3 then ends game.
	 */
	public void nextRound() {
		this.gameRound++;
		for (int i = 0; i < players.length; i++) {
			if (players[i] != null)
				players[i].setTurnNumber(3);
		}
		System.out.println("next round: "+ gameRound) ;
	}
	
	public Player getWinner(Player[] players) {
		Player winner = getCurrPlayer();
		HashMap scoreList = new HashMap();
		
		for (int i = 0; i < players.length; i++) {
			if (players[i] != null) {
				players[i].getScorePoints();
				
				scoreList.put(players[i], players[i].getScorePoints()); // for displaying listed score at the end
				
				if (players[i].getScorePoints() > winner.getScorePoints()) {
				//get max player points
				winner = players[i]; //for now
				}
			}
		}
		
		return winner;
	}
	
	

	/**
	 * Initializes board
	 */
	public void initializeBoard() {
		
		Random rand = new Random();
		PublicationTrack pt = PublicationTrack.getInstance();
		Alchemical a1 = new Alchemical(new AlchemyMarker("+","red","S","src/images/alchemyMarker-icons/red+.png"), new AlchemyMarker("-","green","L","src/images/alchemyMarker-icons/green-.png"), new AlchemyMarker("-","blue","S","src/images/alchemyMarker-icons/blue-.png"));
		Alchemical a2 = new Alchemical(new AlchemyMarker("-","red","S","src/images/alchemyMarker-icons/red-.png"), new AlchemyMarker("+","green","L","src/images/alchemyMarker-icons/green+.png"), new AlchemyMarker("+","blue","S","src/images/alchemyMarker-icons/blue+.png"));
		Alchemical a3 = new Alchemical(new AlchemyMarker("-","red","L","src/images/alchemyMarker-icons/red-.png"), new AlchemyMarker("-","green","S","src/images/alchemyMarker-icons/green-.png"), new AlchemyMarker("+","blue","S","src/images/alchemyMarker-icons/blue+.png"));
		Alchemical a4 = new Alchemical(new AlchemyMarker("+","red","S","src/images/alchemyMarker-icons/red+.png"), new AlchemyMarker("-","green","S","src/images/alchemyMarker-icons/green-.png"), new AlchemyMarker("+","blue","L","src/images/alchemyMarker-icons/blue+.png"));
		Alchemical a5 = new Alchemical(new AlchemyMarker("-","red","S","src/images/alchemyMarker-icons/red-.png"), new AlchemyMarker("+","green","S","src/images/alchemyMarker-icons/green+.png"), new AlchemyMarker("-","blue","L","src/images/alchemyMarker-icons/blue-.png"));
		Alchemical a6 = new Alchemical(new AlchemyMarker("+","red","L","src/images/alchemyMarker-icons/red+.png"), new AlchemyMarker("+","green","S","src/images/alchemyMarker-icons/green+.png"), new AlchemyMarker("-","blue","S","src/images/alchemyMarker-icons/blue-.png"));
		Alchemical a7 = new Alchemical(new AlchemyMarker("-","red","L","src/images/alchemyMarker-icons/red-.png"), new AlchemyMarker("-","green","L","src/images/alchemyMarker-icons/green-.png"), new AlchemyMarker("-","blue","L","src/images/alchemyMarker-icons/blue-.png"));
		Alchemical a8 = new Alchemical(new AlchemyMarker("+","red","L","src/images/alchemyMarker-icons/red+.png"), new AlchemyMarker("+","green","L","src/images/alchemyMarker-icons/green+.png"), new AlchemyMarker("+","blue","L","src/images/alchemyMarker-icons/blue+.png"));
		
		pt.getAvailableAlchemicals().add(a1);
		pt.getAvailableAlchemicals().add(a2);
		pt.getAvailableAlchemicals().add(a3);
		pt.getAvailableAlchemicals().add(a4);
		pt.getAvailableAlchemicals().add(a5);
		pt.getAvailableAlchemicals().add(a6);
		pt.getAvailableAlchemicals().add(a7);
		pt.getAvailableAlchemicals().add(a8);
		
		
		
		for (int i=0; i<8;i++) {
			pt.getAvailableIngredients().add(IngredientStorage.getInstance().getAllingredientcardsarray()[i]);
		}
		
		for (int j=0; j<5; j++) {
			ArrayList<Ingredient> requiredIngredients = new ArrayList<>();
			while (requiredIngredients.size() < 3) {
				Ingredient randIngredient = IngredientStorage.getInstance().getAllingredientcardsarray()[rand.nextInt(8)];
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
			if(currPlayer.getTurnNumber() > 0) {
				IngredientController.getInstance().addIngredientToPlayer(currPlayer);
				currPlayer.updatePlayerTurn();
			}
			break;
		case TRANSMUTE_INGREDIENT:
			if(currPlayer.getTurnNumber() > 0) {
				IngredientController.getInstance().transmuteIngredient(currPlayer);
				currPlayer.updatePlayerTurn();
			}
			break;
		case BUY_THE_RIVER:
			ArtifactController.getArtifactController().buyArtifact(new TheRiver() , currPlayer);
			break;
		case BUY_EOI:
			ArtifactController.getArtifactController().buyArtifact(new ElixirOfInsight() , currPlayer);
			break;
		case MAKE_EXPERIMENT:
			PotionController.getInstance().setCurrPlayer(currPlayer);
			//PlayerIngredientList.initialize(currPlayer);
			
		case SELL_POTION:
			PotionController.getInstance().initializePotionSale(currPlayer);	
		case PUBLISH_THEORY:
			TheoryController.getInstance().setCurrPlayer(currPlayer);
		case CLAIM_CARD:
			TheoryController.getInstance().setCurrPlayer(currPlayer);
		case DEBUNK_THEORY:
			TheoryController.getInstance().setCurrPlayer(currPlayer);
			break;
		case BUY_WISDOM_IDOL:
			ArtifactController.getArtifactController().buyArtifact(artifactfactory.getArtifact("wisdomidol") , currPlayer);
			break;
		case BUY_PRINTING_PRESS:
			ArtifactController.getArtifactController().buyArtifact(artifactfactory.getArtifact("printingpress") , currPlayer);
			break;
		case BUY_MAGIC_MORTAR:
			ArtifactController.getArtifactController().buyArtifact(artifactfactory.getArtifact("magicmortar") , currPlayer);
			break;
		case USE_ARTIFACT:
			ArtifactController.getArtifactController().useArtifact(currPlayer.getCurrArtifact() , currPlayer);
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

	public Player[] getPlayers() {
		return players;
	}
	public void setPlayers(Player[] players) {
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

	public Stack<String> getActionHistory() {
		return actionHistory;
	}
	public void setActionHistory(Stack<String> actionHistory) {
		this.actionHistory = actionHistory;
	}

	public Stack<Player> getPlayerTurnHistory() {
		return playerTurnHistory;
	}
	public void setPlayerTurnHistory(Stack<Player> playerTurnHistory) {
		this.playerTurnHistory = playerTurnHistory;
	}
	public String[] getUsernames() {
		return usernames;
	}
	public void setUsernames(String[] usernames) {
		this.usernames = usernames;
	}
	public int[] getTokens() {
		return tokens;
	}
	public void setTokens(int[] tokens) {
		this.tokens = tokens;
	}
	
	
	
	
}
