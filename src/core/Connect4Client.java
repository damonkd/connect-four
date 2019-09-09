package core;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;



import java.io.*;
import java.net.*;


public class Connect4Client extends JApplet
    implements Runnable, Connect4Constants {
  // Indicate whether the player has the turn
  private boolean myTurn = false;
  
  
  //indicates if one player game
  private int singlePlayer = 0;
  // Indicate the token for the player
  private int myToken = 0;

  // Indicate the token for the other player
  private int otherToken = 0;

//Create and initialize a chooser
 private JButton jlblChooser = new JButton("Single Player?");
 
  // Create and initialize cells
  private Cell[][] cell =  new Cell[6][7];

  // Create and initialize a title label
  private JLabel jlblTitle = new JLabel();

  // Create and initialize a status label
  private JLabel jlblStatus = new JLabel();

  // Indicate selected row and column by the current move
  private int rowSelected;
  private int columnSelected;

  // Input and output streams from/to server
  private DataInputStream fromServer;
  private DataOutputStream toServer;

  // Continue to play?
  private boolean continueToPlay = true;

  // Wait for the player to mark a cell
  private boolean waiting = true;

  // Indicate if it runs as application
  private boolean isStandAlone = false;

  // Host name or ip
  private String host = "localhost";


  
  /** Initialize UI */
  public void init() {
    // Panel p to hold cells
    JPanel p = new JPanel();
    p.setLayout(new GridLayout(6, 7, 0, 0));
    for (int i = 0; i < 6; i++)
      for (int j = 0; j < 7; j++)
        p.add(cell[i][j] = new Cell(i, j));

    // Set properties for labels and borders for labels and panel
    p.setBorder(new LineBorder(Color.black, 1));
    jlblTitle.setHorizontalAlignment(JLabel.CENTER);
    jlblTitle.setFont(new Font("SansSerif", Font.BOLD, 16));
    jlblTitle.setBorder(new LineBorder(Color.black, 1));
    jlblStatus.setBorder(new LineBorder(Color.black, 1));
    jlblChooser.setBorder(new LineBorder(Color.black, 1));
    // Place the panel and the labels to the applet
    
    
    
    add(jlblTitle, BorderLayout.NORTH);
    //add(jlblChooser, BorderLayout.EAST);
    add(p, BorderLayout.CENTER);
    add(jlblStatus, BorderLayout.SOUTH);
    
    jlblChooser.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getID() == ActionEvent.ACTION_PERFORMED
                ? "ACTION_PERFORMED" : e.getID());
            singlePlayer = 1;
            System.out.println(singlePlayer);
        }
    });
    
    // Connect to the server
    connectToServer();
  }

  private void connectToServer() {
    try {
      // Create a socket to connect to the server
      Socket socket;
      if (isStandAlone)
        socket = new Socket(host, 8000);
      else
        socket = new Socket(getCodeBase().getHost(), 8000);

      // Create an input stream to receive data from the server
      fromServer = new DataInputStream(socket.getInputStream());

      // Create an output stream to send data to the server
      toServer = new DataOutputStream(socket.getOutputStream());
    }
    catch (Exception ex) {
      System.err.println(ex);
    }

    // Control the game on a separate thread
    Thread thread = new Thread(this);
    thread.start();
  }

  public void run() {
    try {
      // Get notification from the server
      int player = fromServer.readInt();

      // Am I player 1 or 2?
      if (player == PLAYER1) {
        myToken = 1;
        otherToken = 2;
        jlblTitle.setText("Player 1 with token 'X'");
        jlblStatus.setText("Waiting for player 2 to join");
        //toServer.writeInt(singlePlayer);
        // Receive startup notification from the server
        fromServer.readInt(); // Whatever read is ignored
        
        // The other player has joined
        jlblStatus.setText("Player 2 has joined. I start first");

        // It is my turn
        myTurn = true;
      }
      else if (player == PLAYER2) {
        myToken = 2;
        otherToken = 1;
        jlblTitle.setText("Player 2 with token 'O'");
        jlblStatus.setText("Waiting for player 1 to move");
      }

      // Continue to play
      while (continueToPlay) {
        if (player == PLAYER1) {
          waitForPlayerAction(); // Wait for player 1 to move
          sendMove(); // Send the move to the server
          receiveInfoFromServer(); // Receive info from the server
        }
        else if (player == PLAYER2) {
          receiveInfoFromServer(); // Receive info from the server
          waitForPlayerAction(); // Wait for player 2 to move
          sendMove(); // Send player 2's move to the server
        }
      }
    }
    catch (Exception ex) {
    }
  }

 
    
  /** Wait for the player to mark a cell */
  private void waitForPlayerAction() throws InterruptedException {
    while (waiting) {
      Thread.sleep(100);
    }

    waiting = true;
  }

  /** Send this player's move to the server */
  private void sendMove() throws IOException {
    toServer.writeInt(rowSelected); // Send the selected row
    toServer.writeInt(columnSelected); // Send the selected column
    //cell[rowSelected][columnSelected].setToken(myToken);
    makeMove();
  }

  private void sendMoveComputer() throws IOException {
	    fromServer.readInt(); // Send the selected row
	    fromServer.readInt(); // Send the selected column
	    //cell[rowSelected][columnSelected].setToken(myToken);
	    receiveMove();
	  }
  
  /** Receive info from the server */
  private void receiveInfoFromServer() throws IOException {
    // Receive game status
    int status = fromServer.readInt();

    if (status == PLAYER1_WON) {
      // Player 1 won, stop playing
      continueToPlay = false;
      if (myToken == 1) {
        jlblStatus.setText("I won! (X)");
      }
      else if (myToken == 2) {
        jlblStatus.setText("Player 1 (X) has won!");
        receiveMove();
      }
    }
    else if (status == PLAYER2_WON) {
      // Player 2 won, stop playing
      continueToPlay = false;
      if (myToken == 2) {
        jlblStatus.setText("I won! (O)");
      }
      else if (myToken == 1) {
        jlblStatus.setText("Player 2 (O) has won!");
        receiveMove();
      }
    }
    else if (status == DRAW) {
      // No winner, game is over
      continueToPlay = false;
      jlblStatus.setText("Game is over, no winner!");

      if (myToken == 2) {
        receiveMove();
      }
    }
    else {
      receiveMove();
      jlblStatus.setText("My turn");
      myTurn = true; // It is my turn
    }
  }

  public void receiveMove() throws IOException {
    // Get the other player's move
    int row = fromServer.readInt();
    int column = fromServer.readInt();
    cell[row][column].setToken(otherToken);
  }

  private void makeMove() throws IOException {
	    // Get the other player's move
	    int row = fromServer.readInt();
	    int column = fromServer.readInt();
	    cell[row][column].setToken(myToken);
	  }
  
  // An inner class for a cell
  public class Cell extends JPanel {
    // Indicate the row and column of this cell in the board
    private int row;
    private int column;

    // Token used for this cell
    private int token = 0;

    public Cell(int row, int column) {
      this.row = row;
      this.column = column;
      setBorder(new LineBorder(Color.black, 1)); // Set cell's border
     addMouseListener(new ClickListener());  // Register listener
    }

    /** Return token */
    public int getToken() {
      return token;
    }

    /** Set a new token */
    public void setToken(int c) {
      
      token = c;
      repaint();
    }

   
    @Override /** Paint the cell */
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);

      if (token == 1) {
        g.drawLine(10, 10, getWidth() - 10, getHeight() - 10);
        g.drawLine(getWidth() - 10, 10, 10, getHeight() - 10);
      }
      else if (token == 2) {
        g.drawOval(10, 10, getWidth() - 20, getHeight() - 20);
      }
    }

    /** Handle mouse click on a cell */
    private class ClickListener extends MouseAdapter {
      public void mouseClicked(MouseEvent e) {
        // If cell is not occupied and the player has the turn
        if ((token == 0) && myTurn) {
          //setToken(myToken);  // Set the player's token in the cell
          myTurn = false;
          
          columnSelected = column;
          
          jlblStatus.setText("Waiting for the other player to move");
          waiting = false; // Just completed a successful move
        }
      }
    }
  }

  /** This main method enables the applet to run as an application */
  public static void main(String[] args) {
    // Create a frame
	  
	 
	  
	  
	 
	  
	  JFrame frame = new JFrame("Connect Four Client");

    // Create an instance of the applet
    Connect4Client applet = new Connect4Client();
    applet.isStandAlone = true;

    // Get host
    if (args.length == 1) applet.host = args[0];

    // Add the applet instance to the frame
    frame.getContentPane().add(applet, BorderLayout.CENTER);
    
    // Invoke init() and start()
    
    applet.init();
    applet.start();

    // Display the frame
    frame.setSize(400, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
