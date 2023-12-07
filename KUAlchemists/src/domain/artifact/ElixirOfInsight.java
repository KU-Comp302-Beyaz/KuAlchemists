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
		System.out.println("The 3 next ingerdient cards are " 
				+ IngredientStorage.getIngredientStorage().getIngredientCards().get(0).getName() + ", " 
				+ IngredientStorage.getIngredientStorage().getIngredientCards().get(1).getName() + ", " 
				+ IngredientStorage.getIngredientStorage().getIngredientCards().get(2).getName());
		// they cannot rearrange the cards just yet
	}
	
	

}
