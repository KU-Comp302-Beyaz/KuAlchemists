package domain.potion;

import domain.ingredients.Ingredient;
import domain.theorydeduction.AlchemyMarker;

public class Potion {
	
	Ingredient[] recipe = new Ingredient[2];
	AlchemyMarker alchemyMarker = new AlchemyMarker();
	
	//int pointValue; ??
	
	public Potion(Ingredient i1, Ingredient i2, AlchemyMarker resultToken) {
		
		recipe[0] = i1;
		recipe[1] = i2;
		alchemyMarker = resultToken;
	}

	public Ingredient[] getRecipe() {
		return recipe;
	}
	public void setRecipe(Ingredient[] recipe) {
		this.recipe = recipe;
	}

	public AlchemyMarker getAlchemyMarker() {
		return alchemyMarker;
	}
	public void setAlchemyMarker(AlchemyMarker alchemyMarker) {
		this.alchemyMarker = alchemyMarker;
	}
	
	
	
	
	
}
