package domain.ingredients;

import java.util.ArrayList;
import java.util.List;
import domain.theorydeduction.AlchemyMarker;

public class Alchemical {
	
	private List<AlchemyMarker> aspects = new ArrayList<AlchemyMarker>();
	private String alchemicalPhoto;
	
	
	public Alchemical (AlchemyMarker red, AlchemyMarker green, AlchemyMarker blue, String alchemicalPhoto) {
		this.aspects.add(red);
		this.aspects.add(green);
		this.aspects.add(blue);
		this.alchemicalPhoto = alchemicalPhoto;
	}
	
	public Alchemical (AlchemyMarker red, AlchemyMarker green, AlchemyMarker blue) {
		
		this.aspects.add(red);
		this.aspects.add(green);
		this.aspects.add(blue);
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
