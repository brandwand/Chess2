public class Rook extends Piece {
	
	public Rook(String pieceName, String color, String shortName, String shortColor, String space) {
		super(pieceName, color, shortName, shortColor, space);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkMove(int row, int col, boolean saveMove) {
		int[] rowCol = Board.spaceConverter(space);
		boolean canMove = false;

		if(rowCol[0] == row) {
			if(rowCol[1] - col < 0) {
				if(rowCol[1] - col != -1) {
					for(int i = col - 1; i > rowCol[1]; i--) {
						String check = Board.checkSpace(rowCol[0], i);
						if(check.equals(Board.empty) && !Board.checkSpace(row, col).contains(shortColor)){
							canMove = true;
//							System.out.println("Hello");
						} else {
							canMove = false;
							break;
						}
					}
				} else {
					for(int i = col; i > rowCol[1]; i--) {
						String check = Board.checkSpace(rowCol[0], i);
						if(!String.valueOf(check.charAt(2)).equals(shortColor)){
							canMove = true;
//							System.out.println("Hi");
						} else {
							canMove = false;
							break;
						}
					}
				}
			} else if(rowCol[1] - col > 0) {
				if(rowCol[1] - col != 1) {
					for(int i = col + 1; i < rowCol[1]; i++) {
						String check = Board.checkSpace(rowCol[0], i);
						if(check.equals(Board.empty) && !Board.checkSpace(row, col).contains(shortColor)) {
							canMove = true;
//							System.out.println("YO");
						} else {
							canMove = false;
							break;
						}
					}
				} else {
					for(int i = col; i < rowCol[1]; i++) {
						String check = Board.checkSpace(rowCol[0], i);
						if(!String.valueOf(check.charAt(2)).equals(shortColor)) {
							canMove = true;
//							System.out.println("SUP");
						} else {
							canMove = false;
							break;
						}
					}
				}
			} 
		} else if(rowCol[1] == col) {
			if(rowCol[0] - row < 0) {
				if(rowCol[0] - row != -1) {
					for(int i = row - 1; i > rowCol[0]; i--) {
						String check = Board.checkSpace(i, rowCol[1]);
						if(check.equals(Board.empty) && !Board.checkSpace(row, col).contains(shortColor)) {
							canMove = true;
//							System.out.println("YOYO");
						} else {
							canMove = false;
							break;
						}
					}
				} else {
					for(int i = row; i > rowCol[0]; i--) {
						String check = Board.checkSpace(i, rowCol[1]);
						if(!String.valueOf(check.charAt(2)).equals(shortColor)) {
							canMove = true;
//							System.out.println("NEY");
						} else {
							canMove = false;
							break;
						}
					}
				}
			} else if(rowCol[0] - row > 0) {
				if(rowCol[0] - row != 1) {
					for(int i = row + 1; i < rowCol[0]; i++) {
						String check = Board.checkSpace(i, rowCol[1]);
						if(check.equals(Board.empty) && !Board.checkSpace(row, col).contains(shortColor)) {
							canMove = true;
//							System.out.println("SUCKS");
						} else { 
							canMove = false;
							break;
						}
					}
				} else {
					for(int i = row; i < rowCol[0]; i++) {
						String check = Board.checkSpace(i, rowCol[1]);
						if(!String.valueOf(check.charAt(2)).equals(shortColor)) {
							canMove = true;
//							System.out.println("OKAY");
						} else { 
							canMove = false;
							break;
						}
					}
				} 
			}
		}
		if(canMove && saveMove) {
			space = Board.spaceDeConverter(row, col);
		}
		return canMove;
	}
}
