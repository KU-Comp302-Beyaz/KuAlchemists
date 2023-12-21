package domain.theorydeduction;

import javax.swing.ImageIcon;

public class AlchemyMarker {

	private String sign;
	private String color;
	private String size;
	private ImageIcon icon;
	
	// Potion formula
	public AlchemyMarker (String sign, String color, String size) {
		
		this.sign = sign;	// (+ / -)
		this.color = color;	// (red / green / blue)
		this.size = size;	// (S / L)

	}
	
	public AlchemyMarker (String sign, String color, String size, ImageIcon icon) {
		
		this.sign = sign;	// (+ / -)
		this.color = color;	// (red / green / blue)
		this.size = size;	// (S / L)
		this.icon = icon;  // The icon to put into DeductionBoardDisplay.
	}
	
	
	public AlchemyMarker () { // nötr

	}

	 // resultToken for the result of potion making
	public AlchemyMarker (String sign, String color) {
		
		this.sign = sign;	// (+ / -)
		this.color = color;	// (red / green / blue)
		
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


	public ImageIcon getIcon() {
		return icon;
	}


	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
	
	
	
	
}
