// The package/current namespace of this particular Java compilation unit.
package com.main.components;

// Imports from custom libraries, classes and interfaces

// Imports from existing Java libraries, classes and interfaces
import java.util.Locale;

public abstract class Piece {
    /*
     * This here class models an abstract model for the individual pieces thus creating an abstract factor design pattern
     * which is utilised since many pieces share common features and even method, but some diverge based on certain
     * properties, generally routines, which they might have, in specially in regard to how many cells they might move
     * at once.
     *
     * @author Andrei-Paul Ionescu.
     */

    // Static values/ constants of the class.
    public final static String NAME_ERROR_VALUE = "(Erroneous input)";

    // Fields/attributes of the class.
    final boolean colour; // Where false is black and true is white.
    final String name; // The appellation of the current piece.

    // Constructor(s) of the class.
    public Piece(boolean colour, String name){

        this.colour = colour;
        this.name = name.toLowerCase(Locale.ROOT); // Make sure that the name is stored all in lowercase letters.
    }

    // Getters of the class.

    // Setters of the class.

    // Public non-static methods.
    @Override
    public String toString(){return (this.name != null && !this.name.equals("")) ?
            ( (this.colour)  ? this.name : Character.toUpperCase(this.name.charAt(0)) + this.name.substring(1))
            : Piece.NAME_ERROR_VALUE;}
}
