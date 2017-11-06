package jiVickieRoom;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;
import caveExplorer.Door;
import caveExplorer.NPC;
import caveExplorer.NPCRoom;
//import caveExplorer.Peeves;


public class VickieRoom extends NPCRoom {

	public VickieRoom(String description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	public void printValidMoves()
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
			if(peeves != null && peeves.isActive()) {
				peeves.interact();
			}else {
				CaveExplorer.print("There is no creatures to interect with..");
			}
		}else {
			CaveExplorer.print("There is nothing to do...");
		}
	}
	//dfklbjhetio;jhtiojg
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
				c[row][col] = new NPCRoom("This cave has coordinates " + row+  ", "+col + "and look! Peeves is here! You might want to leave...");
			}
		}
		//3. replace some default rooms with custom rooms(SAVE FOR LATER)
		
		
		
		
		
		//4. set Starting room
		CaveExplorer.currentRoom = c[0][1];
		CaveExplorer.currentRoom.enter();
		
		//5. Set up doors
		c[0][1].setConnection(SOUTH, c[1][1], new Door());
		c[1][1].setConnection(EAST, c[1][2], new Door());
		
		
	}
	
	public boolean containsNPC()
	{
		return here = true;
	}
	
	public void enterNPC(NPC n)
	{
		this.peeves = n;
	}
}
