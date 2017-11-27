package kevinStephRoom;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;

public class KevinRoom extends CaveRoom {
		//THEMATIC ROOM 4
	public KevinRoom(String description) {
		super(description);
		
	}

	/*
	public static int randomRoom() {
		int room = (int)(Math.random()*4); //0 to 5
		//0 to 4
		return room;
	}
	*/
	
	public void printTeleport()
	{
		System.out.println("You have been teleported to a random room.");
	}
	
	public static void performTeleport()
	{
		//if there are bordering rooms
		CaveExplorer.currentRoom = CaveExplorer.caves[0][1]; 
		//if the coordinate has a hallway or an exit then you set the coordinate and move the user.
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

	public static void userEntered() {
		performTeleport();
	}
}