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
		CaveExplorer.print("So you want to merge some items, I see. You better have all the ingredients or I'll kick you out. Are you sure you have all the items?");
		if(inputCase.equals("yes"))
		{
			if(Inventory.hasBroom())
			{
				Inventory.setBroomP1(Inventory.getBroomP1()-1);
				Inventory.setBroomP2(Inventory.getBroomP2()-1);
				Inventory.setBroomP3(Inventory.getBroomP3()-1);
			}
			else
			{
				CaveExplorer.print("YOU LIED TO ME! GET OUT OF MY STORE!");
				leaveRoom();
			}
		}
		else
		{
			CaveExplorer.print("Get out and find me all pieces before I expell you!");
			leaveRoom();
		}
	}


	private static void buyItems() {
		CaveExplorer.print("")
		
	}


	private static void interactDialogue() {
		
		
	}


	public void enter()
	{
		super.enter();

		
	}

}
