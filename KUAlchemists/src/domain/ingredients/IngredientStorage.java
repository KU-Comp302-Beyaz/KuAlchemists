package domain.ingredients;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import domain.theorydeduction.AlchemyMarker;

import javax.swing.ImageIcon;

import domain.theorydeduction.AlchemyMarker;

public class IngredientStorage {

	
	//fields
	private static final Ingredient[] allIngredientCardsArray =
		{new Ingredient(1,"Lamia Heart-Blood","src/images/images-icons/ingredient1.jpg", new Alchemical (new AlchemyMarker ("+", "red", "S","src/images/alchemyMarker-icons/red+.png"), new AlchemyMarker ("-", "green", "L","src/images/alchemyMarker-icons/green-.png"), new AlchemyMarker ("-", "blue", "S","src/images/alchemyMarker-icons/blue-.png"),"")),
		new Ingredient(2,"Witch's Tear", "src/images/images-icons/ingredient2.jpg",  new Alchemical (new AlchemyMarker ("-", "red", "S","src/images/alchemyMarker-icons/red-.png"), new AlchemyMarker ("+", "green", "L","src/images/alchemyMarker-icons/green+.png"), new AlchemyMarker ("+", "blue", "S","src/images/alchemyMarker-icons/blue+.png"),"")), 
		new Ingredient(3,"Hippocamp's Soul", "src/images/images-icons/ingredient3.jpg", new Alchemical (new AlchemyMarker ("-", "red", "L","src/images/alchemyMarker-icons/red-.png"), new AlchemyMarker ("-", "green", "S","src/images/alchemyMarker-icons/green-.png"), new AlchemyMarker ("+", "blue", "S","src/images/alchemyMarker-icons/blue+.png"),"")), 
		new Ingredient(4,"Cockatrice Saliva", "src/images/images-icons/ingredient4.jpg", new Alchemical (new AlchemyMarker ("+", "red", "S","src/images/alchemyMarker-icons/red+.png"), new AlchemyMarker ("-", "green", "S","src/images/alchemyMarker-icons/green-.png"), new AlchemyMarker ("+", "blue", "L","src/images/alchemyMarker-icons/blue+.png"),"")),
		new Ingredient(5,"Goldhorn's Tooth", "src/images/images-icons/ingredient5.jpg",  new Alchemical (new AlchemyMarker ("-", "red", "S","src/images/alchemyMarker-icons/red-.png"), new AlchemyMarker ("+", "green", "S","src/images/alchemyMarker-icons/green+.png"), new AlchemyMarker ("-", "blue", "L","src/images/alchemyMarker-icons/blue-.png"),"")),
		new Ingredient(6,"Ghost Barbs", "src/images/images-icons/ingredient6.jpg",  new Alchemical (new AlchemyMarker ("+", "red", "L","src/images/alchemyMarker-icons/red+.png"), new AlchemyMarker ("+", "green", "S","src/images/alchemyMarker-icons/green+.png"), new AlchemyMarker ("-", "blue", "S","src/images/alchemyMarker-icons/blue-.png"),"")),
		new Ingredient(7,"Bugbear Bone Meal", "src/images/images-icons/ingredient7.jpg",  new Alchemical (new AlchemyMarker ("-", "red", "L","src/images/alchemyMarker-icons/red-.png"), new AlchemyMarker ("-", "green", "L","src/images/alchemyMarker-icons/green-.png"), new AlchemyMarker ("-", "blue", "L","src/images/alchemyMarker-icons/blue-.png"),"")),
		new Ingredient(8,"Strix's Bone", "src/images/images-icons/ingredient8.jpg",  new Alchemical (new AlchemyMarker ("+", "red", "L","src/images/alchemyMarker-icons/red+.png"), new AlchemyMarker ("+", "green", "L","src/images/alchemyMarker-icons/green+.png"), new AlchemyMarker ("+", "blue", "L","src/images/alchemyMarker-icons/blue+.png"),"")),
		}; 


	public static Ingredient[] getAllingredientcardsarray() {
		return allIngredientCardsArray;
	}
  
	private ArrayList<Ingredient> ingredientCards = new ArrayList<Ingredient>();
	
	//Singleton implementation
	private static IngredientStorage ingredientStorageSingleton = new IngredientStorage();
	
	private IngredientStorage() {
		initializeIngredients();
	}
	
	public static IngredientStorage getInstance() {
		return ingredientStorageSingleton;
	}
	
	/**
	 * Converts ingredient array to ArrayList then shuffles the ingredient cards
	 * @return shuffled ingredient cards
	 */
	public ArrayList<Ingredient> initializeIngredients() {
		for (int i = 0; i < 4; i++) {
			Collections.addAll(ingredientCards, allIngredientCardsArray);
		}
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
