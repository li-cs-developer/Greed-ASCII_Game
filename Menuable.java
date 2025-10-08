import java.util.Scanner;

//--------------------------------------------------------------------------------------------------
// INTERFACE: Menuable
//
//
// REMARKS: The purpose of this interface is to force class Menu to implement the methods needed for 
//          a menu of a runnable game to function properly.
//--------------------------------------------------------------------------------------------------
interface Menuable extends GameLogical{
    void setMessage(String message); //set the message
    Scanner getPlayerInput(); //get the player's input to select menu item
}

