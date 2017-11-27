package areejJessRoom;

import caveExplorer.CaveExplorer;

import caveExplorer.CaveRoom;


public class AreejRoom extends CaveRoom {
	
	public AreejRoom(String description) {
		super(description);
		
	}
	public void printValidMoves() {
		System.out.println("You can only enter 'w', 'a', 's', or 'd' to move "
				+ "or you can press 'e' to interact with objects in the room.");
	}

	/**
	 * override to add more moves
	 * @return
	 */
	
	//extra move 'c' maybe??
	public String validMoves() {
		return "wdsae";
	}
	
	public void performAction(int direction) {
	if(direction == 5) {
		if(npc != null && npc.isActive()) {
			npc.interact();
		}else {
			CaveExplorer.print("You've collected your money from the chest.");
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
