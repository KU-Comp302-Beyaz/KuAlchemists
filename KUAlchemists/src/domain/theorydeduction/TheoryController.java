package domain.theorydeduction;

import domain.Game;
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
			
			///// Add action and player to history
			/*
			Game.getGame().getActionHistory().add("Publish Theory\n"
					+ "-1 Gold Balance: " + currPlayer.getGoldBalance()
					+ "\n+2 Reputation Point: " + currPlayer.getReputationPoints());
			Game.getGame().getPlayerTurnHistory().add(currPlayer);
			*/
			
			Game.getGame().updateHistory("Publish Theory\n"
					+ "-1 Gold Balance: " + currPlayer.getGoldBalance()
					+ "\n+2 Reputation Point: " + currPlayer.getReputationPoints(), currPlayer);
	
			
		}
		return result;
	}
	
	public boolean initClaimCard(PublicationCard card) {
		
		if (card == null) {
			return false;
		}
		
		boolean result = pt.claimCard(currPlayer.getTheories(), card);
		if (result) {
			this.currPlayer.updateGoldBalance(card.getGoldReward());
			this.currPlayer.updateReputationPoints(card.getReputationReward());
			card.setRewardClaimer(currPlayer);
			
			///// Add action and player to history
			/*
			Game.getGame().getActionHistory().add("Claim Card\n"
							+ "+" + card.getGoldReward() + " Gold Balance: " + currPlayer.getGoldBalance()
							+ "\n+" + card.getReputationReward() + " Reputation Point: " + currPlayer.getReputationPoints());
			Game.getGame().getPlayerTurnHistory().add(currPlayer);
			*/
			
			Game.getGame().updateHistory("Claim Card\n"
					+ "+" + card.getGoldReward() + " Gold Balance: " + currPlayer.getGoldBalance()
					+ "\n+" + card.getReputationReward() + " Reputation Point: " + currPlayer.getReputationPoints(), currPlayer);
		}
		return result;
		
	}
	
	public boolean initDebunkTheory(Theory theory, AlchemyMarker selectedAlchemyMarker) {
		
		if(theory==null||selectedAlchemyMarker==null)
			return false;
		boolean debunkResult = pt.debunkTheory(theory,selectedAlchemyMarker);
		
		/// action history
		String history = "Debunk Theory\n";
		
		if (debunkResult) {
			Player theoryOwner = theory.getOwner();
			theoryOwner.getTheories().remove(theory);
			pt.getPublishedTheories().remove(theory);
			theoryOwner.updateReputationPoints(-2);
			currPlayer.updateReputationPoints(2);
			
			/// update action history
			history += "Theory Owner " + theoryOwner.getUsername() + " -1 Theories: " + theoryOwner.getTheories().size() + " -2 Reputation Point: " + theoryOwner.getReputationPoints()
					+ " +2 Reputation Point: " + currPlayer.getReputationPoints();
		}
		else {
			currPlayer.updateReputationPoints(-1);
			
			/// update action history
			history += "-1 Reputation Point: " + currPlayer.getReputationPoints();
		}
		
		///// Add action and player to history
		/*
		Game.getGame().getActionHistory().add(history);
		Game.getGame().getPlayerTurnHistory().add(currPlayer);
		*/
		
		Game.getGame().updateHistory(history, currPlayer);

		return debunkResult;
	}
	
	
}
