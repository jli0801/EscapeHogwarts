package jiVickieRoom;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;
import caveExplorer.NPC;
import caveExplorer.NPCRoom;

public class JiRoom extends NPCRoom {
	


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
}
