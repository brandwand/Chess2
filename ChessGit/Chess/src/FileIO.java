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

	public void comparingLines() {
		try {
			while((line = read.readLine()) != null) {
				placement();
				movement();
				castlingQueenSide();
				castlingKingSide();
			}
			System.out.println("Number of placements " + placeCounter);
			System.out.println("Number of moves " + moveCounter);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void castlingKingSide() {
		String placementPattern = "[e][18] [g][18] [h][18] [f][18]";
		Pattern pattern = Pattern.compile(placementPattern);
		Matcher match = pattern.matcher(line);
		boolean matched = match.find();
		if(matched) {
			System.out.println("castling King Side");
		}
	}
	
	public void castlingQueenSide() {
		String placementPattern = "[e][18] [f][18] [h][18] [g][18]";
		Pattern pattern = Pattern.compile(placementPattern);
		Matcher match = pattern.matcher(line);
		boolean matched = match.find();
		if(matched) {
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
	}

	public void movement() {
		String placementPattern = "[a-h][1-8] [a-h][1-8]";
		Pattern pattern = Pattern.compile(placementPattern);
		Matcher match = pattern.matcher(line);
		boolean matched = match.find();
		if(matched) {
			System.out.println(line);
			moveCounter++;
		} else {
			System.out.println("Not a match");
		}
	}
}
