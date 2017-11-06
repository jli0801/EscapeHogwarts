package areejJessRoom;

import caveExplorer.CaveExplorer;
import caveExplorer.NPC;
import caveExplorer.NPCRoom;

public class JessRoom extends NPCRoom {

		//press commit not commit push
		//push branch master
		//replace master with areejJessBranch
		//click next
		//next step
		//fetch from upstream
		//under branches there's local and remote tracking
		//remote tracking double click to access other branches
	private NPCAJ npc;
		
	public JessRoom(String description) {
		super(description);
		
	}
	public boolean canEnter()
	
	{
		return npc == null;
	}
	public void enterNPC(NPCAJ n)
	{
		this.npc = n;
	}
	public void leaveNPC()
	{
		this.npc = null;
	}
	public boolean containsNPC()
	{
		return npc != null;
	}
	
	public void printValidMoves()
	{
		System.out.println("You can only enter 'w', 'a'. 's'. d'");
	}
	
	public void performAction (int direction)
	{
		if(direction == 4) {
			if(npc != null && npc.isActive()) {
				npc.interact();
			}else {
				CaveExplorer.print("There is nothing to interect with.");
			}
		}else {
			CaveExplorer.print("That key does nothing.");
		}
	}

}
