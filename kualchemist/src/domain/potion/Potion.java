package domain.potion;

import domain.ingredients.Ingredient;

public class Potion {
	
	Ingredient[] recipe = new Ingredient[2];
	String sign; //positive, negative, neutral
	
	//int pointValue; ??
	
	public Potion(Ingredient i1, Ingredient i2) {
		
		recipe[0] = i1;
		recipe[1] = i2;
		sign = ""; //? teste mi göndermeliyiz 
		//sign = testPotion(this);
	}
	
	
	
	
}
