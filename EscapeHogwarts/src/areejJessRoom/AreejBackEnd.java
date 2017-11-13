package areejJessRoom;

public class AreejBackEnd implements JessicaSupport{

	private AreejSupport frontend;
	private AreejJessBoard[][] board;

	public AreejBackEnd(AreejSupport frontend) {
		this.frontend = frontend;
		board = new AreejJessBoard[6][7];
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
