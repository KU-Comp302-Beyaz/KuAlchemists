package domain.potion;

import java.util.HashMap;
import java.util.Map;

import domain.Player;
import domain.ingredients.Ingredient;
import domain.ingredients.IngredientController;
import domain.theorydeduction.AlchemyMarker;
import ui.IngredientStorageDisplay;
import ui.PlayerIngredientList;
import ui.PotionBrewingAreaDisplay;
import ui.PotionBrewingAreaDisplayHelp;
import ui.IngredientStorageDisplay;
import ui.PlayerIngredientList;

public class PotionController {
	
	
	
	private static Player player;
	private static Potion potion;
	private static Potion potionForSale; //for test method
	private static int updatedAmount; //for test method
	private int guaranteeLevel;
	private static PotionController potionControllerInstance;
	
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
	
	
	// ?! Her fonksiyon için ayrı açılması yerine ortak bir tane olsun (Yoksa make experimentta iki kez iç içe açılır)
	static PotionBrewingAreaDisplay pbad = PotionBrewingAreaDisplay.getInstance(); 
	static PotionBrewingArea pba = new PotionBrewingArea();
	
	public PotionController(Player player, Potion potion){
		this.player = player;
		this.potion = potion;
	}
	

	public void initializePotionSale() {
		System.out.println("Potion sale initialized");
		
		//Rewards (Gold Coins) in return of a potion:
		Map<String, Integer> rewardTable= new HashMap<String, Integer>();
		rewardTable.put("positive", 3);
		rewardTable.put("positive_neutral", 2);
		rewardTable.put("no_guarantee", 1);

		boolean requestAccepted = pbad.isRequestAccepted();
		
		if (requestAccepted) {
			
			int guarantee = pbad.getGuaranteeLevel(); //Guarantee
			Ingredient[] ingredients = pbad.getChosenIngredients();
			Potion p = pba.makePotion(ingredients[0], ingredients[1]); //Making potion
			String sign = p.getPotionSign(); //Sign of the prepared potion
			
			//Test variables
			updatedAmount = 0;
			potionForSale = p;
			guaranteeLevel = guarantee;
			
			switch (sign) {
				case ("+"):
					if (guarantee == 3) updatedAmount = 3;
					else if (guarantee == 2) updatedAmount = 2;
					break;

				
				case("0"):
					if (guarantee == 2) updatedAmount = 2;
					
				case("-"):
					if (guarantee == 1) updatedAmount = 1;				
			}
			
			System.out.println("Prepared Potion Sign: " + p.getPotionSign());
			System.out.printf("Guarantee Level: %d \n", guarantee);
			System.out.printf("Updated Amount: %d", updatedAmount);
			
			player.updateGoldBalance(updatedAmount); //returns updated amount
		}
		
	}
	
	
	/* The following methods are used for Sell Potion test
	 * 
	 * 
	 * 
	 */
	public int getEarnedGoldAmount() {
		return updatedAmount;
	}
	
	public Potion getPreparedPotionForSale() {
		return potionForSale;
	}
	
	public int getGuaranteeLevel() {
		return guaranteeLevel;
	}
		
	
	public void initializeMakeExperiment(Ingredient[] ingredients, Player p) {
		
		// PotionBrewingAreaDisplay pbad = new PotionBrewingAreaDisplay();
		// PotionBrewingArea pba = new PotionBrewingArea();

		//pbad.display();
		
		//Ingredient[] ingredients = pbad.getIngredients(); // Player Choose 2 Ingredients
		
		Ingredient ing_1 = ingredients[0];
		p.getIngredientCards().remove(ing_1); //remove chosen ingredient
		Ingredient ing_2 = ingredients[1];
		p.getIngredientCards().remove(ing_2); //remove chosen ingredient
		
		potion = pba.makePotion(ing_1, ing_2);
		boolean isSellRequestAccepted = PotionBrewingAreaDisplay.isSellRequestAccepted();
		
		if (!isSellRequestAccepted) {
			initializeTestPotion(potion,p);
			}
				
		p.updatePlayerTurn();
	}


	public void initializeTestPotion(Potion potion, Player player) {

		// pbad.display(); // ???

		String testMethod = PotionBrewingAreaDisplay.getInstance().getTestMethod(); // Player Choose TestMethod (Test on Student / Test on Player)
		AlchemyMarker alchemyMarker = pba.testPotion(testMethod, potion, player);
		
		
	}

	//}
}
