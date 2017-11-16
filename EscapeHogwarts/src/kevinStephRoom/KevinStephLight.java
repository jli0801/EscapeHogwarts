package kevinStephRoom;

public class KevinStephLight {

	private boolean lightOn;

	public KevinStephLight(int row, int col) {
		
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
