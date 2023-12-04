package domain.ingredients;

import java.util.ArrayList;
import java.util.Collections;

public class IngredientStorage {
	
	//fields
	//add ingredientCards here
	
	//INGREDIENT DECK SHOULD HAVE LIMITED NUMBER OF CARDS TO MAKE UNIQUE IDENTIFIER EASIER
	private static final Ingredient[] allIngredientCardsArray =
		{new Ingredient(1,"Lamia Heart-Blood",1),
		new Ingredient(2,"Witch's Tear",2), 
		new Ingredient(3,"Hippocamp's Soul",3), 
		new Ingredient(4,"Cockatrice Saliva",4),
		new Ingredient(5,"Goldhorn's Tooth",5),
		new Ingredient(6,"Ghost Barbs",6),
		new Ingredient(7,"Bugbear Bone Meal",7),
		new Ingredient(8,"Strix's Bone",8),
		new Ingredient(9,"Merman Horn",9),
		new Ingredient(10,"Bunyip Oil",10),
		new Ingredient(11,"Hippocamp's Tongue",11),
		new Ingredient(12,"Roc Claw",12)
		}; //for testing purposes


	private ArrayList<Ingredient> ingredientCards = new ArrayList<Ingredient>();
	
	//Singleton implementation
	private static IngredientStorage ingredientStorageSingleton = new IngredientStorage();
	
	private IngredientStorage() {
		initializeIngredients();
	}
	
	public static IngredientStorage getIngredientStorage() {
		return ingredientStorageSingleton;
	}
	
	//shuffles and returns ingredientCards
	public ArrayList<Ingredient> initializeIngredients() {
		Collections.addAll(ingredientCards, allIngredientCardsArray);
		Collections.shuffle(ingredientCards);
		return ingredientCards;
	}

	//getter and setters
	public ArrayList<Ingredient> getIngredientCards() {
		return ingredientCards;
	}

	public void setIngredientCards(ArrayList<Ingredient> ingredientCards) {
		this.ingredientCards = ingredientCards;
	}
	
	

}
