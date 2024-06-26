package domain.artifact;
import domain.Player;

public abstract class Artifact {
	
	public String name;
	
	public String usage;
	
	public int lastUsed;
	
	public Artifact() {
		
	}
	
	public Artifact(String name, String usage) {
		this.name = name;
		this.usage = usage;
		this.lastUsed = 0;
	}



	public abstract void setActive(boolean b);
	
	public abstract boolean isConditionSatisfied();
	
	
	public abstract void applyEffect(Player player);
	
	public abstract String message(Player player);

	public String getName() {
		return name;
	}

	
	
	public abstract String getDescription();
	
	public abstract String getImagePath();
	

}
