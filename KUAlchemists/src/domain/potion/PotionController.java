package domain.potion;

import java.util.HashMap;
import java.util.Map;

import domain.Game;
import domain.Player;
import domain.ingredients.Ingredient;
import domain.ingredients.IngredientController;
import domain.theorydeduction.AlchemyMarker;
import ui.IngredientStorageDisplay;
import ui.PlayerIngredientList;
import ui.PotionBrewingAreaDisplay;
import ui.IngredientStorageDisplay;
import ui.PlayerIngredientList;

public class PotionController {
	
	
	
	//private static Player player;
	private static PotionController potionControllerInstance;
	private Player currPlayer;
	

	private Potion potion;
	private int updatedAmount; //Sell Potion updated amount
	private boolean isSellRequestAccepted;
	private int guaranteeLevel;
	private Ingredient[] chosenIngredients;
	private String testMethod;


	

	private PotionController() {}

	/**
	 * Singleton implementation
	 * @return unique instance
	 */
	public static synchronized PotionController getInstance() {
		if (potionControllerInstance == null)
			potionControllerInstance = new PotionController();
		return potionControllerInstance;
	}
	
	
	static PotionBrewingArea pba = new PotionBrewingArea();

	public void initializePotionSale(Player player) {
		
		if (isSellRequestAccepted) {
			
			Potion p = pba.makePotion(chosenIngredients[0], chosenIngredients[1]); //Making potion
			String sign = p.getPotionSign(); //Sign of the prepared potion
			updatedAmount = 0;
			
			switch (sign) {
				case ("+"):
					if (guaranteeLevel == 3) updatedAmount = 3;
					else if (guaranteeLevel == 2) updatedAmount = 2;
					break;
				case("0"):
					if (guaranteeLevel == 2) updatedAmount = 2;
					break;
				case("-"):
					if (guaranteeLevel == 1) updatedAmount = 1;				
					break;
			}

			
			player.updateGoldBalance(updatedAmount);

			///// Add action and player to history
			/*
			Game.getGame().getActionHistory().add("Sale Potion\n"
					+ "+" + updatedAmount + " Gold Balance: " + player.getGoldBalance());
			Game.getGame().getPlayerTurnHistory().add(player);
			*/
			
			Game.getGame().updateHistory("Potion Sale\n"

					+ "+" + updatedAmount + " Gold Balance: " + player.getGoldBalance(), player);
		}
	}
	
	
	public int getEarnedGoldAmount() {
		return updatedAmount;
	}
		
	
	public void initializeMakeExperiment(Ingredient[] ingredients, Player p) {

		
		// PotionBrewingAreaDisplay pbad = new PotionBrewingAreaDisplay();
		// PotionBrewingArea pba = new PotionBrewingArea();

		//pbad.display();
		
		//Ingredient[] ingredients = pbad.getIngredients(); // Player Choose 2 Ingredients
		if (p.getActivatedArtifacts().contains("magicmortar")) {
			Ingredient ing_1 = ingredients[0];
			//p.getIngredientCards().remove(ing_1); // if the magic mortar is active player keeps the ingredient
			Ingredient ing_2 = ingredients[1];
			p.getIngredientCards().remove(ing_2); //remove chosen ingredient
		
			potion = pba.makePotion(ing_1, ing_2);
			
			//remove artifact from usable artifacts
			p.removeActivatedArtifact("magicmortar");
		}
		else {
		Ingredient ing_1 = ingredients[0];
		p.getIngredientCards().remove(ing_1); //remove chosen ingredient
		Ingredient ing_2 = ingredients[1];
		p.getIngredientCards().remove(ing_2); //remove chosen ingredient
		
		potion = pba.makePotion(ing_1, ing_2);
		}

		Game.getGame().getCurrPlayer().getPotions().add(potion);	// record new potion
		
		if (!isSellRequestAccepted) {
			initializeTestPotion(potion,p);
		}
				
		p.updatePlayerTurn();
		
	}

	public Player getCurrPlayer() {
		return currPlayer;
	}

	public void setCurrPlayer(Player currPlayer) {
		this.currPlayer = currPlayer;
	}

	public void initializeTestPotion(Potion potion, Player player) {

		AlchemyMarker alchemyMarker = pba.testPotion(testMethod, potion, player);
		//// history update is in testPotion since action detail is in there	
	}
	
	public void setSellRequestAccepted(boolean isSellRequestAccepted) {
		this.isSellRequestAccepted = isSellRequestAccepted;
	}

	public  void setGuaranteeLevel(int guaranteeLevel) {
		this.guaranteeLevel = guaranteeLevel;
	}
	
	public void setChosenIngredients(Ingredient[] chosenIngredients) {
		this.chosenIngredients = chosenIngredients;
	}
	
	public void setTestMethod(String testMethod) {
		this.testMethod = testMethod;
	}
}
