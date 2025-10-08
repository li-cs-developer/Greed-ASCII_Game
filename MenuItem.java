//--------------------------------------------------------------------------------------------------
// CLASS: MenuItem
//
//
// REMARKS: The purpose of this class is to make sure functional menu items as its subclasses to 
//          have necessary instanve vairable and can work polymorphically 
//--------------------------------------------------------------------------------------------------
abstract class MenuItem{
    //instance variable
    String option; //the option of this menu item

    //constructor
    public MenuItem(String option){
        this.option = option;
    }

    //action the menu item do, leave to its subclass to define its behaviour
    public abstract void action();

    //toString method, print out the option 
    public String toString(){
        return option + "?";
    }

    /******************************************* getter *******************************************/
    public String getOption(){
        return option;
    }
}
