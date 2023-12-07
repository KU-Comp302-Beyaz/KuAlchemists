package domain.ingredients;

import domain.theorydeduction.AlchemyMarker;

public class Ingredient {
	
	//fields
	private int identifier; //must be unique ID // Bu ne için??
	private String name;
	private int iconID;
	private String properties; //Properties, including color, value, and other characteristics? // Bu ne için??
	private String photo;
	private Alchemical alchemical;

	//constructor
	public Ingredient(int identifier, String name, int iconID, String photo, Alchemical alchemical) {
		super();///???
		this.identifier = identifier;
		this.name = name;
		this.iconID = iconID;
		this.photo = photo;
		this.alchemical = alchemical;
	}
	public Ingredient(int identifier, String name, int iconID,String photo) {
		super(); ///???
		this.identifier = identifier;
		this.iconID = iconID;
		this.name = name;
		this.photo = photo;
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
	public int getIconID() {
		return iconID;
	}
	public void setIconID(int iconID) {
		this.iconID = iconID;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
	
}
