package caveExplorer;

import java.util.Scanner;

public class CaveExplorer {
	public static CaveRoom[][] caves;
	public static Scanner in = new Scanner(System.in); //for user input
	public static CaveRoom currentRoom; //changes depend on user
	public static Inventory inventory;
	public static boolean playing = true;
	public static boolean firstStart = true;
	public static NPC[] npcs;
	
	public static void main(String[] args) {
		
		CaveRoom.setUpCaves();
		inventory = new Inventory();
		startExploring();

	}
	public static void print(String s)
	{
		System.out.println(s);
	}

	public static void startExploring() {
		while (playing)
		{
			
			
			if(firstStart)
			{moveNPCs();
			print("A story line will appear. ***PRESS ENTER*** for the story to progress.");
			CaveExplorer.in.nextLine();
			print("You are Harry Potter.");
			CaveExplorer.in.nextLine();
			print("You've heard Hogsmeade is the best village in the wizardry world and you want to explore it! " );
			CaveExplorer.in.nextLine();
			print("Unfortunately, your mean Uncle and Aunt didn't sign your permission slip so you can't go. ") ;
			CaveExplorer.in.nextLine();
			print("You decide to sneak out of Hogwarts in order to explore it with Ron and Hermione.");
			CaveExplorer.in.nextLine();
			print("You have the Maurauder's Map which shows you the whole map of Hogwarts.");
			CaveExplorer.in.nextLine();
			print("In order to escape, you must navigate through rooms and beat the minigames to get 3 pieces of your broom.");
			CaveExplorer.in.nextLine();
			print("However, certain rooms will be obstacles on your way to merge the three pieces. ");
			CaveExplorer.in.nextLine();
			print("Good luck!");
			firstStart = false;
			}
			
			print(inventory.getDescription());
			print("key");
			print(currentRoom.getDescription());
			print(currentRoom.getDirections());
			print("HP: " + Integer.toString(inventory.getHp()) );
			
			print("What would you like to do?");
			
			currentRoom.interpretInput(in.nextLine());
			
			
		}
		
	}

	public static void setPlaying(boolean playing) {
		CaveExplorer.playing = playing;
	}
	
	public static void moveNPCs() {
		for(NPC n:npcs)
		{
			n.autoMove();
		}
		inventory.updateMap();
	}
	

}
