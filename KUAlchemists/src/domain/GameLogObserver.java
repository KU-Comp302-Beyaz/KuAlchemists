package domain;

import javax.swing.JLabel;


public interface GameLogObserver{
	
	//private String history;
	/**
	private Player player;
	
	
	private static GameLogObserver gameLogControllerInstance;
	
	
	 * Singleton implementation
	 * @return unique instance
	
	public static synchronized GameLogController getInstance() {
		if (gameLogControllerInstance == null)
			gameLogControllerInstance = new GameLogController();
		return gameLogControllerInstance;
	}
	
	if(Game.getGame().getPlayerTurnHistory().peek().equals(player)) {
    		JLabel historyLabel = new JLabel(Game.getGame().getActionHistory().peek());
    		playerDashboards[i].add(historyLabel);
    	}
	 
	
	 public GameLogObserver(Player player) {
	        this.player = player;
	    }
	
	public void historyUpdate(String history) {
		player.setHistory(player.getHistory() + "\n" + history);
	}
*/
	void historyUpdate(String history, Player player); 

	
	
}
