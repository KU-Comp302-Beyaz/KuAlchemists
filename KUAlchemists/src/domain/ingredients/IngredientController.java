package domain.ingredients;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import domain.Player;

public class IngredientController {
	
	private static IngredientController ingredientControllerInstance;
	
	private IngredientController() {}
	
	/**
	 * Singleton implementation
	 * @return unique instance
	 */
	public static synchronized IngredientController getInstance() {
		if (ingredientControllerInstance == null)
			ingredientControllerInstance = new IngredientController();
		return ingredientControllerInstance;
	}
	
	/**
	 * Adds ingredient to player
	 * gets random from card list, adds it to player cards, returns card image to display in ui
	 * @param player
	 * @return ingredintCardImage
	 */
	public Ingredient addIngredientToPlayer(Player player) {
		int randomNumber = (int)(Math.random() * (IngredientStorage.getInstance().getIngredientCards().size()));
		Ingredient newIngredient = IngredientStorage.getInstance().getIngredientCards().remove(randomNumber);
		player.getIngredientCards().put(newIngredient.getIdentifier(), newIngredient);
		return newIngredient;
	}
	
	/**
	 * Transmute ingredient
	 * @param player
	 * @param chosenIngredientIdentifier
	 */
	public void transmuteIngredient(Player player, int chosenIngredientIdentifier) {
		player.getIngredientCards().remove(chosenIngredientIdentifier); //remove chosen ingredient
		player.updateGoldBalance(10);
	}
	
	public Ingredient[] giveAllCardsToIngredientStorageDisplay() {
		return IngredientStorage.getInstance().getAllIngredientCardsArray();
	}

	

}
