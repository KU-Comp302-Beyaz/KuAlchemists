package domain.ingredients;

import java.util.Stack;

public class IngredientStorage {
	
	Stack<Ingredient> ingredientCards = new Stack();
	
	public Stack<Ingredient> initializeIngredients() {
		
		//use random to create ingredients in the 
		//beginning of the game and put them in here
		
		return ingredientCards;
	}

	public Stack<Ingredient> getIngredientCards() {
		return ingredientCards;
	}

	public void setIngredientCards(Stack<Ingredient> ingredientCards) {
		this.ingredientCards = ingredientCards;
	}
	
	

}
