package domain.ingredients;

import javax.swing.ImageIcon;

import domain.Player;

public class IngredientController {
	
	//Singleton implementation
	private static IngredientController ingredientControllerSingleton = new IngredientController();
	
	private IngredientController() {	
	}
	
	public static IngredientController getIngredientController() {
		return ingredientControllerSingleton;
	}
	
	/**
	 * Adds ingredient to player
	 * gets random from card list, adds it to player cards, returns card image to display in ui
	 * @param player
	 * @return ingredintCardImage
	 */
	public Ingredient addIngredientToPlayer(Player player) {
		int randomNumber = (int)(Math.random() * (IngredientStorage.getIngredientStorage().getIngredientCards().size()));
		Ingredient newIngredient = IngredientStorage.getIngredientStorage().getIngredientCards().remove(randomNumber);
		player.getIngredientCards().put(newIngredient.getIdentifier(), newIngredient);
		return newIngredient;
	}
	
	/**
	 * Transmute ingredient
	 * @param player
	 * @return 
	 */
	public void transmuteIngredient(Player player, int chosenIngredientIdentifier) {
		player.getIngredientCards().remove(chosenIngredientIdentifier); //remove chosen ingredient
		player.updateGoldBalance(10);
	}

	

}
