package domain.potion;

import java.util.HashMap;
import java.util.Map;

import domain.AlchemyMarker;
import domain.Player;
import domain.Student;
import domain.ingredients.Ingredient;
import ui.PotionBrewingAreaDisplay;

public class PotionController {
	
	private Player player;
	private Potion potion;
	
	// ?! Her fonksiyon için ayrı açılması yerine ortak bir tane olsun (Yoksa make experimentta iki kez iç içe açılır)
	PotionBrewingAreaDisplay pbad = new PotionBrewingAreaDisplay(); 
	PotionBrewingArea pba = new PotionBrewingArea();
	
	public PotionController(Player player, Potion potion){
		this.player = player;
		this.potion = potion;
	}
	

	public int initializePotionSale() {
		
		// PotionBrewingAreaDisplay pbad = new PotionBrewingAreaDisplay();
		// PotionBrewingArea pba = new PotionBrewingArea();
		
		Map<String, Integer> rewardTable= new HashMap<String, Integer>();
		rewardTable.put("positive", 3);
		rewardTable.put("positive_neutral", 2);
		rewardTable.put("no_guarantee", 1);


		pbad.display();
		boolean choice = pbad.displayChoiceBox();
		
		if (choice) {
			
		   	String guaranteedPotionNature = pbad.displayGuaranteeBox();
			
			Ingredient[] recipe = pbad.displayExperimentSetup();
			//Potion p = pba.makePotion(recipe[0], recipe[1]);
			potion = pba.makePotion(recipe[0], recipe[1]);
			
			//Daha sonra düzelt
			if (potion.sign.equals(guaranteedPotionNature)) {
				player.updateGoldBalance(1);
				
			}
			
			return 1; //successfully done
		}
		
		else return -1;
			
		
		//player.updateGoldBalance(amount);
		//player.updatePlayerTurn();
	}
	
	
	public void initializeMakeExperiment() {
		
		// PotionBrewingAreaDisplay pbad = new PotionBrewingAreaDisplay();
		// PotionBrewingArea pba = new PotionBrewingArea();

		pbad.display();
		Ingredient[] ingredients = pbad.displayExperimentSetup(); // Player Choose 2 Ingredients
		
		Ingredient ing_1 = ingredients[0];
		Ingredient ing_2 = ingredients[1];
		
		potion = pba.makePotion(ing_1, ing_2);
		initializeTestPotion(potion);
		
		//player.updateGoldBalance(amount);
		//player.updatePlayerTurn();
	}


	public void initializeTestPotion(Potion p) {

		pbad.display();
		String testMethod = pbad.displayTestMethodBox(); // Player Choose TestMethod (Test on Student / Test on Player)
		
		AlchemyMarker alchemyMarker = pba.testPotion(testMethod, p, player);
		
	}

}
