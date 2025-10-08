import java.util.ArrayList;
//--------------------------------------------------------------------------------------------------
// CLASS: MenuItems
//
//
// REMARKS: The purpose of this class is to construct a list of selectable menu items
//--------------------------------------------------------------------------------------------------
class MenuItems implements Selectable{
    //instance variable
    private ArrayList<MenuItem> menuItems; //a list of menu item

    //constructor
    public MenuItems(){
        menuItems = new ArrayList<>();
        menuItems.add(new PlayGame("PlayGame")); //add PlayGame as 1st on the list
        menuItems.add(new QuitProgram("Quit Program")); //add QuitProgram as 2nd on the list
    }
    
    //----------------------------------------------------------------------------------------------
    // select
    //
    // PURPOSE: get the input from the player to select the menu item
    // PARAMETERS: v - a Viewable
    //             gl - must be a Menu
    // Returns: ture if a valid option is selected, false if it isn't
    //----------------------------------------------------------------------------------------------
    @Override
    public boolean select(Viewable v, GameLogical gl){
        //defensive programming
        if(gl instanceof Menu){
            //convert gl to Menu
            Menu menu = (Menu)gl;

            //keep getting input from the player until a valid option is selected
            while(true){
                //get input from the player
                System.out.print("Enter menu option: "); 
                int selectedItem = menu.getPlayerInput().nextInt()-1;

                //if a valid option is entered, do the action and return true
                if(selectedItem >= 0 && selectedItem < menuItems.size()){
                    menuItems.get(selectedItem).action();
                    break;
                }
                
                //if an invalid option, remind the player the valid options
                System.out.printf("The menu option entered is invalid please entre from 1~%d.\n", 
                                    menuItems.size());
                menu.view(); //print the menu again
            }
        }
        return false;
    }

    //----------------------------------------------------------------------------------------------
    // addMenuItem
    //
    // PURPOSE: add a new MenuItem to the end of the list
    // PARAMETERS: menuItem - a MenuItem to be added
    // Returns: N/A
    //----------------------------------------------------------------------------------------------
    public void addMenuItem(MenuItem menuItem){
        menuItems.add(menuItem);
    }

    //toString method, return formatted MenuItems
    public String toString(){
        String string = "";
        for(int i=0; i<menuItems.size(); i++){
            string += String.format("%d: %s\n", i+1, menuItems.get(i).toString());
        }
        return string;
    }

    /******************************************* getter *******************************************/
    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }
}
