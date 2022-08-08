// The package in which the current Java compilation unit is to be found.

package com.main.gui;

// Imports from existing Java libraries, classes and interfaces.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;


// Import from custom libraries, classes and interfaces.
import com.main.gui.View;
import com.main.settings.Settings;
import com.main.gui.graphics.Display;

public class GameView extends View implements Settings {
    /**
     *
     * This here method models the game window on which the game information will be displayed.
     *
     * @author Andrei-Paul Ionescu
     */
    // Static values/constants of the class.
    private Display display;

    // Fields/attributes of the class.

    // Constructor(s) of the class.
    public GameView(int perspective){

        // Call the constructor of the class from which MainMenu inherits.
        super();

        // Invoke the initialise method which deals with initialisation of the current JFrame.
        this.initialise(perspective);

    }

    // Getters of the class.

    // Setters of the class.

    // Public non-static methods of the unit.

    // Public static methods of the unit.

    // Private methods of the unit.
    private void initialise(int perspective){
        /*
         * @param perspective; an integer value transmitted to the GameView constructor so as to determine which colour
         * the current user is going to play with.
         *
         * Initialise the JFrame object to the desired specifications.
         *
         *
         * @since 0.0.1
         * @version 0.0.1
         * @author Andrei-Paul Ionescu
         */

        // Instantiate the display field of the current object which called the initialise method, by passing to it the
        // initial screen dimensions which are stored within constants in the Settings interface.
        this.display = new Display(INITIAL_SCREEN_WIDTH, INITIAL_SCREEN_HEIGHT, perspective);

        // Instantiate a new Controller which is linked with the current view/JFrame; the linking is done with the aid
        // of the frame's addKeyListener method which sets the frame's current KeyListener to our controller.
        //this.addKeyListener(new Controller(this.display));

        // Set the dimensions of the JFrame to the initial ones which are stored within the Settings interface.
        this.setSize(new Dimension(INITIAL_SCREEN_WIDTH, INITIAL_SCREEN_HEIGHT));

        // Set the title of the JFrame to String object stored within the GAME_TITLE constant which is to be found
        // within the Settings interface.
        this.setTitle(GAME_TITLE);

        // Make the JFrame visible, set it to the centre of the screen by passing null as the argument of setLocationRelativeTo(),
        // and add the display object to the current JFrame, which is currently manipulated object.
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.add(this.display);

        // Set a Minimum size for the window so as to assure ourselves that the user is using the game at a resolution
        // which enables him to properly enjoy the experience.
        this.setMinimumSize(new Dimension(INITIAL_SCREEN_WIDTH, INITIAL_SCREEN_HEIGHT));

        // Set the default closing operation with the aid of the Swing constant EXIT_ON_CLOSE.
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
