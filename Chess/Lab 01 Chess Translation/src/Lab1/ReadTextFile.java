package Lab1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadTextFile {

	private BufferedReader read;
	private String line;

	public ReadTextFile(InputStream fileName) {
		try {
			read = new BufferedReader(new InputStreamReader(fileName));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void getMoves() {
		String pattern = "([\\s]*([PKQBRN]?)([ld]?)([a-h][1-8])([-x]?)([[a-h][1-8]]{2}|{0})([+#]?)[\\s]*)([\\s]*([PKQBRN]?)([ld]?)([a-h]?[1-8]?)([-x]?)([[a-h][1-8]]{2}|{0})([+#]?)[\\s]*)";
		Pattern p = Pattern.compile(pattern);
		Matcher m;
		try {
			while((line = read.readLine()) != null) {				
				if(line.trim().matches("O-O")) {
					System.out.println(line + " Black castle King's side.");
				} else if(line.matches("O-O-O")) {
					System.out.println(line + " White castle Queen's side.");
				}
				m = p.matcher(line);
				boolean matches = m.find();	
				if(matches) {
					String piece = m.group(2);
					String pieceName = null;
					switch (piece) {
					case "Q": pieceName = "Queen";
					break;
					case "K": pieceName = "King";
					break;
					case "R": pieceName = "Rook";
					break;
					case "": pieceName = "Pawn";
					break;
					case "N": pieceName = "Knight";
					break;
					case "B": pieceName = "Bishop";
					break;
					case "P": pieceName = "Pawn";
					break;
					}
					String pieces = m.group(9);
					String pieceName2 = null;
					switch (pieces) {
					case "Q": pieceName2 = "Queen";
					break;
					case "K": pieceName2 = "King";
					break;
					case "R": pieceName2 = "Rook";
					break;
					case "": pieceName2 = "Pawn";
					break;
					case "N": pieceName2 = "Knight";
					break;
					case "B": pieceName2 = "Bishop";
					break;
					case "P": pieceName2 = "Pawn";
					break;
					}
					String piece2 = m.group(3);
					String pieceColor = null;
					switch (piece2) {
					case "l": pieceColor = "White";
					break;
					case "d": pieceColor = "Black";
					break;
					}
					String piece3 = m.group(5);
					String pieceCaptured = null;
					switch (piece3) {
					case "-": pieceCaptured = "Move";
					break;
					case "x": pieceCaptured = "Captured";
					break;
					}
					String piece4 = m.group(12);
					String pieceCaptured2 = null;
					switch (piece4) {
					case "-": pieceCaptured2 = "Move";
					break;
					case "x": pieceCaptured2 = "Captured";
					break;
					}
					String checkOrMate = null;
					if(m.group(7).equals("+") || m.group(14).equals("+")) {
						checkOrMate = "Check";
					} else if(m.group(7).equals("#") || m.group(14).equals("#")) {
						checkOrMate = "Check Mate";
					}
					if(line.startsWith("//")) {

					} else if(m.group(10).isEmpty() && !m.group(8).isEmpty() || m.group(10).contains("d")) {
						System.out.println(m.group(8) + " Black " + pieceName2 + " move from " + m.group(11) + " to " + m.group(13));
//						if(pieceCaptured2.equals("Captured")) {
//							System.out.println(m.group(8) + " " + pieceName2 + " move from " + m.group(11) + " to " + m.group(13) + " and Captured oponents piece ");

//						}
				    } else if(m.group(6).isEmpty() && line.length() > 5 ) {
						System.out.println("Error: position out of range");
					} else if(checkOrMate != null && pieceCaptured.equals("Captured") && pieceColor != null) {
						System.out.println(m.group(0) + " " + pieceColor + " " + pieceName + " move from " + m.group(4) + " to " + m.group(6) + " and Captured oponents piece " + checkOrMate);
					} else if(checkOrMate != null && pieceColor != null) {
						System.out.println(m.group(0) + " " + pieceColor + " " + pieceName + " move from " + m.group(4) + " to " + m.group(6) + " " + checkOrMate);
					} else if(!m.group(6).isEmpty() && pieceCaptured.equals("Captured") && pieceColor != null) {
						System.out.println(m.group(0) + " " + pieceColor + " " + pieceName + " move from " + m.group(4) + " to " + m.group(6) + " and Captured oponents piece ");
					} else if(!m.group(6).isEmpty() && pieceColor != null) {
						System.out.println(m.group(0) + " " + pieceColor + " " + pieceName + " " + pieceCaptured + " from " + m.group(4) + " to " + m.group(6));
					} else if(m.group(6).isEmpty() && pieceColor != null) {
						System.out.println(m.group(0) + " " + pieceColor + " " + pieceName + " Position at " + m.group(4));
					} else if(m.group(3).isEmpty()) {
						if(checkOrMate != null && pieceCaptured.equals("Captured")) {
							System.out.println(m.group(1).trim() + " White " + pieceName + " move from " + m.group(4) + " to " + m.group(6) + " and Captured oponents piece " + checkOrMate);
						} else if(checkOrMate != null) {
							System.out.println(m.group(1).trim() + " White " + pieceName + " move from " + m.group(4) + " to " + m.group(6) + " " + checkOrMate);
						} else if(!m.group(6).isEmpty() && pieceCaptured.equals("Captured")) {
							System.out.println(m.group(1).trim() + " White " + pieceName + " move from " + m.group(4) + " to " + m.group(6) + " and Captured oponents piece ");
						} else if(!m.group(6).isEmpty()) {
							System.out.println(m.group(1).trim() + " White " + pieceName + " " + pieceCaptured + " from " + m.group(4) + " to " + m.group(6));
						} 
					} else {
						System.out.println("Unknown Error");
					}	
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}