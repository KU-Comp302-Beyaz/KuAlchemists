package domain.ingredients;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import domain.theorydeduction.AlchemyMarker;

public class Alchemical {
	
	private List<AlchemyMarker> aspects = new ArrayList<>();
	private String alchemicalPhoto;
	
	
	public Alchemical (AlchemyMarker red, AlchemyMarker green, AlchemyMarker blue, String alchemicalPhoto) {
		
		this.aspects.add(red);
		this.aspects.add(green);
		this.aspects.add(blue);
		this.alchemicalPhoto = alchemicalPhoto;
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
	
	
	
	
}
