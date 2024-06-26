package domain.potion;

import domain.Game;
import domain.Player;
import domain.ingredients.Alchemical;
import domain.ingredients.Ingredient;
import domain.theorydeduction.AlchemyMarker;

public class PotionBrewingArea {

	public Potion makePotion(Ingredient ing_1, Ingredient ing_2) { // mixing two ingredients, get the resultToken (alcheyMarkera)
		
		Alchemical alchemy_1 = ing_1.getAlchemical();
		Alchemical alchemy_2 = ing_2.getAlchemical();
		
		AlchemyMarker red1 = alchemy_1.getAspects().get(0);
		//AlchemyMarker red1 = alchemy_1.getRed();
		//System.out.println("red1 " + red1.getSign() + " " + red1.getSize());
		AlchemyMarker green1 = alchemy_1.getAspects().get(1);
		//AlchemyMarker green1 = alchemy_1.getGreen();
		//System.out.println("green1 " + green1.getSign() + " " + green1.getSize());
		AlchemyMarker blue1 = alchemy_1.getAspects().get(2);
		//AlchemyMarker blue1 = alchemy_1.getBlue();
		//System.out.println("blue1 " + blue1.getSign() + " " + blue1.getSize());
		
		AlchemyMarker red2 = alchemy_2.getAspects().get(0);
		//System.out.println("red2 " + red2.getSign() + " " + red2.getSize());
		AlchemyMarker green2 = alchemy_2.getAspects().get(1);
		//System.out.println("green2 " + green2.getSign() + " " + green2.getSize());
		AlchemyMarker blue2 = alchemy_2.getAspects().get(2);
		//System.out.println("blue2 " + blue2.getSign() + " " + blue2.getSize());
		
		AlchemyMarker resultToken = null;
		
		if((! red1.getSize().equals(red2.getSize())) && (red1.getSign().equals(red2.getSign()))) { // red
			resultToken = new AlchemyMarker(red1.getSign(), "red"); // different size, same sign			
		} 
		else if ((! blue1.getSize().equals(blue2.getSize())) && (blue1.getSign().equals(blue2.getSign()))) { // blue
			resultToken = new AlchemyMarker(blue1.getSign(), "blue"); // different size, same sign
		} 
		else if ((! green1.getSize().equals(green2.getSize())) && (green1.getSign().equals(green2.getSign()))) { // green
			resultToken = new AlchemyMarker(green1.getSign(), "green"); // different size, same sign
		} else {
			resultToken = new AlchemyMarker(); //nötr 
		}
		System.out.println("inside makePotion" + ing_1 + ing_2 + resultToken.getSign()  );
		Potion p = new Potion(ing_1, ing_2, resultToken);	
		
		return p;
	}
	



	
	public AlchemyMarker testPotion(String testMethod, Potion p, Player player) {
	    int gold = player.getGoldBalance();
	    AlchemyMarker alchemyMarker = p.getAlchemyMarker();
	    int sicknessLevel = player.getSicknessLevel();

	    String history = "Make Potion\n";
	    
	    if (testMethod.equals("Student")) {
	        if (gold == 0) {
	        	// cannot test on student
	        } else {
	            player.updateGoldBalanceforPotion(1); // negative potion and test it on a student, you will lose 1 gold
	            /// for action history
	            history += "Test on Student\n"
	            		+ "-1 Gold Balance: " + player.getGoldBalance();
	        }
	    } else if (testMethod.equals("Player")) {
	        if (sicknessLevel == 3) {
	        	// cannot test on Player !
	    
	        } else {
	            player.testOnPlayer(p);
	            sicknessLevel = player.getSicknessLevel(); // updaion of sicknessLevel after testing on Player
	            /// for action history
	            history += "Test on Player\n"
	            		+ "Sickness Level: " + player.getSicknessLevel();
	        }
	    } else {
	    	// error;
	        return null; // invalid test method
	    }

	    ///// For Make Potion Add action and player to history
	    /*
		Game.getGame().getActionHistory().add(history);
		Game.getGame().getPlayerTurnHistory().add(Game.getGame().getCurrPlayer());
	    */
	    
	    Game.getGame().updateHistory(history, player);
	    return alchemyMarker;
	}

}
