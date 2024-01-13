package domain.artifact;

import domain.Player;

public class PrintingPress extends Artifact {

	public PrintingPress() {
		this.name = "printingpress";
		this.usage = "one-time";
	}
	@Override
	public boolean isConditionSatisfied() {
		// TODO Auto-generated method stub
		return false; //this artifact needs to me activated in order to be used
	}

	@Override
	public void applyEffect(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String message(Player player) {
		// TODO Auto-generated method stub
		return null;
	}

}
