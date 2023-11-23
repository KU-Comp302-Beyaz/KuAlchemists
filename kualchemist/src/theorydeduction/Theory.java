package theorydeduction;

import domain.Alchemical;
import domain.Player;

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
