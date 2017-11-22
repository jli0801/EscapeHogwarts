package caveExplorer;

import java.util.Scanner;

public class CaveExplorer {
	public static CaveRoom[][] caves;
	public static Scanner in; //for user input
	public static CaveRoom currentRoom; //changes depend on user
	public static Inventory inventory;
	public static boolean playing = true;
	public static boolean firstStart = true;
	public static boolean okay = true;
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
			
			if(firstStart)
			{
			print("Welcome!" +
			" In order to get permission to go on a trip, you must visit each of " + "\nthese rooms and defeat all six of them to go." 
			+ " Good luck!");
			firstStart = false;
			}
			
			print(inventory.getDescription());
			
			if(okay) {
			print(currentRoom.getDescription());
			print(currentRoom.getDirections());
			print("HP: " + Integer.toString(inventory.getHp()) );
			
			
			print("What would you like to do?");
			
			currentRoom.interpretInput(in.nextLine());
			}
			
		}
		
	}

	public static boolean isPlaying() {
		return playing;
	}

	public static void setPlaying(boolean playing) {
		CaveExplorer.playing = playing;
	}

	public static boolean isOkay() {
		return okay;
	}

	public static void setOkay(boolean okay) {
		CaveExplorer.okay = okay;
	}

	private static void moveNPCs() {
		for(NPC n:npcs)
		{
			n.autoMove();
		}
		inventory.updateMap();
	}

	

}
