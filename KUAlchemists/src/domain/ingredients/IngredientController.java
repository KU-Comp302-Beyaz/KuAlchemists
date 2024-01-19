package domain.ingredients;

import domain.Game;
import domain.Player;

public class IngredientController {
	
	private static IngredientController ingredientControllerInstance;
	private Ingredient chosenIngredient;
	
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
	 * gets last card from cards list, adds it to player cards
	 * @param player
	 * @throws NullPointerException
	 */
	public void addIngredientToPlayer(Player player) throws NullPointerException {
		//REQUIRES: player is not null, player.ingredientCards is not null, ingredientStorageSingleton.ingredientCards is not null
		//MODIFIES: player.ingredientCards, IngredientStorage.ingredientCards
		//EFFECTS: 	removes last Ingredient from IngredientStorage.ingredientCards and adds it to player.ingredientCards
			
		
		Ingredient newIngredient = IngredientStorage.getInstance().getIngredientCards().remove(0);
		player.getIngredientCards().add(newIngredient);

		
		///// Add action and player to history
		/*
		Game.getGame().getActionHistory().add("Add Ingredient\n"
					+ "+1 Ingredient: " + player.getIngredientCards().size());
		Game.getGame().getPlayerTurnHistory().add(Game.getGame().getCurrPlayer());
		*/
		Game.getGame().updateHistory("Add Ingredient\n"
					+ "+1 Ingredient: " + player.getIngredientCards().size(), player);
	}
	
	/**
	 * Transmute ingredient
	 * @param player
	 */
	public void transmuteIngredient(Player player) {
		player.getIngredientCards().remove(getChosenIngredient()); //remove chosen ingredient
		player.updateGoldBalance(1);
		
		///// Add action and player to history
		/*
		Game.getGame().getActionHistory().add("Transmute Ingredient\n"
				+ "+1 Gold Balance: " + player.getGoldBalance());
		Game.getGame().getPlayerTurnHistory().add(Game.getGame().getCurrPlayer());
		*/
		
		Game.getGame().updateHistory("Transmute Ingredient\n"
				+ "+1 Gold Balance: " + player.getGoldBalance(), player);
	}

	/**
	 * To initialize ingredient storage display, give all cards to it
	 * @return allCardsArray so they can be given to ingredient storage display1
	 */
	public Ingredient[] giveAllCardsToIngredientStorageDisplay() {
		return IngredientStorage.getInstance().getAllingredientcardsarray();
	}

	public Ingredient getChosenIngredient() {
		return chosenIngredient;
	}

	public void setChosenIngredient(Ingredient chosenIngredient) {
		this.chosenIngredient = chosenIngredient;
	}
	
	

	

}
