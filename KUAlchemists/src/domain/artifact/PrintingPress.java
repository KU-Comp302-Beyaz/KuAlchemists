package domain.artifact;

import domain.Player;

public class PrintingPress extends Artifact {
	
	private boolean active;

	public PrintingPress() {
		this.name = "printingpress";
		this.usage = "one-time";
		this.active = false;
	}
	
	public void setActive(boolean b) {
		this.active = b;
	}
	@Override
	public boolean isConditionSatisfied() {
		// TODO Auto-generated method stub
		return this.active; //this artifact needs to me activated in order to be used
	}

	@Override
	public void applyEffect(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String message(Player player) {
		// TODO Auto-generated method stub
		return "Added Printing Press to artifact storage";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Printing Press:\n\nUse Type: Immidiate\n\nThis artifact allows the player to publish a theory free of charge";
	}

	@Override
	public String getImagePath() {
		// TODO Auto-generated method stub
		return "/images/artifacts/printingpress.jpg";
	}

}
