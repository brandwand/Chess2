import java.util.Scanner;

public class Game {
	static boolean turn = true; // true = white; false = black;
	private boolean done = false;
	private String input;
	private Scanner scan = new Scanner(System.in);

	public void play() {
		while(!done) {
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
							didMove = true;	
							turn = false;
						}
					} else {
						System.out.println("Invalid move");
					}
					//								Starter.file.moveArrayList().clear();
//					Board.printingBoard();
				} else {
					System.out.println("Try again");
				}


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

						if(Board.movement(Starter.file.moveArrayList())) {
							didMove = true;
							turn = true;
						}
					} else {
						//					Starter.file.moveArrayList().clear();
						System.out.println("Invalid move");
					}
					//								Board.printingBoard();
				} else {
					System.out.println("Try Again");
				}
			}
		}
	}
}	