package game_server;
public class StickGame extends Game {
	private int sticksCount = 20;
	
	public int getSticksNum() {
		return sticksCount;
	}
	
	public void takeSticks(int num) {
		sticksCount -= num;
	}
}
