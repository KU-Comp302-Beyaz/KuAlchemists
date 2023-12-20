package domain.artifact;

import domain.Player;
import domain.ingredients.IngredientStorage;

public class ElixirOfInsight extends Artifact{

	
	
	public ElixirOfInsight() {
		this.name = "elixirofinsight";
		this.usage = "immidiate";
		// TODO Auto-generated constructor stub
	}

	public ElixirOfInsight(String name, String usage) {
		super(name, usage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isConditionSatisfied() {
		// TODO Auto-generated method stub
		return true; //this card needs no special precondition to function
	}

	@Override
	public void applyEffect(Player player) {
		// TODO Auto-generated method stub
		// they cannot rearrange the cards just yet
	}
	
	public String message(Player player) {
		return "The 3 next ingerdient cards are " 
				+ IngredientStorage.getInstance().getIngredientCards().get(0).getName() + ", " 
				+ IngredientStorage.getInstance().getIngredientCards().get(1).getName() + ", " 
				+ IngredientStorage.getInstance().getIngredientCards().get(2).getName() ;
	}
	

}
