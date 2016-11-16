
public class placeAndMovement {
	private int rows;
	private int cols;
	private King kingL;
	private King kingD; 
	private Queen queenL; 
	private Queen queenD;
	private Rook rookL1;
	private Rook rookL2;
	private Rook rookD1;
	private Rook rookD2;
	private Knight knightL1;
	private Knight knightL2;
	private Knight knightD1;
	private Knight knightD2;
	private Bishop bishopL1;
	private Bishop bishopL2;
	private Bishop bishopD1;
	private Bishop bishopD2;
	private Pawn pawnL1;
	private Pawn pawnL2;
	private Pawn pawnL3;
	private Pawn pawnL4;
	private Pawn pawnL5;
	private Pawn pawnL6;
	private Pawn pawnL7; 
	private Pawn pawnL8; 
	private Pawn pawnD1; 
	private Pawn pawnD2; 
	private Pawn pawnD3; 
	private Pawn pawnD4; 
	private Pawn pawnD5; 
	private Pawn pawnD6; 
	private Pawn pawnD7; 
	private Pawn pawnD8; 
	public Piece setPiece;


	public placeAndMovement() {
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


	public void grabPiece(String piece, String spot) {
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
			break;
		}
	}
	
	public void findingBoardSpot(String spot) {
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


}
