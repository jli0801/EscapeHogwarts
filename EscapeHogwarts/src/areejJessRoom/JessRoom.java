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
	
	static String input = CaveExplorer.in.nextLine();
	static String inputCase = input.toLowerCase();

	public JessRoom(String description) {
		super(description);
		//super.getContents();
		
	}

	
	public void printValidMoves()
	{
		System.out.println("You can only enter 'i', 'b', 'm', '' ");
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
		CaveExplorer.print("You've entered the merchant's store. Enter 'i' to interact, 'b' to buy, or 'm' to merge items.");
		
		
		//same bug as chatbot
		
		if( inputCase.equals("i"))
		{
			interactDialogue();
		
		}
		if(inputCase.equals("b"))
		{
			buyItems();
		}
		if(inputCase.equals("m"))
		{
			mergeItems();
		}
		
		}

	
	private static void mergeItems() {
		
		
	}


	private static void buyItems() {
		
		
	}


	private static void interactDialogue() {
		
		
	}


	public void enter()
	{
		super.enter();

		
	}

}
