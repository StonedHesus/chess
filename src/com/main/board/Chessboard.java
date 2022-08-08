// The package/current namespace of this particular Java compilation unit.
package com.main.board;

// Imports from custom libraries, classes and interfaces.
import com.main.board.Cell;
import com.main.gui.graphics.Display;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

        // Invoke the method to add mouse listeners to each cell.
        this.addMouseListeners();
    }

    // Public non-static methods of the unit.
    public boolean isOutOfBound(int x, int y) {return (x < 0 || x > this.width) && (y < 0 || y > this.height);}

    // Private methods of the unit.
    private void addMouseListeners(){

        for(int i = 0 ; i < this.height ; ++i){
            for(int j = 0 ; j < this.width ; ++j){

                chessboard[i][j].addMouseListener(new CellMouseListener(chessboard[i][j], i, j));
            }
        }
    }

    // Nested classes within this compilation unit.
    class CellMouseListener implements MouseListener{

        // Attributes/fields of the class.
        private Cell cell;
        private int x;
        private int y;

        // Constructor(s) of the class.
        public CellMouseListener(Cell cell, int x, int y){

            this.cell = cell;
            this.x    = x;
            this.y    = y;
        }

        @Override
        public void mouseClicked(MouseEvent e) {

            Display.addBorder(x, y);
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

}
