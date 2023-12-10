package domain.theorydeduction;

import domain.Player;

public class DeductionBoard {
	
	private DeductionGrid deductionGrid;
	private Player owner;
	private boolean[][] deductionTriangle;
	
	public DeductionBoard(DeductionGrid deductionGrid, Player owner, boolean[][] deductionTriangle) {

		this.deductionGrid = deductionGrid;
		this.owner = owner;
		this.deductionTriangle = deductionTriangle;
	}

	public DeductionGrid getDeductionGrid() {
		return deductionGrid;
	}

	public void setDeductionGrid(DeductionGrid deductionGrid) {
		this.deductionGrid = deductionGrid;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public boolean[][] getDeductionTriangle() {
		return deductionTriangle;
	}

	public void setDeductionTriangle(boolean[][] deductionTriangle) {
		this.deductionTriangle = deductionTriangle;
	}
	
	

	
	
	
	
	
	
}
