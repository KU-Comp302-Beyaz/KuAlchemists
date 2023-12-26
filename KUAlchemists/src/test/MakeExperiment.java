package test;

import javax.swing.ImageIcon;

import domain.ingredients.Alchemical;
import domain.ingredients.Ingredient;
import domain.ingredients.IngredientStorage;
import domain.potion.PotionBrewingArea;
import domain.theorydeduction.AlchemyMarker;

public class MakeExperiment {
	static PotionBrewingArea pba = new PotionBrewingArea();
	static Ingredient[] ing = IngredientStorage.getAllingredientcardsarray();
	/*
	{(1,new Alchemical (new AlchemyMarker ("+", "red", "S"), new AlchemyMarker ("-", "green", "L"), new AlchemyMarker ("-", "blue", "S"), new ImageIcon())),
	(2,new Alchemical (new AlchemyMarker ("-", "red", "S"), new AlchemyMarker ("+", "green", "L"), new AlchemyMarker ("+", "blue", "S"), new ImageIcon())), 
	(3,new Alchemical (new AlchemyMarker ("-", "red", "L"), new AlchemyMarker ("-", "green", "S"), new AlchemyMarker ("+", "blue", "S"), new ImageIcon())), 
	(4,new Alchemical (new AlchemyMarker ("+", "red", "S"), new AlchemyMarker ("-", "green", "S"), new AlchemyMarker ("+", "blue", "L"), new ImageIcon())),
	(5,new Alchemical (new AlchemyMarker ("-", "red", "S"), new AlchemyMarker ("+", "green", "S"), new AlchemyMarker ("-", "blue", "S"), new ImageIcon())),
	(6,new Alchemical (new AlchemyMarker ("+", "red", "L"), new AlchemyMarker ("+", "green", "S"), new AlchemyMarker ("-", "blue", "S"), new ImageIcon())),
	(7,new Alchemical (new AlchemyMarker ("-", "red", "L"), new AlchemyMarker ("-", "green", "L"), new AlchemyMarker ("-", "blue", "S"), new ImageIcon())),
	(8,new Alchemical (new AlchemyMarker ("+", "red", "L"), new AlchemyMarker ("+", "green", "L"), new AlchemyMarker ("+", "blue", "S"), new ImageIcon())),}
	*/

	private static AlchemyMarker result;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		////////// TEST variables
		System.out.println(ing[0] + " " + ing[0].getName() + ing[0].getAlchemical());
		System.out.println(ing[0].getAlchemical().getAspects());
		System.out.println(ing[0].getAlchemical().getAspects().get(0));
		System.out.println(ing[0].getAlchemical().getAspects().get(0).getColor());
		System.out.println(ing[0].getAlchemical().getAspects().get(0).getSign());
		System.out.println(ing[0].getAlchemical().getAspects().get(0).getSize());
		
		System.out.println();
		
		
		/////////	TEST MAKE POTION	////////////
		
		result = pba.makePotion(ing[0],ing[1]).getAlchemyMarker();
		System.out.println("ingredient 1-2: output:" + result.getColor() + " " + result.getSign() + " expected:  ");
		result = pba.makePotion(ing[0],ing[2]).getAlchemyMarker();
		System.out.println("ingredient 1-3: output:" + result.getColor() + " " + result.getSign() + " expected: ");
		result = pba.makePotion(ing[0],ing[3]).getAlchemyMarker();
		System.out.println("ingredient 1-4: output:" + result.getColor() + " " + result.getSign() + " expected: ");
		result = pba.makePotion(ing[0],ing[4]).getAlchemyMarker();
		System.out.println("ingredient 1-5: output:" + result.getColor() + " " + result.getSign() + " expected: ");
		result = pba.makePotion(ing[0],ing[5]).getAlchemyMarker();
		System.out.println("ingredient 1-6: output:" + result.getColor() + " " + result.getSign() + " expected: ");
		result = pba.makePotion(ing[0],ing[6]).getAlchemyMarker();
		System.out.println("ingredient 1-7: output:" + result.getColor() + " " + result.getSign() + " expected: ");
		result = pba.makePotion(ing[0],ing[7]).getAlchemyMarker();
		System.out.println("ingredient 1-8: output:" + result.getColor() + " " + result.getSign() + " expected: ");
		
		result = pba.makePotion(ing[1],ing[2]).getAlchemyMarker();
		System.out.println("ingredient 2-3: output:" + result.getColor() + " " + result.getSign() + " expected: ");
		result = pba.makePotion(ing[1],ing[3]).getAlchemyMarker();
		System.out.println("ingredient 2-4: output:" + result.getColor() + " " + result.getSign() + " expected: ");
		result = pba.makePotion(ing[1],ing[4]).getAlchemyMarker();
		System.out.println("ingredient 2-5: output:" + result.getColor() + " " + result.getSign() + " expected: ");
		result = pba.makePotion(ing[1],ing[5]).getAlchemyMarker();
		System.out.println("ingredient 2-6: output:" + result.getColor() + " " + result.getSign() + " expected: ");
		result = pba.makePotion(ing[1],ing[6]).getAlchemyMarker();
		System.out.println("ingredient 2-7: output:" + result.getColor() + " " + result.getSign() + " expected: ");
		result = pba.makePotion(ing[1],ing[7]).getAlchemyMarker();
		System.out.println("ingredient 2-8: output:" + result.getColor() + " " + result.getSign() + " expected: ");
		
		result = pba.makePotion(ing[2],ing[3]).getAlchemyMarker();
		System.out.println("ingredient 3-4: output:" + result.getColor() + " " + result.getSign() + " expected: ");
		result = pba.makePotion(ing[2],ing[4]).getAlchemyMarker();
		System.out.println("ingredient 3-5: output:" + result.getColor() + " " + result.getSign() + " expected: ");
		result = pba.makePotion(ing[2],ing[5]).getAlchemyMarker();
		System.out.println("ingredient 3-6: output:" + result.getColor() + " " + result.getSign() + " expected: ");
		result = pba.makePotion(ing[2],ing[6]).getAlchemyMarker();
		System.out.println("ingredient 3-7: output:" + result.getColor() + " " + result.getSign() + " expected: ");
		result = pba.makePotion(ing[2],ing[7]).getAlchemyMarker();
		System.out.println("ingredient 3-8: output:" + result.getColor() + " " + result.getSign() + " expected: ");
		
		result = pba.makePotion(ing[3],ing[4]).getAlchemyMarker();
		System.out.println("ingredient 4-5: output:" + result.getColor() + " " + result.getSign() + " expected: ");
		result = pba.makePotion(ing[3],ing[5]).getAlchemyMarker();
		System.out.println("ingredient 4-6: output:" + result.getColor() + " " + result.getSign() + " expected: ");
		result = pba.makePotion(ing[3],ing[6]).getAlchemyMarker();
		System.out.println("ingredient 4-7: output:" + result.getColor() + " " + result.getSign() + " expected: ");
		result = pba.makePotion(ing[3],ing[7]).getAlchemyMarker();
		System.out.println("ingredient 4-8: output:" + result.getColor() + " " + result.getSign() + " expected: ");
		
		result = pba.makePotion(ing[4],ing[5]).getAlchemyMarker();
		System.out.println("ingredient 5-6: output:" + result.getColor() + " " + result.getSign() + " expected: ");
		result = pba.makePotion(ing[4],ing[6]).getAlchemyMarker();
		System.out.println("ingredient 5-7: output:" + result.getColor() + " " + result.getSign() + " expected: ");
		result = pba.makePotion(ing[4],ing[7]).getAlchemyMarker();
		System.out.println("ingredient 5-8: output:" + result.getColor() + " " + result.getSign() + " expected: ");
		
		result = pba.makePotion(ing[5],ing[6]).getAlchemyMarker();
		System.out.println("ingredient 6-7: output:" + result.getColor() + " " + result.getSign() + " expected: ");
		result = pba.makePotion(ing[5],ing[7]).getAlchemyMarker();
		System.out.println("ingredient 6-8: output:" + result.getColor() + " " + result.getSign() + " expected: ");
		
		result = pba.makePotion(ing[6],ing[7]).getAlchemyMarker();
		System.out.println("ingredient 7-8: output:" + result.getColor() + " " + result.getSign() + " expected: ");
	}

}
