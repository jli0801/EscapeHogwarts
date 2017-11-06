package jiVickieRoom;

import caveExplorer.CaveExplorer;
import caveExplorer.NPC;

public class Peeves extends NPC {
	//ghost in HP


	public Peeves() {
		this.setActiveDescription("Peeves is floating in the room with you, "
				+ "waiting to talk to you. He has a mischevious smile on his face. Press 'e' to talk");
		
		this.inactiveDescription = "The ghost you talked to earlier is still here, ready to start that game";
		interact();
	}

	public String getSymbol() {
		return "G";
	}
	
	public void interact() {
		CaveExplorer.print("Hahahahaa, Let's play a game!!!!!!!!! Hahahhahahaa");
		String s = CaveExplorer.in.nextLine();
		while(!s.equalsIgnoreCase("bye")) {
			CaveExplorer.print("Yeah.... Whatever..");
			s = CaveExplorer.in.nextLine();
		}
		CaveExplorer.print("Later - I'm off to scare the otherss! Ahahahhaahhaa");
	}
	
	//fghfg
}
