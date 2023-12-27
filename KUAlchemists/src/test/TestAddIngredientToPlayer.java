package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
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

	@BeforeEach
	void setUp() throws Exception {
		ingredientController = IngredientController.getInstance(); //should these be new IngredientController() ??
		ingredientStorage = IngredientStorage.getInstance();
		player = new Player(null,0);
	}
	
	@Test
	@DisplayName("test1: Null player in function argument should throw NullPointerException")
	void testNullPlayer() {
		player = null;
		assertThrows(NullPointerException.class, () -> ingredientController.addIngredientToPlayer(player));
	}
	
	@Test
	@DisplayName("test2: Null player.ingredientCards should throw NullPointerException")
	void testNullPlayerIngredientCards() {
		player.setIngredientCards(null);
		assertThrows(NullPointerException.class, () -> ingredientController.addIngredientToPlayer(player));
	}
	
	@Test
	@DisplayName("test3: Null ingredientStorage.ingredientCards should throw NullPointerException")
	void testNullIngredientStorageIngredientCards() {
		ingredientStorage.setIngredientCards(null);
		assertThrows(NullPointerException.class, () -> ingredientController.addIngredientToPlayer(player));
	}
	
	@Test
	@DisplayName("test4: IngredientStorage ingredientCards.size() == 0")
	void testIngredientStorageIngredientCardsSizeZero() {
		ArrayList<Ingredient> ingredientCards = ingredientStorage.getIngredientCards();
		
		for (int i = 0; i < ingredientCards.size(); i++) {
			ingredientCards.remove(i);
		}
		Ingredient newIngredient = ingredientStorage.getIngredientCards().get(0);
		assertEquals(newIngredient, ingredientController.addIngredientToPlayer(player));
	}
	
	@Test
	@DisplayName("test5: IngredientStorage.ingredientCards.get(0)")
	void testIngredientrandomNumberMax() {
		//In order to test this I need to change the addIngredientToPlayer function.
		
		/*
		 * 
		 * ASK DURING MEETING
		 * 
		 * 
		 */
	}
	
	@Test
	@DisplayName("test6: IngredientStorage.ingredientCards.get(ingredientCards.size()-1)")
	void testIngredientrandomNumberMin() {
		//In order to test this I need to change the addIngredientToPlayer function.

		/*
		 * 
		 * ASK DURING MEETING
		 * 
		 * 
		 */
	}
	
}
