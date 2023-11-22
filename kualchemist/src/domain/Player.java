package domain;

import java.util.ArrayList;
import java.util.List;

import ingredients.Ingredient;
import potion.Potion;
import theorydeduction.Theory;

public class Player {

	private String username;
	private Token token;
	private int goldBalance; 
	private int turnNumber;
	private List<Ingredient> ingredientCards = new ArrayList<Ingredient>(); 
	// private Artifact[] artifactCards;
	private int sicknessLevel;
	private int reputationPoints;
	private int scorePoints;
	private List<Potion> potions = new ArrayList<Potion>();
	private List<Theory> theories = new ArrayList<Theory>();

	
	// constructor
	public Player (String username, Token token) {
		
		this.username = username;
		this.token = token;
		this.goldBalance = 10; //?
		this.turnNumber = 3; // azalacak şekilde güncellenir
		this.sicknessLevel = 0;
		this.reputationPoints = 0;
		this.scorePoints = 0;
		
	}
	
	
	
	// getter - setter
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public Token getToken() {
		return token;
	}
	public void setToken(Token token) {
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

	public int getScorePoints() {
		return scorePoints;
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



	// other methods
	public int updatePlayerTurn() { // boolean mı dönsün? eğer 3e ulaşırsa false döner ve diğer oyuncuya veya etaba geçilir?
		this.turnNumber ++;
		return turnNumber;
	}
	
	public void updateGoldBalance(int amount) {
		setGoldBalance(goldBalance + amount);
	}
	
	public AlchemyMarker testOnPlayer(Potion p) {
		//////
		
		AlchemyMarker a = null;
		return a;
	}
}
