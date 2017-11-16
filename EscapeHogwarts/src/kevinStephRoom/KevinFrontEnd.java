package kevinStephRoom;

public class KevinFrontEnd implements StephSupport{

	private KevinSupport backend;
	private int move;
	private static int lightsOff;
	
	public KevinFrontEnd() {
		backend = new StephBackEnd(this);
		move = 0;
		setLightsOff(0); //for now until we give it a valueeeeeeeeeeeE
	}

	public static void main(String[] args) {
		KevinFrontEnd game = new KevinFrontEnd();
		game.play();
	}

	private void play() {
		KevinStephLight[][] board = backend.getBoard();
		KevinStephLight c = null; 
		
		while (getLightsOff() > 0) {
			displayBoard(board);
			displayMoveCount();
		
			System.out.println("Where would you like to turn the lights off next?");
			int[] coords = backend.getCoordInput();
			c = board[coords[0]][coords[1]];
			backend.lightSwitch(c);
		
			move++;
		}
		
		System.out.println("Congratulations, you");
	}

	private void displayMoveCount() {
		
		
	}

	private void displayBoard(KevinStephLight[][] board) {
		
		
	}

	public static int getLightsOff() {
		return lightsOff;
	}

	public static void setLightsOff(int lightsOff) {
		KevinFrontEnd.lightsOff = lightsOff;
	}

}
