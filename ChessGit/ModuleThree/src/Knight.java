
public class Knight extends Piece {

	public Knight(String pieceName, String color, String shortName, String shortColor, String space) {
		super(pieceName, color, shortName, shortColor, space);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean chekMove(int row, int col, boolean saveMove) {
		int[] rowCol = Board.spaceConverter(getSpace());
		String check = Board.checkSpace(row, col);

		boolean canMove = false;
		if(rowCol[0] - row == 2 || rowCol[0] - row == -2) {
			if(rowCol[1] - col == 1 || rowCol[1] - col == -1) {
				if(check == Board.empty || !String.valueOf(check.charAt(2)).equals(shortColor)) {
					canMove = true;
				}
			}
		} else if(rowCol[0] - row == 1 || rowCol[0] - row == -1) {
			if(rowCol[1] - col == 2 || rowCol[1] - col == -2) {
				if(check == Board.empty || !String.valueOf(check.charAt(2)).equals(shortColor)) {
					canMove = true;
				}
			}
		}
		if(canMove && saveMove) {
			space = Board.spaceDeConverter(row, col);
		}
		return canMove;
	}
}
