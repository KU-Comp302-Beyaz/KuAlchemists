package domain.theorydeduction;

import domain.Player;
import domain.ingredients.Alchemical;
import domain.ingredients.Ingredient;

public class Theory {

	private Player owner;
	private Alchemical alchemical;
	private Ingredient ingredientType;
	
	public Theory (Player p, Alchemical a, Ingredient ingredientType) {
		
		this.owner = p;
		this.alchemical = a;
		this.ingredientType = ingredientType;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public Alchemical getAlchemical() {
		return alchemical;
	}

	public void setAlchemical(Alchemical alchemical) {
		this.alchemical = alchemical;
	}

	public Ingredient getIngredientType() {
		return ingredientType;
	}

	public void setIngredientType(Ingredient ingredientType) {
		this.ingredientType = ingredientType;
	}
	
	
	
}
