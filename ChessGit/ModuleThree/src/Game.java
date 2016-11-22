import java.io.FileInputStream;
import java.io.InputStream;

public class Game {

	public static void main(String[] args) {
		InputStream in = null;
		FileIO file = null;
		Board board = new Board();
		try {

			if(args.length == 0) {
				in = new FileInputStream("PlaceTests.txt");
			} else {
				in = new FileInputStream(args[0]);
				file = new FileIO(in);
			}		
		} catch(Exception e) {
		}	
		file.comparingLines();

		board.placement(file.placeArrayList());
		board.movement(file.moveArrayList());
		String[][] boardArray = board.printBoard();
		while(!board.movement(file.moveArrayList()).isEmpty()) {
			for (int i = boardArray.length - 1; i > 0; i--) {
				for (int t = 0; t < boardArray.length; t++) {
					System.out.print(boardArray[i][t].toString());
				}
				System.out.println();
			}
			System.out.println("  A   B   C   D   E   F   G   H");
		}
	}
}
