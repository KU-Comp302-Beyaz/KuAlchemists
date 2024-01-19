package domain.artifact;

import domain.Player;

public class WisdomIdol extends Artifact {
	
	private boolean active;

	public WisdomIdol() {
		this.name = "wisdomidol";
		this.usage = "one-time";
		this.active = false;
	}
	
	public void setActive(boolean b) {
		this.active = b;
	}
	
	@Override
	public boolean isConditionSatisfied() {
		// TODO Auto-generated method stub
		return this.active; //this artifact needs to be activated to be used
	}

	@Override
	public void applyEffect(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String message(Player player) {
		// TODO Auto-generated method stub
		return "Added Wisdom Idol to artifact storage";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "WisdomIdol\n\nUse Type: One-Time\n\nWhen used this artifact will let the player keep their reputation points when their theory is debunked.\nCan be bought once per turn.";
	}

	@Override
	public String getImagePath() {
		// TODO Auto-generated method stub
		return "/images/artifacts/wisdomidol.jpg";
	}

}
