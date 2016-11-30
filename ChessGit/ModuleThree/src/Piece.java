import java.util.ArrayList;

public abstract class Piece {
	private String color;
	private String pieceName;
	private String shortName;
	protected String shortColor;
	protected String space;
	public ArrayList<String> availableMoves = new ArrayList<>();
	public Piece() {
		this.pieceName = ("Default");
		this.color = "Default";
		this.shortName = "Default";
		this.setShortColor("Default");
		this.space = "DF";
	}
	
	public Piece(String pieceName, String color, String shortName, String shortColor, String space) {
		this.pieceName = pieceName;
		this.color = color;
		this.shortName = shortName;
		this.setShortColor(shortColor);
		this.space = space;
	}
	public abstract boolean checkMove(int row, int col, boolean saveMove);

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getShortColor() {
		return shortColor;
	}

	public void setShortColor(String shortColor) {
		this.shortColor = shortColor;
	}
	
	public String getSpace() {
		return space;
	}
	
	public void setSpace() {
		this.space = space;
	}
}