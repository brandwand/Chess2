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
	private int placeCounter;
	private int moveCounter;
	private int kingSideCounter;
	private int queenSideCounter;
	private int placementLength;
	private int castleLength;

	public FileIO(InputStream fileName) {
		placeCounter = 0;
		moveCounter = 0;
		kingSideCounter = 0;
		queenSideCounter = 0;
		placementLength = 4;
		castleLength = 7;
		try {
			read = new BufferedReader(new InputStreamReader(fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void comparingLines() {
		try {
			while((line = read.readLine()) != null) {
				if(line.length() == placementLength) {
					placement();
				} else if(line.length() > placementLength && line.length() < castleLength){
					movement();
				} else {
					castlingQueenSide();
					castlingKingSide();
				}
			}
			System.out.println("Number of placements " + placeCounter);
			System.out.println("Number of moves " + moveCounter);
			System.out.println("Castling King Side: " + kingSideCounter);
			System.out.println("Castling Queen Side: " + queenSideCounter);
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
			kingSideCounter++;
			System.out.println("castling King side");
		}
	}

	public void castlingQueenSide() {
		String placementPattern = "[e][18] [c][18] [a][18] [d][18]";
		Pattern pattern = Pattern.compile(placementPattern);
		Matcher match = pattern.matcher(line);
		boolean matched = match.find();
		if(matched) {
			queenSideCounter++;
			System.out.println("castling Queen side");
		}
	}

	public String matchPiece(String pieceNameShort) {
		String pieceNameLong = "";
		switch(pieceNameShort) {
		case "K": pieceNameLong = "King";
		break;
		case "Q": pieceNameLong = "Queen";
		break;
		case "R": pieceNameLong = "Rook";
		break;
		case "P": pieceNameLong = "Pawn";
		break;
		case "N": pieceNameLong = "Knight";
		break;
		case "B": pieceNameLong = "Bishop";
		break;
		}
		return pieceNameLong;
	}

	public String matchColor(String colorShort) {
		String colorLong = "";
		switch(colorShort) {
		case "l": colorLong = "white";
		break;
		case "d": colorLong = "black";
		break;
		}
		return colorLong;
	}

	public void placement() {
		String placementPattern = "([KQRPKB])([ld])([a-h][1-8])";
		Pattern pattern = Pattern.compile(placementPattern);
		Matcher match = pattern.matcher(line);
		boolean matched = match.find();

		if(matched) {
			String pieceName = match.group(1);
			String color = match.group(2);
			String position = match.group(3);
			System.out.println(line + " " + matchColor(color) + " " + matchPiece(pieceName) + " placed at " + position);
			placeCounter++;
		} else {
			System.out.println("Not a match");
		}
	}

	public void movement() {
		String placementPattern = "([a-h][1-8]) ([a-h][1-8])[\\*]?";
		Pattern pattern = Pattern.compile(placementPattern);
		Matcher match = pattern.matcher(line);
		boolean matched = match.find();
		int comparedLineLength = 5;
		if(matched) {
			String position = match.group(1);
			String locationMovingTo = match.group(2);
			if(line.length() > comparedLineLength) {
				System.out.println(line + " Moved from " + position + " to " + locationMovingTo + " and captured a piece.");
			} else {
				System.out.println(line + " Moved from " + position + " to " + locationMovingTo);
			}
			moveCounter++;
		} else {
			System.out.println("Not a match");
		}
	}
}
