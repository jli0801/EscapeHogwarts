package kevinStephRoom;

public class KevinFrontEnd implements StephSupport{

	private KevinSupport backend;
	
	
	public KevinFrontEnd() {
		backend = new StephBackEnd(this);
	}

	public static void main(String[] args) {
		KevinFrontEnd game = new KevinFrontEnd();
		game.play();
	}

	private void play() {
		
		
	}

}
