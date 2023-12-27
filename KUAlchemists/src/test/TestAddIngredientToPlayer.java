package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.Player;
import domain.ingredients.IngredientController;
import domain.ingredients.IngredientStorage;

class TestAddIngredientToPlayer {
	
	IngredientController ingredientController;
	IngredientStorage ingredientStorage;
	Player player;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		ingredientController = IngredientController.getInstance(); //should these be new IngredientController() ??
		ingredientStorage = IngredientStorage.getInstance();
		player = new Player(null,0);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddIngredientToPlayer() {
		fail("Not yet implemented"); // TODO
	}
	
	@Test
	@DisplayName("Null player in function argument should throw NullPointerException")
	void testNullPlayer() {
		assertThrows(NullPointerException.class, () -> ingredientController.addIngredientToPlayer(null));
	}
	
	@Test
	@DisplayName("Null player.ingredientCards should throw NullPointerException")
	void testNullPlayerIngredientCards() {
		player.setIngredientCards(null);
		assertThrows(NullPointerException.class, () -> ingredientController.addIngredientToPlayer(player));
	}
	
	@Test
	@DisplayName("Null ingredientStorage.ingredientStorageSingleton should throw NullPointerException")
	void testNullIngredientStorage() {
		ingredientStorage = null;
		assertThrows(NullPointerException.class, () -> ingredientController.addIngredientToPlayer(player));
	}
	
	@Test
	@DisplayName("Null ingredientStorage.ingredientCards should throw NullPointerException")
	void testNullIngredientStorageIngredientCards() {
		ingredientStorage.setIngredientCards(null);;
		assertThrows(NullPointerException.class, () -> ingredientController.addIngredientToPlayer(player));
	}

}
