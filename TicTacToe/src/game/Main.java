package game;

import java.util.Scanner;

//The Main class contains the code that allows the game to run and the players to play the game.
//It contains the code that calls methods from the gameBoard and Player class.
//It contains a method that switches the player in turn every move.
//Contains for loops, while loops and if statements in the code that allow the players to 
//play the game until winning conditions are met.
public class Main {

	//This piece of code allows each player to enter their name.
	//It assigns each player a piece ( X or O ).
	//It prints the field of play.
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("PLayer 1 enter your name:");
		String player1name = scan.nextLine();
		System.out.println("PLayer 2 enter your name:");
		String player2name = scan.nextLine();
		Player player1 = new Player(player1name);
		player1.setPiece('X');
		Player player2 = new Player(player2name);
		player2.setPiece('O');
		System.out.println("Enter number of rows:");
		int rows = scan.nextInt();
		System.out.println("Enter number of columns:");
		int columns = scan.nextInt();
		gameBoard board = new gameBoard(rows,columns);
		Player playerinturn = player1;

		//The while true loop allows the game to keep going until winning conditions are met.
		//It contains the code that allows the players to actually play the game.
		while (true) {
			System.out.println("Player in turn is: " + playerinturn.getName());
			board.printBoard();
			//This piece of code is for entering the row position of the piece.
			//It warns the player if they enter an invalid row position.
			System.out.println("Enter row position :");
			int row = scan.nextInt();
			while (row > rows || row < 1) {
				System.out.println("Enter a valid row position :");
				row = scan.nextInt();
			}
			//This piece of code is for entering the column position of the piece.
			//It warns the player if they enter an invalid column position.
			System.out.println("Enter column position :");
			int column = scan.nextInt();
			while (column > columns || column < 1) {
				System.out.println("Enter a valid column position :");
				column = scan.nextInt();
			}
			//This if statement prevents players from placing a piece in a position that is already occupied.
			if(board.getFieldOfPlay()[row-1][column-1]!=' ') {
				System.out.println("Field is already occupied!!");
				System.out.println("Please enter a different position");
				continue;
			}
			board.placePiece(row, column, playerinturn.getPiece());
			//This piece of code checks if a player has won and game has ended 
			//by calling the checkWinner method from gameBoard and announces the winner.
			if (board.checkWinner(playerinturn.getPiece()) == true) {
				board.printBoard();
				System.out.println("===========================================");
				System.out.println("The winner is : " + playerinturn.getName());
				System.out.println("===========================================");
				break;
			}
			//This piece of code checks if the players are at a draw
			//by calling the checkDraw method from gameBoard and announces the draw.
			if (board.checkDraw(player1, player2) == true) {
				board.printBoard();
				System.out.println("The result is a draw !");
				break;
			}
			//This line is calling the switchPlayer method to allow for switching turns after every move.
			playerinturn=switchPlayer(player1,player2,playerinturn);	
		}
	}
	
	//This method switches the player in turn, using an if statement comparing the current player 
	//to the player in turn, and returns the new player assigned to be the player in turn.
	public static Player switchPlayer(Player player1, Player player2, Player playerinturn) {
		if (playerinturn == player1) {
			playerinturn = player2;
		} else {
			playerinturn = player1;
		}
		return playerinturn;
	}
}
