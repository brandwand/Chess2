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
			String pieceName = "|" + input.toUpperCase().trim() + "|";
			Starter.file.setLine(input);
			Starter.file.movement();
			Board.movement(Starter.file.movement());
			didMove = true;
			turn = false;
		}	
	}

	public void blackTurn() {
		boolean didMove = false;
		while (!didMove) {
			System.out.println("Black Turn");
			input = scan.nextLine();
			//			if(Board.setPiece)
			//			if(pieceName.contains("Q") || pieceName.contains("K") || pieceName.contains("N") || pieceName.contains("B") || pieceName.contains("R") || pieceName.contains("P")) {
			//				if(pieceName.endsWith("D")) {
			//					if(pieceName.length() == 2) {
			Starter.file.setLine(input);
			Starter.file.movement();
			Board.movement(Starter.file.movement());
			didMove = true;
			turn = true;
			//					}
			//				}
			//		}
		}
	}
}