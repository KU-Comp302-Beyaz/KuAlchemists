package domain.artifact;

import domain.Player;
import domain.ingredients.IngredientStorage;

public class MagicMortar extends Artifact{
	
	private boolean active;
	
	public MagicMortar() {
		this.name = "magicmortar";
		this.usage = "one-time";
		this.active = false;
		// TODO Auto-generated constructor stub
	}

	public MagicMortar(String name, String usage) {
		super(name, usage);
		// TODO Auto-generated constructor stub
	}
	
	public void setActive(boolean b) {
		this.active = b;
	}

	@Override
	public boolean isConditionSatisfied() {
		// TODO Auto-generated method stub
		return this.active; //this card needs to be activated in order to be used
	}

	@Override
	public void applyEffect(Player player) {
		// TODO Auto-generated method stub
		// they cannot rearrange the cards just yet
	}
	
	public String message(Player player) {
		return "Added Magic Mortar to artifact storage";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Magic Mortar:\n\nUse Type: Immidiate\n\nThis artifact allows the player to make a potion while saving the first ingredient they have used";
	}

	@Override
	public String getImagePath() {
		// TODO Auto-generated method stub
		return "/images/artifacts/magicmortar.png";
	}
	

}
