package domain.publication;

import java.util.ArrayList;
import java.util.List;

import domain.ingredients.Alchemical;
import domain.ingredients.Ingredient;
import domain.theorydeduction.AlchemyMarker;
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
	
	public Ingredient getIngredient(Ingredient i) {
		
		if (i==null)
			return null;
		if (i.getPhoto()==null)
			return null;
		for (Ingredient ing : availableIngredients) {
			if (Ingredient.checkEquality(i, ing))
				return ing;
		}
		return null;
	}
	
	public Alchemical getAlchemical(Alchemical a) {
		
		if (a==null)
			return null;
		if (a.getAlchemicalPhoto()==null)
			return null;
		for(Alchemical alc : availableAlchemicals) {
			if(Alchemical.checkEquality(a, alc))
				return alc;
		}
		return null;
	}
	
	public boolean claimCard(List<Theory> theories, PublicationCard c) {
		
		ArrayList<Ingredient> ingredientFromTheories = new ArrayList<>();
		for (Theory t : theories) {
			ingredientFromTheories.add(t.getIngredientType());
		}
		if (ingredientFromTheories.containsAll(c.getRequiredTheories()))
			return true;
		else {
			return false;
		}
		
	}
	
	public boolean debunkTheory(Theory theory, AlchemyMarker selectedAlchemyMarker) {
		
		for(AlchemyMarker am : theory.getIngredientType().getAlchemical().getAspects()) {
			
			if (am.getColor().equals(selectedAlchemyMarker.getColor())) {
				if (am.getSign().equals(selectedAlchemyMarker.getSign()))
					return false;
				else {
					return true;
				}
			}
		}
		return false;
	}
}
