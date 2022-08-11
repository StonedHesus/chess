// The package in which the current Java compilation unit is to be found.

package com.main.board;
// Imports from existing Java libraries, classes and interfaces.

// Import from custom libraries, classes and interfaces.

import com.main.components.Piece;

public class OccupiedCell extends Cell{
    /**
     * This here compilation unit models a class whose role is to represented one cell from within the chessboard,
     * thus this class contains information regarding the colour of the case and the piece which is placed, if placed
     * at all, upon the case. Aside from these the class also provides certain getter and checking functionalities so
     * as to retrieve the piece placed upon the cell the instance is referring to or to check whether it is available
     * or not so as to ensure that the logic for the game rules have an ease when establishing which moves are valid in
     * the current configuration.
     *
     * @author Andrei-Paul Ionescu.
     */
    // Static values/constants of the class.

    // Fields/attributes of the class.
    final boolean colour; // Where false is black and true is white.
    Piece piece; // If no chess piece exist upon the current cell then this value points to null.

    // Constructor(s) of the class.
    public OccupiedCell(boolean colour, Piece piece){

        this.colour = colour;
        this.piece = piece;
    }

    public OccupiedCell(boolean colour) {this(colour, null);}

    // Getters of the class.
    public Piece getPiece() {return this.piece;}

    // Setters of the class.
    public void setPiece(Piece piece) {this.piece = piece;}

    // Public non-static methods of the unit.
    public boolean isEmpty() {return piece == null;}

    // Public static methods of the unit.

    // Private methods of the unit.


    // Fields/attributes of the class.


    // Constructors of the class.

}
