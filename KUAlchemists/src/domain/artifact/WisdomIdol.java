package domain.artifact;

import domain.Player;

public class WisdomIdol extends Artifact {

	public WisdomIdol() {
		this.name = "wisdomidol";
		this.usage = "one-time";
	}
	@Override
	public boolean isConditionSatisfied() {
		// TODO Auto-generated method stub
		return false; //this artifact needs to be activated to be used
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
