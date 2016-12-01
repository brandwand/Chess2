public class King extends Piece {
	private boolean isInCheck = false;
	private boolean checkMate = false;
	public King(String pieceName, String color, String shortName, String shortColor, String space) {
		super(pieceName, color, shortName, shortColor, space);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkMove(int row, int col, boolean saveMove) {
		boolean canMove = false;
		int[] rowCol = Board.spaceConverter(getSpace());
		String check = Board.checkSpace(row, col);
		if(rowCol[0] - row == 1 || rowCol[0] - row == 0 || rowCol[0] - row == -1) {
			if(rowCol[1] - col == 1 || rowCol[1] - col == 0 || rowCol[1] - col == -1) {
				if(check.equals(Board.empty) || !String.valueOf(check.charAt(2)).equals(shortColor)) {
					System.out.println((shortColor + " Is King in Check?"));
					if(!check(Board.spaceDeConverter(row,col))) {
						canMove = true;
					}
				}
			}
		} 
		if(canMove && saveMove) {
			space = Board.spaceDeConverter(row, col);
		}
		return canMove;
	}


	public boolean check(String space) {
		boolean horCheck = false;
		boolean verCheck = false;
		boolean diaCheck = false;
		boolean lCheck = false;

		if(checkHorRight(space) || checkHorLeft(space)) {
			horCheck = true;
		}
		else {
			horCheck = false;
		}
		if(checkVerUp(space) || checkVerDown(space)) {
			verCheck = true;
		}
		else {
			verCheck = false;
		}

		if(checkDiUpRight(space) || checkDiUpLeft(space) || checkDiDownLeft(space) || checkDiDownRight(space)) {
			diaCheck = true;
		}
		else {
			diaCheck = false;
		}

		if(checkLupLeft(space) || checkLUpRight(space) || checkLDownLeft(space) || checkLDownRight(space)) {
			lCheck = true;
		}
		else {
			lCheck = false;
		}


		if(horCheck || verCheck || diaCheck  || lCheck) {
			isInCheck = true;
		}
		else {
			isInCheck = false;
		}

		if(horCheck && verCheck && diaCheck && lCheck) {
			checkMate = true;
		}

		return isInCheck;


	}



	private  boolean checkHorRight(String space) {
		int[] rowCol = Board.spaceConverter(space);
		String check;
		boolean isRight = false;
		//Horizontal -Right 
		for (int i = rowCol[1] + 1; i < 9; i++) {
			check = Board.checkSpace(rowCol[0], i);//whatever the space we are trying to check at the time. 
			if (String.valueOf(check.charAt(2)).equals(shortColor)) {
				isRight = false;
				break;
			}

			if (!String.valueOf(check.charAt(2)).equals(shortColor)) {
				if (String.valueOf(check.charAt(1)).equals("Q") || String.valueOf(check.charAt(1)).equals("R")) {
					isRight = true;
					break;
				}

			}
		}
		return isRight;
	}

	private boolean checkHorLeft(String space) {
		int[] rowCol = Board.spaceConverter(space);
		String check;
		boolean isLeft = false;
		//Horiztonal -Left
		for (int i = rowCol[1] - 1; i >= 1; i--) {
			check = Board.checkSpace(rowCol[0], i);
			if (String.valueOf(check.charAt(2)).equals(shortColor))	{

				isLeft = false;
				break;

			}

			if (!String.valueOf(check.charAt(2)).equals(shortColor)) {
				if (String.valueOf(check.charAt(1)).equals("Q") || String.valueOf(check.charAt(1)).equals("R")) {
					isLeft = true;
					break;
				}

			}

		}
		return isLeft;
	}

	private boolean checkVerUp(String space) {
		int[] rowCol = Board.spaceConverter(space);
		String check;
		boolean isUp = false;

		//Vertical - UP
		for (int i = rowCol[0] - 1; i > 1; i--) {
			check = Board.checkSpace(i, rowCol[1]);
			if (String.valueOf(check.charAt(2)).equals(shortColor)) {
				isUp = false;
				break;
			}
			if (!String.valueOf(check.charAt(2)).equals(shortColor)) {
				if (String.valueOf(check.charAt(1)).equals("Q") || String.valueOf(check.charAt(1)).equals("R")) {
					isUp = true;
					break;
				}
			}
		}
		return isUp;
	}

	private boolean checkVerDown(String space) {
		int[] rowCol = Board.spaceConverter(space);
		String check;
		boolean isDown = false;


		// Vertical - Down

		for (int i = rowCol[0] + 1; i < 9; i++) {
			check = Board.checkSpace(i, rowCol[1]);//whatever the space we are trying to check at the time. 

			if (String.valueOf(check.charAt(2)).equals(shortColor))	{
				isDown = false;
				break;
			}

			if (!String.valueOf(check.charAt(2)).equals(shortColor)) {
				if (String.valueOf(check.charAt(1)).equals("Q") || String.valueOf(check.charAt(1)).equals("R")) {
					isDown = true;
					break;
				}
			}
		}
		return isDown;
	}

	private boolean checkDiUpLeft(String space) {
		int[] rowCol = Board.spaceConverter(space);
		String check;
		boolean isUpLeft = false;

		////Diagnol - UP - Left
		for (int i = rowCol[0]-1; i > 1; i--) {
			for (int j = rowCol[1]-1; j > 1; j--) {
				check = Board.checkSpace(i, j);
				if (rowCol[0] - i == rowCol[1] - j) {
					if (String.valueOf(check.charAt(2)).equals(shortColor)) {
						isUpLeft = false;
						break;
					}

					if (!String.valueOf(check.charAt(2)).equals(shortColor)) {
						if (String.valueOf(check.charAt(1)).equals("Q") || String.valueOf(check.charAt(1)).equals("B")) {
							isUpLeft = true;
							break;
						}
						if(i == rowCol[0] - 1 && j == rowCol[1] - 1) {
							if(String.valueOf(check.charAt(1)).equals("P")) {
								isUpLeft = true;
								break;
							}
						}
					}
				}
			}
		}
		return isUpLeft;
	}

	private boolean checkDiUpRight(String space) {
		int[] rowCol = Board.spaceConverter(space);
		String check;
		boolean isUpRight = false;

		////Diagnol - UP -Right
		outerloop:
		for (int i = rowCol[0] - 1; i > 1; i--) {
			for (int j = rowCol[1] + 1; j < 9; j++) {
				check = Board.checkSpace(i, j);

				if (rowCol[0] - i == j - rowCol[1]) {
					if (String.valueOf(check.charAt(2)).equals(shortColor)) {
						isUpRight = false;
						break outerloop;
					}
					if (!String.valueOf(check.charAt(2)).equals(shortColor)) {
						if (String.valueOf(check.charAt(1)).equals("Q") || String.valueOf(check.charAt(1)).equals("B")) {
							isUpRight = true;
							break outerloop;
						}
						if (i == rowCol[0] - 1 && j == rowCol[1] + 1) {
							if (String.valueOf(check.charAt(1)).equals("P")) {
								isUpRight = true;
								break outerloop;
							}
						}
					}
				}
			}
		}
		return isUpRight;
	}

	private boolean checkDiDownLeft(String space) {
		int[] rowCol = Board.spaceConverter(space);
		String check;
		boolean isDownLeft = false;

		////Diagon - Down -Left
		for (int i = rowCol[0] + 1; i < 9; i++) {
			for (int j = rowCol[1] + 1; j < 9; j++) {
				check = Board.checkSpace(i, j);

				if (i - rowCol[0] == j - rowCol[1]) {
					if (String.valueOf(check.charAt(2)).equals(shortColor)) {
						isDownLeft = false;
						break;
					}
					if (!String.valueOf(check.charAt(2)).equals(shortColor)) {
						if (String.valueOf(check.charAt(1)).equals("Q") || String.valueOf(check.charAt(2)).equals("B")) {
							isDownLeft = true;
							break;
						}

						if (i == rowCol[0] + 1 && j == rowCol[1] + 1) {
							if (String.valueOf(check.charAt(2)).equals("P")) {
								isDownLeft = true;
								break;
							}
						}
					}
				}
			}

		}
		return isDownLeft;
	}

	private boolean checkDiDownRight(String space) {
		int[] rowCol = Board.spaceConverter(space);
		String check;
		boolean isDownRight = false;

		////Diagnol -Down Right
		for (int i = rowCol[0] + 1; i < 9; i++) {
			for (int j = rowCol[1] - 1; j > 1; j--) {
				check = Board.checkSpace(i, j);
				if (i - rowCol[0] == rowCol[1] - j) {
					if (String.valueOf(check.charAt(2)).equals(shortColor)) {
						isDownRight = false;
						break;
					}
					if (!String.valueOf(check.charAt(2)).equals(shortColor)) {
						if (String.valueOf(check.charAt(1)).equals("Q") || String.valueOf(check.charAt(2)).equals("B")) {
							isDownRight = true;
							break;
						}
						if (i == rowCol[0] + 1 && j == rowCol[1] - 1) {
							if (String.valueOf(check.charAt(1)).equals("P")) {
								isDownRight = true;
								break;
							}
						}
					}
				}
			}
		}
		return isDownRight;
	}


	private boolean checkLupLeft(String space)  {
		int[] rowCol = Board.spaceConverter(space);
		String check;
		boolean isLUpLeft = false;
		int horCheck = 2;


		////L UP Left
		for (int i = rowCol[0] - 1; i > rowCol[0] - 2; i--) {
			if (rowCol[0] - i == 1) {
				horCheck = 2;
			}
			else if (rowCol[0] - i == 2) {
				horCheck = 1;
			}

			for (int j = rowCol[1] - horCheck; j < rowCol[1] - horCheck; j++) {
				check = Board.checkSpace(i, j);

				if (!String.valueOf(check.charAt(2)).equals(shortColor)) {
					if (String.valueOf(check.charAt(1)).equals("N")) {
						isInCheck = true;
						break;
					}
				}
			}
		}
		return isLUpLeft;
	}

	private boolean checkLUpRight(String space) 
	{
		int[] rowCol = Board.spaceConverter(space);
		String check;
		boolean isLUpRight = false;
		int horCheck = 2;
		////L UP Right
		for (int i = rowCol[0] - 1; i > rowCol[0] - 2; i--) {
			if (rowCol[0] - i == 1) {
				horCheck = 2;
			}
			else if (rowCol[0] - i == 2) {
				horCheck = 1;
			}
			for (int j = rowCol[1] + horCheck; j > rowCol[1] + horCheck; j--) {
				check = Board.checkSpace(i, j);
				if (!String.valueOf(check.charAt(2)).equals(shortColor)) {
					if (String.valueOf(check.charAt(1)).equals("N")) {
						isInCheck = true;
						break;
					}
				}
			}
		}
		return isLUpRight;
	}

	private boolean checkLDownLeft(String space) {
		int[] rowCol = Board.spaceConverter(space);
		String check;
		boolean isLDownLeft = false;
		int horCheck = 2;
		////L Down Left
		for (int i = rowCol[0] + 1; i < rowCol[0] + 2; i++) {
			if (i - rowCol[0] == 1) {
				horCheck = 2;
			}
			else if (i - rowCol[0] == 2) {
				horCheck = 1;
			}
			for (int j = rowCol[1] - horCheck; j < rowCol[1] - horCheck; j++) {
				check = Board.checkSpace(i, j);

				if (!String.valueOf(check.charAt(2)).equals(shortColor)) {
					if (String.valueOf(check.charAt(1)).equals("N")) {
						isInCheck = true;
						break;
					}
				}
			}
		}
		return isLDownLeft;
	}

	private boolean checkLDownRight(String space) {
		int[] rowCol = Board.spaceConverter(space);
		String check;
		boolean isLDownRight = false;
		int horCheck = 2;
		////L Down Right
		for (int i = rowCol[0] + 1; i < rowCol[0] + 2; i++) {
			if (i - rowCol[0] == 1) {
				horCheck = 2;
			}
			else if (i - rowCol[0] == 2) {
				horCheck = 1;
			}
			for (int j = rowCol[1] + horCheck; j > rowCol[1] + horCheck; j--) {
				check = Board.checkSpace(i, j);

				if (!String.valueOf(check.charAt(2)).equals(shortColor)) {
					if (String.valueOf(check.charAt(1)).equals("N")) {
						isInCheck = true;
						break;
					}
				}
			}
		}	
		return isLDownRight;
	}
}