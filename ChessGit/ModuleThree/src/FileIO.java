import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileIO {
	private BufferedReader read;
	private String line;
	private int placeCounter;
	private int moveCounter;
	private int kingSideCounter;
	private int queenSideCounter;
	private Board board;
	String position;
	private ArrayList<String> moveArrayList;
	private ArrayList<String> placeArrayList;

	public FileIO(InputStream fileName) {
		moveArrayList = new ArrayList<String>();
		placeArrayList = new ArrayList<String>();
		
		board = new Board();
		placeCounter = 0;
		moveCounter = 0;
		kingSideCounter = 0;
		queenSideCounter = 0;
		try {
			read = new BufferedReader(new InputStreamReader(fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> moveArrayList() {
		return moveArrayList;
	}
	
	public ArrayList<String> placeArrayList() {
		return placeArrayList;
	}

	public void comparingLines() {
		String kingSide;
		String kingSide2;
		String queenSide;
		String queenSide2;
		try {
			while((line = read.readLine()) != null) {
				kingSide = "e1 g1 h1 f1";
				kingSide2 = "e8 g8 h8 f8";
				queenSide = "e1 c1 a1 d1";
				queenSide2 = "e8 c8 a8 d8";

				if(line.length() == 9 || line.length() == 4) {
					placement();

				} else if(line.equals(kingSide) || line.equals(kingSide2) || line.equals(queenSide) || line.equals(queenSide2)){
					castlingQueenSide();
					castlingKingSide();

				} else {
					movement();
				}
			}
			System.out.println("Number of placements " + placeCounter);
			System.out.println("Number of moves " + moveCounter);
			System.out.println("Castling King Side: " + kingSideCounter);
			System.out.println("Castling Queen Side: " + queenSideCounter);
//			board.printBoard();
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
			System.out.println(line + " castling King side");
		}
	}



	public void castlingQueenSide() {
		String placementPattern = "[e][18] [c][18] [a][18] [d][18]";
		Pattern pattern = Pattern.compile(placementPattern);
		Matcher match = pattern.matcher(line);
		boolean matched = match.find();

		if(matched) {
			queenSideCounter++;
			System.out.println(line + " castling Queen side");
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



	public ArrayList<String> placement() {		
		String placementPattern = "([KQRPKBN])([LD])([a-h][1-8]) ?([KQRPKB]?)([ld]?)([a-h]?[1-8]?)";
		Pattern pattern = Pattern.compile(placementPattern);
		Matcher match = pattern.matcher(line);
		boolean matched = match.matches();

		if(matched) {
			String pieceName = match.group(1);
			String color = match.group(2);
			position = match.group(3);
			int onePattern = 5;

			if(line.length() > onePattern) {
				String secondPieceName = match.group(4);
				String secondColor = match.group(5);
				String secondPosition = match.group(6);
				String firstValidPosition = line.substring(0,4);
				String secondValidPosition = line.substring(5,9);
				System.out.println(firstValidPosition + " " + matchColor(color) + " " + matchPiece(pieceName) + " placed at " + position);
				System.out.println(secondValidPosition + " " + matchColor(secondColor) + " " + matchPiece(secondPieceName) + " placed at " + secondPosition);
				placeArrayList.add(pieceName + " " + color + " " + position);
				placeArrayList.add(secondPieceName + " " + secondColor + " " + secondPosition);
			} else {
				placeArrayList.add(pieceName + " " + color + " " + position);
				System.out.println(line + " " + matchColor(color) + " " + matchPiece(pieceName) + " placed at " + position);
			}
			placeCounter++;	

		} else {
			System.out.println(line + " Not a match");
		}
		return placeArrayList;
	}



	public ArrayList<String> movement() {
		String movePattern = "([a-h][1-8]) ([a-h][1-8])([\\*]?) ?([a-h]?[1-8]?) ?([a-h]?[1-8]?)([\\*]?)";
		Pattern pattern = Pattern.compile(movePattern);
		Matcher match = pattern.matcher(line);
		boolean matched = match.matches();

		if(matched) {
			position = match.group(1);
			String locationMovingTo = match.group(2);
			String secondPosition = match.group(4);
			String secondLocationMovingTo = match.group(5);
			String captured = match.group(6);
			int secondMove = 6;
			if(line.length() == secondMove) {
				System.out.println(line + " Moved from " + position + " to " + locationMovingTo + " and captured a piece.");
				moveArrayList.add(position + " " + locationMovingTo + " " + captured);
			} else if(line.length() < secondMove) {
				System.out.println(line + " Moved from " + position + " to " + locationMovingTo);
				moveArrayList.add(position + " " + locationMovingTo);

			} else if(!captured.isEmpty()){
				moveArrayList.add(secondPosition + " " + secondLocationMovingTo + " " + captured);
				System.out.println(line.substring(6, 12) + " Moved from " + secondPosition + " to " + secondLocationMovingTo + " and captured a piece.");

			} else {
				moveArrayList.add(position + " " + locationMovingTo);
				moveArrayList.add(secondPosition + " " + secondLocationMovingTo);
				System.out.println(line.substring(0,5) + " Moved from " + position + " to " + locationMovingTo);
				System.out.println(line.substring(6, 11) + " Moved from " + secondPosition + " to " + secondLocationMovingTo);
			}
			moveCounter++;
		} else {
			System.out.println(line + " Not a match");
		}		
		System.out.println(moveArrayList);
		return moveArrayList;
	}
}
