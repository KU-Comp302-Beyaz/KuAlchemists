package domain.ingredients;

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
			
		int deckSize = IngredientStorage.getInstance().getIngredientCards().size();
		Ingredient newIngredient = IngredientStorage.getInstance().getIngredientCards().remove(deckSize-1);
		player.getIngredientCards().add(newIngredient);
	}
	
	/**
	 * Transmute ingredient
	 * @param player
	 */
	public void transmuteIngredient(Player player) {
		player.getIngredientCards().remove(getChosenIngredient()); //remove chosen ingredient
		player.updateGoldBalance(1);
	}

	/**
	 * To initialize ingredient storage display, give all cards to it
	 * @return allCardsArray so they can be given to ingredient storage display1
	 */
	public Ingredient[] giveAllCardsToIngredientStorageDisplay() {
		return IngredientStorage.getInstance().getAllIngredientCardsArray();
	}

	public Ingredient getChosenIngredient() {
		return chosenIngredient;
	}

	public void setChosenIngredient(Ingredient chosenIngredient) {
		this.chosenIngredient = chosenIngredient;
	}
	
	

	

}
