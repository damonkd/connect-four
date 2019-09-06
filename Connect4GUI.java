package ui;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;
import core.Connect4ComputerPlayer;

/** Connect4GUI extends Application javafx
*@param int board[][] blank board;
*@param player is current player number
*@param row to play, defaults to one
*@param return void
*@param computerGame defines two player or 1 player game
* while loop cycles through players and adds pieces to the board, checks for full column and checks for winner
*/


public class Connect4GUI extends Application  {
	int board[][];
	int player =1;
	int row =1;
	
	Connect4ComputerPlayer connect = new Connect4ComputerPlayer();
	public boolean computerGame = false;
	
	public void setIsComputerPlay() {
		computerGame = true;
	}   	
    
@Override // Override the start method in the Application class



public void start(Stage primaryStage) {
  
	
	
	
	
	board = connect.getBoard();
	
	

	    Color blank = Color.WHITE;
	    Color red = Color.RED;
	    Color black = Color.YELLOW;

	    

	    GridPane gridPane = new GridPane();

	    TwoPlayerCol1 handler1 = new TwoPlayerCol1();
	    TwoPlayerCol2 handler2 = new TwoPlayerCol2();
	    TwoPlayerCol3 handler3 = new TwoPlayerCol3();
	    TwoPlayerCol4 handler4 = new TwoPlayerCol4();
	    TwoPlayerCol5 handler5 = new TwoPlayerCol5();
	    TwoPlayerCol6 handler6 = new TwoPlayerCol6();
	    TwoPlayerCol7 handler7 = new TwoPlayerCol7();
	    
	    
	    // for visualizing the different squares:
	    gridPane.setHgap(5);
	    gridPane.setVgap(5);
	    gridPane.setAlignment(Pos.CENTER);
	    gridPane.setStyle("-fx-background-color: blue;");
	    
	    //add disc button col 1
	    Button btAdd1 = new Button("Add Disc Column One");
	    btAdd1.setMaxSize(100, 150);
	    btAdd1.wrapTextProperty().setValue(true);
	    btAdd1.textAlignmentProperty().set(TextAlignment.CENTER);
	    gridPane.add(btAdd1, 0, 0);
	    btAdd1.setOnAction(handler1);
	    
	   
	    
	    
	    //add disc button col 2
	    Button btAdd2 = new Button("Add Disc Column Two");
	    btAdd2.setMaxSize(100, 150);
	    btAdd2.wrapTextProperty().setValue(true);
	    btAdd2.textAlignmentProperty().set(TextAlignment.CENTER);
	    gridPane.add(btAdd2, 1, 0);
	    btAdd2.setOnAction(handler2);
	    
	    //add disc button col 3
	    Button btAdd3 = new Button("Add Disc Column Three");
	    btAdd3.setMaxSize(100, 150);
	    btAdd3.wrapTextProperty().setValue(true);
	    btAdd3.textAlignmentProperty().set(TextAlignment.CENTER);
	    gridPane.add(btAdd3, 2, 0);
	    btAdd3.setOnAction(handler3);

	    //add disc button col 4
	    Button btAdd4 = new Button("Add Disc Column Four");
	    btAdd4.setMaxSize(100, 150);
	    btAdd4.wrapTextProperty().setValue(true);
	    btAdd4.textAlignmentProperty().set(TextAlignment.CENTER);
	    gridPane.add(btAdd4, 3, 0);
	    btAdd4.setOnAction(handler4);
	    
	    //add disc button col 5
	    Button btAdd5 = new Button("Add Disc Column Five");
	    btAdd5.setMaxSize(100, 150);
	    btAdd5.wrapTextProperty().setValue(true);
	    btAdd5.textAlignmentProperty().set(TextAlignment.CENTER);
	    gridPane.add(btAdd5, 4, 0);
	    btAdd5.setOnAction(handler5);
	    
	    //add disc button col 6
	    Button btAdd6 = new Button("Add Disc Column Six");
	    btAdd6.setMaxSize(100, 150);
	    btAdd6.wrapTextProperty().setValue(true);
	    btAdd6.textAlignmentProperty().set(TextAlignment.CENTER);
	    gridPane.add(btAdd6, 5, 0);
	    btAdd6.setOnAction(handler6);
	    
	    //add disc button col 7
	    Button btAdd7 = new Button("Add Disc Column Seven");
	    btAdd7.setMaxSize(100, 150);
	    btAdd7.wrapTextProperty().setValue(true);
	    btAdd7.textAlignmentProperty().set(TextAlignment.CENTER);
	    gridPane.add(btAdd7, 6, 0);
	    btAdd7.setOnAction(handler7);
	    
	    
	    for (int y = 0; y < 6  ; y++) {
	        for (int x = 0 ; x < board[y].length ; x++) {
	            Circle circle1 = new Circle();
	            circle1.setCenterX(100);
	            circle1.setCenterY(100);
	            circle1.setRadius(50);
	            circle1.setStroke(Color.BLACK);
	            
	            if(board[y][x] == 1)
	            {
	            circle1.setFill(red);
	            }
	            
	            if(board[y][x] == 2)
	            {
	            circle1.setFill(black);
	            }
	            else if(board[y][x] == 0)
	            {
	            circle1.setFill(blank);
	            }
	            
	            
	            
	            gridPane.add(circle1, x, y+1);
	        }
	    }
	    //redraw the board
	  EventHandler<ActionEvent> eventHandler = e -> { 
	    for (int y = 0 ; y < 6 ; y++) {
	        for (int x = 0 ; x < board[y].length ; x++) {
	            Circle circle = new Circle();
	            circle.setCenterX(100);
	            circle.setCenterY(100);
	            circle.setRadius(50);
	            circle.setStroke(Color.BLACK);
	            
	            if(board[y][x] == 1)
	            {
	            circle.setFill(red);
	            }
	            
	            if(board[y][x] == 2)
	            {
	            circle.setFill(black);
	            }
	            else if(board[y][x] == 0)
	            {
	            circle.setFill(blank);
	            }
	            
	            
	            
	            gridPane.add(circle, x, y+1);
	        }
	        
	        
	        
	    }};
	    // animation event
	    Timeline animation = new Timeline(
	    	      new KeyFrame(Duration.millis(100), eventHandler));
	    	    animation.setCycleCount(Timeline.INDEFINITE);
	    	    ;
	    	    animation.play(); // Start animation
	    	    
	    	 
	   
	    	    
	    
	    Scene scene = new Scene(gridPane);
	    primaryStage.setScene(scene);
	    primaryStage.show();
	    

	    Stage stage = new Stage(); // Create a new stage
	    stage.setTitle("Second Stage"); // Set the stage title
	    // Set a scene with a button in the stage
	    PlayComputer handler0 = new PlayComputer();
	    GridPane grid = new GridPane();
	    grid.setMinSize(200, 200);
	    grid.setHgap(10);
	    grid.setVgap(10);
	    grid.setAlignment(Pos.CENTER);
	    grid.setStyle("-fx-background-color: orange;");
	    
	    Button btAdd0 = new Button("Click to play against computer? \n Close window after selection");
	    grid.add(btAdd0, 0, 0);
	    btAdd0.setOnAction(handler0);
	    
	    stage.setScene(new Scene(grid));        
	    stage.show(); 


}



public int[][] getBoard() {
	return board;
}
public void setBoard(int[][] board) {
	this.board = board;
}
/**
 * The main method is only needed for the IDE with limited
 * JavaFX support. Not needed for running from the command line.
 */
public static void main(String[] args) {
  launch(args);
}

class PlayComputer implements EventHandler<ActionEvent>{
public void handle(ActionEvent e)
{
	computerGame = true;
}

}
/** TwoPlayerCol1 implements EventHandler<ActionEvent>
*@param return void
* plays column one if button pushed, also plays computer turn if enabled
*/


class TwoPlayerCol1 implements EventHandler<ActionEvent> {
	  @Override
	  public void handle(ActionEvent e) {
	    connect.move(1, player);
	    if(connect.winner(player)) {
	    	Stage stage = new Stage(); // Create a new stage
	        stage.setTitle("Game Over"); // Set the stage title
	        // Set a scene with a button in the stage
	        stage.setScene(new Scene(new Button("player "+ player +" wins"), 200, 200));        
	        stage.show();
	    	//System.exit(player);
	    	
	    }
	    	
	    if(computerGame) {
	    	player = 2;
	    	connect.computerMove();
	    	if(connect.winner(player)) {
		    	Stage stage = new Stage(); // Create a new stage
		        stage.setTitle("Game Over"); // Set the stage title
		        // Set a scene with a button in the stage
		        stage.setScene(new Scene(new Button("player "+ player +" wins"), 200, 200));        
		        stage.show();
	    }
	    }
	    
	    board = connect.getBoard(); 
	    if(player == 1)
	    	player =2;
	    else if(player == 2)
	    	player =1;
	  
	  
	  
	  
	  
	  }
	}

/** TwoPlayerCol2 implements EventHandler<ActionEvent>
*@param return void
* plays column one if button pushed, also plays computer turn if enabled
*/

class TwoPlayerCol2 implements EventHandler<ActionEvent> {
	  @Override
	  public void handle(ActionEvent e) {
	    connect.move(2, player);
	    if(connect.winner(player)) {
	    	Stage stage = new Stage(); // Create a new stage
	        stage.setTitle("Game Over"); // Set the stage title
	        // Set a scene with a button in the stage
	        stage.setScene(new Scene(new Button("player "+ player +" wins"), 200, 200));        
	        stage.show();
	    	//System.exit(player);
	    	
	    }
	    
	    if(computerGame) {
	    	player = 2;
	    	connect.computerMove();
	    	if(connect.winner(player)) {
		    	Stage stage = new Stage(); // Create a new stage
		        stage.setTitle("Game Over"); // Set the stage title
		        // Set a scene with a button in the stage
		        stage.setScene(new Scene(new Button("player "+ player +" wins"), 200, 200));        
		        stage.show();
	    }
	    }
	    
	    board = connect.getBoard(); 
	    if(player == 1)
	    	player =2;
	    else if(player == 2)
	    	player =1;
	  }
	}


/** TwoPlayerCol3 implements EventHandler<ActionEvent>
*@param return void
* plays column one if button pushed, also plays computer turn if enabled
*/

class TwoPlayerCol3 implements EventHandler<ActionEvent> {
	  @Override
	  public void handle(ActionEvent e) {
	    connect.move(3, player);
	    connect.winner(player);
	    if(connect.winner(player)) {
	    	Stage stage = new Stage(); // Create a new stage
	        stage.setTitle("Game Over"); // Set the stage title
	        // Set a scene with a button in the stage
	        stage.setScene(new Scene(new Button("player "+ player +" wins"), 200, 200));        
	        stage.show();
	    	//System.exit(player);
	    	
	    } 
	    
	    if(computerGame) {
	    	player = 2;
	    	connect.computerMove();
	    	if(connect.winner(player)) {
		    	Stage stage = new Stage(); // Create a new stage
		        stage.setTitle("Game Over"); // Set the stage title
		        // Set a scene with a button in the stage
		        stage.setScene(new Scene(new Button("player "+ player +" wins"), 200, 200));        
		        stage.show();
	    }
	    }
	    
	    if(player == 1)
	    	player =2;
	    else if(player == 2)
	    	player =1;
	  }
	}


/** TwoPlayerCol4 implements EventHandler<ActionEvent>
*@param return void
* plays column one if button pushed, also plays computer turn if enabled
*/
class TwoPlayerCol4 implements EventHandler<ActionEvent> {
	  @Override
	  public void handle(ActionEvent e) {
	    connect.move(4, player);
	    connect.winner(player);
	    if(connect.winner(player)) {
	    	Stage stage = new Stage(); // Create a new stage
	        stage.setTitle("Game Over"); // Set the stage title
	        // Set a scene with a button in the stage
	        stage.setScene(new Scene(new Button("player "+ player +" wins"), 200, 200));        
	        stage.show();
	    	//System.exit(player);
	    	
	    } 
	    
	    if(computerGame) {
	    	player = 2;
	    	connect.computerMove();
	    	if(connect.winner(player)) {
		    	Stage stage = new Stage(); // Create a new stage
		        stage.setTitle("Game Over"); // Set the stage title
		        // Set a scene with a button in the stage
		        stage.setScene(new Scene(new Button("player "+ player +" wins"), 200, 200));        
		        stage.show();
	    }
	    }
	    
	    if(player == 1)
	    	player =2;
	    else if(player == 2)
	    	player =1;
	  }
	}

/** TwoPlayerCol5 implements EventHandler<ActionEvent>
*@param return void
* plays column one if button pushed, also plays computer turn if enabled
*/

class TwoPlayerCol5 implements EventHandler<ActionEvent> {
	  @Override
	  public void handle(ActionEvent e) {
	    connect.move(5, player);
	    connect.winner(player);
	    if(connect.winner(player)) {
	    	Stage stage = new Stage(); // Create a new stage
	        stage.setTitle("Game Over"); // Set the stage title
	        // Set a scene with a button in the stage
	        stage.setScene(new Scene(new Button("player "+ player +" wins"), 200, 200));        
	        stage.show();
	    	//System.exit(player);
	    	
	    } 
	    
	    if(computerGame) {
	    	player = 2;
	    	connect.computerMove();
	    	if(connect.winner(player)) {
		    	Stage stage = new Stage(); // Create a new stage
		        stage.setTitle("Game Over"); // Set the stage title
		        // Set a scene with a button in the stage
		        stage.setScene(new Scene(new Button("player "+ player +" wins"), 200, 200));        
		        stage.show();
	    }
	    }
	    
	    if(player == 1)
	    	player =2;
	    else if(player == 2)
	    	player =1;
	  }
	}

/** TwoPlayerCol6 implements EventHandler<ActionEvent>
*@param return void
* plays column one if button pushed, also plays computer turn if enabled
*/

class TwoPlayerCol6 implements EventHandler<ActionEvent> {
	  @Override
	  public void handle(ActionEvent e) {
	    connect.move(6, player);
	    connect.winner(player);
	    if(connect.winner(player)) {
	    	Stage stage = new Stage(); // Create a new stage
	        stage.setTitle("Game Over"); // Set the stage title
	        // Set a scene with a button in the stage
	        stage.setScene(new Scene(new Button("player "+ player +" wins"), 200, 200));        
	        stage.show();
	    	//System.exit(player);
	    	
	    } 
	    
	    if(computerGame) {
	    	player = 2;
	    	connect.computerMove();
	    	if(connect.winner(player)) {
		    	Stage stage = new Stage(); // Create a new stage
		        stage.setTitle("Game Over"); // Set the stage title
		        // Set a scene with a button in the stage
		        stage.setScene(new Scene(new Button("player "+ player +" wins"), 200, 200));        
		        stage.show();
	    }
	    }
	    
	    if(player == 1)
	    	player =2;
	    else if(player == 2)
	    	player =1;
	  }
	}

/** TwoPlayerCol7 implements EventHandler<ActionEvent>
*@param return void
* plays column one if button pushed, also plays computer turn if enabled
*/

class TwoPlayerCol7 implements EventHandler<ActionEvent> {
	  @Override
	  public void handle(ActionEvent e) {
	    connect.move(7, player);
	    connect.winner(player);
	    if(connect.winner(player)) {
	    	Stage stage = new Stage(); // Create a new stage
	        stage.setTitle("Game Over"); // Set the stage title
	        // Set a scene with a button in the stage
	        stage.setScene(new Scene(new Button("player "+ player +" wins"), 200, 200));        
	        stage.show();
	    	//System.exit(player);
	    	
	    } 
	    
	    if(computerGame) {
	    	player = 2;
	    	connect.computerMove();
	    	if(connect.winner(player)) {
		    	Stage stage = new Stage(); // Create a new stage
		        stage.setTitle("Game Over"); // Set the stage title
		        // Set a scene with a button in the stage
		        stage.setScene(new Scene(new Button("player "+ player +" wins"), 200, 200));        
		        stage.show();
	    }
	    }
	    
	    if(player == 1)
	    	player =2;
	    else if(player == 2)
	    	player =1;
	  }
	}


} 