package domain.ingredients;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class IngredientStorage {
	
	//fields
	//add ingredientCards here
	
	//INGREDIENT DECK SHOULD HAVE LIMITED NUMBER OF CARDS TO MAKE UNIQUE IDENTIFIER EASIER
	private final Ingredient[] allIngredientCardsArray =
		{new Ingredient("Lamia Heart-Blood"),
		new Ingredient("Witch's Tear"), 
		new Ingredient("Hippocamp's Soul"), 
		new Ingredient("Cockatrice Saliva"),
		new Ingredient("Goldhorn's Tooth"),
		new Ingredient("Ghost Barbs"),
		new Ingredient("Bugbear Bone Meal"),
		new Ingredient("Strix's Bone"),
		new Ingredient("Merman Horn"),
		new Ingredient("Bunyip Oil"),
		new Ingredient("Hippocamp's Tongue"),
		new Ingredient("Roc Claw")
		}; //for testing purposes

	private ArrayList<Ingredient> ingredientCards = new ArrayList<Ingredient>();
	
	//Singleton implementation
	private static IngredientStorage ingredientStorageSingleton = new IngredientStorage();
	
	private IngredientStorage() {
		initializeIngredients();
	}
	
	public static IngredientStorage getInstance() {
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

	public Ingredient[] getAllIngredientCardsArray() {
		return allIngredientCardsArray;
	}

	@Override
	public String toString() {
		return "IngredientStorage [allIngredientCardsArray=" + Arrays.toString(allIngredientCardsArray)
				+ ", ingredientCards=" + ingredientCards + "]";
	}
	
	




	

}
