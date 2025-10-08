import java.util.Scanner;

//--------------------------------------------------------------------------------------------------
// CLASS: Menu
//
//
// REMARKS: The purpose of this class is to construct a menu of a runnable game
//--------------------------------------------------------------------------------------------------
class Menu implements Menuable{
    //instance variables
    private MenuItems menuItems; //menu items
    private String message; //message
    private Playerable player; //the player to get input from

    //constructor
    public Menu(){
        reset();
    }

    //----------------------------------------------------------------------------------------------
    // view
    //
    // PURPOSE: print out the menu items for the player to view and let the player select from it
    // PARAMETERS: N/A
    // Returns: N/A
    //----------------------------------------------------------------------------------------------
    @Override
    public void view(){
        //print out the message if message is set
        if(message!=null){
            System.out.println(message);
        }

        //print out the menu items
        System.out.print(menuItems);

        //let the player select from it
        menuItems.select(this, this);
    }

    //----------------------------------------------------------------------------------------------
    // nextState
    //
    // PURPOSE: determine if a runnable game is in game mode
    // PARAMETERS: v - a Viewable
    // Returns: ture if the runnable game is in game mode, false if it isn't
    //----------------------------------------------------------------------------------------------
    @Override
    public boolean nextState(Viewable v){
        //convert the first MenuItem to PlayGame
        PlayGame playGame = (PlayGame)(menuItems.getMenuItems().get(0));
        return playGame.isInGame(); //true if PlayGame is set to true, false if it's not
    }

    //----------------------------------------------------------------------------------------------
    // reset
    //
    // PURPOSE: get a new MenuItems and HumanPlayer
    // PARAMETERS: N/A
    // Returns: N/A
    //----------------------------------------------------------------------------------------------
    @Override
    public void reset(){
        menuItems = new MenuItems();
        player = new HumanPlayer();
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

    /******************************************* setter *******************************************/
    @Override
    public void setMessage(String message){
        this.message = message;
    }
}