package game;

//This class contains information about the players of the game.
//It allows the setting of each player's name. Contains setter and getter for name.
//It allows the setting of each player's piece. Contains setter and getter for piece.
public class Player {
	private String name;
	private char piece;
	
	//This is a constructor for the class Player.
	//It takes String name as a parameter, this is the name set for the player.
	public Player(String name) {
		this.name= name;		
	}

	//Getter for the player's name, returns the name.
	public String getName() {
		return name;
	}

	//Setter for the player's name.
	//It takes the name as a parameter.
	public void setName(String name) {
		this.name = name;
	}

	//Getter for the player's piece, returns the piece.
	public char getPiece() {
		return piece;
	}

	//Setter for the player's piece.
	//It takes the piece as a parameter.
	public void setPiece(char piece) {
		this.piece = piece;
	}
}
