package domain.ingredients;

public class IngredientController {
	
	private static IngredientController ingredientControllerSingleton = new IngredientController();
	
	private IngredientController() {
		
	}
	
	public static IngredientController getIngredientController() {
		return ingredientControllerSingleton;
	}
	
	public Ingredient addIngredientToPlayer() {
		Ingredient ingredientCard = null;
		//not implemented yet
		return ingredientCard;
	}
	
	public void transmuteIngredient() {
		//not implemented yet
	}



	
	

}
