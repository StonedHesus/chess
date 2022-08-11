// The package in which the current Java compilation unit is to be found.

package com.main.components;
// Imports from existing Java libraries, classes and interfaces.

// Import from custom libraries, classes and interfaces.
import com.main.components.Piece;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Queen extends Piece{
    /**
     */
    // Static values/constants of the class.
    private static final String name = "QUEEN";

    // Fields/attributes of the class.

    // Constructor(s) of the class.
    public Queen(boolean colour){

        // Invoke the constructor of the parent/super class.
        super(colour, Queen.name);

        // Instantiate the sprite for the current instance in accordance with the colour which the piece has.
        BufferedImage sprite = null;

        try {

            sprite = ImageIO.read(new File((System.getProperty("user.dir")) +
                    "/src/com/main/static/pieces/" + ((colour) ? "white-set/queen.png" : "black-set/queen.png")));
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
