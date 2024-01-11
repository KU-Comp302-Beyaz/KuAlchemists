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
		{new Ingredient(1,"Fern","src/images/images-icons/ingredient1.jpg", new Alchemical (new AlchemyMarker ("+", "red", "S"), new AlchemyMarker ("-", "green", "L"), new AlchemyMarker ("-", "blue", "S"),"")),
		new Ingredient(2,"Chicken Foot", "src/images/images-icons/ingredient2.jpg",  new Alchemical (new AlchemyMarker ("-", "red", "S"), new AlchemyMarker ("+", "green", "L"), new AlchemyMarker ("+", "blue", "S"),"")), 
		new Ingredient(3,"Mushroom", "src/images/images-icons/ingredient3.jpg", new Alchemical (new AlchemyMarker ("-", "red", "L"), new AlchemyMarker ("-", "green", "S"), new AlchemyMarker ("+", "blue", "S"),"")), 
		new Ingredient(4,"Lotus Flower", "src/images/images-icons/ingredient4.jpg", new Alchemical (new AlchemyMarker ("+", "red", "S"), new AlchemyMarker ("-", "green", "S"), new AlchemyMarker ("+", "blue", "L"),"")),
		new Ingredient(5,"Root", "src/images/images-icons/ingredient5.jpg",  new Alchemical (new AlchemyMarker ("-", "red", "S"), new AlchemyMarker ("+", "green", "S"), new AlchemyMarker ("-", "blue", "L"),"")),
		new Ingredient(6,"Scorpion", "src/images/images-icons/ingredient6.jpg",  new Alchemical (new AlchemyMarker ("+", "red", "L"), new AlchemyMarker ("+", "green", "S"), new AlchemyMarker ("-", "blue", "S"),"")),
		new Ingredient(7,"Warty Toad", "src/images/images-icons/ingredient7.jpg",  new Alchemical (new AlchemyMarker ("-", "red", "L"), new AlchemyMarker ("-", "green", "L"), new AlchemyMarker ("-", "blue", "L"),"")),
		new Ingredient(8,"Feather", "src/images/images-icons/ingredient8.jpg",  new Alchemical (new AlchemyMarker ("+", "red", "L"), new AlchemyMarker ("+", "green", "L"), new AlchemyMarker ("+", "blue", "L"),"")),

		//new Ingredient(9,"Merman Horn", "src/images/images-icons/ingredient9.jpg",  new Alchemical (new AlchemyMarker ("+", "red", "S"), new AlchemyMarker ("-", "green", "L"), new AlchemyMarker ("-", "blue", "S"), new ImageIcon())),
		//new Ingredient(10,"Bunyip Oil", "src/images/images-icons/ingredient10.jpg",  new Alchemical (new AlchemyMarker ("+", "red", "S"), new AlchemyMarker ("-", "green", "L"), new AlchemyMarker ("-", "blue", "S"), new ImageIcon())),
		//new Ingredient(11,"Hippocamp's Tongue", "src/images/images-icons/ingredient11.jpg",  new Alchemical (new AlchemyMarker ("+", "red", "S"), new AlchemyMarker ("-", "green", "L"), new AlchemyMarker ("-", "blue", "S"), new ImageIcon())),
		//new Ingredient(12,"Roc Claw", "src/images/images-icons/ingredient12.jpg",  new Alchemical (new AlchemyMarker ("+", "red", "S"), new AlchemyMarker ("-", "green", "L"), new AlchemyMarker ("-", "blue", "S"), new ImageIcon()))
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
