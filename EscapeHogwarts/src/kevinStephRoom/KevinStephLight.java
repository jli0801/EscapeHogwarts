package kevinStephRoom;

public class KevinStephLight {

	private boolean lightOn;
	private int col;
	private int row;

	public KevinStephLight(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public void lightOn(boolean lightOn) { //main method
		this.setLightOn(lightOn);
	}

	public boolean getLightOn() { //getter
		return lightOn;
	}

	public void setLightOn(boolean lightOn) { //setters
		this.lightOn = lightOn;
	}


}