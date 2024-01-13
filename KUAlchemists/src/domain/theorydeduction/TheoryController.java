package domain.theorydeduction;

import domain.Player;
import domain.ingredients.Alchemical;
import domain.ingredients.Ingredient;


public class TheoryController {
	
	private static TheoryController TheoryControllerInstance;
	private Player currPlayer;
	
	
	
	public static synchronized TheoryController getInstance() {
		if (TheoryControllerInstance == null)
			TheoryControllerInstance = new TheoryController();
		return TheoryControllerInstance;
	}
	
	
	
	public Player getCurrPlayer() {
		return currPlayer;
	}

	public void setCurrPlayer(Player currPlayer) {
		this.currPlayer = currPlayer;
	}



	public boolean initPublishTheory(Alchemical alchemical, Ingredient ingretientType) {
		
		// if game round < 2 ise ...
		
		boolean result = currPlayer.getPlayerDeductionBoard().publishTheory(alchemical, ingretientType);
		if (result) {
			if (currPlayer.getArtifacts().containsKey("printingpress") && currPlayer.getArtifacts().get("printingpress").isConditionSatisfied() == true) {
				//this.currPlayer.updateGoldBalance(-1);
				this.currPlayer.updateReputationPoints(2);
			}
			else {
				this.currPlayer.updateGoldBalance(-1);
				this.currPlayer.updateReputationPoints(2);
			}
		}
		return result;
	}
	
	
}
