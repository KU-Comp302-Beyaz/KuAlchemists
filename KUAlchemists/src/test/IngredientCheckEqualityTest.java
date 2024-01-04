package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.ingredients.Ingredient;
import domain.ingredients.IngredientStorage;

class IngredientCheckEqualityTest {
	
	Ingredient i1;
	Ingredient i2;
	
	@BeforeEach
	void setup() {
		
		i1 = new Ingredient(0,"test1","will change");
		i2 = new Ingredient(0,"test2","will change");
	}
	@Test
	void nullShouldBeFalse() {
		i1 = null;
		Assertions.assertFalse(Ingredient.checkEquality(i1, i2));
	}
	@Test
	void photoFieldNullShouldBeFalse() {
		
		i1.setPhoto(null);
		Assertions.assertFalse(Ingredient.checkEquality(i1, i2));
		
	}
	@Test
	void unequalPhotoSholdBeFalse() {
		i1.setPhoto("test1");
		i2.setPhoto("test2");
		Assertions.assertFalse(Ingredient.checkEquality(i1, i2));
	}
	@Test
	void equalPhotoShouldBeTrue() {
		Assertions.assertTrue(Ingredient.checkEquality(i1, i2));
	}
	@Test
	void fromDectIngredientsShouldBeFalse() {
		i1 = IngredientStorage.getAllingredientcardsarray()[0];
		i2 = IngredientStorage.getAllingredientcardsarray()[1];
		Assertions.assertFalse(Ingredient.checkEquality(i1, i2));
	}
	@Test
	void fromDectIngredientsShouldBeTrue() {
		i1 = IngredientStorage.getAllingredientcardsarray()[0];
		i2 = IngredientStorage.getAllingredientcardsarray()[0];
		Assertions.assertTrue(Ingredient.checkEquality(i1, i2));
	}

}
