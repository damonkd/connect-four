package core;

//import java.util.Arrays;
/** connect 4 logic class
*@author Damon Daniels
*@version final 
*/

public class Connect4  {

	int[][] board;
	int numOfMoves = 0;

	/** constructor creates new board at 6 x 7
	*public int [] [] board
	*@version final 
	*/

	public Connect4() {
		board = new int[6][7];

	}

	/** print game method printGame()
	
	*/

	public void printGame() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				if (board[i][j] == 0)
					System.out.print("| ");
				else if (board[i][j] == 1)
					System.out.print("|" + "X");
				else if (board[i][j] == 2)
					System.out.print("|" + "O");
			}
			System.out.println("|");
		}

		System.out.println();
		System.out.println();
		System.out.println();
	}
	/** adds piece to board move(int column, int player)
	*@param column is column number from UI
	*@param player is player number from UI
	*/
	public void move(int column, int player) {
		column--;
		for (int i = 5; i >= 0; i--)
			if (board[i][column] == 0) {
				board[i][column] = player;
				break;
			}
		numOfMoves++;
	
	}
	
	
	public int moveGUI(int column, int player) {
		int height =5;
		
		for (int i = 5; i >= 0; i--)
			if (board[i][column] == 0) {
				board[i][column] = player;
				height = i;
				break;
			}
		numOfMoves++;
	return height;
	}
	
	
	
	/** checks for winner(int player)
	*@param player is player number from UI
	*@param return true if winner false otherwise
	*/
	public boolean winner(int player) {

		// horizontal
		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < 6; i++) {
				if (board[i][j] == player && board[i][j + 1] == player && board[i][j + 2] == player
						&& board[i][j + 3] == player) {

					return true;
				}

			}

		}

		// vertical
		for (int j = 0; j < 7; j++) {
			for (int i = 0; i < 3; i++) {
				if (board[i][j] == player && board[i + 1][j] == player && board[i + 2][j] == player
						&& board[i + 3][j] == player) {

					return true;
				}

			}
		}

		// diagonal up slope

		for (int j = 0; j < 4; j++) {
			for (int i = 3; i < 6; i++) {
				if (board[i][j] == player && board[i - 1][j + 1] == player && board[i - 2][j + 2] == player
						&& board[i - 3][j + 3] == player) {
					return true;

				}
			}

		}

		// diagonal down slope

		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < 3; i++) {
				if (board[i][j] == player && board[i + 1][j + 1] == player && board[i + 2][j + 2] == player
						&& board[i + 3][j + 3] == player) {
					return true;

				}
			}

		}

		return false;
	}
	
	/** checks for full columnFull(int column)
	*@param columns is column from UI
	*@param return true if column full false otherwise
	*/
	public boolean columnFull(int column) {
		column--;
		for (int i = 0; i < 6; i++) {
			if (board[i][column] == 0)
				return true;
		}

		return false;
	}
	
	public int columnHeight(int column) {
		int height =5;
		for (int i = 5; i >= 0; i--) {
			if (board[i][column] != 0)
				height =i;
		}

		return height;
	}
	
	
	
	/** checks for full board boardFull()
	*@param return true if board full false otherwise
	*/
	public boolean boardFull() {
		if (numOfMoves == 42)
			return true;
		else
			return false;
	}

	public int[][] getBoard() {
		return this.board;
	}
	
	
}
