// The package in which the current Java compilation unit is to be found.

package com.main.components;
// Imports from existing Java libraries, classes and interfaces.
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

// Import from custom libraries, classes and interfaces.


public class Pawn extends Piece {
    /**
     */

    // Static values/ constants of the class.
    private static final String name = "PAWN";

    // Fields/attributes of the class.


    // Constructor(s) of the class.
    public Pawn(boolean colour){

        // Invoke the constructor of the parent/super class.
        super(colour, Pawn.name);

        // Instantiate the sprite for the current instance in accordance with the colour which the piece has.
        BufferedImage sprite = null;

        try {

            sprite = ImageIO.read(new File((System.getProperty("user.dir")) +
                    "/src/com/main/static/pieces/" + ((colour) ? "white-set/pawn.png" : "black-set/pawn.png")));
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        super.setSprite(sprite);
    }
    // Getters of the class.

    // Setters of the class.

    // Public non-static methods of the unit.

    // Public static methods of the unit.

    // Private methods of the unit.

}
