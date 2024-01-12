package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import domain.ingredients.Ingredient;
import domain.potion.Potion;
import domain.theorydeduction.AlchemyMarker;
import domain.theorydeduction.DeductionBoard;
import domain.theorydeduction.Theory;
import domain.artifact.*;

public class Player {

	private String username;
	private int token;
	private int goldBalance; 
	private int turnNumber;
	private List<Ingredient> ingredientCards = new ArrayList<Ingredient>(2); 
	// private Artifact[] artifactCards;
	private int sicknessLevel;
	private int reputationPoints;
	private int scorePoints;
	private List<Potion> potions = new ArrayList<Potion>();
	private List<Theory> theories = new ArrayList<Theory>();
	private HashMap<String,Artifact> artifacts = new HashMap<String,Artifact>(2);
	private DeductionBoard playerDeductionBoard;


	
	// constructor
	public Player (String username, int chosenAvatarIndex) {
		
		this.username = username;
		this.token = chosenAvatarIndex;
		this.goldBalance = 10; //?
		this.turnNumber = 3; // azalacak şekilde güncellenir
		this.sicknessLevel = 0;
		this.reputationPoints = 0;
		this.scorePoints = 0;
		this.playerDeductionBoard = new DeductionBoard(this);
		
	}
	
	
	
	// getter - setter
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public int getToken() {
		return token;
	}
	public void setToken(int token) {
		this.token = token;
	}

	public int getGoldBalance() {
		return goldBalance;
	}
	public void setGoldBalance(int goldBalance) {
		this.goldBalance = goldBalance;
	}

	public int getTurnNumber() {
		return turnNumber;
	}
	public void setTurnNumber(int turnNumber) {
		this.turnNumber = turnNumber;
	}

	public List<Ingredient> getIngredientCards() {
		return ingredientCards;
	}
	public void setIngredientCards(List<Ingredient> ingredientCards) {
		this.ingredientCards = ingredientCards;
	}

	public int getSicknessLevel() {
		return sicknessLevel;
	}
	public void setSicknessLevel(int sicknessLevel) {
		this.sicknessLevel = sicknessLevel;
	}

	public int getReputationPoints() {
		return reputationPoints;
	}
	public void setReputationPoints(int reputationPoints) {
		this.reputationPoints = reputationPoints;
	}

	public void setScorePoints(int scorePoints) {
		this.scorePoints = scorePoints;
	}

	public List<Potion> getPotions() {
		return potions;
	}
	public void setPotions(List<Potion> potions) {
		this.potions = potions;
	}

	public List<Theory> getTheories() {
		return theories;
	}
	public void setTheories(List<Theory> theories) {
		this.theories = theories;
	}
	
	public void addTheory(Theory t) {
		this.theories.add(t);
	}
	
	public HashMap<String, Artifact> getArtifacts() {
		return artifacts;
	}
	
	public void addArtifact(Artifact artifact) {
		this.artifacts.put(artifact.name, artifact);
	}



	public DeductionBoard getPlayerDeductionBoard() {
		return playerDeductionBoard;
	}



	public void setPlayerDeductionBoard(DeductionBoard playerDeductionBoard) {
		this.playerDeductionBoard = playerDeductionBoard;
	}



	// other methods
	public void updatePlayerTurn() {
		this.turnNumber--;
	}

	
	public void updateGoldBalance(int amount) {
		setGoldBalance(goldBalance + amount);
	   
	}
	
	public void updateGoldBalanceforPotion(int amount) {
	    setGoldBalance(getGoldBalance() - amount);
	}
	public void updateReputationPoints(int amount) {
		this.reputationPoints += amount;
	}
	
	
	public AlchemyMarker testOnPlayer(Potion p) {
	    AlchemyMarker alchemyMarker = p.getAlchemyMarker();

		System.out.println(alchemyMarker);
	    if (alchemyMarker.getSign().equals("-")) {
	    	//sicknessLevel ++;
	        setSicknessLevel(getSicknessLevel() + 1);

	        if (getSicknessLevel() != 3) {
	        	if (getGoldBalance() > 0) {
		            updateGoldBalance(-1); // Decrease gold balance by 1
	        		}	       
	        }
	  	  //} else if (alchemyMarker.getSign().equals("+")){
			// ou can use it to decrease your sickness level by 1? How ??

		//if(sicknessLevel == 3) { // sickness level increases to 3, e.g., you get sick 3 times, you lose all of your golds to have surgery and get well.
		//	setGoldBalance(0);
	    }
	  
	
	    return alchemyMarker;
	}
	
	public int getScorePoints() {
		
		int score = 0;
		int goldsFromArtifacts = 0;
		score += reputationPoints * 10;
		
		if (!artifacts.isEmpty()) {
			int artifactNum = artifacts.size();
			goldsFromArtifacts = 2 * artifactNum;
		}
		
		score += (int) goldsFromArtifacts / 3;
		return scorePoints;
	}



	@Override
	public String toString() {
		return "Player [username=" + username + ", token=" + token + ", goldBalance=" + goldBalance + ", turnNumber="
				+ turnNumber + ", ingredientCards=" + ingredientCards + ", sicknessLevel=" + sicknessLevel
				+ ", reputationPoints=" + reputationPoints + ", scorePoints=" + scorePoints + ", potions=" + potions
				+ ", theories=" + theories + ", artifacts=" + artifacts + ", playerDeductionBoard="
				+ playerDeductionBoard + "]";
	}
	
	
	

	
}
