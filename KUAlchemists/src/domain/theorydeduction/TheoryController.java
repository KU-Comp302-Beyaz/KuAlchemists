package domain.theorydeduction;

import domain.Player;
import domain.ingredients.Alchemical;
import domain.ingredients.Ingredient;
import domain.publication.PublicationCard;
import domain.publication.PublicationTrack;


public class TheoryController {
	
	private static TheoryController TheoryControllerInstance;
	private Player currPlayer;
	private PublicationTrack pt = PublicationTrack.getInstance();

	
	
	
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
			this.currPlayer.updateGoldBalance(-1);
			this.currPlayer.updateReputationPoints(2);
		}
		return result;
	}
	
	public boolean initClaimCard(PublicationCard card) {
		
		boolean result = pt.claimCard(currPlayer.getTheories(), card);
		if (result) {
			this.currPlayer.updateGoldBalance(card.getGoldReward());
			this.currPlayer.updateReputationPoints(card.getReputationReward());
			card.setRewardClaimer(currPlayer);
		}
		return result;
		
	}
	
	
}
