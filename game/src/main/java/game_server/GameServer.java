package game_server;

import java.util.Set;

public class GameServer {
	private static Set<Game> games;
	
	public static enum GameType {
		STICKS
	}
	
	public static Game CreateStickGame() {
		StickGame newGame = new StickGame();
		games.add(newGame);
		return newGame;
	}
	
	public static void removeGame(Game toRemoveGame) {
		games.remove(toRemoveGame);
	}
	
	
}
