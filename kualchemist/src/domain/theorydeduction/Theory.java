package domain.theorydeduction;

import domain.Player;
import domain.ingredients.Alchemical;

public class Theory {

	private Player owner;
	private Alchemical alchemical;
	
	public Theory (Player p, Alchemical a) {
		
		this.owner = p;
		this.alchemical = a;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public Alchemical getAlchemical() {
		return alchemical;
	}

	public void setAlchemical(Alchemical alchemical) {
		this.alchemical = alchemical;
	}
	
	
}
