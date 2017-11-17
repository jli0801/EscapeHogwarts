package kevinStephRoom;

import caveExplorer.CaveExplorer;

public class StephFrontEnd implements StephSupport{

	private KevinSupport backend;
	private int move;
	private static int lightsOff;
	
	public StephFrontEnd() {
		backend = new KevinBackEnd(this);
		move = 0;
		setLightsOff(0); //for now until we give it a value
	}

	public static void main(String[] args) {
		StephFrontEnd game = new StephFrontEnd();
		game.play();
	}

	public void play() {
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
		
		System.out.println("Congratulations, you win!");
	}

	private void displayMoveCount() {
				
	}

	private void displayBoard(KevinStephLight[][] board) {
		for(int row = 0; row < board.length; row++){
			for(int col = 0; col < board[row].length; col++){
				if(board[row][col].getLightOn() == true) {
					System.out.println("O");
				}else {
					System.out.println("X");
				}	
			}
		}
	}

	public static int getLightsOff() {
		return lightsOff;
	}

	public static void setLightsOff(int lightsOff) {
		StephFrontEnd.lightsOff = lightsOff;
	}
}
