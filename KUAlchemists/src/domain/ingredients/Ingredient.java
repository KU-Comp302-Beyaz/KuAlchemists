package domain.ingredients;

public class Ingredient {
	
	//fields
	private static int counter = 0; //since images start numbering from 1
	private int identifier; //must be unique ID //UNIQUE FOR EACH CARD TYPE OR UNIQUE FOR EVERY SINGLE INGREDIENT INSTANCE?
	private String name;
	private String properties; //Properties, including color, value, and other characteristics? // Bu ne için??
	private Alchemical alchemical;

	//constructor
	public Ingredient(int identifier, String name, String properties, Alchemical alchemical) {
		this.identifier = identifier;
		this.name = name;
		this.properties = properties;
		this.alchemical = alchemical;
	}
	public Ingredient(String name) {
		this.name = name;
		this.identifier = ++counter;
	}

	//getters and setters
	public Alchemical getAlchemical() {
		return alchemical;
	}
	public void setAlchemical(Alchemical alchemical) {
		this.alchemical = alchemical;
	}
	public int getIdentifier() {
		return identifier;
	}
	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProperties() {
		return properties;
	}
	public void setProperties(String properties) {
		this.properties = properties;
	}
	
	
}
