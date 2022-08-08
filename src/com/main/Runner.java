// The package/current namespace of this particular Java compilation unit.
package com.main;

// Imports from custom libraries, classes and interfaces.

// Imports from existing Java libraries, classes and interfaces.
import com.main.gui.GameView;
import com.main.gui.graphics.Display;

import javax.swing.*;

public class Runner {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            new GameView(Display.WHITE_PERSPECTIVE);
        });
    }
}
