package domain;

import java.util.List;

public class Alchemical {
	
	private List<AlchemyMarker> aspects;
	
	public Alchemical (AlchemyMarker m1, AlchemyMarker m2, AlchemyMarker m3) {
		
		this.aspects.add(m1);
		this.aspects.add(m2);
		this.aspects.add(m3);
	}

	public List<AlchemyMarker> getAspects() {
		return aspects;
	}

	public void setAspects(List<AlchemyMarker> aspects) {
		this.aspects = aspects;
	}
	
	
}
