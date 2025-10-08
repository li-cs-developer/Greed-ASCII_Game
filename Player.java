import java.util.Scanner;

//--------------------------------------------------------------------------------------------------
// CLASS: Player
//
//
// REMARKS: The purpose of this class is to make sure players of a runnable game as its subclasses
//          to have necessary instances and to work polymorphically.
//          * A HumanPlayer class is implemented as its subclass, another possible class contructor 
//            of its subclass InputFile could be: 
//            public InputFile(){ setScanner(new Scanner(new File("file.txt")));} 
//--------------------------------------------------------------------------------------------------
abstract class Player implements Playerable{
    //instance variable
    private Scanner scanner; //the scanner to get input from the player

    //----------------------------------------------------------------------------------------------
    // getPlayerInput
    //
    // PURPOSE: get input from the player
    // PARAMETERS: N/A
    // Returns: a Scanner that take the input
    //----------------------------------------------------------------------------------------------
    @Override
    public Scanner getPlayerInput(){
        return scanner;
    }

    /******************************************* setter *******************************************/
    public void setScanner(Scanner scanner){
        this.scanner = scanner;
    }
}