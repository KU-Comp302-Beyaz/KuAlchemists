package domain.potion;

import domain.theorydeduction.AlchemyMarker;

public class Student {
	
	private int sicknessLevel;
	
	public Student() {
		setSicknessLevel(0);
	}
	

	public AlchemyMarker testOnStudent(Potion p) {
		//////
		
		AlchemyMarker alchemyMarker = p.getAlchemyMarker();
		if(alchemyMarker.getSign().equals("-")) {
			setSicknessLevel(getSicknessLevel() + 1);
		}
		
		return alchemyMarker;
		
	}


	public int getSicknessLevel() {
		return sicknessLevel;
	}


	public void setSicknessLevel(int sicknessLevel) {
		this.sicknessLevel = sicknessLevel;
	}
}
