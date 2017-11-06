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
				+ "or you can press 'e' or 'c' to interact.");
	}

	/**
	 * override to add more moves
	 * @return
	 */
	
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
	if(direction == 4) {
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

public String getContents() {
	if(containsNPC() && npc.isActive()) {
		return npc.getSymbol();
	}else {
		return super.getContents();
	}
}

public String getDescription() {
	if(containsNPC() && npc.isActive()) {
		return super.getDescription()+"\n"+npc.getDescription();
	}else if(containsNPC() && !npc.isActive()){
		return super.getDescription()+"\n"+npc.getInactiveDescription();
	}else {
		return super.getDescription();
	}
}


}
