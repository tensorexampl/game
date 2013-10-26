package src.main.java.game_serv;


import javax.websocket.Session;

public class Game {
	private GameState state; //Текущий статус игры
	private final String id; //Идентификатор игры
	private static int idCounter = 0;
	private final List<Session> specList = new ArrayList(); //Список подключенных клиентов
	private final List<Session> playerList = new ArrayList(); //Список игроков
	
	public ednum GameState {
        CREATED, WAIT_FOR_PLAYERS, PLAYING, ENDED
    }
	
	public Game() {
		this.state = GameState.CREATED;
		this.id    = Integer.toString(idCounter);
		idCounter++;
	}
	
	synchronized void addSpectator(Session sess) {
		specList.add(sess);
	}
	
	public synchronized void removeSpectator(Session sess) {
		specList.remove(sess);
	}
	
	synchronized void addPlayer(Session sess) {
		playerList.add(sess);
	}
	
	public synchronized void removePlayer(Session sess) {
		playerList.remove(sess);
	}
	
	public void switchStateToWaitForPlayer() {
		synchronized (id) {
            state = GameState.WAIT_FOR_PLAYERS;
        }
	}
	
	public String getId() {
        return id;
    }
	
	public List<Session> getPlayersList() {
		return playerList;
	}
	
	public List<Session> getSpectatorsList() {
		return specList;
	}
}
