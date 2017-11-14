package kevinStephRoom;

public class KevinFrontEnd implements StephSupport{

	private KevinSupport backend;
	private int move;
	
	public KevinFrontEnd() {
		backend = new StephBackEnd(this);
		move = 0;
	}

	public static void main(String[] args) {
		KevinFrontEnd game = new KevinFrontEnd();
		game.play();
	}

	private void play() {
		KevinStephBoard[][] board = backend.getBoard();
		KevinStephBoard c = null; 
		
		while () {
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
		// TODO Auto-generated method stub
		
	}

	private void displayBoard(KevinStephBoard[][] board) {
		// TODO Auto-generated method stub
		
	}

}
