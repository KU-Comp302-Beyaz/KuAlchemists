package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import domain.ingredients.Alchemical;
import domain.ingredients.Ingredient;
import domain.ingredients.IngredientStorage;
import domain.potion.PotionBrewingArea;
import domain.theorydeduction.AlchemyMarker;

class MakePotionTest {

	
	static PotionBrewingArea pba = new PotionBrewingArea();
	static Ingredient[] ing = IngredientStorage.getAllingredientcardsarray();
	
	/*
	 * new Ingredient(1,"Lamia Heart-Blood","src/images/images-icons/ingredient1.jpg", new Alchemical (new AlchemyMarker ("+", "red", "S"), new AlchemyMarker ("-", "green", "L"), new AlchemyMarker ("-", "blue", "S"),"")),
		new Ingredient(2,"Witch's Tear", "src/images/images-icons/ingredient2.jpg",  new Alchemical (new AlchemyMarker ("-", "red", "S"), new AlchemyMarker ("+", "green", "L"), new AlchemyMarker ("+", "blue", "S"),"")), 
		new Ingredient(3,"Hippocamp's Soul", "src/images/images-icons/ingredient3.jpg", new Alchemical (new AlchemyMarker ("-", "red", "L"), new AlchemyMarker ("-", "green", "S"), new AlchemyMarker ("+", "blue", "S"),"")), 
		new Ingredient(4,"Cockatrice Saliva", "src/images/images-icons/ingredient4.jpg", new Alchemical (new AlchemyMarker ("+", "red", "S"), new AlchemyMarker ("-", "green", "S"), new AlchemyMarker ("+", "blue", "L"),"")),
		new Ingredient(5,"Goldhorn's Tooth", "src/images/images-icons/ingredient5.jpg",  new Alchemical (new AlchemyMarker ("-", "red", "S"), new AlchemyMarker ("+", "green", "S"), new AlchemyMarker ("-", "blue", "L"),"")),
		new Ingredient(6,"Ghost Barbs", "src/images/images-icons/ingredient6.jpg",  new Alchemical (new AlchemyMarker ("+", "red", "L"), new AlchemyMarker ("+", "green", "S"), new AlchemyMarker ("-", "blue", "S"),"")),
		new Ingredient(7,"Bugbear Bone Meal", "src/images/images-icons/ingredient7.jpg",  new Alchemical (new AlchemyMarker ("-", "red", "L"), new AlchemyMarker ("-", "green", "L"), new AlchemyMarker ("-", "blue", "L"),"")),
		new Ingredient(8,"Strix's Bone", "src/images/images-icons/ingredient8.jpg",  new Alchemical (new AlchemyMarker ("+", "red", "L"), new AlchemyMarker ("+", "green", "L"), new AlchemyMarker ("+", "blue", "L"),"")),

	 */
	
	AlchemyMarker result1_2 = pba.makePotion(ing[0],ing[1]).getAlchemyMarker(); // null 
	AlchemyMarker result1_3 = pba.makePotion(ing[0],ing[2]).getAlchemyMarker(); // green -
	AlchemyMarker result1_4 = pba.makePotion(ing[0],ing[3]).getAlchemyMarker(); // green -
	AlchemyMarker result1_5 = pba.makePotion(ing[0],ing[4]).getAlchemyMarker();	// blue -
	AlchemyMarker result1_6 = pba.makePotion(ing[0],ing[5]).getAlchemyMarker();	// red +
	AlchemyMarker result1_7 = pba.makePotion(ing[0],ing[6]).getAlchemyMarker();	// blue -
	AlchemyMarker result1_8 = pba.makePotion(ing[0],ing[7]).getAlchemyMarker();	// red +
	
	AlchemyMarker result2_3 = pba.makePotion(ing[1],ing[2]).getAlchemyMarker();	// red -
	AlchemyMarker result2_4 = pba.makePotion(ing[1],ing[3]).getAlchemyMarker();	// blue +
	AlchemyMarker result2_5 = pba.makePotion(ing[1],ing[4]).getAlchemyMarker();	// green +
	AlchemyMarker result2_6 = pba.makePotion(ing[1],ing[5]).getAlchemyMarker();	// green +
	AlchemyMarker result2_7 = pba.makePotion(ing[1],ing[6]).getAlchemyMarker();	// red -
	AlchemyMarker result2_8 = pba.makePotion(ing[1],ing[7]).getAlchemyMarker();	// blue +
	
	AlchemyMarker result3_4 = pba.makePotion(ing[2],ing[3]).getAlchemyMarker(); // blue +
	AlchemyMarker result3_5 = pba.makePotion(ing[2],ing[4]).getAlchemyMarker(); // red -
	AlchemyMarker result3_6 = pba.makePotion(ing[2],ing[5]).getAlchemyMarker();	// null
	AlchemyMarker result3_7 = pba.makePotion(ing[2],ing[6]).getAlchemyMarker();	// green -
	AlchemyMarker result3_8 = pba.makePotion(ing[2],ing[7]).getAlchemyMarker();	// blue +

	AlchemyMarker result4_5 = pba.makePotion(ing[3],ing[4]).getAlchemyMarker(); // null
	AlchemyMarker result4_6 = pba.makePotion(ing[3],ing[5]).getAlchemyMarker(); // red +
	AlchemyMarker result4_7 = pba.makePotion(ing[3],ing[6]).getAlchemyMarker(); // green -
	AlchemyMarker result4_8 = pba.makePotion(ing[3],ing[7]).getAlchemyMarker();	// red +
	
	AlchemyMarker result5_6 = pba.makePotion(ing[4],ing[5]).getAlchemyMarker(); // blue -
	AlchemyMarker result5_7 = pba.makePotion(ing[4],ing[6]).getAlchemyMarker(); // red -
	AlchemyMarker result5_8 = pba.makePotion(ing[4],ing[7]).getAlchemyMarker(); // green +

	AlchemyMarker result6_7 = pba.makePotion(ing[5],ing[6]).getAlchemyMarker(); // blue -
	AlchemyMarker result6_8 = pba.makePotion(ing[5],ing[7]).getAlchemyMarker(); // green +
	
	AlchemyMarker result7_8 = pba.makePotion(ing[6],ing[7]).getAlchemyMarker(); // null

	
	@Test
	void shouldEqualRed() {
		Assertions.assertTrue(result1_6.getColor().equals("red"));
		Assertions.assertTrue(result1_8.getColor().equals("red"));
		Assertions.assertTrue(result2_3.getColor().equals("red"));
		Assertions.assertTrue(result2_7.getColor().equals("red"));
		Assertions.assertTrue(result3_5.getColor().equals("red"));
		Assertions.assertTrue(result4_6.getColor().equals("red"));
		Assertions.assertTrue(result4_8.getColor().equals("red"));
		Assertions.assertTrue(result5_7.getColor().equals("red"));
	}
	
	@Test
	void shouldEqualBlue() {
		Assertions.assertTrue(result1_5.getColor().equals("blue"));
		Assertions.assertTrue(result1_7.getColor().equals("blue"));
		Assertions.assertTrue(result2_4.getColor().equals("blue"));
		Assertions.assertTrue(result2_8.getColor().equals("blue"));
		Assertions.assertTrue(result3_4.getColor().equals("blue"));
		Assertions.assertTrue(result3_8.getColor().equals("blue"));
		Assertions.assertTrue(result5_6.getColor().equals("blue"));
		Assertions.assertTrue(result6_7.getColor().equals("blue"));
	}
	
	@Test
	void shouldEqualGreen() {
		Assertions.assertTrue(result1_3.getColor().equals("green"));
		Assertions.assertTrue(result1_4.getColor().equals("green"));
		Assertions.assertTrue(result2_5.getColor().equals("green"));
		Assertions.assertTrue(result2_6.getColor().equals("green"));
		Assertions.assertTrue(result3_7.getColor().equals("green"));
		Assertions.assertTrue(result4_7.getColor().equals("green"));
		Assertions.assertTrue(result5_8.getColor().equals("green"));
		Assertions.assertTrue(result6_8.getColor().equals("green"));
	}
	
	@Test
	void shouldEqualPlus() {
		Assertions.assertTrue(result1_6.getSign().equals("+"));
		Assertions.assertTrue(result1_8.getSign().equals("+"));
		Assertions.assertTrue(result2_4.getSign().equals("+"));
		Assertions.assertTrue(result2_5.getSign().equals("+"));
		Assertions.assertTrue(result2_6.getSign().equals("+"));
		Assertions.assertTrue(result2_8.getSign().equals("+"));
		Assertions.assertTrue(result3_4.getSign().equals("+"));
		Assertions.assertTrue(result3_8.getSign().equals("+"));
		Assertions.assertTrue(result4_6.getSign().equals("+"));
		Assertions.assertTrue(result4_8.getSign().equals("+"));
		Assertions.assertTrue(result5_8.getSign().equals("+"));
		Assertions.assertTrue(result6_8.getSign().equals("+"));
	}
	
	@Test
	void shouldEqualMinus() {
		Assertions.assertTrue(result1_3.getSign().equals("-"));
		Assertions.assertTrue(result1_4.getSign().equals("-"));
		Assertions.assertTrue(result1_5.getSign().equals("-"));
		Assertions.assertTrue(result1_7.getSign().equals("-"));
		Assertions.assertTrue(result2_3.getSign().equals("-"));
		Assertions.assertTrue(result2_7.getSign().equals("-"));
		Assertions.assertTrue(result3_5.getSign().equals("-"));
		Assertions.assertTrue(result3_7.getSign().equals("-"));
		Assertions.assertTrue(result4_7.getSign().equals("-"));
		Assertions.assertTrue(result5_6.getSign().equals("-"));
		Assertions.assertTrue(result5_7.getSign().equals("-"));
		Assertions.assertTrue(result6_7.getSign().equals("-"));
		
	}
	
	@Test
	void shouldEqualNull() {
		Assertions.assertTrue(result1_2.getSign()==null && result1_2.getColor()==null);
		Assertions.assertTrue(result3_6.getSign()==null && result3_6.getColor()==null);
		Assertions.assertTrue(result4_5.getSign()==null && result4_5.getColor()==null);
		Assertions.assertTrue(result7_8.getSign()==null && result7_8.getColor()==null);
	}

}
