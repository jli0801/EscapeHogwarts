package kevinStephRoom;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;

public class KevinRoom extends CaveRoom {

	public KevinRoom(String description) {
		super(description);
		
	}

	public int randomRoom() {
		int room = (int)(Math.random()*5);
		return room;
	}
	
	public void printTeleport()
	{
		System.out.println("You have been teleported to a random room.");
	}
	
	public void performTeleport()
	{
		CaveExplorer.currentRoom = CaveExplorer.caves[randomRoom()][randomRoom()];
		CaveExplorer.currentRoom.enter();
	}
	
	public void printValidMoves()
	{
		System.out.println("You can only enter 'w', 'a', 's', d'");
	}
	
	public String validMoves() {
		return "wdsae";
	}
	
	public void performAction (int direction)
	{
		if(direction == 4) {
			printTeleport();
			performTeleport();
		}else {
			CaveExplorer.print("That key does nothing.");
		}
	}
}