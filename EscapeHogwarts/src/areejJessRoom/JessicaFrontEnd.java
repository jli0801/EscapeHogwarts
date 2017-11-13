package areejJessRoom;

import caveExplorer.CaveExplorer;
import java.util.Scanner;

public class JessicaFrontEnd implements AreejSupport{

	private AreejBackEnd backend;
	public static Scanner in; //for user input
	
	public JessicaFrontEnd() {
		backend = new AreejBackEnd(this);
	}

	public static void main(String[] args) {
		public static Scanner in; //for user input
		JessicaFrontEnd demo = new JessicaFrontEnd();
		demo.play();
	}

	private void play() {
		new JessicaIntro().play();
		CaveExplorer.in.nextLine();
		menu();
	}

	private void menu() {
		System.out.println("Enter 'r' for rules or 'p' to play.");
		
	}

}
