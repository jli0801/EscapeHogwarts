package kevinStephRoom;

import caveExplorer.CaveExplorer;

public class KevinBackEnd implements StephSupport{

	private KevinSupport frontend;	
	private KevinStephLight[][] board;
	
	public KevinBackEnd(KevinSupport frontend) {
		this.frontend = frontend;
		board = new KevinStephLight[4][4];
		createBoard();
	}

	public KevinStephLight[][] createBoard() {
		for(int row = 0; row < board.length; row++){
			for(int col = 0; col < board[row].length; col++){
				board[row][col] = new KevinStephLight(row, col); //board is created 
				board[row][col].lightOn(true); // all lights are on
			}
		}
		
		randomLightsOff(); //turn off some lights to start the games
		return board;
		
	}
	
	public void randomLightsOff() {
		for(int i = 0; i < 10; i++) {
			int row = (int)(Math.random()*4);
			int col = (int)(Math.random()*4);
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
		try{
			int a = Integer.parseInt(input.substring(0,1));
			int b = Integer.parseInt(input.substring(2,3));
			if(input.substring(1,2).equals(",") && input.length() ==3){
				int[] coords = {a,b};
				return coords;
			}else{
				return null;
			}
		}catch(Exception e){
			return null;
		}
	}

	public void lightSwitch(KevinStephLight c) {
		while(frontend.getLightsOff() != 0) {
			if(c.getLightOn() == true) {
				c.setLightOn(false);
				switchAdjacentLight(c);
				
			}
			else {
				c.setLightOn(true);
			}
		}
		
	}

	private void switchAdjacentLight(KevinStephLight c) {
		for(int row = c.getRow()-1; row < c.getRow()+2; row++){
			for(int col = c.getCol()-1; col < c.getCol()+2; col++){
				if(row >= 0 && row < board.length && col >= 0 && col < board[row].length){
					if(board[row][col].getLightOn()) {
						board[row][col].setLightOn(false);
					} else if(!board[row][col].getLightOn()) {
						board[row][col].setLightOn(true);
					}
				}
			}
		}
	}

}
