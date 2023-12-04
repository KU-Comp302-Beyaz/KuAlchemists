package domain.ingredients;

import javax.swing.ImageIcon;

import domain.theorydeduction.AlchemyMarker;

public class Ingredient {
	
	//fields
	int identifier; //must be unique ID // Bu ne için??
	String name;
	String properties; //Properties, including color, value, and other characteristics? // Bu ne için??
	Alchemical alchemical;
	ImageIcon ingredientCardImage; //BU BURADA MI OLACAK??? BAŞKA NEREDE OLABİLİR Kİ???

	//constructor
	public Ingredient(int identifier, String name, String properties, Alchemical alchemical) {
		this.identifier = identifier;
		this.name = name;
		this.properties = properties;
		this.alchemical = alchemical;
	
	}
	
	//getters and setters
	public Alchemical getAlchemical() {
		return alchemical;
	}
	public void setAlchemical(Alchemical alchemical) {
		this.alchemical = alchemical;
	}

	public ImageIcon getIngredientCardImage() {
		return ingredientCardImage;
	}

	public void setIngredientCardImage(ImageIcon ingredientCardImage) {
		this.ingredientCardImage = ingredientCardImage;
	}
	
	
	
}
