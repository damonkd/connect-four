package ui;
/** connect 4 user interface class
*@author Damon Daniels
*@version final 
*/

import java.util.Scanner;
import core.Connect4;
import core.Connect4ComputerPlayer;
import ui.Connect4GUI;
import javafx.application.Application;
public class Connect4TextConsole {
	
	/** user interface for connect 4 main(String args[])
	*@param column is current columns
	*@param playerNumber is current player number
	*@param return void
	*@param numTurnsCom keeps track of the number of turns played by computer
	*@param gameMode defines two player or 1 player game
	* while loop cycles through players and adds pieces to the board, checks for full column and checks for winner
	*/
	public static void main(String args[])  {
		int column = 0;
		int playerNumber = 1;
		int numTurnsCom =0;
		String gameMode = "";
		int GUI=0;
		
		
		Scanner scan = new Scanner(System.in);

		Connect4ComputerPlayer connect = new Connect4ComputerPlayer();
		Connect4GUI Gui = new Connect4GUI();
		
		
		System.out.println("GUI interface? 1 for yes 2 for no");
		
		
		try {
			GUI = scan.nextInt();
		}
		catch(Exception d) {
		System.out.print("Invalid Enty");
		}
		if(GUI == 1) {
			Application.launch(Connect4GUI.class, args);
		
		}
		
		else  {
		
		System.out.println("Enter ‘P’ if you want to play against another player; enter ‘C’ to play against computer.");
		
		
			try {
			gameMode = scan.next();
			}
			catch(Exception d) {
			System.out.print("Invalid Enty");
			}
			
				
			
			

			
			
			
		// 2 player Game
		if(gameMode.equals("P")) {
			connect.printGame();
			System.out.println("Begin Game.");
		while (true) {
			if (connect.boardFull() == true) {
				System.out.println("Board is full, game over.");
				break;
			}
			// player X
			if (playerNumber == 1) {
				System.out.println("Player X – your turn. Choose a column number from 1 - 7.");
			try
			{				column = scan.nextInt();
			}
			catch(Exception E) {
				System.out.println("Entry must be an integer from 1 to 7");
			break;
			}
			if (column > 0 && column < 8) {
					if (connect.columnFull(column)) {
						connect.move(column, playerNumber);
						connect.printGame();
						
						if (connect.winner(playerNumber) == true) {
							System.out.println("Player X Wins");
							break;
						}

						playerNumber = 2;
					}

				} else {
					System.out.println("Invalid entry.");
				}
				if (column > 0 && column < 8 && !connect.columnFull(column)) {
					System.out.println("column is full.");
				}

			}

			// Player O
			if (playerNumber == 2) {
				System.out.println("Player O – your turn. Choose a column number from 1 - 7.");

				try
				{				column = scan.nextInt();
				}
				catch(Exception E) {
					System.out.println("Entry must be an integer from 1 to 7");
				break;
				}
				
				
				if (column > 0 && column < 8) {
					if (connect.columnFull(column)) {
						connect.move(column, playerNumber);
						connect.printGame();

						if (connect.winner(playerNumber) == true) {
							System.out.println("Player O Wins");
							break;
						}
						playerNumber = 1;
					}

				} else {
					System.out.println("Invalid entry.");
				}
				if (column > 0 && column < 8 && !connect.columnFull(column)) {
					System.out.println("column is full.");
				}
			}

		} // end while loop
		} //end if statement for 2 player game
		
		
		//VS computer Game
		if(gameMode.equals("C")) {
			//connect = new Connect4ComputerPlayer();
			
			
			connect.printGame();
			System.out.println("Begin Game.");
		while (true) {
			if (connect.boardFull() == true) {
				System.out.println("Board is full, game over.");
				break;
			}
			// player X
			if (playerNumber == 1) {
				System.out.println("Player X – your turn. Choose a column number from 1 - 7.");

				try
				{				column = scan.nextInt();
				}
				catch(Exception E) {
					System.out.println("Entry must be an integer from 1 to 7");
				break;
				}
				
				
				
				if (column > 0 && column < 8) {
					if (connect.columnFull(column)) {
						connect.move(column, playerNumber);
						connect.printGame();
						if (connect.winner(playerNumber) == true) {
							System.out.println("Player X Wins");
							break;
						}

						playerNumber = 2;
					}

				} else {
					System.out.println("Invalid entry.");
				}
				if (column > 0 && column < 8 && !connect.columnFull(column)) {
					System.out.println("column is full.");
				}

			}

			// Computer Player O
			if (playerNumber == 2) {
			connect.computerMove();				
			connect.printGame();
			}
				
					
					
				
					
				
				
				if (connect.winner(playerNumber) == true) {
							System.out.println("Player O Wins");
							break;
						}
						playerNumber = 1;
					}

				
			

		} // end while loop
		} //end if statement for VS Computer Game
		
		
		
		
		
		}	
	}

