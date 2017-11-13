package jiVickieRoom;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;
import caveExplorer.Inventory;

public class JiRoom extends CaveRoom {
	
	private static boolean enteredRoom = false;

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
			CaveExplorer.print("The ancient walls loom over you.");

		}else {
			//when o is not pressed
			super.performAction(direction);
		}
	}

	public static void userEntered() {
		if(enteredRoom == true) {
			CaveExplorer.print("You glance at where the key used be.");
		}else {
			CaveExplorer.print("On a far ledge of wall, you find a dusty silver key.");
			
			if(Math.random() < .7) {
				CaveExplorer.print("You jump on lower ledge But when you jumped back down, you hurt yourself in the landing and lost 5 hp.");
				int userHp = Inventory.getHp() - 5;
				Inventory.setHp(userHp);
				CaveExplorer.print("Your HP is now: " + userHp + ".");
			}
		}
	}
}
