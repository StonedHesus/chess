// The package in which the current Java compilation unit is to be found.
package com.main.settings;

// Imports from existing Java libraries, classes and interfaces.

// Imports from custom libraries, classes and interfaces.

import java.awt.*;

public interface Settings {
    /*
     * This here interface contains a collection of constants which serve as the settings for the various components
     * of the projects thus enabling one to change the parameters for the scope of the said objects(the ones that are
     * not for the user's to alter with voluntarily).
     *
     * @author Andrei-Paul Ionescu
     */

    // Settings regarding the Chessboard game element.
    int CLASSIC_CHESS_NUMBER_OF_COLUMNS = 8;
    int CLASSIC_CHESS_NUMBER_OF_ROWS = 8;
    Dimension CLASSIC_CHESS_DIMENSIONS = new Dimension(CLASSIC_CHESS_NUMBER_OF_ROWS,
            CLASSIC_CHESS_NUMBER_OF_COLUMNS);

    // Settings for the View object.
    int INITIAL_SCREEN_WIDTH  = 800;
    int INITIAL_SCREEN_HEIGHT = 800;
    String GAME_TITLE         = "Chess";

}
