package domain.potion;

import domain.Player;
import domain.ingredients.Ingredient;
import domain.theorydeduction.AlchemyMarker;

public class PotionBrewingArea {

	public Potion makePotion(Ingredient ing_1, Ingredient ing_2) {
		
		Potion p = new Potion(ing_1, ing_2);
		
		return p;
	}
	
	public AlchemyMarker testPotion(String testMethod, Potion p, Player player) {
		
		AlchemyMarker alchemyMarker = null;
		if(testMethod.equals("Student")) {
			Student student = new Student();
			alchemyMarker = student.testOnStudent(p);
		} else if (testMethod.equals("Player")) {
			alchemyMarker = player.testOnPlayer(p);
		} else {
			// error;
		}
		
		return alchemyMarker;
	}
	
	
	
}
