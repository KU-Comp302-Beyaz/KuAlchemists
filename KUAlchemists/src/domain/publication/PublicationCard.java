package domain.publication;

import java.util.ArrayList;

import domain.Player;
import domain.ingredients.Ingredient;

public class PublicationCard {
	
	private ArrayList<Ingredient> requiredTheories = new ArrayList<>();
	private int reputationReward;
	private int goldReward;
	private Player rewardClaimer;

	public PublicationCard(ArrayList<Ingredient> requiredTheories, int reputationReward, int goldReward) {

		this.requiredTheories = requiredTheories;
		this.reputationReward = reputationReward;
		this.goldReward = goldReward;
		this.rewardClaimer = null;
	}

	public ArrayList<Ingredient> getRequiredTheories() {
		return requiredTheories;
	}

	public void setRequiredTheories(ArrayList<Ingredient> requiredTheories) {
		this.requiredTheories = requiredTheories;
	}

	public int getReputationReward() {
		return reputationReward;
	}

	public void setReputationReward(int reputationReward) {
		this.reputationReward = reputationReward;
	}

	public int getGoldReward() {
		return goldReward;
	}

	public void setGoldReward(int goldReward) {
		this.goldReward = goldReward;
	}
	
	public boolean isClaimed() {
		
		return this.rewardClaimer != null;
		
	}
	
	public Player getRewardClaimer() {
		return rewardClaimer;
	}

	public void setRewardClaimer(Player rewardClaimer) {
		this.rewardClaimer = rewardClaimer;
	}
	
	

}
