package domain.ingredients;

import domain.theorydeduction.AlchemyMarker;

public class Ingredient {
	
	String identifier; // Bu ne için??
	String name;
	String properties; // Bu ne için??
	Alchemical alchemical;
	
	public Ingredient(String identifier, String name, String properties, Alchemical alchemical) {
		this.identifier = identifier;
		this.name = name;
		this.properties = properties;
		this.alchemical = alchemical;
	
	}

	public Alchemical getAlchemical() {
		return alchemical;
	}
	public void setAlchemical(Alchemical alchemical) {
		this.alchemical = alchemical;
	}
	
	
	
}
