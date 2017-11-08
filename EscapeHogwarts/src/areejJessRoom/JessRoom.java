package areejJessRoom;

import java.util.Scanner;

import caveExplorer.CaveExplorer;
import caveExplorer.Inventory;
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
	private static Scanner inputSource = new Scanner(System.in);
	
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
	public static void userEntered() {
		CaveExplorer.print("You've entered Jessica's cave. How unfortunate."
				+ "\nYou just lost 25 HP.");
		int userHp = Inventory.getHp() - 25;
		Inventory.setHp(userHp);
		CaveExplorer.print("Your HP is now: " + userHp + ". To get it back, you have answer a riddle."
				+ "\nWhat comes down but doesn't go up?");
		//same bug as chatbot
		if(inputSource.nextLine().equals("Rain") || inputSource.nextLine().equals("rain"))
		{
			CaveExplorer.print("Fine. You win. You can get back you 25 HP.");
			userHp = Inventory.getHp() + 25;
			Inventory.setHp(userHp);
			CaveExplorer.print("Your HP is now: " + userHp + ". Now leave my cave!");
		}
		else
		{
			CaveExplorer.print("HA! You got it wrong! Let me take another 25 HP from you.");
			userHp = Inventory.getHp() - 25;
			Inventory.setHp(userHp);
			CaveExplorer.print("Your HP is now: " + userHp + ". Get out of my room now.");
		}
		
	}

}
