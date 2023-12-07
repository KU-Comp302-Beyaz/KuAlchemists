package domain.ingredients;

import java.util.ArrayList;
import java.util.Collections;

public class IngredientStorage {
	
	//fields
	//add ingredientCards here
	
	//INGREDIENT DECK SHOULD HAVE LIMITED NUMBER OF CARDS TO MAKE UNIQUE IDENTIFIER EASIER
	private static final Ingredient[] allIngredientCardsArray =
		{new Ingredient(1,"Lamia Heart-Blood",1,"src/images/images-icons/ingredient1.jpg"),
		new Ingredient(2,"Witch's Tear",2, "src/images/images-icons/ingredient2.jpg"), 
		new Ingredient(3,"Hippocamp's Soul",3, "src/images/images-icons/ingredient3.jpg"), 
		new Ingredient(4,"Cockatrice Saliva",4, "src/images/images-icons/ingredient4.jpg"),
		new Ingredient(5,"Goldhorn's Tooth",5, "src/images/images-icons/ingredient5.jpg"),
		new Ingredient(6,"Ghost Barbs",6, "src/images/images-icons/ingredient6.jpg"),
		new Ingredient(7,"Bugbear Bone Meal",7, "src/images/images-icons/ingredient7.jpg"),
		new Ingredient(8,"Strix's Bone",8, "src/images/images-icons/ingredient8.jpg"),
		new Ingredient(9,"Merman Horn",9, "src/images/images-icons/ingredient9.jpg"),
		new Ingredient(10,"Bunyip Oil",10, "src/images/images-icons/ingredient10.jpg"),
		new Ingredient(11,"Hippocamp's Tongue",11, "src/images/images-icons/ingredient11.jpg"),
		new Ingredient(12,"Roc Claw",12, "src/images/images-icons/ingredient12.jpg")
		}; //for testing purposes


	public static Ingredient[] getAllingredientcardsarray() {
		return allIngredientCardsArray;
	}

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
