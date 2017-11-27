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
	public CaveRoom[][] c = CaveExplorer.caves;
	
	public VickieRoom(String description) {
		super(description);
	}

	public static void userEntered() {
		if(firstEntered) {
			System.out.println("MYSTERIOUS VOICE: Welcome to my lovely chamber! Tell me, are you Harry Potter?");
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
			//System.out.println("Hmph! Then go and be on your way! ");
			//CaveRoom.print("There's a secret chamber north of here. Do you have the key to open it?");
			/*
			 * if response is yes, check to see if the person really does have the key. 
			 * 		if they dont, say liar! and trap them in the room with a message from snape: even though you're not potter, you're still wandering the halls. 50 points from gryffindor.
			 * 		if they really do have the key (picked up from ji's room, ) open the chamber, and if they go inside, trap them as well? maybe
			 * 
			 * if response is no, then "Hmph, go on and be on your way"
			 */
			notHarry();
			
		}else
		{
			CaveExplorer.print("Sorry, are you Harry? ");
			userEntered();
		}
	}
	
	public static void notHarry() {
		CaveExplorer.print("Did you acquire the silver key?");
		input = CaveExplorer.in.nextLine();
		inputCase = input.toLowerCase();
		
		if(inputCase.equals("yes"))
		{
			//check to see if user v
			if(Inventory.getSilverKey())
			{
				CaveExplorer.print("MYSTERIOUS VOICE: The rooms will be switched.");
				switchRooms();
			}else
			{
				CaveExplorer.setPlaying(false);
				CaveExplorer.print("MYSTERIOUS VOICE: YOU DO NOT HAVE THE KEY! FOR LYING TO ME, YOU ARE TRAPPED HERE UNTILL DUMBLEDORE COMES.");
				CaveExplorer.print("	You failed to meet up with Ron and Hermione.");
				CaveExplorer.print("	-----------GAME OVER----------");
			}
		}else
		if(inputCase.equals("no")) {
			CaveExplorer.print("Hmph! Then be on your way!");
		}
		else {
			notHarry();
		}
	}

	public static void switchRooms() {
		//Size of Caves
				CaveExplorer.caves = new NPCRoom[4][10];
				CaveRoom[][] c = CaveExplorer.caves; //shortcut for accessing CaveExplorer
			
				//Populate with default caves
				for(int row = 0; row < c.length; row++)
				{
					for(int col = 0; col < c[row].length; col++)
					{
						c[row][col] = new NPCRoom("You are at " + row + ", " + col); //change
					}
				}
				
				CaveExplorer.currentRoom = c[2][0];
				CaveExplorer.currentRoom.enter();
				
				if(CaveRoom.isJiRoom() ==false) {
					c[3][1].setContents("2");
				}
				if(CaveRoom.isKRoom() ==false) {
					c[0][4].setContents("4");
				}
				if(CaveRoom.isSRoom() ==false) {
					c[2][7].setContents("3");
				}
				
				if(CaveRoom.isMagicSquare() ==false) {
					c[2][3].setContents("M");
				}
				if(CaveRoom.isConnect4() ==false) {
					c[3][5].setContents("C");
				}
				if(CaveRoom.isLightsOut() ==false) {
					c[0][8].setContents("L");
				}
				
				if(CaveRoom.isStore() ==false) {
					c[3][9].setContents("S");
				}
				
				
				
				//connections
				c[0][1].setConnection(SOUTH, c[1][1], new Door("hallway", true));
				//c[1][1].setConnection(EAST, c[1][2], new Door("hallway", true));
				
				c[1][1].setConnection(SOUTH, c[2][1], new Door("hallway", true));
			//	c[1][1].setConnection(WEST, c[1][0], new Door("hallway", true));
				c[1][1].setConnection(EAST, c[1][2], new Door("hallway", true));
				
			//	c[1][3].setConnection(SOUTH, c[2][3], new Door("hallway", true));
				c[1][3].setConnection(WEST, c[1][2], new Door("hallway", true)); 
				c[1][3].setConnection(EAST, c[1][4], new Door("hallway", true));
			//	c[1][3].setConnection(NORTH, c[0][3], new Door("hallway", true));
				
				c[1][2].setConnection(WEST, c[1][1], new Door("hallway", true));
				
				c[2][1].setConnection(NORTH, c[1][1], new Door("hallway",true));
			
				c[1][4].setConnection(EAST, c[1][5], new Door("hallways",true));
				c[1][5].setConnection(EAST, c[1][6], new Door("hallways",true));
				c[1][6].setConnection(EAST, c[1][7], new Door("hallways",true));
				c[1][4].setConnection(NORTH, c[0][4], new Door("hallways",true));
				c[0][4].setConnection(SOUTH, c[1][4], new Door("hallways",true));
				
				c[1][5].setConnection(SOUTH, c[2][5], new Door("hallways",true));
				c[2][5].setConnection(SOUTH, c[3][5], new Door("hallways",true));
				c[2][5].setConnection(NORTH, c[1][5], new Door("hallways",true));
			//	c[3][1].setConnection(NORTH, c[2][1], new Door("hallway", true));
				
				c[2][1].setConnection(SOUTH, c[3][1], new Door("hallways",true));
				
				//Hallways for thematic
				c[2][0].setConnection(EAST, c[2][1], new Door("hallway", true));
				c[2][3].setConnection(NORTH, c[1][3], new Door("hallway", true));
				c[2][7].setConnection(NORTH, c[1][7], new Door("hallway", true));
				//hall
				c[1][7].setConnection(EAST, c[1][8], new Door("hallway", true));
				c[1][8].setConnection(EAST, c[1][9], new Door("hallway", true));
				c[1][9].setConnection(SOUTH, c[2][9], new Door("hallway", true));
				c[2][9].setConnection(SOUTH, c[3][9], new Door("hallway", true));
				c[0][8].setConnection(SOUTH, c[1][8], new Door("hallway", true));
		
	}

	
	public void setConnection(int direction, CaveRoom anotherRoom, Door door) {
		addRoom(direction, anotherRoom, door);
		anotherRoom.addRoom(oppositeDirection(direction), this, door);
	}
	
	public void goToRoom(int direction) {
		//make sure there is a room to go to:
		if(borderingRooms[direction] != null && doors[direction] != null &&
				doors[direction].isOpen()) 
		{
			
			CaveExplorer.currentRoom.leave();
			CaveExplorer.currentRoom = borderingRooms[direction];
			CaveExplorer.currentRoom.enter();
		}else {
			//print red text
			System.err.println("You can't do that!");
		}
	}

	public static void doorOpens()
	{
		//Size of Caves
		CaveExplorer.caves = new NPCRoom[4][10];
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
		
		CaveExplorer.currentRoom = c[2][0];
		CaveExplorer.currentRoom.enter();
		
		//rooms 	
		if(CaveRoom.isJiRoom() ==false) {
			c[3][2].setContents("2");
		}
		if(CaveRoom.isKRoom() ==false) {
			c[0][9].setContents("4");
		}
		if(CaveRoom.isSRoom() ==false) {
			c[0][3].setContents("3");
		}
		
		if(CaveRoom.isMagicSquare() ==false) {
			c[3][9].setContents("M");
		}
		if(CaveRoom.isConnect4() ==false) {
			c[1][1].setContents("C");
		}
		if(CaveRoom.isLightsOut() ==false) {
			c[0][5].setContents("L");
		}
		
		if(CaveRoom.isStore() ==false) {
			c[1][6].setContents("S");
		}

		//connections
		c[2][0].setConnection(EAST, c[2][1], new Door("hallway", true));
		
		c[1][1].setConnection(SOUTH, c[2][1], new Door("hallway", true));
		c[2][1].setConnection(SOUTH, c[3][1], new Door("hallway", true));
		c[2][1].setConnection(EAST, c[2][2], new Door("hallway", true));
		
		c[2][2].setConnection(EAST, c[2][3], new Door("hallway", true));
		c[3][2].setConnection(EAST, c[3][3], new Door("hallway", true));
		
		c[0][3].setConnection(EAST, c[0][4], new Door("hallway", true));
		c[2][3].setConnection(SOUTH, c[3][3], new Door("hallway", true));
		c[3][3].setConnection(EAST, c[3][4], new Door("hallway", true));
		
		c[0][4].setConnection(SOUTH, c[1][4], new Door("hallway", true));
		c[1][4].setConnection(EAST, c[1][5], new Door("hallway", true));
		c[3][4].setConnection(EAST, c[3][5], new Door("hallway", true));
		
		c[1][5].setConnection(SOUTH, c[2][5], new Door("hallway", true));
		c[2][5].setConnection(SOUTH, c[3][5], new Door("hallway", true));
		c[1][5].setConnection(EAST, c[1][6], new Door("hallway", true));
		c[3][5].setConnection(EAST, c[3][6], new Door("hallway", true));
		c[0][5].setConnection(EAST, c[0][6], new Door("hallway", true));
		
		c[0][6].setConnection(SOUTH, c[1][6], new Door("hallway", true));
		c[0][6].setConnection(EAST, c[0][7], new Door("hallway", true));
		c[3][6].setConnection(EAST, c[3][7], new Door("hallway", true));
		
		c[0][7].setConnection(EAST, c[0][8], new Door("hallway", true));
		c[2][7].setConnection(EAST, c[2][8], new Door("hallway", true));
		c[2][7].setConnection(SOUTH, c[3][7], new Door("hallway", true));
		
		c[0][8].setConnection(EAST, c[0][9], new Door("hallway", true));
		c[0][8].setConnection(SOUTH, c[1][8], new Door("hallway", true));
		c[1][8].setConnection(SOUTH, c[2][8], new Door("hallway", true));
		c[2][8].setConnection(EAST, c[2][9], new Door("hallway", true));
		
		c[2][9].setConnection(SOUTH, c[3][9], new Door("hallway", true));
	}
	
	public String getDirections()
	{
		return "";
	}
}
