package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayDeque;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import domain.Game;
import domain.Player;
import domain.ingredients.IngredientStorage;
import domain.publication.PublicationTrack;

class GameTest {
	
	/**
	 * GameTest Class Overview:
	 * 
	 * The GameTest class is responsible for testing the functionality of the Game class,
	 * which represents the core logic of the game. This class uese JUnit for testing.
	 * The tests cover various aspects of the Game class methods to ensure proper behavior
	 * and functionality during different game scenarios.
	 * 
	 * The Game class includes methods related to player initialization, turn progression,
	 * round management, game ending, board initialization, and controller selection. The tests
	 * aim to verify the correctness and robustness of these methods.
	 * 
	 * The test suite employs both Black-Box and GlassBox testing techniques to ensure a
	 * comprehensive evaluation of the Game class. Each test case is designed to cover different
	 * scenarios, including edge cases, normal gameplay, and potential error conditions.
	 * 
	 * Tests:
	 * - Test Case 1: Verify player initialization and card allocation.
	 * - Test Case 2: Test the progression of turns and the proper rotation of players.
	 * - Test Case 3: Check the end of the game when the specified number of rounds is reached.
	 * - Test Case 4: Test the proper initialization of the game board and available alchemicals.
	 * - Test Case 5: Validate the selection of controllers and their corresponding functions.
	 * 
	 * The test plan will include additional test cases covering various functionalities of
	 * the Game class, ensuring thorough testing and reliability of the game's core logic.
	 * 
	 */
	
	
	static Game game;
	private static ArrayDeque<Player> players;
	private static int numberOfPlayers;

	@BeforeEach
	public void setup() {
		game = Game.getGame();
		game.setNumberOfPlayers(3);
		numberOfPlayers = 3;
		game.setPlayers(new ArrayDeque<Player> ());
		game.initializePlayers(numberOfPlayers);
		players = game.getPlayers();
		game.setGameRound(1);
	}
	
    @AfterEach
    public void tearDown() {
    	//Test repOk() after each test function
        assertTrue(game.repOk());
    }

	@Test
	@DisplayName("Testing for player numbers")
	public void testPlayerNumbers() {
	
		assertEquals(numberOfPlayers + 1, players.size()); 
		//1 added because of the control player
	}
	
	@Test
	@DisplayName("Testing endTurn() method")
	public void testEndTurn() {

		for (int i = 0; i < numberOfPlayers + 1; i++) {
		
			Player p = players.poll();
			if (i == numberOfPlayers) {
				p.setUsername("End Round Control");				
			}
			
			p.setUsername(String.valueOf(i + 1));
			players.offer(p);
		}
		
		game.setPlayers(players);
				
		Player initPlayer = game.getCurrPlayer();
		game.endTurn();		
		Player currentPlayer = game.getCurrPlayer(); 

		assertNotEquals(initPlayer, currentPlayer);	
	}
	
	@Test
	@DisplayName("Testing nextRound() method")
	public void testNextRound() {
		
		int initRound = game.getGameRound();
		game.nextRound();
		int currentRound = game.getGameRound();
		initRound += 1;
		assertEquals(initRound, currentRound);
	}
	
	@Test
	@DisplayName("Testing endGame() function - No player has any points")
	public void testEndGame_winnerNoPoints() {
		// creating players to test end game
		Player player1 = new Player("1",1);
		Player player2 = new Player("2",2);
		Player player3 = new Player("3",3);
		Player player4 = new Player("4",4);
		Player player5 = new Player("End Round Control",0);
		ArrayDeque<Player> players = new ArrayDeque<Player>();
		players.addLast(player1);
		players.addLast(player2);
		players.addLast(player3);
		players.addLast(player4);
		players.addLast(player5);
		
		// if no players have any points the first player should automatically win
		assertEquals("1", Game.getGame().endGame(players));
		}
		
	@Test
	@DisplayName("Testing endGame() function - one person is a winner")
		//tests the endGame function where one person has distinctly superior point total
	public void testEndGame_winnerIs2() {
		// creating players to test end game
		Player player1 = new Player("1",1);
		Player player2 = new Player("2",2);
		Player player3 = new Player("3",3);
		Player player4 = new Player("4",4);
		Player player5 = new Player("End Round Control",0);
		ArrayDeque<Player> players = new ArrayDeque<Player>();
		players.addLast(player1);
		players.addLast(player2);
		players.addLast(player3);
		players.addLast(player4);
		players.addLast(player5);
		
		player1.setScorePoints(10);
		player2.setScorePoints(25);
		player3.setScorePoints(100);
		player4.setScorePoints(0);
		player5.setScorePoints(Integer.MIN_VALUE);
		// if no players have any points the first player should automatically win
		assertEquals("3", Game.getGame().endGame(players));
	}
	
	
	@Test
	@DisplayName("Testing endGame() function - control player is the current player")
	public void testEndGame_winnerIsNotLast() {
		// creating players to test end game
		Player player1 = new Player("1",1);
		Player player2 = new Player("2",2);
		Player player3 = new Player("3",3);
		Player player4 = new Player("4",4);
		Player player5 = new Player("End Round Control",0);
		ArrayDeque<Player> players = new ArrayDeque<Player>();
		//players are added in the reverse order
		players.addLast(player5);
		players.addLast(player4);
		players.addLast(player3);
		players.addLast(player2);
		players.addLast(player1);
		
		player1.setScorePoints(0);
		player2.setScorePoints(0);
		player3.setScorePoints(0);
		player4.setScorePoints(0);
		player5.setScorePoints(Integer.MIN_VALUE);
		// all players have 0 points but the control player should not win
		// player 4 should win as they are the next player from the control player
		assertEquals("4", Game.getGame().endGame(players));
	}
		
	@Test
	@DisplayName("Testing initialiseBoard() function")	
	public void testInitialiseBoard() {
		Player player1 = new Player("1",1);
		Player player2 = new Player("2",2);
		Player player3 = new Player("3",3);
		Player player4 = new Player("4",4);
		ArrayDeque<Player> players = new ArrayDeque<Player>();
		players.addLast(player1);
		players.addLast(player2);
		players.addLast(player3);
		players.addLast(player4);
		
		game.initializeBoard();
		// checks whether the alchemicals are null
		
		Assertions.assertNotEquals(null, PublicationTrack.getInstance().getAvailableAlchemicals());
		
		//checks whether the ingredients are null
		Assertions.assertNotEquals(null, IngredientStorage.getAllingredientcardsarray());		
	}
	

    @Test
    public void testRepOkCorrect() {
    	  game.setNumberOfPlayers(3);
          assertTrue(game.repOk());
    }

	
	
}
