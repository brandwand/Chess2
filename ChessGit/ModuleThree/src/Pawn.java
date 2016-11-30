
public class Pawn extends Piece {
	boolean isFirst = true;
	public Pawn(String pieceName, String color, String shortName, String shortColor, String space) {
		super(pieceName, color, shortName, shortColor, space);
	}

	@Override
	public boolean checkMove(int row, int col, boolean saveMove) {
		boolean canMove = false;
		int[] rowCol = Board.spaceConverter(getSpace());
		String check = Board.checkSpace(row, col);
		if(shortColor.equals("D")) {
			if(rowCol[0] - row == 2 && col == rowCol[1]) {
				if(isFirst) {
					if(check.equals(Board.empty)) {
					isFirst = false;
					canMove = true;
					}
				}
			}
			if(rowCol[0] - 1 == row && rowCol[1] + 1 == col && !check.equals(Board.empty) && !String.valueOf(check.charAt(2)).equals(shortColor)) {
				canMove = true;
			} else if(rowCol[0] - 1 == row && rowCol[1] - 1 == col && !check.equals(Board.empty) && !String.valueOf(check.charAt(2)).equals(shortColor)) {
				canMove = true;
			}
			if(rowCol[0] - row == 1 && col == rowCol[1]) {
				if(check.equals(Board.empty)) {
				canMove = true;
				isFirst = false;
				}
			}
		} else if(shortColor.equals("L")) {
			if(row - rowCol[0] == 2 && col == rowCol[1]) {
				if(isFirst) {
					if(check.equals(Board.empty)) {
					isFirst = false;
					canMove = true;
					}
				}
			}
			if(rowCol[0] + 1 == row && rowCol[1] - 1 == col && !check.equals(Board.empty) && !String.valueOf(check.charAt(2)).equals(shortColor)) {
				canMove = true;
			} else if(rowCol[0] + 1 == row && rowCol[1] + 1 == col && !check.equals(Board.empty) && !String.valueOf(check.charAt(2)).equals(shortColor)) {
				canMove = true;
			}
			if(row - rowCol[0] == 1 && col == rowCol[1]) {
				System.out.println(isFirst);
				if(check.equals(Board.empty)) {
				canMove = true;
				isFirst = false;
				}
			}
		}
		if(canMove && saveMove) {
			space = Board.spaceDeConverter(row, col);
		}
		return canMove;
	}
}