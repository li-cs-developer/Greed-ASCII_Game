import java.util.Scanner;

//--------------------------------------------------------------------------------------------------
// CLASS: GameBoard
//
//
// REMARKS: The purpose of this class is to consturct a generic game board for the players of 
//          runnable games to view, and to make sure other specific game boards as its subclasses 
//          to have necessary instances and can work polymorphically 
//--------------------------------------------------------------------------------------------------
public abstract class GameBoard implements GameBoardable{ 
    //instances variables
    private char[][] gameBoard; //ascii game board
    private Playerable player; //player to get input from
    private int numRows; //number of rows of the gameboard
    private int numCols; //number of columns of the gameboard

    //constructor
    public GameBoard(int numRows, int numCols){
        this.numRows = numRows;
        this.numCols = numCols;
        gameBoard = new char[numRows][numCols];
    }

    //abstract methods, leave the subclasses to define their behaviour
    public abstract void reset();
    public abstract boolean select(Viewable v, GameLogical gl);

    //----------------------------------------------------------------------------------------------
    // view
    //
    // PURPOSE: print out the ascii game board
    // PARAMETERS: N/A
    // Returns: N/A
    //----------------------------------------------------------------------------------------------
    @Override
    public void view(){
        for(int i=0; i<numRows; i++) {
            for(int j=0; j<numCols; j++){
                System.out.print(gameBoard[i][j]);
            }
            System.out.println();
        }
    }

    //----------------------------------------------------------------------------------------------
    // updateGameBoard
    //
    // PURPOSE: change 1 element in the game board
    // PARAMETERS: rowIndex - row index of the game board
    //             colIndex - column index of the game board
    //             newChar - the new character to be set in the game board
    // Returns: N/A
    //----------------------------------------------------------------------------------------------
    public void updateGameBoard(int rowIndex, int colIndex, char newChar){
        if(rowIndex < numRows && colIndex < numCols && rowIndex >= 0 && colIndex >= 0){
            gameBoard[rowIndex][colIndex] = newChar;
        }
    }

    //----------------------------------------------------------------------------------------------
    // getPlayerInput
    //
    // PURPOSE: get input from the player
    // PARAMETERS: N/A
    // Returns: a Scanner that take the input
    //----------------------------------------------------------------------------------------------
    @Override
    public Scanner getPlayerInput(){
        return player.getPlayerInput();
    }

    /****************************************** getters ******************************************/
    public char[][] getGameBoard(){
        return gameBoard;
    }

    public int getNumRows(){
        return numRows;
    }

    public int getNumCols(){
        return numCols;
    }

    /******************************************* setter *******************************************/
    public void setPlayer(Playerable player){
        this.player = player;
    }
}