package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.ingredients.Alchemical;
import domain.theorydeduction.AlchemyMarker;


class AlchemicalCheckEqualityTest {

	Alchemical a1;
	Alchemical a2;
	
	
	/*
	 * Specifications for checkEquality(alchemical1, alchemical2) method:
	 * 
	 * REQUIRES: -
	 * MODIFIES: -
	 * EFFECTS: two alchemicals are compared to each other by whether they are the same or not and the result is returned.
	 */
	
	@BeforeEach
	void setup() {
		
		a1 = new Alchemical(null,null,null,"will change");
		a2 = new Alchemical(null,null,null,"will change");
	}
	@Test
	void nullShouldBeFalse() {
		a1 = null;
		Assertions.assertFalse(Alchemical.checkEquality(a1, a2));
	}
	@Test
	void photoFieldNullShouldBeFalse() {
		
		a1.setAlchemicalPhoto(null);
		Assertions.assertFalse(Alchemical.checkEquality(a1, a2));
		
	}
	@Test
	void unequalPhotoSholdBeFalse() {
		a1.setAlchemicalPhoto("test1");
		a2.setAlchemicalPhoto("test2");
		Assertions.assertFalse(Alchemical.checkEquality(a1, a2));
	}
	@Test
	void equalPhotoShouldBeTrue() {
		Assertions.assertTrue(Alchemical.checkEquality(a1, a2));
	}
	@Test
	void fromDectIngredientsShouldBeFalse() {
		a1 = new Alchemical(new AlchemyMarker("+","red","S"), new AlchemyMarker("-","green","L"), new AlchemyMarker("-","blue","S"), "src/images/alchemical-icons/alchemical1.png");
		a2 = new Alchemical(new AlchemyMarker("-","red","S"), new AlchemyMarker("+","green","L"), new AlchemyMarker("+","blue","S"), "src/images/alchemical-icons/alchemical2.png");
		Assertions.assertFalse(Alchemical.checkEquality(a1, a2));
	}
	@Test
	void fromDectIngredientsShouldBeTrue() {
		a1 = new Alchemical(new AlchemyMarker("+","red","S"), new AlchemyMarker("-","green","L"), new AlchemyMarker("-","blue","S"), "src/images/alchemical-icons/alchemical1.png");
		a2 = new Alchemical(new AlchemyMarker("+","red","S"), new AlchemyMarker("-","green","L"), new AlchemyMarker("-","blue","S"), "src/images/alchemical-icons/alchemical1.png");
		Assertions.assertTrue(Alchemical.checkEquality(a1, a2));
	}

}
