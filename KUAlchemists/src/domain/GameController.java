package domain;

import ui.BoardWindow;
import ui.EndGameDisplay;

public class GameController {

	private static GameController gameControllerInstance;
	
	/**
	 * Singleton implementation
	 * @return unique instance
	 */
	public static synchronized GameController getInstance() {
		if (gameControllerInstance == null)
			gameControllerInstance = new GameController();
		return gameControllerInstance;
	}
	
	public void updateHistory(String history, Player p) {
		Game.getGame().getActionHistory().add(history);
		Game.getGame().getPlayerTurnHistory().add(p);
		if(p.getHistory() == null) {
			p.setHistory("---------- New Action ----------\n" + history);
		} else {
			p.setHistory(p.getHistory() + "\n\n---------- New Action ----------\n" + history);
		}
		
		BoardWindow.getBoardWindow().rewriteHistory(p); 	
  		
	}
	
	
	public void endGame(Player[] players) {
		
		EndGameDisplay ptDisplay = EndGameDisplay.getInstance();		
		ptDisplay.initialize();
	}
}
