package ui;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import domain.Player;
import domain.ingredients.Ingredient;


public class PlayerIngredientList {
	
	private final int IMAGE_WIDTH = 140, IMAGE_HEIGHT = 140;
	
	private HashMap<JLabel, Ingredient> playerIngredientJListLabels = new HashMap<JLabel, Ingredient>();
	private ArrayList<JPanel> playerIngredientJListPanels = new ArrayList<JPanel>();
	
	/**
	 * Creates the array of player ingredient cards
	 * @param player
	 * @return Jpanel array of player ingredients to be put into JList
	 */
	public JPanel[] createIngredientArray(Player player) {
		JLabel label;
		JPanel panel;
		setIngredientCardPanels(new ArrayList<JPanel>(0));
		
		for (Ingredient ingredient : player.getIngredientCards()) {
			label = new JLabel(ingredient.getName(), getImage(ingredient), JLabel.LEFT);
			label.setHorizontalTextPosition(JLabel.CENTER);
			label.setVerticalTextPosition(JLabel.BOTTOM);
			
			panel = new JPanel();
			panel.add(label);
			
			getIngredientCardLabels().put(label, ingredient);
			getIngredientCardPanels().add(panel);
		}

		JPanel[] ingredientCardPanelsArray = getIngredientCardPanels().toArray(new JPanel[getIngredientCardPanels().size()]);
		return ingredientCardPanelsArray;
	}
	

	/**
	 * Gets image from the images folder in src and scales it to the wanted pixels
	 * @param ingredient to access image path
	 * @return imageicon of the ingredient
	 */
	public ImageIcon getImage(Ingredient ingredient) {
		return new ImageIcon(new ImageIcon(ingredient.getPhoto()).getImage()
					.getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_SMOOTH));
	}
	
	//getter setters
	public HashMap<JLabel, Ingredient> getIngredientCardLabels() {
		return this.playerIngredientJListLabels;
	}

	public ArrayList<JPanel> getIngredientCardPanels() {
		return this.playerIngredientJListPanels;
	}

	public void setIngredientCardPanels(ArrayList<JPanel> ingredientCardPanels) {
		this.playerIngredientJListPanels = ingredientCardPanels;
	}


}
