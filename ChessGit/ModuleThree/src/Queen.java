
public class Queen extends Piece {
	
	public Queen(String pieceName, String color, String shortName, String shortColor, String space) {
		super(pieceName, color, shortName, shortColor, space);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean chekMove(int row, int col, boolean saveMove) {
		int[] rowCol = Board.spaceConverter(getSpace());
		boolean canMove = false;

		if(rowCol[0] - row == rowCol[1] - col) {
			if(rowCol[0] - 1 != row && rowCol[1] - 1 != col) {
				for(int i = row + 1; i < rowCol[0]; i++) {
					for(int j = col + 1; j < rowCol[1]; j++) {
						if(rowCol[0] - i == rowCol[1] - j) {
							String check = Board.checkSpace(i, j);
							if(check.equals(Board.empty) && !Board.checkSpace(row, col).equals(shortColor)) {
								canMove = true;
							} else {
								canMove = false;
								break;
							}
						}
					}
				}
			} else if(rowCol[0] - 1 == row && rowCol[1] - 1 == col) {
				for(int i = row; i < rowCol[0]; i++) {
					for(int j = col; j < rowCol[1]; j++) {
						if(rowCol[0] - i == rowCol[1] - j) {
							String check = Board.checkSpace(i, j);
							if(!String.valueOf(check.charAt(2)).equals(shortColor)) {
								canMove = true;
							} else {
								canMove = false;
								break;
							}
						}
					}
				}
			}
		}


		if(rowCol[0] - row == col - rowCol[1]) {
			if(rowCol[0] - 1 != row && rowCol[1] + 1 != col) {
				for(int i = row + 1; i < rowCol[0]; i++) {
					for(int j = col - 1; j > rowCol[1]; j--) {
						if(rowCol[0] - i == j - rowCol[1]) {
							String check = Board.checkSpace(i, j);
							if(check.equals(Board.empty) && !Board.checkSpace(row, col).equals(shortColor)) {
								canMove = true;
							} else {
								canMove = false;
								break;
							}
						}
					}
				}
			} else {
				for(int i = row; i < rowCol[0]; i++) {
					for(int j = col; j > rowCol[1]; j--) {
						if(rowCol[0] - i == j - rowCol[1]) {
							String check = Board.checkSpace(i, j);
							if(!String.valueOf(check.charAt(2)).equals(shortColor)) {
								canMove = true;
							} else {
								canMove = false;
								break;
							}
						}
					}
				}
			}
		}


		if(row - rowCol[0] == rowCol[1] - col) {
			if(rowCol[0] + 1 != row && rowCol[1] - 1 != col) {
				for(int i = row - 1; i > rowCol[0]; i--) {
					for(int j = col + 1; j < rowCol[1]; j++) {
						if(i - rowCol[0] == rowCol[1] - j) {
							String check = Board.checkSpace(i, j);
							if(check.equals(Board.empty) && !Board.checkSpace(row, col).equals(shortColor)) {
								canMove = true;
							} else {
								canMove = false;
								break;
							}
						}
					}		
				}
			} else if(rowCol[0] < row) {
				for(int i = row; i > rowCol[0]; i--) {
					for(int j = col; j < rowCol[1]; j++) {
						if(i - rowCol[0] == rowCol[1] - j) {
							String check = Board.checkSpace(i, j);
							if(!String.valueOf(check.charAt(2)).equals(shortColor)) {
								canMove = true;
							} else {
								canMove = false;
								break;
							}
						}
					}		
				}
			}
		}


		if(row - rowCol[0]  == col - rowCol[1]) {
			if(rowCol[0] - 1 != row && rowCol[1] - 1 != col) {
				for(int i = row - 1; i > rowCol[0]; i--) {
					for(int j = col - 1; j > rowCol[1]; j--) {
						if(i - rowCol[0] == j - rowCol[1]) {
							String check = Board.checkSpace(i, j);
							if(check.equals(Board.empty) && !Board.checkSpace(row, col).equals(shortColor)) {
								canMove = true;
							} else {
								canMove = false;
								break;
							}
						}
					}		
				}
			} else {
				for(int i = row; i > rowCol[0]; i--) {
					for(int j = col; j > rowCol[1]; j--) {
						if(i - rowCol[0] == j - rowCol[1]) {
							String check = Board.checkSpace(i, j);
							if(!String.valueOf(check.charAt(2)).equals(shortColor)) {
								canMove = true;
							} else {
								canMove = false;
								break;
							}
						}
					}		
				}
			}
		}


		if(rowCol[0] == row) {
			if(rowCol[1] - col < 0) {
				if(rowCol[1] - col != -1) {
					for(int i = col - 1; i > rowCol[1]; i--) {
						String check = Board.checkSpace(rowCol[0], i);
						if(check.equals(Board.empty) && !Board.checkSpace(row, col).contains(shortColor)){
							canMove = true;
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
