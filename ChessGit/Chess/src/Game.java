import java.io.FileInputStream;
import java.io.InputStream;

public class Game {

	public static void main(String[] args) {
		InputStream in = null;
		try {
			if(args.length == 0) {
				in = new FileInputStream("PlaceTests.txt");
			} else {
				in = new FileInputStream(args[0]);
				FileIO file = new FileIO(in);
				file.comparingLines();
			}		
		} catch(Exception e) {

		}	
	}
}
