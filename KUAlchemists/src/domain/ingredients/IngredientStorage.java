package domain.ingredients;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class IngredientStorage {
	
	//fields
	//add ingredientCards here
	
	//INGREDIENT DECK SHOULD HAVE LIMITED NUMBER OF CARDS TO MAKE UNIQUE IDENTIFIER EASIER

	private static final Ingredient[] allIngredientCardsArray =
		{new Ingredient(1,"Lamia Heart-Blood","src/images/images-icons/ingredient1.jpg"),
		new Ingredient(2,"Witch's Tear", "src/images/images-icons/ingredient2.jpg"), 
		new Ingredient(3,"Hippocamp's Soul", "src/images/images-icons/ingredient3.jpg"), 
		new Ingredient(4,"Cockatrice Saliva", "src/images/images-icons/ingredient4.jpg"),
		new Ingredient(5,"Goldhorn's Tooth", "src/images/images-icons/ingredient5.jpg"),
		new Ingredient(6,"Ghost Barbs", "src/images/images-icons/ingredient6.jpg"),
		new Ingredient(7,"Bugbear Bone Meal", "src/images/images-icons/ingredient7.jpg"),
		new Ingredient(8,"Strix's Bone", "src/images/images-icons/ingredient8.jpg"),
		new Ingredient(9,"Merman Horn", "src/images/images-icons/ingredient9.jpg"),
		new Ingredient(10,"Bunyip Oil", "src/images/images-icons/ingredient10.jpg"),
		new Ingredient(11,"Hippocamp's Tongue", "src/images/images-icons/ingredient11.jpg"),
		new Ingredient(12,"Roc Claw", "src/images/images-icons/ingredient12.jpg")
		}; //for testing purposes


	public static Ingredient[] getAllingredientcardsarray() {
		return allIngredientCardsArray;
	}

	/*
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
	*/

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
