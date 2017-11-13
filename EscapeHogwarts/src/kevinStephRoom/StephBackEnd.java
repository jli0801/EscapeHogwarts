package kevinStephRoom;

import caveExplorer.CaveExplorer;
import kevinStephRoom.KevinStephPlot;

public class StephBackEnd implements KevinSupport{

	private StephSupport frontend;	
	private KevinStephPlot[][] plots;
	private int lightsOff;
	
	public StephBackEnd(StephSupport frontend) {
		this.frontend = frontend;
		plots = new KevinStephPlot[4][4];
		createPlots();
	}

	private void createPlots() {
		for(int row = 0; row < plots.length; row++){
			for(int col = 0; col < plots[row].length; col++){
				plots[row][col] = new KevinStephPlot(row, col);
			}
		}
	}

	@Override
	public KevinStephPlot[][] getPlots() {
		return plots;
	}

	@Override
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
		
	}
}
