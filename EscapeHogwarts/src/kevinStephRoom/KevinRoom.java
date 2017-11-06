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
}