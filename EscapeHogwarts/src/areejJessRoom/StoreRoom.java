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
	private static boolean inRoom;
	public static Scanner in;

	
	static CaveRoom[][] c = CaveExplorer.caves; 

	public void setUserEnter(boolean userEntered) {
		this.userEnter = userEntered;
	}


	public StoreRoom(String description) {
		super(description);
		//super.getContents();
		userEnter = false;
		inRoom = true; 
	}

	
	private static String getUserInput()
	{
		 String input =CaveExplorer.in.nextLine().toLowerCase();
		 return input;
	}
	

	public static void userEntered() {
		if(!userEnter)
		{
		CaveExplorer.print("Welcome, Harry Potter. You've entered the merchant's store, where all the magic happens.");
		userEnter = true;
		inRoom = true;
		}
		
		while(inRoom)
		{
		CaveExplorer.print("Enter 'i' to interact, 'b' to buy, or 'e' to exit.");
		String userInput = CaveExplorer.in.nextLine();
		
		//same bug as chatbot
		
		if( userInput.equals("i"))
		{
			interactDialogue();
		}
		else if(userInput.equals("b"))
		{
			buyItems();
		}
		else if(userInput.equals("e"))
		{
			leaveRoom();
			inRoom = false;
		}
		else
		{
			CaveExplorer.print("You can only enter 'i', 'b', or 'e' ");
		}
		}
	}

	
	public static void leaveRoom() {
		CaveExplorer.print("Alright, Potter. Begone!");
		CaveExplorer.currentRoom = c[2][5];
		CaveExplorer.currentRoom.enter();
	}


	private static void buyItems() {
		CaveExplorer.print("What would you like to purchase today?"
				+ "\nWe have freshly made Chocolate Frogs, and some potions to help with your battles."
				+ "\nEnter 'c' for Chocolate Frogs or 'p' for some potions. The Chocolate Frogs provide you with 15 HP."
				+ "\nThe potion will randomly give you any amount of HP. Let's see if you get lucky."
				+ "\nThe Chocolate Frogs cost 5 Galleons, while the potions are a bit pricey, at 8 Galleons.");
		String userInput = CaveExplorer.in.nextLine();
		if(userInput.equals("c") && Inventory.getMoney() > 5)
		{
			Inventory.setMoney(Inventory.getMoney() - 5);
			Inventory.setHp(Inventory.getHp() + 15);
			CaveExplorer.print("You have " + Inventory.getHp() + " HP now and " + Inventory.getMoney() + " Galleon(s).");
		}
		if(userInput.equals("p") && Inventory.getHp() > 8)
		{
			int randomHP = (int)(Math.random()*30 +1);
			if (randomHP > 15)
			{
				CaveExplorer.print("Wow, you got luck this time! " + "You got " + randomHP + "!");
			}
			else
			{
				CaveExplorer.print("Oh, not so lucky, Potter. ");
			}
			Inventory.setMoney(Inventory.getMoney() - 8);
			Inventory.setHp(Inventory.getHp() + randomHP);
			CaveExplorer.print("You have " + Inventory.getHp() + " HP now and " + Inventory.getMoney() + " Galleon(s).");
		}
		userEntered();
	}


	private static void interactDialogue() {
		CaveExplorer.print("Welcome to Hogwart's One and Only Store! You can purchase goods to boost your health. "
				+ "\nYou're welcome to try these goods for a price, Potter. Only do it if you dare.."
				+ "\nTo purchase goods, enter 'b'. To exit the store, enter 'e'");
		userEntered();
		
	}


	public void enter()
	{
		super.enter();

		
	}

}
