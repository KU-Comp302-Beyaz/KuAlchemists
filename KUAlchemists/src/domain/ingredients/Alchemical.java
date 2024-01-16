package domain.ingredients;

import java.util.ArrayList;
import java.util.List;
import domain.theorydeduction.AlchemyMarker;

public class Alchemical {
	
	private List<AlchemyMarker> aspects = new ArrayList<AlchemyMarker>();
	private String alchemicalPhoto;
	private String name;
	
	
	public Alchemical (AlchemyMarker red, AlchemyMarker green, AlchemyMarker blue, String alchemicalPhoto) {
		this.aspects.add(red);
		this.aspects.add(green);
		this.aspects.add(blue);
		this.alchemicalPhoto = alchemicalPhoto; // "red+S_green-L_blue-S" 
		this.name = "red " + red.getSign() + " " + red.getSize() + " | " + "green " + green.getSign() + " " + green.getSize() + "blue " + blue.getSign() + " " + blue.getSize() ;
	}
	
	public Alchemical (AlchemyMarker red, AlchemyMarker green, AlchemyMarker blue) {
		
		this.aspects.add(red);
		this.aspects.add(green);
		this.aspects.add(blue);
		this.name = "red " + red.getSign() + " " + red.getSize() + " | " + "green " + green.getSign() + " " + green.getSize() + "blue " + blue.getSign() + " " + blue.getSize() ;

	}

	
	public List<AlchemyMarker> getAspects() {
		return aspects;
	}

	public void setAspects(List<AlchemyMarker> aspects) {
		this.aspects = aspects;

	}	
	public String getAlchemicalPhoto() {
		return alchemicalPhoto;
	}
	public void setAlchemicalPhoto(String alchemicalPhoto) {
		this.alchemicalPhoto = alchemicalPhoto;
  }
	public String getName() {
		return name;
	}
	
	/*
	 * REQUIRES: -
	 * MODIFIES: -
	 * EFFECTS: two alchemicals are compared to each other by whether they are the same or not and the result is returned.
	 */
	public static boolean checkEquality(Alchemical a1, Alchemical a2) {
		
		if (a1 == null)
			return false;
		else if (a2==null)
			return false;
		else if (a1.getAlchemicalPhoto()==null)
			return false;
		else if (a2.getAlchemicalPhoto()==null)
			return false;
		else {
			return a1.getAlchemicalPhoto().equals(a2.getAlchemicalPhoto());
		}
	}
	
	
}
