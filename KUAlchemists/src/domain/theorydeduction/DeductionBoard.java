package domain.theorydeduction;

import domain.Player;
import domain.ingredients.Alchemical;
import domain.ingredients.Ingredient;
import domain.publication.PublicationTrack;

public class DeductionBoard {
	
	private boolean[][] deductionGrid;
	private Player owner;
	private String[][] deductionTriangle;
	
	public DeductionBoard(Player owner) {

		this.deductionGrid = new boolean[8][8];
		this.owner = owner;
		this.deductionTriangle = new String[8][8];
		
	}

	public boolean[][] getDeductionGrid() {
		return deductionGrid;
	}

	public void setDeductionGrid(boolean[][] deductionGrid) {
		this.deductionGrid = deductionGrid;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public String[][] getDeductionTriangle() {
		return deductionTriangle;
	}

	public void setDeductionTriangle(String[][] deductionTriangle) {
		this.deductionTriangle = deductionTriangle;
	}
	
	public boolean publishTheory(Alchemical alchemical, Ingredient ingredientType) {
		
		PublicationTrack pt = PublicationTrack.getInstance();
		if (this.owner.getGoldBalance() < 1)
			return false;	
		Theory t = new Theory(this.owner, alchemical, ingredientType);
		pt.addTheory(t);
		pt.getAvailableAlchemicals().remove(alchemical);
		pt.getAvailableIngredients().remove(ingredientType);
		this.owner.addTheory(t);
		return true;
	}

	
	
	
	
	
	
}
