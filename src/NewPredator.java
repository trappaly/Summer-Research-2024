
/*
 * Stores the predators as the agents that will capture the prey
 @author Jio Hong and Alyssa Trapp
 */

public class NewPredator {

    // +--------+------------------------------------------------------
    // | Fields |
    // +--------+
    static final char PREDATOR = 'X';

    /*
     * Stores the current predators
     */
    static int[][] predators = {
            { 0, 0 }, // North-West corner
            { 0, NewGrid.GRID_SIZE - 1 }, // North-East corner
            { NewGrid.GRID_SIZE - 1, 0 }, // South-West corner
            { NewGrid.GRID_SIZE - 1, NewGrid.GRID_SIZE - 1 } // South-East corner
    };

    /*
     * Stores the original predators
     */

    static final int[][] ORIGINAL_PREDATORS = {
            { 0, 0 }, // North-West corner
            { 0, NewGrid.GRID_SIZE - 1 }, // North-East corner
            { NewGrid.GRID_SIZE - 1, 0 }, // South-West corner
            { NewGrid.GRID_SIZE - 1, NewGrid.GRID_SIZE - 1 } // South-East corner
    };

    // +--------+------------------------------------------------------
    // | Methods |
    // +--------+

    /*
     * Stores predator locations and places predators
     */
    static void placePredators() {
        for (int[] predator : predators) {
            NewGrid.grid[predator[0]][predator[1]] = PREDATOR;
        } // for
    } // placePredators()

    static void clearPredators() {
        for (int[] predator : predators) {
            NewGrid.grid[predator[0]][predator[1]] = NewGrid.EMPTY;
        } // for
    } // clearPredators

    /*
     * Reset predators
     */
    static void resetPredators() {
        for (int i = 0; i < predators.length; i++) {
            predators[i][0] = ORIGINAL_PREDATORS[i][0];
            predators[i][1] = ORIGINAL_PREDATORS[i][1];
        } // for
        placePredators();
    } // resetPredators()

    static void movePredator(int index) {
        // old location of the predators
        int oldX = predators[index][0];
        int oldY = predators[index][1];
        // new location of predators after they move
        int newX = oldX;
        int newY = oldY;

        // North-West predator priortizes the X-axis (right direction) over the Y-axis
        // (down direction)
        if (index == 0) {
            if ((oldX < NewPrey.preyX) && (NewGrid.isEmpty(oldX + 1, oldY))) {
                newX = oldX + 1;
            } // if
            else if ((oldX > NewPrey.preyX) && (NewGrid.isEmpty(oldX - 1, oldY))) {
                newX = oldX - 1;
            } // else if
            else if ((oldY < NewPrey.preyY) && (NewGrid.isEmpty(oldX, oldY + 1))) {
                newY = oldY + 1;
            } // else if
            else if ((oldY > NewPrey.preyY) && (NewGrid.isEmpty(oldX, oldY - 1))) {
                newY = oldY - 1;
            } // else if 
        } // if

        // North-East predator priortizes the Y-axis (down direction) over the X-axis
        // (left direction)
        if (index == 1) {
            if ((oldY < NewPrey.preyY) && (NewGrid.isEmpty(oldX, oldY + 1))) {
                newY = oldY + 1;
            } // if
            else if ((oldY > NewPrey.preyY) && (NewGrid.isEmpty(oldX, oldY - 1))) {
                newY = oldY - 1;
            } // else if
            else if ((oldX > NewPrey.preyX) && NewGrid.isEmpty(oldX - 1, oldY)) {
                newX = oldX - 1;
            } // else if
            else if ((oldX < NewPrey.preyX) && (NewGrid.isEmpty(oldX + 1, oldY))) {
                newX = oldX + 1;
            } // else if
        } // else if

        // South-West predator prioritizes the Y-axis (up direction) over the X-axis
        // (right direction)
        else if (index == 2) {
            if ((oldY > NewPrey.preyY) && (NewGrid.isEmpty(oldX, oldY - 1))) {
                newY = oldY - 1;
            } // if
            else if ((oldY < NewPrey.preyY) && (NewGrid.isEmpty(oldX, oldY + 1))) {
                newY = oldY + 1;
            } // else if
            else if (((oldX < NewPrey.preyX)) && (NewGrid.isEmpty(oldX + 1, oldY))) {
                newX = oldX + 1;
            } // else if
            else if ((oldX > NewPrey.preyX) && NewGrid.isEmpty(oldX - 1, oldY)) {
                newX = oldX - 1;
            } // else if
        } // else if

        // South-East predator prioritizes the X-axis (left direction) over the Y-axis
        // (up direction)
        else if (index == 3) {
            if ((oldX > NewPrey.preyX) && (NewGrid.isEmpty(oldX - 1, oldY))) {
                newX = oldX - 1;
            } // if
            else if ((oldX < NewPrey.preyX) && (NewGrid.isEmpty(oldX + 1, oldY))) {
                newX = oldX + 1;
            } else if ((oldY > NewPrey.preyY) && (NewGrid.isEmpty(oldX, oldY - 1))) {
                newY = oldY - 1;
            } // else if
            else if ((oldY < NewPrey.preyY) && (NewGrid.isEmpty(oldX, oldY + 1))) {
                newY = oldY + 1;
            } // else
        } // else if

        // Ensure the new position is within the grid bounds and not occupied by another
        // predator
        if (newX >= 0 && newX < NewGrid.GRID_SIZE && newY >= 0 && newY < NewGrid.GRID_SIZE
                && NewGrid.grid[newX][newY] == NewGrid.EMPTY) {
            NewGrid.grid[oldX][oldY] = NewGrid.EMPTY;
            predators[index][0] = newX;
            predators[index][1] = newY;
            NewGrid.grid[newX][newY] = PREDATOR;
        } // if
    } // movePredator (int)
} // class NewPredator
