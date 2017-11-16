package kevinStephRoom;

import caveExplorer.CaveExplorer;

public class StephBackEnd implements KevinSupport{

	private StephSupport frontend;	
	private KevinStephLight[][] board;
	
	public StephBackEnd(StephSupport frontend) {
		this.frontend = frontend;
		board = new KevinStephLight[4][4];
		createBoard();
	}

	private void createBoard() {
		for(int row = 0; row < board.length; row++){
			for(int col = 0; col < board[row].length; col++){
				board[row][col] = new KevinStephLight(row, col); //board is created 
				board[row][col].lightOn(true); // all lights are on
			}
		}
		
		randomLightsOff(); //some lights turn off to start the game
		
	}
	
	public void randomLightsOff() {
		for(int i = 0; i < 15; i++) {
			int row = (int)(Math.random()*5);
			int col = (int)(Math.random()*5);
			board[row][col].lightOn(false);
		}
		
	}
	
	public boolean isLightOn(int row, int col) {
		if (board[row][col].getLightOn() == true) {
			return true;
		}
		return false;
	}
	
	
	public KevinStephLight[][] getBoard() {
		return board;
	}
	
	public int[] getCoordInput() {
		String input = CaveExplorer.in.nextLine();
		int[] coords = toCoords(input);
		while(coords == null){
			System.out.println("You must enter cordinates of the form:\n          <row>,<col>"
					+ "\n<row> and <col> should be integers.");
			input = CaveExplorer.in.nextLine();
			coords = toCoords(input);
		}
		return coords;
	}

	private int[] toCoords(String input) {
		int x = Integer.parseInt(input.substring(0,1));
		int y = Integer.parseInt(input.substring(2,3));
		if(input.substring(1,2).equals(",") && input.length() ==3){
			int[] coords = {x,y};
			return coords;
		}else{
			return null;
		}
	}

	public void lightSwitch(KevinStephLight c) {
		while(KevinFrontEnd.getLightsOff() != 0) {
			if(c.getLightOn() == true) {
				c.setLightOn(false);
				checkAdjacentLight();
			}
			else {
				c.setLightOn(true);
			}
		}
		
	}

	public void checkAdjacentLight() {
		//
	}

}
