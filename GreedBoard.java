import java.util.Random;

//--------------------------------------------------------------------------------------------------
// CLASS: GreedBoard
//
//
// REMARKS: It is a subclass of GameBoard. The purpose of this class is to construct a game board of
//          the game Greed for the player to view
//--------------------------------------------------------------------------------------------------
public class GreedBoard extends GameBoard{
    //class constants
    private static final int OFFSET = 48; //the offset to convert char 1-9 to int 1-9
    private static final char PLAYER_SYMBOL = '@';

    //instance vairables
    private int playerPosX; //horizontal position of the player
    private int playerPosY; //vertical position of the player

    //constructor
    public GreedBoard(int numRows, int numCols){
        super(numRows, numCols);
        setPlayer(new HumanPlayer()); //set the player as Human Player
        reset(); //get a new board to start the game
    }

    //----------------------------------------------------------------------------------------------
    // reset
    //
    // PURPOSE: reset a new game board for Greed
    // PARAMETERS: N/A
    // Returns: N/A
    //----------------------------------------------------------------------------------------------
    @Override
    public void reset(){
        Random rand = new Random();
        int numRows = getNumRows();
        int numCols = getNumCols();

        //generate random numbers from 1-9 than convert them to char to update the game board
        for(int i=0; i<numRows; i++){
            for(int j = 0; j < numCols; j++){
                updateGameBoard(i, j, (char)(1+rand.nextInt(9)+getOffset()));
            }
        }

        //let the player start from the centre
        playerPosX = numCols/2;
        playerPosY = numRows/2;
        updateGameBoard(playerPosY, playerPosX, PLAYER_SYMBOL);
    }

    //----------------------------------------------------------------------------------------------
    // select
    //
    // PURPOSE: select the next direction to eat characters 
    // PARAMETERS: v - must be a GreedBoard
    //             gl - must be a GreedLogic
    // Returns: ture if the direction is valid to eat character, false if the direction is invalid
    //----------------------------------------------------------------------------------------------
    @Override
    public boolean select(Viewable v, GameLogical gl){
        //defensive programming
        if(!((v instanceof GreedBoard) && (gl instanceof GreedLogic))){
            return false;
        }

        //down cast gl to GreedLogic
        GreedLogic greedLogic = (GreedLogic)gl;

        //get selection from the player until a valid selection is gotten
        int selection;
        while(true){
            //get selection from the player
            System.out.print("Enter move option (0 to give up) : ");
            selection = getPlayerInput().nextInt();

            //quit Greed if 0 is selected
            if(selection == 0){
                System.out.println("Quit Greed\n");
                return false;
            }

            //remind the player to enter valid option if invalid one is entered
            else if(selection == 5 || selection < 0 || selection > 9){
                System.out.println("Your option is invalid, please enter 1~4 or 6~9.");
            }

            //remind the player to enter another option if the move is invalid.
            else if(!greedLogic.isValidMove(this, selection)){
                System.out.println("That is an invalid move. Try again.");
            }

            //otherwise break the loop
            else{
                break;
            }
            
            //print the score and the board again 
            greedLogic.view();
            view();
        }
        
        //eat characters if a valid selection is made
        return greedLogic.eatChars(this, selection);
    }

    /****************************************** getters ******************************************/
    public int getOffset(){
        return OFFSET;
    }

    public char getPlayerSymbol(){
        return PLAYER_SYMBOL;
    }

    public int getPlayerPosX(){
        return playerPosX;
    }

    public int getPlayerPosY(){
        return playerPosY;
    }

    /****************************************** setters ******************************************/
    public void setPlayerPosX(int x){
        playerPosX = x;
    }

    public void setPlayerPosY(int y){
        playerPosY = y;
    }
}
