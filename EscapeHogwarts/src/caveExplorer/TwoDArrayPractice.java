package caveExplorer;

public class TwoDArrayPractice {

	public static void main(String[] args) {
	String[][] pic = new String[6][10];
		for(String[] row: pic)
		{
			for(int col = 0; col <row.length; col++)
			{
				row[col] = " ";
			}
		}
	/*	drawHorizontalLine(pic, 2);
		drawVerticalLine(pic, 3);
		drawSlot(pic, 4, 6);
		drawBox(pic, 5, 8);
		print(pic);*/
	}
//Box looks like this: ___
	//                | * |
	//                |___|
	private static void drawBox(String[][] pic, int i, int j) {
		//i = x j = y
		drawSlot(pic, i,j);
		drawSlot(pic, i+1, j);
		drawAt("_", pic, i+1, j);
		for(int col = j-1; col <= j+1; col++)
		{
			drawAt("_", pic, i, col);
		}
	}

	private static void drawAt(String string, String[][] pic, int row, int col) {
		//always check the row before the column
		//row must exist before a column can exist before it
		if(row >= 0 && row <pic.length && col >=0 && col <pic[row].length)
		{
			pic[row][col] = string;
		}
	}
	//Slot: | | (i,j) left and right
	private static void drawSlot(String[][] pic, int i, int j) {

		if(i >= 0 && i< pic.length)
		{
		
		if(j > 0)
		{
			pic[i][j-1] = "|";
		}
		if(j <pic[i].length-1)
		{
			pic[i][j+1] = "|";
		}
		}
	}

	private static void drawVerticalLine(String[][] pic, int col) {
		for(int i =0; i <pic.length;i++ )
		{
			pic[i][col] = "|";
		}
		
	}

	private static void drawHorizontalLine(String[][] pic, int row) {
		for(int i =0; i <pic[row].length;i++ )
		{
			pic[row][i] = "-";
		}
		
	}

	//prints every string, no array/bracket
	//if you dont care about the content use FOR EACH
	private static void print(String[][] pic) {
		for(int row = 0; row <pic.length; row++){
			for(int col = 0; col < pic[row].length; col++){
				System.out.print(pic[row][col]);
			}
			System.out.println("");
		}
		
		
	}

}
