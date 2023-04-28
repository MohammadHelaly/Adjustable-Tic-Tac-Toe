package game;

import java.util.Scanner;

//This class contains the methods which are the building blocks of our functional tictactoe game.
//It contains the construction of a game board and a method to print it.
//It contains a method to place the pieces in the game board.
//It contains a method to check if a player has won the game either by connecting 3 pieces vertically,horizontally or diagonally.
//It contains a method to check if a draw takes place and neither player wins.
public class gameBoard {
	private int rows;
	private int columns;
	private char[][] fieldOfPlay;
	private boolean finishGame = false;
    //This is a constructor for the class gameBoard.
	//Constructs a 2D array with all the positions as spaces, these will be the empty positions on the game board.
    public gameBoard(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        fieldOfPlay = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                fieldOfPlay[i][j] = ' ';
            }
        }
    }
	
    //This method prints the game board the players will use.
	//It also prints dividing lines to have a clear shape of the game board and distinct locations for the pieces.
	//It also prints numbers next to and on top of the field of play to number the positions and be more user-friendly.
	public void printBoard() {
		System.out.print("  ");
		for(int d = 0; d<columns;d++) {
			System.out.print((d+1)+"  ");
		}
		System.out.print("\n");
		//System.out.println("  1  2  3  4  5  6  7");
		for (int i = 0; i < rows; i++) {
			String rowAsString = (i + 1) + "|";
			for (int j = 0; j < columns; j++) {
				rowAsString += fieldOfPlay[i][j] + " |";
			}
			if (i == rows - 1) {
				System.out.println(rowAsString);
				break;
			}
			System.out.println(rowAsString);
			//System.out.println(" |--+--+--+--+--+--+--|");
			for(int g = 0; g<columns;g++) {
				if(g==0) {
					System.out.print(" |--");
				}
				else if(g==(columns-1)) {
					System.out.print("+--|");
				}
				else {
				System.out.print("+--");
				}
			}
			System.out.print("\n");
		}
	}
	
    //This method is used to place the player's piece in a position on the array which is the game board.
	//It takes as parameters the player's piece, the row number and the column number.
	//It is user-friendly as the code is [row-1] so the player doesn't have to type [0,0] as a position, for example.
	public void placePiece(int row, int column, char piece) {
		this.fieldOfPlay[row - 1][column - 1] = piece;
	}

	//This method checks who won the game by using a counter that ticks up when the player's piece
	//is found in the array that is the game board. It returns a boolean value, if the counter reaches three
	//it returns true as there is a winner. If not, it returns false.
	//It takes the parameter char playerinturnpiece which is the piece the player uses in the game.
	public boolean checkWinner(char playerinturnpiece) {
		//This piece of code checks if a player has connected three pieces horizontally and won.
		int rowCheck = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (fieldOfPlay[i][j] == playerinturnpiece) {
					rowCheck++;
				} else
					rowCheck = 0;
				if (rowCheck == 3) {
					this.finishGame = true;
					return true;
				}
			}
		}
		//This piece of code checks if a player has connected 3 pieces vertically and won.
		int columnCheck = 0;
		for (int j = 0; j < columns; j++) {
			for (int i = 0; i < rows; i++) {
				if (fieldOfPlay[i][j] == playerinturnpiece) {
					columnCheck++;
				} else
					columnCheck = 0;

				if (columnCheck == 3) {
					this.finishGame = true;
					return true;
				}
			}
		}
		//This piece of code checks if a player has connected three pieces in either an ascending or descending diagonal and won.
		for (int i = 0; i < columns; i++) {
			for (int j = 0; j < rows; j++) {
				if (i + 1 < columns && i + 2 < columns && j + 1 < rows && j + 2 < rows) {
					if (fieldOfPlay[j][i] == playerinturnpiece && fieldOfPlay[j + 1][i + 1] == playerinturnpiece
							&& fieldOfPlay[j + 2][i + 2] == playerinturnpiece) {
						return true;
					}
				}
			}
		}
		for (int i = 0; i < columns; i++) {
			for (int j = 0; j < rows; j++) {
				if (i - 1 > 0 && i - 2 > 0 && j + 1 < rows && j + 2 < rows) {
					if (fieldOfPlay[j][i] == playerinturnpiece && fieldOfPlay[j + 1][i - 1] == playerinturnpiece
							&& fieldOfPlay[j + 2][i - 2] == playerinturnpiece) {
						return true;
					}
				}
			}
		}
		return false;
	}

	//This method checks if the game results in a draw, it returns a boolean value, 
	//it returns false if one empty field is found,indicating that the board is not 
	//full and more moves can still take place.
	public boolean checkDraw(Player playerOne, Player playerTwo) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if(fieldOfPlay[i][j]==' ') {
					return false;
				}
			}
		}
		return true;
	}

	public char[][] getFieldOfPlay() {
		return fieldOfPlay;
	}

	public void setFieldOfPlay(char[][] fieldOfPlay) {
		this.fieldOfPlay = fieldOfPlay;
	}

    //This method is to end the game. 
	public boolean gameFinished() {
		return finishGame;
	}
}