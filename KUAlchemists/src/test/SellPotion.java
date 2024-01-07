package test;
import java.util.Arrays;
import java.util.Random;

import javax.swing.ImageIcon;

import domain.Game;
import domain.Player;
import domain.ingredients.Alchemical;
import domain.ingredients.Ingredient;
import domain.ingredients.IngredientStorage;
import domain.potion.Potion;
import domain.potion.PotionBrewingArea;
import domain.potion.PotionController;
import domain.theorydeduction.AlchemyMarker;
import ui.PotionBrewingAreaDisplay;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;



public class SellPotion {

		PotionBrewingArea pba = new PotionBrewingArea();
		static PotionController controller;
		static Player player;
		static Potion p;
		static Ingredient[] ingredients;
		
		
		@BeforeAll
		static void setUpBeforeAll() {
			player = new Player("player", 0);
			Game.setCurrPlayer(player);
			controller = PotionController.getInstance();
			ingredients = IngredientStorage.getAllingredientcardsarray();
		}
		
		
		@Test
		@DisplayName("Test 1: Null Potion should throw a NullPointerException")
		void testNullPotion() {
			assertThrows(NullPointerException.class, () -> controller.sellPotion(0, p), "Potion is null!");
		}
		
		@Test
		@DisplayName("Test 2: Invalid guaranteeLevel should throw a InvalidArgumentException")
		void testValidGuarantee() {
			Potion p = pba.makePotion(ingredients[0], ingredients[1]);
			assertThrows(IllegalArgumentException.class, () -> controller.sellPotion(5, p));				
		}
		
		@Test
		@DisplayName("Test 3: Testing positive potion and guaranteeLevel 3")
		void testSellPositivePotion() {
			Potion p = new Potion(ingredients[0], ingredients[1], new AlchemyMarker("+", "blue"));
			assertEquals(3, controller.sellPotion(3, p));	
		}
		
		@Test
		@DisplayName("Test 4: Testing positive potion and guaranteeLevel 2")
		void testSellPositivePotion2() {
			Potion p = new Potion(ingredients[0], ingredients[1], new AlchemyMarker("+", "blue"));
			assertEquals(2, controller.sellPotion(2, p));	
		}
		
		@Test
		@DisplayName("Test 5: Testing positive potion and guaranteeLevel 1")
		void testSellPositivePotion3() {
			Potion p = new Potion(ingredients[0], ingredients[1], new AlchemyMarker("+", "blue"));
			assertEquals(1, controller.sellPotion(1, p));	
		}
		
		@Test
		@DisplayName("Test 6: Testing neutral potion and guaranteeLevel 3")
		void testSellNeutralPotion1() {
			Potion p = new Potion(ingredients[0], ingredients[1], new AlchemyMarker());
			assertEquals(0, controller.sellPotion(3, p));	
		}
				
		
		@Test
		@DisplayName("Test 7: Testing neutral potion and guaranteeLevel 2")
		void testSellNeutralPotion2() {
			Potion p = new Potion(ingredients[0], ingredients[1], new AlchemyMarker());
			assertEquals(2, controller.sellPotion(2, p));	
		}
				
		
		@Test
		@DisplayName("Test 8: Testing neutral potion and guaranteeLevel 1")
		void testSellNeutralPotion3() {
			Potion p = new Potion(ingredients[0], ingredients[1], new AlchemyMarker());
			assertEquals(1, controller.sellPotion(1, p));	
		}
		
		@Test
		@DisplayName("Test 9: Testing negative potion and guaranteeLevel 3")
		void testSellNegativePotion1() {
			Potion p = new Potion(ingredients[0], ingredients[1], new AlchemyMarker("-", "red"));
			assertEquals(0, controller.sellPotion(3, p));	
		}
		
		@Test
		@DisplayName("Test 10: Testing negative potion and guaranteeLevel 2")
		void testSellNegativePotion2() {
			Potion p = new Potion(ingredients[0], ingredients[1], new AlchemyMarker("-", "red"));
			assertEquals(0, controller.sellPotion(2, p));	
		}
		
		@Test
		@DisplayName("Test 11: Testing negative potion and guaranteeLevel 1")
		void testSellNegativePotion3() {
			Potion p = new Potion(ingredients[0], ingredients[1], new AlchemyMarker("-", "red"));
			assertEquals(1, controller.sellPotion(1, p));	
		}
	}	
