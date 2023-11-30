package domain.theorydeduction;

public class AlchemyMarker {

	private String sign;
	private String color;
	private String size;
	
	
	public AlchemyMarker (String sign, String color, String size) {
		
		this.sign = sign;	// (+ / -)
		this.color = color;	// (red / green / blue)
		this.size = size;	// (S / L)
	}
	
	
	public AlchemyMarker () { // nötr

	}

	public AlchemyMarker (String sign, String color) { // resutToken for the result of potion making
		
		this.sign = sign;	// (+ / -)
		this.color = color;	// (red / green / blue)
		this.size = size;	// (S / L)
	}
	
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}


	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}


	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
	
	
}
