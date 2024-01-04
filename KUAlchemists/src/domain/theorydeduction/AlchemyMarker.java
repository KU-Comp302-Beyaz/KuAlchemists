package domain.theorydeduction;

import java.util.Objects;

public class AlchemyMarker {

	private String sign;
	private String color;
	private String size;
	private String icon;
	
	// Potion formula
	public AlchemyMarker (String sign, String color, String size) {
		
		this.sign = sign;	// (+ / -)
		this.color = color;	// (red / green / blue)
		this.size = size;	// (S / L)

	}
	
	public AlchemyMarker (String sign, String color, String size, String icon) {
		
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
		this.icon = "src/images/bottle-icons/"+color+ sign +"bottle.png"; // creating path for displaying result Token after make potion
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


	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AlchemyMarker that = (AlchemyMarker) obj;
        return Objects.equals(getSign(), that.getSign()) &&
               Objects.equals(getColor(), that.getColor()) &&
               Objects.equals(getSize(), that.getSize()) &&
               Objects.equals(getIcon(), that.getIcon());
    }
	
	
}
