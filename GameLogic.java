//--------------------------------------------------------------------------------------------------
// CLASS: GameLogic
//
//
// REMARKS: The purpose of this class is to construct generic game logic of a runnable game so that 
//          the game can run as expected and make sure other specific game logic as its subclasses 
//          can work polymorphically 
//--------------------------------------------------------------------------------------------------
public abstract class GameLogic implements GameLogical{
    private int score; //score of the game

    //constructor
    public GameLogic(){
        score = 0; //set the score to 0 at the beginning the game
    }

    //abstract class, leave to its subclasses to handle the behaviour
    public abstract boolean nextState(Viewable v);

    //----------------------------------------------------------------------------------------------
    // view
    //
    // PURPOSE: print out the score for the player to view
    // PARAMETERS: N/A
    // Returns: N/A
    //----------------------------------------------------------------------------------------------
    @Override
    public void view(){
        System.out.println("\nPlayer score: " + getScore());
    }

    //----------------------------------------------------------------------------------------------
    // reset
    //
    // PURPOSE: reset the score to 0
    // PARAMETERS: N/A
    // Returns: N/A
    //----------------------------------------------------------------------------------------------
    @Override
    public void reset(){
        score = 0;
    }
    
    //----------------------------------------------------------------------------------------------
    // addScore
    //
    // PURPOSE: add additional score to the existing score
    // PARAMETERS: score - additional score to be added to the existing score
    // Returns: N/A
    //----------------------------------------------------------------------------------------------
    public void addScore(int score){
        this.score += score;
    } 

    /******************************************* getter *******************************************/
    public int getScore(){
        return score;
    }
}
