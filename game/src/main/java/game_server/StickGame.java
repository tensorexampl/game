
public class StickGame extends Game {
	private int sticksCount = 20;
	
	public int getSticks() {
		return sticksCount;
	}
	
	public void decSticks(int num) {
		sticksCount -= num;
	}
}
