package kevinStephRoom;

import caveExplorer.CaveExplorer;

public class StephBackEnd implements KevinSupport{

	private StephSupport frontend;	
	private KevinStephLight[][] board;
	private int lightsOn;
	
	public StephBackEnd(StephSupport frontend) {
		this.frontend = frontend;
		board = new KevinStephLight[4][4];
		createBoard();
	}

	private void createBoard() {
		for(int row = 0; row < board.length; row++){
			for(int col = 0; col < board[row].length; col++){
				board[row][col] = new KevinStephLight(row, col);
				board[row][col].lightOn(true);
			}
		}
		//turn lights on
		
		
	}
	
	public void randomLightsOff(int row, int col) {
		for(int i = 0; i < 15; i++) {
			row = (int)(Math.random()*4);
			col = (int)(Math.random()*4);
			board[row][col].lightOn(false);
		}
		
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

	public void setLights() {
		int i = 0;
		while(i < 5) {
			
		}
	}
	public void lightSwitch(KevinStephLight c) {
		
		
	}

	
}
