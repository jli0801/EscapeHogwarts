package caveExplorer;

public class NPCRoom extends CaveRoom {

	private NPC npc;
	
	public NPCRoom(String description) {
		super(description);
	
	}
	public boolean canEnter()
	{
		return npc == null;
	}
	public void enterNPC(NPC n)
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
	//below are replacement from older and classE
	
}
