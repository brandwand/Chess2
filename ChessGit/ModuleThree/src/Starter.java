import java.io.FileInputStream;
import java.io.InputStream;

public class Starter {
	public static FileIO file = null;
	static Game game = new Game();

	public static void main(String[] args) {
		InputStream in = null;
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
		Board.placement(file.placeArrayList());	
		Board.printingBoard();
//		Board.movement(file.moveArrayList());
		game.play();

	}
}