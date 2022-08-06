// The package/current namespace of this particular Java compilation unit.
package com.main.board;

// Imports from custom libraries, classes and interfaces.
import com.main.board.Cell;

import java.awt.*;

// Imports from existing Java libraries, classes and interfaces.

public class Chessboard {
    /*
     * The board object is a collection of Cell object which thus constructs the board upon which the pieces are to be
     * laid on with which the interaction of the user with the software will be later tailored upon; hence the board
     * represents a critical object which allows us to determine the correctness of moves and to establish certain
     * observations of the game, whether the king is under sieged and so forth.
     *
     * @author Andrei-Paul Ionescu.
     */

    // Fields/attributes of the class.
    private final int width;
    private final int height;
    private final Cell[][] chessboard;

    // Constructors of the class.
    public Chessboard(int width, int height){

        this.width  = width;
        this.height = height;
        this.chessboard = new Cell[this.width][this.height];
    }

    // Methods of the class.
    public boolean isOutOfBound(int x, int y) {return (x < 0 || x > this.width) && (y < 0 || y > this.height);}

}
