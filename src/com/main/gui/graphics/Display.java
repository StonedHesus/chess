// The package in which the current Java compilation unit is to be found.

package com.main.gui.graphics;

// Imports from existing Java libraries, classes and interfaces.
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.temporal.ChronoUnit;
import java.util.EventListener;

// Import from custom libraries, classes and interfaces.
import com.main.board.Cell;
import com.main.board.Chessboard;
import com.main.board.EmptyCell;
import com.main.board.OccupiedCell;
import com.main.settings.Settings;

public class Display extends JPanel implements Settings{
    /**
     */
    // Static values/constants of the class.
    public final static int WHITE_PERSPECTIVE = 1;
    public final static int BLACK_PERSPECTIVE = 0;
    private static Dimension toBeBordered = null;

    // Fields/attributes of the class.
    private int width; // The width of the current JPanel.
    private int height; // The height of the current JPanel.
    private int perspective; // This value indicates with which piece set the user is going to play.
    private final int blockLength = CELL_SIZE; // The length of a block, a square block which will be drawn on the current JPanel.
    private double growthFactorX = 1.0; // The growth factor determines by how much we ought to increase the graphics in accordance to the screen size on the x-axis.
    private double growthFactorY = 1.0; //The growth factor determines by how much we ought to increase the graphics in accordance to the screen size on the y-axis.
    private Chessboard chessboard;

    // Constructor(s) of the class.
    public Display(){
        /*
         * @param none; this method takes no formal arguments upon invocation.
         *
         * This here method is the constructor which will be used by the user, for it deals with selecting the desired size of the
         * current display automatically, this being achieved by selecting the values from within the Settings interface.
         * This constructor uses the previously declared one, a feat which keeps the code clean and readable.
         *
         * If no perspective is specified then the player will automatically play with the white pieces.
         *
         * @author Andrei-Paul Ionescu
         */

        new Display(INITIAL_SCREEN_WIDTH, INITIAL_SCREEN_HEIGHT, Display.WHITE_PERSPECTIVE);
    }

    public Display(int width, int height, int perspective){
        /*
         * @param width; an integer value which represents the desired width of the current display as specified by the caller.
         * @param height; an integer value which represents the desired height of the current display as specified by the caller.
         * @param perspective; a parameter indicating which piece set the current player will utilise.
         *
         * This is the main constructor of the Display class, whose role is to initialise the width and height fields and to
         * set the preferred size of the current JPanel in accordance to these values and the constant value blockLength.
         *
         * @author Andrei-Paul Ionescu.
         */

        this.width = width;
        this.height = height;
        this.perspective = perspective;

        // Initialise the chessboard object.
        this.chessboard = new Chessboard(perspective);

        // Set the preferred size of the JPanel component.
        this.setPreferredSize(new Dimension(this.blockLength * this.width, this.blockLength * this.height));

    }

    // Getters of the class.

    // Setters of the class.

    // Public non-static methods of the unit.
    @Override
    public void paintComponent(Graphics graphics){
        /*
         * @param graphics; a Graphics object which contains the current frame's graphics.
         *
         * This method is inherited from the JPanel class and is subsequently invoked every frame by the Controller class;
         * its role is to keep the current JPanel updated, thus for each particular frame the method redraws the background
         * and all the components which might have changed since the previous frame thus ensuring that the game's front-end
         * are responsive to both internal events and external ones such as player command.
         *
         * @author Andrei-Paul Ionescu.
         */



        super.paintComponent(graphics); // Call the JPanel's paintComponent method and pass to it the current frame's graphics.

        this.drawBackground(graphics); // Call the drawBackground method and pass the current frame's graphics.

        this.drawChessboard(graphics);

        this.updateGrowthFactor(); // Update the growth factor after each Frame so as to ensure that the graphics are properly scaled.

        addBorder(0, 0, graphics);

        Toolkit.getDefaultToolkit().sync(); // Call the sync method whose role is to ensure a smooth transition from frame to frame.
    }

    // Public static methods of the unit.
    public static void addBorder(int x, int y){
        /**
         * @param x; an integer corresponding to the position on the abscissa axis for the cell which will currently be bordered.
         * @param y; an integer corresponding to the position on the abscissa axis for the cell which will currently be bordered.
         *
         * This here method adds a border to the cell which was currently clicked by the user, whilst keeping track that
         * no more than two cells at one time can have this property.
         *
         * @author Andrei-Paul Ionescu.
         */

       toBeBordered = new Dimension(x, y);
    }

    // Private methods of the unit.
    private void drawChessboard(Graphics graphics){
        /**
         * @graphics; A Graphics graphical object.
         *
         * This here method draws to the screen the current configuration of the chessboard object.
         *
         * @author Andrei-Paul Ionescu.
         */

        // Iterate through the chessboard object and display each piece's BufferedImage field.
        for(int i = 0 ; i < CLASSIC_CHESS_NUMBER_OF_ROWS ; ++i){
            for(int j = 0 ; j < CLASSIC_CHESS_NUMBER_OF_COLUMNS ; ++j){

                Cell current = this.chessboard.getCell(i, j);

                if(current instanceof OccupiedCell)
                    graphics.drawImage(((OccupiedCell) current).getPiece().getSprite(), j * CELL_SIZE, i * CELL_SIZE,null, this);

            }
        }

    }

    private void addBorder(int x, int y, Graphics graphics){

        // Retrieve the current colour.
        Color temporary = graphics.getColor();

        // Set the colour to the desired one and update the border.
        graphics.setColor(BORDER_COLOR);
        graphics.drawRect(x * this.blockLength, y*this.blockLength,
                (int) (this.blockLength * this.growthFactorX), (int)(this.blockLength * this.growthFactorY)); // Draw the margins of the block which we want to draw.

        // Reset the colour to the original one.
        graphics.setColor(temporary);

        toBeBordered = null;
    }

    private void updateGrowthFactor(){
        /*
         * @param none; this method takes no formal arguments upon invocation.
         *
         * Compute the amount we ought to increase the growth factor by based on the current size of the screen when
         * compared with the initial/default one.
         *
         * @author Andrei-Paul Ionescu.
         */

        this.growthFactorX += (double) (Toolkit.getDefaultToolkit().getScreenSize().width - this.width) / this.blockLength;
        this.growthFactorY += (double) (Toolkit.getDefaultToolkit().getScreenSize().height - this.height) / this.blockLength;
    }

    private void drawBackground(Graphics graphics){
        /*
         * @param graphics; a Graphics object which contains the current frame's graphics.
         *
         * This here method draws the background to the current JPanel's graphics, thus initialising the board. In the case of this
         * here game, the background will remain constant and all the other game components such as the snake or the bonuses will be
         * juxtaposed atop of this background.
         *
         * @author Andrei-Paul Ionescu.
         */

        // Iterated thru the matrix whose size is the couple (this.width, this.height) and instantiate the blocks within the
        // current graphics.
        for(int i = 0 ; i < CLASSIC_CHESS_NUMBER_OF_ROWS; ++i){

            if(i == 0){

                if(this.perspective == Display.BLACK_PERSPECTIVE)
                    graphics.setColor(BLACK_CELL);
                else if(this.perspective == Display.WHITE_PERSPECTIVE)
                    graphics.setColor(WHITE_CELL);
            } else{

                if(graphics.getColor() == BLACK_CELL) graphics.setColor(WHITE_CELL);
                else if(graphics.getColor() == WHITE_CELL) graphics.setColor(BLACK_CELL);
            }

            for(int j = 0 ; j < CLASSIC_CHESS_NUMBER_OF_COLUMNS; ++j){

                graphics.drawRect(i * this.blockLength, j*this.blockLength,
                        (int) (this.blockLength * this.growthFactorX), (int)(this.blockLength * this.growthFactorY)); // Draw the margins of the block which we want to draw.
                graphics.fillRect(i * this.blockLength,  j*this.blockLength,
                        (int) (this.blockLength * this.growthFactorX), (int) (this.blockLength * this.growthFactorY)); // Fill the rect so as to achieve a solid black background.

                if(graphics.getColor() == BLACK_CELL) graphics.setColor(WHITE_CELL);
                else if(graphics.getColor() == WHITE_CELL) graphics.setColor(BLACK_CELL);
            }
        }
    }
}
