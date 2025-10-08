import java.util.Scanner;

//--------------------------------------------------------------------------------------------------
// INTERFACE: Playerable
//
//
// REMARKS: The purpose of this interface is to force the classes that implement players of a 
//          runnable game to implement necessary methods.
//          * A Player class has been implemented, this interface can also force classes like 
//            CPU_Player, MultiPlayer to implement necessary method
//--------------------------------------------------------------------------------------------------
interface Playerable{
    Scanner getPlayerInput(); //get the input from player
}
