package domain;

import ingredients.Ingredient;
import potion.Potion;
import theorydeduction.AlchemyMarker;
import theorydeduction.Theory;

public class Player {

	private String username;
	private Token token;
	private int goldBalance; 
	private int turnNumber;
	private Ingredient[] ingredientCards;
	// private Artifact[] artifactCards;
	private int sicknessLevel;
	private int reputationPoints;
	private int scorePoints;
	private Potion[] potions;
	private Theory[] theories;
	private AlchemyMarker alchemyMarker; // ??? array?
	// ingredientType: IngredientType

	
	// constructor
	public Player (String username, Token token) {
		
		this.username = username;
		this.token = token;
		this.goldBalance = 0; //?
		this.turnNumber = 0; //?
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

	public Ingredient[] getIngredientCards() {
		return ingredientCards;
	}
	public void setIngredientCards(Ingredient[] ingredientCards) {
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

	public Potion[] getPotions() {
		return potions;
	}
	public void setPotions(Potion[] potions) {
		this.potions = potions;
	}

	public Theory[] getTheories() {
		return theories;
	}
	public void setTheories(Theory[] theories) {
		this.theories = theories;
	}

	public AlchemyMarker getAlchemyMarker() {
		return alchemyMarker;
	}
	public void setAlchemyMarker(AlchemyMarker alchemyMarker) {
		this.alchemyMarker = alchemyMarker;
	}


	// other methods
	public void updatePlayerTurn() { // boolean mı dönsün? eğer 3e ulaşırsa false döner ve diğer oyuncuya veya etaba geçilir?
		this.turnNumber ++;
	}
	
	public void updateGoldBalance(int amount) {
		setGoldBalance(goldBalance + amount);
	}
}
