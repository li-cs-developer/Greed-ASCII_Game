//--------------------------------------------------------------------------------------------------
// CLASS: GreedLogic
//
//
// REMARKS: It is a subclass of GameLogic. The purpose of this class is to construct game logics of  
//          the game Greed specifically so that it can run as expected.
//--------------------------------------------------------------------------------------------------
public class GreedLogic extends GameLogic{
    //constructer
    public GreedLogic(){
        super();
    }

    //----------------------------------------------------------------------------------------------
    // nextState
    //
    // PURPOSE: select the next direction to eat characters 
    // PARAMETERS: v - must be a GreedBoard
    // Returns: ture if the GreedBoard has next state, false if it doesn't
    //----------------------------------------------------------------------------------------------
    @Override
    public boolean nextState(Viewable v){
        //defensive programming
        if(!(v instanceof GreedBoard)){
           return false; 
        }

        //convert v to GreedBoard
        GreedBoard greedBoard = (GreedBoard)v;

        //find out if there are more moves
        boolean isMoreMoves = false;
        for(int i=1; i <= 9; i++){
            if(i != 5 && isValidMove(greedBoard, i)){
                isMoreMoves = true;
                break;
            }
        }

        //get the selection form the player if there are more moves
        if(isMoreMoves){
            return greedBoard.select(greedBoard, this);
        }

        //print game over and final score then return false if there are no more moves
        else{
            System.out.println("Game Over! No more moves!");
            System.out.printf("Your final score is: %d\n\n", getScore());
            return false;
        }
    }

    //----------------------------------------------------------------------------------------------
    // eatChars
    //
    // PURPOSE: eat characters from the selected direction on the GreedBoard
    // PARAMETERS: greedBoard - the GreedBoard to eat characters from
    //             selection - determine which direction the player to eat characters
    // Returns: ture if the GreedBoard has next state, false if it doesn't
    //----------------------------------------------------------------------------------------------
    public boolean eatChars(GreedBoard greedBoard, int selection){
        //defensive programming
        if(selection < 1 || selection > 9 || selection == 5 || !isValidMove(greedBoard, selection)){
            return false;
        }
        
        //player's coordinate
        int playerX = greedBoard.getPlayerPosX();
        int playerY = greedBoard.getPlayerPosY();
    
        //match directions to selection
        int[][] directions = {{}, // 0 - invalid direction
                              {-1, -1}, //up left
                              {0, -1}, //up
                              {1, -1}, //up right
                              {-1, 0}, //left
                              {}, //5 - invalid direction
                              {1, 0}, //right
                              {-1, 1}, //donw left
                              {0, 1}, //down
                              {1, 1} /*down right */};
        
        //the differece of x and y coordinates between the player and the selected character 
        int diffX = directions[selection][0];
        int diffY = directions[selection][1];

        //number of characters to eat
        int numChars = greedBoard.getGameBoard()[playerY+diffY][playerX+diffX] - greedBoard.getOffset();

        //eat characters
        for(int i=1; i<=numChars; i++){
            greedBoard.updateGameBoard(playerY+(i*diffY), playerX+(i*diffX), ' ');
        }

        //updated coordinate of the player after eating characters
        int newPlayerX = playerX+(numChars*diffX);
        int newPlayerY = playerY+(numChars*diffY);

        //update player position
        greedBoard.updateGameBoard(newPlayerY, newPlayerX, greedBoard.getPlayerSymbol());
        greedBoard.updateGameBoard(playerY, playerX, ' ');
        greedBoard.setPlayerPosX(newPlayerX);
        greedBoard.setPlayerPosY(newPlayerY);

        addScore(numChars); //update score

        return true; //return true if reach the end
    }

    //----------------------------------------------------------------------------------------------
    // isValidMove
    //
    // PURPOSE: determine if the selected direction on the GreedBoard is a valid move
    // PARAMETERS: greedBoard - the GreedBoard to eat characters from
    //             selection - determine which direction the player to eat characters
    // Returns: ture if the selected direction on the GreedBoard is a valid move, false if it isn't
    //----------------------------------------------------------------------------------------------   
    public boolean isValidMove(GreedBoard greedBoard, int selection) {
        //player's coordinate
        int playerX = greedBoard.getPlayerPosX();
        int playerY = greedBoard.getPlayerPosY();
        
        //the differece of x and y coordinates between the player and the selected character 
        int diffX;
        int diffY;

        //assgined the coordiates of selected direction
        switch(selection){
            case 1: //up left
                diffX = -1; 
                diffY = -1; 
                break; 
            case 2: //up
                diffX = 0;  
                diffY = -1; 
                break;
            case 3: //up right   
                diffX = 1;  
                diffY = -1; 
                break; 
            case 4: //left
                diffX = -1; 
                diffY = 0;  
                break;
            case 6: //right
                diffX = 1;  
                diffY = 0;  
                break; 
            case 7: //down left
                diffX = -1; 
                diffY = 1;  
                break; 
            case 8: //down
                diffX = 0;  
                diffY = 1;  
                break; 
            case 9: //down right
                diffX = 1;  
                diffY = 1;  
                break; 
            default: //invalid selection
                return false; 
        }

        //coordinate of the selected character
        int selectedX = playerX + diffX;
        int selectedY = playerY + diffY;
        //maximum x and y can be
        int xMax = greedBoard.getNumCols()-1;
        int yMax = greedBoard.getNumRows()-1;

        //check if the selected char is out of bounds
        if(selectedX < 0 || selectedX > xMax || selectedY < 0 || selectedY > yMax){
            return false;
        }

        final int OFFSET = greedBoard.getOffset(); //the offset to convert char 1-9 to int 1-9

        //number of character needed to move
        int numChars = (int)greedBoard.getGameBoard()[selectedY][selectedX] - OFFSET;

        //return false if the selected character is a space(which is smaller than 1 in ascii table)
        if(numChars < 1){
            return false;
        }

        //coordinate of the players final destination
        int destX = playerX + (diffX*numChars);
        int destY = playerY + (diffY*numChars);

        //check if destination is out of bounds
        if(destX < 0 || destX > greedBoard.getNumCols()-1 || destY < 0 || destY > yMax){
            return false;
        }

        //check if there are any spaces in the way
        for(int i=1; i<=numChars; i++){
            if ((int)greedBoard.getGameBoard()[playerY+(diffY*i)][playerX+(diffX * i)]-OFFSET < 0){
                return false;
            }
        }

        return true; //otherwise the move is valid
    }
}