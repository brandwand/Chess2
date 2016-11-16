
public class King extends Piece {
//	Board board = new Board();
	
	public King(String pieceName, String color, String shortName, String shortColor, String space) {
		super(pieceName, color, shortName, shortColor, space);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean chekMove(int row, int col) {
		boolean canMove = false;
		int[] rowCol = Board.spaceConverter(getSpace());
		String check = Board.checkSpace(row, col);
		if(rowCol[0] - row == 1 || rowCol[0] - row == 0 || rowCol[0] - row == -1) {
			if(rowCol[1] - col == 1 || rowCol[1] - col == 0 || rowCol[1] - col == -1) {
				if(check.equals(Board.empty) || !String.valueOf(check.charAt(2)).equals(shortColor)) {
					canMove = true;
				}
			}
		}
		if(canMove) {
			space = Board.spaceDeConverter(row, col);
		}
		return canMove;
	}
}
