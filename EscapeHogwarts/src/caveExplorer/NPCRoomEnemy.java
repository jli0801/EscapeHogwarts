package caveExplorer;

public class NPCRoomEnemy extends NPCRoom {

private NPCEnemy npcEnemy;
	
	public NPCRoomEnemy(String description) {
		super(description);
	
	}
	public boolean canEnter()
	{
		return npcEnemy == null;
	}
	public void enterNpcEnemy(NPCEnemy n)
	{
		this.npcEnemy = n;
	}
	public void leaveNpcEnemy()
	{
		this.npcEnemy = null;
	}
	public boolean containsNpcEnemy()
	{
		return npcEnemy != null;
	}
	
	public void printValidMoves()
	{
		System.out.println("You can only enter 'w', 'a'. 's'. d'");
	}
	
	public void performAction (int direction)
	{
		if(direction == 4) {
			NPCEnemy.startFight();
		}else {
			CaveExplorer.print("That key does nothing.");
		}
	}

}
