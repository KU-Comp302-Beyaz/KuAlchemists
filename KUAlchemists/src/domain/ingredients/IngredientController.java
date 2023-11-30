package domain.ingredients;

import domain.Player;

public class IngredientController {
	
	private static IngredientController ingredientControllerSingleton = new IngredientController();
	
	private IngredientController() {
		
	}
	
	public static IngredientController getIngredientController() {
		return ingredientControllerSingleton;
	}
	
	//NEED TO ADD THE PLAYER TO THE METHODS OR ELSE HOW WILL WE KNOW???
	public Ingredient addIngredientToPlayer() {
		Ingredient ingredientCard = null;
		//not implemented yet
		return ingredientCard;
	}
	
	//NEED TO ADD THE PLAYER TO THE METHODS OR ELSE HOW WILL WE KNOW???
	public void transmuteIngredient() {
		//not implemented yet
		
	}



	
	

}
