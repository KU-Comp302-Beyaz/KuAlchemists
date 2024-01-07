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
	
	/* REQUIRES: alchemical is not null, ingredient is not null.
	 * MODIFIES: PublicationTrack.availableAlchemicals, PulicationTrack.availableIngredients, PublicationTrack.publishedTheories, currPlayer.theories
	 * EFFECTS: A new theory is created from the alchemical and ingredient and added to the publication track's published theories
	 * 			and current player's published theories. Used alchemical and ingredient are removed from publication tracks
	 * 	        available alchemicals and available ingredients.
	*/
	public boolean publishTheory(Alchemical alchemical, Ingredient ingredientType) {
		
		PublicationTrack pt = PublicationTrack.getInstance();
		if (alchemical == null)
			return false;
		else if (ingredientType == null)
			return false;
		else if (pt.getAlchemical(alchemical) == null)
			return false;
		else if (pt.getIngredient(ingredientType) == null)
			return false;
		else if (this.owner.getGoldBalance() < 1)
			return false;
		else {
			Theory t = new Theory(this.owner, alchemical, ingredientType);
			pt.addTheory(t);
			pt.getAvailableAlchemicals().remove(pt.getAlchemical(alchemical));
			pt.getAvailableIngredients().remove(pt.getIngredient(ingredientType));
			this.owner.addTheory(t);
			return true;
		}
		
	}

	
	
	
	
	
	
}
