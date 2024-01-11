package domain.artifact;

import domain.Player;
import domain.ingredients.IngredientStorage;

public class MagicMortar extends Artifact{
	
	public MagicMortar() {
		this.name = "magicmortar";
		this.usage = "one-time";
		// TODO Auto-generated constructor stub
	}

	public MagicMortar(String name, String usage) {
		super(name, usage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isConditionSatisfied() {
		// TODO Auto-generated method stub
		return false; //this card needs to be activated in order to be used
	}

	@Override
	public void applyEffect(Player player) {
		// TODO Auto-generated method stub
		// they cannot rearrange the cards just yet
	}
	
	public String message(Player player) {
		return "";
	}
	

}
