package domain;

import java.util.ArrayList;
import java.util.List;

public class GameLogObservable {
	
	// private List<GameLogObserver> users = new ArrayList<>();
	// private List<String> userHistories = new ArrayList<>();
	//private GameLogObserver observer;
	private List<GameLogObserver> observers = new ArrayList<>();
	 
	 public GameLogObservable(){
	 }
	
	 public void addObserver(GameLogObserver observer) {
	        observers.add(observer);
	    }
	 
	public void notifyObservers(String logEntry, Player player) {

        Game.getGame().getActionHistory().add(logEntry);
		Game.getGame().getPlayerTurnHistory().add(player);
     
		for (GameLogObserver observer : observers) {
			observer.historyUpdate(logEntry, player);
        }
		

    }
}
