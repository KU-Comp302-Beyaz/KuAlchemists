package domain.ingredients;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import domain.theorydeduction.AlchemyMarker;

public class Alchemical {
	
	private List<AlchemyMarker> aspects = new ArrayList<>();
	/*
	AlchemyMarker red;
	AlchemyMarker green; 
	AlchemyMarker blue;
	*/
	private ImageIcon alchemicalPhoto;
	
	
	public Alchemical (AlchemyMarker red, AlchemyMarker green, AlchemyMarker blue, ImageIcon alchemicalPhoto) {

		this.aspects.add(red);
		this.aspects.add(green);
		this.aspects.add(blue);
		/*
		this.red = red;
		this.green = green;
		this.blue = blue;*/
		this.alchemicalPhoto = alchemicalPhoto;
	}

	
	public List<AlchemyMarker> getAspects() {
		return aspects;
	}

	public void setAspects(List<AlchemyMarker> aspects) {
		this.aspects = aspects;
	}	

/*
	public AlchemyMarker getRed() {
		return red;
	}
	public void setRed(AlchemyMarker red) {
		this.red = red;
	}

	public AlchemyMarker getGreen() {
		return green;
	}
	public void setGreen(AlchemyMarker green) {
		this.green = green;
	}

	public AlchemyMarker getBlue() {
		return blue;
	}
	public void setBlue(AlchemyMarker blue) {
		this.blue = blue;
	}
*/
	public ImageIcon getAlchemicalPhoto() {
		return alchemicalPhoto;
	}
	public void setAlchemicalPhoto(ImageIcon alchemicalPhoto) {
		this.alchemicalPhoto = alchemicalPhoto;
	}
	
	
	
}
