package jiVickieRoom;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;
import caveExplorer.NPC;
import caveExplorer.NPCRoom;

public class JiRoom extends CaveRoom {
	
	private NPC npc;

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
		if(direction == 4) {
			if(npc != null && npc.isActive()) {
				npc.interact();
			}else {
				CaveExplorer.print("There is nothing to interact with.");
			}
		}else {
			CaveExplorer.print("That key does nothing.");
		}
	}
}
