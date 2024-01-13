package domain.ingredients;

public class Ingredient {
	
	//fields
	private static int counter = 0; //since images start numbering from 1
	private int identifier; //must be unique ID //UNIQUE FOR EACH CARD TYPE
	private String name;
	private String properties; //Properties, including color, value, and other characteristics?
	private String photo;
	private Alchemical alchemical;
	private int iconID;

	//constructor
	public Ingredient(int identifier, String name, String photo, Alchemical alchemical) {
		this.identifier = identifier;
		this.name = name;

		this.photo = photo;
		this.alchemical = alchemical;
	}
	public Ingredient(int identifier, String name,String photo) {
		this.identifier = identifier;

		this.name = name;
		this.photo = photo;

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


	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "Ingredient [identifier=" + identifier + ", name=" + name + "]";
	}
	
	/*
	 * REQUIRES: -
	 * MODIFIES: -
	 * EFFECTS: two ingredients are compared to each other by whether they are the same or not and the result is returned.
	 */

	public static boolean checkEquality(Ingredient i1, Ingredient i2) {
	
		if (i1 == null)
			return false;
		else if (i2==null)
			return false;
		else if (i1.getPhoto()== null)
			return false;
		else if (i2.getPhoto()==null)
			return false;
		else {
			return i1.getPhoto().equals(i2.getPhoto());
		}
	}
}
