import java.util.Scanner;

//--------------------------------------------------------------------------------------------------
// CLASS: HumanPlayer
//
//
// REMARKS: It is a subclass of Player. The purpose of this class is to get input of a human player 
//          of a runnable game from System.in  
//--------------------------------------------------------------------------------------------------
class HumanPlayer extends Player{
    //constructor
    public HumanPlayer(){
        setScanner(new Scanner(System.in));
    }
}
