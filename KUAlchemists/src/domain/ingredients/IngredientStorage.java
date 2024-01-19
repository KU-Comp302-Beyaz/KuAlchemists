package domain.ingredients;

import java.util.ArrayList;
import java.util.Collections;
import domain.theorydeduction.AlchemyMarker;

public class IngredientStorage {

	//fields
	private final Ingredient[] allIngredientCardsArray =
		{	new Ingredient(1,"Lamia Heart-Blood","src/images/images-icons/ingredient1.jpg"),
			new Ingredient(2,"Witch's Tear", "src/images/images-icons/ingredient2.jpg"), 
			new Ingredient(3,"Hippocamp's Soul", "src/images/images-icons/ingredient3.jpg"), 
			new Ingredient(4,"Cockatrice Saliva", "src/images/images-icons/ingredient4.jpg"), 
			new Ingredient(5,"Goldhorn's Tooth", "src/images/images-icons/ingredient5.jpg"),  
			new Ingredient(6,"Ghost Barbs", "src/images/images-icons/ingredient6.jpg"), 
			new Ingredient(7,"Bugbear Bone Meal", "src/images/images-icons/ingredient7.jpg"),  
			new Ingredient(8,"Strix's Bone", "src/images/images-icons/ingredient8.jpg")
		}; 
	
	private final Alchemical[] allAlchemicalsArray =
	   {new Alchemical (new AlchemyMarker ("+", "red", "S","src/images/alchemyMarker-icons/red+.png"), new AlchemyMarker ("-", "green", "L","src/images/alchemyMarker-icons/green-.png"), new AlchemyMarker ("-", "blue", "S","src/images/alchemyMarker-icons/blue-.png")),
		new Alchemical (new AlchemyMarker ("-", "red", "S","src/images/alchemyMarker-icons/red-.png"), new AlchemyMarker ("+", "green", "L","src/images/alchemyMarker-icons/green+.png"), new AlchemyMarker ("+", "blue", "S","src/images/alchemyMarker-icons/blue+.png")), 
		new Alchemical (new AlchemyMarker ("-", "red", "L","src/images/alchemyMarker-icons/red-.png"), new AlchemyMarker ("-", "green", "S","src/images/alchemyMarker-icons/green-.png"), new AlchemyMarker ("+", "blue", "S","src/images/alchemyMarker-icons/blue+.png")), 
		new Alchemical (new AlchemyMarker ("+", "red", "S","src/images/alchemyMarker-icons/red+.png"), new AlchemyMarker ("-", "green", "S","src/images/alchemyMarker-icons/green-.png"), new AlchemyMarker ("+", "blue", "L","src/images/alchemyMarker-icons/blue+.png")),
		new Alchemical (new AlchemyMarker ("-", "red", "S","src/images/alchemyMarker-icons/red-.png"), new AlchemyMarker ("+", "green", "S","src/images/alchemyMarker-icons/green+.png"), new AlchemyMarker ("-", "blue", "L","src/images/alchemyMarker-icons/blue-.png")),
		new Alchemical (new AlchemyMarker ("+", "red", "L","src/images/alchemyMarker-icons/red+.png"), new AlchemyMarker ("+", "green", "S","src/images/alchemyMarker-icons/green+.png"), new AlchemyMarker ("-", "blue", "S","src/images/alchemyMarker-icons/blue-.png")),
		new Alchemical (new AlchemyMarker ("-", "red", "L","src/images/alchemyMarker-icons/red-.png"), new AlchemyMarker ("-", "green", "L","src/images/alchemyMarker-icons/green-.png"), new AlchemyMarker ("-", "blue", "L","src/images/alchemyMarker-icons/blue-.png")),
		new Alchemical (new AlchemyMarker ("+", "red", "L","src/images/alchemyMarker-icons/red+.png"), new AlchemyMarker ("+", "green", "L","src/images/alchemyMarker-icons/green+.png"), new AlchemyMarker ("+", "blue", "L","src/images/alchemyMarker-icons/blue+.png"))
		}; 
	
//	  {		new Ingredient(1,"Lamia Heart-Blood","src/images/images-icons/ingredient1.jpg", new Alchemical (new AlchemyMarker ("+", "red", "S","src/images/alchemyMarker-icons/red+.png"), new AlchemyMarker ("-", "green", "L","src/images/alchemyMarker-icons/green-.png"), new AlchemyMarker ("-", "blue", "S","src/images/alchemyMarker-icons/blue-.png"))),
//			new Ingredient(2,"Witch's Tear", "src/images/images-icons/ingredient2.jpg",  new Alchemical (new AlchemyMarker ("-", "red", "S","src/images/alchemyMarker-icons/red-.png"), new AlchemyMarker ("+", "green", "L","src/images/alchemyMarker-icons/green+.png"), new AlchemyMarker ("+", "blue", "S","src/images/alchemyMarker-icons/blue+.png"))), 
//			new Ingredient(3,"Hippocamp's Soul", "src/images/images-icons/ingredient3.jpg", new Alchemical (new AlchemyMarker ("-", "red", "L","src/images/alchemyMarker-icons/red-.png"), new AlchemyMarker ("-", "green", "S","src/images/alchemyMarker-icons/green-.png"), new AlchemyMarker ("+", "blue", "S","src/images/alchemyMarker-icons/blue+.png"))), 
//			new Ingredient(4,"Cockatrice Saliva", "src/images/images-icons/ingredient4.jpg", new Alchemical (new AlchemyMarker ("+", "red", "S","src/images/alchemyMarker-icons/red+.png"), new AlchemyMarker ("-", "green", "S","src/images/alchemyMarker-icons/green-.png"), new AlchemyMarker ("+", "blue", "L","src/images/alchemyMarker-icons/blue+.png"))),
//			new Ingredient(5,"Goldhorn's Tooth", "src/images/images-icons/ingredient5.jpg",  new Alchemical (new AlchemyMarker ("-", "red", "S","src/images/alchemyMarker-icons/red-.png"), new AlchemyMarker ("+", "green", "S","src/images/alchemyMarker-icons/green+.png"), new AlchemyMarker ("-", "blue", "L","src/images/alchemyMarker-icons/blue-.png"))),
//			new Ingredient(6,"Ghost Barbs", "src/images/images-icons/ingredient6.jpg",  new Alchemical (new AlchemyMarker ("+", "red", "L","src/images/alchemyMarker-icons/red+.png"), new AlchemyMarker ("+", "green", "S","src/images/alchemyMarker-icons/green+.png"), new AlchemyMarker ("-", "blue", "S","src/images/alchemyMarker-icons/blue-.png"))),
//			new Ingredient(7,"Bugbear Bone Meal", "src/images/images-icons/ingredient7.jpg",  new Alchemical (new AlchemyMarker ("-", "red", "L","src/images/alchemyMarker-icons/red-.png"), new AlchemyMarker ("-", "green", "L","src/images/alchemyMarker-icons/green-.png"), new AlchemyMarker ("-", "blue", "L","src/images/alchemyMarker-icons/blue-.png"))),
//			new Ingredient(8,"Strix's Bone", "src/images/images-icons/ingredient8.jpg",  new Alchemical (new AlchemyMarker ("+", "red", "L","src/images/alchemyMarker-icons/red+.png"), new AlchemyMarker ("+", "green", "L","src/images/alchemyMarker-icons/green+.png"), new AlchemyMarker ("+", "blue", "L","src/images/alchemyMarker-icons/blue+.png"))),
//			}; 

	private ArrayList<Ingredient> ingredientCards = new ArrayList<Ingredient>();
	private ArrayList<Alchemical> alchemicals = new ArrayList<Alchemical>();
	
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
		matchIngredientsWithAlchemicals();
		for (int i = 0; i < 4; i++) {
			Collections.addAll(ingredientCards, allIngredientCardsArray);
		}
		Collections.shuffle(ingredientCards);
		return ingredientCards;
	}
	
	public void matchIngredientsWithAlchemicals() {
		Collections.addAll(alchemicals, allAlchemicalsArray);
		Collections.shuffle(alchemicals);
		for (int i = 0; i < allIngredientCardsArray.length; i++) {
			allIngredientCardsArray[i].setAlchemical(alchemicals.get(i));
		}
	}

	//getter and setters
	public ArrayList<Ingredient> getIngredientCards() {
		return ingredientCards;
	}
	public void setIngredientCards(ArrayList<Ingredient> ingredientCards) {
		this.ingredientCards = ingredientCards;
	}
	
	public Ingredient[] getAllingredientcardsarray() {
		return allIngredientCardsArray;
	}

	public Alchemical[] getAllalchemicalsarray() {
		return allAlchemicalsArray;
	}

	public ArrayList<Alchemical> getAlchemicals() {
		return alchemicals;
	}

	public void setAlchemicals(ArrayList<Alchemical> alchemicals) {
		this.alchemicals = alchemicals;
	}
	
	




	

}
