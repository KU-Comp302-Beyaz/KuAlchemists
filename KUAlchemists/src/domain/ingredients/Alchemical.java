package domain.ingredients;

import java.util.List;

import javax.swing.ImageIcon;

import domain.theorydeduction.AlchemyMarker;

public class Alchemical {
	
	private List<AlchemyMarker> aspects;
	private ImageIcon alchemicalPhoto;
	
	
	public Alchemical (AlchemyMarker red, AlchemyMarker green, AlchemyMarker blue, ImageIcon alchemicalPhoto) {
		
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

	public ImageIcon getAlchemicalPhoto() {
		return alchemicalPhoto;
	}

	public void setAlchemicalPhoto(ImageIcon alchemicalPhoto) {
		this.alchemicalPhoto = alchemicalPhoto;
	}
	
	
	
	
}
