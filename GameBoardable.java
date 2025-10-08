import java.util.Scanner;

//--------------------------------------------------------------------------------------------------
// INTERFACE: GameBoardable
//
//
// REMARKS: The purpose of this interface is to force class GameBoard to implement methods that are
//          needed for a game. It extends Viewable and Selectable as GameBoard needs visual and
//          and needs to take player's selection.
//--------------------------------------------------------------------------------------------------
interface GameBoardable extends Viewable, Selectable{
    void reset(); //reset the gameboard
    Scanner getPlayerInput(); //get input from player
}
