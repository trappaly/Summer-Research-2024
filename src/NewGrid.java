
/*
 * Stores the grid as the agents' environment
 @author Jio Hong and Alyssa Trapp
 */

public class NewGrid {

    // +--------+------------------------------------------------------
    // | Fields |
    // +--------+
    static final int GRID_SIZE = 10;
    static final char EMPTY = '.';
    static char[][] grid = new char[GRID_SIZE][GRID_SIZE];

    // +--------+------------------------------------------------------
    // | Methods |
    // +--------+

    /*
     * Creates the starting grid
     */
    static void initializeGrid() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = EMPTY;
            } // for
        } // for
    } // intializeGrid()

    /*
     * Checks to see if a space is out of bounds
     */
    static boolean outofBounds(int X_AXIS, int Y_AXIS) {
        return (X_AXIS < 0) || (X_AXIS >= GRID_SIZE) || (Y_AXIS < 0) || (Y_AXIS >= GRID_SIZE);
    } // outofBounds (int, int)

    /*
     * Checks to see if a space is at the edge
     */
    static boolean isEdge(int X_AXIS, int Y_AXIS) {
        return (X_AXIS == 0) || (X_AXIS == NewGrid.GRID_SIZE - 1) || (Y_AXIS == 0) || (Y_AXIS == NewGrid.GRID_SIZE - 1);
    } // isEdge (int, int)

    /*
     * Checks to see if a space is emtpy
     */

    static boolean isEmpty(int locX, int locY) {
        if (outofBounds(locX, locY)) {
            return false;
        } // if
        return grid[locX][locY] == EMPTY;
    } // isEmpty (int, int)

    /*
     * Prints the grid
     */
    static void printGrid() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                System.out.print(grid[i][j] + " ");
            } // for
            System.out.println();
        } // for
        System.out.println();
    } // printGrid()

    /*
     * Clears the grid
     */
    static void clearGrid() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = EMPTY;
            } // for
        } // for
    } // clear ()
} // class NewGrid
