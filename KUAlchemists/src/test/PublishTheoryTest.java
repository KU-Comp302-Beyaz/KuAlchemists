package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.Game;
import domain.Player;
import domain.ingredients.Alchemical;
import domain.ingredients.Ingredient;
import domain.ingredients.IngredientStorage;
import domain.publication.PublicationTrack;
import domain.theorydeduction.AlchemyMarker;
import domain.theorydeduction.DeductionBoard;


class PublishTheoryTest {

	DeductionBoard db;
	Player p;
	PublicationTrack pt = PublicationTrack.getInstance();
	Alchemical a1;
	Ingredient i1;
	
	/*
	 * publishTheory(alchemical,ingredient) method gets one alchemical and one ingredient instance,
	 * creates a theory from them and add the theory to Publication Track publishedTheories arraylist.
	 * It also removes the selected alchemical and ingredients from the availableAlchemicals and availableIngredients
	 * lists of Publication Track.
	 */
	
	/*
	 * Specifications for publishTheory(alchemical,ingredient) method:
	 * 
	 * REQUIRES: alchemical is not null, ingredient is not null.
	 * MODIFIES: PublicationTrack.availableAlchemicals, PulicationTrack.availableIngredients, PublicationTrack.publishedTheories, currPlayer.theories
	 * EFFECTS: A new theory is created from the alchemical and ingredient and added to the publication track's published theories
	 * 			and current player's published theories. Used alchemical and ingredient are removed from publication tracks
	 * 	        available alchemicals and available ingredients.
	 * 
	 */
	
	@BeforeEach
	void setup() {
		pt.getAvailableAlchemicals().clear();
		pt.getAvailableIngredients().clear();
		pt.getPublishedTheories().clear();
		
		Game.initializePublicationTrack();
		p = new Player("Test", 0);
		db = new DeductionBoard(p);
		a1 = new Alchemical(new AlchemyMarker("+","red","S"), new AlchemyMarker("-","green","L"), new AlchemyMarker("-","blue","S"), "src/images/alchemical-icons/alchemical1.png");
		i1 = new Ingredient(1,"Lamia Heart-Blood","src/images/images-icons/ingredient1.jpg", new Alchemical (new AlchemyMarker ("+", "red", "S"), new AlchemyMarker ("-", "green", "L"), new AlchemyMarker ("-", "blue", "S"),""));
	}
	

	

	
	@Test
	void shouldReturnTrue() {
		Assertions.assertTrue(db.publishTheory(a1,i1));
	}
	
	@Test 
	void shouldReturnFalse() {
		
		p.setGoldBalance(0);
		Assertions.assertFalse(db.publishTheory(a1,i1));
	}
	
	@Test
	void shouldNotBeEmpty() {
		
		db.publishTheory(a1,i1);
		Assertions.assertFalse(pt.getPublishedTheories().isEmpty());
	}
	
	@Test
	void availableAlchemicalsSholdNotBeEight() {
		
		db.publishTheory(a1, i1);
		Assertions.assertFalse(pt.getAvailableAlchemicals().size() == 8);
	}
	
	@Test
	void availableIngredientsSholdNotBeEight() {
		Alchemical a1 = new Alchemical(new AlchemyMarker("+","red","S"), new AlchemyMarker("-","green","L"), new AlchemyMarker("-","blue","S"), "src/images/alchemical-icons/alchemical1.png");
		Ingredient i1 = IngredientStorage.getAllingredientcardsarray()[0];
		db.publishTheory(a1, i1);
		Assertions.assertFalse(pt.getAvailableIngredients().size() == 8);
	}
	
	@Test
	void notContainedAlchemicalShouldReturnFalse() {
		
		Assertions.assertFalse(db.publishTheory(new Alchemical(null, null, null), i1));
	}
	
	@Test
	void notContainedIngredientShouldReturnFalse() {
		
		Assertions.assertFalse(db.publishTheory(a1, new Ingredient(null)));
	}
	
}
