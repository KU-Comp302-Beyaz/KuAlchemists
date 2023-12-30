package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.Player;
import domain.ingredients.Ingredient;
import domain.ingredients.IngredientController;
import domain.ingredients.IngredientStorage;

class TestAddIngredientToPlayer {
	
	IngredientController ingredientController;
	IngredientStorage ingredientStorage;
	Player player;
	double randomNum;

	@BeforeEach
	void setUp() throws Exception {
		ingredientController = IngredientController.getInstance();
		ingredientStorage = IngredientStorage.getInstance();
		player = new Player(null,0);
		randomNum = Math.random();
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	@DisplayName("test1: Null player in function argument should throw NullPointerException")
	void testNullPlayer() {
		player = null;
		assertThrows(NullPointerException.class, () -> ingredientController.addIngredientToPlayer(player, randomNum));
	}
	
	@Test
	@DisplayName("test2: Null player.ingredientCards should throw NullPointerException")
	void testNullPlayerIngredientCards() {
		player.setIngredientCards(null);
		ingredientStorage.initializeIngredients();
		assertThrows(NullPointerException.class, () -> ingredientController.addIngredientToPlayer(player, randomNum));
	}
	
	@Test
	@DisplayName("test3: Null ingredientStorage.ingredientCards should throw NullPointerException")
	void testNullIngredientStorageIngredientCards() {
		ingredientStorage.setIngredientCards(null);
		assertThrows(NullPointerException.class, () -> ingredientController.addIngredientToPlayer(player, randomNum));
	}
	
	@Test
	@DisplayName("test4: IngredientStorage ingredientCards.size() == 0")
	void testIngredientStorageIngredientCardsSizeZero() {
		ingredientStorage.initializeIngredients();
		ArrayList<Ingredient> ingredientCards = ingredientStorage.getIngredientCards();
		
		for (int i = ingredientCards.size()-1; i > -1 ; i--) {
			ingredientCards.remove(i);
		}

		assertThrows(IndexOutOfBoundsException.class, () -> ingredientController.addIngredientToPlayer(player, randomNum));
	}
	
	@Test
	@DisplayName("test5: IngredientStorage.ingredientCards.get(0)")
	void testIngredientrandomNumberMax() {
		randomNum = 0;
		ingredientStorage.initializeIngredients();
		Ingredient newIngredient = ingredientStorage.getIngredientCards().get(0);
		assertEquals(newIngredient, ingredientController.addIngredientToPlayer(player, randomNum));
	}
	
	@Test
	@DisplayName("test6: IngredientStorage.ingredientCards.get(ingredientCards.size()-1)")
	void testIngredientrandomNumberMin() {
		randomNum = 0.99999;
		ingredientStorage.initializeIngredients();
		Ingredient newIngredient = ingredientStorage.getIngredientCards().get(ingredientStorage.getIngredientCards().size()-1);
		assertEquals(newIngredient, ingredientController.addIngredientToPlayer(player, randomNum));
	}
	
}
