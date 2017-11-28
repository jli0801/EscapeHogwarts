package areejJessRoom;

import java.util.Scanner;
//THEMATIC ROOM S

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
	
	//private NPCAJ npc;
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
			double randomChance = (Math.random()*1);
			if(randomChance > .4)
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
				Inventory.setHp(Inventory.getHp() + randomHP);
			}
			else
			{
				int decreaseHP = (int)(Math.random()*30 +1);
				if(Inventory.getHp() - decreaseHP > 0)
				{
					CaveExplorer.print("Oh no, Potter..YOU LOST HP! These potions are dangerous..time to revisit the recipe.");
					Inventory.setHp(Inventory.getHp() - decreaseHP);
				}
				
			}
			Inventory.setMoney(Inventory.getMoney() - 8);
			CaveExplorer.print("You have " + Inventory.getHp() + " HP now and " + Inventory.getMoney() + " Galleon(s).");
		}
		userEntered();
	}


	private static void interactDialogue() {
		CaveExplorer.print("Welcome to Hogwart's One and Only Store! You can purchase goods to boost your health. Press ENTER to continue.");
		CaveExplorer.in.nextLine();
		CaveExplorer.print("\nSome potions will give you random amounts of HP and some might take HP away. But Chocolate Frogs will always give you 15 HP.");
		CaveExplorer.in.nextLine();
		CaveExplorer.print("It's a gamble, Potter. Only try them if you dare..");
		CaveExplorer.in.nextLine();
		CaveExplorer.print("I reccommend the Chocolate Frogs. They're always a sweet treat. Suitable for all ages");
		CaveExplorer.in.nextLine();
		CaveExplorer.print("The potions, however, are a bit bitter. But you could get a good deal.");
		CaveExplorer.in.nextLine();
		CaveExplorer.print("Well, that's all Potter. Good luck with all your adventures..");
		CaveExplorer.in.nextLine();
		CaveExplorer.print("\nTo purchase goods, enter 'b'. To exit the store, enter 'e'");
		userEntered();
		
	}


	public void enter()
	{
		super.enter();

		
	}

}