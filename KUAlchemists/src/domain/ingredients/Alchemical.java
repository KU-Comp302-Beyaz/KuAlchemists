package domain.ingredients;

import java.util.List;

import domain.theorydeduction.AlchemyMarker;

public class Alchemical {
	
	private List<AlchemyMarker> aspects;
	
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
	
	
}
