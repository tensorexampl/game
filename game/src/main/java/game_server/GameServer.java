
public class GameServer {
	private static final Set<Game> games;
	
	public enum GameType {
		STICKS
	}
	
	public Game CreateGame() {
		Game newGame = new Game();
		games.add(newGame);
		return newGame;
	}
	
	public void removeGame(Game toRemoveGame) {
		games.remove(toRemoveGame);
	}
}
