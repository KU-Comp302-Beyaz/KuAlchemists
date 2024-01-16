package domain.ingredients;

import java.util.ArrayList;
import java.util.List;
import domain.theorydeduction.AlchemyMarker;

public class Alchemical {
	
	private List<AlchemyMarker> aspects = new ArrayList<AlchemyMarker>();
	private String alchemicalPhoto;
	private String name;
	private static final String[] alchemicalPhotos = {
			"red+S_green-L_blue-S",
			"red-S_green+L_blue+S",
			"red-L_green-S_blue+S",
			"red+S_green-S_blue+L",
			"red-S_green+S_blue-L",
			"red+L_green+S_blue-S",
			"red-L_green-L_blue-L",
			"red+L_green+L_blue+L"
			};
	
	
	public Alchemical (AlchemyMarker red, AlchemyMarker green, AlchemyMarker blue) {
		
		this.aspects.add(red);
		this.aspects.add(green);
		this.aspects.add(blue);
		// "red+S_green-L_blue-S" 
		this.alchemicalPhoto = "red" + red.getSign() + red.getSize() +"_green" + green.getSign() + green.getSize() + "_blue" + blue.getSign() + blue.getSize();
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
	public void setName(String name) {
		this.name = name;
	}
	
	
	public static String[] getAlchemicalphotos() {
		return alchemicalPhotos;
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
