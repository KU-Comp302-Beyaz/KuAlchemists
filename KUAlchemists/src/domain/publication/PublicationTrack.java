package domain.publication;

import java.util.ArrayList;

import domain.ingredients.Alchemical;
import domain.ingredients.Ingredient;
import domain.theorydeduction.Theory;

public class PublicationTrack {
	
	private static PublicationTrack PublicationTrackInstance;
	private ArrayList<PublicationCard> publicationCards;
	private ArrayList<Theory> publishedTheories;
	private ArrayList<Alchemical> availableAlchemicals;
	private ArrayList<Ingredient> availableIngredients;
	
	public static synchronized PublicationTrack getInstance() {
		if (PublicationTrackInstance == null)
			PublicationTrackInstance = new PublicationTrack();
		return PublicationTrackInstance;
	}
	
	public PublicationTrack() {

		this.publicationCards = new ArrayList<>();
		this.publishedTheories = new ArrayList<>();
		this.availableAlchemicals = new ArrayList<>();
		this.availableIngredients = new ArrayList<>();
	
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

	public ArrayList<Alchemical> getAvailableAlchemicals() {
		return availableAlchemicals;
	}

	public ArrayList<Ingredient> getAvailableIngredients() {
		return availableIngredients;
	}

	
	

	
	
	
	
	
	
}
