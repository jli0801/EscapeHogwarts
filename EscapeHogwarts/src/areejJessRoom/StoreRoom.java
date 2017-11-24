package areejJessRoom;

import java.util.Scanner;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;
import caveExplorer.Inventory;
import caveExplorer.NPC;
import caveExplorer.NPCRoom;

public class StoreRoom extends NPCRoom {

		//press commit not commit push
		//push branch master
		//replace master with areejJessBranch
		//click next
		//next step
		//fetch from upstream
		//under branches there's local and remote tracking
		//remote tracking double click to access other branches

	//private static Scanner inputSource = new Scanner(System.in);
	
	private NPCAJ npc;
	private static boolean userEnter;
	public static Scanner in;

	
	static CaveRoom[][] c = CaveExplorer.caves; 

	public void setUserEnter(boolean userEntered) {
		this.userEnter = userEntered;
	}


	public StoreRoom(String description) {
		super(description);
		//super.getContents();
		userEnter = false;
	
	}

	
	private static String getUserInput()
	{
		 String input =CaveExplorer.in.nextLine().toLowerCase();
		 return input;
	}
	public void printValidMoves()
	{
		System.out.println("You can only enter 'i', 'b', 'm', or 'e' ");
	}
	
	/*public void performAction (int direction)
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
	}*/

	public static void userEntered() {
		if(!userEnter)
		{
		CaveExplorer.print("You've entered the merchant's store. Enter 'i' to interact, 'b' to buy, or 'm' to merge items.");
		userEnter = true;
		}
		
		String userInput = CaveExplorer.in.nextLine();
		
		//same bug as chatbot
		
		if( userInput.equals("i"))
		{
			interactDialogue();
		}
		if(userInput.equals("b"))
		{
			buyItems();
		}
		if(userInput.equals("m"))
		{
			mergeItems();
		}
		if(userInput.equals("e"))
		{
			leaveRoom();
		}
		
	}

	
	


	private static void mergeItems() {
		CaveExplorer.print("So you want to merge some items, I see. You better have all the ingredients or I'll kick you out. Are you sure you have all the items?");
		String input = getUserInput();

		if(input.equals("yes"))
		{
			if(Inventory.hasBroom())
			{
				Inventory.setBroomP1(false);
				Inventory.setBroomP2(false);
				Inventory.setBroomP3(false);
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


	
	private static void leaveRoom() {
		CaveExplorer.currentRoom = c[2][1];
		CaveExplorer.currentRoom.enter();
	}


	private static void buyItems() {
		CaveExplorer.print("What would you like to purchase today?"
				+ "\nWe have freshly made Chocolate Frogs, potions, and some accessories to help with your battles.");
		
	}


	private static void interactDialogue() {
		CaveExplorer.print("Welcome to Hogwart's One and Only Store! You can purchase goods to boost your health. "
				+ "\nIf you have the pieces for to complete the broom, you can choose to merge to create the broom."
				+ "\nTo purchase goods, enter 'b'. To merge the pieces, enter 'm'. To exit the store, enter 'e'");
		userEntered();
		
	}


	public void enter()
	{
		super.enter();

		
	}

}
