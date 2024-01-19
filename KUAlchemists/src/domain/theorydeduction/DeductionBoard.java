package domain.theorydeduction;

import java.util.ArrayList;
import java.util.List;

import domain.Player;
import domain.ingredients.Alchemical;
import domain.ingredients.Ingredient;
import domain.ingredients.IngredientStorage;
import domain.publication.PublicationTrack;

public class DeductionBoard {
	
	private boolean[] deductionGrid;
	private Player owner;
	private String[][] deductionTriangle;
	
	public DeductionBoard(Player owner) {

		this.deductionGrid = new boolean[64];
		this.owner = owner;
		this.deductionTriangle = new String[8][8];
		
	}

	public boolean[] getDeductionGrid() {
		return deductionGrid;
	}

	public void setDeductionGrid(boolean[] deductionGrid) {
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

	public static Ingredient findIngredientFromPhoto(String path) {
    	
    	for (Ingredient i : IngredientStorage.getInstance().getAllingredientcardsarray()) {
    		if (i.getPhoto().equals(path)) {
    			return i;
    		}
    	}
    	return null;
    }
    
    public static Alchemical findAlchemicalFromPhoto(String path) {
    	
    	for (Alchemical a : PublicationTrack.getInstance().getAvailableAlchemicals()) {
    		if (a.getAlchemicalPhoto().equals(path))
    			return a;
    	}
    	return null;
    	
    }
	
    public static ArrayList<String> getIngredientPhotoPaths() {
    	
    	ArrayList<String> photoPaths = new ArrayList<>();
    	for (Ingredient i : PublicationTrack.getInstance().getAvailableIngredients()) {
    		photoPaths.add(i.getPhoto());
    	}
    	return photoPaths;
    }
	
    public static ArrayList<String> getAlchemicalPhotoPaths() {
    	
    	ArrayList<String> photoPaths = new ArrayList<>();
    	for (Alchemical i : PublicationTrack.getInstance().getAvailableAlchemicals()) {
    		photoPaths.add(i.getAlchemicalPhoto());
    	}
    	return photoPaths;
    }
	
	
}
