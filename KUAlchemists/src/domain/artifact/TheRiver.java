package domain.artifact;

import domain.Player;


public class TheRiver extends Artifact {

	public TheRiver() {
		this.name = "theriver";
		this.usage = "immidiate";
		this.lastUsed = 0;
		
		// TODO Auto-generated constructor stub
	}
	
	public boolean isConditionSatisfied() {
		return true; //this artifact requires no special condition
		
	}
	
	public void applyEffect(Player player) {		
            player.setTurnNumber(player.getTurnNumber() + 2);
            System.out.println("The player now has " + player.getTurnNumber() + " turns left");
        
		
		
	}


	
	

	
	

}