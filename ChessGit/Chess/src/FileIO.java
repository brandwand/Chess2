import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileIO {
	private BufferedReader read;
	private String line;
	private int placeCounter = 0;
	private int moveCounter = 0;

	public FileIO(InputStream fileName) {
		try {
			read = new BufferedReader(new InputStreamReader(fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void checkEverything() {
		try {
			while((line = read.readLine()) != null) {
				placement();
				movement();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void placement() {

		String placementPattern = "[KQRPKB][ld][a-h][1-8]";
		Pattern pattern = Pattern.compile(placementPattern);
		Matcher match = pattern.matcher(line);
		boolean matched = match.find();
			if(matched) {
				System.out.println(line);
				placeCounter++;
			} else {
				System.out.println("Not a match");
			}
			System.out.println("Number of placements " + placeCounter);
	}

	public void movement() {
		String placementPattern = "[a-h][1-8]\\s[a-h][1-8]";
		Pattern pattern = Pattern.compile(placementPattern);
		Matcher match = pattern.matcher(line);
		boolean matched = match.find();
			if(matched) {
				System.out.println(line);
				moveCounter++;
			} else {
				System.out.println("Not a match");
			}
			System.out.println("Number of moves " + moveCounter);
	}
}
