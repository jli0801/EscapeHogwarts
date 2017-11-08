package jiVickieRoom;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;
import caveExplorer.Door;
import caveExplorer.Inventory;
import caveExplorer.NPC;
import caveExplorer.NPCRoom;

public class VickieRoom extends CaveRoom {

	public static String input;
	public static String inputCase;
	private static boolean firstEntered = true;
	private CaveRoom[] borderingRooms;
	private Door[] doors;
	
	public VickieRoom(String description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	public static void userEntered() {
		//Peeves.Peeves();
		if(firstEntered) {
		System.out.println("Welcome to my lovely chamber! Tell me, are you Harry Potter?");
		firstEntered = false;
		}
		input = CaveExplorer.in.nextLine();
		inputCase = input.toLowerCase();
		if(inputCase.equals("yes"))
		{
			//System.out.println("Hello Harry! I have a secret to tell you! There is a secret passageway to the north! ");
			CaveExplorer.print("'Ahahahhaa - you've triggered my spell and now all the rooms in Hogwarts "
					+ "are all randomly placed!");
			CaveExplorer.print(	" Now I know you are trying to escape, Potter. ");
			CaveExplorer.print(" I'm coming for you!'");
						CaveExplorer.print("		-Snape ");
			
			doorOpens();
			//setConnection(0, [0,1], Door[1]);
			
			/*
			 * IDEAS:
			 * 		1) Make a secret chamber accessible if user says s/he is Harry Potter, then when they access the chamber, the
			 * 			door closes (shuts) and the mysterious voice (the antagonist) says "Ahahahahahaa! Snape has been tipped off 
			 * 			that you were trying to escape! Now he's coming to deliver your punishment so sit tight - not that you have anywhere 
			 * 			to go. Ahahahahhahaah!!!!" (At first, it was supposed to say "You're trapped! You are going to die now!"
			 * 					************Use setConnection to do this
			 * 
			 * 		2) Make a secret chamber accessible and then have a map of that room with Peeves or something, or just make new doorways 
			 * 			appear somewhere....
			 * 
			 * 		3) Once they say they are harry, rearrange the whole map, randomly put him somewhere, and say "You triggered a spell! Now
			 * 			Snape is tipped off that you are trying to sneak out. Finish all tasks before he catches you" And have Snape NPC
			 *
			 */
		}else
		if(inputCase.equals("no"))
		{
			System.out.println("Hmph! Then go and be on your way! ");
		}else
		{
			CaveExplorer.print("Sorry, are you Harry? ");
			userEntered();
		}
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
		
	/*	CaveRoom AreejRoom = new AreejRoom("Room");
		CaveExplorer.caves[2][3] = AreejRoom;
		CaveRoom JessRoom = new JessRoom("Room");
		CaveExplorer.caves[2][3] = JessRoom;
		
		CaveRoom JiRoom = new JiRoom("Room");
		CaveExplorer.caves[3][3] = JiRoom;
		CaveRoom VickieRoom = new VickieRoom("Room");
		CaveExplorer.caves[2][3] = VickieRoom;
		
		CaveRoom StephanieRoom = new StephanieRoom("Room");
		CaveExplorer.caves[2][3] = StephanieRoom;
		CaveRoom KevinRoom = new KevinRoom("Room");
		CaveExplorer.caves[2][3] = KevinRoom; */

		
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
		
		CaveExplorer.currentRoom = c[3][2];
		CaveExplorer.currentRoom.enter();
		//Set up doors
		
		/*NPC Peeves = new NPC(); //EDIT TO OWN NPC
		Peeves.setPosition(1,4);
		CaveExplorer.npcs = new NPC[1];
		CaveExplorer.npcs[0] = Peeves; 
		*/
		
		
	/*	NPC testNPCAJ = new NPC();
		testNPC.setPosition(1,2);
		CaveExplorer.npcs = new NPC[1];
		CaveExplorer.npcs[0] = testNPC; */
		
		//room1 : 1,4
		//room2: 2,5
		//room3: 4.3
		
		//replace default room with custom room (SAVE FOR LATER)
		//Set starting room
		
	
		//Set up doors
		
		//rooms 
		c[1][2].setContents("A");
		c[2][0].setContents("L");
		//c[0][3].setContents("V");
		c[0][0].setContents("J");
		c[1][5].setContents("K");
		c[3][4].setContents("S");
		
		//addRoom
		/*c[1][2].addRoom(SOUTH, c[1][3], new Door("room 1", true));
		c[2][0].addRoom(WEST, c[2][0], new Door("room 2", true));
		//c[0][3].addRoom(EAST, c[3][4],new Door("room 3", true));
		
		//c[2][3].addRoom(EAST, c[2][2],new Door("room Trap", true));
		
		c[0][0].addRoom(EAST, c[0][1],new Door("room 4", true));
		c[1][5].addRoom(NORTH, c[1][2],new Door("room 5", true));
		c[2][0].addRoom(EAST, c[1][1],new Door("room 6", true));
	*/
		//connections
		c[0][0].setConnection(EAST, c[0][1], new Door("hallway", true));
		c[0][1].setConnection(SOUTH, c[1][1], new Door("hallway", true));
		c[1][1].setConnection(SOUTH, c[2][1], new Door("hallway", true));
		c[1][1].setConnection(EAST, c[1][2], new Door("hallway", true));
		c[2][1].setConnection(WEST, c[2][0], new Door("hallway", true));
		c[1][2].setConnection(EAST, c[1][3], new Door("hallway", true));
		c[1][3].setConnection(NORTH, c[0][3], new Door("hallway", true));
		c[1][3].setConnection(SOUTH, c[2][3], new Door("hallway", true));
		//c[2][2].setConnection(SOUTH, c[2][3], new Door("hallway", true));
		c[3][3].setConnection(WEST, c[3][2], new Door("hallway", true));
		c[2][3].setConnection(EAST, c[2][4], new Door("hallway", true));
		c[2][4].setConnection(SOUTH, c[3][4], new Door("hallway", true));
		c[2][4].setConnection(EAST, c[2][5], new Door("hallway", true));
		c[2][5].setConnection(NORTH, c[1][5], new Door("hallway", true));
		c[2][2].setConnection(SOUTH, c[3][2], new Door("hallway", true));
		c[2][2].setConnection(NORTH, c[1][2], new Door("hallway", true));
		c[1][3].setConnection(EAST, c[1][4], new Door("hallway", true));
		
		
		
		//c[3][2].setConnection(NORTH, c[2][2], new Door("hallway", true));
	}
	
}
