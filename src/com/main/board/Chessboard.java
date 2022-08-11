// The package/current namespace of this particular Java compilation unit.
package com.main.board;

// Imports from custom libraries, classes and interfaces.
import com.main.board.Cell;
import com.main.components.*;
import com.main.gui.graphics.Display;
import com.main.settings.Settings;

// Imports from existing Java libraries, classes and interfaces.
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Chessboard implements Settings{
    /*
     * The board object is a collection of Cell object which thus constructs the board upon which the pieces are to be
     * laid on with which the interaction of the user with the software will be later tailored upon; hence the board
     * represents a critical object which allows us to determine the correctness of moves and to establish certain
     * observations of the game, whether the king is under siege and so forth.
     *
     * @author Andrei-Paul Ionescu.
     */

    // Fields/attributes of the class.
    private final int width;
    private final int height;
    private final Cell[][] chessboard;

    // Constructors of the class.
    public Chessboard(int width, int height, int perspective){

        this.width  = width;
        this.height = height;
        this.chessboard = new Cell[this.width][this.height];

        // Invoke the routine which initialises the chessboard in accordance to the current perspective.
        this.initialise(perspective);

        // Invoke the method to add mouse listeners to each cell.
        //this.addMouseListeners();
    }

    public Chessboard(int perspective){

        // Invoke the other constructor from within the class with the width and height as specified in the Settings interface.
        this(CLASSIC_CHESS_NUMBER_OF_ROWS, CLASSIC_CHESS_NUMBER_OF_COLUMNS, perspective);
    }

    // Getters of the class.
    public Cell getCell(int i, int j) {return this.chessboard[i][j];}

    // Public non-static methods of the unit.
    public boolean isOutOfBound(int x, int y) {return (x < 0 || x > this.width) && (y < 0 || y > this.height);}

    // Private methods of the unit.
    private void initialise(int perspective){
        /**
         * @param perspective; an integer value which indicates the perspective the user has upon the board, in other words
         *                     it indicates whether the user is playing using the white pieces or the black ones.
         *
         * This here method initialises the chessboard object in accordance with the specified perspective.
         *
         * @author Andrei-Paul Ionescu.
         */

        // Initialise a variable which indicates the current colour for the pieces.
        boolean colour;

        // Initialise the variable based on the current perspective, keeping in mind that if the perspective is one
        // than the topmost player will play with the = piece set and if otherwise than the top player will play with
        // the - piece set.
        colour = perspective == 1;

        // Initialise a list containing the order in which the non-pawn row must be initialised.
        for(int i = 0 ; i < 2 ; ++i){
            for(int j = 0 ; j < CLASSIC_CHESS_NUMBER_OF_COLUMNS ; ++j){

                if(i == 0)
                    this.initialiseRowContainingDifferentPieces(i, j, colour);
                else
                    this.chessboard[i][j] = new OccupiedCell(colour, new Pawn(colour));
            }
        }

        // Initialise the part of the board that upon the creation of a new game instance are deprived of a specific piece.
        for (int i = 2 ; i < CLASSIC_CHESS_NUMBER_OF_ROWS - 2 ; ++i){
            for(int j = 0 ; j < CLASSIC_CHESS_NUMBER_OF_COLUMNS ; ++j)
                this.chessboard[i][j] = new EmptyCell();
        }

        // Initialise the southernmost part of the board which contains a row of pawns followed by a row of
        // the different pieces poised in accordance to the standard layout of the chess game.
        for(int i = CLASSIC_CHESS_NUMBER_OF_ROWS - 2 ; i < CLASSIC_CHESS_NUMBER_OF_ROWS ; ++i){
            for(int j = 0 ; j < CLASSIC_CHESS_NUMBER_OF_COLUMNS ; ++j){

                if(i == CLASSIC_CHESS_NUMBER_OF_ROWS - 2)
                    this.chessboard[i][j] = new OccupiedCell(colour, new Pawn(!colour));

                else
                    this.initialiseRowContainingDifferentPieces(i, j, !colour);
            }
        }

    }

    private void initialiseRowContainingDifferentPieces(int x, int y, boolean colour){
        /**
         * @param x; an integer value indicating the row.
         * @param y; an integer value indicating the column.
         *
         *  This here method uses modular arithmetic so as to properly initialise the rows that contain not just pawns.
         *
         * @author Andrei-Paul Ionescu.
         */

        switch (y % 8) {

            case 0, 7 -> {
                this.chessboard[x][y] = new OccupiedCell(colour, new Rook(colour));
            }

            case 1, 5 -> {
                this.chessboard[x][y] = new OccupiedCell(colour, new Bishop(colour));
            }

            case 2, 6 -> {
                this.chessboard[x][y] = new OccupiedCell(colour, new Knight(colour));
            }

            case 3 -> {
                this.chessboard[x][y] = new OccupiedCell(colour, new King(colour));
            }

            case 4 -> {
                this.chessboard[x][y] = new OccupiedCell(colour, new Queen(colour));
            }

            default -> {

                System.exit(1); // An error has occurred so kill the program.
            }
        }

    }

    private void addMouseListeners(){
        /**
         * @param none; this here method takes no formal arguments upon invocation.
         *
         * This here method assigns to each of the Cell object, of which the chessboard element is constituted, a custom
         * mouse listener, which is a nested class within this compilation unit, whose role is to intercept events related
         * to user interactivity with the board and to respond in accordance with the events so as to create a dynamic
         * and responsive environment.
         *
         * @author Andrei-Paul Ionescu.
         */

        for(int i = 0 ; i < this.height ; ++i){
            for(int j = 0 ; j < this.width ; ++j){

                chessboard[i][j].addMouseListener(new CellMouseListener(chessboard[i][j], i, j));
            }
        }
    }

    // Nested classes within this compilation unit.
    static class CellMouseListener implements MouseListener{

        // Attributes/fields of the class.
        private final Cell cell; // The cell object which this listener is linked with.
        private final int x; // The abscess coordinate of the cell.
        private final int y; // The ordinate coordinate of the cell.

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

            cell.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        @Override
        public void mouseExited(MouseEvent e) {

            cell.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }

}
