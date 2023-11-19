package potion;

import domain.Player;
import ingredients.Ingredient;

public class PotionController {
	
	private Player player;
	private Potion potion;
	
	public PotionController(Player player, Potion potion){
		this.player = player;
		this.potion = potion;
	}
	
	public Potion makePotion(Ingredient ing_1, Ingredient ing_2) {
		
		Potion p = null;
		
		return p;
	}
	
	// public ? testPotion(??) {}
	
	public void sellPotion(Potion p) {
		
		//player.updateGoldBalance(amount);
		//player.updatePlayerTurn();
	}
}
