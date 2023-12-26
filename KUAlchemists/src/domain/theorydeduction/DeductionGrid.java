package domain.theorydeduction;

public class DeductionGrid {
	
	private DeductionBoard board;
	private boolean[][] markedSpaces;
	
	

	public DeductionGrid(DeductionBoard board, boolean[][] markedSpaces) {
		this.board = board;
		this.markedSpaces = markedSpaces;
	}

	public boolean[][] getMarkedSpaces() {
		return markedSpaces;
	}

	public void setMarkedSpaces(boolean[][] markedSpaces) {
		this.markedSpaces = markedSpaces;
	}

	public DeductionBoard getBoard() {
		return board;
	}

	public void setBoard(DeductionBoard board) {
		this.board = board;
	}
	
	
	
	
	

}
