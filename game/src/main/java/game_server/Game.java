package game_server;


import java.util.ArrayList;
import java.util.List;

import javax.websocket.Session;

public class Game {
	private GameState state; 
	private final String id; 
	private static int idCounter = 0;
	private final List<Session> specList = new ArrayList<Session>();
	private final List<Session> playerList = new ArrayList<Session>();
	
	public enum GameState {
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
	
	public GameState getState() {
		return state;
	}
}
