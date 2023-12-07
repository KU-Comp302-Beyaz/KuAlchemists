package domain.publication;

import java.util.ArrayList;

import domain.theorydeduction.Theory;

public class PublicationTrack {
	
	private ArrayList<PublicationCard> publicationCards;
	private ArrayList<Theory> publishedTheories;
	
	public PublicationTrack() {

		this.publicationCards = new ArrayList<>();
		this.publishedTheories = new ArrayList<>();
	
	}

	public ArrayList<PublicationCard> getPublicationCards() {
		return publicationCards;
	}

	public ArrayList<Theory> getPublishedTheories() {
		return publishedTheories;
	}
	
	public void addPublicationCard(PublicationCard pc) {
		
		this.publicationCards.add(pc);
	}
	
	public void removePublicationCard(PublicationCard pc) {
		
		this.publicationCards.remove(pc);
		
	}
	
	public void addTheory(Theory t) {
		
		this.publishedTheories.add(t);
	}
	
	public void removeTheory(Theory t) {
		
		this.publishedTheories.remove(t);
	}
	
	
	
}
