import java.util.Scanner;

public class Game {
	static boolean turn = true; // true = white; false = black;
	private boolean done = false;
	private String input;
	private Scanner scan = new Scanner(System.in);

	public void play() {
		while(!done) {
			if(Board.kingL.Check(Board.kingL.getSpace())) {
				System.out.println("Light king in check");
				//								updateBoard(empty, "", startrow, startcol);	
				//								updateBoard(setPiece.getShortName(),setPiece.getShortColor(),rows, cols);	
			} else {
				System.out.println("Nope");
			}
			if(Board.kingD.Check(Board.kingD.getSpace())) {
				System.out.println("Dark king in check");
				//								updateBoard(empty, "", startrow, startcol);	
				//								updateBoard(setPiece.getShortName(),setPiece.getShortColor(),rows, cols);	
			} else {
				System.out.println("Nope");
			}		
			if(turn) {
				whiteTurn();
			} else {
				blackTurn();
			}
		}
	}

	public void whiteTurn() {
		boolean didMove = false;
		while (!didMove) {			

			System.out.println("White Turn");
			input = scan.nextLine();	
			String[] inputSplit = input.split(" ");
			Starter.file.setLine(input);
			Starter.file.movement();
			if(Starter.file.matched) {
				Board.findingBoardSpot(inputSplit[0]);
				int startRow = Board.getRows();
				int startCol = Board.getCols();
				Board.findingBoardSpot(inputSplit[1]);
				Board.grabPiece(Board.checkSpace(startRow,startCol), inputSplit[0]);
				if(Board.setPiece != null) {		
					if(Board.setPiece.shortColor.equals("L")) {	

						if(Board.movement(Starter.file.moveArrayList())) {
							if(!Board.kingL.Check(Board.kingL.space)) {
								didMove = true;	
								turn = false;
							}
						}
						
					} else {
						System.out.println("Invalid move");
					}
					//					Board.printingBoard();
				} else {
					System.out.println("Try again");
				}

				Starter.file.moveArrayList().clear();

			}
		}
	}

	public void blackTurn() {
		boolean didMove = false;
		while (!didMove) {
			System.out.println("Black Turn");
			input = scan.nextLine();
			String[] inputSplit = input.split(" ");
			Starter.file.setLine(input);
			Starter.file.movement();
			if(Starter.file.matched) {
				Board.findingBoardSpot(inputSplit[0]);
				int startRow = Board.getRows();
				int startCol = Board.getCols();
				Board.findingBoardSpot(inputSplit[1]);
				Board.grabPiece(Board.checkSpace(startRow,startCol), inputSplit[0]);
				if(Board.setPiece != null) {
					if(Board.setPiece.shortColor.equals("D")) {
								didMove = true;

						if(Board.movement(Starter.file.moveArrayList())) {
							if(!Board.kingD.Check(Board.kingD.space)) {
								turn = true;
							}
						}
					} else {
						System.out.println("Invalid move");
					}
					//								Board.printingBoard();
				} else {
					System.out.println("Try Again");
				}
			}
			Starter.file.moveArrayList().clear();
		}											

	}
}	