package areejJessRoom;

import caveExplorer.CaveExplorer;
import caveExplorer.NPC;
import caveExplorer.NPCRoom;


public class AreejRoom extends NPCRoom {

	private NPC npc;
	
	public AreejRoom(String description) {
		super(description);
		
	}
	public void printValidMoves() {
		System.out.println("You can only enter 'w', 'a', 's', or 'd' to move "
				+ "or you can press 'e' or 'c' to interact with objects in the room.");
	}

	/**
	 * override to add more moves
	 * @return
	 */
	
	//extra moves 'e' and 'c' maybe??
	public String validMoves() {
		return "wdsaec";
	}
	
	public void performAction(int direction) {
	if(direction == 5) {
		if(npc != null && npc.isActive()) {
			npc.interact();
		}else {
			CaveExplorer.print("You've collected your money from the chest.");
		}
	}
		else if(direction == 4) {
		if(npc != null && npc.isActive()) {
			npc.interact();
		}else {
			CaveExplorer.print("You cannot grab the dragon egg");
		}
	}
	else {
		CaveExplorer.print("That key does nothing");
	}
}

	public void enter() {
		super.enter();
	}

}
