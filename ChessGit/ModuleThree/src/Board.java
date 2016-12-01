import java.util.ArrayList;

public class Board {
	static King kingL;
	static King kingD; 
	private static Queen queenL; 
	private static Queen queenD;
	private static Rook rookL1;
	private static Rook rookL2;
	private static Rook rookD1;
	private static Rook rookD2;
	private static Knight knightL1;
	private static Knight knightL2;
	private static Knight knightD1;
	private static Knight knightD2;
	private static Bishop bishopL1;
	private static Bishop bishopL2;
	private static Bishop bishopD1;
	private static Bishop bishopD2;
	private static Pawn pawnL1;
	private static Pawn pawnL2;
	private static Pawn pawnL3;
	private static Pawn pawnL4;
	private static Pawn pawnL5;
	private static Pawn pawnL6;
	private static Pawn pawnL7; 
	private static Pawn pawnL8; 
	private static Pawn pawnD1; 
	private static Pawn pawnD2; 
	private static Pawn pawnD3; 
	private static Pawn pawnD4; 
	private static Pawn pawnD5; 
	private static Pawn pawnD6; 
	private static Pawn pawnD7; 
	private static Pawn pawnD8; 
	private int width = 9;
	private int height = 9;
	private static String[][] array;
	public static String empty = "|--|";
	protected static Piece setPiece;
	private static int rows;
	private static int cols;

	public static int getRows() {
		return rows;
	}

	public static int getCols() {
		return cols;
	}

	public Board() {
		array = new String[width][height];
		constructBoard();
		kingL = new King("King", "Light", "K", "L", "e1");
		kingD = new King("King", "Dark", "K", "D", "e8");
		queenL = new Queen("Queen", "Light", "Q", "L", "d1");
		queenD = new Queen("Queen", "Dark", "Q", "D", "d8");
		rookL1 = new Rook("Rook", "Light", "R", "L", "a1");
		rookL2 = new Rook("Rook", "Light", "R", "L", "h1");
		rookD1 = new Rook("Rook", "Dark", "R", "D", "a8");
		rookD2 = new Rook("Rook", "Dark", "R", "D", "h8");
		knightL1 = new Knight("Knight", "Light", "N", "L", "b1");
		knightL2 = new Knight("Knight", "Light", "N", "L", "g1");
		knightD1 = new Knight("Knight", "Dark", "N", "D", "b8");
		knightD2 = new Knight("Knight", "Dark", "N", "D", "g8");
		bishopL1 = new Bishop("Bishop", "Light", "B", "L", "c1");
		bishopL2 = new Bishop("Bishop", "Light", "B", "L", "f1");
		bishopD1 = new Bishop("Bishop", "Dark", "B", "D", "c8");
		bishopD2 = new Bishop("Bishop", "Dark", "B", "D", "f8");
		pawnL1 = new Pawn("Pawn", "Light", "P", "L", "a2");
		pawnL2 = new Pawn("Pawn", "Light", "P", "L", "b2");
		pawnL3 = new Pawn("Pawn", "Light", "P", "L", "c2");
		pawnL4 = new Pawn("Pawn", "Light", "P", "L", "d2");
		pawnL5 = new Pawn("Pawn", "Light", "P", "L", "e2");
		pawnL6 = new Pawn("Pawn", "Light", "P", "L", "f2");
		pawnL7 = new Pawn("Pawn", "Light", "P", "L", "g2");
		pawnL8 = new Pawn("Pawn", "Light", "P", "L", "h2");
		pawnD1 = new Pawn("Pawn", "Dark", "P", "D", "a7");
		pawnD2 = new Pawn("Pawn", "Dark", "P", "D", "b7");
		pawnD3 = new Pawn("Pawn", "Dark", "P", "D", "c7");
		pawnD4 = new Pawn("Pawn", "Dark", "P", "D", "d7");
		pawnD5 = new Pawn("Pawn", "Dark", "P", "D", "e7");
		pawnD6 = new Pawn("Pawn", "Dark", "P", "D", "f7");
		pawnD7 = new Pawn("Pawn", "Dark", "P", "D", "g7");
		pawnD8 = new Pawn("Pawn", "Dark", "P", "D", "h7");
	}

	public void constructBoard() {
		int counting = -1;
		for (int rows = 0; rows < array.length; rows++) {
			counting++;
			for(int cols = 0; cols < array.length; cols++) {
				array[rows][cols] = empty;
				array[rows][0] = Integer.toString(counting);
			}
		}
	}

	public static String[][] printBoard() {
		String[][] boardArray = new String[array.length][array.length];
		//		String border = "---------------------------------";
		for (int i = array.length - 1; i > 0; i--) {
			for (int t = 0; t < array.length; t++) {
				boardArray[i][t] = array[i][t];
			}
		}			
		//		System.out.println("   A   B   C   D   E   F   G   H");
		return boardArray;
	}


	public static void updateBoard(String piece, String color, int row, int col) {
		if(piece != empty) {
			array[row][col] = "|" + piece + color +  "|";
		} else {
			array[row][col] = empty;
		}
	}

	public static String checkSpace(int row, int col) {
		return array[row][col];
	}

	public static int[] spaceConverter(String space) {
		int[] spaceArray = new int[2];
		switch(space.charAt(0)) {
		case 'a' : spaceArray[1] = 1;
		break;
		case 'b': spaceArray[1] = 2;
		break;
		case 'c': spaceArray[1] = 3;
		break;
		case 'd': spaceArray[1] = 4;
		break;
		case 'e': spaceArray[1] = 5;
		break;
		case 'f': spaceArray[1] = 6;
		break;
		case 'g': spaceArray[1] = 7;
		break;
		case 'h': spaceArray[1] = 8;
		break;
		}
		spaceArray[0] = Integer.parseInt(String.valueOf(space.charAt(1)));
		return spaceArray;
	}

	public static String spaceDeConverter(int row, int col) {
		String colString = "2";
		switch(col) {
		case 1: colString = "a";
		break;
		case 2: colString = "b";
		break;
		case 3: colString = "c";
		break;
		case 4: colString = "d";
		break;
		case 5: colString = "e";
		break;
		case 6: colString = "f";
		break;
		case 7: colString = "g";
		break;
		case 8: colString = "h";
		break;
		}
		return "" + colString + row;

	}

	public static void grabPiece(String piece, String spot) {
		switch(piece.charAt(2)) {
		case 'L' :
			switch(piece.charAt(1)) {
			case 'K' : setPiece = kingL;
			break;
			case 'Q' : setPiece = queenL;
			break;
			case 'R' : 
				if(spot.equals(rookL1.getSpace())) {
					setPiece = rookL1;
				} else if(spot.equals(rookL2.getSpace())) {
					setPiece = rookL2;
				}
				break;
			case 'B' :
				if(spot.equals(bishopL1.getSpace())) {
					setPiece = bishopL1;
				} else if(spot.equals(bishopL2.getSpace())) {
					setPiece = bishopL2;
				}
				break;
			case 'N' :
				if(spot.equals(knightL1.getSpace())) {
					setPiece = knightL1;
				} else if(spot.equals(knightL2.getSpace())) {
					setPiece = knightL2;
				}
				break;
			case 'P' :
				if(spot.equals(pawnL1.getSpace())) {
					setPiece = pawnL1;
				} else if(spot.equals(pawnL2.getSpace())) {
					setPiece = pawnL2;
				} else if(spot.equals(pawnL3.getSpace())) {
					setPiece = pawnL3;
				} else if(spot.equals(pawnL4.getSpace())) {
					setPiece = pawnL4;
				} else if(spot.equals(pawnL5.getSpace())) {
					setPiece = pawnL5;
				} else if(spot.equals(pawnL6.getSpace())) {
					setPiece = pawnL6;
				} else if(spot.equals(pawnL7.getSpace())) {
					setPiece = pawnL7;
				} else if(spot.equals(pawnL8.getSpace())) {
					setPiece = pawnL8;
				}
				break;
			}
			break;
		case 'D' :
			switch(piece.charAt(1)) {
			case 'K' : setPiece = kingD;
			break;
			case 'Q' : setPiece = queenD;
			break;

			case 'R' : 
				if(spot.equals(rookD1.getSpace())) {
					setPiece = rookD1;
				} else if(spot.equals(rookD2.getSpace())) {
					setPiece = rookD2;
				}
				break;

			case 'B' :
				if(spot.equals(bishopD1.getSpace())) {
					setPiece = bishopD1;
				} else if(spot.equals(bishopD2.getSpace())) {
					setPiece = bishopD2;
				}
				break;

			case 'N' :
				if(spot.equals(knightD1.getSpace())) {
					setPiece = knightD1;
				} else if(spot.equals(knightD2.getSpace())) {
					setPiece = knightD2;
				}
				break;

			case 'P' :
				if(spot.equals(pawnD1.getSpace())) {
					setPiece = pawnD1;
				} else if(spot.equals(pawnD2.getSpace())) {
					setPiece = pawnD2;
				} else if(spot.equals(pawnD3.getSpace())) {
					setPiece = pawnD3;
				} else if(spot.equals(pawnD4.getSpace())) {
					setPiece = pawnD4;
				} else if(spot.equals(pawnD5.getSpace())) {
					setPiece = pawnD5;
				} else if(spot.equals(pawnD6.getSpace())) {
					setPiece = pawnD6;
				} else if(spot.equals(pawnD7.getSpace())) {
					setPiece = pawnD7;
				} else if(spot.equals(pawnD8.getSpace())) {
					setPiece = pawnD8;
				}
				break;
			}
			//		case '-': 
			//			setPiece = null;
			//			break;
		}
	}

	public static void findingBoardSpot(String spot) {
		String[] s = spot.trim().split("");
		switch (s[0]) {
		case "a": cols = 1;
		break;
		case "b": cols = 2;
		break;
		case "c": cols = 3;
		break;
		case "d": cols = 4;
		break;
		case "e": cols = 5;
		break;
		case "f": cols = 6;
		break;
		case "g": cols = 7;
		break;
		case "h": cols = 8;
		break;
		}
		rows = Integer.parseInt(s[1]);
	}

	public static void placement(ArrayList<String> place) {
		String[] placeSplitUp = new String[array.length];
		for (int t = 0; t < place.size(); t++) {		
			String placeToString = place.get(t).toString();
			placeSplitUp = placeToString.split(" ");
			findingBoardSpot(placeSplitUp[2]);
			updateBoard(placeSplitUp[0], placeSplitUp[1], rows, cols);
			grabPiece(checkSpace(rows, cols), placeSplitUp[2]);
		}
	}

	public static void printingBoard() {
		String[][] boardArray = printBoard();
		for (int i = boardArray.length - 1; i > 0; i--) {
			for (int t = 0; t < boardArray.length; t++) {
				System.out.print(boardArray[i][t].toString());
			}
			System.out.println();
		}
		System.out.println("  A   B   C   D   E   F   G   H");
	}

	public static boolean movement(ArrayList<String> move) {
		boolean moved = false;
		for (int t = 0; t < move.size(); t++) {
			String moveToString = move.get(t).toString();
			String[] moveSplitUp = moveToString.split(" ");
			findingBoardSpot(moveSplitUp[0]);
			int startrow = rows;
			int startcol = cols;
			findingBoardSpot(moveSplitUp[1]);	
			grabPiece(checkSpace(startrow, startcol), moveSplitUp[0]);

			if(setPiece != null) {
				moved = setPiece.checkMove(rows, cols, true);
				if(moved) {	
					updateBoard(setPiece.getShortName(), setPiece.getShortColor(), rows, cols);	
					updateBoard(empty, "", startrow, startcol);	
					System.out.println(moveSplitUp[0] + " " + moveSplitUp[1] + " move from " +  moveSplitUp[0] + " to " + moveSplitUp[1] );
					//					} else {	
					if(setPiece.shortColor.equals("D")) {
						if(kingD.check(kingD.space)) {
							updateBoard(empty, "", rows, cols);	
							updateBoard(setPiece.getShortName(), setPiece.getShortColor(), startrow, startcol);	
//							setPiece.checkMove(rows, cols, true);
						}	
					} 
					if(setPiece.shortColor.equals("L")) {
						if(kingL.check(kingL.space)) {
							updateBoard(empty, "", rows, cols);	
							updateBoard(setPiece.getShortName(), setPiece.getShortColor(), startrow, startcol);	
//							setPiece.checkMove(rows, cols, true);
						}
						
					}
					printingBoard();

				}
			}		

		}		
		setPiece = null;
		move.clear();
		return moved;
	}

}
