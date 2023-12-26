package domain.potion;

import domain.Player;
import domain.ingredients.Alchemical;
import domain.ingredients.Ingredient;
import domain.theorydeduction.AlchemyMarker;

public class PotionBrewingArea {

	public Potion makePotion(Ingredient ing_1, Ingredient ing_2) { // mixing two ingredients, get the resultToken (alcheyMarkera)
		
		Alchemical alchemy_1 = ing_1.getAlchemical();
		Alchemical alchemy_2 = ing_2.getAlchemical();
		
		AlchemyMarker red1 = alchemy_1.getAspects().get(0);
		AlchemyMarker green1 = alchemy_1.getAspects().get(1);
		AlchemyMarker blue1 = alchemy_1.getAspects().get(2);
		
		AlchemyMarker red2 = alchemy_1.getAspects().get(0);
		AlchemyMarker green2 = alchemy_1.getAspects().get(1);
		AlchemyMarker blue2 = alchemy_1.getAspects().get(2);
		
		AlchemyMarker resultToken = null;
		if(red1.getSize().equals(red2.getSize())) { // red has same size
			
			if(green1.getSize().equals(green2.getSize())) { // green has same size
				
				if(blue1.getSize().equals(blue2.getSize())) { // blue has same size
					resultToken = new AlchemyMarker(); // nötr
				} else {
					if (blue1.getSign().equals(blue2.getSign())) {
						resultToken = new AlchemyMarker(blue1.getSign(), "blue"); // different size, same sign
					}
				}
				
			} else {

				if (green1.getSign().equals(green2.getSign())) {
					resultToken = new AlchemyMarker(green1.getSign(), "green"); // different size, same sign
				}
			}
		} else {
			if (red1.getSign().equals(red2.getSign())) {
				resultToken = new AlchemyMarker(red1.getSign(), "red"); // different size, same sign
			}
		}
		
		System.out.println("Ingredient 1: " + ing_1.getName());
		System.out.println("Ingredient 2: " + ing_2.getName());
		System.out.println("resultToken: " + resultToken.getSign());
		Potion p = new Potion(ing_1, ing_2, resultToken);
		
		
		return p;
	}
	
	public AlchemyMarker testPotion(String testMethod, Potion p, Player player) {
		
		int gold = player.getGoldBalance();		
		AlchemyMarker alchemyMarker = p.getAlchemyMarker();
		int sicknessLevel = player.getSicknessLevel();
		if(testMethod.equals("Student")) {
			// Student student = new Student();
			if(gold == 0) {
				// cannot test on student
			} else {
				player.updateGoldBalance(1); // negative potion and test it on a student, you will lose 1 gold
			}
		} else if (testMethod.equals("Player")) {	
			if (sicknessLevel == 3) {
				// cannot test on Player !
			} else {
				player.testOnPlayer(p);
			}
		} else {
			// error;
		}
		return alchemyMarker;
	}
	
	
	
}
