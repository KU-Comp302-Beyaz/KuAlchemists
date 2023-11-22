package domain;

public class Game {

	static Player player1;
	static Player player2;
	
	public void selectContoller() {
	
		//player1.updatePlayerTurn()
		//player2.updatePlayerTurn()
	
	}

	public static Player getPlayer1() {
		return player1;
	}

	public static void setPlayer1(Player player1) {
		Game.player1 = player1;
	}

	public static Player getPlayer2() {
		return player2;
	}

	public static void setPlayer2(Player player2) {
		Game.player2 = player2;
	}
	
	
}
