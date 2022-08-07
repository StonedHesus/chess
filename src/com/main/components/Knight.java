// The package in which the current Java compilation unit is to be found.

package com.main.components;
// Imports from existing Java libraries, classes and interfaces.

// Import from custom libraries, classes and interfaces.
import com.main.components.Piece;

public class Knight extends Piece {
    /**
     */
    // Static values/constants of the class.
    private final static String name = "KNIGHT";
    // Fields/attributes of the class.

    // Constructor(s) of the class.
    public Knight(boolean colour){

        // Invoke the parent/super constructor of the class.
        super(colour, Knight.name);
    }
    // Getters of the class.

    // Setters of the class.

    // Public non-static methods of the unit.

    // Public static methods of the unit.

    // Private methods of the unit.
}
