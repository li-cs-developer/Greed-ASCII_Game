//--------------------------------------------------------------------------------------------------
// CLASS: Greed
//
//
// REMARKS: It is a subclass of Game. The purpose of this class is to construct a runnable game for
//          Greed specifically so that it can run Greed.
//--------------------------------------------------------------------------------------------------
public class Greed extends Game{
    //class constants
    private static final int NUM_ROWS = 21; //number of rows for greed board
    private static final int NUM_COLS = 81; //number of colums for greed board
    
    //constructor
    public Greed(){
        //use Greed specific logic and game board for the super constructor
        super(new GreedLogic(), new GreedBoard(NUM_ROWS, NUM_COLS), new Menu());

        //use println instead since can't call setMessage as there is no getters in Game class.
        System.out.println("\nWelcome to Greed"); 
    }
}