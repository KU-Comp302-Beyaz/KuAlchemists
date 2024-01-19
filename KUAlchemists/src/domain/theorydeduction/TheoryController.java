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

	
	public enum TCReturnMessage {
		
		EMPTY_MESSAGE,
		NULL_ERROR,
		SUCCESS_PUBLISH,
		SUCCESS_CARD,
		SUCCESS_DEBUNK_DONE,
		SUCCESS_DEBUNK_FAILED,
		ROUND_ERROR_SECOND,
		ROUND_ERROR_FINAL,
		GOLD_ERROR,
		TURN_ERROR,
		NOT_ENOUGH_ALCHEMY_MARKERS_ERROR,
		NO_SUFFICENT_THEORIES_ERROR,
		CARD_ALREADY_CLAIMED_ERROR,
		SELF_DEBUNK_ERROR
	}
	
	
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

	public TCReturnMessage checkRoundAndTurnForPublish() {
		if (Game.getGame().getGameRound() < 2)
			return TCReturnMessage.ROUND_ERROR_SECOND;
		else if (currPlayer.getTurnNumber() < 1)
			return TCReturnMessage.TURN_ERROR;
		else
			return TCReturnMessage.EMPTY_MESSAGE;
	}

	public TCReturnMessage initPublishTheory(Alchemical alchemical, Ingredient ingredientType) {
		
		if (alchemical == null || ingredientType == null)
			return TCReturnMessage.NULL_ERROR;
		boolean result = currPlayer.getPlayerDeductionBoard().publishTheory(alchemical, ingredientType);
		if (result) {
			if (currPlayer.getActivatedArtifacts().contains("printingpress")) {
				//this.currPlayer.updateGoldBalance(-1);
				this.currPlayer.updateReputationPoints(2);
				//currPlayer.removeActivatedArtifact("printingpress");
        this.currPlayer.updatePlayerTurn();
			}
			
			else {
				this.currPlayer.updateGoldBalance(-1);
				this.currPlayer.updateReputationPoints(2);
        this.currPlayer.updatePlayerTurn();
			}

			

			///// Add action and player to history
			/*
			Game.getGame().getActionHistory().add("Publish Theory\n"
					+ "-1 Gold Balance: " + currPlayer.getGoldBalance()
					+ "\n+2 Reputation Point: " + currPlayer.getReputationPoints());
			Game.getGame().getPlayerTurnHistory().add(currPlayer);
			*/
			

			if (currPlayer.getActivatedArtifacts().contains("printingpress")) {
				Game.getGame().updateHistory("Publish Theory\n"
					+ "Gold Balance unchanged (Printing Press): " + currPlayer.getGoldBalance()
					+ "\n+2 Reputation Point: " + currPlayer.getReputationPoints(), currPlayer);
				// removes the artifact from the usable artifacts of the user
				currPlayer.removeActivatedArtifact("printingpress");
        return TCReturnMessage.SUCCESS_PUBLISH;
			}
			
			else {
				Game.getGame().updateHistory("Publish Theory\n"
						+ "-1 Gold Balance: " + currPlayer.getGoldBalance()
						+ "\n+2 Reputation Point: " + currPlayer.getReputationPoints(), currPlayer);
        return TCReturnMessage.SUCCESS_PUBLISH;
			}
		}
		else {
			return TCReturnMessage.GOLD_ERROR;
		}
		
	}
	
	public TCReturnMessage checkAvailableAlchemicals() {
		if (pt.getPublishedTheories().size()>7)
			return TCReturnMessage.NOT_ENOUGH_ALCHEMY_MARKERS_ERROR;
		return TCReturnMessage.EMPTY_MESSAGE;
	}
	
	
	public TCReturnMessage initClaimCard(PublicationCard card) {
		
		if (card == null) {
			return TCReturnMessage.NULL_ERROR;
		}
		else if (card.isClaimed())
			return TCReturnMessage.CARD_ALREADY_CLAIMED_ERROR;
		else if (currPlayer.getTurnNumber() < 1)
			return TCReturnMessage.TURN_ERROR;
		boolean result = pt.claimCard(currPlayer.getTheories(), card);
		if (result) {
			this.currPlayer.updateGoldBalance(card.getGoldReward());
			this.currPlayer.updateReputationPoints(card.getReputationReward());
			card.setRewardClaimer(currPlayer);
			this.currPlayer.updatePlayerTurn();
			
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
			return TCReturnMessage.SUCCESS_CARD;
		}
		else 
			return TCReturnMessage.NO_SUFFICENT_THEORIES_ERROR;
		
		
		
	}
	
	public TCReturnMessage initDebunkTheory(Theory theory, AlchemyMarker selectedAlchemyMarker) {
		
		if(theory==null||selectedAlchemyMarker==null)
			return TCReturnMessage.NULL_ERROR;
		boolean debunkResult = pt.debunkTheory(theory,selectedAlchemyMarker);
		/// action history
		String history = "Debunk Theory\n";
		
		if (debunkResult) {
			
			Player theoryOwner = theory.getOwner();
			theoryOwner.getTheories().remove(theory);
			pt.getPublishedTheories().remove(theory);
			pt.getAvailableAlchemicals().add(theory.getAlchemical());
			pt.getAvailableIngredients().add(theory.getIngredientType());
			if (theoryOwner.getActivatedArtifacts().contains("wisdomidol")) {
			//theoryOwner.updateReputationPoints(-2);
				//theoryOwner.removeActivatedArtifact("wisdomidol");
			}
			else {
				theoryOwner.updateReputationPoints(-2);
			}
			currPlayer.updateReputationPoints(2);
			currPlayer.updatePlayerTurn();
			/// update action history
			
			if(theoryOwner.getActivatedArtifacts().contains("wisdomidol")) {
				history += "Theory Owner " + theoryOwner.getUsername() + " -1 Theories: " + theoryOwner.getTheories().size() + " Reputation Point unchanged (wisdom idol): " + theoryOwner.getReputationPoints()
				+ " +2 Reputation Point: " + currPlayer.getReputationPoints();
				
				theoryOwner.removeActivatedArtifact("wisdomidol");
				
			}
			
			else {
				history += "Theory Owner " + theoryOwner.getUsername() + " -1 Theories: " + theoryOwner.getTheories().size() + " -2 Reputation Point: " + theoryOwner.getReputationPoints()
				+ " +2 Reputation Point: " + currPlayer.getReputationPoints();
			}

			Game.getGame().updateHistory(history, currPlayer);
			return TCReturnMessage.SUCCESS_DEBUNK_DONE;
			

		}
		else {
			currPlayer.updateReputationPoints(-1);
			currPlayer.updatePlayerTurn();
			/// update action history
			history += "-1 Reputation Point: " + currPlayer.getReputationPoints();
			Game.getGame().updateHistory(history, currPlayer);
			return TCReturnMessage.SUCCESS_DEBUNK_FAILED;
		}
		///// Add action and player to history
		/*
		Game.getGame().getActionHistory().add(history);
		Game.getGame().getPlayerTurnHistory().add(currPlayer);
		*/
	}
	
	public TCReturnMessage checkRoundAndTurnForDebunk() {
		if (Game.getGame().getGameRound() < 3)
			return TCReturnMessage.ROUND_ERROR_FINAL;
		else if (currPlayer.getTurnNumber() < 1)
			return TCReturnMessage.TURN_ERROR;
		else
			return TCReturnMessage.EMPTY_MESSAGE;
	}
	
	public TCReturnMessage lookTheoryOwner(Theory t) {
		if (t.getOwner().equals(currPlayer))
			return TCReturnMessage.SELF_DEBUNK_ERROR;
		else
			return TCReturnMessage.EMPTY_MESSAGE;
	}
	
	
	
	
	
}
