package domain.artifact;

import domain.Player;


public class TheRiver extends Artifact {

	public TheRiver() {
		this.name = "theriver";
		this.usage = "immidiate";
		
		
		// TODO Auto-generated constructor stub
	}
	
	public boolean isConditionSatisfied() {
		return true; //this artifact requires no special condition
		
	}
	
	public void applyEffect(Player player) {		
            player.setTurnNumber(player.getTurnNumber() + 3); //as all artifacts need 1 turn point to buy we counter the effect by adding 1 extra than intended
            System.out.println("The player now has " + player.getTurnNumber() + " turns left");
        
		
		
	}
	
	public String message(Player player) {
		return "The player now has " + player.getTurnNumber() + " turns left" ;
	}


	
	

	
	

}
