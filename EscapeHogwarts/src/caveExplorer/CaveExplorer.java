package caveExplorer;

import java.util.Scanner;

public class CaveExplorer {
	public static CaveRoom[][] caves;
	public static Scanner in; //for user input
	public static CaveRoom currentRoom; //changes depend on user
	public static Inventory inventory;
	public static boolean playing = true;
	public static NPC[] npcs;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		CaveRoom.setUpCaves();
		inventory = new Inventory();
		startExploring();

	}
	
	public static void print(String s)
	{
		System.out.println(s);
	}

	private static void startExploring() {
		while (playing)
		{
			moveNPCs();
			print("Welcome!" +
			" In order to get permission to go on a trip, you must visit each of " + "\nthese rooms and defeat all six of them to go." 
					+ " Good luck!");
			
			print(inventory.getDescription());
			print(currentRoom.getDescription());
			print(currentRoom.getDirection());
			print("What would you like to do?");
			currentRoom.interpretInput(in.nextLine());
		}
		
	}

	private static void moveNPCs() {
		for(NPC n:npcs)
		{
			n.autoMove();
		}
		inventory.updateMap();
	}

}
