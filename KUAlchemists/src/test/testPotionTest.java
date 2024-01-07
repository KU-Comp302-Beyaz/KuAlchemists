package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

//import org.junit.Test;
//import static org.junit.Assert.assertEquals;

import domain.Player;
import domain.potion.Potion;
import domain.potion.PotionBrewingArea;
import domain.potion.Student;
import domain.theorydeduction.AlchemyMarker;


  
	
	/*
      testPotion method

	  Description:
	  for testing a potion by either a student or a player in the PotionBrewingArea. 
	  It considers various scenarios such as the student ability to test, the - potion effects or the player
	  sickness level. method also updates the players gold balance and sickness level based on the test results
	  
	  Requires:
	  -  potionBrewingArea object must be instantiated
	  -  player and potion parameters must not be null
	  -  potion parameter must be a testable Potion object
	  -  testMethod parameter must be a valid test method such "Student" or "Player"
	  
	  Modifies:
	  - if its applicable player gold balance 
	  -  if its applicable player sickness level 
	  
	  Effects:
	    whe testMethod is testing "Student"
	    - If student is sick  potion test player pays gold 
	    - If  student is not sick  potion test returns an AlchemyMarker indicating effect without any requirement
	  
	    when testMethod is testing  "Player":
	    - If  players sickness level is at the maximum (3) the potions test returns null (cant test)
	    - If player sickness level is not maximum the potion test apply effect on  player
	    -  player gold balance and sickness level are updated based on effects
	    -  player sickness level does not exceed maximum value
	  
	   if the testMethod is not valid
	    - potion test returns null
	    - player gold balance and sickness level remain unchanged
	  
	  */


class testPotionTest {
	
    static PotionBrewingArea potionBrewingArea = new PotionBrewingArea();

    //Black-Box Testing
    // gold balance is 0
    // student cannot test the potion.
    //checks whether can test potion with student when the gold is 0
    @Test
    public void testTestPotion_StudentCannotTest() {
        Player player = new Player("CurrentPlayer", 0); 
        player.setGoldBalance(0);
        Potion potion = new Potion(null, null, null); 
        Student sickStudent = new Student();
        sickStudent.setSicknessLevel(3); // Seting sickness level for testing

        //  student is sick so testing potion should increase sickness level and return null.
        if (sickStudent.getSicknessLevel() > 0) {
            int initialSicknessLevel = sickStudent.getSicknessLevel();
            assertEquals(null, potionBrewingArea.testPotion("Student", potion, player));
            
      // student is not sick so testing potion should return the AlchemyMarker
       } else {
            AlchemyMarker alchemyMarker = potionBrewingArea.testPotion("Student", potion, player);
            assertNotNull(alchemyMarker);
        }
        assertEquals(0, player.getGoldBalance()); // gold balance remains unchanged.
    }
    
    //Glass-Box Testing - knowledge of the internal logic  (ex- decreasing gold balance)
    // (-) effect potion
    // should decrease the gold -1
    @Test
    public void testTestPotion_StudentTestNegativeEffect() {
        Player player = new Player("CurrentPlayer", 0);
        player.setGoldBalance(5);
        Potion potion = new Potion(null, null, new AlchemyMarker("-", "red"));

        assertEquals(new AlchemyMarker("-", "red"), potionBrewingArea.testPotion("Student", potion, player)); //  gold balance to be 5 - 1 = 4 
        assertEquals(4, player.getGoldBalance()); //  gold balance doesn't go below zero
        assertTrue(player.getGoldBalance() >= 0);
    }


    
    //Black-Box Testing
    // sickness level at maximum
    // player cannot test the potion
    // checks whether player can test a potion when the sickness level is maximum = 3
    @Test
    public void testTestPotion_PlayerCannotTest() {
        Player player = new Player("CurrentPlayer", 0);
        player.setSicknessLevel(3); 
        Potion potion = new Potion(null, null, null); 
        
        assertEquals(null, potionBrewingArea.testPotion("Player", potion, player));
        assertEquals(3, player.getSicknessLevel()); // sickness level remains unchanged
        assertTrue(player.getSicknessLevel() <= 3);  //to ensure sickness level doesnt go above the maximum value
 
    }

    //GlassBox
    //sickness level less than maximum
    // testing - effect potion on player should call the testOnPlayer method
    @Test
    public void testTestPotion_PlayerTestOnPlayer() {
        Player player = new Player("CurrentPlayer", 0);
        player.setSicknessLevel(2);
        Potion potion = new Potion(null, null, new AlchemyMarker("-", "green"));

        assertEquals(new AlchemyMarker("-", "green"), potionBrewingArea.testPotion("Player", potion, player));
        assertEquals(3, player.getSicknessLevel()); // Update expected sickness level
    }



    //GlassBox
    @Test
    public void testTestPotion_InvalidTestMethodNoEffectOnPlayer() {
        Player player = new Player("CurrentPlayer", 0);
        int initialGold = player.getGoldBalance();
        int initialSicknessLevel = player.getSicknessLevel();
        Potion potion = new Potion(null, null, new AlchemyMarker("neutral", "blue")); // Neutral effect potion
        // invalid test method returns null
        AlchemyMarker result = potionBrewingArea.testPotion("InvalidMethod", potion, player);

        assertNull(result); // checking if result is null

      //player attributes remain unchanged
        assertEquals(initialGold, player.getGoldBalance());
        assertEquals(initialSicknessLevel, player.getSicknessLevel());
    }


}

