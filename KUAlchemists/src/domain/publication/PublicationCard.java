package domain.publication;

import java.util.ArrayList;

import domain.Player;
import domain.theorydeduction.Theory;

public class PublicationCard {
	
	private ArrayList<Theory> requiredTheories;
	
	private int reputationReward;
	
	private int goldReward;
	
	private Player rewardClaimer;

	public PublicationCard(ArrayList<Theory> requiredTheories, int reputationReward, int goldReward) {

		this.requiredTheories = requiredTheories;
		this.reputationReward = reputationReward;
		this.goldReward = goldReward;
		this.rewardClaimer = null;
	}

	public ArrayList<Theory> getRequiredTheories() {
		return requiredTheories;
	}

	public void setRequiredTheories(ArrayList<Theory> requiredTheories) {
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
		
		return this.rewardClaimer == null;
		
	}
	

}
