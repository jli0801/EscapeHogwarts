package kevinStephRoom;

public class StephIntro {
	
	public StephIntro() {
		
	}
	
	public void play(){
		 displayGameScreen();
	}

	private void displayGameScreen() {
		String message = "Your eyes are locked onto the Mirror of Erised. You must play this game in order to determine your fate.";
		System.out.println(message + "\n- - press enter - -");
	}
}	

