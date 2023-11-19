package potion;

import java.util.HashMap;
import java.util.Map;

import domain.Player;
import ingredients.Ingredient;
import ui.PotionBrewingAreaDisplay;

public class PotionController {
	
	private Player player;
	private Potion potion;
	
	public PotionController(Player player, Potion potion){
		this.player = player;
		this.potion = potion;
	}
	
		
	public int initializePotionSale() {
		
		PotionBrewingAreaDisplay pbad = new PotionBrewingAreaDisplay();
		PotionBrewingArea pba = new PotionBrewingArea();
		
		Map<String, Integer> rewardTable= new HashMap<String, Integer>();
		rewardTable.put("positive", 3);
		rewardTable.put("positive_neutral", 2);
		rewardTable.put("no_guarantee", 1);


		pbad.display();
		boolean choice = pbad.displayChoiceBox();
		
		if (choice) {
			
		   	String guaranteedPotionNature = pbad.displayGuaranteeBox();
			
			Ingredient[] recipe = pbad.displayExperimentSteup();
			Potion p = pba.makePotion(recipe[0], recipe[1]);
			
			
			//Daha sonra düzelt
			if (p.sign.equals(guaranteedPotionNature)) {
				player.updateGoldBalance(1);
				
			}
			
			return 1; //successfully done
		}
		
		else return -1;
			
		
		//player.updateGoldBalance(amount);
		//player.updatePlayerTurn();
	}
}
