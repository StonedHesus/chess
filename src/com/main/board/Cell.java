// The package/current namespace of this particular Java compilation unit.
package com.main.board;

// Imports from custom libraries, classes and interfaces.
import com.main.components.Piece;

// Imports from existing Java libraries, classes and interfaces.

public class Cell {
    /*
     * This here compilation unit models a class whose role is to represented one cell from within the chessboard,
     * thus this class contains information regarding the colour of the case and the piece which is placed, if placed
     * at all, upon the case. Aside from these the class also provides certain getter and checking functionalities so
     * as to retrieve the piece placed upon the cell the instance is referring to or to check whether it is available
     * or not so as to ensure that the logic for the game rules have an ease when establishing which moves are valid in
     * the current configuration.
     *
     * @author Andrei-Paul Ionescu.
     */

    // Fields/attributes of the class.
    final boolean colour; // Where false is black and true is white.
    Piece piece; // If no chess piece exist upon the current cell then this value points to null.

    // Constructors of the class.
    public Cell(boolean colour, Piece piece){

        this.colour = colour;
        this.piece = piece;
    }

    public Cell(boolean colour) {this(colour, null);}

    // Getters of the class.
    public Piece getPiece() {return this.piece;}

    // Setters of the class.
    public void setPiece(Piece piece) {this.piece = piece;}

    // Public non-static methods of the class.
    public boolean isEmpty() {return piece == null;}

    @Override
    public String toString() {return (this.piece != null) ? "this.piece.getName()[0]" : this.colour ?  "-"  :  "*";}
}
