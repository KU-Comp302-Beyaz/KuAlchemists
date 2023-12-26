package domain.potion;

import java.util.HashMap;
import java.util.Map;

import domain.Player;
import domain.ingredients.Ingredient;
import domain.ingredients.IngredientController;
import domain.theorydeduction.AlchemyMarker;
import ui.PotionBrewingAreaDisplay;
import ui.PotionBrewingAreaDisplayHelp;
import ui.IngredientStorageDisplay;
import ui.PlayerIngredientList;

public class PotionController {
	
	
	
	private static Player player;
	private static Potion potion;
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
	static PotionBrewingAreaDisplay pbad = new PotionBrewingAreaDisplay(); 
	static PotionBrewingArea pba = new PotionBrewingArea();
	
	public PotionController(Player player, Potion potion){
		this.player = player;
		this.potion = potion;
	}
	

	public void initializePotionSale() {
		System.out.println("Potion sale initialized");
		// PotionBrewingAreaDisplay pbad = new PotionBrewingAreaDisplay();
		// PotionBrewingArea pba = new PotionBrewingArea();
		
//		Map<String, Integer> rewardTable= new HashMap<String, Integer>();
//		rewardTable.put("positive", 3);
//		rewardTable.put("positive_neutral", 2);
//		rewardTable.put("no_guarantee", 1);

/*
		pbad.display();
		boolean choice = pbad.displayChoiceBox();
		
		if (choice) {
			
		   	String guaranteedPotionNature = pbad.displayGuaranteeBox();
			
			Ingredient[] recipe = pbad.displayExperimentSetup();
			//Potion p = pba.makePotion(recipe[0], recipe[1]);
			potion = pba.makePotion(recipe[0], recipe[1]);
			
			//Daha sonra düzelt
			if (potion.getAlchemyMarker().getSign().equals(guaranteedPotionNature)) {
				player.updateGoldBalance(1);
				
			}
			
			return 1; //successfully done
		}
		
		else return -1;
			
		
		//player.updateGoldBalance(amount);
		//player.updatePlayerTurn();
	*/
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
		initializeTestPotion(potion,p);
		
		
		p.updatePlayerTurn();
	}


	public void initializeTestPotion(Potion potion, Player player) {

		// pbad.display(); // ???
		String testMethod = PotionBrewingAreaDisplay.getPotionBrewingAreaDisplay().getTestMethod(); // Player Choose TestMethod (Test on Student / Test on Player)
		
		AlchemyMarker alchemyMarker = pba.testPotion(testMethod, potion, player);
		
		
	}

	//}
}
