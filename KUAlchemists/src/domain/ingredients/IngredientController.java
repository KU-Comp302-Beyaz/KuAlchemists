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
	 * gets card from card deck, adds it to player cards, returns card image to display in ui
	 * @param player
	 * @return ingredintCardImage
	 */
	public ImageIcon addIngredientToPlayer(Player player) {
		Ingredient newIngredient = IngredientStorage.getIngredientStorage().getIngredientCards().pop();
		player.getIngredientCards().add(newIngredient);
		ImageIcon ingredientCardImage = newIngredient.getIngredientCardImage();
		return ingredientCardImage;
	}
	
	/**
	 * Transmute ingredient
	 * @param player
	 */
	public void transmuteIngredient(Player player) {
		//not implemented yet
		
	}



	
	

}
