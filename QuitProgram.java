//--------------------------------------------------------------------------------------------------
// CLASS: QuitProgram
//
//
// REMARKS: It is a subclass of MenuItem. The purpose of this class is to construct a menu item for
//          quit the program
//--------------------------------------------------------------------------------------------------
class QuitProgram extends MenuItem{
    //constructor
    public QuitProgram(String option){
        super(option);  
    }

    //----------------------------------------------------------------------------------------------
    // action
    //
    // PURPOSE: quit the program
    // PARAMETERS: N/A
    // Returns: N/A
    //----------------------------------------------------------------------------------------------
    @Override
    public void action(){
        System.out.println("Quit Program\n");
        System.exit(0);
    }
}