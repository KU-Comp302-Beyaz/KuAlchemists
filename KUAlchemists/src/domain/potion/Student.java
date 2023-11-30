package domain.potion;

import domain.theorydeduction.AlchemyMarker;

public class Student {
	
	int sicknessLevel;
	
	public Student() {
		sicknessLevel = 0;
	}
	

	public AlchemyMarker testOnStudent(Potion p) {
		//////
		
		AlchemyMarker alchemyMarker = p.getAlchemyMarker();
		if(alchemyMarker.getSign().equals("-")) {
			sicknessLevel ++;
		}
		
		return alchemyMarker;
		
	}
}
