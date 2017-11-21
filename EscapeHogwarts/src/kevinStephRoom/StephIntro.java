package kevinStephRoom;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;

public class StephIntro extends CaveRoom {
	
	public StephIntro(String description) {
		super(description);
	}
	
	public void play(){
		cheatCode();
	}

	private void displayGameScreen() {
		String message = "Your eyes are locked onto the Mirror of Erised. You must play this game in order to determine your fate.";
		System.out.println(message + "\n- - press enter - -");
	}

	private static String getUserInput()
	{
		 String input = CaveExplorer.in.nextLine().toLowerCase();
		 return input;
	}
	
	public static boolean getYesNo() {
		String input = getUserInput();
		if(input.equals("yes")){
			return true;
		}
		return false;
	}
	
	private void cheatCode() {
		String s = "You have entered a dark room with only a large mirror. Do you wish to look into it?";
		System.out.println(s);
		if(getYesNo()) {
			displayGameScreen();
		}else {
			System.out.println("You have escaped the illusions of the mirror.");
			CaveExplorer.currentRoom = CaveExplorer.caves[1][4];
			CaveExplorer.currentRoom.enter();
		}
		
	}
	
}

