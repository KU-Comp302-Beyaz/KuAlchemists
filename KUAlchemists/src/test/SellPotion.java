package test;
import java.util.Random;

import javax.swing.ImageIcon;

import domain.Game;
import domain.Player;
import domain.ingredients.Alchemical;
import domain.ingredients.Ingredient;
import domain.ingredients.IngredientStorage;
import domain.potion.Potion;
import domain.potion.PotionBrewingArea;
import domain.potion.PotionController;
import domain.theorydeduction.AlchemyMarker;
import ui.PotionBrewingAreaDisplay;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;



public class SellPotion {

	public static void main(String[] args) {

		PotionBrewingArea pba = new PotionBrewingArea();
		PotionController controller = PotionController.getInstance();
		
		Ingredient[] ing = IngredientStorage.getAllingredientcardsarray();
		
		
		//Test 1
		/*Ingredient ing1 = ing[0];
		Ingredient ing2 = ing[1];
		Potion potion = pba.makePotion(ing1, ing2);
		String sign = potion.getPotionSign();*/
		controller.initializePotionSale();
		Player player = Game.getCurrPlayer(); //current player
		
		Potion potion = controller.getPreparedPotionForSale();
	    int guaranteeLevel = controller.getGuaranteeLevel();
		int goldAmount = controller.getEarnedGoldAmount();
		
		String potionSign = potion.getPotionSign();
		
		assertNotNull(player.getIngredientCards(), "Player has no ingredients!");
		assertNotNull(potion, "Potion is null!");		
		assertNotNull(potionSign, "Potion sign is null!");
		

		switch (potionSign) {
			
		case ("+"):
			switch (guaranteeLevel) {
			
			case 1:
				assertEquals("Adventurer should pay 1 golds!", 1, goldAmount);
				break;
				
			case 2:
				assertEquals("Adventurer should pay 2 golds!", 2, goldAmount);
				break;
				
			case 3:
				assertEquals("Adventurer should pay 3 golds!", 3, goldAmount);
				break;	
			}
			
		case ("0"):
			switch (guaranteeLevel) {
			
			case 1:
				assertEquals("Adventurer should pay 1 golds!", 1, goldAmount);
				break;
				
			case 2:
				assertEquals("Adventurer should pay 2 golds!", 2, goldAmount);
				break;
				
			case 3:
				assertEquals("Adventurer should pay 0 golds!", 0, goldAmount);
				break;	
			}
			break;
					
		case ("-"):
			switch (guaranteeLevel) {
			
			case 1:
				assertEquals("Adventurer should pay 1 golds!", 1, goldAmount);
				break;
				
			case 2:
				assertEquals("Adventurer should pay 0 golds!", 0, goldAmount);
				break;
				
			case 3:
				assertEquals("Adventurer should pay 0 golds!", 0, goldAmount);
				break;	
			}
			break;		
		}
	}	
}