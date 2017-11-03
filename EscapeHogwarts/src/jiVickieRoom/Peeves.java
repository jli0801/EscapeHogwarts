package jiVickieRoom;

public class Peeves extends NPC {
	//ghost in HP

	
	public static NPC[] characters;
	public Peeves() {
		interact();
	}

	public String getSymbol() {
		return "G";
	}
	
	public void interact() {
		caveExplorer.print("Hahahahaa, I'm off to scare the first years! Hahahhahahaa");
		String s = caveExplorer.in.nextLine();
		while(!s.equalsIgnoreCase("bye")) {
			caveExplorer.print("Yeah.... I don't do that a whole lot.");
			s = caveExplorer.in.nextLine();
		}
		caveExplorer.print("Later, friend!");
	}
}
