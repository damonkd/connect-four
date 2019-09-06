package core;
/** connect 4 Computer player class extends Connect4
*@author Damon Daniels
*@version final 
*/

public class Connect4ComputerPlayer extends Connect4 {

	/** checks for player 1 three in a row and blocks it if possible
	*@param return int value of column to be played or 20 if no move to make
	*/
	
	boolean ComputerPlay = false;
	
public boolean isComputerPlay() {
	return ComputerPlay;
}

public void setIsComputerPlay() {
	ComputerPlay = true;
}
	
	
public int check3InRow(){
	//Check Vertical
	
	for (int j = 0; j < 7; j++) {
		for (int i = 0; i < 3; i++) {
			if (board[i][j] == 0 && board[i + 1][j] == 1 && board[i + 2][j] == 1
					&& board[i + 3][j] == 1) {

				return j;				
											}//end if
										  }//end for i
										}	//end for j	
		
			//end check vertical

// check horizontal
for (int j = 0; j < 4; j++) {
	for (int i = 0; i < 6; i++) {
		if (board[i][j] == 0 && board[i][j + 1] == 1 && board[i][j + 2] == 1
				&& board[i][j + 3] == 1) {
			if(i<5 && board[i+1][j]!=0)
			return j;
			if(i == 5)
				return j;
		}
	
		if (board[i][j] == 1 && board[i][j + 1] == 0 && board[i][j + 2] == 1
				&& board[i][j + 3] == 1) {
			if(i<5 && board[i+1][j+1]!=0)
			return j+1;
			if(i == 5)
				return j+1;
		}
		
		if (board[i][j] == 1 && board[i][j + 1] == 1 && board[i][j + 2] == 0
				&& board[i][j + 3] == 1) {
			if(i<5 && board[i+1][j+2]!=0)
			return j+2;
			if(i == 5)
				return j+2;
		}
	
		if (board[i][j] == 1 && board[i][j + 1] == 1 && board[i][j + 2] == 1
				&& board[i][j + 3] == 0) {
			if(i<5 && board[i+1][j+3]!=0)
			return j+3;
			if(i == 5)
				return j+3;
		}
	}//end inside loop
} // end check horizontal

//check diagonal upslope
for (int j = 0; j < 4; j++) {
	for (int i = 3; i < 6; i++) {
		if (board[i][j] == 0 && board[i - 1][j + 1] == 1 && board[i - 2][j + 2] == 1
				&& board[i - 3][j + 3] == 1) {
			if(i<5 && board[i+1][j]!=0)
			return j;
			if(i == 5)
				return j;
		}
	
		if (board[i][j] == 1 && board[i - 1][j + 1] == 0 && board[i - 2][j + 2] == 1
				&& board[i - 3][j + 3] == 1) {
			if(board[i][j+1]!=0)
			return j+1;
			
		}
		
		if (board[i][j] == 1 && board[i - 1][j + 1] == 1 && board[i - 2][j + 2] == 0
				&& board[i - 3][j + 3] == 1) {
			if(board[i-1][j+2]!=0)
			return j+2;
			
		}
	
		if (board[i][j] == 1 && board[i - 1][j + 1] == 1 && board[i - 2][j + 2] == 1
				&& board[i - 3][j + 3] == 0) {
			if(board[i-2][j+3]!=0)
			return j+3;
			
		}
	}//end inside loop
} // end check diagonal upslope



//check diagonal downslope
for (int j = 0; j < 4; j++) {
	for (int i = 0; i < 3; i++) {
		if (board[i][j] == 0 && board[i + 1][j + 1] == 1 && board[i + 2][j + 2] == 1
				&& board[i + 3][j + 3] == 1) {
			if(board[i+1][j]!=0)
			return j;
			
		}
	
		if (board[i][j] == 1 && board[i + 1][j + 1] == 0 && board[i + 2][j + 2] == 1
				&& board[i + 3][j + 3] == 1) {
			if(board[i+2][j+1]!=0)
			return j+1;
			
		}
		
		if (board[i][j] == 1 && board[i + 1][j + 1] == 1 && board[i + 2][j + 2] == 0
				&& board[i + 3][j + 3] == 1) {
			if(board[i+3][j+2]!=0)
			return j+2;
			
		}
	
		if (board[i][j] == 1 && board[i + 1][j + 1] == 1 && board[i + 2][j + 2] == 1
				&& board[i + 3][j + 3] == 0) {
			if(i+4 <5 && board[i+4][j+3]!=0)
			return j+3;
			if(i+4 == 5)
				return j+3;
		}
	}//end inside loop
} // end check diagonal downslope



return 20;
}

/** checks for Computer three in a row and plays it if possible
*@param return int value of column to be played or 20 for nothing to play
*/
public int win3InRow(){
	//Check Vertical
	
	for (int j = 0; j < 7; j++) {
		for (int i = 0; i < 3; i++) {
			if (board[i][j] == 0 && board[i + 1][j] == 2 && board[i + 2][j] == 2
					&& board[i + 3][j] == 2) {

				return j;				
											}//end if
										  }//end for i
										}	//end for j	
		
			//end check vertical

// check horizontal
for (int j = 0; j < 4; j++) {
	for (int i = 0; i < 6; i++) {
		if (board[i][j] == 0 && board[i][j + 1] == 2 && board[i][j + 2] == 2
				&& board[i][j + 3] == 2) {
			if(i<5 && board[i+1][j]!=0)
			return j;
			if(i == 5)
				return j;
		}
	
		if (board[i][j] == 2 && board[i][j + 1] == 0 && board[i][j + 2] == 2
				&& board[i][j + 3] == 2) {
			if(i<5 && board[i+1][j+1]!=0)
			return j+1;
			if(i == 5)
				return j+1;
		}
		
		if (board[i][j] == 2 && board[i][j + 1] == 2 && board[i][j + 2] == 0
				&& board[i][j + 3] == 2) {
			if(i<5 && board[i+1][j+2]!=0)
			return j+2;
			if(i == 5)
				return j+2;
		}
	
		if (board[i][j] == 2 && board[i][j + 1] == 2 && board[i][j + 2] == 2
				&& board[i][j + 3] == 0) {
			if(i<5 && board[i+1][j+3]!=0)
			return j+3;
			if(i == 5)
				return j+3;
		}
	}//end inside loop
} // end check horizontal

//check diagonal upslope
for (int j = 0; j < 4; j++) {
	for (int i = 3; i < 6; i++) {
		if (board[i][j] == 0 && board[i - 1][j + 1] == 2 && board[i - 2][j + 2] == 2
				&& board[i - 3][j + 3] == 2) {
			if(i<5 && board[i+1][j]!=0)
			return j;
			if(i == 5)
				return j;
		}
	
		if (board[i][j] == 2 && board[i - 1][j + 1] == 0 && board[i - 2][j + 2] == 2
				&& board[i - 3][j + 3] == 2) {
			if(board[i][j+1]!=0)
			return j+1;
			
		}
		
		if (board[i][j] == 2 && board[i - 1][j + 1] == 2 && board[i - 2][j + 2] == 0
				&& board[i - 3][j + 3] == 2) {
			if(board[i-1][j+2]!=0)
			return j+2;
			
		}
	
		if (board[i][j] == 2 && board[i - 1][j + 1] == 2 && board[i - 2][j + 2] == 2
				&& board[i - 3][j + 3] == 0) {
			if(board[i-2][j+3]!=0)
			return j+3;
			
		}
	}//end inside loop
} // end check diagonal upslope



//check diagonal downslope
for (int j = 0; j < 4; j++) {
	for (int i = 0; i < 3; i++) {
		if (board[i][j] == 0 && board[i + 1][j + 1] == 2 && board[i + 2][j + 2] == 2
				&& board[i + 3][j + 3] == 2) {
			if(board[i+1][j]!=0)
			return j;
			
		}
	
		if (board[i][j] == 2 && board[i + 1][j + 1] == 0 && board[i + 2][j + 2] == 2
				&& board[i + 3][j + 3] == 2) {
			if(board[i+2][j+1]!=0)
			return j+1;
			
		}
		
		if (board[i][j] == 2 && board[i + 1][j + 1] == 2 && board[i + 2][j + 2] == 0
				&& board[i + 3][j + 3] == 2) {
			if(board[i+3][j+2]!=0)
			return j+2;
			
		}
	
		if (board[i][j] == 2 && board[i + 1][j + 1] == 2 && board[i + 2][j + 2] == 2
				&& board[i + 3][j + 3] == 0) {
			if(i+4 <5 && board[i+4][j+3]!=0)
			return j+3;
			if(i+4 == 5)
				return j+3;
		}
	}//end inside loop
} // end check diagonal downslope



return 20;
}
/** computerMove
*@param return void
*@param numTurnsCom number of turns computer
*@param check3 value returned by check3method
*@param win3 value returned by win3 method
*@param tryCol column to be played by computer if nothing to block or win
*@param playerNumber player number
*/
public void computerMove() {
	int numTurnsCom =0;
	int check3 = check3InRow();
	int win3 = win3InRow();
	int tryCol = 4;
	int playerNumber =2;
	//System.out.println(check3);
	
	if(check3 !=20)
	{
	
	move(check3 + 1, playerNumber);
	numTurnsCom++;
	playerNumber = 1;
	}
	
	else if(win3 !=20)
	{
		move(win3 + 1, playerNumber);
		
	
	
	
	}
	
	

	
	// choose column starting in center
	else if (columnFull(tryCol)) {
			move(tryCol, playerNumber);
			printGame();
			numTurnsCom++;
	}
			
	else if(!columnFull(tryCol)){
				
		if(numTurnsCom % 2 == 0) {
			
				if (columnFull(5)) {
					move(5, playerNumber);
					
					
										}
			
				else if (columnFull(6)) {
					move(6, playerNumber);
					
					
										}
		
				else if (columnFull(7)) {
					move(7, playerNumber);
					
					
										}
				else if (columnFull(3)) {
					move(3, playerNumber);
					
					
										}
		
				
				else if (columnFull(2)) {
					move(2, playerNumber);
					
					
										}
		
				else if (columnFull(1)) {
					move(1, playerNumber);
					
					
										}
		}// close %2=0
		
		
		
		if(numTurnsCom % 2 == 1) {
			
			if (columnFull(3)) {
				move(3, playerNumber);
				
				
									}
		
			else if (columnFull(2)) {
				move(2, playerNumber);
				
				
									}
	
			else if (columnFull(1)) {
				move(1, playerNumber);
				
				
									}
			else if (columnFull(5)) {
				move(5, playerNumber);
				
				
									}
	
			
			else if (columnFull(6)) {
				move(6, playerNumber);
				
				
									}
	
			else if (columnFull(7)) {
				move(7, playerNumber);
				
				
									}
	}// close %2=1
		numTurnsCom++;
		}// close colum4 full
	
		
	
	
	
	
	
}



}
