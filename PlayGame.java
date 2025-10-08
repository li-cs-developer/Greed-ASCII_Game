//--------------------------------------------------------------------------------------------------
// CLASS: PlayGame
//
//
// REMARKS: It is a subclass of MenuItem. The purpose of this class is to construct a menu game for
//          a runnable game to start
//--------------------------------------------------------------------------------------------------
class PlayGame extends MenuItem{
    //instance variable
    boolean inGame; //determine if a runnable game is in game mode

    //constructor
    public PlayGame(String option){
        super(option);
        inGame = false; //false as default
    }

    //----------------------------------------------------------------------------------------------
    // action
    //
    // PURPOSE: set the game mode to true
    // PARAMETERS: N/A
    // Returns: N/A
    //----------------------------------------------------------------------------------------------
    @Override
    public void action(){
        inGame = true;
    }
    
    //----------------------------------------------------------------------------------------------
    // isInGame
    //
    // PURPOSE: determine if PlayGame is selected
    // PARAMETERS: N/A
    // Returns: true if PlayGame is selected, false if isn't
    //----------------------------------------------------------------------------------------------
    public boolean isInGame(){
        return inGame;
    }
}
