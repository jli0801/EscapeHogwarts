package jiVickieRoom;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;
import caveExplorer.Inventory;

public class JiRoom extends CaveRoom {
	
	private static boolean gotKey = false;
	private static String input;
	private static String inputCase;

	public JiRoom(String description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	public String validMoves() {
		return "wdsaeo";
	}
	
	public void printValidMoves() {
		System.out.println("You can only enter 'w', 'a', 's', or 'd' to move "

				+ "or you can press 'e' to interact and 'o' to observe.");
	}

	public void performAction(int direction) {
		if(direction == 5) {
			//what happens when o is pressed
			CaveExplorer.print("The mysterious ancient walls loom over you.");

		}else {
			//when o is not pressed
			super.performAction(direction);
		}
	}

	public static void userEntered() {
		if(gotKey == true) {
			CaveExplorer.print("You glance at where the key used be.");
		}else {
			CaveExplorer.print("On a far ledge of wall, you find a dusty silver key.");
			CaveExplorer.print("Would you like to attempt to reach it?");
			input = CaveExplorer.in.nextLine();
			inputCase = input.toLowerCase();
			if(inputCase.equals("yes")) {
				if(Math.random() < .7) {
					CaveExplorer.print("You jump on lower ledge.");
					CaveExplorer.print("But when you jumped back down, you hurt yourself in the landing");
					CaveExplorer.print("You lose 30 hp.");
					int userHp = Inventory.getHp() - 30;
					Inventory.setHp(userHp);
					CaveExplorer.print("Your HP is now: " + userHp + ".");
				}else {
					CaveExplorer.print("Congratulations!");
					CaveExplorer.print("You receive a silver key.");
					gotKey = true;
					Inventory.setSilverKey(true);
				}
			}
		}
	}
}
