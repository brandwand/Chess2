import java.util.Scanner;

public class Game {
	private boolean turn = true; // true = white; false = black;
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
			Board.findingBoardSpot(inputSplit[0]);
			Board.grabPiece(Board.checkSpace(Board.getRows(), Board.getCols()), inputSplit[0]);
//			if(Board.setPiece.chekMove(Board.getRows(), Board.getCols(), true)) {
				if(Board.setPiece.shortColor.equals("L")) {

					Starter.file.setLine(input);
					Starter.file.movement();
					Board.movement(Starter.file.moveArrayList());
					didMove = true;
					turn = false;
					Starter.file.moveArrayList().clear();
//				}
			} else {
				System.out.println("Try again");
				//				Board.printingBoard();
			}
		}	
	}

	public void blackTurn() {
		boolean didMove = false;
		while (!didMove) {
			System.out.println("Black Turn");
			input = scan.nextLine();
			String[] inputSplit = input.split(" ");
			Board.findingBoardSpot(inputSplit[0]);
			Board.grabPiece(Board.checkSpace(Board.getRows(), Board.getCols()), inputSplit[0]);
//			if(Board.setPiece.chekMove(Board.getRows(), Board.getCols(), true)) {
				if(Board.setPiece.shortColor.equals("D")) {
					Starter.file.setLine(input);
					Starter.file.movement();
					Board.movement(Starter.file.moveArrayList());
					didMove = true;
					turn = true;
					Starter.file.moveArrayList().clear();
//				}
			} else {
				System.out.println("Try Again");
				//				Board.printingBoard();
			}
		}
	}
}