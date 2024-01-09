package ui;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;


import domain.Player;
import domain.ingredients.Ingredient;


public class PlayerIngredientList {
	
	private final static int IMAGE_WIDTH = 140;

	private static final int IMAGE_HEIGHT = 140;

	
	private static HashMap<JLabel, Ingredient> playerIngredientJListLabels = new HashMap<JLabel, Ingredient>();
	private static ArrayList<JPanel> playerIngredientJListPanels = new ArrayList<JPanel>();
	
	/**
	 * Creates the array of player ingredient cards
	 * @param player
	 * @return Jpanel array of player ingredients to be put into JList
	 */
	public static JPanel[] createIngredientArray(Player player) {
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
	 * Initialize UI, player cards are updated every time this is called (every button click)
	 * @param player
	 */
	public static void initialize(Player player) {
		
		//ingredientList in to be put in the Scroll pane

		JList<JPanel> ingredientList = PotionBrewingAreaDisplay.getInstance().getIngredientList();
			

		JPanel[] ingredientCardPanelsArray = createIngredientArray(player);
		ingredientList.setListData(ingredientCardPanelsArray);
		ingredientList.setLayoutOrientation(JList.VERTICAL_WRAP);
		ingredientList.setFixedCellHeight(IMAGE_HEIGHT+50);
		ingredientList.setFixedCellWidth(IMAGE_WIDTH);
		
		int boxWidth = 900; //ingredientScrollPane.getViewport().getSize().width;
		int numberOfImagesInRow = boxWidth/IMAGE_WIDTH;
		ingredientList.setVisibleRowCount((player.getIngredientCards().size()+numberOfImagesInRow-1)/numberOfImagesInRow);
		ingredientList.setSelectedIndex(0);

		PotionBrewingAreaDisplay.getInstance().getScrollPane_ingredients().setViewportView(ingredientList);
	}
	
	/**
	 * Gets image from the images folder in src and scales it to the wanted pixels
	 * @param ingredient to access image path
	 * @return imageicon of the ingredient
	 */
	public static ImageIcon getImage(Ingredient ingredient) {
		return new ImageIcon(new ImageIcon(ingredient.getPhoto()).getImage()
					.getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_SMOOTH));
	}
	
	//getter setters
	public static HashMap<JLabel, Ingredient> getIngredientCardLabels() {
		return playerIngredientJListLabels;

	}

	public static ArrayList<JPanel> getIngredientCardPanels() {
		return playerIngredientJListPanels;
	}

	public static void setIngredientCardPanels(ArrayList<JPanel> ingredientCardPanels) {
		playerIngredientJListPanels = ingredientCardPanels;
	}


	
	/*
	public static Ingredient[] getChosenIngredients(JList<JPanel> lst) {
		
        int[] selectedIndices = lst.getSelectedIndices();
        ArrayList<Ingredient> selectedIngredients = new ArrayList<>();
        
	}
	*/
	public static Ingredient getChosenIngredient(JList<JPanel> lst) {
		JLabel label = (JLabel) lst.getSelectedValue().getComponent(0);
		return getIngredientCardLabels().get(label);
	}
	
	
	
	public static Ingredient[] getChosenIngredients(JList<JPanel> lst) {
		
        int[] selectedIndices = lst.getSelectedIndices();
        ArrayList<Ingredient> selectedIngredients = new ArrayList<>();

        	for (int index : selectedIndices) {
                JLabel label = (JLabel) lst.getModel().getElementAt(index).getComponent(0);
                Ingredient ingredient = getIngredientCardLabels().get(label);
                selectedIngredients.add(ingredient);
            }

            // Convert ArrayList to an array
            Ingredient[] resultArray = new Ingredient[selectedIngredients.size()];
            return selectedIngredients.toArray(resultArray);
     
    }

    
}