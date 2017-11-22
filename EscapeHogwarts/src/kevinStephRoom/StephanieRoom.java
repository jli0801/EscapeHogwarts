package kevinStephRoom;

import java.util.Scanner;
import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;
import caveExplorer.Door;
import caveExplorer.Inventory;
import caveExplorer.NPCRoom;
import caveExplorer.NPC;

public class StephanieRoom extends CaveRoom {
	
	private CaveRoom[] borderingRooms;
	private Door[] doors;
	public CaveRoom[][] c = CaveExplorer.caves;

	public StephanieRoom(String description) {
		super(description);
		
	}
	
	public void setConnection(int direction, CaveRoom anotherRoom, Door door) {
		addRoom(direction, anotherRoom, door);
		anotherRoom.addRoom(oppositeDirection(direction), this, door);
	}
	/*public void printValidMoves()
	{
		System.out.println("You can only enter 'w', 'a'. 's'. d'" + "or you can press 'p' to interact with Peeves.");
	}
	
	public String validMoves()
	{
		return "wdsap";
	}
	
	public void performAction (int direction)
	{
		if(direction == 5) {
			if(Peeves() != null && Peeves.isActive()) {
				Peeves.interact();
			}else {
				CaveExplorer.print("There is no creatures to interect with..");
			}
		}else {
			CaveExplorer.print("There is nothing to do...");
		}
	}*/
	
	public static void setUpCaves()
	{
		//1. Determine size of caves
		CaveExplorer.caves = new NPCRoom[5][5];
		CaveRoom[][] c = CaveExplorer.caves;//create a shortcut for accessing CaveExplorer.caves
		//2. populate with default caves
		for(int row = 0; row < c.length; row++)
		{
			for(int col = 0; col < c[row].length; col++)
			{
				c[row][col] = new NPCRoom("This cave has coordinates " + row+  ", "+col + " and look! Peeves is here! You might want to leave...");
			}
		}
		//3. replace some default rooms with custom rooms(SAVE FOR LATER)
		
		
		
		
		
		//4. set Starting room
		CaveExplorer.currentRoom = c[0][1];
		CaveExplorer.currentRoom.enter();
		
		//5. Set up doors
		c[2][3].setConnection(NORTH, c[2][2], new Door("hallway", true));
		
		
		
	}
	
	/*public boolean containsNPC()
	{
		return here = true;
	}
	
	public void enterNPC(NPC n)
	{
		this.peeves = n;
	}*/
	public void goToRoom(int direction) {
		//make sure there is a room to go to:
		if(borderingRooms[direction] != null && doors[direction] != null &&
				doors[direction].isOpen()) 
		{
			
			CaveExplorer.currentRoom.leave();
			CaveExplorer.currentRoom = borderingRooms[direction];
			CaveExplorer.currentRoom.enter();
			
			
			//CaveExplorer.inventory.updateMap();
			
			
			
		}else {
			//print red text
			System.err.println("You can't do that!");
		}
	}

	public static void doorOpens()
	{
		//Size of Caves
		CaveExplorer.caves = new NPCRoom[4][6];
		CaveRoom[][] c = CaveExplorer.caves; //shortcut for accessing CaveExplorer

		//Populate with default caves
		for(int row = 0; row < c.length; row++)
		{
			for(int col = 0; col < c[row].length; col++)
			{
				c[row][col] = new NPCRoom("You are at " + row + ", " + col); //change
			}
		}
		
		//replace default room with custom room (SAVE FOR LATER)
		//Set starting room
		
		CaveExplorer.currentRoom = c[1][0];
		CaveExplorer.currentRoom.enter();
		//Set up doors
		
		
		//replace default room with custom room (SAVE FOR LATER)
		//Set starting room
		
	
		//Set up doors
		
		//rooms 
				c[0][3].setContents("A");
				c[1][4].setContents("L");
				c[3][2].setContents("V");
				c[3][4].setContents("J");
				c[2][1].setContents("K");
				c[1][0].setContents("S");
				
				//addRoom
				c[0][3].addRoom(SOUTH, c[1][3], new Door("room 1", true));
				c[1][4].addRoom(WEST, c[1][3], new Door("room 2", true));
				c[3][2].addRoom(EAST, c[3][4],new Door("room 3", true));
				c[3][5].addRoom(EAST, c[3][4],new Door("room 4", true));
				c[2][1].addRoom(NORTH, c[1][2],new Door("room 5", true));
				c[1][0].addRoom(EAST, c[1][1],new Door("room 6", true));
				
				//connections
				c[0][1].setConnection(SOUTH, c[1][1], new Door("hallway", true));
				c[1][1].setConnection(EAST, c[1][2], new Door("hallway", true));
				
				c[1][1].setConnection(SOUTH, c[2][1], new Door("hallway", true));
			//	c[1][1].setConnection(WEST, c[1][0], new Door("hallway", true));
				c[1][1].setConnection(EAST, c[1][2], new Door("hallway", true));
				
				c[1][3].setConnection(SOUTH, c[2][3], new Door("hallway", true));
				c[1][3].setConnection(WEST, c[1][2], new Door("hallway", true)); 
				c[1][3].setConnection(EAST, c[1][4], new Door("hallway", true));
				c[1][3].setConnection(NORTH, c[0][3], new Door("hallway", true));
				
				c[1][2].setConnection(WEST, c[1][1], new Door("hallway", true));
				
				
			
				c[2][3].setConnection(SOUTH, c[2][3], new Door("hallway", true));
				c[2][3].setConnection(SOUTH, c[3][3], new Door("hallway", true));
				c[2][3].setConnection(NORTH, c[1][3], new Door("hallway", true));
				
				c[3][3].setConnection(EAST, c[3][4], new Door("hallway", true));
				c[3][3].setConnection(WEST, c[3][2], new Door("hallway", true));
				
	}
	
	public String getDirections()
	{
		return "";
	}
	
	public static void door()
	{
		CaveRoom[][] c = CaveExplorer.caves;
		c[3][2].setConnection(NORTH, c[2][2], new Door("hallway", true));
	}
/**	public String validMoves() {
		return "wdsa";
	}
	
	public void printValidMoves()
	{
		System.out.println("You can only enter 'w', 'a', 's', or 'd'");//
	}
	
	public void interpretInput(String input) {
		while(!isValid(input)) {
			printValidMoves();
			
			input = CaveExplorer.in.nextLine();
		}
		int direction =  validMoves().indexOf(input); 
		if(direction < 4) {
			goToRoom(direction);
		}else {
			performAction(direction);
		}
		
	}

	
	private boolean isValid(String input) {
		return validMoves().indexOf(input) != -1 && input.length() == 1;
	}
	
	public void performAction (int direction)
	{
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
**/
	private static String getUserInput()
	{
		 String input = CaveExplorer.in.nextLine().toLowerCase();
		 return input;
	}
	
	public static boolean getYesNo() {
		String input = getUserInput();
		if(input.equals("yes")){
			return true;
		}
		return false;
	}
	
	
	public static void userEntered() {
		CaveExplorer.print("You see a mirror in front of you. Do you want to look into it?");
		if(getYesNo()) {
			CaveExplorer.print("You see the exit of Hogwarts, do you wish to continue looking into the mirror? ");
			if(getYesNo()) {
				int userHp = Inventory.getHp() - 10;
				Inventory.setHp(userHp);
				CaveExplorer.print("Your eyes start to burn and you lose 10 hp. Your HP is now: " + userHp + ".");
			}	
		}else {
			CaveExplorer.print("Good choice, you may continue your journey.");
			doorOpens();
		}
	}
}	

