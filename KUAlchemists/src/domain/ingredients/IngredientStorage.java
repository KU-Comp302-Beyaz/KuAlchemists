package domain.ingredients;

import java.util.Collections;
import java.util.Stack;

public class IngredientStorage {
	
	//fields
	//add ingredientCards here
	Stack<Ingredient> ingredientCards = new Stack<Ingredient>();
	
	//Singleton implementation
	private static IngredientStorage ingredientStorageSingleton = new IngredientStorage();
	
	private IngredientStorage() {
		initializeIngredients();
	}
	
	public static IngredientStorage getIngredientStorage() {
		return ingredientStorageSingleton;
	}
	
	//shuffles and returns ingredientCards
	public Stack<Ingredient> initializeIngredients() {
		Collections.shuffle(ingredientCards);
		return ingredientCards;
	}

	//getter and setters
	public Stack<Ingredient> getIngredientCards() {
		return ingredientCards;
	}

	public void setIngredientCards(Stack<Ingredient> ingredientCards) {
		this.ingredientCards = ingredientCards;
	}
	
	

}
